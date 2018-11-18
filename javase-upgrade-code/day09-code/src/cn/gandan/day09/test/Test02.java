package cn.gandan.day09.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
    1.项目根目录下建立两个文件夹：src和dest
	2.找一张图片放入src文件夹中
	3.将图片复制到dest文件夹中
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\视频\\石原里美.Mp4");
        FileOutputStream fos = new FileOutputStream("D:\\视频\\十元.Mp4");
        int len;
        byte[] bytes = new byte[1024];
        while((len = fis.read(bytes)) != -1){
            System.out.println(Arrays.toString(bytes));
            fos.write(bytes,0,len);
        }
        fos.close();
        fis.close();
    }
}
