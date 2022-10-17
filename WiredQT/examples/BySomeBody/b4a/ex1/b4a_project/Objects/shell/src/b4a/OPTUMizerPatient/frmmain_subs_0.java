package b4a.OPTUMizerPatient;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class frmmain_subs_0 {


public static RemoteObject  _addtoparent(RemoteObject __ref,RemoteObject _parent,RemoteObject _left,RemoteObject _top,RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("AddToParent (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,27);
if (RapidSub.canDelegate("addtoparent")) { return __ref.runUserSub(false, "frmmain","addtoparent", __ref, _parent, _left, _top, _width, _height);}
Debug.locals.put("Parent", _parent);
Debug.locals.put("Left", _left);
Debug.locals.put("Top", _top);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 27;BA.debugLine="Public Sub AddToParent(Parent As Activity, Left As";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 28;BA.debugLine="mBase.Initialize(\"mBase\")";
Debug.ShouldStop(134217728);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("mBase")));
 BA.debugLineNum = 29;BA.debugLine="Parent.AddView(mBase, Left, Top, Width, Height)";
Debug.ShouldStop(268435456);
_parent.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_mbase" /*RemoteObject*/ ).getObject())),(Object)(_left),(Object)(_top),(Object)(_width),(Object)(_height));
 BA.debugLineNum = 30;BA.debugLine="GTKForms";
Debug.ShouldStop(536870912);
__ref.runClassMethod (b4a.OPTUMizerPatient.frmmain.class, "_gtkforms" /*RemoteObject*/ );
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 9;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Private mEventName As String 'ignore";
frmmain._meventname = RemoteObject.createImmutable("");__ref.setField("_meventname",frmmain._meventname);
 //BA.debugLineNum = 11;BA.debugLine="Private mCallBack As Object 'ignore";
frmmain._mcallback = RemoteObject.createNew ("Object");__ref.setField("_mcallback",frmmain._mcallback);
 //BA.debugLineNum = 12;BA.debugLine="Private mBase As Panel";
frmmain._mbase = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_mbase",frmmain._mbase);
 //BA.debugLineNum = 13;BA.debugLine="Private Const DefaultColorConstant As Int = -9848";
frmmain._defaultcolorconstant = BA.numberCast(int.class, -(double) (0 + 984833));__ref.setField("_defaultcolorconstant",frmmain._defaultcolorconstant);
 //BA.debugLineNum = 14;BA.debugLine="Dim QPushButton4 As Button";
frmmain._qpushbutton4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");__ref.setField("_qpushbutton4",frmmain._qpushbutton4);
 //BA.debugLineNum = 15;BA.debugLine="Dim QPushButton1 As Button";
frmmain._qpushbutton1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");__ref.setField("_qpushbutton1",frmmain._qpushbutton1);
 //BA.debugLineNum = 16;BA.debugLine="Dim QComboBox3 As Spinner";
frmmain._qcombobox3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");__ref.setField("_qcombobox3",frmmain._qcombobox3);
 //BA.debugLineNum = 17;BA.debugLine="Dim QFrame4 As ScrollView";
frmmain._qframe4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");__ref.setField("_qframe4",frmmain._qframe4);
 //BA.debugLineNum = 18;BA.debugLine="Dim QComboBox5 As Spinner";
frmmain._qcombobox5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");__ref.setField("_qcombobox5",frmmain._qcombobox5);
 //BA.debugLineNum = 19;BA.debugLine="Dim QLabel6 As Label";
frmmain._qlabel6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");__ref.setField("_qlabel6",frmmain._qlabel6);
 //BA.debugLineNum = 20;BA.debugLine="Dim DataGrid7 as Table";
frmmain._datagrid7 = RemoteObject.createNew ("b4a.OPTUMizerPatient.table");__ref.setField("_datagrid7",frmmain._datagrid7);
 //BA.debugLineNum = 21;BA.debugLine="Dim QSlider8 As SeekBar";
frmmain._qslider8 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SeekBarWrapper");__ref.setField("_qslider8",frmmain._qslider8);
 //BA.debugLineNum = 22;BA.debugLine="Dim Timer9 As Timer";
frmmain._timer9 = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");__ref.setField("_timer9",frmmain._timer9);
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _datagrid7_cellclick(RemoteObject __ref,RemoteObject _col,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("DataGrid7_CellClick (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,102);
if (RapidSub.canDelegate("datagrid7_cellclick")) { return __ref.runUserSub(false, "frmmain","datagrid7_cellclick", __ref, _col, _row);}
RemoteObject _val = RemoteObject.createImmutable("");
Debug.locals.put("Col", _col);
Debug.locals.put("Row", _row);
 BA.debugLineNum = 102;BA.debugLine="Sub DataGrid7_CellClick (Col As Int, Row As Int)";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="Log(\"CellClick: \" & Col & \" , \" & Row)";
Debug.ShouldStop(64);
frmmain.__c.runVoidMethod ("LogImpl","23473409",RemoteObject.concat(RemoteObject.createImmutable("CellClick: "),_col,RemoteObject.createImmutable(" , "),_row),0);
 BA.debugLineNum = 104;BA.debugLine="Dim val As String = DataGrid7.GetValue(Col, Row)";
Debug.ShouldStop(128);
_val = __ref.getField(false,"_datagrid7" /*RemoteObject*/ ).runClassMethod (b4a.OPTUMizerPatient.table.class, "_getvalue" /*RemoteObject*/ ,(Object)(_col),(Object)(_row));Debug.locals.put("val", _val);Debug.locals.put("val", _val);
 BA.debugLineNum = 105;BA.debugLine="ToastMessageShow(val,False)";
Debug.ShouldStop(256);
frmmain.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(_val)),(Object)(frmmain.__c.getField(true,"False")));
 BA.debugLineNum = 106;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _designercreateview(RemoteObject __ref,RemoteObject _base,RemoteObject _lbl,RemoteObject _props) throws Exception{
try {
		Debug.PushSubsStack("DesignerCreateView (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,53);
if (RapidSub.canDelegate("designercreateview")) { return __ref.runUserSub(false, "frmmain","designercreateview", __ref, _base, _lbl, _props);}
Debug.locals.put("Base", _base);
Debug.locals.put("Lbl", _lbl);
Debug.locals.put("Props", _props);
 BA.debugLineNum = 53;BA.debugLine="Public Sub DesignerCreateView (Base As Panel, Lbl";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="mBase = Base";
Debug.ShouldStop(2097152);
__ref.setField ("_mbase" /*RemoteObject*/ ,_base);
 BA.debugLineNum = 55;BA.debugLine="GTKForms";
Debug.ShouldStop(4194304);
__ref.runClassMethod (b4a.OPTUMizerPatient.frmmain.class, "_gtkforms" /*RemoteObject*/ );
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getbase(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GetBase (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,122);
if (RapidSub.canDelegate("getbase")) { return __ref.runUserSub(false, "frmmain","getbase", __ref);}
 BA.debugLineNum = 122;BA.debugLine="Public Sub GetBase As Panel";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 123;BA.debugLine="Return mBase";
Debug.ShouldStop(67108864);
if (true) return __ref.getField(false,"_mbase" /*RemoteObject*/ );
 BA.debugLineNum = 124;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getvisible(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("getVisible (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,112);
if (RapidSub.canDelegate("getvisible")) { return __ref.runUserSub(false, "frmmain","getvisible", __ref);}
 BA.debugLineNum = 112;BA.debugLine="Public Sub getVisible() As Boolean";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="Return mBase.Visible";
Debug.ShouldStop(65536);
if (true) return __ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getVisible");
 BA.debugLineNum = 114;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _gtkforms(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GTKForms (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,57);
if (RapidSub.canDelegate("gtkforms")) { return __ref.runUserSub(false, "frmmain","gtkforms", __ref);}
 BA.debugLineNum = 57;BA.debugLine="Public Sub GTKForms";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 58;BA.debugLine="mBase.Color=0x000000'transparent background";
Debug.ShouldStop(33554432);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runVoidMethod ("setColor",BA.numberCast(int.class, 0x000000));
 BA.debugLineNum = 59;BA.debugLine="mBase.Width=100%x";
Debug.ShouldStop(67108864);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"setWidth",frmmain.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),__ref.getField(false, "ba")));
 BA.debugLineNum = 60;BA.debugLine="mBase.height=100%y";
Debug.ShouldStop(134217728);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"setHeight",frmmain.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),__ref.getField(false, "ba")));
 BA.debugLineNum = 61;BA.debugLine="mBase.AddView(QPushButton4,0.05 * mBase.Width,0.0";
Debug.ShouldStop(268435456);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((__ref.getField(false,"_qpushbutton4" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.05),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.05),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.24),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.06),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))));
 BA.debugLineNum = 62;BA.debugLine="mBase.AddView(QPushButton1,0.31 * mBase.Width,0.0";
