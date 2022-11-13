package b4a.OPTUMizerPatient;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class frmmain extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.OPTUMizerPatient.frmmain");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.OPTUMizerPatient.frmmain.class).invoke(this, new Object[] {null});
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
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.PanelWrapper _mbase = null;
public int _defaultcolorconstant = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _qpushbutton4 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _qpushbutton1 = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _qcombobox3 = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _qframe4 = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _qcombobox5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _qlabel6 = null;
public b4a.OPTUMizerPatient.table _datagrid7 = null;
public anywheresoftware.b4a.objects.SeekBarWrapper _qslider8 = null;
public anywheresoftware.b4a.objects.Timer _timer9 = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.OPTUMizerPatient.main _main = null;
public b4a.OPTUMizerPatient.starter _starter = null;
public b4a.OPTUMizerPatient.vb6 _vb6 = null;
public String  _setlayout(b4a.OPTUMizerPatient.frmmain __ref,int _left,int _top,int _width,int _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "setlayout", false))
	 {return ((String) Debug.delegate(ba, "setlayout", new Object[] {_left,_top,_width,_height}));}
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Public Sub SetLayout(Left As Int,Top As Int,Width";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="mBase.SetLayout(Left,Top,Width,Height )";
__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .SetLayout(_left,_top,_width,_height);
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="End Sub";
return "";
}
public String  _setvisible(b4a.OPTUMizerPatient.frmmain __ref,boolean _flag) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "setvisible", false))
	 {return ((String) Debug.delegate(ba, "setvisible", new Object[] {_flag}));}
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Public Sub setVisible(flag As Boolean)";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="mBase.Visible=flag";
__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .setVisible(_flag);
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="End Sub";
return "";
}
public String  _addtoparent(b4a.OPTUMizerPatient.frmmain __ref,anywheresoftware.b4a.objects.ActivityWrapper _parent,int _left,int _top,int _width,int _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "addtoparent", false))
	 {return ((String) Debug.delegate(ba, "addtoparent", new Object[] {_parent,_left,_top,_width,_height}));}
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Public Sub AddToParent(Parent As Activity, Left As";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="mBase.Initialize(\"mBase\")";
__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .Initialize(ba,"mBase");
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="Parent.AddView(mBase, Left, Top, Width, Height)";
_parent.AddView((android.view.View)(__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()),_left,_top,_width,_height);
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="GTKForms";
__ref._gtkforms /*String*/ (null);
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="End Sub";
return "";
}
public String  _gtkforms(b4a.OPTUMizerPatient.frmmain __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "gtkforms", false))
	 {return ((String) Debug.delegate(ba, "gtkforms", null));}
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Public Sub GTKForms";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="mBase.Color=0x000000'transparent background";
__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .setColor((int) (0x000000));
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="mBase.Width=100%x";
__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .setWidth(__c.PerXToCurrent((float) (100),ba));
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="mBase.height=100%y";
__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .setHeight(__c.PerYToCurrent((float) (100),ba));
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="mBase.AddView(QPushButton4,0.05 * mBase.Width,0.0";
__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .AddView((android.view.View)(__ref._qpushbutton4 /*anywheresoftware.b4a.objects.ButtonWrapper*/ .getObject()),(int) (0.05*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()),(int) (0.05*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()),(int) (0.24*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()),(int) (0.06*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()));
RDebugUtils.currentLine=3014661;
 //BA.debugLineNum = 3014661;BA.debugLine="mBase.AddView(QPushButton1,0.31 * mBase.Width,0.0";
__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .AddView((android.view.View)(__ref._qpushbutton1 /*anywheresoftware.b4a.objects.ButtonWrapper*/ .getObject()),(int) (0.31*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()),(int) (0.07*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()),(int) (0.24*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()),(int) (0.06*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()));
RDebugUtils.currentLine=3014662;
 //BA.debugLineNum = 3014662;BA.debugLine="mBase.AddView(QComboBox3,0.37 * mBase.Width,0.17";
