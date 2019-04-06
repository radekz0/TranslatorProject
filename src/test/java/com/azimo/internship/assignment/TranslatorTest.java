package com.azimo.internship.assignment;

import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class TranslatorTest {

    private String polishExpression;
    private String expected;

    public TranslatorTest(String polishExpression, String expected){
        this.polishExpression = polishExpression;
        this.expected = expected;
    }

    @Parameterized.Parameters(name="{index}: polEng({0}) = {1}")
    public static Collection parameters(){
        return Arrays.asList(new Object[][]{
                {"kolor", "colour"},
                {"rower","bike"}
        });
    }

    @org.junit.Test
    public void polish2English() {
        Translator translator  = new Translator();
        String actual = translator.polish2English("POL2ENG.txt",polishExpression);

        assertEquals(expected,actual);
    }

    @org.junit.Test
    public void polishToGerman() {
    }

    @org.junit.Test
    public void generateGermanToPolishTranslationFile() {
    }

}