def generate(y):
	x='''import os
folder='training'
onlyfiles = [f for f in os.listdir(folder+'/') if os.path.isfile(folder+'/'+f) and f.find(".index")!=-1]
max_index=-1
buf=-1
fnd="model.ckpt-"
for a in onlyfiles:
	if a.find(fnd)!=-1:
		try:
			buf=int(a.replace(fnd,'').replace(".index",''))
			if buf>max_index:
				max_index=buf
		except:
			pass
if buf!=-1:
	print('Please execute at Line 16 >> !python export_inference_graph.py --input_type image_tensor --pipeline_config_path training/%s --trained_checkpoint_prefix training/model.ckpt-%s --output_directory inference_graph' %s (buf))
else:
	print("Error,Check training folder!!!")
''' % (y,'%s','%')
	return x
if __name__ == '__main__':
	strs=generate("")
	print(strs)
	