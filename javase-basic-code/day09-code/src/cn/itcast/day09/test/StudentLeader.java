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
public class StudentLeader extends Student{
    private String job;
    @Override
    public void show(){
        super.show();
        System.out.println(" 职务:" + getJob());
    }

    public StudentLeader() {
    }

    public StudentLeader(String name, String gender, int age, String job) {
        super(name, gender, age);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void meeting(){
        System.out.println("学生干部喜欢开会!");
    }
}
