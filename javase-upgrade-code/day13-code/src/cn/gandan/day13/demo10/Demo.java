package cn.gandan.day13.demo10;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        printName("盛利",(name)->{
            return new Person(name);
        });
        printName("盛利",Person::new);

    }

    public static void printName(String name,PersonBuilder pb){
        Person person = pb.builderPerson(name);
        System.out.println(person);
    }
}
