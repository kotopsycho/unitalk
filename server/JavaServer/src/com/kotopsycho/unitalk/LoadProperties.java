package com.kotopsycho.unitalk;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @package com.kotopsycho.unitalk
 * @Author kirain
 * @create 2021/4/15 14:11
 */
public class LoadProperties {

    private LoadProperties(){}

    private static final String filename = "config.properties";
    private static final String defaultPort = "port = 38888\n";

    public static int port;

    public static void load(){
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filename));
            Properties properties = new Properties();
            properties.load(in);

            port = Integer.parseInt(properties.getProperty("port"));


        } catch (FileNotFoundException e) {
            System.out.println("can't find config file, try to create default one...");
            init();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("can't load config file, try to use default value");
        }

    }

    private static void init(){

        File configFile = new File(filename);
        try {
            configFile.createNewFile();
            FileOutputStream w = new FileOutputStream(configFile);
            OutputStreamWriter writer = new OutputStreamWriter(w, StandardCharsets.UTF_8);

            writer.append(defaultPort);

            writer.close();
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("can't create a new default config file, try to use default value");
        }
    }

    public static int getPort() {
        return port;
    }
}
