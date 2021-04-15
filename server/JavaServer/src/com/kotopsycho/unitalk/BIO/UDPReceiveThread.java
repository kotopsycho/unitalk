package com.kotopsycho.unitalk.BIO;

import com.kotopsycho.unitalk.LoadProperties;

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
    //fixme 设定一个对应的长度
    private static final int maxReceiveLength = 256;

    private static final DatagramSocket socket = getSocket();

    //todo 通过配置文件决定绑定的端口,最大长度等
    private static DatagramSocket getSocket(){
        try {
            return new DatagramSocket(LoadProperties.getPort());
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("get socket error, please check port number...");
        }
        return null;
    }

    @Override
    public void run() {
        DatagramQueue queue = DatagramQueue.getInstance();
        while(!this.isInterrupted()){
            byte[] bytes = new byte[maxReceiveLength];
            DatagramPacket p = new DatagramPacket(bytes, bytes.length);
            try {
                socket.receive(p);
                queue.offer(p.getData());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("socket receive error, try to stop this thread: " + this.toString());
                this.interrupt();
            }
        }
    }

}
