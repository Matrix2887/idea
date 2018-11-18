package cn.itcast.day11.demo03;

public class Body {// 外部类

    public class Heart{// 成员内部类

        // 内部类的方法
        public void beat(){
            System.out.println("咚咚咚救人质");
            System.out.println("我叫" + name);
        }

    }
    public class Uplay{
        public void game() {
            System.out.println("育碧新鲜土豆");
        }
        }

    // 外部类的成员变量
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    // 外部类的方法
    public void methodBody(){
        System.out.println("外部类的方法");
        new Heart().beat();
    }
    public void methodGame(){
        new Uplay().game();
    }
}
