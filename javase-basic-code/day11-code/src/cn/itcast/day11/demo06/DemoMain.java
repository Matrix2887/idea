package cn.itcast.day11.demo06;

import cn.itcast.day11.demo03.Body;

public class DemoMain {
    public static void main(String[] args) {
        // 创建一个英雄角色
        Hero hero = new Hero();
        // 为英雄起一个名字,并且设置年龄
        hero.setName("IQ");
        hero.setAge(18);

        // 创建一个武器对象
        Weapon weapon = new Weapon("AUG");
        // 为英雄配备武器
        hero.setWeapon(weapon);

        // 年龄为18的IQ用AUG反恐
        hero.attack();
    }
}
