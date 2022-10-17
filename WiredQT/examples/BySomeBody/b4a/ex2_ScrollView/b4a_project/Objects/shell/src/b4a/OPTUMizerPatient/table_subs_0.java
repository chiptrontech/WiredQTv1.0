package b4a.OPTUMizerPatient;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class table_subs_0 {


public static RemoteObject  _addrow(RemoteObject __ref,RemoteObject _values) throws Exception{
try {
		Debug.PushSubsStack("AddRow (table) ","table",6,__ref.getField(false, "ba"),__ref,146);
if (RapidSub.canDelegate("addrow")) { return __ref.runUserSub(false, "table","addrow", __ref, _values);}
RemoteObject _lastrow = RemoteObject.createImmutable(0);
Debug.locals.put("Values", _values);
 BA.debugLineNum = 146;BA.debugLine="Public Sub AddRow(Values() As String)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 147;BA.debugLine="If Values.Length <> NumberOfColumns Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("!",_values.getField(true,"length"),BA.numberCast(double.class, __ref.getField(true,"_numberofcolumns" /*RemoteObject*/ )))) { 
 BA.debugLineNum = 148;BA.debugLine="Log(\"Wrong number of values.\")";
Debug.ShouldStop(524288);
table.__c.runVoidMethod ("LogImpl","15439490",RemoteObject.createImmutable("Wrong number of values."),0);
 BA.debugLineNum = 149;BA.debugLine="Return";
Debug.ShouldStop(1048576);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 151;BA.debugLine="Data.Add(Values)";
Debug.ShouldStop(4194304);
__ref.getField(false,"_data" /*RemoteObject*/ ).runVoidMethod ("Add",(Object)((_values)));
 BA.debugLineNum = 152;BA.debugLine="Dim lastRow As Int";
Debug.ShouldStop(8388608);
_lastrow = RemoteObject.createImmutable(0);Debug.locals.put("lastRow", _lastrow);
 BA.debugLineNum = 153;BA.debugLine="lastRow = Data.Size - 1";
Debug.ShouldStop(16777216);
_lastrow = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_data" /*RemoteObject*/ ).runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("lastRow", _lastrow);
 BA.debugLineNum = 154;BA.debugLine="If lastRow < (SV.ScrollPosition + SV.Height) / Ro";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("<",_lastrow,RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(true,"getScrollPosition"),__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "+",1, 1)),__ref.getField(true,"_rowheight" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "/+",1, 0))) { 
 BA.debugLineNum = 155;BA.debugLine="ShowRow(lastRow)";
Debug.ShouldStop(67108864);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_showrow" /*RemoteObject*/ ,(Object)(_lastrow));
 };
 BA.debugLineNum = 157;BA.debugLine="SV.Panel.Height = Data.Size * RowHeight";
Debug.ShouldStop(268435456);
__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(false,"getPanel").runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_data" /*RemoteObject*/ ).runMethod(true,"getSize"),__ref.getField(true,"_rowheight" /*RemoteObject*/ )}, "*",0, 1));
 BA.debugLineNum = 158;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addtoparent(RemoteObject __ref,RemoteObject _act,RemoteObject _left,RemoteObject _top,RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("AddToParent (table) ","table",6,__ref.getField(false, "ba"),__ref,132);
if (RapidSub.canDelegate("addtoparent")) { return __ref.runUserSub(false, "table","addtoparent", __ref, _act, _left, _top, _width, _height);}
Debug.locals.put("Act", _act);
Debug.locals.put("Left", _left);
Debug.locals.put("Top", _top);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 132;BA.debugLine="Public Sub AddToParent(Act As Activity, Left As In";
Debug.ShouldStop(8);
 BA.debugLineNum = 133;BA.debugLine="visible = True";
Debug.ShouldStop(16);
__ref.setField ("_visible" /*RemoteObject*/ ,table.__c.getField(true,"True"));
 BA.debugLineNum = 134;BA.debugLine="Header.Initialize(\"\")";
Debug.ShouldStop(32);
__ref.getField(false,"_header" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 135;BA.debugLine="Header.Color = TableColor";
Debug.ShouldStop(64);
__ref.getField(false,"_header" /*RemoteObject*/ ).runVoidMethod ("setColor",__ref.getField(true,"_tablecolor" /*RemoteObject*/ ));
 BA.debugLineNum = 136;BA.debugLine="Act.AddView(Header, Left, Top , Width, RowHeight)";
Debug.ShouldStop(128);
_act.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_header" /*RemoteObject*/ ).getObject())),(Object)(_left),(Object)(_top),(Object)(_width),(Object)(__ref.getField(true,"_rowheight" /*RemoteObject*/ )));
 BA.debugLineNum = 137;BA.debugLine="Act.AddView(SV, Left, Top + RowHeight, Width, Hei";
Debug.ShouldStop(256);
_act.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_sv" /*RemoteObject*/ ).getObject())),(Object)(_left),(Object)(RemoteObject.solve(new RemoteObject[] {_top,__ref.getField(true,"_rowheight" /*RemoteObject*/ )}, "+",1, 1)),(Object)(_width),(Object)(RemoteObject.solve(new RemoteObject[] {_height,__ref.getField(true,"_rowheight" /*RemoteObject*/ )}, "-",1, 1)));
 BA.debugLineNum = 138;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
Debug.ShouldStop(512);
__ref.setField ("_columnwidth" /*RemoteObject*/ ,BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(true,"getWidth"),__ref.getField(true,"_numberofcolumns" /*RemoteObject*/ )}, "/",0, 0)));
 BA.debugLineNum = 140;BA.debugLine="SV_ScrollChanged(0)";
Debug.ShouldStop(2048);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_sv_scrollchanged" /*RemoteObject*/ ,(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cell_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Cell_Click (table) ","table",6,__ref.getField(false, "ba"),__ref,254);
if (RapidSub.canDelegate("cell_click")) { return __ref.runUserSub(false, "table","cell_click", __ref);}
RemoteObject _rc = RemoteObject.declareNull("b4a.OPTUMizerPatient.table._rowcol");
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 254;BA.debugLine="Private Sub Cell_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 255;BA.debugLine="Dim rc As RowCol";
Debug.ShouldStop(1073741824);
_rc = RemoteObject.createNew ("b4a.OPTUMizerPatient.table._rowcol");Debug.locals.put("rc", _rc);
 BA.debugLineNum = 256;BA.debugLine="Dim l As Label";
Debug.ShouldStop(-2147483648);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 257;BA.debugLine="l = Sender";
Debug.ShouldStop(1);
_l.setObject(table.__c.runMethod(false,"Sender",__ref.getField(false, "ba")));
 BA.debugLineNum = 258;BA.debugLine="rc = l.Tag";
Debug.ShouldStop(2);
_rc = (_l.runMethod(false,"getTag"));Debug.locals.put("rc", _rc);
 BA.debugLineNum = 259;BA.debugLine="SelectRow(rc.Row)";
Debug.ShouldStop(4);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_selectrow" /*RemoteObject*/ ,(Object)(_rc.getField(true,"Row" /*RemoteObject*/ )));
 BA.debugLineNum = 260;BA.debugLine="If SubExists(Callback, Event & \"_CellClick\") Then";
