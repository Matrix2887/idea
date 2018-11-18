package cn.gandan.day04.test;

import java.util.*;

public class Poker {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        ArrayList<Integer> boot = new ArrayList<>();
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        List<String> flow = List.of("♠","♥","♣","♦");
        List<String> num = List.of("2","A","K","Q","J","10","9","8","7","6","5","4","3");
//        poker.add("👑");
//        poker.add("📿");

        HashMap<Integer, String> poker = new HashMap<>();
        Integer count = 0;
        poker.put(count++,"👑");
        poker.put(count++,"📿");
        for (String nu : num) {
            for (String flo : flow) {
                poker.put(count++ ,flo + nu);
//                count++;
            }
        }
        for (int i = 0; i < poker.size(); i++) {
            list.add(i);
        }
//        Set<Integer> n = poker.keySet();
//        for (Integer t : n) {
//            list.add(t);
//        }
        Collections.shuffle(list);
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size()-3) {
                if (i % 3 == 0) {
                    player1.add(list.get(i));
                } else if (i % 3 == 1) {
                    player2.add(list.get(i));
                } else if (i % 3 == 2) {
                    player3.add(list.get(i));
                }
            }else{
                boot.add(list.get(i));
            }
        }
        Collections.sort(boot);
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);


        System.out.println(poker);
        System.out.print("底牌:");
        print(boot,poker);
        System.out.print("艾登.皮尔斯:");
        print(player1,poker);
        System.out.print("麦克.迪圣塔:");
        print(player2,poker);
        System.out.print("艾吉奥.奥迪托雷:");
        print(player3,poker);

    }
    public static void print(ArrayList<Integer> list,HashMap<Integer, String> poker){
        for (Integer i : list) {
            String c = poker.get(i);
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
