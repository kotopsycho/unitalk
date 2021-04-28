package com.kotopsycho.unitalk.system;

import com.kotopsycho.unitalk.struct.Channel;
import com.kotopsycho.unitalk.struct.User;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @package com.kotopsycho.unitalk.system
 * @Author kirain
 * @create 2021/4/16 0:36
 */
public class ChannelManager {

    private Channel rootChannel;                //根部频道
    private int channelCount;                   //频道个数
    private LinkedList<Channel> allChanel;      //所有频道列表
    private int onlineUser;                     //在线用户个数
    private LinkedList<User> userList;          //在线用户列表


    //todo 使用hashmap来管理用户与频道的映射关系
    //初始化大小为16
    private static final ConcurrentHashMap<User, Channel> userMap = new ConcurrentHashMap<>(16);

    //单例模式
    private final static ChannelManager channelManager = new ChannelManager();
    private ChannelManager(){}
    //获取实例
    public static ChannelManager getChannelManager(){
        return ChannelManager.channelManager;
    }

}
