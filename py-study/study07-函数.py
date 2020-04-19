# 函数也是一个对象,对象是内存中用来存储数据的一块区域,函数用来保存代码
# def 函数名([形参1,形参2,..形参n]):
#     代码块


def fn():
    print(1233)


print(fn)  # <function fn at 0x000001D25ADF8F70>
print(type(fn))  # <class 'function'>
fn()


def fn2(a, b, c=100):  # 参数指定默认值，不传参数就是用默认值
    print('a=', a)
    print('b=', b)
    print('c=', c)


fn2(12, 22)  # 按照位置一个一个传递过去
fn2(a=1, c=111, b=11)  # 关键字传参  按照关键字传递值,可以前面位置 后面关键字混合传递


def fn3(a):  # 参数可以传递任意类型
    # a = 0  对形参进行重新赋值,不会影响其他变量(实参)。
    a[0] = 33  # 但是如果形参执行的是一个对象,我们通过形参去修改对象时,会影响到所指向该对象的变量
    print('a=', a)


c = 3
c = [1, 2, 3]
fn3(c)  # 传递对象时,如果不想函数内部操作影响外部变量,可以传递 c.copy()  c[:] 等对象副本
print(c)


def fn4(b, *a):  # 可变参数(装包)   a以元组形式接受参数
    print('b=', b)
    result = 0
    for n in a:
        result += n
    print('result=', result)


fn4(1, 2, 3, 3)


def fn5(*a, b, c):
    print('b=', b)
    print('c=', c)
    print('a=', a)


fn5(1, 2, b=3, c=3)  # *a 变量后面的所有变量必须以关键字参数形式传递


def fn6(*, a, b):  # 形参开头写一个*,要求我们所有的参数必须以关键字形式传递
    print('a=', a)
    print('b=', b)


fn6(a=32, b=22)


def fn7(*a):
    print('a=', a)


# fn7(a=1, b=2, c=3) *形参只接受位置参数,不接受关键字参数


def fn8(g, **a):  # 以字典形式接受关键字参数,**形参只能有一个,并且只能写在最后
    print('a=', a)
    print('g=', g)


fn8(g=1, a=1, b=2)


def fn9(a, b, n):
    print('a=', a)
    print('b=', b)
    print('n=', n)


t = [10, 100, 1000]  # 传递一个序列类型时(list,元组,字符串),实参前加* ,可以解包 依次传递参数
fn9(*t)
t_dict = {'a': 11, 'b': 111, 'n': 111}
fn9(**t_dict)


def fn10(*nums):  # 函数可以返回任意类型,甚至是一个函数
    res = 0
    for num in nums:
        res += num
    return res


result = fn10(1, 2, 3)
print('result=', result)
print('输出一个函数', fn10)
print('输出函数返回值', fn10(1, 2))


def fn11():
    def fun():
        print("我是函数")
    return fun()


f = fn11()  # 函数返回一个函数
f()
