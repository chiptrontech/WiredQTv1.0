import time
import datetime
import os
from PIL import Image
import gi
gi.require_version('Gtk', '3.0')

from gi.repository import Gtk,GObject,Gdk,GdkPixbuf,Pango,GLib
try:
	gi.require_version('GtkSource', '3.0')
	from gi.repository import GtkSource
except:
	pass
try:
	import RPi.GPIO as GPIO
	GPIO.setmode(GPIO.BCM)
	GPIO.setwarnings(False)
	HIGH=GPIO.HIGH
	LOW=GPIO.LOW
	INPUT=GPIO.IN
	OUTPUT=GPIO.OUT
	INPUT_PULLUP=GPIO.PUD_UP
	def digitalWrite(pin,state):
		GPIO.output(pin,state)
	def digitalRead(pin):
		return HIGH if GPIO.input(pin) else LOW
	def pinMode(pin,direction):
		if direction==INPUT_PULLUP:
			GPIO.setup(pin,GPIO.IN,pull_up_down=GPIO.PUD_UP)
		else:
			GPIO.setup(pin,direction)
except:
	print ("")
try:
	import cv2
except:
	print ("Install cv2")
try:
	import ctypes
	user32 = ctypes.windll.user32
	screensize = [user32.GetSystemMetrics(0), user32.GetSystemMetrics(1)]
	resizeW=float(screensize[0]/1366.0)
	resizeH=float(screensize[1]/768.0)	
	print (screensize)
except:
	screensize = [1320, 768]
	resizeW=float(screensize[0]/1320.0)
	resizeH=float(screensize[1]/768.0)
def millis():
	return time.time()*1000
class Scheduler:
	def __init__(self,ms_timeout):
		self._ms_timeout=ms_timeout
		self._flag=False
		self._startms=0
	def Start(self):
		self._startms=millis()
		self._flag=True;
	def Stop(self):
		self._flag=False;		
	def Event(self):
		buf=0;
		if(self._flag==False):
			return False;
		buf=millis()-self._startms;
		if(buf>=self._ms_timeout):
			self._flag=False;
			return True;
		else:
			return False;
def getCSV(x,delimiter,str_data):
	getCSVret = ""
	if(x<0):
		return ""       #if negative index
	b = 0
	while (x != 0):
		if (str_data[b] == delimiter):
			x = x - 1
		b = b + 1
	if(b>=len(str_data)):
		return ""       #if index out of range
	while ((str_data[b] != delimiter) and ((len(str_data)+1) != b)):
		getCSVret = getCSVret + str_data[b]
		b = b + 1
		if(b>=len(str_data)):
			break
	return getCSVret

def delay(x):
	time.sleep(x*1.0/1000)
def delayMicroseconds(x):

	time.sleep(x*1.0/1000000)

class LapTimer:
	def __init__(self):
		self.startms=millis();
		self.started=False;
	def start(self):
		self.started=True;
		self.startms=millis();
	def stop(self):
		self.started=False;
	def currTime(self):
		return millis()-self.startms;
class Poll(object):
	def __init__(self,search):
		self.currPointer=0
		self.size_st=len(search)
		self.st=search
	def Poll(self,x):
		if(self.st[self.currPointer]==x):
			self.currPointer=self.currPointer+1
		else:
			self.currPointer=0;
			if(self.st[self.currPointer]==x):		#WTF 
				self.currPointer=self.currPointer+1	#WTF				
		if(self.currPointer==self.size_st):
			self.currPointer=0
			return True
		return False	
'''
x=ParserLangguage(sequence="eat that")
word="dont\teat\r\t that\nball\r"        
t=x.Parse(word)
print(word[t[0]:])
print(word[t[1]:])
returns tuple of start and end if sequence is found in word
return None if not found
'''
class ParserLangguage:
	def __init__(self,sequence,wspace="\r\n\t \'\"("):
		self.sequence=sequence.split()
		self.poll=[]
		for a in self.sequence:
			_poll=Poll(a)
			self.poll.append(_poll)
		self.wspace=wspace

	def Parse(self,strings):
		curr_sequence=0
		strs=""
		start=0
		end=0
		for i,a in enumerate(strings):
			if a in self.wspace:
				#print(strs)
				if strs!="" and curr_sequence!=0:
					curr_sequence=0	#word not in order,reset curr_sequence
				strs=""
				continue
			strs+=a
			if self.poll[curr_sequence].Poll(a):
				if self.sequence[curr_sequence]==strs:
					#print(i,strs)
					curr_sequence+=1
					if curr_sequence==1:
						start=i-len(strs)+1
					if curr_sequence==len(self.sequence):
						end=i+1
						return start,end 
					strs=""
		return None			

