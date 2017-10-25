package com.zc.io.nio;

import java.nio.ByteBuffer;

/**
 * Created by zengc on 2017/10/23.
 */
public class BufferDemo {
    public static void main(String[] args) {
        //byteBufferDemo();
        //byteBufferDemo_compact();
        //byteBufferDemo_reset();
        moveData();
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

    public static void byteBufferDemo_compact(){
        ByteBuffer buffer=ByteBuffer.allocate(10);
        System.out.println("初始化:"+buffer.mark());
        buffer.put(new String("hello").getBytes());
        System.out.println("放入元素:"+buffer.mark());
        buffer.flip();
        System.out.println("执行flip():"+buffer.mark());
        buffer.get();
        System.out.println("取出一个元素:"+buffer.mark());
        buffer.get();
        System.out.println("再次取出一个元素:"+buffer.mark());
        buffer.compact();
        System.out.println("执行compact:"+buffer.mark());
        /**
         * 总结:
         * 在使用compact后,会压缩空间
         * 例如读取完一部分数据后,可能你需要再次完buffer中写入元素,就可以使用这个方法
         */
    }

    public static void byteBufferDemo_reset(){
        ByteBuffer buffer=ByteBuffer.allocate(10);
        buffer.put(new String("hello").getBytes());
        buffer.flip();
        System.out.println("执行完mark():"+buffer.mark());
        buffer.get();
        buffer.get();
        System.out.println("执行完reset():"+buffer.reset());
        /**
         * 总结:mark在使用时会记录当前的值
         * 当读取完两个元素之后,使用reset 他会把pos和lim置到上一次mark的位置,
         * 如果之前未定义,使用reset会出错
         * 使用clear(),rewind(),flip()会抛弃之前的标记
         */
    }

    /**
     * 批量移动
     */
    public static void moveData(){
        /**
         * 当buffer中的数组小于数组的长度时
         * 可以会把数组填充满
         */
//        ByteBuffer buffer=ByteBuffer.allocate(10);
//        buffer.put(new String("abcdefg").getBytes());
//        System.out.println(buffer);
//        byte[] bytes=new byte[2];
//        buffer.flip();
//        buffer.get(bytes);
        /**
         *  当数组的长度大于缓存区数据的长度,使用read()会抛出异常BufferUnderflowException
         *  所以当数组的长度要大于缓存区中数据的长度时,需要制定读取数据的位置
         */
        ByteBuffer buffer=ByteBuffer.allocate(10);
        buffer.put(new String("abcdefg").getBytes());
        buffer.flip();
        byte[] bytes=new byte[20];
//        buffer.get(bytes);//会抛异常
        int starIndex=buffer.position();
        int endIndex=buffer.remaining();
        buffer.get(bytes,starIndex,endIndex);

    }

}
