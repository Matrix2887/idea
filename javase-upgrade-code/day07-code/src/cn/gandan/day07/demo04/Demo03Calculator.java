package cn.gandan.day07.demo04;

public class Demo03Calculator {
    public static void main(String[] args) {

        invokeCalc(100, 200, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        });
        invokeCalc(100,20,(int a,int b) ->{
            return a+b;
        });

        invokeCalc(10,200,(a,b) ->a+b);

        invokeCalc(200,40,(int c,int v)->{return c+v;});

        invokeCalc(30,50,(a,b)->a+b);
    }

    public static void invokeCalc(int a,int b,Calculator c){
        int sum = c.calc(a,b);
        System.out.println(sum);
    }
}
