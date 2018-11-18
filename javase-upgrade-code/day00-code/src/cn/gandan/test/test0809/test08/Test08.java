package cn.gandan.test.test0809.test08;

import java.util.*;

/*
第八题：分析以下需求，并用代码实现
	定义Student类包含姓名：String name、年龄：int age、成绩：int score，生成空参、有参构造、set和get方法、toString方法
	1.创建10个学生对象(其中有两个学员信息完全相同)存入集合中
	2.去除重复的学员并遍历打印剩余学员信息(分别利用增强for循环、迭代器遍历)
	3.打印最高分的学员信息
	4.打印平均分
	5.打印不及格的学员信息及数量
 */
public class Test08 {
    public static void main(String[] args) {
        Student s0 = new Student("艾登.皮尔斯",35,150);
        Student s1 = new Student("玛丽.皮尔斯",27,120);
        Student s2 = new Student("刹那.F.塞尔",17,80);
        Student s3 = new Student("富兰克林",31,50);
        Student s4 = new Student("富兰克林",31,50);
        Student s5 = new Student("麦克.迪圣塔",45,80);
        Student s6 = new Student("崔佛.菲利普",40,60);
        Student s7 = new Student("海恩斯",48,80);
        Student s8 = new Student("艾吉奥.奥迪托雷",35,90);
        Student s9 = new Student("康纳.肯威",25,50);
        Set<Student> students = new HashSet<>();
        students.add(s0);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);
        students.add(s8);
        students.add(s9);
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("============================================");
        Iterator<Student> it = students.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("============================================");
        high(students);
        System.out.println("============================================");
        int average = average(students);
        System.out.println(average);
        System.out.println("============================================");
        people(students);
    }

    public static void high(Set<Student> stu){
        List<Student> student = new ArrayList<>();
        for (Student s : stu) {
            student.add(s);
        }
        Student count = student.get(0);
        for (Student st : student) {
            if(st.getScore() > count.getScore()){
                count = st;
            }
        }
        System.out.println(count);
    }

    public static int average(Set<Student> stu){
        List<Student> student = new ArrayList<>();
        for (Student s : stu) {
            student.add(s);
        }
        int sum = 0;
        for (Student st : student) {
            sum += st.getScore();
        }
        return sum/student.size();
    }
    public static void people(Set<Student> stu){
        for (Student student : stu) {
            if(student.getScore() < average(stu)){
                System.out.println(student);
            }
        }

    }
}
