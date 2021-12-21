from PyQt5 import QtCore, QtWidgets
from PyQt5.QtGui import * 
from wired_module import * 
import cv2
#	Generated By WiredQT for Python: by Rocky Nuarin, 2021 Phils
class Handler(QtWidgets.QWidget,usercontrol):
	def __init__(self, *param):    
		super(Handler, self).__init__(None)
		initUI(self,param,w=640,h=550,title="WiredQTv5.0",controlbox=True,startpos=(0,30),timeoutdestroy=-1)
		self.GTKForms()
		self.timer=QtCore.QTimer()
		self.timer.timeout.connect(self.loop)
		self.timer.start(10)       

		self.sch=Scheduler(5000)#500 ms
		self.sch.Start()
		
	def createwidget(self,prop,control,parent,event=[]):
		createWidget(self,prop,control,parent,event)         
	def GTKForms(self):
		self.createwidget("{'Name': 'WebCam0', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '7', 'Width': '545', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': [[['frameReady', 'self,arg1']]], 'Height': '431', 'Left': '10', 'Tag': 'Activex', 'Text': '', 'Help': '', 'Open': 'False', 'camindex': '0'}",'WebCam','usercontrol',"[['frameReady', 'self,arg1']]")
		self.createwidget("{'Name': 'QPushButton1', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '442', 'Width': '93', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': '[released]', 'Height': '30', 'Left': '7', 'Tag': '', 'Text': 'Start', 'Help': ''}",'QPushButton','usercontrol',"[['released', 'self']]")
		self.createwidget("{'Name': 'QPushButton2', 'Var': '', 'Font': '', 'Enable': 'False', 'Top': '442', 'Width': '104', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': '[clicked]', 'Height': '30', 'Left': '102', 'Tag': '', 'Text': 'Capture n Save', 'Help': ''}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Events': [], 'Width': '25', 'Name': 'MsgBox1', 'Picture': 'MsgBox.png', 'Visible': 'False', 'Enable': 'True', 'BackColor': '(0, 0.17776407343308598, 0.8110544536739468, 0.5)', 'Var': '', 'ParentsType': '', 'Help': '', 'Top': '447', 'usercontrolproperty': 'sample only', 'Height': '25', 'Text': '', 'Left': '250', 'Tag': '', 'ForeColor': '(0,0,0,1)', 'Font': ''}",'QInputDialog','usercontrol',"[]")
	def Widget(self):
		return self    
	def loop(self):
		if self.form_load==False:
			self.form_load=True
		if self.sch.Event():#timer routine
			#code here
			if self.timeoutdestroy!=-1:
				self.timeoutdestroy-=1
				if self.timeoutdestroy==0:
					pass#self.unload(None)
			self.sch.Start()#restart scheduler      
		
	def connect(self,ev,evusr):
		self.wiredevents.update({ev:evusr})     
	def activeXcreated(self,*args):
		pass    
	def eventFilter(self, obj, event):
		return super(Handler, self).eventFilter(obj, event)
	
	def WebCam0_frameReady(self,arg1):
		try:
			arg2=cv2.resize(arg1,(self.WebCam0.Width,self.WebCam0.Height))	
			self.WebCam0.imshow(arg2)		
			self.frame=arg1
		except:
			print("frameReady error");
			self.WebCam0.Open=False
			self.QPushButton1.Text="Start"
	def QPushButton1_released(self):
		try:
			
			
			if self.QPushButton1.Text=="Start":
				name=self.MsgBox1.obj.getItem(self,"Select camera","index",['0','1','2','3','4','5','6','7','8','9'])
				if name[1] !=True:
					pass
				else:
					self.WebCam0.camindex=name[0]

				self.WebCam0.Open=True
				self.QPushButton1.Text="Stop"
			else:
				self.WebCam0.Open=False
				self.QPushButton1.Text="Start"
		except:
			print("camera error");	
		pass
	def QPushButton2_clicked(self,arg1):
		
		try:
			fname=self.caller.tabfrmtraining1.Label1.Text+"/" + CreateFileName() + ".jpg"# save as datetime.jpg
			cv2.imwrite(fname,self.frame)
			if self.QPushButton2.Text.find("Train")!=-1:
				self.caller.tabfrmtraining1.Button2_clicked(None)
			else:
				self.caller.tabfrmtraining1.Button1_clicked(None)
		except:
			print("check destination folder")
		pass
if __name__ == '__main__':
	import sys
	app = QtWidgets.QApplication(sys.argv)
	w = Handler()
	w.show()
	sys.exit(app.exec_())
