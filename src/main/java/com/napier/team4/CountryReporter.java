package com.napier.team4;

import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryReporter {

    public List<Country> sortCountryByPopulation(@NotNull Connection con) {
        List<Country> countryList = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement to get countries sorted by population
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Iterate through the result set and create Country objects
            while (rset.next()) {
                Country country = new Country();
                country.setCode(rset.getString("Code"));
                country.setName(rset.getString("Name"));
                country.setContinent(rset.getString("Continent"));
                country.setRegion(rset.getString("Region"));
                country.setPopulation(rset.getInt("Population"));
                country.setCapital(rset.getInt("Capital"));
                countryList.add(country);
            }

            // Close the ResultSet and Statement
            rset.close();
            stmt.close();

            return countryList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            throw new RuntimeException(e);
        }
    }

    public void displayCountryInfo(@NotNull List<Country> countryList) {
        for (Country country : countryList) {
            System.out.println(country.toString());
        }
    }
}
