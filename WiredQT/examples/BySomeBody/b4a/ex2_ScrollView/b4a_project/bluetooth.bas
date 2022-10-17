B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=6.5
@EndOfDesignText@
'Custom View class 
#Event: ExampleEvent (Value As Int)
#DesignerProperty: Key: BooleanExample, DisplayName: Boolean Example, FieldType: Boolean, DefaultValue: True, Description: Example of a boolean property.
#DesignerProperty: Key: IntExample, DisplayName: Int Example, FieldType: Int, DefaultValue: 10, MinRange: 0, MaxRange: 100, Description: Note that MinRange and MaxRange are optional.
#DesignerProperty: Key: StringWithListExample, DisplayName: String With List, FieldType: String, DefaultValue: Sunday, List: Sunday|Monday|Tuesday|Wednesday|Thursday|Friday|Saturday
#DesignerProperty: Key: StringExample, DisplayName: String Example, FieldType: String, DefaultValue: Text
#DesignerProperty: Key: ColorExample, DisplayName: Color Example, FieldType: Color, DefaultValue: 0xFFCFDCDC, Description: You can use the built-in color picker to find the color values.
#DesignerProperty: Key: DefaultColorExample, DisplayName: Default Color Example, FieldType: Color, DefaultValue: Null, Description: Setting the default value to Null means that a nullable field will be displayed.
Sub Class_Globals
	Private mEventName As String 'ignore
	Private mCallBack As Object 'ignore
	Private mBase As Panel
	Private Const DefaultColorConstant As Int = -984833 'ignore
	Dim imgconnect As ImageView
	Dim Label2 As Label
	Dim Timer1 As Timer
	Dim imgdisconnect As ImageView

End Sub
'clsTest.Initialize(Me, "clsTest")
'clsTest.AddToParent(Activity,0,0,100%x,100%y)
Public Sub AddToParent(Parent As Activity, Left As Int, Top As Int, Width As Int,Height As Int)
	mBase.Initialize("mBase")
	Parent.AddView(mBase, Left, Top, Width, Height)
	GTKForms
End Sub
Public Sub Initialize (Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
	imgconnect.Initialize("imgconnect")
	imgdisconnect.Initialize("imgdisconnect")
	Timer1.Initialize("Timer1",1000)
	Timer1.Enabled = True
	Label2.Initialize("Label2")

End Sub

Public Sub DesignerCreateView (Base As Panel, Lbl As Label, Props As Map)
	mBase = Base
	GTKForms
End Sub
Public Sub GTKForms
	mBase.Color=0x000000'transparent background
	mBase.Width=100%x
	mBase.height=100%y
	mBase.AddView(imgconnect,0.08 * mBase.Width,0.18 * mBase.Height,0.43 * mBase.Width,0.14 * mBase.Height)
	imgconnect.Bitmap = LoadBitmapResize(File.DirAssets,"pics1.png",imgconnect.Width,imgconnect.Height,True)
	mBase.AddView(imgdisconnect,0.61 * mBase.Width,0.21 * mBase.Height,0.20 * mBase.Width,0.07 * mBase.Height)
	imgdisconnect.Bitmap = LoadBitmapResize(File.DirAssets,"pics1.png",imgdisconnect.Width,imgdisconnect.Height,True)
	Label2.Color =  0x00ffffff
	Label2.TextColor = 0xff000000
	Label2.Gravity = Gravity.CENTER_HORIZONTAL+Gravity.CENTER_VERTICAL
	Label2.Text = "Label1"
	mBase.AddView(Label2,0.26 * mBase.Width,0.05 * mBase.Height,0.33 * mBase.Width,0.06 * mBase.Height)

End Sub

'If SubExists(mCallBack,mEventName & "_" & "ExampleEvent") Then
'	CallSub2(mCallBack,mEventName & "_" & "ExampleEvent",123)
'End If
Sub GetList(L As List)
	Return InputList(L, "Choose device", -1) 'show list with paired devices ask user to choose
End Sub
Sub imgconnect_click()
	CallSub(Starter,"mnuConnect_Click")
End Sub
Sub check_bluetooth
	If Starter.Serial1.IsEnabled = False Then
		Msgbox("Please enable Bluetooth.", "")
	Else
		If Starter.connected_BT=False Then
			Starter.Serial1.Listen 'listen for incoming connections
			'Serial1.Connect("C0:18:85:87:6B:2E")
			'Serial1.Connect3("C0:18:85:87:6B:2E",1)
			'Serial1.Connect3("20:13:03:04:11:12",1)
			'Serial1.Connect3("20:13:03:04:11:12",1)
		End	If
	End If
End Sub
Sub Serial_print(str As String)
	CallSub2( Starter,"astream_write",str)
End Sub
Sub imgdisconnect_click()
'	Dim x As frmcontrols
'	x=Starter.frmcontrols1
'	x.Visible=True
	setVisible(False)
	'CallSub(Starter,"mnuDisconnect_Click")
	'Label2.Text="Disconnected"
End Sub
Sub Label2_click()
End Sub
Sub Timer1_Tick()
End Sub


Public Sub GetBase As Panel
	Return mBase
End Sub
Public Sub getVisible() As Boolean
	Return mBase.Visible
End Sub
Public Sub setVisible(flag As Boolean)
	mBase.Visible=flag
End Sub
Public Sub SetLayout(Left As Int,Top As Int,Width As Int,Height As Int)
	mBase.SetLayout(Left,Top,Width,Height )
End Sub
