package b4a.OPTUMizerPatient;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends  android.app.Service{
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (starter) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, true, anywheresoftware.b4a.ShellBA.class);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "b4a.OPTUMizerPatient", "b4a.OPTUMizerPatient.starter");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.OPTUMizerPatient.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (starter) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (starter) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (true)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (true) {
            BA.LogInfo("** Service (starter) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (starter) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.phone.PhoneEvents.SMSInterceptor _sms_rx = null;
public static anywheresoftware.b4a.phone.Phone.PhoneSms _sms = null;
public static anywheresoftware.b4a.objects.Timer _timer1 = null;
public static anywheresoftware.b4a.randomaccessfile.AsyncStreams _astream = null;
public static boolean _connected_bt = false;
public static anywheresoftware.b4a.objects.Serial _serial1 = null;
public static int _msec_ = 0;
public static anywheresoftware.b4a.objects.collections.List _customview = null;
public static Object _bluetoothview1 = null;
public static Object _frmcontrols1 = null;
public static b4a.OPTUMizerPatient.wtaserver _wsh = null;
public static b4a.OPTUMizerPatient.clsparser _myparser = null;
public static b4a.OPTUMizerPatient.clsparser _parse1 = null;
public static b4a.OPTUMizerPatient.clsparser _volt = null;
public static b4a.OPTUMizerPatient.clsparser _amp = null;
public static b4a.OPTUMizerPatient.clsparser _powerwatt = null;
public static b4a.OPTUMizerPatient.clsparser _energy = null;
public static String _voltx = "";
public static String _ampx = "";
public static String _powerwattx = "";
public static String _energyx = "";
public static anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public static Object _frmmain1 = null;
public static b4a.OPTUMizerPatient.clsparser _rfid = null;
public static b4a.OPTUMizerPatient.clsparser _gotomap = null;
public static b4a.OPTUMizerPatient.clsparser _location = null;
public static b4a.OPTUMizerPatient.clsparser _notifengineon = null;
public static b4a.OPTUMizerPatient.clsparser _notifengineoff = null;
public static b4a.OPTUMizerPatient.clsparser _nextform = null;
public static b4a.OPTUMizerPatient.clsparser _selectsql = null;
public static b4a.OPTUMizerPatient.clsparser _hasdisinfect = null;
public static b4a.OPTUMizerPatient.clsparser _hasdelivered = null;
public static String _uuid = "";
public static String _filepath = "";
public static String _statequerry = "";
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.OPTUMizerPatient.main _main = null;
public b4a.OPTUMizerPatient.vb6 _vb6 = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "application_error", false))
	 {return ((Boolean) Debug.delegate(processBA, "application_error", new Object[] {_error,_stacktrace}));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="End Sub";
return false;
}
public static String  _astream_newdata(byte[] _buffer) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "astream_newdata", false))
	 {return ((String) Debug.delegate(processBA, "astream_newdata", new Object[] {_buffer}));}
String _str = "";
int _aa = 0;
String _z = "";
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub astream_NewData (Buffer() As Byte)";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Dim str As String";
_str = "";
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="str=BytesToString(Buffer, 0, Buffer.Length, \"UTF8";
_str = anywheresoftware.b4a.keywords.Common.BytesToString(_buffer,(int) (0),_buffer.length,"UTF8");
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="Dim aa As Int";
_aa = 0;
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="For aa = 0 To str.Length-1";
{
final int step4 = 1;
final int limit4 = (int) (_str.length()-1);
_aa = (int) (0) ;
for (;_aa <= limit4 ;_aa = _aa + step4 ) {
RDebugUtils.currentLine=1245192;
 //BA.debugLineNum = 1245192;BA.debugLine="Dim z As String";
_z = "";
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="z=str.SubString2(aa,aa+1)";
_z = _str.substring(_aa,(int) (_aa+1));
RDebugUtils.currentLine=1245195;
 //BA.debugLineNum = 1245195;BA.debugLine="If myparser.available(z)=True Then";
if (_myparser._available /*boolean*/ (null,_z)==anywheresoftware.b4a.keywords.Common.True) { 
 };
 }
};
RDebugUtils.currentLine=1245202;
 //BA.debugLineNum = 1245202;BA.debugLine="End Sub";
