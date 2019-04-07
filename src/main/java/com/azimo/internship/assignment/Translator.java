package com.azimo.internship.assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


class Translator {

    private HashMap<String, String> polEngMap = new HashMap<>();
    private HashMap<String, String> engGerMap = new HashMap<>();
    private HashMap<String, String> polGerMap = new HashMap<>();

    //Method to convert data from resource files to hashMaps.
    private void fileToMap(String dictionaryPath, HashMap hashMap) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(dictionaryPath));
        String fileLine;

        while ((fileLine = reader.readLine()) != null) {
            String[] splitLine = fileLine.split(";", 2);    //Strings have to be split into maximum 2 new Strings.
            if (splitLine.length == 2) {
                String key = splitLine[0];
                String value = splitLine[1];
                hashMap.put(key, value);
            }
        }
        reader.close();
    }


    //This method returns english translation of a polish expression.
     String polish2English(String polish2EnglishDictionaryPath, String polishExpression) throws IOException {
        String translation = "";

        fileToMap(polish2EnglishDictionaryPath, polEngMap);

        for(String key : polEngMap.keySet()){   //Iterating through polEng HashMap.
            if(key.equals(polishExpression)){
                translation = polEngMap.get(key);   //Translation of the polish word will be the value of the key found in the polEng HashMap.
            }
        }
        if(translation.isEmpty()) System.out.println("No such word in resources file.");

        return translation;
    }


    //This method returns german translation of a polish expression.
    String polishToGerman(String polish2EnglishDictionaryPath, String english2GermanDictionaryPath, String polishExpression) throws IOException{
        String translation = "";

        fileToMap(polish2EnglishDictionaryPath, polEngMap);
        fileToMap(english2GermanDictionaryPath, engGerMap);

        //Simple algorithm that iterates through both polEng and engGer HashMaps. It compares values of english words in both HashMaps.
        for(String i : polEngMap.keySet()){
            for(String j : engGerMap.keySet()){
                if(polEngMap.get(i).equals(j) && i.equals(polishExpression))    //If a value(english expression) of polEng will equal key(english expression) in engGer and key(polish expression) of polEng will equal polish expression inserted into method,
                    translation = engGerMap.get(j);                             //then translation(german expression) will be the value(german expression) of engGer HashMap.
            }
        }
        if(translation.isEmpty()) System.out.println("No such word in resources file.");

        return translation;

    }


    //This method creates a file POL2GER.txt in resources folder by combining POL2ENG.txt and ENG2GER.txt files.
    void generateGermanToPolishTranslationFile(String polish2EnglishDictionaryPath, String english2GermanDictionaryPath) throws IOException{

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/POL2GER.txt"));
        StringBuilder stringBuilder = new StringBuilder();

        fileToMap(polish2EnglishDictionaryPath, polEngMap);
        fileToMap(english2GermanDictionaryPath, engGerMap);

        //Similar algorithm to one used in polishToGerman() method.
        for(String i : polEngMap.keySet()){
            for(String j : engGerMap.keySet()){
                if(polEngMap.get(i).equals(j)){
                    polGerMap.put(i, engGerMap.get(j)); //Inserting key:value pairs into new HashMap polGer.
                }
            }
        }

        //Creating a string consisting of data from polGer HashMap.
        for(String key : polGerMap.keySet()){
            stringBuilder.append(key + ";" + polGerMap.get(key) + "\n");    //Using StringBuilder for merging key:values from HashMap.
        }

        writer.append(stringBuilder);
        writer.close();
    }
}