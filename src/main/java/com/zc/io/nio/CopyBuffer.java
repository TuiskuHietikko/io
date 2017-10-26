package com.zc.io.nio;

import java.nio.CharBuffer;

/**
 * Created by zengc on 2017/10/26.
 */
public class CopyBuffer {
    public static void main(String[] args) {
        //duplicateDemo();
        //asReadOnlyDemo();
        slicenDemo();
    }
    public static void duplicateDemo(){
        /**
         * Duplicate()函数创建了一个与原始缓冲区相似的新缓冲区。两个缓冲区共享数据元
         素，拥有同样的容量，但每个缓冲区拥有各自的位置，上界和标记属性。对一个缓冲区内的数
         据元素所做的改变会反映在另外一个缓冲区上
         */
        CharBuffer buffer=CharBuffer.wrap(new String("hello,word!").toCharArray());
        buffer.get();
        CharBuffer duplicateBuffer = buffer.duplicate();
        System.out.println("buffer:"+buffer);
        System.out.println("buffer:"+duplicateBuffer);

        //读取buffer中的元素
        buffer.get();
        System.out.println(buffer);
        System.out.println(duplicateBuffer);
        duplicateBuffer.put(9,'X');
        System.out.println(buffer);
        System.out.println(duplicateBuffer);
        /**
         * 只会重新创建一个buffer对象,但是数据并不会拷贝,共用同一份数据
         */
    }

    /**
     * 创建一个只读的缓冲区,不能put(),否则抛出异常
     * ReadOnlyBufferException
     */
    public static void asReadOnlyDemo(){
        CharBuffer buffer=CharBuffer.allocate(10);
        CharBuffer buffer1 = buffer.asReadOnlyBuffer();
        System.out.println(buffer.isReadOnly());
        System.out.println(buffer1.isReadOnly());
        buffer1.put('X');
    }

    public static void slicenDemo(){
        CharBuffer buffer=CharBuffer.wrap(new String("abcdefg").toCharArray());
        buffer.get(new char[2]);
        System.out.println(buffer);
        CharBuffer sliceBuffer = buffer.slice();
        System.out.println(sliceBuffer);
        /**
         * 总结:创建一个从原始缓冲区的当前位置开始的新缓冲
         区，并且其容量是原始缓冲区的剩余元素数量（limit-position）
         */
    }

}
