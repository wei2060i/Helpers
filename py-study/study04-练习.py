# 模块 通过模块对python 扩展
from time import *

begin = time()
i = 2
while i <= 10:
    flag = True
    j = 2
    while j <= i ** 1 / 2:
        if i % j == 0:
            flag = False
            break
        j = j + 1
    if flag:
        print(i)
    i += 1
end = time()
print("程序花费了", end - begin, "秒")
print('-' * 5, "欢迎来到《唐僧大战白骨精》", '-' * 5)
print('请选择你的身份:')
print('\t1.唐僧')
print("\t2.白骨精")
player_choose = input('请选择[1-2]:')
if player_choose == "1":
    print('你已经选择了唐僧')
elif player_choose == '2':
    print('你竟然选择了白骨精')
else:
    pass
# 创建玩家和boss的生命值 、攻击力
player_life = 10
player_attack = 10
boss_life = 20
boss_attack = 20
print(f'唐僧,您的生命值是{player_life},你的攻击力是{player_attack}')
while True:
    print("请你选择要进行的操作:")
    print('\t1.练级')
    print("\t2.打BOSS")
    print("\t3.逃跑")
    game_choose = input("请选择要做的操作[1-3]:")
    if game_choose == '1':
        player_life += 2
        player_attack += 2
        print(f'恭喜你升级了!,你现在的生命值是{player_life},你的攻击力是{player_attack}')
    elif game_choose == '2':
        boss_life -= player_attack
        print('->唐僧<-攻击了 ->白骨精<-')
        if boss_life <= 0:
            print(f'->白骨竟<-受到了{player_attack}点伤害,死亡,唐僧胜利')
            break
        player_life -= boss_life
        print('白骨精攻击了唐僧')
        if player_life <= 0:
            print(f'你受到了{boss_attack}点伤害,game over')
            break
    elif game_choose == '3':
        print('唐僧逃跑。。')
    else:
        print('输入错误')