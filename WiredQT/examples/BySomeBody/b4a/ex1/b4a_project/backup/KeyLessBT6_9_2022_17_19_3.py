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
		self.create("{'Left': '0', 'Picture': '', 'BackColor': '(0, 0.15818675032557372, 0.9408383013784336, 0.5)', 'Text': 'Layout1', 'ParentsType': '', 'Name': 'Activity', 'Height': '665', 'Events': '[[, ]]', 'Help': '', 'Top': '0', 'Var': '', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Width': '445', 'Visible': 'True', 'Tag': '', 'Font': ''}","Layout","usercontrol","[]")
		self.mBase=forms
		self.create("{'Left': '0', 'Picture': '', 'BackColor': '(0, 0.9535890512821091, 0.7790916597141007, 0.5)', 'Text': 'Layout1', 'ParentsType': 'Layout', 'Name': 'mBase', 'Height': '665', 'Events': '[[, ]]', 'Help': '', 'Top': '0', 'Var': '', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Width': '445', 'Visible': 'True', 'Tag': '', 'Font': ''}","Layout","Activity","[]")
		self.Image1=forms
		self.create("{'Left': '0', 'Picture': 'loginSignUp.png', 'BackColor': '(1,1,1,1)', 'Text': '', 'ParentsType': 'Layout', 'Name': 'Image1', 'Height': '645', 'Events': '[button-press-event]', 'Help': '', 'Top': '0', 'Var': '', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Width': '425', 'Visible': 'True', 'Tag': '', 'Font': ''}","Image","mBase","[['button-press-event', 'self,event,e']]")
		self.btnSignUp=forms
		self.create("{'Left': '45', 'Picture': '', 'BackColor': '(0, 0.12157566880294246, 0.34919659131927605, 0.5)', 'Text': '', 'ParentsType': 'Layout', 'Name': 'btnSignUp', 'Height': '45', 'Events': '[[, ]]', 'Help': '', 'Top': '535', 'Var': '', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Width': '335', 'Visible': 'True', 'Tag': '', 'Font': ''}","Layout","mBase","[]")
		self.txtID=forms
		self.create("{'Left': '60', 'Picture': '', 'BackColor': '(1,1,1,1)', 'Text': '', 'ParentsType': 'Layout', 'Name': 'txtID', 'Height': '35', 'Alignment': 'CENTER', 'Events': '[[, ]]', 'Help': '', 'Top': '300', 'Var': '', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Width': '320', 'Visible': 'True', 'Tag': '', 'Font': ''}","Label","mBase","[]")
		self.txtPassword=forms
		self.create("{'Left': '55', 'Picture': '', 'BackColor': '(1,1,1,1)', 'Text': '', 'ParentsType': 'Layout', 'Name': 'txtPassword', 'Height': '35', 'Alignment': 'CENTER', 'Events': '[[, ]]', 'Help': '', 'Top': '375', 'Var': '', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Width': '325', 'Visible': 'True', 'Tag': '', 'Font': ''}","Label","mBase","[]")
		self.txtConfirmPass=forms
		self.create("{'Left': '60', 'Picture': '', 'BackColor': '(1,1,1,1)', 'Text': '', 'ParentsType': 'Layout', 'Name': 'txtConfirmPass', 'Height': '35', 'Alignment': '', 'Events': '[[, ]]', 'Help': '', 'Top': '445', 'Var': '', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Width': '320', 'Visible': 'True', 'Tag': '', 'Font': ''}","Label","mBase","[]")
		self.btnSignI=forms
		self.create("{'Left': '70', 'Picture': '', 'BackColor': '(1,1,1,1)', 'Text': '', 'ParentsType': 'Layout', 'Name': 'btnSignI', 'Height': '45', 'Alignment': '', 'Events': '[[, ]]', 'Help': '', 'Top': '180', 'Var': '', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Width': '135', 'Visible': 'True', 'Tag': '', 'Font': ''}","Label","mBase","[]")
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
	def Image1_button_press_event(self,event,e):
		pass
if __name__ == "__main__":
	_m = Handler()
	_m._window.show()
	Gtk.main()