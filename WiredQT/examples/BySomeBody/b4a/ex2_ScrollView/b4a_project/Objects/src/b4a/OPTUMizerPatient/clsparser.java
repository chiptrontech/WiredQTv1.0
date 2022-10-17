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
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub available(MSComm_input As String) As Boolean";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="Dim c As String";
_c = "";
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="str = str & MSComm_input";
__ref._str /*String*/  = __ref._str /*String*/ +_mscomm_input;
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="Do While (str <> \"\")";
while (((__ref._str /*String*/ ).equals("") == false)) {
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="c = vb6.Mid2(str, 1, 1)";
_c = _vb6._mid2 /*String*/ (getActivityBA(),__ref._str /*String*/ ,(int) (1),(int) (1));
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="If status Then data = data & c";
if (__ref._status /*boolean*/ ) { 
__ref._data /*String*/  = __ref._data /*String*/ +_c;};
RDebugUtils.currentLine=4128775;
 //BA.debugLineNum = 4128775;BA.debugLine="If Pollbyte(c) Then";
if (__ref._pollbyte /*boolean*/ (null,_c)) { 
RDebugUtils.currentLine=4128776;
 //BA.debugLineNum = 4128776;BA.debugLine="data = \"\"";
__ref._data /*String*/  = "";
RDebugUtils.currentLine=4128777;
 //BA.debugLineNum = 4128777;BA.debugLine="status = True";
__ref._status /*boolean*/  = __c.True;
RDebugUtils.currentLine=4128778;
 //BA.debugLineNum = 4128778;BA.debugLine="num_bufterminate_char = 0";
__ref._num_bufterminate_char /*int*/  = (int) (0);
 };
RDebugUtils.currentLine=4128780;
 //BA.debugLineNum = 4128780;BA.debugLine="If (status = True) Then";
if ((__ref._status /*boolean*/ ==__c.True)) { 
RDebugUtils.currentLine=4128781;
 //BA.debugLineNum = 4128781;BA.debugLine="If (c = terminate_char) Then";
if (((_c).equals(__ref._terminate_char /*String*/ ))) { 
RDebugUtils.currentLine=4128782;
 //BA.debugLineNum = 4128782;BA.debugLine="str = vb6.Mid(str, 2)";
__ref._str /*String*/  = _vb6._mid /*String*/ (getActivityBA(),__ref._str /*String*/ ,(int) (2));
RDebugUtils.currentLine=4128783;
 //BA.debugLineNum = 4128783;BA.debugLine="num_bufterminate_char = num_bufter";
__ref._num_bufterminate_char /*int*/  = (int) (__ref._num_bufterminate_char /*int*/ +1);
RDebugUtils.currentLine=4128784;
 //BA.debugLineNum = 4128784;BA.debugLine="If (num_bufterminate_char = num_te";
if ((__ref._num_bufterminate_char /*int*/ ==__ref._num_terminate_char /*int*/ )) { 
RDebugUtils.currentLine=4128785;
 //BA.debugLineNum = 4128785;BA.debugLine="status = False";
__ref._status /*boolean*/  = __c.False;
RDebugUtils.currentLine=4128786;
 //BA.debugLineNum = 4128786;BA.debugLine="data = vb6.Mid2(data, 1, vb6.L";
__ref._data /*String*/  = _vb6._mid2 /*String*/ (getActivityBA(),__ref._data /*String*/ ,(int) (1),(int) ((double)(Double.parseDouble(_vb6._len /*String*/ (getActivityBA(),__ref._data /*String*/ )))-1));
RDebugUtils.currentLine=4128787;
 //BA.debugLineNum = 4128787;BA.debugLine="Return True";
if (true) return __c.True;
 };
 };
 };
RDebugUtils.currentLine=4128791;
 //BA.debugLineNum = 4128791;BA.debugLine="If vb6.Len(str) > 1 Then";
if ((double)(Double.parseDouble(_vb6._len /*String*/ (getActivityBA(),__ref._str /*String*/ )))>1) { 
RDebugUtils.currentLine=4128792;
 //BA.debugLineNum = 4128792;BA.debugLine="str = vb6.Mid(str, 2)";
__ref._str /*String*/  = _vb6._mid /*String*/ (getActivityBA(),__ref._str /*String*/ ,(int) (2));
 }else {
RDebugUtils.currentLine=4128794;
 //BA.debugLineNum = 4128794;BA.debugLine="str = \"\"";
__ref._str /*String*/  = "";
RDebugUtils.currentLine=4128795;
 //BA.debugLineNum = 4128795;BA.debugLine="Exit";
if (true) break;
 };
 }
