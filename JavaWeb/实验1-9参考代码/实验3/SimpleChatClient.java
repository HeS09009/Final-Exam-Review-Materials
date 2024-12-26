package mypackage;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleChatClient {

    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket socket;

    public static void main(String[] args) {
        new SimpleChatClient().go();
    }

    public void go() {
        JFrame frame = new JFrame("聊天客户端");
        JPanel mainPanel = new JPanel();
        JPanel panel = new JPanel();
        incoming = new JTextArea(15, 30);
        incoming.setLineWrap(true);//设置在行过长的时候是否要自动换行
        incoming.setWrapStyleWord(true);//设置在单词过长的时候是否要把长单词移到下一行。
        incoming.setEditable(false);
        JScrollPane qScrollPane = new JScrollPane(incoming);
        qScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("发送");
        //设置按钮的监听器
        sendButton.addActionListener(new SendButtonListener());

        panel.add(outgoing);
        panel.add(sendButton);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(qScrollPane);
        mainPanel.add(panel);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //窗体关闭，则退出应用程序
        frame.setResizable(false); //禁止改变窗体大小        
        frame.getRootPane().setDefaultButton(sendButton);//设置在窗口中按下回车键时，单击了sendButton
        frame.pack();
        frame.setVisible(true);

        setUpNetWoking();

        //创建一个线程，用于接收服务器的消息
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

    }

    private void setUpNetWoking() {
        try {
            socket = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("networking established");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent ev) {
            try {
                writer.println(outgoing.getText());
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();//设置焦点
        }
    }

    public class IncomingReader implements Runnable {

        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("read：" + message);
                    incoming.append(message + "\n");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
