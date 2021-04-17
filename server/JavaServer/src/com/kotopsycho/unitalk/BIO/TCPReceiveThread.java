package com.kotopsycho.unitalk.BIO;

import com.kotopsycho.unitalk.LoadProperties;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @package com.kotopsycho.unitalk.BIO
 * @Author kirain
 * @create 2021/4/17 15:48
 */
public class TCPReceiveThread extends Thread{
    //todo 实现对Tcp连接的监听与读取，将接收到的信息转为操作存储到操作队列里
    private static final ServerSocket socket = getSocket();

    private static ServerSocket getSocket(){
        try {
            return new ServerSocket(LoadProperties.getPort());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("get tcp socket error, please check port number...");
        }
        return null;
    }

    @Override
    public void run(){
        //todo 储存操作
    }
}
