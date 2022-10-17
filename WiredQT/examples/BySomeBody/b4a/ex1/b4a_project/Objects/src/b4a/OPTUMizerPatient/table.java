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
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Public Sub GetValue(Col As Int, Row As Int)";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="Dim values() As String";
_values = new String[(int) (0)];
java.util.Arrays.fill(_values,"");
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="values = Data.Get(Row)";
_values = (String[])(__ref._data /*anywheresoftware.b4a.objects.collections.List*/ .Get(_row));
RDebugUtils.currentLine=4980739;
 //BA.debugLineNum = 4980739;BA.debugLine="Return values(Col)";
if (true) return _values[_col];
RDebugUtils.currentLine=4980740;
 //BA.debugLineNum = 4980740;BA.debugLine="End Sub";
return "";
}
public String  _addtoparent(b4a.OPTUMizerPatient.table __ref,anywheresoftware.b4a.objects.ActivityWrapper _act,int _left,int _top,int _width,int _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "addtoparent", false))
	 {return ((String) Debug.delegate(ba, "addtoparent", new Object[] {_act,_left,_top,_width,_height}));}
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Public Sub AddToParent(Act As Activity, Left As In";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="visible = True";
__ref._visible /*boolean*/  = __c.True;
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="Header.Initialize(\"\")";
__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .Initialize(ba,"");
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="Header.Color = TableColor";
__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .setColor(__ref._tablecolor /*int*/ );
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="Act.AddView(Header, Left, Top , Width, RowHeight)";
_act.AddView((android.view.View)(__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()),_left,_top,_width,__ref._rowheight /*int*/ );
RDebugUtils.currentLine=4325381;
 //BA.debugLineNum = 4325381;BA.debugLine="Act.AddView(SV, Left, Top + RowHeight, Width, Hei";
_act.AddView((android.view.View)(__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getObject()),_left,(int) (_top+__ref._rowheight /*int*/ ),_width,(int) (_height-__ref._rowheight /*int*/ ));
RDebugUtils.currentLine=4325382;
 //BA.debugLineNum = 4325382;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
__ref._columnwidth /*int*/  = (int) (__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getWidth()/(double)__ref._numberofcolumns /*int*/ );
RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="SV_ScrollChanged(0)";
__ref._sv_scrollchanged /*String*/ (null,(int) (0));
RDebugUtils.currentLine=4325386;
 //BA.debugLineNum = 4325386;BA.debugLine="End Sub";
return "";
}
public String  _initialize(b4a.OPTUMizerPatient.table __ref,anywheresoftware.b4a.BA _ba,Object _callbackmodule,String _eventname,int _vnumberofcolumns) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_callbackmodule,_eventname,_vnumberofcolumns}));}
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Public Sub Initialize (CallbackModule As Object, E";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="SV.Initialize2(0, \"SV\")";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .Initialize2(ba,(int) (0),"SV");
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="SV.Panel.Color = TableColor";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getPanel().setColor(__ref._tablecolor /*int*/ );
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="Callback = CallbackModule";
__ref._callback /*Object*/  = _callbackmodule;
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="Event = EventName";
__ref._event /*String*/  = _eventname;
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="innerClearAll(vNumberOfColumns)";
__ref._innerclearall /*String*/ (null,_vnumberofcolumns);
RDebugUtils.currentLine=3997702;
 //BA.debugLineNum = 3997702;BA.debugLine="End Sub";
return "";
}
public String  _addrow(b4a.OPTUMizerPatient.table __ref,String[] _values) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "addrow", false))
	 {return ((String) Debug.delegate(ba, "addrow", new Object[] {_values}));}
int _lastrow = 0;
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Public Sub AddRow(Values() As String)";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="If Values.Length <> NumberOfColumns Then";
if (_values.length!=__ref._numberofcolumns /*int*/ ) { 
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="Log(\"Wrong number of values.\")";
__c.LogImpl("24390914","Wrong number of values.",0);
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="Data.Add(Values)";
__ref._data /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)(_values));
RDebugUtils.currentLine=4390918;
 //BA.debugLineNum = 4390918;BA.debugLine="Dim lastRow As Int";
_lastrow = 0;
RDebugUtils.currentLine=4390919;
 //BA.debugLineNum = 4390919;BA.debugLine="lastRow = Data.Size - 1";
_lastrow = (int) (__ref._data /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1);
RDebugUtils.currentLine=4390920;
 //BA.debugLineNum = 4390920;BA.debugLine="If lastRow < (SV.ScrollPosition + SV.Height) / Ro";
if (_lastrow<(__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getScrollPosition()+__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getHeight())/(double)__ref._rowheight /*int*/ +1) { 
RDebugUtils.currentLine=4390921;
 //BA.debugLineNum = 4390921;BA.debugLine="ShowRow(lastRow)";
__ref._showrow /*String*/ (null,_lastrow);
 };
RDebugUtils.currentLine=4390923;
 //BA.debugLineNum = 4390923;BA.debugLine="SV.Panel.Height = Data.Size * RowHeight";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getPanel().setHeight((int) (__ref._data /*anywheresoftware.b4a.objects.collections.List*/ .getSize()*__ref._rowheight /*int*/ ));
RDebugUtils.currentLine=4390924;
 //BA.debugLineNum = 4390924;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Private Sub ShowRow(row As Int)";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="If visibleRows.ContainsKey(row) Then Return";
if (__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .ContainsKey((Object)(_row))) { 
if (true) return "";};
RDebugUtils.currentLine=4456451;
 //BA.debugLineNum = 4456451;BA.debugLine="Dim lbls() As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=4456452;
 //BA.debugLineNum = 4456452;BA.debugLine="Dim values() As String";
_values = new String[(int) (0)];
java.util.Arrays.fill(_values,"");
RDebugUtils.currentLine=4456453;
 //BA.debugLineNum = 4456453;BA.debugLine="lbls = GetLabels(row)";
_lbls = __ref._getlabels /*anywheresoftware.b4a.objects.LabelWrapper[]*/ (null,_row);
RDebugUtils.currentLine=4456454;
 //BA.debugLineNum = 4456454;BA.debugLine="values = Data.Get(row)";
_values = (String[])(__ref._data /*anywheresoftware.b4a.objects.collections.List*/ .Get(_row));
RDebugUtils.currentLine=4456455;
 //BA.debugLineNum = 4456455;BA.debugLine="visibleRows.Put(row, lbls)";
__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)(_row),(Object)(_lbls));
RDebugUtils.currentLine=4456456;
 //BA.debugLineNum = 4456456;BA.debugLine="Dim rowColor() As Object";
_rowcolor = new Object[(int) (0)];
{
int d0 = _rowcolor.length;
for (int i0 = 0;i0 < d0;i0++) {
_rowcolor[i0] = new Object();
}
}
;
RDebugUtils.currentLine=4456457;
 //BA.debugLineNum = 4456457;BA.debugLine="If row = SelectedRow Then";
