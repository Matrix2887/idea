package cn.itcast.day05.test;

public class Test03 {
    public static void main(String[] args) {
        int[] score = {80,90,85,90,78,88,89,93,98,75,10,50,59,40};
        int failPeople = fail(score);
        System.out.println("不及格人数为：" + failPeople);
        int sum = totalPoints(score);
        System.out.println("班级总分数：" + sum);
        double meanValue = meanValue(score);
        System.out.println("班级平均分：" + meanValue);
    }
    public static int fail(int[] score){
        int count = 0;
        for (int i = 0 ; i < score.length; i++) {
            if (score[i] < 60 && score[i] != 0){
                count++;
            }else if (score[i] == 0){
                continue;
            }
        }
        return count;
    }
    public static int totalPoints(int[] score){
        int sum1 = score[0];
        for (int i = 1; i < score.length; i++) {
            sum1 = sum1 + score[i];
        }
        return  sum1;
    }
    public static double meanValue(int[] score){
        double sum1 = score[0];
        double numOfPeople = score.length;
        for (int i = 1; i < score.length; i++) {
            sum1 = sum1 + score[i];
            if (score[i] == 0){
                numOfPeople--;
                continue;
            }
        }
        double meanValue = sum1 / numOfPeople;
        return meanValue;
    }
}
