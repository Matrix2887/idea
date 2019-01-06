package cn.gandan.sms;

import org.junit.Test;

public class MainClass {
    public static void main(String[] args) {
        int nDisks = 3;
        doTowers(nDisks, 'A', 'B', 'C');
    }

    public static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1){
            System.out.println("Disk 1 从 " + from + " 到 " + to);
        }else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk " + topN + " 从 " + from + " 到 " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }

    @Test
    public void math(){
        int[] ints = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < 6000; i++) {
            String s = Integer.toString(i, 5);
            Integer integer = Integer.valueOf(s);
            System.out.println(String.format("%05d", integer));
        }

    }

    @Test
    public void tryCatch(){
        System.out.println(count());
    }

    public static Student count(){
        Student student = new Student();
        try {
            student.setName("盛利");
            student.setAge(25);
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            student.setName("爆米花");
            student.setAge(18);
        }
        student.setName("胡图图");
        student.setAge(28);
        return student;
    }

    @Test
    public void resout(){
        num();
    }
    private static void num(){
        int i;
        try {
            System.out.println("try");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            i=2;
            System.out.println("finally");
        }
        System.out.println("void");
        return;
        }
}
