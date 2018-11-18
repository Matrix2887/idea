package cn.gandan.day07.demo04;

import java.util.Arrays;
import java.util.Comparator;

public class Demo02Array {
    public static void main(String[] args) {
        Person[] arr = {
                new Person("11",33),
                new Person("22",22),
                new Person("33",11)

        };

//        Arrays.sort(arr, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });

//        Arrays.sort(arr,(Person o1,Person o2) -> {
//            return o1.getAge() - o2.getAge();
//        });

//        Arrays.sort(arr,(o1,o2) -> o2.getAge() - o1.getAge());

//        Arrays.sort(arr,(Person a,Person b) -> {return a.getAge() - b.getAge();});
        Arrays.sort(arr,(a,b)->a.getAge() - b.getAge());
        for (Person person : arr) {
            System.out.println(person);
        }
    }
}
