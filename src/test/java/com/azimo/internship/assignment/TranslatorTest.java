package com.azimo.internship.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class TranslatorTest {

    //assertEquals tests are hard coded, because @ParametrizedTests didn't work as expected.
    @org.junit.Test
    public void polish2EnglishValidInput() throws IOException {
        Translator translator  = new Translator();
        String actual1 = translator.polish2English("src/test/resources/POL2ENG.txt","rower");
        String actual2 = translator.polish2English("src/test/resources/POL2ENG.txt","zielony");
        String actual3 = translator.polish2English("src/test/resources/POL2ENG.txt","dwa");
        String expected1 = "bike";
        String expected2 = "green";
        String expected3 = "two";

        assertEquals(actual1,expected1);
        assertEquals(actual2,expected2);
        assertEquals(actual3,expected3);
    }

    @org.junit.Test
    public void polish2EnglishStringNotInFile() throws IOException{
        Translator translator = new Translator();
        String actual1 = translator.polish2English("src/test/resources/POL2ENG.txt","");
        String actual2 = translator.polish2English("src/test/resources/POL2ENG.txt","komputer");
        String expected = "";

        assertEquals(actual1,expected);
        assertEquals(actual2,expected);
    }

    @org.junit.Test
    public void polish2EnglishNullInput() throws IOException{
        Translator translator = new Translator();
        String actual1 = translator.polish2English("src/test/resources/POL2ENG.txt",null);
        String expected = "";

        assertEquals(actual1,expected);
    }

    @org.junit.Test(expected = IOException.class)
    public void polish2EnglishWrongPath() throws IOException{
        Translator translator  = new Translator();
        translator.polish2English("ffffff","rower");
    }

//----------------------------------------------------------------------------------------------------------------------

    @org.junit.Test
    public void polish2GermanValidInput() throws IOException {
        Translator translator  = new Translator();
        String actual1 = translator.polishToGerman("src/test/resources/POL2ENG.txt","src/test/resources/ENG2GER.txt","szafka");
        String actual2 = translator.polishToGerman("src/test/resources/POL2ENG.txt","src/test/resources/ENG2GER.txt","woda");
        String actual3 = translator.polishToGerman("src/test/resources/POL2ENG.txt","src/test/resources/ENG2GER.txt","jablko");
        String expected1 = "schrank";
        String expected2 = "wasser";
        String expected3 = "apfel";

        assertEquals(actual1,expected1);
        assertEquals(actual2,expected2);
        assertEquals(actual3,expected3);
    }

    @org.junit.Test
    public void polish2GermanStringNotInFile() throws IOException{
        Translator translator = new Translator();
        String actual1 = translator.polishToGerman("src/test/resources/POL2ENG.txt","src/test/resources/ENG2GER.txt","");
        String actual2 = translator.polishToGerman("src/test/resources/POL2ENG.txt","src/test/resources/ENG2GER.txt","stolik");
        String expected = "";

        assertEquals(actual1,expected);
        assertEquals(actual2,expected);
    }

    @org.junit.Test
    public void polish2GermanNullInput() throws IOException{
        Translator translator = new Translator();
        String actual1 = translator.polishToGerman("src/test/resources/POL2ENG.txt","src/test/resources/ENG2GER.txt",null);
        String expected = "";

        assertEquals(actual1,expected);
    }

    @org.junit.Test(expected = IOException.class)
    public void polish2GermanWrongSecondPath() throws IOException{
        Translator translator  = new Translator();
        translator.polishToGerman("src/test/resources/POL2ENG.txt","fffffff","rower");
    }

    @org.junit.Test(expected = IOException.class)
    public void polish2GermanWrongFirstPath() throws IOException{
        Translator translator  = new Translator();
        translator.polishToGerman("fffffffff","src/test/resources/ENG2GER.txt","rower");
    }

    @org.junit.Test(expected = IOException.class)
    public void polish2GermanWrongPaths() throws IOException{
        Translator translator  = new Translator();
        translator.polishToGerman("abcdef","fffffff","rower");
    }

//----------------------------------------------------------------------------------------------------------------------

    @org.junit.Test(expected = IOException.class)
    public void generateGermanToPolishTranslationFileWrongFirstPath() throws IOException {
        Translator translator = new Translator();
        translator.generateGermanToPolishTranslationFile("gggggg", "src/test/resources/ENG2GER.txt");
    }

    @org.junit.Test(expected = IOException.class)
    public void generateGermanToPolishTranslationFileWrongSecondPath() throws IOException {
        Translator translator = new Translator();
        translator.generateGermanToPolishTranslationFile("src/test/resources/POL2ENG.txt", "lllllllll");
    }

    @org.junit.Test(expected = IOException.class)
    public void generateGermanToPolishTranslationFileWrongPaths() throws IOException {
        Translator translator = new Translator();
        translator.generateGermanToPolishTranslationFile("oooooo", "rrrrrrrr");
    }

    @org.junit.Test
    public void generateGermanToPolishTranslationFileDataCheck() throws IOException {
        Translator translator = new Translator();
        translator.generateGermanToPolishTranslationFile("src/test/resources/POL2ENG.txt", "src/test/resources/ENG2GER.txt");

        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/POL2GER.txt"));
        ArrayList<String> readData = new ArrayList<>();
        String[] validArray = {"szafka;schrank", "jablko;apfel", "zielony;grun","drzwi;tur","las deszczowy;regenwald","trzy;drei","dokument;dokumentieren","sol;salz","kawa;kaffee","zupa;suppe","dywan;teppich","lampa;lampe","herbata;tee","lekarz;arzt","tabletka;tablette","kanapka;sandwich","gabinet;buro","woda;wasser","cytryna;zitrone","czerwony;rot","butelka;flasche","fioletowy;violett","zaslona;vorhang","dwa;zwei","paszport;reisepass","jeden;ein","pieprz;pfeffer","olowek;bleistift","kolor;farbe","rower;fahrrad"};
        ArrayList<String> validData = new ArrayList<>(Arrays.asList(validArray));
        String fileLine;

        while ((fileLine = reader.readLine()) != null) {
            readData.add(fileLine);
        }
        reader.close();

        Collections.sort(validData);
        Collections.sort(readData);

        assertTrue(validData.equals(readData));
    }
}