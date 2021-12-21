from PyQt5 import QtCore, QtWidgets,QtMultimedia
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
		
		filename="death.wav"
		self.q1=QtMultimedia.QSound(filename)

		filename="demo.wav"
		self.q2=QtMultimedia.QSound(filename)
		
	def createwidget(self,prop,control,parent,event=[]):
		createWidget(self,prop,control,parent,event)         
	def GTKForms(self):		self.createwidget("{'Events': '[clicked]', 'Enable': 'True', 'Picture': '', 'Tag': '', 'Height': '45', 'Var': '', 'Font': '', 'ForeColor': '(0,0,0,1)', 'Text': 'Play2', 'Top': '130', 'Help': '', 'Width': '119', 'Name': 'QPushButton1', 'Left': '189', 'BackColor': '(1,1,1,0.25)', 'Visible': 'True', 'ParentsType': ''}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Events': '[clicked]', 'Enable': 'True', 'Picture': '', 'Tag': '', 'Visible': 'True', 'Var': '', 'Font': '', 'Height': '45', 'ForeColor': '(0,0,0,1)', 'Text': 'Play1', 'Top': '127', 'Help': '', 'Width': '119', 'Name': 'QPushButton3', 'Left': '63', 'BackColor': '(1,1,1,0.25)', 'ParentsType': ''}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
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
	
	def QPushButton1_clicked(self,arg1):
		self.q1.play()

	def QPushButton3_clicked(self,arg1):
		self.q2.play()
if __name__ == '__main__':
	import sys
	app = QtWidgets.QApplication(sys.argv)
	w = Handler()
	w.show()
	sys.exit(app.exec_())
