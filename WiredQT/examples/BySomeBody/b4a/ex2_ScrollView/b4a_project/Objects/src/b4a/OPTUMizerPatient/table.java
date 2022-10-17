package b4a.OPTUMizerPatient;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class table extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.OPTUMizerPatient.table");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.OPTUMizerPatient.table.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public static class _rowcol{
public boolean IsInitialized;
public int Row;
public int Col;
public void Initialize() {
IsInitialized = true;
Row = 0;
Col = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.StringUtils _stringutils1 = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _sv = null;
public anywheresoftware.b4a.objects.PanelWrapper _header = null;
public Object _callback = null;
public String _event = "";
public int _selectedrow = 0;
public anywheresoftware.b4a.objects.collections.List _data = null;
public anywheresoftware.b4a.objects.collections.List _labelscache = null;
public int _minvisiblerow = 0;
public int _maxvisiblerow = 0;
public boolean _visible = false;
public anywheresoftware.b4a.objects.collections.Map _visiblerows = null;
public int _numberofcolumns = 0;
public int _columnwidth = 0;
public int _rowheight = 0;
public int _headercolor = 0;
public int _tablecolor = 0;
public int _fontcolor = 0;
public int _headerfontcolor = 0;
public float _fontsize = 0f;
public int _alignment = 0;
public Object[] _selecteddrawable = null;
public Object[] _drawable1 = null;
public Object[] _drawable2 = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.OPTUMizerPatient.main _main = null;
public b4a.OPTUMizerPatient.starter _starter = null;
public b4a.OPTUMizerPatient.vb6 _vb6 = null;
public String  _getvalue(b4a.OPTUMizerPatient.table __ref,int _col,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "getvalue", false))
	 {return ((String) Debug.delegate(ba, "getvalue", new Object[] {_col,_row}));}
String[] _values = null;
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Public Sub GetValue(Col As Int, Row As Int)";
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="Dim values() As String";
_values = new String[(int) (0)];
java.util.Arrays.fill(_values,"");
RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="values = Data.Get(Row)";
_values = (String[])(__ref._data /*anywheresoftware.b4a.objects.collections.List*/ .Get(_row));
RDebugUtils.currentLine=6029315;
 //BA.debugLineNum = 6029315;BA.debugLine="Return values(Col)";
if (true) return _values[_col];
RDebugUtils.currentLine=6029316;
 //BA.debugLineNum = 6029316;BA.debugLine="End Sub";
return "";
}
public String  _addtoparent(b4a.OPTUMizerPatient.table __ref,anywheresoftware.b4a.objects.ActivityWrapper _act,int _left,int _top,int _width,int _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "addtoparent", false))
	 {return ((String) Debug.delegate(ba, "addtoparent", new Object[] {_act,_left,_top,_width,_height}));}
RDebugUtils.currentLine=5373952;
 //BA.debugLineNum = 5373952;BA.debugLine="Public Sub AddToParent(Act As Activity, Left As In";
RDebugUtils.currentLine=5373953;
 //BA.debugLineNum = 5373953;BA.debugLine="visible = True";
__ref._visible /*boolean*/  = __c.True;
RDebugUtils.currentLine=5373954;
 //BA.debugLineNum = 5373954;BA.debugLine="Header.Initialize(\"\")";
__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .Initialize(ba,"");
RDebugUtils.currentLine=5373955;
 //BA.debugLineNum = 5373955;BA.debugLine="Header.Color = TableColor";
__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .setColor(__ref._tablecolor /*int*/ );
RDebugUtils.currentLine=5373956;
 //BA.debugLineNum = 5373956;BA.debugLine="Act.AddView(Header, Left, Top , Width, RowHeight)";
_act.AddView((android.view.View)(__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()),_left,_top,_width,__ref._rowheight /*int*/ );
RDebugUtils.currentLine=5373957;
 //BA.debugLineNum = 5373957;BA.debugLine="Act.AddView(SV, Left, Top + RowHeight, Width, Hei";
_act.AddView((android.view.View)(__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getObject()),_left,(int) (_top+__ref._rowheight /*int*/ ),_width,(int) (_height-__ref._rowheight /*int*/ ));
RDebugUtils.currentLine=5373958;
 //BA.debugLineNum = 5373958;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
__ref._columnwidth /*int*/  = (int) (__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getWidth()/(double)__ref._numberofcolumns /*int*/ );
RDebugUtils.currentLine=5373960;
 //BA.debugLineNum = 5373960;BA.debugLine="SV_ScrollChanged(0)";
__ref._sv_scrollchanged /*String*/ (null,(int) (0));
RDebugUtils.currentLine=5373962;
 //BA.debugLineNum = 5373962;BA.debugLine="End Sub";
return "";
}
public String  _initialize(b4a.OPTUMizerPatient.table __ref,anywheresoftware.b4a.BA _ba,Object _callbackmodule,String _eventname,int _vnumberofcolumns) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_callbackmodule,_eventname,_vnumberofcolumns}));}
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Public Sub Initialize (CallbackModule As Object, E";
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="SV.Initialize2(0, \"SV\")";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .Initialize2(ba,(int) (0),"SV");
RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="SV.Panel.Color = TableColor";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getPanel().setColor(__ref._tablecolor /*int*/ );
RDebugUtils.currentLine=5046275;
 //BA.debugLineNum = 5046275;BA.debugLine="Callback = CallbackModule";
__ref._callback /*Object*/  = _callbackmodule;
RDebugUtils.currentLine=5046276;
 //BA.debugLineNum = 5046276;BA.debugLine="Event = EventName";
__ref._event /*String*/  = _eventname;
RDebugUtils.currentLine=5046277;
 //BA.debugLineNum = 5046277;BA.debugLine="innerClearAll(vNumberOfColumns)";
__ref._innerclearall /*String*/ (null,_vnumberofcolumns);
RDebugUtils.currentLine=5046278;
 //BA.debugLineNum = 5046278;BA.debugLine="End Sub";
return "";
}
public String  _addrow(b4a.OPTUMizerPatient.table __ref,String[] _values) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "addrow", false))
	 {return ((String) Debug.delegate(ba, "addrow", new Object[] {_values}));}
int _lastrow = 0;
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Public Sub AddRow(Values() As String)";
RDebugUtils.currentLine=5439489;
 //BA.debugLineNum = 5439489;BA.debugLine="If Values.Length <> NumberOfColumns Then";
if (_values.length!=__ref._numberofcolumns /*int*/ ) { 
RDebugUtils.currentLine=5439490;
 //BA.debugLineNum = 5439490;BA.debugLine="Log(\"Wrong number of values.\")";
__c.LogImpl("15439490","Wrong number of values.",0);
RDebugUtils.currentLine=5439491;
 //BA.debugLineNum = 5439491;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=5439493;
 //BA.debugLineNum = 5439493;BA.debugLine="Data.Add(Values)";
__ref._data /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)(_values));
RDebugUtils.currentLine=5439494;
 //BA.debugLineNum = 5439494;BA.debugLine="Dim lastRow As Int";
_lastrow = 0;
RDebugUtils.currentLine=5439495;
 //BA.debugLineNum = 5439495;BA.debugLine="lastRow = Data.Size - 1";
_lastrow = (int) (__ref._data /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1);
RDebugUtils.currentLine=5439496;
 //BA.debugLineNum = 5439496;BA.debugLine="If lastRow < (SV.ScrollPosition + SV.Height) / Ro";
if (_lastrow<(__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getScrollPosition()+__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getHeight())/(double)__ref._rowheight /*int*/ +1) { 
RDebugUtils.currentLine=5439497;
 //BA.debugLineNum = 5439497;BA.debugLine="ShowRow(lastRow)";
__ref._showrow /*String*/ (null,_lastrow);
 };
