package com.kotopsycho.unitalk.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @version 1.0
 * @package com.kotopsycho.unitalk.sql
 * @Author kirain
 * @create 2021/4/26 18:48
 * @description 初始化数据库结构
 */
public class InitDatabase {

    //todo 完成sql脚本的编写

    //建立用户表
    private final static String usersTable = "create table student(" +
            " id int," +
            " name varchar(20)," +
            " gender varchar(10)," +
            " birthday date" +
            " );";

    //建立频道表
    private final static String channelTable = "";

    //


    //初始化
    private static boolean createUsersTable(Connection con) throws SQLException {
        if(con == null) return false;
        PreparedStatement pst = con.prepareStatement(usersTable);
        return pst.execute();
    }



}
