
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

public class vb6 implements IRemote{
	public static vb6 mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public vb6() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, vb6.class);
    static {
		mostCurrent = new vb6();
        remoteMe = RemoteObject.declareNull("b4a.OPTUMizerPatient.vb6");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("vb6"), "b4a.OPTUMizerPatient.vb6");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("b4a.OPTUMizerPatient.vb6"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _httputils2service = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httputils2service");
public static b4a.OPTUMizerPatient.main _main = null;
public static b4a.OPTUMizerPatient.starter _starter = null;
  public Object[] GetGlobals() {
		return new Object[] {"HttpUtils2Service",vb6.mostCurrent._httputils2service,"Main",Debug.moduleToString(b4a.OPTUMizerPatient.main.class),"Starter",Debug.moduleToString(b4a.OPTUMizerPatient.starter.class)};
}
}