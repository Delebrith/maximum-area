package config;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerConfig {

    public static final Logger LOGGER = Logger.getLogger("Logger");
    public static FileHandler fileHandler;

    public static void init(){
        try {
            fileHandler = new FileHandler("out/Log.log");
            LOGGER.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }
}

