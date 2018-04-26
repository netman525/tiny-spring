package com.zzjr.example.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Description:
 *
 * @author <a href="mailto:maoling@zuozh.com">maoling</a>
 * @date Create on 2018/4/26
 * @since version1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
public class TimeServerHandler implements Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(), true);
            String currentTime = null;
            String body = null;
            while (true) {
                body = in.readLine();
                if (null == body) {
                    break;
                }
                System.out.println("the time server receive order :" + body);
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)
                              ? new Date(System.currentTimeMillis()).toString()
                              : "BAD ORDER";
                out.println(currentTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                out.close();
                out = null;
            }
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
