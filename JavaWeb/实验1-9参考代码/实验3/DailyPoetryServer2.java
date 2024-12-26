package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyPoetryServer2 {
    String[] poetrys = {"太阳颂", "生如夏花", "飞鸟集", "园丁集", "吉檀迦利", "闲暇"};

    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            while (true) {
                Socket sock = serverSocket.accept();
                Thread t = new Thread(new MyThread(sock));
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class MyThread implements Runnable {
        Socket sock;

        public MyThread(Socket sock) {
            this.sock = sock;
        }

        @Override
        public void run() {
            try {
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String poetry = getPoetry(); //获取诗歌名
                writer.println(poetry);
                writer.close();
                System.out.println(poetry);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //随机返回诗歌名
    private String getPoetry() {
        int random = (int) (Math.random() * poetrys.length);
        return poetrys[random];
    }

    public static void main(String[] args) {
        DailyPoetryServer2 server = new DailyPoetryServer2();
        server.go();
    }
}

