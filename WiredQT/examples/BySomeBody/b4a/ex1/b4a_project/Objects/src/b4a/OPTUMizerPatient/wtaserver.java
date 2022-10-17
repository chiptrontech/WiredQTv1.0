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
public String _dbsql = "";
public int _notconnected = 0;
public boolean _autoconnect = false;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.OPTUMizerPatient.main _main = null;
public b4a.OPTUMizerPatient.starter _starter = null;
public b4a.OPTUMizerPatient.vb6 _vb6 = null;
public String  _sendclient(b4a.OPTUMizerPatient.wtaserver __ref,String _s) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "sendclient", false))
	 {return ((String) Debug.delegate(ba, "sendclient", new Object[] {_s}));}
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Sub SendClient(s As String)";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="Try";
try {RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="If wtaserverIO.IsInitialized Then";
if (__ref._wtaserverio /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .IsInitialized()) { 
RDebugUtils.currentLine=6094851;
 //BA.debugLineNum = 6094851;BA.debugLine="s=\"WTARELAY^\" & clientid & \"^\" & s & Chr(13)";
_s = "WTARELAY^"+__ref._clientid /*String*/ +"^"+_s+BA.ObjectToString(__c.Chr((int) (13)));
RDebugUtils.currentLine=6094852;
 //BA.debugLineNum = 6094852;BA.debugLine="wtaserverIO.Write(s.GetBytes(\"UTF8\"))";
__ref._wtaserverio /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Write(_s.getBytes("UTF8"));
 }else {
RDebugUtils.currentLine=6094854;
 //BA.debugLineNum = 6094854;BA.debugLine="connected=False";
__ref._connected /*boolean*/  = __c.False;
RDebugUtils.currentLine=6094855;
 //BA.debugLineNum = 6094855;BA.debugLine="InitWTAServer";
__ref._initwtaserver /*String*/ (null);
 };
 } 
       catch (Exception e10) {
			ba.setLastException(e10);RDebugUtils.currentLine=6094858;
 //BA.debugLineNum = 6094858;BA.debugLine="ToastMessageShow(\"Check Internet\",False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("Check Internet"),__c.False);
 };
RDebugUtils.currentLine=6094860;
 //BA.debugLineNum = 6094860;BA.debugLine="End Sub";
return "";
}
public String  _initialize(b4a.OPTUMizerPatient.wtaserver __ref,anywheresoftware.b4a.BA _ba,Object _pmodule,String _peventname,String _id,String _clientid_,String _dbsql_x) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_pmodule,_peventname,_id,_clientid_,_dbsql_x}));}
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Public Sub Initialize(pModule As Object, pEventNam";
RDebugUtils.currentLine=5832705;
 //BA.debugLineNum = 5832705;BA.debugLine="mModule    = pModule";
__ref._mmodule /*Object*/  = _pmodule;
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="mEventName = pEventName";
__ref._meventname /*String*/  = _peventname;
RDebugUtils.currentLine=5832707;
 //BA.debugLineNum = 5832707;BA.debugLine="myid=id";
__ref._myid /*String*/  = _id;
RDebugUtils.currentLine=5832708;
 //BA.debugLineNum = 5832708;BA.debugLine="clientid=clientid_";
__ref._clientid /*String*/  = _clientid_;
RDebugUtils.currentLine=5832709;
 //BA.debugLineNum = 5832709;BA.debugLine="dbsql=dbsql_x";
__ref._dbsql /*String*/  = _dbsql_x;
RDebugUtils.currentLine=5832710;
 //BA.debugLineNum = 5832710;BA.debugLine="End Sub";
return "";
}
public String  _initwtaserver(b4a.OPTUMizerPatient.wtaserver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "initwtaserver", false))
	 {return ((String) Debug.delegate(ba, "initwtaserver", null));}
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Sub InitWTAServer";
RDebugUtils.currentLine=6291457;
 //BA.debugLineNum = 6291457;BA.debugLine="Try";
