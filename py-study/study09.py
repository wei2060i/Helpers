# 将函数作为返回值返回,也是一种高阶函数
# 这种高阶函数也叫做闭包,通过闭包可以创建一些只有当前函数能访问的变量
# 可以将一些私有的数据藏在闭包中


def Zlj():
    nums = []

    def inner(i):
        nums.append(i)
        return sum(nums) / len(nums)

    return inner


z = Zlj()
print(z(1))
print(z(3))
print(z(129))


def Z(fn):
    def new_z(*arg, **args):
        print('函数开始执行')
        res = fn(*arg, **args)
        print('函数执行结束')
        return res

    return new_z


@Z   # @装饰器    增强函数功能
def L(a, b):
    r = a + b
    return r


def J(a, b):
    r = a * b
    return r


print(Z(J)(1, 2))  # Z函数就是一个装饰器,类似与aop

print(L(1, 99))
