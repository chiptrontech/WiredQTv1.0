function inputDictionary()
{
	x={};
	inputs=document.getElementsByTagName('input')
	for (index = 0; index < inputs.length; ++index) {
	x[inputs[index].id]=JSON.stringify({"name":inputs[index].name,"value":inputs[index].value,"checked":String(inputs[index].checked),"type":inputs[index].type});
	}
	return x;
}
function mybarchartendpoint(id,_url,data)
{
	x=data;
	$.ajax({
		url: _url,
		type: "post",
		data: x,
		success: function(response) {
		if (response['userName']!="")
		{
			var data = new google.visualization.DataTable();
			eval(response['barchartValue'])
			var chart = new google.visualization.BarChart(document.getElementById(id));
			chart.draw(view, options);

		}
		else
		{
			alert("invalid user/password!!!");
		}
	},
	error: function(xhr) {
		//Do Something to handle error
		console.log("what a mess");
	}
	});
	/*google.visualization.events.addListener(table, 'select', selectHandler);*/
}

function mylinechartendpoint(id,_url,data)
{
	x=data;
	$.ajax({
		url: _url,
		type: "post",
		data: x,
		success: function(response) {
		if (response['userName']!="")
		{
			var data = new google.visualization.DataTable();
			eval(response['linechartValue'])
			var chart = new google.visualization.LineChart(document.getElementById(id));

			chart.draw(data, options);

		}
		else
		{
			alert("invalid user/password!!!");
		}
	},
	error: function(xhr) {
		//Do Something to handle error
		console.log("what a mess");
	}
	});
	/*google.visualization.events.addListener(table, 'select', selectHandler);*/
}
function mytableendpoint(id,_url,data)
{
	x=data;
	$.ajax({
		url: _url,
		type: "post",
		data: x,
		success: function(response) {
		if (response['userName']!="")
		{
			var data = new google.visualization.DataTable();
			eval(response['datagridValue'])
			var table = new google.visualization.Table(document.getElementById(id));

			table.draw(data, { width: '100%', height: '100%'});

		}
		else
		{
			alert("invalid user/password!!!");
		}
	},
	error: function(xhr) {
		//Do Something to handle error
		console.log("what a mess");
	}
	});
	/*google.visualization.events.addListener(table, 'select', selectHandler);*/
}
function parseServerData(data)
{

	y="var data="+data.replaceAll("&#39;",'"');
	eval(y);
	//alert(data['refresh_token']);
	return data;
}



function display_data(data)
{
	alert(data['access_token']);
	console.log("data values",data);
}


/*
usage:
postForm('mysite.com/form', {arg1: 'value1', arg2: 'value2'});
*/
function postForm(path, params, method) {
method = method || 'post';

var form = document.createElement('form');
form.setAttribute('method', method);
form.setAttribute('action', path);

for (var key in params) {
	if (params.hasOwnProperty(key)) {
		var hiddenField = document.createElement('input');
		hiddenField.setAttribute('type', 'hidden');
		hiddenField.setAttribute('name', key);
		hiddenField.setAttribute('value', params[key]);

		form.appendChild(hiddenField);
	}
}

document.body.appendChild(form);
form.submit();
}



