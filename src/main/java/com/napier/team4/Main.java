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
        List<Country> sortedCountries = countryReporter.sortCountryByPopulation(con);
        // For task 3
        List<Country> sortedCountriesByRegion = countryReporter.sortCountryByPopulationBasedOnRegion(con, "Caribbean");
        countryReporter.displayCountryInfo(sortedCountries);
        countryReporter.displayCountryInfo(sortedCountriesByRegion);
        mysqlCon.disconnect();
    }
}
