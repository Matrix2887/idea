package cn.gandan.day02.demo04;

import java.util.ArrayList;
import java.util.Collections;

public class Poker {
    public static void main(String[] args) {
        ArrayList<String> poker = poker();
        Collections.shuffle(poker);
        ArrayList<String> boot = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        for (int i = 0; i < poker.size(); i++) {
            if (i < poker.size()-3) {
                if (i % 3 == 0) {
                    player1.add(poker.get(i));
                } else if (i % 3 == 1) {
                    player2.add(poker.get(i));
                } else if (i % 3 == 2) {
                    player3.add(poker.get(i));
                }
            }else{
                boot.add(poker.get(i));
            }
        }
        System.out.println("玩家一:" + player1);
        System.out.println("玩家二:" + player2);
        System.out.println("玩家三:" + player3);
        System.out.println("底牌:" + boot);
    }
    public static ArrayList<String> poker(){
        ArrayList<String> poker = new ArrayList<>();
        String[] flow = {"♠","♥","♣","♦"};
        String[] num = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
//        for (int i = 0; i < flow.length; i++) {
//            for (int j = 0; j < num.length; j++) {
//                poker.add(flow[i] + num[j]);
//            }
//        }
        for(String flows : flow){
            for(String number : num){
                poker.add(flows + number);
            }
        }
        poker.add("👑");
        poker.add("📿");
        return poker;
    }
}