Debug.ShouldStop(536870912);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((__ref.getField(false,"_qpushbutton1" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.31),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.07),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.24),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.06),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))));
 BA.debugLineNum = 63;BA.debugLine="mBase.AddView(QComboBox3,0.37 * mBase.Width,0.17";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((__ref.getField(false,"_qcombobox3" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.37),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.17),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.39),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.11),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))));
 BA.debugLineNum = 64;BA.debugLine="QComboBox3.Color =  0x00ffffff";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_qcombobox3" /*RemoteObject*/ ).runVoidMethod ("setColor",BA.numberCast(int.class, 0x00ffffff));
 BA.debugLineNum = 65;BA.debugLine="QComboBox3.DropdownBackgroundColor =  0x00ffffff";
Debug.ShouldStop(1);
__ref.getField(false,"_qcombobox3" /*RemoteObject*/ ).runMethod(true,"setDropdownBackgroundColor",BA.numberCast(int.class, 0x00ffffff));
 BA.debugLineNum = 66;BA.debugLine="QComboBox3.DropdownTextColor =  0xff000000";
Debug.ShouldStop(2);
__ref.getField(false,"_qcombobox3" /*RemoteObject*/ ).runMethod(true,"setDropdownTextColor",BA.numberCast(int.class, 0xff000000));
 BA.debugLineNum = 67;BA.debugLine="QComboBox3.TextColor =  0xff000000";
