# py一个回车 是一个语句
# py是动态类型的语言，可以为变量赋任意类型的值，可以任意修改变量值
a = '测试'
_a = 2
print(a)
# 命名不能用关键字、保留字、函数名
# py数值分为 整数 浮点数 复数，整数的大小没有限制
a = 999_999_99  # a重新被赋值  _ 分割数值  方便辨认
print(a)
# 二进制 0b开头  八进制0o 十六进制0x开头  打印都是以十进制输出，浮点数运算可能不太精确
a = '我的' \
    '都是的的'
# 单引号 双引号 无法跨行使用，跨行需要加 \，不能保留字符串有多行的格式，即按一行输出
# 三引号可以跨行使用并且保留字符串格式 """  或 ''',字符串可配合转义字符 \t \n \\ \uxxx Unicode编码
print(a)
a = """是我
订单对
的"""
print(a)
# 字符串连接符 +   注意字符串只能 + 字符串，无法字符串+其他类型
print("a的值是" + a)
b = 3
# print("b的值是"+b)  不行， 可以多参数输出
print("b的值是", b)
b = "Hello %s" % "tom"
print(b)
b = "Hello %s,啊 %2s" % ("tom", 'hgga')
# %2s 最少2个字符 不足补空格，%2.5  限制2到5个字符
b = "啊啊%s" % 12.34
b = "保留几位小数 %0.1f" % 91.2354
# %0.1f 保留1位小数  .前面是整数位  后面小数位  不足补0
print(b)
# %d  输出整形
b = 24325
print("b的值是%d" % b)
c = f"哈哈哈{b}啊啊{'我啊草'}啊啊"
# 格式化字符串  前面加f  字符串内部{变量名}
print(c)
# 字符串 和数字n相乘  会将字符串连续输出n次 'a' * 3   -->aaa
# 布尔值默认 True 1  False 0
c = None  # None 表示不存在  即空值
print(c)
# type() 返回变量类型
print(type(True))
