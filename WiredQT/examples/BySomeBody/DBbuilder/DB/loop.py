	def activeXcreated(self,*args):
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
	def connect(self,ev,evusr):
		self.wiredevents.update({ev:evusr})	
	@property
	def Text(self):
		return ''
	@Text.setter
	def Text(self,value):
		pass
	def createwidget(self,prop,control,parent,event=[]):
		createWidget(self,prop,control,parent,event)
	def GTKForms(self):