class Parser():
	def __init__(self,_header,_terminator,numterminator,_sizeofdata=10):
		self.size=_sizeofdata
		self._numterminator=numterminator
		self._numterminatorbuf=0
		self.terminator=_terminator
		self.st=_header
		self.currPointer=0
		self.state=False
		self.size_st=len(_header);
	def Poll(self,x):
		if(self.st[self.currPointer]==x):
			self.currPointer=self.currPointer+1
		else:
			self.currPointer=0;
		if(self.currPointer==self.size_st):
			self.currPointer=0
			return True
		return False
	def available(self,x):
		if(self.Poll(x)==True):
			self.state=True
			#self.index=0
			self.data=""
			return False
		if(self.state):
			if(x==self.terminator or self.terminator==''):
				self._numterminatorbuf=self._numterminatorbuf+1
				if(self._numterminator==self._numterminatorbuf):
					self._numterminatorbuf=0
					#*(data+(index%size))=0;
					self.state=False;
					return True
			self.data=self.data+x
				#self.index++
		return False


def Map(x, in_min , in_max , out_min, out_max):
	return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min

def Constrain(amt, low, high):
	if (amt < low):
		amt = low
	if (amt > high):
		amt = high
	return amt



def GetFileSize(fname):
	fname=fname.replace('\\','/')
	return os.stat(fname).st_size
def GetFileStr(fname):
	fname=fname.replace('\\','/')
	fo = open(fname, "r+")
	str = fo.read(GetFileSize(fname))
	return str
def SaveFileStr(fname,str_to_write):
	fname=fname.replace('\\','/')
	fo = open(fname, "w")
	fo.write(str_to_write);
	fo.close()
def FileExist(fname):
	fname=fname.replace('\\','/')
	return os.path.exists(fname)
def ListAllFile():
	return filter(os.path.isfile, os.listdir('.')) 
def ListAllDir():
	return filter(os.path.isdir, os.listdir('.'))
def GetFilename(fname):
	fname=fname.replace('\\','/')
	ret=""
	for a in fname[::-1]:
		if a=='\\' or a=='/':
			break        
		ret+=a
	return ret[::-1]
def GetFilenameNoEXT(fname):
	
	strs=GetFilename(fname)
	ret=""
	for a in strs:
		if a=='.':
			break        
		ret+=a    
	return ret
def GetPath(fname):
	
	ret=GetFilename(fname)
	return fname.replace("/"+ret,"")

def CreateFileName():
	s=time.localtime(time.time())
	return str(s.tm_mon) + '_'+str(s.tm_mday) + '_'+str(s.tm_year) + '_'+str(s.tm_hour) + '_'+str(s.tm_min) + '_'+str(s.tm_sec) 
def DateToString():
	s=time.localtime(time.time())
	return str(s.tm_mon) + '/'+str(s.tm_mday) + '/'+str(s.tm_year) 
def Date():
	s=time.localtime(time.time())
	return datetime.date(s.tm_year,s.tm_mon,s.tm_mday) 

def TimeToString():
	s=time.localtime(time.time())
	return str(s.tm_hour) + ':'+str(s.tm_min) + ':'+str(s.tm_sec)
def Time():
	s=time.localtime(time.time())
	return datetime.time(s.tm_hour,s.tm_min,s.tm_sec)
def Now():
	return datetime.datetime.now()
def NowToString():
	s=Now()
	return str(s.month) + "/" +str(s.day)  + "/" + str(s.year)  + " " +str(s.hour)  + ":" +str(s.minute)  + ":" +str(s.second)

def TimeInBetween(mintime,maxtime,curr):
	return (mintime<=curr) and (maxtime>=curr)




import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk,GObject,Gdk
Colors_BLACK=0.0, 0.0, 0.0, 1.0	
Colors_WHITE=1.0, 1.0, 1.0, 1.0	
Colors_RED=1.0, 0.0, 0.0, 1.0	
Colors_GREEN=0.0, 1.0, 0.0, 1.0
Colors_BLUE=0.0, 0.0, 1.0, 1.0	
def refreshGTK():
	while Gtk.events_pending():
		Gtk.main_iteration()
