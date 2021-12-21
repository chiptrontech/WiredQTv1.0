def generate(lst):	
	'''
		lst=["bird","eagle","chicken"]
	'''
	data=''
	for i,a in enumerate(lst):
		b='''item {
	id: %s
	name: '%s'
}

'''%(str(i+1),a,)		
		data+=b
		
	return data
if __name__ == '__main__':
	strs=generate(["bird","eagle","chicken"])
	print(strs)
	
