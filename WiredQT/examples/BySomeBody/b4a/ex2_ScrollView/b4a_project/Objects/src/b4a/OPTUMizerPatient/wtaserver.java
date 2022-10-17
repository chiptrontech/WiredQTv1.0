package b4a.OPTUMizerPatient;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class wtaserver extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.OPTUMizerPatient.wtaserver");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.OPTUMizerPatient.wtaserver.class).invoke(this, new Object[] {null});
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
public Object _mmodule = null;
public String _meventname = "";
public anywheresoftware.b4a.objects.SocketWrapper _wsh = null;
public anywheresoftware.b4a.randomaccessfile.AsyncStreams _wtaserverio = null;
public boolean _connected = false;
public String _myid = "";
public String _clientid = "";
public anywheresoftware.b4a.objects.Timer _tmrwtaserver = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.OPTUMizerPatient.main _main = null;
public b4a.OPTUMizerPatient.starter _starter = null;
public b4a.OPTUMizerPatient.vb6 _vb6 = null;
public String  _sendclient(b4a.OPTUMizerPatient.wtaserver __ref,String _s) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "sendclient", false))
	 {return ((String) Debug.delegate(ba, "sendclient", new Object[] {_s}));}
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Sub SendClient(s As String)";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="Try";
try {RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="If wtaserverIO.IsInitialized Then";
if (__ref._wtaserverio /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .IsInitialized()) { 
RDebugUtils.currentLine=4587523;
 //BA.debugLineNum = 4587523;BA.debugLine="s=\"WTARELAY^\" & clientid & \"^\" & s & Chr(13)";
_s = "WTARELAY^"+__ref._clientid /*String*/ +"^"+_s+BA.ObjectToString(__c.Chr((int) (13)));
RDebugUtils.currentLine=4587524;
 //BA.debugLineNum = 4587524;BA.debugLine="wtaserverIO.Write(s.GetBytes(\"UTF8\"))";
__ref._wtaserverio /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Write(_s.getBytes("UTF8"));
 }else {
RDebugUtils.currentLine=4587526;
 //BA.debugLineNum = 4587526;BA.debugLine="connected=False";
__ref._connected /*boolean*/  = __c.False;
RDebugUtils.currentLine=4587527;
 //BA.debugLineNum = 4587527;BA.debugLine="InitWTAServer";
__ref._initwtaserver /*String*/ (null);
 };
 } 
       catch (Exception e10) {
			ba.setLastException(e10);RDebugUtils.currentLine=4587530;
 //BA.debugLineNum = 4587530;BA.debugLine="ToastMessageShow(\"Check Internet\",False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("Check Internet"),__c.False);
 };
RDebugUtils.currentLine=4587532;
 //BA.debugLineNum = 4587532;BA.debugLine="End Sub";
