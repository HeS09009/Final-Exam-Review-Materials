package it.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/register") //【代码2】
public class RegisterServlet extends HttpServlet {
    //md5加密方法
    public static String stringToMD5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").
                    digest(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//【代码3】
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String userpass = req.getParameter("userpass");
        if ("lily".equals(username)) {
            resp.getWriter().println("用户名已存在，注册失败");
        }else {
            resp.getWriter().println(username+"欢迎加入，您的md5密码是："+stringToMD5(userpass));
        }
    }
}
