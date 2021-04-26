package com.kotopsycho.unitalk;

import org.apache.logging.log4j.*;

public class Main {

    private static final Logger logger = LogManager.getLogger("main");

    public static void main(String[] args){
	// write your code here
        logger.info("Try to load config...");
        LoadProperties.load();
        logger.info("Config load complete!");
        logger.info("Try to load mysql driver...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("Could not load driver!");
            e.printStackTrace();
            logger.error("Server is close...");
            return;
        }
        logger.info("Mysql Driver load complete.");

    }
}
