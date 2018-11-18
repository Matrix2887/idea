package cn.itcast.day07.demo04;

import java.util.ArrayList;

public class Demo04ArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("迪丽热巴");
        list.add("胡歌");
        list.add("艾登.皮尔斯");

        // 遍历集合
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
