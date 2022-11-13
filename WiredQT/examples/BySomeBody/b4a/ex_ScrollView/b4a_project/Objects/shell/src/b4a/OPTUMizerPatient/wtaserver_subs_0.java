package b4a.OPTUMizerPatient;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class wtaserver_subs_0 {


public static RemoteObject  _checkconnection(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("CheckConnection (wtaserver) ","wtaserver",5,__ref.getField(false, "ba"),__ref,96);
if (RapidSub.canDelegate("checkconnection")) { return __ref.runUserSub(false, "wtaserver","checkconnection", __ref);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
 BA.debugLineNum = 96;BA.debugLine="Sub CheckConnection As Boolean";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(1);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 99;BA.debugLine="If (p.GetDataState == \"CONNECTED\") Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",_p.runMethod(true,"GetDataState"),RemoteObject.createImmutable("CONNECTED")))) { 
 BA.debugLineNum = 100;BA.debugLine="Return True";
Debug.ShouldStop(8);
if (true) return wtaserver.__c.getField(true,"True");
 };
 BA.debugLineNum = 103;BA.debugLine="If (p.GetSettings (\"wifi_on\") == 1) Then";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean("=",_p.runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("wifi_on"))),BA.NumberToString(1)))) { 
 BA.debugLineNum = 104;BA.debugLine="Return True";
Debug.ShouldStop(128);
if (true) return wtaserver.__c.getField(true,"True");
 };
 BA.debugLineNum = 107;BA.debugLine="If (p.GetDataState == \"DISCONNECTED\") Then";
Debug.ShouldStop(1024);
if ((RemoteObject.solveBoolean("=",_p.runMethod(true,"GetDataState"),RemoteObject.createImmutable("DISCONNECTED")))) { 
 BA.debugLineNum = 108;BA.debugLine="Return False";
Debug.ShouldStop(2048);
if (true) return wtaserver.__c.getField(true,"False");
 };
 BA.debugLineNum = 111;BA.debugLine="If (p.GetDataState == \"SUSPENDED\") Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",_p.runMethod(true,"GetDataState"),RemoteObject.createImmutable("SUSPENDED")))) { 
 BA.debugLineNum = 112;BA.debugLine="Return False";
Debug.ShouldStop(32768);
if (true) return wtaserver.__c.getField(true,"False");
 };
 BA.debugLineNum = 114;BA.debugLine="Return False";
Debug.ShouldStop(131072);
if (true) return wtaserver.__c.getField(true,"False");
 BA.debugLineNum = 115;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _pmodule,RemoteObject _peventname,RemoteObject _id,RemoteObject _clientid_) throws Exception{
try {
		Debug.PushSubsStack("Initialize (wtaserver) ","wtaserver",5,__ref.getField(false, "ba"),__ref,14);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "wtaserver","initialize", __ref, _ba, _pmodule, _peventname, _id, _clientid_);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("pModule", _pmodule);
Debug.locals.put("pEventName", _peventname);
Debug.locals.put("id", _id);
Debug.locals.put("clientid_", _clientid_);
 BA.debugLineNum = 14;BA.debugLine="Public Sub Initialize(pModule As Object, pEventNam";
Debug.ShouldStop(8192);
 BA.debugLineNum = 15;BA.debugLine="mModule    = pModule";
Debug.ShouldStop(16384);
__ref.setField ("_mmodule" /*RemoteObject*/ ,_pmodule);
 BA.debugLineNum = 16;BA.debugLine="mEventName = pEventName";
Debug.ShouldStop(32768);
__ref.setField ("_meventname" /*RemoteObject*/ ,_peventname);
 BA.debugLineNum = 17;BA.debugLine="myid=id";
Debug.ShouldStop(65536);
__ref.setField ("_myid" /*RemoteObject*/ ,_id);
 BA.debugLineNum = 18;BA.debugLine="clientid=clientid_";
Debug.ShouldStop(131072);
__ref.setField ("_clientid" /*RemoteObject*/ ,_clientid_);
 BA.debugLineNum = 19;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("InitWTAServer (wtaserver) ","wtaserver",5,__ref.getField(false, "ba"),__ref,79);
if (RapidSub.canDelegate("initwtaserver")) { return __ref.runUserSub(false, "wtaserver","initwtaserver", __ref);}
 BA.debugLineNum = 79;BA.debugLine="Sub InitWTAServer";
Debug.ShouldStop(16384);
 BA.debugLineNum = 80;BA.debugLine="Try";
Debug.ShouldStop(32768);
try { BA.debugLineNum = 81;BA.debugLine="If tmrwtaserver.IsInitialized=False Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_tmrwtaserver" /*RemoteObject*/ ).runMethod(true,"IsInitialized"),wtaserver.__c.getField(true,"False"))) { 
 BA.debugLineNum = 82;BA.debugLine="tmrwtaserver.Initialize(\"tmrwtaserver\",5000)";
Debug.ShouldStop(131072);
__ref.getField(false,"_tmrwtaserver" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("tmrwtaserver")),(Object)(BA.numberCast(long.class, 5000)));
 BA.debugLineNum = 83;BA.debugLine="tmrwtaserver.Enabled=True";
