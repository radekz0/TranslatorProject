package com.azimo.internship.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class Translator {

    private HashMap<String, String> polEngMap = new HashMap<String, String>();

    private void fileToMap(String polish2EnglishDictionaryPath) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(polish2EnglishDictionaryPath));
        String fileLine;

        while ((fileLine = reader.readLine()) != null) {
            String[] splitLine = fileLine.split(";", 2);
            if (splitLine.length == 2) {
                String key = splitLine[0];
                String value = splitLine[1];
                polEngMap.put(key, value);
            }
        }
        reader.close();
    }


     String polish2English(String polish2EnglishDictionaryPath, String polishExpression) {
        try {
            fileToMap(polish2EnglishDictionaryPath);
        } catch (IOException e) {
            System.out.println("Wrong input " + e.getMessage());
        }

        String translation = "";

        for(String key : polEngMap.keySet()){
            if(key.equals(polishExpression)){
                translation = polEngMap.get(key);
            }
        }
        if(translation.isEmpty()) System.out.println("No such word in resources file.");

        return translation;
    }
}