__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .AddView((android.view.View)(__ref._qcombobox3 /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .getObject()),(int) (0.37*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()),(int) (0.17*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()),(int) (0.39*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()),(int) (0.11*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()));
RDebugUtils.currentLine=3014663;
 //BA.debugLineNum = 3014663;BA.debugLine="QComboBox3.Color =  0x00ffffff";
__ref._qcombobox3 /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .setColor((int) (0x00ffffff));
RDebugUtils.currentLine=3014664;
 //BA.debugLineNum = 3014664;BA.debugLine="QComboBox3.DropdownBackgroundColor =  0x00ffffff";
__ref._qcombobox3 /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .setDropdownBackgroundColor((int) (0x00ffffff));
RDebugUtils.currentLine=3014665;
 //BA.debugLineNum = 3014665;BA.debugLine="QComboBox3.DropdownTextColor =  0xff000000";
__ref._qcombobox3 /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .setDropdownTextColor((int) (0xff000000));
RDebugUtils.currentLine=3014666;
 //BA.debugLineNum = 3014666;BA.debugLine="QComboBox3.TextColor =  0xff000000";
__ref._qcombobox3 /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .setTextColor((int) (0xff000000));
RDebugUtils.currentLine=3014667;
 //BA.debugLineNum = 3014667;BA.debugLine="mBase.AddView(QFrame4,0.03 * mBase.Width,0.30 * m";
__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .AddView((android.view.View)(__ref._qframe4 /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getObject()),(int) (0.03*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()),(int) (0.30*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()),(int) (0.76*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()),(int) (0.27*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()));
RDebugUtils.currentLine=3014668;
 //BA.debugLineNum = 3014668;BA.debugLine="QFrame4.Color =  0x00ffffff";
__ref._qframe4 /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .setColor((int) (0x00ffffff));
RDebugUtils.currentLine=3014669;
 //BA.debugLineNum = 3014669;BA.debugLine="QFrame4.Panel.AddView(QComboBox5,0.16 * QFrame4.W";
__ref._qframe4 /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getPanel().AddView((android.view.View)(__ref._qcombobox5 /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .getObject()),(int) (0.16*__ref._qframe4 /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getWidth()),(int) (0.51*__ref._qframe4 /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getHeight()),(int) (0.26*__ref._qframe4 /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getWidth()),(int) (0.27*__ref._qframe4 /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getHeight()));
RDebugUtils.currentLine=3014670;
 //BA.debugLineNum = 3014670;BA.debugLine="QComboBox5.Color =  0x00ffffff";
__ref._qcombobox5 /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .setColor((int) (0x00ffffff));
RDebugUtils.currentLine=3014671;
 //BA.debugLineNum = 3014671;BA.debugLine="QComboBox5.DropdownBackgroundColor =  0x00ffffff";
__ref._qcombobox5 /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .setDropdownBackgroundColor((int) (0x00ffffff));
RDebugUtils.currentLine=3014672;
 //BA.debugLineNum = 3014672;BA.debugLine="QComboBox5.DropdownTextColor =  0xff000000";
__ref._qcombobox5 /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .setDropdownTextColor((int) (0xff000000));
RDebugUtils.currentLine=3014673;
 //BA.debugLineNum = 3014673;BA.debugLine="QComboBox5.TextColor =  0xff000000";
__ref._qcombobox5 /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .setTextColor((int) (0xff000000));
RDebugUtils.currentLine=3014674;
 //BA.debugLineNum = 3014674;BA.debugLine="QLabel6.Color =  0x00ffffff";
__ref._qlabel6 /*anywheresoftware.b4a.objects.LabelWrapper*/ .setColor((int) (0x00ffffff));
RDebugUtils.currentLine=3014675;
 //BA.debugLineNum = 3014675;BA.debugLine="QLabel6.TextColor = 0xff000000";
__ref._qlabel6 /*anywheresoftware.b4a.objects.LabelWrapper*/ .setTextColor((int) (0xff000000));
RDebugUtils.currentLine=3014676;
 //BA.debugLineNum = 3014676;BA.debugLine="QLabel6.Gravity = Gravity.CENTER_HORIZONTAL+Gravi";