RDebugUtils.currentLine=5439499;
 //BA.debugLineNum = 5439499;BA.debugLine="SV.Panel.Height = Data.Size * RowHeight";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getPanel().setHeight((int) (__ref._data /*anywheresoftware.b4a.objects.collections.List*/ .getSize()*__ref._rowheight /*int*/ ));
RDebugUtils.currentLine=5439500;
 //BA.debugLineNum = 5439500;BA.debugLine="End Sub";
return "";
}
public String  _showrow(b4a.OPTUMizerPatient.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "showrow", false))
	 {return ((String) Debug.delegate(ba, "showrow", new Object[] {_row}));}
anywheresoftware.b4a.objects.LabelWrapper[] _lbls = null;
String[] _values = null;
Object[] _rowcolor = null;
int _i = 0;
RDebugUtils.currentLine=5505024;
 //BA.debugLineNum = 5505024;BA.debugLine="Private Sub ShowRow(row As Int)";
RDebugUtils.currentLine=5505025;
 //BA.debugLineNum = 5505025;BA.debugLine="If visibleRows.ContainsKey(row) Then Return";
if (__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .ContainsKey((Object)(_row))) { 
if (true) return "";};
RDebugUtils.currentLine=5505027;
 //BA.debugLineNum = 5505027;BA.debugLine="Dim lbls() As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=5505028;
 //BA.debugLineNum = 5505028;BA.debugLine="Dim values() As String";
_values = new String[(int) (0)];
java.util.Arrays.fill(_values,"");
RDebugUtils.currentLine=5505029;
 //BA.debugLineNum = 5505029;BA.debugLine="lbls = GetLabels(row)";
_lbls = __ref._getlabels /*anywheresoftware.b4a.objects.LabelWrapper[]*/ (null,_row);
RDebugUtils.currentLine=5505030;
 //BA.debugLineNum = 5505030;BA.debugLine="values = Data.Get(row)";
_values = (String[])(__ref._data /*anywheresoftware.b4a.objects.collections.List*/ .Get(_row));
RDebugUtils.currentLine=5505031;
 //BA.debugLineNum = 5505031;BA.debugLine="visibleRows.Put(row, lbls)";
__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)(_row),(Object)(_lbls));
RDebugUtils.currentLine=5505032;
 //BA.debugLineNum = 5505032;BA.debugLine="Dim rowColor() As Object";
_rowcolor = new Object[(int) (0)];
{
int d0 = _rowcolor.length;
for (int i0 = 0;i0 < d0;i0++) {
_rowcolor[i0] = new Object();
}
}
;
RDebugUtils.currentLine=5505033;
 //BA.debugLineNum = 5505033;BA.debugLine="If row = SelectedRow Then";
if (_row==__ref._selectedrow /*int*/ ) { 
RDebugUtils.currentLine=5505034;
 //BA.debugLineNum = 5505034;BA.debugLine="rowColor = SelectedDrawable";
_rowcolor = __ref._selecteddrawable /*Object[]*/ ;
 }else 
{RDebugUtils.currentLine=5505035;
 //BA.debugLineNum = 5505035;BA.debugLine="Else If row Mod 2 = 0 Then";
if (_row%2==0) { 
RDebugUtils.currentLine=5505036;
 //BA.debugLineNum = 5505036;BA.debugLine="rowColor = Drawable1";
_rowcolor = __ref._drawable1 /*Object[]*/ ;
 }else {
RDebugUtils.currentLine=5505038;
 //BA.debugLineNum = 5505038;BA.debugLine="rowColor = Drawable2";
_rowcolor = __ref._drawable2 /*Object[]*/ ;
 }}
;
RDebugUtils.currentLine=5505040;
 //BA.debugLineNum = 5505040;BA.debugLine="For I = 0 To lbls.Length - 1";
{
final int step15 = 1;
final int limit15 = (int) (_lbls.length-1);
_i = (int) (0) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
RDebugUtils.currentLine=5505041;
 //BA.debugLineNum = 5505041;BA.debugLine="SV.Panel.AddView(lbls(I), Header.GetView(I).Left";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getPanel().AddView((android.view.View)(_lbls[_i].getObject()),__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetView(_i).getLeft(),(int) (_row*__ref._rowheight /*int*/ ),__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetView(_i).getWidth(),(int) (__ref._rowheight /*int*/ -__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=5505043;
 //BA.debugLineNum = 5505043;BA.debugLine="lbls(I).Text = values(I)";
_lbls[_i].setText(BA.ObjectToCharSequence(_values[_i]));
RDebugUtils.currentLine=5505044;
 //BA.debugLineNum = 5505044;BA.debugLine="lbls(I).Background = rowColor(I)";
_lbls[_i].setBackground((android.graphics.drawable.Drawable)(_rowcolor[_i]));
 }
};
RDebugUtils.currentLine=5505046;
 //BA.debugLineNum = 5505046;BA.debugLine="End Sub";
return "";
}
public String  _sv_scrollchanged(b4a.OPTUMizerPatient.table __ref,int _position) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "sv_scrollchanged", false))
	 {return ((String) Debug.delegate(ba, "sv_scrollchanged", new Object[] {_position}));}
int _currentmin = 0;
int _currentmax = 0;
int _i = 0;
RDebugUtils.currentLine=5308416;
 //BA.debugLineNum = 5308416;BA.debugLine="Private Sub SV_ScrollChanged(Position As Int)";
RDebugUtils.currentLine=5308417;
 //BA.debugLineNum = 5308417;BA.debugLine="Dim currentMin, currentMax As Int";
_currentmin = 0;
_currentmax = 0;
RDebugUtils.currentLine=5308418;
 //BA.debugLineNum = 5308418;BA.debugLine="currentMin = Max(0, Position / RowHeight - 30)";
_currentmin = (int) (__c.Max(0,_position/(double)__ref._rowheight /*int*/ -30));
RDebugUtils.currentLine=5308419;
 //BA.debugLineNum = 5308419;BA.debugLine="currentMax = Min(Data.Size - 1, (Position + SV.He";
_currentmax = (int) (__c.Min(__ref._data /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1,(_position+__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getHeight())/(double)__ref._rowheight /*int*/ +30));
RDebugUtils.currentLine=5308420;
 //BA.debugLineNum = 5308420;BA.debugLine="If minVisibleRow > -1 Then";
if (__ref._minvisiblerow /*int*/ >-1) { 
RDebugUtils.currentLine=5308421;
 //BA.debugLineNum = 5308421;BA.debugLine="If minVisibleRow < currentMin Then";
if (__ref._minvisiblerow /*int*/ <_currentmin) { 
RDebugUtils.currentLine=5308423;
 //BA.debugLineNum = 5308423;BA.debugLine="For I = minVisibleRow To Min(currentMin - 1, ma";
{
final int step6 = 1;
final int limit6 = (int) (__c.Min(_currentmin-1,__ref._maxvisiblerow /*int*/ ));
_i = __ref._minvisiblerow /*int*/  ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=5308424;
 //BA.debugLineNum = 5308424;BA.debugLine="HideRow(I)";
__ref._hiderow /*String*/ (null,_i);
 }
};
 }else 
{RDebugUtils.currentLine=5308426;
 //BA.debugLineNum = 5308426;BA.debugLine="Else If minVisibleRow > currentMin Then";
if (__ref._minvisiblerow /*int*/ >_currentmin) { 
RDebugUtils.currentLine=5308428;
 //BA.debugLineNum = 5308428;BA.debugLine="For I = currentMin To Min(minVisibleRow - 1, cu";
{
final int step10 = 1;
final int limit10 = (int) (__c.Min(__ref._minvisiblerow /*int*/ -1,_currentmax));
_i = _currentmin ;
for (;_i <= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=5308429;
 //BA.debugLineNum = 5308429;BA.debugLine="ShowRow(I)";
__ref._showrow /*String*/ (null,_i);
 }
};
 }}