try {RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="If tmrwtaserver.IsInitialized=False Then";
if (__ref._tmrwtaserver /*anywheresoftware.b4a.objects.Timer*/ .IsInitialized()==__c.False) { 
RDebugUtils.currentLine=6291459;
 //BA.debugLineNum = 6291459;BA.debugLine="tmrwtaserver.Initialize(\"tmrwtaserver\",5000)";
__ref._tmrwtaserver /*anywheresoftware.b4a.objects.Timer*/ .Initialize(ba,"tmrwtaserver",(long) (5000));
RDebugUtils.currentLine=6291460;
 //BA.debugLineNum = 6291460;BA.debugLine="tmrwtaserver.Enabled=True";
__ref._tmrwtaserver /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(__c.True);
 };
RDebugUtils.currentLine=6291462;
 //BA.debugLineNum = 6291462;BA.debugLine="If CheckConnection  Then";
if (__ref._checkconnection /*boolean*/ (null)) { 
RDebugUtils.currentLine=6291463;
 //BA.debugLineNum = 6291463;BA.debugLine="wsh.Initialize(\"wsh\")";
__ref._wsh /*anywheresoftware.b4a.objects.SocketWrapper*/ .Initialize("wsh");
RDebugUtils.currentLine=6291464;
 //BA.debugLineNum = 6291464;BA.debugLine="wsh.Connect(\"184.168.126.221\",5001,30000)";
__ref._wsh /*anywheresoftware.b4a.objects.SocketWrapper*/ .Connect(ba,"184.168.126.221",(int) (5001),(int) (30000));
 };
 } 
       catch (Exception e11) {
			ba.setLastException(e11);RDebugUtils.currentLine=6291467;
 //BA.debugLineNum = 6291467;BA.debugLine="ToastMessageShow(\"Check Internet\",False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("Check Internet"),__c.False);
 };
RDebugUtils.currentLine=6291469;
 //BA.debugLineNum = 6291469;BA.debugLine="End Sub";
return "";
}
public boolean  _checkconnection(b4a.OPTUMizerPatient.wtaserver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "checkconnection", false))
	 {return ((Boolean) Debug.delegate(ba, "checkconnection", null));}
anywheresoftware.b4a.phone.Phone _p = null;
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Sub CheckConnection As Boolean";
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=6422531;
 //BA.debugLineNum = 6422531;BA.debugLine="If (p.GetDataState == \"CONNECTED\") Then";
if (((_p.GetDataState()).equals("CONNECTED"))) { 
RDebugUtils.currentLine=6422532;
 //BA.debugLineNum = 6422532;BA.debugLine="Return True";
if (true) return __c.True;
 };
RDebugUtils.currentLine=6422535;
 //BA.debugLineNum = 6422535;BA.debugLine="If (p.GetSettings (\"wifi_on\") == 1) Then";
if (((_p.GetSettings("wifi_on")).equals(BA.NumberToString(1)))) { 
RDebugUtils.currentLine=6422536;
 //BA.debugLineNum = 6422536;BA.debugLine="Return True";
if (true) return __c.True;
 };
RDebugUtils.currentLine=6422539;
 //BA.debugLineNum = 6422539;BA.debugLine="If (p.GetDataState == \"DISCONNECTED\") Then";
if (((_p.GetDataState()).equals("DISCONNECTED"))) { 
RDebugUtils.currentLine=6422540;
 //BA.debugLineNum = 6422540;BA.debugLine="Return False";
if (true) return __c.False;
 };
RDebugUtils.currentLine=6422543;
 //BA.debugLineNum = 6422543;BA.debugLine="If (p.GetDataState == \"SUSPENDED\") Then";
if (((_p.GetDataState()).equals("SUSPENDED"))) { 
RDebugUtils.currentLine=6422544;
 //BA.debugLineNum = 6422544;BA.debugLine="Return False";
if (true) return __c.False;
 };
RDebugUtils.currentLine=6422546;
 //BA.debugLineNum = 6422546;BA.debugLine="Return False";
if (true) return __c.False;
RDebugUtils.currentLine=6422547;
 //BA.debugLineNum = 6422547;BA.debugLine="End Sub";
