package com.napier.team4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PopulationReporterTest {

    static PopulationReporter populationReporter;

    @BeforeAll
    static void init(){
        populationReporter = new PopulationReporter();
    }

    @Test
    void displayPopulationByLanguageTestNullForParameter(){
        populationReporter.displayPopulationByLanguage(null, null);

    }

    @Test
    void displayPopulationByLanguageTestEmpty(){
        ArrayList<Language> languageArrayList = new ArrayList<>();
        populationReporter.displayPopulationByLanguage(languageArrayList, "Empty language by population List");
    }

    @Test
    void displayPopulationByLanguageTestContainNull(){
        ArrayList<Language> languageArrayList = new ArrayList<>();
        languageArrayList.add(null);
        populationReporter.displayPopulationByLanguage(languageArrayList, "Language list Contain Null Value");
    }

    @Test
    void displayPopulationByLanguage(){
        ArrayList<Language> languageArrayList = new ArrayList<>();
        Language language = new Language("Language", 1000, 50.00);
        languageArrayList.add(language);
        populationReporter.displayPopulationByLanguage(languageArrayList, "Display Population by Language");
    }


    @Test
    void displayPopulationInfoTestNullForParameter(){
        populationReporter.displayPopulationInfo(null, null);

    }

    @Test
    void displayPopulationInfoTestEmpty(){
        ArrayList<Population> populationArrayList = new ArrayList<>();
        populationReporter.displayPopulationInfo(populationArrayList, "Empty population List");
    }

    @Test
    void displayPopulationInfoTestContainNull(){
        ArrayList<Population> populationArrayList = new ArrayList<>();
        populationArrayList.add(null);
        populationReporter.displayPopulationInfo(populationArrayList, "Population list Contain Null Value");
    }

    @Test
    void displayPopulationInfo(){
        ArrayList<Population> populationArrayList = new ArrayList<>();
        Population population = new Population("Location Name", 10000, 5000, 5000, 50.00, 50.00);
        populationArrayList.add(population);
        populationReporter.displayPopulationInfo(populationArrayList, "Display Population by Language");
    }

    @Test
    void displayAdditionalInfoTestNullForParameter(){
        populationReporter.displayAdditionalInfo(null, null);
    }

    @Test
    void displayAdditionalInfo(){
        populationReporter.displayAdditionalInfo(2000L,"Display Additional Info");
    }

}
