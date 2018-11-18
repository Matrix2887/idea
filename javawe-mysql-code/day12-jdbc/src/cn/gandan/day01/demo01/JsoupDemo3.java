package cn.gandan.day01.demo01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path),"utf-8");

        /*
        getElementById​(String id)：根据id属性值获取唯一的element对象
		getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
		getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
		getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
         */

            // 获取有student标签的元素
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);
        System.out.println("====================================");
            // 获取有id属性的元素
        Elements id = document.getElementsByAttribute("id");
        System.out.println(id);
        System.out.println("====================================");
            // 获取有number属性的元素并且这个元素的值为a
        Elements a = document.getElementsByAttributeValue("number", "a");
        System.out.println(a);
        System.out.println("====================================");
            // 获取id属性值为baomihua的元素
        Element baomihua = document.getElementById("baomihua");
        System.out.println(baomihua);

    }
}