Debug.ShouldStop(4);
__ref.getField(false,"_qcombobox3" /*RemoteObject*/ ).runMethod(true,"setTextColor",BA.numberCast(int.class, 0xff000000));
 BA.debugLineNum = 68;BA.debugLine="mBase.AddView(QFrame4,0.03 * mBase.Width,0.30 * m";
Debug.ShouldStop(8);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((__ref.getField(false,"_qframe4" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.03),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.30),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.76),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.27),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))));
 BA.debugLineNum = 69;BA.debugLine="QFrame4.Color =  0x00ffffff";
Debug.ShouldStop(16);
__ref.getField(false,"_qframe4" /*RemoteObject*/ ).runVoidMethod ("setColor",BA.numberCast(int.class, 0x00ffffff));
 BA.debugLineNum = 70;BA.debugLine="QFrame4.Panel.AddView(QComboBox5,0.16 * QFrame4.W";
Debug.ShouldStop(32);
__ref.getField(false,"_qframe4" /*RemoteObject*/ ).runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((__ref.getField(false,"_qcombobox5" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.16),__ref.getField(false,"_qframe4" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.51),__ref.getField(false,"_qframe4" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.26),__ref.getField(false,"_qframe4" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.27),__ref.getField(false,"_qframe4" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))));
 BA.debugLineNum = 71;BA.debugLine="QComboBox5.Color =  0x00ffffff";
Debug.ShouldStop(64);
__ref.getField(false,"_qcombobox5" /*RemoteObject*/ ).runVoidMethod ("setColor",BA.numberCast(int.class, 0x00ffffff));
 BA.debugLineNum = 72;BA.debugLine="QComboBox5.DropdownBackgroundColor =  0x00ffffff";
