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
	def GTKForms(self):		self.createwidget("{'Name': 'socketClientTCP0', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '100', 'Width': '100', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': [[['CommEvent', 'self,arg1,arg2']]], 'Height': '100', 'Left': '100', 'Tag': 'Activex', 'Text': '', 'Help': '', 'Port': '5000', 'Address': 'localhost', 'BufferSize': '1024', 'Open': 'False'}",'socketClientTCP','usercontrol',"[['CommEvent', 'self,arg1,arg2']]")
		self.createwidget("{'Name': 'QPushButton1', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '213', 'Width': '100', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': '[clicked]', 'Height': '100', 'Left': '210', 'Tag': '', 'Text': 'QPushButton1', 'Help': ''}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Name': 'QPushButton2', 'Var': '', 'Font': '', 'Enable': 'True', 'Top': '209', 'Width': '100', 'ParentsType': '', 'Picture': '', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'BackColor': '(1,1,1,0.25)', 'Events': '[clicked]', 'Height': '100', 'Left': '100', 'Tag': '', 'Text': 'QPushButton2', 'Help': ''}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
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
	
	def socketClientTCP0_CommEvent(self,arg1,arg2):
		print(data.decode())
		pass
	def QPushButton1_clicked(self,arg1):
		self.socketClientTCP0.Open=True
		pass
	def QPushButton2_clicked(self,arg1):
		self.socketClientTCP0.sendall("Rocky".encode())
		pass
if __name__ == '__main__':
	import sys
	app = QtWidgets.QApplication(sys.argv)
	w = Handler()
	w.show()
	sys.exit(app.exec_())
