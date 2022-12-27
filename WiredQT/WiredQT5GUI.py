
from PyQt5 import QtCore, QtWidgets
from PyQt5.QtGui import * 
from wired_module import *    
import Scintilla
from PyQt5.Qsci import QsciScintilla, QsciLexerPython
from copy import deepcopy
from shutil import copyfile
import os
import platform
import sys
from subprocess import PIPE, Popen, STDOUT
from threading  import Thread
import shutil
from _thread import *
try:
	from queue import Queue, Empty
except ImportError:
	from Queue import Queue, Empty  # python 2.x
	
class plugin:
	def __init__(self,path):
		self.filename=[]
		self.path=[]
		index=0
		for dirname, dirnames, filenames in os.walk(path):
			if index==0:
				for filename in filenames:
					if filename.find('.py')!=-1:
						self.filename.append( filename)
						self.path.append('plugin')			
			for subdirname in dirnames:
				subject_path = os.path.join(dirname, subdirname)
				for filename in os.listdir(subject_path):
					if filename.find('.py')!=-1 and filename.find('.pyc')==-1:
						files = os.path.join(subject_path, filename)
						self.filename.append(filename)
						self.path.append(subject_path.replace('\\','/'))
			index+=1			
	def Exist(self,types):
		if types in self.filename:
			return True
		return False
	def Path(self,types):
		for i,a in enumerate(self.filename):
			if types==a:
				return self.path[i]
		return ''
class ActiveX:
	def __init__(self,obj):
		self.obj=obj
		pass
	def IsActiveX(self):
		if str(type(self.obj)).find("Handler")!=-1:
			return True
		else:
			return False

class clsIntellisense:
	def __init__(self,selfhandler):
		self.selfhandler=selfhandler
		CTRL=255
		ALT=254
		TAB=253
		SHIFT=252       
		SPACE=32
		F=70
		self.parsekey=Poll(chr(37)+chr(65))
		self.parsekeyWin=Poll(chr(CTRL)+chr(SPACE))
		self.parsefind=Poll(chr(37)+chr(41))
		self.parsefindWin=Poll(chr(CTRL)+chr(F))
		self.findagainRasp=[114,65472]
		self.findagainWin=[69,65472]
		self._findagain=[self.findagainRasp,self.findagainWin]
		self._parsekey=[self.parsekey,self.parsekeyWin]
		self._parsefind=[self.parsefind,self.parsefindWin]  
		self.lstpreloaded=[]
		self.jedimodule={}     
		self.posX=-1
		self.posY=-1
	def helpintellisense(self,code):
		if self.selfhandler.IsQTForms()==False:
			return code
		c=self.selfhandler.objectMove.lst
		content=""
		for a in c:
			_type=str(type(c[a].name)).split(".")[-1].split("'")[0]

			prop=eval(c[a].prop)
			if prop["Tag"]=="Activex":
				content+="\t\timport "+str(c[a].name).split(" ")[0][1:].split(".")[0]+"\n"
				content+="\t\tself." + c[a].name.objectName +"="+ str(c[a].name).split(" ")[0][1:] +"()\n"
			else:
				content+="\t\tself." + c[a].name.objectName + "=forms(" + _type + ")\n"
		routine="\tdef helpintellisense(self):\n" + content + "\t\tpass\n"

		x=pythonCode("",code)
		handler,_=x.getRoutinCode("class Handler") 
		y,_=x.getRoutinCode(routine)
		if y=="":#add helpintellisense code to Handler
			code=code.replace(handler,handler+routine)             
		return code	


	def ShowTypedWord(self,code,offset,allchar=False):
		def GetWord(offset,stopAt,forward=False):

			if forward==False:
				while(offset!=-1):
					if code[offset] in stopAt:
						break
					offset-=1
				return offset+1
			else:
				ends=len(code)
				while(offset!=ends):
					if code[offset] in stopAt:
						break
					offset+=1
				return offset    

		ST=' \t\r\n`~!@#$%^&*()-=+[]{}|\'\";:/.,?><'
		if allchar:
			ST=ST.replace('.','')
		startAt=GetWord(offset, stopAt=ST,forward=False)
		endAt=GetWord(offset, stopAt=ST,forward=True)
		strs=code[startAt:endAt+1]
		return strs,startAt,endAt   		
	def words(self):
		def getavailableWord(src,target):
			x=target[-1::-1].find(".")
			if x!=-1:
				target=target[len(target)-x:]
				if target=='':return src
			ret=[]
			for a in src:
				try:
					if a[0:len(target):].lower()==target.lower():
						ret.append(a)
				except:
					a=a
			return ret		
		linestr=self.selfhandler.QSCI.Text.split('\n')[self.selfhandler.yIntel]
		num=0
		for i,a in enumerate(linestr):
			if a=='\t':
				num+=8
			else:
				num+=1    
			if num==self.selfhandler.xIntel:
				break
		#print(i)   
		wordline=linestr[:i+2].strip()
		nword,_,_=self.ShowTypedWord(linestr,i)
		nword=nword.strip()
		x=i+1
		word=nword
		xword=""
		ret=[]
		code=self.selfhandler.QSCI.Text
		code=self.helpintellisense(code)#alter code add LocalWidget for jedi
		y=self.selfhandler.yIntel+1
		QApplication.setOverrideCursor(Qt.WaitCursor)
		
		path=GetPath(self.selfhandler.filename)[:-1]
		if self.selfhandler.caller.jedi.__version__!="0.18.0":
			path=path
		else:
			path+="/duno.py"#duno.py is required if jedi is >="0.18.0"
		if wordline==nword:
			if "global" in self.selfhandler.helplst:
				ret=getavailableWord(self.selfhandler.helplst["global"],nword)
		else:
			if wordline in self.selfhandler.helplst:
				ret=getavailableWord(self.selfhandler.helplst[wordline],nword)
		if ret==[]:
			if wordline==nword:
				ret,xword=self.selfhandler.caller.showhelp(code,"", x-len(wordline),y,"",path)
			else:
				ret,xword=self.selfhandler.caller.showhelp(code,word, x,y,wordline,path)
			if wordline==nword:
				self.selfhandler.helplst.update({"global":ret})
			else:
				self.selfhandler.helplst.update({wordline:ret})
			ret=getavailableWord(ret,nword)	
			
		self.posX=x
		self.posY=y-1
		self.selfhandler.intellisense.obj.setParent(None)
		self.selfhandler.intellisense.obj.setParent(self.selfhandler.QSCI.obj)
		
		
		
		
		ret=filter(lambda ret:ret!='', ret)#filter empty string in array
		ret=list(ret)		
		if ret==None:ret=[]
		if len(xword):
			_len=len(xword)
		else:
			_len=-1
		self.selfhandler.startPasteIntellisense=len(nword)-_len-1
		QApplication.restoreOverrideCursor()
		if len(ret):
			self.selfhandler.intellisense.List=ret	
			self.selfhandler.intellisense.Left=50
			self.selfhandler.intellisense.Top=100
			self.selfhandler.intellisense.Visible=True
			print("hoolaqwerty")
			self.selfhandler.fromcodeIntel=True
	def check(self,key):
		CTRL=16777249
		ALT=16777251
		TAB=16777217
		SHIFT=16777248
		keys={CTRL:255,ALT:254,TAB:253,SHIFT:252}
		
		if key in keys:
			key=keys[key]
		if key>255:
			return
		for a in self._parsekey:
			if a.Poll(chr(key)):
				try:
					if self.selfhandler.caller.finishjedi:
						self.words()
					else:
						print("Jedi is still loaading")
					self.helptriggered=True   
					self.lstprev=[] 
				except:
					pass
				return True
		
				#break
		return False		

class PropertyEditor:
	def __init__(self,_self,default):
		self.scrollWidget = QWidget()
		self.parent=_self
		forms(self.scrollWidget).Width=_self.thisleft*2
		forms(self.scrollWidget).Height=DeskTopSize()[1]*2

		scrollArea = QScrollArea()
		forms(scrollArea).Width=_self.thisleft
		forms(scrollArea).Height=DeskTopSize()[1]-68-_self.thistop
		scrollArea.setWidgetResizable(True)
		scrollArea.setWidget(self.scrollWidget)   
		scrollArea.setParent(_self)
		forms(scrollArea).Left=0
		forms(scrollArea).Top=_self.thistop
		self.scrollArea=scrollArea
		self.controls=[]
		self.default=default

		pass
	def setparent(self,obj,nameparent=""):
		if obj.prop=="":#newly added widget
			return
		prop=eval(obj.prop)
		prop["ParentsType"]=nameparent
		obj.prop=str(prop)
	def setwidgetproperties(self,wid,dragChange=False):
		_wid=wid
		self.widget=wid


		wid=forms(wid.name)
		if str(type(wid.obj)).find("Handler")!=-1:
			name=str(type(wid.obj)).split("'")[1].split(".")[0]
			fileInProject=GetPath(self.parent.filename)+name+".py"
			if FileExist(fileInProject):
				name=GetPath(self.parent.filename)+name+".py"
			ret=extractModuleProperties(name)
			#print('rrr',ret)
			self.addproperty(ret)		
		if _wid.prop!="":	
			prop=eval(_wid.prop)	
		for a in self.dictwidget:
			if _wid.prop!="" and (a in prop) == True:	#2022 added and (a in prop) == True, tabfrm doesnt include properties
				value=str(prop[a])
			else:
				value=str(forms(self.dictwidget[a][0]).Text)
			if dragChange:
				if a in ['Top','Left','Width','Height']:
					value=str(eval('forms(_wid.name).'+a ))
			try:
				c=eval('wid.'+a)
				if callable(c)==False  or hasattr(wid.obj,a) or a in ["ParentsType","Picture"]:
					if type(self.dictwidget[a][0])==QComboBox:
						index=forms(self.dictwidget[a][0]).List.index(value)
						forms(self.dictwidget[a][0]).ListIndex=index						
					else:	
						forms(self.dictwidget[a][0]).Text=value


			except:
				a=a
		forms(self.dictwidget['Name'][0]).Text=wid.obj.objectName        
		_type=wid.obj.parent().objectName
		if type(_type)==str:
			forms(self.dictwidget['ParentsType'][0]).Text=_type#has parent
		else:
			self.setparent(_wid)
			forms(self.dictwidget['ParentsType'][0]).Text=''#no parent

		pass
	def resetdefaultproperty(self):
		willrem=[]
		for a in self.dictwidget:
			if (self.dictwidget[a][0].objectName in self.default)==False:
				willrem.append(a)
		for a in willrem:

			c=self.dictwidget.pop(a)
			lineedit,but=c
			lineedit.setParent(None)
			lineedit.deleteLater() 
			but.setParent(None)
			but.deleteLater() 				


	def addproperty(self,ret):

		for a in ret:
			try:
				comment=a.find('#')
				if (comment!=-1):
					a=a[:comment]
					a=a.replace('\t','')
				_dict=eval("{"+a+"}")				
				for b in _dict:
					if b!="list":
						label=[b]
					if "list" in _dict:	
						values=[_dict['list']]
					else:
						values=[""]
				self.property(label, values,addonly=True)
			except:
				QMessageBox.about(self.parent,"User Control error!!!","Invalid param "+ a)

	def property(self,label,values,addonly=False):
		if addonly==False:
			self.dictwidget={}
		
		#for a in label:
		#	self.dictwidget.update({a:""})
		print('yyy',label,values)
		for a in zip(label,values):
			
			if a[0] in self.dictwidget:
				continue
			
			i=len(self.dictwidget)
			label=QPushButton()
			label.clicked.connect(self.clicked)
			label.setParent(self.scrollWidget)
			forms(label).Left=0
			forms(label).Top=30*i                
			forms(label).Width=100
			forms(label).Height=30
			forms(label).Text=a[0]        
			forms(label).Visible=True
			forms(label).BackColor=[1,1,1,0.5]
			forms(label).ForeColor=[0,0,1,1]
			label.objectName=a[0]
			but=label


			if type(a[1])==list or a[0]=="Enable" or a[0]=="Visible":
				label=QComboBox()
				label.objectName=a[0]
				if a[0]=="Enable" or a[0]=="Visible":
					forms(label).List=["True","False"]
				else:    
					forms(label).List=a[1]
				label.activated.connect(self.activatecombo)    


			else:

				label=QLineEdit()
				label.objectName=a[0]
				if a[0]=="ParentsType":
					forms(label).Enable=False
				label.returnPressed.connect(self.updatevalue)
			label.setParent(self.scrollWidget)  	
			forms(label).Left=100
			forms(label).Top=30*i                      
			forms(label).Width=200
			forms(label).Height=30

			forms(label).Visible=True

			self.dictwidget.update({a[0]:[label,but]})
			self.label=label

	def clicked(self,a):


		self.lastselected=self.scrollWidget.sender().objectName
		if self.lastselected=="BackColor" or self.lastselected=="ForeColor":
			self.parent.QColorDialog.Visible=True
		if self.lastselected=="Font":
			self.parent.QFontDialog.Visible=True	
		if self.lastselected=="Picture":
			self.parent.QFileDialog.obj.setDirectory(os.path.expanduser(GetPath(self.parent.filename)))

			name = self.parent.QFileDialog.getOpenFileName(self.parent, 'Open File')
			if len(GetPath(name[0]))>=len(GetPath(self.parent.filename)):
				if GetPath(name[0])[0:len(GetPath(self.parent.filename))]==GetPath(self.parent.filename):
					self.updatevaluewidget(name[0][len(GetPath(self.parent.filename)):])	
					return
			self.updatevaluewidget(name[0])				
		
	def updatevaluewidget(self,val):
		forms(self.dictwidget[self.lastselected][0]).Text=str(val)
		self.updatevalue(fromlabel=True)
	def activatecombo(self,index):
		if hasattr(self,'widget')==False:return
		self.lastselected=self.scrollWidget.sender().objectName
		val=forms(self.scrollWidget.sender()).List[index]
		#if val in ['True','False']:
			#val=TrueFalse(val)
		x=ActiveX(self.widget.name).IsActiveX()
		if x==False:
			strs1='forms(self.widget.name).'+self.lastselected+ '="'+ val+'"'
		else:
			strs1='self.widget.name.'+self.lastselected+ '="'+ val+'"'
		#strs2='forms(self.widget.sa).'+self.lastselected+ '="'+ val+'"'
		try:
			exec(strs1)

			prop=eval(self.widget.prop)
			prop[self.lastselected]=forms(self.scrollWidget.sender()).Text
			self.widget.prop=str(prop)#update self.widget.prop			
		#    exec(strs2)
		except:
			a=0        
	def updatevalue(self,fromlabel=None):
		if hasattr(self,'widget')==False:return
		if fromlabel==None:
			self.lastselected=self.scrollWidget.sender().objectName
		if self.lastselected=="Name":
			val=forms(self.scrollWidget.sender()).Text
			oldname=self.widget.name.objectName

			self.widget.name.objectName= val
			self.widget.sa.objectName= val
			exec('self.parent.'+val+'=' + 'self.parent.' + oldname)
			return


		if fromlabel==None:
			value=forms(self.scrollWidget.sender()).Text
			if hasattr(forms(self.widget.sa),self.lastselected):
				strs1='forms(self.widget.name).'+self.lastselected+ '="'+ value +'"'
				strs2='forms(self.widget.sa).'+self.lastselected+ '="'+ value+'"'
			else:
				strs1='self.widget.name.'+self.lastselected+ '="'+ value+'"'
				strs2='self.widget.sa.'+self.lastselected+ '="'+ value+'"'				
		else:
			value=forms(self.dictwidget[self.lastselected][0]).Text
			if hasattr(forms(self.widget.sa),self.lastselected):
				strs1='forms(self.widget.name).'+self.lastselected+ '="'+ value+'"'
				strs2='forms(self.widget.sa).'+self.lastselected+ '="'+ value+'"'
			else:
				strs1='forms(self.widget.name).'+self.lastselected+ '="'+ value+'"'
				strs2='forms(self.widget.sa).'+self.lastselected+ '="'+ value+'"'				
		try:
			exec(strs1)
			exec(strs2)
			if self.lastselected=="Picture":
				strs1='forms(self.widget.name).LoadPicture="'+ GetPath(self.parent.filename)+value + '"'
				strs2='forms(self.widget.sa).LoadPicture="'+ GetPath(self.parent.filename)+value + '"'
				exec(strs1)				
				exec(strs2)
			if self.widget.prop!="":
				prop=eval(self.widget.prop)
				prop=eval(self.widget.prop)
				prop[self.lastselected]=value
				self.widget.prop=str(prop)#update self.widget.prop
				forms(self.scrollWidget.sender()).ForeColor=[1,0,0,1]
				self.parent.repaint()
				delay(500)
				forms(self.scrollWidget.sender()).ForeColor=[0,0,0,1]
		except:
			a=0
		#x=self.sender()
		a=0