__ref._qlabel6 /*anywheresoftware.b4a.objects.LabelWrapper*/ .setGravity((int) (__c.Gravity.CENTER_HORIZONTAL+__c.Gravity.CENTER_VERTICAL));
RDebugUtils.currentLine=3014677;
 //BA.debugLineNum = 3014677;BA.debugLine="QLabel6.Text = \"QLabel6\"";
__ref._qlabel6 /*anywheresoftware.b4a.objects.LabelWrapper*/ .setText(BA.ObjectToCharSequence("QLabel6"));
RDebugUtils.currentLine=3014678;
 //BA.debugLineNum = 3014678;BA.debugLine="QFrame4.Panel.AddView(QLabel6,0.50 * QFrame4.Widt";
__ref._qframe4 /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getPanel().AddView((android.view.View)(__ref._qlabel6 /*anywheresoftware.b4a.objects.LabelWrapper*/ .getObject()),(int) (0.50*__ref._qframe4 /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getWidth()),(int) (0.53*__ref._qframe4 /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getHeight()),(int) (0.32*__ref._qframe4 /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getWidth()),(int) (0.27*__ref._qframe4 /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getHeight()));
RDebugUtils.currentLine=3014679;
 //BA.debugLineNum = 3014679;BA.debugLine="DataGrid7.AddToParent(mBase,0.03 * mBase.Width,0.";
__ref._datagrid7 /*b4a.OPTUMizerPatient.table*/ ._addtoparent /*String*/ (null,(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject())),(int) (0.03*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()),(int) (0.60*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()),(int) (0.76*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()),(int) (0.24*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()));
RDebugUtils.currentLine=3014682;
 //BA.debugLineNum = 3014682;BA.debugLine="mBase.AddView(QSlider8,0.31 * mBase.Width,0.82 *";
__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .AddView((android.view.View)(__ref._qslider8 /*anywheresoftware.b4a.objects.SeekBarWrapper*/ .getObject()),(int) (0.31*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()),(int) (0.82*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()),(int) (0.60*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()),(int) (0.08*__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight()));
RDebugUtils.currentLine=3014684;
 //BA.debugLineNum = 3014684;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.OPTUMizerPatient.frmmain __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="Private mEventName As String 'ignore";
_meventname = "";
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="Private mCallBack As Object 'ignore";
_mcallback = new Object();
RDebugUtils.currentLine=2752515;
 //BA.debugLineNum = 2752515;BA.debugLine="Private mBase As Panel";
_mbase = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="Private Const DefaultColorConstant As Int = -9848";
_defaultcolorconstant = (int) (-984833);
RDebugUtils.currentLine=2752517;
 //BA.debugLineNum = 2752517;BA.debugLine="Dim QPushButton4 As Button";
_qpushbutton4 = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=2752518;
 //BA.debugLineNum = 2752518;BA.debugLine="Dim QPushButton1 As Button";
_qpushbutton1 = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=2752519;
 //BA.debugLineNum = 2752519;BA.debugLine="Dim QComboBox3 As Spinner";
_qcombobox3 = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=2752520;
 //BA.debugLineNum = 2752520;BA.debugLine="Dim QFrame4 As ScrollView";
_qframe4 = new anywheresoftware.b4a.objects.ScrollViewWrapper();
RDebugUtils.currentLine=2752521;
 //BA.debugLineNum = 2752521;BA.debugLine="Dim QComboBox5 As Spinner";
_qcombobox5 = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=2752522;
 //BA.debugLineNum = 2752522;BA.debugLine="Dim QLabel6 As Label";
_qlabel6 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2752523;
 //BA.debugLineNum = 2752523;BA.debugLine="Dim DataGrid7 as Table";
_datagrid7 = new b4a.OPTUMizerPatient.table();
RDebugUtils.currentLine=2752524;
 //BA.debugLineNum = 2752524;BA.debugLine="Dim QSlider8 As SeekBar";
_qslider8 = new anywheresoftware.b4a.objects.SeekBarWrapper();
RDebugUtils.currentLine=2752525;
 //BA.debugLineNum = 2752525;BA.debugLine="Dim Timer9 As Timer";