if (_row==__ref._selectedrow /*int*/ ) { 
RDebugUtils.currentLine=4456458;
 //BA.debugLineNum = 4456458;BA.debugLine="rowColor = SelectedDrawable";
_rowcolor = __ref._selecteddrawable /*Object[]*/ ;
 }else 
{RDebugUtils.currentLine=4456459;
 //BA.debugLineNum = 4456459;BA.debugLine="Else If row Mod 2 = 0 Then";
if (_row%2==0) { 
RDebugUtils.currentLine=4456460;
 //BA.debugLineNum = 4456460;BA.debugLine="rowColor = Drawable1";
_rowcolor = __ref._drawable1 /*Object[]*/ ;
 }else {
RDebugUtils.currentLine=4456462;
 //BA.debugLineNum = 4456462;BA.debugLine="rowColor = Drawable2";
_rowcolor = __ref._drawable2 /*Object[]*/ ;
 }}
;
RDebugUtils.currentLine=4456464;
 //BA.debugLineNum = 4456464;BA.debugLine="For I = 0 To lbls.Length - 1";
{
final int step15 = 1;
final int limit15 = (int) (_lbls.length-1);
_i = (int) (0) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
RDebugUtils.currentLine=4456465;
 //BA.debugLineNum = 4456465;BA.debugLine="SV.Panel.AddView(lbls(I), Header.GetView(I).Left";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getPanel().AddView((android.view.View)(_lbls[_i].getObject()),__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetView(_i).getLeft(),(int) (_row*__ref._rowheight /*int*/ ),__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetView(_i).getWidth(),(int) (__ref._rowheight /*int*/ -__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=4456467;
 //BA.debugLineNum = 4456467;BA.debugLine="lbls(I).Text = values(I)";
_lbls[_i].setText(BA.ObjectToCharSequence(_values[_i]));
RDebugUtils.currentLine=4456468;
 //BA.debugLineNum = 4456468;BA.debugLine="lbls(I).Background = rowColor(I)";
_lbls[_i].setBackground((android.graphics.drawable.Drawable)(_rowcolor[_i]));
 }
};
RDebugUtils.currentLine=4456470;
 //BA.debugLineNum = 4456470;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Private Sub SV_ScrollChanged(Position As Int)";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="Dim currentMin, currentMax As Int";
_currentmin = 0;
_currentmax = 0;
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="currentMin = Max(0, Position / RowHeight - 30)";
_currentmin = (int) (__c.Max(0,_position/(double)__ref._rowheight /*int*/ -30));
RDebugUtils.currentLine=4259843;
 //BA.debugLineNum = 4259843;BA.debugLine="currentMax = Min(Data.Size - 1, (Position + SV.He";
_currentmax = (int) (__c.Min(__ref._data /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1,(_position+__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getHeight())/(double)__ref._rowheight /*int*/ +30));
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="If minVisibleRow > -1 Then";
if (__ref._minvisiblerow /*int*/ >-1) { 
RDebugUtils.currentLine=4259845;
 //BA.debugLineNum = 4259845;BA.debugLine="If minVisibleRow < currentMin Then";
if (__ref._minvisiblerow /*int*/ <_currentmin) { 
RDebugUtils.currentLine=4259847;
 //BA.debugLineNum = 4259847;BA.debugLine="For I = minVisibleRow To Min(currentMin - 1, ma";
{
final int step6 = 1;
final int limit6 = (int) (__c.Min(_currentmin-1,__ref._maxvisiblerow /*int*/ ));
_i = __ref._minvisiblerow /*int*/  ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=4259848;
 //BA.debugLineNum = 4259848;BA.debugLine="HideRow(I)";
__ref._hiderow /*String*/ (null,_i);
 }
};
 }else 
{RDebugUtils.currentLine=4259850;
 //BA.debugLineNum = 4259850;BA.debugLine="Else If minVisibleRow > currentMin Then";
if (__ref._minvisiblerow /*int*/ >_currentmin) { 
RDebugUtils.currentLine=4259852;
 //BA.debugLineNum = 4259852;BA.debugLine="For I = currentMin To Min(minVisibleRow - 1, cu";
{
final int step10 = 1;
final int limit10 = (int) (__c.Min(__ref._minvisiblerow /*int*/ -1,_currentmax));
_i = _currentmin ;
for (;_i <= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=4259853;
 //BA.debugLineNum = 4259853;BA.debugLine="ShowRow(I)";
__ref._showrow /*String*/ (null,_i);
 }
};
 }}
;
RDebugUtils.currentLine=4259856;
 //BA.debugLineNum = 4259856;BA.debugLine="If maxVisibleRow > currentMax Then";
if (__ref._maxvisiblerow /*int*/ >_currentmax) { 
RDebugUtils.currentLine=4259858;
 //BA.debugLineNum = 4259858;BA.debugLine="For I = maxVisibleRow To Max(currentMax + 1, mi";
{
final int step15 = -1;
final int limit15 = (int) (__c.Max(_currentmax+1,__ref._minvisiblerow /*int*/ ));
_i = __ref._maxvisiblerow /*int*/  ;
for (;_i >= limit15 ;_i = _i + step15 ) {
RDebugUtils.currentLine=4259859;
 //BA.debugLineNum = 4259859;BA.debugLine="HideRow(I)";
__ref._hiderow /*String*/ (null,_i);
 }
};
 }else 
{RDebugUtils.currentLine=4259861;
 //BA.debugLineNum = 4259861;BA.debugLine="Else If maxVisibleRow < currentMax Then";
if (__ref._maxvisiblerow /*int*/ <_currentmax) { 
RDebugUtils.currentLine=4259863;
 //BA.debugLineNum = 4259863;BA.debugLine="For I = currentMax To Max(maxVisibleRow + 1, cu";
{
final int step19 = -1;
final int limit19 = (int) (__c.Max(__ref._maxvisiblerow /*int*/ +1,_currentmin));
_i = _currentmax ;
for (;_i >= limit19 ;_i = _i + step19 ) {
RDebugUtils.currentLine=4259864;
 //BA.debugLineNum = 4259864;BA.debugLine="ShowRow(I)";
__ref._showrow /*String*/ (null,_i);
 }
};
 }}
;
 };
RDebugUtils.currentLine=4259868;
 //BA.debugLineNum = 4259868;BA.debugLine="minVisibleRow = currentMin";
__ref._minvisiblerow /*int*/  = _currentmin;
RDebugUtils.currentLine=4259869;
 //BA.debugLineNum = 4259869;BA.debugLine="maxVisibleRow = currentMax";
__ref._maxvisiblerow /*int*/  = _currentmax;
RDebugUtils.currentLine=4259870;
 //BA.debugLineNum = 4259870;BA.debugLine="End Sub";