return "";
}
public static String  _conns(int _res,anywheresoftware.b4a.objects.collections.Map _paireddevices,anywheresoftware.b4a.objects.collections.List _l) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "conns", false))
	 {return ((String) Debug.delegate(processBA, "conns", new Object[] {_res,_paireddevices,_l}));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub conns(res As Int, PairedDevices As Map, L As L";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Serial1.Connect3(PairedDevices.Get(L.Get(res)),1)";
_serial1.Connect3(processBA,BA.ObjectToString(_paireddevices.Get(_l.Get(_res))),(int) (1));
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="End Sub";
return "";
}
public static String  _gps_locationchanged(anywheresoftware.b4a.gps.LocationWrapper _location1) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "gps_locationchanged", false))
	 {return ((String) Debug.delegate(processBA, "gps_locationchanged", new Object[] {_location1}));}
float _lat = 0f;
float _lon = 0f;
String _speed = "";
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub GPS_LocationChanged (Location1 As Location)";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="Dim lat As Float= NumberFormat(Location1.Latitude";
_lat = (float)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.NumberFormat(_location1.getLatitude(),(int) (1),(int) (6))));
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="Dim lon As Float= NumberFormat(Location1.Longitud";
_lon = (float)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.NumberFormat(_location1.getLongitude(),(int) (1),(int) (6))));
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="Dim speed As String = \"Speed = \" & Location1.Spee";
_speed = "Speed = "+BA.NumberToString(_location1.getSpeed());
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="If wsh.connected=True Then";
if (_wsh._connected /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="wsh.SendClient(\"WTAGPS\" & lat & \",\" & lon & \",\"";
_wsh._sendclient /*String*/ (null,"WTAGPS"+BA.NumberToString(_lat)+","+BA.NumberToString(_lon)+","+_speed+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (13))));
 };
RDebugUtils.currentLine=1572876;
 //BA.debugLineNum = 1572876;BA.debugLine="End Sub";
return "";
}
public static String  _mnuconnect_click() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "mnuconnect_click", false))
	 {return ((String) Debug.delegate(processBA, "mnuconnect_click", null));}
anywheresoftware.b4a.objects.collections.Map _paireddevices = null;
anywheresoftware.b4a.objects.collections.List _l = null;
int _i = 0;
int _res = 0;
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub mnuConnect_Click";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="Dim PairedDevices As Map";
_paireddevices = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="If connected_BT=False Then";
if (_connected_bt==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="PairedDevices = Serial1.GetPairedDevices";
_paireddevices = _serial1.GetPairedDevices();
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="Dim L As List";
_l = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="L.Initialize";
_l.Initialize();
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="For i = 0 To PairedDevices.Size - 1";
{
final int step6 = 1;
final int limit6 = (int) (_paireddevices.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=1376263;
 //BA.debugLineNum = 1376263;BA.debugLine="L.Add(PairedDevices.GetKeyAt(i)) 'add the frien";
_l.Add(_paireddevices.GetKeyAt(_i));
 }
};
RDebugUtils.currentLine=1376265;
 //BA.debugLineNum = 1376265;BA.debugLine="Dim res As Int";
_res = 0;
RDebugUtils.currentLine=1376267;
 //BA.debugLineNum = 1376267;BA.debugLine="res=\"\"'CallSub2(bluetooth,\"Getlist\",L)";
_res = (int)(Double.parseDouble(""));
RDebugUtils.currentLine=1376269;
 //BA.debugLineNum = 1376269;BA.debugLine="If 1 Then 'res <> DialogResponse.CANCEL Then";
if (BA.ObjectToBoolean(1)) { 
RDebugUtils.currentLine=1376270;
 //BA.debugLineNum = 1376270;BA.debugLine="PairedDevices.Get(l.Get(res))";
_paireddevices.Get(_l.Get(_res));
RDebugUtils.currentLine=1376276;
 //BA.debugLineNum = 1376276;BA.debugLine="Serial1.Connect(PairedDevices.Get(\"HC-05\")) 'co";
_serial1.Connect(processBA,BA.ObjectToString(_paireddevices.Get((Object)("HC-05"))));
 };
 };
