package cn.gandan.day05.demo03;

import java.util.Date;

public class Seeded {
    private Integer id;
    private String name;
    private Integer age;
    private String orz;
    private String seed;
    private Date date;

    public Seeded() {
    }

    public Seeded(Integer id, String name, Integer age, String orz, String seed, Date date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.orz = orz;
        this.seed = seed;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getOrz() {
        return orz;
    }

    public void setOrz(String orz) {
        this.orz = orz;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Seeded{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", orz='" + orz + '\'' +
                ", seed='" + seed + '\'' +
                ", date=" + date +
                '}';
    }
}