def TrueFalse(val):
	if type(val)==str:
		if val=="True":
			return True; 
		else:
			return False;
	else:	
		return val;
def ExitApplication():
	Gtk.main_quit()
def initUI(self,param,w=screensize[0],h=screensize[1],title="WiredGTKV1.0",controlbox=True,startpos=(0,0),timeoutdestroy=-1,background=None):
	self.caller=None
	self.param=None
	self.wiredevents={}
	if len(param)!=0:
		self.caller=param[0]
		if len(param)>1:
			self.param=param[1]	
	dir_path = os.path.dirname(os.path.realpath(__file__))
	os.chdir(dir_path)		
	
	self._window = Gtk.Window();self._window.connect("delete-event", self.unload);self.window=forms(self._window)
	self._window.set_decorated(controlbox);self._window.move(startpos[0],startpos[1]);
	self.timeoutdestroy=timeoutdestroy;
	self._mainlayout=Gtk.Layout();self.layout=forms(self._mainlayout);self._mainlayout.show();self.layout.Dimension=w,h;self._window.add(self._mainlayout);
	self._usercontrol=Gtk.Layout();self.usercontrol=forms(self._usercontrol);self._usercontrol.show();self.usercontrol.Dimension=1366,768;self._mainlayout.put(self._usercontrol,0,0);
	self._window.set_icon_from_file("icon.ico")
	self.timeout_id = GLib.timeout_add(10, self.loop, None)#10ms 
	self.form_load=False
	self.window.Text=title
	if background!=None and background!="":
		bk=Gtk.Image();forms(bk).Width=w;forms(bk).Height=h;forms(bk).LoadPicture=background;forms(bk).Visible=True
		self.usercontrol.put(bk,0,0)
class usercontrol(object):
	def __init__(self,usercontrol):
		self.usercontrol
	@property	
	def Top(self):
		return self.usercontrol.Top
	@Top.setter	
	def Top(self,value):
		self.usercontrol.Top=value
	@property	
	def Left(self):
		return self.usercontrol.Left
	@Left.setter	
	def Left(self,value):
		self.usercontrol.Left=value
	@property	
	def Width(self):
		return self.usercontrol.Width
	@Width.setter	
	def Width(self,value):
		
		self.usercontrol.Width=value	
	@property	
	def Height(self):
		return self.usercontrol.Height
	@Height.setter	
	def Height(self,value):
		self.usercontrol.Height=value
	@property	
	def Visible(self):
		return self.usercontrol.Visible
	@Visible.setter	
	def Visible(self,value):
		self.usercontrol.Visible=value
	@property
	def Text(self):
		return self._text
	@Text.setter
	def Text(self,value):
		self._text=value
	@property
	def Font(self):
		return self._font
	@Font.setter
	def Font(self,value):
		self._font=value
	@property
	def BackColor(self):
		return self._backcolor
	@BackColor.setter
	def BackColor(self,value):
		self._backcolor=value
	@property
	def ForeColor(self):
		return self._forecolor
	@ForeColor.setter
	def ForeColor(self,value):
		self._forecolor=value
	@property
	def Alignment(self):
		return self._alignment
	@Alignment.setter
	def Alignment(self,value):
		self._alignment=value
	
