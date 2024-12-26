package mypackage;

import java.net.*;
import java.io.*;

public class DailyPoetryServer {
    String[] poetrys = {"太阳颂", "生如夏花", "飞鸟集", "园丁集", "吉檀迦利", "闲暇"};
    /*【代码二】数组的内容包括："太阳颂"、"生如夏花"、 "飞鸟集"、 "园丁集"、
    "吉檀迦利"、 "闲暇"以及【学生本人的姓名】*/
    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(5000)/*【代码三】*/;
            Socket sock = serverSocket.accept();//【代码四】
            PrintWriter writer = new PrintWriter(sock.getOutputStream());
            String poetry = getPoetry(); //获取诗歌名
            writer.println(poetry);
            writer.close();//【代码五】
            System.out.println(poetry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //随机返回诗歌名
    private String getPoetry() {
        int random = (int) (Math.random() * poetrys.length);
        return  poetrys[random]/*【代码六】*/;
    }

    public static void main(String[] args) {
        DailyPoetryServer server = new DailyPoetryServer();
        server.go();
    }
}