_timer9 = new anywheresoftware.b4a.objects.Timer();
RDebugUtils.currentLine=2752527;
 //BA.debugLineNum = 2752527;BA.debugLine="End Sub";
return "";
}
public String  _datagrid7_cellclick(b4a.OPTUMizerPatient.frmmain __ref,int _col,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "datagrid7_cellclick", false))
	 {return ((String) Debug.delegate(ba, "datagrid7_cellclick", new Object[] {_col,_row}));}
String _val = "";
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub DataGrid7_CellClick (Col As Int, Row As Int)";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="Log(\"CellClick: \" & Col & \" , \" & Row)";
__c.LogImpl("13473409","CellClick: "+BA.NumberToString(_col)+" , "+BA.NumberToString(_row),0);
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="Dim val As String = DataGrid7.GetValue(Col, Row)";
_val = __ref._datagrid7 /*b4a.OPTUMizerPatient.table*/ ._getvalue /*String*/ (null,_col,_row);
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="ToastMessageShow(val,False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_val),__c.False);
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(b4a.OPTUMizerPatient.frmmain __ref,anywheresoftware.b4a.objects.PanelWrapper _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "designercreateview", false))
	 {return ((String) Debug.delegate(ba, "designercreateview", new Object[] {_base,_lbl,_props}));}
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Public Sub DesignerCreateView (Base As Panel, Lbl";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="mBase = Base";
__ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/  = _base;
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="GTKForms";
__ref._gtkforms /*String*/ (null);
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.PanelWrapper  _getbase(b4a.OPTUMizerPatient.frmmain __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "getbase", false))
	 {return ((anywheresoftware.b4a.objects.PanelWrapper) Debug.delegate(ba, "getbase", null));}
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Public Sub GetBase As Panel";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="Return mBase";
if (true) return __ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ ;
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="End Sub";
return null;
}
public boolean  _getvisible(b4a.OPTUMizerPatient.frmmain __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "getvisible", false))
	 {return ((Boolean) Debug.delegate(ba, "getvisible", null));}
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Public Sub getVisible() As Boolean";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="Return mBase.Visible";
if (true) return __ref._mbase /*anywheresoftware.b4a.objects.PanelWrapper*/ .getVisible();
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="End Sub";
return false;
}
public String  _initialize(b4a.OPTUMizerPatient.frmmain __ref,anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_callback,_eventname}));}
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="mEventName = EventName";
__ref._meventname /*String*/  = _eventname;
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="mCallBack = Callback";
__ref._mcallback /*Object*/  = _callback;
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="QPushButton4.Initialize(\"QPushButton4\")";
__ref._qpushbutton4 /*anywheresoftware.b4a.objects.ButtonWrapper*/ .Initialize(ba,"QPushButton4");
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="QPushButton1.Initialize(\"QPushButton1\")";
__ref._qpushbutton1 /*anywheresoftware.b4a.objects.ButtonWrapper*/ .Initialize(ba,"QPushButton1");
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="QComboBox3.Initialize(\"QComboBox3\")";
__ref._qcombobox3 /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .Initialize(ba,"QComboBox3");
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="QComboBox3.AddAll(Array As String(\"Sunday\", \"Mond";
__ref._qcombobox3 /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Sunday","Monday"}));
RDebugUtils.currentLine=2883591;
 //BA.debugLineNum = 2883591;BA.debugLine="QFrame4.Initialize(27.01%y)'add QFrame4.Height=xx";
__ref._qframe4 /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .Initialize(ba,__c.PerYToCurrent((float) (27.01),ba));
RDebugUtils.currentLine=2883592;
 //BA.debugLineNum = 2883592;BA.debugLine="QComboBox5.Initialize(\"QComboBox5\")";
__ref._qcombobox5 /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .Initialize(ba,"QComboBox5");
RDebugUtils.currentLine=2883593;
 //BA.debugLineNum = 2883593;BA.debugLine="QComboBox5.AddAll(Array As String(\"Sunday\", \"Mond";
__ref._qcombobox5 /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Sunday","Monday"}));
RDebugUtils.currentLine=2883594;
 //BA.debugLineNum = 2883594;BA.debugLine="QLabel6.Initialize(\"QLabel6\")";
