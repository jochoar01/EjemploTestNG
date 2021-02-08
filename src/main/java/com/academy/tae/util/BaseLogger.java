package com.academy.tae.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * BaseLogger is the implementation, a basic one, of the Log4j2 dependency.
 * The file that holds the configuration is located at: src/main/resources/log4j2.xml
 * It currently logs information to both, console and .log files, the files are currently being stored
 * at: logs/
 * @author juanpablo.vasquez
 */
public class BaseLogger {
    /**
     * The static instantiation of the Logger
     */
    private static final Logger logger = LogManager.getLogger(BaseLogger.class);

    /**
     * Way to reach the log instantiation and use it along the project.
     * @return
     */
    public static Logger getLogger() {
        return logger;
    }
}