return "";
}
public String  _initialize(b4a.OPTUMizerPatient.wtaserver __ref,anywheresoftware.b4a.BA _ba,Object _pmodule,String _peventname,String _id,String _clientid_) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_pmodule,_peventname,_id,_clientid_}));}
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Public Sub Initialize(pModule As Object, pEventNam";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="mModule    = pModule";
__ref._mmodule /*Object*/  = _pmodule;
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="mEventName = pEventName";
__ref._meventname /*String*/  = _peventname;
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="myid=id";
__ref._myid /*String*/  = _id;
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="clientid=clientid_";
__ref._clientid /*String*/  = _clientid_;
RDebugUtils.currentLine=4325381;
 //BA.debugLineNum = 4325381;BA.debugLine="End Sub";
return "";
}
public String  _initwtaserver(b4a.OPTUMizerPatient.wtaserver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "initwtaserver", false))
	 {return ((String) Debug.delegate(ba, "initwtaserver", null));}
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Sub InitWTAServer";
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="Try";
try {RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="If tmrwtaserver.IsInitialized=False Then";
if (__ref._tmrwtaserver /*anywheresoftware.b4a.objects.Timer*/ .IsInitialized()==__c.False) { 
RDebugUtils.currentLine=4784131;
 //BA.debugLineNum = 4784131;BA.debugLine="tmrwtaserver.Initialize(\"tmrwtaserver\",5000)";
__ref._tmrwtaserver /*anywheresoftware.b4a.objects.Timer*/ .Initialize(ba,"tmrwtaserver",(long) (5000));
RDebugUtils.currentLine=4784132;
 //BA.debugLineNum = 4784132;BA.debugLine="tmrwtaserver.Enabled=True";
__ref._tmrwtaserver /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(__c.True);
 };
RDebugUtils.currentLine=4784134;
 //BA.debugLineNum = 4784134;BA.debugLine="If CheckConnection  Then";
if (__ref._checkconnection /*boolean*/ (null)) { 
RDebugUtils.currentLine=4784135;
 //BA.debugLineNum = 4784135;BA.debugLine="wsh.Initialize(\"wsh\")";
__ref._wsh /*anywheresoftware.b4a.objects.SocketWrapper*/ .Initialize("wsh");
RDebugUtils.currentLine=4784136;
 //BA.debugLineNum = 4784136;BA.debugLine="wsh.Connect(\"184.168.126.221\",5001,30000)";
__ref._wsh /*anywheresoftware.b4a.objects.SocketWrapper*/ .Connect(ba,"184.168.126.221",(int) (5001),(int) (30000));
 };
 } 
       catch (Exception e11) {
			ba.setLastException(e11);RDebugUtils.currentLine=4784139;
 //BA.debugLineNum = 4784139;BA.debugLine="ToastMessageShow(\"Check Internet\",False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("Check Internet"),__c.False);
 };
RDebugUtils.currentLine=4784141;
 //BA.debugLineNum = 4784141;BA.debugLine="End Sub";
return "";
}
public boolean  _checkconnection(b4a.OPTUMizerPatient.wtaserver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "checkconnection", false))
	 {return ((Boolean) Debug.delegate(ba, "checkconnection", null));}
anywheresoftware.b4a.phone.Phone _p = null;
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Sub CheckConnection As Boolean";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=4915203;
 //BA.debugLineNum = 4915203;BA.debugLine="If (p.GetDataState == \"CONNECTED\") Then";
if (((_p.GetDataState()).equals("CONNECTED"))) { 
RDebugUtils.currentLine=4915204;
 //BA.debugLineNum = 4915204;BA.debugLine="Return True";
if (true) return __c.True;
 };
RDebugUtils.currentLine=4915207;
 //BA.debugLineNum = 4915207;BA.debugLine="If (p.GetSettings (\"wifi_on\") == 1) Then";