class pythonCode(object):
	def __init__(self,fname,code=None):
		if code==None:
			code=GetFileStr(fname)
		self.code=code;
		self.startSpaceOrTab=0;
		self.bodySpaceOrTab=0;
		self.endSpaceOrTab=self.startSpaceOrTab;        
	def getRoutinCode(self,routine,startafterThisString=None):

		startAt=0
		if startafterThisString!=None:
			startAt=self.code.find(startafterThisString)
		while 1:	
			parse=ParserLangguage(routine)
			t=parse.Parse(self.code[startAt:])
			ret=""
			if t!=None:
				if self.code[t[0]+len(routine)+startAt]!="(":
					startAt+=t[0]+1
				else:	
					ret=self.getSpaceOrTab(t[0],t[1],len(self.code[startAt:]),self.code[startAt:])                
					break
			else:
				break
		return ret,t  
	def getLineNumber(self,routine):
		code=self.code.split('\n')
		parse=ParserLangguage(routine)
		for i,a in enumerate(code):
			t=parse.Parse(a)
			if t!=None:
				if a.replace("\t","")[0:len(routine)]==routine:
					return i
		return -1
	def getSpaceOrTab(self,st1,end1,totalchar,code):
		st=st1-1
		end=end1+1
		def GotoEnterAtTheBack(st):
			num=0
			while(st!=-1):
				if code[st]=='\r' or code[st]=='\n':
					break
				else:
					num+=1
				st-=1      
			return num,st+1
		def GotoEnterAtTheEnd(st):
			num=0
			while(st!=-1):
				if code[st]=='\r' or code[st]=='\n':
					break
				else:
					num+=1
				st+=1      
			return num     
		def GotoFirstValidchar(st1):
			num=0
			st=st1
			while(st!=totalchar):
				if code[st]=='#':
					num2=GotoEnterAtTheEnd(st)
					st=num2+st
				if code[st]!=' ' and code[st]!='\t' and code[st]!='\n' and code[st]!='\r':
					break
				else:
					if code[st]=='\n' or code[st]=='\r':
						num=0
					else:        
						num+=1
				st+=1 
			end=st1+st-st1        
			return num,end
		def GotoFirstEndRoutine(st):
			num=0
			loopcnt=0
			while(1):
				n,e=GotoFirstValidchar(st)
				if n<=self.startSpaceOrTab and loopcnt!=0:
					break
				else:
					n=GotoEnterAtTheEnd(st) 
					st=st+n+1
				loopcnt+=1        
			return num,e                        

		self.startSpaceOrTab,stx=GotoEnterAtTheBack(st)
		num=GotoEnterAtTheEnd(end)
		end=end+num+1
		self.bodySpaceOrTab,st=GotoFirstValidchar(end)
		_,end=GotoFirstEndRoutine(stx)
		return code[stx:end]
def SquareWidget(parent,l,t,w,h,scroll=False,installEvent=False):
	scrollWidget = QWidget()
	if scroll:
		w,h=DeskTopSize()
		forms(scrollWidget).Width=w
		forms(scrollWidget).Height=h
	if installEvent:
		scrollWidget.setMouseTracking(True)
		scrollWidget.installEventFilter(parent)

	scrollArea = QScrollArea()
	#scrollArea.setWidgetResizable(True)
	scrollArea.setWidget(scrollWidget)  


	forms(scrollArea).Left=l#500        
	forms(scrollArea).Top=t#0
	forms(scrollArea).Width=w#100
	forms(scrollArea).Height=h#100
	scrollArea.setStyleSheet("background-color:rgba(0,0,0,0)"); 
	scrollArea.setParent(parent)
	return scrollWidget,scrollArea
class ScrollLayout:
	def addWidget(self,a,plugin=""):
		if a in self.userwidget:
			return
		p=QPushButton(a)
		p.setStyleSheet("border:none")	

		self.userwidget.update({a:p})
		im=GetPath(plugin)+ GetFilenameNoEXT(plugin)+".png"
		pluginFlag= FileExist(im)
		if FileExist("images/"+a+".png") or pluginFlag:
			if pluginFlag:
				pixmap=QPixmap(im)
			else:	
				pixmap=QPixmap("images/"+a+".png")
			ButtonIcon=QIcon(pixmap)
			p.setIcon(ButtonIcon)
			p.setIconSize(pixmap.rect().size())
		if a.find('user control')!=-1 or a.find('---------')!=-1:
			forms(p).BackColor=(0.5,0.5,1,1)
		else:
			if plugin!="":
				forms(p).BackColor=(0.8,0.8,1,1)
			else:	
				forms(p).BackColor=(0.8,1,0.8,1)
		p.clicked.connect(self.parent.butP)
		self.scrollLayout.addRow(p)
		#self.scrollArea.setParent(self.parent)   
		forms(p).Height=35
		forms(p).Visible=True
	def __init__(self,parent,l,t,w,h):
		self.userwidget={}
		self.parent=parent
		# scroll area
		scrollLayout = QFormLayout()

		# scroll area widget contents
		scrollWidget = QWidget()
		#scrollWidget.setMouseTracking(True)
		scrollWidget.setLayout(scrollLayout)
		#scrollWidget.installEventFilter(parent)
		# scroll area
		scrollArea = QScrollArea()
		scrollArea.setWidgetResizable(True)
		scrollArea.setWidget(scrollWidget)  


		forms(scrollArea).Left=l        
		forms(scrollArea).Top=t
		forms(scrollArea).Width=w
		forms(scrollArea).Height=h
		import PyQt5.QtWidgets  as b
		self.scrollArea=scrollArea
		self.scrollLayout=scrollLayout        
		self.addWidget('Load User Control')        
		self.addWidget('QsciScintilla')
		self.addWidget('QLabel')
		self.addWidget('QPushButton')
		self.addWidget('QLineEdit')
		self.addWidget('QTextEdit')
		self.addWidget('QTimeEdit')
		self.addWidget('QDateEdit')
		self.addWidget('QDateTimeEdit')
		self.addWidget('QCalendarWidget')
		self.addWidget('QComboBox')
		self.addWidget('QFileDialog')
		self.addWidget('QInputDialog')
		self.addWidget('QSlider')
		self.addWidget('QListWidget')
		self.addWidget('QCheckBox')
		self.addWidget('QRadioButton')
		self.addWidget('QFrame')
		self.addWidget('QGroupBox')
		self.addWidget('QWidget')
		self.addWidget('----user control----')
		plugindata=plugin(app_path()+'/plugin/')
		for a,p in zip(plugindata.filename,plugindata.path):
			parent.plugin.update({GetFilenameNoEXT(a):p+"/"+GetFilenameNoEXT(a)+".py"})
			self.addWidget(GetFilenameNoEXT(a),p+"/"+GetFilenameNoEXT(a)+".py")
			pass
		self.addWidget('--------------------')
		for a in dir(b):
			try:
				c=eval('b.'+a + '()')

				if 'setFixedSize'in dir(c):
					if hasattr(c,"widget"):
						pass
						#print("wid",a)
						'''wid QMdiSubWindow
						wid QScrollArea
						wid QSplitter
						wid QStackedWidget
						wid QTabWidget
						wid QToolBox						
						'''
					self.addWidget(a)

					#print(a)

			except:
				pass
		scrollArea.setParent(parent)



def extractModuleEvents(module):
	module=str(module)
	if module.find(".Handler")!=-1:
		module=module[module.find("'")+1:module.find(".")]
	if module.find('/')==-1:
		module+=".py" 
	lst=[]
	if FileExist(module):
		a=GetFileStr(module)
		b=a.split('\n')
		fnd="#WiredEvent def "
		for c in b:
			st=c.find(fnd)
			en=c.find(')')
			if st!=-1 and en!=-1:
				c=c[st+len(fnd):en+1]
				#print(c)    
				lst.append(c)
	return lst;  
