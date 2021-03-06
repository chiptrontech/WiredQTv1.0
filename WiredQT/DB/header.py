from PyQt5 import QtCore, QtWidgets
from PyQt5.QtWidgets import * 
from PyQt5.QtGui import * 
from wired_module import *
#	Generated By WiredQT for Python: by Rocky Nuarin, 2021 Phils
class Handler(QtWidgets.QWidget,usercontrol):
	def __init__(self, *param):    
		super(Handler, self).__init__(None)
		initUI(self,param,w=1366,h=768,title="WiredQT v1.0",controlbox=True,startpos=(0,30),timeoutdestroy=-1)
		self.GTKForms()
		self.timer=QtCore.QTimer()
		self.timer.timeout.connect(self.loop)
		self.timer.start(10)    
		self.sch=Scheduler(500)#500 ms
		self.sch.Start()

