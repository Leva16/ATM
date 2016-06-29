package com.exercise.atm;

import java.io.*;
import java.util.*;

public class ReadPropertiesFile {
    Properties properties = new Properties();

    public Map getPropValues() throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        properties.load(inputStream);
        inputStream.close();
        Map<Integer, Integer> sortProp = new TreeMap<Integer, Integer>();
        Enumeration enuKeys = properties.keys();
        while (enuKeys.hasMoreElements()) {
            String key = (String) enuKeys.nextElement();
            String value = properties.getProperty(key);
            sortProp.put(Integer.valueOf(key), Integer.valueOf(value));
        }
        return sortProp;
    }
}