if (((_p.GetSettings("wifi_on")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=4915208;
 //BA.debugLineNum = 4915208;BA.debugLine="Return True";
if (true) return __c.True;
 };
RDebugUtils.currentLine=4915211;
 //BA.debugLineNum = 4915211;BA.debugLine="If (p.GetDataState == \"DISCONNECTED\") Then";
if (((_p.GetDataState()).equals("DISCONNECTED"))) { 
RDebugUtils.currentLine=4915212;
 //BA.debugLineNum = 4915212;BA.debugLine="Return False";
if (true) return __c.False;
 };
RDebugUtils.currentLine=4915215;
 //BA.debugLineNum = 4915215;BA.debugLine="If (p.GetDataState == \"SUSPENDED\") Then";
if (((_p.GetDataState()).equals("SUSPENDED"))) { 
RDebugUtils.currentLine=4915216;
 //BA.debugLineNum = 4915216;BA.debugLine="Return False";
if (true) return __c.False;
 };
RDebugUtils.currentLine=4915218;
 //BA.debugLineNum = 4915218;BA.debugLine="Return False";
if (true) return __c.False;
RDebugUtils.currentLine=4915219;
 //BA.debugLineNum = 4915219;BA.debugLine="End Sub";
return false;
}
public String  _class_globals(b4a.OPTUMizerPatient.wtaserver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="Private mModule As Object";
_mmodule = new Object();
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="Private mEventName As String";
_meventname = "";
RDebugUtils.currentLine=4259843;
 //BA.debugLineNum = 4259843;BA.debugLine="Private wsh As Socket";
_wsh = new anywheresoftware.b4a.objects.SocketWrapper();
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="Private wtaserverIO As AsyncStreams";
_wtaserverio = new anywheresoftware.b4a.randomaccessfile.AsyncStreams();
RDebugUtils.currentLine=4259845;
 //BA.debugLineNum = 4259845;BA.debugLine="Dim connected As Boolean=False";
_connected = __c.False;
RDebugUtils.currentLine=4259846;
 //BA.debugLineNum = 4259846;BA.debugLine="Dim myid As String=\"456\"";
_myid = "456";
RDebugUtils.currentLine=4259847;
 //BA.debugLineNum = 4259847;BA.debugLine="Dim clientid As String=\"123\"";
_clientid = "123";
RDebugUtils.currentLine=4259848;
 //BA.debugLineNum = 4259848;BA.debugLine="Private tmrwtaserver As Timer";
_tmrwtaserver = new anywheresoftware.b4a.objects.Timer();
RDebugUtils.currentLine=4259850;
 //BA.debugLineNum = 4259850;BA.debugLine="End Sub";
return "";
}
public String  _sendserver(b4a.OPTUMizerPatient.wtaserver __ref,String _s) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "sendserver", false))
	 {return ((String) Debug.delegate(ba, "sendserver", new Object[] {_s}));}
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub SendServer(s As String)";
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="Try";
try {RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="s=s&Chr(13)";
_s = _s+BA.ObjectToString(__c.Chr((int) (13)));
RDebugUtils.currentLine=4521987;
 //BA.debugLineNum = 4521987;BA.debugLine="If wtaserverIO.IsInitialized Then";
if (__ref._wtaserverio /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .IsInitialized()) { 
RDebugUtils.currentLine=4521988;
 //BA.debugLineNum = 4521988;BA.debugLine="wtaserverIO.Write(s.GetBytes(\"UTF8\"))";
__ref._wtaserverio /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Write(_s.getBytes("UTF8"));
 }else {
RDebugUtils.currentLine=4521990;
 //BA.debugLineNum = 4521990;BA.debugLine="InitWTAServer";
__ref._initwtaserver /*String*/ (null);
 };
 } 
       catch (Exception e9) {
			ba.setLastException(e9);RDebugUtils.currentLine=4521993;
 //BA.debugLineNum = 4521993;BA.debugLine="ToastMessageShow(\"Check Internet\",False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("Check Internet"),__c.False);
 };
RDebugUtils.currentLine=4521995;
 //BA.debugLineNum = 4521995;BA.debugLine="End Sub";
return "";
}
public String  _tmrwtaserver_tick(b4a.OPTUMizerPatient.wtaserver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "tmrwtaserver_tick", false))
	 {return ((String) Debug.delegate(ba, "tmrwtaserver_tick", null));}
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Sub tmrwtaserver_Tick";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="SendServer(\"x\")'prevent disconnection";
__ref._sendserver /*String*/ (null,"x");
RDebugUtils.currentLine=4849666;
 //BA.debugLineNum = 4849666;BA.debugLine="End Sub";
return "";
}
public String  _wsh_connected(b4a.OPTUMizerPatient.wtaserver __ref,boolean _successful) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "wsh_connected", false))
	 {return ((String) Debug.delegate(ba, "wsh_connected", new Object[] {_successful}));}
