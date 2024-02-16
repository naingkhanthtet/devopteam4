package com.napier.team4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class CapitalCityUnitTest {

    static CapitalCityReporter capitalCityReporter;

    @BeforeAll
    static void init()
    {
        capitalCityReporter = new CapitalCityReporter();
    }


    @Test
    void displayCapitalCityInfoTestNullForParameter()
    {
        capitalCityReporter.displayCapitalCityInfo(null, null);
    }

    @Test
    void displayCapitalCityInfoTestEmpty()
    {
        ArrayList<CapitalCity> capitalCitiesList = new ArrayList<CapitalCity>();
        capitalCityReporter.displayCapitalCityInfo(capitalCitiesList, "Empty Captial City List");
    }

    @Test
    void displayCapitalCityInfoTestContainNull()
    {
        ArrayList<CapitalCity> capitalCitiesList = new ArrayList<CapitalCity>();
        capitalCitiesList.add(null);
        capitalCityReporter.displayCapitalCityInfo(capitalCitiesList, "City List Contain Null Value");
    }

    @Test
    void displayCapitalCityInfo() {
        ArrayList<CapitalCity> capitalCitiesList = new ArrayList<CapitalCity>();
        CapitalCity capitalCity = new CapitalCity("CapitalName", "CountryName", 0);
        capitalCitiesList.add(capitalCity);
        capitalCityReporter.displayCapitalCityInfo(capitalCitiesList, "Display City Info");
    }

}
