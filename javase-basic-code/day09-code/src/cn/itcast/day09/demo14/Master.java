package cn.itcast.day09.demo14;

import java.util.ArrayList;

public class Master extends Use{
    public Master() {
    }

    public Master(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int totalMoney, int count,int people){
        ArrayList<Integer> list = new ArrayList<>();
        if(super.getMoney() > totalMoney){ setMoney(super.getMoney() - totalMoney);
            for (int i = 0; i < people; i++) {
                if(i < count-1){
                    list.add(i, totalMoney / count);
                }else if(i == count - 1){
                    list.add((totalMoney % count) + (totalMoney / count));
                }else {
                    list.add(0);
                }
            }
            System.out.println(super.getName() + " 发了" + totalMoney + "元" + "余额还剩" + super.getMoney() + "元");
            return list;
        }else{
            System.out.println("地主家没余粮了");
            return list;
        }

    }
}