String _strs = "";
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub wsh_Connected(Successful As Boolean)";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="ProgressDialogHide";
__c.ProgressDialogHide();
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="If Successful Then";
if (_successful) { 
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="wtaserverIO.Initialize(wsh.InputStream,wsh.Outpu";
__ref._wtaserverio /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Initialize(ba,__ref._wsh /*anywheresoftware.b4a.objects.SocketWrapper*/ .getInputStream(),__ref._wsh /*anywheresoftware.b4a.objects.SocketWrapper*/ .getOutputStream(),"wsh");
RDebugUtils.currentLine=4390918;
 //BA.debugLineNum = 4390918;BA.debugLine="Dim strs As String=\"WTAREGISTER^\"&myid & Chr(13)";
_strs = "WTAREGISTER^"+__ref._myid /*String*/ +BA.ObjectToString(__c.Chr((int) (13)));
RDebugUtils.currentLine=4390919;
 //BA.debugLineNum = 4390919;BA.debugLine="wtaserverIO.Write(strs.GetBytes(\"UTF8\"))";
__ref._wtaserverio /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Write(_strs.getBytes("UTF8"));
RDebugUtils.currentLine=4390920;
 //BA.debugLineNum = 4390920;BA.debugLine="connected=True";
__ref._connected /*boolean*/  = __c.True;
 }else {
RDebugUtils.currentLine=4390922;
 //BA.debugLineNum = 4390922;BA.debugLine="wsh.Close";
__ref._wsh /*anywheresoftware.b4a.objects.SocketWrapper*/ .Close();
RDebugUtils.currentLine=4390923;
 //BA.debugLineNum = 4390923;BA.debugLine="Msgbox(\"Please Tr-y Again\",\"Error Connecting\")";
__c.Msgbox(BA.ObjectToCharSequence("Please Tr-y Again"),BA.ObjectToCharSequence("Error Connecting"),getActivityBA());
 };
RDebugUtils.currentLine=4390925;
 //BA.debugLineNum = 4390925;BA.debugLine="End Sub";
return "";
}
public String  _wsh_newdata(b4a.OPTUMizerPatient.wtaserver __ref,byte[] _buffer) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "wsh_newdata", false))
	 {return ((String) Debug.delegate(ba, "wsh_newdata", new Object[] {_buffer}));}
String _mline = "";
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub wsh_NewData(Buffer() As Byte)";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="Dim mLine As String";
_mline = "";
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="mLine = BytesToString(Buffer,0,Buffer.Length,\"UTF";
_mline = __c.BytesToString(_buffer,(int) (0),_buffer.length,"UTF-8");
RDebugUtils.currentLine=4456451;
 //BA.debugLineNum = 4456451;BA.debugLine="If SubExists(mModule,mEventName & \"_\" & \"NewData\"";
if (__c.SubExists(ba,__ref._mmodule /*Object*/ ,__ref._meventname /*String*/ +"_"+"NewData")) { 
RDebugUtils.currentLine=4456452;
 //BA.debugLineNum = 4456452;BA.debugLine="CallSub2(mModule,mEventName & \"_\" & \"NewData\",mL";
__c.CallSubNew2(ba,__ref._mmodule /*Object*/ ,__ref._meventname /*String*/ +"_"+"NewData",(Object)(_mline));
 };
RDebugUtils.currentLine=4456455;
 //BA.debugLineNum = 4456455;BA.debugLine="End Sub";
return "";
}
public String  _wtaserver_error(b4a.OPTUMizerPatient.wtaserver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "wtaserver_error", false))
	 {return ((String) Debug.delegate(ba, "wtaserver_error", null));}
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Sub wtaserver_Error()";
RDebugUtils.currentLine=4718593;
 //BA.debugLineNum = 4718593;BA.debugLine="wtaserverIO.Close";
__ref._wtaserverio /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Close();
RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="wsh.Close";
__ref._wsh /*anywheresoftware.b4a.objects.SocketWrapper*/ .Close();
RDebugUtils.currentLine=4718595;
 //BA.debugLineNum = 4718595;BA.debugLine="connected=False";
__ref._connected /*boolean*/  = __c.False;
RDebugUtils.currentLine=4718596;
 //BA.debugLineNum = 4718596;BA.debugLine="ToastMessageShow(\"wtaserver_Error\",False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("wtaserver_Error"),__c.False);
RDebugUtils.currentLine=4718597;
 //BA.debugLineNum = 4718597;BA.debugLine="End Sub";
return "";
}
public String  _wtaserver_terminated(b4a.OPTUMizerPatient.wtaserver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "wtaserver_terminated", false))
	 {return ((String) Debug.delegate(ba, "wtaserver_terminated", null));}
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Sub wtaserver_Terminated()";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="ToastMessageShow(\"Terminated raks\",False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("Terminated raks"),__c.False);
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="connected=False";
__ref._connected /*boolean*/  = __c.False;
RDebugUtils.currentLine=4653059;
 //BA.debugLineNum = 4653059;BA.debugLine="End Sub";
return "";
}
}