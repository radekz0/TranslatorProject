package com.azimo.internship.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Translator {

    private HashMap<String, String> polEngMap = new HashMap<String, String>();


    public String polish2English(String polish2EnglishDictionaryPath, String polishExpression) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(polish2EnglishDictionaryPath));
        String fileLine;
        String translation = "";

        while ((fileLine = reader.readLine()) != null) {
            String[] splitLine = fileLine.split(";", 2);
            if (splitLine.length == 2) {
                String key = splitLine[0];
                String value = splitLine[1];
                polEngMap.put(key, value);
            }
        }
        reader.close();

        for(String key : polEngMap.keySet()){
            if(key.equals(polishExpression)){
                translation = polEngMap.get(key);
            }
        }
        if(translation.isEmpty()) System.out.println("No such word in resources file.");

        return translation;
    }
}