
package b4a.OPTUMizerPatient;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class clsparser {
    public static RemoteObject myClass;
	public clsparser() {
	}
    public static PCBA staticBA = new PCBA(null, clsparser.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _str = RemoteObject.createImmutable("");
public static RemoteObject _buffer = RemoteObject.createImmutable("");
public static RemoteObject _data = RemoteObject.createImmutable("");
public static RemoteObject _wait_header = RemoteObject.createImmutable("");
public static RemoteObject _terminate_char = RemoteObject.createImmutable("");
public static RemoteObject _num_terminate_char = RemoteObject.createImmutable(0);
public static RemoteObject _num_bufterminate_char = RemoteObject.createImmutable(0);
public static RemoteObject _status = RemoteObject.createImmutable(false);
public static RemoteObject _currpointer = RemoteObject.createImmutable(0);
public static RemoteObject _httputils2service = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httputils2service");
public static b4a.OPTUMizerPatient.main _main = null;
public static b4a.OPTUMizerPatient.starter _starter = null;
public static b4a.OPTUMizerPatient.vb6 _vb6 = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"buffer",_ref.getField(false, "_buffer"),"currPointer",_ref.getField(false, "_currpointer"),"data",_ref.getField(false, "_data"),"HttpUtils2Service",_ref.getField(false, "_httputils2service"),"num_bufterminate_char",_ref.getField(false, "_num_bufterminate_char"),"num_terminate_char",_ref.getField(false, "_num_terminate_char"),"status",_ref.getField(false, "_status"),"str",_ref.getField(false, "_str"),"terminate_char",_ref.getField(false, "_terminate_char"),"wait_header",_ref.getField(false, "_wait_header")};
}
}