return "";
}
public String  _cell_click(b4a.OPTUMizerPatient.table __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "cell_click", false))
	 {return ((String) Debug.delegate(ba, "cell_click", null));}
b4a.OPTUMizerPatient.table._rowcol _rc = null;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Private Sub Cell_Click";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="Dim rc As RowCol";
_rc = new b4a.OPTUMizerPatient.table._rowcol();
RDebugUtils.currentLine=4849666;
 //BA.debugLineNum = 4849666;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4849667;
 //BA.debugLineNum = 4849667;BA.debugLine="l = Sender";
_l.setObject((android.widget.TextView)(__c.Sender(ba)));
RDebugUtils.currentLine=4849668;
 //BA.debugLineNum = 4849668;BA.debugLine="rc = l.Tag";
_rc = (b4a.OPTUMizerPatient.table._rowcol)(_l.getTag());
RDebugUtils.currentLine=4849669;
 //BA.debugLineNum = 4849669;BA.debugLine="SelectRow(rc.Row)";
__ref._selectrow /*String*/ (null,_rc.Row /*int*/ );
RDebugUtils.currentLine=4849670;
 //BA.debugLineNum = 4849670;BA.debugLine="If SubExists(Callback, Event & \"_CellClick\") Then";
if (__c.SubExists(ba,__ref._callback /*Object*/ ,__ref._event /*String*/ +"_CellClick")) { 
RDebugUtils.currentLine=4849671;
 //BA.debugLineNum = 4849671;BA.debugLine="CallSub3(Callback, Event & \"_CellClick\", rc.Col,";
__c.CallSubNew3(ba,__ref._callback /*Object*/ ,__ref._event /*String*/ +"_CellClick",(Object)(_rc.Col /*int*/ ),(Object)(_rc.Row /*int*/ ));
 };
RDebugUtils.currentLine=4849673;
 //BA.debugLineNum = 4849673;BA.debugLine="End Sub";
return "";
}
public String  _selectrow(b4a.OPTUMizerPatient.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "selectrow", false))
	 {return ((String) Debug.delegate(ba, "selectrow", new Object[] {_row}));}
int _prev = 0;
int _col = 0;
RDebugUtils.currentLine=5111808;
 //BA.debugLineNum = 5111808;BA.debugLine="Private Sub SelectRow(Row As Int)";
RDebugUtils.currentLine=5111809;
 //BA.debugLineNum = 5111809;BA.debugLine="Dim prev As Int";
_prev = 0;
RDebugUtils.currentLine=5111810;
 //BA.debugLineNum = 5111810;BA.debugLine="prev = SelectedRow";
_prev = __ref._selectedrow /*int*/ ;
RDebugUtils.currentLine=5111811;
 //BA.debugLineNum = 5111811;BA.debugLine="SelectedRow = Row";
__ref._selectedrow /*int*/  = _row;
RDebugUtils.currentLine=5111813;
 //BA.debugLineNum = 5111813;BA.debugLine="If prev > -1 Then";
if (_prev>-1) { 
RDebugUtils.currentLine=5111814;
 //BA.debugLineNum = 5111814;BA.debugLine="If visibleRows.ContainsKey(prev) Then";
if (__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .ContainsKey((Object)(_prev))) { 
RDebugUtils.currentLine=5111815;
 //BA.debugLineNum = 5111815;BA.debugLine="HideRow(prev)";
__ref._hiderow /*String*/ (null,_prev);
RDebugUtils.currentLine=5111816;
 //BA.debugLineNum = 5111816;BA.debugLine="ShowRow(prev)";
__ref._showrow /*String*/ (null,_prev);
 };
 };
RDebugUtils.currentLine=5111819;
 //BA.debugLineNum = 5111819;BA.debugLine="SelectedRow = Row";
__ref._selectedrow /*int*/  = _row;
RDebugUtils.currentLine=5111820;
 //BA.debugLineNum = 5111820;BA.debugLine="For col = 0 To NumberOfColumns - 1";
{
final int step11 = 1;
final int limit11 = (int) (__ref._numberofcolumns /*int*/ -1);
_col = (int) (0) ;
for (;_col <= limit11 ;_col = _col + step11 ) {
RDebugUtils.currentLine=5111821;
 //BA.debugLineNum = 5111821;BA.debugLine="If visibleRows.ContainsKey(SelectedRow) Then";
if (__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .ContainsKey((Object)(__ref._selectedrow /*int*/ ))) { 
RDebugUtils.currentLine=5111822;
 //BA.debugLineNum = 5111822;BA.debugLine="HideRow(SelectedRow)";
__ref._hiderow /*String*/ (null,__ref._selectedrow /*int*/ );
RDebugUtils.currentLine=5111823;
 //BA.debugLineNum = 5111823;BA.debugLine="ShowRow(SelectedRow)";
__ref._showrow /*String*/ (null,__ref._selectedrow /*int*/ );
 };
 }
};
RDebugUtils.currentLine=5111826;
 //BA.debugLineNum = 5111826;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.OPTUMizerPatient.table __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="Private StringUtils1 As StringUtils";
_stringutils1 = new anywheresoftware.b4a.objects.StringUtils();
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="Private SV As ScrollView";
_sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="Private Header As Panel";
_header = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="Private Callback As Object";
_callback = new Object();
RDebugUtils.currentLine=3932165;
 //BA.debugLineNum = 3932165;BA.debugLine="Private Event As String";
_event = "";
RDebugUtils.currentLine=3932166;
 //BA.debugLineNum = 3932166;BA.debugLine="Private SelectedRow As Int";
_selectedrow = 0;
RDebugUtils.currentLine=3932167;
 //BA.debugLineNum = 3932167;BA.debugLine="Private Data As List";
_data = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3932168;
 //BA.debugLineNum = 3932168;BA.debugLine="Private LabelsCache As List";
_labelscache = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3932169;
 //BA.debugLineNum = 3932169;BA.debugLine="Private minVisibleRow, maxVisibleRow As Int";
_minvisiblerow = 0;
_maxvisiblerow = 0;
RDebugUtils.currentLine=3932170;
 //BA.debugLineNum = 3932170;BA.debugLine="Private visible As Boolean";
_visible = false;
RDebugUtils.currentLine=3932171;
 //BA.debugLineNum = 3932171;BA.debugLine="Private visibleRows As Map";
_visiblerows = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=3932172;
 //BA.debugLineNum = 3932172;BA.debugLine="Private NumberOfColumns, ColumnWidth As Int";
_numberofcolumns = 0;
_columnwidth = 0;
RDebugUtils.currentLine=3932173;
 //BA.debugLineNum = 3932173;BA.debugLine="Public RowHeight, HeaderColor, TableColor, FontCo";
_rowheight = 0;
_headercolor = 0;
_tablecolor = 0;
_fontcolor = 0;
_headerfontcolor = 0;
RDebugUtils.currentLine=3932174;
 //BA.debugLineNum = 3932174;BA.debugLine="Public FontSize As Float";
