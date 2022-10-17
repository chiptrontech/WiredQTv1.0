package b4a.OPTUMizerPatient;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class wtaserver_subs_0 {


public static RemoteObject  _checkconnection(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("CheckConnection (wtaserver) ","wtaserver",6,__ref.getField(false, "ba"),__ref,115);
if (RapidSub.canDelegate("checkconnection")) { return __ref.runUserSub(false, "wtaserver","checkconnection", __ref);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
 BA.debugLineNum = 115;BA.debugLine="Sub CheckConnection As Boolean";
Debug.ShouldStop(262144);
 BA.debugLineNum = 116;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(524288);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 118;BA.debugLine="If (p.GetDataState == \"CONNECTED\") Then";
Debug.ShouldStop(2097152);
if ((RemoteObject.solveBoolean("=",_p.runMethod(true,"GetDataState"),RemoteObject.createImmutable("CONNECTED")))) { 
 BA.debugLineNum = 119;BA.debugLine="Return True";
Debug.ShouldStop(4194304);
if (true) return wtaserver.__c.getField(true,"True");
 };
 BA.debugLineNum = 122;BA.debugLine="If (p.GetSettings (\"wifi_on\") == 1) Then";
Debug.ShouldStop(33554432);
if ((RemoteObject.solveBoolean("=",_p.runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("wifi_on"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 123;BA.debugLine="Return True";
Debug.ShouldStop(67108864);
if (true) return wtaserver.__c.getField(true,"True");
 };
 BA.debugLineNum = 126;BA.debugLine="If (p.GetDataState == \"DISCONNECTED\") Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",_p.runMethod(true,"GetDataState"),RemoteObject.createImmutable("DISCONNECTED")))) { 
 BA.debugLineNum = 127;BA.debugLine="Return False";
Debug.ShouldStop(1073741824);
if (true) return wtaserver.__c.getField(true,"False");
 };
 BA.debugLineNum = 130;BA.debugLine="If (p.GetDataState == \"SUSPENDED\") Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",_p.runMethod(true,"GetDataState"),RemoteObject.createImmutable("SUSPENDED")))) { 
 BA.debugLineNum = 131;BA.debugLine="Return False";
Debug.ShouldStop(4);
if (true) return wtaserver.__c.getField(true,"False");
 };
 BA.debugLineNum = 133;BA.debugLine="Return False";
Debug.ShouldStop(16);
if (true) return wtaserver.__c.getField(true,"False");
 BA.debugLineNum = 134;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private mModule As Object";
wtaserver._mmodule = RemoteObject.createNew ("Object");__ref.setField("_mmodule",wtaserver._mmodule);
 //BA.debugLineNum = 3;BA.debugLine="Private mEventName As String";
wtaserver._meventname = RemoteObject.createImmutable("");__ref.setField("_meventname",wtaserver._meventname);
 //BA.debugLineNum = 4;BA.debugLine="Private wsh As Socket";
wtaserver._wsh = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper");__ref.setField("_wsh",wtaserver._wsh);
 //BA.debugLineNum = 5;BA.debugLine="Private wtaserverIO As AsyncStreams";
wtaserver._wtaserverio = RemoteObject.createNew ("anywheresoftware.b4a.randomaccessfile.AsyncStreams");__ref.setField("_wtaserverio",wtaserver._wtaserverio);
 //BA.debugLineNum = 6;BA.debugLine="Dim connected As Boolean=False";
wtaserver._connected = wtaserver.__c.getField(true,"False");__ref.setField("_connected",wtaserver._connected);
 //BA.debugLineNum = 7;BA.debugLine="Dim myid As String=\"456\"";
wtaserver._myid = BA.ObjectToString("456");__ref.setField("_myid",wtaserver._myid);
 //BA.debugLineNum = 8;BA.debugLine="Dim clientid As String=\"123\"";
wtaserver._clientid = BA.ObjectToString("123");__ref.setField("_clientid",wtaserver._clientid);
 //BA.debugLineNum = 9;BA.debugLine="Private tmrwtaserver As Timer";
wtaserver._tmrwtaserver = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");__ref.setField("_tmrwtaserver",wtaserver._tmrwtaserver);
 //BA.debugLineNum = 11;BA.debugLine="Private dbsql As String";
wtaserver._dbsql = RemoteObject.createImmutable("");__ref.setField("_dbsql",wtaserver._dbsql);
 //BA.debugLineNum = 12;BA.debugLine="Private notconnected As Int";
wtaserver._notconnected = RemoteObject.createImmutable(0);__ref.setField("_notconnected",wtaserver._notconnected);
 //BA.debugLineNum = 13;BA.debugLine="Private autoconnect As Boolean=True";
