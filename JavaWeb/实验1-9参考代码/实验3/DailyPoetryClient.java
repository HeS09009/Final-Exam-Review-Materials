package mypackage;

import java.io.*;
import java.net.*;

public class DailyPoetryClient {
    public void go() {
        try {
            Socket s = new Socket("127.0.0.1", 5000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));//【代码一】
            String poetry = reader.readLine();
            System.out.println("Today's Poetry: " + poetry);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DailyPoetryClient client = new DailyPoetryClient();
        client.go();
    }
}
