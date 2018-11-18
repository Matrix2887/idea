package cn.gandan.test.test0810;

import java.util.Objects;

/*
1.分析以下需求，并用代码实现
	1.定义一个map集合,key为String类型的姓名,value为String类型地址,存入数据多条数据(假设不存在重名的情况),并用多种方式遍历
	2.定义一个map集合,key为Student类型的对象,value为String类型的地址,存入数据多条数据(需要加入对象的唯一性判断)
		(1)定义一个学生类Student，包含属性：姓名(String name)、年龄(int age)、成绩(int score)
		(2)定义Map集合，用Student对象作为key，用字符串(此表示表示学生的住址)作为value
		(3)利用四种方式遍历Map集合中的内容，格式：key::value
 */
public class Student {
    private String name;
    private int age;
    private int score;

    public Student() {
    }

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                score == student.score &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