Debug.ShouldStop(262144);
__ref.getField(false,"_tmrwtaserver" /*RemoteObject*/ ).runMethod(true,"setEnabled",wtaserver.__c.getField(true,"True"));
 };
 BA.debugLineNum = 85;BA.debugLine="If CheckConnection  Then";
Debug.ShouldStop(1048576);
if (__ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_checkconnection" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 86;BA.debugLine="wsh.Initialize(\"wsh\")";
Debug.ShouldStop(2097152);
__ref.getField(false,"_wsh" /*RemoteObject*/ ).runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("wsh")));
 BA.debugLineNum = 87;BA.debugLine="wsh.Connect(\"184.168.126.221\",5001,30000)";
Debug.ShouldStop(4194304);
__ref.getField(false,"_wsh" /*RemoteObject*/ ).runVoidMethod ("Connect",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("184.168.126.221")),(Object)(BA.numberCast(int.class, 5001)),(Object)(BA.numberCast(int.class, 30000)));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e11) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e11.toString()); BA.debugLineNum = 90;BA.debugLine="ToastMessageShow(\"Check Internet\",False)";
Debug.ShouldStop(33554432);
wtaserver.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Check Internet")),(Object)(wtaserver.__c.getField(true,"False")));
 };
 BA.debugLineNum = 92;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("SendClient (wtaserver) ","wtaserver",5,__ref.getField(false, "ba"),__ref,55);
if (RapidSub.canDelegate("sendclient")) { return __ref.runUserSub(false, "wtaserver","sendclient", __ref, _s);}
Debug.locals.put("s", _s);
 BA.debugLineNum = 55;BA.debugLine="Sub SendClient(s As String)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="Try";
Debug.ShouldStop(8388608);
try { BA.debugLineNum = 57;BA.debugLine="If wtaserverIO.IsInitialized Then";
Debug.ShouldStop(16777216);
if (__ref.getField(false,"_wtaserverio" /*RemoteObject*/ ).runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 58;BA.debugLine="s=\"WTARELAY^\" & clientid & \"^\" & s & Chr(13)";
Debug.ShouldStop(33554432);
_s = RemoteObject.concat(RemoteObject.createImmutable("WTARELAY^"),__ref.getField(true,"_clientid" /*RemoteObject*/ ),RemoteObject.createImmutable("^"),_s,wtaserver.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 13))));Debug.locals.put("s", _s);
 BA.debugLineNum = 59;BA.debugLine="wtaserverIO.Write(s.GetBytes(\"UTF8\"))";
Debug.ShouldStop(67108864);
__ref.getField(false,"_wtaserverio" /*RemoteObject*/ ).runVoidMethod ("Write",(Object)(_s.runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")))));
 }else {
 BA.debugLineNum = 61;BA.debugLine="connected=False";
Debug.ShouldStop(268435456);
__ref.setField ("_connected" /*RemoteObject*/ ,wtaserver.__c.getField(true,"False"));
 BA.debugLineNum = 62;BA.debugLine="InitWTAServer";
Debug.ShouldStop(536870912);
__ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_initwtaserver" /*RemoteObject*/ );
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e10) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e10.toString()); BA.debugLineNum = 65;BA.debugLine="ToastMessageShow(\"Check Internet\",False)";
Debug.ShouldStop(1);
wtaserver.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Check Internet")),(Object)(wtaserver.__c.getField(true,"False")));
 };
 BA.debugLineNum = 67;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("SendServer (wtaserver) ","wtaserver",5,__ref.getField(false, "ba"),__ref,43);
if (RapidSub.canDelegate("sendserver")) { return __ref.runUserSub(false, "wtaserver","sendserver", __ref, _s);}
Debug.locals.put("s", _s);
 BA.debugLineNum = 43;BA.debugLine="Sub SendServer(s As String)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="Try";
