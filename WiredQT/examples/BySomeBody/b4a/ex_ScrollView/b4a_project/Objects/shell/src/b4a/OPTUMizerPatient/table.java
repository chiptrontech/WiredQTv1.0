
package b4a.OPTUMizerPatient;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class table {
    public static RemoteObject myClass;
	public table() {
	}
    public static PCBA staticBA = new PCBA(null, table.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _stringutils1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.StringUtils");
public static RemoteObject _sv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _header = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _callback = RemoteObject.declareNull("Object");
public static RemoteObject _event = RemoteObject.createImmutable("");
public static RemoteObject _selectedrow = RemoteObject.createImmutable(0);
public static RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _labelscache = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _minvisiblerow = RemoteObject.createImmutable(0);
public static RemoteObject _maxvisiblerow = RemoteObject.createImmutable(0);
public static RemoteObject _visible = RemoteObject.createImmutable(false);
public static RemoteObject _visiblerows = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _numberofcolumns = RemoteObject.createImmutable(0);
public static RemoteObject _columnwidth = RemoteObject.createImmutable(0);
public static RemoteObject _rowheight = RemoteObject.createImmutable(0);
public static RemoteObject _headercolor = RemoteObject.createImmutable(0);
public static RemoteObject _tablecolor = RemoteObject.createImmutable(0);
public static RemoteObject _fontcolor = RemoteObject.createImmutable(0);
public static RemoteObject _headerfontcolor = RemoteObject.createImmutable(0);
public static RemoteObject _fontsize = RemoteObject.createImmutable(0f);
public static RemoteObject _alignment = RemoteObject.createImmutable(0);
public static RemoteObject _selecteddrawable = null;
public static RemoteObject _drawable1 = null;
public static RemoteObject _drawable2 = null;
public static RemoteObject _httputils2service = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httputils2service");
public static b4a.OPTUMizerPatient.main _main = null;
public static b4a.OPTUMizerPatient.starter _starter = null;
public static b4a.OPTUMizerPatient.vb6 _vb6 = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"Alignment",_ref.getField(false, "_alignment"),"Callback",_ref.getField(false, "_callback"),"ColumnWidth",_ref.getField(false, "_columnwidth"),"Data",_ref.getField(false, "_data"),"Drawable1",_ref.getField(false, "_drawable1"),"Drawable2",_ref.getField(false, "_drawable2"),"Event",_ref.getField(false, "_event"),"FontColor",_ref.getField(false, "_fontcolor"),"FontSize",_ref.getField(false, "_fontsize"),"Header",_ref.getField(false, "_header"),"HeaderColor",_ref.getField(false, "_headercolor"),"HeaderFontColor",_ref.getField(false, "_headerfontcolor"),"HttpUtils2Service",_ref.getField(false, "_httputils2service"),"LabelsCache",_ref.getField(false, "_labelscache"),"maxVisibleRow",_ref.getField(false, "_maxvisiblerow"),"minVisibleRow",_ref.getField(false, "_minvisiblerow"),"NumberOfColumns",_ref.getField(false, "_numberofcolumns"),"RowHeight",_ref.getField(false, "_rowheight"),"SelectedDrawable",_ref.getField(false, "_selecteddrawable"),"SelectedRow",_ref.getField(false, "_selectedrow"),"StringUtils1",_ref.getField(false, "_stringutils1"),"SV",_ref.getField(false, "_sv"),"TableColor",_ref.getField(false, "_tablecolor"),"visible",_ref.getField(false, "_visible"),"visibleRows",_ref.getField(false, "_visiblerows")};
}
}