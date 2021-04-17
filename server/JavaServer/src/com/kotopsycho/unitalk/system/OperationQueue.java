package com.kotopsycho.unitalk.system;

/**
 * @package com.kotopsycho.unitalk.system
 * @Author kirain
 * @create 2021/4/16 0:40
 */
public class OperationQueue {

    //以单例模式管理操作队列
    private OperationQueue(){}
    //单例对象
    private static OperationQueue singleQueue;
    //获取对象
    public static OperationQueue getInstance(){
        if(singleQueue == null){
            synchronized (DatagramQueue.class) {
                if (singleQueue == null){
                    singleQueue = new OperationQueue();
                }
            }
        }
        return singleQueue;
    }

    //操作队列
    //todo 使用ConcurrentLinkedQueue创建一个队列
    //private static ConcurrentLinkedQueue<>


}