;
RDebugUtils.currentLine=5308432;
 //BA.debugLineNum = 5308432;BA.debugLine="If maxVisibleRow > currentMax Then";
if (__ref._maxvisiblerow /*int*/ >_currentmax) { 
RDebugUtils.currentLine=5308434;
 //BA.debugLineNum = 5308434;BA.debugLine="For I = maxVisibleRow To Max(currentMax + 1, mi";
{
final int step15 = -1;
final int limit15 = (int) (__c.Max(_currentmax+1,__ref._minvisiblerow /*int*/ ));
_i = __ref._maxvisiblerow /*int*/  ;
for (;_i >= limit15 ;_i = _i + step15 ) {
RDebugUtils.currentLine=5308435;
 //BA.debugLineNum = 5308435;BA.debugLine="HideRow(I)";
__ref._hiderow /*String*/ (null,_i);
 }
};
 }else 
{RDebugUtils.currentLine=5308437;
 //BA.debugLineNum = 5308437;BA.debugLine="Else If maxVisibleRow < currentMax Then";
if (__ref._maxvisiblerow /*int*/ <_currentmax) { 
RDebugUtils.currentLine=5308439;
 //BA.debugLineNum = 5308439;BA.debugLine="For I = currentMax To Max(maxVisibleRow + 1, cu";
{
final int step19 = -1;
final int limit19 = (int) (__c.Max(__ref._maxvisiblerow /*int*/ +1,_currentmin));
_i = _currentmax ;
for (;_i >= limit19 ;_i = _i + step19 ) {
RDebugUtils.currentLine=5308440;
 //BA.debugLineNum = 5308440;BA.debugLine="ShowRow(I)";
__ref._showrow /*String*/ (null,_i);
 }
};
 }}
;
 };
RDebugUtils.currentLine=5308444;
 //BA.debugLineNum = 5308444;BA.debugLine="minVisibleRow = currentMin";
__ref._minvisiblerow /*int*/  = _currentmin;
RDebugUtils.currentLine=5308445;
 //BA.debugLineNum = 5308445;BA.debugLine="maxVisibleRow = currentMax";
__ref._maxvisiblerow /*int*/  = _currentmax;
RDebugUtils.currentLine=5308446;
 //BA.debugLineNum = 5308446;BA.debugLine="End Sub";
return "";
}
public String  _cell_click(b4a.OPTUMizerPatient.table __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "cell_click", false))
	 {return ((String) Debug.delegate(ba, "cell_click", null));}
b4a.OPTUMizerPatient.table._rowcol _rc = null;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Private Sub Cell_Click";
RDebugUtils.currentLine=5898241;
 //BA.debugLineNum = 5898241;BA.debugLine="Dim rc As RowCol";
_rc = new b4a.OPTUMizerPatient.table._rowcol();
RDebugUtils.currentLine=5898242;
 //BA.debugLineNum = 5898242;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="l = Sender";
_l.setObject((android.widget.TextView)(__c.Sender(ba)));
RDebugUtils.currentLine=5898244;
 //BA.debugLineNum = 5898244;BA.debugLine="rc = l.Tag";
_rc = (b4a.OPTUMizerPatient.table._rowcol)(_l.getTag());
RDebugUtils.currentLine=5898245;
 //BA.debugLineNum = 5898245;BA.debugLine="SelectRow(rc.Row)";
__ref._selectrow /*String*/ (null,_rc.Row /*int*/ );
RDebugUtils.currentLine=5898246;
 //BA.debugLineNum = 5898246;BA.debugLine="If SubExists(Callback, Event & \"_CellClick\") Then";
if (__c.SubExists(ba,__ref._callback /*Object*/ ,__ref._event /*String*/ +"_CellClick")) { 
RDebugUtils.currentLine=5898247;
 //BA.debugLineNum = 5898247;BA.debugLine="CallSub3(Callback, Event & \"_CellClick\", rc.Col,";
__c.CallSubNew3(ba,__ref._callback /*Object*/ ,__ref._event /*String*/ +"_CellClick",(Object)(_rc.Col /*int*/ ),(Object)(_rc.Row /*int*/ ));
 };
RDebugUtils.currentLine=5898249;
 //BA.debugLineNum = 5898249;BA.debugLine="End Sub";
return "";
}
public String  _selectrow(b4a.OPTUMizerPatient.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "selectrow", false))
	 {return ((String) Debug.delegate(ba, "selectrow", new Object[] {_row}));}
int _prev = 0;
int _col = 0;
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Private Sub SelectRow(Row As Int)";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="Dim prev As Int";
_prev = 0;
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="prev = SelectedRow";
_prev = __ref._selectedrow /*int*/ ;
RDebugUtils.currentLine=6160387;
 //BA.debugLineNum = 6160387;BA.debugLine="SelectedRow = Row";
__ref._selectedrow /*int*/  = _row;
RDebugUtils.currentLine=6160389;
 //BA.debugLineNum = 6160389;BA.debugLine="If prev > -1 Then";
if (_prev>-1) { 
RDebugUtils.currentLine=6160390;
 //BA.debugLineNum = 6160390;BA.debugLine="If visibleRows.ContainsKey(prev) Then";
if (__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .ContainsKey((Object)(_prev))) { 
RDebugUtils.currentLine=6160391;
 //BA.debugLineNum = 6160391;BA.debugLine="HideRow(prev)";
__ref._hiderow /*String*/ (null,_prev);
RDebugUtils.currentLine=6160392;
 //BA.debugLineNum = 6160392;BA.debugLine="ShowRow(prev)";
__ref._showrow /*String*/ (null,_prev);
 };
 };
RDebugUtils.currentLine=6160395;
 //BA.debugLineNum = 6160395;BA.debugLine="SelectedRow = Row";
__ref._selectedrow /*int*/  = _row;
RDebugUtils.currentLine=6160396;
 //BA.debugLineNum = 6160396;BA.debugLine="For col = 0 To NumberOfColumns - 1";
{
final int step11 = 1;
final int limit11 = (int) (__ref._numberofcolumns /*int*/ -1);
_col = (int) (0) ;
for (;_col <= limit11 ;_col = _col + step11 ) {
RDebugUtils.currentLine=6160397;
 //BA.debugLineNum = 6160397;BA.debugLine="If visibleRows.ContainsKey(SelectedRow) Then";
if (__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .ContainsKey((Object)(__ref._selectedrow /*int*/ ))) { 
RDebugUtils.currentLine=6160398;
 //BA.debugLineNum = 6160398;BA.debugLine="HideRow(SelectedRow)";
__ref._hiderow /*String*/ (null,__ref._selectedrow /*int*/ );
RDebugUtils.currentLine=6160399;
 //BA.debugLineNum = 6160399;BA.debugLine="ShowRow(SelectedRow)";
__ref._showrow /*String*/ (null,__ref._selectedrow /*int*/ );
 };
 }
};
RDebugUtils.currentLine=6160402;
 //BA.debugLineNum = 6160402;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.OPTUMizerPatient.table __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="Private StringUtils1 As StringUtils";
_stringutils1 = new anywheresoftware.b4a.objects.StringUtils();
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="Private SV As ScrollView";
_sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
RDebugUtils.currentLine=4980739;
 //BA.debugLineNum = 4980739;BA.debugLine="Private Header As Panel";
_header = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=4980740;
 //BA.debugLineNum = 4980740;BA.debugLine="Private Callback As Object";
_callback = new Object();
RDebugUtils.currentLine=4980741;
 //BA.debugLineNum = 4980741;BA.debugLine="Private Event As String";
_event = "";
RDebugUtils.currentLine=4980742;
 //BA.debugLineNum = 4980742;BA.debugLine="Private SelectedRow As Int";
_selectedrow = 0;
RDebugUtils.currentLine=4980743;
 //BA.debugLineNum = 4980743;BA.debugLine="Private Data As List";
