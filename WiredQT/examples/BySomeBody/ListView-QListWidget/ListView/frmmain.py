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

		#self.QListWidget3.List=["raks" + str(a) for a in range(20)]

		self.QListWidget3.List=["Data 1","Data 2","Data 3","Data 4","Data 5"]

	def createwidget(self,prop,control,parent,event=[]):
		createWidget(self,prop,control,parent,event)         
	def GTKForms(self):		self.createwidget("{'Font': '', 'ParentsType': '', 'Top': '35', 'Tag': '', 'Events': '[clicked]', 'Help': '', 'Var': '', 'Name': 'QListWidget3', 'Picture': '', 'Text': '', 'Height': '65', 'Visible': 'True', 'ForeColor': '(0,0,0,1)', 'Width': '155', 'BackColor': '(1,1,1,0.25)', 'Enable': 'True', 'Left': '20'}",'QListWidget','usercontrol',"[['clicked', 'self,arg1'], ['currentTextChanged', 'self,arg1'], ['currentRowChanged', 'self,arg1']]")
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
	

	def QListWidget3_currentTextChanged(self,arg1):
		print('text ',arg1)
		pass
	def QListWidget3_currentRowChanged(self,arg1):
		print('row',arg1)
		pass
if __name__ == '__main__':
	import sys
	app = QtWidgets.QApplication(sys.argv)
	w = Handler()
	w.show()
	sys.exit(app.exec_())
