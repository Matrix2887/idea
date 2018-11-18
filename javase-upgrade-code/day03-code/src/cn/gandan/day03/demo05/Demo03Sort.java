package cn.gandan.day03.demo05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
    java.utils.Collections是集合工具类,用来对集合进行操作.部分方法如下:
    public static<T> void sort(List<T> list):将集合中元素按照默认规则排序


    Comparator和Comparable的区别
        Comparable:自己(this)和别人(参数)比较,自己需要实现Comparable接口,重写比较的规则compareTo方法
        Comparator:相当于找一个第三方的裁判,比较两个

    Comparator排序规则
        o1 - o2:升序
        o2 - o1:降序

 */
public class Demo03Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,3,2);
        System.out.println(list);// [1, 3, 2]

        Collections.sort(list, new Comparator<Integer>() {
            // 重写比较的规则
            @Override
            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;// 升序排序
                return o2 - o1;// 降序排序
            }
        });

        System.out.println(list);

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("富兰克林",28));
        students.add(new Student("b麦克.迪圣塔",45));
        students.add(new Student("崔佛.菲利普",42));
        students.add(new Student("a崔佛.菲利普",45));
        System.out.println(students);

//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                // 按照年龄升序排序
//                return o1.getAge() - o2.getAge();
//            }
//        });

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 按照年龄升序排序
                int result =  o1.getAge() - o2.getAge();
                // 如果两个人的年龄相同,再使用姓名的首字比较
                if(result == 0){
                    result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return result;
            }
        });
        System.out.println(students);
    }
}