wtaserver._autoconnect = wtaserver.__c.getField(true,"True");__ref.setField("_autoconnect",wtaserver._autoconnect);
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _datagrid(RemoteObject __ref,RemoteObject _grid,RemoteObject _strs,RemoteObject _header) throws Exception{
try {
		Debug.PushSubsStack("DataGrid (wtaserver) ","wtaserver",6,__ref.getField(false, "ba"),__ref,140);
if (RapidSub.canDelegate("datagrid")) { return __ref.runUserSub(false, "wtaserver","datagrid", __ref, _grid, _strs, _header);}
RemoteObject _j = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("grid", _grid);
Debug.locals.put("strs", _strs);
Debug.locals.put("header", _header);
 BA.debugLineNum = 140;BA.debugLine="public Sub DataGrid(grid As Table,strs As String,h";
Debug.ShouldStop(2048);
 BA.debugLineNum = 141;BA.debugLine="Dim j As List=ToList(strs)";
Debug.ShouldStop(4096);
_j = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_j = __ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_tolist" /*RemoteObject*/ ,(Object)(_strs));Debug.locals.put("j", _j);Debug.locals.put("j", _j);
 BA.debugLineNum = 142;BA.debugLine="ToGrid(grid,j,header)";
Debug.ShouldStop(8192);
__ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_togrid" /*RemoteObject*/ ,(Object)(_grid),(Object)(_j),(Object)(_header));
 BA.debugLineNum = 143;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _datetimesql(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("DateTimeSQL (wtaserver) ","wtaserver",6,__ref.getField(false, "ba"),__ref,194);
if (RapidSub.canDelegate("datetimesql")) { return __ref.runUserSub(false, "wtaserver","datetimesql", __ref);}
RemoteObject _a = RemoteObject.createImmutable("");
RemoteObject _b = RemoteObject.createImmutable("");
RemoteObject _date = RemoteObject.createImmutable("");
 BA.debugLineNum = 194;BA.debugLine="Sub DateTimeSQL() As String";
Debug.ShouldStop(2);
 BA.debugLineNum = 195;BA.debugLine="Dim a As String=DateTime.Date(DateTime.Now)";
Debug.ShouldStop(4);
_a = wtaserver.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(wtaserver.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("a", _a);Debug.locals.put("a", _a);
 BA.debugLineNum = 196;BA.debugLine="Dim b As String=DateTime.Time(DateTime.Now)";
Debug.ShouldStop(8);
_b = wtaserver.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(wtaserver.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("b", _b);Debug.locals.put("b", _b);
 BA.debugLineNum = 197;BA.debugLine="Dim date=vb6.getCSV(2,\"/\",a) & \"-\" & vb6.getCSV(0";
Debug.ShouldStop(16);
_date = RemoteObject.concat(wtaserver._vb6.runMethod(true,"_getcsv" /*RemoteObject*/ ,__ref.runMethod(false,"getActivityBA"),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.ObjectToString("/")),(Object)(_a)),RemoteObject.createImmutable("-"),wtaserver._vb6.runMethod(true,"_getcsv" /*RemoteObject*/ ,__ref.runMethod(false,"getActivityBA"),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.ObjectToString("/")),(Object)(_a)),RemoteObject.createImmutable("-"),wtaserver._vb6.runMethod(true,"_getcsv" /*RemoteObject*/ ,__ref.runMethod(false,"getActivityBA"),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.ObjectToString("/")),(Object)(_a)),RemoteObject.createImmutable(" "),_b);Debug.locals.put("date", _date);Debug.locals.put("date", _date);
 BA.debugLineNum = 198;BA.debugLine="Return  date";
Debug.ShouldStop(32);
if (true) return _date;
 BA.debugLineNum = 199;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _pmodule,RemoteObject _peventname,RemoteObject _id,RemoteObject _clientid_,RemoteObject _dbsql_x) throws Exception{
try {
		Debug.PushSubsStack("Initialize (wtaserver) ","wtaserver",6,__ref.getField(false, "ba"),__ref,17);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "wtaserver","initialize", __ref, _ba, _pmodule, _peventname, _id, _clientid_, _dbsql_x);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("pModule", _pmodule);
Debug.locals.put("pEventName", _peventname);
Debug.locals.put("id", _id);
Debug.locals.put("clientid_", _clientid_);
Debug.locals.put("dbsql_x", _dbsql_x);
 BA.debugLineNum = 17;BA.debugLine="Public Sub Initialize(pModule As Object, pEventNam";
Debug.ShouldStop(65536);
 BA.debugLineNum = 18;BA.debugLine="mModule    = pModule";
Debug.ShouldStop(131072);
__ref.setField ("_mmodule" /*RemoteObject*/ ,_pmodule);
 BA.debugLineNum = 19;BA.debugLine="mEventName = pEventName";
Debug.ShouldStop(262144);
__ref.setField ("_meventname" /*RemoteObject*/ ,_peventname);
 BA.debugLineNum = 20;BA.debugLine="myid=id";
Debug.ShouldStop(524288);
__ref.setField ("_myid" /*RemoteObject*/ ,_id);
 BA.debugLineNum = 21;BA.debugLine="clientid=clientid_";
Debug.ShouldStop(1048576);
__ref.setField ("_clientid" /*RemoteObject*/ ,_clientid_);
 BA.debugLineNum = 22;BA.debugLine="dbsql=dbsql_x";
Debug.ShouldStop(2097152);
__ref.setField ("_dbsql" /*RemoteObject*/ ,_dbsql_x);
 BA.debugLineNum = 23;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initwtaserver(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("InitWTAServer (wtaserver) ","wtaserver",6,__ref.getField(false, "ba"),__ref,85);
if (RapidSub.canDelegate("initwtaserver")) { return __ref.runUserSub(false, "wtaserver","initwtaserver", __ref);}
 BA.debugLineNum = 85;BA.debugLine="Sub InitWTAServer";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 86;BA.debugLine="Try";
Debug.ShouldStop(2097152);
try { BA.debugLineNum = 87;BA.debugLine="If tmrwtaserver.IsInitialized=False Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_tmrwtaserver" /*RemoteObject*/ ).runMethod(true,"IsInitialized"),wtaserver.__c.getField(true,"False"))) { 
 BA.debugLineNum = 88;BA.debugLine="tmrwtaserver.Initialize(\"tmrwtaserver\",5000)";
Debug.ShouldStop(8388608);
__ref.getField(false,"_tmrwtaserver" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("tmrwtaserver")),(Object)(BA.numberCast(long.class, 5000)));
 BA.debugLineNum = 89;BA.debugLine="tmrwtaserver.Enabled=True";
Debug.ShouldStop(16777216);
__ref.getField(false,"_tmrwtaserver" /*RemoteObject*/ ).runMethod(true,"setEnabled",wtaserver.__c.getField(true,"True"));
 };
 BA.debugLineNum = 91;BA.debugLine="If CheckConnection  Then";
