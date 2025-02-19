package com.example.Employee.stepDefinitions;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.hamcrest.beans.PropertyUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UtilityClass {
    private static final Properties properties=new Properties();


    public static String getProperty(String key) throws IOException {
        FileInputStream inputStream=new FileInputStream("src/test/resources/application.properties");

        properties.load(inputStream);
        return  properties.getProperty(key);
    }


}
