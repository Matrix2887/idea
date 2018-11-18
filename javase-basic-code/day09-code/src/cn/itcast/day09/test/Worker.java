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
public class Worker extends Person{
    private String unit;
    private int workAge;
    @Override
    public void show(){
        super.show();
        System.out.println(" 单位:" + getUnit() + " 工龄:" + getWorkAge());
    }

    public Worker() {
    }

    public Worker(String name, String gender, int age) {
        super(name, gender, age);
    }

    public Worker(String unit, int workAge) {
        this.unit = unit;
        this.workAge = workAge;
    }

    public Worker(String name, String gender, int age, String unit, int workAge) {
        super(name, gender, age);
        this.unit = unit;
        this.workAge = workAge;
    }

    @Override
    public void work(){
        System.out.println("工人的工作是盖房子");
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }
}
