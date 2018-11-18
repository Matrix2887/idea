package cn.itcast.day00.demo0726;

/*
1.定义接口Study,要求如下:
(1)定义抽象方法void studyPlan(Plan p)
(2)定义默认方法void studyHard(),要求:方法内依次调用readBook(),doTest()
(3)定义私有方法  void readBook(),要求:输出”多读书,多看报,少吃零食多睡觉”
void doTest(),要求:输出”键盘敲烂,先赚他一个亿”
2.定义类Plan，包含空参、满参构造和以下成员变量
阅读 read（String类型）
做题 test（String类型）
        生成所有成员变量set/get方法
定义成员方法：void printPlan(),要求：输出打印"当次学习计划，阅读：xxx，练习：yyy",
PS： xxx为变量read值，yyy为变量test值
3.定义类Person，包含空参、满参构造和以下成员变量
        姓名 name（String类型）
年龄 age（int类型）
        生成所有成员变量set/get方法
定义成员方法：void startStudy (Study study)，要求：输出“xxx开始学习”，然后在方法内依次调用studyHard()，studyPlan(Plan p)
PS：xxx为变量name值，参数p需要自行创建并初始化变量read与 test
4.定义测试类，在main方法实现以下功能：
创建并初始化一个Person对象per，调用方法 startStudy (Study study)
参数：study为Study的实现类，需要实现studyPlan(Plan p)抽象方法，
实现要求：调用参数p的printPlan ()方法
示例如下：
张三开始锻炼
每天动一动,享受健康生活
记得要做热身运动哦
当此运动计划,热身:拉拉筋骨,锻炼:平板撑
 */
public class Plan {
    private String read;
    private String test;

    public Plan() {
    }

    public Plan(String read, String test) {
        this.read = read;
        this.test = test;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    public void printPlan(){
        System.out.println("当次学习计划，阅读:" + getRead() + "，练习:" + getTest());
    }
}
