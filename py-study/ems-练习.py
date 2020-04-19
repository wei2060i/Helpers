print("-"*20, '欢迎使用员工管理系统', "-"*20)
emps = ['孙悟空\t12\t男\t花果山']
while True:
    print("请选择你要做的操作:")
    print("\t1.查询员工")
    print("\t2.添加员工")
    print("\t3.删除员工")
    print("\t4.退出系统")
    user_choose = input("请选择[1-4]:")
    print("-" * 40)
    if user_choose == '1':
        print("\t序号\t姓名\t年龄\t性别\t住址")
        n = 1
        for emp in emps:
            print(f'\t{n}\t{emp}')
            n += 1
    elif user_choose == '2':
        emp_name = input("请输入员工的姓名:")
        emp_age = input("请输入员工的年龄")
        emp_gender = input("请输入员工的性别")
        emp_address = input("请输入员工的地址")
        emp = f'{emp_name}\t{emp_age}\t{emp_gender}\t{emp_address}'
        print("以下员工将被添加到emps:")
        print("-" * 40)
        print('姓名\t年龄\t性别\t住址')
        print(emp)
        user_confirm = input("是否确认添加操作[Y/N]")
        if user_confirm == 'y' or user_confirm == 'yes':
            emps.append(emp)
            print("添加成功")
        else:
            print("添加已取消")
    elif user_choose == '3':
        del_num = int(input('请输入要删除的员工序号:'))
        if 0 < del_num <= len(emps):
            del_i = del_num - 1
            print("以下员工将被删除:")
            print("-" * 40)
            print('序号\t姓名\t年龄\t性别\t住址')
            print(f'\t{del_num}\t{emps[del_i]}')
            print("-" * 40)
            user_confirm = input("该操作不可恢复,是否确认添加操作[Y/N]")
            if user_confirm == 'y' or user_confirm == 'yes':
                emps.pop(del_i)
                print("删除成功")
            else:
                print("操作已取消")
    elif user_choose == '4':
        print("欢迎使用!再见!")
        input("点击回车退出")
        break
    else:
        print("你输入的有误")
    print("-" * 40)
