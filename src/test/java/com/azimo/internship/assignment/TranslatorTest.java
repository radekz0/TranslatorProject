package com.azimo.internship.assignment;

import java.io.IOException;

import static org.junit.Assert.*;

public class TranslatorTest {

    @org.junit.Test
    public void polish2EnglishValidInput() throws IOException {
        Translator translator  = new Translator();
        String actual1 = translator.polish2English("src/main/resources/POL2ENG.txt","rower");
        String actual2 = translator.polish2English("src/main/resources/POL2ENG.txt","zielony");
        String actual3 = translator.polish2English("src/main/resources/POL2ENG.txt","dwa");
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
        String actual1 = translator.polish2English("src/main/resources/POL2ENG.txt","");
        String actual2 = translator.polish2English("src/main/resources/POL2ENG.txt","komputer");
        String expected = "";

        assertEquals(actual1,expected);
        assertEquals(actual2,expected);
    }

    @org.junit.Test
    public void polish2EnglishNullInput() throws IOException{
        Translator translator = new Translator();
        String actual1 = translator.polish2English("src/main/resources/POL2ENG.txt",null);
        String expected = "";

        assertEquals(actual1,expected);
    }

    @org.junit.Test(expected = IOException.class)
    public void polish2EnglishWrongPath() throws IOException{
        Translator translator  = new Translator();
        translator.polish2English("ffffff","rower");
    }

//--------
    @org.junit.Test
    public void generateGermanToPolishTranslationFile() {
    }
}