def extractModuleProperties(module):
	module=str(module)
	if module.find(".Handler")!=-1:
		module=module[module.find("'")+1:module.find(".")]
	if module.find('/')==-1:
		module+=".py"                            
	lst=[]
	if FileExist(module):
		a=GetFileStr(module)
		b=a.split('\n')
		fnd="#WiredProperty "
		for c in b:
			st=c.find(fnd)
			if st!=-1:
				c=c[st+len(fnd):]
				print(c)    
				lst.append(c)
	return lst;  
class objectMove:
	class prop:
		def __init__(self,obj,sw,sa,prop=''):
			self.sw=sw
			self.sa=sa
			self.name=obj
			self.label=obj.objectName
			self.flag=False
			self.selected=False
			self.incwidth=0
			self.hasmoved=False  
			self.events=[]
			self.prop=prop
			pass
	def delete(self,obj):
		a,b,c=self.lst[obj].name,self.lst[obj].sw,self.lst[obj].sa
		self.lst.pop(obj)

		a.setParent(None)
		b.setParent(None)
		c.setParent(None)
		a.deleteLater() 
		b.deleteLater() 
		c.deleteLater() 



		a=0
	def __init__(self,parent,workarea):
		self.lst={}
		self.key=0
		self.mousedown=0     
		self.obj=None
		self.workarea=workarea
		self.lastselected=None
		for a in dir(parent):#place hidden squareobject in front of actual widget, this hidden squareobject(sw) actually receives mouse event
			try:
				obj=eval('parent.' + a)
				if type(obj)==forms and a!='intellisense':
					self.add(obj.obj)
			except:
				pass            
		pass 
	def widgetQScrollparent(self,curr):
		for a in self.lst:
			if type(self.lst[a].name)==QScrollArea:
				if self.lst[a].name.widget()==curr.parent() :          
					return self.lst[a].name
		return None     
	def ControlUnderMouse(self,x,y):
		obj=[]

		for a in self.lst:

			#print(self.lst[a].name.objectName)
			curr=self.lst[a].name
			ot=0
			ol=0
			if curr.parent()!=self.workarea:#inside qwidget or QScrollArea
				ret=self.widgetQScrollparent(curr)
				if ret==None:
					ot=forms(curr.parent()).Top#inside QWidget
					ol=forms(curr.parent()).Left
				else:
					ot=forms(ret).Top#inside QScrollArea
					ol=forms(ret).Left                    
			_ll =forms(curr).Left+ol
			_ul =forms(curr).Left+forms(curr).Width+ol
			_lt=forms(curr).Top+ot
			_ut=forms(curr).Top+forms(curr).Height+ot

			if _ll<x and _ul> x and _lt<y and  _ut>y:
				#self.lst[a].sw.setStyleSheet("background-color:rgba(0,0,255,50)");   
				obj.append(self.lst[a].sw)

			else:
				#self.lst[a].sw.setStyleSheet("background-color:rgba(0,0,0,0)");   
				pass
		areab=10e6
		index=0
		if len(obj)>1:
			#chooose smaller area
			for i,a in enumerate(obj):
				area=forms(self.lst[a].name).Width*forms(self.lst[a].name).Height
				if areab>area:
					areab=area
					index=i
			return obj[index]        
		else:    
			return None if len(obj) == 0 else obj[0] 
		return None
	def IsInsideControl(self,obj,x,y):
		if self.multipleselected()==False:
			self.lst[obj].selected=True#select obj if only one cotrol were selected
		for a in self.lst:

			for b in self.lst:
				if self.lst[b].selected:

					#print(self.lst[obj].name.objectName + " " + self.lst[a].name.objectName)
					targetdrop=forms(self.lst[a].name)
					_targetdrop=self.lst[a].name
					_targetdropSA=self.lst[a].sa
					sourcedrop=forms(self.lst[b].name)
					_sourcedrop=self.lst[b].name
					sourcedropSA=forms(self.lst[b].sa)
					_sourcedropSA=self.lst[b].sa
					_ll =targetdrop.Left
					_ul =targetdrop.Left+targetdrop.Width

					_lt=targetdrop.Top
					_ut=targetdrop.Top+targetdrop.Height     

					y=sourcedrop.Top
					x=sourcedrop.Left
					#print(_ll,_ul,_lt,_ut)
					#print(x,y)
					if _ll<x and _ul> x and _lt<y and  _ut>y:
						
						#print(_sourcedrop.objectName + " drop to "+ _targetdrop.objectName)
						_type=type(_targetdrop)
						if  _type in [QWidget,QFrame,QGroupBox]:#[QWidget,QScrollArea,QFrame,QGroupBox]:
							#print("okxxx"+_targetdrop.objectName )

							_targetdropSA.setStyleSheet("background-color:rgba(0,255,0,100)");

							if _type==QGroupBox or _type==QFrame :
								_type=QWidget

							if _type==QWidget or _type==QScrollArea:
								if _type==QScrollArea:
									sourcedrop.Top=0
									sourcedrop.Left=0
									sourcedropSA.Top=0
									sourcedropSA.Left=0
								else:	
									sourcedrop.Top-=targetdrop.Top
									sourcedrop.Left-=targetdrop.Left
									sourcedropSA.Top-=targetdrop.Top
									sourcedropSA.Left-=targetdrop.Left   

								w=sourcedrop.Width
								h=sourcedrop.Height                                
								sw=sourcedropSA.Width
								sh=sourcedropSA.Height
								if _type==QScrollArea:
									_targetdrop.setWidget(_sourcedrop)																
								else:	
									_sourcedrop.setParent(_targetdrop)
									print(_targetdrop,_sourcedropSA)
								_sourcedropSA.setParent(_targetdrop)
								sourcedrop.Width=w
								sourcedrop.Height=h    
								sourcedropSA.Width=sw
								sourcedropSA.Height=sh                                    
								
								sourcedrop.Visible=True
								sourcedropSA.Visible=True     


					else:
						self.lst[b].sa.setStyleSheet("background-color:rgba(0,0,0,0)");

					#reset parent
	def signals(self,obj):#get available signal of obj
		lst=[]
		c=self.lst[obj].name
		if 'setFixedSize'in dir(c):
			#print(c.objectName)
			for bb in dir(c):
				d=eval( "c." + bb)
				#print(d)
				if str(d).find('PYQT_SIGNAL')!=-1:
					signal=eval('self.lst[obj].name.'+bb+'.signal[1:]')
					#print("  " +  signal) 
					lst.append(signal)
		return lst 
	def methods(self,obj,_filter):#get available signal of obj
		lst=[]
		c=self.lst[obj].name
		if 'setFixedSize'in dir(c):
			#print(c.objectName)
			for bb in dir(c):
				d=eval( "c." + bb)
				#print(d,bb)
				if str(d).find('PYQT_SIGNAL')!=-1:
					signal=eval('self.lst[obj].name.'+bb+'.signal[1:]')
					#print("  " +  signal) 
					lst.append(signal)

		return lst     


	def exist(self,obj):# check if obj is in our list
		return obj in self.lst
	def add(self,obj,prop):
		sw,sa=SquareWidget(obj.parent(),forms(obj).Left,forms(obj).Top,forms(obj).Width,forms(obj).Height)
		properties=self.prop(obj,sw,sa,prop)
		self.lst.update({sw:properties})
		return sw
	def flag(self,obj):
		ret=self.lst[obj].flag
		return ret
	def resetselected(self):
		for a in self.lst:
			self.lst[a].selected=False
			self.lst[a].sa.setStyleSheet("background-color:rgba(0,0,0,0)");
	def showselected(self):
		for a in self.lst:
			if self.lst[a].selected:
				forms(self.lst[a].sa).BackColor=[0,0,1,0.5]#self.lst[a].sw.setStyleSheet("background-color:rgba(0,0,255,100)");        
			else:    
				forms(self.lst[a].sa).BackColor=[0,0,0,0]#self.lst[a].sw.setStyleSheet("background-color:rgba(0,0,0,0)");        
	def setselected(self,obj):
		self.lst[obj].selected=True 
		forms(self.lst[obj].sa).BackColor=[0,0,1,0.5]#.setStyleSheet("background-color:rgba(0,0,255,100)");
	def setflag(self,obj,x):
		self.lastselected=obj
		self.lst[obj].flag=x
		if x:
			forms(self.lst[obj].sa).BackColor=[0,0,1,0.5]#self.lst[obj].sw.setStyleSheet("background-color:rgba(0,0,255,100)");
		self.lst[obj].selected=x  
	def boundery(self,obj,x,y):#check if mousepress is within boundery  of incwidth and incheight then set it to 1
		#print(abs(forms(self.lst[obj].name).Width-x))
		if abs(forms(self.lst[obj].name).Width-x) < 10:
			self.incwidth=1
		else:
			self.incwidth=0
		if abs(forms(self.lst[obj].name).Height-y) < 10:
			self.incheight=1
		else:
			self.incheight=0    
	def multipleselected(self):#returns true if morethan one widget is selected
		b=0
		for a in self.lst:
			if self.lst[a].selected:
				b+=1
		return b>1        
	def transfer(self,parent):#transfer widget place by GTKForms to our working widget(self.sw) w/c has scrollV and scrollh
		for a in self.lst:            
			self.lst[a].name.setParent(parent)
			self.lst[a].sa.setParent(parent)
	def transferone(self,parent,obj,prop,events='[]'):#transfer widget place by GTKForms to our working widget(self.sw) w/c has scrollV and scrollh           

		self.lst[obj].name.setParent(parent)
		self.lst[obj].sa.setParent(parent)

		#self.lst[obj].prop=prop
		#self.lst[obj].events=self.lst[obj].events+eval(events)

		forms(self.lst[obj].name).Visible=TrueFalse(prop['Visible'])
		forms(self.lst[obj].sa).Visible=True


		#print("xxx",forms(self.lst[obj].name).Width,forms(self.lst[obj].name).Height)
		a=0    


	def move(self,x,y):#move controls that being selected or resize widget if incwidth or incheight is true

		for a in self.lst:
			if self.lst[a].selected:
				curr=self.lst[a].name
				if self.multipleselected()==False:
					if self.incwidth==1:
						self.incwidth=2
						self.prevWidth=forms(curr).Width
					if  self.incwidth==2:                  
						val=self.prevWidth+x
						if val>20:                        
							forms(curr).Width=self.prevWidth+x
							forms(self.lst[a].sa).Width=self.prevWidth+x 

					if self.incheight==1:
						self.incheight=2
						self.prevHeight=forms(curr).Height
					if  self.incheight==2:
						val=self.prevHeight+y
						if val>20:
							forms(curr).Height=self.prevHeight+y
							forms(self.lst[a].sa).Height=self.prevHeight+y


				if self.incwidth==0 and self.incheight==0:
					forms(curr).Top+=y
					forms(curr).Left+=x
					forms(self.lst[a].sa).Top+=y
					forms(self.lst[a].sa).Left+=x   
					if curr.parent!=self.workarea:
						ret=self.widgetQScrollparent(curr)
						if ret==None:
							forms(curr).Top+=forms(curr.parent()).Top
							forms(curr).Left+=forms(curr.parent()).Left
							forms(self.lst[a].sa).Top+=forms(curr.parent()).Top
							forms(self.lst[a].sa).Left+=forms(curr.parent()).Left
						else:
							ot=forms(ret).Top#inside QScrollArea
							ol=forms(ret).Left                                            
							forms(curr).Top+=ot
							forms(curr).Left+=ol
							forms(self.lst[a].sa).Top+=ot
							forms(self.lst[a].sa).Left+=ol                                          
						buferVis=forms(curr).Visible
						curr.setParent(self.workarea)#visibility will be lost
						self.lst[a].sa.setParent(self.workarea)
						forms(curr).Visible=buferVis
						forms(self.lst[a].sa).Visible=True