_fontsize = 0f;
RDebugUtils.currentLine=3932175;
 //BA.debugLineNum = 3932175;BA.debugLine="Type RowCol (Row As Int, Col As Int)";
;
RDebugUtils.currentLine=3932176;
 //BA.debugLineNum = 3932176;BA.debugLine="Public Alignment As Int";
_alignment = 0;
RDebugUtils.currentLine=3932177;
 //BA.debugLineNum = 3932177;BA.debugLine="Public SelectedDrawable(), Drawable1(), Drawable2";
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
RDebugUtils.currentLine=3932179;
 //BA.debugLineNum = 3932179;BA.debugLine="HeaderColor = Colors.Gray";
__ref._headercolor /*int*/  = __c.Colors.Gray;
RDebugUtils.currentLine=3932180;
 //BA.debugLineNum = 3932180;BA.debugLine="RowHeight = 30dip";
__ref._rowheight /*int*/  = __c.DipToCurrent((int) (30));
RDebugUtils.currentLine=3932181;
 //BA.debugLineNum = 3932181;BA.debugLine="TableColor = Colors.LightGray";
__ref._tablecolor /*int*/  = __c.Colors.LightGray;
RDebugUtils.currentLine=3932182;
 //BA.debugLineNum = 3932182;BA.debugLine="FontColor = Colors.Black";
__ref._fontcolor /*int*/  = __c.Colors.Black;
RDebugUtils.currentLine=3932183;
 //BA.debugLineNum = 3932183;BA.debugLine="HeaderFontColor = Colors.White";
__ref._headerfontcolor /*int*/  = __c.Colors.White;
RDebugUtils.currentLine=3932184;
 //BA.debugLineNum = 3932184;BA.debugLine="FontSize = 14";
__ref._fontsize /*float*/  = (float) (14);
RDebugUtils.currentLine=3932185;
 //BA.debugLineNum = 3932185;BA.debugLine="Alignment = Gravity.CENTER 'change to Gravity.LEF";
__ref._alignment /*int*/  = __c.Gravity.CENTER;
RDebugUtils.currentLine=3932186;
 //BA.debugLineNum = 3932186;BA.debugLine="End Sub";
return "";
}
public String  _clearall(b4a.OPTUMizerPatient.table __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "clearall", false))
	 {return ((String) Debug.delegate(ba, "clearall", null));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Public Sub ClearAll";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="innerClearAll(NumberOfColumns)";
__ref._innerclearall /*String*/ (null,__ref._numberofcolumns /*int*/ );
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="public Sub innerClearAll(vNumberOfColumns As Int)";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="For i = SV.Panel.NumberOfViews -1 To 0 Step -1";
{
final int step1 = -1;
final int limit1 = (int) (0);
_i = (int) (__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getPanel().getNumberOfViews()-1) ;
for (;_i >= limit1 ;_i = _i + step1 ) {
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="SV.Panel.RemoveViewAt(i)";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getPanel().RemoveViewAt(_i);
 }
};
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="NumberOfColumns = vNumberOfColumns";
__ref._numberofcolumns /*int*/  = _vnumberofcolumns;
RDebugUtils.currentLine=4194309;
 //BA.debugLineNum = 4194309;BA.debugLine="Dim Drawable1(NumberOfColumns) As Object";
_drawable1 = new Object[__ref._numberofcolumns /*int*/ ];
{
int d0 = _drawable1.length;
for (int i0 = 0;i0 < d0;i0++) {
_drawable1[i0] = new Object();
}
}
;
RDebugUtils.currentLine=4194310;
 //BA.debugLineNum = 4194310;BA.debugLine="Dim Drawable2(NumberOfColumns) As Object";
_drawable2 = new Object[__ref._numberofcolumns /*int*/ ];
{
int d0 = _drawable2.length;
for (int i0 = 0;i0 < d0;i0++) {
_drawable2[i0] = new Object();
}
}
;
RDebugUtils.currentLine=4194311;
 //BA.debugLineNum = 4194311;BA.debugLine="Dim SelectedDrawable(NumberOfColumns) As Object";
_selecteddrawable = new Object[__ref._numberofcolumns /*int*/ ];
{
int d0 = _selecteddrawable.length;
for (int i0 = 0;i0 < d0;i0++) {
_selecteddrawable[i0] = new Object();
}
}
;
RDebugUtils.currentLine=4194312;
 //BA.debugLineNum = 4194312;BA.debugLine="For i = 0 To NumberOfColumns - 1";
{
final int step8 = 1;
final int limit8 = (int) (__ref._numberofcolumns /*int*/ -1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
RDebugUtils.currentLine=4194313;
 //BA.debugLineNum = 4194313;BA.debugLine="Dim cd1, cd2, cd3 As ColorDrawable";
_cd1 = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
_cd2 = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
_cd3 = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=4194314;
 //BA.debugLineNum = 4194314;BA.debugLine="cd1.Initialize(Colors.White, 0)";
_cd1.Initialize(__c.Colors.White,(int) (0));
RDebugUtils.currentLine=4194315;
 //BA.debugLineNum = 4194315;BA.debugLine="cd2.Initialize(0xFF98F5FF, 0)";
_cd2.Initialize((int) (0xff98f5ff),(int) (0));
RDebugUtils.currentLine=4194316;
 //BA.debugLineNum = 4194316;BA.debugLine="cd3.Initialize(0xFF007FFF, 0)";
_cd3.Initialize((int) (0xff007fff),(int) (0));
RDebugUtils.currentLine=4194317;
 //BA.debugLineNum = 4194317;BA.debugLine="Drawable1(i) = cd1";
__ref._drawable1 /*Object[]*/ [_i] = (Object)(_cd1.getObject());
RDebugUtils.currentLine=4194318;
 //BA.debugLineNum = 4194318;BA.debugLine="Drawable2(i) = cd2";
__ref._drawable2 /*Object[]*/ [_i] = (Object)(_cd2.getObject());
RDebugUtils.currentLine=4194319;
 //BA.debugLineNum = 4194319;BA.debugLine="SelectedDrawable(i) = cd3";
__ref._selecteddrawable /*Object[]*/ [_i] = (Object)(_cd3.getObject());
 }
};
RDebugUtils.currentLine=4194321;
 //BA.debugLineNum = 4194321;BA.debugLine="SV.Panel.Height = 0";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getPanel().setHeight((int) (0));
RDebugUtils.currentLine=4194322;
 //BA.debugLineNum = 4194322;BA.debugLine="SelectedRow = -1";
__ref._selectedrow /*int*/  = (int) (-1);
RDebugUtils.currentLine=4194323;
 //BA.debugLineNum = 4194323;BA.debugLine="minVisibleRow = -1";
__ref._minvisiblerow /*int*/  = (int) (-1);
RDebugUtils.currentLine=4194324;
 //BA.debugLineNum = 4194324;BA.debugLine="maxVisibleRow = 0";
__ref._maxvisiblerow /*int*/  = (int) (0);
RDebugUtils.currentLine=4194325;
 //BA.debugLineNum = 4194325;BA.debugLine="Data.Initialize";
__ref._data /*anywheresoftware.b4a.objects.collections.List*/ .Initialize();
RDebugUtils.currentLine=4194326;
 //BA.debugLineNum = 4194326;BA.debugLine="LabelsCache.Initialize";
__ref._labelscache /*anywheresoftware.b4a.objects.collections.List*/ .Initialize();
RDebugUtils.currentLine=4194327;
 //BA.debugLineNum = 4194327;BA.debugLine="visibleRows.Initialize";
__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .Initialize();
RDebugUtils.currentLine=4194328;
 //BA.debugLineNum = 4194328;BA.debugLine="SV.ScrollPosition = 0";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .setScrollPosition((int) (0));
RDebugUtils.currentLine=4194329;
 //BA.debugLineNum = 4194329;BA.debugLine="DoEvents";
__c.DoEvents();
RDebugUtils.currentLine=4194330;
 //BA.debugLineNum = 4194330;BA.debugLine="SV.ScrollPosition = 0";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .setScrollPosition((int) (0));
RDebugUtils.currentLine=4194331;
 //BA.debugLineNum = 4194331;BA.debugLine="For i = 1 To 80 'fill the cache to avoid delay on";
{
final int step27 = 1;
final int limit27 = (int) (80);
_i = (int) (1) ;
for (;_i <= limit27 ;_i = _i + step27 ) {
RDebugUtils.currentLine=4194332;
 //BA.debugLineNum = 4194332;BA.debugLine="LabelsCache.Add(CreateNewLabels)";
__ref._labelscache /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)(__ref._createnewlabels /*anywheresoftware.b4a.objects.LabelWrapper[]*/ (null)));
 }
};
RDebugUtils.currentLine=4194334;
 //BA.debugLineNum = 4194334;BA.debugLine="If visible Then";
