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
	def GTKForms(self):		self.createwidget("{'Tag': '', 'Help': '', 'Var': '', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Events': '[clicked]', 'Text': 'Show Array Data', 'ParentsType': '', 'Name': 'QPushButton1', 'Font': '', 'Width': '102', 'Left': '119', 'Visible': 'True', 'Top': '184', 'BackColor': '(1,1,1,0.25)', 'Picture': '', 'Height': '38'}",'QPushButton','usercontrol',"[['clicked', 'self,arg1']]")
		self.createwidget("{'Tag': '', 'ForeColor': '(0,0,0,1)', 'Var': '', 'Enable': 'True', 'Help': '', 'Events': '[clicked]', 'Text': '', 'ParentsType': '', 'Name': 'QTableView0', 'Font': '', 'Width': '302', 'Left': '31', 'Visible': 'True', 'Top': '15', 'BackColor': '(1,1,1,0.25)', 'Picture': '', 'Height': '160'}",'QTableView','usercontrol',"[['clicked', 'self,arg1']]")
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
		data = [[4, 9, 2],
			["Fuck", 0, 0],
			[3, 5, 0],
			[3, 3, 2],
			[7, 8, 9],
		]
		self.model = TableModel(["Column 1","Column 1","Column 1"],data)
		self.QTableView0.setModel(self.model)
		self.QTableView0.setStyleSheet("QHeaderView::section {background-color:#cccccc}");#header color
		pass
	
	def QTableView0_clicked(self,arg1):
		print(arg1.row(),arg1.column(),arg1.data())
	
if __name__ == '__main__':
	import sys
	app = QtWidgets.QApplication(sys.argv)
	w = Handler()
	w.show()
	sys.exit(app.exec_())
