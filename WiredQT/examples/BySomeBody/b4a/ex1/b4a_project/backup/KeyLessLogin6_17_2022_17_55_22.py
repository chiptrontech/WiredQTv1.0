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
		self.create("{'Events': '[[, ]]', 'Width': '465', 'Var': '', 'Tag': '', 'Text': 'Layout1', 'ParentsType': '', 'Help': '', 'BackColor': '(0, 0.15818675032557372, 0.9408383013784336, 0.5)', 'Left': '0', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Height': '685', 'Visible': 'True', 'Font': '', 'Name': 'Activity', 'Top': '0', 'Picture': ''}","Layout","usercontrol","[]")
		self.mBase=forms
		self.create("{'Events': '[[, ]]', 'Width': '445', 'Var': '', 'Tag': '', 'Text': 'Layout1', 'ParentsType': 'Layout', 'Help': '', 'BackColor': '(0, 0.9535890512821091, 0.7790916597141007, 0.5)', 'Left': '0', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Height': '665', 'Visible': 'True', 'Font': '', 'Name': 'mBase', 'Top': '0', 'Picture': ''}","Layout","Activity","[]")
		self.Image1=forms
		self.create("{'Events': '[button-press-event]', 'Width': '425', 'Var': '', 'Tag': '', 'Text': '', 'ParentsType': 'Layout', 'Help': '', 'BackColor': '(1,1,1,1)', 'Left': '0', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Height': '645', 'Visible': 'True', 'Font': '', 'Name': 'Image1', 'Top': '0', 'Picture': 'loginSignIn.png'}","Image","mBase","[['button-press-event', 'self,event,e']]")
		self.btnSignIn=forms
		self.create("{'Events': '[[, ]]', 'Width': '335', 'Var': '', 'Tag': '', 'Text': '', 'ParentsType': 'Layout', 'Help': '', 'BackColor': '(1.00,1.00,1.00,1)', 'Left': '45', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Height': '45', 'Visible': 'True', 'Font': '', 'Name': 'btnSignIn', 'Top': '535', 'Picture': ''}","Layout","mBase","[]")
		self.txtID=forms
		self.create("{'Events': '[[, ]]', 'Width': '320', 'Var': '', 'Tag': '', 'Text': '', 'ParentsType': 'Layout', 'Alignment': 'CENTER', 'Help': '', 'BackColor': '(1,1,1,1)', 'Left': '60', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Height': '35', 'Visible': 'True', 'Font': '', 'Name': 'txtID', 'Top': '300', 'Picture': ''}","Label","mBase","[]")
		self.txtPassword=forms
		self.create("{'Events': '[[, ]]', 'Width': '325', 'Var': '', 'Tag': '', 'Text': '', 'ParentsType': 'Layout', 'Alignment': 'CENTER', 'Help': '', 'BackColor': '(1,1,1,1)', 'Left': '55', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Height': '35', 'Visible': 'True', 'Font': '', 'Name': 'txtPassword', 'Top': '375', 'Picture': ''}","Label","mBase","[]")
		self.btnofflineA=forms
		self.create("{'Events': '[[, ]]', 'Width': '125', 'Var': '', 'Tag': '', 'Text': '', 'ParentsType': 'Layout', 'Alignment': '', 'Help': '', 'BackColor': '(1,1,1,1)', 'Left': '290', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Height': '35', 'Visible': 'True', 'Font': '', 'Name': 'btnofflineA', 'Top': '15', 'Picture': ''}","Label","mBase","[]")
		self.btnSignU=forms
		self.create("{'Events': '[[, ]]', 'Width': '140', 'Var': '', 'Tag': '', 'Text': '', 'ParentsType': 'Layout', 'Alignment': '', 'Help': '', 'BackColor': '(1,1,1,1)', 'Left': '215', 'Enable': 'True', 'ForeColor': '(0,0,0,1)', 'Height': '45', 'Visible': 'True', 'Font': '', 'Name': 'btnSignU', 'Top': '180', 'Picture': ''}","Label","mBase","[]")
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