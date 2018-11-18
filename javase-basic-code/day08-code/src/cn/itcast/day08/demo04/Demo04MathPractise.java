package cn.itcast.day08.demo04;

/*
题目:
计算在-10.8到5.9之间,绝对值大于6或者小于2.1的整数有多少个
-10, -9, -8, -7, -2, -1, 0, 1, 2

分析:
1.既然已经确定了范围,for循环
2.起点位置-10.8应该转换成为-10,两种办法:
    2.1可以使用Math.ceil方法,向上(向正方向)取整
    2.2强转成为int,自动舍弃所有小数位
3.每一个数字都是整数,所以步进表达式应该是num++,这样每次都是+1的
4.如何拿到绝对值:Math.ads方法
5.一旦发现了一个数字,需要让计数器++进行统计

备注:如果使用Math.ceil方法,-10.8可以变成-10.0。注意double也是可以进行++的
 */
public class Demo04MathPractise {
    public static void main(String[] args) {
        double max = 5.9;
        double min = -10.8;
        double num;
        int count = 0;
        int c = 0;
        for (double i = Math.ceil(min) ; i <= Math.floor(max); i++) {
                num = Math.abs(i);
                if (num > 6.0 || num < 2.1){
                    if(num % 1.0 == 0){
                        count++;
                    }
                }
            }
        System.out.println("整数有:" + count + "个");
        for (int i = (int)min; i < (int)max; i++) {
            if (i > 6.0 || i < 2.1) {
                if (i % 1.0 == 0) {
                    c++;
                }
            }
        }
        System.out.println(c);
        for (double i = -9.1; i < 5.2; i++) {
            System.out.println(i);
        }
    }
}