_data = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4980744;
 //BA.debugLineNum = 4980744;BA.debugLine="Private LabelsCache As List";
_labelscache = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4980745;
 //BA.debugLineNum = 4980745;BA.debugLine="Private minVisibleRow, maxVisibleRow As Int";
_minvisiblerow = 0;
_maxvisiblerow = 0;
RDebugUtils.currentLine=4980746;
 //BA.debugLineNum = 4980746;BA.debugLine="Private visible As Boolean";
_visible = false;
RDebugUtils.currentLine=4980747;
 //BA.debugLineNum = 4980747;BA.debugLine="Private visibleRows As Map";
_visiblerows = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=4980748;
 //BA.debugLineNum = 4980748;BA.debugLine="Private NumberOfColumns, ColumnWidth As Int";
_numberofcolumns = 0;
_columnwidth = 0;
RDebugUtils.currentLine=4980749;
 //BA.debugLineNum = 4980749;BA.debugLine="Public RowHeight, HeaderColor, TableColor, FontCo";
_rowheight = 0;
_headercolor = 0;
_tablecolor = 0;
_fontcolor = 0;
_headerfontcolor = 0;
RDebugUtils.currentLine=4980750;
 //BA.debugLineNum = 4980750;BA.debugLine="Public FontSize As Float";
_fontsize = 0f;
RDebugUtils.currentLine=4980751;
 //BA.debugLineNum = 4980751;BA.debugLine="Type RowCol (Row As Int, Col As Int)";
;
RDebugUtils.currentLine=4980752;
 //BA.debugLineNum = 4980752;BA.debugLine="Public Alignment As Int";
_alignment = 0;
RDebugUtils.currentLine=4980753;
 //BA.debugLineNum = 4980753;BA.debugLine="Public SelectedDrawable(), Drawable1(), Drawable2";
_selecteddrawable = new Object[(int) (0)];
{
int d0 = _selecteddrawable.length;
for (int i0 = 0;i0 < d0;i0++) {
_selecteddrawable[i0] = new Object();
}
}
;
_drawable1 = new Object[(int) (0)];
{
int d0 = _drawable1.length;
for (int i0 = 0;i0 < d0;i0++) {
_drawable1[i0] = new Object();
}
}
;
_drawable2 = new Object[(int) (0)];
{
int d0 = _drawable2.length;
for (int i0 = 0;i0 < d0;i0++) {
_drawable2[i0] = new Object();
}
}
;
RDebugUtils.currentLine=4980755;
 //BA.debugLineNum = 4980755;BA.debugLine="HeaderColor = Colors.Gray";
__ref._headercolor /*int*/  = __c.Colors.Gray;
RDebugUtils.currentLine=4980756;
 //BA.debugLineNum = 4980756;BA.debugLine="RowHeight = 30dip";
__ref._rowheight /*int*/  = __c.DipToCurrent((int) (30));
RDebugUtils.currentLine=4980757;
 //BA.debugLineNum = 4980757;BA.debugLine="TableColor = Colors.LightGray";
__ref._tablecolor /*int*/  = __c.Colors.LightGray;
RDebugUtils.currentLine=4980758;
 //BA.debugLineNum = 4980758;BA.debugLine="FontColor = Colors.Black";
__ref._fontcolor /*int*/  = __c.Colors.Black;
RDebugUtils.currentLine=4980759;
 //BA.debugLineNum = 4980759;BA.debugLine="HeaderFontColor = Colors.White";
__ref._headerfontcolor /*int*/  = __c.Colors.White;
RDebugUtils.currentLine=4980760;
 //BA.debugLineNum = 4980760;BA.debugLine="FontSize = 14";
__ref._fontsize /*float*/  = (float) (14);
RDebugUtils.currentLine=4980761;
 //BA.debugLineNum = 4980761;BA.debugLine="Alignment = Gravity.CENTER 'change to Gravity.LEF";
__ref._alignment /*int*/  = __c.Gravity.CENTER;
RDebugUtils.currentLine=4980762;
 //BA.debugLineNum = 4980762;BA.debugLine="End Sub";
return "";
}
public String  _clearall(b4a.OPTUMizerPatient.table __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "clearall", false))
	 {return ((String) Debug.delegate(ba, "clearall", null));}
RDebugUtils.currentLine=5111808;
 //BA.debugLineNum = 5111808;BA.debugLine="Public Sub ClearAll";
RDebugUtils.currentLine=5111809;
 //BA.debugLineNum = 5111809;BA.debugLine="innerClearAll(NumberOfColumns)";
__ref._innerclearall /*String*/ (null,__ref._numberofcolumns /*int*/ );
RDebugUtils.currentLine=5111810;
 //BA.debugLineNum = 5111810;BA.debugLine="End Sub";
return "";
}
public String  _innerclearall(b4a.OPTUMizerPatient.table __ref,int _vnumberofcolumns) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "innerclearall", false))
	 {return ((String) Debug.delegate(ba, "innerclearall", new Object[] {_vnumberofcolumns}));}
int _i = 0;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd1 = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd2 = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd3 = null;
RDebugUtils.currentLine=5242880;
 //BA.debugLineNum = 5242880;BA.debugLine="public Sub innerClearAll(vNumberOfColumns As Int)";
RDebugUtils.currentLine=5242881;
 //BA.debugLineNum = 5242881;BA.debugLine="For i = SV.Panel.NumberOfViews -1 To 0 Step -1";
{
final int step1 = -1;
final int limit1 = (int) (0);
_i = (int) (__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getPanel().getNumberOfViews()-1) ;
for (;_i >= limit1 ;_i = _i + step1 ) {
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="SV.Panel.RemoveViewAt(i)";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getPanel().RemoveViewAt(_i);
 }
};
RDebugUtils.currentLine=5242884;
 //BA.debugLineNum = 5242884;BA.debugLine="NumberOfColumns = vNumberOfColumns";
__ref._numberofcolumns /*int*/  = _vnumberofcolumns;
RDebugUtils.currentLine=5242885;
 //BA.debugLineNum = 5242885;BA.debugLine="Dim Drawable1(NumberOfColumns) As Object";
_drawable1 = new Object[__ref._numberofcolumns /*int*/ ];
{
int d0 = _drawable1.length;
for (int i0 = 0;i0 < d0;i0++) {
_drawable1[i0] = new Object();
}
}
;
RDebugUtils.currentLine=5242886;
 //BA.debugLineNum = 5242886;BA.debugLine="Dim Drawable2(NumberOfColumns) As Object";
_drawable2 = new Object[__ref._numberofcolumns /*int*/ ];
{
int d0 = _drawable2.length;
for (int i0 = 0;i0 < d0;i0++) {
_drawable2[i0] = new Object();
}
}
;
RDebugUtils.currentLine=5242887;
 //BA.debugLineNum = 5242887;BA.debugLine="Dim SelectedDrawable(NumberOfColumns) As Object";