if (__ref._visible /*boolean*/ ) { 
RDebugUtils.currentLine=4194335;
 //BA.debugLineNum = 4194335;BA.debugLine="SV_ScrollChanged(0)";
__ref._sv_scrollchanged /*String*/ (null,(int) (0));
 };
RDebugUtils.currentLine=4194337;
 //BA.debugLineNum = 4194337;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Private Sub CreateNewLabels As Label()";
RDebugUtils.currentLine=4718593;
 //BA.debugLineNum = 4718593;BA.debugLine="Dim lbls(NumberOfColumns) As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[__ref._numberofcolumns /*int*/ ];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="For I = 0 To NumberOfColumns - 1";
{
final int step2 = 1;
final int limit2 = (int) (__ref._numberofcolumns /*int*/ -1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=4718595;
 //BA.debugLineNum = 4718595;BA.debugLine="Dim rc As RowCol";
_rc = new b4a.OPTUMizerPatient.table._rowcol();
RDebugUtils.currentLine=4718596;
 //BA.debugLineNum = 4718596;BA.debugLine="rc.Col = I";
_rc.Col /*int*/  = _i;
RDebugUtils.currentLine=4718597;
 //BA.debugLineNum = 4718597;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4718598;
 //BA.debugLineNum = 4718598;BA.debugLine="l.Initialize(\"cell\")";
_l.Initialize(ba,"cell");
RDebugUtils.currentLine=4718599;
 //BA.debugLineNum = 4718599;BA.debugLine="l.Gravity = Alignment";
_l.setGravity(__ref._alignment /*int*/ );
RDebugUtils.currentLine=4718600;
 //BA.debugLineNum = 4718600;BA.debugLine="l.TextSize = FontSize";
_l.setTextSize(__ref._fontsize /*float*/ );
RDebugUtils.currentLine=4718601;
 //BA.debugLineNum = 4718601;BA.debugLine="l.TextColor = FontColor";
_l.setTextColor(__ref._fontcolor /*int*/ );
RDebugUtils.currentLine=4718602;
 //BA.debugLineNum = 4718602;BA.debugLine="l.Tag = rc";
_l.setTag((Object)(_rc));
RDebugUtils.currentLine=4718603;
 //BA.debugLineNum = 4718603;BA.debugLine="lbls(I) = l";
_lbls[_i] = _l;
 }
};
RDebugUtils.currentLine=4718605;
 //BA.debugLineNum = 4718605;BA.debugLine="Return lbls";
if (true) return _lbls;
RDebugUtils.currentLine=4718606;
 //BA.debugLineNum = 4718606;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Private Sub GetLabels(Row As Int) As Label()";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="Dim lbls() As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="If LabelsCache.Size > 0 Then";
if (__ref._labelscache /*anywheresoftware.b4a.objects.collections.List*/ .getSize()>0) { 
RDebugUtils.currentLine=4653060;
 //BA.debugLineNum = 4653060;BA.debugLine="lbls = LabelsCache.Get(LabelsCache.Size - 1)";
_lbls = (anywheresoftware.b4a.objects.LabelWrapper[])(__ref._labelscache /*anywheresoftware.b4a.objects.collections.List*/ .Get((int) (__ref._labelscache /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1)));
RDebugUtils.currentLine=4653061;
 //BA.debugLineNum = 4653061;BA.debugLine="LabelsCache.RemoveAt(LabelsCache.Size - 1)";
__ref._labelscache /*anywheresoftware.b4a.objects.collections.List*/ .RemoveAt((int) (__ref._labelscache /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1));
 }else {
RDebugUtils.currentLine=4653063;
 //BA.debugLineNum = 4653063;BA.debugLine="lbls = CreateNewLabels";
_lbls = __ref._createnewlabels /*anywheresoftware.b4a.objects.LabelWrapper[]*/ (null);
 };
RDebugUtils.currentLine=4653065;
 //BA.debugLineNum = 4653065;BA.debugLine="For I = 0 To lbls.Length - 1";
{
final int step8 = 1;
final int limit8 = (int) (_lbls.length-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
RDebugUtils.currentLine=4653066;
 //BA.debugLineNum = 4653066;BA.debugLine="Dim rc As RowCol";
_rc = new b4a.OPTUMizerPatient.table._rowcol();
RDebugUtils.currentLine=4653067;
 //BA.debugLineNum = 4653067;BA.debugLine="rc = lbls(I).Tag";
_rc = (b4a.OPTUMizerPatient.table._rowcol)(_lbls[_i].getTag());
RDebugUtils.currentLine=4653068;
 //BA.debugLineNum = 4653068;BA.debugLine="rc.Row = Row";
_rc.Row /*int*/  = _row;
 }
};
RDebugUtils.currentLine=4653070;
 //BA.debugLineNum = 4653070;BA.debugLine="Return lbls";