Debug.ShouldStop(8);
if (table.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_callback" /*RemoteObject*/ )),(Object)(RemoteObject.concat(__ref.getField(true,"_event" /*RemoteObject*/ ),RemoteObject.createImmutable("_CellClick")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 261;BA.debugLine="CallSub3(Callback, Event & \"_CellClick\", rc.Col,";
Debug.ShouldStop(16);
table.__c.runMethodAndSync(false,"CallSubNew3",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_callback" /*RemoteObject*/ )),(Object)(RemoteObject.concat(__ref.getField(true,"_event" /*RemoteObject*/ ),RemoteObject.createImmutable("_CellClick"))),(Object)((_rc.getField(true,"Col" /*RemoteObject*/ ))),(Object)((_rc.getField(true,"Row" /*RemoteObject*/ ))));
 };
 BA.debugLineNum = 263;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private StringUtils1 As StringUtils";
table._stringutils1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.StringUtils");__ref.setField("_stringutils1",table._stringutils1);
 //BA.debugLineNum = 4;BA.debugLine="Private SV As ScrollView";
table._sv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");__ref.setField("_sv",table._sv);
 //BA.debugLineNum = 5;BA.debugLine="Private Header As Panel";
table._header = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_header",table._header);
 //BA.debugLineNum = 6;BA.debugLine="Private Callback As Object";
table._callback = RemoteObject.createNew ("Object");__ref.setField("_callback",table._callback);
 //BA.debugLineNum = 7;BA.debugLine="Private Event As String";
table._event = RemoteObject.createImmutable("");__ref.setField("_event",table._event);
 //BA.debugLineNum = 8;BA.debugLine="Private SelectedRow As Int";
table._selectedrow = RemoteObject.createImmutable(0);__ref.setField("_selectedrow",table._selectedrow);
 //BA.debugLineNum = 9;BA.debugLine="Private Data As List";
table._data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");__ref.setField("_data",table._data);
 //BA.debugLineNum = 10;BA.debugLine="Private LabelsCache As List";
table._labelscache = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");__ref.setField("_labelscache",table._labelscache);
 //BA.debugLineNum = 11;BA.debugLine="Private minVisibleRow, maxVisibleRow As Int";
table._minvisiblerow = RemoteObject.createImmutable(0);__ref.setField("_minvisiblerow",table._minvisiblerow);
table._maxvisiblerow = RemoteObject.createImmutable(0);__ref.setField("_maxvisiblerow",table._maxvisiblerow);
 //BA.debugLineNum = 12;BA.debugLine="Private visible As Boolean";
table._visible = RemoteObject.createImmutable(false);__ref.setField("_visible",table._visible);
 //BA.debugLineNum = 13;BA.debugLine="Private visibleRows As Map";
table._visiblerows = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");__ref.setField("_visiblerows",table._visiblerows);
 //BA.debugLineNum = 14;BA.debugLine="Private NumberOfColumns, ColumnWidth As Int";
table._numberofcolumns = RemoteObject.createImmutable(0);__ref.setField("_numberofcolumns",table._numberofcolumns);
table._columnwidth = RemoteObject.createImmutable(0);__ref.setField("_columnwidth",table._columnwidth);
 //BA.debugLineNum = 15;BA.debugLine="Public RowHeight, HeaderColor, TableColor, FontCo";
table._rowheight = RemoteObject.createImmutable(0);__ref.setField("_rowheight",table._rowheight);
table._headercolor = RemoteObject.createImmutable(0);__ref.setField("_headercolor",table._headercolor);
table._tablecolor = RemoteObject.createImmutable(0);__ref.setField("_tablecolor",table._tablecolor);
table._fontcolor = RemoteObject.createImmutable(0);__ref.setField("_fontcolor",table._fontcolor);
table._headerfontcolor = RemoteObject.createImmutable(0);__ref.setField("_headerfontcolor",table._headerfontcolor);
 //BA.debugLineNum = 16;BA.debugLine="Public FontSize As Float";
table._fontsize = RemoteObject.createImmutable(0f);__ref.setField("_fontsize",table._fontsize);
 //BA.debugLineNum = 17;BA.debugLine="Type RowCol (Row As Int, Col As Int)";
;
 //BA.debugLineNum = 18;BA.debugLine="Public Alignment As Int";
table._alignment = RemoteObject.createImmutable(0);__ref.setField("_alignment",table._alignment);
 //BA.debugLineNum = 19;BA.debugLine="Public SelectedDrawable(), Drawable1(), Drawable2";
table._selecteddrawable = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});__ref.setField("_selecteddrawable",table._selecteddrawable);
table._drawable1 = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});__ref.setField("_drawable1",table._drawable1);
table._drawable2 = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});__ref.setField("_drawable2",table._drawable2);
 //BA.debugLineNum = 21;BA.debugLine="HeaderColor = Colors.Gray";
__ref.setField ("_headercolor" /*RemoteObject*/ ,table.__c.getField(false,"Colors").getField(true,"Gray"));
 //BA.debugLineNum = 22;BA.debugLine="RowHeight = 30dip";
__ref.setField ("_rowheight" /*RemoteObject*/ ,table.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 //BA.debugLineNum = 23;BA.debugLine="TableColor = Colors.LightGray";
__ref.setField ("_tablecolor" /*RemoteObject*/ ,table.__c.getField(false,"Colors").getField(true,"LightGray"));
 //BA.debugLineNum = 24;BA.debugLine="FontColor = Colors.Black";
__ref.setField ("_fontcolor" /*RemoteObject*/ ,table.__c.getField(false,"Colors").getField(true,"Black"));
 //BA.debugLineNum = 25;BA.debugLine="HeaderFontColor = Colors.White";
__ref.setField ("_headerfontcolor" /*RemoteObject*/ ,table.__c.getField(false,"Colors").getField(true,"White"));
 //BA.debugLineNum = 26;BA.debugLine="FontSize = 14";
__ref.setField ("_fontsize" /*RemoteObject*/ ,BA.numberCast(float.class, 14));
 //BA.debugLineNum = 27;BA.debugLine="Alignment = Gravity.CENTER 'change to Gravity.LEF";
__ref.setField ("_alignment" /*RemoteObject*/ ,table.__c.getField(false,"Gravity").getField(true,"CENTER"));
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _clearall(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("ClearAll (table) ","table",6,__ref.getField(false, "ba"),__ref,39);
if (RapidSub.canDelegate("clearall")) { return __ref.runUserSub(false, "table","clearall", __ref);}
 BA.debugLineNum = 39;BA.debugLine="Public Sub ClearAll";
Debug.ShouldStop(64);
 BA.debugLineNum = 40;BA.debugLine="innerClearAll(NumberOfColumns)";
Debug.ShouldStop(128);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_innerclearall" /*RemoteObject*/ ,(Object)(__ref.getField(true,"_numberofcolumns" /*RemoteObject*/ )));
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createnewlabels(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("CreateNewLabels (table) ","table",6,__ref.getField(false, "ba"),__ref,220);
if (RapidSub.canDelegate("createnewlabels")) { return __ref.runUserSub(false, "table","createnewlabels", __ref);}
RemoteObject _lbls = null;
int _i = 0;
RemoteObject _rc = RemoteObject.declareNull("b4a.OPTUMizerPatient.table._rowcol");
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 220;BA.debugLine="Private Sub CreateNewLabels As Label()";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 221;BA.debugLine="Dim lbls(NumberOfColumns) As Label";
Debug.ShouldStop(268435456);
_lbls = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {__ref.getField(true,"_numberofcolumns" /*RemoteObject*/ ).<Integer>get().intValue()}, new Object[]{});Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 222;BA.debugLine="For I = 0 To NumberOfColumns - 1";
Debug.ShouldStop(536870912);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_numberofcolumns" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 223;BA.debugLine="Dim rc As RowCol";
Debug.ShouldStop(1073741824);
_rc = RemoteObject.createNew ("b4a.OPTUMizerPatient.table._rowcol");Debug.locals.put("rc", _rc);
 BA.debugLineNum = 224;BA.debugLine="rc.Col = I";
Debug.ShouldStop(-2147483648);
_rc.setField ("Col" /*RemoteObject*/ ,BA.numberCast(int.class, _i));
 BA.debugLineNum = 225;BA.debugLine="Dim l As Label";
Debug.ShouldStop(1);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 226;BA.debugLine="l.Initialize(\"cell\")";
Debug.ShouldStop(2);
_l.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("cell")));
 BA.debugLineNum = 227;BA.debugLine="l.Gravity = Alignment";
Debug.ShouldStop(4);
_l.runMethod(true,"setGravity",__ref.getField(true,"_alignment" /*RemoteObject*/ ));
 BA.debugLineNum = 228;BA.debugLine="l.TextSize = FontSize";
Debug.ShouldStop(8);
_l.runMethod(true,"setTextSize",__ref.getField(true,"_fontsize" /*RemoteObject*/ ));
 BA.debugLineNum = 229;BA.debugLine="l.TextColor = FontColor";
Debug.ShouldStop(16);
_l.runMethod(true,"setTextColor",__ref.getField(true,"_fontcolor" /*RemoteObject*/ ));
 BA.debugLineNum = 230;BA.debugLine="l.Tag = rc";
Debug.ShouldStop(32);
_l.runMethod(false,"setTag",(_rc));
 BA.debugLineNum = 231;BA.debugLine="lbls(I) = l";
Debug.ShouldStop(64);
_lbls.setArrayElement (_l,BA.numberCast(int.class, _i));
 }
}Debug.locals.put("I", _i);
;
 BA.debugLineNum = 233;BA.debugLine="Return lbls";