Debug.ShouldStop(67108864);
if (__ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_checkconnection" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 92;BA.debugLine="wsh.Initialize(\"wsh\")";
Debug.ShouldStop(134217728);
__ref.getField(false,"_wsh" /*RemoteObject*/ ).runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("wsh")));
 BA.debugLineNum = 93;BA.debugLine="wsh.Connect(\"184.168.126.221\",5001,30000)";
Debug.ShouldStop(268435456);
__ref.getField(false,"_wsh" /*RemoteObject*/ ).runVoidMethod ("Connect",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("184.168.126.221")),(Object)(BA.numberCast(int.class, 5001)),(Object)(BA.numberCast(int.class, 30000)));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e11) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e11.toString()); BA.debugLineNum = 96;BA.debugLine="ToastMessageShow(\"Check Internet\",False)";
Debug.ShouldStop(-2147483648);
wtaserver.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Check Internet")),(Object)(wtaserver.__c.getField(true,"False")));
 };
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _querry(RemoteObject __ref,RemoteObject _strs,RemoteObject _key) throws Exception{
try {
		Debug.PushSubsStack("Querry (wtaserver) ","wtaserver",6,__ref.getField(false, "ba"),__ref,144);
if (RapidSub.canDelegate("querry")) { return __ref.runUserSub(false, "wtaserver","querry", __ref, _strs, _key);}
RemoteObject _sx = null;
Debug.locals.put("strs", _strs);
Debug.locals.put("key", _key);
 BA.debugLineNum = 144;BA.debugLine="public Sub Querry(strs As String,key As String)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 145;BA.debugLine="strs=strs.Trim";
Debug.ShouldStop(65536);
_strs = _strs.runMethod(true,"trim");Debug.locals.put("strs", _strs);
 BA.debugLineNum = 146;BA.debugLine="Dim sx() As String=Regex.Split(\" \",strs)";
Debug.ShouldStop(131072);
_sx = wtaserver.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(" ")),(Object)(_strs));Debug.locals.put("sx", _sx);Debug.locals.put("sx", _sx);
 BA.debugLineNum = 147;BA.debugLine="If sx(0).ToLowerCase.Contains(\"insert\") Then";
