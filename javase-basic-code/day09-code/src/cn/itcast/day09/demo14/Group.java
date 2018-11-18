package cn.itcast.day09.demo14;

import java.util.ArrayList;

public class Group {
    public static void main(String[] args) {
        Master master = new Master("钢铁侠 ",1999999999);
        ArrayList<Member> members = new ArrayList<>();
        Member member00 = new Member();
        Member member01 = new Member("美国队长",1000);
        Member member02 = new Member("黑寡妇 ",1500);
        Member member03 = new Member("雷神  ",1000);
        Member member04 = new Member("奇异博士",60000);
        Member member05 = new Member("星爵  ",10000);
        Member member06 = new Member("蜘蛛侠 ",10);
        members.add(member01);
        members.add(member02);
        members.add(member03);
        members.add(member04);
        members.add(member05);
        members.add(member06);
        master.show();
        for (int i = 0; i < members.size(); i++) {
            members.get(i).show();
        }
        int totalMoney = 520000;
        int count = 1;

        member00.receive(master.send(totalMoney,count,members.size()),members);
    }
}
