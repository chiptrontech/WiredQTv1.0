from wta_module import *
import os
from flask import Flask, render_template,request,redirect,url_for,Response,jsonify
import json
import datetime

def jsonResponseFactory(data):
    '''Return a callable in top of Response'''
    def callable(response=None, *args, **kwargs):
        '''Return a response with JSON data from factory context'''
        return Response(json.dumps(data), *args, **kwargs)
    return callable

app = Flask(__name__)


@app.route('/')
def startpage():
	return render_template( '/startpage.html')#( '/index.html')#return 'welcome %s' % name
@app.route('/nextpage',methods = ['POST', 'GET'])
def nextpage():
	#import pdb;pdb.set_trace()
	if request.method == 'POST':
		
		arg1=request.form['arg1']
	return render_template( '/nextpage.html',data="From Flask,Rocky Nuarin " + arg1)#( '/index.html')#return 'welcome %s' % name
@app.route('/Temperature',methods = ['POST', 'GET'])
def Temperature():
	import pdb;pdb.set_trace()
	user=""	
	temp=""
	if request.method == 'POST':
		
		arg1=request.form['userName']
		if arg1=="Donna":
			user=arg1
			temp="123"
	return jsonify({'userName':user,'temp':temp});

@app.route('/Datagrid',methods = ['POST', 'GET'])

def Datagrid():
	
	user=""	
	if request.method == 'POST':
		
		arg1=request.form['userName']
		if arg1=="Donna":
			user=arg1
		'''
		DataGrid1=DataGridChart()
		import sqlite3

		db = sqlite3.connect('database.db')

		#datagridValue=DataGrid1.DataSource(db,"select * from supplier limit 10")
		datagridValue=DataGrid1.DataSource(db,"select Name,QTY from supplier limit 10")
'''
		datagridValue=TableChart(["Name","Age"],[["Rocky","17"],["Rocky2","18"]])
	
	
	return jsonify({'userName':user,'datagridValue':datagridValue});
@app.route('/Datagrid2',methods = ['POST', 'GET'])
def Datagrid2():
	#import pdb;pdb.set_trace()
	user=""	
	if request.method == 'POST':
		
		arg1=request.form['userName']
		if arg1=="Donna":
			user=arg1
		DataGrid1=DataGridChart()
		import sqlite3

		db = sqlite3.connect('database.db')

		datagridValue=DataGrid1.DataSource(db,"select * from supplier limit 10")
		#datagridValue=DataGrid1.DataSource(db,"select Name,QTY from supplier limit 10")
		
	
	return jsonify({'userName':user,'datagridValue':datagridValue});
@app.route('/BarChart',methods = ['POST', 'GET'])
def BarChart():
	#import pdb;pdb.set_trace()
	user=""	
	if request.method == 'POST':
		
		arg1=request.form['userName']
		if arg1=="Donna":
			user=arg1
		title="Density of Precious Metals, in g/cm^3"
		header="['Elements','Density'],\n"
		data=header+"['Gold',100],\n"+"['siver',120],\n"
		barchartValue=barchart(data,title)
	return jsonify({'userName':user,'barchartValue':barchartValue});
@app.route('/LineChart',methods = ['POST', 'GET'])
def LineChart():
	#import pdb;pdb.set_trace()
	user=""	
	if request.method == 'POST':
		
		
		arg1=request.form['userName']
		if arg1=="Donna":
			user=arg1
			title=request.form['title']
		import numpy as np
		time        = np.arange(0, 10, 0.1);

		amplitude   = np.sin(time)

		amplitude2   = np.cos(time)
		amplitude3   = np.tan(time)

		header="['amp','sin','cos'],\n"

		linechartValue=linechart(time,amplitude,amplitude2,header=header,title=title)
	return jsonify({'userName':user,'linechartValue':linechartValue});

if __name__ == '__main__':
	#localhost:5000/login	
	#app.run(port=80)
	app.config['TEMPLATES_AUTO_RELOAD'] = True
	app.run(host='0.0.0.0',port=80)#app.run(host='0.0.0.0',port=5000)#app.run(port=80)

	pass