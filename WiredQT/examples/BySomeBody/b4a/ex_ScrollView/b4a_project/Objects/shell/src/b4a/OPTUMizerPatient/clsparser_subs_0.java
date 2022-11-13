package b4a.OPTUMizerPatient;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class clsparser_subs_0 {


public static RemoteObject  _available(RemoteObject __ref,RemoteObject _mscomm_input) throws Exception{
try {
		Debug.PushSubsStack("available (clsparser) ","clsparser",4,__ref.getField(false, "ba"),__ref,36);
if (RapidSub.canDelegate("available")) { return __ref.runUserSub(false, "clsparser","available", __ref, _mscomm_input);}
RemoteObject _c = RemoteObject.createImmutable("");
Debug.locals.put("MSComm_input", _mscomm_input);
 BA.debugLineNum = 36;BA.debugLine="Sub available(MSComm_input As String) As Boolean";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="Dim c As String";
Debug.ShouldStop(16);
_c = RemoteObject.createImmutable("");Debug.locals.put("c", _c);
 BA.debugLineNum = 38;BA.debugLine="str = str & MSComm_input";
Debug.ShouldStop(32);
__ref.setField ("_str" /*RemoteObject*/ ,RemoteObject.concat(__ref.getField(true,"_str" /*RemoteObject*/ ),_mscomm_input));
 BA.debugLineNum = 39;BA.debugLine="Do While (str <> \"\")";
Debug.ShouldStop(64);
while ((RemoteObject.solveBoolean("!",__ref.getField(true,"_str" /*RemoteObject*/ ),RemoteObject.createImmutable("")))) {
 BA.debugLineNum = 40;BA.debugLine="c = vb6.Mid2(str, 1, 1)";
Debug.ShouldStop(128);
_c = clsparser._vb6.runMethod(true,"_mid2" /*RemoteObject*/ ,__ref.runMethod(false,"getActivityBA"),(Object)(__ref.getField(true,"_str" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("c", _c);
 BA.debugLineNum = 41;BA.debugLine="If status Then data = data & c";
Debug.ShouldStop(256);
if (__ref.getField(true,"_status" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
__ref.setField ("_data" /*RemoteObject*/ ,RemoteObject.concat(__ref.getField(true,"_data" /*RemoteObject*/ ),_c));};
 BA.debugLineNum = 43;BA.debugLine="If Pollbyte(c) Then";
Debug.ShouldStop(1024);
if (__ref.runClassMethod (b4a.OPTUMizerPatient.clsparser.class, "_pollbyte" /*RemoteObject*/ ,(Object)(_c)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 44;BA.debugLine="data = \"\"";
Debug.ShouldStop(2048);
__ref.setField ("_data" /*RemoteObject*/ ,BA.ObjectToString(""));
 BA.debugLineNum = 45;BA.debugLine="status = True";
Debug.ShouldStop(4096);
__ref.setField ("_status" /*RemoteObject*/ ,clsparser.__c.getField(true,"True"));
 BA.debugLineNum = 46;BA.debugLine="num_bufterminate_char = 0";
Debug.ShouldStop(8192);
__ref.setField ("_num_bufterminate_char" /*RemoteObject*/ ,BA.numberCast(int.class, 0));
 };
 BA.debugLineNum = 48;BA.debugLine="If (status = True) Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",__ref.getField(true,"_status" /*RemoteObject*/ ),clsparser.__c.getField(true,"True")))) { 
 BA.debugLineNum = 49;BA.debugLine="If (c = terminate_char) Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",_c,__ref.getField(true,"_terminate_char" /*RemoteObject*/ )))) { 
 BA.debugLineNum = 50;BA.debugLine="str = vb6.Mid(str, 2)";
Debug.ShouldStop(131072);
__ref.setField ("_str" /*RemoteObject*/ ,clsparser._vb6.runMethod(true,"_mid" /*RemoteObject*/ ,__ref.runMethod(false,"getActivityBA"),(Object)(__ref.getField(true,"_str" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 51;BA.debugLine="num_bufterminate_char = num_bufter";
Debug.ShouldStop(262144);
__ref.setField ("_num_bufterminate_char" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_num_bufterminate_char" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+",1, 1));
 BA.debugLineNum = 52;BA.debugLine="If (num_bufterminate_char = num_te";
Debug.ShouldStop(524288);
if ((RemoteObject.solveBoolean("=",__ref.getField(true,"_num_bufterminate_char" /*RemoteObject*/ ),BA.numberCast(double.class, __ref.getField(true,"_num_terminate_char" /*RemoteObject*/ ))))) { 
 BA.debugLineNum = 53;BA.debugLine="status = False";
Debug.ShouldStop(1048576);
__ref.setField ("_status" /*RemoteObject*/ ,clsparser.__c.getField(true,"False"));
 BA.debugLineNum = 54;BA.debugLine="data = vb6.Mid2(data, 1, vb6.L";
Debug.ShouldStop(2097152);
__ref.setField ("_data" /*RemoteObject*/ ,clsparser._vb6.runMethod(true,"_mid2" /*RemoteObject*/ ,__ref.runMethod(false,"getActivityBA"),(Object)(__ref.getField(true,"_data" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, clsparser._vb6.runMethod(true,"_len" /*RemoteObject*/ ,__ref.runMethod(false,"getActivityBA"),(Object)(__ref.getField(true,"_data" /*RemoteObject*/ )))),RemoteObject.createImmutable(1)}, "-",1, 0)))));
 BA.debugLineNum = 55;BA.debugLine="Return True";
Debug.ShouldStop(4194304);
if (true) return clsparser.__c.getField(true,"True");
 };
 };
 };
 BA.debugLineNum = 59;BA.debugLine="If vb6.Len(str) > 1 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean(">",BA.numberCast(double.class, clsparser._vb6.runMethod(true,"_len" /*RemoteObject*/ ,__ref.runMethod(false,"getActivityBA"),(Object)(__ref.getField(true,"_str" /*RemoteObject*/ )))),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 60;BA.debugLine="str = vb6.Mid(str, 2)";
Debug.ShouldStop(134217728);
__ref.setField ("_str" /*RemoteObject*/ ,clsparser._vb6.runMethod(true,"_mid" /*RemoteObject*/ ,__ref.runMethod(false,"getActivityBA"),(Object)(__ref.getField(true,"_str" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, 2))));
 }else {
 BA.debugLineNum = 62;BA.debugLine="str = \"\"";
Debug.ShouldStop(536870912);
__ref.setField ("_str" /*RemoteObject*/ ,BA.ObjectToString(""));
 BA.debugLineNum = 63;BA.debugLine="Exit";
Debug.ShouldStop(1073741824);
if (true) break;
 };
 }
;
 BA.debugLineNum = 66;BA.debugLine="Return False";
Debug.ShouldStop(2);
if (true) return clsparser.__c.getField(true,"False");
 BA.debugLineNum = 67;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim str As String";
clsparser._str = RemoteObject.createImmutable("");__ref.setField("_str",clsparser._str);
 //BA.debugLineNum = 4;BA.debugLine="Dim buffer As String";
clsparser._buffer = RemoteObject.createImmutable("");__ref.setField("_buffer",clsparser._buffer);
 //BA.debugLineNum = 5;BA.debugLine="Dim data As String";
clsparser._data = RemoteObject.createImmutable("");__ref.setField("_data",clsparser._data);
 //BA.debugLineNum = 7;BA.debugLine="Dim wait_header As String";
clsparser._wait_header = RemoteObject.createImmutable("");__ref.setField("_wait_header",clsparser._wait_header);
 //BA.debugLineNum = 8;BA.debugLine="Dim terminate_char As String";
clsparser._terminate_char = RemoteObject.createImmutable("");__ref.setField("_terminate_char",clsparser._terminate_char);
 //BA.debugLineNum = 9;BA.debugLine="Dim num_terminate_char As Int";
clsparser._num_terminate_char = RemoteObject.createImmutable(0);__ref.setField("_num_terminate_char",clsparser._num_terminate_char);
 //BA.debugLineNum = 10;BA.debugLine="Dim num_bufterminate_char As Int";
clsparser._num_bufterminate_char = RemoteObject.createImmutable(0);__ref.setField("_num_bufterminate_char",clsparser._num_bufterminate_char);
 //BA.debugLineNum = 11;BA.debugLine="Dim status As Boolean";
clsparser._status = RemoteObject.createImmutable(false);__ref.setField("_status",clsparser._status);
 //BA.debugLineNum = 12;BA.debugLine="Dim currPointer As Int";
clsparser._currpointer = RemoteObject.createImmutable(0);__ref.setField("_currpointer",clsparser._currpointer);
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _databuffer(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Databuffer (clsparser) ","clsparser",4,__ref.getField(false, "ba"),__ref,69);
if (RapidSub.canDelegate("databuffer")) { return __ref.runUserSub(false, "clsparser","databuffer", __ref);}
 BA.debugLineNum = 69;BA.debugLine="Sub Databuffer() As String";
Debug.ShouldStop(16);
 BA.debugLineNum = 70;BA.debugLine="Return data";
Debug.ShouldStop(32);
if (true) return __ref.getField(true,"_data" /*RemoteObject*/ );
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _waitheader,RemoteObject _terminatechar,RemoteObject _numterminate) throws Exception{
try {
		Debug.PushSubsStack("Initialize (clsparser) ","clsparser",4,__ref.getField(false, "ba"),__ref,17);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "clsparser","initialize", __ref, _ba, _waitheader, _terminatechar, _numterminate);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("WaitHeader", _waitheader);
Debug.locals.put("TerminateChar", _terminatechar);
Debug.locals.put("numTerminate", _numterminate);
 BA.debugLineNum = 17;BA.debugLine="Public Sub Initialize(WaitHeader As String, Termin";
Debug.ShouldStop(65536);
 BA.debugLineNum = 18;BA.debugLine="num_terminate_char = numTerminate";
Debug.ShouldStop(131072);
__ref.setField ("_num_terminate_char" /*RemoteObject*/ ,_numterminate);
 BA.debugLineNum = 19;BA.debugLine="wait_header = WaitHeader";
Debug.ShouldStop(262144);
__ref.setField ("_wait_header" /*RemoteObject*/ ,_waitheader);
 BA.debugLineNum = 20;BA.debugLine="terminate_char = TerminateChar";
Debug.ShouldStop(524288);
__ref.setField ("_terminate_char" /*RemoteObject*/ ,_terminatechar);
 BA.debugLineNum = 21;BA.debugLine="currPointer = 1";
Debug.ShouldStop(1048576);
__ref.setField ("_currpointer" /*RemoteObject*/ ,BA.numberCast(int.class, 1));
 BA.debugLineNum = 22;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pollbyte(RemoteObject __ref,RemoteObject _x) throws Exception{
try {
		Debug.PushSubsStack("Pollbyte (clsparser) ","clsparser",4,__ref.getField(false, "ba"),__ref,24);
if (RapidSub.canDelegate("pollbyte")) { return __ref.runUserSub(false, "clsparser","pollbyte", __ref, _x);}
Debug.locals.put("x", _x);
 BA.debugLineNum = 24;BA.debugLine="Sub Pollbyte(x As String) As Boolean";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="If (vb6.Mid2(wait_header, currPointer, 1) = x)";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",clsparser._vb6.runMethod(true,"_mid2" /*RemoteObject*/ ,__ref.runMethod(false,"getActivityBA"),(Object)(__ref.getField(true,"_wait_header" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_currpointer" /*RemoteObject*/ )),(Object)(BA.numberCast(int.class, 1))),_x))) { 
 BA.debugLineNum = 26;BA.debugLine="currPointer = currPointer + 1";
Debug.ShouldStop(33554432);
__ref.setField ("_currpointer" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_currpointer" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+",1, 1));
 }else {
 BA.debugLineNum = 28;BA.debugLine="currPointer = 1";
Debug.ShouldStop(134217728);
__ref.setField ("_currpointer" /*RemoteObject*/ ,BA.numberCast(int.class, 1));
 };
 BA.debugLineNum = 30;BA.debugLine="If ((currPointer - 1) = vb6.Len(wait_header))";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_currpointer" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 1)),BA.numberCast(double.class, clsparser._vb6.runMethod(true,"_len" /*RemoteObject*/ ,__ref.runMethod(false,"getActivityBA"),(Object)(__ref.getField(true,"_wait_header" /*RemoteObject*/ ))))))) { 
 BA.debugLineNum = 31;BA.debugLine="currPointer = 1";
Debug.ShouldStop(1073741824);
__ref.setField ("_currpointer" /*RemoteObject*/ ,BA.numberCast(int.class, 1));
 BA.debugLineNum = 32;BA.debugLine="Return True";
Debug.ShouldStop(-2147483648);
if (true) return clsparser.__c.getField(true,"True");
 };
 BA.debugLineNum = 34;BA.debugLine="Return False";
Debug.ShouldStop(2);
if (true) return clsparser.__c.getField(true,"False");
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}