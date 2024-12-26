package it.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 40;
        //创建验证码图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //美化图片
        //1.填充背景色
        Graphics g = image.getGraphics();
        g.setColor(Color.blue);
        g.fillRect(0, 0, width, height);
        //2.画边框
        g.setColor(Color.cyan);
        g.drawRect(0, 0, width - 1, height - 1);
        //3.写验证码
        //验证码的字符
        String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        //生成随机字符串
        Random ran = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);//随机字符
            sb.append(ch);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 16));
            g.drawString(ch + "", width / 5 * i, height / 2);
        }
        String checkCode_session = sb.toString();

        //【代码1】将验证码存入session，属性名为checkCode_session
       HttpSession session =  req.getSession();
       session.setAttribute("checkCode_session",checkCode_session);

        //4.画干扰线
        g.setColor(Color.green);
        //随机生成坐标点
        for (int i = 1; i <= 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);

            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }

        //将图片输出到页面展示
        ImageIO.write(image, "jpg", resp.getOutputStream()/*【代码2】*/);

    }
}
