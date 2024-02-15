package com.napier.team4;

import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PopulationReporter {
    public List<Population> getPopulationStaticForContinent(@NotNull Connection con) {
        List<Population> populationList = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT Continent, SUM(Population) AS TotalPopulation, "
                    + "SUM(PopulationInCities) AS PopulationInCities, "
                    + "SUM(Population - PopulationInCities) AS PopulationNotInCities, "
                    + "ROUND((SUM(PopulationInCities) / SUM(Population)) * 100, 2) AS PercentageInCities, "
                    + "ROUND((SUM(Population - PopulationInCities) / SUM(Population)) * 100, 2) AS PercentageNotInCities "
                    + "FROM (SELECT Continent, Population, 0 AS PopulationInCities "
                    + "      FROM country "
                    + "      UNION ALL "
                    + "      SELECT country.Continent, 0, city.Population "
                    + "      FROM country "
                    + "      JOIN city ON country.Code = city.CountryCode) AS combined "
                    + "GROUP BY Continent";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(query);

            while (rset.next()) {
                Population population = createPopulationFromResultSet(rset, "Continent");
                populationList.add(population);
            }

            // Close the ResultSet and Statement
            rset.close();
            stmt.close();

            return populationList;
        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    public List<Population> getPopulationStatisticsForRegion(@NotNull Connection con) {
        List<Population> populationList = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT Region, SUM(Population) AS TotalPopulation, "
                    + "SUM(PopulationInCities) AS PopulationInCities, "
                    + "SUM(Population - PopulationInCities) AS PopulationNotInCities, "
                    + "ROUND((SUM(PopulationInCities) / SUM(Population)) * 100, 2) AS PercentageInCities, "
                    + "ROUND((SUM(Population - PopulationInCities) / SUM(Population)) * 100, 2) AS PercentageNotInCities "
                    + "FROM (SELECT Region, Population, 0 AS PopulationInCities "
                    + "      FROM country "
                    + "      UNION ALL "
                    + "      SELECT country.Region, 0, city.Population "
                    + "      FROM country "
                    + "      JOIN city ON country.Code = city.CountryCode) AS combined "
                    + "GROUP BY Region";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(query);

            while (rset.next()) {
                Population population = createPopulationFromResultSet(rset, "Region");
                populationList.add(population);
            }

            // Close the ResultSet and Statement
            rset.close();
            stmt.close();

            return populationList;
        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    public List<Population> getPopulationStatisticsForCountry(@NotNull Connection con) {
        List<Population> populationList = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT country.Name AS Country, SUM(country.Population) AS TotalPopulation, "
                    + "COALESCE(SUM(city.Population), 0) AS PopulationInCities, "
                    + "SUM(country.Population) - COALESCE(SUM(city.Population), 0) AS PopulationNotInCities, "
                    + "ROUND((COALESCE(SUM(city.Population), 0) / SUM(country.Population)) * 100, 2) AS PercentageInCities, "
                    + "ROUND(((SUM(country.Population) - COALESCE(SUM(city.Population), 0)) / SUM(country.Population)) * 100, 2) AS PercentageNotInCities "
                    + "FROM country "
                    + "LEFT JOIN city ON country.Code = city.CountryCode "
                    + "GROUP BY country.Name";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(query);

            while (rset.next()) {
                Population population = createPopulationFromResultSet(rset, "Country");
                populationList.add(population);
            }

            // Close the ResultSet and Statement
            rset.close();
            stmt.close();

            return populationList;
        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    public List<Language> getPopulationByLanguage(@NotNull Connection con){
        List<Language> languageList = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT " +
                    "cl.Language AS Language, " +
                    "SUM(c.Population) AS TotalPopulation, " +
                    "ROUND((SUM(c.Population) / (SELECT SUM(Population) FROM country)) * 100, 2) AS PercentageOfWorldPopulation, " +
                    "100 - ROUND((SUM(c.Population) / (SELECT SUM(Population) FROM country)) * 100, 2) AS PercentageNotInWorld " +
                    "FROM " +
                    "countrylanguage cl " +
                    "JOIN " +
                    "country c ON cl.CountryCode = c.Code " +
                    "GROUP BY " +
                    "cl.Language " +
                    "ORDER BY " +
                    "TotalPopulation DESC";  // Sort by TotalPopulation in descending order

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(query);
            List<String> desiredLanguages = Arrays.asList("Chinese", "English", "Hindi", "Spanish", "Arabic");

            while (rset.next()) {
                Language language = createLanguageFromResultSet(rset);
                if (desiredLanguages.contains(language.getLanguage())) {
                    languageList.add(language);
                }
            }

            // Close the ResultSet and Statement
            rset.close();
            stmt.close();
            return languageList;
        }catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    public long getPopulationOfTheWorld(@NotNull Connection con) {
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT SUM(Population) AS TotalPopulation FROM country";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(query);

            // Retrieve the total population from the result set
            if (resultSet.next()) {
                return resultSet.getLong("TotalPopulation");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            handleSQLException(e);
            return 0;
        }
    }

    public long getPopulationOfContinent(@NotNull Connection con, String continent) {
        try {
            // Create a prepared statement with a parameter to prevent SQL injection
            String query = "SELECT SUM(Population) AS TotalPopulation FROM country WHERE Continent = ?";
            PreparedStatement pstmt = con.prepareStatement(query);

            // Set the continent parameter
            pstmt.setString(1, continent);

            // Execute SQL statement
            ResultSet resultSet = pstmt.executeQuery();

            // Retrieve the total population from the result set
            if (resultSet.next()) {
                return resultSet.getLong("TotalPopulation");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            handleSQLException(e);
            return 0;
        }
    }

    public long getPopulationOfRegion(@NotNull Connection con, String region) {
        try {
            // Create a prepared statement with a parameter to prevent SQL injection
            String query = "SELECT SUM(Population) AS TotalPopulation FROM country WHERE Region = ?";
            PreparedStatement pstmt = con.prepareStatement(query);

            // Set the region parameter
            pstmt.setString(1, region);

            // Execute SQL statement
            ResultSet resultSet = pstmt.executeQuery();

            // Retrieve the total population from the result set
            if (resultSet.next()) {
                return resultSet.getLong("TotalPopulation");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            handleSQLException(e);
            return 0;
        }
    }

    public long getPopulationOfDistrict(@NotNull Connection con, String district) {
        try {
            // Create a prepared statement with a parameter to prevent SQL injection
            String query = "SELECT SUM(Population) AS TotalPopulation FROM city WHERE District = ?";
            PreparedStatement pstmt = con.prepareStatement(query);

            // Set the district parameter
            pstmt.setString(1, district);

            // Execute SQL statement
            ResultSet resultSet = pstmt.executeQuery();

            // Retrieve the total population from the result set
            if (resultSet.next()) {
                return resultSet.getLong("TotalPopulation");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            handleSQLException(e);
            return 0;
        }
    }

    public long getPopulationOfCity(@NotNull Connection con, String cityName) {
        try {
            // Create a prepared statement with a parameter to prevent SQL injection
            String query = "SELECT Population FROM city WHERE Name = ?";
            PreparedStatement pstmt = con.prepareStatement(query);

            // Set the city name parameter
            pstmt.setString(1, cityName);

            // Execute SQL statement
            ResultSet resultSet = pstmt.executeQuery();

            // Retrieve the population from the result set
            if (resultSet.next()) {
                return resultSet.getLong("Population");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            handleSQLException(e);
            return 0;
        }
    }

    public long getPopulationOfCountryByName(@NotNull Connection con, String countryName) {
        try {
            // Create a prepared statement with a parameter to prevent SQL injection
            String query = "SELECT Population FROM country WHERE Name = ?";
            PreparedStatement pstmt = con.prepareStatement(query);

            // Set the country name parameter
            pstmt.setString(1, countryName);

            // Execute SQL statement
            ResultSet resultSet = pstmt.executeQuery();

            // Retrieve the population from the result set
            if (resultSet.next()) {
                return resultSet.getLong("Population");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            handleSQLException(e);
            return 0;
        }
    }


    /**
     * Handles SQLException by printing an error message and throwing a RuntimeException.
     *
     * @param e The SQLException to be handled.
     */
    private void handleSQLException(@NotNull SQLException e) {
        System.out.println(e.getMessage());
        System.out.println("Failed to get city information");
        throw new RuntimeException(e);
    }

    private @NotNull Population createPopulationFromResultSet(@NotNull ResultSet rset, String location) throws SQLException {
        Population population = new Population();
        population.setLocationName(rset.getString(location));
        population.setTotalPopulation(rset.getLong("TotalPopulation"));
        population.setPopulationInCities(rset.getLong("PopulationInCities"));
        population.setPopulationNotInCities(rset.getLong("PopulationNotInCities"));
        population.setPercentageInCities(rset.getDouble("PercentageInCities"));
        population.setPercentageNotInCities(rset.getDouble("PercentageNotInCities"));
        return population;
    }

    private @NotNull Language createLanguageFromResultSet(@NotNull ResultSet rset) throws SQLException {
        Language language = new Language();
        language.setLanguage(rset.getString("Language"));
        language.setTotalPopulation(rset.getLong("TotalPopulation"));
        language.setPercentageInWorld(rset.getDouble("PercentageOfWorldPopulation"));
        language.setGetPercentageNotInWorld(rset.getDouble("PercentageNotInWorld"));

        return language;
    }

    public void displayPopulationByLanguage(List<Language> languageList, String title){
        if (languageList == null || title == null){
            System.out.println("No languageLists or no title information provided.");
            return;
        }
        System.out.println(title);
        for (Language language : languageList) {
            System.out.println(language);
        }
    }


    public void displayPopulationInfo(List<Population> populationList, String title) {
        // Check populationList is not null
        if (populationList == null || title == null) {
            System.out.println("No populations or no title information provided.");
            return;
        }
        System.out.println(title);
        for (Population population : populationList) {
            System.out.println(population);
        }
    }

    public void displayAdditionalInfo(long population, String title) {
        System.out.println(title + " = " + population);
    }
}
