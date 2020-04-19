help(print)  # 查看函数用法


# 文档字符串 定义函数  形参:需要的类型               -> 函数返回类型
def fn(a: int, b: bool, c: str = 'hello') -> int:
    """
    :param a:
    :param b:
    :param c:
    :return: int
    """
    return 10


fn(1, True, "2")
help(fn)
# 作用域:全局作用域、函数作用域(局部作用域)
# 使用变量时,优先在当前作用域找变量,没有就去上一作用域找

a = 11


def fn2():
    def fn3():
        b = 11  # 默认创建局部变量
        global a
        a = 1  # 如果想修改全局变量,需要在上面声明之
        print('fn3:', 'a=', a)

    fn3()


fn2()

# 命名空间(namespace)
# 命名空间指的是变量存储的位置,每一个变量都需要存储在指定的命名空间中
# 每一个作用域都会有一个它对应的命名空间,命名空间实际上是一个字典
# 全局命名空间用来保存全局变量,函数命名空间用来保存函数中的变量
# locals() 获取当前作用域的命名空间,返回一个字典
# globals() 在任意位置获取全局命名空间
scope = locals()
scope['c'] = 1000  # 向当前作用域添加变量c
print('scope:', scope)
print('scope:', c)
glo = globals()
print('glo:', glo)


def factorial(n):
    """
    :param n:
    :return:求n的阶乘
    """
    result = n
    for i in range(1, n):
        result *= i
    return result


print('10的阶乘', factorial(10))


def diGui(n):
    """
    递归 求阶乘
    :param n:
    :return:
    """
    if n == 1:
        return 1
    return n * diGui(n - 1)


print(diGui(10))


def power(n, i):
    if i == 1:
        return n
    return n * power(n, i - 1)


print('阶乘', pow(10, 2))


def hui_wen(n):
    if len(n) < 2:
        return True
    return n[0] == n[-1] and hui_wen(n[1:-1])


print('判断回文', hui_wen("aba"))


# 函数式编程
# 在python中,函数是一等对象,一等对象一般具有以下特点
# 1对象是在运行时创建的 2 能赋值给变量或作为数据结构中的元素
# 3 能作为参数传递  4 能作为返回值返回
# 高阶函数  特点: 1 接受一个或多个函数为参数 2 将函数作为返回值返回


def fn1(i):
    if i % 2 == 0:
        return True
    return False


def fn2(i):
    if i > 5:
        return True
    return False


def fn3(func, lst):
    new_list = []
    for n in lst:
        if func(int(n)):
            new_list.append(n)
    return new_list


print(fn3(fn1, "1247"))

# filter() 可以从序列中过滤出符合条件的元素,保存到一个新的序列
# 参数 1函数,根据该函数过滤序列 2 需要过滤的序列(可迭代的结构) 返回值:过滤后的新序列(可迭代的结构)
print(list(filter(fn1, [1, 2, 7, 8, 12])))
# 匿名函数  lambda表达式 语法:lambda 参数列表:返回值
var = lambda a, b: a + b
print('var函数', var(1, 2))
print(list(filter(lambda i: i % 3 == 0, [1, 2, 7, 8, 12])))

# map() 可以对可迭代的对象中的所有元素做指定的操作,然后将其添加到一个新的对象中返回
r = map(lambda i: i + 1, [1, 2, 3, 3, 4, 5])
print(r, list(r))

# sort() 对列表中的元素进行排序,默认直接比较列表中元素的大小
# 在sort()可以接受一个关键字参数 key(一个函数) 利用此函数比较大小
l = ['bb', 'a', 'ccc', 'jojoba', 'l']
l.sort(key=len)
print(l)
l = [2, '5', 2]
l.sort(key=int)
print(l)
# sorted() 和sort() 用法基本一致,但是sorted()可以对任意列表进行排序
# sorted()排序 不会影响原来的对象,而是返回一个新对象
l = "253483"
print(sorted(l), '---', l)
