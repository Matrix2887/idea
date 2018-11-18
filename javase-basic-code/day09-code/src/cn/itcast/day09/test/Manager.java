package cn.itcast.day09.test;

/*
1.定义项目经理类
		属性：
			姓名 工号 工资 奖金
		行为：
			工作work
	2.定义程序员类
		属性：
			姓名 工号 工资
		行为：
			工作work

	3.要求:向上抽取一个父类,让这两个类都继承这个父类,共有的属性写在父类中，子类重写父类中的方法

		编写测试类:完成这两个类的测试

 */
public class Manager extends Company{
    private int reward;


    public Manager() {
    }

    public Manager(String name, int id, int money) {
        super(name, id, money);
    }

    public Manager(int reward) {
        this.reward = reward;
    }

    public Manager(String name, int id, int money, int reward) {
        super(name, id, money);
        this.reward = reward;
    }

    @Override
    public void work(){
        System.out.println("整合代码");
    }

    @Override
    public void show(){
        super.show();
        System.out.println("奖金:" + getReward());
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }
}
