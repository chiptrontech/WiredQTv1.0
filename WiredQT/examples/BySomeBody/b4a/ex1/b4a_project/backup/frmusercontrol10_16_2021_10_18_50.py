import gi
import time
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk,GObject,Gdk,Pango,GLib
from wta_module import *
#	Generated By WiredGTK for Python: by Rocky Nuarin, 2018 Phils
#	#####################www.WireThemAll.com#####################

class Handler(object):
	def __init__(self,*param):			
		initUI(self,param,w=400,h=400,title="WiredGTKV1.0",controlbox=True,startpos=(200,200),timeoutdestroy=-1)
		self.GTKForms()
		self.sch=Scheduler(500)#500 ms
		self.sch.Start()

	def unload(self,*args):
		destroy=True
		if destroy==True:
			GLib.source_remove(self.timeout_id)
			self._window.hide()
			del self._window
			#ExitApplication() #activate this if u want to destroy this window
			return False
		else:
			self.window.Visible=False
			return True		
	def loop(self, user_data):
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
	def create(self,prop,control,parent,event=[]):
		createWidget(self,prop,control,parent,event)
	def GTKForms(self):
		self.Activity=forms
		self.create("{'Width': '643', 'ParentsType': '', 'Help': '', 'Picture': '', 'Left': '75', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '-5', 'Events': '[[, ]]', 'Text': 'Layout1', 'Name': 'Activity', 'Var': '', 'Tag': '', 'Height': '541', 'Enable': 'True', 'BackColor': '(0, 0.15818675032557372, 0.9408383013784336, 0.5)', 'Font': ''}","Layout","usercontrol","[]")
		self.mBase=forms
		self.create("{'Width': '444', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '30', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '15', 'Events': '[]', 'Text': 'Layout2', 'Name': 'mBase', 'Var': '', 'Tag': '', 'Height': '520', 'Enable': 'True', 'BackColor': '(1.00,1.00,1.00,1)', 'Font': ''}","Layout","Activity","[]")
		import Timer
		self.Timer1=Timer.Handler
		self.create("{'Width': '30', 'ParentsType': 'Layout', 'Help': '', 'Picture': 'Timer.png', 'Left': '360', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '340', 'Events': '[[, ]]', 'Text': 'Timer1', 'Name': 'Timer1', 'Var': '', 'Tag': 'Activex', 'Height': '30', 'Interval': '1000', 'Enable': 'True', 'BackColor': '(0, 0.3888056493649016, 0.4463967631327912, 0.5)', 'Font': ''}","Timer","mBase","[]")
		import Timer
		self.mytimer=Timer.Handler
		self.create("{'Width': '30', 'ParentsType': 'Layout', 'Help': '', 'Picture': 'Timer.png', 'Left': '285', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '340', 'Events': '[[, ]]', 'Text': 'Timer2', 'Name': 'mytimer', 'Var': '', 'Tag': 'Activex', 'Height': '30', 'Interval': '1000', 'Enable': 'True', 'BackColor': '(0, 0.12027104030828939, 0.5728644378168872, 0.5)', 'Font': ''}","Timer","mBase","[]")
		self.Image1=forms
		self.create("{'Width': '85', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '190', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '355', 'Events': '[[, ]]', 'Text': 'Image1', 'Name': 'Image1', 'Var': '', 'Tag': '', 'Height': '50', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Image","mBase","[]")
		self.Button1=forms
		self.create("{'Width': '100', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '55', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '300', 'Events': '[[, ]]', 'Text': 'Button1', 'Name': 'Button1', 'Var': '', 'Tag': '', 'Height': '50', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Button","mBase","[]")
		self.Button2=forms
		self.create("{'Width': '100', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '170', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '300', 'Events': '[[, ]]', 'Text': 'Connect BT', 'Name': 'Button2', 'Var': '', 'Tag': '', 'Height': '50', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Button","mBase","[]")
		self.Label1=forms
		self.create("{'Width': '345', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '55', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '30', 'Alignment': '', 'Events': '[]', 'Text': 'Power Logger App', 'Name': 'Label1', 'Var': '', 'Tag': '', 'Height': '70', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Label","mBase","[]")
		self.Label2=forms
		self.create("{'Width': '220', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '55', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '125', 'Alignment': '', 'Events': '[[, ]]', 'Text': 'V', 'Name': 'Label2', 'Var': '', 'Tag': '', 'Height': '30', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Label","mBase","[]")
		self.Label3=forms
		self.create("{'Width': '220', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '55', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '165', 'Alignment': '', 'Events': '[[, ]]', 'Text': 'A', 'Name': 'Label3', 'Var': '', 'Tag': '', 'Height': '30', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Label","mBase","[]")
		self.Label4=forms
		self.create("{'Width': '220', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '55', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '200', 'Alignment': '', 'Events': '[[, ]]', 'Text': 'W', 'Name': 'Label4', 'Var': '', 'Tag': '', 'Height': '30', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Label","mBase","[]")
		self.Label5=forms
		self.create("{'Width': '220', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '55', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '240', 'Alignment': '', 'Events': '[[, ]]', 'Text': 'WH', 'Name': 'Label5', 'Var': '', 'Tag': '', 'Height': '30', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Label","mBase","[]")
		self.Button3=forms
		self.create("{'Width': '80', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '55', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '360', 'Events': '[[, ]]', 'Text': 'Button3', 'Name': 'Button3', 'Var': '', 'Tag': '', 'Height': '35', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Button","mBase","[]")
		self.Layout1=forms
		self.create("{'Width': '75', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '115', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '405', 'Events': '[[, ]]', 'Text': 'Layout1', 'Name': 'Layout1', 'Var': '', 'Tag': '', 'Height': '40', 'Enable': 'True', 'BackColor': '(0, 0.4361869060461, 0.42905835405256687, 0.5)', 'Font': ''}","Layout","mBase","[]")
		self.Label6=forms
		self.create("{'Width': '20', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '25', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '5', 'Alignment': '', 'Events': '[[, ]]', 'Text': '^', 'Name': 'Label6', 'Var': '', 'Tag': '', 'Height': '25', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Label","Layout1","[]")
		self.Layout2=forms
		self.create("{'Width': '75', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '115', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '455', 'Events': '[[, ]]', 'Text': 'v', 'Name': 'Layout2', 'Var': '', 'Tag': '', 'Height': '40', 'Enable': 'True', 'BackColor': '(0, 0.4361869060461, 0.42905835405256687, 0.5)', 'Font': ''}","Layout","mBase","[]")
		self.Label7=forms
		self.create("{'Width': '20', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '25', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '5', 'Alignment': '', 'Events': '[[, ]]', 'Text': 'v', 'Name': 'Label7', 'Var': '', 'Tag': '', 'Height': '25', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Label","Layout2","[]")
		self.Layout3=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '40', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '430', 'Events': '[[, ]]', 'Text': 'Layout1', 'Name': 'Layout3', 'Var': '', 'Tag': '', 'Height': '40', 'Enable': 'True', 'BackColor': '(0, 0.4361869060461, 0.42905835405256687, 0.5)', 'Font': ''}","Layout","mBase","[]")
		self.Label8=forms
		self.create("{'Width': '15', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '25', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '5', 'Alignment': '', 'Events': '[[, ]]', 'Text': '<', 'Name': 'Label8', 'Var': '', 'Tag': '', 'Height': '25', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Label","Layout3","[]")
		self.Layout4=forms
		self.create("{'Width': '70', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '205', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '430', 'Events': '[[, ]]', 'Text': 'Layout1', 'Name': 'Layout4', 'Var': '', 'Tag': '', 'Height': '40', 'Enable': 'True', 'BackColor': '(0, 0.4361869060461, 0.42905835405256687, 0.5)', 'Font': ''}","Layout","mBase","[]")
		self.Label9=forms
		self.create("{'Width': '25', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '20', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '5', 'Alignment': '', 'Events': '[[, ]]', 'Text': '>', 'Name': 'Label9', 'Var': '', 'Tag': '', 'Height': '25', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Label","Layout4","[]")
		self.Layout5=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '285', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '425', 'Events': '[[, ]]', 'Text': 'Layout1', 'Name': 'Layout5', 'Var': '', 'Tag': '', 'Height': '40', 'Enable': 'True', 'BackColor': '(0, 0.4361869060461, 0.42905835405256687, 0.5)', 'Font': ''}","Layout","mBase","[]")
		self.Label10=forms
		self.create("{'Width': '15', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '25', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '5', 'Alignment': '', 'Events': '[[, ]]', 'Text': 'Label10', 'Name': 'Label10', 'Var': '', 'Tag': '', 'Height': '25', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Label","Layout5","[]")
		self.Layout6=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '285', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '465', 'Events': '[[, ]]', 'Text': 'Layout1', 'Name': 'Layout6', 'Var': '', 'Tag': '', 'Height': '40', 'Enable': 'True', 'BackColor': '(0, 0.4361869060461, 0.42905835405256687, 0.5)', 'Font': ''}","Layout","mBase","[]")
		self.Label11=forms
		self.create("{'Width': '15', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '25', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '5', 'Alignment': '', 'Events': '[[, ]]', 'Text': 'Label11', 'Name': 'Label11', 'Var': '', 'Tag': '', 'Height': '25', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Label","Layout6","[]")
		self.Layout7=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '355', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '425', 'Events': '[[, ]]', 'Text': 'Layout1', 'Name': 'Layout7', 'Var': '', 'Tag': '', 'Height': '40', 'Enable': 'True', 'BackColor': '(0, 0.4361869060461, 0.42905835405256687, 0.5)', 'Font': ''}","Layout","mBase","[]")
		self.Label12=forms
		self.create("{'Width': '15', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '25', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '5', 'Alignment': '', 'Events': '[[, ]]', 'Text': 'Label12', 'Name': 'Label12', 'Var': '', 'Tag': '', 'Height': '25', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Label","Layout7","[]")
		self.Layout8=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '355', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '465', 'Events': '[[, ]]', 'Text': 'Layout1', 'Name': 'Layout8', 'Var': '', 'Tag': '', 'Height': '40', 'Enable': 'True', 'BackColor': '(0, 0.4361869060461, 0.42905835405256687, 0.5)', 'Font': ''}","Layout","mBase","[]")
		self.Label13=forms
		self.create("{'Width': '15', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '25', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '5', 'Alignment': '', 'Events': '[[, ]]', 'Text': 'Label13', 'Name': 'Label13', 'Var': '', 'Tag': '', 'Height': '25', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Label","Layout8","[]")
		self.txts11=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '285', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '115', 'Alignment': '', 'Events': '[]', 'Text': '0', 'Name': 'txts11', 'Var': '', 'Tag': '', 'Height': '30', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Entry","mBase","[]")
		self.txts12=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '350', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '115', 'Alignment': '', 'Events': '[]', 'Text': '180', 'Name': 'txts12', 'Var': '', 'Tag': '', 'Height': '30', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Entry","mBase","[]")
		self.btnservo11=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '285', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '150', 'Events': '[]', 'Text': '1', 'Name': 'btnservo11', 'Var': '', 'Tag': '', 'Height': '35', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Button","mBase","[]")
		self.btnservo12=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '349', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '152', 'Events': '[]', 'Text': '1', 'Name': 'btnservo12', 'Var': '', 'Tag': '', 'Height': '35', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Button","mBase","[]")
		self.btnservo22=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '355', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '65', 'Events': '[]', 'Text': '1', 'Name': 'btnservo22', 'Var': '', 'Tag': '', 'Height': '35', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Button","mBase","[]")
		self.btnservo21=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '285', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '65', 'Events': '[]', 'Text': '1', 'Name': 'btnservo21', 'Var': '', 'Tag': '', 'Height': '35', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Button","mBase","[]")
		self.txts22=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '355', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '30', 'Alignment': '', 'Events': '[]', 'Text': '180', 'Name': 'txts22', 'Var': '', 'Tag': '', 'Height': '30', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Entry","mBase","[]")
		self.txts21=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '285', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '30', 'Alignment': '', 'Events': '[]', 'Text': '0', 'Name': 'txts21', 'Var': '', 'Tag': '', 'Height': '30', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Entry","mBase","[]")
		self.txts31=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '284', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '195', 'Alignment': '', 'Events': '[]', 'Text': '0', 'Name': 'txts31', 'Var': '', 'Tag': '', 'Height': '30', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Entry","mBase","[]")
		self.txts32=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '349', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '195', 'Alignment': '', 'Events': '[]', 'Text': '180', 'Name': 'txts32', 'Var': '', 'Tag': '', 'Height': '30', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Entry","mBase","[]")
		self.btnservo31=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '284', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '230', 'Events': '[]', 'Text': '1', 'Name': 'btnservo31', 'Var': '', 'Tag': '', 'Height': '35', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Button","mBase","[]")
		self.btnservo32=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '349', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '232', 'Events': '[]', 'Text': '1', 'Name': 'btnservo32', 'Var': '', 'Tag': '', 'Height': '35', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Button","mBase","[]")
		self.txts41=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '285', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '270', 'Alignment': '', 'Events': '[]', 'Text': '0', 'Name': 'txts41', 'Var': '', 'Tag': '', 'Height': '30', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Entry","mBase","[]")
		self.txts42=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '350', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '265', 'Alignment': '', 'Events': '[]', 'Text': '180', 'Name': 'txts42', 'Var': '', 'Tag': '', 'Height': '30', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Entry","mBase","[]")
		self.btnservo42=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '350', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '305', 'Events': '[]', 'Text': '1', 'Name': 'btnservo42', 'Var': '', 'Tag': '', 'Height': '35', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Button","mBase","[]")
		self.btnservo41=forms
		self.create("{'Width': '60', 'ParentsType': 'Layout', 'Help': '', 'Picture': '', 'Left': '285', 'ForeColor': '(0,0,0,1)', 'Visible': 'True', 'Top': '307', 'Events': '[]', 'Text': '1', 'Name': 'btnservo41', 'Var': '', 'Tag': '', 'Height': '35', 'Enable': 'True', 'BackColor': '(1,1,1,1)', 'Font': ''}","Button","mBase","[]")
	def Widget(self):
		if self._usercontrol in self._mainlayout.get_children():
			self._mainlayout.remove(self._usercontrol)
		return self._usercontrol
	def Hide(self):
		self._window.hide()
	def Show(self,modal=False,x=None,y=None):
		if x!=None:
			self._window.move(x,y)
		self._window.set_modal(modal)
		self._window.show()
		Gtk.main()
		return ""#put ur return value here upon closing this form
if __name__ == "__main__":
	_m = Handler()
	_m._window.show()
	Gtk.main()