package com.java.io.BlockingIODemo;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 95
 * @Date: 2020/6/4
 */
public class IOClient {

    public static void main(String[] args) {

        new Thread(() -> {

            try {

                Socket socket = new Socket("127.0.0",3333);

                while(true){
                    try {
                        socket.getOutputStream().write((new Date()+" hello ======= ").getBytes());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }).start();
    }
}
