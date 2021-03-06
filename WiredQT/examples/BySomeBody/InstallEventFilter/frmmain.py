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
	def GTKForms(self):		self.createwidget("{'Name': 'QLineEdit0', 'Events': '[installEventFilter]', 'Width': '110', 'Font': '', 'Visible': 'True', 'Top': '55', 'Height': '28', 'ParentsType': '', 'Text': 'QLineEdit0', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Tag': '', 'Enable': 'True', 'BackColor': '(1,1,1,0.25)', 'Var': '', 'Left': '68', 'Help': ''}",'QLineEdit','usercontrol',"[['installEventFilter', 'self']]")
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

		if obj==self.QLineEdit0.obj:
			if event.type() == QtCore.QEvent.KeyPress:					
				print(event.key()) 
			if event.type() == QtCore.QEvent.Enter:					
				print("mouse Entered") 
			if event.type() == QtCore.QEvent.Leave:
				print("mouse Leave") 



		return super(Handler, self).eventFilter(obj, event)
	
	
	def QLineEdit0_installEventFilter(self):
		pass
if __name__ == '__main__':
	import sys
	app = QtWidgets.QApplication(sys.argv)
	w = Handler()
	w.show()
	sys.exit(app.exec_())