_selecteddrawable = new Object[__ref._numberofcolumns /*int*/ ];
{
int d0 = _selecteddrawable.length;
for (int i0 = 0;i0 < d0;i0++) {
_selecteddrawable[i0] = new Object();
}
}
;
RDebugUtils.currentLine=5242888;
 //BA.debugLineNum = 5242888;BA.debugLine="For i = 0 To NumberOfColumns - 1";
{
final int step8 = 1;
final int limit8 = (int) (__ref._numberofcolumns /*int*/ -1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
RDebugUtils.currentLine=5242889;
 //BA.debugLineNum = 5242889;BA.debugLine="Dim cd1, cd2, cd3 As ColorDrawable";
_cd1 = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
_cd2 = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
_cd3 = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=5242890;
 //BA.debugLineNum = 5242890;BA.debugLine="cd1.Initialize(Colors.White, 0)";
_cd1.Initialize(__c.Colors.White,(int) (0));
RDebugUtils.currentLine=5242891;
 //BA.debugLineNum = 5242891;BA.debugLine="cd2.Initialize(0xFF98F5FF, 0)";
_cd2.Initialize((int) (0xff98f5ff),(int) (0));
RDebugUtils.currentLine=5242892;
 //BA.debugLineNum = 5242892;BA.debugLine="cd3.Initialize(0xFF007FFF, 0)";
_cd3.Initialize((int) (0xff007fff),(int) (0));
RDebugUtils.currentLine=5242893;
 //BA.debugLineNum = 5242893;BA.debugLine="Drawable1(i) = cd1";
__ref._drawable1 /*Object[]*/ [_i] = (Object)(_cd1.getObject());
RDebugUtils.currentLine=5242894;
 //BA.debugLineNum = 5242894;BA.debugLine="Drawable2(i) = cd2";
__ref._drawable2 /*Object[]*/ [_i] = (Object)(_cd2.getObject());
RDebugUtils.currentLine=5242895;
 //BA.debugLineNum = 5242895;BA.debugLine="SelectedDrawable(i) = cd3";
__ref._selecteddrawable /*Object[]*/ [_i] = (Object)(_cd3.getObject());
 }
};
RDebugUtils.currentLine=5242897;
 //BA.debugLineNum = 5242897;BA.debugLine="SV.Panel.Height = 0";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getPanel().setHeight((int) (0));
RDebugUtils.currentLine=5242898;
 //BA.debugLineNum = 5242898;BA.debugLine="SelectedRow = -1";
__ref._selectedrow /*int*/  = (int) (-1);
RDebugUtils.currentLine=5242899;
 //BA.debugLineNum = 5242899;BA.debugLine="minVisibleRow = -1";
__ref._minvisiblerow /*int*/  = (int) (-1);
RDebugUtils.currentLine=5242900;
 //BA.debugLineNum = 5242900;BA.debugLine="maxVisibleRow = 0";
__ref._maxvisiblerow /*int*/  = (int) (0);
RDebugUtils.currentLine=5242901;
 //BA.debugLineNum = 5242901;BA.debugLine="Data.Initialize";
__ref._data /*anywheresoftware.b4a.objects.collections.List*/ .Initialize();
RDebugUtils.currentLine=5242902;
 //BA.debugLineNum = 5242902;BA.debugLine="LabelsCache.Initialize";
__ref._labelscache /*anywheresoftware.b4a.objects.collections.List*/ .Initialize();
RDebugUtils.currentLine=5242903;
 //BA.debugLineNum = 5242903;BA.debugLine="visibleRows.Initialize";
__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .Initialize();
RDebugUtils.currentLine=5242904;
 //BA.debugLineNum = 5242904;BA.debugLine="SV.ScrollPosition = 0";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .setScrollPosition((int) (0));
RDebugUtils.currentLine=5242905;
 //BA.debugLineNum = 5242905;BA.debugLine="DoEvents";
__c.DoEvents();
RDebugUtils.currentLine=5242906;
 //BA.debugLineNum = 5242906;BA.debugLine="SV.ScrollPosition = 0";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .setScrollPosition((int) (0));
RDebugUtils.currentLine=5242907;
 //BA.debugLineNum = 5242907;BA.debugLine="For i = 1 To 80 'fill the cache to avoid delay on";
{
final int step27 = 1;
final int limit27 = (int) (80);
_i = (int) (1) ;
for (;_i <= limit27 ;_i = _i + step27 ) {
RDebugUtils.currentLine=5242908;
 //BA.debugLineNum = 5242908;BA.debugLine="LabelsCache.Add(CreateNewLabels)";
__ref._labelscache /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)(__ref._createnewlabels /*anywheresoftware.b4a.objects.LabelWrapper[]*/ (null)));
 }
};
RDebugUtils.currentLine=5242910;
 //BA.debugLineNum = 5242910;BA.debugLine="If visible Then";
if (__ref._visible /*boolean*/ ) { 
RDebugUtils.currentLine=5242911;
 //BA.debugLineNum = 5242911;BA.debugLine="SV_ScrollChanged(0)";
__ref._sv_scrollchanged /*String*/ (null,(int) (0));
 };
RDebugUtils.currentLine=5242913;
 //BA.debugLineNum = 5242913;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.LabelWrapper[]  _createnewlabels(b4a.OPTUMizerPatient.table __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "createnewlabels", false))
	 {return ((anywheresoftware.b4a.objects.LabelWrapper[]) Debug.delegate(ba, "createnewlabels", null));}
anywheresoftware.b4a.objects.LabelWrapper[] _lbls = null;
int _i = 0;
b4a.OPTUMizerPatient.table._rowcol _rc = null;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Private Sub CreateNewLabels As Label()";
RDebugUtils.currentLine=5767169;
 //BA.debugLineNum = 5767169;BA.debugLine="Dim lbls(NumberOfColumns) As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[__ref._numberofcolumns /*int*/ ];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=5767170;
 //BA.debugLineNum = 5767170;BA.debugLine="For I = 0 To NumberOfColumns - 1";
{
final int step2 = 1;
final int limit2 = (int) (__ref._numberofcolumns /*int*/ -1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=5767171;
 //BA.debugLineNum = 5767171;BA.debugLine="Dim rc As RowCol";
_rc = new b4a.OPTUMizerPatient.table._rowcol();
RDebugUtils.currentLine=5767172;
 //BA.debugLineNum = 5767172;BA.debugLine="rc.Col = I";
_rc.Col /*int*/  = _i;
RDebugUtils.currentLine=5767173;
 //BA.debugLineNum = 5767173;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5767174;
 //BA.debugLineNum = 5767174;BA.debugLine="l.Initialize(\"cell\")";
_l.Initialize(ba,"cell");
RDebugUtils.currentLine=5767175;
 //BA.debugLineNum = 5767175;BA.debugLine="l.Gravity = Alignment";
_l.setGravity(__ref._alignment /*int*/ );
RDebugUtils.currentLine=5767176;
 //BA.debugLineNum = 5767176;BA.debugLine="l.TextSize = FontSize";
_l.setTextSize(__ref._fontsize /*float*/ );
RDebugUtils.currentLine=5767177;
 //BA.debugLineNum = 5767177;BA.debugLine="l.TextColor = FontColor";
_l.setTextColor(__ref._fontcolor /*int*/ );
RDebugUtils.currentLine=5767178;
 //BA.debugLineNum = 5767178;BA.debugLine="l.Tag = rc";
_l.setTag((Object)(_rc));
RDebugUtils.currentLine=5767179;
 //BA.debugLineNum = 5767179;BA.debugLine="lbls(I) = l";
_lbls[_i] = _l;
 }
};
RDebugUtils.currentLine=5767181;
 //BA.debugLineNum = 5767181;BA.debugLine="Return lbls";
if (true) return _lbls;
RDebugUtils.currentLine=5767182;
 //BA.debugLineNum = 5767182;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.LabelWrapper[]  _getlabels(b4a.OPTUMizerPatient.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "getlabels", false))
	 {return ((anywheresoftware.b4a.objects.LabelWrapper[]) Debug.delegate(ba, "getlabels", new Object[] {_row}));}
anywheresoftware.b4a.objects.LabelWrapper[] _lbls = null;
int _i = 0;
b4a.OPTUMizerPatient.table._rowcol _rc = null;
RDebugUtils.currentLine=5701632;
 //BA.debugLineNum = 5701632;BA.debugLine="Private Sub GetLabels(Row As Int) As Label()";
RDebugUtils.currentLine=5701633;
 //BA.debugLineNum = 5701633;BA.debugLine="Dim lbls() As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=5701634;
 //BA.debugLineNum = 5701634;BA.debugLine="If LabelsCache.Size > 0 Then";