Debug.ShouldStop(256);
if (true) return _lbls;
 BA.debugLineNum = 234;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getlabels(RemoteObject __ref,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("GetLabels (table) ","table",6,__ref.getField(false, "ba"),__ref,203);
if (RapidSub.canDelegate("getlabels")) { return __ref.runUserSub(false, "table","getlabels", __ref, _row);}
RemoteObject _lbls = null;
int _i = 0;
RemoteObject _rc = RemoteObject.declareNull("b4a.OPTUMizerPatient.table._rowcol");
Debug.locals.put("Row", _row);
 BA.debugLineNum = 203;BA.debugLine="Private Sub GetLabels(Row As Int) As Label()";
Debug.ShouldStop(1024);
 BA.debugLineNum = 204;BA.debugLine="Dim lbls() As Label";
Debug.ShouldStop(2048);
_lbls = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {0}, new Object[]{});Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 205;BA.debugLine="If LabelsCache.Size > 0 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean(">",__ref.getField(false,"_labelscache" /*RemoteObject*/ ).runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 207;BA.debugLine="lbls = LabelsCache.Get(LabelsCache.Size - 1)";
Debug.ShouldStop(16384);
_lbls = (__ref.getField(false,"_labelscache" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_labelscache" /*RemoteObject*/ ).runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1))));Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 208;BA.debugLine="LabelsCache.RemoveAt(LabelsCache.Size - 1)";
Debug.ShouldStop(32768);
__ref.getField(false,"_labelscache" /*RemoteObject*/ ).runVoidMethod ("RemoveAt",(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_labelscache" /*RemoteObject*/ ).runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1)));
 }else {
 BA.debugLineNum = 210;BA.debugLine="lbls = CreateNewLabels";
Debug.ShouldStop(131072);
_lbls = __ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_createnewlabels" /*RemoteObject*/ );Debug.locals.put("lbls", _lbls);
 };
 BA.debugLineNum = 212;BA.debugLine="For I = 0 To lbls.Length - 1";
Debug.ShouldStop(524288);
{
final int step8 = 1;
final int limit8 = RemoteObject.solve(new RemoteObject[] {_lbls.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step8 > 0 && _i <= limit8) || (step8 < 0 && _i >= limit8) ;_i = ((int)(0 + _i + step8))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 213;BA.debugLine="Dim rc As RowCol";
Debug.ShouldStop(1048576);
_rc = RemoteObject.createNew ("b4a.OPTUMizerPatient.table._rowcol");Debug.locals.put("rc", _rc);
 BA.debugLineNum = 214;BA.debugLine="rc = lbls(I).Tag";
Debug.ShouldStop(2097152);
_rc = (_lbls.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(false,"getTag"));Debug.locals.put("rc", _rc);
 BA.debugLineNum = 215;BA.debugLine="rc.Row = Row";
Debug.ShouldStop(4194304);
_rc.setField ("Row" /*RemoteObject*/ ,_row);
 }
}Debug.locals.put("I", _i);
;
 BA.debugLineNum = 217;BA.debugLine="Return lbls";
Debug.ShouldStop(16777216);
if (true) return _lbls;
 BA.debugLineNum = 218;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getvalue(RemoteObject __ref,RemoteObject _col,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("GetValue (table) ","table",6,__ref.getField(false, "ba"),__ref,276);
if (RapidSub.canDelegate("getvalue")) { return __ref.runUserSub(false, "table","getvalue", __ref, _col, _row);}
RemoteObject _values = null;
Debug.locals.put("Col", _col);
Debug.locals.put("Row", _row);
 BA.debugLineNum = 276;BA.debugLine="Public Sub GetValue(Col As Int, Row As Int)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 277;BA.debugLine="Dim values() As String";
Debug.ShouldStop(1048576);
_values = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("values", _values);
 BA.debugLineNum = 278;BA.debugLine="values = Data.Get(Row)";
Debug.ShouldStop(2097152);
_values = (__ref.getField(false,"_data" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(_row)));Debug.locals.put("values", _values);
 BA.debugLineNum = 279;BA.debugLine="Return values(Col)";
Debug.ShouldStop(4194304);
if (true) return _values.getArrayElement(true,_col);
 BA.debugLineNum = 280;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _header_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Header_Click (table) ","table",6,__ref.getField(false, "ba"),__ref,265);
if (RapidSub.canDelegate("header_click")) { return __ref.runUserSub(false, "table","header_click", __ref);}
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _col = RemoteObject.createImmutable(0);
 BA.debugLineNum = 265;BA.debugLine="Private Sub Header_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 266;BA.debugLine="Dim l As Label";
Debug.ShouldStop(512);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 267;BA.debugLine="Dim col As Int";
Debug.ShouldStop(1024);
_col = RemoteObject.createImmutable(0);Debug.locals.put("col", _col);
 BA.debugLineNum = 268;BA.debugLine="l = Sender";
Debug.ShouldStop(2048);
_l.setObject(table.__c.runMethod(false,"Sender",__ref.getField(false, "ba")));
 BA.debugLineNum = 269;BA.debugLine="col = l.Tag";
Debug.ShouldStop(4096);
_col = BA.numberCast(int.class, _l.runMethod(false,"getTag"));Debug.locals.put("col", _col);
 BA.debugLineNum = 270;BA.debugLine="If SubExists(Callback, Event & \"_HeaderClick\") Th";
Debug.ShouldStop(8192);
if (table.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_callback" /*RemoteObject*/ )),(Object)(RemoteObject.concat(__ref.getField(true,"_event" /*RemoteObject*/ ),RemoteObject.createImmutable("_HeaderClick")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 271;BA.debugLine="CallSub2(Callback, Event & \"_HeaderClick\", col)";
Debug.ShouldStop(16384);
table.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_callback" /*RemoteObject*/ )),(Object)(RemoteObject.concat(__ref.getField(true,"_event" /*RemoteObject*/ ),RemoteObject.createImmutable("_HeaderClick"))),(Object)((_col)));
 };
 BA.debugLineNum = 273;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _hiderow(RemoteObject __ref,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("HideRow (table) ","table",6,__ref.getField(false, "ba"),__ref,188);
if (RapidSub.canDelegate("hiderow")) { return __ref.runUserSub(false, "table","hiderow", __ref, _row);}
RemoteObject _lbls = null;
int _i = 0;
Debug.locals.put("Row", _row);
 BA.debugLineNum = 188;BA.debugLine="Private Sub HideRow (Row As Int)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 190;BA.debugLine="Dim lbls() As Label";
Debug.ShouldStop(536870912);
_lbls = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {0}, new Object[]{});Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 191;BA.debugLine="lbls = visibleRows.Get(Row)";
Debug.ShouldStop(1073741824);
_lbls = (__ref.getField(false,"_visiblerows" /*RemoteObject*/ ).runMethod(false,"Get",(Object)((_row))));Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 192;BA.debugLine="If lbls = Null Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("n",_lbls)) { 
 BA.debugLineNum = 193;BA.debugLine="Log(\"HideRow: (null) \" & Row)";
Debug.ShouldStop(1);
table.__c.runVoidMethod ("LogImpl","15636101",RemoteObject.concat(RemoteObject.createImmutable("HideRow: (null) "),_row),0);
 BA.debugLineNum = 194;BA.debugLine="Return";
Debug.ShouldStop(2);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 196;BA.debugLine="For I = 0 To lbls.Length - 1";
Debug.ShouldStop(8);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {_lbls.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 197;BA.debugLine="lbls(I).RemoveView";
Debug.ShouldStop(16);
_lbls.getArrayElement(false,BA.numberCast(int.class, _i)).runVoidMethod ("RemoveView");
 }
}Debug.locals.put("I", _i);
;
 BA.debugLineNum = 199;BA.debugLine="visibleRows.Remove(Row)";
Debug.ShouldStop(64);
__ref.getField(false,"_visiblerows" /*RemoteObject*/ ).runVoidMethod ("Remove",(Object)((_row)));
 BA.debugLineNum = 200;BA.debugLine="LabelsCache.Add(lbls)";
Debug.ShouldStop(128);
__ref.getField(false,"_labelscache" /*RemoteObject*/ ).runVoidMethod ("Add",(Object)((_lbls)));
 BA.debugLineNum = 201;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _callbackmodule,RemoteObject _eventname,RemoteObject _vnumberofcolumns) throws Exception{
try {
		Debug.PushSubsStack("Initialize (table) ","table",6,__ref.getField(false, "ba"),__ref,30);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "table","initialize", __ref, _ba, _callbackmodule, _eventname, _vnumberofcolumns);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("CallbackModule", _callbackmodule);
Debug.locals.put("EventName", _eventname);
Debug.locals.put("vNumberOfColumns", _vnumberofcolumns);
 BA.debugLineNum = 30;BA.debugLine="Public Sub Initialize (CallbackModule As Object, E";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 31;BA.debugLine="SV.Initialize2(0, \"SV\")";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_sv" /*RemoteObject*/ ).runVoidMethod ("Initialize2",__ref.getField(false, "ba"),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.createImmutable("SV")));
 BA.debugLineNum = 32;BA.debugLine="SV.Panel.Color = TableColor";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(false,"getPanel").runVoidMethod ("setColor",__ref.getField(true,"_tablecolor" /*RemoteObject*/ ));
 BA.debugLineNum = 33;BA.debugLine="Callback = CallbackModule";
Debug.ShouldStop(1);
__ref.setField ("_callback" /*RemoteObject*/ ,_callbackmodule);
 BA.debugLineNum = 34;BA.debugLine="Event = EventName";
Debug.ShouldStop(2);
__ref.setField ("_event" /*RemoteObject*/ ,_eventname);
 BA.debugLineNum = 35;BA.debugLine="innerClearAll(vNumberOfColumns)";
Debug.ShouldStop(4);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_innerclearall" /*RemoteObject*/ ,(Object)(_vnumberofcolumns));
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _innerclearall(RemoteObject __ref,RemoteObject _vnumberofcolumns) throws Exception{
try {
		Debug.PushSubsStack("innerClearAll (table) ","table",6,__ref.getField(false, "ba"),__ref,64);
if (RapidSub.canDelegate("innerclearall")) { return __ref.runUserSub(false, "table","innerclearall", __ref, _vnumberofcolumns);}
int _i = 0;
RemoteObject _cd1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _cd2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _cd3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
Debug.locals.put("vNumberOfColumns", _vnumberofcolumns);
 BA.debugLineNum = 64;BA.debugLine="public Sub innerClearAll(vNumberOfColumns As Int)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 65;BA.debugLine="For i = SV.Panel.NumberOfViews -1 To 0 Step -1";
Debug.ShouldStop(1);
{
final int step1 = -1;
final int limit1 = 0;
_i = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(false,"getPanel").runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1) ;_i = ((int)(0 + _i + step1))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 66;BA.debugLine="SV.Panel.RemoveViewAt(i)";
Debug.ShouldStop(2);
__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(false,"getPanel").runVoidMethod ("RemoveViewAt",(Object)(BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 68;BA.debugLine="NumberOfColumns = vNumberOfColumns";
Debug.ShouldStop(8);
__ref.setField ("_numberofcolumns" /*RemoteObject*/ ,_vnumberofcolumns);
 BA.debugLineNum = 69;BA.debugLine="Dim Drawable1(NumberOfColumns) As Object";
Debug.ShouldStop(16);
table._drawable1 = RemoteObject.createNewArray ("Object", new int[] {__ref.getField(true,"_numberofcolumns" /*RemoteObject*/ ).<Integer>get().intValue()}, new Object[]{});__ref.setField("_drawable1",table._drawable1);
 BA.debugLineNum = 70;BA.debugLine="Dim Drawable2(NumberOfColumns) As Object";
Debug.ShouldStop(32);
table._drawable2 = RemoteObject.createNewArray ("Object", new int[] {__ref.getField(true,"_numberofcolumns" /*RemoteObject*/ ).<Integer>get().intValue()}, new Object[]{});__ref.setField("_drawable2",table._drawable2);
 BA.debugLineNum = 71;BA.debugLine="Dim SelectedDrawable(NumberOfColumns) As Object";
Debug.ShouldStop(64);
table._selecteddrawable = RemoteObject.createNewArray ("Object", new int[] {__ref.getField(true,"_numberofcolumns" /*RemoteObject*/ ).<Integer>get().intValue()}, new Object[]{});__ref.setField("_selecteddrawable",table._selecteddrawable);
 BA.debugLineNum = 72;BA.debugLine="For i = 0 To NumberOfColumns - 1";
Debug.ShouldStop(128);
{
final int step8 = 1;
final int limit8 = RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_numberofcolumns" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step8 > 0 && _i <= limit8) || (step8 < 0 && _i >= limit8) ;_i = ((int)(0 + _i + step8))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 73;BA.debugLine="Dim cd1, cd2, cd3 As ColorDrawable";
Debug.ShouldStop(256);
_cd1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd1", _cd1);
_cd2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd2", _cd2);
_cd3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd3", _cd3);
 BA.debugLineNum = 74;BA.debugLine="cd1.Initialize(Colors.White, 0)";
Debug.ShouldStop(512);
_cd1.runVoidMethod ("Initialize",(Object)(table.__c.getField(false,"Colors").getField(true,"White")),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 75;BA.debugLine="cd2.Initialize(0xFF98F5FF, 0)";
Debug.ShouldStop(1024);
_cd2.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0xff98f5ff)),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 76;BA.debugLine="cd3.Initialize(0xFF007FFF, 0)";
Debug.ShouldStop(2048);
_cd3.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0xff007fff)),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 77;BA.debugLine="Drawable1(i) = cd1";
Debug.ShouldStop(4096);
__ref.getField(false,"_drawable1" /*RemoteObject*/ ).setArrayElement ((_cd1.getObject()),BA.numberCast(int.class, _i));
 BA.debugLineNum = 78;BA.debugLine="Drawable2(i) = cd2";
Debug.ShouldStop(8192);
__ref.getField(false,"_drawable2" /*RemoteObject*/ ).setArrayElement ((_cd2.getObject()),BA.numberCast(int.class, _i));
 BA.debugLineNum = 79;BA.debugLine="SelectedDrawable(i) = cd3";
Debug.ShouldStop(16384);
__ref.getField(false,"_selecteddrawable" /*RemoteObject*/ ).setArrayElement ((_cd3.getObject()),BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 81;BA.debugLine="SV.Panel.Height = 0";
Debug.ShouldStop(65536);
__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(false,"getPanel").runMethod(true,"setHeight",BA.numberCast(int.class, 0));
 BA.debugLineNum = 82;BA.debugLine="SelectedRow = -1";
Debug.ShouldStop(131072);
__ref.setField ("_selectedrow" /*RemoteObject*/ ,BA.numberCast(int.class, -(double) (0 + 1)));
 BA.debugLineNum = 83;BA.debugLine="minVisibleRow = -1";
Debug.ShouldStop(262144);
__ref.setField ("_minvisiblerow" /*RemoteObject*/ ,BA.numberCast(int.class, -(double) (0 + 1)));
 BA.debugLineNum = 84;BA.debugLine="maxVisibleRow = 0";
Debug.ShouldStop(524288);
__ref.setField ("_maxvisiblerow" /*RemoteObject*/ ,BA.numberCast(int.class, 0));
 BA.debugLineNum = 85;BA.debugLine="Data.Initialize";
Debug.ShouldStop(1048576);
__ref.getField(false,"_data" /*RemoteObject*/ ).runVoidMethod ("Initialize");
 BA.debugLineNum = 86;BA.debugLine="LabelsCache.Initialize";
Debug.ShouldStop(2097152);
__ref.getField(false,"_labelscache" /*RemoteObject*/ ).runVoidMethod ("Initialize");
 BA.debugLineNum = 87;BA.debugLine="visibleRows.Initialize";
Debug.ShouldStop(4194304);
__ref.getField(false,"_visiblerows" /*RemoteObject*/ ).runVoidMethod ("Initialize");
 BA.debugLineNum = 88;BA.debugLine="SV.ScrollPosition = 0";
Debug.ShouldStop(8388608);
__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(true,"setScrollPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 89;BA.debugLine="DoEvents";
Debug.ShouldStop(16777216);
table.__c.runVoidMethodAndSync ("DoEvents");
 BA.debugLineNum = 90;BA.debugLine="SV.ScrollPosition = 0";
Debug.ShouldStop(33554432);
__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(true,"setScrollPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 91;BA.debugLine="For i = 1 To 80 'fill the cache to avoid delay on";
Debug.ShouldStop(67108864);
{
final int step27 = 1;
final int limit27 = 80;
_i = 1 ;
for (;(step27 > 0 && _i <= limit27) || (step27 < 0 && _i >= limit27) ;_i = ((int)(0 + _i + step27))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 92;BA.debugLine="LabelsCache.Add(CreateNewLabels)";
Debug.ShouldStop(134217728);
__ref.getField(false,"_labelscache" /*RemoteObject*/ ).runVoidMethod ("Add",(Object)((__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_createnewlabels" /*RemoteObject*/ ))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 94;BA.debugLine="If visible Then";
Debug.ShouldStop(536870912);
if (__ref.getField(true,"_visible" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 95;BA.debugLine="SV_ScrollChanged(0)";
Debug.ShouldStop(1073741824);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_sv_scrollchanged" /*RemoteObject*/ ,(Object)(BA.numberCast(int.class, 0)));
 };
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
public static RemoteObject  _isrowvisible(RemoteObject __ref,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("IsRowVisible (table) ","table",6,__ref.getField(false, "ba"),__ref,183);
if (RapidSub.canDelegate("isrowvisible")) { return __ref.runUserSub(false, "table","isrowvisible", __ref, _row);}
Debug.locals.put("Row", _row);
 BA.debugLineNum = 183;BA.debugLine="Private Sub IsRowVisible(Row As Int) As Boolean";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 184;BA.debugLine="Return Row < (SV.ScrollPosition + SV.Height) / (R";
Debug.ShouldStop(8388608);
if (true) return BA.ObjectToBoolean(RemoteObject.solveBoolean("<",_row,RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(true,"getScrollPosition"),__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "+",1, 1)),(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_rowheight" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+",1, 1))}, "/",0, 0)) && RemoteObject.solveBoolean(">",_row,RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(true,"getScrollPosition"),__ref.getField(true,"_rowheight" /*RemoteObject*/ )}, "/",0, 0)));
 BA.debugLineNum = 186;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jumptorow(RemoteObject __ref,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("JumpToRow (table) ","table",6,__ref.getField(false, "ba"),__ref,314);
if (RapidSub.canDelegate("jumptorow")) { return __ref.runUserSub(false, "table","jumptorow", __ref, _row);}
Debug.locals.put("Row", _row);
 BA.debugLineNum = 314;BA.debugLine="Public Sub JumpToRow(Row As Int)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 315;BA.debugLine="SV.ScrollPosition = Row * RowHeight";
Debug.ShouldStop(67108864);
__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(true,"setScrollPosition",RemoteObject.solve(new RemoteObject[] {_row,__ref.getField(true,"_rowheight" /*RemoteObject*/ )}, "*",0, 1));
 BA.debugLineNum = 316;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadtablefromcsv(RemoteObject __ref,RemoteObject _dir,RemoteObject _filename,RemoteObject _headersexist) throws Exception{
try {
		Debug.PushSubsStack("LoadTableFromCSV (table) ","table",6,__ref.getField(false, "ba"),__ref,320);
if (RapidSub.canDelegate("loadtablefromcsv")) { return __ref.runUserSub(false, "table","loadtablefromcsv", __ref, _dir, _filename, _headersexist);}
RemoteObject _list1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _h = null;
RemoteObject _headers = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _firstrow = null;
RemoteObject _row = null;
Debug.locals.put("Dir", _dir);
Debug.locals.put("Filename", _filename);
Debug.locals.put("HeadersExist", _headersexist);
 BA.debugLineNum = 320;BA.debugLine="Public Sub LoadTableFromCSV(Dir As String, Filenam";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 322;BA.debugLine="Dim List1 As List";
Debug.ShouldStop(2);
_list1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("List1", _list1);
 BA.debugLineNum = 323;BA.debugLine="Dim h() As String";
Debug.ShouldStop(4);
_h = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("h", _h);
 BA.debugLineNum = 324;BA.debugLine="If HeadersExist Then";
Debug.ShouldStop(8);
if (_headersexist.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 325;BA.debugLine="Dim headers As List";
Debug.ShouldStop(16);
_headers = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("headers", _headers);
 BA.debugLineNum = 326;BA.debugLine="List1 = StringUtils1.LoadCSV2(Dir, Filename, \",\"";
Debug.ShouldStop(32);
_list1 = __ref.getField(false,"_stringutils1" /*RemoteObject*/ ).runMethod(false,"LoadCSV2",(Object)(_dir),(Object)(_filename),(Object)(BA.ObjectToChar(",")),(Object)(_headers));Debug.locals.put("List1", _list1);
 BA.debugLineNum = 327;BA.debugLine="Dim h(headers.Size) As String";
Debug.ShouldStop(64);
_h = RemoteObject.createNewArray ("String", new int[] {_headers.runMethod(true,"getSize").<Integer>get().intValue()}, new Object[]{});Debug.locals.put("h", _h);
 BA.debugLineNum = 328;BA.debugLine="For i = 0 To headers.Size - 1";
Debug.ShouldStop(128);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {_headers.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 329;BA.debugLine="h(i) = headers.Get(i)";
Debug.ShouldStop(256);
_h.setArrayElement (BA.ObjectToString(_headers.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))),BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 }else {
 BA.debugLineNum = 332;BA.debugLine="List1 = StringUtils1.LoadCSV(Dir, Filename, \",\")";
Debug.ShouldStop(2048);
_list1 = __ref.getField(false,"_stringutils1" /*RemoteObject*/ ).runMethod(false,"LoadCSV",(Object)(_dir),(Object)(_filename),(Object)(BA.ObjectToChar(RemoteObject.createImmutable(","))));Debug.locals.put("List1", _list1);
 BA.debugLineNum = 333;BA.debugLine="Dim firstRow() As String";
Debug.ShouldStop(4096);
_firstrow = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("firstRow", _firstrow);
 BA.debugLineNum = 334;BA.debugLine="firstRow = List1.Get(0)";
Debug.ShouldStop(8192);
_firstrow = (_list1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("firstRow", _firstrow);
 BA.debugLineNum = 335;BA.debugLine="Dim h(firstRow.Length)";
Debug.ShouldStop(16384);
_h = RemoteObject.createNewArray ("String", new int[] {_firstrow.getField(true,"length").<Integer>get().intValue()}, new Object[]{});Debug.locals.put("h", _h);
 BA.debugLineNum = 336;BA.debugLine="For i = 0 To firstRow.Length - 1";
Debug.ShouldStop(32768);
{
final int step15 = 1;
final int limit15 = RemoteObject.solve(new RemoteObject[] {_firstrow.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 337;BA.debugLine="h(i) = \"Col\" & (i + 1)";
Debug.ShouldStop(65536);
_h.setArrayElement (RemoteObject.concat(RemoteObject.createImmutable("Col"),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1))),BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 340;BA.debugLine="innerClearAll(h.Length)";
Debug.ShouldStop(524288);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_innerclearall" /*RemoteObject*/ ,(Object)(_h.getField(true,"length")));
 BA.debugLineNum = 341;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
Debug.ShouldStop(1048576);
__ref.setField ("_columnwidth" /*RemoteObject*/ ,BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(true,"getWidth"),__ref.getField(true,"_numberofcolumns" /*RemoteObject*/ )}, "/",0, 0)));
 BA.debugLineNum = 342;BA.debugLine="SetHeader(h)";
Debug.ShouldStop(2097152);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_setheader" /*RemoteObject*/ ,(Object)(_h));
 BA.debugLineNum = 343;BA.debugLine="For i = 0 To List1.Size - 1";
Debug.ShouldStop(4194304);
{
final int step22 = 1;
final int limit22 = RemoteObject.solve(new RemoteObject[] {_list1.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step22 > 0 && _i <= limit22) || (step22 < 0 && _i >= limit22) ;_i = ((int)(0 + _i + step22))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 344;BA.debugLine="Dim row() As String";
Debug.ShouldStop(8388608);
_row = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("row", _row);
 BA.debugLineNum = 345;BA.debugLine="row = List1.Get(i)";
Debug.ShouldStop(16777216);
_row = (_list1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("row", _row);
 BA.debugLineNum = 346;BA.debugLine="AddRow(row)";
Debug.ShouldStop(33554432);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_addrow" /*RemoteObject*/ ,(Object)(_row));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 348;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _savetabletocsv(RemoteObject __ref,RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("SaveTableToCSV (table) ","table",6,__ref.getField(false, "ba"),__ref,359);
if (RapidSub.canDelegate("savetabletocsv")) { return __ref.runUserSub(false, "table","savetabletocsv", __ref, _dir, _filename);}
RemoteObject _headers = null;
int _i = 0;
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("Dir", _dir);
Debug.locals.put("Filename", _filename);
 BA.debugLineNum = 359;BA.debugLine="Public Sub SaveTableToCSV(Dir As String, Filename";
Debug.ShouldStop(64);
 BA.debugLineNum = 360;BA.debugLine="Dim headers(NumberOfColumns) As String";
Debug.ShouldStop(128);
_headers = RemoteObject.createNewArray ("String", new int[] {__ref.getField(true,"_numberofcolumns" /*RemoteObject*/ ).<Integer>get().intValue()}, new Object[]{});Debug.locals.put("headers", _headers);
 BA.debugLineNum = 361;BA.debugLine="For i = 0 To headers.Length - 1";
Debug.ShouldStop(256);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {_headers.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 362;BA.debugLine="Dim l As Label";
Debug.ShouldStop(512);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 363;BA.debugLine="l = Header.GetView(i)";
Debug.ShouldStop(1024);
_l.setObject(__ref.getField(false,"_header" /*RemoteObject*/ ).runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i))).getObject());
 BA.debugLineNum = 364;BA.debugLine="headers(i) = l.Text";
Debug.ShouldStop(2048);
_headers.setArrayElement (_l.runMethod(true,"getText"),BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 366;BA.debugLine="StringUtils1.SaveCSV2(Dir, Filename, \",\", Data, h";
Debug.ShouldStop(8192);
__ref.getField(false,"_stringutils1" /*RemoteObject*/ ).runVoidMethod ("SaveCSV2",(Object)(_dir),(Object)(_filename),(Object)(BA.ObjectToChar(",")),(Object)(__ref.getField(false,"_data" /*RemoteObject*/ )),(Object)(table.__c.runMethod(false, "ArrayToList", (Object)(_headers))));
 BA.debugLineNum = 367;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _selectrow(RemoteObject __ref,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("SelectRow (table) ","table",6,__ref.getField(false, "ba"),__ref,293);
if (RapidSub.canDelegate("selectrow")) { return __ref.runUserSub(false, "table","selectrow", __ref, _row);}
RemoteObject _prev = RemoteObject.createImmutable(0);
int _col = 0;
Debug.locals.put("Row", _row);
 BA.debugLineNum = 293;BA.debugLine="Private Sub SelectRow(Row As Int)";
Debug.ShouldStop(16);
 BA.debugLineNum = 294;BA.debugLine="Dim prev As Int";
Debug.ShouldStop(32);
_prev = RemoteObject.createImmutable(0);Debug.locals.put("prev", _prev);
 BA.debugLineNum = 295;BA.debugLine="prev = SelectedRow";
Debug.ShouldStop(64);
_prev = __ref.getField(true,"_selectedrow" /*RemoteObject*/ );Debug.locals.put("prev", _prev);
 BA.debugLineNum = 296;BA.debugLine="SelectedRow = Row";
Debug.ShouldStop(128);
__ref.setField ("_selectedrow" /*RemoteObject*/ ,_row);
 BA.debugLineNum = 298;BA.debugLine="If prev > -1 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean(">",_prev,BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 299;BA.debugLine="If visibleRows.ContainsKey(prev) Then";
Debug.ShouldStop(1024);
if (__ref.getField(false,"_visiblerows" /*RemoteObject*/ ).runMethod(true,"ContainsKey",(Object)((_prev))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 300;BA.debugLine="HideRow(prev)";
Debug.ShouldStop(2048);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_hiderow" /*RemoteObject*/ ,(Object)(_prev));
 BA.debugLineNum = 301;BA.debugLine="ShowRow(prev)";
Debug.ShouldStop(4096);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_showrow" /*RemoteObject*/ ,(Object)(_prev));
 };
 };
 BA.debugLineNum = 304;BA.debugLine="SelectedRow = Row";
Debug.ShouldStop(32768);
__ref.setField ("_selectedrow" /*RemoteObject*/ ,_row);
 BA.debugLineNum = 305;BA.debugLine="For col = 0 To NumberOfColumns - 1";
Debug.ShouldStop(65536);
{
final int step11 = 1;
final int limit11 = RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_numberofcolumns" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_col = 0 ;
for (;(step11 > 0 && _col <= limit11) || (step11 < 0 && _col >= limit11) ;_col = ((int)(0 + _col + step11))  ) {
Debug.locals.put("col", _col);
 BA.debugLineNum = 306;BA.debugLine="If visibleRows.ContainsKey(SelectedRow) Then";
Debug.ShouldStop(131072);
if (__ref.getField(false,"_visiblerows" /*RemoteObject*/ ).runMethod(true,"ContainsKey",(Object)((__ref.getField(true,"_selectedrow" /*RemoteObject*/ )))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 307;BA.debugLine="HideRow(SelectedRow)";
Debug.ShouldStop(262144);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_hiderow" /*RemoteObject*/ ,(Object)(__ref.getField(true,"_selectedrow" /*RemoteObject*/ )));
 BA.debugLineNum = 308;BA.debugLine="ShowRow(SelectedRow)";
Debug.ShouldStop(524288);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_showrow" /*RemoteObject*/ ,(Object)(__ref.getField(true,"_selectedrow" /*RemoteObject*/ )));
 };
 }
}Debug.locals.put("col", _col);
;
 BA.debugLineNum = 311;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setcolumnswidths(RemoteObject __ref,RemoteObject _widths) throws Exception{
try {
		Debug.PushSubsStack("SetColumnsWidths (table) ","table",6,__ref.getField(false, "ba"),__ref,45);
if (RapidSub.canDelegate("setcolumnswidths")) { return __ref.runUserSub(false, "table","setcolumnswidths", __ref, _widths);}
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
int _i = 0;
RemoteObject _lbls = null;
int _lbl = 0;
Debug.locals.put("Widths", _widths);
 BA.debugLineNum = 45;BA.debugLine="Public Sub SetColumnsWidths(Widths() As Int)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="Dim v As View";
Debug.ShouldStop(8192);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");Debug.locals.put("v", _v);
 BA.debugLineNum = 47;BA.debugLine="For i = 0 To Widths.Length - 1";
Debug.ShouldStop(16384);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {_widths.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 48;BA.debugLine="v = Header.GetView(i)";
Debug.ShouldStop(32768);
_v = __ref.getField(false,"_header" /*RemoteObject*/ ).runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i)));Debug.locals.put("v", _v);
 BA.debugLineNum = 49;BA.debugLine="v.Width = Widths(i) - 1dip";
Debug.ShouldStop(65536);
_v.runMethod(true,"setWidth",RemoteObject.solve(new RemoteObject[] {_widths.getArrayElement(true,BA.numberCast(int.class, _i)),table.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "-",1, 1));
 BA.debugLineNum = 50;BA.debugLine="If i > 0 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 51;BA.debugLine="v.Left = Header.GetView(i-1).Left + Widths(i-1)";
Debug.ShouldStop(262144);
_v.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_header" /*RemoteObject*/ ).runMethod(false,"GetView",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "-",1, 1))).runMethod(true,"getLeft"),_widths.getArrayElement(true,RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "-",1, 1)),table.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "++",2, 1));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 54;BA.debugLine="Dim lbls() As Label";
Debug.ShouldStop(2097152);
_lbls = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {0}, new Object[]{});Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 55;BA.debugLine="For i = 0 To visibleRows.Size - 1";
Debug.ShouldStop(4194304);
{
final int step10 = 1;
final int limit10 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_visiblerows" /*RemoteObject*/ ).runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 56;BA.debugLine="lbls = visibleRows.GetValueAt(i)";
Debug.ShouldStop(8388608);
_lbls = (__ref.getField(false,"_visiblerows" /*RemoteObject*/ ).runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 57;BA.debugLine="For lbl = 0 To lbls.Length - 1";
Debug.ShouldStop(16777216);
{
final int step12 = 1;
final int limit12 = RemoteObject.solve(new RemoteObject[] {_lbls.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_lbl = 0 ;
for (;(step12 > 0 && _lbl <= limit12) || (step12 < 0 && _lbl >= limit12) ;_lbl = ((int)(0 + _lbl + step12))  ) {
Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 58;BA.debugLine="lbls(lbl).SetLayout(Header.GetView(lbl).Left, l";
Debug.ShouldStop(33554432);
_lbls.getArrayElement(false,BA.numberCast(int.class, _lbl)).runVoidMethod ("SetLayout",(Object)(__ref.getField(false,"_header" /*RemoteObject*/ ).runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _lbl))).runMethod(true,"getLeft")),(Object)(_lbls.getArrayElement(false,BA.numberCast(int.class, _lbl)).runMethod(true,"getTop")),(Object)(__ref.getField(false,"_header" /*RemoteObject*/ ).runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _lbl))).runMethod(true,"getWidth")),(Object)(__ref.getField(true,"_rowheight" /*RemoteObject*/ )));
 }
}Debug.locals.put("lbl", _lbl);
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setdatagrid(RemoteObject __ref,RemoteObject _headerx,RemoteObject _x) throws Exception{
try {
		Debug.PushSubsStack("SetDatagrid (table) ","table",6,__ref.getField(false, "ba"),__ref,349);
if (RapidSub.canDelegate("setdatagrid")) { return __ref.runUserSub(false, "table","setdatagrid", __ref, _headerx, _x);}
RemoteObject _a = RemoteObject.declareNull("Object");
Debug.locals.put("HeaderX", _headerx);
Debug.locals.put("x", _x);
 BA.debugLineNum = 349;BA.debugLine="public Sub SetDatagrid(HeaderX() As String,x As Li";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 351;BA.debugLine="innerClearAll(HeaderX.Length)";
Debug.ShouldStop(1073741824);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_innerclearall" /*RemoteObject*/ ,(Object)(_headerx.getField(true,"length")));
 BA.debugLineNum = 352;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
Debug.ShouldStop(-2147483648);
__ref.setField ("_columnwidth" /*RemoteObject*/ ,BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(true,"getWidth"),__ref.getField(true,"_numberofcolumns" /*RemoteObject*/ )}, "/",0, 0)));
 BA.debugLineNum = 353;BA.debugLine="SetHeader(HeaderX)";
Debug.ShouldStop(1);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_setheader" /*RemoteObject*/ ,(Object)(_headerx));
 BA.debugLineNum = 354;BA.debugLine="For Each a In x";
Debug.ShouldStop(2);
{
final RemoteObject group4 = _x;
final int groupLen4 = group4.runMethod(true,"getSize").<Integer>get()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_a = group4.runMethod(false,"Get",index4);Debug.locals.put("a", _a);
Debug.locals.put("a", _a);
 BA.debugLineNum = 355;BA.debugLine="AddRow(a)";
Debug.ShouldStop(4);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_addrow" /*RemoteObject*/ ,(Object)((_a)));
 }
}Debug.locals.put("a", _a);
;
 BA.debugLineNum = 357;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setheader(RemoteObject __ref,RemoteObject _values) throws Exception{
try {
		Debug.PushSubsStack("SetHeader (table) ","table",6,__ref.getField(false, "ba"),__ref,237);
if (RapidSub.canDelegate("setheader")) { return __ref.runUserSub(false, "table","setheader", __ref, _values);}
int _i = 0;
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("Values", _values);
 BA.debugLineNum = 237;BA.debugLine="Public Sub SetHeader(Values() As String)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 238;BA.debugLine="For I = Header.NumberOfViews - 1 To 0 Step -1";
Debug.ShouldStop(8192);
{
final int step1 = -1;
final int limit1 = 0;
_i = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_header" /*RemoteObject*/ ).runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1) ;_i = ((int)(0 + _i + step1))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 239;BA.debugLine="Header.RemoveViewAt(I)";
Debug.ShouldStop(16384);
__ref.getField(false,"_header" /*RemoteObject*/ ).runVoidMethod ("RemoveViewAt",(Object)(BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("I", _i);
;
 BA.debugLineNum = 241;BA.debugLine="For I = 0 To NumberOfColumns - 1";
Debug.ShouldStop(65536);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_numberofcolumns" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 242;BA.debugLine="Dim l As Label";
Debug.ShouldStop(131072);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 243;BA.debugLine="l.Initialize(\"header\")";
Debug.ShouldStop(262144);
_l.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("header")));
 BA.debugLineNum = 244;BA.debugLine="l.Gravity = Gravity.CENTER";
Debug.ShouldStop(524288);
_l.runMethod(true,"setGravity",table.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 245;BA.debugLine="l.TextSize = FontSize";
Debug.ShouldStop(1048576);
_l.runMethod(true,"setTextSize",__ref.getField(true,"_fontsize" /*RemoteObject*/ ));
 BA.debugLineNum = 246;BA.debugLine="l.Color = HeaderColor";
Debug.ShouldStop(2097152);
_l.runVoidMethod ("setColor",__ref.getField(true,"_headercolor" /*RemoteObject*/ ));
 BA.debugLineNum = 247;BA.debugLine="l.TextColor = HeaderFontColor";
Debug.ShouldStop(4194304);
_l.runMethod(true,"setTextColor",__ref.getField(true,"_headerfontcolor" /*RemoteObject*/ ));
 BA.debugLineNum = 248;BA.debugLine="l.Text = Values(I)";
Debug.ShouldStop(8388608);
_l.runMethod(true,"setText",BA.ObjectToCharSequence(_values.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 249;BA.debugLine="l.Tag = I";
Debug.ShouldStop(16777216);
_l.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 250;BA.debugLine="Header.AddView(l, ColumnWidth * I, 0, ColumnWidt";
Debug.ShouldStop(33554432);
__ref.getField(false,"_header" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((_l.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_columnwidth" /*RemoteObject*/ ),RemoteObject.createImmutable(_i)}, "*",0, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_columnwidth" /*RemoteObject*/ ),table.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "-",1, 1)),(Object)(__ref.getField(true,"_rowheight" /*RemoteObject*/ )));
 }
}Debug.locals.put("I", _i);
;
 BA.debugLineNum = 252;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setvalue(RemoteObject __ref,RemoteObject _col,RemoteObject _row,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("SetValue (table) ","table",6,__ref.getField(false, "ba"),__ref,282);
if (RapidSub.canDelegate("setvalue")) { return __ref.runUserSub(false, "table","setvalue", __ref, _col, _row, _value);}
RemoteObject _values = null;
RemoteObject _lbls = null;
Debug.locals.put("Col", _col);
Debug.locals.put("Row", _row);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 282;BA.debugLine="Public Sub SetValue(Col As Int, Row As Int, Value";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 283;BA.debugLine="Dim values() As String";
Debug.ShouldStop(67108864);
_values = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("values", _values);
 BA.debugLineNum = 284;BA.debugLine="values = Data.Get(Row)";
Debug.ShouldStop(134217728);
_values = (__ref.getField(false,"_data" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(_row)));Debug.locals.put("values", _values);
 BA.debugLineNum = 285;BA.debugLine="values(Col) = Value";
Debug.ShouldStop(268435456);
_values.setArrayElement (_value,_col);
 BA.debugLineNum = 286;BA.debugLine="If visibleRows.ContainsKey(Row) Then";
Debug.ShouldStop(536870912);
if (__ref.getField(false,"_visiblerows" /*RemoteObject*/ ).runMethod(true,"ContainsKey",(Object)((_row))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 287;BA.debugLine="Dim lbls() As Label";
Debug.ShouldStop(1073741824);
_lbls = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {0}, new Object[]{});Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 288;BA.debugLine="lbls = visibleRows.Get(Row)";
Debug.ShouldStop(-2147483648);
_lbls = (__ref.getField(false,"_visiblerows" /*RemoteObject*/ ).runMethod(false,"Get",(Object)((_row))));Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 289;BA.debugLine="lbls(Col).Text = Value";
Debug.ShouldStop(1);
_lbls.getArrayElement(false,_col).runMethod(true,"setText",BA.ObjectToCharSequence(_value));
 };
 BA.debugLineNum = 291;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _showrow(RemoteObject __ref,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("ShowRow (table) ","table",6,__ref.getField(false, "ba"),__ref,159);
if (RapidSub.canDelegate("showrow")) { return __ref.runUserSub(false, "table","showrow", __ref, _row);}
RemoteObject _lbls = null;
RemoteObject _values = null;
RemoteObject _rowcolor = null;
int _i = 0;
Debug.locals.put("row", _row);
 BA.debugLineNum = 159;BA.debugLine="Private Sub ShowRow(row As Int)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 160;BA.debugLine="If visibleRows.ContainsKey(row) Then Return";
Debug.ShouldStop(-2147483648);
if (__ref.getField(false,"_visiblerows" /*RemoteObject*/ ).runMethod(true,"ContainsKey",(Object)((_row))).<Boolean>get().booleanValue()) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 162;BA.debugLine="Dim lbls() As Label";
Debug.ShouldStop(2);
_lbls = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {0}, new Object[]{});Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 163;BA.debugLine="Dim values() As String";
Debug.ShouldStop(4);
_values = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("values", _values);
 BA.debugLineNum = 164;BA.debugLine="lbls = GetLabels(row)";
Debug.ShouldStop(8);
_lbls = __ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_getlabels" /*RemoteObject*/ ,(Object)(_row));Debug.locals.put("lbls", _lbls);
 BA.debugLineNum = 165;BA.debugLine="values = Data.Get(row)";
Debug.ShouldStop(16);
_values = (__ref.getField(false,"_data" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(_row)));Debug.locals.put("values", _values);
 BA.debugLineNum = 166;BA.debugLine="visibleRows.Put(row, lbls)";
Debug.ShouldStop(32);
__ref.getField(false,"_visiblerows" /*RemoteObject*/ ).runVoidMethod ("Put",(Object)((_row)),(Object)((_lbls)));
 BA.debugLineNum = 167;BA.debugLine="Dim rowColor() As Object";
Debug.ShouldStop(64);
_rowcolor = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});Debug.locals.put("rowColor", _rowcolor);
 BA.debugLineNum = 168;BA.debugLine="If row = SelectedRow Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_row,BA.numberCast(double.class, __ref.getField(true,"_selectedrow" /*RemoteObject*/ )))) { 
 BA.debugLineNum = 169;BA.debugLine="rowColor = SelectedDrawable";
Debug.ShouldStop(256);
_rowcolor = __ref.getField(false,"_selecteddrawable" /*RemoteObject*/ );Debug.locals.put("rowColor", _rowcolor);
 }else 
{ BA.debugLineNum = 170;BA.debugLine="Else If row Mod 2 = 0 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {_row,RemoteObject.createImmutable(2)}, "%",0, 1),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 171;BA.debugLine="rowColor = Drawable1";
Debug.ShouldStop(1024);
_rowcolor = __ref.getField(false,"_drawable1" /*RemoteObject*/ );Debug.locals.put("rowColor", _rowcolor);
 }else {
 BA.debugLineNum = 173;BA.debugLine="rowColor = Drawable2";
Debug.ShouldStop(4096);
_rowcolor = __ref.getField(false,"_drawable2" /*RemoteObject*/ );Debug.locals.put("rowColor", _rowcolor);
 }}
;
 BA.debugLineNum = 175;BA.debugLine="For I = 0 To lbls.Length - 1";
Debug.ShouldStop(16384);
{
final int step15 = 1;
final int limit15 = RemoteObject.solve(new RemoteObject[] {_lbls.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 176;BA.debugLine="SV.Panel.AddView(lbls(I), Header.GetView(I).Left";
Debug.ShouldStop(32768);
__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_lbls.getArrayElement(false,BA.numberCast(int.class, _i)).getObject())),(Object)(__ref.getField(false,"_header" /*RemoteObject*/ ).runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i))).runMethod(true,"getLeft")),(Object)(RemoteObject.solve(new RemoteObject[] {_row,__ref.getField(true,"_rowheight" /*RemoteObject*/ )}, "*",0, 1)),(Object)(__ref.getField(false,"_header" /*RemoteObject*/ ).runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i))).runMethod(true,"getWidth")),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_rowheight" /*RemoteObject*/ ),table.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "-",1, 1)));
 BA.debugLineNum = 178;BA.debugLine="lbls(I).Text = values(I)";
Debug.ShouldStop(131072);
_lbls.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setText",BA.ObjectToCharSequence(_values.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 179;BA.debugLine="lbls(I).Background = rowColor(I)";
Debug.ShouldStop(262144);
_lbls.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(false,"setBackground",(_rowcolor.getArrayElement(false,BA.numberCast(int.class, _i))));
 }
}Debug.locals.put("I", _i);
;
 BA.debugLineNum = 181;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sv_scrollchanged(RemoteObject __ref,RemoteObject _position) throws Exception{
try {
		Debug.PushSubsStack("SV_ScrollChanged (table) ","table",6,__ref.getField(false, "ba"),__ref,99);
if (RapidSub.canDelegate("sv_scrollchanged")) { return __ref.runUserSub(false, "table","sv_scrollchanged", __ref, _position);}
RemoteObject _currentmin = RemoteObject.createImmutable(0);
RemoteObject _currentmax = RemoteObject.createImmutable(0);
int _i = 0;
Debug.locals.put("Position", _position);
 BA.debugLineNum = 99;BA.debugLine="Private Sub SV_ScrollChanged(Position As Int)";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="Dim currentMin, currentMax As Int";
Debug.ShouldStop(8);
_currentmin = RemoteObject.createImmutable(0);Debug.locals.put("currentMin", _currentmin);
_currentmax = RemoteObject.createImmutable(0);Debug.locals.put("currentMax", _currentmax);
 BA.debugLineNum = 101;BA.debugLine="currentMin = Max(0, Position / RowHeight - 30)";
Debug.ShouldStop(16);
_currentmin = BA.numberCast(int.class, table.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_position,__ref.getField(true,"_rowheight" /*RemoteObject*/ ),RemoteObject.createImmutable(30)}, "/-",1, 0))));Debug.locals.put("currentMin", _currentmin);
 BA.debugLineNum = 102;BA.debugLine="currentMax = Min(Data.Size - 1, (Position + SV.He";
Debug.ShouldStop(32);
_currentmax = BA.numberCast(int.class, table.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_data" /*RemoteObject*/ ).runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1))),(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_position,__ref.getField(false,"_sv" /*RemoteObject*/ ).runMethod(true,"getHeight")}, "+",1, 1)),__ref.getField(true,"_rowheight" /*RemoteObject*/ ),RemoteObject.createImmutable(30)}, "/+",1, 0))));Debug.locals.put("currentMax", _currentmax);
 BA.debugLineNum = 103;BA.debugLine="If minVisibleRow > -1 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean(">",__ref.getField(true,"_minvisiblerow" /*RemoteObject*/ ),BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 104;BA.debugLine="If minVisibleRow < currentMin Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("<",__ref.getField(true,"_minvisiblerow" /*RemoteObject*/ ),BA.numberCast(double.class, _currentmin))) { 
 BA.debugLineNum = 106;BA.debugLine="For I = minVisibleRow To Min(currentMin - 1, ma";
Debug.ShouldStop(512);
{
final int step6 = 1;
final int limit6 = (int) (0 + table.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_currentmin,RemoteObject.createImmutable(1)}, "-",1, 1))),(Object)(BA.numberCast(double.class, __ref.getField(true,"_maxvisiblerow" /*RemoteObject*/ )))).<Double>get().doubleValue());
_i = __ref.getField(true,"_minvisiblerow" /*RemoteObject*/ ).<Integer>get().intValue() ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 107;BA.debugLine="HideRow(I)";
Debug.ShouldStop(1024);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_hiderow" /*RemoteObject*/ ,(Object)(BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("I", _i);
;
 }else 
{ BA.debugLineNum = 109;BA.debugLine="Else If minVisibleRow > currentMin Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean(">",__ref.getField(true,"_minvisiblerow" /*RemoteObject*/ ),BA.numberCast(double.class, _currentmin))) { 
 BA.debugLineNum = 111;BA.debugLine="For I = currentMin To Min(minVisibleRow - 1, cu";
Debug.ShouldStop(16384);
{
final int step10 = 1;
final int limit10 = (int) (0 + table.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_minvisiblerow" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 1))),(Object)(BA.numberCast(double.class, _currentmax))).<Double>get().doubleValue());
_i = _currentmin.<Integer>get().intValue() ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 112;BA.debugLine="ShowRow(I)";
Debug.ShouldStop(32768);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_showrow" /*RemoteObject*/ ,(Object)(BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("I", _i);
;
 }}
;
 BA.debugLineNum = 115;BA.debugLine="If maxVisibleRow > currentMax Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean(">",__ref.getField(true,"_maxvisiblerow" /*RemoteObject*/ ),BA.numberCast(double.class, _currentmax))) { 
 BA.debugLineNum = 117;BA.debugLine="For I = maxVisibleRow To Max(currentMax + 1, mi";
Debug.ShouldStop(1048576);
{
final int step15 = -1;
final int limit15 = (int) (0 + table.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_currentmax,RemoteObject.createImmutable(1)}, "+",1, 1))),(Object)(BA.numberCast(double.class, __ref.getField(true,"_minvisiblerow" /*RemoteObject*/ )))).<Double>get().doubleValue());
_i = __ref.getField(true,"_maxvisiblerow" /*RemoteObject*/ ).<Integer>get().intValue() ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 118;BA.debugLine="HideRow(I)";
Debug.ShouldStop(2097152);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_hiderow" /*RemoteObject*/ ,(Object)(BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("I", _i);
;
 }else 
{ BA.debugLineNum = 120;BA.debugLine="Else If maxVisibleRow < currentMax Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("<",__ref.getField(true,"_maxvisiblerow" /*RemoteObject*/ ),BA.numberCast(double.class, _currentmax))) { 
 BA.debugLineNum = 122;BA.debugLine="For I = currentMax To Max(maxVisibleRow + 1, cu";
Debug.ShouldStop(33554432);
{
final int step19 = -1;
final int limit19 = (int) (0 + table.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_maxvisiblerow" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+",1, 1))),(Object)(BA.numberCast(double.class, _currentmin))).<Double>get().doubleValue());
_i = _currentmax.<Integer>get().intValue() ;
for (;(step19 > 0 && _i <= limit19) || (step19 < 0 && _i >= limit19) ;_i = ((int)(0 + _i + step19))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 123;BA.debugLine="ShowRow(I)";
Debug.ShouldStop(67108864);
__ref.runClassMethod (b4a.OPTUMizerPatient.table.class, "_showrow" /*RemoteObject*/ ,(Object)(BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("I", _i);
;
 }}
;
 };
 BA.debugLineNum = 127;BA.debugLine="minVisibleRow = currentMin";
Debug.ShouldStop(1073741824);
__ref.setField ("_minvisiblerow" /*RemoteObject*/ ,_currentmin);
 BA.debugLineNum = 128;BA.debugLine="maxVisibleRow = currentMax";
Debug.ShouldStop(-2147483648);
__ref.setField ("_maxvisiblerow" /*RemoteObject*/ ,_currentmax);
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}