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
        countryReporter.displayCountryInfo(sortedCountries);
        mysqlCon.disconnect();
    }
}