;
RDebugUtils.currentLine=4128798;
 //BA.debugLineNum = 4128798;BA.debugLine="Return False";
if (true) return __c.False;
RDebugUtils.currentLine=4128799;
 //BA.debugLineNum = 4128799;BA.debugLine="End Sub";
return false;
}
public String  _initialize(b4a.OPTUMizerPatient.clsparser __ref,anywheresoftware.b4a.BA _ba,String _waitheader,String _terminatechar,int _numterminate) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="clsparser";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_waitheader,_terminatechar,_numterminate}));}
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Public Sub Initialize(WaitHeader As String, Termin";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="num_terminate_char = numTerminate";
__ref._num_terminate_char /*int*/  = _numterminate;
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="wait_header = WaitHeader";
__ref._wait_header /*String*/  = _waitheader;
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="terminate_char = TerminateChar";
__ref._terminate_char /*String*/  = _terminatechar;
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="currPointer = 1";
__ref._currpointer /*int*/  = (int) (1);
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="End Sub";
return "";
}
public boolean  _pollbyte(b4a.OPTUMizerPatient.clsparser __ref,String _x) throws Exception{
__ref = this;
RDebugUtils.currentModule="clsparser";
if (Debug.shouldDelegate(ba, "pollbyte", false))
	 {return ((Boolean) Debug.delegate(ba, "pollbyte", new Object[] {_x}));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub Pollbyte(x As String) As Boolean";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="If (vb6.Mid2(wait_header, currPointer, 1) = x)";
if (((_vb6._mid2 /*String*/ (getActivityBA(),__ref._wait_header /*String*/ ,__ref._currpointer /*int*/ ,(int) (1))).equals(_x))) { 
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="currPointer = currPointer + 1";
__ref._currpointer /*int*/  = (int) (__ref._currpointer /*int*/ +1);
 }else {
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="currPointer = 1";
__ref._currpointer /*int*/  = (int) (1);
 };
RDebugUtils.currentLine=4063238;
 //BA.debugLineNum = 4063238;BA.debugLine="If ((currPointer - 1) = vb6.Len(wait_header))";
if (((__ref._currpointer /*int*/ -1)==(double)(Double.parseDouble(_vb6._len /*String*/ (getActivityBA(),__ref._wait_header /*String*/ ))))) { 
RDebugUtils.currentLine=4063239;
 //BA.debugLineNum = 4063239;BA.debugLine="currPointer = 1";
__ref._currpointer /*int*/  = (int) (1);
RDebugUtils.currentLine=4063240;
 //BA.debugLineNum = 4063240;BA.debugLine="Return True";
if (true) return __c.True;
 };
RDebugUtils.currentLine=4063242;
 //BA.debugLineNum = 4063242;BA.debugLine="Return False";
if (true) return __c.False;
RDebugUtils.currentLine=4063243;
 //BA.debugLineNum = 4063243;BA.debugLine="End Sub";
return false;
}
public String  _class_globals(b4a.OPTUMizerPatient.clsparser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="clsparser";
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="Dim str As String";
_str = "";
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="Dim buffer As String";
_buffer = "";
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="Dim data As String";
_data = "";
RDebugUtils.currentLine=3932165;
 //BA.debugLineNum = 3932165;BA.debugLine="Dim wait_header As String";
_wait_header = "";
RDebugUtils.currentLine=3932166;
 //BA.debugLineNum = 3932166;BA.debugLine="Dim terminate_char As String";
_terminate_char = "";
RDebugUtils.currentLine=3932167;
 //BA.debugLineNum = 3932167;BA.debugLine="Dim num_terminate_char As Int";
_num_terminate_char = 0;
RDebugUtils.currentLine=3932168;
 //BA.debugLineNum = 3932168;BA.debugLine="Dim num_bufterminate_char As Int";
_num_bufterminate_char = 0;
RDebugUtils.currentLine=3932169;
 //BA.debugLineNum = 3932169;BA.debugLine="Dim status As Boolean";
_status = false;
RDebugUtils.currentLine=3932170;
 //BA.debugLineNum = 3932170;BA.debugLine="Dim currPointer As Int";
_currpointer = 0;
RDebugUtils.currentLine=3932172;
 //BA.debugLineNum = 3932172;BA.debugLine="End Sub";
return "";
}
public String  _databuffer(b4a.OPTUMizerPatient.clsparser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="clsparser";
if (Debug.shouldDelegate(ba, "databuffer", false))
	 {return ((String) Debug.delegate(ba, "databuffer", null));}
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Sub Databuffer() As String";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="Return data";
if (true) return __ref._data /*String*/ ;
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="End Sub";
return "";
}
}