Debug.ShouldStop(262144);
if (_sx.getArrayElement(true,BA.numberCast(int.class, 0)).runMethod(true,"toLowerCase").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("insert"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 148;BA.debugLine="SendServer(\"WTASQLNONQUERRY^\"&strs&\";^\"&dbsql)";
Debug.ShouldStop(524288);
__ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_sendserver" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable("WTASQLNONQUERRY^"),_strs,RemoteObject.createImmutable(";^"),__ref.getField(true,"_dbsql" /*RemoteObject*/ ))));
 };
 BA.debugLineNum = 150;BA.debugLine="If sx(0).ToLowerCase.Contains(\"create\") Then";
Debug.ShouldStop(2097152);
if (_sx.getArrayElement(true,BA.numberCast(int.class, 0)).runMethod(true,"toLowerCase").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("create"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 151;BA.debugLine="SendServer(\"WTASQLNONQUERRY^\"&strs&\";^\"&dbsql)";
Debug.ShouldStop(4194304);
__ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_sendserver" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable("WTASQLNONQUERRY^"),_strs,RemoteObject.createImmutable(";^"),__ref.getField(true,"_dbsql" /*RemoteObject*/ ))));
 };
 BA.debugLineNum = 153;BA.debugLine="If sx(0).ToLowerCase.Contains(\"update\") Then";
Debug.ShouldStop(16777216);
if (_sx.getArrayElement(true,BA.numberCast(int.class, 0)).runMethod(true,"toLowerCase").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("update"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 154;BA.debugLine="SendServer(\"WTASQLNONQUERRY^\" & strs &\";^\"&dbsql";
Debug.ShouldStop(33554432);
__ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_sendserver" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable("WTASQLNONQUERRY^"),_strs,RemoteObject.createImmutable(";^"),__ref.getField(true,"_dbsql" /*RemoteObject*/ ))));
 };
 BA.debugLineNum = 156;BA.debugLine="If sx(0).ToLowerCase.Contains(\"delete\") Then";
Debug.ShouldStop(134217728);
if (_sx.getArrayElement(true,BA.numberCast(int.class, 0)).runMethod(true,"toLowerCase").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("delete"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 157;BA.debugLine="SendServer(\"WTASQLNONQUERRY^\"& strs &\";^\"&dbsql)";
Debug.ShouldStop(268435456);
__ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_sendserver" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable("WTASQLNONQUERRY^"),_strs,RemoteObject.createImmutable(";^"),__ref.getField(true,"_dbsql" /*RemoteObject*/ ))));
 };
 BA.debugLineNum = 160;BA.debugLine="If sx(0).ToLowerCase.Contains(\"select\") Then";
Debug.ShouldStop(-2147483648);
if (_sx.getArrayElement(true,BA.numberCast(int.class, 0)).runMethod(true,"toLowerCase").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("select"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 161;BA.debugLine="SendServer(\"WTASQLQUERRY^\"&strs &\";^\"&dbsql&\"^\"&";
Debug.ShouldStop(1);
__ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_sendserver" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable("WTASQLQUERRY^"),_strs,RemoteObject.createImmutable(";^"),__ref.getField(true,"_dbsql" /*RemoteObject*/ ),RemoteObject.createImmutable("^"),_key)));
 };
 BA.debugLineNum = 163;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sendclient(RemoteObject __ref,RemoteObject _s) throws Exception{
try {
		Debug.PushSubsStack("SendClient (wtaserver) ","wtaserver",6,__ref.getField(false, "ba"),__ref,61);
if (RapidSub.canDelegate("sendclient")) { return __ref.runUserSub(false, "wtaserver","sendclient", __ref, _s);}
Debug.locals.put("s", _s);
 BA.debugLineNum = 61;BA.debugLine="Sub SendClient(s As String)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 62;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 63;BA.debugLine="If wtaserverIO.IsInitialized Then";
Debug.ShouldStop(1073741824);
if (__ref.getField(false,"_wtaserverio" /*RemoteObject*/ ).runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 64;BA.debugLine="s=\"WTARELAY^\" & clientid & \"^\" & s & Chr(13)";
Debug.ShouldStop(-2147483648);
_s = RemoteObject.concat(RemoteObject.createImmutable("WTARELAY^"),__ref.getField(true,"_clientid" /*RemoteObject*/ ),RemoteObject.createImmutable("^"),_s,wtaserver.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 13))));Debug.locals.put("s", _s);
 BA.debugLineNum = 65;BA.debugLine="wtaserverIO.Write(s.GetBytes(\"UTF8\"))";
Debug.ShouldStop(1);
__ref.getField(false,"_wtaserverio" /*RemoteObject*/ ).runVoidMethod ("Write",(Object)(_s.runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")))));
 }else {
 BA.debugLineNum = 67;BA.debugLine="connected=False";
Debug.ShouldStop(4);
__ref.setField ("_connected" /*RemoteObject*/ ,wtaserver.__c.getField(true,"False"));
 BA.debugLineNum = 68;BA.debugLine="InitWTAServer";
Debug.ShouldStop(8);
__ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_initwtaserver" /*RemoteObject*/ );
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e10) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e10.toString()); BA.debugLineNum = 71;BA.debugLine="ToastMessageShow(\"Check Internet\",False)";
Debug.ShouldStop(64);
wtaserver.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Check Internet")),(Object)(wtaserver.__c.getField(true,"False")));
 };
 BA.debugLineNum = 73;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sendserver(RemoteObject __ref,RemoteObject _s) throws Exception{
try {
		Debug.PushSubsStack("SendServer (wtaserver) ","wtaserver",6,__ref.getField(false, "ba"),__ref,49);
if (RapidSub.canDelegate("sendserver")) { return __ref.runUserSub(false, "wtaserver","sendserver", __ref, _s);}
Debug.locals.put("s", _s);
 BA.debugLineNum = 49;BA.debugLine="Sub SendServer(s As String)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="Try";
Debug.ShouldStop(131072);
try { BA.debugLineNum = 51;BA.debugLine="s=s&Chr(13)";
Debug.ShouldStop(262144);
_s = RemoteObject.concat(_s,wtaserver.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 13))));Debug.locals.put("s", _s);
 BA.debugLineNum = 52;BA.debugLine="If wtaserverIO.IsInitialized Then";
Debug.ShouldStop(524288);
if (__ref.getField(false,"_wtaserverio" /*RemoteObject*/ ).runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 53;BA.debugLine="wtaserverIO.Write(s.GetBytes(\"UTF8\"))";
Debug.ShouldStop(1048576);
__ref.getField(false,"_wtaserverio" /*RemoteObject*/ ).runVoidMethod ("Write",(Object)(_s.runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")))));
 }else {
 BA.debugLineNum = 55;BA.debugLine="InitWTAServer";
Debug.ShouldStop(4194304);
__ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_initwtaserver" /*RemoteObject*/ );
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e9.toString()); BA.debugLineNum = 58;BA.debugLine="ToastMessageShow(\"Check Internet\",False)";
Debug.ShouldStop(33554432);
wtaserver.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Check Internet")),(Object)(wtaserver.__c.getField(true,"False")));
 };
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tmrwtaserver_tick(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("tmrwtaserver_Tick (wtaserver) ","wtaserver",6,__ref.getField(false, "ba"),__ref,99);
if (RapidSub.canDelegate("tmrwtaserver_tick")) { return __ref.runUserSub(false, "wtaserver","tmrwtaserver_tick", __ref);}
 BA.debugLineNum = 99;BA.debugLine="Sub tmrwtaserver_Tick";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="If autoconnect Then";
Debug.ShouldStop(8);
if (__ref.getField(true,"_autoconnect" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 101;BA.debugLine="If notconnected=3 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_notconnected" /*RemoteObject*/ ),BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 102;BA.debugLine="ToastMessageShow(\"check connection\",False)";
Debug.ShouldStop(32);
wtaserver.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("check connection")),(Object)(wtaserver.__c.getField(true,"False")));
 BA.debugLineNum = 103;BA.debugLine="wsh.Close";
Debug.ShouldStop(64);
__ref.getField(false,"_wsh" /*RemoteObject*/ ).runVoidMethod ("Close");
 BA.debugLineNum = 104;BA.debugLine="InitWTAServer";
Debug.ShouldStop(128);
__ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_initwtaserver" /*RemoteObject*/ );
 }else {
 BA.debugLineNum = 106;BA.debugLine="notconnected=notconnected+1";
Debug.ShouldStop(512);
__ref.setField ("_notconnected" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_notconnected" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+",1, 1));
 BA.debugLineNum = 107;BA.debugLine="SendServer(\"WTASQLTIME\")'prevent disconnection";
Debug.ShouldStop(1024);
__ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_sendserver" /*RemoteObject*/ ,(Object)(RemoteObject.createImmutable("WTASQLTIME")));
 };
 }else {
 BA.debugLineNum = 111;BA.debugLine="SendServer(\"x\")'prevent disconnection";
Debug.ShouldStop(16384);
__ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_sendserver" /*RemoteObject*/ ,(Object)(RemoteObject.createImmutable("x")));
 };
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _togrid(RemoteObject __ref,RemoteObject _grid,RemoteObject _j,RemoteObject _header) throws Exception{
try {
		Debug.PushSubsStack("ToGrid (wtaserver) ","wtaserver",6,__ref.getField(false, "ba"),__ref,164);
if (RapidSub.canDelegate("togrid")) { return __ref.runUserSub(false, "wtaserver","togrid", __ref, _grid, _j, _header);}
RemoteObject _strs = RemoteObject.createImmutable("");
int _a = 0;
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _c = 0;
RemoteObject _d = RemoteObject.createImmutable("");
RemoteObject _fname = RemoteObject.createImmutable("");
Debug.locals.put("grid", _grid);
Debug.locals.put("j", _j);
Debug.locals.put("header", _header);
 BA.debugLineNum = 164;BA.debugLine="private Sub ToGrid(grid As Table,j As List,header";
Debug.ShouldStop(8);
 BA.debugLineNum = 165;BA.debugLine="Dim strs As String=header &CRLF";
Debug.ShouldStop(16);
_strs = RemoteObject.concat(_header,wtaserver.__c.getField(true,"CRLF"));Debug.locals.put("strs", _strs);Debug.locals.put("strs", _strs);
 BA.debugLineNum = 166;BA.debugLine="For a =0  To j.Size-1";
Debug.ShouldStop(32);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {_j.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_a = 0 ;
for (;(step2 > 0 && _a <= limit2) || (step2 < 0 && _a >= limit2) ;_a = ((int)(0 + _a + step2))  ) {
Debug.locals.put("a", _a);
 BA.debugLineNum = 167;BA.debugLine="Dim b As List	=j.get(a)'Log(j.Get(a))";
Debug.ShouldStop(64);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_b.setObject(_j.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _a))));Debug.locals.put("b", _b);
 BA.debugLineNum = 168;BA.debugLine="For c =0  To b.Size-1";
Debug.ShouldStop(128);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {_b.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_c = 0 ;
for (;(step4 > 0 && _c <= limit4) || (step4 < 0 && _c >= limit4) ;_c = ((int)(0 + _c + step4))  ) {
Debug.locals.put("c", _c);
 BA.debugLineNum = 169;BA.debugLine="Dim d As String=b.get(c)'Log(j.Get(a))";
Debug.ShouldStop(256);
_d = BA.ObjectToString(_b.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _c))));Debug.locals.put("d", _d);Debug.locals.put("d", _d);
 BA.debugLineNum = 170;BA.debugLine="d=d.Replace(\",\",\" \")' supress comma";
Debug.ShouldStop(512);
_d = _d.runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable(" ")));Debug.locals.put("d", _d);
 BA.debugLineNum = 171;BA.debugLine="strs=strs&d&\",\"";
