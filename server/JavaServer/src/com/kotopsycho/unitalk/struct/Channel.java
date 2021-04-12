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
    public volatile LinkedList<User> users;

    public Channel(String name, int ID){
        this.channelName = name;
        this.channelID = ID;
        this.users = new LinkedList<>();
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


}
