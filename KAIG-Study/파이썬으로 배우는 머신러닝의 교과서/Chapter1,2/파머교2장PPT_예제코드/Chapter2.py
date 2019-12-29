#!/usr/bin/env python
# coding: utf-8

# In[1]:


1 + 2


# In[2]:


(1 + 2 * 3 - 4) / 5


# In[3]:


2 ** 8


# In[4]:


a=1.5


# In[5]:


a="learning"


# In[6]:


b='abc'


# In[7]:


type(100)


# In[8]:


type(100.1)


# In[9]:


a=(1, 2, 3)


# In[10]:


b=(2,)


# In[11]:


False


# In[12]:


b=(2,)
b[0]+1


# In[13]:


x = 1 / 3
x
y = 2 / 3
y


# In[14]:


x = 1 / 3
print(x)
y = 2 / 3
print(y)
print('x= ' + str(x))
print('weight = {0} kg'.format(x))


# In[15]:


x = 1 / 3
y = 1 / 7
z = 1 / 4
print ('weight : {0} kg {1} kg {2} kg'.format(x, y, z))


# In[16]:


print('weight: {0:.2f} kg, y={1:.2f} kg, z={2:.2f} kg'.format(x,y,z))


# In[17]:


x = [1, 1, 2, 3, 5] # list의 정의
print(x) # 표시


# In[18]:


x[0]


# In[19]:


x[2]


# In[20]:


print(type(x))
print(type(x[0]))


# In[21]:


s=['SUN', 1, 'MON', 2]
print(type(s[0]))
print(type(s[1]))


# In[22]:


a=[[1, 2, 3], [4, 5, 6]]
print(a)


# In[23]:


a=[[1, 2, 3], [4, 5, 6]]
print(a[0][1])


# In[24]:


x=[1, 1, 2, 3, 5]
x[3] = 100
print(x)


# In[25]:


x=[1, 1, 2, 3, 5]
len(x)


# In[26]:


y = range(5, 10)
print(y[0], y[1], y[2], y[3], y[4])


# In[27]:


print(y)


# In[28]:


z=list(range(5, 10))
print(z)


# In[29]:


list(range(10))


# In[30]:


a=(1, 2, 3)
print(a)


# In[31]:


a[1]


# In[32]:


type(a)


# In[33]:


a = (1)
type(a)
    


# In[34]:


a = (1,)
type(a)


# In[35]:


x = 11
if x > 10:
    print('x is ') # ... (A1)
    print('        larger than 10.') # ... (A2)
else:
    print('x is smaller than 11') # ... (B1) 


# In[36]:


x > 10


# In[37]:


type(x > 10)


# In[38]:


x = 15
if 10 <= x and x <= 20:
    print('x is between 10 and 20.')


# In[39]:


for i in [1, 2, 3]:
    print(i)


# In[40]:


num = [2, 4, 6, 8, 10]
for i in range(len(num)):
    num[i] = num[i] * 2
print(num)


# In[41]:


[1, 2] + [3, 4]


# In[42]:


import numpy as np


# In[43]:


x=np.array([1, 2, 3])
x


# In[44]:


print(x)


# In[45]:


y=np.array([4, 5, 6])
print(x + y)


# In[46]:


type(x)


# In[47]:


x[0]


# In[48]:


x[0] = 100
print(x)


# In[49]:


print(np.arange(10))


# In[50]:


print(np.arange(5, 10))


# In[51]:


j=np.array([4, 5, 6])
for i in np.arange(1,4):
    print(i)
    print(i + j)


# In[52]:


a = np.array([1, 1])
b = a
print('a =' + str(a))
print('b =' + str(b))
b[0] = 100
print('b =' + str(b))
print('a =' + str(a))


# In[53]:


a = np.array([1, 1])
b = a.copy()
print('a =' + str(a))
print('b =' + str(b))
b[0] = 100
print('b =' + str(b))
print('a =' + str(a))


# In[54]:


x = np.array([[1, 2, 3], [4, 5, 6]])
print(x)


# In[55]:


x = np.array([[1, 2, 3], [4, 5, 6]])
x.shape


# In[56]:


w, h = x.shape
print(w)
print(h)


# In[57]:


type(x.shape)


# In[58]:


w, h = x.shape
print(w)
print(h)


# In[59]:


x = np.array([[1, 2, 3], [4, 5, 6]])
x[1, 2]


# In[60]:


x = np.array([[1, 2, 3], [4, 5, 6]])
x[0, 2]


# In[61]:


x = np.array([[1, 2, 3], [4, 5, 6]])
x[1, 2] = 100
print(x)


# In[62]:


print(np.zeros(10))


# In[63]:


print(np.zeros((2, 10)))


# In[64]:


print(np.ones((2, 10)))


# In[65]:


np.random.rand(2, 3)


# In[66]:


a = np.arange(10)
print(a)


# In[67]:


a.reshape(2, 5)


# In[68]:


x = np.array([[4, 4, 4], [8, 8, 8]])
y = np.array([[1, 1, 1], [2, 2, 2]])
print(x + y)


# In[69]:


x = np.array([[4, 4, 4], [8, 8, 8]])
print(10 * x)


# In[70]:


x = np.array([[4, 4, 4], [8, 8, 8]])
print(np.exp(x))


# In[71]:


v = np.array([[1, 2, 3], [4, 5, 6]])
w = np.array([[1, 1], [2, 2], [3, 3]])
print(v.dot(w))


# In[72]:


x = np.arange(10)
print(x)
print(x[:5])


# In[73]:


print(x[5:])


# In[74]:


print(x[3:8])


# In[75]:


print(x[3:8:2])


# In[76]:


print(x[::-1])


# In[77]:


y = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
print(y)
print(y[:2, 1:2])


# In[78]:


x = np.array([1, 1, 2, 3, 5, 8, 13])
x > 3


# In[79]:


x[x > 3]


# In[80]:


x[x > 3] = 999
print(x)


# In[81]:


help(np.random.randint)


# In[82]:


np.random.randint(5)


# In[83]:


np.random.randint(5, 10, (3, 2))


# In[84]:


def my_func1():
    print('Hi!')
# 함수 my_func1()의 정의는 여기까지
my_func1() # 함수를 실행


# In[85]:


def my_func2(a, b):
    c = a + b
    return c


my_func2(1, 2)


# In[86]:


def my_func3(D):
    m = np.mean(D)
    s = np.std(D)
    return m, s


# In[87]:


data=np.random.randn(100)
data_mean, data_std = my_func3(data)
print('mean:{0:3.2f}, std:{1:3.2f}'.format(data_mean, data_std))


# In[88]:


output = my_func3(data)
print(output)
print(type(output))
print('mean:{0:3.2f}, std:{1:3.2f}'.format(output[0], output[1]))


# In[89]:


data = np.random.randn(5)
print(data)
np.save('datafile.npy', data)  # 세이브
data = []                      # 데이터 삭제
print(data)
data = np.load('datafile.npy') # 로드
print(data)


# In[90]:


data1 = np.array([1, 2, 3])
data2 = np.array([10, 20, 30])
np.savez('datafile2.npz', data1=data1, data2=data2) # 세이브
data1 = [] # 데이터 삭제
data2 = []
outfile = np.load('datafile2.npz') # 로드
print(outfile.files) # 저장된 데이터 표시
data1 = outfile['data1'] # data1 꺼내기
data2 = outfile['data2'] # data2 꺼내기
print(data1)
print(data2)


# In[ ]:




