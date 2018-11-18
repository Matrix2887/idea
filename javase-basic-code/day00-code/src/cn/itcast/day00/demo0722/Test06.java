package cn.itcast.day00.demo0722;

import java.lang.reflect.Array;

/*
一、需求说明：创建三个图书类对象，找出价格最高的图书并打印该图书的所有信息。
二、设计“图书类”Book，要求有以下属性：
	图书编号：
	书名：
	价格：
 */
public class Test06 {
    public static void main(String[] args) {
        Book[] book = new Book[3];
        Book one = new Book(01,"哈利波特",20);
        Book two = new Book(02,"波西杰克逊",45);
        Book three = new Book(03,"尼古拉斯赵四",30);
        Book temp = new Book();
        book[0] = one;
        book[1] = two;
        book[2] = three;
        temp = one;
        for (int i = 1; i < book.length - 1; i++) {
            if(book[i].getPrice() > temp.getPrice()){
                temp = book[i];
            }
        }
        temp.show(temp.getId(),temp.getName(),temp.getPrice());
    }
}
