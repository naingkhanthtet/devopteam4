package com.napier.team4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class AppUnitTest {

    static CityReporter cityReporter;

    @BeforeAll
    static void init()
    {
        cityReporter = new CityReporter();
    }


    @Test
    void displayCityInfoTestNullForParameter()
    {
        cityReporter.displayCityInfo(null, null);
    }

    @Test
    void displayCityInfoTestEmpty()
    {
        ArrayList<City> cityList = new ArrayList<City>();
        cityReporter.displayCityInfo(cityList, "Empty City List");
    }

    @Test
    void displayCityInfoTestContainNull()
    {
        ArrayList<City> cityList = new ArrayList<City>();
        cityList.add(null);
        cityReporter.displayCityInfo(cityList, "City List Contain Null Value");
    }

    @Test
    void displayCityInfo() {
        ArrayList<City> cityList = new ArrayList<City>();
        City city = new City("CityName", "CountryName", "District", 0);
        cityList.add(city);
        cityReporter.displayCityInfo(cityList, "Display City Info");
    }

}
