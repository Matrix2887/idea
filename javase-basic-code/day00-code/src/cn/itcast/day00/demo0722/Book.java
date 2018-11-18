package cn.itcast.day00.demo0722;

public class Book {
    private int id;
    private String name;
    private  int price;

    public Book() {
    }

    public Book(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void show(int id,String name,int price){
        System.out.println("图书编号:" + getId());
        System.out.println("书名:" + getName());
        System.out.println("价格:" + getPrice());
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

