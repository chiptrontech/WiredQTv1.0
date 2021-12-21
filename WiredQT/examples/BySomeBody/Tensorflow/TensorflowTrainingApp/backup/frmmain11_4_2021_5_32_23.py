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
		import pdb;pdb.set_trace()

		self.Tab.arrangetabs()
		#self.QTabWidget0.addTab(self.frmtraining1,"Training")

		#self.QTabWidget0.addTab(self.frmcamera2,"Camera")

		
	def createwidget(self,prop,control,parent,event=[]):
		createWidget(self,prop,control,parent,event)         
	def GTKForms(self):
		self.createwidget("{'Name': 'tabfrmtraining1', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '79', 'Width': '218', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': [], 'Height': '151', 'Left': '608', 'Tag': 'Activex', 'Text': '', 'Help': ''}",'frmtraining','usercontrol',"[]")
		self.createwidget("{'Name': 'tabfrmcamera2', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '357', 'Width': '100', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': [], 'Height': '100', 'Left': '341', 'Tag': 'Activex', 'Text': '', 'Help': ''}",'frmcamera','usercontrol',"[]")
		self.createwidget("{'Name': 'Tab', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '26', 'Width': '239', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': [], 'Height': '165', 'Left': '67', 'Tag': 'Activex', 'Text': '', 'Help': '', 'Interval': '1000'}",'Tab','usercontrol',"[]")
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
	
if __name__ == '__main__':
	import sys
	app = QtWidgets.QApplication(sys.argv)
	w = Handler()
	w.show()
	sys.exit(app.exec_())
