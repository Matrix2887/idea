package cn.gandan.day01.demo01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo4.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path),"utf-8");
        /*
        getElementById​(String id)：根据id属性值获取唯一的element对象
		getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
		getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
		getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
		String attr(String key)：根据属性名称获取属性值
		String text():获取文本内容
		String html():获取标签体的所有内容(包括字标签的字符串内容)
         */

            // 获取有name标签的元素,返回一个数组
        Elements name = document.getElementsByTag("name");
        System.out.println(name.size());

        System.out.println("==============");
            // 获取有student标签的元素,并返回该数组的第一个元素
        Element student = document.getElementsByTag("student").get(0);

            // 一下是Elements里的方法
            // 获取该元素的name标签的元素们
        Elements na = student.getElementsByTag("name");
        System.out.println(na.size());

        System.out.println("==============");
            // 获带有该属性的值,这里student是document.getElementsByTag("student").get(0)
        String number = student.attr("number");
        System.out.println(number);

        System.out.println("==============");
            // 获取纯文本
        String text = na.text();
            // 获取标签以及文本,获取所有
        String html = na.html();
        System.out.println(text);
        System.out.println("===============");
        System.out.println(html);

    }
}
