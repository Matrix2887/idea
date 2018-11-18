package cn.itcast.day06.demo06;

public class Demo01Exercise {
    public static void main(String[] args) {
        Exercise dog = new Exercise ();
        dog.setName("艾登.皮尔斯");
        dog.setAge(38);
        dog.setJob("黑客");
        dog.watchDog("我");
        System.out.println("芝加哥的" + dog.getName() + "年龄是" + dog.getAge() + "岁" + "职业" + dog.getJob());
    }
}
