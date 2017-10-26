package com.zc.io.nio;

import java.nio.CharBuffer;

/**
 * Created by zengc on 2017/10/26.
 */
public class CreatBufferDemo {
    public static void main(String[] args) {
        createOne();
    }

    public static void createOne(){
        CharBuffer buffer1=CharBuffer.allocate(10);
        System.out.println("使用allocate()方式分配:"+buffer1.mark());

        char[] chars=new String("hello,world!").toCharArray();
        CharBuffer buffer2=CharBuffer.wrap(chars);
        System.out.println("使用wrap()包装操作创建1:"+buffer2.mark());
        chars[3]='X';
        System.out.println("修改初始化数组会修改缓冲区中的值:"+buffer2);
        System.out.println(buffer2.arrayOffset());

        char[] chars2=new String("hello,world!").toCharArray();
        //会创建一个长度为10的,limit为6,pos为1的缓冲区
        CharBuffer buffer3=CharBuffer.wrap(chars2,1,5);
        System.out.println("使用wrap()包装操作创建2:"+buffer3.mark());
        System.out.println(buffer2.arrayOffset());
    }
}
