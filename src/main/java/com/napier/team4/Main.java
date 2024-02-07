// This file is the starting point of the whole app.
package com.napier.team4;

import java.sql.*;
import java.util.List;

/**
 * The main class for the Country Information App.
 * It connects to the database, performs various tasks related to country information,
 * and displays the results.
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
        String country = "Myanmar"; // local variable for getting cities from country
        String district = "Kabol"; // local variable for getting cities from district
        // Connect to MYSQL
        MYSQLConnection mysqlCon = new MYSQLConnection();
        Connection con = null;
        if (args.length < 1) {
            con = mysqlCon.connect("localhost:33062", 0);
        } else {
            con = mysqlCon.connect("db:3306", 30000);
        }


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

        CityReporter cityReporter = new CityReporter();
        // For task 7
        List<City> sortCityByPopulation = cityReporter.sortCityByPopulation(con);
        // For task 8
        List<City> sortCityByPopulationBasedOnContinent = cityReporter.sortCityByPopulationBasedOnContinent(con, continent);
        // For task 9
        List<City> sortCityByPopulationBasedOnRegion = cityReporter.sortCityByPopulationBasedOnRegion(con, region);
        // For task 10
        List<City> sortCityByPopulationInCountry = cityReporter.sortCityByPopulationInCountry(con, country);
        // For task 11
        List<City> sortCityByPopulationInDistrict = cityReporter.sortCityByPopulationInDistrict(con, district);
        // For task 12
        List<City> topNPopulatedCities = cityReporter.getTopNPopulatedCities(con, topN);
        // For task 13
        List<City> topNPopulatedCitiesInContinent = cityReporter.getTopNPopulatedCitiesInContinent(con, continent, topN);
        // For task 14
        List<City> topNPopulatedCitiesInRegion = cityReporter.getTopNPopulatedCitiesInRegion(con, region, topN);
        // For task 15
        List<City> topNPopulatedCitiesInCountry = cityReporter.getTopNPopulatedCitiesInCountry(con, country, topN);
        // For task 16
        List<City> topNPopulatedCitiesInDistrict = cityReporter.getTopNPopulatedCitiesInDistrict(con, district, topN);

//        cityReporter.displayCityInfo(sortCityByPopulation, "Sorted Cities By Population");
//        cityReporter.displayCityInfo(sortCityByPopulationBasedOnContinent, String.format("Sorted Cities By Population In %s", continent));
//        cityReporter.displayCityInfo(sortCityByPopulationBasedOnRegion, String.format("Sorted Cities By Population In %s", region));
//        cityReporter.displayCityInfo(sortCityByPopulationInCountry, String.format("Sorted Cities By Population In %s", country));
//        cityReporter.displayCityInfo(sortCityByPopulationInDistrict, String.format("Sorted Cities By Population In %s", district));
//        cityReporter.displayCityInfo(topNPopulatedCities, String.format("Top %d Populated Cities", topN));
//        cityReporter.displayCityInfo(topNPopulatedCitiesInContinent, String.format("Top %d Populated Cities In %s", topN, continent));
//        cityReporter.displayCityInfo(topNPopulatedCitiesInRegion, String.format("Top %d Populated Cities In %s", topN, region));
//        cityReporter.displayCityInfo(topNPopulatedCitiesInCountry, String.format("Top %d Populated Cities In %s", topN, country));
//        cityReporter.displayCityInfo(topNPopulatedCitiesInDistrict, String.format("Top %d Populated Cities In %s", topN, district));

        mysqlCon.disconnect();
    }
}