if (__ref._labelscache /*anywheresoftware.b4a.objects.collections.List*/ .getSize()>0) { 
RDebugUtils.currentLine=5701636;
 //BA.debugLineNum = 5701636;BA.debugLine="lbls = LabelsCache.Get(LabelsCache.Size - 1)";
_lbls = (anywheresoftware.b4a.objects.LabelWrapper[])(__ref._labelscache /*anywheresoftware.b4a.objects.collections.List*/ .Get((int) (__ref._labelscache /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1)));
RDebugUtils.currentLine=5701637;
 //BA.debugLineNum = 5701637;BA.debugLine="LabelsCache.RemoveAt(LabelsCache.Size - 1)";
__ref._labelscache /*anywheresoftware.b4a.objects.collections.List*/ .RemoveAt((int) (__ref._labelscache /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1));
 }else {
RDebugUtils.currentLine=5701639;
 //BA.debugLineNum = 5701639;BA.debugLine="lbls = CreateNewLabels";
_lbls = __ref._createnewlabels /*anywheresoftware.b4a.objects.LabelWrapper[]*/ (null);
 };
RDebugUtils.currentLine=5701641;
 //BA.debugLineNum = 5701641;BA.debugLine="For I = 0 To lbls.Length - 1";
{
final int step8 = 1;
final int limit8 = (int) (_lbls.length-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
RDebugUtils.currentLine=5701642;
 //BA.debugLineNum = 5701642;BA.debugLine="Dim rc As RowCol";
_rc = new b4a.OPTUMizerPatient.table._rowcol();
RDebugUtils.currentLine=5701643;
 //BA.debugLineNum = 5701643;BA.debugLine="rc = lbls(I).Tag";
_rc = (b4a.OPTUMizerPatient.table._rowcol)(_lbls[_i].getTag());
RDebugUtils.currentLine=5701644;
 //BA.debugLineNum = 5701644;BA.debugLine="rc.Row = Row";
_rc.Row /*int*/  = _row;
 }
};
RDebugUtils.currentLine=5701646;
 //BA.debugLineNum = 5701646;BA.debugLine="Return lbls";
if (true) return _lbls;
RDebugUtils.currentLine=5701647;
 //BA.debugLineNum = 5701647;BA.debugLine="End Sub";
return null;
}
public String  _header_click(b4a.OPTUMizerPatient.table __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "header_click", false))
	 {return ((String) Debug.delegate(ba, "header_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _l = null;
int _col = 0;
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Private Sub Header_Click";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="Dim col As Int";
_col = 0;
RDebugUtils.currentLine=5963779;
 //BA.debugLineNum = 5963779;BA.debugLine="l = Sender";
_l.setObject((android.widget.TextView)(__c.Sender(ba)));
RDebugUtils.currentLine=5963780;
 //BA.debugLineNum = 5963780;BA.debugLine="col = l.Tag";
_col = (int)(BA.ObjectToNumber(_l.getTag()));
RDebugUtils.currentLine=5963781;
 //BA.debugLineNum = 5963781;BA.debugLine="If SubExists(Callback, Event & \"_HeaderClick\") Th";
if (__c.SubExists(ba,__ref._callback /*Object*/ ,__ref._event /*String*/ +"_HeaderClick")) { 
RDebugUtils.currentLine=5963782;
 //BA.debugLineNum = 5963782;BA.debugLine="CallSub2(Callback, Event & \"_HeaderClick\", col)";
__c.CallSubNew2(ba,__ref._callback /*Object*/ ,__ref._event /*String*/ +"_HeaderClick",(Object)(_col));
 };
RDebugUtils.currentLine=5963784;
 //BA.debugLineNum = 5963784;BA.debugLine="End Sub";
return "";
}
public String  _hiderow(b4a.OPTUMizerPatient.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "hiderow", false))
	 {return ((String) Debug.delegate(ba, "hiderow", new Object[] {_row}));}
anywheresoftware.b4a.objects.LabelWrapper[] _lbls = null;
int _i = 0;
RDebugUtils.currentLine=5636096;
 //BA.debugLineNum = 5636096;BA.debugLine="Private Sub HideRow (Row As Int)";
RDebugUtils.currentLine=5636098;
 //BA.debugLineNum = 5636098;BA.debugLine="Dim lbls() As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=5636099;
 //BA.debugLineNum = 5636099;BA.debugLine="lbls = visibleRows.Get(Row)";
_lbls = (anywheresoftware.b4a.objects.LabelWrapper[])(__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(_row)));
RDebugUtils.currentLine=5636100;
 //BA.debugLineNum = 5636100;BA.debugLine="If lbls = Null Then";
if (_lbls== null) { 
RDebugUtils.currentLine=5636101;
 //BA.debugLineNum = 5636101;BA.debugLine="Log(\"HideRow: (null) \" & Row)";
__c.LogImpl("15636101","HideRow: (null) "+BA.NumberToString(_row),0);
RDebugUtils.currentLine=5636102;
 //BA.debugLineNum = 5636102;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=5636104;
 //BA.debugLineNum = 5636104;BA.debugLine="For I = 0 To lbls.Length - 1";
{
final int step7 = 1;
final int limit7 = (int) (_lbls.length-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
RDebugUtils.currentLine=5636105;
 //BA.debugLineNum = 5636105;BA.debugLine="lbls(I).RemoveView";
_lbls[_i].RemoveView();
 }
};
RDebugUtils.currentLine=5636107;
 //BA.debugLineNum = 5636107;BA.debugLine="visibleRows.Remove(Row)";
__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .Remove((Object)(_row));
RDebugUtils.currentLine=5636108;
 //BA.debugLineNum = 5636108;BA.debugLine="LabelsCache.Add(lbls)";
__ref._labelscache /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)(_lbls));
RDebugUtils.currentLine=5636109;
 //BA.debugLineNum = 5636109;BA.debugLine="End Sub";
return "";
}
public boolean  _isrowvisible(b4a.OPTUMizerPatient.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "isrowvisible", false))
	 {return ((Boolean) Debug.delegate(ba, "isrowvisible", new Object[] {_row}));}
RDebugUtils.currentLine=5570560;
 //BA.debugLineNum = 5570560;BA.debugLine="Private Sub IsRowVisible(Row As Int) As Boolean";
RDebugUtils.currentLine=5570561;
 //BA.debugLineNum = 5570561;BA.debugLine="Return Row < (SV.ScrollPosition + SV.Height) / (R";
if (true) return _row<(__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getScrollPosition()+__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getHeight())/(double)(__ref._rowheight /*int*/ +1) && _row>__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getScrollPosition()/(double)__ref._rowheight /*int*/ ;
RDebugUtils.currentLine=5570563;
 //BA.debugLineNum = 5570563;BA.debugLine="End Sub";
return false;
}
public String  _jumptorow(b4a.OPTUMizerPatient.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "jumptorow", false))
	 {return ((String) Debug.delegate(ba, "jumptorow", new Object[] {_row}));}
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Public Sub JumpToRow(Row As Int)";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="SV.ScrollPosition = Row * RowHeight";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .setScrollPosition((int) (_row*__ref._rowheight /*int*/ ));
RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="End Sub";
return "";
}
public String  _loadtablefromcsv(b4a.OPTUMizerPatient.table __ref,String _dir,String _filename,boolean _headersexist) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "loadtablefromcsv", false))
	 {return ((String) Debug.delegate(ba, "loadtablefromcsv", new Object[] {_dir,_filename,_headersexist}));}
