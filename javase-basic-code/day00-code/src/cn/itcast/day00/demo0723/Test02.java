package cn.itcast.day00.demo0723;

import java.util.ArrayList;

/*
1.	定义"学员"类Stu,类中包含以下成员:
    成员属性: name(姓名)：String类型, age(年龄):int类型,属性使用private修饰,为所有属性提供set/get方法
2.	定义类：Test,类中定义main()方法，依次完成以下要求:
2.1 实例化2个Stu对象stu1和stu2，2个对象的属性分别为：”Jack”, 27、”Tom”,31；
2.2	创建一个ArrayList集合，将上面的2个Stu对象添加到集合中；
2.3	实例化1个Stu对象stu3，对应的属性为：”Rose”, 29；
2.4	通过遍历将集合中年龄属性大于29的元素替换成stu3，全部替换完后，按照如下格式输出元素信息:

 */
public class Test02 {
    public static void main(String[] args) {
        Student jack = new Student("Jack", 27);
        Student tom = new Student("Tom", 31);
        Student rose = new Student("Rose", 29);
        ArrayList<Student> list = new ArrayList<>();
        list.add(jack);
        list.add(tom);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getAge() > 29){
                list.set(i,rose);
            }
                list.get(i).show();
        }
    }
}