Debug.ShouldStop(1024);
_strs = RemoteObject.concat(_strs,_d,RemoteObject.createImmutable(","));Debug.locals.put("strs", _strs);
 }
}Debug.locals.put("c", _c);
;
 BA.debugLineNum = 173;BA.debugLine="strs=strs.SubString2(0,strs.Length-1)";
Debug.ShouldStop(4096);
_strs = _strs.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_strs.runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)));Debug.locals.put("strs", _strs);
 BA.debugLineNum = 174;BA.debugLine="strs=strs&CRLF";
Debug.ShouldStop(8192);
_strs = RemoteObject.concat(_strs,wtaserver.__c.getField(true,"CRLF"));Debug.locals.put("strs", _strs);
 }
}Debug.locals.put("a", _a);
;
 BA.debugLineNum = 176;BA.debugLine="Dim fname As String=\"mycsv.csv\"";
Debug.ShouldStop(32768);
_fname = BA.ObjectToString("mycsv.csv");Debug.locals.put("fname", _fname);Debug.locals.put("fname", _fname);
 BA.debugLineNum = 177;BA.debugLine="If File.Exists(File.DirInternal,fname) Then";
Debug.ShouldStop(65536);
if (wtaserver.__c.getField(false,"File").runMethod(true,"Exists",(Object)(wtaserver.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_fname)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 178;BA.debugLine="File.Delete(File.DirInternal,fname)";
Debug.ShouldStop(131072);
wtaserver.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(wtaserver.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_fname));
 };
 BA.debugLineNum = 180;BA.debugLine="File.WriteString(File.DirInternal,fname,strs)";
