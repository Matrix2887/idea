package cn.itcast.day11.demo08;

import cn.itcast.day11.red.OpenMode;
import cn.itcast.day11.red.RedPacketFrame;

import java.util.ArrayList;

public class MyRed extends RedPacketFrame{
    /**
     * 构造方法：生成红包界面。
     *
     * @param title 界面的标题
     */
    public MyRed(String title) {
        super(title);
    }

}
