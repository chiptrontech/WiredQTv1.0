from PyQt5 import QtCore, QtWidgets
from PyQt5.QtGui import * 
from wired_module import * 
#	Generated By WiredQT for Python: by Rocky Nuarin, 2021 Phils
class Handler(QtWidgets.QWidget,usercontrol):
	#WiredEvent def on_data_recv(value)	#add more events 
	#WiredEvent def on_error(value)	#add more events 
	#WiredEvent def on_close()	#add more events 
	#WiredEvent def on_connected(conn)	#add more events 
	#WiredProperty 'url':'new.testonlineproject.com:5000'	
	#WiredProperty 'ID': '123'
	#WiredProperty 'ClientID': '456'

	def __init__(self, *param):    
		super(Handler, self).__init__(None)
		initUI(self,param,w=400,h=400,title="WiredQTv5.0",controlbox=True,startpos=(0,30),timeoutdestroy=-1)
		self.GTKForms()
		self.timer=QtCore.QTimer()
		self.timer.timeout.connect(self.loop)
		self.timer.start(10)       

		self.sch=Scheduler(5000)#500 ms
		self.sch.Start()
		self.ComboBoxText1.List=["WTAREGISTER^"+self.Entry1.Text+"\r","WTARELAY^"+self.Entry1.Text+"^Hello\r","WTADEVICES^\r","WTAKICK^"+self.Entry1.Text+"\r",]
		self._url=""
		self._ID=""
		self._ClientID=""
		self.socketclienttcp1.Open=True

		self.SendServerbuf=[]

		self.SendClientbuf=[]
	@property
	def ClientID(self):
		return self._ClientID
	@ClientID.setter	
	def ClientID(self,value):
		self._ClientID=value
	@property
	def ID(self):
		return self._ID
	@ID.setter	
	def ID(self,value):
		self._ID=value
	@property	
	def url(self):
		return self._url
	@url.setter	
	def url(self,value):
		self._url=value
		self.socketclienttcp1.Address=getCSV(0,":",value)
		self.socketclienttcp1.Port=int(getCSV(1,":",value))
	@property
	def Open(self):
		return self._url
	@Open.setter	
	def Open(self,value):
		self.Timer1.Enable=True
		self.socketclienttcp1.reconnect()
	def loop(self):

		if len(self.SendServerbuf):
			self.SendServerbuf.reverse()
			self.SendServerbuf.pop
			data=self.SendServerbuf.pop()
			try:
				self.socketclienttcp1.sendall( data.encode())
			except:
				if self.caller!=None:
					if 'on_error' in self.wiredevents:	
						self.wiredevents['on_error']("connection error")
			self.SendServerbuf.reverse()
		if len(self.SendClientbuf):
			self.SendClientbuf.reverse()
			data=self.SendClientbuf.pop()
			try:
				self.socketclienttcp1.sendall((("WTARELAY^" +self._ClientID + "^").encode() + data.encode() + "\r".encode()))
			except:
				if self.caller!=None:
					if 'on_error' in self.wiredevents:	
						self.wiredevents['on_error']("connection error")
			self.SendClientbuf.reverse()
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
	def GTKForms(self):		self.createwidget("{'Top': '82', 'Width': '28', 'Address': 'localhost', 'Port': '5000', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'BufferSize': '1024', 'ParentsType': '', 'Text': '', 'Picture': 'socketclienttcp.png', 'Left': '127', 'Font': '', 'Help': '', 'Tag': 'Activex', 'Name': 'socketclienttcp1', 'Height': '30', 'BackColor': '(0, 0.4305762015564615, 0.26882148398282424, 0.5)', 'Open': 'False', 'Visible': 'True', 'Events': [[['CommEvent', 'self,conn,data']], [['ConnectionFrom', 'self,conn']]], 'Var': ''}",'socketClientTCP','usercontrol',"[['CommEvent', 'self,conn,data'], ['ConnectionFrom', 'self,conn']]")
		self.createwidget("{'Top': '127', 'Width': '214', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'ParentsType': '', 'Text': 'TextView1', 'Picture': '', 'Left': '125', 'Font': '', 'Help': '', 'Tag': '', 'Name': 'TextView1', 'Height': '160', 'BackColor': '(1,1,1,1)', 'Visible': 'True', 'Events': [], 'Var': ''}",'QLineEdit','usercontrol',"[]")
		self.createwidget("{'Top': '73', 'Width': '100', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'ParentsType': '', 'Text': 'Send', 'Picture': '', 'Left': '184', 'Font': '', 'Help': '', 'Tag': '', 'Name': 'Button1', 'Height': '50', 'BackColor': '(1,1,1,1)', 'Visible': 'True', 'Events': '[clicked]', 'Var': ''}",'QPushButton','usercontrol',"[['clicked', 'self,e']]")
		self.createwidget("{'Top': '41', 'Width': '147', 'Alignment': '', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'ParentsType': '', 'Text': 'socket Client TCP example', 'Picture': '', 'Left': '124', 'Font': '', 'Help': '', 'Tag': '', 'Name': 'Label1', 'Height': '30', 'BackColor': '(1,1,1,1)', 'Visible': 'True', 'Events': [], 'Var': ''}",'QLabel','usercontrol',"[]")
		self.createwidget("{'Top': '35', 'Width': '30', 'Enable': 'False', 'Interval': '5000', 'ForeColor': '(0,0,0,1)', 'ParentsType': '', 'Text': '', 'Picture': 'Timer.png', 'Left': '295', 'Font': '', 'Help': '', 'Tag': 'Activex', 'Name': 'Timer1', 'Height': '30', 'BackColor': '(0, 0.20513950224541044, 0.8222246816727782, 0.5)', 'Visible': 'True', 'Events': [[['Tick', 'self']]], 'Var': ''}",'Timer','usercontrol',"[['Tick', 'self']]")
		self.createwidget("{'Top': '95', 'Width': '220', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'ParentsType': '', 'Text': '', 'Picture': '', 'Left': '300', 'Font': '', 'Help': '', 'Tag': '', 'Name': 'ComboBoxText1', 'Height': '25', 'BackColor': '(1,1,1,1)', 'Visible': 'True', 'Events': [], 'Var': ''}",'QComboBox','usercontrol',"[]")
		self.createwidget("{'Top': '65', 'Width': '120', 'Alignment': '', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'ParentsType': '', 'Text': '123', 'Picture': '', 'Left': '300', 'Font': '', 'Help': '', 'Tag': '', 'Name': 'Entry1', 'Height': '30', 'BackColor': '(1,1,1,1)', 'Visible': 'True', 'Events': [], 'Var': ''}",'QLineEdit','usercontrol',"[]")
		self.createwidget("{'Top': '45', 'Width': '100', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'ParentsType': '', 'Text': 'Update', 'Picture': '', 'Left': '420', 'Font': '', 'Help': '', 'Tag': '', 'Name': 'Button2', 'Height': '50', 'BackColor': '(1,1,1,1)', 'Visible': 'True', 'Events': '[clicked]', 'Var': ''}",'QPushButton','usercontrol',"[['clicked', 'self,e']]")
	def Widget(self):
		return self
	def connect(self,ev,evusr):
		self.wiredevents.update({ev:evusr})
	def activeXcreated(self,*args):
		pass

	def Button1_clicked(self,e):
		self.socketclienttcp1.sendall((self.ComboBoxText1.Text+"\r").encode())
		pass
	def socketclienttcp1_CommEvent(self,conn,data):
		if self.caller!=None:
			if 'on_data_recv' in self.wiredevents:	
				self.wiredevents['on_data_recv'](data)
		else:
			self.TextView1.Text+=data.decode()+"\r\n"
		pass
	def Timer1_Tick(self):
		try:
			self.socketclienttcp1.sendall("1\r".encode())
		except:
			self.Open=True	
			print("socket error")
		pass
	def Button2_clicked(self,e):
		self.ComboBoxText1.List=["WTAREGISTER^"+self.Entry1.Text+"\r","WTARELAY^"+self.Entry1.Text+"^Hello\r","WTADEVICES^\r","WTAKICK^"+self.Entry1.Text+"\r",]
		pass
	def Register(self):
		try:
			self.socketclienttcp1.sendall(("WTAREGISTER^" +self._ID + "\r").encode())
		except:
			if self.caller!=None:
				if 'on_error' in self.wiredevents:	
					self.wiredevents['on_error']("connection error")
	def SendClient(self,data):

		self.SendClientbuf.append(data)
	def SendServer(self,data):

		
		data+="\r"

		self.SendServerbuf.append(data)
	def Devices(self):
		try:
			self.socketclienttcp1.sendall((("WTADEVICES^").encode()  + "\r".encode()))
		except:
			if self.caller!=None:
				if 'on_error' in self.wiredevents:	
					self.wiredevents['on_error']("connection error")
	def socketclienttcp1_ConnectionFrom(self,conn):
		if self.caller!=None:
			if 'on_connected' in self.wiredevents:	
				self.Register()
				self.wiredevents['on_connected'](conn)
		pass
if __name__ == '__main__':
	import sys
	app = QtWidgets.QApplication(sys.argv)
	w = Handler()
	w.show()
	sys.exit(app.exec_())