Debug.ShouldStop(524288);
wtaserver.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(wtaserver.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_fname),(Object)(_strs));
 BA.debugLineNum = 181;BA.debugLine="grid.LoadTableFromCSV(File.DirInternal,fname,True";
Debug.ShouldStop(1048576);
_grid.runClassMethod (b4a.OPTUMizerPatient.table.class, "_loadtablefromcsv" /*RemoteObject*/ ,(Object)(wtaserver.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_fname),(Object)(wtaserver.__c.getField(true,"True")));
 BA.debugLineNum = 182;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tolist(RemoteObject __ref,RemoteObject _s) throws Exception{
try {
		Debug.PushSubsStack("ToList (wtaserver) ","wtaserver",6,__ref.getField(false, "ba"),__ref,183);
if (RapidSub.canDelegate("tolist")) { return __ref.runUserSub(false, "wtaserver","tolist", __ref, _s);}
RemoteObject _json = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _jsls = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("s", _s);
 BA.debugLineNum = 183;BA.debugLine="Sub ToList(s As String) As List";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 184;BA.debugLine="Dim JSon As JSONParser";
Debug.ShouldStop(8388608);
_json = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("JSon", _json);
 BA.debugLineNum = 185;BA.debugLine="s=s.Replace(\",)\",\")\")";
Debug.ShouldStop(16777216);
_s = _s.runMethod(true,"replace",(Object)(BA.ObjectToString(",)")),(Object)(RemoteObject.createImmutable(")")));Debug.locals.put("s", _s);
 BA.debugLineNum = 186;BA.debugLine="s=s.Replace(\")\",\"]\")";
Debug.ShouldStop(33554432);
_s = _s.runMethod(true,"replace",(Object)(BA.ObjectToString(")")),(Object)(RemoteObject.createImmutable("]")));Debug.locals.put("s", _s);
 BA.debugLineNum = 187;BA.debugLine="s=s.Replace(\"(\",\"[\")";
Debug.ShouldStop(67108864);
_s = _s.runMethod(true,"replace",(Object)(BA.ObjectToString("(")),(Object)(RemoteObject.createImmutable("[")));Debug.locals.put("s", _s);
 BA.debugLineNum = 188;BA.debugLine="JSon.Initialize(s)";
Debug.ShouldStop(134217728);
_json.runVoidMethod ("Initialize",(Object)(_s));
 BA.debugLineNum = 189;BA.debugLine="Dim JSLs As List";
Debug.ShouldStop(268435456);
_jsls = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("JSLs", _jsls);
 BA.debugLineNum = 190;BA.debugLine="JSLs.Initialize";
Debug.ShouldStop(536870912);
_jsls.runVoidMethod ("Initialize");
 BA.debugLineNum = 191;BA.debugLine="JSLs = JSon.nextArray";
Debug.ShouldStop(1073741824);
_jsls = _json.runMethod(false,"NextArray");Debug.locals.put("JSLs", _jsls);
 BA.debugLineNum = 192;BA.debugLine="Return JSLs";
Debug.ShouldStop(-2147483648);
if (true) return _jsls;
 BA.debugLineNum = 193;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _wsh_connected(RemoteObject __ref,RemoteObject _successful) throws Exception{
try {
		Debug.PushSubsStack("wsh_Connected (wtaserver) ","wtaserver",6,__ref.getField(false, "ba"),__ref,24);
if (RapidSub.canDelegate("wsh_connected")) { return __ref.runUserSub(false, "wtaserver","wsh_connected", __ref, _successful);}
RemoteObject _strs = RemoteObject.createImmutable("");
Debug.locals.put("Successful", _successful);
 BA.debugLineNum = 24;BA.debugLine="Sub wsh_Connected(Successful As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(16777216);
wtaserver.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 27;BA.debugLine="If Successful Then";
Debug.ShouldStop(67108864);
if (_successful.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 29;BA.debugLine="wtaserverIO.Initialize(wsh.InputStream,wsh.Outpu";
Debug.ShouldStop(268435456);
__ref.getField(false,"_wtaserverio" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_wsh" /*RemoteObject*/ ).runMethod(false,"getInputStream")),(Object)(__ref.getField(false,"_wsh" /*RemoteObject*/ ).runMethod(false,"getOutputStream")),(Object)(RemoteObject.createImmutable("wsh")));
 BA.debugLineNum = 30;BA.debugLine="Dim strs As String=\"WTAREGISTER^\"&myid & Chr(13)";
Debug.ShouldStop(536870912);
_strs = RemoteObject.concat(RemoteObject.createImmutable("WTAREGISTER^"),__ref.getField(true,"_myid" /*RemoteObject*/ ),wtaserver.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 13))));Debug.locals.put("strs", _strs);Debug.locals.put("strs", _strs);
 BA.debugLineNum = 31;BA.debugLine="wtaserverIO.Write(strs.GetBytes(\"UTF8\"))";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_wtaserverio" /*RemoteObject*/ ).runVoidMethod ("Write",(Object)(_strs.runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")))));
 BA.debugLineNum = 32;BA.debugLine="connected=True";
