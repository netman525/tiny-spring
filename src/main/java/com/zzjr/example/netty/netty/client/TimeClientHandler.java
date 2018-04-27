package com.zzjr.example.netty.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

/**
 * Description:
 *
 * @author <a href="mailto:maoling@zuozh.com">maoling</a>
 * @date Create on 2018/4/27
 * @since version1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
public class TimeClientHandler extends ChannelHandlerAdapter {

    private int counter;

    private byte[] req = null;


    private static final Logger logger = Logger.getLogger(TimeClientHandler.class.getName());

    public TimeClientHandler(){
        req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception{
        ByteBuf message = null;
        for(int i = 0; i< 100 ; i++){
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        ByteBuf buf = (ByteBuf) msg;
        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);
        String body = new String(bytes, "UTF-8");
        System.out.println("Now is :" + body + ", the counter is : " + ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception{
        logger.warning("Unexpected exception from downStread " + cause.getMessage());
        ctx.close();
    }
}
