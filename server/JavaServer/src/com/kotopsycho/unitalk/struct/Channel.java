package com.kotopsycho.unitalk.struct;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @package com.kotopsycho.unitalk.struct
 * @Author kirain
 * @create 2021/4/12 10:17
 */
public class Channel {

    private final int channelID;                    //频道标识id
    private String channelName;                     //频道名
    private Boolean isEncrypted;                    //是否加密的标志位
    private String password;                        //密码
    private volatile LinkedList<User> users;        //用户列表
    private LinkedList<Channel> childChannels;      //子频道列表


    public Channel(String name, int ID){
        this.channelName = name;
        this.channelID = ID;
        this.users = new LinkedList<>();
        childChannels = new LinkedList<>();
    }

    //设置频道名
    public void setName(String name){
        this.channelName = name;
    }
    //获取频道名
    public String getChannelName(){
        return channelName;
    }
    //设置密码
    public void setPassword(String password) {
        this.password = password;
    }
    //获取是否为加密频道
    public boolean isSecret(){
        return isEncrypted;
    }
    //判断密码
    public boolean judgePassword(String password){
        return this.password.equals(password);
    }
    //获取子频道
    public LinkedList<Channel> getChildChannels() {
        return childChannels;
    }
    //添加子频道
    public void addChildChannel(Channel channel){
        this.childChannels.add(channel);
    }
    public void addChildChannel(String name, int ID){
        this.childChannels.add(new Channel(name, ID));
    }

    //重写equals和hashcode
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(!(obj instanceof Channel))
            return false;
        else
            return this.channelID == ((Channel)obj).channelID;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.channelID);
    }
}