Debug.ShouldStop(-2147483648);
__ref.setField ("_connected" /*RemoteObject*/ ,wtaserver.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 34;BA.debugLine="wsh.Close";
Debug.ShouldStop(2);
__ref.getField(false,"_wsh" /*RemoteObject*/ ).runVoidMethod ("Close");
 BA.debugLineNum = 35;BA.debugLine="Msgbox(\"Please Tr-y Again\",\"Error Connecting\")";
Debug.ShouldStop(4);
wtaserver.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence("Please Tr-y Again")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error Connecting"))),__ref.runMethod(false,"getActivityBA"));
 };
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _wsh_newdata(RemoteObject __ref,RemoteObject _buffer) throws Exception{
try {
		Debug.PushSubsStack("wsh_NewData (wtaserver) ","wtaserver",6,__ref.getField(false, "ba"),__ref,39);
if (RapidSub.canDelegate("wsh_newdata")) { return __ref.runUserSub(false, "wtaserver","wsh_newdata", __ref, _buffer);}
RemoteObject _mline = RemoteObject.createImmutable("");
Debug.locals.put("Buffer", _buffer);
 BA.debugLineNum = 39;BA.debugLine="Sub wsh_NewData(Buffer() As Byte)";
Debug.ShouldStop(64);
 BA.debugLineNum = 40;BA.debugLine="Dim mLine As String";
Debug.ShouldStop(128);
_mline = RemoteObject.createImmutable("");Debug.locals.put("mLine", _mline);
 BA.debugLineNum = 41;BA.debugLine="mLine = BytesToString(Buffer,0,Buffer.Length,\"UTF";
Debug.ShouldStop(256);
_mline = wtaserver.__c.runMethod(true,"BytesToString",(Object)(_buffer),(Object)(BA.numberCast(int.class, 0)),(Object)(_buffer.getField(true,"length")),(Object)(RemoteObject.createImmutable("UTF-8")));Debug.locals.put("mLine", _mline);
 BA.debugLineNum = 42;BA.debugLine="notconnected=0";
Debug.ShouldStop(512);
__ref.setField ("_notconnected" /*RemoteObject*/ ,BA.numberCast(int.class, 0));
 BA.debugLineNum = 43;BA.debugLine="If SubExists(mModule,mEventName & \"_\" & \"NewData\"";
Debug.ShouldStop(1024);
if (wtaserver.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mmodule" /*RemoteObject*/ )),(Object)(RemoteObject.concat(__ref.getField(true,"_meventname" /*RemoteObject*/ ),RemoteObject.createImmutable("_"),RemoteObject.createImmutable("NewData")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 44;BA.debugLine="CallSub2(mModule,mEventName & \"_\" & \"NewData\",mL";
Debug.ShouldStop(2048);
wtaserver.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mmodule" /*RemoteObject*/ )),(Object)(RemoteObject.concat(__ref.getField(true,"_meventname" /*RemoteObject*/ ),RemoteObject.createImmutable("_"),RemoteObject.createImmutable("NewData"))),(Object)((_mline)));
 };
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _wtaserver_error(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("wtaserver_Error (wtaserver) ","wtaserver",6,__ref.getField(false, "ba"),__ref,79);
if (RapidSub.canDelegate("wtaserver_error")) { return __ref.runUserSub(false, "wtaserver","wtaserver_error", __ref);}
 BA.debugLineNum = 79;BA.debugLine="Sub wtaserver_Error()";
Debug.ShouldStop(16384);
 BA.debugLineNum = 80;BA.debugLine="wtaserverIO.Close";
Debug.ShouldStop(32768);
__ref.getField(false,"_wtaserverio" /*RemoteObject*/ ).runVoidMethod ("Close");
 BA.debugLineNum = 81;BA.debugLine="wsh.Close";
Debug.ShouldStop(65536);
__ref.getField(false,"_wsh" /*RemoteObject*/ ).runVoidMethod ("Close");
 BA.debugLineNum = 82;BA.debugLine="connected=False";
Debug.ShouldStop(131072);
__ref.setField ("_connected" /*RemoteObject*/ ,wtaserver.__c.getField(true,"False"));
 BA.debugLineNum = 83;BA.debugLine="ToastMessageShow(\"wtaserver_Error\",False)";
Debug.ShouldStop(262144);
wtaserver.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("wtaserver_Error")),(Object)(wtaserver.__c.getField(true,"False")));
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _wtaserver_terminated(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("wtaserver_Terminated (wtaserver) ","wtaserver",6,__ref.getField(false, "ba"),__ref,75);
if (RapidSub.canDelegate("wtaserver_terminated")) { return __ref.runUserSub(false, "wtaserver","wtaserver_terminated", __ref);}
 BA.debugLineNum = 75;BA.debugLine="Sub wtaserver_Terminated()";
Debug.ShouldStop(1024);
 BA.debugLineNum = 76;BA.debugLine="ToastMessageShow(\"Terminated raks\",False)";
Debug.ShouldStop(2048);
wtaserver.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Terminated raks")),(Object)(wtaserver.__c.getField(true,"False")));
 BA.debugLineNum = 77;BA.debugLine="connected=False";
Debug.ShouldStop(4096);
__ref.setField ("_connected" /*RemoteObject*/ ,wtaserver.__c.getField(true,"False"));
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}