anywheresoftware.b4a.objects.collections.List _list1 = null;
String[] _h = null;
anywheresoftware.b4a.objects.collections.List _headers = null;
int _i = 0;
String[] _firstrow = null;
String[] _row = null;
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Public Sub LoadTableFromCSV(Dir As String, Filenam";
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="Dim List1 As List";
_list1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6291459;
 //BA.debugLineNum = 6291459;BA.debugLine="Dim h() As String";
_h = new String[(int) (0)];
java.util.Arrays.fill(_h,"");
RDebugUtils.currentLine=6291460;
 //BA.debugLineNum = 6291460;BA.debugLine="If HeadersExist Then";
if (_headersexist) { 
RDebugUtils.currentLine=6291461;
 //BA.debugLineNum = 6291461;BA.debugLine="Dim headers As List";
_headers = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6291462;
 //BA.debugLineNum = 6291462;BA.debugLine="List1 = StringUtils1.LoadCSV2(Dir, Filename, \",\"";
_list1 = __ref._stringutils1 /*anywheresoftware.b4a.objects.StringUtils*/ .LoadCSV2(_dir,_filename,BA.ObjectToChar(","),_headers);
RDebugUtils.currentLine=6291463;
 //BA.debugLineNum = 6291463;BA.debugLine="Dim h(headers.Size) As String";
_h = new String[_headers.getSize()];
java.util.Arrays.fill(_h,"");
RDebugUtils.currentLine=6291464;
 //BA.debugLineNum = 6291464;BA.debugLine="For i = 0 To headers.Size - 1";
{
final int step7 = 1;
final int limit7 = (int) (_headers.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
RDebugUtils.currentLine=6291465;
 //BA.debugLineNum = 6291465;BA.debugLine="h(i) = headers.Get(i)";
_h[_i] = BA.ObjectToString(_headers.Get(_i));
 }
};
 }else {
RDebugUtils.currentLine=6291468;
 //BA.debugLineNum = 6291468;BA.debugLine="List1 = StringUtils1.LoadCSV(Dir, Filename, \",\")";
_list1 = __ref._stringutils1 /*anywheresoftware.b4a.objects.StringUtils*/ .LoadCSV(_dir,_filename,BA.ObjectToChar(","));
RDebugUtils.currentLine=6291469;
 //BA.debugLineNum = 6291469;BA.debugLine="Dim firstRow() As String";
_firstrow = new String[(int) (0)];
java.util.Arrays.fill(_firstrow,"");
RDebugUtils.currentLine=6291470;
 //BA.debugLineNum = 6291470;BA.debugLine="firstRow = List1.Get(0)";
_firstrow = (String[])(_list1.Get((int) (0)));
RDebugUtils.currentLine=6291471;
 //BA.debugLineNum = 6291471;BA.debugLine="Dim h(firstRow.Length)";
_h = new String[_firstrow.length];
java.util.Arrays.fill(_h,"");
RDebugUtils.currentLine=6291472;
 //BA.debugLineNum = 6291472;BA.debugLine="For i = 0 To firstRow.Length - 1";
{
final int step15 = 1;
final int limit15 = (int) (_firstrow.length-1);
_i = (int) (0) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
RDebugUtils.currentLine=6291473;
 //BA.debugLineNum = 6291473;BA.debugLine="h(i) = \"Col\" & (i + 1)";
_h[_i] = "Col"+BA.NumberToString((_i+1));
 }
};
 };
RDebugUtils.currentLine=6291476;
 //BA.debugLineNum = 6291476;BA.debugLine="innerClearAll(h.Length)";
__ref._innerclearall /*String*/ (null,_h.length);
RDebugUtils.currentLine=6291477;
 //BA.debugLineNum = 6291477;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
__ref._columnwidth /*int*/  = (int) (__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getWidth()/(double)__ref._numberofcolumns /*int*/ );
RDebugUtils.currentLine=6291478;
 //BA.debugLineNum = 6291478;BA.debugLine="SetHeader(h)";
__ref._setheader /*String*/ (null,_h);
RDebugUtils.currentLine=6291479;
 //BA.debugLineNum = 6291479;BA.debugLine="For i = 0 To List1.Size - 1";
{
final int step22 = 1;
final int limit22 = (int) (_list1.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit22 ;_i = _i + step22 ) {
RDebugUtils.currentLine=6291480;
 //BA.debugLineNum = 6291480;BA.debugLine="Dim row() As String";
_row = new String[(int) (0)];
java.util.Arrays.fill(_row,"");
RDebugUtils.currentLine=6291481;
 //BA.debugLineNum = 6291481;BA.debugLine="row = List1.Get(i)";
_row = (String[])(_list1.Get(_i));
RDebugUtils.currentLine=6291482;
 //BA.debugLineNum = 6291482;BA.debugLine="AddRow(row)";
__ref._addrow /*String*/ (null,_row);
 }
};
RDebugUtils.currentLine=6291484;
 //BA.debugLineNum = 6291484;BA.debugLine="End Sub";
return "";
}
public String  _setheader(b4a.OPTUMizerPatient.table __ref,String[] _values) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "setheader", false))
	 {return ((String) Debug.delegate(ba, "setheader", new Object[] {_values}));}
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Public Sub SetHeader(Values() As String)";
RDebugUtils.currentLine=5832705;
 //BA.debugLineNum = 5832705;BA.debugLine="For I = Header.NumberOfViews - 1 To 0 Step -1";
{
final int step1 = -1;
final int limit1 = (int) (0);
_i = (int) (__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .getNumberOfViews()-1) ;
for (;_i >= limit1 ;_i = _i + step1 ) {
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="Header.RemoveViewAt(I)";
__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .RemoveViewAt(_i);
 }
};
RDebugUtils.currentLine=5832708;
 //BA.debugLineNum = 5832708;BA.debugLine="For I = 0 To NumberOfColumns - 1";
{
final int step4 = 1;
final int limit4 = (int) (__ref._numberofcolumns /*int*/ -1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=5832709;
 //BA.debugLineNum = 5832709;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5832710;
 //BA.debugLineNum = 5832710;BA.debugLine="l.Initialize(\"header\")";
_l.Initialize(ba,"header");
RDebugUtils.currentLine=5832711;
 //BA.debugLineNum = 5832711;BA.debugLine="l.Gravity = Gravity.CENTER";
_l.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=5832712;
 //BA.debugLineNum = 5832712;BA.debugLine="l.TextSize = FontSize";
_l.setTextSize(__ref._fontsize /*float*/ );
RDebugUtils.currentLine=5832713;
 //BA.debugLineNum = 5832713;BA.debugLine="l.Color = HeaderColor";
_l.setColor(__ref._headercolor /*int*/ );
RDebugUtils.currentLine=5832714;
 //BA.debugLineNum = 5832714;BA.debugLine="l.TextColor = HeaderFontColor";
_l.setTextColor(__ref._headerfontcolor /*int*/ );
RDebugUtils.currentLine=5832715;
 //BA.debugLineNum = 5832715;BA.debugLine="l.Text = Values(I)";
_l.setText(BA.ObjectToCharSequence(_values[_i]));
RDebugUtils.currentLine=5832716;
 //BA.debugLineNum = 5832716;BA.debugLine="l.Tag = I";
_l.setTag((Object)(_i));
RDebugUtils.currentLine=5832717;
 //BA.debugLineNum = 5832717;BA.debugLine="Header.AddView(l, ColumnWidth * I, 0, ColumnWidt";
__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .AddView((android.view.View)(_l.getObject()),(int) (__ref._columnwidth /*int*/ *_i),(int) (0),(int) (__ref._columnwidth /*int*/ -__c.DipToCurrent((int) (1))),__ref._rowheight /*int*/ );
 }
};
RDebugUtils.currentLine=5832719;
 //BA.debugLineNum = 5832719;BA.debugLine="End Sub";
return "";
}
public String  _savetabletocsv(b4a.OPTUMizerPatient.table __ref,String _dir,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "savetabletocsv", false))
	 {return ((String) Debug.delegate(ba, "savetabletocsv", new Object[] {_dir,_filename}));}
