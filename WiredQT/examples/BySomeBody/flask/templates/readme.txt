dummy static folder.(not needed by flask)
need by dreamweaver to point to proper css,js,images

event sender(inside javascript function)(put name=" userid,producid" tag in HTML to detect which widget causes event )
event.srcElement.name	-



    <table width="200" border="0">
    <tbody>
    {% for suggestion in suggestions %}
      <tr>
	<td>Hello</td>
	<td>raks</td>
	<td><input type="button" value="OK{{ suggestion }}" name="OK{{ suggestion }}" onClick="clkraks()" id="OK{{ suggestion }}"></td>
      </tr>
    {% endfor %}
    </tbody>
    </table>