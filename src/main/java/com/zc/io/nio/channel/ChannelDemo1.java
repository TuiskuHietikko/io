package com.zc.io.nio.channel;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;

/**
 * Created by zengc on 2017/11/2.
 *
 * @author zengchao
 */
public class ChannelDemo1 {
    /**
     * Channel接口主要有两个接口 :
     *      isOpen() 表示Channel 是否打开
     *      close() Closes this channel.
     *
     * InterruptibleChannel 接口 主要标记接口是否可以中断
     * ReadableByteChannel 接口 主要标记接口是否可读
     * WritableByteChannel 接口 主要标记接口是否可写
     * I/O 主要分为 File I/O 和 Stream I/O
     *
     * Channel 主要分为
     *  FileChannel :
     *
     *
     *  SocketChannel
     *  ServerSocketChannel
     *  DataGramChannel
     *
     */

    public static void main(String[] args) throws IOException {
        //创建方式一
        RandomAccessFile randomAccessFile =new RandomAccessFile("","r");
        FileChannel fileChannel = randomAccessFile.getChannel();
        //创建方式二
        FileInputStream fileInputStream=new FileInputStream("");
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();
        //创建方式三
        FileOutputStream fileOutputStream=new FileOutputStream("");
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();

        //创建方式1
        SocketChannel socketChannel=SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",80));
        //创建方式2
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(80));

        //创建方式1
        DatagramChannel datagramChannel=DatagramChannel.open();

        //创建方式1


    }
}
