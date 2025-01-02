package it.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
    private List<String> sensitiveWords = new ArrayList<>();
    @Override
    public void init() throws ServletException {
        sensitiveWords.add("山寨");
        sensitiveWords.add("盗版");
        sensitiveWords.add("水货");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //【代码一】获取评论内容（注意：post请求体中的数据的中文处理）
        request.setCharacterEncoding("utf-8");
        String comment = request.getParameter("comment");

        String originalComment = comment; //保存原评论

        for (String sensitiveWord : sensitiveWords) {
            //对所有敏感词汇进行过滤
            if (comment.contains(sensitiveWord)){
                //替换敏感词汇
                comment = comment.replace(sensitiveWord, "**");
            }
        }

       if (/*【代码二】*/originalComment.equals(comment)){
            //没有敏感词，设置tag为good guy
            request.setAttribute("tag","good guy：");
        }else {
            //有敏感词，设置tag为bad guy
            request.setAttribute("tag","bad guy：");
        }
       //【代码三】将comment保存到request中
        request.setAttribute("comment",comment);
        //【代码四】跳转到comment.jsp页面（请求转发？还是重定向？）
       request.getRequestDispatcher("/comment.jsp").forward(request,response);
     }
}