class Handler(QtWidgets.QWidget,usercontrol):
	def __init__(self,*param):    
		super(Handler, self).__init__(None)
		w,h=DeskTopSize()
		initUI(self,param,w=w,h=h,title="WiredQT v5.0",controlbox=True,startpos=(0,30),timeoutdestroy=-1)
		#self.installEventFilter(self)
		self.process=None
		self.runtime="Default"
		self.QCSI_code_line_flag=False
		self.helplst={}
		self.timer=QtCore.QTimer()
		self.timer.timeout.connect(self.loop)
		self.timer.start(10)       
		self.thisleft=250
		self.thistop=50
		self.thiswidth=w-466#900
		self.sw,self.sa=SquareWidget(self, self.thisleft,self.thistop,self.thiswidth,500,True,True)
		self.GTKForms()      
		self.intellisense.setStyleSheet("border:none")	
		_label=sorted(["Text","Top","Left","Width","Height","Visible","Enable","Font","BackColor","ForeColor","Picture","Events","Tag","ParentsType","Var","Help"])                        
		_label=["Name"]+_label
		_input=["" for a in _label]
		self.propertyEditor=PropertyEditor(self,_label)

		self.propertyEditor.property(_label,_input)

		self.plugin={}
		self.gui=ScrollLayout(self,500,0,200,650)
		forms(self.gui.scrollArea).Left=forms(self.sa).Left+forms(self.sa).Width
		forms(self.gui.scrollArea).Top=50
		self.sch=Scheduler(1000)#500 ms
		self.sch.Start()


		#ret=True
		#self.filename="untitled1.py"
		#self.code="import sys\nprint('Hello World')\n"
		self.objectMove=objectMove(self,self.sw)
		#ret=self.setfilename("picOCV.py")          
		#ret=self.setfilename('purescript.py')        
		#ret=self.setfilename()        
		ret=False
		self.toolbar()



		#self.QComboBox1.List=["asd","asdd"]
		self.QSCI=Scintilla.SimplePythonEditor()
		self.QSCI=forms(self.QSCI)
		self.QSCIShow(ret)
		self.QSCI.obj.selectionChanged.connect(self.QSCI_selectionChanged)
		self.QSCI.obj.linesChanged.connect(self.QSCIlinesChanged)
		self.QSCI.obj.cursorPositionChanged.connect(self.QSCIcursorPositionChanged)
		self.QSCI.obj.installEventFilter(self)
		if ret==True:
			self.Designer.Enable=False
			forms(self.propertyEditor.scrollWidget).Enable=False
		self.bufftyped=[]
		self.clsintellisense=clsIntellisense(self)
		
		self.installEventFilter(self)
		self.PutICON()
		
		
	def new_script(self,fname):
		self.filename=fname
		self.code="import sys\nprint('Hello World')\nx=100\nprint(x)\npass\n"
		self.QSCIShow(True)
		self.Designer.Enable=False
		self.Designer.ForeColor=(0.5,0.5,0.5,1)
	def PutICON(self):
		def doit(p,image):
			if FileExist("images/"+image):
				pixmap=QPixmap("images/"+image)
				ButtonIcon=QIcon(pixmap)
				p.setIcon(ButtonIcon)
				p.setIconSize(pixmap.rect().size())
				forms(p).Text=""
				p.setToolTip(image[0:image.find(".")])
		doit(self.run.obj,"run.png")
		doit(self.stop.obj,"stop.png")
		doit(self.stepin.obj,"stepin.png")
		doit(self.stepover.obj,"stepover.png")
		doit(self.stepout.obj,"stepout.png")
		doit(self.resume.obj,"resume.png")
		doit(self.where.obj,"where.png")
		doit(self.breakpoint.obj,"breakpoint.png")
		doit(self.goto.obj,"goto.png")		
		doit(self.Designer.obj,"designer.png")
		doit(self.Break_PDB.obj,"break_pdb.png")
			
	def toolbar(self):
		_wtaprop=wtaprop()
		def _createwidget(_type,name,left,top,width,height):




			_wtaprop["Name"]=name;_wtaprop["Text"]=name;_wtaprop["Text"]=name;_wtaprop["Left"]=left;_wtaprop["Top"]=top;_wtaprop["Width"]=width;_wtaprop["Height"]=height;

			self.createwidget(str(_wtaprop), _type, 'usercontrol','[]')
		t=19
		_createwidget('QPushButton','Designer',600,t,30,30)
		self.Designer.obj.clicked.connect(self.designer)

		_createwidget('QPushButton','resume',500,t,30,30)
		self.resume.obj.clicked.connect(self.resume_clicked)		
		_createwidget('QPushButton','run',530,t,30,30)
		self.run.obj.clicked.connect(self.run_clicked)

		_createwidget('QPushButton','stop',560,t,30,30)
		self.stop.obj.clicked.connect(self.stop_clicked)
		self.stop.Enable=False

		

		_createwidget('QPushButton','stepin',150,t,30,30)
		self.stepin.obj.clicked.connect(self.stepin_clicked)

		_createwidget('QPushButton','stepout',180,t,30,30)
		self.stepout.obj.clicked.connect(self.stepout_clicked)

		_createwidget('QPushButton','stepover',210,t,30,30)
		self.stepover.obj.clicked.connect(self.stepover_clicked)

		_createwidget('QColorDialog','QColorDialog',0,100,500,500)
		self.QColorDialog.Visible=False
		self.QColorDialog.BackColor=[0.5,0.5,0.5,1]
		self.QColorDialog.obj.accepted.connect(self.colorevent)        

		_createwidget('QFontDialog','QFontDialog',0,0,600,400)
		self.QFontDialog.BackColor=[0.5,0.5,0.5,1]
		self.QFontDialog.Visible=False
		self.QFontDialog.obj.accepted.connect(self.fontevent)
		
		_createwidget('QFileDialog','QFileDialog',0,0,600,400)
		self.QFileDialog.BackColor=[0.5,0.5,0.5,1]
		self.QFileDialog.Visible=False
		#self.QFileDialog.obj.accepted.connect(self.fontevent)		

		_createwidget('QPushButton','goto',240,t,30,30)
		self.goto.obj.clicked.connect(self.goto_clicked)

		_createwidget('QPushButton','breakpoint',270,t,30,30)
		self.breakpoint.obj.clicked.connect(self.breakpoint_clicked) 

		_createwidget('QPushButton','Break_PDB',300,t,30,30)
		self.Break_PDB.obj.clicked.connect(self.Break_PDB_clicked) 

		_createwidget('QPushButton','where',330,t,30,30)
		self.where.obj.clicked.connect(self.where_clicked)         


		_createwidget('QsciScintilla','_xEntry1x',self.thisleft,550,self.thiswidth,40)
		self._xEntry1x.installEventFilter(self)
		self._xEntry1x.Text="print('Hello WiredQT')"
		lexer = QsciLexerPython()
		#lexer.setDefaultFont(font)
		self._xEntry1x.setLexer(lexer)
		text = bytearray(str.encode("Arial"))   
		self._xEntry1x.obj.SendScintilla(QsciScintilla.SCI_STYLESETFONT, 1)        

		self._xEntry1x.obj.linesChanged.connect(self.linesChanged)
		self._xEntry1x.obj.SendScintilla(QsciScintilla.SCI_SETHSCROLLBAR, 0)
		self._xEntry1x.obj.SendScintilla(QsciScintilla.SCI_SETVSCROLLBAR, 0)


		_createwidget('QsciScintilla','OutputPane',self.thisleft,590,self.thiswidth,115)
		lexer = QsciLexerPython()
		#lexer.setDefaultFont(font)
		self.OutputPane.setLexer(lexer)
		text = bytearray(str.encode("Arial"))   
		self.OutputPane.obj.SendScintilla(QsciScintilla.SCI_STYLESETFONT, 1)              


		_createwidget('QFileDialog','QFileDialog',160,0,75,45)
		self.QFileDialog.Visible=False

		if self.caller.current_debug==None:
			self.showdebugbutton(False)#call this if debugging is not in progress      
		self.run.ForeColor=[0,0,1,1]  
		self.stop.ForeColor=[0.5,0.5,0.5,1]  
		self.Designer.ForeColor=[0.5,0.5,0.5,1]  

	def colorevent(self):
		a=self.QColorDialog.obj.currentColor()
		self.propertyEditor.updatevaluewidget([a.red()/255,a.green()/255,a.blue()/255,a.alpha()/255])
		a=0
	def fontevent(self):
		a=self.QFontDialog.obj.currentFont()
		self.propertyEditor.updatevaluewidget(a.family()+' ' + str(a.pointSize()))
		a=0		
	def _SourceBrowse(self,browse_self=False):
		if browse_self==False:
			self.browse={}
			self.cboclass.List=self.SourceBrowse(browse=self.browse)
			self.QCSI_code_line_flag=False
			print("Jedi finish(code browser)")
		else:
			self.caller.finishjedi=False
			print("start jedi self")
			ret=self.caller.showhelp(self.code, "", 6, 2, "self.")
			self.caller.finishjedi=True			
			pass
			
	def QSCIlinesChanged(self):    
		self.QCSI_indicator_break()
		self.QCSI_code_line_flag=True
		
	def QSCIcursorPositionChanged(self,y,x):
		self.xIntel=x
		self.yIntel=y	
		if self.caller.finishjedi==True and self.QCSI_code_line_flag==False:
			print("jedi no update (code browser)")
		if self.caller.finishjedi==True and self.QCSI_code_line_flag==True:
			print("jedi start (code browser)")
			start_new_thread(self._SourceBrowse,())	
		if self.caller.finishjedi==False and self.QCSI_code_line_flag==True:
			print("jedi busy (code browser)")
		#print(y,x)
	def linesChanged(self):
		if self._xEntry1x.Text=='':return
		if self.caller.current_debug==None: 
			self._xEntry1x_clear=True
			return
		#print(self._xEntry1x.Text.encode())
		self.caller.current_debug.execPDB(self._xEntry1x.Text.replace("\r\n","").replace("\n",""))
		self._xEntry1x_clear=True#for this _xEntry1x
	def execPDB(self,strs):#for current_debug 
		cmd="!"+strs+"\n"
		if hasattr(self,'debhist')==False:
			self.debhist=[]
		self.debhist.append(strs)
		self.debhistptr=len(self.debhist)-1
		self.process.stdin.write(cmd.encode())
		self.process.stdin.flush()
		self.OutputPane.Text+=">>"+strs+'\n'
		self.OutputPane.obj.setCursorPosition(self.OutputPane.obj.lines(),1)
		self.caller.updateAllOutputPane()
		self.bufftyped.append(strs)
		self.bufftypedIndex=len(self.bufftyped)-1        
		self._xEntry1x_clear=True
	def designer(self):
		self.QSCI.Visible=False
		self.Designer.ForeColor=[0.5,0.5,0.5,1] 
		self.Designer.Enable=False
		self.Break_PDB.Enable=False
		self.Break_PDB.ForeColor=[0.5,0.5,0.5,1]           
		forms(self.sa.verticalScrollBar()).Enable=True
		a=0
	def QSCIShow(self,flag):
		if self.QSCI.parent()==None:
			self.QSCI.setParent(self)
			
		else:
			self.QSCI.setParent(None)
		if flag==True:
			self.Designer.Enable=True
			self.Designer.ForeColor=[0,0,1,1]
			self.Break_PDB.Enable=True
			self.Break_PDB.ForeColor=[0,0,1,1]


		else:
			self.Designer.Enable=False
			self.Designer.ForeColor=[0.5,0.5,0.5,1]
			self.Break_PDB.Enable=False
			self.Break_PDB.ForeColor=[0.5,0.5,0.5,1] 
		forms(self.gui.scrollArea).Enable=flag^True
		self.QSCI.setParent(self)
		forms(self.QSCI).Visible=flag
		forms(self.sa).Visible=flag^True
		self.cboclass.Visible=flag
		self.cbomethods.Visible=flag
		
		forms(self.sa.verticalScrollBar()).Enable=flag^True
		forms(self.QSCI).Top=forms(self.sa).Top+30
		forms(self.QSCI).Left=forms(self.sa).Left
		forms(self.QSCI).Width=forms(self.sa).Width
		forms(self.QSCI).Height=forms(self.sa).Height-30
		self.cboclass.Top=forms(self.QSCI).Top-30
		self.cboclass.Left=forms(self.QSCI).Left
		self.cbomethods .Top=self.cboclass.Top
		self.cbomethods.Left=self.cboclass.Left+self.cboclass.Width
		try:self.QSCI.Text=self.code 
		except:pass	
		self.QCSI_indicator_break()


	def setfilename(self,fname=None,purescript=False):

		if purescript:
			SaveFileStr(fname,'import sys\nprint("Hello Word")\n')		
		if fname==None or FileExist(fname):
			if fname==None:
				self.filename="untitled.py"
				x=GetFileStr('template.py')
				SaveFileStr(self.filename, x)
				fname=self.filename
			elif FileExist(fname)==False:
				return
			if FileExist(fname) or purescript:
				self.filename=fname
				
				x=GetFileStr(self.filename).replace("\r\n","\n")
				self.code=x
				if self.IsQTForms()==False:
					#self.Designer.Enabled=False
					#self.QSCI.Text=x
					self.code=x
					#self.QSCI.Visible=True
					return True

			self.code=x

			xline=x
			xline=xline.replace('\n','\r')
			xline=xline.split('\r')        
			for a in xline: 
				if a.find('self.createwidget(')!=-1 and a.find('self.createwidget')!=-1 :
					a=a.strip()
					if a.find(";;;")!=-1:
						y=a[a.find('(')+1:a.find(";;;")-1]   
					else:	
						y=a[a.find('(')+1:-1]   
					#strs="getparam(%s)" % (y)
					try:

						x=eval(y)
						param=eval(x[0])
						events=x[3]
						fname=GetPath(self.filename)+ x[1]+".py"
						if FileExist(fname):#ActiveX in Project folder
							x=list(x);#x[1]=fname
							a='self.createwidget("'+str(x[0])+"\",'"+str(x[1])+"','"+str(x[2])+'\',\"'+x[3]+'\")'
						dir_path = os.path.dirname(os.path.realpath(self.filename))
						os.chdir(dir_path)
						import sys
						sys.path.append(dir_path)
						exec(a)#createWidget
						os.chdir(app_path())
						sys.path.remove(dir_path)
							
						if FileExist(GetPath(self.filename)+param['Picture']) and param['Picture']!='':
							strs="self."+ param["Name"]+".LoadPicture='"+ GetPath(self.filename)+param['Picture']+"'"
							#print(param['Picture'])
							exec(strs)
						sw=self.objectMove.add(eval("self._"+param["Name"]),str(param))        
						self.objectMove.lst[sw].events=eval(events)
						if param['Tag']=='Activex':
							_type=GetFilenameNoEXT(x[1])
							self.plugin.update({_type:x[1]})
						
						if param["ParentsType"]=='':#add to usercontrol
							self.objectMove.transferone(self.sw,sw,param,events)
						else:
							pass
							for a in self.objectMove.lst:
								props=eval(self.objectMove.lst[a].prop)
								if "self."+props['Name']==str(x[2]):
									parent=a
									print("OKKK",parent)
									print(parent in self.objectMove.lst)
									break
							print("this widget has parent",str(x[2]),sw)
							#self.objectMove.lst[sw].name.setParent(parent)
							#self.objectMove.lst[sw].sa.setParent(parent)
							pass
						
					except Exception as e:
						#continue#if debug our own wiredQT
						QMessageBox.about(self, "Error", "Check " + fname + ", if no errors or required Libraries were installed")
						import traceback
						strs=""
						for a in traceback.format_exc().splitlines():
							strs+=a+"\n"
						#QMessageBox.about(self, "\nWidget warning, ", "self." +param["Name"]+ " will not be included in the design")
						QMessageBox.about(self, "\nWidget warning, ", strs+"\n\n"+param["Name"]+".py will not be included in the design")
						pass
			self.QSCI.Text=self.code		
			return False
	def copyall(self,root_src_dir,root_dst_dir): # folder must have / at the and
		for src_dir, dirs, files in os.walk(root_src_dir):
			dst_dir = src_dir.replace(root_src_dir, root_dst_dir, 1)
			if not os.path.exists(dst_dir):
				os.makedirs(dst_dir)
			for file_ in files:
				src_file = os.path.join(src_dir, file_)
				dst_file = os.path.join(dst_dir, file_)
				if os.path.exists(dst_file):
					os.remove(dst_file)
				shutil.copy(src_file, dst_dir)		
	def getdependencies(self,fname,dest):


		xline=GetFileStr(fname)
		xline=xline.replace('\r\n','\n')
		xline=xline.replace('\r','\n')
		xline=xline.split('\n')        
		for a in xline: 
			if a.find('self.createwidget(')!=-1 and a.find('self.createwidget')!=-1 :
				a=a.strip()
				if a.find(";;;")!=-1:
					y=a[a.find('(')+1:a.find(";;;")-1]   
				else:	
					y=a[a.find('(')+1:-1]   
				try:

					x=eval(y)

					if FileExist(app_path()+"/plugin/"+x[1]):

						self.copyall(app_path()+"/plugin/"+x[1],dest)
				except:
					print("invalid self.createwidget")
					pass		
	def TransformParam(self,event):
		x=event.find("(")+1
		x=event[x:-1]
		ret="self"
		if x!='':
			x=x.split(",")
			for i,a in enumerate(x):
				ret+=",arg" +str(i+1)
			return "(" + ret + ")"    
		return '(self)'        
	def ShowEventSelected(self,obj,event):

		x=event.find('(')
		self.code=self.QSCI.Text
		if x!=-1:
			events=event[0:x]
		if self.code=="":

			#if self.filename.find('UnTitled')==-1:
			#	self.code=GetFileStr(self.filename)
			#print "save code first"
			#self.prop.btnSaveAs_clicked(None)
			pass

		if self.filename.find('UnTitled')!=-1:
			return






		if obj!=None:
			findthis="def " + self.objectMove.lst[obj].name.objectName + "_"  + events.replace('-',"_")
		else:
			findthis="class " + event

		p=pythonCode("",self.code)

		lineno=p.getLineNumber(findthis)
		if lineno==-1:
			x=pythonCode("",self.code)
			handler,_=x.getRoutinCode("class Handler") 

			#will add events if it does not exist in code
			routine=findthis
			y,_=x.getRoutinCode(routine)

			if y=="":
				routine= '\t'+findthis+self.TransformParam(event)+":\n\t\tpass\n"
				self.code=self.code.replace(handler,handler+routine)             
				p=pythonCode("",self.code)
				lineno=p.getLineNumber(findthis)                
			#will add events if it does not exist in code    
		return lineno
	def showdebugbutton(self,flag):
		if self.caller.current_debug!=None:
			self.caller.current_debug.showdebugbutton_rot(flag)
		self.caller.showdebugbutton() 
		pass
	def showdebugbutton_rot(self,flag):
		self._xEntry1x.Enable=flag
		self.resume.Enable=flag
		self.stepin.Enable=flag
		self.stepout.Enable=flag
		self.stepover.Enable=flag
		self.where.Enable=flag
		self.goto.Enable=flag
		self.breakpoint.Enable=flag
		#self.Break_PDB.Enable=flag
		if flag:
			color=[0,0,1,1]
		else:
			color=[0.5,0.5,0.5,1]
		self.resume.ForeColor=color
		self.stepin.ForeColor=color
		self.stepout.ForeColor=color
		self.stepover.ForeColor=color            
		self.where.ForeColor=color 
		self.goto.ForeColor=color 
		self.breakpoint.ForeColor=color 
		pass
	def resume_clicked(self,flag):
		self.caller.current_debug.resume_rot(True)
	def resume_rot(self,flag):
		if self.caller.current_debug!=None:
			self.showdebugbutton(False)
			self.process.stdin.write(b'c\n')
			self.process.stdin.flush()        
			a=0  		
	def goto_clicked(self,flag):
		self.caller.current_debug.goto_rot(True)
		pass
	def goto_rot(self,flag):
		cmd='j '+str(self.QSCI.obj.getCursorPosition()[0]+1)+'\n'
		#self.showdebugbutton(False)
		self.process.stdin.write(cmd.encode())
		self.process.stdin.flush() 
		self.where_clicked(1)
		pass	
	def where_clicked(self,flag):
		self.caller.current_debug.where_rot(True) 
		pass   
	def where_rot(self,flag):
		self.showdebugbutton(False)
		self.process.stdin.write(b'where\n')
		self.process.stdin.flush()        
		pass	
	
	def breakpoint_clicked(self,flag):
		self.caller.breakline=self.QSCI.obj.getCursorPosition()[0]+1#save current line before calling window that initiate debug
		self.caller.current_debug.breakpoint_rot(True) 
		pass
	def breakpoint_rot(self,flag):
		cmd='b '+str(self.caller.breakline)+'\n'
		#self.showdebugbutton(False)
		self.process.stdin.write(cmd.encode())
		self.process.stdin.flush()
		pass
	def QCSI_indicator_break(self):
		self.code=self.QSCI.Text
		x=self.code.split('\n')
		for nline,a in enumerate(x):
			if a.find("import pdb;pdb.set_trace()")!=-1:
				self.QSCI.markerAdd(nline, self.QSCI.obj.ARROW_MARKER_NUM)
			else:
				if self.QSCI.markersAtLine(nline) != 0:
					self.QSCI.markerDelete(nline, self.QSCI.obj.ARROW_MARKER_NUM)
	def Break_PDB_clicked(self,flag):
		line=self.QSCI.obj.getCursorPosition()[0]
		self.QSCI.insertAt("\t\timport pdb;pdb.set_trace()\n", line, 0)
		pass    
	def stepout_clicked(self,flag):        
		self.caller.current_debug.stepout_rot(True) 
	def stepout_rot(self,flag):        
		self.process.stdin.write(b'r\n')
		self.process.stdin.flush()
		self.process.stdin.write(b'r\n')
		self.process.stdin.flush()    
		a=0   
	def stepin_clicked(self,flag):
		self.caller.current_debug.stepin_rot(True) 
	def stepin_rot(self,flag):
		if self.importnextflag==True:#stepin crashes so we stepout instead if current line is import xxx(CheckTraceError handles it)
			self.stepover_clicked(None)        
		self.showdebugbutton(False)
		self.process.stdin.write(b's\n')
		self.process.stdin.flush()        
		a=0  		
	def stepover_clicked(self,flag):
		self.caller.current_debug.stepover_rot(True)  
	def stepover_rot(self,flag):
		self.showdebugbutton(False)
		self.process.stdin.write(b'n\n')
		self.process.stdin.flush()		
	        
	def stop_clicked(self,e): 
		if self.caller.current_debug:
			self.caller.current_debug.stop_rot(True)
			self.caller.showdebugbutton()
		self.caller.current_debug=None
	def stop_rot(self,e): 
		self._xEntry1x.Text=NowToString()
		if self.process!=None:
			self.process.terminate()
		self.showdebugbutton(False)

		self.process=None
		self.stop.Enable=False
		self.run.Enable=True
		self.stop.ForeColor=[0.5,0.5,0.5,1]
		self.run.ForeColor=[0,0,1,1]  

	def save(self):
		self.code=self.QSCI.Text
		if self.IsQTForms():
			self.GenerateWidget()
		SaveFileStr(self.filename, self.QSCI.Text.replace("\r\n","\n"))	
	def saveas(self,fname):
		self.code=self.QSCI.Text
		if self.IsQTForms():
			self.GenerateWidget()
		self.filename=fname
		SaveFileStr(fname, self.QSCI.Text.replace("\r\n","\n"))			
	def check_syntax(self,filename):	
		import ast, traceback
		
		with open(filename) as f:
			source = f.read()
		valid = True
		try:
			ast.parse(source)
		except SyntaxError:
			valid = False
			#traceback.print_exc()  # Remove to silence any errros
			self.OutputPane.Text+=traceback.format_exc(limit=None, chain=True)
			self.OutputPane.Text+="syntaxt error in : "+filename
			self.OutputPane.obj.setCursorPosition(self.OutputPane.obj.lines(),1)
		#print(valid)			
	def run_clicked(self,e):
		if self.process==None:
			print('Process Started')
			if hasattr(self,'debhist')==False:
				self.debhistptr=0
			else:	
				self.debhistptr=len(self.debhist)-1
			self.GenerateWidget()
			SaveFileStr(self.filename, self.QSCI.Text.replace("\r\n","\n"))
			self.check_syntax(self.filename)
			self.caller.current_debug=self
			import platform
			if self.runtime!="Default" and platform.system()=="Windows":
				path=GetPath(self.runtime)[:-1]
				import shutil
				#if FileExist(path +"\\python_.exe")==False:
				#	shutil.copyfile(self.runtime, path +"\\python_.exe")

				paths=[]
				if os.environ["PATH"].find(path)==-1:
					os.environ["PATH"]+=";"+path+";"

				paths=['Library\\mingw-w64\\bin','Library\\usr\\bin','Library\\bin','Scripts','bin']
				for a in paths:
					if FileExist(path+'\\' + a) and os.environ["PATH"].find(path+'\\' + a)==-1:
						os.environ["PATH"]+=path+'\\' + a +";"


			command='python ' + self.filename



			ON_POSIX = 'posix' in sys.builtin_module_names							

			def enqueue_output(out, queue):
				for line in iter(out.readline, b''):
					queue.put(line)
				out.close()
			def enqueue_output2(out, queue):
				for line in iter(out.readline, b''):
					queue.put(line)
				out.close()
			import frmaddlibs
			frmaddlibs.getimportlibs(self.filename)
			if platform.system()!="Windows":
				python_name="python3"
			if platform.system()=="Windows" and self.runtime=="Default":
				python_name="python.exe"
			if platform.system()=="Windows" and self.runtime!="Default":
				python_name=self.runtime					
			#get path of python, currently running python that execute this WiredQT
			python_path=os.path.dirname(sys.executable)#
			#print(python_path+"/"+python_name)
			python_name=python_path+"/"+python_name
			dir_path = os.path.dirname(os.path.realpath(self.filename))
			os.chdir(dir_path)

			self.process = Popen([python_name,'-u',self.filename], stderr=PIPE,stdout=PIPE ,stdin=PIPE, bufsize=1, close_fds=ON_POSIX)
			self.queue = Queue()
			self.queue2 = Queue()
			#self.outraks,self.errraks = self.process.communicate()

			t = Thread(target=enqueue_output, args=(self.process.stderr, self.queue))
			t.daemon = True # thread dies with the program
			t.start()

			t = Thread(target=enqueue_output2, args=(self.process.stdout, self.queue2))
			t.daemon = True # thread dies with the program
			t.start()	
			os.chdir(app_path())
			self.showdebugbutton_rot(False)
			self.run.Enable=False
			self.stop.Enable=True
			self.stop.ForeColor=[1,0,0,1]
			self.run.ForeColor=[0.5,0.5,0.5,1]
	def WidgetProperties(self,name):
		for a in self.objectMove.lst:
			_prop=self.objectMove.lst[a]
			prop=eval(_prop.prop)
			
			if prop['Name']==name:
				prop['Left']=forms(_prop.sa).Left
				prop['Top']=forms(_prop.sa).Top
				return prop
		return None				
	def WidgetPlaced(self):
		class ret:
			def __init__(self):
				self.lst={}
			def Exist(self,name):
				return name in self.lst
			
			def IsParent(self,name):
				if self.Exist(name):
					if self.lst[name]!="usercontrol":
						return True
					else:
						return False
			def Widgetobj(self,name,objmove):
				if self.Exist(name):
					for a in objmove.lst:
						n=objmove.lst[a]
						if eval(n.prop)['Name']==name:
							return n 
				return None								
			def GetChild(self,name):
				lst=[]
				if self.Exist(name):
					for a in self.lst:
						if self.lst[a]==name:
							lst.append(a);	
				return lst
			def GetParent(self,name):
				if self.Exist(name):
					for a in self.lst:
						if a==name:
							return self.lst[a];
				return 'usercontrol'				
						
		_ret=ret()	
		for obj in self.objectMove.lst:
			_obj=self.objectMove.lst[obj]
			x1=_obj.name.objectName
			if type(_obj.name.parent().objectName)==str and _obj.name.parent().objectName!='':
				x2=_obj.name.parent().objectName
					
			elif type(_obj.name.parent().parent().objectName)==str and _obj.name.parent().parent().objectName!='' and type(_obj.name)==QWidget:
				x2=_obj.name.parent().parent().objectName		
			else:    
				x2="usercontrol"
			_ret.lst.update({x1:x2})
		return _ret
		
	def GenerateWidget(self):
		def generate():#update self.objectMove.lst[obj].prop 
			for obj in self.objectMove.lst:
				formswidget=forms(self.objectMove.lst[obj].name)
				if self.objectMove.lst[obj].prop=="":
					wtapropx=wtaprop()
				else:    
					wtapropx=eval(self.objectMove.lst[obj].prop)#wtaprop()
				#for a in wtapropx:
					#x=ActiveX(formswidget.obj).IsActiveX()
					#if (a in ['Name','Events','ParentsType','Help','Picture','Tag',"Var"])==False:
						#if x==False:
							#wtapropx[a]=str(eval('formswidget.'+a)) #from actual widget to wtapropx
						#else:
							#try:
								#wtapropx[a]=str(eval('formswidget.obj.'+a)) #from actual widget to wtapropx
							#except:
								#pass	

					#if a=='Name':
						#wtapropx[a]=self.objectMove.lst[obj].name.objectName
					#if a=='Events':
						#wtapropx[a]=str(self.objectMove.lst[obj].events)
				self.objectMove.lst[obj].prop=str(wtapropx)   

		generate()
		withparent=[]
		withoutparent=[]

		if len(self.objectMove.lst)==0:
			strs='\tdef GTKForms(self):\n\t\tpass\n'			
		else:        
			strs='\tdef GTKForms(self):\n'			
			for obj in self.objectMove.lst:
				_obj=self.objectMove.lst[obj]
				prop=eval(_obj.prop)
				#update prop; self.objectMove.lst[obj].prop -> prop
				if prop['Tag']!='Activex':
					prop['Events']=[a[0] for a in _obj.events]
					if len(prop['Events']):
						prop['Events']="[" + prop['Events'][0] + "]"                    
				else:
					prop['Events']=[[a] for a in _obj.events]

			# prop['Enable']='True'
				prop['Text']=forms(_obj.name).Text
				prop['Left']=str(forms(_obj.name).Left)
				prop['Top']=str(forms(_obj.name).Top)
				prop['Width']=str(forms(_obj.name).Width)
				prop['Height']=str(forms(_obj.name).Height)
				_obj.prop=str(prop)
				if prop['Tag']!='Activex':
					types=str(type(_obj.name)).split('.')[-1][:-2]
				else:
					types=str(type(self.objectMove.lst[obj].name))

					types=types[8:types.find('.')]
				prop['Name']=_obj.name.objectName
				if type(_obj.name.parent().objectName)==str and _obj.name.parent().objectName!='':
					parent="self."+_obj.name.parent().objectName
					ptype=_obj.name.parent()
					ptype=str(type(ptype)).split('.')[-1][:-2]
					prop['ParentsType']=ptype
					_strs="\t\tself.createwidget(\""+str(prop)+"\",'%s','%s',\"%s\")\n" % (types, parent,str(_obj.events))
					withparent.append(_strs)
				elif type(_obj.name.parent().parent().objectName)==str and _obj.name.parent().parent().objectName!='' and type(_obj.name)==QWidget:
					parent="self."+_obj.name.parent().parent().objectName
					ptype=_obj.name.parent().parent()
					ptype=str(type(ptype)).split('.')[-1][:-2]
					prop['ParentsType']=ptype
					_strs="\t\tself.createwidget(\""+str(prop)+"\",'%s','%s',\"%s\")\n" % (types, parent,str(_obj.events))
					withparent.append(_strs)				
				else:    
					parent="usercontrol"
					_strs="\t\tself.createwidget(\""+str(prop)+"\",'%s','%s',\"%s\")\n" % (types, parent,str(_obj.events))
					withoutparent.append(_strs)
		#without parent first        
		for a in withoutparent:        
			strs+=a        
		#follwed by with parent
		for a in withparent:        
			strs+=a                    
		self.code=self.QSCI.Text        
		x=pythonCode("",self.code)
		handler,_=x.getRoutinCode("def GTKForms")
		if handler!="":#apply to GTKForms changes
			self.code=self.code.replace(handler,strs+'\t')  
		self.QSCI.Text=self.code    

	def intellisense_activated(self,e):


		if hasattr(self,'fromcodeIntel') and self.fromcodeIntel:
			a=0
			strs=self.intellisense.List[e]#[self.startPasteIntellisense:]
			indexTo=self.clsintellisense.posX
			indexFrom=self.clsintellisense.posX-self.startPasteIntellisense
			self.QSCI.obj.setSelection (self.clsintellisense.posY, indexFrom, self.clsintellisense.posY, indexTo)
			self.QSCI.obj.removeSelectedText()
			self.QSCI.obj.insertAt(strs,self.clsintellisense.posY,indexFrom)
			self.QSCI.setCursorPosition(self.clsintellisense.posY,indexFrom+len(strs))
			self.QSCI.obj.setFocus(True)
			self.intellisense.Visible=False
			self.fromcodeIntel=False


		else:	

			strs=self.intellisense.List[e]
			rot=strs[0:strs.find('(')]
			param=self.TransformParam(strs)[1:-1]#get param and remove '(' and ')'



			#print(e,strs)
			self.intellisense.Visible=False
			lineno=self.ShowEventSelected(self.objectMove.obj,strs)
			#print(lineno,"line")
			self.QSCI.Text=self.code
			self.QSCIShow(True)#self.QSCI.Visible=True
			self.QSCI.setCursorPosition(lineno+1,2)
			self.QSCI.obj.setFocus(True)



			if ([rot,param] in self.objectMove.lst[self.objectMove.lastselected].events)==False:
				#['clicked', 'self,e']
				self.objectMove.lst[self.objectMove.lastselected].events.append([rot,param])

			a=0   
	def _createwidgetActivex(self,_wtaprop,_type,name,left,top,width,height,activex):
		_wtaprop["Tag"]=activex
		_wtaprop["Name"]=name;_wtaprop["Text"]=name;_wtaprop["Text"]=name;_wtaprop["Left"]=left;_wtaprop["Top"]=top;_wtaprop["Width"]=width;_wtaprop["Height"]=height;
		dir_path = os.path.dirname(os.path.realpath(self.filename))
		os.chdir(dir_path)
		import sys
		sys.path.append(dir_path)
		self.createwidget(str(_wtaprop), _type, _type,'[]') 
		os.chdir(app_path())
		sys.path.remove(dir_path)
		
	def butP(self):	
		self._butP()
	def _butP(self,name="",prop=None):
		if prop!=None:
			cname=prop['Name']
		self.objectMove.resetselected()
		if name=="":
			name=self.sender().text()
			if name.find('user control')!=-1 or name.find('--------')!=-1:
				return;
		if name=="Load User Control":
			self.QFileDialog.obj.setDirectory(GetPath(self.filename))
			ret=self.QFileDialog.obj.getOpenFileName()
			a=GetFilename(ret[0])
			self.plugin.update({GetFilenameNoEXT(a):ret[0]})
			if self.filename==a:
				print("same name detected")
			else:    
				self.gui.addWidget(GetFilenameNoEXT(a),ret[0])
			return
		if name in self.plugin:
			pathcode=GetPath(self.filename)
			pathplugin=GetPath(self.plugin[name])
			if FileExist(pathcode+name+'.py')==False:
				copyfile(self.plugin[name],pathcode+name+'.py')#copy Plugin Library
				if FileExist(pathplugin+name+".png")==True:#is png exist in plugin
					copyfile(pathplugin+name+".png",pathcode+name+'.png')#copy Plugin image			
		if FileExist(GetPath(self.filename)+ name+".py"):
			QApplication.setOverrideCursor(Qt.WaitCursor)
			_wtaprop=wtaprop()
			ret=extractModuleProperties(GetPath(self.filename)+name+".py")
			for a in ret:
				_dict=eval("{"+a+"}")
				for b in _dict:
					if b!="list":
						label=b;val=_dict[b];
				_wtaprop.update({label:val})					

			_type=GetPath(self.filename)+ name+".py"
			name=GetFilenameNoEXT(name)

			if prop==None:
				l="100";t="100";w="100";h="100"
			else:
				l=prop['Left'];t=prop['Top'];w=prop['Width'];h=prop['Height']
			try:	
			#if 1:
				self._createwidgetActivex(_wtaprop,_type,name+str(len(self.objectMove.lst)),l,t,w,h,"Activex") 
				sw=self.objectMove.add(eval("self."+_wtaprop["Name"]),str(_wtaprop))
				self.objectMove.transferone(self.sw,sw,_wtaprop,"[['ccc'],['ddd']")
				self.objectMove.lst[sw].prop=str(_wtaprop)
			except Exception as e:#comment this so that we can see actual error in terminal(wireqt should be executed in terminal)
				import traceback
				strs=""
				for a in traceback.format_exc().splitlines():
					strs+=a+"\n"				
				QMessageBox.about(self,"WiredQT, Error Detected in " + name + ".py!!!",strs+"\n\n"+"Correct this error before using this usercontrol")
			a=0
			QApplication.restoreOverrideCursor()
			return
		_wtaprop=wtaprop()
		if name=='QColorDialog':#dont show QColorDialog, it causes crash when resizing
			_wtaprop["Visible"]=False
		_wtaprop["Name"]=name + str(len(self.objectMove.lst));_wtaprop["Text"]=_wtaprop["Name"];_wtaprop["Top"]=200;_wtaprop["Left"]='300'
		if prop==None:
			try:

				setting=eval(GetFileStr('setting.txt'))
				_wtaprop['Width']=setting[name]['Width']
				_wtaprop['Height']=setting[name]['Height']
			except:
				pass        
		else:
			_name=_wtaprop['Name']
			_wtaprop=prop
			_wtaprop['Name']=_name			
			'''_wtaprop['Left']=prop['Left']
			_wtaprop['Top']=prop['Top']
			_wtaprop['Width']=prop['Width']
			_wtaprop['Height']=prop['Height']
		
			'''	
		
		if prop!=None:
			n=self.WidgetPlaced()#index zero is last sel name,folowed by dictionary of all widget with parents
			y=n.GetParent(cname)
			z=n.GetChild(y)
			parent=n.GetParent(cname)
			lst=n.lst 
		if prop==None or parent=='usercontrol':
			_wtaprop['ParentsType']=''# added for paste from cut(might have parent but already cut and paste)
			self.createwidget(str(_wtaprop), name, 'usercontrol','[]')#oct 29 2022
		else:
			parent=n.GetParent(cname)
			parent_prop=self.WidgetProperties(parent)
			_wtaprop['Left']=int(_wtaprop['Left'])+int(parent_prop['Left'])
			_wtaprop['Top']=int(_wtaprop['Top'])+int(parent_prop['Top'])			
			self.createwidget(str(_wtaprop), name, "self."+parent,'[]')#oct 29 2022
		
		
		sw=self.objectMove.add(eval("self._"+_wtaprop["Name"]),str(_wtaprop))

		self.objectMove.transferone(self.sw,sw,_wtaprop)
		
		self.objectMove.IsInsideControl(sw,_wtaprop['Left'],_wtaprop['Top'] )        
		self.objectMove.resetselected()		
		
		n=self.WidgetPlaced()#index zero is last sel name,folowed by dictionary of all widget with parents
		obj=n.Widgetobj(_wtaprop['Name'],self.objectMove)
		self.propertyEditor.resetdefaultproperty()
		if obj!=None:
			self.propertyEditor.setwidgetproperties(obj,True)  
		
		#print("xxx",self.QColorDialog0.Width,self.QColorDialog0.Height)
		if name=='QLCDNumber':
			exec('self.'+name +str(len(self.objectMove.lst)-1)+".obj.display(100)")
	def createwidget(self,prop,control,parent,event=[]):
		createWidget(self,prop,control,parent,event)         
	def GTKForms(self):
		self.createwidget("{'Picture': '', 'ForeColor': '[0.0, 0.0, 0.0, 1.0]', 'Top': '56', 'Events': '[activated]', 'Enable': 'True', 'Tag': '', 'Width': '200', 'Help': '', 'Text': 'cbomethods', 'Height': '25', 'Left': '601', 'Var': '', 'Font': '', 'Name': 'intellisense', 'BackColor': '[1.0, 1.0, 1.0, 1.0]', 'ParentsType': '', 'Visible': 'False'}",'QComboBox','usercontrol',"[['activated', 'self,e']]")
		self.createwidget("{'Picture': '', 'Height': '21', 'Events': '[activated]', 'Enable': 'True', 'Tag': '', 'Width': '207', 'Help': '', 'Text': '', 'Name': 'cbomethods', 'Left': '285', 'Var': '', 'BackColor': '(1,1,1,0.25)', 'Top': '1', 'Visible': 'True', 'Font': '', 'ParentsType': '', 'ForeColor': '(0,0,0,1)'}",'QComboBox','usercontrol',"[['activated', 'self,arg1']]")
		self.createwidget("{'Picture': '', 'ForeColor': '(0,0,0,1)', 'Events': '[activated]', 'Font': '', 'Enable': 'True', 'Tag': '', 'Width': '172', 'Help': '', 'Text': '', 'Name': 'cboclass', 'Left': '86', 'Var': '', 'BackColor': '(1,1,1,0.25)', 'Top': '0', 'Height': '21', 'ParentsType': '', 'Visible': 'True'}",'QComboBox','usercontrol',"[['activated', 'self,arg1']]")
	def Widget(self):
		return self  

	#def ShowLineCodeInFile(self,line,filename):
		##import pdb;pdb.set_trace();
		#for i,a in enumerate(self.frmForm):
			#print(a.filename)
			#a.Widget().hide()
			#if a.filename.lower()==filename.lower():
				#self.currentform=a
				#self.currentform.Widget().show()
				#try:
					#x=self.currentform.editor[1].get_buffer()
				#except:
					#self.currentform.hassavedWiredGT=True
					#self.currentform.ShowEventSelected(None,"")
					##x=self.currentform.editor[1].TextView().TextView1
					##x.set_highlight_current_line(True)	
					##delay(1000)
					#refreshGTK()
				#self.currentform.showLineInCode(line)    
	def CheckTraceError(self):
		def getLine():
			try:  line = self.queue.get_nowait()
			except Empty:
				return ""
			else: # got line
				#...do something with line
				return line.decode()
		def getLine2():
			try:  line = self.queue2.get_nowait()
			except Empty:
				return ""
			else: # got line
				#...do something with line
				try:
					line=line.decode()
				except:
					line="cant decode byte"
				return line

		buf=getLine()
		buf2=getLine2()
		try:
			if (buf2!=''):
				#print("at last stdout has data",buf2)
				while(buf2.find("(Pdb) ")==0):
					buf2=buf2[6:]			
				pdbheader= '(Pdb) > /'
				pdbheader2= '> '#pdbheader2= '> /'
	
				if buf2[:2]==pdbheader or buf2.find(pdbheader2) ==0:
					if buf2.find(pdbheader2)==0:
						pdbheader=pdbheader2
					offset=len(pdbheader)
					_start=buf2[offset:].find("(")
					_end=buf2[offset:].find(")")
					codeline=buf2[_start+offset+1:_end+offset]
					fname=buf2[offset-1:offset+_start]
					fname=fname.replace("\\","/")
					fname=fname.strip()
	
					#print("fname",fname)
					#print("codeline",codeline)
					self.showdebugbutton_rot(True)
					fnamex=self.filename.lower()
					fnamey=fname				
					if fnamey[len(fnamey)-len(fnamex):]==fnamex:
						
						self.QSCI.Visible=True
						self.QSCIShow(True)#self.QSCI.Visible=True
						self.caller.QComboBox3_activated(fname)
						self.QSCI.setCursorPosition(int(codeline)-1,2)
						self.QSCI.obj.setFocus()
						self.window().activateWindow()
						
					else:
						windows=[a.lower() for a in list(self.caller.windows.keys())]
						windowsRetainCase=list(self.caller.windows.keys())
						
						if (fnamey in windows)==False:#open new window for this script										
							self.caller.NewWIndow(fname)
							self.caller.refreshCombo()
							self.caller.windows[fname]. QSCI.Visible=True
							self.caller.windows[fname].QSCIShow(True)
							self.caller.windows[fname].QSCI.setCursorPosition(int(codeline)-1,2)
							self.caller.windows[fname].QSCI.obj.setFocus()
							self.window().activateWindow()
							self.caller.showdebugbutton()
							
							
							a=0
						else:	#script already open, pdb gives lower case in file,so we use this technique
							index=windows.index(fname)
							fname=windowsRetainCase[index]					
							self.caller.QComboBox3_activated(fname)
							self.caller.windows[fname]. QSCI.Visible=True
							self.caller.windows[fname].QSCIShow(True)
							self.caller.windows[fname].QSCI.setCursorPosition(int(codeline)-1,2)
							self.caller.windows[fname].QSCI.obj.setFocus()
							self.window().activateWindow()	
							
							
						print("Open new file for display")
				self.importnextflag=False
				if len(buf2)>1 and (buf2[0]==">" or buf2[0:2]=="->"):
					pass
				else:
						self.OutputPane.Text+=buf2
						self.OutputPane.obj.setCursorPosition(self.OutputPane.obj.lines(),1)
						self.caller.updateAllOutputPane()
			
				#cursor = self.OutputPane.textCursor()
				#cursor.movePosition(QTextCursor.End);
				#self.OutputPane.setTextCursor(cursor);
	
				if len(buf2)>10:
					if buf2[:9]=="-> import":
						self.importnextflag=True
		except:
			buf=''
			line=''
			buf2=''
			print("special char error")			
		line=''
		while(buf!=''):
			line+=buf
			buf=getLine()
		if line!='':
			if line.find('Traceback')!=-1 or line.find('SyntaxError')!=-1:
				#self._xEntry1x.Enable=True
				self.process.terminate()
				self.OutputPane.Text+=line
				self.OutputPane.obj.setCursorPosition(self.OutputPane.obj.lines(),1)
				self.caller.updateAllOutputPane()
				QMessageBox.about(self, "WiredQT, Error Detected!!!",line)
				#self.DatagridTreeView1.Visible=True

				#self.Fill(line)


			else:

				self.importnextflag=False
				#print(line,"raks")    
	def loop(self):
		if hasattr(self,'_xEntry1x_clear') and self._xEntry1x_clear:
			self._xEntry1x_clear=False
			self._xEntry1x.Text=""		
		if self.process!=None:
			self.CheckTraceError()
		if self.process!=None and self.process.poll()!=None:
			self.CheckTraceError()			        
		if self.form_load==False:
			start_new_thread(self._SourceBrowse,(True,))
			self.form_load=True
		if self.sch.Event():#timer routine
			if self.stepin.Enable==True:
				self._xEntry1x.Enable=True
			else:
				self._xEntry1x.Enable=False			
			#code here
			#print(TimeToString())
			if self.timeoutdestroy!=-1:
				self.timeoutdestroy-=1
				if self.timeoutdestroy==0:
					pass#self.unload(None)
			self.sch.Start()#restart scheduler      
		#self.add


	def connect(self,ev,evusr):
		self.wiredevents.update({ev:evusr})
	def activeXcreated(self,*args):
		pass        
	def eventFilter(self, obj, event):
		#if obj == self.btn and event.type() == QtCore.QEvent.HoverEnter:
		#    self.onHovered()
		GRID_OFFSET=5
		if event.type() == QtCore.QEvent.KeyPress:

			#print(event.key())     
			self.objectMove.key=event.key()
			if self.objectMove.obj!=None and event.key()==16777223 and self.sw==obj:#delete only if in design mode
				lst=[]
				n=self.WidgetPlaced()#index zero is last sel name,folowed by dictionary of all widget with parents
				
				
				for a in self.objectMove.lst:
					if self.objectMove.lst[a].selected:
						cname=eval(self.objectMove.lst[a].prop)["Name"]#object name
						lst.append(a)
				#parent has been deleted		
				z=n.GetChild(cname)
				for a in self.objectMove.lst:
					cnameb=eval(self.objectMove.lst[a].prop)["Name"]
					if (cnameb in z) ==True and cnameb!=cname:#dont include parent as it is already appended to lst
						lst.append(a)				
				#parent has been deleted		
				
				for a in lst:
					self.objectMove.delete(a)
				
			if self.objectMove.key==16777216:#esc
				self.intellisense.Visible=False
				self.objectMove.resetselected()  
			if self.objectMove.key==16777249:#ctrl
				self.objectMove.showselected()
			ret=self.clsintellisense.check(event.key())  
			if ret:
				if obj==self.QSCI.obj:
					event.accept()			
					return True				
		if event.type() == QtCore.QEvent.KeyRelease:
			#print(event.key())  
			CTRL=16777249
			ALT=16777251
			TAB=16777217
			SHIFT=16777248	
			F3=16777266
			F5=16777268
			F8=16777271
			F9=16777272
			F10=16777273
			F11=16777274
			F12=16777275
			F1=16777264#update code browser
			UP=16777235
			Fkey=70
			DOWN=16777237
			if obj==self._xEntry1x.obj:
				if self.caller.current_debug!=None and  event.key()==UP:
					if hasattr(self.caller.current_debug,"debhist"):
						if self.caller.current_debug.debhistptr!=0:
							self.caller.current_debug.debhistptr-=1						
						self._xEntry1x.Text=self.caller.current_debug.debhist[self.caller.current_debug.debhistptr]
						
				if self.caller.current_debug!=None and  event.key()==DOWN:						
					if hasattr(self.caller.current_debug,"debhist"):
						if self.caller.current_debug.debhistptr!=len(self.caller.current_debug.debhist)-1:
							self.caller.current_debug.debhistptr+=1							
						self._xEntry1x.Text=self.caller.current_debug.debhist[self.caller.current_debug.debhistptr]		
				pass
			if obj==self.QSCI.obj:
				try:
					x=event.pos()
					print(x.x(),x.y(),"qpoint")
				except:
					pass
				for a in self.clsintellisense._parsefind:
					key=event.key()
					keys={CTRL:255,ALT:254,TAB:253,SHIFT:252}
					if key in keys:
						key=keys[key]
					if key>255:key=0#filter some extended keys	
					if a.Poll(chr(key)):
						if hasattr(self,'QInputDialog0')==False:
							self.QInputDialog0=forms(QInputDialog())
						self.findthis=self.QInputDialog0.obj.getText(self,"Find","")
						self.QSCI.obj.findFirst(self.findthis[0],False,False,False,False)
						
				if event.key()==F3:
					if hasattr(self,'findthis'):
						self.QSCI.obj.findNext()
						pass
				if event.key()!=16777249 and event.key()!=32:#hide intellisense 
					self.intellisense.Visible=False
				if event.key()==F1:	
					#self.browse={}
					#self.cboclass.List=self.SourceBrowse(browse=self.browse)
					pass
				if event.key()==F10:
					if self.caller.current_debug!=None:
						self.caller.current_debug.stepover_rot(True)
				if event.key()==F11:
					if self.caller.current_debug!=None:
						self.caller.current_debug.stepin_rot(True)					
				if event.key()==F12:
					if self.caller.current_debug!=None:
						self.caller.current_debug.stepout_rot(True)
				if event.key()==F5:
					if self.caller.current_debug!=None:
						self.caller.current_debug.resume_rot(True)					
					else:
						if self.run.Enable==True:
							self.run_clicked(None)
						
			self.objectMove.key=0
		if event.type() == QtCore.QEvent.MouseButtonPress:    
			if self.objectMove.exist(obj)==False:
				#print('form pressed')            
				pass
		if event.type() == QtCore.QEvent.MouseButtonRelease:
			if self.objectMove.exist(obj)==False:
				pass
		if hasattr(self,'objectMove')==True and obj!=self:#dont entertain if obj=self 


			if event.type() == QtCore.QEvent.MouseButtonPress:
				#print(event.button())
				if event.button()==2:#right
					self.objectMove.resetselected()
					self.intellisense.Visible=False
					forms(self.QSCI).Visible=False                 
				if event.button()==1 or event.button()==4:#left and middle
					self.propertyEditor.resetdefaultproperty()
					self.objectMove.showselected()                   
					self.objectMove.obj=self.objectMove.ControlUnderMouse(event.x()-event.x()%GRID_OFFSET ,event.y()-event.y()%GRID_OFFSET)
					obj=self.objectMove.obj
					if obj!=None:
						self.intellisense.Visible=False
						self.objectMove.lst[obj].hasmoved=False
						self.objectMove.mousedown=True
						if self.objectMove.key==0 and self.objectMove.multipleselected()==False:
							self.objectMove.resetselected()                    
						if self.objectMove.multipleselected()==False:
							self.objectMove.setflag(obj,True)  
							self.objectMove.setselected(obj)
							self.objectMove.key=16777249
						if event.button()==4:
							self.objectMove.setselected(obj)
							self.objectMove.setflag(obj,True)
						self.offsety=event.y()-event.y()%GRID_OFFSET-self.sa.verticalScrollBar().value()
						self.offsetx=event.x()-event.x()%GRID_OFFSET-self.sa.horizontalScrollBar().value()                         
						self.objectMove.boundery(obj, self.offsetx-forms(self.objectMove.lst[obj].name).Left+self.sa.horizontalScrollBar().value(),self.offsety-forms(self.objectMove.lst[obj].name).Top+self.sa.verticalScrollBar().value())

						objname=self.objectMove.lst[obj]
						#print(objname.name.objectName," lP")
						#self.updateprop=objname




			if event.type() == QtCore.QEvent.MouseButtonRelease:
				#self.objectMove.obj=None
				#obj=self.objectMove.ControlUnderMouse(event.x(),event.y())

				if self.objectMove.obj!=None and event.button()==1:                         
					if self.objectMove.key==0:
						if self.objectMove.multipleselected()==False:
							self.objectMove.setflag(self.objectMove.obj,False)  
					if self.objectMove.lst[self.objectMove.obj].hasmoved:
						self.objectMove.IsInsideControl(self.objectMove.obj, event.x()-event.x()%GRID_OFFSET, event.y()-event.y()%GRID_OFFSET)        
						self.objectMove.resetselected()    
					#print(obj.objectName," lR")

					objname=self.objectMove.lst[self.objectMove.obj]
					self.propertyEditor.setwidgetproperties(objname,True)                    
				#self.objectMove.obj=None    
				self.objectMove.mousedown=False
			#if  event.type() == QEvent.Enter:
				#print(obj.objectName," enterx")   
			#if event.type() == QEvent.Leave:
				#print(obj.objectName," leavex")  
			if event.type() == QEvent.MouseMove:    
				if self.objectMove.mousedown:
					#if self.objectMove.obj==None:
					#    self.objectMove.obj=self.objectMove.ControlUnderMouse(event.x() ,event.y())

					if self.objectMove.obj!=None:                      
						if 1:#self.objectMove.mousedown:
							self.objectMove.lst[self.objectMove.obj].hasmoved=True
							if self.objectMove.flag(self.objectMove.obj):
								x=event.x()-event.x()%GRID_OFFSET#-self.offsetx
								y=event.y()-event.y()%GRID_OFFSET#-self.offsety
								if self.objectMove.incwidth or self.objectMove.incheight :
									self.objectMove.move(x-self.offsetx-self.sa.horizontalScrollBar().value(), y-self.offsety-self.sa.verticalScrollBar().value())
								else:
									_x=forms(self.objectMove.lst[self.objectMove.obj].name).Left-forms(self.objectMove.lst[self.objectMove.obj].name).Left%GRID_OFFSET
									_y=forms(self.objectMove.lst[self.objectMove.obj].name).Top-forms(self.objectMove.lst[self.objectMove.obj].name).Top%GRID_OFFSET

									self.objectMove.move(x-self.offsetx, y-self.offsety)
									self.offsety=event.y()-event.y()%GRID_OFFSET-self.sa.verticalScrollBar().value()
									self.offsetx=event.x()-event.x()%GRID_OFFSET-self.sa.horizontalScrollBar().value()  
								
								#try:	
								#	pos_ = QCursor.pos()
								#	QCursor.setPos(pos_.x()-pos_.x()%5,pos_.y()-pos_.y()%5)
								#	pos_ = QCursor.pos()
								#	print(x,pos_x())
								#except:
								#	pass
							#print(x,y)
							
				#print(obj.objectName," movex")  
			if event.type() == QEvent.MouseButtonDblClick:
				if self.objectMove.obj!=None:
					#print(" MouseButtonDblClickx",self.objectMove.lst[self.objectMove.obj].name.objectName)  
					module=type(eval('self.' + self.objectMove.lst[self.objectMove.obj].name.objectName))
					_module =str(module).split("'")[1].split('.')[0]
					ret=[]
					if _module in self.plugin:
						ret=extractModuleEvents(GetPath(self.filename)+_module+".py")#it is in user Project Folder

					#ret=extractModuleProperties(module)+ret
					signal=self.objectMove.signals(self.objectMove.obj)#Event/Signal from QGUI
					self.intellisense.obj.setParent(None)
					self.intellisense.obj.setParent(self)
					if len(ret):
						self.intellisense.List=ret
					else:
						self.intellisense.List=signal+["installEventFilter()"]
					self.intellisense.Top=event.y()  +forms(self.sa).Top-self.sa.verticalScrollBar().value()                       
					self.intellisense.Left=event.x() +forms(self.sa).Left-self.sa.horizontalScrollBar().value()                       
					self.intellisense.Width=200
					#x=self.intellisense.ForeColor			
					self.intellisense.Visible=True
					methods=signal=self.objectMove.methods(self.objectMove.obj,"")
					#print(methods)
					#colorize events that has code
					for i,a in enumerate(self.intellisense.List):
						self.intellisense.setItemData(i, QBrush(Qt.black), Qt.ForegroundRole)
					for a in self.objectMove.lst[self.objectMove.lastselected].events:
						for i,b in enumerate(self.intellisense.List):
							rot=b[0:b.find('(')]
							if a[0]==rot:
								self.intellisense.setItemData(i, QBrush(Qt.red), Qt.ForegroundRole)  
					#colorize events that has code            
				else:
					lineno=self.ShowEventSelected(None,"Handler")
					#print(lineno,"line")
					self.QSCI.Text=self.code
					self.QSCIShow(True)#self.QSCI.Visible=True
					self.QSCI.setCursorPosition(lineno+1,2)
					self.QSCI.obj.setFocus(True)                    
					#print(" MouseButtonDblClick form")
			#if event.type() == QEvent.Move:                      
				#print('mouseMoveEvents')

		#print(event)    
		a=super(Handler, self).eventFilter(obj, event)
		return a
	def SourceBrowse(self,cls="",methodfnd="",getline=False,browse=None):
		self.caller.finishjedi=False
		browse.clear()
		sys_path =self.caller.jedi.get_default_environment().get_sys_path()
		path=GetPath(self.filename)[:-1]
		
		_lst=[]
		code =self.QSCI.Text+"\n"+cls
		if self.caller.jedi.__version__!="0.18.0":
			script=self.caller.jedi.Script(source=code,sys_path=sys_path + [path])
		else:	
			script=self.caller.jedi.Script(code,path="")
		try:	
			suggest=script.complete(self.QSCI.obj.lines()+1,len(cls))
			for sug in suggest:
				# __main__ jedi 0.16.0
				# WiredQT jedi 0.18.0
				if (sug.module_name=="__main__" or sug.module_name=="WiredQT") and (sug.type=="class" or sug.type=="function"):
					browse.update({sug.name:sug.line})
					if getline and methodfnd==sug.name:
						self.caller.finishjedi=True
						return sug.line
					_lst.append(sug.name)
		except:
			print("jedi, invalid line (code browser)")
			pass
		self.caller.finishjedi=True		
		return _lst	
	def QSCI_selectionChanged(self):
		
		#r=self.SourceBrowse()
		#rc=self.SourceBrowse("Handler.")
		#rc=self.SourceBrowse("Handler.loop")
		
		
		self.QSCI.obj.SendScintilla(QsciScintilla.SCI_INDICATORCLEARRANGE,0,len(self.QSCI.Text))
		self.QSCI.obj.SendScintilla(QsciScintilla.SCI_INDICSETSTYLE, 0, QsciScintilla.INDIC_BOX)
		#print(self.QSCI.obj.selectedText())
		text=self.QSCI.obj.selectedText()
		if text=="":return
		self.code=self.QSCI.Text
		_len=len(text)	
		for i,a in enumerate(self.code):
			try:
				if self.code[i:i+_len]==text:
					self.QSCI.obj.SendScintilla(QsciScintilla.SCI_INDICATORFILLRANGE,i,len(text))               
			except:
				break
		pass
	
	def IsQTForms(self):
		if self.code.find('#	Generated By WiredQT for Python: by Rocky Nuarin, 2021 Phils')==-1:
			return False
		else:
			return True
	def designer(self,arg1):
		self.QSCI.Visible=False
		self.Designer.ForeColor=[0.5,0.5,0.5,1] 
		self.Designer.Enable=False
		self.Break_PDB.Enable=False
		self.Break_PDB.ForeColor=[0.5,0.5,0.5,1]           
		forms(self.sa.verticalScrollBar()).Enable=True
		forms(self.sa).Visible=True
		self.cboclass.Visible=False
		self.cbomethods.Visible=False		
		forms(self.gui.scrollArea).Enable=True
		a=0
		pass
	def cboclass_activated(self,arg1):
		try:
			if self.caller.finishjedi==True:
				y=self.browse[self.cboclass.List[arg1]]
				self.QSCI.setCursorPosition(y-1,0)
				self.QSCI.obj.setFocus()
				self.window().activateWindow()		
				self.browse2={}
				self.cbomethods.List=self.SourceBrowse(self.cboclass.List[arg1]+".",getline=True,browse=self.browse2)
		except:
			pass
	def cbomethods_activated(self,arg1):
		try:
			if self.caller.finishjedi==True:
				y=self.browse2[self.cbomethods.List[arg1]]
				self.QSCI.setCursorPosition(y-1,0)
				self.QSCI.obj.setFocus()
				self.window().activateWindow()		
		except:
			pass
		
if __name__ == '__main__':
	import sys
	app = QtWidgets.QApplication(sys.argv)
	w = Handler()
	w.show()
	sys.exit(app.exec_())