def createWidget(self,prop,control,parent,event=[]):
	prop=eval(prop)
	name=prop["Name"]
	#print name
	left=int(prop["Left"])*resizeW
	top=int(prop["Top"])*resizeH
	if control=="VScrollbar" or control=="HScrollbar":
		exec('adj2 = Gtk.Adjustment(1,0,101,5,1,1)')
		exec("self._%s=Gtk.%s(adj2)" % (name,control))
		exec("self.%s=forms(self._%s)" % (name,name))

	elif control=="RadioButton":
		if prop["Var"]=="":
			prop["Var"]='None'
		if prop["Var"][0]!="@":
			_prop=prop["Var"]
		else:
			_prop=None
		exec('self._%s=Gtk.%s(group=%s,label="%s")' % (name,control,_prop,prop["Text"]))
		exec("self.%s=forms(self._%s)" % (name,name))
	elif control=="CheckButton":
		if prop["Var"]=="":
			prop["Var"]='None'
		exec('self._%s=Gtk.%s(label="%s")' % (name,control,prop["Text"]))
		exec("self.%s=forms(self._%s)" % (name,name))
	elif prop['Tag']=='Activex':
		exec('import '+ control) 
		exec("self.%s=%s.Handler(self)" % (name,control))
		exec("self.%sW=forms(self.%s.Widget())" % (name,name))
		for a in prop:
			usr_act=eval("self.%s"%(name))
			if hasattr(usr_act,a):
				try:
					exec("self.%s.%s='%s'"%(name,a,prop[a]))		
				except:
					a=a
	else:	
		if control=='SourceView':
			exec("self._%s=GtkSource.View()" % (name))
			exec("self._%stextbuff=GtkSource.Buffer()" % (name))
			exec("self._%s.set_buffer(self._%stextbuff)" % (name,name))
			#self.lm = GtkSource.LanguageManager()
			#self.textbuff.set_language(self.lm.get_language('python'))
			
		else:
			exec("self._%s=Gtk.%s()" % (name,control))		
		exec("self.%s=forms(self._%s)" % (name,name))
	dontaltertextandcolor=["Calendar","VScrollbar","HScrollbar","SpinButton","ScrolledWindow"]	
	if (control in dontaltertextandcolor):
		control=control
	else:	
		if control=="Button" and prop['Picture']!='':	
			butimg=Gtk.Image.new_from_file (prop['Picture'])	
			cmd="self._%s.set_image(butimg)"%(name)	
			exec(cmd)
		else:	
			exec("self.%s.Text='%s'"%(name,prop["Text"]))	
		if (control in dontaltertextandcolor)==False:
			prop["BackColor"]=prop["BackColor"].replace("(","");prop["BackColor"]=prop["BackColor"].replace(")","");
			exec("self.%s.BackColor=%s"%(name,prop["BackColor"]))			
			prop["ForeColor"]=prop["ForeColor"].replace("(","");prop["ForeColor"]=prop["ForeColor"].replace(")","");
			exec("self.%s.ForeColor=%s"%(name,prop["ForeColor"]))		
	if prop["Font"]!='':	
		exec("self.%s.Font='%s'"%(name,prop["Font"]))
	exec("self.%s.Enable=%s"%(name,TrueFalse(prop["Enable"])))
	exec("self.%s.Visible=%s"%(name,TrueFalse(prop["Visible"])))
	if prop['Tag']=='Activex':
		exec("self.%sW.Dimension=%s"%(name,prop["Width"]+","+prop["Height"]))
		exec("self.%s.activeXcreated()"%(name))
		
	else:
		exec("self.%s.Dimension=%s"%(name,prop["Width"]+","+prop["Height"]))

	#prop["ForeColor"]=prop["ForeColor"].replace("(","");prop["ForeColor"]=prop["ForeColor"].replace(")","");
	#exec("self.%sW.ForeColor=%s"%(name,prop["ForeColor"]))		

	if prop['ParentsType']=="Layout" and prop['Tag']!='Activex':
		cmd="self._%s.put(self._%s,%s,%s)"%(parent,name,left,top)
	elif prop['ParentsType']=="ScrolledWindow" or prop['ParentsType']=="Viewport" or prop['ParentsType']=="Frame":
		cmd="self._%s.add(self._%s)"%(parent,name)	
	else:
		if prop['Tag']=='Activex':
			cmd="self._%s.put(self.%s.Widget(),%s,%s)"%(parent,name,left,top)
		else:
			cmd="self._%s.put(self._%s,%s,%s)"%(parent,name,left,top)#widget that has no parent,put it to our usercontrol
	

	eval(cmd)
	try:
		exec("self.%s.Var='%s'"%(name,prop["Var"]))	
	except:
		cmd=''# do nothing
	if control in ["Image","DrawingArea","Label"] :
		exec("self._%sEvent=Gtk.EventBox()" % (name))
		exec("self.%sEvent=forms(self._%sEvent)" % (name,name))
		exec("self.%sEvent.Dimension=%s"%(name,prop["Width"]+","+prop["Height"]))
		exec("self.%sEvent.Visible=True" % (name))
		try:
			exec("self.%s.LoadPicture='%s'" % (name, prop['Picture']))
		except:
			name=name
		
		if parent=="usercontrol":
			cmd="self._%s.put(self._%sEvent,%s,%s)"%(parent,name,left,top)
		else:
			cmd="self._%s.put(self._%sEvent,%s,%s)"%(parent,name,float(left),float(top))
		eval(cmd)
	if control=="Entry":
		exec('self._%s.set_width_chars(1);'%(name))
		if 'Alignment' in prop:
			exec('self.%s.Alignment="%s"'%(name,prop["Alignment"]))
	if control=="Label":
		if 'Alignment' in prop:
			exec('self.%s.Alignment="%s"'%(name,prop["Alignment"]))	
