from PyQt5 import QtCore, QtWidgets
from PyQt5.QtGui import * 
from wired_module import * 
#	Generated By WiredQT for Python: by Rocky Nuarin, 2021 Phils
class Handler(QtWidgets.QWidget,usercontrol):
	def __init__(self, *param):    
		super(Handler, self).__init__(None)
		initUI(self,param,w=1366,h=600,title="WiredQTv5.0",controlbox=True,startpos=(0,30),timeoutdestroy=-1)
		self.GTKForms()
		self.timer=QtCore.QTimer()
		self.timer.timeout.connect(self.loop)
		self.timer.start(10)       
		self.sch=Scheduler(500)#500 ms

		self.sch.Start()
	
	def loop(self):
		if self.form_load==False:
			self.form_load=True
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
		self.createwidget("{'Events': [[['onKeydown', 'self,key']]], 'BackColor': '(0, 0.381090576839595, 0.5916299873397326, 0.5)', 'ROW1': '18', 'Height': '30', 'ROW3': '20', 'ForeColor': '(0,0,0,1)', 'Help': '', 'Enable': 'True', 'Text': '', 'Left': '155', 'Width': '30', 'COL2': '5', 'COL1': '4', 'Tag': 'Activex', 'Var': '', 'Picture': 'Keypad.png', 'Font': '', 'ROW2': '19', 'Visible': 'True', 'COL3': '6', 'Top': '120', 'Name': 'Keypad1', 'ParentsType': '', 'ROW4': '21', 'COL4': '-1'}",'Keypad','usercontrol',"[['onKeydown', 'self,key']]")
		self.createwidget("{'Alignment': '', 'Events': [], 'BackColor': '[0.0, 1.0, 1.0, 1.0]', 'Top': '70', 'Height': '30', 'Tag': '', 'Var': '', 'Picture': '', 'Font': '', 'Visible': 'True', 'ForeColor': '[0.6666666666666666, 0.0, 0.0, 1.0]', 'Enable': 'True', 'Name': 'Entry1', 'Text': '', 'Left': '155', 'ParentsType': '', 'Help': '', 'Width': '170'}",'QLineEdit','usercontrol',"[]")
	def Widget(self):
		return self
	def Keypad1_onKeydown(self,key):
		self.Entry1.Text+=key
		pass
if __name__ == '__main__':
	import sys
	app = QtWidgets.QApplication(sys.argv)
	w = Handler()
	w.show()
	sys.exit(app.exec_())
