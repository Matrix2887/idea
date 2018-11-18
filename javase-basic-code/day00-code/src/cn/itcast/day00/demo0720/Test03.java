package cn.itcast.day00.demo0720;

/*
分析以下需求，并用代码实现：
	1.功能描述：模拟计算器功能，对定义的int类型的数据进行加、减、乘、除的运算，并打印运算结果
	2.要求：
		(1)定义三个int类型变量接收三个数据,其中前两个整数代表参加运算的数据，
			第三个整数为要进行的运算(0:表示加法运算,1:表示减法运算,2:表示乘法运算,3:表示除法运算)
		(2)使用今天所学知识完成功能
		(3)演示格式如下:
			第一个整数:30
			第二个整数:40
			您要进行的运算(0:表示加法运算,1:表示减法运算,2:表示乘法运算,3:表示除法运算):0
			控制台输出:30+40=70

			1.定义三个变量，还能咋地。顺便在定义一个结果变量。
			2.因为有明确的选择，所以我推荐switch游戏机，是一款居家旅游必备之良品
			3.switch语句里分别定义0，1，2，3，default.分别用来表示加法、减法、乘法、除法、报错
			4.在除法的case中，加入一个条件，被除数不能为0
			5.打印输出
 */
public class Test03 {
    public static void main(String[] args) {
        int num1 = 20;
        int num2 = 10;
        int mark = 3;
        int result;
        switch(mark){
            case 0:
            result = num1 + num2;
                System.out.println(num1 + "+" + num2 + "=" + result);
                break;
            case 1:
                result = num1 - num2;
                System.out.println(num1 + "-" + num2 + "=" + result);
                break;
            case 2:
                result = num1 * num2;
                System.out.println(num1 + "*" + num2 + "=" + result);
                break;
            case 3:
                if(num2 == 0){
                    System.out.println("被除数不能为0");
                }else{
                    result = num1 / num2;
                    System.out.println(num1 + "/" + num2 + "=" + result);
                }
                break;
        }
    }
}
