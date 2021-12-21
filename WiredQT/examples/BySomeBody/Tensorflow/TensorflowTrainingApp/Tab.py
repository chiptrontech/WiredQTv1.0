from PyQt5 import QtCore, QtWidgets
from PyQt5.QtGui import * 
from wired_module import * 
#	Generated By WiredQT for Python: by Rocky Nuarin, 2021 Phils
class Handler(QtWidgets.QWidget,usercontrol):
	#WiredEvent def Tick()	
	#WiredProperty 'Interval': '1000'	
	def __init__(self, *param):    
		super(Handler, self).__init__(None)
		initUI(self,param,w=1366,h=768,title="WiredQT v1.0",controlbox=True,startpos=(0,30),timeoutdestroy=-1)
		self.GTKForms()
		self.timer=QtCore.QTimer()
		self.timer.timeout.connect(self.loop)
		self.timer.start(10)       		
		self.sch=Scheduler(0)
		self.sch.Start()
		self._text=''
		self.showtab=True

		self._TabVisible=True
		self._BackColor='(1,1,1,0)'
	@property
	def BackColorTab(self):
		return self._BackColor
	@BackColorTab.setter	
	def BackColorTab(self,value):
		#import pdb;pdb.set_trace();
		if type(value)==str:
			value=eval(value)
		self._BackColor=value
		self.Viewport1.BackColor=self._BackColor
	@property
	def TabVisible(self):
		return TrueFalse(self._TabVisible)
	@TabVisible.setter	
	def TabVisible(self,value):
		self._TabVisible=TrueFalse(value)
		try:
			if self._TabVisible==True:
				for i,a in enumerate(self.btn):
					a.Visible=True
					self.tab[i].Top=30
			else:
				for i,a in enumerate(self.btn):
					a.Visible=False
					self.tab[i].Top=0
		except:
			value=value
	def TabLabel(self,index,label):
		self.label[index]=label
		self.btn[index].Text=label
	def arrangetabs(self):
		self.tab=[]
		self.label=[]
		self.btn=[]
		#import pdb;pdb.set_trace()
		for a in dir(self.caller):
			try:
				a=eval("self.caller."+a)
				if len(str(type(a)))>len("<class \'tab") and str(type(a))[:len("<class \'tab")]=="<class \'tab" and a!=self:
					if (a in self.tab)==False:
						self.tab.append(a)
						self.label.append("Tab "+str(len(self.label)+1))
			except:
				pass
		#import pdb;pdb.set_trace();	
		
		#sort by tab.Left#

		#array of tab.Left,tab.label
		x=[[a.Left,a,b] for a,b in zip(self.tab,self.label)]
		#sort by first index
		def sortthis(item):
			return item[0]
		x=sorted(x, key=sortthis)
		#return sorted value
		self.tab= [a[1] for a in x]
		self.label= [a[2] for a in x]
		for i,a in enumerate(self.tab):
			
			btn=QPushButton()
		
			btn.setParent(self)
			btn=forms(btn)
			self.btn.append(btn)
			btn.Text=self.label[i]
			btn.Width=100
			btn.Height=20
			
			btn.Left=i*100
			btn.Top=0
			btn.Visible=True
			#btn.connect("clicked",self.Tab)
			btn.obj.clicked.connect(self.Tab)
			self.tab[i].Width=self.Width
			self.tab[i].Height=self.Height-20
			
			
			#self.caller.usercontrol.remove(self.tab[i]._usercontrol)
			#self.usercontrol.put(self.tab[i]._usercontrol,30,0)
			self.tab[i].setParent(None)
			self.tab[i].setParent(self)
			self.tab[i].Top=30
			self.tab[i].Left=0#self.usercontrol.Left
			#print(a,self.tab[i])

			if i!=0:
				self.tab[i].Visible=False
		self.setvisible(0)
		self.TabVisible=self._TabVisible
	def Tab(self,args):
		args=self.sender()
		if type(args)==QPushButton:
			a=self.label.index(forms(args).Text)
		else:
			a=args
		self.setvisible(a)
		if self.caller!=None and 'tabchange' in self.wiredevents:self.wiredevents['tabchange'](a)
		pass
	def setvisible(self,index):
		for i,a in enumerate(self.tab):
			a.Visible=False
			self.btn[i].ForeColor=(0,0,0,1)
		self.tab[index].Visible=True
		self.btn[index].ForeColor=(0,0,1,1)
		pass

	def connect(self,ev,evusr):
		self.wiredevents.update({ev:evusr})
	def activeXcreated(self,*args):
		self.Viewport1.Width=self.Width
		self.Viewport1.Height=self.Height
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
		self.createwidget("{'Left': '0', 'Events': [], 'Top': '0', 'Tag': '', 'Enable': 'True', 'Name': 'Viewport1', 'Var': '', 'Width': '240', 'Height': '125', 'Font': '', 'ForeColor': '(0.92,0.59,0.59,0.3)', 'Picture': '', 'BackColor': '(0.92,0.59,0.59,0.3)', 'Text': '', 'Visible': 'True', 'ParentsType': '', 'Help': ''}",'QWidget','usercontrol',"[]")
	def Widget(self):
		return self
if __name__ == '__main__':
	import sys
	app = QtWidgets.QApplication(sys.argv)
	w = Handler()
	w.show()
	sys.exit(app.exec_())