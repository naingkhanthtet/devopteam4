// This file is the starting point of the whole app.
package com.napier.team4;

import java.sql.*;
import java.util.List;

/**
 * The main class for the Country Information App.
 * It connects to the database, performs various tasks related to country information,
 * and displays the results.
 */
/*
Java program testing
 */
public class Main {

    /**
     * The main method that serves as the entry point for the application.
     * It connects to the MySQL database, performs various tasks related to country information,
     * and displays the results.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        int topN = 5; // local variable for getting TOP N
        String continent = "Asia"; // local variable for getting countries from continent
        String region = "Caribbean"; // local variable for getting countries from region

        // Connect to MYSQL
        MYSQLConnection mysqlCon = new MYSQLConnection();
        Connection con = mysqlCon.connect();

        CountryReporter countryReporter = new CountryReporter();
        // For task 1
        List<Country> sortedCountries = countryReporter.sortCountryByPopulation(con);
        // For task 2
        List<Country> sortedCountriesInContinent = countryReporter.sortCountryByPopulationBasedOnContinent(con, continent);
        // For task 3
        List<Country> sortedCountriesInRegion = countryReporter.sortCountryByPopulationBasedOnRegion(con, region);
        // For task 4
        List<Country> topNPopulatedCountries= countryReporter.getTopNPopulatedCountries(con, topN);
        // For task 5
        List<Country> topNPopulatedCountriesInContinent = countryReporter.getTopNPopulatedCountriesInContinent(con, continent, topN);
        // For task 6
        List<Country> topNPopulatedCountriesInRegion = countryReporter.getTopNPopulatedCountriesInRegion(con, region, topN);

        countryReporter.displayCountryInfo(sortedCountries, "Sorted Countries By Population");
        countryReporter.displayCountryInfo(sortedCountriesInContinent, String.format("Sorted Countries By Population In %s", continent));
        countryReporter.displayCountryInfo(sortedCountriesInRegion, String.format("Sorted Countries By Population In %s", region));
        countryReporter.displayCountryInfo(topNPopulatedCountries, String.format("Top %d Populated Countries", topN));
        countryReporter.displayCountryInfo(topNPopulatedCountriesInContinent, String.format("Top %d Populated Countries In %s", topN, continent));
        countryReporter.displayCountryInfo(topNPopulatedCountriesInRegion, String.format("Top %d Populated Countries In %s", topN, region));

        mysqlCon.disconnect();
    }
}