Debug.ShouldStop(2048);
try { BA.debugLineNum = 45;BA.debugLine="s=s&Chr(13)";
Debug.ShouldStop(4096);
_s = RemoteObject.concat(_s,wtaserver.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 13))));Debug.locals.put("s", _s);
 BA.debugLineNum = 46;BA.debugLine="If wtaserverIO.IsInitialized Then";
Debug.ShouldStop(8192);
if (__ref.getField(false,"_wtaserverio" /*RemoteObject*/ ).runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 47;BA.debugLine="wtaserverIO.Write(s.GetBytes(\"UTF8\"))";
Debug.ShouldStop(16384);
__ref.getField(false,"_wtaserverio" /*RemoteObject*/ ).runVoidMethod ("Write",(Object)(_s.runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")))));
 }else {
 BA.debugLineNum = 49;BA.debugLine="InitWTAServer";
Debug.ShouldStop(65536);
__ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_initwtaserver" /*RemoteObject*/ );
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e9.toString()); BA.debugLineNum = 52;BA.debugLine="ToastMessageShow(\"Check Internet\",False)";
Debug.ShouldStop(524288);
wtaserver.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Check Internet")),(Object)(wtaserver.__c.getField(true,"False")));
 };
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("tmrwtaserver_Tick (wtaserver) ","wtaserver",5,__ref.getField(false, "ba"),__ref,93);
if (RapidSub.canDelegate("tmrwtaserver_tick")) { return __ref.runUserSub(false, "wtaserver","tmrwtaserver_tick", __ref);}
 BA.debugLineNum = 93;BA.debugLine="Sub tmrwtaserver_Tick";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 94;BA.debugLine="SendServer(\"x\")'prevent disconnection";
Debug.ShouldStop(536870912);
__ref.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_sendserver" /*RemoteObject*/ ,(Object)(RemoteObject.createImmutable("x")));
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _wsh_connected(RemoteObject __ref,RemoteObject _successful) throws Exception{
try {
		Debug.PushSubsStack("wsh_Connected (wtaserver) ","wtaserver",5,__ref.getField(false, "ba"),__ref,20);
if (RapidSub.canDelegate("wsh_connected")) { return __ref.runUserSub(false, "wtaserver","wsh_connected", __ref, _successful);}
RemoteObject _strs = RemoteObject.createImmutable("");
Debug.locals.put("Successful", _successful);
 BA.debugLineNum = 20;BA.debugLine="Sub wsh_Connected(Successful As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 21;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(1048576);
wtaserver.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 23;BA.debugLine="If Successful Then";
Debug.ShouldStop(4194304);
if (_successful.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 25;BA.debugLine="wtaserverIO.Initialize(wsh.InputStream,wsh.Outpu";
Debug.ShouldStop(16777216);
__ref.getField(false,"_wtaserverio" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_wsh" /*RemoteObject*/ ).runMethod(false,"getInputStream")),(Object)(__ref.getField(false,"_wsh" /*RemoteObject*/ ).runMethod(false,"getOutputStream")),(Object)(RemoteObject.createImmutable("wsh")));
 BA.debugLineNum = 26;BA.debugLine="Dim strs As String=\"WTAREGISTER^\"&myid & Chr(13)";
Debug.ShouldStop(33554432);
_strs = RemoteObject.concat(RemoteObject.createImmutable("WTAREGISTER^"),__ref.getField(true,"_myid" /*RemoteObject*/ ),wtaserver.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 13))));Debug.locals.put("strs", _strs);Debug.locals.put("strs", _strs);
 BA.debugLineNum = 27;BA.debugLine="wtaserverIO.Write(strs.GetBytes(\"UTF8\"))";
Debug.ShouldStop(67108864);
__ref.getField(false,"_wtaserverio" /*RemoteObject*/ ).runVoidMethod ("Write",(Object)(_strs.runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")))));
 BA.debugLineNum = 28;BA.debugLine="connected=True";
Debug.ShouldStop(134217728);
__ref.setField ("_connected" /*RemoteObject*/ ,wtaserver.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 30;BA.debugLine="wsh.Close";
Debug.ShouldStop(536870912);
__ref.getField(false,"_wsh" /*RemoteObject*/ ).runVoidMethod ("Close");
 BA.debugLineNum = 31;BA.debugLine="Msgbox(\"Please Tr-y Again\",\"Error Connecting\")";
Debug.ShouldStop(1073741824);
wtaserver.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence("Please Tr-y Again")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error Connecting"))),__ref.runMethod(false,"getActivityBA"));
 };
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("wsh_NewData (wtaserver) ","wtaserver",5,__ref.getField(false, "ba"),__ref,35);
if (RapidSub.canDelegate("wsh_newdata")) { return __ref.runUserSub(false, "wtaserver","wsh_newdata", __ref, _buffer);}
RemoteObject _mline = RemoteObject.createImmutable("");
Debug.locals.put("Buffer", _buffer);
 BA.debugLineNum = 35;BA.debugLine="Sub wsh_NewData(Buffer() As Byte)";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="Dim mLine As String";
Debug.ShouldStop(8);
_mline = RemoteObject.createImmutable("");Debug.locals.put("mLine", _mline);
 BA.debugLineNum = 37;BA.debugLine="mLine = BytesToString(Buffer,0,Buffer.Length,\"UTF";
Debug.ShouldStop(16);
_mline = wtaserver.__c.runMethod(true,"BytesToString",(Object)(_buffer),(Object)(BA.numberCast(int.class, 0)),(Object)(_buffer.getField(true,"length")),(Object)(RemoteObject.createImmutable("UTF-8")));Debug.locals.put("mLine", _mline);
 BA.debugLineNum = 38;BA.debugLine="If SubExists(mModule,mEventName & \"_\" & \"NewData\"";
Debug.ShouldStop(32);
if (wtaserver.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mmodule" /*RemoteObject*/ )),(Object)(RemoteObject.concat(__ref.getField(true,"_meventname" /*RemoteObject*/ ),RemoteObject.createImmutable("_"),RemoteObject.createImmutable("NewData")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 39;BA.debugLine="CallSub2(mModule,mEventName & \"_\" & \"NewData\",mL";
Debug.ShouldStop(64);
wtaserver.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mmodule" /*RemoteObject*/ )),(Object)(RemoteObject.concat(__ref.getField(true,"_meventname" /*RemoteObject*/ ),RemoteObject.createImmutable("_"),RemoteObject.createImmutable("NewData"))),(Object)((_mline)));
 };
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("wtaserver_Error (wtaserver) ","wtaserver",5,__ref.getField(false, "ba"),__ref,73);
if (RapidSub.canDelegate("wtaserver_error")) { return __ref.runUserSub(false, "wtaserver","wtaserver_error", __ref);}
 BA.debugLineNum = 73;BA.debugLine="Sub wtaserver_Error()";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="wtaserverIO.Close";
Debug.ShouldStop(512);
__ref.getField(false,"_wtaserverio" /*RemoteObject*/ ).runVoidMethod ("Close");
 BA.debugLineNum = 75;BA.debugLine="wsh.Close";
Debug.ShouldStop(1024);
__ref.getField(false,"_wsh" /*RemoteObject*/ ).runVoidMethod ("Close");
 BA.debugLineNum = 76;BA.debugLine="connected=False";
Debug.ShouldStop(2048);
__ref.setField ("_connected" /*RemoteObject*/ ,wtaserver.__c.getField(true,"False"));
 BA.debugLineNum = 77;BA.debugLine="ToastMessageShow(\"wtaserver_Error\",False)";
Debug.ShouldStop(4096);
wtaserver.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("wtaserver_Error")),(Object)(wtaserver.__c.getField(true,"False")));
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
public static RemoteObject  _wtaserver_terminated(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("wtaserver_Terminated (wtaserver) ","wtaserver",5,__ref.getField(false, "ba"),__ref,69);
if (RapidSub.canDelegate("wtaserver_terminated")) { return __ref.runUserSub(false, "wtaserver","wtaserver_terminated", __ref);}
 BA.debugLineNum = 69;BA.debugLine="Sub wtaserver_Terminated()";
Debug.ShouldStop(16);
 BA.debugLineNum = 70;BA.debugLine="ToastMessageShow(\"Terminated raks\",False)";
Debug.ShouldStop(32);
wtaserver.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Terminated raks")),(Object)(wtaserver.__c.getField(true,"False")));
 BA.debugLineNum = 71;BA.debugLine="connected=False";
Debug.ShouldStop(64);
__ref.setField ("_connected" /*RemoteObject*/ ,wtaserver.__c.getField(true,"False"));
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}