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
public class Company {
    private String name;
    private int id;
    private int money;

    public void show(){
        System.out.println("姓名:" + name + " 工号:" + id + " 工资:" + money);
    }
    public void work(){
        System.out.println("苦逼的工作");
    }

    public Company() {
    }

    public Company(String name, int id, int money) {
        this.name = name;
        this.id = id;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}