RDebugUtils.currentLine=1376279;
 //BA.debugLineNum = 1376279;BA.debugLine="End Sub";
return "";
}
public static String  _mnudisconnect_click() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "mnudisconnect_click", false))
	 {return ((String) Debug.delegate(processBA, "mnudisconnect_click", null));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub mnuDisconnect_Click";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="If connected_BT=True Then";
if (_connected_bt==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="astream.Close";
_astream.Close();
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="timer1.Enabled=False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="Serial1.Disconnect";
_serial1.Disconnect();
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="connected_BT=False";
_connected_bt = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=1048583;
 //BA.debugLineNum = 1048583;BA.debugLine="End Sub";
return "";
}
public static String  _msec(int _xa) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "msec", false))
	 {return ((String) Debug.delegate(processBA, "msec", new Object[] {_xa}));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub msec(xa As Int)";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="msec_ = xa";
_msec_ = _xa;
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="Do While(msec_<>0)";
while ((_msec_!=0)) {
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
 }
;
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="End Sub";
return "";
}
public static String  _println(String _str) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "println", false))
	 {return ((String) Debug.delegate(processBA, "println", new Object[] {_str}));}
String _x = "";
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="public Sub Println(str As String)";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Dim x As String";
_x = "";
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="str=str&Chr(13)";
_str = _str+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (13)));
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="x=str.Length";
_x = BA.NumberToString(_str.length());
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="If connected_BT=True Then";
if (_connected_bt==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="astream.Write(str.GetBytes(\"UTF8\"))";
_astream.Write(_str.getBytes("UTF8"));
 };
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="End Sub";
return "";
}
public static String  _sendwsh(String _strs) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "sendwsh", false))
	 {return ((String) Debug.delegate(processBA, "sendwsh", new Object[] {_strs}));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub sendwsh(strs As String)";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="wsh.SendClient(strs & \",\" &uuid & \"#\")";
_wsh._sendclient /*String*/ (null,_strs+","+_uuid+"#");
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="End Sub";
return "";
}
public static String  _serial1_connected(boolean _success) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "serial1_connected", false))
	 {return ((String) Debug.delegate(processBA, "serial1_connected", new Object[] {_success}));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub Serial1_Connected (Success As Boolean)";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="ToastMessageShow(\"Connected successfully\", False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Connected successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="astream.Initialize(Serial1.InputStream, Serial1.";
_astream.Initialize(processBA,_serial1.getInputStream(),_serial1.getOutputStream(),"astream");
RDebugUtils.currentLine=1179656;
 //BA.debugLineNum = 1179656;BA.debugLine="connected_BT = True";
_connected_bt = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=1179662;
 //BA.debugLineNum = 1179662;BA.debugLine="connected_BT = False";
_connected_bt = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=1179663;
 //BA.debugLineNum = 1179663;BA.debugLine="ToastMessageShow(\"Check BT connection\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Check BT connection"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=1179671;
 //BA.debugLineNum = 1179671;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_create", false))
	 {return ((String) Debug.delegate(processBA, "service_create", null));}
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="r.Target=r.RunStaticMethod(\"java.util.UUID\", \"ran";
_r.Target = _r.RunStaticMethod("java.util.UUID","randomUUID",(Object[])(anywheresoftware.b4a.keywords.Common.Null),(String[])(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="uuid =r.RunMethod(\"toString\")";
_uuid = BA.ObjectToString(_r.RunMethod("toString"));
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="Serial1.Initialize(\"Serial1\")";
_serial1.Initialize("Serial1");
RDebugUtils.currentLine=393225;
 //BA.debugLineNum = 393225;BA.debugLine="wsh.Initialize(Me,\"wsh\",uuid,\"KEYLESSSERVER\")";
_wsh._initialize /*String*/ (null,processBA,starter.getObject(),"wsh",_uuid,"KEYLESSSERVER");
RDebugUtils.currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="wsh.InitWTAServer()";
_wsh._initwtaserver /*String*/ (null);
RDebugUtils.currentLine=393227;
 //BA.debugLineNum = 393227;BA.debugLine="GOTOMAP.Initialize(\"GOTOMAP\",\"#\",1)";
_gotomap._initialize /*String*/ (null,processBA,"GOTOMAP","#",(int) (1));
RDebugUtils.currentLine=393228;
 //BA.debugLineNum = 393228;BA.debugLine="RFID.Initialize(\"RFID\",\"#\",1)";
_rfid._initialize /*String*/ (null,processBA,"RFID","#",(int) (1));
RDebugUtils.currentLine=393229;
 //BA.debugLineNum = 393229;BA.debugLine="LOCATION.Initialize(\"LOCATION\",\"#\",1)";
_location._initialize /*String*/ (null,processBA,"LOCATION","#",(int) (1));
RDebugUtils.currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="NEXTFORM.Initialize(\"NEXTFORM\",\"#\",1)";
_nextform._initialize /*String*/ (null,processBA,"NEXTFORM","#",(int) (1));
RDebugUtils.currentLine=393231;
 //BA.debugLineNum = 393231;BA.debugLine="HASDISINFECT.Initialize(\"HASDISINFECT\",\"#\",1)";
_hasdisinfect._initialize /*String*/ (null,processBA,"HASDISINFECT","#",(int) (1));
RDebugUtils.currentLine=393232;
 //BA.debugLineNum = 393232;BA.debugLine="HASDELIVERED.Initialize(\"HASDELIVERED\",\"#\",1)";
_hasdelivered._initialize /*String*/ (null,processBA,"HASDELIVERED","#",(int) (1));
RDebugUtils.currentLine=393233;
 //BA.debugLineNum = 393233;BA.debugLine="SELECTSQL.Initialize(\"SELECTSQL\",\"#\",1)";
_selectsql._initialize /*String*/ (null,processBA,"SELECTSQL","#",(int) (1));
RDebugUtils.currentLine=393234;
 //BA.debugLineNum = 393234;BA.debugLine="NOTIFENGINEON.Initialize(\"NOTIFENGINEON\",\"#\",1)";
_notifengineon._initialize /*String*/ (null,processBA,"NOTIFENGINEON","#",(int) (1));
RDebugUtils.currentLine=393235;
 //BA.debugLineNum = 393235;BA.debugLine="NOTIFENGINEOFF.Initialize(\"NOTIFENGINEOFF\",\"#\",1)";
_notifengineoff._initialize /*String*/ (null,processBA,"NOTIFENGINEOFF","#",(int) (1));
RDebugUtils.currentLine=393236;
 //BA.debugLineNum = 393236;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_destroy", false))
	 {return ((String) Debug.delegate(processBA, "service_destroy", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="ToastMessageShow(\"exit\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("exit"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_start", false))
	 {return ((String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent}));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_taskremoved", false))
	 {return ((String) Debug.delegate(processBA, "service_taskremoved", null));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub Service_TaskRemoved";
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="End Sub";
return "";
}
public static boolean  _sms_rx_messagereceived(String _from,String _body) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "sms_rx_messagereceived", false))
	 {return ((Boolean) Debug.delegate(processBA, "sms_rx_messagereceived", new Object[] {_from,_body}));}
String _strsend = "";
int _aa = 0;
String _z = "";
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub sms_rx_MessageReceived(From As String, Body As";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="Dim strsend As String";
_strsend = "";
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="If Body=\"Hello\" Then";
if ((_body).equals("Hello")) { 
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="sms.Send(From,\"what the hell\")";
_sms.Send(_from,"what the hell");
 };
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="Dim aa As Int";
_aa = 0;
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="For aa = 0 To Body.Length-1";
{
final int step6 = 1;
final int limit6 = (int) (_body.length()-1);
_aa = (int) (0) ;
for (;_aa <= limit6 ;_aa = _aa + step6 ) {
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="Dim z As String";
_z = "";
RDebugUtils.currentLine=1310728;
 //BA.debugLineNum = 1310728;BA.debugLine="z=Body.SubString2(aa,aa+1)";
_z = _body.substring(_aa,(int) (_aa+1));
RDebugUtils.currentLine=1310729;
 //BA.debugLineNum = 1310729;BA.debugLine="If myparser.available(z)=True Then";
if (_myparser._available /*boolean*/ (null,_z)==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1310730;
 //BA.debugLineNum = 1310730;BA.debugLine="ToastMessageShow(myparser.data,False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_myparser._data /*String*/ ),anywheresoftware.b4a.keywords.Common.False);
 };
 }
};
RDebugUtils.currentLine=1310733;
 //BA.debugLineNum = 1310733;BA.debugLine="End Sub";
return false;
}
public static String  _timer1_tick() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "timer1_tick", false))
	 {return ((String) Debug.delegate(processBA, "timer1_tick", null));}
String _strs = "";
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub Timer1_Tick";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="ToastMessageShow(\"saving logs to power_log.csv\",T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("saving logs to power_log.csv"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="If File.Exists(File.DirRootExternal, \"power_log.c";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"power_log.csv")==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="Dim strs As String=vb6.GetFileStr(\"power_log.csv";
_strs = mostCurrent._vb6._getfilestr /*String*/ (processBA,"power_log.csv");
RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="strs=strs&voltx&\",\"&ampx&\",\"&powerWattx&\",\"&ener";
_strs = _strs+_voltx+","+_ampx+","+_powerwattx+","+_energyx+","+mostCurrent._vb6._now /*String*/ (processBA)+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (13)));
RDebugUtils.currentLine=1441798;
 //BA.debugLineNum = 1441798;BA.debugLine="vb6.SaveFileStr(\"power_log.csv\",strs)";
mostCurrent._vb6._savefilestr /*String*/ (processBA,"power_log.csv",_strs);
 }else {
RDebugUtils.currentLine=1441800;
 //BA.debugLineNum = 1441800;BA.debugLine="vb6.SaveFileStr(\"power_log.csv\",\"Volt,Current,Po";
mostCurrent._vb6._savefilestr /*String*/ (processBA,"power_log.csv","Volt,Current,Power,Energy,Time"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (13)))+_voltx+","+_ampx+","+_powerwattx+","+_energyx+","+mostCurrent._vb6._now /*String*/ (processBA)+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (13))));
 };
RDebugUtils.currentLine=1441802;
 //BA.debugLineNum = 1441802;BA.debugLine="End Sub";
return "";
}
public static String  _wsh_newdata(String _data) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "wsh_newdata", false))
	 {return ((String) Debug.delegate(processBA, "wsh_newdata", new Object[] {_data}));}
int _aa = 0;
String _z = "";
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub wsh_NewData(data As String)";
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Dim aa As Int";
_aa = 0;
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="For aa = 0 To data.Length-1";
{
final int step2 = 1;
final int limit2 = (int) (_data.length()-1);
_aa = (int) (0) ;
for (;_aa <= limit2 ;_aa = _aa + step2 ) {
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="Dim z As String";
_z = "";
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="z=data.SubString2(aa,aa+1)";
_z = _data.substring(_aa,(int) (_aa+1));
 }
};
RDebugUtils.currentLine=983054;
 //BA.debugLineNum = 983054;BA.debugLine="End Sub";
return "";
}
}