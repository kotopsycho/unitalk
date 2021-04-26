package com.kotopsycho.unitalk.sql;

import org.apache.logging.log4j.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @version 1.0
 * @package com.kotopsycho.unitalk.sql
 * @Author kirain
 * @create 2021/4/26 16:08
 * @description 数据库连接池
 */
public class SqlConnectionPool {

    private final static Logger sqlLogger = LogManager.getLogger("sql");

    private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private final String dbUrl = "jdbc:mysql://localhost:3306/unitalk";
    private final String username = "root";
    private final String password = "TQCfgT1X4";

    private final static int coreConnect = 5;
    private final static int maxConnect = 10;
    private final static int increaseConnect = 5;

    private final static ConcurrentLinkedQueue<Connection> connections = new ConcurrentLinkedQueue<>();

    private final static SqlConnectionPool sqlConnectPool = new SqlConnectionPool();

    //单例模式管理池化对象
    private SqlConnectionPool(){

        try {
            for(int i = 0;i < coreConnect; i++){
                connections.offer(DriverManager.getConnection(this.dbUrl, this.username, this.password));
            }
        } catch (SQLException e) {
            sqlLogger.error("get database connect error");
            sqlLogger.error(e.toString());
        }
    }

    public Connection getConnection(){
        return connections.poll();
    }

    public void releaseConnection(Connection con){
        connections.offer(con);
    }





}
