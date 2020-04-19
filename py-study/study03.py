if True:
    print(2)
    print(29)
    if True:
        print(3)
# 代码块  缩进代码块开始,结束缩进代码块结束,缩进是按 四个空格算的
print(44)
# a = input("请输入内容:")  # 用户输入，返回的是字符串
# print(a)
if False:
    print("无法输出")
else:
    print("能输出")
# if-elif    注意缩进
if False:
    print("无法输出")
elif True:
    print(33)
else:
    print(44)
# 多参数输出格式，前后位置无所谓
print(12, "测试值")
print("测试值", 21, "测试", 88)

i = 0
while i < 3:
    print(i)
    i += 1
else:
    print("while结束")
# end= 不换行操作
print("*", end='')
print("*", end='')
j = 0
while j < 5:
    j += 1
    if j == 2:
        break
    print("测试break", j)
else:
    print('循环结束')



