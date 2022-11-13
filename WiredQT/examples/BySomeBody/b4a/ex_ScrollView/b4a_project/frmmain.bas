B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=8
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
	Dim QPushButton4 As Button
	Dim QPushButton1 As Button
	Dim QComboBox3 As Spinner
	Dim QFrame4 As ScrollView
	Dim QComboBox5 As Spinner
	Dim QLabel6 As Label
	Dim DataGrid7 as Table
	Dim QSlider8 As SeekBar
	Dim Timer9 As Timer

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
	QPushButton4.Initialize("QPushButton4")
	QPushButton1.Initialize("QPushButton1")
	QComboBox3.Initialize("QComboBox3")
	QComboBox3.AddAll(Array As String("Sunday", "Monday"))
	QFrame4.Initialize(27.01%y)'add QFrame4.Height=xx%y at the end of GTKForms, overide size of scroll use QFrame4.Panel.Height=xx%y
	QComboBox5.Initialize("QComboBox5")
	QComboBox5.AddAll(Array As String("Sunday", "Monday"))
	QLabel6.Initialize("QLabel6")
	DataGrid7.Initialize(Me,"DataGrid7",4)
	'DataGrid7.LoadTableFromCSV(Dir, Filename, HeadersExist)
	'vb6.SetDataGrid(Activity,Main.SQL,DataGrid7,"History")
	QSlider8.Initialize("QSlider8")
	QSlider8.Max = 100
	Timer9.Initialize("Timer9",1000)
	Timer9.Enabled = True

End Sub

Public Sub DesignerCreateView (Base As Panel, Lbl As Label, Props As Map)
	mBase = Base
	GTKForms
End Sub
Public Sub GTKForms
	mBase.Color=0x000000'transparent background
	mBase.Width=100%x
	mBase.height=100%y
	mBase.AddView(QPushButton4,0.05 * mBase.Width,0.05 * mBase.Height,0.24 * mBase.Width,0.06 * mBase.Height)
	mBase.AddView(QPushButton1,0.31 * mBase.Width,0.07 * mBase.Height,0.24 * mBase.Width,0.06 * mBase.Height)
	mBase.AddView(QComboBox3,0.37 * mBase.Width,0.17 * mBase.Height,0.39 * mBase.Width,0.11 * mBase.Height)
	QComboBox3.Color =  0x00ffffff
	QComboBox3.DropdownBackgroundColor =  0x00ffffff
	QComboBox3.DropdownTextColor =  0xff000000
	QComboBox3.TextColor =  0xff000000
	mBase.AddView(QFrame4,0.03 * mBase.Width,0.30 * mBase.Height,0.76 * mBase.Width,0.27 * mBase.Height)
	QFrame4.Color =  0x00ffffff
	QFrame4.Panel.AddView(QComboBox5,0.16 * QFrame4.Width,0.51 * QFrame4.Height,0.26 * QFrame4.Width,0.27 * QFrame4.Height)
	QComboBox5.Color =  0x00ffffff
	QComboBox5.DropdownBackgroundColor =  0x00ffffff
	QComboBox5.DropdownTextColor =  0xff000000
	QComboBox5.TextColor =  0xff000000
	QLabel6.Color =  0x00ffffff
	QLabel6.TextColor = 0xff000000
	QLabel6.Gravity = Gravity.CENTER_HORIZONTAL+Gravity.CENTER_VERTICAL
	QLabel6.Text = "QLabel6"
	QFrame4.Panel.AddView(QLabel6,0.50 * QFrame4.Width,0.53 * QFrame4.Height,0.32 * QFrame4.Width,0.27 * QFrame4.Height)
	DataGrid7.AddToParent(mBase,0.03 * mBase.Width,0.60 * mBase.Height,0.76 * mBase.Width,0.24 * mBase.Height)
	'DataGrid7.LoadTableFromCSV(File.DirAssets, "datus.csv", True)
	'DataGrid7.SetDatagrid(Array As String ("A","B","C"),Array(Array As String("1","2","3"),Array As String("4","5","6")))
	mBase.AddView(QSlider8,0.31 * mBase.Width,0.82 * mBase.Height,0.60 * mBase.Width,0.08 * mBase.Height)

End Sub

'If SubExists(mCallBack,mEventName & "_" & "ExampleEvent") Then
'	CallSub2(mCallBack,mEventName & "_" & "ExampleEvent",123)
'End If
Sub QPushButton4_click()
End Sub
Sub QPushButton1_click()
End Sub
Sub QComboBox3_ItemClick (Position As Int, Value As Object)
End Sub
Sub QFrame4_click()
End Sub
Sub QComboBox5_ItemClick (Position As Int, Value As Object)
End Sub
Sub QLabel6_click()
End Sub
Sub DataGrid7_CellClick (Col As Int, Row As Int)
	Log("CellClick: " & Col & " , " & Row)
	Dim val As String = DataGrid7.GetValue(Col, Row)
	ToastMessageShow(val,False)
End Sub
Sub QSlider8_ValueChanged (Value As Int, UserChanged As Boolean)
End Sub
Sub Timer9_Tick()
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

Public Sub GetBase As Panel
	Return mBase
End Sub
