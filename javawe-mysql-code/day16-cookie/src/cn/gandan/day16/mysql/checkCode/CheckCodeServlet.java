package cn.gandan.day16.mysql.checkCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCode")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int width = 100;
        int height = 30;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);


        //2.1填充背景色
        Graphics g = image.getGraphics();
        g.setColor(Color.pink);
        g.fillRect(0,0,width,height);

        g.setColor(Color.blue);
        g.drawRect(0,0,width-1,height-1);

        String str = "我爱盛利胜利爆米花";

        Random ran = new Random();
        StringBuilder sb = new StringBuilder();
        g.setColor(Color.black);
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);
            sb.append(ch);
            g.drawString("" + ch,width/5*i,height/2);
        }
        String checkCode = sb.toString();
        request.getSession().setAttribute("checkCode",checkCode);

//        g.drawString("爱",40,25);
//        g.drawString("盛",60,25);
//        g.drawString("利",80,25);

        g.setColor(Color.black);
        for (int i = 0; i < 2; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int x3 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            int y3 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
            g.drawLine(x2,y2,x3,y3);
            g.drawLine(x3,y3,x1,y1);
        }






        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
