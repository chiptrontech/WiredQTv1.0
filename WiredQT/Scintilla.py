#int analogRead(int x)
#{
#    return x+50;
#}
'''
def analogRead(y):
    return y+50
while(1):
    x=analogRead(50)
    print(x)
    if (x==150):
        print("now exiting")
        break
x=123
print(x)
'''










#-------------------------------------------------------------------------
# qsci_simple_pythoneditor.pyw
#
# QScintilla sample with PyQt
#
# Eli Bendersky (eliben@gmail.com)
# This code is in the public domain
#-------------------------------------------------------------------------
import sys

import sip
from PyQt5.QtWidgets import *
from PyQt5.QtCore import *
from PyQt5.QtGui import *
from PyQt5.Qsci import QsciScintilla, QsciLexerPython


class SimplePythonEditor(QsciScintilla):
    ARROW_MARKER_NUM = 8

    def __init__(self, parent=None):
        super(SimplePythonEditor, self).__init__(parent)

        # Set the default font
        font = QFont()
        font.setFamily('Courier')
        font.setFixedPitch(True)
        font.setPointSize(10)
        self.setFont(font)
        self.setMarginsFont(font)

        # Margin 0 is used for line numbers
        fontmetrics = QFontMetrics(font)
        self.setMarginsFont(font)
        self.setMarginWidth(0, fontmetrics.width("00000") + 6)
        self.setMarginLineNumbers(0, True)
        self.setMarginsBackgroundColor(QColor("#cccccc"))

        # Clickable margin 1 for showing markers
        self.setMarginSensitivity(1, True)
        #self.marginClicked.connect(self.on_margin_clicked)
        '''self.connect(self,
            SIGNAL('marginClicked(int, int, Qt::KeyboardModifiers)'),
            self.on_margin_clicked)
            '''
        self.markerDefine(QsciScintilla.RightArrow,
            self.ARROW_MARKER_NUM)
        self.setMarkerBackgroundColor(QColor("#ee1111"),
            self.ARROW_MARKER_NUM)

        # Brace matching: enable for a brace immediately before or after
        # the current position
        #
        self.setBraceMatching(QsciScintilla.SloppyBraceMatch)

        # Current line visible with special background color
        self.setCaretLineVisible(True)
        self.setCaretLineBackgroundColor(QColor("#ffcccc"))

        # Set Python lexer
        # Set style for Python comments (style number 1) to a fixed-width
        # courier.
        #

        lexer = QsciLexerPython()
        lexer.setDefaultFont(font)
        self.setLexer(lexer)

        text = bytearray(str.encode("Arial"))
# 32, "Courier New"         
        self.SendScintilla(QsciScintilla.SCI_STYLESETFONT, 1, text)

        # Don't want to see the horizontal scrollbar at all
        # Use raw message to Scintilla here (all messages are documented
        # here: http://www.scintilla.org/ScintillaDoc.html)
        #self.SendScintilla(QsciScintilla.SCI_SETHSCROLLBAR, 0)

        # not too small
        self.setMinimumSize(600, 1000)

    def on_margin_clicked(self, nmargin, nline, modifiers):
        # Toggle marker for the line the margin was clicked on
        #print(self.cursor().pos())
        #print(self.getCursorPosition())
        #self.setCursorPosition(self.getCursorPosition()[0]+1,self.getCursorPosition()[1])
        if self.markersAtLine(nline) != 0:
            self.markerDelete(nline, self.ARROW_MARKER_NUM)
        else:
            self.markerAdd(nline, self.ARROW_MARKER_NUM)


if __name__ == "__main__":
    app = QApplication(sys.argv)
    editor = SimplePythonEditor()
    editor.show()
    editor.setText(open(sys.argv[0]).read())
    app.exec_()