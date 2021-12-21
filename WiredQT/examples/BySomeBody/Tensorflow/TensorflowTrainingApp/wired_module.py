import time
import datetime
import os
from PyQt5.QtWidgets import *
from PyQt5.QtCore import *
from PyQt5 import QtCore, QtWidgets
from PyQt5.QtGui import * 
from PyQt5.Qsci import QsciScintilla, QsciLexerPython
from copy import deepcopy
try:
	import RPi.GPIO as GPIO
	GPIO.setmode(GPIO.BCM)
	GPIO.setwarnings(False)
	HIGH=GPIO.HIGH
	LOW=GPIO.LOW
	INPUT=GPIO.IN
	OUTPUT=GPIO.OUT
	INPUT_PULLUP=GPIO.PUD_UP
	def digitalWrite(pin,state):
		GPIO.output(pin,state)
	def digitalRead(pin):
		return HIGH if GPIO.input(pin) else LOW
	def pinMode(pin,direction):
		if direction==INPUT_PULLUP:
			GPIO.setup(pin,GPIO.IN,pull_up_down=GPIO.PUD_UP)
		else:
			GPIO.setup(pin,direction)
except:
	print ("")
def wtaprop():
	wtaprop=eval("{'Name': 'Label1', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '0', 'Width': '100', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': '[]', 'Height': '100', 'Left': '0', 'Tag': '', 'Text': 'Label1', 'Help': ''}")
	return deepcopy(wtaprop)
class TableModel(QtCore.QAbstractTableModel):
	def __init__(self, columnName,data):
		super(TableModel, self).__init__()
		self._data = data
		self._columnName = columnName
	def data(self, index, role):
		if role == Qt.DisplayRole:
			return self._data[index.row()][index.column()]
		if role == Qt.BackgroundRole:
			return QColor('#fcaeff')		
	def rowCount(self, index):
		return len(self._data)

	def columnCount(self, index):
		return len(self._data[0])
	def headerData(self, column, orientation, role=QtCore.Qt.DisplayRole):
		if role!=QtCore.Qt.DisplayRole:
			return QtCore.QVariant()
		if orientation==QtCore.Qt.Horizontal:
			return QtCore.QVariant(self._columnName[column]) 	
try:
	import ctypes
	user32 = ctypes.windll.user32
	screensize = [user32.GetSystemMetrics(0), user32.GetSystemMetrics(1)]
	resizeW=float(screensize[0]/1366.0)
	resizeH=float(screensize[1]/768.0)	
	print (screensize)
except:
	screensize = [1320, 768]
	resizeW=float(screensize[0]/1320.0)
	resizeH=float(screensize[1]/768.0)
	
def millis():
	return time.time()*1000
class Scheduler:
	def __init__(self,ms_timeout):
		self._ms_timeout=ms_timeout
		self._flag=False;
	def Start(self):
		self._startms=millis()
		self._flag=True;
	def Stop(self):
		self._flag=False;		
	def Event(self):
		buf=0;
		if(self._flag==False):
			return False;
		buf=millis()-self._startms;
		if(buf>=self._ms_timeout):
			self._flag=False;
			return True;
		else:
			return False;
def getCSV(x,delimiter,str_data):
	getCSVret = ""
	if(x<0):
		return ""       #if negative index
	b = 0
	while (x != 0):
		if (str_data[b] == delimiter):
			x = x - 1
		b = b + 1
	if(b>=len(str_data)):
		return ""       #if index out of range
	while ((str_data[b] != delimiter) and ((len(str_data)+1) != b)):
		getCSVret = getCSVret + str_data[b]
		b = b + 1
		if(b>=len(str_data)):
			break
	return getCSVret

def delay(x):
	time.sleep(x*1.0/1000)
def delayMicroseconds(x):

	time.sleep(x*1.0/1000000)

class LapTimer:
	def __init__(self):
		self.startms=millis();
		self.started=False;
	def start(self):
		self.started=True;
		self.startms=millis();
	def stop(self):
		self.started=False;
	def currTime(self):
		return millis()-self.startms;
class Poll(object):
	def __init__(self,search):
		self.currPointer=0
		self.size_st=len(search)
		self.st=search
	def Poll(self,x):
		if(self.st[self.currPointer]==x):
			self.currPointer=self.currPointer+1
		else:
			self.currPointer=0;
			if(self.st[self.currPointer]==x):		#WTF 
				self.currPointer=self.currPointer+1	#WTF				
		if(self.currPointer==self.size_st):
			self.currPointer=0
			return True
		return False	
