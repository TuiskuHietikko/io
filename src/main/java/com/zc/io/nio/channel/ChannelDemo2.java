package com.zc.io.nio.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by zengc on 2017/11/2.
 *
 * @author zengchao
 * 通道copy
 */
public class ChannelDemo2 {
    public static void main(String[] args) throws IOException {
        ReadableByteChannel source= Channels.newChannel(System.in);
        WritableByteChannel target=Channels.newChannel(System.out);
        //channelCopy1(source,target);
        channelCopy2(source,target);
        source.close();
        target.close();
    }

    public static void channelCopy1(ReadableByteChannel source,WritableByteChannel target) throws IOException {

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (source.read(byteBuffer)!=-1){
            byteBuffer.flip();
            target.write(byteBuffer);
            byteBuffer.compact();
        }
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()){
            target.write(byteBuffer);
        }
    }

    public static void channelCopy2(ReadableByteChannel source,WritableByteChannel target) throws IOException {
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        while ((source.read(buffer))!=-1){
            buffer.flip();
            while (buffer.hasRemaining()){
                target.write(buffer);
            }
            buffer.clear();
        }
    }
}
