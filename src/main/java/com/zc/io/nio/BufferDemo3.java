package com.zc.io.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * 字节序
 * Created by zengc on 2017/10/26.
 */
public class BufferDemo3 {
    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.wrap(new byte[4]);
        buffer.asIntBuffer().put(1024);
        System.out.println("字节序:"+buffer.order().toString());
        System.out.println(Arrays.toString(buffer.array()));

        buffer.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println("修改后字节序:"+buffer.order());
        buffer.asIntBuffer().put(1024);
        System.out.println(Arrays.toString(buffer.array()));
    }
}
