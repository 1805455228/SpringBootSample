package com.ryze.netty.nio;

import io.netty.channel.ServerChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by xueLai on 2019/7/23.
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        // 创建一个选择器来处理Channel
        Selector selector = Selector.open();
        // 打开套接字通道
        SocketChannel channel = SocketChannel.open();
        // 设置此通道为非阻塞模式
        channel.configureBlocking(false);
        // 绑定端口
        channel.bind(new InetSocketAddress("127.0.0.1", 9090));
        channel.register(selector, SelectionKey.OP_CONNECT);

        while (true) {
            //阻塞方法
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {

                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isConnectable()) {
                    SocketChannel sc = (SocketChannel)key.channel();
                    channel.finishConnect();
                    System.out.println("客户端连接服务器成功!");
                    

                } else if (key.isReadable()) {

                }
            }
        }
    }
}
