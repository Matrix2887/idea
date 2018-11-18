package cn.gandan.day01.demo01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo1{
    public static void main(String[] args) throws IOException {
            // 通过类加载器,获取XML路径
        String path = Jsoup.class.getClassLoader().getResource("student.xml").getPath();
            // 使用Jsoup中的parse静态方法获得document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
            // document通过调用getElementsByTag获取有该属性的对象,返回的是一个数组
        Elements elements = document.getElementsByTag("name");
            // 打印数组的长度
        System.out.println(elements.size());
            // 获取该数组的第一个元素
        Element element = elements.get(0);
            // 用text方法,获取该元素的文本
        String name = element.text();

        System.out.println(name);

    }
}