return false;
}
public String  _class_globals(b4a.OPTUMizerPatient.wtaserver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=5767169;
 //BA.debugLineNum = 5767169;BA.debugLine="Private mModule As Object";
_mmodule = new Object();
RDebugUtils.currentLine=5767170;
 //BA.debugLineNum = 5767170;BA.debugLine="Private mEventName As String";
_meventname = "";
RDebugUtils.currentLine=5767171;
 //BA.debugLineNum = 5767171;BA.debugLine="Private wsh As Socket";
_wsh = new anywheresoftware.b4a.objects.SocketWrapper();
RDebugUtils.currentLine=5767172;
 //BA.debugLineNum = 5767172;BA.debugLine="Private wtaserverIO As AsyncStreams";
_wtaserverio = new anywheresoftware.b4a.randomaccessfile.AsyncStreams();
RDebugUtils.currentLine=5767173;
 //BA.debugLineNum = 5767173;BA.debugLine="Dim connected As Boolean=False";
_connected = __c.False;
RDebugUtils.currentLine=5767174;
 //BA.debugLineNum = 5767174;BA.debugLine="Dim myid As String=\"456\"";
_myid = "456";
RDebugUtils.currentLine=5767175;
 //BA.debugLineNum = 5767175;BA.debugLine="Dim clientid As String=\"123\"";
_clientid = "123";
RDebugUtils.currentLine=5767176;
 //BA.debugLineNum = 5767176;BA.debugLine="Private tmrwtaserver As Timer";
_tmrwtaserver = new anywheresoftware.b4a.objects.Timer();
RDebugUtils.currentLine=5767178;
 //BA.debugLineNum = 5767178;BA.debugLine="Private dbsql As String";
_dbsql = "";
RDebugUtils.currentLine=5767179;
 //BA.debugLineNum = 5767179;BA.debugLine="Private notconnected As Int";
_notconnected = 0;
RDebugUtils.currentLine=5767180;
 //BA.debugLineNum = 5767180;BA.debugLine="Private autoconnect As Boolean=True";
_autoconnect = __c.True;
RDebugUtils.currentLine=5767181;
 //BA.debugLineNum = 5767181;BA.debugLine="End Sub";
return "";
}
public String  _datagrid(b4a.OPTUMizerPatient.wtaserver __ref,b4a.OPTUMizerPatient.table _grid,String _strs,String _header) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "datagrid", false))
	 {return ((String) Debug.delegate(ba, "datagrid", new Object[] {_grid,_strs,_header}));}
anywheresoftware.b4a.objects.collections.List _j = null;
RDebugUtils.currentLine=6488064;
 //BA.debugLineNum = 6488064;BA.debugLine="public Sub DataGrid(grid As Table,strs As String,h";
RDebugUtils.currentLine=6488065;
 //BA.debugLineNum = 6488065;BA.debugLine="Dim j As List=ToList(strs)";
_j = new anywheresoftware.b4a.objects.collections.List();
_j = __ref._tolist /*anywheresoftware.b4a.objects.collections.List*/ (null,_strs);
RDebugUtils.currentLine=6488066;
 //BA.debugLineNum = 6488066;BA.debugLine="ToGrid(grid,j,header)";
__ref._togrid /*String*/ (null,_grid,_j,_header);
RDebugUtils.currentLine=6488067;
 //BA.debugLineNum = 6488067;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.List  _tolist(b4a.OPTUMizerPatient.wtaserver __ref,String _s) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "tolist", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "tolist", new Object[] {_s}));}
anywheresoftware.b4a.objects.collections.JSONParser _json = null;
anywheresoftware.b4a.objects.collections.List _jsls = null;
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Sub ToList(s As String) As List";
RDebugUtils.currentLine=6684673;
 //BA.debugLineNum = 6684673;BA.debugLine="Dim JSon As JSONParser";
_json = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=6684674;
 //BA.debugLineNum = 6684674;BA.debugLine="s=s.Replace(\",)\",\")\")";
