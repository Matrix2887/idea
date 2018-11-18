package cn.gandan.day01.demo01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
            // document有三种方法获得方式
        String path = Jsoup.class.getClassLoader().getResource("student.xml").getPath();
//              通过路径获取document对象
//        Document document = Jsoup.parse(new File(path), "utf-8");
//
//        System.out.println(document);
//              通过XML字符串的表示形式获取document对象
//        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
//                "<students>\n" +
//                "\t<student number=\"a\">\n" +
//                "\t\t<name>shengli</name>\n" +
//                "\t\t<age>16</age>\n" +
//                "\t\t<sex>little</sex>\n" +
//                "\t</student>\n" +
//                "\t<student number=\"b\">\n" +
//                "\t\t<name>baomihua</name>\n" +
//                "\t\t<age>16</age>\n" +
//                "\t\t<sex>little</sex>\n" +
//                "\t</student>\n" +
//                "\n" +
//                "\n" +
//                "</students>";
//
//        Document document = Jsoup.parse(str);
//
//        System.out.println(document);

        URL url = new URL("http://ntlias-stu.boxuegu.com/#/index");
//          通过URL获取document对象,并设置响应时间,超过这个响应时间就会报错
        Document document = Jsoup.parse(url,10000);

        System.out.println(document);
    }
}