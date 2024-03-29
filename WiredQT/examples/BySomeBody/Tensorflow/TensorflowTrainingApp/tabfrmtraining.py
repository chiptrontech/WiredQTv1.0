from PyQt5 import QtCore, QtWidgets
from PyQt5.QtWidgets import * 
from PyQt5.QtGui import * 
from wired_module import *
import cv2

#	Super Easy Tensorflow Training Dataset written by: Rocky Nuarin

#	2020 WiredGTK version ported to WiredQT 2021 

#	manila phillines




#	Generated By WiredQT for Python: by Rocky Nuarin, 2021 Phils
try:
	import thread
except ImportError:
	import _thread as thread

def backonefolder(fname):
	x=fname
	x=x.replace("\\",'/')
	y=''
	for a in x[::-1]:
		if a=="/":break
		y+=a
	
	return fname.replace("/" + y[::-1],"")


class Handler(QtWidgets.QWidget,usercontrol):	
	def __init__(self, *param):    
		super(Handler, self).__init__(None)		
		initUI(self,param,w=1366,h=768,title="Tensorflow Super Easy Training Dataset - WiredQT",controlbox=True,startpos=(0,30),timeoutdestroy=-1)
		self.GTKForms()
		self.timer=QtCore.QTimer()
		self.timer.timeout.connect(self.loop)
		self.timer.start(10)    
		self.sch=Scheduler(500)#500 ms
		self.sch.Start()

		self.Execute=0		
		self.ExecuteNext=1
		
		self.classes=[]
		self.ComboBoxText1.List=["faster_rcnn_inception_v2","ssd_mobilenet_v1"]
		self.RadioButton1.Active=True
		self.setpythonpath()
		self.lastclasses=0
		self.msg=QMessageBox()
		a=0
	def setpythonpath(self):
		import platform
		import sys
		if platform.system()!="Windows":
			python_name="python3"
		else:
			python_name="python.exe"				
		#get path of python, currently running python that execute this WiredQT
		python_path=os.path.dirname(sys.executable)#
		#print(python_path+"/"+python_name)
		self.Label3.Text=python_path.replace("\\","/")+"/"+python_name				
	def connect(self,ev,evusr):
		self.wiredevents.update({ev:evusr})
	def activeXcreated(self,*args):
		pass
	
	def loop(self):
		if self.form_load==False:
			self.form_load=True
		if self.Execute==1:
			#train_labels.csv,test_labels.csv creation
			os.chdir(self.projectpath)
			py3=self.Label3.Text
			cmdlst=[py3,"-u",self.projectpath +"/xml_to_csv.py"]
			self.ctlExecCommand1.ExecCommand(cmdlst)		
			self.Execute=0		
			self.ExecuteNext+=1

		if self.Execute==2:
			#train_labels.csv,test_labels.csv creation
			os.chdir(self.projectpath)
			py3=self.Label3.Text
			path=py3
			path=path.replace("\\python.exe",'')
									
			paths=[]
			os.environ["PATH"]=""
			if os.environ["PATH"].find(path)==-1:
				os.environ["PATH"]+=";"+path+";"
				
			paths=['Library\\mingw-w64\\bin','Library\\usr\\bin','Library\\bin','Scripts','bin']
			for a in paths:
				if FileExist(path+'\\' + a) and os.environ["PATH"].find(path+'\\' + a)==-1:
					os.environ["PATH"]+=path+'\\' + a +";"

			cmdlst=[py3,"-u",self.projectpath +"/generate_tfrecord.py","--csv_input=images/train_labels.csv","--image_dir=images/train","--output_path=train.record"]
			self.ctlExecCommand1.ExecCommand(cmdlst)		
			self.Execute=0
			self.ExecuteNext+=1
		if self.Execute==3:
			#train_labels.csv,test_labels.csv creation
			os.chdir(self.projectpath)
			py3=self.Label3.Text
		
			cmdlst=[py3,"-u",self.projectpath +"/generate_tfrecord.py","--csv_input=images/test_labels.csv","--image_dir=images/test","--output_path=test.record"]
			self.ctlExecCommand1.ExecCommand(cmdlst)		
			self.Execute=0
			self.ExecuteNext+=1
			
		if self.sch.Event():#timer routine
			#code here
			if self.timeoutdestroy!=-1:
				self.timeoutdestroy-=1
				if self.timeoutdestroy==0:
					self.unload(None)
			self.sch.Start()#restart scheduler
		return True	#return true so that main_loop can call it again 	
	def createwidget(self,prop,control,parent,event=[]):
		createWidget(self,prop,control,parent,event)
	def GTKForms(self):
		self.createwidget("{'Width': '50', 'Enable': 'True', 'Picture': '', 'Name': 'Button10', 'BackColor': '(1,1,1,1)', 'Var': '', 'Height': '30', 'ForeColor': '[1.0, 0.0, 0.0, 1.0]', 'Help': '', 'Top': '343', 'Visible': 'True', 'ParentsType': '', 'Text': 'clear', 'Left': '834', 'Tag': '', 'Events': '[clicked]', 'Font': ''}",'QPushButton','usercontrol',"[['clicked', 'self,e'], ['clicked', 'self,arg1'], ['released', 'self']]")
		self.createwidget("{'Events': '[clicked]', 'Width': '100', 'Name': 'Button7', 'Picture': '', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Var': '', 'ParentsType': '', 'Help': '', 'Top': '2', 'Visible': 'True', 'Height': '30', 'Text': 'ClearBox', 'Left': '100', 'Tag': '', 'ForeColor': '(0,0,0,1)', 'Font': ''}",'QPushButton','usercontrol',"[['clicked', 'self,e'], ['clicked', 'self,arg1'], ['released', 'self']]")
		self.createwidget("{'Events': '[clicked]', 'Width': '155', 'Name': 'Button5', 'Picture': '', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Var': '', 'ParentsType': '', 'Help': '', 'Top': '0', 'Visible': 'True', 'Height': '28', 'Text': 'Open Existing Project', 'Left': '932', 'Tag': '', 'ForeColor': '(0,0,1,1)', 'Font': ''}",'QPushButton','usercontrol',"[['clicked', 'self,e']]")
		self.createwidget("{'Events': '[clicked]', 'Width': '100', 'Name': 'Button6', 'Picture': 'python.png', 'Enable': 'False', 'BackColor': '(1,1,1,1)', 'Var': '@python3 with tensorflow path', 'ParentsType': '', 'Help': '', 'Top': '694', 'Visible': 'False', 'Height': '35', 'Text': '', 'Left': '-1', 'Tag': '', 'ForeColor': '(0,0,0,1)', 'Font': ''}",'QPushButton','usercontrol',"[['clicked', 'self,e']]")
		self.createwidget("{'Events': '[clicked]', 'Width': '100', 'Name': 'Button12', 'Picture': '', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Var': '', 'ParentsType': '', 'Help': '', 'Top': '133', 'Visible': 'True', 'Height': '50', 'Text': 'Train', 'Left': '1087', 'Tag': '', 'ForeColor': '[1.0, 0.0, 0.0, 1.0]', 'Font': 'Sans Bold Italic 12'}",'QPushButton','usercontrol',"[['clicked', 'self,e']]")
		self.createwidget("{'Width': '100', 'Enable': 'False', 'Picture': '', 'Name': 'Button1', 'BackColor': '(1,1,1,1)', 'Var': '', 'Height': '30', 'ForeColor': '[1.0, 0.0, 0.0, 1.0]', 'Help': '', 'Top': '29', 'Visible': 'True', 'ParentsType': '', 'Text': 'Test Folder', 'Left': '750', 'Tag': '', 'Events': '[clicked]', 'Font': ''}",'QPushButton','usercontrol',"[['clicked', 'self,e']]")
		self.createwidget("{'Events': '[clicked]', 'Width': '140', 'Name': 'Button11', 'Picture': '', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Var': '', 'ParentsType': '', 'Help': '', 'Top': '0', 'Visible': 'True', 'Height': '28', 'Text': 'Create New Project', 'Left': '650', 'Tag': '', 'ForeColor': '(0,0,1,1)', 'Font': ''}",'QPushButton','usercontrol',"[['clicked', 'self,e']]")
		self.createwidget("{'Width': '450', 'Alignment': '', 'Enable': 'True', 'Picture': '', 'Name': 'Label1', 'BackColor': '(1,1,1,0)', 'Var': '', 'Height': '21', 'ForeColor': '(0,0,0,1)', 'Help': '', 'Top': '58', 'Visible': 'True', 'ParentsType': '', 'Text': 'Current Folder', 'Left': '650', 'Tag': '', 'Events': [], 'Font': ''}",'QLabel','usercontrol',"[]")
		self.createwidget("{'Events': '[clicked]', 'Width': '140', 'Name': 'Button8', 'Picture': '', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Var': '', 'ParentsType': '', 'Help': '', 'Top': '0', 'Visible': 'True', 'Height': '28', 'Text': 'Open Project Folder', 'Left': '791', 'Tag': '', 'ForeColor': '(0,0,0,1)', 'Font': ''}",'QPushButton','usercontrol',"[['clicked', 'self,e']]")
		self.createwidget("{'Width': '530', 'Alignment': '', 'Enable': 'True', 'Picture': '', 'Name': 'Label3', 'BackColor': '(1,1,1,1)', 'Var': '', 'Height': '35', 'ForeColor': '(0,0,0,1)', 'Help': '', 'Top': '694', 'Visible': 'False', 'ParentsType': '', 'Text': 'python3 path', 'Left': '100', 'Tag': '', 'Events': [], 'Font': ''}",'QLabel','usercontrol',"[]")
		self.createwidget("{'Width': '100', 'Enable': 'True', 'Picture': '', 'Name': 'Button13', 'BackColor': '(1,1,1,1)', 'Var': '', 'Height': '25', 'ForeColor': '(0,0,0,1)', 'Help': '', 'Top': '188', 'Visible': 'True', 'ParentsType': '', 'Text': 'Clear', 'Left': '1193', 'Tag': '', 'Events': '[clicked]', 'Font': ''}",'QPushButton','usercontrol',"[['clicked', 'self,e']]")
		self.createwidget("{'Width': '40', 'Enable': 'True', 'Picture': '', 'Name': 'ctlExecCommand1', 'BackColor': '(0, 0.33817815766829007, 0.4859420866885811, 0.5)', 'Var': '', 'Height': '25', 'ForeColor': '(0,0,0,1)', 'Help': '', 'Top': '622', 'Visible': 'True', 'ParentsType': '', 'Text': '', 'Left': '183', 'Tag': 'Activex', 'Events': [[['on_messagePipe', 'self,msg']], [['finishExecuting', 'self']]], 'Font': ''}",'Pipe','usercontrol',"[['on_messagePipe', 'self,msg'], ['finishExecuting', 'self']]")
		self.createwidget("{'Events': '[toggled]', 'Width': '110', 'Name': 'RadioButton2', 'Picture': '', 'Enable': 'True', 'BackColor': '[0.0, 0.6666666666666666, 1.0, 1.0]', 'Var': 'self.RadioButton1.obj', 'ParentsType': '', 'Help': '', 'Top': '182', 'Visible': 'True', 'Height': '30', 'Text': 'Local Training', 'Left': '1010', 'Tag': '', 'ForeColor': '(0,0,0,1)', 'Font': ''}",'QRadioButton','usercontrol',"[['toggled', 'self,widget'], ['toggled', 'self,arg1']]")
		self.createwidget("{'Width': '235', 'Enable': 'True', 'Picture': '', 'Name': 'ctlListBox1', 'BackColor': '(0, 0.4901733589034363, 0.08166343779938767, 0.5)', 'Var': '', 'Height': '235', 'ForeColor': '(0,0,0,1)', 'Help': '', 'Top': '105', 'Visible': 'True', 'ParentsType': '', 'Text': '', 'Left': '650', 'Tag': '', 'Events': '[currentTextChanged]', 'Font': ''}",'QListWidget','usercontrol',"[['currentTextChanged', 'self,arg1']]")
		self.createwidget("{'Width': '100', 'Enable': 'False', 'Picture': '', 'Name': 'Button2', 'BackColor': '(1,1,1,1)', 'Var': '', 'Height': '30', 'ForeColor': '[0.0, 0.6666666666666666, 0.0, 1.0]', 'Help': '', 'Top': '29', 'Visible': 'True', 'ParentsType': '', 'Text': 'Train Folder', 'Left': '650', 'Tag': '', 'Events': '[clicked]', 'Font': ''}",'QPushButton','usercontrol',"[['clicked', 'self,e'], ['clicked', 'self,arg1']]")
		self.createwidget("{'Events': [], 'Width': '290', 'Name': 'ComboBoxText1', 'Picture': '', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Var': '', 'ParentsType': '', 'Help': '', 'Top': '105', 'Visible': 'True', 'Height': '25', 'Text': '', 'Left': '899', 'Tag': '', 'ForeColor': '(0,0,0,1)', 'Font': ''}",'QComboBox','usercontrol',"[]")
		self.createwidget("{'Width': '450', 'Alignment': '', 'Enable': 'True', 'Picture': '', 'Name': 'Label4', 'BackColor': '(1,1,1,0)', 'Var': '', 'Height': '24', 'ForeColor': '(0,0,0,1)', 'Help': '', 'Top': '79', 'Visible': 'True', 'ParentsType': '', 'Text': 'Current Image', 'Left': '650', 'Tag': '', 'Events': [], 'Font': ''}",'QLabel','usercontrol',"[]")
		self.createwidget("{'Width': '50', 'Enable': 'True', 'Picture': '', 'Name': 'Button3', 'BackColor': '(1,1,1,1)', 'Var': '', 'Height': '30', 'ForeColor': '[0.0, 0.0, 1.0, 1.0]', 'Help': '', 'Top': '343', 'Visible': 'True', 'ParentsType': '', 'Text': 'add', 'Left': '650', 'Tag': '', 'Events': '[clicked]', 'Font': ''}",'QPushButton','usercontrol',"[['clicked', 'self,e']]")
		self.createwidget("{'Events': [], 'Width': '25', 'Name': 'MsgBox1', 'Picture': 'MsgBox.png', 'Visible': 'False', 'Enable': 'True', 'BackColor': '(0, 0.17776407343308598, 0.8110544536739468, 0.5)', 'Var': '', 'ParentsType': '', 'Help': '', 'Top': '621', 'usercontrolproperty': 'sample only', 'Height': '25', 'Text': '', 'Left': '241', 'Tag': '', 'ForeColor': '(0,0,0,1)', 'Font': ''}",'QInputDialog','usercontrol',"[]")
		self.createwidget("{'Width': '650', 'Enable': 'True', 'Picture': '', 'Name': 'ctlbox1', 'BackColor': '(0, 0.6741879151868759, 0.9181997404131559, 0.5)', 'Var': '', 'Height': '558', 'ForeColor': '(0,0,0,1)', 'Help': '', 'Top': '31', 'Visible': 'True', 'ParentsType': '', 'Text': '', 'Left': '1', 'Tag': 'Activex', 'Events': [[['draw', 'self']]], 'Font': ''}",'ctlbox','usercontrol',"[['draw', 'self']]")
		self.createwidget("{'Width': '40', 'Enable': 'True', 'Picture': 'FileChooser.png', 'Name': 'FileChooser1', 'BackColor': '(0, 0.028292299065927673, 0.3807361575911752, 0.5)', 'Var': '', 'Height': '30', 'ForeColor': '(0,0,0,1)', 'Help': '', 'Top': '622', 'Visible': 'False', 'ParentsType': '', 'Text': '', 'Left': '281', 'Tag': '', 'Events': [], 'Font': ''}",'QFileDialog','usercontrol',"[]")
		self.createwidget("{'Width': '89', 'Enable': 'True', 'Picture': '', 'Name': 'Button14', 'BackColor': '(1,1,1,1)', 'Var': '', 'Height': '36', 'ForeColor': '[0.0, 0.3333333333333333, 1.0, 1.0]', 'Help': '', 'Top': '592', 'Visible': 'False', 'ParentsType': '', 'Text': 'models path', 'Left': '0', 'Tag': '', 'Events': '[clicked]', 'Font': ''}",'QPushButton','usercontrol',"[['clicked', 'self,e']]")
		self.createwidget("{'Width': '563', 'Alignment': '', 'Enable': 'True', 'Picture': '', 'Name': 'Label5', 'BackColor': '(1,1,1,1)', 'Var': '', 'Height': '36', 'ForeColor': '(0,0,0,1)', 'Help': '', 'Top': '594', 'Visible': 'False', 'ParentsType': '', 'Text': 'models path', 'Left': '90', 'Tag': '', 'Events': [], 'Font': ''}",'QLabel','usercontrol',"[]")
		self.createwidget("{'Width': '111', 'Enable': 'True', 'Picture': '', 'Name': 'RadioButton1', 'BackColor': '[0.3333333333333333, 1.0, 1.0, 1.0]', 'Var': '@Online Training', 'Height': '30', 'ForeColor': '(0,0,0,1)', 'Help': '', 'Top': '182', 'Visible': 'True', 'ParentsType': '', 'Text': 'Google Colab', 'Left': '900', 'Tag': '', 'Events': '[toggled]', 'Font': ''}",'QRadioButton','usercontrol',"[['toggled', 'self,widget'], ['toggled', 'self,arg1'], ['clicked', 'self,arg1']]")
		self.createwidget("{'Width': '100', 'Enable': 'False', 'Picture': '', 'Name': 'Button4', 'BackColor': '(1,1,1,1)', 'Var': '', 'Height': '30', 'ForeColor': '(0,0,0,1)', 'Help': '', 'Top': '1', 'Visible': 'True', 'ParentsType': '', 'Text': 'Save XML', 'Left': '1', 'Tag': '', 'Events': '[clicked]', 'Font': ''}",'QPushButton','usercontrol',"[['clicked', 'self,e']]")
		self.createwidget("{'Width': '134', 'Alignment': '', 'Enable': 'True', 'Picture': '', 'Name': 'Label2', 'BackColor': '[0.0, 0.0, 0.0, 1.0]', 'Var': '', 'Height': '30', 'ForeColor': '[1.0, 1.0, 1.0, 1.0]', 'Help': '', 'Top': '343', 'Visible': 'True', 'ParentsType': '', 'Text': 'Classes', 'Left': '700', 'Tag': '', 'Events': [], 'Font': ''}",'QLabel','usercontrol',"[]")
		self.createwidget("{'Width': '153', 'Enable': 'True', 'Picture': 'youtube.png', 'Name': 'Button9', 'BackColor': '(1,1,1,1)', 'Var': '@Generate TFRecods', 'Height': '50', 'ForeColor': '[0.0, 0.3333333333333333, 1.0, 1.0]', 'Help': '', 'Top': '132', 'Visible': 'True', 'ParentsType': '', 'Text': 'Gen TF RECORDS', 'Left': '900', 'Tag': '', 'Events': '[clicked]', 'Font': 'Sans Bold Italic 12'}",'QPushButton','usercontrol',"[['clicked', 'self,e'], ['clicked', 'self,arg1']]")
		self.createwidget("{'Width': '235', 'Enable': 'True', 'Picture': '', 'Name': 'ctlListBox2', 'BackColor': '(0, 0.4901733589034363, 0.08166343779938767, 0.5)', 'Var': '', 'Height': '255', 'ForeColor': '(0,0,0,1)', 'Help': '', 'Top': '375', 'Visible': 'True', 'ParentsType': '', 'Text': '', 'Left': '650', 'Tag': '', 'Events': [], 'Font': ''}",'QListWidget','usercontrol',"[]")
		self.createwidget("{'Width': '395', 'Enable': 'True', 'Picture': '', 'Name': 'TextView1', 'BackColor': '(1,1,1,1)', 'Var': '', 'Height': '418', 'ForeColor': '(0,0,0,1)', 'Help': '', 'Top': '213', 'Visible': 'True', 'ParentsType': '', 'Text': 'Output Pane -- ', 'Left': '899', 'Tag': '', 'Events': [], 'Font': ''}",'QTextEdit','usercontrol',"[]")
	def Widget(self):
		return self
	def ctlbox1_draw(self):
		
		#name=self.MsgBox1.Display("Select Here",self.classes,["YES"])

		try:
			
			
			name=self.MsgBox1.obj.getItem(self,"Select Here","Classes",self.classes,current=self.lastclasses)
			
			if name[1] !=True:
				ret="NO"
			else:
				ret="YES"
				self.ctlbox1.boxes.x.name=name[0]
				self.lastclasses=self.classes.index(name[0])

		except:

			pass
		self.EnableButton(self.Button4,True)
		
			
		return ret#signal caller if ok 

	def ctlListBox1_currentTextChanged(self,arg1):
		value=arg1
		try:
			if self.Button4.Enable==True:
				#ret=self.MsgBox1.Display("Suggestion","Save XML?",["YES","NO"])
				ret=QMessageBox.question(self, "Suggestion","Save XML?", QMessageBox.Yes | QMessageBox.No)
				if ret==QMessageBox.Yes:
					self.Button4_clicked(None)
			fname=self.folderimage+"/"+self.folder+"/"+value
			x=cv2.imread(fname)
			self.ctlbox1.boxes.delete()
			self.ctlbox1.Init(x.shape[1],x.shape[0],False,fname)
			self.EnableButton(self.Button4,False)
			self.Label4.Text=value
		except:
			pass
	def SetTensorFlowFolder(self,folder=None):
		if folder==None:
			#ret=self.FileChooser1.SelectFile("Select Folder(Object_detection)",FolderSelect=True)
			self.FileChooser1.obj.setDirectory(os.path.expanduser('~'))
			ret = self.FileChooser1.getExistingDirectory()
		else:
			ret=folder
		if GetFilename(ret)!="object_detection":
			self.projectpath=ret
			#self.MsgBox1.Display("Invalid Folder","Must be object_detection folder!!!",button=["OK"],width=300)
			QMessageBox.about(self, "Invalid Folder","Must be object_detection folder!!!")
			return
		
		if type(ret)==str and FileExist(ret+"/images"):
			self.folderimage=ret+"/images"
			self.Label1.Text=self.folderimage
			self.EnableButton(self.Button1, True)
			self.EnableButton(self.Button2, True)
			self.EnableButton(self.Button6, True)
			self.Button2_clicked(None)#default train folder show
			#self.Label3.Text= GetFileStr(self.folderimage+"/" + 'python3.txt')
			self.projectpath=backonefolder(self.folderimage)
			self.Label5.Text=GetFileStr(self.folderimage+"/" + 'object_detection.txt')
		else:
			self.EnableButton(self.Button1, False)
			self.EnableButton(self.Button2, False)

	def LoadImageFolder(self,folder="train"):
		from os import listdir
		from os.path import isfile, join
		import os
		self.folder=folder
		if folder=="train":
			self.Button2.ForeColor=(1,0,0,1)
			self.Button1.ForeColor=(0,0,1,1)
			self.caller.tabfrmcamera2.QPushButton2.Text="Save To Train Folder"
			self.caller.tabfrmcamera2.QPushButton2.Enable=True
		else:
			self.Button2.ForeColor=(0,0,1,1)
			self.Button1.ForeColor=(1,0,0,1)
			self.caller.tabfrmcamera2.QPushButton2.Text="Save To Test Folder"
			self.caller.tabfrmcamera2.QPushButton2.Enable=True
			self.caller.tabfrmcamera2.QPushButton2.ForeColor=[0,0,1,1]

		if FileExist(self.folderimage):
			self.Label1.Text=self.folderimage+'/'+folder
			onlyfiles = [f for f in os.listdir(self.folderimage+'/'+folder+'/') if os.path.isfile(self.folderimage+'/'+folder+'/'+f) and (f.find(".jpg")!=-1 or f.find(".JPG")!=-1 or f.find(".png")!=-1 or f.find(".PNG")!=-1 or f.find(".jpeg")!=-1 or f.find(".JPEG")!=-1)]
			self.ctlListBox1.List=onlyfiles
			self.Label4.Text=""
			pass
		self.RetribClasses()
	def RetribClasses(self):
		fname=self.folderimage+"/classes.txt"
		if FileExist(fname):
			self.classes=eval(GetFileStr(fname))
			self.ctlListBox2.List=self.classes
		pass
	def Button3_clicked(self,e):
		try:		
			fname=self.folderimage+"/classes.txt"
		except:
			return
		#x=self.MsgBox1.Display("Enter New class name","",["OK"])
		x=self.MsgBox1.obj.getText(self,"Enter New class name","")
		self.classes.append(x[0])
		SaveFileStr(fname,str(self.classes))
		self.RetribClasses()
		pass
	def EnableButton(self,butt,flag):
		butt.Enable=flag
		if flag:
			butt.ForeColor=(0,0,1,1)
		else:
			butt.ForeColor=(0,0,0,1)
	def Button4_clicked(self,e):
		try:
			self.ctlbox1.boxes.GenerateXML()
			self.EnableButton(self.Button4, False)
		except:
			pass
	def Button2_clicked(self,e):
		self.LoadImageFolder(folder="train")
		if hasattr(self.ctlbox1,"Image1"):	
			self.ctlbox1.Image1.LoadPicture=""
		pass
	def Button1_clicked(self,e):
		self.LoadImageFolder(folder="test")
		if hasattr(self.ctlbox1,"Image1"):
			self.ctlbox1.Image1.LoadPicture=""
		pass
	def Button5_clicked(self,e):
		self.SetTensorFlowFolder()
		if GetFilename(self.projectpath)!="object_detection":
			return
		if len(self.classes)==0:
			#self.MsgBox1.Display("Suggestion","add classes and set python3 path",["OK"],width=300)
			x=self.MsgBox1.obj.getText(self,"Suggestion","add classes and set python3 path")
		if hasattr(self.ctlbox1,"Image1"):
			self.ctlbox1.Image1.LoadPicture=""
		pass
	def Button6_clicked(self,e):
		#ret=self.FileChooser1.SelectFile("Select Python 3 with Tensorflow installed",filetypes=['*.*'],FolderSelect=False)
		self.FileChooser1.obj.setDirectory(os.path.expanduser('~'))
		ret = self.FileChooser1.getOpenFileName(self, 'Open File')		
		try:
			if ret.find("python")!=-1:
				self.Label3.Text=ret
				SaveFileStr(self.folderimage+"/python3.txt",ret)
			pass
		except:
			pass
	def Button7_released(self):

		ret=self.msg.question(None, 'Warning', "Clear All Box in current image?", QMessageBox.Yes | QMessageBox.No)
		if ret==QMessageBox.No:
			return
		self.ctlbox1.ClearBox()
		self.EnableButton(self.Button4,True)
		pass
	def Button8_clicked(self,e):
		if hasattr(self, 'projectpath'):
			#import subprocess
			import webbrowser
			webbrowser.open(self.projectpath)   
			#subprocess.Popen('explorer /select,' + self.projectpath) #windows
		pass
	def StartDownload(self,DOWNLOAD_BASE,MODEL_FILE):
		import urllib
		import tarfile
		opener = urllib.request.URLopener()
		opener.retrieve(DOWNLOAD_BASE + MODEL_FILE, MODEL_FILE)
		tar_file = tarfile.open(MODEL_FILE)
		tar_file.extractall(self.projectpath)
		self.findownload=True	

		
	def downloadModel(self,MODEL_NAME='ssd_mobilenet_v1_coco_11_06_2017'):
		#MODEL_NAME = 'ssd_mobilenet_v1_coco_11_06_2017'
		MODEL_FILE = MODEL_NAME + '.tar.gz'
		DOWNLOAD_BASE = 'http://download.tensorflow.org/models/object_detection/'
		if not os.path.exists(self.projectpath+"/"+ MODEL_NAME):
			self.TextView1.Text+='\nDownloading the model, may take several minutes please wait..\n'
			self.findownload=False	
			thread.start_new_thread(self.StartDownload, (DOWNLOAD_BASE,MODEL_FILE))			
			cnt=0
			while(self.findownload==False):
				delay(1000)
				refreshGTK()
				self.TextView1.Text+="."
				cnt+=1
				if cnt==100:
					cnt=0
					self.TextView1.Text+="\n"

			self.TextView1.Text+='Download complete\n'
		else:
			self.TextView1.Text+='\nModel already exists\n'

	def Button9_clicked(self,e):
		
		if (self.Label3.Text.find("python")!=-1 and FileExist(self.Label3.Text))==False:

			
			QMessageBox.question(self,"Error","python3 does not exist", QMessageBox.OK )

			return
		if len(self.classes)==0:

			QMessageBox.question(self,"Error","Classes empty", QMessageBox.Ok)
			#self.MsgBox1.Display("Error","python3 does not exist",["OK"])
			return
		import testObjDetect


		strs=testObjDetect.generate(str(len(self.classes)))
		path=self.projectpath.replace("\\","/").replace("/object_detection","")
		SaveFileStr(path+"/test/testcamera.py",strs)	

		

		from shutil import copyfile
		import show_training_index

		num_classes=str(len(self.classes))
		
		if self.RadioButton1.Active:
			pathtraining='/content/drive/My Drive/Colab Notebooks/models/research'
		else:
			pathtraining=self.projectpath.replace("\\object_detection","").replace("/object_detection","")
		pathtraining=pathtraining.replace("\\","/")

		input_pathtrain=pathtraining+'/object_detection/train.record'
		label_map_pathtrain=pathtraining+'/object_detection/training/labelmap.pbtxt'
		folder='test'
		num_examples = [f for f in os.listdir(self.folderimage+'/'+folder+'/') if os.path.isfile(self.folderimage+'/'+folder+'/'+f) and f.find(".jpg")!=-1]
		num_examples=str(len(num_examples))
		input_pathtest=pathtraining+'/object_detection/test.record'
		label_map_pathtest=pathtraining+'/object_detection/training/labelmap.pbtxt'
		


		if self.ComboBoxText1.Text=="faster_rcnn_inception_v2":
			if self.RadioButton2.Active:
				self.downloadModel(MODEL_NAME='faster_rcnn_inception_v2_coco_2018_01_28')
			copyfile(app_path()+"/training_dataset_faster_rcnn_inception_v2.ipynb", self.projectpath+'/training_dataset_faster_rcnn_inception_v2.ipynb')		
			x='faster_rcnn_inception_v2_pets.config'

			import faster_rcnn_inception_v2
			#http://download.tensorflow.org/models/object_detection/faster_rcnn_inception_v2_coco_2018_01_28.tar.gz
			fine_tune_checkpoint=pathtraining+'/object_detection/faster_rcnn_inception_v2_coco_2018_01_28/model.ckpt'
			strs=faster_rcnn_inception_v2.generate(num_classes,fine_tune_checkpoint,input_pathtrain,label_map_pathtrain,num_examples,input_pathtest,label_map_pathtest)
			SaveFileStr(self.projectpath+"/training/faster_rcnn_inception_v2_pets.config",strs)	

		if self.ComboBoxText1.Text=="ssd_mobilenet_v1":
			if self.RadioButton2.Active:
				self.downloadModel(MODEL_NAME='ssd_mobilenet_v1_coco_2018_01_28')
			copyfile(app_path()+"/training_dataset_ssd_mobilenet_v1.ipynb", self.projectpath+'/training_dataset_ssd_mobilenet_v1.ipynb')		
			x='ssd_mobilenet_v1_pets.config'

			import ssd_mobilenet_v1
			#http://download.tensorflow.org/models/object_detection/ssd_mobilenet_v1_coco_2018_01_28.tar.gz
			fine_tune_checkpoint=pathtraining+'/object_detection/ssd_mobilenet_v1_coco_2018_01_28/model.ckpt'
			strs=ssd_mobilenet_v1.generate(num_classes,fine_tune_checkpoint,input_pathtrain,label_map_pathtrain,num_examples,input_pathtest,label_map_pathtest)
			SaveFileStr(self.projectpath+"/training/ssd_mobilenet_v1_pets.config",strs)	


		strs=show_training_index.generate(x)
		SaveFileStr( self.projectpath+"/show_training_index.py",strs)	

		strs='''1.Create folder "Colab Notebooks" in your Google Drive/My Drive and paste training_dataset.ipynb
2.Run training_dataset.ipynb in Colaboratory(line by line)

3.after executing #line 9 copy listed files and folder below from object_detection folder 
to google drive "/My Drive/Colab Notebooks/models/research/object_detection" 

a.show_training_index.py
b.train.py
c.train.record
d.test.record
e.training(folder)
f.inference_graph(folder)

4.after executing #line 15 it will advice what to execute on #line 16

'''

		SaveFileStr(self.projectpath+"/readmeFirst.txt",strs)	



		import train
		strs=train.generate("")
		SaveFileStr( self.projectpath+"/train.py",strs)	


		import generate_tfrecord
		strs=generate_tfrecord.generate(self.classes)
		SaveFileStr(self.projectpath+"/generate_tfrecord.py",strs)	

		import labelmap
		strs=labelmap.generate(self.classes)
		SaveFileStr(self.projectpath+"/training/labelmap.pbtxt",strs)	



		self.TextView1.Text="xml_to_csv started\n"		
		import xml_to_csv
		strs=xml_to_csv.generate()
		SaveFileStr(self.projectpath+"/xml_to_csv.py",strs)	
		
		#start xml_to_csv.py
		#will fire on loop
		self.ExecuteNext=1
		self.Execute=self.ExecuteNext
	
		

		pass
	def Button14_clicked(self,e):
		#ret=self.FileChooser1.SelectFile("Select Folder models folder",FolderSelect=True)
		self.FileChooser1.obj.setDirectory(os.path.expanduser('~'))
		ret = self.FileChooser1.getExistingDirectory()
		try:
			if type(ret)==str and FileExist(ret+"/research") and ret.find("models")!=-1:
				SaveFileStr(self.projectpath+'/images/object_detection.txt',ret)
				self.Label5.Text=ret
			else:
				#self.MsgBox1.Display("Error ","Invalid models folder \nit doesnt contain research folder",["OK"])
				QMessageBox.question(self, "Error ","Invalid models folder \nit doesnt contain research folder", QMessageBox.Ok)
			pass
		except:
			pass
	def Button12_clicked(self,e):
		self.ExecuteNext=-1
		if self.Button12.Text=="Train":
			self.Button12.Text="Abort Training"
		else:
			self.Button12.Text="Train"
			self.ctlExecCommand1.AbortExecution()
			return
		if self.Label5.Text=="":
			#self.MsgBox1.Display("Error","please set models folder","OK")
			QMessageBox.question(self, "Error","please set models folder", QMessageBox.Ok)
			return

		import train
		x='import sys\nsys.path.append("' + self.Label5.Text.replace("\\","/") + '/research")\n' + 'sys.path.append("' + self.Label5.Text.replace("\\","/")  +'/research/slim")\n' 

		strs=train.generate(x)
		SaveFileStr( self.projectpath+"/train.py",strs)	
	

		if self.ComboBoxText1.Text=="faster_rcnn_inception_v2":
			config='faster_rcnn_inception_v2_pets.config'
		if self.ComboBoxText1.Text=="ssd_mobilenet_v1":
			config='ssd_mobilenet_v1_pets.config'
		self.projectpath=self.projectpath.replace("\\","/")
		cmdlst=[self.Label3.Text,self.projectpath +"/train.py","logtostderr","--train_dir="+self.projectpath  +"/training/",'--pipeline_config_path='+self.projectpath +"/training/"+ config]
		self.ctlExecCommand1.ExecCommand(cmdlst)	
		pass

	def ctlExecCommand1_on_messagePipe(self,msg):
		self.TextView1.Text+=msg
		if msg.find('test.record')!=-1:
			self.Button8_clicked(None)
		pass
	def ctlExecCommand1_finishExecuting(self):
		self.TextView1.Text+="Finish\n"
		if self.ExecuteNext!=-1: 
			self.Execute=self.ExecuteNext
	def Button10_released(self):

		ret=QMessageBox.question(self, "Warning","Clear All Classes?", QMessageBox.Ok | QMessageBox.No)

		if ret==QMessageBox.No:

			return

		try:		

			fname=self.folderimage+"/classes.txt"

		except:

			return



		self.classes=[]

		SaveFileStr(fname,str(self.classes))

		self.RetribClasses()

		pass		
	
	def Button11_clicked(self,e):
		#ret=self.FileChooser1.SelectFile("Select Folder",FolderSelect=True)
		self.FileChooser1.obj.setDirectory(os.path.expanduser('~'))
	
		ret = self.FileChooser1.getExistingDirectory()		
		if type (ret)==int:return
		def createFolder(path):
			try:
				os.mkdir(path)
			except:
				pass
		if FileExist(ret):
			self.projectpath=ret+'/object_detection'
			self.projectpath=self.projectpath.replace('\\','/')
			createFolder(ret.replace('\\','/')+'/test')
			createFolder(ret.replace('\\','/')+'/test/inference_graph')

			createFolder(ret.replace('\\','/')+'/object_detection')
			createFolder(ret.replace('\\','/')+'/object_detection/images')
			createFolder(ret.replace('\\','/')+'/object_detection/images/train')
			createFolder(ret.replace('\\','/')+'/object_detection/images/test')
			createFolder(ret.replace('\\','/')+'/object_detection/training')
			createFolder(ret.replace('\\','/')+'/object_detection/inference_graph')
			SaveFileStr(self.projectpath+"/images/python3.txt","")
			SaveFileStr(self.projectpath+"/images/classes.txt","[]")
			SaveFileStr(self.projectpath+'/images/object_detection.txt',"")
			msg='''	Please put 70 percent of your image to train folder
			and 30 percent image for test folder and start labeling 
			it by drawing a box..
			'''
			#self.MsgBox1.Display("Important",msg,["OK"],width=400)
			QMessageBox.question(self,"Important",msg)
			self.SetTensorFlowFolder(self.projectpath)
			import webbrowser
			self.projectpath=ret+'/object_detection'
			webbrowser.open(self.projectpath+'/images')   
		pass
	def Button13_clicked(self,e):
		self.TextView1.Text=""
		pass
	def RadioButton1_toggled(self,widget):
		self.Button12.Visible=self.RadioButton2.Active

		self.Button14.Visible=self.RadioButton2.Active

		self.Label5.Visible=self.RadioButton2.Active
		pass
	def RadioButton2_toggled(self,widget):
		self.Button12.Visible=self.RadioButton2.Active

		self.Button14.Visible=self.RadioButton2.Active

		self.Label5.Visible=self.RadioButton2.Active
		pass
if __name__ == '__main__':
	import sys
	app = QtWidgets.QApplication(sys.argv)
	w = Handler()
	w.show()
	sys.exit(app.exec_())