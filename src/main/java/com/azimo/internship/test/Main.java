package com.azimo.internship.test;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator();
        try {
            System.out.println(translator.polish2English("/Users/radek/Downloads/hellokoding-courses-master/springboot-examples/TranslatorProject/src/main/resources/POL2ENG.txt","rower"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