'''
x=ParserLangguage(sequence="eat that")
word="dont\teat\r\t that\nball\r"        
t=x.Parse(word)
print(word[t[0]:])
print(word[t[1]:])
returns tuple of start and end if sequence is found in word
return None if not found
'''
class ParserLangguage:
	def __init__(self,sequence,wspace="\r\n\t \'\"("):
		self.sequence=sequence.split()
		self.poll=[]
		for a in self.sequence:
			_poll=Poll(a)
			self.poll.append(_poll)
		self.wspace=wspace

	def Parse(self,strings):
		curr_sequence=0
		strs=""
		start=0
		end=0
		for i,a in enumerate(strings):
			if a in self.wspace:
				#print(strs)
				if strs!="" and curr_sequence!=0:
					curr_sequence=0	#word not in order,reset curr_sequence
				strs=""
				continue
			strs+=a
			if self.poll[curr_sequence].Poll(a):
				
				if self.sequence[curr_sequence]==strs:
					#print(i,strs)
					#print strings[i+1:i+20]
					curr_sequence+=1
					if curr_sequence==1:
						start=i-len(strs)+1
					if curr_sequence==len(self.sequence):
						end=i+1
						return start,end 
					strs=""
					self.poll[curr_sequence].currPointer=0#bug to fix this
		return None			

class Parser():
	def __init__(self,_header,_terminator,numterminator,_sizeofdata=10):
		self.size=_sizeofdata
		self._numterminator=numterminator
		self._numterminatorbuf=0
		self.terminator=_terminator
		self.st=_header
		self.currPointer=0
		self.state=False
		self.size_st=len(_header);
	def Poll(self,x):
		if(self.st[self.currPointer]==x):
			self.currPointer=self.currPointer+1
		else:
			self.currPointer=0;
		if(self.currPointer==self.size_st):
			self.currPointer=0
			return True
		return False
	def available(self,x):
		if(self.Poll(x)==True):
			self.state=True
			#self.index=0
			self.data=""
			return False
		if(self.state):
			if(x==self.terminator or self.terminator==''):
				self._numterminatorbuf=self._numterminatorbuf+1
				if(self._numterminator==self._numterminatorbuf):
					self._numterminatorbuf=0
					#*(data+(index%size))=0;
					self.state=False;
					return True
			self.data=self.data+x
				#self.index++
		return False


def Map(x, in_min , in_max , out_min, out_max):
	return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min

def Constrain(amt, low, high):
	if (amt < low):
		amt = low
	if (amt > high):
		amt = high
	return amt



def GetFileSize(fname):
	fname=fname.replace('\\','/')
	return os.stat(fname).st_size
def GetFileStr(fname):
	fname=fname.replace('\\','/')
	fo = open(fname, "r+")
	str = fo.read(GetFileSize(fname))
	return str
def SaveFileStr(fname,str_to_write):
	fname=fname.replace('\\','/')
	fo = open(fname, "w")
	fo.write(str_to_write);
	fo.close()
def FileExist(fname):
	fname=fname.replace('\\','/')
	return os.path.exists(fname)
def ListAllFile():
	return filter(os.path.isfile, os.listdir('.')) 
def ListAllDir():
	return filter(os.path.isdir, os.listdir('.'))
def GetFilename(fname):
	fname=fname.replace('\\','/')
	ret=""
	for a in fname[::-1]:
		if a=='\\' or a=='/':
			break        
		ret+=a
	return ret[::-1]
def GetFilenameNoEXT(fname):
	
	strs=GetFilename(fname)
	ret=""
	for a in strs:
		if a=='.':
			break        
		ret+=a    
	return ret
def GetPath(fname):
	return os.path.dirname(fname)+"/"

def CreateFileName():
	s=time.localtime(time.time())
	return str(s.tm_mon) + '_'+str(s.tm_mday) + '_'+str(s.tm_year) + '_'+str(s.tm_hour) + '_'+str(s.tm_min) + '_'+str(s.tm_sec) 
def DateToString():
	s=time.localtime(time.time())
	return str(s.tm_mon) + '/'+str(s.tm_mday) + '/'+str(s.tm_year) 
def Date():
	s=time.localtime(time.time())
	return datetime.date(s.tm_year,s.tm_mon,s.tm_mday) 

def TimeToString():
	s=time.localtime(time.time())
	return str(s.tm_hour) + ':'+str(s.tm_min) + ':'+str(s.tm_sec)