__ref._qlabel6 /*anywheresoftware.b4a.objects.LabelWrapper*/ .Initialize(ba,"QLabel6");
RDebugUtils.currentLine=2883595;
 //BA.debugLineNum = 2883595;BA.debugLine="DataGrid7.Initialize(Me,\"DataGrid7\",4)";
__ref._datagrid7 /*b4a.OPTUMizerPatient.table*/ ._initialize /*String*/ (null,ba,this,"DataGrid7",(int) (4));
RDebugUtils.currentLine=2883598;
 //BA.debugLineNum = 2883598;BA.debugLine="QSlider8.Initialize(\"QSlider8\")";
__ref._qslider8 /*anywheresoftware.b4a.objects.SeekBarWrapper*/ .Initialize(ba,"QSlider8");
RDebugUtils.currentLine=2883599;
 //BA.debugLineNum = 2883599;BA.debugLine="QSlider8.Max = 100";
__ref._qslider8 /*anywheresoftware.b4a.objects.SeekBarWrapper*/ .setMax((int) (100));
RDebugUtils.currentLine=2883600;
 //BA.debugLineNum = 2883600;BA.debugLine="Timer9.Initialize(\"Timer9\",1000)";
__ref._timer9 /*anywheresoftware.b4a.objects.Timer*/ .Initialize(ba,"Timer9",(long) (1000));
RDebugUtils.currentLine=2883601;
 //BA.debugLineNum = 2883601;BA.debugLine="Timer9.Enabled = True";
__ref._timer9 /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(__c.True);
RDebugUtils.currentLine=2883603;
 //BA.debugLineNum = 2883603;BA.debugLine="End Sub";
return "";
}
public String  _qcombobox3_itemclick(b4a.OPTUMizerPatient.frmmain __ref,int _position,Object _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "qcombobox3_itemclick", false))
	 {return ((String) Debug.delegate(ba, "qcombobox3_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub QComboBox3_ItemClick (Position As Int, Value A";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="End Sub";
return "";
}
public String  _qcombobox5_itemclick(b4a.OPTUMizerPatient.frmmain __ref,int _position,Object _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "qcombobox5_itemclick", false))
	 {return ((String) Debug.delegate(ba, "qcombobox5_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub QComboBox5_ItemClick (Position As Int, Value A";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="End Sub";
return "";
}
public String  _qframe4_click(b4a.OPTUMizerPatient.frmmain __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "qframe4_click", false))
	 {return ((String) Debug.delegate(ba, "qframe4_click", null));}
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub QFrame4_click()";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="End Sub";
return "";
}
public String  _qlabel6_click(b4a.OPTUMizerPatient.frmmain __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "qlabel6_click", false))
	 {return ((String) Debug.delegate(ba, "qlabel6_click", null));}
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub QLabel6_click()";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="End Sub";
return "";
}
public String  _qpushbutton1_click(b4a.OPTUMizerPatient.frmmain __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "qpushbutton1_click", false))
	 {return ((String) Debug.delegate(ba, "qpushbutton1_click", null));}
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub QPushButton1_click()";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="End Sub";
return "";
}
public String  _qpushbutton4_click(b4a.OPTUMizerPatient.frmmain __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "qpushbutton4_click", false))
	 {return ((String) Debug.delegate(ba, "qpushbutton4_click", null));}
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub QPushButton4_click()";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="End Sub";
return "";
}
public String  _qslider8_valuechanged(b4a.OPTUMizerPatient.frmmain __ref,int _value,boolean _userchanged) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "qslider8_valuechanged", false))
	 {return ((String) Debug.delegate(ba, "qslider8_valuechanged", new Object[] {_value,_userchanged}));}
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub QSlider8_ValueChanged (Value As Int, UserChang";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="End Sub";
return "";
}
public String  _timer9_tick(b4a.OPTUMizerPatient.frmmain __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="frmmain";
if (Debug.shouldDelegate(ba, "timer9_tick", false))
	 {return ((String) Debug.delegate(ba, "timer9_tick", null));}
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub Timer9_Tick()";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="End Sub";
return "";
}
}