if (true) return _lbls;
RDebugUtils.currentLine=4653071;
 //BA.debugLineNum = 4653071;BA.debugLine="End Sub";
return null;
}
public String  _header_click(b4a.OPTUMizerPatient.table __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "header_click", false))
	 {return ((String) Debug.delegate(ba, "header_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _l = null;
int _col = 0;
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Private Sub Header_Click";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4915202;
 //BA.debugLineNum = 4915202;BA.debugLine="Dim col As Int";
_col = 0;
RDebugUtils.currentLine=4915203;
 //BA.debugLineNum = 4915203;BA.debugLine="l = Sender";
_l.setObject((android.widget.TextView)(__c.Sender(ba)));
RDebugUtils.currentLine=4915204;
 //BA.debugLineNum = 4915204;BA.debugLine="col = l.Tag";
_col = (int)(BA.ObjectToNumber(_l.getTag()));
RDebugUtils.currentLine=4915205;
 //BA.debugLineNum = 4915205;BA.debugLine="If SubExists(Callback, Event & \"_HeaderClick\") Th";
if (__c.SubExists(ba,__ref._callback /*Object*/ ,__ref._event /*String*/ +"_HeaderClick")) { 
RDebugUtils.currentLine=4915206;
 //BA.debugLineNum = 4915206;BA.debugLine="CallSub2(Callback, Event & \"_HeaderClick\", col)";
__c.CallSubNew2(ba,__ref._callback /*Object*/ ,__ref._event /*String*/ +"_HeaderClick",(Object)(_col));
 };
RDebugUtils.currentLine=4915208;
 //BA.debugLineNum = 4915208;BA.debugLine="End Sub";
return "";
}
public String  _hiderow(b4a.OPTUMizerPatient.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "hiderow", false))
	 {return ((String) Debug.delegate(ba, "hiderow", new Object[] {_row}));}
anywheresoftware.b4a.objects.LabelWrapper[] _lbls = null;
int _i = 0;
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Private Sub HideRow (Row As Int)";
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="Dim lbls() As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=4587523;
 //BA.debugLineNum = 4587523;BA.debugLine="lbls = visibleRows.Get(Row)";
_lbls = (anywheresoftware.b4a.objects.LabelWrapper[])(__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(_row)));
RDebugUtils.currentLine=4587524;
 //BA.debugLineNum = 4587524;BA.debugLine="If lbls = Null Then";
if (_lbls== null) { 
RDebugUtils.currentLine=4587525;
 //BA.debugLineNum = 4587525;BA.debugLine="Log(\"HideRow: (null) \" & Row)";
__c.LogImpl("24587525","HideRow: (null) "+BA.NumberToString(_row),0);
RDebugUtils.currentLine=4587526;
 //BA.debugLineNum = 4587526;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=4587528;
 //BA.debugLineNum = 4587528;BA.debugLine="For I = 0 To lbls.Length - 1";
{
final int step7 = 1;
final int limit7 = (int) (_lbls.length-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
RDebugUtils.currentLine=4587529;
 //BA.debugLineNum = 4587529;BA.debugLine="lbls(I).RemoveView";
_lbls[_i].RemoveView();
 }
};
RDebugUtils.currentLine=4587531;
 //BA.debugLineNum = 4587531;BA.debugLine="visibleRows.Remove(Row)";
__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .Remove((Object)(_row));
RDebugUtils.currentLine=4587532;
 //BA.debugLineNum = 4587532;BA.debugLine="LabelsCache.Add(lbls)";
__ref._labelscache /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)(_lbls));
RDebugUtils.currentLine=4587533;
 //BA.debugLineNum = 4587533;BA.debugLine="End Sub";
return "";
}
public boolean  _isrowvisible(b4a.OPTUMizerPatient.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "isrowvisible", false))
	 {return ((Boolean) Debug.delegate(ba, "isrowvisible", new Object[] {_row}));}
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Private Sub IsRowVisible(Row As Int) As Boolean";
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="Return Row < (SV.ScrollPosition + SV.Height) / (R";
if (true) return _row<(__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getScrollPosition()+__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getHeight())/(double)(__ref._rowheight /*int*/ +1) && _row>__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getScrollPosition()/(double)__ref._rowheight /*int*/ ;
RDebugUtils.currentLine=4521987;
 //BA.debugLineNum = 4521987;BA.debugLine="End Sub";
return false;
}
public String  _jumptorow(b4a.OPTUMizerPatient.table __ref,int _row) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "jumptorow", false))
	 {return ((String) Debug.delegate(ba, "jumptorow", new Object[] {_row}));}
RDebugUtils.currentLine=5177344;
 //BA.debugLineNum = 5177344;BA.debugLine="Public Sub JumpToRow(Row As Int)";
RDebugUtils.currentLine=5177345;
 //BA.debugLineNum = 5177345;BA.debugLine="SV.ScrollPosition = Row * RowHeight";
__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .setScrollPosition((int) (_row*__ref._rowheight /*int*/ ));
RDebugUtils.currentLine=5177346;
 //BA.debugLineNum = 5177346;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=5242880;
 //BA.debugLineNum = 5242880;BA.debugLine="Public Sub LoadTableFromCSV(Dir As String, Filenam";
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="Dim List1 As List";
_list1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5242883;
 //BA.debugLineNum = 5242883;BA.debugLine="Dim h() As String";
_h = new String[(int) (0)];
java.util.Arrays.fill(_h,"");
RDebugUtils.currentLine=5242884;
 //BA.debugLineNum = 5242884;BA.debugLine="If HeadersExist Then";
