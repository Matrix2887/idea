package cn.itcast.day09.test;

/*
1.定义Person类
		属性：
			姓名name、性别gender、年龄age、国籍nationality；
		方法：吃饭eat、睡觉sleep，工作work。
	2.根据人类，创建一个学生类Student
		增加属性：
			学校school、学号stuNumber；
		重写工作方法（学生的工作是学习）。
	3.根据人类，创建一个工人类Worker
		增加属性：
			单位unit、工龄workAge；
		重写工作方法（工人的工作是盖房子）。
	4.根据学生类，创建一个学生干部类 StudentLeader
		增加属性：
			职务job；
		增加方法：开会meeting。
	5.编写测试类分别对上述3类具体人物进行测试。

	6.要求运行结果:
		学生需要学习!
		工人的工作是盖房子!
		学生干部喜欢开会!
 */
public class Student extends Person{
    private static String school;
    private int stuNumber;
    private static int id = 0;


    public Student() {
        this.stuNumber = ++id;
    }


    public Student(String name, String gender, int age) {
        super(name, gender, age);
        this.stuNumber = ++id;
    }

    public static String getSchool() {
        return school;
    }

    public static void setSchool(String school) {
        Student.school = school;
    }

    public int getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(int stuNumber) {
        this.stuNumber = stuNumber;
    }
    @Override
    public void work(){
        System.out.println("学生的工作是学习");
    }

    @Override
    public void show(){
        super.show();
        System.out.println(" 学校:" + getSchool() + " 学号:" + getStuNumber());
    }
}
