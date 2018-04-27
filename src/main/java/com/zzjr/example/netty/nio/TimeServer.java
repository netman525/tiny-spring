package com.zzjr.example.netty.nio;

import java.io.IOException;

/**
 * Description:
 *
 * @author <a href="mailto:maoling@zuozh.com">maoling</a>
 * @date Create on 2018/4/27
 * @since version1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
public class TimeServer {

    public static void main(String[] args) throws IOException{
        int port = 8080;
        if ( args != null &&args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
            MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
            new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
        }
    }
}