Debug.ShouldStop(128);
__ref.getField(false,"_qcombobox5" /*RemoteObject*/ ).runMethod(true,"setDropdownBackgroundColor",BA.numberCast(int.class, 0x00ffffff));
 BA.debugLineNum = 73;BA.debugLine="QComboBox5.DropdownTextColor =  0xff000000";
Debug.ShouldStop(256);
__ref.getField(false,"_qcombobox5" /*RemoteObject*/ ).runMethod(true,"setDropdownTextColor",BA.numberCast(int.class, 0xff000000));
 BA.debugLineNum = 74;BA.debugLine="QComboBox5.TextColor =  0xff000000";
Debug.ShouldStop(512);
__ref.getField(false,"_qcombobox5" /*RemoteObject*/ ).runMethod(true,"setTextColor",BA.numberCast(int.class, 0xff000000));
 BA.debugLineNum = 75;BA.debugLine="QLabel6.Color =  0x00ffffff";
Debug.ShouldStop(1024);
__ref.getField(false,"_qlabel6" /*RemoteObject*/ ).runVoidMethod ("setColor",BA.numberCast(int.class, 0x00ffffff));
 BA.debugLineNum = 76;BA.debugLine="QLabel6.TextColor = 0xff000000";
Debug.ShouldStop(2048);
__ref.getField(false,"_qlabel6" /*RemoteObject*/ ).runMethod(true,"setTextColor",BA.numberCast(int.class, 0xff000000));
 BA.debugLineNum = 77;BA.debugLine="QLabel6.Gravity = Gravity.CENTER_HORIZONTAL+Gravi";
Debug.ShouldStop(4096);
__ref.getField(false,"_qlabel6" /*RemoteObject*/ ).runMethod(true,"setGravity",RemoteObject.solve(new RemoteObject[] {frmmain.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"),frmmain.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL")}, "+",1, 1));
 BA.debugLineNum = 78;BA.debugLine="QLabel6.Text = \"QLabel6\"";
Debug.ShouldStop(8192);
__ref.getField(false,"_qlabel6" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence("QLabel6"));
 BA.debugLineNum = 79;BA.debugLine="QFrame4.Panel.AddView(QLabel6,0.50 * QFrame4.Widt";
Debug.ShouldStop(16384);
__ref.getField(false,"_qframe4" /*RemoteObject*/ ).runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((__ref.getField(false,"_qlabel6" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.50),__ref.getField(false,"_qframe4" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.53),__ref.getField(false,"_qframe4" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.32),__ref.getField(false,"_qframe4" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.27),__ref.getField(false,"_qframe4" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))));
 BA.debugLineNum = 80;BA.debugLine="DataGrid7.AddToParent(mBase,0.03 * mBase.Width,0.";
Debug.ShouldStop(32768);
__ref.getField(false,"_datagrid7" /*RemoteObject*/ ).runClassMethod (b4a.OPTUMizerPatient.table.class, "_addtoparent" /*RemoteObject*/ ,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ActivityWrapper"), __ref.getField(false,"_mbase" /*RemoteObject*/ ).getObject()),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.03),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.60),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.76),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.24),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))));
 BA.debugLineNum = 83;BA.debugLine="mBase.AddView(QSlider8,0.31 * mBase.Width,0.82 *";
Debug.ShouldStop(262144);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((__ref.getField(false,"_qslider8" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.31),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.82),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.60),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth")}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.08),__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "*",0, 0))));
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _callback,RemoteObject _eventname) throws Exception{
try {
		Debug.PushSubsStack("Initialize (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,32);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "frmmain","initialize", __ref, _ba, _callback, _eventname);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("Callback", _callback);
Debug.locals.put("EventName", _eventname);
 BA.debugLineNum = 32;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="mEventName = EventName";
Debug.ShouldStop(1);
__ref.setField ("_meventname" /*RemoteObject*/ ,_eventname);
 BA.debugLineNum = 34;BA.debugLine="mCallBack = Callback";
Debug.ShouldStop(2);
__ref.setField ("_mcallback" /*RemoteObject*/ ,_callback);
 BA.debugLineNum = 35;BA.debugLine="QPushButton4.Initialize(\"QPushButton4\")";
Debug.ShouldStop(4);
__ref.getField(false,"_qpushbutton4" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("QPushButton4")));
 BA.debugLineNum = 36;BA.debugLine="QPushButton1.Initialize(\"QPushButton1\")";
Debug.ShouldStop(8);
__ref.getField(false,"_qpushbutton1" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("QPushButton1")));
 BA.debugLineNum = 37;BA.debugLine="QComboBox3.Initialize(\"QComboBox3\")";
Debug.ShouldStop(16);
__ref.getField(false,"_qcombobox3" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("QComboBox3")));
 BA.debugLineNum = 38;BA.debugLine="QComboBox3.AddAll(Array As String(\"Sunday\", \"Mond";
