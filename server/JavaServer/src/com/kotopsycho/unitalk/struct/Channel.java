package com.kotopsycho.unitalk.struct;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @package com.kotopsycho.unitalk.struct
 * @Author kirain
 * @create 2021/4/12 10:17
 */
public class Channel {

    private final int channelID;
    private String channelName;
    private Boolean isEncrypted;
    private String password;
    private volatile LinkedList<User> users;
    private LinkedList<Channel> childChannels;

    public Channel(String name, int ID){
        this.channelName = name;
        this.channelID = ID;
        this.users = new LinkedList<>();
        childChannels = new LinkedList<>();
    }

    public void setName(String name){
        this.channelName = name;
    }

    public String getChannelName(){
        return channelName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSecret(){
        return isEncrypted;
    }

    public boolean judgePassword(String password){
        return this.password.equals(password);
    }

    public LinkedList<Channel> getChildChannels() {
        return childChannels;
    }

    public void addChildChannel(Channel channel){
        this.childChannels.add(channel);
    }

    public void addChildChannel(String name, int ID){
        this.childChannels.add(new Channel(name, ID));
    }

}
