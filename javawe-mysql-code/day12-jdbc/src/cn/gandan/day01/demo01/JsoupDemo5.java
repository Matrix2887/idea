package cn.gandan.day01.demo01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo5.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path),"utf-8");

        // 根据标签name筛选
        Elements name = document.select("name");
        System.out.println(name);

        System.out.println("==========");
        // 根据id值为baomihua来筛选
        Elements select = document.select("#baomihua");
        System.out.println(select);

        System.out.println("==========");
        // 获取student标签并且number属性为a
        Elements student = document.select("student[number='a']");
        System.out.println(student);

        System.out.println("==========");
        // 获取student标签并且number属性为b的age
        Elements student1 = document.select("student[number='b'] > age");
        System.out.println(student1);


    }
}
