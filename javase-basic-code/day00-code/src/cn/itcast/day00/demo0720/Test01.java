package cn.itcast.day00.demo0720;

/*
定义一个int类型变量接收一个大于100的三位数,求出100到该数字之间满足如下要求的数字之和:
		1.数字的个位数不为7;
		2.数字的十位数不为5;
		3.数字的百位数不为3;

		1.首先定义一个变量num
		2.在定义一个变量sum用来求和
		3.判断这个是否大于100且小于等于999，如果不符合就报错
		4.在来个从100开始的循环，一直到这个数，遍历一次
		5.循环里的变量模出个位要不等于7，且模出十位不等于5，且模出百位不等于3
		6.将所有符合条件的数字相加在之前定义的变量
 */
public class Test01 {
    public static void main(String[] args) {
        int num = 235;
        int sum = 0;
        if(num < 100 || num > 999){
            System.out.println("此数以与东风起，扶摇直上九万里");
        }else{  for (int i = 100; i <= num; i++) {
            if(i % 10 != 7 && i / 10 % 10 != 5 && i / 100 % 10 != 3){
                sum += i;
            }
        }
            System.out.println("和为:" + sum);
        }
    }
}