#	if control=="Layout":
#		exec("self.%sW.BackColor=0.0,0.6,0.8,1"%(name))				
	event=eval(event)	
	try:
		if prop["Var"]!="":
			if prop["Var"][0]=="@":
				exec("self._%s.set_tooltip_text('%s')" % (name,prop["Var"][1:]))
	except:
		pass
	
	for a in event:
		if prop['Tag']=='Activex':
			strs="self.%s.connect('%s',self.%s_%s)"%(name,a[0],name,a[0].replace('-','_'))
		else:
			strs="self._%s.connect('%s',self.%s_%s)"%(name,a[0],name,a[0].replace('-','_'))
		if control in ["Image","DrawingArea","Label"] :
			strs="self._%sEvent.connect('%s',self.%s_%s)"%(name,a[0],name,a[0].replace('-','_'))
		try:
			eval(strs)
		except:
			if prop['Tag']=='Activex':
				print("Unknown Signal '%s' for self.%s"%(a[0],name))
			else:
				print("Unknown Signal '%s' for self._%s"%(a[0],name))
def setPicture (imgGTK,imgCV2):
	imgCV2=cv2.resize(imgCV2,(forms(imgGTK).Width,forms(imgGTK).Height))
	retval, jpg = cv2.imencode (".jpg", imgCV2)
	loader = GdkPixbuf.PixbufLoader.new_with_type ("jpeg")
	loader.write (jpg)
	loader.close ()
	pixbuf = loader.get_pixbuf ()
	imgGTK.set_from_pixbuf(pixbuf.copy())
	#GObject.Object.unref (loader)
	return imgCV2
def app_path():
	return os.path.dirname(os.path.realpath(__file__))			
