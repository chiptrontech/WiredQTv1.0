package b4a.OPTUMizerPatient;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class vb6 {
private static vb6 mostCurrent = new vb6();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.OPTUMizerPatient.main _main = null;
public b4a.OPTUMizerPatient.starter _starter = null;
public static String  _getfilestr(anywheresoftware.b4a.BA _ba,String _file_) throws Exception{
RDebugUtils.currentModule="vb6";
if (Debug.shouldDelegate(null, "getfilestr", false))
	 {return ((String) Debug.delegate(null, "getfilestr", new Object[] {_ba,_file_}));}
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub GetFileStr(file_ As String) As String";
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="Return File.GetText(Starter.FilePath,file_)";
if (true) return anywheresoftware.b4a.keywords.Common.File.GetText(mostCurrent._starter._filepath /*String*/ ,_file_);
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="End Sub";
return "";
}
public static String  _now(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="vb6";
if (Debug.shouldDelegate(null, "now", false))
	 {return ((String) Debug.delegate(null, "now", new Object[] {_ba}));}
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub Now() As String";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="Return DateTime.Date(DateTime.Now) & \" \" & DateTi";
if (true) return anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())+" "+anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="End Sub";
return "";
}
public static String  _savefilestr(anywheresoftware.b4a.BA _ba,String _file_,String _str) throws Exception{
RDebugUtils.currentModule="vb6";
if (Debug.shouldDelegate(null, "savefilestr", false))
	 {return ((String) Debug.delegate(null, "savefilestr", new Object[] {_ba,_file_,_str}));}
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub SaveFileStr(file_ As String, str As String)";
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="File.WriteString(Starter.FilePath,file_,str)";
anywheresoftware.b4a.keywords.Common.File.WriteString(mostCurrent._starter._filepath /*String*/ ,_file_,_str);
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="End Sub";
return "";
}
public static float  _constrain(anywheresoftware.b4a.BA _ba,float _amt,float _low,float _high) throws Exception{
RDebugUtils.currentModule="vb6";
if (Debug.shouldDelegate(null, "constrain", false))
	 {return ((Float) Debug.delegate(null, "constrain", new Object[] {_ba,_amt,_low,_high}));}
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub constrain(amt As Float,low As Float,high As Fl";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="If amt<low Then amt=low";
if (_amt<_low) { 
_amt = _low;};
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="If amt>high Then amt=high";
if (_amt>_high) { 
_amt = _high;};
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="Return amt";
if (true) return _amt;
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="End Sub";
return 0f;
}
public static String  _date(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="vb6";
if (Debug.shouldDelegate(null, "date", false))
	 {return ((String) Debug.delegate(null, "date", new Object[] {_ba}));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub Date() As String";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="Return DateTime.Date(DateTime.Now)";
if (true) return anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="End Sub";
return "";
}
public static String  _getcsv(anywheresoftware.b4a.BA _ba,int _x,String _chars,String _str) throws Exception{
RDebugUtils.currentModule="vb6";
if (Debug.shouldDelegate(null, "getcsv", false))
	 {return ((String) Debug.delegate(null, "getcsv", new Object[] {_ba,_x,_chars,_str}));}
int _b = 0;
String _ret = "";
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub getCSV(x As Int, Chars As String, str As Strin";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="Dim B As Int";
_b = 0;
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="Dim ret As String";
_ret = "";
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="B = 1";
_b = (int) (1);
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="Do While (x <> 0)";
while ((_x!=0)) {
RDebugUtils.currentLine=2621445;
 //BA.debugLineNum = 2621445;BA.debugLine="If Mid2(str, B, 1) = Chars Then x = x - 1";
if ((_mid2(_ba,_str,_b,(int) (1))).equals(_chars)) { 
_x = (int) (_x-1);};
RDebugUtils.currentLine=2621447;
 //BA.debugLineNum = 2621447;BA.debugLine="B = B + 1";
_b = (int) (_b+1);
 }
;
RDebugUtils.currentLine=2621449;
 //BA.debugLineNum = 2621449;BA.debugLine="Do While ((Mid2(str, B, 1) <> Chars) And ((str";
while ((((_mid2(_ba,_str,_b,(int) (1))).equals(_chars) == false) && ((_str.length())+1)!=_b)) {
RDebugUtils.currentLine=2621450;
 //BA.debugLineNum = 2621450;BA.debugLine="ret = ret & Mid2(str, B, 1)";
_ret = _ret+_mid2(_ba,_str,_b,(int) (1));
RDebugUtils.currentLine=2621451;
 //BA.debugLineNum = 2621451;BA.debugLine="B = B + 1";
_b = (int) (_b+1);
 }
;
RDebugUtils.currentLine=2621453;
 //BA.debugLineNum = 2621453;BA.debugLine="Return ret";
if (true) return _ret;
RDebugUtils.currentLine=2621454;
 //BA.debugLineNum = 2621454;BA.debugLine="End Sub";
return "";
}
public static String  _mid2(anywheresoftware.b4a.BA _ba,String _string1,int _start,int _lenght) throws Exception{
RDebugUtils.currentModule="vb6";
if (Debug.shouldDelegate(null, "mid2", false))
	 {return ((String) Debug.delegate(null, "mid2", new Object[] {_ba,_string1,_start,_lenght}));}
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub Mid2(String1 As String,Start As Int,Lenght As";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="If(String1.Length>=Start)Then";
if ((_string1.length()>=_start)) { 
 }else {
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="Return \"\"";
if (true) return "";
 };
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="If(String1.Length>=Start+Lenght-1)Then";
if ((_string1.length()>=_start+_lenght-1)) { 
RDebugUtils.currentLine=2228230;
 //BA.debugLineNum = 2228230;BA.debugLine="Return String1.SubString2(Start-1,Lenght+Start-1";
if (true) return _string1.substring((int) (_start-1),(int) (_lenght+_start-1));
 }else {
RDebugUtils.currentLine=2228232;
 //BA.debugLineNum = 2228232;BA.debugLine="Return String1.SubString(Start-1)";
if (true) return _string1.substring((int) (_start-1));
 };
RDebugUtils.currentLine=2228234;
 //BA.debugLineNum = 2228234;BA.debugLine="End Sub";
return "";
}
public static long  _instr(anywheresoftware.b4a.BA _ba,int _start,String _string1,String _string2) throws Exception{
RDebugUtils.currentModule="vb6";
if (Debug.shouldDelegate(null, "instr", false))
	 {return ((Long) Debug.delegate(null, "instr", new Object[] {_ba,_start,_string1,_string2}));}
long _x = 0L;
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub InStr(Start As Int,String1 As String,String2 A";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="Dim x As Long";
_x = 0L;
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="x=String1.IndexOf(String2)";
_x = (long) (_string1.indexOf(_string2));
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="Return x+1";
if (true) return (long) (_x+1);
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="End Sub";
return 0L;
}
public static String  _jsontostring(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.Map _am) throws Exception{
RDebugUtils.currentModule="vb6";
if (Debug.shouldDelegate(null, "jsontostring", false))
	 {return ((String) Debug.delegate(null, "jsontostring", new Object[] {_ba,_am}));}
String _str = "";
String _types = "";
int _i = 0;
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub jsonToString(am As Map) As String";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="Dim str As String";
_str = "";
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="Dim types As String";
_types = "";
RDebugUtils.currentLine=2686979;
 //BA.debugLineNum = 2686979;BA.debugLine="For i = 0 To am.Size - 1";
{
final int step3 = 1;
final int limit3 = (int) (_am.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=2686980;
 //BA.debugLineNum = 2686980;BA.debugLine="If GetType(am.GetValueAt(i))=\"java.lang.String\"";
if ((anywheresoftware.b4a.keywords.Common.GetType(_am.GetValueAt(_i))).equals("java.lang.String")) { 
RDebugUtils.currentLine=2686981;
 //BA.debugLineNum = 2686981;BA.debugLine="types=\"'\"";
_types = "'";
 }else {
RDebugUtils.currentLine=2686983;
 //BA.debugLineNum = 2686983;BA.debugLine="types=\"\"";
_types = "";
 };
RDebugUtils.currentLine=2686985;
 //BA.debugLineNum = 2686985;BA.debugLine="str=str & \"'\" & am.GetKeyAt(i) &  \"'\" & \":\" &  t";
_str = _str+"'"+BA.ObjectToString(_am.GetKeyAt(_i))+"'"+":"+_types+BA.ObjectToString(_am.GetValueAt(_i))+_types;
RDebugUtils.currentLine=2686986;
 //BA.debugLineNum = 2686986;BA.debugLine="If (i+1)<> am.Size Then";
if ((_i+1)!=_am.getSize()) { 
RDebugUtils.currentLine=2686987;
 //BA.debugLineNum = 2686987;BA.debugLine="str=str&\",\"";
_str = _str+",";
 };
RDebugUtils.currentLine=2686989;
 //BA.debugLineNum = 2686989;BA.debugLine="Log(GetType(\"\")=\"java.lang.Integer\")";
anywheresoftware.b4a.keywords.Common.LogImpl("12686989",BA.ObjectToString((anywheresoftware.b4a.keywords.Common.GetType((Object)(""))).equals("java.lang.Integer")),0);
RDebugUtils.currentLine=2686990;
 //BA.debugLineNum = 2686990;BA.debugLine="Log(\"Key: \" & am.GetKeyAt(i))";
anywheresoftware.b4a.keywords.Common.LogImpl("12686990","Key: "+BA.ObjectToString(_am.GetKeyAt(_i)),0);
RDebugUtils.currentLine=2686991;
 //BA.debugLineNum = 2686991;BA.debugLine="Log(\"Value: \" & am.GetValueAt(i))";
anywheresoftware.b4a.keywords.Common.LogImpl("12686991","Value: "+BA.ObjectToString(_am.GetValueAt(_i)),0);
 }
};
RDebugUtils.currentLine=2686993;
 //BA.debugLineNum = 2686993;BA.debugLine="str=\"{\"&str&\"}\"";
_str = "{"+_str+"}";
RDebugUtils.currentLine=2686994;
 //BA.debugLineNum = 2686994;BA.debugLine="Return str";
if (true) return _str;
RDebugUtils.currentLine=2686995;
 //BA.debugLineNum = 2686995;BA.debugLine="End Sub";
return "";
}
public static String  _len(anywheresoftware.b4a.BA _ba,String _str) throws Exception{
RDebugUtils.currentModule="vb6";
if (Debug.shouldDelegate(null, "len", false))
	 {return ((String) Debug.delegate(null, "len", new Object[] {_ba,_str}));}
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub Len(str As String) As String";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="Return str.Length";
if (true) return BA.NumberToString(_str.length());
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="End Sub";
return "";
}
public static float  _maparduino(anywheresoftware.b4a.BA _ba,float _x,float _in_min,float _in_max,float _out_min,float _out_max) throws Exception{
RDebugUtils.currentModule="vb6";
if (Debug.shouldDelegate(null, "maparduino", false))
	 {return ((Float) Debug.delegate(null, "maparduino", new Object[] {_ba,_x,_in_min,_in_max,_out_min,_out_max}));}
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub mapArduino(x As Float, in_min As Float,  in_ma";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="Return (x - in_min) * (out_max - out_min) / (in_";
if (true) return (float) ((_x-_in_min)*(_out_max-_out_min)/(double)(_in_max-_in_min)+_out_min);
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="End Sub";
return 0f;
}
public static String  _mid(anywheresoftware.b4a.BA _ba,String _string1,int _start) throws Exception{
RDebugUtils.currentModule="vb6";
if (Debug.shouldDelegate(null, "mid", false))
	 {return ((String) Debug.delegate(null, "mid", new Object[] {_ba,_string1,_start}));}
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub Mid(String1 As String,Start As Int) As String";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="If(String1.Length>=Start)Then";
if ((_string1.length()>=_start)) { 
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="Return String1.SubString(Start-1)";
if (true) return _string1.substring((int) (_start-1));
 }else {
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="Return \"\"";
if (true) return "";
 };
RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="End Sub";
return "";
}
public static String[]  _split(anywheresoftware.b4a.BA _ba,String _str,String _delimeter) throws Exception{
RDebugUtils.currentModule="vb6";
if (Debug.shouldDelegate(null, "split", false))
	 {return ((String[]) Debug.delegate(null, "split", new Object[] {_ba,_str,_delimeter}));}
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub Split(str As String,delimeter As String) As St";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="Return Regex.Split(delimeter,str)";
if (true) return anywheresoftware.b4a.keywords.Common.Regex.Split(_delimeter,_str);
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="End Sub";
return null;
}
public static String  _time(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="vb6";
if (Debug.shouldDelegate(null, "time", false))
	 {return ((String) Debug.delegate(null, "time", new Object[] {_ba}));}
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub Time() As String";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="Return DateTime.Time(DateTime.Now)";
if (true) return anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="End Sub";
return "";
}
public static boolean  _timeinbetween(anywheresoftware.b4a.BA _ba,String _mintime,String _maxtime,String _timenow) throws Exception{
RDebugUtils.currentModule="vb6";
if (Debug.shouldDelegate(null, "timeinbetween", false))
	 {return ((Boolean) Debug.delegate(null, "timeinbetween", new Object[] {_ba,_mintime,_maxtime,_timenow}));}
long _mintimelong = 0L;
long _maxtimelong = 0L;
long _currtimelong = 0L;
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub TimeInBetween(minTime As String, maxTime As St";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="Dim minTimeLong As Long";
_mintimelong = 0L;
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="Dim maxTimeLong As Long";
_maxtimelong = 0L;
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="Dim currTimeLong As Long";
_currtimelong = 0L;
RDebugUtils.currentLine=2555912;
 //BA.debugLineNum = 2555912;BA.debugLine="minTimeLong = DateTime.TimeParse(minTime)/1000";
_mintimelong = (long) (anywheresoftware.b4a.keywords.Common.DateTime.TimeParse(_mintime)/(double)1000);
RDebugUtils.currentLine=2555913;
 //BA.debugLineNum = 2555913;BA.debugLine="maxTimeLong = DateTime.TimeParse(maxTime)/1000";
_maxtimelong = (long) (anywheresoftware.b4a.keywords.Common.DateTime.TimeParse(_maxtime)/(double)1000);
RDebugUtils.currentLine=2555914;
 //BA.debugLineNum = 2555914;BA.debugLine="currTimeLong = DateTime.TimeParse(timenow)/100";
_currtimelong = (long) (anywheresoftware.b4a.keywords.Common.DateTime.TimeParse(_timenow)/(double)1000);
RDebugUtils.currentLine=2555915;
 //BA.debugLineNum = 2555915;BA.debugLine="If minTimeLong < maxTimeLong Then";
if (_mintimelong<_maxtimelong) { 
RDebugUtils.currentLine=2555916;
 //BA.debugLineNum = 2555916;BA.debugLine="If currTimeLong >= minTimeLong And currTim";
if (_currtimelong>=_mintimelong && _currtimelong<=_maxtimelong) { 
if (true) return anywheresoftware.b4a.keywords.Common.True;};
 }else {
RDebugUtils.currentLine=2555919;
 //BA.debugLineNum = 2555919;BA.debugLine="If currTimeLong > maxTimeLong Then";
if (_currtimelong>_maxtimelong) { 
RDebugUtils.currentLine=2555920;
 //BA.debugLineNum = 2555920;BA.debugLine="If currTimeLong >= minTimeLong And cur";
if (_currtimelong>=_mintimelong && _currtimelong>=_maxtimelong) { 
if (true) return anywheresoftware.b4a.keywords.Common.True;};
 }else {
RDebugUtils.currentLine=2555922;
 //BA.debugLineNum = 2555922;BA.debugLine="If currTimeLong <= minTimeLong And cur";
if (_currtimelong<=_mintimelong && _currtimelong<=_maxtimelong) { 
if (true) return anywheresoftware.b4a.keywords.Common.True;};
 };
 };
RDebugUtils.currentLine=2555925;
 //BA.debugLineNum = 2555925;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=2555926;
 //BA.debugLineNum = 2555926;BA.debugLine="End Sub";
return false;
}
public static long  _ubound(anywheresoftware.b4a.BA _ba,String[] _str) throws Exception{
RDebugUtils.currentModule="vb6";
if (Debug.shouldDelegate(null, "ubound", false))
	 {return ((Long) Debug.delegate(null, "ubound", new Object[] {_ba,_str}));}
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub UBound(str() As String) As Long";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="Return str.Length";
if (true) return (long) (_str.length);
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="End Sub";
return 0L;
}
}