if (_headersexist) { 
RDebugUtils.currentLine=5242885;
 //BA.debugLineNum = 5242885;BA.debugLine="Dim headers As List";
_headers = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5242886;
 //BA.debugLineNum = 5242886;BA.debugLine="List1 = StringUtils1.LoadCSV2(Dir, Filename, \",\"";
_list1 = __ref._stringutils1 /*anywheresoftware.b4a.objects.StringUtils*/ .LoadCSV2(_dir,_filename,BA.ObjectToChar(","),_headers);
RDebugUtils.currentLine=5242887;
 //BA.debugLineNum = 5242887;BA.debugLine="Dim h(headers.Size) As String";
_h = new String[_headers.getSize()];
java.util.Arrays.fill(_h,"");
RDebugUtils.currentLine=5242888;
 //BA.debugLineNum = 5242888;BA.debugLine="For i = 0 To headers.Size - 1";
{
final int step7 = 1;
final int limit7 = (int) (_headers.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
RDebugUtils.currentLine=5242889;
 //BA.debugLineNum = 5242889;BA.debugLine="h(i) = headers.Get(i)";
_h[_i] = BA.ObjectToString(_headers.Get(_i));
 }
};
 }else {
RDebugUtils.currentLine=5242892;
 //BA.debugLineNum = 5242892;BA.debugLine="List1 = StringUtils1.LoadCSV(Dir, Filename, \",\")";
_list1 = __ref._stringutils1 /*anywheresoftware.b4a.objects.StringUtils*/ .LoadCSV(_dir,_filename,BA.ObjectToChar(","));
RDebugUtils.currentLine=5242893;
 //BA.debugLineNum = 5242893;BA.debugLine="Dim firstRow() As String";
_firstrow = new String[(int) (0)];
java.util.Arrays.fill(_firstrow,"");
RDebugUtils.currentLine=5242894;
 //BA.debugLineNum = 5242894;BA.debugLine="firstRow = List1.Get(0)";
_firstrow = (String[])(_list1.Get((int) (0)));
RDebugUtils.currentLine=5242895;
 //BA.debugLineNum = 5242895;BA.debugLine="Dim h(firstRow.Length)";
_h = new String[_firstrow.length];
java.util.Arrays.fill(_h,"");
RDebugUtils.currentLine=5242896;
 //BA.debugLineNum = 5242896;BA.debugLine="For i = 0 To firstRow.Length - 1";
{
final int step15 = 1;
final int limit15 = (int) (_firstrow.length-1);
_i = (int) (0) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
RDebugUtils.currentLine=5242897;
 //BA.debugLineNum = 5242897;BA.debugLine="h(i) = \"Col\" & (i + 1)";
_h[_i] = "Col"+BA.NumberToString((_i+1));
 }
};
 };
RDebugUtils.currentLine=5242900;
 //BA.debugLineNum = 5242900;BA.debugLine="innerClearAll(h.Length)";
__ref._innerclearall /*String*/ (null,_h.length);
RDebugUtils.currentLine=5242901;
 //BA.debugLineNum = 5242901;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
__ref._columnwidth /*int*/  = (int) (__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getWidth()/(double)__ref._numberofcolumns /*int*/ );
RDebugUtils.currentLine=5242902;
 //BA.debugLineNum = 5242902;BA.debugLine="SetHeader(h)";
__ref._setheader /*String*/ (null,_h);
RDebugUtils.currentLine=5242903;
 //BA.debugLineNum = 5242903;BA.debugLine="For i = 0 To List1.Size - 1";
{
final int step22 = 1;
final int limit22 = (int) (_list1.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit22 ;_i = _i + step22 ) {
RDebugUtils.currentLine=5242904;
 //BA.debugLineNum = 5242904;BA.debugLine="Dim row() As String";
_row = new String[(int) (0)];
java.util.Arrays.fill(_row,"");
RDebugUtils.currentLine=5242905;
 //BA.debugLineNum = 5242905;BA.debugLine="row = List1.Get(i)";
_row = (String[])(_list1.Get(_i));
RDebugUtils.currentLine=5242906;
 //BA.debugLineNum = 5242906;BA.debugLine="AddRow(row)";
__ref._addrow /*String*/ (null,_row);
 }
};
RDebugUtils.currentLine=5242908;
 //BA.debugLineNum = 5242908;BA.debugLine="End Sub";
return "";
}
public String  _setheader(b4a.OPTUMizerPatient.table __ref,String[] _values) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "setheader", false))
	 {return ((String) Debug.delegate(ba, "setheader", new Object[] {_values}));}
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Public Sub SetHeader(Values() As String)";
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="For I = Header.NumberOfViews - 1 To 0 Step -1";
{
final int step1 = -1;
final int limit1 = (int) (0);
_i = (int) (__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .getNumberOfViews()-1) ;
for (;_i >= limit1 ;_i = _i + step1 ) {
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="Header.RemoveViewAt(I)";
__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .RemoveViewAt(_i);
 }
};
RDebugUtils.currentLine=4784132;
 //BA.debugLineNum = 4784132;BA.debugLine="For I = 0 To NumberOfColumns - 1";
{
final int step4 = 1;
final int limit4 = (int) (__ref._numberofcolumns /*int*/ -1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=4784133;
 //BA.debugLineNum = 4784133;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4784134;
 //BA.debugLineNum = 4784134;BA.debugLine="l.Initialize(\"header\")";
_l.Initialize(ba,"header");
RDebugUtils.currentLine=4784135;
 //BA.debugLineNum = 4784135;BA.debugLine="l.Gravity = Gravity.CENTER";
_l.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=4784136;
 //BA.debugLineNum = 4784136;BA.debugLine="l.TextSize = FontSize";
_l.setTextSize(__ref._fontsize /*float*/ );
RDebugUtils.currentLine=4784137;
 //BA.debugLineNum = 4784137;BA.debugLine="l.Color = HeaderColor";
_l.setColor(__ref._headercolor /*int*/ );
RDebugUtils.currentLine=4784138;
 //BA.debugLineNum = 4784138;BA.debugLine="l.TextColor = HeaderFontColor";
_l.setTextColor(__ref._headerfontcolor /*int*/ );
RDebugUtils.currentLine=4784139;
 //BA.debugLineNum = 4784139;BA.debugLine="l.Text = Values(I)";
_l.setText(BA.ObjectToCharSequence(_values[_i]));
RDebugUtils.currentLine=4784140;
 //BA.debugLineNum = 4784140;BA.debugLine="l.Tag = I";
_l.setTag((Object)(_i));
RDebugUtils.currentLine=4784141;
 //BA.debugLineNum = 4784141;BA.debugLine="Header.AddView(l, ColumnWidth * I, 0, ColumnWidt";
__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .AddView((android.view.View)(_l.getObject()),(int) (__ref._columnwidth /*int*/ *_i),(int) (0),(int) (__ref._columnwidth /*int*/ -__c.DipToCurrent((int) (1))),__ref._rowheight /*int*/ );
 }
};
RDebugUtils.currentLine=4784143;
 //BA.debugLineNum = 4784143;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=5373952;
 //BA.debugLineNum = 5373952;BA.debugLine="Public Sub SaveTableToCSV(Dir As String, Filename";
RDebugUtils.currentLine=5373953;
 //BA.debugLineNum = 5373953;BA.debugLine="Dim headers(NumberOfColumns) As String";
_headers = new String[__ref._numberofcolumns /*int*/ ];
java.util.Arrays.fill(_headers,"");
RDebugUtils.currentLine=5373954;
 //BA.debugLineNum = 5373954;BA.debugLine="For i = 0 To headers.Length - 1";
{
final int step2 = 1;
final int limit2 = (int) (_headers.length-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=5373955;
 //BA.debugLineNum = 5373955;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5373956;
 //BA.debugLineNum = 5373956;BA.debugLine="l = Header.GetView(i)";
_l.setObject((android.widget.TextView)(__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetView(_i).getObject()));
RDebugUtils.currentLine=5373957;
 //BA.debugLineNum = 5373957;BA.debugLine="headers(i) = l.Text";
_headers[_i] = _l.getText();
 }
};
RDebugUtils.currentLine=5373959;
 //BA.debugLineNum = 5373959;BA.debugLine="StringUtils1.SaveCSV2(Dir, Filename, \",\", Data, h";
