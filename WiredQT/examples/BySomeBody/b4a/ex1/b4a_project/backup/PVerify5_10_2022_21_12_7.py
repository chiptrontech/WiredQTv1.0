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
		self.create("{'Picture': '', 'Tag': '', 'Height': '645', 'Width': '405', 'Enable': 'True', 'Var': '', 'Events': '[]', 'ForeColor': '(0,0,0,1)', 'Left': '-10', 'ParentsType': '', 'BackColor': '(0, 0.15818675032557372, 0.9408383013784336, 0.5)', 'Top': '-5', 'Text': 'Layout1', 'Name': 'Activity', 'Visible': 'True', 'Font': '', 'Help': ''}","Layout","usercontrol","[]")
		self.mBase=forms
		self.create("{'Picture': '', 'Tag': '', 'Height': '645', 'Width': '405', 'Enable': 'True', 'Var': '', 'Events': '[]', 'ForeColor': '(0,0,0,1)', 'Left': '0', 'ParentsType': 'Layout', 'BackColor': '(0, 0.9535890512821091, 0.7790916597141007, 0.5)', 'Top': '0', 'Text': 'Layout1', 'Name': 'mBase', 'Visible': 'True', 'Font': '', 'Help': ''}","Layout","Activity","[]")
		self.Image1=forms
		self.create("{'Picture': 'AppointmentsSubModule-6e904.png', 'Tag': '', 'Height': '645', 'Width': '405', 'Enable': 'True', 'Var': '', 'Events': '[[, ]]', 'ForeColor': '(0,0,0,1)', 'Left': '0', 'ParentsType': 'Layout', 'BackColor': '(1,1,1,1)', 'Top': '0', 'Text': '', 'Name': 'Image1', 'Visible': 'True', 'Font': '', 'Help': ''}","Image","mBase","[]")
		self.btnAppointment=forms
		self.create("{'Picture': '', 'Tag': '', 'Height': '30', 'Width': '175', 'Enable': 'True', 'Var': '', 'Events': '[[, ]]', 'ForeColor': '(0,0,0,1)', 'Left': '115', 'ParentsType': 'Layout', 'BackColor': '(0, 0.5947705885149066, 0.6256477024706841, 0.5)', 'Top': '195', 'Text': '', 'Name': 'btnAppointment', 'Visible': 'True', 'Font': '', 'Help': ''}","Layout","mBase","[]")
		self.btnBack=forms
		self.create("{'Picture': '', 'Tag': '', 'Height': '40', 'Width': '55', 'Enable': 'True', 'Var': '', 'Events': '[[, ]]', 'ForeColor': '(0,0,0,1)', 'Left': '25', 'ParentsType': 'Layout', 'BackColor': '(0, 0.5485275470322745, 0.40684617506831855, 0.5)', 'Top': '10', 'Text': '', 'Name': 'btnBack', 'Visible': 'True', 'Font': '', 'Help': ''}","Layout","mBase","[]")
		self.btnQr=forms
		self.create("{'Picture': '', 'Tag': '', 'Height': '40', 'Width': '55', 'Enable': 'True', 'Var': '', 'Events': '[[, ]]', 'ForeColor': '(0,0,0,1)', 'Left': '330', 'ParentsType': 'Layout', 'BackColor': '(0, 0.5485275470322745, 0.40684617506831855, 0.5)', 'Top': '10', 'Text': '', 'Name': 'btnQr', 'Visible': 'True', 'Font': '', 'Help': ''}","Layout","mBase","[]")
		self.lbl_startStop1=forms
		self.create("{'Picture': '', 'Tag': '', 'Height': '30', 'Width': '185', 'Enable': 'True', 'Var': '', 'Alignment': '', 'Events': '[[, ]]', 'ForeColor': '(0,0,0,1)', 'Left': '80', 'ParentsType': 'Layout', 'BackColor': '(1,1,1,1)', 'Top': '260', 'Text': '', 'Name': 'lbl_startStop1', 'Visible': 'True', 'Font': '', 'Help': ''}","Label","mBase","[]")
		self.lblDesc1=forms
		self.create("{'Picture': '', 'Tag': '', 'Height': '75', 'Width': '345', 'Enable': 'True', 'Var': '', 'Alignment': '', 'Events': '[[, ]]', 'ForeColor': '(0,0,0,1)', 'Left': '30', 'ParentsType': 'Layout', 'BackColor': '(1,1,1,1)', 'Top': '290', 'Text': '', 'Name': 'lblDesc1', 'Visible': 'True', 'Font': '', 'Help': ''}","Label","mBase","[]")
		self.lblDate1=forms
		self.create("{'Picture': '', 'Tag': '', 'Height': '30', 'Width': '110', 'Enable': 'True', 'Var': '', 'Alignment': '', 'Events': '[[, ]]', 'ForeColor': '(0,0,0,1)', 'Left': '265', 'ParentsType': 'Layout', 'BackColor': '(1,1,1,1)', 'Top': '260', 'Text': '', 'Name': 'lblDate1', 'Visible': 'True', 'Font': '', 'Help': ''}","Label","mBase","[]")
		self.lbl_startStop2=forms
		self.create("{'Picture': '', 'Tag': '', 'Height': '30', 'Width': '185', 'Enable': 'True', 'Var': '', 'Alignment': '', 'Events': '[[, ]]', 'ForeColor': '(0,0,0,1)', 'Left': '80', 'ParentsType': 'Layout', 'BackColor': '(1,1,1,1)', 'Top': '390', 'Text': '', 'Name': 'lbl_startStop2', 'Visible': 'True', 'Font': '', 'Help': ''}","Label","mBase","[]")
		self.lblDate2=forms
		self.create("{'Picture': '', 'Tag': '', 'Height': '30', 'Width': '110', 'Enable': 'True', 'Var': '', 'Alignment': '', 'Events': '[[, ]]', 'ForeColor': '(0,0,0,1)', 'Left': '265', 'ParentsType': 'Layout', 'BackColor': '(1,1,1,1)', 'Top': '390', 'Text': '', 'Name': 'lblDate2', 'Visible': 'True', 'Font': '', 'Help': ''}","Label","mBase","[]")
		self.lblDesc2=forms
		self.create("{'Picture': '', 'Tag': '', 'Height': '75', 'Width': '345', 'Enable': 'True', 'Var': '', 'Alignment': '', 'Events': '[[, ]]', 'ForeColor': '(0,0,0,1)', 'Left': '30', 'ParentsType': 'Layout', 'BackColor': '(1,1,1,1)', 'Top': '420', 'Text': '', 'Name': 'lblDesc2', 'Visible': 'True', 'Font': '', 'Help': ''}","Label","mBase","[]")
		self.lbl_startStop3=forms
		self.create("{'Picture': '', 'Tag': '', 'Height': '30', 'Width': '185', 'Enable': 'True', 'Var': '', 'Alignment': '', 'Events': '[[, ]]', 'ForeColor': '(0,0,0,1)', 'Left': '80', 'ParentsType': 'Layout', 'BackColor': '(1,1,1,1)', 'Top': '520', 'Text': '', 'Name': 'lbl_startStop3', 'Visible': 'True', 'Font': '', 'Help': ''}","Label","mBase","[]")
		self.lblDate3=forms
		self.create("{'Picture': '', 'Tag': '', 'Height': '30', 'Width': '110', 'Enable': 'True', 'Var': '', 'Alignment': '', 'Events': '[[, ]]', 'ForeColor': '(0,0,0,1)', 'Left': '265', 'ParentsType': 'Layout', 'BackColor': '(1,1,1,1)', 'Top': '520', 'Text': '', 'Name': 'lblDate3', 'Visible': 'True', 'Font': '', 'Help': ''}","Label","mBase","[]")
		self.lblDesc3=forms
		self.create("{'Picture': '', 'Tag': '', 'Height': '75', 'Width': '345', 'Enable': 'True', 'Var': '', 'Alignment': '', 'Events': '[[, ]]', 'ForeColor': '(0,0,0,1)', 'Left': '30', 'ParentsType': 'Layout', 'BackColor': '(1,1,1,1)', 'Top': '550', 'Text': '', 'Name': 'lblDesc3', 'Visible': 'True', 'Font': '', 'Help': ''}","Label","mBase","[]")
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