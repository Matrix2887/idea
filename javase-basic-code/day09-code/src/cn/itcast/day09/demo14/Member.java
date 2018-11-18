package cn.itcast.day09.demo14;

import java.util.ArrayList;
import java.util.Random;

public class Member extends Use{

    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }

    public void receive(ArrayList<Integer> list,ArrayList<Member> members){
        Random r = new Random();
        int time = list.size();
        for (int i = 0; i < time; i++) {
            int temp = r.nextInt(list.size());
            members.get(i).setMoney(members.get(i).getMoney() + list.get(temp));
            System.out.println(members.get(i).getName() + " 抢到" + list.get(temp) + "元 余额还剩" + members.get(i).getMoney() + "元");
            list.remove(temp);
        }
    }
}
