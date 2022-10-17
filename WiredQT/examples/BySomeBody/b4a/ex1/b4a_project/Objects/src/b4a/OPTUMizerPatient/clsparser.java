package b4a.OPTUMizerPatient;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class clsparser extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.OPTUMizerPatient.clsparser");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.OPTUMizerPatient.clsparser.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public String _str = "";
public String _buffer = "";
public String _data = "";
public String _wait_header = "";
public String _terminate_char = "";
public int _num_terminate_char = 0;
public int _num_bufterminate_char = 0;
public boolean _status = false;
public int _currpointer = 0;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.OPTUMizerPatient.main _main = null;
public b4a.OPTUMizerPatient.starter _starter = null;
public b4a.OPTUMizerPatient.vb6 _vb6 = null;
public boolean  _available(b4a.OPTUMizerPatient.clsparser __ref,String _mscomm_input) throws Exception{
__ref = this;
RDebugUtils.currentModule="clsparser";
if (Debug.shouldDelegate(ba, "available", false))
	 {return ((Boolean) Debug.delegate(ba, "available", new Object[] {_mscomm_input}));}
String _c = "";
RDebugUtils.currentLine=5636096;
 //BA.debugLineNum = 5636096;BA.debugLine="Sub available(MSComm_input As String) As Boolean";
RDebugUtils.currentLine=5636097;
 //BA.debugLineNum = 5636097;BA.debugLine="Dim c As String";
_c = "";
RDebugUtils.currentLine=5636098;
 //BA.debugLineNum = 5636098;BA.debugLine="str = str & MSComm_input";
__ref._str /*String*/  = __ref._str /*String*/ +_mscomm_input;
RDebugUtils.currentLine=5636099;
 //BA.debugLineNum = 5636099;BA.debugLine="Do While (str <> \"\")";
while (((__ref._str /*String*/ ).equals("") == false)) {
RDebugUtils.currentLine=5636100;
 //BA.debugLineNum = 5636100;BA.debugLine="c = vb6.Mid2(str, 1, 1)";
_c = _vb6._mid2 /*String*/ (getActivityBA(),__ref._str /*String*/ ,(int) (1),(int) (1));
RDebugUtils.currentLine=5636101;
 //BA.debugLineNum = 5636101;BA.debugLine="If status Then data = data & c";
if (__ref._status /*boolean*/ ) { 
__ref._data /*String*/  = __ref._data /*String*/ +_c;};
RDebugUtils.currentLine=5636103;
 //BA.debugLineNum = 5636103;BA.debugLine="If Pollbyte(c) Then";
if (__ref._pollbyte /*boolean*/ (null,_c)) { 
RDebugUtils.currentLine=5636104;
 //BA.debugLineNum = 5636104;BA.debugLine="data = \"\"";
__ref._data /*String*/  = "";
RDebugUtils.currentLine=5636105;
 //BA.debugLineNum = 5636105;BA.debugLine="status = True";
__ref._status /*boolean*/  = __c.True;
RDebugUtils.currentLine=5636106;
 //BA.debugLineNum = 5636106;BA.debugLine="num_bufterminate_char = 0";
__ref._num_bufterminate_char /*int*/  = (int) (0);
 };
RDebugUtils.currentLine=5636108;
 //BA.debugLineNum = 5636108;BA.debugLine="If (status = True) Then";
if ((__ref._status /*boolean*/ ==__c.True)) { 
RDebugUtils.currentLine=5636109;
 //BA.debugLineNum = 5636109;BA.debugLine="If (c = terminate_char) Then";
if (((_c).equals(__ref._terminate_char /*String*/ ))) { 
RDebugUtils.currentLine=5636110;
 //BA.debugLineNum = 5636110;BA.debugLine="str = vb6.Mid(str, 2)";
__ref._str /*String*/  = _vb6._mid /*String*/ (getActivityBA(),__ref._str /*String*/ ,(int) (2));
RDebugUtils.currentLine=5636111;
 //BA.debugLineNum = 5636111;BA.debugLine="num_bufterminate_char = num_bufter";
__ref._num_bufterminate_char /*int*/  = (int) (__ref._num_bufterminate_char /*int*/ +1);
RDebugUtils.currentLine=5636112;
 //BA.debugLineNum = 5636112;BA.debugLine="If (num_bufterminate_char = num_te";
if ((__ref._num_bufterminate_char /*int*/ ==__ref._num_terminate_char /*int*/ )) { 
RDebugUtils.currentLine=5636113;
 //BA.debugLineNum = 5636113;BA.debugLine="status = False";
__ref._status /*boolean*/  = __c.False;
RDebugUtils.currentLine=5636114;
 //BA.debugLineNum = 5636114;BA.debugLine="data = vb6.Mid2(data, 1, vb6.L";
__ref._data /*String*/  = _vb6._mid2 /*String*/ (getActivityBA(),__ref._data /*String*/ ,(int) (1),(int) ((double)(Double.parseDouble(_vb6._len /*String*/ (getActivityBA(),__ref._data /*String*/ )))-1));
RDebugUtils.currentLine=5636115;
 //BA.debugLineNum = 5636115;BA.debugLine="Return True";
if (true) return __c.True;
 };
 };
 };
RDebugUtils.currentLine=5636119;
 //BA.debugLineNum = 5636119;BA.debugLine="If vb6.Len(str) > 1 Then";
if ((double)(Double.parseDouble(_vb6._len /*String*/ (getActivityBA(),__ref._str /*String*/ )))>1) { 
RDebugUtils.currentLine=5636120;
 //BA.debugLineNum = 5636120;BA.debugLine="str = vb6.Mid(str, 2)";
__ref._str /*String*/  = _vb6._mid /*String*/ (getActivityBA(),__ref._str /*String*/ ,(int) (2));
 }else {
RDebugUtils.currentLine=5636122;
 //BA.debugLineNum = 5636122;BA.debugLine="str = \"\"";
__ref._str /*String*/  = "";
RDebugUtils.currentLine=5636123;
 //BA.debugLineNum = 5636123;BA.debugLine="Exit";
if (true) break;
 };
 }
;
RDebugUtils.currentLine=5636126;
 //BA.debugLineNum = 5636126;BA.debugLine="Return False";
if (true) return __c.False;
RDebugUtils.currentLine=5636127;
 //BA.debugLineNum = 5636127;BA.debugLine="End Sub";
return false;
}
public String  _initialize(b4a.OPTUMizerPatient.clsparser __ref,anywheresoftware.b4a.BA _ba,String _waitheader,String _terminatechar,int _numterminate) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="clsparser";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_waitheader,_terminatechar,_numterminate}));}
RDebugUtils.currentLine=5505024;
 //BA.debugLineNum = 5505024;BA.debugLine="Public Sub Initialize(WaitHeader As String, Termin";
