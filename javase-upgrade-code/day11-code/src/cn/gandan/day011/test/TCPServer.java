package cn.gandan.day011.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 1.创建一个服务器ServerSocket对象,和系统要指定的端口号
        2.使用ServerSocket对象中的方法accept,获取到请求的客户端Socket对象
        3.使用Socket对象中的方法getInputStream,获取到网络字节输入流InputStream对象
        4.判断d:\\upload文件夹是否存在,不存在则创建
        5.创建一个本地字节输出流FileOutputStream对象,构造方法中绑定要输出的目的地
        6.使用网络字节输入流InputStream对象中的方法read,读取客户端上传的文件
        7.使用本地字节输出流FileOutputStream对象中的方法write,把读取到的文件保存到服务器的硬盘上
        8.使用Socket对象中的方法getOutputStream,获取到网络字节输出流OutputStream对象
        9.使用网络字节输出流OutputStream对象中的方法write,给客户端回写"上传成功"
        10.释放资源(FileOutputStream,Socket,ServerSocket)
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("day11-code\\upload\\0824.rar");
        ServerSocket server = new ServerSocket(6666);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        int len;
        byte[] bytes = new byte[1024];
        while((len = is.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        OutputStream os = socket.getOutputStream();
        os.write("传输成功".getBytes());
        fos.close();
        socket.close();
        server.close();
    }
}
