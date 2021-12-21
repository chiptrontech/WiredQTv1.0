import ast
from wired_module import *              
def getimportlibs(mod_path,code=None):
        def getFunctionCall(ast_data,mod_path):
                ret=[]
                for i,body in enumerate(ast_data.body):
                        if body.__class__ == ast.ImportFrom or body.__class__ == ast.Import:
                                if body.__class__ == ast.ImportFrom:
                                        cname=x=eval('body.'+ ast.ImportFrom.__dict__['_fields'][0])
                                else:
                                        cname=eval('body.'+ ast.Import.__dict__['_fields'][0]+'[0].name')
                                src=app_path()+'/AdditionalLibrary/' + cname+'/'+cname+'.py'
                                dst=GetPath(mod_path)  + cname+'.py'
                                
                                if FileExist(src):
                                        if FileExist(dst)==False:
                                                SaveFileStr(dst, GetFileStr(src))
        ast_data=None
        ModuleType = type(ast)
        if code==None:
                with open(mod_path, "r") as file_mod:
                        data = file_mod.read()
        else:
                data=code
        try:
                if code==None:
                        ast_data = ast.parse(data, filename=mod_path)
                else:
                        ast_data = ast.parse(data)
        except:
                #print("Syntax error 'ast.parse' can't read %r" % mod_path)
                #import traceback
                #traceback.print_exc()
                a=0
        ret= []
        if ast_data!=None:
                ret=getFunctionCall(ast_data,mod_path)
        print(ret)
        return ret
