package b4a.OPTUMizerPatient;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,30);
if (RapidSub.canDelegate("activity_create")) { return b4a.OPTUMizerPatient.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _rp = RemoteObject.declareNull("anywheresoftware.b4a.objects.RuntimePermissions");
RemoteObject _filepath = RemoteObject.createImmutable("");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="If FirstTime=True Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_firsttime,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 34;BA.debugLine="Activity.LoadLayout(\"Layout1\")";
Debug.ShouldStop(2);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout1")),main.mostCurrent.activityBA);
 BA.debugLineNum = 38;BA.debugLine="Activity.Title=\"\"";
Debug.ShouldStop(32);
main.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 47;BA.debugLine="frmmain1.SetLayout(0,0,100%x,100%y)        '1";
Debug.ShouldStop(16384);
main.mostCurrent._frmmain1.runClassMethod (b4a.OPTUMizerPatient.frmmain.class, "_setlayout" /*RemoteObject*/ ,(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 48;BA.debugLine="frmmain1.Visible=True";
Debug.ShouldStop(32768);
main.mostCurrent._frmmain1.runClassMethod (b4a.OPTUMizerPatient.frmmain.class, "_setvisible" /*RemoteObject*/ ,main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 51;BA.debugLine="Dim rp As RuntimePermissions";
Debug.ShouldStop(262144);
_rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");Debug.locals.put("rp", _rp);
 BA.debugLineNum = 53;BA.debugLine="Dim FilePath As String";
Debug.ShouldStop(1048576);
_filepath = RemoteObject.createImmutable("");Debug.locals.put("FilePath", _filepath);
 BA.debugLineNum = 54;BA.debugLine="If File.ExternalWritable Then Starter.FilePath =";
Debug.ShouldStop(2097152);
if (main.mostCurrent.__c.getField(false,"File").runMethod(true,"getExternalWritable").<Boolean>get().booleanValue()) { 
main.mostCurrent._starter._filepath /*RemoteObject*/  = _rp.runMethod(true,"GetSafeDirDefaultExternal",(Object)(RemoteObject.createImmutable("")));}
else {
main.mostCurrent._starter._filepath /*RemoteObject*/  = main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal");};
 };
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,89);
if (RapidSub.canDelegate("activity_pause")) { return b4a.OPTUMizerPatient.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 89;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 91;BA.debugLine="If UserClosed=True Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",_userclosed,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 92;BA.debugLine="ExitApplication";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ExitApplication");
 };
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,78);
if (RapidSub.canDelegate("activity_resume")) { b4a.OPTUMizerPatient.main.remoteMe.runUserSub(false, "main","activity_resume"); return;}
ResumableSub_Activity_Resume rsub = new ResumableSub_Activity_Resume(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Activity_Resume extends BA.ResumableSub {
public ResumableSub_Activity_Resume(b4a.OPTUMizerPatient.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.OPTUMizerPatient.main parent;
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,78);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 BA.debugLineNum = 84;BA.debugLine="Starter.frmmain1=frmmain1              '1";
Debug.ShouldStop(524288);
parent.mostCurrent._starter._frmmain1 /*RemoteObject*/  = (parent.mostCurrent._frmmain1);
 BA.debugLineNum = 85;BA.debugLine="Starter.rp.CheckAndRequest(Starter.rp.PERMISSION_";
Debug.ShouldStop(1048576);
parent.mostCurrent._starter._rp /*RemoteObject*/ .runVoidMethod ("CheckAndRequest",main.processBA,(Object)(parent.mostCurrent._starter._rp /*RemoteObject*/ .getField(true,"PERMISSION_WRITE_EXTERNAL_STORAGE")));
 BA.debugLineNum = 86;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
Debug.ShouldStop(2097152);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "activity_resume"), null);
this.state = 1;
return;
case 1:
//C
this.state = -1;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 87;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _activity_permissionresult(RemoteObject _permission,RemoteObject _result) throws Exception{
}
public static RemoteObject  _done_click() throws Exception{
try {
		Debug.PushSubsStack("done_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,74);
if (RapidSub.canDelegate("done_click")) { return b4a.OPTUMizerPatient.main.remoteMe.runUserSub(false, "main","done_click");}
 BA.debugLineNum = 74;BA.debugLine="Sub done_click()";
Debug.ShouldStop(512);
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 26;BA.debugLine="Private frmmain1 As frmmain                 '1";
main.mostCurrent._frmmain1 = RemoteObject.createNew ("b4a.OPTUMizerPatient.frmmain");
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
vb6_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.OPTUMizerPatient.main");
starter.myClass = BA.getDeviceClass ("b4a.OPTUMizerPatient.starter");
vb6.myClass = BA.getDeviceClass ("b4a.OPTUMizerPatient.vb6");
frmmain.myClass = BA.getDeviceClass ("b4a.OPTUMizerPatient.frmmain");
clsparser.myClass = BA.getDeviceClass ("b4a.OPTUMizerPatient.clsparser");
wtaserver.myClass = BA.getDeviceClass ("b4a.OPTUMizerPatient.wtaserver");
table.myClass = BA.getDeviceClass ("b4a.OPTUMizerPatient.table");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _refresh_click() throws Exception{
try {
		Debug.PushSubsStack("refresh_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,70);
if (RapidSub.canDelegate("refresh_click")) { return b4a.OPTUMizerPatient.main.remoteMe.runUserSub(false, "main","refresh_click");}
 BA.debugLineNum = 70;BA.debugLine="Sub refresh_click()";
Debug.ShouldStop(32);
 BA.debugLineNum = 73;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}