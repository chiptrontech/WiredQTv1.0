package b4a.OPTUMizerPatient;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class starter_subs_0 {


public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (starter) ","starter",1,starter.processBA,starter.mostCurrent,231);
if (RapidSub.canDelegate("application_error")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","application_error", _error, _stacktrace);}
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 231;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(64);
 BA.debugLineNum = 232;BA.debugLine="Return True";
Debug.ShouldStop(128);
if (true) return starter.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 233;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _astream_newdata(RemoteObject _buffer) throws Exception{
try {
		Debug.PushSubsStack("astream_NewData (starter) ","starter",1,starter.processBA,starter.mostCurrent,141);
if (RapidSub.canDelegate("astream_newdata")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","astream_newdata", _buffer);}
RemoteObject _str = RemoteObject.createImmutable("");
RemoteObject _aa = RemoteObject.createImmutable(0);
RemoteObject _z = RemoteObject.createImmutable("");
Debug.locals.put("Buffer", _buffer);
 BA.debugLineNum = 141;BA.debugLine="Sub astream_NewData (Buffer() As Byte)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 142;BA.debugLine="Dim str As String";
Debug.ShouldStop(8192);
_str = RemoteObject.createImmutable("");Debug.locals.put("str", _str);
 BA.debugLineNum = 143;BA.debugLine="str=BytesToString(Buffer, 0, Buffer.Length, \"UTF8";
Debug.ShouldStop(16384);
_str = starter.mostCurrent.__c.runMethod(true,"BytesToString",(Object)(_buffer),(Object)(BA.numberCast(int.class, 0)),(Object)(_buffer.getField(true,"length")),(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("str", _str);
 BA.debugLineNum = 145;BA.debugLine="Dim aa As Int";
Debug.ShouldStop(65536);
_aa = RemoteObject.createImmutable(0);Debug.locals.put("aa", _aa);
 BA.debugLineNum = 148;BA.debugLine="For aa = 0 To str.Length-1";
Debug.ShouldStop(524288);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {_str.runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_aa = BA.numberCast(int.class, 0) ;
for (;(step4 > 0 && _aa.<Integer>get().intValue() <= limit4) || (step4 < 0 && _aa.<Integer>get().intValue() >= limit4) ;_aa = RemoteObject.createImmutable((int)(0 + _aa.<Integer>get().intValue() + step4))  ) {
Debug.locals.put("aa", _aa);
 BA.debugLineNum = 149;BA.debugLine="Dim z As String";
Debug.ShouldStop(1048576);
_z = RemoteObject.createImmutable("");Debug.locals.put("z", _z);
 BA.debugLineNum = 150;BA.debugLine="z=str.SubString2(aa,aa+1)";
Debug.ShouldStop(2097152);
_z = _str.runMethod(true,"substring",(Object)(_aa),(Object)(RemoteObject.solve(new RemoteObject[] {_aa,RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("z", _z);
 BA.debugLineNum = 152;BA.debugLine="If myparser.available(z)=True Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",starter._myparser.runClassMethod (b4a.OPTUMizerPatient.clsparser.class, "_available" /*RemoteObject*/ ,(Object)(_z)),starter.mostCurrent.__c.getField(true,"True"))) { 
 };
 }
}Debug.locals.put("aa", _aa);
;
 BA.debugLineNum = 159;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _conns(RemoteObject _res,RemoteObject _paireddevices,RemoteObject _l) throws Exception{
try {
		Debug.PushSubsStack("conns (starter) ","starter",1,starter.processBA,starter.mostCurrent,112);
if (RapidSub.canDelegate("conns")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","conns", _res, _paireddevices, _l);}
Debug.locals.put("res", _res);
Debug.locals.put("PairedDevices", _paireddevices);
Debug.locals.put("L", _l);
 BA.debugLineNum = 112;BA.debugLine="Sub conns(res As Int, PairedDevices As Map, L As L";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="Serial1.Connect3(PairedDevices.Get(L.Get(res)),1)";
Debug.ShouldStop(65536);
starter._serial1.runVoidMethod ("Connect3",starter.processBA,(Object)(BA.ObjectToString(_paireddevices.runMethod(false,"Get",(Object)(_l.runMethod(false,"Get",(Object)(_res)))))),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 114;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _gps_locationchanged(RemoteObject _location1) throws Exception{
try {
		Debug.PushSubsStack("GPS_LocationChanged (starter) ","starter",1,starter.processBA,starter.mostCurrent,239);
if (RapidSub.canDelegate("gps_locationchanged")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","gps_locationchanged", _location1);}
RemoteObject _lat = RemoteObject.createImmutable(0f);
RemoteObject _lon = RemoteObject.createImmutable(0f);
RemoteObject _speed = RemoteObject.createImmutable("");
Debug.locals.put("Location1", _location1);
 BA.debugLineNum = 239;BA.debugLine="Sub GPS_LocationChanged (Location1 As Location)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 240;BA.debugLine="Dim lat As Float= NumberFormat(Location1.Latitude";
Debug.ShouldStop(32768);
_lat = BA.numberCast(float.class, starter.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_location1.runMethod(true,"getLatitude")),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 6))));Debug.locals.put("lat", _lat);Debug.locals.put("lat", _lat);
 BA.debugLineNum = 241;BA.debugLine="Dim lon As Float= NumberFormat(Location1.Longitud";
Debug.ShouldStop(65536);
_lon = BA.numberCast(float.class, starter.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_location1.runMethod(true,"getLongitude")),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 6))));Debug.locals.put("lon", _lon);Debug.locals.put("lon", _lon);
 BA.debugLineNum = 242;BA.debugLine="Dim speed As String = \"Speed = \" & Location1.Spee";
Debug.ShouldStop(131072);
_speed = RemoteObject.concat(RemoteObject.createImmutable("Speed = "),_location1.runMethod(true,"getSpeed"));Debug.locals.put("speed", _speed);Debug.locals.put("speed", _speed);
 BA.debugLineNum = 243;BA.debugLine="If wsh.connected=True Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",starter._wsh.getField(true,"_connected" /*RemoteObject*/ ),starter.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 244;BA.debugLine="wsh.SendClient(\"WTAGPS\" & lat & \",\" & lon & \",\"";
Debug.ShouldStop(524288);
starter._wsh.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_sendclient" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable("WTAGPS"),_lat,RemoteObject.createImmutable(","),_lon,RemoteObject.createImmutable(","),_speed,starter.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 13))))));
 };
 BA.debugLineNum = 251;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mnuconnect_click() throws Exception{
try {
		Debug.PushSubsStack("mnuConnect_Click (starter) ","starter",1,starter.processBA,starter.mostCurrent,174);
if (RapidSub.canDelegate("mnuconnect_click")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","mnuconnect_click");}
RemoteObject _paireddevices = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _res = RemoteObject.createImmutable(0);
 BA.debugLineNum = 174;BA.debugLine="Sub mnuConnect_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 175;BA.debugLine="Dim PairedDevices As Map";
Debug.ShouldStop(16384);
_paireddevices = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("PairedDevices", _paireddevices);
 BA.debugLineNum = 176;BA.debugLine="If connected_BT=False Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",starter._connected_bt,starter.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 177;BA.debugLine="PairedDevices = Serial1.GetPairedDevices";
Debug.ShouldStop(65536);
_paireddevices = starter._serial1.runMethod(false,"GetPairedDevices");Debug.locals.put("PairedDevices", _paireddevices);
 BA.debugLineNum = 178;BA.debugLine="Dim L As List";
Debug.ShouldStop(131072);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("L", _l);
 BA.debugLineNum = 179;BA.debugLine="L.Initialize";
Debug.ShouldStop(262144);
_l.runVoidMethod ("Initialize");
 BA.debugLineNum = 180;BA.debugLine="For i = 0 To PairedDevices.Size - 1";
Debug.ShouldStop(524288);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {_paireddevices.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 181;BA.debugLine="L.Add(PairedDevices.GetKeyAt(i)) 'add the frien";
Debug.ShouldStop(1048576);
_l.runVoidMethod ("Add",(Object)(_paireddevices.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 183;BA.debugLine="Dim res As Int";
Debug.ShouldStop(4194304);
_res = RemoteObject.createImmutable(0);Debug.locals.put("res", _res);
 BA.debugLineNum = 185;BA.debugLine="res=\"\"'CallSub2(bluetooth,\"Getlist\",L)";
Debug.ShouldStop(16777216);
_res = BA.numberCast(int.class, "");Debug.locals.put("res", _res);
 BA.debugLineNum = 187;BA.debugLine="If 1 Then 'res <> DialogResponse.CANCEL Then";
Debug.ShouldStop(67108864);
if (BA.ObjectToBoolean(1).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 188;BA.debugLine="PairedDevices.Get(l.Get(res))";
Debug.ShouldStop(134217728);
_paireddevices.runVoidMethod ("Get",(Object)(_l.runMethod(false,"Get",(Object)(_res))));
 BA.debugLineNum = 194;BA.debugLine="Serial1.Connect(PairedDevices.Get(\"HC-05\")) 'co";
Debug.ShouldStop(2);
starter._serial1.runVoidMethod ("Connect",starter.processBA,(Object)(BA.ObjectToString(_paireddevices.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("HC-05")))))));
 };
 };
 BA.debugLineNum = 197;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mnudisconnect_click() throws Exception{
try {
		Debug.PushSubsStack("mnuDisconnect_Click (starter) ","starter",1,starter.processBA,starter.mostCurrent,104);
if (RapidSub.canDelegate("mnudisconnect_click")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","mnudisconnect_click");}
 BA.debugLineNum = 104;BA.debugLine="Sub mnuDisconnect_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 105;BA.debugLine="If connected_BT=True Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",starter._connected_bt,starter.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 106;BA.debugLine="astream.Close";
Debug.ShouldStop(512);
starter._astream.runVoidMethod ("Close");
 BA.debugLineNum = 107;BA.debugLine="timer1.Enabled=False";
Debug.ShouldStop(1024);
starter._timer1.runMethod(true,"setEnabled",starter.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 108;BA.debugLine="Serial1.Disconnect";
Debug.ShouldStop(2048);
starter._serial1.runVoidMethod ("Disconnect");
 BA.debugLineNum = 109;BA.debugLine="connected_BT=False";
Debug.ShouldStop(4096);
starter._connected_bt = starter.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 111;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _msec(RemoteObject _xa) throws Exception{
try {
		Debug.PushSubsStack("msec (starter) ","starter",1,starter.processBA,starter.mostCurrent,217);
if (RapidSub.canDelegate("msec")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","msec", _xa);}
Debug.locals.put("xa", _xa);
 BA.debugLineNum = 217;BA.debugLine="Sub msec(xa As Int)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 218;BA.debugLine="msec_ = xa";
Debug.ShouldStop(33554432);
starter._msec_ = _xa;
 BA.debugLineNum = 219;BA.debugLine="Do While(msec_<>0)";
Debug.ShouldStop(67108864);
while ((RemoteObject.solveBoolean("!",starter._msec_,BA.numberCast(double.class, 0)))) {
 BA.debugLineNum = 220;BA.debugLine="DoEvents";
Debug.ShouldStop(134217728);
starter.mostCurrent.__c.runVoidMethodAndSync ("DoEvents");
 }
;
 BA.debugLineNum = 222;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _println(RemoteObject _str) throws Exception{
try {
		Debug.PushSubsStack("Println (starter) ","starter",1,starter.processBA,starter.mostCurrent,78);
if (RapidSub.canDelegate("println")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","println", _str);}
RemoteObject _x = RemoteObject.createImmutable("");
Debug.locals.put("str", _str);
 BA.debugLineNum = 78;BA.debugLine="public Sub Println(str As String)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="Dim x As String";
Debug.ShouldStop(16384);
_x = RemoteObject.createImmutable("");Debug.locals.put("x", _x);
 BA.debugLineNum = 80;BA.debugLine="str=str&Chr(13)";
Debug.ShouldStop(32768);
_str = RemoteObject.concat(_str,starter.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 13))));Debug.locals.put("str", _str);
 BA.debugLineNum = 81;BA.debugLine="x=str.Length";
Debug.ShouldStop(65536);
_x = BA.NumberToString(_str.runMethod(true,"length"));Debug.locals.put("x", _x);
 BA.debugLineNum = 82;BA.debugLine="If connected_BT=True Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",starter._connected_bt,starter.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 83;BA.debugLine="astream.Write(str.GetBytes(\"UTF8\"))";
Debug.ShouldStop(262144);
starter._astream.runVoidMethod ("Write",(Object)(_str.runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")))));
 };
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 13;BA.debugLine="Dim sms_rx As SmsInterceptor";
starter._sms_rx = RemoteObject.createNew ("anywheresoftware.b4a.phone.PhoneEvents.SMSInterceptor");
 //BA.debugLineNum = 14;BA.debugLine="Dim sms As PhoneSms";
starter._sms = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.PhoneSms");
 //BA.debugLineNum = 17;BA.debugLine="Dim timer1 As Timer";
starter._timer1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 18;BA.debugLine="Private astream As AsyncStreams";
starter._astream = RemoteObject.createNew ("anywheresoftware.b4a.randomaccessfile.AsyncStreams");
 //BA.debugLineNum = 19;BA.debugLine="Dim connected_BT As Boolean";
starter._connected_bt = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 20;BA.debugLine="Dim Serial1 As Serial";
starter._serial1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.Serial");
 //BA.debugLineNum = 21;BA.debugLine="Dim msec_ As Int'in 100 ms";
starter._msec_ = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 22;BA.debugLine="Dim customview As List";
starter._customview = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 23;BA.debugLine="Dim bluetoothview1 As Object";
starter._bluetoothview1 = RemoteObject.createNew ("Object");
 //BA.debugLineNum = 24;BA.debugLine="Dim frmcontrols1 As Object";
starter._frmcontrols1 = RemoteObject.createNew ("Object");
 //BA.debugLineNum = 25;BA.debugLine="Dim wsh As WTAServer";
starter._wsh = RemoteObject.createNew ("b4a.OPTUMizerPatient.wtaserver");
 //BA.debugLineNum = 26;BA.debugLine="Dim myparser As clsParser";
starter._myparser = RemoteObject.createNew ("b4a.OPTUMizerPatient.clsparser");
 //BA.debugLineNum = 27;BA.debugLine="Dim parse1 As clsParser";
starter._parse1 = RemoteObject.createNew ("b4a.OPTUMizerPatient.clsparser");
 //BA.debugLineNum = 28;BA.debugLine="Dim volt As clsParser";
starter._volt = RemoteObject.createNew ("b4a.OPTUMizerPatient.clsparser");
 //BA.debugLineNum = 29;BA.debugLine="Dim amp As clsParser";
starter._amp = RemoteObject.createNew ("b4a.OPTUMizerPatient.clsparser");
 //BA.debugLineNum = 30;BA.debugLine="Dim powerWatt As clsParser";
starter._powerwatt = RemoteObject.createNew ("b4a.OPTUMizerPatient.clsparser");
 //BA.debugLineNum = 31;BA.debugLine="Dim energy As clsParser";
starter._energy = RemoteObject.createNew ("b4a.OPTUMizerPatient.clsparser");
 //BA.debugLineNum = 32;BA.debugLine="Dim voltx As String=\"0\"";
starter._voltx = BA.ObjectToString("0");
 //BA.debugLineNum = 33;BA.debugLine="Dim ampx As String=\"0\"";
starter._ampx = BA.ObjectToString("0");
 //BA.debugLineNum = 34;BA.debugLine="Dim powerWattx As String=\"0\"";
starter._powerwattx = BA.ObjectToString("0");
 //BA.debugLineNum = 35;BA.debugLine="Dim energyx As String=\"0\"";
starter._energyx = BA.ObjectToString("0");
 //BA.debugLineNum = 36;BA.debugLine="Dim rp As RuntimePermissions";
starter._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 //BA.debugLineNum = 40;BA.debugLine="Dim frmmain1 As Object";
starter._frmmain1 = RemoteObject.createNew ("Object");
 //BA.debugLineNum = 41;BA.debugLine="Dim rp As RuntimePermissions";
starter._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 //BA.debugLineNum = 42;BA.debugLine="Dim RFID As clsParser";
starter._rfid = RemoteObject.createNew ("b4a.OPTUMizerPatient.clsparser");
 //BA.debugLineNum = 43;BA.debugLine="Dim GOTOMAP As clsParser";
starter._gotomap = RemoteObject.createNew ("b4a.OPTUMizerPatient.clsparser");
 //BA.debugLineNum = 44;BA.debugLine="Dim LOCATION As clsParser";
starter._location = RemoteObject.createNew ("b4a.OPTUMizerPatient.clsparser");
 //BA.debugLineNum = 45;BA.debugLine="Dim NOTIFENGINEON As clsParser";
starter._notifengineon = RemoteObject.createNew ("b4a.OPTUMizerPatient.clsparser");
 //BA.debugLineNum = 46;BA.debugLine="Dim NOTIFENGINEOFF As clsParser";
starter._notifengineoff = RemoteObject.createNew ("b4a.OPTUMizerPatient.clsparser");
 //BA.debugLineNum = 47;BA.debugLine="Dim NEXTFORM As clsParser";
starter._nextform = RemoteObject.createNew ("b4a.OPTUMizerPatient.clsparser");
 //BA.debugLineNum = 48;BA.debugLine="Dim SELECTSQL As clsParser";
starter._selectsql = RemoteObject.createNew ("b4a.OPTUMizerPatient.clsparser");
 //BA.debugLineNum = 49;BA.debugLine="Dim HASDISINFECT As clsParser";
starter._hasdisinfect = RemoteObject.createNew ("b4a.OPTUMizerPatient.clsparser");
 //BA.debugLineNum = 50;BA.debugLine="Dim HASDELIVERED As clsParser";
starter._hasdelivered = RemoteObject.createNew ("b4a.OPTUMizerPatient.clsparser");
 //BA.debugLineNum = 52;BA.debugLine="Dim uuid As String";
starter._uuid = RemoteObject.createImmutable("");
 //BA.debugLineNum = 53;BA.debugLine="Dim FilePath As String";
starter._filepath = RemoteObject.createImmutable("");
 //BA.debugLineNum = 54;BA.debugLine="Dim statequerry As String";
starter._statequerry = RemoteObject.createImmutable("");
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _sendwsh(RemoteObject _strs) throws Exception{
try {
		Debug.PushSubsStack("sendwsh (starter) ","starter",1,starter.processBA,starter.mostCurrent,86);
if (RapidSub.canDelegate("sendwsh")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","sendwsh", _strs);}
Debug.locals.put("strs", _strs);
 BA.debugLineNum = 86;BA.debugLine="Sub sendwsh(strs As String)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 87;BA.debugLine="wsh.SendClient(strs & \",\" &uuid & \"#\")";
Debug.ShouldStop(4194304);
starter._wsh.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_sendclient" /*RemoteObject*/ ,(Object)(RemoteObject.concat(_strs,RemoteObject.createImmutable(","),starter._uuid,RemoteObject.createImmutable("#"))));
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _serial1_connected(RemoteObject _success) throws Exception{
try {
		Debug.PushSubsStack("Serial1_Connected (starter) ","starter",1,starter.processBA,starter.mostCurrent,116);
if (RapidSub.canDelegate("serial1_connected")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","serial1_connected", _success);}
Debug.locals.put("Success", _success);
 BA.debugLineNum = 116;BA.debugLine="Sub Serial1_Connected (Success As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 117;BA.debugLine="If Success Then";
Debug.ShouldStop(1048576);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 118;BA.debugLine="ToastMessageShow(\"Connected successfully\", False";
Debug.ShouldStop(2097152);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Connected successfully")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 123;BA.debugLine="astream.Initialize(Serial1.InputStream, Serial1.";
Debug.ShouldStop(67108864);
starter._astream.runVoidMethod ("Initialize",starter.processBA,(Object)(starter._serial1.runMethod(false,"getInputStream")),(Object)(starter._serial1.runMethod(false,"getOutputStream")),(Object)(RemoteObject.createImmutable("astream")));
 BA.debugLineNum = 124;BA.debugLine="connected_BT = True";
Debug.ShouldStop(134217728);
starter._connected_bt = starter.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 130;BA.debugLine="connected_BT = False";
Debug.ShouldStop(2);
starter._connected_bt = starter.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 131;BA.debugLine="ToastMessageShow(\"Check BT connection\", False)";
Debug.ShouldStop(4);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Check BT connection")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 139;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (starter) ","starter",1,starter.processBA,starter.mostCurrent,57);
if (RapidSub.canDelegate("service_create")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","service_create");}
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
 BA.debugLineNum = 57;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 60;BA.debugLine="Dim r As Reflector";
Debug.ShouldStop(134217728);
_r = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("r", _r);
 BA.debugLineNum = 61;BA.debugLine="r.Target=r.RunStaticMethod(\"java.util.UUID\", \"ran";
Debug.ShouldStop(268435456);
_r.setField ("Target",_r.runMethod(false,"RunStaticMethod",(Object)(BA.ObjectToString("java.util.UUID")),(Object)(BA.ObjectToString("randomUUID")),(Object)((starter.mostCurrent.__c.getField(false,"Null"))),(Object)((starter.mostCurrent.__c.getField(false,"Null")))));
 BA.debugLineNum = 62;BA.debugLine="uuid =r.RunMethod(\"toString\")";
Debug.ShouldStop(536870912);
starter._uuid = BA.ObjectToString(_r.runMethod(false,"RunMethod",(Object)(RemoteObject.createImmutable("toString"))));
 BA.debugLineNum = 63;BA.debugLine="Serial1.Initialize(\"Serial1\")";
Debug.ShouldStop(1073741824);
starter._serial1.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("Serial1")));
 BA.debugLineNum = 66;BA.debugLine="wsh.Initialize(Me,\"wsh\",uuid,\"KEYLESSSERVER\",\"db_";
Debug.ShouldStop(2);
starter._wsh.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_initialize" /*RemoteObject*/ ,starter.processBA,(Object)(starter.getObject()),(Object)(BA.ObjectToString("wsh")),(Object)(starter._uuid),(Object)(BA.ObjectToString("KEYLESSSERVER")),(Object)(RemoteObject.createImmutable("db_testX")));
 BA.debugLineNum = 67;BA.debugLine="wsh.InitWTAServer()";
Debug.ShouldStop(4);
starter._wsh.runClassMethod (b4a.OPTUMizerPatient.wtaserver.class, "_initwtaserver" /*RemoteObject*/ );
 BA.debugLineNum = 68;BA.debugLine="GOTOMAP.Initialize(\"GOTOMAP\",\"#\",1)";
Debug.ShouldStop(8);
starter._gotomap.runClassMethod (b4a.OPTUMizerPatient.clsparser.class, "_initialize" /*RemoteObject*/ ,starter.processBA,(Object)(BA.ObjectToString("GOTOMAP")),(Object)(BA.ObjectToString("#")),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 69;BA.debugLine="RFID.Initialize(\"RFID\",\"#\",1)";
Debug.ShouldStop(16);
starter._rfid.runClassMethod (b4a.OPTUMizerPatient.clsparser.class, "_initialize" /*RemoteObject*/ ,starter.processBA,(Object)(BA.ObjectToString("RFID")),(Object)(BA.ObjectToString("#")),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 70;BA.debugLine="LOCATION.Initialize(\"LOCATION\",\"#\",1)";
Debug.ShouldStop(32);
starter._location.runClassMethod (b4a.OPTUMizerPatient.clsparser.class, "_initialize" /*RemoteObject*/ ,starter.processBA,(Object)(BA.ObjectToString("LOCATION")),(Object)(BA.ObjectToString("#")),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 71;BA.debugLine="NEXTFORM.Initialize(\"NEXTFORM\",\"#\",1)";
Debug.ShouldStop(64);
starter._nextform.runClassMethod (b4a.OPTUMizerPatient.clsparser.class, "_initialize" /*RemoteObject*/ ,starter.processBA,(Object)(BA.ObjectToString("NEXTFORM")),(Object)(BA.ObjectToString("#")),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 72;BA.debugLine="HASDISINFECT.Initialize(\"HASDISINFECT\",\"#\",1)";
Debug.ShouldStop(128);
starter._hasdisinfect.runClassMethod (b4a.OPTUMizerPatient.clsparser.class, "_initialize" /*RemoteObject*/ ,starter.processBA,(Object)(BA.ObjectToString("HASDISINFECT")),(Object)(BA.ObjectToString("#")),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 73;BA.debugLine="HASDELIVERED.Initialize(\"HASDELIVERED\",\"#\",1)";
Debug.ShouldStop(256);
starter._hasdelivered.runClassMethod (b4a.OPTUMizerPatient.clsparser.class, "_initialize" /*RemoteObject*/ ,starter.processBA,(Object)(BA.ObjectToString("HASDELIVERED")),(Object)(BA.ObjectToString("#")),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 74;BA.debugLine="SELECTSQL.Initialize(\"SELECTSQL\",\"#\",1)";
Debug.ShouldStop(512);
starter._selectsql.runClassMethod (b4a.OPTUMizerPatient.clsparser.class, "_initialize" /*RemoteObject*/ ,starter.processBA,(Object)(BA.ObjectToString("SELECTSQL")),(Object)(BA.ObjectToString("#")),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 75;BA.debugLine="NOTIFENGINEON.Initialize(\"NOTIFENGINEON\",\"#\",1)";
Debug.ShouldStop(1024);
starter._notifengineon.runClassMethod (b4a.OPTUMizerPatient.clsparser.class, "_initialize" /*RemoteObject*/ ,starter.processBA,(Object)(BA.ObjectToString("NOTIFENGINEON")),(Object)(BA.ObjectToString("#")),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 76;BA.debugLine="NOTIFENGINEOFF.Initialize(\"NOTIFENGINEOFF\",\"#\",1)";
Debug.ShouldStop(2048);
starter._notifengineoff.runClassMethod (b4a.OPTUMizerPatient.clsparser.class, "_initialize" /*RemoteObject*/ ,starter.processBA,(Object)(BA.ObjectToString("NOTIFENGINEOFF")),(Object)(BA.ObjectToString("#")),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (starter) ","starter",1,starter.processBA,starter.mostCurrent,235);
if (RapidSub.canDelegate("service_destroy")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","service_destroy");}
 BA.debugLineNum = 235;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(1024);
 BA.debugLineNum = 236;BA.debugLine="ToastMessageShow(\"exit\",True)";
Debug.ShouldStop(2048);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("exit")),(Object)(starter.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 237;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (starter) ","starter",1,starter.processBA,starter.mostCurrent,223);
if (RapidSub.canDelegate("service_start")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","service_start", _startingintent);}
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 223;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 224;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_taskremoved() throws Exception{
try {
		Debug.PushSubsStack("Service_TaskRemoved (starter) ","starter",1,starter.processBA,starter.mostCurrent,226);
if (RapidSub.canDelegate("service_taskremoved")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","service_taskremoved");}
 BA.debugLineNum = 226;BA.debugLine="Sub Service_TaskRemoved";
Debug.ShouldStop(2);
 BA.debugLineNum = 228;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sms_rx_messagereceived(RemoteObject _from,RemoteObject _body) throws Exception{
try {
		Debug.PushSubsStack("sms_rx_MessageReceived (starter) ","starter",1,starter.processBA,starter.mostCurrent,160);
if (RapidSub.canDelegate("sms_rx_messagereceived")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","sms_rx_messagereceived", _from, _body);}
RemoteObject _strsend = RemoteObject.createImmutable("");
RemoteObject _aa = RemoteObject.createImmutable(0);
RemoteObject _z = RemoteObject.createImmutable("");
Debug.locals.put("From", _from);
Debug.locals.put("Body", _body);
 BA.debugLineNum = 160;BA.debugLine="Sub sms_rx_MessageReceived(From As String, Body As";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 161;BA.debugLine="Dim strsend As String";
Debug.ShouldStop(1);
_strsend = RemoteObject.createImmutable("");Debug.locals.put("strsend", _strsend);
 BA.debugLineNum = 162;BA.debugLine="If Body=\"Hello\" Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_body,BA.ObjectToString("Hello"))) { 
 BA.debugLineNum = 163;BA.debugLine="sms.Send(From,\"what the hell\")";
Debug.ShouldStop(4);
starter._sms.runVoidMethod ("Send",(Object)(_from),(Object)(RemoteObject.createImmutable("what the hell")));
 };
 BA.debugLineNum = 165;BA.debugLine="Dim aa As Int";
Debug.ShouldStop(16);
_aa = RemoteObject.createImmutable(0);Debug.locals.put("aa", _aa);
 BA.debugLineNum = 166;BA.debugLine="For aa = 0 To Body.Length-1";
Debug.ShouldStop(32);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {_body.runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_aa = BA.numberCast(int.class, 0) ;
for (;(step6 > 0 && _aa.<Integer>get().intValue() <= limit6) || (step6 < 0 && _aa.<Integer>get().intValue() >= limit6) ;_aa = RemoteObject.createImmutable((int)(0 + _aa.<Integer>get().intValue() + step6))  ) {
Debug.locals.put("aa", _aa);
 BA.debugLineNum = 167;BA.debugLine="Dim z As String";
Debug.ShouldStop(64);
_z = RemoteObject.createImmutable("");Debug.locals.put("z", _z);
 BA.debugLineNum = 168;BA.debugLine="z=Body.SubString2(aa,aa+1)";
Debug.ShouldStop(128);
_z = _body.runMethod(true,"substring",(Object)(_aa),(Object)(RemoteObject.solve(new RemoteObject[] {_aa,RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("z", _z);
 BA.debugLineNum = 169;BA.debugLine="If myparser.available(z)=True Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",starter._myparser.runClassMethod (b4a.OPTUMizerPatient.clsparser.class, "_available" /*RemoteObject*/ ,(Object)(_z)),starter.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 170;BA.debugLine="ToastMessageShow(myparser.data,False)";
Debug.ShouldStop(512);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(starter._myparser.getField(true,"_data" /*RemoteObject*/ ))),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 };
 }
}Debug.locals.put("aa", _aa);
;
 BA.debugLineNum = 173;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _timer1_tick() throws Exception{
try {
		Debug.PushSubsStack("Timer1_Tick (starter) ","starter",1,starter.processBA,starter.mostCurrent,198);
if (RapidSub.canDelegate("timer1_tick")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","timer1_tick");}
RemoteObject _strs = RemoteObject.createImmutable("");
 BA.debugLineNum = 198;BA.debugLine="Sub Timer1_Tick";
Debug.ShouldStop(32);
 BA.debugLineNum = 199;BA.debugLine="ToastMessageShow(\"saving logs to power_log.csv\",T";
Debug.ShouldStop(64);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("saving logs to power_log.csv")),(Object)(starter.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 201;BA.debugLine="If File.Exists(File.DirRootExternal, \"power_log.c";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",starter.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal")),(Object)(RemoteObject.createImmutable("power_log.csv"))),starter.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 202;BA.debugLine="Dim strs As String=vb6.GetFileStr(\"power_log.csv";
Debug.ShouldStop(512);
_strs = starter.mostCurrent._vb6.runMethod(true,"_getfilestr" /*RemoteObject*/ ,starter.processBA,(Object)(RemoteObject.createImmutable("power_log.csv")));Debug.locals.put("strs", _strs);Debug.locals.put("strs", _strs);
 BA.debugLineNum = 203;BA.debugLine="strs=strs&voltx&\",\"&ampx&\",\"&powerWattx&\",\"&ener";
Debug.ShouldStop(1024);
_strs = RemoteObject.concat(_strs,starter._voltx,RemoteObject.createImmutable(","),starter._ampx,RemoteObject.createImmutable(","),starter._powerwattx,RemoteObject.createImmutable(","),starter._energyx,RemoteObject.createImmutable(","),starter.mostCurrent._vb6.runMethod(true,"_now" /*RemoteObject*/ ,starter.processBA),starter.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 13))));Debug.locals.put("strs", _strs);
 BA.debugLineNum = 204;BA.debugLine="vb6.SaveFileStr(\"power_log.csv\",strs)";
Debug.ShouldStop(2048);
starter.mostCurrent._vb6.runVoidMethod ("_savefilestr" /*RemoteObject*/ ,starter.processBA,(Object)(BA.ObjectToString("power_log.csv")),(Object)(_strs));
 }else {
 BA.debugLineNum = 206;BA.debugLine="vb6.SaveFileStr(\"power_log.csv\",\"Volt,Current,Po";
Debug.ShouldStop(8192);
starter.mostCurrent._vb6.runVoidMethod ("_savefilestr" /*RemoteObject*/ ,starter.processBA,(Object)(BA.ObjectToString("power_log.csv")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("Volt,Current,Power,Energy,Time"),starter.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 13))),starter._voltx,RemoteObject.createImmutable(","),starter._ampx,RemoteObject.createImmutable(","),starter._powerwattx,RemoteObject.createImmutable(","),starter._energyx,RemoteObject.createImmutable(","),starter.mostCurrent._vb6.runMethod(true,"_now" /*RemoteObject*/ ,starter.processBA),starter.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 13))))));
 };
 BA.debugLineNum = 208;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _wsh_newdata(RemoteObject _data) throws Exception{
try {
		Debug.PushSubsStack("wsh_NewData (starter) ","starter",1,starter.processBA,starter.mostCurrent,89);
if (RapidSub.canDelegate("wsh_newdata")) { return b4a.OPTUMizerPatient.starter.remoteMe.runUserSub(false, "starter","wsh_newdata", _data);}
RemoteObject _aa = RemoteObject.createImmutable(0);
RemoteObject _z = RemoteObject.createImmutable("");
Debug.locals.put("data", _data);
 BA.debugLineNum = 89;BA.debugLine="Sub wsh_NewData(data As String)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 91;BA.debugLine="Dim aa As Int";
Debug.ShouldStop(67108864);
_aa = RemoteObject.createImmutable(0);Debug.locals.put("aa", _aa);
 BA.debugLineNum = 92;BA.debugLine="For aa = 0 To data.Length-1";
Debug.ShouldStop(134217728);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {_data.runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_aa = BA.numberCast(int.class, 0) ;
for (;(step2 > 0 && _aa.<Integer>get().intValue() <= limit2) || (step2 < 0 && _aa.<Integer>get().intValue() >= limit2) ;_aa = RemoteObject.createImmutable((int)(0 + _aa.<Integer>get().intValue() + step2))  ) {
Debug.locals.put("aa", _aa);
 BA.debugLineNum = 93;BA.debugLine="Dim z As String";
Debug.ShouldStop(268435456);
_z = RemoteObject.createImmutable("");Debug.locals.put("z", _z);
 BA.debugLineNum = 94;BA.debugLine="z=data.SubString2(aa,aa+1)";
Debug.ShouldStop(536870912);
_z = _data.runMethod(true,"substring",(Object)(_aa),(Object)(RemoteObject.solve(new RemoteObject[] {_aa,RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("z", _z);
 }
}Debug.locals.put("aa", _aa);
;
 BA.debugLineNum = 103;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}