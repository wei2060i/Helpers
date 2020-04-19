# 列表(list) 是python中的对象
# 对象是内存中专门用来存储数据的一块区域
# 之前学的对象，只能保存一个单一的数据,列表可以保存多个有序的数据(任意对象)
my_list = [1, 2, 3, True, None, [1, 2], print]
print(my_list)
print(len(my_list))
print(my_list[0], my_list[-1])  # 负数表示倒数第几个
print(my_list[0:-1])  # 切片获取子列表 包含头 不包含尾
print(my_list[0:-1:2])  # 步长  默认是1    [1, 3, None]
# 如果起始位置和结束位置全部省略，则相当 于创建了一个列表的副本
print(my_list[:])
# 步长可以是负数 但不能是0,负数倒着取值
print(my_list[::-1])
print("----------------------------------------")
# + 将两个列表 拼接成一个列表
print([1, 2, 3] + [5, 6, 8])
# * 将列表重复指定的次数
new_list = [0, 0, 10] * 3
print(new_list)
print(0 in new_list)
print(9 not in new_list)
print(min(new_list), max(new_list))
# 两个方法 index()返回指定元素位置,没有就抛异常  count() 统计指定元素的个数,没有返回0
print(new_list.index(0), new_list.count(0))
# 序列(sequence) 是python中最基本的一种数据结构
# 序列用于保存一组有序的数据，所有的数据在序列中都有唯一一个位置(索引),按照添加顺序分配索引
# 分为可变序列:list  不可变序列 字符串,元组
stu = ["孙悟空", "总面积", "生三", "三世"]
stu[0] = '孙悟空副本'
print(stu)
del stu[2]
stu.append("dad")
print(stu)
# 用切片进行赋值时，只能使用序列,使用后面的序列赋值给前面,无论后面的序列多少个，都用来全部替换切片所包含的值
stu[0:2] = ["唐三"]
print(stu)
stu[0:0] = ["唐浩"]  # 向索引为0 的位置插入元素
print(stu)
stu[::2] = ["小舞", "朱朱清"]  # 设置步长时，后面序列的元素个数必须和前面切片包含的元素个数一致
print(stu)
# 也可以通过切片删除序列，del stu[0:2] del stu[0:0:2]
# stu[0:1] = [] 赋值空序列也可以删除
# 可变序列可以修改(删除、修改)，不可变序列无法通过索引修改  但可以通过list()函数转换为可变序列
s = "AddaFi"
s_list = list(s)
print(s_list)
print("----------列表方法------------")
s_list.append("小舞")
print(s_list)
s_list.insert(1, "唐三")
print(s_list)
s_list.extend([1, 2, 4])
print(s_list)
# s_list.clear() 清空序列
s_pop = s_list.pop()  # 返回被删除的元素,不写索引删除最后一个
print(s_pop, s_list)
s_list.remove("d")  # 删除指定元素，没有返回值，有多个相同元素，只删第一个
print(s_list)
s_list.reverse()   # 反转列表
print(s_list)
sort_list = list("Asd")
sort_list.sort(reverse=True)  # reverse=True 写这个参数表示降序
print(sort_list)
for s in sort_list:
    print(s)
