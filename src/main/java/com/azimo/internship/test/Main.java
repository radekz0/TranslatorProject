package com.azimo.internship.test;


import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator();
        //System.out.println(translator.polish2English("/Users/radek/Downloads/hellokoding-courses-master/springboot-examples/TranslatorProject/src/main/resources/POL2ENG.txt", "rower"));
        System.out.println(translator.polishToGerman("/Users/radek/Downloads/hellokoding-courses-master/springboot-examples/TranslatorProject/src/main/resources/POL2ENG.txt", "/Users/radek/Downloads/hellokoding-courses-master/springboot-examples/TranslatorProject/src/main/resources/ENG2GER.txt", "hjg"));
    }
}
