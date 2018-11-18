package cn.itcast.day00.demo0722;

/*
1.定义Empl类，包含salary（工资属性私有化），提供空参带参构造方法，和set/get方法
2.定义ArrayList集合，存入3个Empl对象，对象的薪资属性分别为：100，123，567
3.遍历集合,将集合中元素的薪资小于等于300的元素删除，将集合中元素的薪资大于300的元素，
元素值在原来基础上加100，并在控制台打印输出修改后集合中所有元素的属性

 */
public class Empl {
    private String name;
    private int salary;

    public Empl() {
    }

    public Empl(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public void show(){
        System.out.println("姓名\t" + name);
        System.out.println("薪资\t" + salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
