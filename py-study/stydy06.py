# range()是一个函数 可以生成一个自然数序列
# 此函数参数 1起始位置(默认0，可省略) 2结束位置  3步长(默认1，可省略)
r = list(range(5))
print(r)
for s in range(4):
    print(s)
for s in "Asa":
    print(s)
# 元祖 tuple 不可变序列，用法和列表一样
my_tuple = (0, 21, 2)
print(my_tuple)
t_tuple = 1, 2, 3, 5  # 不是空元祖，括号可省略
a, b, *c = t_tuple  # 解包 元素个数需要和变量个数一样, 否则 需要一个*变量
print(a, b, c)
print("-" * 20)
# 列表就是一个可变对象 a = [1,2,3]
# a[0] = 10,这种操作是通过变量修改对象的值,不会影响变量指向的对象
# 当我们去修改对象时，如果有其他变量也指向该对象，则修改也会在其他变量上体现
# a = [2,1,3] 这种是给变量重新赋值，此操作会改变变量所指向的对象
# ==  != 比较的是两个对象的值是否相等
# is is not 比较的两个对象的id是否相等
# 字典 dict 属于一种新的数据结构，称为映射(mapping)
# 字典和列表类似，用于存储对象的容器,列表存储性能好，查询性能差
# 在字典中每一个元素都有唯一的名字，通过这个唯一名字，可以快速查找想要的元素
# 字典是 key value 结构 ,value可以是任意不可变对象,key可以是任意不可变对象(int,str,bool,tuple...)
# key不能重复，重复的话,后面的会替换前面的
d = {'name': "悟空"}  # 创建字典方式1
print(d['name'])
# 使用dict() 函数创建字典
di = dict(name='悟空', age=11)
print(di)
# 也可以将一个包含双值子序列的序列转换为字典
l_dict = dict([(1, 2), (2, 3)])  # 双值，只有两个值的序列，值也是序列的序列称为子序列
print(l_dict, len(l_dict))
# in 检查字典是否包含指定的键  not in 检查字典是否不包含指定的键
print(l_dict[1])
# 通过[] 来获取值时,如果键不存在，会抛出keyError异常
# 通过 get() 来获取值时,如果键不存在,会返回None,也可以设置默认值
print(l_dict.get(3, "默认"))
l_dict["name"] = "悟空"  # 如果key存在就覆盖不, 存在就添加
# setdefault 如果key已经存在,返回该值,如果key不存在,则添加值并返回该值
result = l_dict.setdefault("name1", "山上")
print(l_dict, result)
# dict1.update(dict2) 将dict2 字典中的key-value添加到dict1里面去
# 如果key重复,则dict2替换掉dict1
del l_dict[1]
print(l_dict)
# popitem() 随机删除一个元素,一般删除最后一个,返回元组形式，就是被删除的key-value
# popitem() 空数组会抛异常
result = l_dict.popitem()
print("result:", result)
ll = l_dict.pop(2)  # pop(key,default]) 会返回被删除的值,key不存在抛异常
# 设置默认值,key不存在返回默认值
# l_dict.clear() 清空字典
print(l_dict)
d_dict = l_dict.copy()  # copy浅复制,复制以后的对象和原对象是独立的,修改一个不会影响另一个
print(d_dict)
# 浅复制只简单的复制对象内部的值,如果值也是一个可变对象，不会被复制
d = {"a": 2, "b": {1: 1}}
d2 = d.copy()  # d d2是两个对象 ,但字典里面的字典是同一个对象
d2['b'][1] = "A55"
print(d2)
print(d)
d3 = {"name": "孙悟空", "age": 11}
for f in d3.keys():
    print(f)
# keys()返回所有的 key,values() 会返回所有的值,items() 返回含有双值子序列
for k, v in d3.items():
    print(k, v)
# 集合set 集合和列表非常相似
# 不同点:1集合中只能存储不可变对象  2集合中存储的对象是无序的(和插入的顺序无关) 3集合不能出现重复元素
s = {1, 3, 4}
print(s)
# set() 函数创建集合
s_set = set([1, 3, 4, 4])
s_set = set((1, 3, 4, 4))
s_set = set("Asda")
s_set = set({"a": 12, "b": 22})  # 字典的key 创建集合
print(s_set)
# in 、not in 检查集合中的元素   len(s_set) 返回个数
s_set.add(10)
print(s_set)
# update() 将一个集合中的元素添加到当前集合中
s_set.update(('c', 'd'))
print(s_set)
# pop() 随机删除一个集合,一般从头开始删除,返回已删除元素
res = s_set.pop()
print(s_set, res)
s_set.remove('d')  # 删除指定元素
# clear() 清空集合   copy() 浅复制
s = {1, 2, 3, 4, 5}
s1 = {3, 4, 5, 6, 7}
result = s & s1
print(result)  # 交集 3 4 5
result = s | s1
print(result)  # 并集 1 2 3 4 5 6 7
result = s - s1
print(result)  # 差集 1 2
result = s ^ s1   # 亦或集  获取只在一个集合中出现的元素
print(result)
# <= 检查一个集合是否是另一个集合的子集
a = {1, 2, 3}
b = {1, 2, 3, 4, 5}
result = a <= b
print(result)  # 集合a是集合b的子集,集合b是集合a的超集
result = a < b  # < 真超集  真子集
print(result)