_s = _s.replace(",)",")");
RDebugUtils.currentLine=6684675;
 //BA.debugLineNum = 6684675;BA.debugLine="s=s.Replace(\")\",\"]\")";
_s = _s.replace(")","]");
RDebugUtils.currentLine=6684676;
 //BA.debugLineNum = 6684676;BA.debugLine="s=s.Replace(\"(\",\"[\")";
_s = _s.replace("(","[");
RDebugUtils.currentLine=6684677;
 //BA.debugLineNum = 6684677;BA.debugLine="JSon.Initialize(s)";
_json.Initialize(_s);
RDebugUtils.currentLine=6684678;
 //BA.debugLineNum = 6684678;BA.debugLine="Dim JSLs As List";
_jsls = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6684679;
 //BA.debugLineNum = 6684679;BA.debugLine="JSLs.Initialize";
_jsls.Initialize();
RDebugUtils.currentLine=6684680;
 //BA.debugLineNum = 6684680;BA.debugLine="JSLs = JSon.nextArray";
_jsls = _json.NextArray();
RDebugUtils.currentLine=6684681;
 //BA.debugLineNum = 6684681;BA.debugLine="Return JSLs";
if (true) return _jsls;
RDebugUtils.currentLine=6684682;
 //BA.debugLineNum = 6684682;BA.debugLine="End Sub";
return null;
}
public String  _togrid(b4a.OPTUMizerPatient.wtaserver __ref,b4a.OPTUMizerPatient.table _grid,anywheresoftware.b4a.objects.collections.List _j,String _header) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "togrid", false))
	 {return ((String) Debug.delegate(ba, "togrid", new Object[] {_grid,_j,_header}));}
String _strs = "";
int _a = 0;
anywheresoftware.b4a.objects.collections.List _b = null;
int _c = 0;
String _d = "";
String _fname = "";
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="private Sub ToGrid(grid As Table,j As List,header";
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="Dim strs As String=header &CRLF";
_strs = _header+__c.CRLF;
RDebugUtils.currentLine=6619138;
 //BA.debugLineNum = 6619138;BA.debugLine="For a =0  To j.Size-1";
{
final int step2 = 1;
final int limit2 = (int) (_j.getSize()-1);
_a = (int) (0) ;
for (;_a <= limit2 ;_a = _a + step2 ) {
RDebugUtils.currentLine=6619139;
 //BA.debugLineNum = 6619139;BA.debugLine="Dim b As List	=j.get(a)'Log(j.Get(a))";
_b = new anywheresoftware.b4a.objects.collections.List();
_b.setObject((java.util.List)(_j.Get(_a)));
RDebugUtils.currentLine=6619140;
 //BA.debugLineNum = 6619140;BA.debugLine="For c =0  To b.Size-1";
{
final int step4 = 1;
final int limit4 = (int) (_b.getSize()-1);
_c = (int) (0) ;
for (;_c <= limit4 ;_c = _c + step4 ) {
RDebugUtils.currentLine=6619141;
 //BA.debugLineNum = 6619141;BA.debugLine="Dim d As String=b.get(c)'Log(j.Get(a))";
_d = BA.ObjectToString(_b.Get(_c));
RDebugUtils.currentLine=6619142;
 //BA.debugLineNum = 6619142;BA.debugLine="d=d.Replace(\",\",\" \")' supress comma";
_d = _d.replace(","," ");
RDebugUtils.currentLine=6619143;
 //BA.debugLineNum = 6619143;BA.debugLine="strs=strs&d&\",\"";
_strs = _strs+_d+",";
 }
};
RDebugUtils.currentLine=6619145;
 //BA.debugLineNum = 6619145;BA.debugLine="strs=strs.SubString2(0,strs.Length-1)";
_strs = _strs.substring((int) (0),(int) (_strs.length()-1));
RDebugUtils.currentLine=6619146;
 //BA.debugLineNum = 6619146;BA.debugLine="strs=strs&CRLF";
_strs = _strs+__c.CRLF;
 }
};
RDebugUtils.currentLine=6619148;
 //BA.debugLineNum = 6619148;BA.debugLine="Dim fname As String=\"mycsv.csv\"";
