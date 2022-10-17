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
		self.create("{'Text': 'Layout1', 'Name': 'Activity', 'Help': '', 'ForeColor': '(0,0,0,1)', 'Enable': 'True', 'Picture': '', 'Top': '30', 'Tag': '', 'Font': '', 'ParentsType': '', 'Width': '643', 'Events': '[[, ]]', 'Var': '', 'Visible': 'True', 'Left': '50', 'BackColor': '(0, 0.15818675032557372, 0.9408383013784336, 0.5)', 'Height': '541'}","Layout","usercontrol","[]")
		self.mBase=forms
		self.create("{'Text': 'Layout2', 'Name': 'mBase', 'Help': '', 'ForeColor': '(0,0,0,1)', 'Enable': 'True', 'Picture': '', 'Top': '15', 'Tag': '', 'Font': '', 'ParentsType': 'Layout', 'Width': '424', 'Events': '[]', 'Var': '', 'Visible': 'True', 'Left': '25', 'BackColor': '(1.00,1.00,1.00,1)', 'Height': '465'}","Layout","Activity","[]")
		import Timer
		self.Timer1=Timer.Handler
		self.create("{'Text': 'Timer1', 'Name': 'Timer1', 'Help': '', 'ForeColor': '(0,0,0,1)', 'Enable': 'True', 'Picture': 'Timer.png', 'Top': '45', 'Tag': 'Activex', 'Font': '', 'ParentsType': 'Layout', 'Width': '30', 'Events': '[]', 'Var': '', 'Visible': 'True', 'Left': '165', 'BackColor': '(0, 0.3888056493649016, 0.4463967631327912, 0.5)', 'Height': '30', 'Interval': '1000'}","Timer","mBase","[]")
		import Timer
		self.mytimer=Timer.Handler
		self.create("{'Text': 'Timer2', 'Name': 'mytimer', 'Help': '', 'ForeColor': '(0,0,0,1)', 'Enable': 'True', 'Picture': 'Timer.png', 'Top': '85', 'Tag': 'Activex', 'Font': '', 'ParentsType': 'Layout', 'Width': '30', 'Events': '[]', 'Var': '', 'Visible': 'True', 'Left': '165', 'BackColor': '(0, 0.12027104030828939, 0.5728644378168872, 0.5)', 'Height': '30', 'Interval': '1000'}","Timer","mBase","[]")
		self.Image1=forms
		self.create("{'Text': 'Image1', 'Name': 'Image1', 'Help': '', 'ForeColor': '(0,0,0,1)', 'Enable': 'True', 'Picture': '', 'Top': '125', 'Tag': '', 'Font': '', 'ParentsType': 'Layout', 'Width': '85', 'Events': '[]', 'Var': '', 'Visible': 'True', 'Left': '90', 'BackColor': '(1,1,1,1)', 'Height': '50'}","Image","mBase","[]")
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