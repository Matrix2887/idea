package cn.gandan.day05.demo02;

/*
    子父类的异常:
        如果父类抛出了多个异常,子类重写父类方法时,抛出和父类相同异常或者是父类异常的子类或者不抛出异常
        父类方法没有抛出异常,子类重写父类方法时也不可抛出异常.此时子类产生该异常,只能捕获处理,不能声明抛出
    注意:
        父类异常是什么样,子类异常就是什么样
 */
public class Father {
    public void father01() throws NullPointerException,ClassCastException{}
    public void father02() throws IndexOutOfBoundsException{}
    public void father03() throws IndexOutOfBoundsException{}
    public void father04() {}
}

class Son extends Father{
    // 子类重写父类方法时,抛出和父类相同异常
    public void father01() throws NullPointerException,ClassCastException{}
    // 子类重写父类方法时,抛出父类异常的子类
    public void father02() throws ArrayIndexOutOfBoundsException{}
    // 子类重写父类方法时,不抛出异常
    public void father03() {}

    /*
    父类方法没有抛出异常,子类重写父类方法时也不可抛出异常.
    此时子类产生该异常,只能捕获处理,不能声明抛出
     */
//    public void father04() throws Exception{}

    // 此时子类产生该异常,只能捕获处理,不能声明抛出
    public void father04(){
        try {
            throw new Exception("编译器异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
