package com.azimo.internship.assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

class Translator {

    private HashMap<String, String> polEngMap = new HashMap<String, String>();
    private HashMap<String, String> engGerMap = new HashMap<String, String>();
    private HashMap<String, String> polGerMap = new HashMap<String, String>();

    private void fileToMap(String dictionaryPath, HashMap hashMap) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(dictionaryPath));
        String fileLine;

        while ((fileLine = reader.readLine()) != null) {
            String[] splitLine = fileLine.split(";", 2);
            if (splitLine.length == 2) {
                String key = splitLine[0];
                String value = splitLine[1];
                hashMap.put(key, value);
            }
        }
        reader.close();
    }


     String polish2English(String polish2EnglishDictionaryPath, String polishExpression) throws IOException {
        String translation = "";

        fileToMap(polish2EnglishDictionaryPath, polEngMap);

        for(String key : polEngMap.keySet()){
            if(key.equals(polishExpression)){
                translation = polEngMap.get(key);
            }
        }
        if(translation.isEmpty()) System.out.println("No such word in resources file.");

        return translation;
    }


    String polishToGerman(String polish2EnglishDictionaryPath, String english2GermanDictionaryPath, String polishExpression) throws IOException{
        //String engTranslation = "";
        String translation = "";

        fileToMap(polish2EnglishDictionaryPath, polEngMap);
        fileToMap(english2GermanDictionaryPath, engGerMap);


        for(String i : polEngMap.keySet()){
            for(String j : engGerMap.keySet()){
                if(polEngMap.get(i).equals(j) && i.equals(polishExpression))
                    translation = engGerMap.get(j);
            }
        }
        if(translation.isEmpty()) System.out.println("No such word in resources file.");

        return translation;

    }


    void generateGermanToPolishTranslationFile(String polish2EnglishDictionaryPath, String english2GermanDictionaryPath) throws IOException{

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/POL2GER.txt"));
        StringBuilder stringBuilder = new StringBuilder();

        fileToMap(polish2EnglishDictionaryPath, polEngMap);
        fileToMap(english2GermanDictionaryPath, engGerMap);

        for(String i : polEngMap.keySet()){
            for(String j : engGerMap.keySet()){
                if(polEngMap.get(i).equals(j)){
                    polGerMap.put(i, engGerMap.get(j));
                }
            }
        }

        for(String key : polGerMap.keySet()){
            stringBuilder.append(key + ";" + polGerMap.get(key) + "\n");
        }

        writer.append(stringBuilder);
        writer.close();
    }
}