_fname = "mycsv.csv";
RDebugUtils.currentLine=6619149;
 //BA.debugLineNum = 6619149;BA.debugLine="If File.Exists(File.DirInternal,fname) Then";
if (__c.File.Exists(__c.File.getDirInternal(),_fname)) { 
RDebugUtils.currentLine=6619150;
 //BA.debugLineNum = 6619150;BA.debugLine="File.Delete(File.DirInternal,fname)";
__c.File.Delete(__c.File.getDirInternal(),_fname);
 };
RDebugUtils.currentLine=6619152;
 //BA.debugLineNum = 6619152;BA.debugLine="File.WriteString(File.DirInternal,fname,strs)";
__c.File.WriteString(__c.File.getDirInternal(),_fname,_strs);
RDebugUtils.currentLine=6619153;
 //BA.debugLineNum = 6619153;BA.debugLine="grid.LoadTableFromCSV(File.DirInternal,fname,True";
_grid._loadtablefromcsv /*String*/ (null,__c.File.getDirInternal(),_fname,__c.True);
RDebugUtils.currentLine=6619154;
 //BA.debugLineNum = 6619154;BA.debugLine="End Sub";
return "";
}
public String  _datetimesql(b4a.OPTUMizerPatient.wtaserver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "datetimesql", false))
	 {return ((String) Debug.delegate(ba, "datetimesql", null));}
String _a = "";
String _b = "";
String _date = "";
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Sub DateTimeSQL() As String";
RDebugUtils.currentLine=6750209;
 //BA.debugLineNum = 6750209;BA.debugLine="Dim a As String=DateTime.Date(DateTime.Now)";
_a = __c.DateTime.Date(__c.DateTime.getNow());
RDebugUtils.currentLine=6750210;
 //BA.debugLineNum = 6750210;BA.debugLine="Dim b As String=DateTime.Time(DateTime.Now)";
_b = __c.DateTime.Time(__c.DateTime.getNow());
RDebugUtils.currentLine=6750211;
 //BA.debugLineNum = 6750211;BA.debugLine="Dim date=vb6.getCSV(2,\"/\",a) & \"-\" & vb6.getCSV(0";
_date = _vb6._getcsv /*String*/ (getActivityBA(),(int) (2),"/",_a)+"-"+_vb6._getcsv /*String*/ (getActivityBA(),(int) (0),"/",_a)+"-"+_vb6._getcsv /*String*/ (getActivityBA(),(int) (1),"/",_a)+" "+_b;
RDebugUtils.currentLine=6750212;
 //BA.debugLineNum = 6750212;BA.debugLine="Return  date";
if (true) return _date;
RDebugUtils.currentLine=6750213;
 //BA.debugLineNum = 6750213;BA.debugLine="End Sub";
return "";
}
public String  _querry(b4a.OPTUMizerPatient.wtaserver __ref,String _strs,String _key) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "querry", false))
	 {return ((String) Debug.delegate(ba, "querry", new Object[] {_strs,_key}));}
String[] _sx = null;
RDebugUtils.currentLine=6553600;
 //BA.debugLineNum = 6553600;BA.debugLine="public Sub Querry(strs As String,key As String)";
RDebugUtils.currentLine=6553601;
 //BA.debugLineNum = 6553601;BA.debugLine="strs=strs.Trim";
_strs = _strs.trim();
RDebugUtils.currentLine=6553602;
 //BA.debugLineNum = 6553602;BA.debugLine="Dim sx() As String=Regex.Split(\" \",strs)";
_sx = __c.Regex.Split(" ",_strs);
RDebugUtils.currentLine=6553603;
 //BA.debugLineNum = 6553603;BA.debugLine="If sx(0).ToLowerCase.Contains(\"insert\") Then";
