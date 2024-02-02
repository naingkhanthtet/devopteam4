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

    public List<Country> sortCountryByPopulationBasedOnRegion(@NotNull Connection con, String region) {
        List<Country> countryList = new ArrayList<>();
        try {
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "WHERE Region = ? " // Add a WHERE clause to filter by continent
                            + "ORDER BY Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, region); // Set the region parameter in the PreparedStatement
            ResultSet rset = pstmt.executeQuery();
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
            pstmt.close();

            return countryList;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            throw new RuntimeException(e);
        }
    }
    public List<Country> sortCountryByPopulationBasedOnContinent(@NotNull Connection con, String continent) {
        List<Country> countryList = new ArrayList<>();
        try {
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "WHERE Continent = ? " // Add a WHERE clause to filter by continent
                            + "ORDER BY Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, continent); // Set the continent parameter in the PreparedStatement
            ResultSet rset = pstmt.executeQuery();
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
            pstmt.close();

            return countryList;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            throw new RuntimeException(e);
        }
    }

    public List<Country> getTopNPopulatedCountries(@NotNull Connection con, int n) {
        List<Country> countryList = new ArrayList<>();
        try {
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "ORDER BY Population DESC "
                            + "LIMIT ?";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setInt(1, n); // Set the limit to the desired top N
            ResultSet rset = pstmt.executeQuery();
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
            pstmt.close();

            return countryList;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            throw new RuntimeException(e);
        }
    }

    public List<Country> getTopNPopulatedCountriesInContinent(@NotNull Connection con, String continent, int n) {
        List<Country> countryList = new ArrayList<>();
        try {
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "WHERE Continent = ? " // Add a WHERE clause to filter by continent
                            + "ORDER BY Population DESC "
                            + "LIMIT ?";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, continent); // Set the continent parameter in the PreparedStatement
            pstmt.setInt(2, n); // Set the limit to the desired top N
            ResultSet rset = pstmt.executeQuery();
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
            pstmt.close();

            return countryList;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            throw new RuntimeException(e);
        }
    }

    public List<Country> getTopNPopulatedCountriesInRegion(@NotNull Connection con, String region, int n) {
        List<Country> countryList = new ArrayList<>();
        try {
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "WHERE Region = ? " // Add a WHERE clause to filter by region
                            + "ORDER BY Population DESC "
                            + "LIMIT ?";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, region); // Set the region parameter in the PreparedStatement
            pstmt.setInt(2, n); // Set the limit to the desired top N
            ResultSet rset = pstmt.executeQuery();
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
            pstmt.close();

            return countryList;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            throw new RuntimeException(e);
        }
    }
    public void displayCountryInfo(@NotNull List<Country> countryList, String title) {
        System.out.println(title);
        for (Country country : countryList) {
            System.out.println(country.toString());
        }
        System.out.println();
    }
}
