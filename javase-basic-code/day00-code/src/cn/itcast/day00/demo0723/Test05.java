package cn.itcast.day00.demo0723;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
定义一个Person类，包含满参构造方法和以下成员属性：
	成员属性:
	              姓名（String）
	              年龄（int）
	              爱好（String）

	a. 定义一个测试类Test，在Test类的main方法中利用满参构造创建三个Person对象
	“李明”,22, "游泳";”王红”,30,"登山"; "赵玉",40,"跳舞 "。
	b. 将这三个对象存入ArrayList<Person>集合中
	c. 遍历集合，输出年龄在30岁以上的对象的所有属性
 */
public class Test05 {
    public static void main(String[] args) {
        ArrayList<Person> person = new ArrayList<>();
        Person one = new Person("李明",22, "游泳");
        Person two = new Person("王红",30,"登山");
        Person three = new Person("赵玉",40,"跳舞 ");
        person.add(one);
        person.add(two);
        person.add(three);
        for (int i = 0; i < person.size(); i++) {
            if(person.get(i).getAge() > 30){
                person.get(i).show();
            }
        }
    }
}
