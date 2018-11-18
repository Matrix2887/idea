package cn.gandan.day01.demo01;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsoupDemo6 {
    public static void main(String[] args) throws IOException ,XpathSyntaxErrorException{
        String path = JsoupDemo6.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path),"utf-8");

        JXDocument jxDocument = new JXDocument(document);
        // 询所有student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }

        System.out.println("============================");
        // 查询所有student标签下的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }

        System.out.println("============================");
        // 查询student标签下带有id属性的name标签
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }

        System.out.println("============================");
        // 查询student标签下带有id属性的name标签 并且id属性值为shengli
        List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id='shengli']");
        for (JXNode jxNode : jxNodes4) {
            System.out.println(jxNode);
        }

    }
}
