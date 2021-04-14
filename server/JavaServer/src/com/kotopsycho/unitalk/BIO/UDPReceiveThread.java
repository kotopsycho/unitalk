package com.kotopsycho.unitalk.BIO;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @package com.kotopsycho.unitalk.BIO
 * @Author kirain
 * @create 2021/4/13 21:09
 */
public class UDPReceiveThread extends Thread{

    private static final int maxReceiveLength = 256;

    private static final DatagramSocket socket = getSocket();

    //todo 通过配置文件决定绑定的端口,最大长度等
    private static DatagramSocket getSocket(){
        return null;
    }


    //todo 实现udp包的接收和加入队列
    @Override
    public void run() {
        DatagramQueue queue = DatagramQueue.getDatagramQueue();
        for(;;){
            byte[] bytes = new byte[maxReceiveLength];
            DatagramPacket p = new DatagramPacket(bytes, bytes.length);
            try {
                socket.receive(p);
                queue.offer(p.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
