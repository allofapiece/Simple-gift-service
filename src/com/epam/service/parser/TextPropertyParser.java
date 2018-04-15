package com.epam.service.parser;

import java.io.*;
import java.util.HashMap;

public class TextPropertyParser implements PropertyParserInterface {

    @Override
    public HashMap<String, String> parse(String filePath) {
        HashMap<String, String> properties = new HashMap<>();

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
            String line;
            String property;
            String value;
            while((line = bufferedReader.readLine()) != null){
                line = line.trim();
                property = line.substring(0, line.indexOf("="));
                value = line.substring(line.indexOf("=")+1, line.length());

                properties.put(property, value);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

        return properties;
    }
}
