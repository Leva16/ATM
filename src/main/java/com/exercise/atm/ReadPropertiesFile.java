package com.exercise.atm;

import org.apache.commons.io.IOUtils;
import java.io.*;
import java.util.*;

class ReadPropertiesFile implements PropertiesFile {

    private static final String CONFIG = "config.properties";
    Properties properties = new Properties();

    @Override
    public Map getPropValues() throws IOException{
        InputStream inputStream = null;
        Map<Integer, Integer> sortProp = new TreeMap<>();
        try {
            inputStream = new FileInputStream(CONFIG);
            properties.load(inputStream);
            Enumeration enuKeys = properties.keys();
            while (enuKeys.hasMoreElements()) {
                String key = String.valueOf(enuKeys.nextElement());
                String value = properties.getProperty(key);
                sortProp.put(Integer.valueOf(key), Integer.valueOf(value));
            }
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

//        } catch (IOException e) {
//            System.err.println("Config file not found.");
//        } finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    System.err.println("InputStream is null");
//                }
//            }
//        }
        return sortProp;
    }
    @Override
    public void setPropValues(final Map<Integer, Integer> setProp) throws IOException{
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(CONFIG);
            for (Map.Entry<Integer, Integer> entry : setProp.entrySet()) {
                properties.setProperty(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }
            properties.store(outputStream, null);
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
//        } catch (FileNotFoundException e) {
//            System.err.println("Config file not found.");
//        } catch (IOException e) {
//            System.err.println("Can`t store config file");
//        } finally {
//            if (outputStream != null) {
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    System.err.println("Can`t close config file");
//                }
//            }
//        }
    }
}
