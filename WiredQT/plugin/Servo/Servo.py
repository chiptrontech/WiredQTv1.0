from PyQt5 import QtCore, QtWidgets
from PyQt5.QtGui import * 
from wired_module import * 
#	Generated By WiredQT for Python: by Rocky Nuarin, 2021 Phils
import pigpio

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
		self._text=''
		import os
		os.system("sudo pigpiod")
		self.gpio = pigpio.pi()

		self._MinDutyCycle=540
		self._MaxDutyCycle=2400
		self._angle=90
		self._pin=18

	def write(self,angle):
		self._angle=int(float(angle))
		x=Map(self._angle,0,180,self._MinDutyCycle,self._MaxDutyCycle)
		self.gpio.set_servo_pulsewidth(self._pin, x)	
	@property	
	def Angle(self):
		return self._angle
	@Angle.setter	
	def Angle(self,value):
		self.write(value)
	@property	
	def MinDutyCycle(self):
		return self._MinDutyCycle
	@MinDutyCycle.setter	
	def MinDutyCycle(self,value):
		self._MinDutyCycle=int(value)
	@property	
	def MaxDutyCycle(self):
		return self._MaxDutyCycle
	@MaxDutyCycle.setter	
	def MaxDutyCycle(self,value):
		self._MaxDutyCycle=int(value)
	@property	
	def Pin(self):
		return self._pin
	@Pin.setter	
	def Pin(self,value):
		self._pin=int(value)
	def connect(self,ev,evusr):
		self.wiredevents.update({ev:evusr})
	def activeXcreated(self,*args):
		x=Map(90,0,180,self.MinDutyCycle,self.MaxDutyCycle)
		pass
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
		pass
	def Widget(self):
		return self
if __name__ == '__main__':
	import sys
	app = QtWidgets.QApplication(sys.argv)
	w = Handler()
	w.show()
	sys.exit(app.exec_())