package com.kotopsycho.unitalk.BIO;

import java.net.DatagramPacket;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author kirain
 * @create 2021/4/12 16:11
 */
public class DatagramQueue {

    //单例模式来管理udp包
    private static  DatagramQueue singleQueue;

    private static volatile ConcurrentLinkedQueue<DatagramPacket> datagramQueue;

    private DatagramQueue(){
        this.datagramQueue = new ConcurrentLinkedQueue<>();
    }

    public static DatagramQueue getDatagramQueue(){
        if(singleQueue == null){
            synchronized (DatagramQueue.class) {
                if (singleQueue == null){
                    singleQueue = new DatagramQueue();
                }
            }
        }
        return singleQueue;
    }

    public boolean offer(DatagramPacket datagramPacket){
        if(datagramPacket == null) return false;
        return datagramQueue.offer(datagramPacket);
    }

    public DatagramPacket poll(){
        return datagramQueue.poll();
    }

}
