// This file is the starting point of the whole app.
package com.napier.team4;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Connect to MYSQL
        MYSQLConnection mysqlCon = new MYSQLConnection();
        Connection con = mysqlCon.connect();
        CountryReporter countryReporter = new CountryReporter();
        // For task 1
        List<Country> sortedCountries = countryReporter.sortCountryByPopulation(con);
        // For task 2
        List<Country> sortedCountriesByContinent = countryReporter.sortCountryByPopulationBasedOnContinent(con, "Asia");
        // For task 3
        List<Country> sortedCountriesByRegion = countryReporter.sortCountryByPopulationBasedOnRegion(con, "Caribbean");
        // For task 4
        List<Country> topNPopulatedCountries= countryReporter.getTopNPopulatedCountries(con, 5);
        // For task 5
        List<Country> topNPopulatedCountriesInContinent = countryReporter.getTopNPopulatedCountriesInContinent(con, "Asia", 5);
        countryReporter.displayCountryInfo(sortedCountries);
        countryReporter.displayCountryInfo(sortedCountriesByContinent);
        countryReporter.displayCountryInfo(sortedCountriesByRegion);
        countryReporter.displayCountryInfo(topNPopulatedCountries);
        countryReporter.displayCountryInfo(topNPopulatedCountriesInContinent);
        mysqlCon.disconnect();
    }
}
