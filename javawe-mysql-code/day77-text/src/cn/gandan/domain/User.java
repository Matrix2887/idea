package cn.gandan.domain;

public class User {
    private int id;
    private String name;
    private String password;
    private int age;
    private String hobby;
    private String address;

    public User() {
    }

    public User(int id, String name, String password, int age, String hobby, String address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.hobby = hobby;
        this.address = address;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
