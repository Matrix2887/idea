package cn.itcast.day00.demo0722;

import java.util.ArrayList;

/*
1.定义Empl类，包含salary（工资属性私有化），提供空参带参构造方法，和set/get方法
2.定义ArrayList集合，存入3个Empl对象，对象的薪资属性分别为：100，123，567
3.遍历集合,将集合中元素的薪资小于等于300的元素删除，将集合中元素的薪资大于300的元素，
元素值在原来基础上加100，并在控制台打印输出修改后集合中所有元素的属性

 */
public class Test09 {
    public static void main(String[] args) {
        ArrayList<Empl> list = new ArrayList<>();
        Empl one = new Empl("麦克迪圣塔",567);
        Empl two = new Empl("崔佛菲利普",123);
        Empl three = new Empl("富兰克林",100);
        list.add(one);
        list.add(two);
        list.add(three);
        int count = list.size();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getSalary() <= 300){
                list.remove(i);
                i--;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setSalary(list.get(i).getSalary() + 100);
            list.get(i).show();
        }
    }
}
