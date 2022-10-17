B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=6.5
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub
'Dim a() As String
'	a=vb6.Split("123 456 789", " " )
Sub Split(str As String,delimeter As String) As String()
	Return Regex.Split(delimeter,str)
End Sub
'dim x as int=100
'x=vb6.constrain(x,1,80)
Sub constrain(amt As Float,low As Float,high As Float) As Float
	If amt<low Then amt=low
	If amt>high Then amt=high
	Return amt
End Sub
'dim x as int=100
'x=vb6.mapArduino(x,1,1023,1,100)
Sub mapArduino(x As Float, in_min As Float,  in_max As Float, out_min As Float,out_max As Float) As Float
  Return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min
End Sub
Sub UBound(str() As String) As Long
	Return str.Length
End Sub
'Start not used, Set it to 1
Sub InStr(Start As Int,String1 As String,String2 As String) As Long
Dim x As Long
	x=String1.IndexOf(String2)
	Return x+1
End Sub
Sub SaveFileStr(file_ As String, str As String)
	'File.WriteString(File.DirRootExternal,file_,str)
	File.WriteString(Starter.FilePath,file_,str)
End Sub
Sub GetFileStr(file_ As String) As String
	'Return File.GetText(File.DirRootExternal,file_)
	Return File.GetText(Starter.FilePath,file_)
End Sub


Sub Mid(String1 As String,Start As Int) As String
	If(String1.Length>=Start)Then
		Return String1.SubString(Start-1)
	Else
		Return ""
	End If	
End Sub
Sub Mid2(String1 As String,Start As Int,Lenght As Int) As String
	If(String1.Length>=Start)Then
	Else
		Return ""
	End If			
	If(String1.Length>=Start+Lenght-1)Then
		Return String1.SubString2(Start-1,Lenght+Start-1)
	Else
		Return String1.SubString(Start-1)
	End If
End Sub
Sub Now() As String
	Return DateTime.Date(DateTime.Now) & " " & DateTime.Time(DateTime.Now)
End Sub
Sub Date() As String
	Return DateTime.Date(DateTime.Now) 
End Sub
Sub Time() As String
	Return DateTime.Time(DateTime.Now) 
End Sub
Sub Len(str As String) As String
	Return str.Length
End Sub
'not time should be military time format unlike in VB6 TimeInBetween function wich accept 
Sub TimeInBetween(minTime As String, maxTime As String, timenow As String) As Boolean
Dim minTimeLong As Long
Dim maxTimeLong As Long
Dim currTimeLong As Long

    'minTimeLong = DatePart("h", minTime) * 3600 + DatePart("n", minTime) * 60 + DatePart("s", minTime)
    'maxTimeLong = DatePart("h", maxTime) * 3600 + DatePart("n", maxTime) * 60 + DatePart("s", maxTime)
    'currTimeLong = DatePart("h", timenow) * 3600 + DatePart("n", timenow) * 60 + DatePart("s", timenow)
    minTimeLong = DateTime.TimeParse(minTime)/1000 
	maxTimeLong = DateTime.TimeParse(maxTime)/1000 
    currTimeLong = DateTime.TimeParse(timenow)/1000
    If minTimeLong < maxTimeLong Then
        If currTimeLong >= minTimeLong And currTimeLong <= maxTimeLong Then Return True
    Else
        'mintime crosses midnight
        If currTimeLong > maxTimeLong Then
            If currTimeLong >= minTimeLong And currTimeLong >= maxTimeLong Then Return True
        Else
            If currTimeLong <= minTimeLong And currTimeLong <= maxTimeLong Then Return True
        End If
    End If
	Return False
End Sub
Sub getCSV(x As Int, Chars As String, str As String) As String 'number = getCSV(0, ",", str) 'FIRST PARAM
Dim B As Int
Dim ret As String
    B = 1
    Do While (x <> 0)
        If Mid2(str, B, 1) = Chars Then x = x - 1
                
        B = B + 1
    Loop
    Do While ((Mid2(str, B, 1) <> Chars) And ((str.Length) + 1) <> B)
        ret = ret & Mid2(str, B, 1)
        B = B + 1
	Loop
	Return ret
End Sub

Sub jsonToString(am As Map) As String
	Dim str As String
	Dim types As String
	For i = 0 To am.Size - 1
		If GetType(am.GetValueAt(i))="java.lang.String" Then
			types="'"
		Else
			types=""
		End If
		str=str & "'" & am.GetKeyAt(i) &  "'" & ":" &  types & am.GetValueAt(i) &  types
		If (i+1)<> am.Size Then
			str=str&","
		End If
		Log(GetType("")="java.lang.Integer")
		Log("Key: " & am.GetKeyAt(i))
		Log("Value: " & am.GetValueAt(i))
	Next
	str="{"&str&"}"
	Return str
End Sub
'Sub UseJson_AppStart (Form1 As Form, Args() As String)
'	Dim jp As JSONParser
'	Dim am As Map
'			
'	jp.Initialize("{'1':12,'Rocky':'Donna'}")'from getfilestr
'	am=jp.NextObject()
'	am.Put("1",5)
'	Log(am.Get("1")*5)
'	Log(am.Get("Rocky"))
'	
'	Dim my_str As String=vb6.jsonToString(am)'to SaveFileStr
'	Dim jp1 As JSONParser
'	Dim am1 As Map
'			
'	jp1.Initialize(my_str)
'	am1=jp1.NextObject()
'	am1.Put("1",5)
'	Log(am1.Get("1")*5)
'	
'End Sub