Debug.ShouldStop(32);
__ref.getField(false,"_qcombobox3" /*RemoteObject*/ ).runVoidMethod ("AddAll",(Object)(frmmain.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.ObjectToString("Sunday"),RemoteObject.createImmutable("Monday")})))));
 BA.debugLineNum = 39;BA.debugLine="QFrame4.Initialize(27.01%y)'add QFrame4.Height=xx";
Debug.ShouldStop(64);
__ref.getField(false,"_qframe4" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(frmmain.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 27.01)),__ref.getField(false, "ba"))));
 BA.debugLineNum = 40;BA.debugLine="QComboBox5.Initialize(\"QComboBox5\")";
Debug.ShouldStop(128);
__ref.getField(false,"_qcombobox5" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("QComboBox5")));
 BA.debugLineNum = 41;BA.debugLine="QComboBox5.AddAll(Array As String(\"Sunday\", \"Mond";
Debug.ShouldStop(256);
__ref.getField(false,"_qcombobox5" /*RemoteObject*/ ).runVoidMethod ("AddAll",(Object)(frmmain.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.ObjectToString("Sunday"),RemoteObject.createImmutable("Monday")})))));
 BA.debugLineNum = 42;BA.debugLine="QLabel6.Initialize(\"QLabel6\")";
Debug.ShouldStop(512);
__ref.getField(false,"_qlabel6" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("QLabel6")));
 BA.debugLineNum = 43;BA.debugLine="DataGrid7.Initialize(Me,\"DataGrid7\",4)";
Debug.ShouldStop(1024);
__ref.getField(false,"_datagrid7" /*RemoteObject*/ ).runClassMethod (b4a.OPTUMizerPatient.table.class, "_initialize" /*RemoteObject*/ ,__ref.getField(false, "ba"),(Object)(__ref),(Object)(BA.ObjectToString("DataGrid7")),(Object)(BA.numberCast(int.class, 4)));
 BA.debugLineNum = 46;BA.debugLine="QSlider8.Initialize(\"QSlider8\")";
Debug.ShouldStop(8192);
__ref.getField(false,"_qslider8" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("QSlider8")));
 BA.debugLineNum = 47;BA.debugLine="QSlider8.Max = 100";
Debug.ShouldStop(16384);
__ref.getField(false,"_qslider8" /*RemoteObject*/ ).runMethod(true,"setMax",BA.numberCast(int.class, 100));
 BA.debugLineNum = 48;BA.debugLine="Timer9.Initialize(\"Timer9\",1000)";