if (_sx[(int) (0)].toLowerCase().contains("insert")) { 
RDebugUtils.currentLine=6553604;
 //BA.debugLineNum = 6553604;BA.debugLine="SendServer(\"WTASQLNONQUERRY^\"&strs&\";^\"&dbsql)";
__ref._sendserver /*String*/ (null,"WTASQLNONQUERRY^"+_strs+";^"+__ref._dbsql /*String*/ );
 };
RDebugUtils.currentLine=6553606;
 //BA.debugLineNum = 6553606;BA.debugLine="If sx(0).ToLowerCase.Contains(\"create\") Then";
if (_sx[(int) (0)].toLowerCase().contains("create")) { 
RDebugUtils.currentLine=6553607;
 //BA.debugLineNum = 6553607;BA.debugLine="SendServer(\"WTASQLNONQUERRY^\"&strs&\";^\"&dbsql)";
__ref._sendserver /*String*/ (null,"WTASQLNONQUERRY^"+_strs+";^"+__ref._dbsql /*String*/ );
 };
RDebugUtils.currentLine=6553609;
 //BA.debugLineNum = 6553609;BA.debugLine="If sx(0).ToLowerCase.Contains(\"update\") Then";
if (_sx[(int) (0)].toLowerCase().contains("update")) { 
RDebugUtils.currentLine=6553610;
 //BA.debugLineNum = 6553610;BA.debugLine="SendServer(\"WTASQLNONQUERRY^\" & strs &\";^\"&dbsql";
__ref._sendserver /*String*/ (null,"WTASQLNONQUERRY^"+_strs+";^"+__ref._dbsql /*String*/ );
 };
RDebugUtils.currentLine=6553612;
 //BA.debugLineNum = 6553612;BA.debugLine="If sx(0).ToLowerCase.Contains(\"delete\") Then";
if (_sx[(int) (0)].toLowerCase().contains("delete")) { 
RDebugUtils.currentLine=6553613;
 //BA.debugLineNum = 6553613;BA.debugLine="SendServer(\"WTASQLNONQUERRY^\"& strs &\";^\"&dbsql)";
__ref._sendserver /*String*/ (null,"WTASQLNONQUERRY^"+_strs+";^"+__ref._dbsql /*String*/ );
 };
RDebugUtils.currentLine=6553616;
 //BA.debugLineNum = 6553616;BA.debugLine="If sx(0).ToLowerCase.Contains(\"select\") Then";
if (_sx[(int) (0)].toLowerCase().contains("select")) { 
RDebugUtils.currentLine=6553617;
 //BA.debugLineNum = 6553617;BA.debugLine="SendServer(\"WTASQLQUERRY^\"&strs &\";^\"&dbsql&\"^\"&";
__ref._sendserver /*String*/ (null,"WTASQLQUERRY^"+_strs+";^"+__ref._dbsql /*String*/ +"^"+_key);
 };
RDebugUtils.currentLine=6553619;
 //BA.debugLineNum = 6553619;BA.debugLine="End Sub";
return "";
}
public String  _sendserver(b4a.OPTUMizerPatient.wtaserver __ref,String _s) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "sendserver", false))
	 {return ((String) Debug.delegate(ba, "sendserver", new Object[] {_s}));}
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Sub SendServer(s As String)";
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="Try";
try {RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="s=s&Chr(13)";
_s = _s+BA.ObjectToString(__c.Chr((int) (13)));
RDebugUtils.currentLine=6029315;
 //BA.debugLineNum = 6029315;BA.debugLine="If wtaserverIO.IsInitialized Then";
if (__ref._wtaserverio /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .IsInitialized()) { 
RDebugUtils.currentLine=6029316;
 //BA.debugLineNum = 6029316;BA.debugLine="wtaserverIO.Write(s.GetBytes(\"UTF8\"))";
__ref._wtaserverio /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Write(_s.getBytes("UTF8"));
 }else {
RDebugUtils.currentLine=6029318;
 //BA.debugLineNum = 6029318;BA.debugLine="InitWTAServer";
__ref._initwtaserver /*String*/ (null);
 };
 } 
       catch (Exception e9) {
			ba.setLastException(e9);RDebugUtils.currentLine=6029321;
 //BA.debugLineNum = 6029321;BA.debugLine="ToastMessageShow(\"Check Internet\",False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("Check Internet"),__c.False);
 };