__ref._stringutils1 /*anywheresoftware.b4a.objects.StringUtils*/ .SaveCSV2(_dir,_filename,BA.ObjectToChar(","),__ref._data /*anywheresoftware.b4a.objects.collections.List*/ ,anywheresoftware.b4a.keywords.Common.ArrayToList(_headers));
RDebugUtils.currentLine=5373960;
 //BA.debugLineNum = 5373960;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Public Sub SetColumnsWidths(Widths() As Int)";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="Dim v As View";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="For i = 0 To Widths.Length - 1";
{
final int step2 = 1;
final int limit2 = (int) (_widths.length-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="v = Header.GetView(i)";
_v = __ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetView(_i);
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="v.Width = Widths(i) - 1dip";
_v.setWidth((int) (_widths[_i]-__c.DipToCurrent((int) (1))));
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="If i > 0 Then";
if (_i>0) { 
RDebugUtils.currentLine=4128774;
 //BA.debugLineNum = 4128774;BA.debugLine="v.Left = Header.GetView(i-1).Left + Widths(i-1)";
_v.setLeft((int) (__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetView((int) (_i-1)).getLeft()+_widths[(int) (_i-1)]+__c.DipToCurrent((int) (1))));
 };
 }
};
RDebugUtils.currentLine=4128777;
 //BA.debugLineNum = 4128777;BA.debugLine="Dim lbls() As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=4128778;
 //BA.debugLineNum = 4128778;BA.debugLine="For i = 0 To visibleRows.Size - 1";
{
final int step10 = 1;
final int limit10 = (int) (__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .getSize()-1);
_i = (int) (0) ;
for (;_i <= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=4128779;
 //BA.debugLineNum = 4128779;BA.debugLine="lbls = visibleRows.GetValueAt(i)";
_lbls = (anywheresoftware.b4a.objects.LabelWrapper[])(__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .GetValueAt(_i));
RDebugUtils.currentLine=4128780;
 //BA.debugLineNum = 4128780;BA.debugLine="For lbl = 0 To lbls.Length - 1";
{
final int step12 = 1;
final int limit12 = (int) (_lbls.length-1);
_lbl = (int) (0) ;
for (;_lbl <= limit12 ;_lbl = _lbl + step12 ) {
RDebugUtils.currentLine=4128781;
 //BA.debugLineNum = 4128781;BA.debugLine="lbls(lbl).SetLayout(Header.GetView(lbl).Left, l";
_lbls[_lbl].SetLayout(__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetView(_lbl).getLeft(),_lbls[_lbl].getTop(),__ref._header /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetView(_lbl).getWidth(),__ref._rowheight /*int*/ );
 }
};
 }
};
RDebugUtils.currentLine=4128785;
 //BA.debugLineNum = 4128785;BA.debugLine="End Sub";
return "";
}
public String  _setdatagrid(b4a.OPTUMizerPatient.table __ref,String[] _headerx,anywheresoftware.b4a.objects.collections.List _x) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "setdatagrid", false))
	 {return ((String) Debug.delegate(ba, "setdatagrid", new Object[] {_headerx,_x}));}
Object _a = null;
RDebugUtils.currentLine=5308416;
 //BA.debugLineNum = 5308416;BA.debugLine="public Sub SetDatagrid(HeaderX() As String,x As Li";
RDebugUtils.currentLine=5308418;
 //BA.debugLineNum = 5308418;BA.debugLine="innerClearAll(HeaderX.Length)";
__ref._innerclearall /*String*/ (null,_headerx.length);
RDebugUtils.currentLine=5308419;
 //BA.debugLineNum = 5308419;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
__ref._columnwidth /*int*/  = (int) (__ref._sv /*anywheresoftware.b4a.objects.ScrollViewWrapper*/ .getWidth()/(double)__ref._numberofcolumns /*int*/ );
RDebugUtils.currentLine=5308420;
 //BA.debugLineNum = 5308420;BA.debugLine="SetHeader(HeaderX)";
__ref._setheader /*String*/ (null,_headerx);
RDebugUtils.currentLine=5308421;
 //BA.debugLineNum = 5308421;BA.debugLine="For Each a In x";
{
final anywheresoftware.b4a.BA.IterableList group4 = _x;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_a = group4.Get(index4);
RDebugUtils.currentLine=5308422;
 //BA.debugLineNum = 5308422;BA.debugLine="AddRow(a)";
__ref._addrow /*String*/ (null,(String[])(_a));
 }
};
RDebugUtils.currentLine=5308424;
 //BA.debugLineNum = 5308424;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(b4a.OPTUMizerPatient.table __ref,int _col,int _row,String _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="table";
if (Debug.shouldDelegate(ba, "setvalue", false))
	 {return ((String) Debug.delegate(ba, "setvalue", new Object[] {_col,_row,_value}));}
String[] _values = null;
anywheresoftware.b4a.objects.LabelWrapper[] _lbls = null;
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Public Sub SetValue(Col As Int, Row As Int, Value";
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="Dim values() As String";
_values = new String[(int) (0)];
java.util.Arrays.fill(_values,"");
RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="values = Data.Get(Row)";
_values = (String[])(__ref._data /*anywheresoftware.b4a.objects.collections.List*/ .Get(_row));
RDebugUtils.currentLine=5046275;
 //BA.debugLineNum = 5046275;BA.debugLine="values(Col) = Value";
_values[_col] = _value;
RDebugUtils.currentLine=5046276;
 //BA.debugLineNum = 5046276;BA.debugLine="If visibleRows.ContainsKey(Row) Then";
if (__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .ContainsKey((Object)(_row))) { 
RDebugUtils.currentLine=5046277;
 //BA.debugLineNum = 5046277;BA.debugLine="Dim lbls() As Label";
_lbls = new anywheresoftware.b4a.objects.LabelWrapper[(int) (0)];
{
int d0 = _lbls.length;
for (int i0 = 0;i0 < d0;i0++) {
_lbls[i0] = new anywheresoftware.b4a.objects.LabelWrapper();
}
}
;
RDebugUtils.currentLine=5046278;
 //BA.debugLineNum = 5046278;BA.debugLine="lbls = visibleRows.Get(Row)";
_lbls = (anywheresoftware.b4a.objects.LabelWrapper[])(__ref._visiblerows /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(_row)));
RDebugUtils.currentLine=5046279;
 //BA.debugLineNum = 5046279;BA.debugLine="lbls(Col).Text = Value";
_lbls[_col].setText(BA.ObjectToCharSequence(_value));
 };
RDebugUtils.currentLine=5046281;
 //BA.debugLineNum = 5046281;BA.debugLine="End Sub";
return "";
}
}