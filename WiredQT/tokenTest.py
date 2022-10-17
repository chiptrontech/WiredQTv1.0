
import tokenize,io
from wired_module import *
class _parseRoutine:
	def __init__(self,routinename,find,replace):
		self.routinename=[routinename,"End Sub"]
		self.replace=replace
		self.num=len(self.routinename)
		self.index=0
		self.code=""
		self.find=find
		self.hasfind=len(find)*[False]
		self.finalcode=""
		self.start=None
		self.end=None
	def parse(self,linestr,line):
		if self.index!=0:
			if self.code=="":
				self.start=line
				self.code+=self.routinename[0]+"\r\n"
				self.finalcode=""
			if self.index!=self.num and linestr!=self.routinename[self.index]:#not last index of self.routinename("End Sub")
				self.code+=linestr+"\r\n"
			if self.index+1==self.num and linestr==self.routinename[self.index]:
				self.end=line
			
		if (self.index)==self.num:	
			return False
		if linestr==self.routinename[self.index]:
			self.index+=1
			if (self.index)==self.num:
				self.replaceExistingLineCode(self.code.encode())#encode bcoz it is not a file
				for i,a in enumerate(range(len(self.find))):
					if self.hasfind[a]==False:
						self.finalcode+=self.replace[a]+"\r\n"			
				self.finalcode+=self.routinename[-1]
				self.code+=self.routinename[-1]
				print(self.finalcode)
				
				return True
			else:
				return False
	def replaceExistingLineCode(self,fileOrString):
			self.line=-1
			if type(fileOrString)!=str:
				f = io.BytesIO(fileOrString)
			else:
				f=open(fileOrString, 'rb') 
			for five_tuple in tokenize.tokenize(f.readline):#f.readline):
					
					
					if self.line!=five_tuple.start[0] and (five_tuple.type==1 or five_tuple.type==tokenize.NEWLINE):
						prevlinestr=five_tuple.line.replace("\r","").replace("\n","")
						self.line=five_tuple.start[0]
						#print(prevlinestr)
						fnd=False
						for i,a in enumerate(self.find):
							if prevlinestr.lower().find(a.lower())!=-1:
								#if i==0:								
								self.finalcode+=self.replace[i]+"\r\n"
								self.hasfind[i]=True
							else:
								if i==0:
									if self.hasfind[i]==False:
										self.finalcode+=prevlinestr+"\r\n"
							
class parseRoutine:
	def __init__(self):
		self._parseRoutine=[]
		pass
	def append(self,routinename,find,replace):
		self._parseRoutine.append(_parseRoutine(routinename,find,replace))
	def parse(self,linestr,line):
		for a in self._parseRoutine:
			if a.parse(linestr,line):
				print("ok")
	def updatecode(self,code):
		'''for a in self._parseRoutine:
			newcode=''
			arr=code.split('\n')
			for b in range(a.start[0]-2):
				newcode+=arr[b]+"\n"
				
			newcode+=a.finalcode+"\n"
			'''
		newcode=''
		arr=code.split('\n')
		b=0
		while b!=len(arr):
			newcode+=arr[b]+"\n"
			for a in self._parseRoutine:
				if b==a.start[0]-3:
					b=a.end[0]-1
					newcode+=a.finalcode+"\n"
			b+=1		
		return newcode	
