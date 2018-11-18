package cn.itcast.day00.practice01;

/*
（1）定义Student类，属性：score(成绩：double类型)，age(年龄：int类型)
（2）定义Check类，方法：test，方法所需参数Student类对象，方法功能如下：
对学生成绩进行四舍五入
（3）1.定义测试类Test04，在main方法中创建5个学生对象，对象信息通过键盘录入获取
并将学生对象存储到集合1中，打印集合中对象的属性信息
2.使用test方法，对学生对象的成绩进行操作，将操作后的学生对象存储到集合2中，
打印集合中对象的属性信息
 */
public class Student {
    private double score;
    private int age;

    public Student() {
    }

    public Student(double score, int age) {
        if(score < 0){
            System.out.println("去你妈的,玩老子呢");
        }else{
            this.score = score;
        }
        if(age < 0 && age > 200){
            System.out.println("去你妈的,玩老子呢");
        }else{
            this.age = age;
        }
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if(score < 0){
            System.out.println("去你妈的,玩老子呢");
        }else{
        this.score = score;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0 && age > 200){
            System.out.println("去你妈的,玩老子呢");
        }else{
            this.age = age;
        }
    }
    public void show(){
        System.out.println("成绩:" + getScore() + "年龄:" + getAge());
    }
}
