package com.kotopsycho.unitalk.sql;

import com.kotopsycho.unitalk.struct.Channel;

import java.sql.Connection;

/**
 * @version 1.0
 * @package com.kotopsycho.unitalk.sql
 * @Author kirain
 * @create 2021/4/26 16:04
 * @description 完成数据库操作
 */
public class SqlCommand {

    //todo 完成所有的sql脚本编写


    //获取所有频道
    public static Channel[] getAllChannel(Connection connection){
        return new Channel[1];
    }

    public boolean addChannel(int channelID){
        return true;
    }


}
