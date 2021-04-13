package com.kotopsycho.unitalk.BIO;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @package com.kotopsycho.unitalk.BIO
 * @Author kirain
 * @create 2021/4/13 21:09
 */
public class UDPReceiveThread extends Thread{

    int port;

    public UDPReceiveThread(int port){
        this.port = port;
    }

    //todo 实现udp包的接收和加入队列
    @Override
    public void run() {
        DatagramQueue queue = DatagramQueue.getDatagramQueue();
        for(;;){

        }
    }

}
