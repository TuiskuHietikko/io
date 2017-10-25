package com.zc.io.nio;

import java.nio.ByteBuffer;

/**
 * Created by zengc on 2017/10/23.
 */
public class BufferDemo {
    public static void main(String[] args) {
        byteBufferDemo();
    }

    public static void byteBufferDemo(){
        ByteBuffer buffer=ByteBuffer.allocate(8);
        System.out.println("初始化:"+buffer.mark());
        buffer.put((byte) 'h');
        System.out.println("放入'h':"+buffer.mark());
        buffer.put((byte) 'e');
        System.out.println("放入'e':"+buffer.mark());
        buffer.put((byte) 'l').put((byte) 'l').put((byte) 'o');
        System.out.println("放入'llo':"+buffer.mark());
        //修改 h
        buffer.put(0, (byte) 'z');
        System.out.println(buffer.mark());
        buffer.put((byte) 'v');
        System.out.println("数据写完:"+buffer.mark());

        //flip()
//        buffer.flip();
//        System.out.println("执行完flip():"+buffer.mark());
        //执行完flip(),[pos=6 lim=8 cap=8]->[pos=0 lim=6 cap=8]
        /**
         * 总结:flip()会把 pos的值赋给lim，然后pos设置为0
         */

        //rewind()
//        buffer.rewind();
//        System.out.println("执行完rewind():"+buffer.mark());
        //执行完rewind(),[pos=6 lim=8 cap=8]->[pos=0 lim=8 cap=8]
        /**
         *
         * 总结： rewind() 会把pos 置为0
         */

//        buffer.hasRemaining();
//        buffer.flip();
//        //buffer.rewind();
//        while (buffer.hasRemaining()){
//            byte b = buffer.get();
//            System.out.println(b);
//            System.out.println(buffer.remaining());
//        }
        /**
         * hasRemaining()返回是否到达lim位置,
         * 如果上面执行的是flip(),pos->0,lim->6,只能读取6个数据
         * 如果是rewind(),pos->0,lim->8,可以读取8个数据
         */

        buffer.clear();
        System.out.println("执行clear():"+buffer.mark());
        /**
         * 总结：clear()会把设置回原始状态
         */
    }

}
