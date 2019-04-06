package com.azimo.internship.assignment;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Translator translator = new Translator();
        //System.out.println(translator.polish2English("/Users/radek/Downloads/hellokoding-courses-master/springboot-examples/TranslatorProject/src/main/resources/POL2ENG.txt", ""));
        //System.out.println(translator.polishToGerman("/Users/radek/Downloads/hellokoding-courses-master/springboot-examples/TranslatorProject/src/main/resources/POL2ENG.txt", "/Users/radek/Downloads/hellokoding-courses-master/springboot-examples/TranslatorProject/src/main/resources/ENG2GER.txt", "rower"));
        translator.generateGermanToPolishTranslationFile("/Users/radek/Downloads/hellokoding-courses-master/springboot-examples/TranslatorProject/src/main/resources/POL2ENG.txt", "/Users/radek/Downloads/hellokoding-courses-master/springboot-examples/TranslatorProject/src/main/resources/ENG2GER.txt");
    }
}
