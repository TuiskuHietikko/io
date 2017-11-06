package com.zc.io.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by zengc on 2017/11/2.
 *
 * @author zengchao
 * java   Scatter/Gather
 *  分散（scatter）从Channel中读取是指在读操作时将读取的数据写入多个buffer中。因此，Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。
    聚集（gather）写入Channel是指在写操作时将多个buffer的数据写入同一个Channel，因此，Channel 将多个Buffer中的数据“聚集（gather）”后发送到Channel。
 */
public class ChannelDemo4 {
    public static void main(String[] args) throws IOException {
        //gatherMehtod();
        scatterMethod();
    }

    /**
     * 聚集写
     * @throws IOException
     */
    public static void gatherMehtod() throws IOException {
        String headStr="head";
        ByteBuffer head = ByteBuffer.allocate(headStr.getBytes().length);
        head.put(headStr.getBytes());
        head.flip();
        String bodyStr="body";
        ByteBuffer body=ByteBuffer.allocate(bodyStr.getBytes().length);
        body.put(bodyStr.getBytes());
        body.flip();

        URL url = ChannelDemo4.class.getResource("/gather.txt");
        RandomAccessFile raf=new RandomAccessFile(url.getPath(),"rw");
        FileChannel channel = raf.getChannel();
        ByteBuffer[] byteBuffers={head,body};
        channel.write(byteBuffers);
        channel.close();
        raf.close();
    }

    /**
     * 分散读
     */
    public static void scatterMethod() throws IOException {
        URL url = ChannelDemo4.class.getResource("/gather.txt");
        RandomAccessFile raf=new RandomAccessFile(url.getPath(),"r");
        ByteBuffer head=ByteBuffer.allocate(4);
        ByteBuffer body=ByteBuffer.allocate(4);
        ByteBuffer[] byteBuffers={head,body};
        FileChannel channel = raf.getChannel();
        long read = channel.read(byteBuffers);
        System.out.println(read);
        head.flip();
        body.flip();
    }
}
