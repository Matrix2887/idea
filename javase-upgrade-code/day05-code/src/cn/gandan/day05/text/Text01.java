package cn.gandan.day05.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
	键盘录入3个学生对象放到集合中。 name  age  gender

	name ： 长度一定是3 ~ 13之间，如果不在这个范围那么继续录

	age ：  一定要在 10 ~ 100 之间。

	gender ： 男 女  nan  nv  NAN  NV

	因为数据是键盘录入的，你不能保证用户录的是什么。比如age 用户也有可能录abc，那么此时如何处理。
 */
public class Text01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        ArrayList<Student> students = new ArrayList<>(List.of(s1,s2,s3));
        int count = 0;
        while(true) {
            System.out.println("第" + (count + 1) + "个学生");
//            System.out.println("姓名");
//            String name = sc.next();
//            System.out.println("年龄");
//            String age = sc.next();
//            System.out.println("性别");
//            String gander = sc.next();

//        try {
//            protect(name,age,gander);
//        } catch (NameOutOfBoundsException e) {
//            e.printStackTrace();
//        } catch (AgeOutOfBoundsException e) {
//            e.printStackTrace();
//        }
            while(true){
            try {
                System.out.println("第" + (count + 1) + "个学生姓名");
                String name = sc.nextLine();
                protectName(name);
                students.get(count).setName(name);
            } catch (NameOutOfBoundsException e) {
                e.printStackTrace();
                continue;
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }
            break;
            }

            while(true) {
                try {
                    System.out.println("第" + (count + 1) + "个学生年龄");
                    String age = sc.nextLine();
                    int i = protectAge(age);
                    students.get(count).setAge(i);
                    // 写多个catch目的是不同的异常,用不同的处理方式
                } catch (AgeOutOfBoundsException e) {
                    e.printStackTrace();
                    continue;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    continue;
                }catch (Exception e){
                    e.printStackTrace();
                    continue;
                }
                break;
            }
            while(true) {
                try {
                    System.out.println("第" + (count + 1) + "个学生性别");
                    String gander = sc.nextLine();
                    protectGander(gander);
                    students.get(count).setGander(gander);
                } catch (GanderOutOfBoundsException e) {
                    e.printStackTrace();
                    continue;
                }catch (Exception e){
                    e.printStackTrace();
                    continue;
                }
                break;
            }
//            students.get(count).setName(name);
//            students.get(count).setAge(age);
//            students.get(count).setGander(gander);
            count++;
            if(count == students.size()){
                break;
            }
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }
//    public static void protect(String name,int age,String gander) throws NameOutOfBoundsException, AgeOutOfBoundsException {
//        if (name.length() < 3 || name.length() > 13) {
//            throw new NameOutOfBoundsException("姓名长度不符合");
//        }
//        if(age<10 || age>100){
//            throw new AgeOutOfBoundsException("年龄不符合");
//        }
//
//    }

    public static void protectName(String name) throws NameOutOfBoundsException{
        if (name.length() < 3 || name.length() > 13) {
            throw new NameOutOfBoundsException("长度不符合");
        }
    }
    public static int protectAge(String age) throws AgeOutOfBoundsException {
//        char[] chars = age.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//        if(!(chars[i] <= '9' && chars[i] >= '0')){
        try {
            int i = Integer.parseInt(age);
            if(i<10 || i>100){
                throw new AgeOutOfBoundsException("年龄不符合");
            }else {
                return i;
            }
        } catch (NumberFormatException e) {
        throw new NumberFormatException("输入字符不能包含除数字以外的字符");
        }
    }
    public static void protectGander(String gander) throws GanderOutOfBoundsException {
        ArrayList<String> list = new ArrayList<>(List.of("男", "女", "nan", "nv", "NAN", "NV"));
        if(!(list.contains(gander))){
            throw new GanderOutOfBoundsException("性别不符合");
        }
    }
}