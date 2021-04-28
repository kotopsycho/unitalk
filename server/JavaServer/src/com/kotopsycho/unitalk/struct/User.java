package com.kotopsycho.unitalk.struct;

import java.net.InetSocketAddress;

/**
 * @package com.kotopsycho.unitalk.struct
 * @Author kirain
 * @create 2021/4/12 10:43
 */
public class User {
    private final String userID;
    private String userName;
    private String password;
    private InetSocketAddress userIpAddress;

    public User(String ID,String userName){
        this.userID = ID;
        this.userName = userName;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(!(obj instanceof User))
            return false;
        else
            return this.userID.equals(((User)obj).userID);
    }

    @Override
    public int hashCode() {
        return this.userID.hashCode();
    }
}
