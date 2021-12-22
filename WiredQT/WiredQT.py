from PyQt5 import QtCore, QtWidgets
from PyQt5.QtGui import * 
from wired_module import * 
import WiredQT5GUI
from copy import deepcopy
import jedi
from _thread import *
#	Generated By WiredQT for Python: by Rocky Nuarin, 2021 Phils
class Handler(QtWidgets.QWidget,usercontrol):
	def __init__(self, *param):    
		super(Handler, self).__init__(None)
		initUI(self,param,w=1366,h=768,title="WiredQT v1.0",controlbox=True,startpos=(0,30),timeoutdestroy=-1)
		self.GTKForms()
		self.timer=QtCore.QTimer()
		self.timer.timeout.connect(self.loop)
		self.timer.start(10)       

		self.sch=Scheduler(100)#500 ms
		self.sch.Start()
		self.windows={}
		self.copied=None
		self.current_debug=None
		self.filename=""
		self.PutICON()
		self.jedi=jedi
		self.jedimodule={}
		if FileExist("intelisense.txt"):
			strs=GetFileStr("intelisense.txt")
			self.jedimodule=eval(strs)
		a=0	
	def _showhelp(self,code,word,x,y,wordline,jedimodule,path=""):
		#print(word,y)
		def extractlst(lst,x,module_name=""):
			suggest=script.complete(y,x+1)
			
			try:
				
				for i,sug in enumerate(suggest):
					if sug.module_name=="__main__" or sug.module_name==module_name or module_name=="":
						sug_name=sug.name	
						strs=sug.name
						if len(sug_name)>0:	
							if len(sug._get_signatures()):
								try:
									#print(1,strs)
									strs=sug._get_signatures()[0].to_string()
									if strs.find("*")!=-1:#member obj of type class(eg forms)
										strs=sug.name
									#print(2,strs)
								except:
									pass
								if (strs in lst)==False:
									lst.append(strs)
							else:
								lst.append(sug_name)
				'''
				if wordline.find("self.")!=-1 and wordline!="self.":
					rem=eval(GetFileStr("self.txt"))
					for a in rem:
						if a in lst:
							lst.remove(a)
				'''				                        
			except AssertionError:
				print("jedi parser warning occur!!!")
	
		def getvardefinition(target,_x):    
			x=target[-1::-1].find(".")
			if x!=-1:
				target=target[0:len(target)-x-1]
				return target,_x-x-1
			return "",-1
			
		print("jedi thingking")
		sys_path =jedi.get_default_environment().get_sys_path()
		if jedi.__version__!="0.18.0":
			script=jedi.Script(source=code,sys_path=sys_path+ [path] )
		else:	
			script=jedi.Script(code,path=path,environment=jedi.get_default_environment())
			#script=jedi.Script(code,path="")
		cc=getvardefinition(wordline, x)
		lst=[]
		try: 	#fixme, x doesnt point to exact cursor location like eg x.available where cursor is in between i and l
			if cc[1] !=-1 and word=='':
				modulename=script.infer(y,cc[1])
				modulename=modulename[0]
				if str(modulename)!='[]':
					if (modulename.module_name in jedimodule)==False:
						try:
							extractlst(lst,x-1,modulename.module_name)
							modulenotinfolder=False
							index=str(modulename).find("module ")
							if index!=-1: 
								fname=str(modulename)[index+len("module "):-3]
								if FileExist(fname+".py")==False:
									modulenotinfolder=True
							if str(modulename)!="" and modulenotinfolder==True:#add only if module not in project directory eg numpy etc
								
								jedimodule.update({modulename.module_name:lst})
								SaveFileStr("intelisense.txt", str(jedimodule))
								pass							
						except:
							pass
					else:
						lst=jedimodule[modulename.module_name]
			else:
				extractlst(lst,x-1)	
		except:
			QApplication.restoreOverrideCursor()
			return [],""
		print("finish jedi")
		
		return lst,""#cc[0]		
	def showhelp(self,code,word,x,y,wordline,path=""):
		ret=self._showhelp(code,word,x,y,wordline,jedimodule=self.jedimodule,path=path)
		return ret
	def NewWIndow(self,filename,purescript=False):	
		QApplication.setOverrideCursor(Qt.WaitCursor)
		#hide all opened Project/Script
		for a in self.windows:
			forms(self.windows[a]).Visible=False
		self.filename=filename	
		#Dynamically Load WiredQT5GUI to this forms
		x=WiredQT5GUI.Handler(self)
		
		y=x.Widget()
		y.setParent(self)
		y.Width=self.Width
		y.Height=self.Height
		x.setfilename(filename,purescript) 
		forms(x).Visible=True
		#self.windows dictionary memorize opened windows
		self.windows.update({filename:x})
		
		self.QLabel12.Visible=False
		if self.windows[self.filename].IsQTForms()==False:
			self.windows[self.filename].QSCIShow(True)
			self.windows[self.filename].Designer.Enable=False
			self.windows[self.filename].Designer.ForeColor=(0.5,0.5,0.5,1)
		self.jedi=jedi	
		QApplication.restoreOverrideCursor()
	def PutICON(self):
		def doit(p,image):
			if FileExist("images/"+image):
				pixmap=QPixmap("images/"+image)
				ButtonIcon=QIcon(pixmap)
				p.setIcon(ButtonIcon)
				p.setIconSize(pixmap.rect().size())
				forms(p).Text=""
				p.setToolTip(image[0:image.find(".")])
				
		doit(self.New_Script.obj,"new_script.png")
		doit(self.New_Forms.obj,"new_forms.png")
		doit(self.cutWid.obj,"cut.png")
		doit(self.copyWid.obj,"copy.png")
		doit(self.pasteWid.obj,"paste.png")
		doit(self.DB.obj,"db.png")
		doit(self.OpenFile.obj,"open.png")
		doit(self.Close.obj,"close.png")
		doit(self.Save.obj,"save.png")
		doit(self.Saveas .obj,"saveas.png")
		doit(self.example.obj,"example.png")
		doit(self.QPushButton7.obj,"explore.png")
	def createwidget(self,prop,control,parent,event=[]):
		createWidget(self,prop,control,parent,event)         
	def GTKForms(self):
		self.createwidget("{'Picture': '', 'ForeColor': '(0,0,0,1)', 'Name': 'example', 'Events': '[clicked]', 'Enable': 'True', 'Tag': '', 'Width': '30', 'Help': '', 'Text': '<>', 'Height': '30', 'Left': '408', 'Var': '', 'Font': '', 'Top': '0', 'BackColor': '(1,1,1,0.25)', 'ParentsType': '', 'Visible': 'True'}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Picture': '', 'Name': 'Save', 'Events': '[clicked]', 'Enable': 'True', 'Tag': '', 'Width': '30', 'Help': '', 'Text': 'Save', 'Height': '30', 'Left': '105', 'Var': '', 'Font': 'None', 'Top': '0', 'Visible': 'True', 'BackColor': '[1.0, 1.0, 1.0, 0.24705882352941178]', 'ParentsType': '', 'ForeColor': '[0.0, 0.0, 0.0, 1.0]'}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Picture': '', 'Name': 'copyWid', 'Events': '[clicked]', 'Enable': 'True', 'Tag': '', 'Width': '30', 'Help': '', 'Text': 'Copy', 'Height': '30', 'Left': '290', 'Var': '', 'Font': '', 'Top': '0', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'ParentsType': '', 'ForeColor': '(0,0,0,1)'}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Picture': '', 'Name': 'New_Forms', 'Events': '[clicked]', 'Enable': 'True', 'Tag': '', 'Width': '30', 'Help': '', 'Text': 'New Forms', 'Height': '30', 'Left': '36', 'Var': '', 'Font': 'None', 'Top': '0', 'Visible': 'True', 'BackColor': '[1.0, 1.0, 1.0, 0.24705882352941178]', 'ParentsType': '', 'ForeColor': '[0.0, 0.0, 0.0, 1.0]'}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Picture': '', 'Name': 'Close', 'Events': '[clicked]', 'Enable': 'True', 'Tag': '', 'Width': '30', 'Help': '', 'Text': 'Close Project', 'Height': '30', 'Left': '222', 'Var': '', 'Font': '', 'Top': '0', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'ParentsType': '', 'ForeColor': '(0,0,0,1)'}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Picture': 'appimage.png', 'Name': 'QLabel12', 'Events': [], 'Enable': 'True', 'Tag': '', 'Width': '1080', 'Help': '', 'Text': '', 'Height': '700', 'Left': '0', 'Var': '', 'Font': '', 'Top': '32', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'ParentsType': '', 'ForeColor': '(0,0,0,1)'}",'QLabel','usercontrol',"[]")
		self.createwidget("{'Picture': '', 'Name': 'QFileDialog', 'Events': [], 'Enable': 'True', 'Tag': '', 'Width': '100', 'Help': '', 'Text': '', 'Height': '100', 'Left': '724', 'Var': '', 'Font': 'None', 'Top': '38', 'Visible': 'False', 'BackColor': '[1.0, 1.0, 1.0, 0.24705882352941178]', 'ParentsType': '', 'ForeColor': '[0.0, 0.0, 0.0, 1.0]'}",'QFileDialog','usercontrol',"[]")
		self.createwidget("{'Picture': '', 'Name': 'QComboBox3', 'Events': '[activated]', 'Enable': 'True', 'Tag': '', 'Width': '316', 'Help': '', 'Text': '', 'Height': '22', 'Left': '501', 'Var': '', 'Font': '', 'Top': '0', 'Visible': 'True', 'BackColor': '[1.0, 1.0, 1.0, 0.24705882352941178]', 'ParentsType': '', 'ForeColor': '[0.0, 0.0, 0.0, 1.0]'}",'QComboBox','usercontrol',"[['activated', 'self,arg1']]")
		self.createwidget("{'Picture': '', 'Name': 'New_Script', 'Events': '[clicked]', 'Enable': 'True', 'Tag': '', 'Width': '30', 'Help': '', 'Text': 'New Script', 'Height': '30', 'Left': '0', 'Var': '', 'Font': 'None', 'Top': '0', 'Visible': 'True', 'BackColor': '[1.0, 1.0, 1.0, 0.24705882352941178]', 'ParentsType': '', 'ForeColor': '[0.0, 0.0, 0.0, 1.0]'}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Picture': '', 'Name': 'QPushButton7', 'Events': '[clicked]', 'Enable': 'True', 'Tag': '', 'Width': '30', 'Help': '', 'Text': 'Open Project Folder', 'Height': '30', 'Left': '187', 'Var': '', 'Font': 'None', 'Top': '0', 'Visible': 'True', 'BackColor': '[1.0, 1.0, 1.0, 0.24705882352941178]', 'ParentsType': '', 'ForeColor': '[0.0, 0.0, 0.0, 1.0]'}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Picture': '', 'ForeColor': '(0,0,0,1)', 'Name': 'DB', 'Events': '[clicked]', 'Enable': 'True', 'Tag': '', 'Width': '30', 'Help': '', 'Text': 'DB', 'Height': '30', 'Left': '444', 'Var': '', 'Font': '', 'Top': '0', 'BackColor': '(1,1,1,0.25)', 'ParentsType': '', 'Visible': 'True'}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Picture': '', 'Name': 'pasteWid', 'Events': '[clicked]', 'Enable': 'True', 'Tag': '', 'Width': '30', 'Help': '', 'Text': 'Paste', 'Height': '30', 'Left': '359', 'Var': '', 'Font': '', 'Top': '0', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'ParentsType': '', 'ForeColor': '(0,0,0,1)'}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Picture': '', 'Name': 'OpenFile', 'Events': '[clicked]', 'Enable': 'True', 'Tag': '', 'Width': '30', 'Help': '', 'Text': 'Open File', 'Height': '30', 'Left': '71', 'Var': '', 'Font': 'None', 'Top': '0', 'Visible': 'True', 'BackColor': '[1.0, 1.0, 1.0, 0.24705882352941178]', 'ParentsType': '', 'ForeColor': '[0.0, 0.0, 0.0, 1.0]'}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Picture': '', 'Name': 'Saveas', 'Events': '[clicked]', 'Enable': 'True', 'Tag': '', 'Width': '30', 'Help': '', 'Text': 'Save as', 'Height': '30', 'Left': '140', 'Var': '', 'Font': 'None', 'Top': '0', 'Visible': 'True', 'BackColor': '[1.0, 1.0, 1.0, 0.24705882352941178]', 'ParentsType': '', 'ForeColor': '[0.0, 0.0, 0.0, 1.0]'}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Picture': '', 'Name': 'cutWid', 'Events': '[clicked]', 'Enable': 'True', 'Tag': '', 'Width': '30', 'Help': '', 'Text': 'Cut', 'Height': '30', 'Left': '325', 'Var': '', 'Font': '', 'Top': '0', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'ParentsType': '', 'ForeColor': '(0,0,0,1)'}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
	def Widget(self):
		return self 

	def loop(self):
		if self.form_load==False:
			start_new_thread(self.activeXcreated,(None,))
			self.form_load=True
		if self.sch.Event():#timer routine
			if self.current_debug==None:
				
				for a in self.windows:
					if self.windows[a].stepin.Enable:
						self.disabledebugcontrol(a,'stepin')
						self.disabledebugcontrol(a,'stepout')
						self.disabledebugcontrol(a,'stepover')
						self.disabledebugcontrol(a,'where')
						self.disabledebugcontrol(a,'goto')
						self.disabledebugcontrol(a,'breakpoint')
						self.disabledebugcontrol(a,'resume')
			#code here
			if self.timeoutdestroy!=-1:
				self.timeoutdestroy-=1
				if self.timeoutdestroy==0:
					pass#self.unload(None)
			self.sch.Start()#restart scheduler      
		
	def connect(self,ev,evusr):
		self.wiredevents.update({ev:evusr})     
	def activeXcreated(self,*args):
		self.finishjedi=False
		print("start jedi on wiredQT.py")
		ret=self.showhelp("import numpy\nnumpy.", "", 6, 2, "numpy.")
		self.finishjedi=True
		print("Finish jedi on wiredQT.py")
	def eventFilter(self, obj, event):
		return super(Handler, self).eventFilter(obj, event)
	def refreshCombo(self):
		lst=[]
		for a in self.windows:
			lst.append(a)
		self.QComboBox3.List=lst
		self.QComboBox3.Text=self.filename

	def Save_clicked(self,arg1):
		if len(self.windows)==0:return
		self.windows[self.filename].save()	
		pass
	def Saveas_clicked(self,arg1):
		if len(self.windows)==0:return
		name = self.QFileDialog.getSaveFileName(self, 'Save File')
		if name[0]=='':return
		if FileExist(name[0]):
			print('over write',name[0])
		fname=GetPath(name[0]) + GetFilenameNoEXT(name[0])+'.py'	
		self.windows[self.filename].saveas(fname)
		buf={}
		lst=[]
		for a in self.windows:
			if a!=self.filename:
				buf.update({a:self.windows[a]})
				lst.append(a)	
			else:
				buf.update({fname:self.windows[a]})
				lst.append(fname)	
		self.windows=buf
		self.QComboBox3.List=lst
		self.QComboBox3.Text=fname
		a=0		
		pass

	def OpenFile_clicked(self,arg1):
		if self.filename!="":
			path=GetPath(self.filename)
		else:
			path=os.path.expanduser('~')
		self.QFileDialog.obj.setDirectory(path)
		
		ret=self.QFileDialog.obj.getOpenFileName()

		a=GetFilename(ret[0])
		if a=="":return
		if (ret[0] in self.windows)==False :

			self.NewWIndow(ret[0])

			self.refreshCombo()
		self.showdebugbutton()	
		self.backup(self.filename)

	def copyDependencies(self,saveasFname):
		from shutil import copyfile
		if FileExist(GetPath(saveasFname) + '/wired_module.py')==False and GetPath(saveasFname).find('plugin')==-1 and GetPath(saveasFname).find('examples')==-1:
			copyfile('properties/wired_module.py', GetPath(saveasFname) + 'wired_module.py')
			copyfile('properties/icon.png', GetPath(saveasFname) + 'icon.png')
			
		copyfile('properties/template.py', GetPath(saveasFname) +GetFilename(saveasFname))
			
		if GetPath(saveasFname).find('plugin')!=-1 or GetPath(saveasFname).find('examples')!=-1:
			msgbox(None, "Cant save to this folder, Choose another folder and save ", "WiredGTK Error")
	def QPushButton7_clicked(self,arg1):
		if len(self.windows)==0:return
		import webbrowser
		
		webbrowser.open(GetPath(self.filename))

		pass			
	def New_Script_clicked(self,arg1):
		

		self.Newformscript(True)
	def New_Forms_clicked(self,arg1):

		self.Newformscript(False)

	def Newformscript(self,purescript):
		if self.filename!="":
			path=GetPath(self.filename)
		else:
			path=os.path.expanduser('~')
		self.QFileDialog.obj.setDirectory(path)
		name = self.QFileDialog.getSaveFileName(self, 'Save File')

		if name[0]=='':return

		if FileExist(name[0]):

			print('over write',name[0])

		fname=GetPath(name[0]) + GetFilenameNoEXT(name[0])+'.py'	
		
		if purescript==False:
			self.copyDependencies(fname)

		if (name in self.windows)==False :

			self.NewWIndow(fname,purescript)

			self.refreshCombo()		

		self.QLabel12.Visible=False
		self.showdebugbutton()
		pass
	def QComboBox3_activated(self,arg1):
		if arg1=="":
			self.QLabel12.Visible=True
			return
		for a in self.windows:

			self.windows[a].Visible=False
		if type(arg1)==int:
			strs=self.QComboBox3.List[arg1]
		else:
			#pdb problem with filename always in lower case
			windows=[a.lower() for a in list(self.windows.keys())]
			windowsRetainCase=list(self.windows.keys())			
			index=windows.index(arg1.lower())
			strs=windowsRetainCase[index]
			self.QComboBox3.ListIndex=index
		
		
				
		if len(self.windows):	
			self.windows[strs].Visible=True
		self.filename=strs
		self.QLabel12.Visible=False
		if self.windows[strs].IsQTForms()==True and self.windows[strs].QSCI.Visible==True:
			self.windows[strs].Designer.Enable=True
			self.windows[strs].Designer.ForeColor=(0,0,1,1)
		if self.windows[strs].QSCI.Visible==True:
			self.windows[strs].Break_PDB.Enable=True
			self.windows[strs].Break_PDB.ForeColor=(0,0,1,1)
		else:
			self.windows[strs].Break_PDB.Enable=False
		self.showdebugbutton()
		pass
	def copyproperties(self,a,ctrl):
		strs='self.windows[a].'+ctrl+'.Enable=self.current_debug.'+ctrl+'.Enable'
		exec(strs)
		strs='self.windows[a].'+ctrl+'.ForeColor=self.current_debug.'+ctrl+'.ForeColor'
		exec(strs)
	def disabledebugcontrol(self,a,ctrl):
		strs='self.windows[a].'+ctrl+'.Enable=False'
		exec(strs)
	def showdebugbutton(self):
		if self.current_debug==None:return
					
		
		for a in self.windows:
			if self.windows[a]!=self.current_debug or True:
				self.copyproperties(a,'run')
				self.copyproperties(a,'stop')
				self.copyproperties(a,'stepin')
				self.copyproperties(a,'stepout')
				self.copyproperties(a,'stepover')
				self.copyproperties(a,'breakpoint')
				self.copyproperties(a,'goto')
				self.copyproperties(a,'where')
				self.copyproperties(a,'resume')
				
	def updateAllOutputPane(self):
		for a in self.windows:
			if self.windows[a]!=self.current_debug:
				self.windows[a].OutputPane.Text=self.current_debug.OutputPane.Text
				self.windows[a].OutputPane.obj.setCursorPosition(self.windows[a].OutputPane.obj.lines(),1)
					
	def Close_clicked(self,arg1):
		if len(self.windows)==0:
			self.QLabel12.Visible=True
			return
		for a in self.windows:#remove dict
			if a==self.filename:
				currwin=self.windows.pop(a)
				
				break
		x=self.QComboBox3.List
		lst=[]
		for a in x:
			if a!=self.filename:
				lst.append(a)
		currwin.Visible=False
		self.QComboBox3.List=lst
		self.QComboBox3_activated(self.QComboBox3.Text)
		pass
	def copyWid_clicked(self,arg1):
		if len(self.windows)==0:return
		x=self.windows[self.filename].objectMove.lst
		lst=[]
		for a in x:
			if x[a].selected:
				prop=eval(x[a].prop)
				prop.update({"Left":str(forms(x[a].name).Left+20)})
				prop.update({"Top":str(forms(x[a].name).Top)})
				prop.update({"Width":str(forms(x[a].name).Width)})
				prop.update({"Height":str(forms(x[a].name).Height)})				
				try:
					_type=str(type(x[a].name)).split("'")[1].split('.')[2]#regular widget
				except:
					try:
						_type=str(type(x[a].name)).split("'")[1].split('.')[0]#activeX widget
					except:pass
				lst.append([_type,prop])
		self.copied=lst		
		pass
	def cutWid_clicked(self,arg1):
		if len(self.windows)==0:return
		x=self.windows[self.filename].objectMove.lst
		lstdel=[]
		lst=[]
		for a in x:
			if x[a].selected:
				prop=eval(x[a].prop)
				prop.update({"Left":str(forms(x[a].name).Left)})
				prop.update({"Top":str(forms(x[a].name).Top)})				
				lstdel.append(a)
				try:
					_type=str(type(x[a].name)).split("'")[1].split('.')[2]#regular widget
				except:
					try:
						_type=str(type(x[a].name)).split("'")[1].split('.')[0]#activeX widget
					except:pass
				lst.append([_type,prop])
		self.copied=lst		
		for a in lstdel:
			self.windows[self.filename].objectMove.delete(a)		
		pass
	def pasteWid_clicked(self,arg1):
		if len(self.windows)==0:return
		if self.copied!=None:
			for a in self.copied:
				self.windows[self.filename]._butP(a[0],a[1])
		pass
	def example_clicked(self,arg1):
		#self.QFileDialog.obj.setWindowTitle("Select Example WireQT app")
		self.QFileDialog.obj.setDirectory(app_path()+"/examples/BySomeBody")
		ret=self.QFileDialog.obj.getOpenFileName()
		a=GetFilename(ret[0])
		if a=="":return		
		path=GetPath(ret[0])
		x=WiredQT5GUI.Handler(self)
		
		#self.QFileDialog.obj.setWindowTitle("Destination Folder")
		self.QFileDialog.obj.setDirectory(os.path.expanduser('~'))
		dest=self.QFileDialog.obj.getExistingDirectory()
		
		if dest=="":return		
		from shutil import copyfile
		x.copyall(GetPath(ret[0]), dest+"/")
		copyfile(app_path()+"/properties/wired_module.py", dest+"/wired_module.py")
		copyfile(app_path()+"/properties/icon.png", dest+"/icon.png")
		x.getdependencies(ret[0],dest)
		self.NewWIndow(dest+"/" + GetFilename(ret[0]))
		
		self.refreshCombo()		
		pass
	def backup(self,fname):#march 2019
		path=GetPath(fname).replace('\\','/')+'backup'
		if os.path.isdir(path)==False:
			os.mkdir(path)
		_fname=GetFilenameNoEXT(fname)
		if FileExist(fname):
			SaveFileStr(path+"/"+_fname+CreateFileName()+'.py', GetFileStr(fname))		
	def DB_clicked(self,arg1):
		pass
	def _resizeEvent(self):
		#print(self.Width,self.Height)
		try:
			for a in self.windows:
			
				forms(self.windows[a].sa).Height=self.Height-forms(self.windows[a]._xEntry1x).Height-forms(self.windows[a].OutputPane).Height-forms(self.windows[a].sa).Top-30
				forms(self.windows[a]._xEntry1x).Top=forms(self.windows[a].sa).Top+forms(self.windows[a].sa).Height#+self.windows[a].QSCI.Top
				forms(self.windows[a].OutputPane).Top=forms(self.windows[a]._xEntry1x).Top+forms(self.windows[a]._xEntry1x).Height
				forms(self.windows[a].gui.scrollArea).Height=self.Height-80
				forms(self.windows[a].propertyEditor.scrollArea).Height=forms(self.windows[a].gui.scrollArea).Height
				
				forms(self.windows[a].gui.scrollArea).Left=self.Width-forms(self.windows[a].gui.scrollArea).Width
				forms(self.windows[a].sa).Width=forms(self.windows[a].gui.scrollArea).Left-forms(self.windows[a].sa).Left
				forms(self.windows[a]._xEntry1x).Width=forms(self.windows[a].gui.scrollArea).Left-forms(self.windows[a].sa).Left
				forms(self.windows[a].OutputPane).Width=forms(self.windows[a].gui.scrollArea).Left-forms(self.windows[a].sa).Left
				
				self.windows[a].QSCI.Width=forms(self.windows[a].sa).Width
				self.windows[a].QSCI.Height=forms(self.windows[a].sa).Height-30#bcoz of cboclass n cbomethods
		except:
			pass
		
	def resizeEvent(self, event):
		self._resizeEvent()
		return super(Handler, self).resizeEvent(event)	
if __name__ == '__main__':
	import sys
	app = QtWidgets.QApplication(sys.argv)
	w = Handler()
	w.show()
	sys.exit(app.exec_())