def Time():
	s=time.localtime(time.time())
	return datetime.time(s.tm_hour,s.tm_min,s.tm_sec)
def Now():
	return datetime.datetime.now()
def NowToString():
	s=Now()
	return str(s.month) + "/" +str(s.day)  + "/" + str(s.year)  + " " +str(s.hour)  + ":" +str(s.minute)  + ":" +str(s.second)

def TimeInBetween(mintime,maxtime,curr):
	return (mintime<=curr) and (maxtime>=curr)





def refreshGTK():
	pass
def TrueFalse(val):
	if val in ['True',"False"]:
		if val=='True':
			return True
		else:
			return False
	return val	

def ExitApplication():
	#Gtk.main_quit()
	pass
class usercontrol(object):
	def __init__(self):
		a=0
		pass#self.usercontrol
	@property	
	def Top(self):
		return self.y()
	@Top.setter	
	def Top(self,value):
		self.move(self.x(),int(value))
	@property	
	def Left(self):
		return self.x()
	@Left.setter	
	def Left(self,value):
		self.move(value,self.y())
	@property	
	def Width(self):
		return self.width()
	@Width.setter	
	def Width(self,value):
		self.setFixedWidth(int(value))
	@property	
	def Height(self):
		'''fck'''
		return self.height()
	@Height.setter	
	def Height(self,value):
		'''fck'''
		self.setFixedHeight(int(value))
	@property	
	def Visible(self):
		return self.isVisible()
	@Visible.setter	
	def Visible(self,value):
		
		self.setVisible(TrueFalse(value))
	@property
	def Text(self):
		return self._text
	@Text.setter
	def Text(self,value):
		self._text=value  
		self.setWindowTitle(value)
def initUI(self,param,w=1366,h=768,title="WiredQT5.0",controlbox=True,startpos=(200,200),timeoutdestroy=-1):
	import os
	
	self.caller=None
	self.param=None
	if len(param)!=0:
		self.caller=param[0]
		if len(param)>1:
			self.param=param[1]		
	self.wiredevents={}
	self.setGeometry(startpos[0], startpos[1], w,h)
	self.setWindowTitle(title)
	if len(param)!=0:
		self.caller=param[0]
		if len(param)>1:
			self.param=param[1]	
	dir_path = os.path.dirname(os.path.realpath(__file__))
	os.chdir(dir_path)
	self.form_load=False
	self.timeoutdestroy=timeoutdestroy;
	self.setWindowIcon(QIcon('icon.png'))
