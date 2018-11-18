package cn.itcast.day06.text;

public class Text02 {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Coder coder = new Coder();
        manager.setName("项目经理");
        manager.setId(123);
        manager.setSalary(15000);
        manager.setBonus(6000);
        manager.work();
        coder.setName("程序员");
        coder.setId(135);
        coder.setSalary(10000);
        coder.work();
    }
}
