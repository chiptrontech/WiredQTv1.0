B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=6.5
@EndOfDesignText@
'Class module
Sub Class_Globals
	Dim str As String
	Dim buffer As String
	Dim data As String

	Dim wait_header As String
	Dim terminate_char As String
	Dim num_terminate_char As Int
	Dim num_bufterminate_char As Int
	Dim status As Boolean
	Dim currPointer As Int

End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(WaitHeader As String, TerminateChar As String, numTerminate As Int)
    num_terminate_char = numTerminate
    wait_header = WaitHeader
    terminate_char = TerminateChar
    currPointer = 1
End Sub

Sub Pollbyte(x As String) As Boolean
    If (vb6.Mid2(wait_header, currPointer, 1) = x) Then
        currPointer = currPointer + 1
    Else
        currPointer = 1
    End If
    If ((currPointer - 1) = vb6.Len(wait_header)) Then
        currPointer = 1
        Return True
    End If
    Return False
End Sub
Sub available(MSComm_input As String) As Boolean
Dim c As String
    str = str & MSComm_input
    Do While (str <> "")
        c = vb6.Mid2(str, 1, 1)
        If status Then data = data & c
        
        If Pollbyte(c) Then
            data = ""
            status = True
            num_bufterminate_char = 0
        End If
        If (status = True) Then
            If (c = terminate_char) Then
                str = vb6.Mid(str, 2)
                num_bufterminate_char = num_bufterminate_char + 1
                If (num_bufterminate_char = num_terminate_char) Then
                    status = False
                    data = vb6.Mid2(data, 1, vb6.Len(data) - 1)
                    Return True
                End If
            End If
        End If
        If vb6.Len(str) > 1 Then
            str = vb6.Mid(str, 2)
        Else
            str = ""
            Exit
        End If
    Loop
    Return False
End Sub

Sub Databuffer() As String
	Return data
End Sub
