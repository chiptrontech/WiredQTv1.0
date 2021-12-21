
#Python code to illustrate parsing of XML files 
# importing the required modules 
import csv 
import requests 
import xml.etree.ElementTree as ET 
def XMLHeader(x):
    a,b,c,d,e,f,g,h=x["folder"],x["filename"],x["path"],x["database"],x["width"],x["height"],x["depth"],x["segmented"]
    xml='''<annotation>
	<folder>%s</folder>
	<filename>%s</filename>
	<path>%s</path>
	<source>
		<database>%s</database>
	</source>
	<size>
		<width>%s</width>
		<height>%s</height>
		<depth>%s</depth>
	</size>
	<segmented>%s</segmented>
'''%(a,b,c,d,e,f,g,h)
    return xml
def XMLBody(x):
    a,b,c,d,e,f,g,h=x["name"],x["pose"],x["truncated"],x["difficult"],x["xmin"],x["ymin"],x["xmax"],x["ymax"]
    xml='''	<object>
		<name>%s</name>
		<pose>%s</pose>
		<truncated>%s</truncated>
		<difficult>%s</difficult>
		<bndbox>
			<xmin>%s</xmin>
			<ymin>%s</ymin>
			<xmax>%s</xmax>
			<ymax>%s</ymax>
		</bndbox>
	</object>    
'''%(a,b,c,d,e,f,g,h)
    return xml
def GenerateXML(x):
    head=XMLHeader(x[0].fields)
    body=""
    for a in x[1]:
        body+=XMLBody(a.fields)
    return head+body+"</annotation>"
class Properties:
    def __init__(self):
        self.fields={"folder":"","filename":"","path":"","database":"","width":"","height":"","depth":"","segmented":""}
    def __str__(self):
        return str(self.fields)
class BoundingBox:
    def __init__(self):
        self.fields={"name":"","pose":"","truncated":"","difficult":"","xmin":"","ymin":"","xmax":"","ymax":""}
    def __str__(self):
        return str(self.fields)
def parseXML(xmlfile): 
    # create element tree object 
    tree = ET.parse(xmlfile) 
    # get root element 
    root = tree.getroot() 
    prop=Properties()
    # create empty list for news items 
    lst = [] 
    # iterate news items 
    for item in root.findall('.'): #for item in root.findall('./channel/item'): 
        # iterate child elements of item 
        def parseitem(src,dst):
            if src.tag in dst.fields:
                dst.fields[src.tag]=src.text            
        for child in item: 
            #if child.tag in prop.fields:
            #    prop.fields[child.tag]=child.text
            parseitem(child,prop)
            if child.tag=='source':
                for a in child:
                    #if a.tag in prop.fields:
                    #    prop.fields[a.tag]=a.text                                       
                    parseitem(a,prop)    
            if child.tag=='size':
                for a in child:
                    #if a.tag in prop.fields:
                    #    prop.fields[a.tag]=a.text                                       
                    parseitem(a,prop)    
            if child.tag=='object':
                x=BoundingBox()
                for a in child:
                    #if a.tag in x.fields:
                    #    x.fields[a.tag]=a.text
                    parseitem(a,x)    
                    if a.tag=='bndbox':
                        for b in a:
                            parseitem(b,x)    
                            #x.fields[b.tag]=b.text
                lst.append(x)
    #print(prop)            
    #for a in lst:            
     #   print(a)            
    return prop,lst 

if __name__ == "__main__": 

    newsitems = parseXML('cam_image2.xml') 
    x=GenerateXML(newsitems)
    print(x)