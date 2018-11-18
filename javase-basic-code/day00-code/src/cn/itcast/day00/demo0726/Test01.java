package cn.itcast.day00.demo0726;

/*
(1)定义抽象类Person,抽象方法eat
(2)定义接口speak,属性language(String 类型),初始值"中文",
默认方法speakM,打印language,格式"母语:"+language值
抽象方法speak,参数String language
(3)定义Man类继承Person类,重写eat方法,打印"大口吃",实现接口speak,重写speak方法,打印"第二语言:"+方法参数的值
(4)定义Woman类继承Person类,重写eat方法,打印"细嚼慢咽",实现接口speak,重写speak方法,打印"第二语言:"+方法参数的值
(5)定义测试类,创建Man对象和Woman对象,定义方法test,方法需要Person类型参数,,String类型参数language,根据传递的实际参数的类型,
调用相应的eat方法及speak方法
(6)在测试类中进行测试

 */
public class Test01 {
    public static void main(String[] args) {
        test(new Man(),"日语");
        test(new Woman(),"英语");
    }

    public static void test(Person person,String language){
        person.eat();
        if(person instanceof Man){
            Man man = (Man) person;
            man.speakM();
            man.speak(language);
        }else if(person instanceof Woman){
            Woman woman = (Woman) person;
            woman.speakM();
            woman.speak(language);
        }
    }
}