RDebugUtils.currentLine=6029323;
 //BA.debugLineNum = 6029323;BA.debugLine="End Sub";
return "";
}
public String  _tmrwtaserver_tick(b4a.OPTUMizerPatient.wtaserver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "tmrwtaserver_tick", false))
	 {return ((String) Debug.delegate(ba, "tmrwtaserver_tick", null));}
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="Sub tmrwtaserver_Tick";
RDebugUtils.currentLine=6356993;
 //BA.debugLineNum = 6356993;BA.debugLine="If autoconnect Then";
if (__ref._autoconnect /*boolean*/ ) { 
RDebugUtils.currentLine=6356994;
 //BA.debugLineNum = 6356994;BA.debugLine="If notconnected=3 Then";
if (__ref._notconnected /*int*/ ==3) { 
RDebugUtils.currentLine=6356995;
 //BA.debugLineNum = 6356995;BA.debugLine="ToastMessageShow(\"check connection\",False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("check connection"),__c.False);
RDebugUtils.currentLine=6356996;
 //BA.debugLineNum = 6356996;BA.debugLine="wsh.Close";
__ref._wsh /*anywheresoftware.b4a.objects.SocketWrapper*/ .Close();
RDebugUtils.currentLine=6356997;
 //BA.debugLineNum = 6356997;BA.debugLine="InitWTAServer";
__ref._initwtaserver /*String*/ (null);
 }else {
RDebugUtils.currentLine=6356999;
 //BA.debugLineNum = 6356999;BA.debugLine="notconnected=notconnected+1";
__ref._notconnected /*int*/  = (int) (__ref._notconnected /*int*/ +1);
RDebugUtils.currentLine=6357000;
 //BA.debugLineNum = 6357000;BA.debugLine="SendServer(\"WTASQLTIME\")'prevent disconnection";
__ref._sendserver /*String*/ (null,"WTASQLTIME");
 };
 }else {
RDebugUtils.currentLine=6357004;
 //BA.debugLineNum = 6357004;BA.debugLine="SendServer(\"x\")'prevent disconnection";
__ref._sendserver /*String*/ (null,"x");
 };
RDebugUtils.currentLine=6357006;
 //BA.debugLineNum = 6357006;BA.debugLine="End Sub";
return "";
}
public String  _wsh_connected(b4a.OPTUMizerPatient.wtaserver __ref,boolean _successful) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "wsh_connected", false))
	 {return ((String) Debug.delegate(ba, "wsh_connected", new Object[] {_successful}));}
String _strs = "";
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub wsh_Connected(Successful As Boolean)";
RDebugUtils.currentLine=5898241;
 //BA.debugLineNum = 5898241;BA.debugLine="ProgressDialogHide";
__c.ProgressDialogHide();
RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="If Successful Then";
if (_successful) { 
RDebugUtils.currentLine=5898245;
 //BA.debugLineNum = 5898245;BA.debugLine="wtaserverIO.Initialize(wsh.InputStream,wsh.Outpu";
__ref._wtaserverio /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Initialize(ba,__ref._wsh /*anywheresoftware.b4a.objects.SocketWrapper*/ .getInputStream(),__ref._wsh /*anywheresoftware.b4a.objects.SocketWrapper*/ .getOutputStream(),"wsh");
RDebugUtils.currentLine=5898246;
 //BA.debugLineNum = 5898246;BA.debugLine="Dim strs As String=\"WTAREGISTER^\"&myid & Chr(13)";
_strs = "WTAREGISTER^"+__ref._myid /*String*/ +BA.ObjectToString(__c.Chr((int) (13)));
RDebugUtils.currentLine=5898247;
 //BA.debugLineNum = 5898247;BA.debugLine="wtaserverIO.Write(strs.GetBytes(\"UTF8\"))";
__ref._wtaserverio /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Write(_strs.getBytes("UTF8"));
RDebugUtils.currentLine=5898248;
 //BA.debugLineNum = 5898248;BA.debugLine="connected=True";
__ref._connected /*boolean*/  = __c.True;
 }else {
RDebugUtils.currentLine=5898250;
 //BA.debugLineNum = 5898250;BA.debugLine="wsh.Close";
__ref._wsh /*anywheresoftware.b4a.objects.SocketWrapper*/ .Close();
RDebugUtils.currentLine=5898251;
 //BA.debugLineNum = 5898251;BA.debugLine="Msgbox(\"Please Tr-y Again\",\"Error Connecting\")";
__c.Msgbox(BA.ObjectToCharSequence("Please Tr-y Again"),BA.ObjectToCharSequence("Error Connecting"),getActivityBA());
 };
