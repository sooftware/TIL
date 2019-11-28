def changeToSpace(s):
    s.replace('?',' ')
    s.replace('!',' ')
    s.replace('.',' ')
    s.replace(',',' ')

    return s

def strToList(s):
    data_list=s.split(' ')
    return data_list

def checkCopy(original,compare):
    final_list=[]
    memory=0

    for i in range(0,len(original),1):
        if i < memory :
            continue
        copy_list=[]
        for j in range(0,len(compare),1):
            if original[i] == compare[j] :
                copy_list.append(original[i])
                equal=True
                k=1
                while True :
                    if original[i+k] == compare[j+k] :        
                        copy_list.append(original[i+k])
                        k+=1
                    else :
                        equal=False
                        break;
                    if i+k == len(original) or j+k == len(compare) :
                        break;

        if len(copy_list) > 3 :
            final_list.append(copy_list)
            memory=i+len(copy_list)

    return final_list

text1=open('c:/app/d1.txt','r')
text2=open('c:/app/d2.txt','r')

str1=text1.read() # text to str
str2=text2.read() # text to str

print("\n【비교문장\n")
print(str1)
print(str2)

str1=changeToSpace(str1)
str2=changeToSpace(str2)

list1=strToList(str1)
list2=strToList(str2)

print(list1)
print(list2)

data_list=checkCopy(list1,list2)

print("\n【실행결과\n")
for i in range(0,len(data_list),1):
    print(data_list[i])








