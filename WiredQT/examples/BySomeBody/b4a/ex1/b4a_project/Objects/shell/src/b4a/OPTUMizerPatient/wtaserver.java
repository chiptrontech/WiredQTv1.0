
package b4a.OPTUMizerPatient;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class wtaserver {
    public static RemoteObject myClass;
	public wtaserver() {
	}
    public static PCBA staticBA = new PCBA(null, wtaserver.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _mmodule = RemoteObject.declareNull("Object");
public static RemoteObject _meventname = RemoteObject.createImmutable("");
public static RemoteObject _wsh = RemoteObject.declareNull("anywheresoftware.b4a.objects.SocketWrapper");
public static RemoteObject _wtaserverio = RemoteObject.declareNull("anywheresoftware.b4a.randomaccessfile.AsyncStreams");
public static RemoteObject _connected = RemoteObject.createImmutable(false);
public static RemoteObject _myid = RemoteObject.createImmutable("");
public static RemoteObject _clientid = RemoteObject.createImmutable("");
public static RemoteObject _tmrwtaserver = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _dbsql = RemoteObject.createImmutable("");
public static RemoteObject _notconnected = RemoteObject.createImmutable(0);
public static RemoteObject _autoconnect = RemoteObject.createImmutable(false);
public static RemoteObject _httputils2service = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httputils2service");
public static b4a.OPTUMizerPatient.main _main = null;
public static b4a.OPTUMizerPatient.starter _starter = null;
public static b4a.OPTUMizerPatient.vb6 _vb6 = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"autoconnect",_ref.getField(false, "_autoconnect"),"clientid",_ref.getField(false, "_clientid"),"connected",_ref.getField(false, "_connected"),"dbsql",_ref.getField(false, "_dbsql"),"HttpUtils2Service",_ref.getField(false, "_httputils2service"),"mEventName",_ref.getField(false, "_meventname"),"mModule",_ref.getField(false, "_mmodule"),"myid",_ref.getField(false, "_myid"),"notconnected",_ref.getField(false, "_notconnected"),"tmrwtaserver",_ref.getField(false, "_tmrwtaserver"),"wsh",_ref.getField(false, "_wsh"),"wtaserverIO",_ref.getField(false, "_wtaserverio")};
}
}