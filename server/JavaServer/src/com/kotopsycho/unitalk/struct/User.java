package com.kotopsycho.unitalk.struct;

import java.net.InetSocketAddress;

/**
 * @package com.kotopsycho.unitalk.struct
 * @Author kirain
 * @create 2021/4/12 10:43
 */
public class User {
    private final int userID;
    private String userName;
    private String password;
    private InetSocketAddress userIpAddress;

    public User(int ID,String userName){
        this.userID = ID;
        this.userName = userName;
    }

}
