package com.zzjr.example.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 *
 * @author <a href="mailto:maoling@zuozh.com">maoling</a>
 * @date Create on 2018/4/26
 * @since version1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
public class TimeServer {

    public static void main(String[] args){
        int port = 8080;
        if (null != args && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {

            }
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(port);
                System.out.println("the time server is start in port :" + port);
                Socket socket = null;
                while (true){
                    socket = serverSocket.accept();
                    new Thread(new TimeServerHandler(socket)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(null != serverSocket){
                    try {
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    serverSocket = null;
                }
            }

        }
    }
}
