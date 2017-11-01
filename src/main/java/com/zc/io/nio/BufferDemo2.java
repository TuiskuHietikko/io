package com.zc.io.nio;

import java.nio.ByteBuffer;

/**
 * 直接缓冲区和非直接缓冲区
 * Created by zengc on 2017/10/26.
 */
public class BufferDemo2 {
    public static void main(String[] args) {
        creatone();
        /**
         * 非直接缓冲区：通过 allocate() 方法分配缓冲区，将缓冲区建立在 JVM 的内存中
         直接缓冲区：通过 allocateDirect() 方法分配直接缓冲区，将缓冲区建立在物理内存中。可以提高效率
         字节缓冲区要么是直接的，要么是非直接的。如果为直接字节缓冲区，则 Java 虚拟机会尽最大努力直接在机 此缓冲区上执行本机 I/O 操作。也就是说，在每次调用基础操作系统的一个本机 I/O 操作之前（或之后），
         虚拟机都会尽量避免将缓冲区的内容复制到中间缓冲区中（或从中间缓冲区中复制内容）。
         直接字节缓冲区可以通过调用此类的 allocateDirect() 工厂方法 来创建。此方法返回的 缓冲区进行分配和取消分配所需成本通常高于非直接缓冲区 。直接缓冲区的内容可以驻留在常规的垃圾回收堆之外，因此，它们对应用程序的内存需求量造成的影响可能并不明显。所以，建议将直接缓冲区主要分配给那些易受基础系统的本机 I/O 操作影响的大型、持久的缓冲区。一般情况下，最好仅在直接缓冲区能在程序性能方面带来明显好处时分配它们。
         直接字节缓冲区还可以过 通过FileChannel 的 map() 方法 将文件区域直接映射到内存中来创建 。该方法返回MappedByteBuffer 。Java 平台的实现有助于通过 JNI 从本机代码创建直接字节缓冲区。如果以上这些缓冲区中的某个缓冲区实例指的是不可访问的内存区域，则试图访问该区域不会更改该缓冲区的内容，并且将会在访问期间或稍后的某个时间导致抛出不确定的异常。
         字节缓冲区是直接缓冲区还是非直接缓冲区可通过调用其 isDirect() 方法来确定。提供此方法是为了能够在性能关键型代码中执行显式缓冲区管理。
         *
         */
    }

    public static void creatone(){
        ByteBuffer buffer1=ByteBuffer.allocate(10);
        System.out.println("allocate()创建:"+buffer1.isDirect());
        ByteBuffer buffer2=ByteBuffer.wrap(new byte[10]);
        System.out.println("wrap()创建:"+buffer2.isDirect());
        ByteBuffer buffer3=ByteBuffer.allocateDirect(10);
        System.out.println("allocateDirect()创建:"+buffer3.isDirect());
    }

}
