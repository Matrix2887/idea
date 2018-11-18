package cn.gandan.day15.download;

import cn.gandan.day15.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
@WebServlet("/downLoadServlet")
public class downLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求头参数,文件名称
        String filename = request.getParameter("filename");

        // 使用字节输入流加载文件进入内存

        // 找到文件的服务器路径,响应所有用户的数据
        ServletContext servletContext = this.getServletContext();// ?
        // 拼接字符串,代表文件的路径,获取文件在服务器的路径
        String realPath = servletContext.getRealPath("/img/" + filename);// ?
        // 获取字节输入流读取数据,并且关联
        FileInputStream fis = new FileInputStream(realPath);

        // 设置response的响应头

        // 设置响应头类型:content-type
        String mimeType = servletContext.getMimeType(filename);
        // 告知响应体数据格式以及编码格式
        response.setHeader("content-type",mimeType);


        String agent = request.getHeader("user-agent");
        //2.使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName(agent, filename);

        // 设置响应头打开方式:content-disposition
        // 以附件形式打开响应体,就是下载弹框,并设置下载文件的名字
        response.setHeader("content-disposition","attachment;filename=" + filename);

        // 将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        // 定义一个数组用来提高数据的传输效率
        byte[] bytes = new byte[1024 * 8];
        // 定义一个数据,用来记录当前一行有多少有效数据
        int len;
        while ((len =fis.read(bytes)) != -1){
            sos.write(bytes,0,len);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
