package com.zc.io.nio.channel;

/**
 * Created by zengc on 2017/11/2.
 *
 * @author zengchao
 * 通道关闭
 *  调用通道的close( )方法时，可能会导致在通道关闭底层I/O服务的过程中线程暂时阻塞 ,哪怕
    该通道处于非阻塞模式。通道关闭时的阻塞行为（如果有的话）是高度取决于操作系统或者文件系
    统的。在一个通道上多次调用close( )方法是没有坏处的，但是如果第一个线程在close( )方法中阻
    塞，那么在它完成关闭通道之前，任何其他调用close( )方法都会阻塞。后续在该已关闭的通道上调
    用close( )不会产生任何操作，只会立即返回。
  通道开放
    可以通过 isOpen( )方法来测试通道的开放状态。如果返回 true 值，那么该通道可以使用。如
    果返回 false 值，那么该通道已关闭，不能再被使用。尝试进行任何需要通道处于开放状态作为
    前提的操作，如读、写等都会导致 ClosedChannelException 异常
 */
public class ChannelDemo3 {
    public static void main(String[] args) {

    }
}