RDebugUtils.currentLine=5505025;
 //BA.debugLineNum = 5505025;BA.debugLine="num_terminate_char = numTerminate";
__ref._num_terminate_char /*int*/  = _numterminate;
RDebugUtils.currentLine=5505026;
 //BA.debugLineNum = 5505026;BA.debugLine="wait_header = WaitHeader";
__ref._wait_header /*String*/  = _waitheader;
RDebugUtils.currentLine=5505027;
 //BA.debugLineNum = 5505027;BA.debugLine="terminate_char = TerminateChar";
__ref._terminate_char /*String*/  = _terminatechar;
RDebugUtils.currentLine=5505028;
 //BA.debugLineNum = 5505028;BA.debugLine="currPointer = 1";
__ref._currpointer /*int*/  = (int) (1);
RDebugUtils.currentLine=5505029;
 //BA.debugLineNum = 5505029;BA.debugLine="End Sub";
return "";
}
public boolean  _pollbyte(b4a.OPTUMizerPatient.clsparser __ref,String _x) throws Exception{
__ref = this;
RDebugUtils.currentModule="clsparser";
if (Debug.shouldDelegate(ba, "pollbyte", false))
	 {return ((Boolean) Debug.delegate(ba, "pollbyte", new Object[] {_x}));}
RDebugUtils.currentLine=5570560;
 //BA.debugLineNum = 5570560;BA.debugLine="Sub Pollbyte(x As String) As Boolean";
RDebugUtils.currentLine=5570561;
 //BA.debugLineNum = 5570561;BA.debugLine="If (vb6.Mid2(wait_header, currPointer, 1) = x)";
if (((_vb6._mid2 /*String*/ (getActivityBA(),__ref._wait_header /*String*/ ,__ref._currpointer /*int*/ ,(int) (1))).equals(_x))) { 
RDebugUtils.currentLine=5570562;
 //BA.debugLineNum = 5570562;BA.debugLine="currPointer = currPointer + 1";
__ref._currpointer /*int*/  = (int) (__ref._currpointer /*int*/ +1);
 }else {
RDebugUtils.currentLine=5570564;
 //BA.debugLineNum = 5570564;BA.debugLine="currPointer = 1";
__ref._currpointer /*int*/  = (int) (1);
 };
RDebugUtils.currentLine=5570566;
 //BA.debugLineNum = 5570566;BA.debugLine="If ((currPointer - 1) = vb6.Len(wait_header))";
if (((__ref._currpointer /*int*/ -1)==(double)(Double.parseDouble(_vb6._len /*String*/ (getActivityBA(),__ref._wait_header /*String*/ ))))) { 
RDebugUtils.currentLine=5570567;
 //BA.debugLineNum = 5570567;BA.debugLine="currPointer = 1";
__ref._currpointer /*int*/  = (int) (1);
RDebugUtils.currentLine=5570568;
 //BA.debugLineNum = 5570568;BA.debugLine="Return True";
if (true) return __c.True;
 };
RDebugUtils.currentLine=5570570;
 //BA.debugLineNum = 5570570;BA.debugLine="Return False";
if (true) return __c.False;
RDebugUtils.currentLine=5570571;
 //BA.debugLineNum = 5570571;BA.debugLine="End Sub";
return false;
}
public String  _class_globals(b4a.OPTUMizerPatient.clsparser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="clsparser";
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=5439489;
 //BA.debugLineNum = 5439489;BA.debugLine="Dim str As String";
_str = "";
RDebugUtils.currentLine=5439490;
 //BA.debugLineNum = 5439490;BA.debugLine="Dim buffer As String";
_buffer = "";
RDebugUtils.currentLine=5439491;
 //BA.debugLineNum = 5439491;BA.debugLine="Dim data As String";
_data = "";
RDebugUtils.currentLine=5439493;
 //BA.debugLineNum = 5439493;BA.debugLine="Dim wait_header As String";
_wait_header = "";
RDebugUtils.currentLine=5439494;
 //BA.debugLineNum = 5439494;BA.debugLine="Dim terminate_char As String";
_terminate_char = "";
RDebugUtils.currentLine=5439495;
 //BA.debugLineNum = 5439495;BA.debugLine="Dim num_terminate_char As Int";
_num_terminate_char = 0;
RDebugUtils.currentLine=5439496;
 //BA.debugLineNum = 5439496;BA.debugLine="Dim num_bufterminate_char As Int";
_num_bufterminate_char = 0;
RDebugUtils.currentLine=5439497;
 //BA.debugLineNum = 5439497;BA.debugLine="Dim status As Boolean";
_status = false;
RDebugUtils.currentLine=5439498;
 //BA.debugLineNum = 5439498;BA.debugLine="Dim currPointer As Int";
_currpointer = 0;
RDebugUtils.currentLine=5439500;
 //BA.debugLineNum = 5439500;BA.debugLine="End Sub";
return "";
}
public String  _databuffer(b4a.OPTUMizerPatient.clsparser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="clsparser";
if (Debug.shouldDelegate(ba, "databuffer", false))
	 {return ((String) Debug.delegate(ba, "databuffer", null));}
RDebugUtils.currentLine=5701632;
 //BA.debugLineNum = 5701632;BA.debugLine="Sub Databuffer() As String";
RDebugUtils.currentLine=5701633;
 //BA.debugLineNum = 5701633;BA.debugLine="Return data";
if (true) return __ref._data /*String*/ ;
RDebugUtils.currentLine=5701634;
 //BA.debugLineNum = 5701634;BA.debugLine="End Sub";
return "";
}
}