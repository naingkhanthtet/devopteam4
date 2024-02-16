package com.napier.team4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class CountryReporterUnitTest {
    static CountryReporter countryReporter;

    @BeforeAll
    static void init()
    {
        countryReporter = new CountryReporter();
    }

    @Test
    void displayCountryInfoTestNullForParameter()
    {
        countryReporter.displayCountryInfo(null, null);
    }

    @Test
    void displayCountryInfoTestEmpty()
    {
        ArrayList<Country> countryList = new ArrayList<Country>();
        countryReporter.displayCountryInfo(countryList, "Empty Country List");
    }

    @Test
    void displayCountryInfoTestContainNull()
    {
        ArrayList<Country> countryList = new ArrayList<Country>();
        countryList.add(null);
        countryReporter.displayCountryInfo(countryList, "Country List Contain Null Value");
    }

    @Test
    void displayCountryInfo() {
        ArrayList<Country> countryList = new ArrayList<Country>();
        Country country = new Country("CountryCode", "CountryName", "ContinentName", "RegionName", 10000, "Capital Name");
        countryList.add(country);
        countryReporter.displayCountryInfo(countryList, "Display Country Info");
    }
}