def createWidget(self,prop,control,parent,event=[]):
	prop=eval(prop)
	name=prop["Name"]

	if prop['Tag']=='Activex':
		if control.find("/")!=-1:#plugin ActiveX
			import importlib.util
			spec = importlib.util.spec_from_file_location(GetFilenameNoEXT(control), control)
			foo = importlib.util.module_from_spec(spec)	
			spec.loader.exec_module(foo)
			exec("self.%s=foo.Handler(self)" % (name)) 
			
			control=GetFilenameNoEXT(control)
			
		else:	
			exec('import '+ control) 
			exec("self.%s=%s.Handler(self)" % (name,control))
		exec("self._%s=self.%s" % (name,name))
		exec("self.%sW=forms(self._%s)" % (name,name))
		exec("self.%s.objectName='%s'" % (name,name))
		for a in prop:
			usr_act=eval("self.%s"%(name))
			if hasattr(usr_act,a):
				try:
					exec("self.%s.%s='%s'"%(name,a,prop[a]))		
				except:
					a=a
	else:	
	
		exec("self._%s=%s()" % (name,control))
		exec("self._%s.objectName='%s'" % (name,name))
			
		exec("self.%s=forms(self._%s)" % (name,name))
	dontaltertextandcolor=["QScrollArea","QWidget"]	
	if (control in dontaltertextandcolor):
		control=control
		
		
	else:	
		exec("self.%s.Text='%s'"%(name,prop["Text"]))	
		if (control in dontaltertextandcolor)==False:
			
			prop["BackColor"]=prop["BackColor"].replace("(","");prop["BackColor"]=prop["BackColor"].replace(")","");
			exec("self.%s.BackColor=%s"%(name,prop["BackColor"]))			
			prop["ForeColor"]=prop["ForeColor"].replace("(","");prop["ForeColor"]=prop["ForeColor"].replace(")","");
			exec("self.%s.ForeColor=%s"%(name,prop["ForeColor"]))		
	if prop["Font"]!='':	
		exec("self.%s.Font='%s'"%(name,prop["Font"]))
	exec("self.%s.Enable=%s"%(name,TrueFalse(prop["Enable"])))
	
	if prop['Tag']=='Activex':
		exec("self.%sW.Dimension=%s"%(name,prop["Width"]+","+prop["Height"]))
		exec("self.%s.activeXcreated()"%(name))
		
	else:
		"self.%s.setParent(self);self.%s.Left=%s;self.%s.Top=%s;"%(name,name,prop["Left"],name,prop["Top"])#widget that has no parent,put it to our usercontrol
		if control=="QScrollArea" and 0:
			exec("self._%swid=QWidget()" % (name))
			exec("self._%s.setWidget(self._%swid)" % (name,name))
			exec("self._%swid.setFixedHeight(%s)" % (name,prop["Height"]))
			exec("self._%swid.setFixedWidth(%s)" % (name,prop["Width"]))
			exec("forms(self._%swid).Left=%s" % (name,0))
			exec("forms(self._%swid).Top=%s" % (name,0))
			exec("self._%swid.setVisible(True)" % (name))		
	
	if prop['ParentsType'] in ["QWidget","QGroupBox","QFrame","QScrollArea"]:
		cmd="self.%s.setParent(%s.obj)"%(name,parent)	
	elif prop['ParentsType'] in["QScrollArea"]:
		cmd="self.%s.setWidget(%s.obj)"%(name,parent)	
	else:
		if prop['Tag']=='Activex':
			cmd="self.%s.setParent(self);self.%s.Left=%s;self.%s.Top=%s;"%(name,name,prop["Left"],name,prop["Top"])#widget that has no parent,put it to our usercontrol
		else:
			cmd="self.%s.setParent(self);self.%s.Left=%s;self.%s.Top=%s;"%(name,name,prop["Left"],name,prop["Top"])#widget that has no parent,put it to our usercontrol
	

	exec(cmd)
	try:
		exec("self.%s.Width=%s;"%(name,prop["Width"]))
		exec("self.%s.Height=%s;"%(name,prop["Height"]))
		exec("self.%s.Top=%s;"%(name,prop["Top"]))
		exec("self.%s.Left=%s;"%(name,prop["Left"]))		
	except:
		pass
	if control=="QLabel":
		try:
			exec("self.%s.LoadPicture='%s'" % (name, prop['Picture']))
		except:
			pass
		
	event=eval(event)
	exec("self.%s.Visible=%s"%(name,TrueFalse(prop["Visible"])))
	for a in event:
		if prop['Tag']=='Activex':
			strs="self.%s.connect('%s',self.%s_%s)"%(name,a[0],name,a[0].replace('-','_'))
		else:
			strs="self._%s.%s.connect(self.%s_%s)"%(name,a[0],name,a[0].replace('-','_'))
		try:
				
			eval(strs)
		except:
			try:
				strs="self._%s.%s(self)"%(name,a[0])
				eval(strs)					
			except:	
				print("Unknown Signal '%s' for self._%s"%(a[0],name))
def setPicture (imgGTK,imgCV2):
	channel=1	
	import cv2
	if len(imgCV2.shape)==3:
		height, width, channel = imgCV2.shape
	if len(imgCV2.shape)==2:
		height, width = imgCV2.shape
	bytesPerLine = channel * width
	if channel==4:
		qImg = QImage(imgCV2.data, width, height, bytesPerLine, QImage.Format_ARGB32)
	if channel==3:
		qImg = QImage(imgCV2.data, width, height, bytesPerLine, QImage.Format_RGB888)
	if channel==1:
		qImg = QImage(imgCV2.data, width, height, bytesPerLine, QImage.Format_Grayscale8)

	imgGTK.setPixmap(QPixmap.fromImage(qImg));
	return imgCV2

def app_path():
	return os.path.dirname(os.path.realpath(__file__))			
class forms(object):
	def __init__(self,obj):
		self.obj=obj
		self.var=""
		self.cv=None
	def __getattr__(self,attr):#WTF!!! it took me a month to figure this out,. 
		#thanks goes to StackOverFlow and to their brilliant and very helpful users
		def wrapper(*args, **kw):
			#print('called with %r and %r' % (args, kw))
			return getattr(self.obj, attr)(*args, **kw)
		return wrapper		
	def SetFocus(self):
		pass	
	@property
	def Text(self):
		self.obj
		pass
	@Text.setter
	def Text(self,value):
		if type(value)==int or type(value)==float:
			value=str(value)
		pass
	@property
	def LoadPicture(self):		
		pass
	@LoadPicture.setter
	def LoadPicture(self,fname):
