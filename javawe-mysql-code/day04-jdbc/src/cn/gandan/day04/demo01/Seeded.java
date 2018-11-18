package cn.gandan.day04.demo01;

import java.util.Date;

public class Seeded {
    private int id;
    private String name;
    private String orz;
    private Date date;

    public Seeded() {
    }

    public Seeded(int id, String name, String orz,Date date) {
        this.id = id;
        this.name = name;
        this.orz = orz;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrz() {
        return orz;
    }

    public void setOrz(String orz) {
        this.orz = orz;
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
                ", orz='" + orz + '\'' +
                ", date=" + date +
                '}';
    }
}