RDebugUtils.currentLine=5898253;
 //BA.debugLineNum = 5898253;BA.debugLine="End Sub";
return "";
}
public String  _wsh_newdata(b4a.OPTUMizerPatient.wtaserver __ref,byte[] _buffer) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "wsh_newdata", false))
	 {return ((String) Debug.delegate(ba, "wsh_newdata", new Object[] {_buffer}));}
String _mline = "";
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Sub wsh_NewData(Buffer() As Byte)";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="Dim mLine As String";
_mline = "";
RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="mLine = BytesToString(Buffer,0,Buffer.Length,\"UTF";
_mline = __c.BytesToString(_buffer,(int) (0),_buffer.length,"UTF-8");
RDebugUtils.currentLine=5963779;
 //BA.debugLineNum = 5963779;BA.debugLine="notconnected=0";
__ref._notconnected /*int*/  = (int) (0);
RDebugUtils.currentLine=5963780;
 //BA.debugLineNum = 5963780;BA.debugLine="If SubExists(mModule,mEventName & \"_\" & \"NewData\"";
if (__c.SubExists(ba,__ref._mmodule /*Object*/ ,__ref._meventname /*String*/ +"_"+"NewData")) { 
RDebugUtils.currentLine=5963781;
 //BA.debugLineNum = 5963781;BA.debugLine="CallSub2(mModule,mEventName & \"_\" & \"NewData\",mL";
__c.CallSubNew2(ba,__ref._mmodule /*Object*/ ,__ref._meventname /*String*/ +"_"+"NewData",(Object)(_mline));
 };
RDebugUtils.currentLine=5963785;
 //BA.debugLineNum = 5963785;BA.debugLine="End Sub";
return "";
}
public String  _wtaserver_error(b4a.OPTUMizerPatient.wtaserver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "wtaserver_error", false))
	 {return ((String) Debug.delegate(ba, "wtaserver_error", null));}
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Sub wtaserver_Error()";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="wtaserverIO.Close";
__ref._wtaserverio /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Close();
RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="wsh.Close";
__ref._wsh /*anywheresoftware.b4a.objects.SocketWrapper*/ .Close();
RDebugUtils.currentLine=6225923;
 //BA.debugLineNum = 6225923;BA.debugLine="connected=False";
__ref._connected /*boolean*/  = __c.False;
RDebugUtils.currentLine=6225924;
 //BA.debugLineNum = 6225924;BA.debugLine="ToastMessageShow(\"wtaserver_Error\",False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("wtaserver_Error"),__c.False);
RDebugUtils.currentLine=6225925;
 //BA.debugLineNum = 6225925;BA.debugLine="End Sub";
return "";
}
public String  _wtaserver_terminated(b4a.OPTUMizerPatient.wtaserver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="wtaserver";
if (Debug.shouldDelegate(ba, "wtaserver_terminated", false))
	 {return ((String) Debug.delegate(ba, "wtaserver_terminated", null));}
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Sub wtaserver_Terminated()";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="ToastMessageShow(\"Terminated raks\",False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("Terminated raks"),__c.False);
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="connected=False";
__ref._connected /*boolean*/  = __c.False;
RDebugUtils.currentLine=6160387;
 //BA.debugLineNum = 6160387;BA.debugLine="End Sub";
return "";
}
}