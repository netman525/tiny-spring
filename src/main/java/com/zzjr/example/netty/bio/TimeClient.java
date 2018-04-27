package com.zzjr.example.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Description:
 *
 * @author <a href="mailto:maoling@zuozh.com">maoling</a>
 * @date Create on 2018/4/26
 * @since version1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
public class TimeClient {

    public static void main(String[] args){
        int port = 8080;
        if(null != args && args.length > 0){
            try{
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
            Socket socket = null;
            BufferedReader in = null;
            PrintWriter out = null;
            try{
                socket = new Socket("127.0.0.1",port);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out =  new PrintWriter(socket.getOutputStream(),true);
                out.println("QUERY TIME ORDER");
                System.out.println("Send order 2 server successed.");
                String response = in.readLine();
                System.out.println("Now is : " + response);
            }catch (Exception e){

            }finally{
                if(null != out){
                    out.close();
                    out = null;
                }
                if(null != in){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    in = null;
                }
                if(null != socket){
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
}
