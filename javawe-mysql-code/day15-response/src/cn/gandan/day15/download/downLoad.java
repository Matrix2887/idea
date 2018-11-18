package cn.gandan.day15.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/downLoadServlet0")
public class downLoad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");

        ServletContext sc = this.getServletContext();

        String realPath = sc.getRealPath("/img/" + filename);

        FileInputStream fis = new FileInputStream(realPath);

        String mimeType = sc.getMimeType(filename);

        response.setHeader("content-type",mimeType);
        response.setHeader("content-disposition","attachment;filename=" + filename);

        ServletOutputStream sos = response.getOutputStream();

        byte[] bytes = new byte[1024 * 7];
        int len;
        while((len=fis.read(bytes))!=-1){
            sos.write(bytes,0,len);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
