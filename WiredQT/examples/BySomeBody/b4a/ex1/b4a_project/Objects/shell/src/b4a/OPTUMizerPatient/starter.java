
package b4a.OPTUMizerPatient;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class starter implements IRemote{
	public static starter mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public starter() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("starter"), "b4a.OPTUMizerPatient.starter");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("b4a.OPTUMizerPatient.starter");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, starter.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) mostCurrent.pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _sms_rx = RemoteObject.declareNull("anywheresoftware.b4a.phone.PhoneEvents.SMSInterceptor");
public static RemoteObject _sms = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.PhoneSms");
public static RemoteObject _timer1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _astream = RemoteObject.declareNull("anywheresoftware.b4a.randomaccessfile.AsyncStreams");
public static RemoteObject _connected_bt = RemoteObject.createImmutable(false);
public static RemoteObject _serial1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.Serial");
public static RemoteObject _msec_ = RemoteObject.createImmutable(0);
public static RemoteObject _customview = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _bluetoothview1 = RemoteObject.declareNull("Object");
public static RemoteObject _frmcontrols1 = RemoteObject.declareNull("Object");
public static RemoteObject _wsh = RemoteObject.declareNull("b4a.OPTUMizerPatient.wtaserver");
public static RemoteObject _myparser = RemoteObject.declareNull("b4a.OPTUMizerPatient.clsparser");
public static RemoteObject _parse1 = RemoteObject.declareNull("b4a.OPTUMizerPatient.clsparser");
public static RemoteObject _volt = RemoteObject.declareNull("b4a.OPTUMizerPatient.clsparser");
public static RemoteObject _amp = RemoteObject.declareNull("b4a.OPTUMizerPatient.clsparser");
public static RemoteObject _powerwatt = RemoteObject.declareNull("b4a.OPTUMizerPatient.clsparser");
public static RemoteObject _energy = RemoteObject.declareNull("b4a.OPTUMizerPatient.clsparser");
public static RemoteObject _voltx = RemoteObject.createImmutable("");
public static RemoteObject _ampx = RemoteObject.createImmutable("");
public static RemoteObject _powerwattx = RemoteObject.createImmutable("");
public static RemoteObject _energyx = RemoteObject.createImmutable("");
public static RemoteObject _rp = RemoteObject.declareNull("anywheresoftware.b4a.objects.RuntimePermissions");
public static RemoteObject _frmmain1 = RemoteObject.declareNull("Object");
public static RemoteObject _rfid = RemoteObject.declareNull("b4a.OPTUMizerPatient.clsparser");
public static RemoteObject _gotomap = RemoteObject.declareNull("b4a.OPTUMizerPatient.clsparser");
public static RemoteObject _location = RemoteObject.declareNull("b4a.OPTUMizerPatient.clsparser");
public static RemoteObject _notifengineon = RemoteObject.declareNull("b4a.OPTUMizerPatient.clsparser");
public static RemoteObject _notifengineoff = RemoteObject.declareNull("b4a.OPTUMizerPatient.clsparser");
public static RemoteObject _nextform = RemoteObject.declareNull("b4a.OPTUMizerPatient.clsparser");
public static RemoteObject _selectsql = RemoteObject.declareNull("b4a.OPTUMizerPatient.clsparser");
public static RemoteObject _hasdisinfect = RemoteObject.declareNull("b4a.OPTUMizerPatient.clsparser");
public static RemoteObject _hasdelivered = RemoteObject.declareNull("b4a.OPTUMizerPatient.clsparser");
public static RemoteObject _uuid = RemoteObject.createImmutable("");
public static RemoteObject _filepath = RemoteObject.createImmutable("");
public static RemoteObject _statequerry = RemoteObject.createImmutable("");
public static RemoteObject _httputils2service = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httputils2service");
public static b4a.OPTUMizerPatient.main _main = null;
public static b4a.OPTUMizerPatient.vb6 _vb6 = null;
  public Object[] GetGlobals() {
		return new Object[] {"amp",starter._amp,"ampx",starter._ampx,"astream",starter._astream,"bluetoothview1",starter._bluetoothview1,"connected_BT",starter._connected_bt,"customview",starter._customview,"energy",starter._energy,"energyx",starter._energyx,"FilePath",starter._filepath,"frmcontrols1",starter._frmcontrols1,"frmmain1",starter._frmmain1,"GOTOMAP",starter._gotomap,"HASDELIVERED",starter._hasdelivered,"HASDISINFECT",starter._hasdisinfect,"HttpUtils2Service",starter.mostCurrent._httputils2service,"LOCATION",starter._location,"Main",Debug.moduleToString(b4a.OPTUMizerPatient.main.class),"msec_",starter._msec_,"myparser",starter._myparser,"NEXTFORM",starter._nextform,"NOTIFENGINEOFF",starter._notifengineoff,"NOTIFENGINEON",starter._notifengineon,"parse1",starter._parse1,"powerWatt",starter._powerwatt,"powerWattx",starter._powerwattx,"RFID",starter._rfid,"rp",starter._rp,"SELECTSQL",starter._selectsql,"Serial1",starter._serial1,"Service",starter.mostCurrent._service,"sms",starter._sms,"sms_rx",starter._sms_rx,"statequerry",starter._statequerry,"timer1",starter._timer1,"uuid",starter._uuid,"vb6",Debug.moduleToString(b4a.OPTUMizerPatient.vb6.class),"volt",starter._volt,"voltx",starter._voltx,"wsh",starter._wsh};
}
}