class forms(object):
	def __init__(self,obj):
		self.obj=obj
		self.var=""
		self.cv=None
	def __getattr__(self,attr):#WTF!!! it took me a month to figure this out,. 
		#thanks goes to StackOverFlow and to their brilliant and very helpful users
		def wrapper(*args, **kw):
			#print('called with %r and %r' % (args, kw))
			return getattr(self.obj, attr)(*args, **kw)
		return wrapper		
	def SetFocus(self):
		return self.obj.grab_focus()	
	@property
	def Active(self):
		if type(self.obj)==Gtk.Switch  or type(self.obj)==Gtk.CheckButton or type(self.obj)==Gtk.RadioButton:#our january starts at 1
			value=self.obj.get_active()
			return value		
	@Active.setter
	def Active(self,value):
		if type(self.obj)==Gtk.Switch  or type(self.obj)==Gtk.CheckButton or type(self.obj)==Gtk.RadioButton:#our january starts at 1
			self.obj.set_active(value)
	@property
	def Text(self):
		if type(self.obj)==Gtk.Entry or type(self.obj)==Gtk.Label:
			return self.obj.get_text()
		elif type(self.obj)==Gtk.Button:
			return self.obj.get_label()
		elif type(self.obj)==Gtk.Window:
			return self.obj.get_title()
		elif type(self.obj)==Gtk.ComboBoxText:
			return self.obj.get_active_text ()
		elif type(self.obj)==Gtk.Frame:
			return self.obj.get_label()
		elif type(self.obj)==Gtk.LinkButton:
			return self.obj.get_label()		
		elif type(self.obj)==Gtk.Calendar:#our january starts at 1
			x=self.obj.get_date()
			return str(x[0])+"-"+str(x[1]+1)+"-"+str(x[2])
		elif type(self.obj)==Gtk.CheckButton or type(self.obj)==Gtk.RadioButton:#our january starts at 1
			value=self.obj.get_label()
			return value
		elif type(self.obj)==Gtk.TextView:
			x=self.obj.get_buffer()
			return x.get_text(x.get_start_iter(),x.get_end_iter(),False)
			
		elif type(self.obj)==Gtk.VScrollbar or type(self.obj)==Gtk.HScrollbar or type(self.obj)==Gtk.SpinButton:
			return str(self.obj.get_value())
		else:
			try:
				if type(self.obj)==GtkSource.View :#our january starts at 1
					x=self.obj.get_buffer()
					return x.get_text(x.get_start_iter(),x.get_end_iter(),False)			
			except:
				pass		
	@Text.setter
	def Text(self,value):
		if type(value)==int or type(value)==float:
			value=str(value)
		if type(self.obj)==Gtk.Entry  or type(self.obj)==Gtk.Label:
			self.obj.set_text(value)
		if type(self.obj)==Gtk.Button:
			self.obj.set_label(value)
		elif type(self.obj)==Gtk.Window:
			self.obj.set_title(str(value))	
		elif type(self.obj)==Gtk.Frame:
			self.obj.set_label(value)
		elif type(self.obj)==Gtk.LinkButton:
			return self.obj.set_label(value)			
		elif type(self.obj)==Gtk.CheckButton or type(self.obj)==Gtk.RadioButton:#our january starts at 1
			self.obj.set_label(value)		
		elif type(self.obj)==Gtk.Calendar:#our january starts at 1
			try:
				value=value.split('-')
				self.obj.select_month(int(value[1])-1,int(value[0]));
				self.obj.select_day(int(value[2]));
			except:
				a=0
		elif type(self.obj)==Gtk.TextView:
			self.obj.get_buffer().set_text(value)
		elif type(self.obj)==Gtk.VScrollbar or type(self.obj)==Gtk.HScrollbar  or type(self.obj)==Gtk.SpinButton:
			self.obj.set_value(float(value))
		elif type(self.obj)==Gtk.ComboBoxText:
			ls=self.obj.get_model()
			if ls==None: 
				return
			for i,a in enumerate(ls):
				if value==a[0]:
					self.ListIndex=i
					return
		else:
			try:
				if type(self.obj)==GtkSource.View:
					self.obj.get_buffer().set_text(value)
			except:
				pass
	@property
	def Var(self):		
		return self.var
	@Var.setter
	def Var(self,value):
		self.var=value			
	@property
	def LoadPicture(self):		
		pass
	@LoadPicture.setter
	def LoadPicture(self,fname):
		if type(self.obj)==Gtk.Image:
			try:
				#img = Image.open(fname)
				#img = img.resize((forms(self.obj).Width,forms(self.obj).Height), Image.ANTIALIAS)
				#img.save("temp/"+fname) 
				#self.obj.set_from_file ("temp/"+fname)
				w=forms(self.obj).Width
				h=forms(self.obj).Height
				img=cv2.imread(fname)
				#img=cv2.resize(img,(w,h))
				self.cv=setPicture(self.obj, img)
				
			except:
				self.obj.set_from_file (fname)
	@property
	def LoadPictureNoResize(self):
		pass
	@LoadPicture.setter
	def LoadPictureNoResize(self,fname):
		if type(self.obj)==Gtk.Image:
			try:
				self.obj.set_from_file (fname)
			except:
				pass
	def imread(self):
		return self.cv
	@property
	def LoadPictureOCV(self):		
		pass
	@LoadPicture.setter
	def LoadPictureOCV(self,imOCV):
		if type(self.obj)==Gtk.Image:
			self.cv=setPicture(self.obj,imOCV)
	@property
	def List(self):
		if type(self.obj)==Gtk.ComboBoxText:
			ls=self.obj.get_model()
			if ls==None: 
				return
			ret=[]
			for a in ls:
				ret.append(a[0])
			return ret	
	@List.setter			#=['123','456',1024]
	def List(self,listvalues):
		if type(self.obj)==Gtk.ComboBoxText:
			ls=Gtk.ListStore(str)
			for a in listvalues:
				ls.append([str(a)])
			self.obj.set_model(ls)	
			self.obj.set_active(1)
	@property
	def ListIndex(self):		
		if type(self.obj)==Gtk.ComboBoxText:			
			return self.obj.get_active()		
		pass
	@ListIndex.setter	
	def ListIndex(self,index):
		if type(self.obj)==Gtk.ComboBoxText:			
			self.obj.set_active(index)
	@property
	def ListClear(self):
		if type(self.obj)==Gtk.ComboBoxText:
			self.obj.set_model(None)

	@property
	def ForeColor(self):		#value=0.0, 1.0, 0.0, 1.0 #RGBA
		return 0
	@ForeColor.setter
	def ForeColor(self,*value):		#value=0.0, 1.0, 0.0, 1.0
		self.obj.override_color(Gtk.StateFlags.NORMAL, Gdk.RGBA(value[0][0],value[0][1],value[0][2],value[0][3])) 
	@property
	def BackColor(self):		#value=0.0, 1.0, 0.0, 1.0 #RGBA
		return 0
	@BackColor.setter
	def BackColor(self,*value):		#value=0.0, 1.0, 0.0, 1.0
		if type(self.obj)==Gtk.TextView or type(self.obj)==Gtk.Entry:return# or type(self.obj)==GtkSource.View:return
		self.obj.override_background_color(Gtk.StateFlags.SELECTED,Gdk.RGBA(0.8,0.8,1,1))	
		self.obj.override_background_color(Gtk.StateFlags.NORMAL, Gdk.RGBA(value[0][0],value[0][1],value[0][2],value[0][3])) 

	@property
	def Visible(self):		#value=0.0, 1.0, 0.0, 1.0 #RGBA
		return self.obj.get_visible() 
	@Visible.setter
	def Visible(self,value):		#value=0.0, 1.0, 0.0, 1.0
		if value==True:
			self.obj.show()
		else:
			self.obj.hide()
	@property
	def Enable(self):		#value=0.0, 1.0, 0.0, 1.0 #RGBA
		return self.obj.get_sensitive()
	@Enable.setter
	def Enable(self,value):		#value=0.0, 1.0, 0.0, 1.0
		self.obj.set_sensitive(value)
	def Move(self,xy):		
		parent=self.obj.get_parent()
		parent.move(self.obj,xy[0],xy[1])
		return 0
	def Location(self):		#value=0.0, 1.0, 0.0, 1.0 #RGBA
		parent=self.obj.get_parent()
		x=parent.child_get_property(self.obj,"x")
		y=parent.child_get_property(self.obj,"y")
		return x,y
	@property
	def Dimension(self):
		#w=self.obj.size_request();
		#return w.width,w.height
		return self.obj.get_size_request()[0],self.obj.get_size_request()[1]
	@Dimension.setter
	def Dimension(self,wh):
		if screensize[0]<1366 or screensize[1]<768:
			wh=[int(wh[0])*resizeW,int(wh[1])*resizeH]
			self.obj.set_size_request(int(wh[0]),int(wh[1]));
		else:
			self.obj.set_size_request(int(wh[0]),int(wh[1]));
	@property
	def Top(self):
		parent=self.obj.get_parent()
		y=parent.child_get_property(self.obj,"y")
		return y
	@Top.setter
	def Top(self,y):
		parent=self.obj.get_parent()
		x=parent.child_get_property(self.obj,"x")		
		parent.move(self.obj,x,y)
	@property
	def Left(self):
		parent=self.obj.get_parent()
		x=parent.child_get_property(self.obj,"x")
		return x
	@Left.setter
	def Left(self,x):
		parent=self.obj.get_parent()
		y=parent.child_get_property(self.obj,"y")		
		parent.move(self.obj,x,y)
	@property
	def Font(self):
		pass
	@Font.setter
	def Font(self,font):
		try:
			self.obj.modify_font( Pango.FontDescription(font))#font='Dejavu Sans Mono 20'	
		except:
			pass
	@property
	def Width(self):
		return self.obj.get_size_request()[0]
	@Width.setter
	def Width(self,w):
		h=self.obj.get_size_request()[1]
		self.obj.set_size_request(w,h);
	@property
	def Height(self):
		return self.obj.get_size_request()[1]
	@Height.setter
	def Height(self,h):
		w=self.obj.get_size_request()[0]
		self.obj.set_size_request(w,h);
	@property
	def Alignment(self):		
		pass
	@Alignment.setter
	def Alignment(self,value):
		if value=='LEFT' or value=='':
			value=0
		if value=='CENTER':
			value=0.5			
		if value=='RIGHT':
			value=1	
		if type(self.obj)==Gtk.Entry:
			self.obj.set_alignment (value)
		if type(self.obj)==Gtk.Label:
			_,y=self.obj.get_alignment ()			
			self.obj.set_alignment (value,y)
