package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    // This class will be responsible for loading properties files and will provide access to values based on key names

    // We use this Properties to load custom .properties files
    private static Properties configFile;

    static{
        try {
            //provide access to properties file
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");

            //initialize properties object
            configFile = new Properties();
            //load your properties
            configFile.load(fileInputStream);
            // close input stream
            fileInputStream.close();

        }   catch (IOException e){
            System.out.println("Failed to load properties file!!!");
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return configFile.getProperty(key);
    }
}