#replace = OK!!!
#todo: add linecode if not existing on routine body				
class tokenKO:
	def printdata(self,five_tuple):
		print("==========================")
		print(five_tuple.type)
		print(five_tuple.string)
		print(five_tuple.start)
		print(five_tuple.end)
		print(five_tuple.line)	
		print("==========================")
	def __init__(self):
		self.parse=parseRoutine()
	def addreplace(self,routine,fndlst,replacelst):
		self.parse.append(routine,fndlst,replacelst)
	def Start(self,fileOrString):
		
		self.line=-1
		#self.parse.append("Sub Class_Globals",["Dim Image2 as ImageView"],["\tADim Image2 as ImageView"])
		#self.parse.append("Public Sub Initialize (Callback As Object, EventName As String)",["vLabel1.Initialize(\"Label1\")","cLabel1.Initialize(\"Label1\")",],["\tBLabel1.Initialize(\"Label1\")","\tDLabel1.Initialize(\"Label1\")",])
		#self.parse.append("Public Sub GTKForms",["\tmBase.AddView(Image1"],["\tCmBase.AddView(Image1xx,0.07 * mBase.Width,0.22 * mBase.Height,0.43 * mBase.Width,0.18 * mBase.Height)"])
		
		if type(fileOrString)!=str:
			f = io.BytesIO(fileOrString)
		else:
			#strs=GetFileStr(fileOrString)
			#strs=strs.replace("\r\n","\n")
			#SaveFileStr(fileOrString, strs)
			f=open(fileOrString, 'rb') 
		for five_tuple in tokenize.tokenize(f.readline):#f.readline):
				
				
				if self.line!=five_tuple.start[0] and five_tuple.type==1:
					prevlinestr=five_tuple.line.replace("\r","").replace("\n","")
					#print(prevlinestr)
					self.line=five_tuple.start[0]
					self.parse.parse(prevlinestr,five_tuple.start)
		fo = open(fileOrString, "rb")#getfilestr use r+ fuck!!! it convert \r to \n
		code = fo.read(GetFileSize(fileOrString))		
		_code=self.parse.updatecode(code.decode())			
		fo.close()
		def SaveFileStrX(fname,str_to_write):
			fname=fname.replace('\\','/')
			fo = open(fname, "wb")
			fo.write(str_to_write);
			fo.close()		
		SaveFileStrX(GetPath(fileOrString) +'/'+ GetFilenameNoEXT(fileOrString)+'_current.bas',_code.encode())
		SaveFileStrX(GetPath(fileOrString) +'/'+ GetFilenameNoEXT(fileOrString)+'_prev.bas',code)
		a=0			
		f.close()	
c='''Public Sub Initialize (Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
	Label1.Initialize("Label1")
	Image2.Initialize("Image2")
	Image1.Initialize("Image1")
	Image3.Initialize("Image3")
	Label2.Initialize("Label2")
	Layout1.Initialize("Layout1")
	Label3.Initialize("Label3")
	Image4.Initialize("Image4")

End Sub'''
if __name__ == "__main__":
	#s=tokenKO(c.encode())#if encoded then it is code else it is a file
	#self.parse.append("Sub Class_Globals",["Dim Image2 as ImageView"],["\tADim Image2 as ImageView"])
	#self.parse.append("Public Sub Initialize (Callback As Object, EventName As String)",["vLabel1.Initialize(\"Label1\")","cLabel1.Initialize(\"Label1\")",],["\tBLabel1.Initialize(\"Label1\")","\tDLabel1.Initialize(\"Label1\")",])
	#self.parse.append("Public Sub GTKForms",["\tmBase.AddView(Image1"],["\tCmBase.AddView(Image1xx,0.07 * mBase.Width,0.22 * mBase.Height,0.43 * mBase.Width,0.18 * mBase.Height)"])	
	s=tokenKO()
	s.addreplace("Sub Class_Globals",["Dim Image2 as ImageView"],["\tADim Image2 as ImageView"])
	s.addreplace("Public Sub Initialize (Callback As Object, EventName As String)",["vLabel1.Initialize(\"Label1\")","cLabel1.Initialize(\"Label1\")",],["\tBLabel1.Initialize(\"Label1\")","\tDLabel1.Initialize(\"Label1\")",])
	s.addreplace("Public Sub GTKForms",["\tmBase.AddView(Image1"],["\tCmBase.AddView(Image1xx,0.07 * mBase.Width,0.22 * mBase.Height,0.43 * mBase.Width,0.18 * mBase.Height)"])
	s.Start("123.bas")