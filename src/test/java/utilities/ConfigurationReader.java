package utilities;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

// Let's design the ConfigurationReader class in a way that it can be used from anywhere in our project
// without needing to create objects or inherit from it.
// static: a keyword used to allocate memory for variables immediately when the program starts, which helps in holding memory space.

    static Properties properties;
    static{
        String path = "src/test/resources/configuration.properties";
        try{
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        }catch (Exception e){
        }
    }

    public  static String getProperty(String key){
        return properties.getProperty(key);
    }
}