
package b4a.OPTUMizerPatient;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class frmmain {
    public static RemoteObject myClass;
	public frmmain() {
	}
    public static PCBA staticBA = new PCBA(null, frmmain.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _meventname = RemoteObject.createImmutable("");
public static RemoteObject _mcallback = RemoteObject.declareNull("Object");
public static RemoteObject _mbase = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _defaultcolorconstant = RemoteObject.createImmutable(0);
public static RemoteObject _qpushbutton4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _qpushbutton1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _qcombobox3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _qframe4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _qcombobox5 = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _qlabel6 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _datagrid7 = RemoteObject.declareNull("b4a.OPTUMizerPatient.table");
public static RemoteObject _qslider8 = RemoteObject.declareNull("anywheresoftware.b4a.objects.SeekBarWrapper");
public static RemoteObject _timer9 = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _httputils2service = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httputils2service");
public static b4a.OPTUMizerPatient.main _main = null;
public static b4a.OPTUMizerPatient.starter _starter = null;
public static b4a.OPTUMizerPatient.vb6 _vb6 = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"DataGrid7",_ref.getField(false, "_datagrid7"),"DefaultColorConstant",_ref.getField(false, "_defaultcolorconstant"),"HttpUtils2Service",_ref.getField(false, "_httputils2service"),"mBase",_ref.getField(false, "_mbase"),"mCallBack",_ref.getField(false, "_mcallback"),"mEventName",_ref.getField(false, "_meventname"),"QComboBox3",_ref.getField(false, "_qcombobox3"),"QComboBox5",_ref.getField(false, "_qcombobox5"),"QFrame4",_ref.getField(false, "_qframe4"),"QLabel6",_ref.getField(false, "_qlabel6"),"QPushButton1",_ref.getField(false, "_qpushbutton1"),"QPushButton4",_ref.getField(false, "_qpushbutton4"),"QSlider8",_ref.getField(false, "_qslider8"),"Timer9",_ref.getField(false, "_timer9")};
}
}