from PyQt5 import QtCore, QtWidgets
from PyQt5.QtGui import * 
from wired_module import * 
#	Generated By WiredQT for Python: by Rocky Nuarin, 2021 Phils
class Handler(QtWidgets.QWidget,usercontrol):
	def __init__(self, *param):    
		super(Handler, self).__init__(None)
		initUI(self,param,w=400,h=400,title="WiredQTv5.0",controlbox=True,startpos=(0,30),timeoutdestroy=-1)
		self.GTKForms()
		self.timer=QtCore.QTimer()
		self.timer.timeout.connect(self.loop)
		self.timer.start(10)       

		self.sch=Scheduler(5000)#500 ms
		self.sch.Start()
		

	def createwidget(self,prop,control,parent,event=[]):
		createWidget(self,prop,control,parent,event)         
	def GTKForms(self):		self.createwidget("{'Name': 'Pipe0', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '34', 'Width': '64', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': [[['on_messagePipe', 'self,arg1']], [['finishExecuting', 'self']]], 'Height': '36', 'Left': '223', 'Tag': 'Activex', 'Text': '', 'Help': ''}",'Pipe','usercontrol',"[['on_messagePipe', 'self,arg1'], ['finishExecuting', 'self']]")
		self.createwidget("{'Name': 'QLineEdit1', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '33', 'Width': '53', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': [], 'Height': '23', 'Left': '144', 'Tag': '', 'Text': 'dir', 'Help': ''}",'QLineEdit','usercontrol',"[]")
		self.createwidget("{'Name': 'QPushButton2', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '5', 'Width': '78', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': '[clicked]', 'Height': '21', 'Left': '62', 'Tag': '', 'Text': 'Step 1', 'Help': ''}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Name': 'QPushButton3', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '33', 'Width': '78', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': '[clicked]', 'Height': '24', 'Left': '61', 'Tag': '', 'Text': 'Step 2', 'Help': ''}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Name': 'QLabel4', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '4', 'Width': '95', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '[1.0, 1.0, 0.4980392156862745, 1.0]', 'Events': [], 'Height': '23', 'Left': '143', 'Tag': '', 'Text': 'execute terminal', 'Help': ''}",'QLabel','usercontrol',"[]")
		self.createwidget("{'Name': 'QTextEdit6', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '89', 'Width': '346', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': [], 'Height': '281', 'Left': '3', 'Tag': '', 'Text': '', 'Help': ''}",'QTextEdit','usercontrol',"[]")
		self.createwidget("{'Name': 'QLineEdit7', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '61', 'Width': '51', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': [], 'Height': '24', 'Left': '145', 'Tag': '', 'Text': 'exit', 'Help': ''}",'QLineEdit','usercontrol',"[]")
		self.createwidget("{'Name': 'QPushButton8', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '62', 'Width': '78', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': '[clicked]', 'Height': '24', 'Left': '60', 'Tag': '', 'Text': 'step 3', 'Help': ''}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
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
	
	def Pipe0_on_messagePipe(self,arg1):
		self.QTextEdit6.Text+=arg1
		pass
	def QPushButton2_clicked(self,arg1):
		self.Pipe0.ExecCommand(["cmd"])
		#execute python
		#self.Pipe0.ExecCommand(["python","-u",'C:/Users/Acer/Desktop/myscript.py'])
		
		pass
	def QPushButton3_clicked(self,arg1):
		self.Pipe0.SendPipe(self.QLineEdit1.Text+"\n")
		pass
	def Pipe0_finishExecuting(self):
		print("Finish")
		pass
	def QPushButton8_clicked(self,arg1):
		self.Pipe0.SendPipe(self.QLineEdit7.Text+"\n")
		pass
if __name__ == '__main__':
	import sys
	app = QtWidgets.QApplication(sys.argv)
	w = Handler()
	w.show()
	sys.exit(app.exec_())
