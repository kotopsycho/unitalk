package com.kotopsycho.unitalk.system;

/**
 * @package com.kotopsycho.unitalk.system
 * @Author kirain
 * @create 2021/4/16 0:36
 */
public class ChannelManager {

    private ChannelManager(){}

    //todo 使用hashmap来管理用户与频道的映射关系
    private final static ChannelManager channelManager = new ChannelManager();

    public ChannelManager getChannelManager(){
        return ChannelManager.channelManager;
    }




}