String[] _headers = null;
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Public Sub SaveTableToCSV(Dir As String, Filename";
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="Dim headers(NumberOfColumns) As String";
_headers = new String[__ref._numberofcolumns /*int*/ ];
java.util.Arrays.fill(_headers,"");
RDebugUtils.currentLine=6422530;
 //BA.debugLineNum = 6422530;BA.debugLine="For i = 0 To headers.Length - 1";
{
final int step2 = 1;
final int limit2 = (int) (_headers.length-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=6422531;
 //BA.debugLineNum = 6422531;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=6422532;
 //BA.debugLineNum = 6422532;BA.debugLine="l = Header.GetView(i)";
_l.setObject((android.widget.TextView)(__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetView(_i).getObject()));
RDebugUtils.currentLine=6422533;
 //BA.debugLineNum = 6422533;BA.debugLine="headers(i) = l.Text";
_headers[_i] = _l.getText();
 }
};
RDebugUtils.currentLine=6422535;
 //BA.debugLineNum = 6422535;BA.debugLine="StringUtils1.SaveCSV2(Dir, Filename, \",\", Data, h";
__ref._stringutils1 /*anywheresoftware.b4a.objects.StringUtils*/ .SaveCSV2(_dir,_filename,BA.ObjectToChar(","),__ref._data /*anywheresoftware.b4a.objects.collections.List*/ ,anywheresoftware.b4a.keywords.Common.ArrayToList(_headers));
RDebugUtils.currentLine=6422536;
 //BA.debugLineNum = 6422536;BA.debugLine="End Sub";
return "";
}
public String  _setcolumnswidths(b4a.OPTUMizerPatient.table __ref,int[] _widths) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "setcolumnswidths", false))
	 {return ((String) Debug.delegate(ba, "setcolumnswidths", new Object[] {_widths}));}
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper[] _lbls = null;
int _lbl = 0;
RDebugUtils.currentLine=5177344;
 //BA.debugLineNum = 5177344;BA.debugLine="Public Sub SetColumnsWidths(Widths() As Int)";
RDebugUtils.currentLine=5177345;
 //BA.debugLineNum = 5177345;BA.debugLine="Dim v As View";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
RDebugUtils.currentLine=5177346;
 //BA.debugLineNum = 5177346;BA.debugLine="For i = 0 To Widths.Length - 1";
{
final int step2 = 1;
final int limit2 = (int) (_widths.length-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=5177347;
 //BA.debugLineNum = 5177347;BA.debugLine="v = Header.GetView(i)";
_v = __ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetView(_i);
RDebugUtils.currentLine=5177348;
 //BA.debugLineNum = 5177348;BA.debugLine="v.Width = Widths(i) - 1dip";
_v.setWidth((int) (_widths[_i]-__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=5177349;
 //BA.debugLineNum = 5177349;BA.debugLine="If i > 0 Then";
if (_i>0) { 
RDebugUtils.currentLine=5177350;
 //BA.debugLineNum = 5177350;BA.debugLine="v.Left = Header.GetView(i-1).Left + Widths(i-1)";
_v.setLeft((int) (__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetView((int) (_i-1)).getLeft()+_widths[(int) (_i-1)]+__c.DipToCurrent((int) (1))));
 };
 }
};
RDebugUtils.currentLine=5177353;
 //BA.debugLineNum = 5177353;BA.debugLine="Dim lbls() As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=5177354;
 //BA.debugLineNum = 5177354;BA.debugLine="For i = 0 To visibleRows.Size - 1";
{
final int step10 = 1;
final int limit10 = (int) (__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .getSize()-1);
_i = (int) (0) ;
for (;_i <= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=5177355;
 //BA.debugLineNum = 5177355;BA.debugLine="lbls = visibleRows.GetValueAt(i)";
_lbls = (anywheresoftware.b4a.objects.LabelWrapper[])(__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .GetValueAt(_i));
RDebugUtils.currentLine=5177356;
 //BA.debugLineNum = 5177356;BA.debugLine="For lbl = 0 To lbls.Length - 1";
{
final int step12 = 1;
final int limit12 = (int) (_lbls.length-1);
_lbl = (int) (0) ;
for (;_lbl <= limit12 ;_lbl = _lbl + step12 ) {
RDebugUtils.currentLine=5177357;
 //BA.debugLineNum = 5177357;BA.debugLine="lbls(lbl).SetLayout(Header.GetView(lbl).Left, l";
_lbls[_lbl].SetLayout(__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetView(_lbl).getLeft(),_lbls[_lbl].getTop(),__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetView(_lbl).getWidth(),__ref._rowheight /*int*/ );
 }
};
 }
};
RDebugUtils.currentLine=5177361;
 //BA.debugLineNum = 5177361;BA.debugLine="End Sub";
return "";
}
public String  _setdatagrid(b4a.OPTUMizerPatient.table __ref,String[] _headerx,anywheresoftware.b4a.objects.collections.List _x) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "setdatagrid", false))
	 {return ((String) Debug.delegate(ba, "setdatagrid", new Object[] {_headerx,_x}));}
Object _a = null;
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="public Sub SetDatagrid(HeaderX() As String,x As Li";
RDebugUtils.currentLine=6356994;
 //BA.debugLineNum = 6356994;BA.debugLine="innerClearAll(HeaderX.Length)";
__ref._innerclearall /*String*/ (null,_headerx.length);
RDebugUtils.currentLine=6356995;
 //BA.debugLineNum = 6356995;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
__ref._columnwidth /*int*/  = (int) (__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getWidth()/(double)__ref._numberofcolumns /*int*/ );
RDebugUtils.currentLine=6356996;
 //BA.debugLineNum = 6356996;BA.debugLine="SetHeader(HeaderX)";
__ref._setheader /*String*/ (null,_headerx);
RDebugUtils.currentLine=6356997;
 //BA.debugLineNum = 6356997;BA.debugLine="For Each a In x";
{
final anywheresoftware.b4a.BA.IterableList group4 = _x;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_a = group4.Get(index4);
RDebugUtils.currentLine=6356998;
 //BA.debugLineNum = 6356998;BA.debugLine="AddRow(a)";
__ref._addrow /*String*/ (null,(String[])(_a));
 }
};
RDebugUtils.currentLine=6357000;
 //BA.debugLineNum = 6357000;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(b4a.OPTUMizerPatient.table __ref,int _col,int _row,String _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "setvalue", false))
	 {return ((String) Debug.delegate(ba, "setvalue", new Object[] {_col,_row,_value}));}
String[] _values = null;
anywheresoftware.b4a.objects.LabelWrapper[] _lbls = null;
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Public Sub SetValue(Col As Int, Row As Int, Value";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="Dim values() As String";
_values = new String[(int) (0)];
java.util.Arrays.fill(_values,"");
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="values = Data.Get(Row)";
_values = (String[])(__ref._data /*anywheresoftware.b4a.objects.collections.List*/ .Get(_row));
RDebugUtils.currentLine=6094851;
 //BA.debugLineNum = 6094851;BA.debugLine="values(Col) = Value";
_values[_col] = _value;
RDebugUtils.currentLine=6094852;
 //BA.debugLineNum = 6094852;BA.debugLine="If visibleRows.ContainsKey(Row) Then";
if (__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .ContainsKey((Object)(_row))) { 
RDebugUtils.currentLine=6094853;
 //BA.debugLineNum = 6094853;BA.debugLine="Dim lbls() As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=6094854;
 //BA.debugLineNum = 6094854;BA.debugLine="lbls = visibleRows.Get(Row)";
_lbls = (anywheresoftware.b4a.objects.LabelWrapper[])(__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(_row)));
RDebugUtils.currentLine=6094855;
 //BA.debugLineNum = 6094855;BA.debugLine="lbls(Col).Text = Value";
_lbls[_col].setText(BA.ObjectToCharSequence(_value));
 };
RDebugUtils.currentLine=6094857;
 //BA.debugLineNum = 6094857;BA.debugLine="End Sub";
return "";
}
}