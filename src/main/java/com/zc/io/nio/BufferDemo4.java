package com.zc.io.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

/**
 * Created by zengc on 2017/11/1.
 *  视图缓冲区
 * @author zengchao
 *
 */
public class BufferDemo4 {
    public static void main(String[] args) {
        BufferDemo4.methodOne();
    }

    public static void methodOne(){
        ByteBuffer byteBuffer=ByteBuffer.allocate(7);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.put (0, (byte)0);
        byteBuffer.put (1, (byte)'H');
        byteBuffer.put (2, (byte)0);
        byteBuffer.put (3, (byte)'i');
        byteBuffer.put (4, (byte)0);
        byteBuffer.put (5, (byte)'!');
        byteBuffer.put (6, (byte)0);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        printBuffer(byteBuffer);
        printBuffer(charBuffer);
        /**
         *
         * 可以通过ByteBuffer 的asCharBuffer或者其他asXXBuffer,将ByteBuffer转化成其他类型的Buffer
         */

    }

    /**
     * 打印buffer信息
     * @param buffer
     */
    public static void printBuffer(Buffer buffer){
        System.out.println ("pos=" + buffer.position( )
                + ", limit=" + buffer.limit( )
                + ", capacity=" + buffer.capacity( )
                + ": '" + buffer.toString( ) + "'");
    }

}