Debug.ShouldStop(32768);
__ref.getField(false,"_timer9" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("Timer9")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 49;BA.debugLine="Timer9.Enabled = True";
Debug.ShouldStop(65536);
__ref.getField(false,"_timer9" /*RemoteObject*/ ).runMethod(true,"setEnabled",frmmain.__c.getField(true,"True"));
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _qcombobox3_itemclick(RemoteObject __ref,RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("QComboBox3_ItemClick (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,94);
if (RapidSub.canDelegate("qcombobox3_itemclick")) { return __ref.runUserSub(false, "frmmain","qcombobox3_itemclick", __ref, _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 94;BA.debugLine="Sub QComboBox3_ItemClick (Position As Int, Value A";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _qcombobox5_itemclick(RemoteObject __ref,RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("QComboBox5_ItemClick (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,98);
if (RapidSub.canDelegate("qcombobox5_itemclick")) { return __ref.runUserSub(false, "frmmain","qcombobox5_itemclick", __ref, _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 98;BA.debugLine="Sub QComboBox5_ItemClick (Position As Int, Value A";
Debug.ShouldStop(2);
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _qframe4_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("QFrame4_click (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,96);
if (RapidSub.canDelegate("qframe4_click")) { return __ref.runUserSub(false, "frmmain","qframe4_click", __ref);}
 BA.debugLineNum = 96;BA.debugLine="Sub QFrame4_click()";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _qlabel6_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("QLabel6_click (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,100);
if (RapidSub.canDelegate("qlabel6_click")) { return __ref.runUserSub(false, "frmmain","qlabel6_click", __ref);}
 BA.debugLineNum = 100;BA.debugLine="Sub QLabel6_click()";
Debug.ShouldStop(8);
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _qpushbutton1_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("QPushButton1_click (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,92);
if (RapidSub.canDelegate("qpushbutton1_click")) { return __ref.runUserSub(false, "frmmain","qpushbutton1_click", __ref);}
 BA.debugLineNum = 92;BA.debugLine="Sub QPushButton1_click()";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _qpushbutton4_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("QPushButton4_click (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,90);
if (RapidSub.canDelegate("qpushbutton4_click")) { return __ref.runUserSub(false, "frmmain","qpushbutton4_click", __ref);}
 BA.debugLineNum = 90;BA.debugLine="Sub QPushButton4_click()";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _qslider8_valuechanged(RemoteObject __ref,RemoteObject _value,RemoteObject _userchanged) throws Exception{
try {
		Debug.PushSubsStack("QSlider8_ValueChanged (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,107);
if (RapidSub.canDelegate("qslider8_valuechanged")) { return __ref.runUserSub(false, "frmmain","qslider8_valuechanged", __ref, _value, _userchanged);}
Debug.locals.put("Value", _value);
Debug.locals.put("UserChanged", _userchanged);
 BA.debugLineNum = 107;BA.debugLine="Sub QSlider8_ValueChanged (Value As Int, UserChang";
Debug.ShouldStop(1024);
 BA.debugLineNum = 108;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setlayout(RemoteObject __ref,RemoteObject _left,RemoteObject _top,RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("SetLayout (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,118);
if (RapidSub.canDelegate("setlayout")) { return __ref.runUserSub(false, "frmmain","setlayout", __ref, _left, _top, _width, _height);}
Debug.locals.put("Left", _left);
Debug.locals.put("Top", _top);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 118;BA.debugLine="Public Sub SetLayout(Left As Int,Top As Int,Width";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 119;BA.debugLine="mBase.SetLayout(Left,Top,Width,Height )";
Debug.ShouldStop(4194304);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runVoidMethod ("SetLayout",(Object)(_left),(Object)(_top),(Object)(_width),(Object)(_height));
 BA.debugLineNum = 120;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setvisible(RemoteObject __ref,RemoteObject _flag) throws Exception{
try {
		Debug.PushSubsStack("setVisible (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,115);
if (RapidSub.canDelegate("setvisible")) { return __ref.runUserSub(false, "frmmain","setvisible", __ref, _flag);}
Debug.locals.put("flag", _flag);
 BA.debugLineNum = 115;BA.debugLine="Public Sub setVisible(flag As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 116;BA.debugLine="mBase.Visible=flag";
Debug.ShouldStop(524288);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"setVisible",_flag);
 BA.debugLineNum = 117;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _timer9_tick(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Timer9_Tick (frmmain) ","frmmain",3,__ref.getField(false, "ba"),__ref,109);
if (RapidSub.canDelegate("timer9_tick")) { return __ref.runUserSub(false, "frmmain","timer9_tick", __ref);}
 BA.debugLineNum = 109;BA.debugLine="Sub Timer9_Tick()";
Debug.ShouldStop(4096);
 BA.debugLineNum = 110;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}