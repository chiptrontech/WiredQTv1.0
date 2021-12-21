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

		self.sch=Scheduler(5000)#500 ms
		self.sch.Start()
		self.GIF0.Open()
		self.GIF1.Open()

		self.GIF2.Open()
	def createwidget(self,prop,control,parent,event=[]):
		createWidget(self,prop,control,parent,event)         
	def GTKForms(self):		self.createwidget("{'ParentsType': '', 'ForeColor': '(0,0,0,1)', 'Tag': '', 'Var': '', 'Top': '-1', 'Height': '640', 'Events': [], 'BackColor': '(1,1,1,0.25)', 'Width': '1366', 'Enable': 'True', 'Left': '0', 'Help': '', 'Picture': 'map.png', 'Visible': 'True', 'Text': '', 'Font': '', 'Name': 'QLabel4'}",'QLabel','usercontrol',"[]")
		self.createwidget("{'ParentsType': '', 'Acceleration': 'True', 'AutoRun': 'True', 'Top': '73', 'Folder': 'img', 'Events': [], 'Speed': '50', 'Width': '145', 'Enable': 'True', 'currY': '', 'Help': '', 'Visible': 'True', 'Text': '', 'Font': '', 'AutoScale': 'True', 'Tag': 'Activex', 'Stun': 'False', 'Height': '129', 'GavityValue': '1', 'BackColor': '(1,1,1,0.25)', 'Gravity': 'False', 'ForeColor': '(0,0,0,1)', 'Left': '427', 'Var': '', 'Picture': '', 'currX': '', 'Name': 'GIF2'}",'GIF','usercontrol',"[]")
		self.createwidget("{'ParentsType': '', 'ForeColor': '(0,0,0,1)', 'Tag': '', 'Var': '', 'Top': '5', 'Height': '34', 'Events': '[clicked]', 'BackColor': '(1,1,1,1)', 'Width': '101', 'Enable': 'True', 'Left': '464', 'Help': '', 'Picture': '', 'Visible': 'True', 'Text': 'Flicker', 'Font': '', 'Name': 'QPushButton4'}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'ParentsType': '', 'Acceleration': 'True', 'AutoRun': 'True', 'Top': '148', 'Folder': 'img', 'Events': [[['buttonpress', 'self,arg1']], [['buttonpress', 'self']]], 'Speed': '100', 'Width': '181', 'Enable': 'True', 'currY': '', 'Tag': 'Activex', 'Visible': 'True', 'Text': '', 'Font': '', 'AutoScale': 'True', 'Help': '', 'Stun': 'False', 'Height': '143', 'GavityValue': '1', 'BackColor': '(1,1,1,0.25)', 'Gravity': 'True', 'ForeColor': '(0,0,0,1)', 'Left': '76', 'Var': '', 'Picture': '', 'currX': '', 'Name': 'GIF0'}",'GIF','usercontrol',"[['buttonpress', 'self,arg1'], ['buttonpress', 'self']]")
		self.createwidget("{'ParentsType': '', 'Acceleration': 'True', 'AutoRun': 'True', 'Top': '35', 'Folder': 'img', 'Events': [], 'Speed': '100', 'Width': '145', 'Enable': 'True', 'currY': '', 'Help': '', 'Visible': 'True', 'Text': '', 'Font': '', 'AutoScale': 'True', 'Tag': 'Activex', 'Stun': 'False', 'Height': '129', 'GavityValue': '1', 'BackColor': '(1,1,1,0.25)', 'Gravity': 'True', 'ForeColor': '(0,0,0,1)', 'Left': '643', 'Var': '', 'Picture': '', 'currX': '', 'Name': 'GIF1'}",'GIF','usercontrol',"[]")
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
	
	def GIF0_buttonpress(self):
		x,y=self.GIF0.currX+200,self.GIF0.currY
		self.GIF0.Move(x,y)
		pass

	def QPushButton4_clicked(self,arg1):

		self.GIF0.MoveInstant(100,100)
		pass
if __name__ == '__main__':
	import sys
	app = QtWidgets.QApplication(sys.argv)
	w = Handler()
	w.show()
	sys.exit(app.exec_())
