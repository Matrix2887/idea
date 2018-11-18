package cn.gandan.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class Person {

    private String name;
    private int age;
    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    public Person() {
    }

    public Person(String name, int age, String gender, Date date) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", date=" + date +
                '}';
    }
}
