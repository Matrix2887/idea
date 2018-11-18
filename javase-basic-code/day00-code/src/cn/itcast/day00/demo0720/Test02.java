package cn.itcast.day00.demo0720;

/*
分析以下需求，并用代码实现：
	1.根据工龄(整数)给员工涨工资(整数),工龄和基本工资自定义
	2.涨工资的条件如下：
		[10-15)     +5000
		[5-10)      +2500
		[3~5)       +1000
		[1~3)       +500
		[0~1)       +200
	3.如果自定义的工龄为10，基本工资为3000，程序运行后打印格式
	"您目前工作了10年，基本工资为 3000元, 应涨工资 5000元,涨后工资 8000元"

	1.首先定义两个变量，一个用来存放工龄的workAge 一个用来存放基本工资的pay。并且给出条件，如果不符合条件就报错
	2.定义if...else if...else通过工龄的变量来对应出要加多少工资，并打印结果。
 */
public class Test02 {
    public static void main(String[] args) {
        int workAge = 10;
        int pay = 3000;
        if(workAge >= 10 && workAge < 15){
            pay = pay + 5000;
            System.out.println("您目前工作了"+workAge+"年，基本工资为3000元, 应涨工资 5000元,涨后工资"+pay+"元");
        }else if(workAge >=5 && workAge < 10){
            pay = pay + 2500;
            System.out.println("您目前工作了"+workAge+"年，基本工资为3000元, 应涨工资 2500元,涨后工资"+pay+"元");
        }else if(workAge >=3 && workAge < 5){
            pay = pay + 1000;
            System.out.println("您目前工作了"+workAge+"年，基本工资为3000元, 应涨工资 1000元,涨后工资"+pay+"元");
        }else if(workAge >=1 && workAge < 3){
            pay = pay + 500;
            System.out.println("您目前工作了"+workAge+"年，基本工资为3000元, 应涨工资 500元,涨后工资"+pay+"元");
        }else if(workAge >=0 && workAge < 1){
            pay = pay + 200;
            System.out.println("您目前工作了"+workAge+"年，基本工资为3000元, 应涨工资 200元,涨后工资"+pay+"元");
        }else{
            System.out.println("阁下何不同风起，扶摇直上九万里");
        }
    }
}
