from PyQt5 import QtCore, QtWidgets
from PyQt5.QtWidgets import * 
from PyQt5.QtGui import * 
from wired_module import *
class Initialize:
	def __init__(self,parentobj):
		self.parentobj=parentobj
	def PopulateCombo(self,cboW,fields,table,RETFIELDS=False):
		if fields.find(",")!=-1:
			f1=getCSV(0,",",fields)
			f2=getCSV(1,",",fields)
			sep=getCSV(2,",",fields)
			sep=sep.replace("\"","")
			sep=sep.replace("'","")
			sql="select %s,%s from %s" % (f1,f2,table)
		else:	
			sql="select %s from %s" % (fields,table)
		y=[];
		if RETFIELDS==True:
			x=self.parentobj.datagrid.getFields(self.parentobj.db,table)
			x2=[]
			for a in x:#convert to format of ExecuteQuerry 
				x2.append([a])
			x=x2                
		else:
			x=self.parentobj.datagrid.ExecuteQuerry(self.parentobj.db, sql);
			
		if len(x)==0:
			return
		y.insert(0,"Select Here")
		for a in x:
			if len(a)==1:
				y.append(a[0])
			else:
				y.append(a[0]+sep+a[1])
		cboW.List=y
		cboW.ListIndex=0
	#print(self.getCount(""))
	#print(self.getCount('','0000'))
	#print(self.UpdateFiFo('','0000',2))		
	def getCount(self,lst,whereid=None):
		#self.notnull=[["items","Category"]]
		lst=self.getcount=[['PRODUCTS','Name','Stocks','Name','QTY'," order by Date desc"]]
		retlst={}
		for a in lst:
			sql1="select * from %s" % (a[0])
			ret=self.parentobj.datagrid.ExecuteQuerry(self.parentobj.db, sql1)
			fields=self.parentobj.datagrid.getFields(self.parentobj.db, a[0])
			for i,b in enumerate(fields):
				if b==a[1]:
					for c in ret:
						ids=c[i]
						sql2="select * from %s where %s='%s'" % (a[2],a[3],ids) + a[5] 
						ret2=self.parentobj.datagrid.ExecuteQuerry(self.parentobj.db, sql2)
	
						fields2=self.parentobj.datagrid.getFields(self.parentobj.db, a[2])
						for i2,b2 in enumerate(fields2):
							if b2==a[4]:
								total=0.0
								for d in ret2:
									total+=float(d[i2])
								retlst.update({ids:total})
	
								if whereid!=None and whereid==ids:
									return str(total)
	
	
		return retlst			
	def UpdateFiFo(self,lst,whereid,qty):
		#self.notnull=[["items","Category"]]
		lst=self.getcount=[['PRODUCTS','Name','Stocks','Name','QTY'," order by Date asc","stocksconsumed"]]
		retlst={}
		for a in lst:
			sql1="select * from %s" % (a[0])
			ret=self.parentobj.datagrid.ExecuteQuerry(self.parentobj.db, sql1)
			fields=self.parentobj.datagrid.getFields(self.parentobj.db, a[0])
			for i,b in enumerate(fields):
				if b==a[1]:
					for c in ret:
						ids=c[i]
	
						sql2="select * from %s where %s='%s' and %s<>'0'" % (a[2],a[3],whereid,a[4]) + a[5] 
						ret2=self.parentobj.datagrid.ExecuteQuerry(self.parentobj.db, sql2)
						fields2=self.parentobj.datagrid.getFields(self.parentobj.db, a[2])
						for i2,b2 in enumerate(fields2):
							if b2==a[4]:
								total=0.0
								for pos,d in enumerate(ret2):
									qtyrec=d[i2]
									if whereid==ids:
										table=a[2]
										wherefields1=a[3]
										wherefields2=a[3]
										updatefield=a[4]
										for i22,b22 in enumerate(fields2):
											if 'Date'==b22:
												datefieldspos=i22
												datevalue=d[datefieldspos]										
										if float(qty)>=float(qtyrec):
											sql3="UPDATE `"+a[2]+"` SET " + a[4] + "='" + str(0) +"' where " +a[3]+"='"+ids+ "' and date='" + str(datevalue) +"'"
											qty=float(qty)-float(qtyrec)
											deduct=qtyrec
										else:
											sql3="UPDATE `"+a[2]+"` SET " + a[4] + "='" + str(float(qtyrec)-float(qty)) +"' where " +a[3]+"='"+ids+ "' and date='" + str(datevalue) +"'"
											deduct=qty
											qty="0"
	
										fields22=self.parentobj.datagrid.getFields(self.parentobj.db, a[6])
										stockhist=a[6]	
										sqlhistory="INSERT INTO `"  + stockhist +"` " + str(tuple(fields22)).replace("'","") + "VALUES " 
										val=[]
										for i222,b222 in enumerate(fields22):        
											if b222=="QTY" or b222=="Date":
												if b222=="QTY":
													val.append(deduct)
												if b222=="Date":
													val.append(str(datetime.datetime.now()))													
											else:	
												val.append(str(d[i222]))
										sqlhistory+=str(tuple(val))
	
										self.parentobj.datagrid.ExecuteNonQuerry(self.parentobj.db,sqlhistory)
										self.parentobj.datagrid.ExecuteNonQuerry(self.parentobj.db,sql3)
										if qty=="0":
											return True	
	
		return False
	def IsUnique(self,lst):
		#self.unique=[["items","Category"]]
		for a in lst:
			j = eval("self.parentobj.txt" + a[1]+"_"+a[0]+'.Text')#self.builder.get_object("txt" + a[1]+"_"+a[0])
			#j =forms(i).Text			
			s=self.parentobj.datagrid.GetSingleRec(self.parentobj.db,a[0],a[1],j,a[1]);
			if s!="":
				QMessageBox.about(None,"Warning",a[1]+" Exist!!!")
				return False
		return True		
	def IsNotNull(self,lst):
		#self.notnull=[["items","Category"]]
		for a in lst:
			j = eval("self.parentobj.txt" + a[1]+"_"+a[0]+'.Text') #self.builder.get_object("txt" + a[1]+"_"+a[0])
			#j =forms(i).Text			
			if j=="":
				QMessageBox.about(None,"Warning",a[1]+" Cannot be null!!!")
				return False
			if j=="Type Here":
				QMessageBox.about(None,"Warning","Please Enter Data for " + a[1])
				return False
			if j=="Select Here":
				QMessageBox.about(None,"Warning","Please Select Item for " +a[1])
				return False		
		return True
	def CheckNumber(self,lst,intIsTrue=False):
		#self.notnull=[["items","Category"]]
		for a in lst:
			j = eval("self.parentobj.txt" + a[1]+"_"+a[0]+'.Text') #self.builder.get_object("txt" + a[1]+"_"+a[0])
			#j = forms(i).Text
			if intIsTrue:
				try:
					if j.find(".")!=-1:
						QMessageBox.about(None,"Warning",a[1]+" Must be Integer!!!")
						return False	
	
					num=int(j)
					return True
				except:
					QMessageBox.about(None,"Warning",a[1]+" Must be Integer!!!")
					return False
			else:
				try:
					num=float(j)
					return True
				except:
					QMessageBox.about(None,"Warning",a[1]+" Must be Floating point!!!")
					return False
		return True		
	def TableValToUserInput(self,itemsString,values):
		lst=self.parentobj.datagrid.getFields(self.parentobj.db, itemsString)
		for i,a in enumerate(lst):
			obj = eval("self.parentobj.txt" + a+"_"+itemsString)#self.builder.get_object("txt" + a+"_"+itemsString)
			j =obj
			if type(j.obj)==QLineEdit :
				j.Text=str(values[i])
			if type(j.obj)==QCheckBox :	
				j.Text=TrueFalse(values[i])
			if type(j.obj)==QComboBox:
				j.Text=values[i]
	def SetAutoNumber(self,lst):
		for a in lst:
			fields=a[1]
			table=a[0]
			txt=    eval("self.parentobj.txt" + fields+"_"+table)#self.builder.get_object("txt" + fields+"_"+table)
			#if type(txt)==richEntry.Handler:
			#	txtW=txt
			#else:
			#	txtW=forms(txt)				
			txtW=forms(txt)				
			x=self.parentobj.datagrid.ExecuteQuerry(self.parentobj.db, "select * from `autonumber`" );
			if len(x)==0:
				self.parentobj.datagrid.ExecuteNonQuerry(self.parentobj.db, "INSERT INTO `autonumber` (ignores)VALUES('%s')"%('id'))
			x=self.parentobj.datagrid.ExecuteQuerry(self.parentobj.db, "select "+fields+"_"+table+" from `autonumber` where " + fields+"_"+table+ " is null" );
			if len(x):
				if x[0][0]==None:
					x=self.parentobj.datagrid.ExecuteNonQuerry(self.parentobj.db, "update `autonumber` set "+fields+"_"+table+"='0'  where ignores='id'");	
					txtW.Text="%04d" % (0)
			else:
				x=self.parentobj.datagrid.ExecuteQuerry(self.parentobj.db, "select "+fields+"_"+table+" from `autonumber` where ignores='id'" );
				txtW.Text="%04d" % (int(x[0][0]))
			#self.IncAutoNumber(fields,table)	
	def IncAutoNumber(self,lst):
		for a in lst:
			fields=a[1]
			table=a[0]
			x=self.parentobj.datagrid.ExecuteQuerry(self.parentobj.db, "select "+fields+"_"+table+" from `autonumber` where ignores = 'id'" );
			currnum=int(x[0][0])+1
			x=self.parentobj.datagrid.ExecuteNonQuerry(self.parentobj.db, "update `autonumber` set "+fields+"_"+table+"="+str(currnum)+"  where ignores='id'");
	def CboNameClick(self,*args):
		try:
			total=self.getCount(None, whereid=self.txtName_Sales.Text)
			if total=="0":
				QMessageBox.about(None,"Warning","Out of Stock " + self.txtName_Sales.Text)
		except:
			a=0
		self.ComboGetData("Name","Products",self.txtName_Sales.Text,"Amount",self.txtAmount_SalesW)
		self.txtQty_Sales.Text="1"
		self.txtQty_SalesChange(None)
	def ComboGetData(self,fields,table,value,retfields,obj):
		x=self.parentobj.datagrid.ExecuteQuerry(self.parentobj.db, "select %s from %s where %s = '%s'" % (retfields,table,fields,value));
		if len(x)!=0:
			obj.Text=x[0][0]