#		if type(self.obj)==Gtk.Image:
#			self.obj.set_from_file (fname)	
		if type(self.obj)==QLabel:
			self.obj.setAlignment(Qt.AlignCenter)
			pix=QPixmap()
			_fname=GetFilename(fname)
			if FileExist(_fname):
				fname=_fname
			if pix.load(fname):
				pix = pix.scaled(self.obj.size(),Qt.KeepAspectRatio)
				self.obj.setPixmap(pix)	
				#Use QImage to cv2
				import numpy as np
				import cv2
				tmp = QImage(pix)
				tmp = tmp.convertToFormat(4)
			
				width = tmp.width()
				height = tmp.height()
			
				ptr = tmp.bits()
				ptr.setsize(tmp.byteCount())
				arr = np.array(ptr).reshape(height, width, 4)  #  Copies the data
				self.cv= cv2.cvtColor(arr,cv2.COLOR_RGBA2BGR)				
			pass
	@property
	def LoadPictureNoResize(self):
		pass
	@LoadPicture.setter
	def LoadPictureNoResize(self,fname):
		pass
	def imread(self):
		return self.cv
	@property
	def LoadPictureOCV(self):		
		pass
	@LoadPicture.setter
	def LoadPictureOCV(self,imOCV):
		if type(self.obj)==QLabel:
			import cv2
			if len(imOCV.shape)==3:
				height, width, channel = imOCV.shape
				if channel==3:
					imOCV= cv2.cvtColor(imOCV,cv2.COLOR_BGR2RGB)
			self.cv=setPicture(self.obj,imOCV)	
	@property
	def Active(self):
		if hasattr(self.obj,"isChecked"):
			return self.obj.isChecked()
	@Active.setter
	def Active(self,value):
		if hasattr(self.obj,"isChecked"):
			self.obj.setChecked(TrueFalse(value))
	@property
	def Var(self):		
		return self.var
	@Var.setter
	def Var(self,value):
		self.var=value	
		
	@property
	def List(self):
		lst=[]
		for a in range(self.obj.count()):
			lst.append(self.obj.itemText(a))
		return lst
	@List.setter
	def List(self,value):
		self.obj.clear()		
		self.obj.addItems(value)		
	'''@property
	def LoadPictureOCV(self):		
		pass
	@LoadPicture.setter
	def LoadPictureOCV(self,imOCV):
		if type(self.obj)==Gtk.Image:
			setPicture(self.obj,imOCV)
	'''
	
	@property
	def ListIndex(self):	
		return self.obj.currentIndex()
		
	@ListIndex.setter	
	def ListIndex(self,index):
		self.obj.setCurrentIndex(index)
	@property
	def ListClear(self):
		pass
	@property
	def ForeColor(self):		#value=0.0, 1.0, 0.0, 1.0 #RGBA
		buf=self.obj.styleSheet()
		if buf=="":return
		a=buf.split(';')
		style=''
		for b in a:
			if b.find('color')!=1 and b.find('background')==-1 and b!='':
				ret=eval(b[b.find('('):])#return tuple
				ret=list(ret);ret[0]/=255;ret[1]/=255;ret[2]/=255;ret[3]/=255;
				return ret
		
		return (0,0,0,1)
	@ForeColor.setter
	def ForeColor(self,*value):		#value=0.0, 1.0, 0.0, 1.0
		if type(value[0])==str:
			value=[eval(value[0])]
		try:
			buf=self.obj.styleSheet()
			a=buf.split(';')
			style=''
			for b in a:
				if (b.find('color')==-1  or b.find('background')!=-1) and b!='':
					style+=b+";"
			x=255*value[0][0],255*value[0][1],255*value[0][2],255*value[0][3]
			bck='color:rgba'+str(x)+';'			
			style+=bck
			self.obj.setStyleSheet(style);   
		except:
			pass
		#self.obj.override_background_color(Gtk.StateFlags.NORMAL, Gdk.RGBA(value[0][0],value[0][1],value[0][2],value[0][3])) 
		pass
		pass
	@property
	def BackColor(self):		#value=0.0, 1.0, 0.0, 1.0 #RGBA
		buf=self.obj.styleSheet()
		a=buf.split(';')
		style=''
		for b in a:
			if b.find('background-color')!=-1:
				ret=eval(b[b.find('('):])#return tuple
				ret=list(ret);ret[0]/=255;ret[1]/=255;ret[2]/=255;ret[3]/=255;				
				return ret
		
		return (0,0,0,0)
	@BackColor.setter
	def BackColor(self,*value):		#value=0.0, 1.0, 0.0, 1.0
		if type(value[0])==str:
			value=[eval(value[0])]		
		try:
			buf=self.obj.styleSheet()
			a=buf.split(';')
			style=''
			for b in a:
				if b.find('background-color')==-1 and b!='':
					style+=b+";"
			x=int(255*value[0][0]),int(255*value[0][1]),int(255*value[0][2]),int(255*value[0][3])
			bck='background-color:rgba'+str(x)+';'			
			style+=bck
			self.obj.setStyleSheet(style);   
		except:
			pass
		#self.obj.override_background_color(Gtk.StateFlags.NORMAL, Gdk.RGBA(value[0][0],value[0][1],value[0][2],value[0][3])) 
		pass

	@property 
	def Enable(self):		#value=0.0, 1.0, 0.0, 1.0 #RGBA
		return self.obj.isEnabled()
	@Enable.setter
	def Enable(self,value):		#value=0.0, 1.0, 0.0, 1.0
		self.obj.setEnabled(TrueFalse(value))
		pass#self.obj.set_sensitive(value)
	def Move(self,xy):		
		pass
	def Location(self):		#value=0.0, 1.0, 0.0, 1.0 #RGBA
		pass
	@property
	def Dimension(self):
		return forms(self.obj).Width,forms(self.obj).Height	
	@Dimension.setter
	def Dimension(self,wh):
		forms(self.obj).Width=int(wh[0])
		forms(self.obj).Height=int(wh[1])
		pass
	
	@property
	def Font(self):
		pass
	@Font.setter
	def Font(self,font):
		try:
			_font=font.split(' ')
			font=font.replace(" " + _font[-1],"")
			size=10
			try:size=int(_font[-1])
			except:pass
			self.obj.setFont(QFont(font,size))#font='Dejavu Sans Mono 20'	
		except:
			pass
	@property	
	def Top(self):
		return self.obj.y()
	@Top.setter	
	def Top(self,value):
		try:
			self.obj.move(self.obj.x(),int(value))
		except:
			pass
	@property	
	def Left(self):
		return self.obj.x()
	@Left.setter	
	def Left(self,value):
		try:
			self.obj.move(int(value),self.obj.y())
		except:
			pass
	@property	
	def Width(self):
		return self.obj.width()
	@Width.setter	
	def Width(self,value):
		self.obj.setFixedWidth(int(value))
	@property	
	def Height(self):
		return self.obj.height()
	@Height.setter	
	def Height(self,value):
		self.obj.setFixedHeight(int(value))
	@property	
	def Visible(self):
		return self.obj.isVisible()
	@Visible.setter	
	def Visible(self,value):
		try:
			self.obj.setVisible(TrueFalse(value))
		except:
			pass
	@property
	def Text(self):
		try:
			if type(self.obj)==QTextEdit:
				return self.obj.toPlainText()
			if type(self.obj)==QComboBox:
				return self.obj.currentText()	
			if type(self.obj)==QCheckBox:
				return str(self.obj.isChecked())
			return self.obj.text()
		except:
			return ""
		
		
	@Text.setter
	def Text(self,value):
		try:
			if type(self.obj)==QComboBox:
				self.obj.setCurrentText(value)
				return
			if type(self.obj)==QCheckBox:
				self.obj.setChecked(TrueFalse(value))
				return
			self.obj.setText(value)	
		except:
			pass

	@property
	def ComboValues(self):
		pass
	@ComboValues.setter			#=['123','456',1024]
	def ComboValues(self,listvalues):
		pass

	@property
	def ComboClear(self):
		pass

	@property
	def Alignment(self):		
		pass
	@Alignment.setter
	def Alignment(self,value):
		if value=='LEFT' or value=='':
			value=0
		if value=='CENTER':
			value=0.5			
		if value=='RIGHT':
			value=1	
		pass
	'''
		if type(self.obj)==Gtk.Entry:
			self.obj.set_alignment (value)
		if type(self.obj)==Gtk.Label:
			_,y=self.obj.get_alignment ()			
			self.obj.set_alignment (value,y)			
				
	'''




