package com.napier.team4;

import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PopulationReporter {
    /**
     * Retrieves population statistics for each continent.
     *
     * @param con The database connection.
     * @return A list of Population objects containing continent-wise population information.
     *         Returns null in case of a SQL exception.
     */
    public List<Population> getPopulationStaticForContinent(@NotNull Connection con) {
        List<Population> populationList = new ArrayList<>();
        try {
            // Create a statement to execute SQL queries
            Statement stmt = con.createStatement();

            // SQL query to retrieve continent-wise population statistics
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

            // Process the result set and populate the populationList
            while (rset.next()) {
                Population population = createPopulationFromResultSet(rset, "Continent");
                populationList.add(population);
            }

            // Close the ResultSet and Statement
            rset.close();
            stmt.close();

            return populationList;
        } catch (SQLException e) {
            // Handle SQL exception and return null
            handleSQLException(e);
            return null;
        }
    }


    /**
     * Retrieves population statistics for each region.
     *
     * @param con The database connection.
     * @return A list of Population objects containing region-wise population information.
     *         Returns null in case of a SQL exception.
     */
    public List<Population> getPopulationStatisticsForRegion(@NotNull Connection con) {
        List<Population> populationList = new ArrayList<>();
        try {
            // Create a statement to execute SQL queries
            Statement stmt = con.createStatement();

            // SQL query to retrieve region-wise population statistics
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

            // Process the result set and populate the populationList
            while (rset.next()) {
                Population population = createPopulationFromResultSet(rset, "Region");
                populationList.add(population);
            }

            // Close the ResultSet and Statement
            rset.close();
            stmt.close();

            return populationList;
        } catch (SQLException e) {
            // Handle SQL exception and return null
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves population statistics for each country.
     *
     * @param con The database connection.
     * @return A list of Population objects containing country-wise population information.
     *         Returns null in case of a SQL exception.
     */
    public List<Population> getPopulationStatisticsForCountry(@NotNull Connection con) {
        List<Population> populationList = new ArrayList<>();
        try {
            // Create a statement to execute SQL queries
            Statement stmt = con.createStatement();

            // SQL query to retrieve country-wise population statistics
            String query = "SELECT country.Name AS Country, SUM(country.Population) AS TotalPopulation, "
                    + "COALESCE(SUM(city.Population), 0) AS PopulationInCities, "
                    + "GREATEST(SUM(country.Population) - COALESCE(SUM(city.Population), 0), 0) AS PopulationNotInCities, "
                    + "GREATEST(ROUND((COALESCE(SUM(city.Population), 0) / SUM(country.Population)) * 100, 2), 0) AS PercentageInCities, "
                    + "GREATEST(ROUND(((SUM(country.Population) - COALESCE(SUM(city.Population), 0)) / SUM(country.Population)) * 100, 2), 0) AS PercentageNotInCities "
                    + "FROM country "
                    + "LEFT JOIN city ON country.Code = city.CountryCode "
                    + "GROUP BY country.Name";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(query);

            // Process the result set and populate the populationList
            while (rset.next()) {
                Population population = createPopulationFromResultSet(rset, "Country");
                populationList.add(population);
            }

            // Close the ResultSet and Statement
            rset.close();
            stmt.close();

            return populationList;
        } catch (SQLException e) {
            // Handle SQL exception and return null
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves population statistics for specific languages.
     *
     * @param con The database connection.
     * @return A list of Language objects containing language-wise population information.
     *         Returns null in case of a SQL exception.
     */
    public List<Language> getPopulationByLanguage(@NotNull Connection con) {
        List<Language> languageList = new ArrayList<>();
        try {
            // Create a statement to execute SQL queries
            Statement stmt = con.createStatement();

            // SQL query to retrieve language-wise population statistics
            String query = "SELECT countrylanguage.Language, "
                    + "SUM(country.Population * (countrylanguage.Percentage / 100)) AS `TotalPopulationwithlanguages`, "
                    + "ROUND( "
                    +   "(SUM(country.Population * (countrylanguage.Percentage / 100)) / "
                    +   "(SELECT SUM(Population) FROM country)) * 100, 2) AS `Percentageofpopulationlanguages` "
                    + "FROM country, countrylanguage WHERE country.Code = countrylanguage.CountryCode "
                    + "AND countrylanguage.Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') "
                    + "GROUP BY countrylanguage.Language ORDER BY TotalPopulationwithlanguages DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(query);

            // Process the result set and populate the languageList
            while (rset.next()) {
                Language language = createLanguageFromResultSet(rset);
                languageList.add(language);

            }

            // Close the ResultSet and Statement
            rset.close();
            stmt.close();

            return languageList;
        } catch (SQLException e) {
            // Handle SQL exception and return null
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves the total population of the world.
     *
     * @param con The database connection.
     * @return The total population of the world.
     */
    public long getPopulationOfTheWorld(@NotNull Connection con) {
        try {
            // Create a statement to execute SQL queries
            Statement stmt = con.createStatement();

            // SQL query to retrieve the total population of the world
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
            // Handle SQL exception and return 0
            handleSQLException(e);
            return 0;
        }
    }

    /**
     * Retrieves the total population of a specific continent.
     *
     * @param con The database connection.
     * @param continent The name of the continent.
     * @return The total population of the specified continent.
     */
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
            // Handle SQL exception and return 0
            handleSQLException(e);
            return 0;
        }
    }

    /**
     * Retrieves the total population of a specific region.
     *
     * @param con The database connection.
     * @param region The name of the region.
     * @return The total population of the specified region.
     */
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
            // Handle SQL exception and return 0
            handleSQLException(e);
            return 0;
        }
    }

    /**
     * Retrieves the total population of a specific district.
     *
     * @param con The database connection.
     * @param district The name of the district.
     * @return The total population of the specified district.
     */
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
            // Handle SQL exception and return 0
            handleSQLException(e);
            return 0;
        }
    }

    /**
     * Retrieves the population of a specific city.
     *
     * @param con The database connection.
     * @param cityName The name of the city.
     * @return The population of the specified city.
     */
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
            // Handle SQL exception and return 0
            handleSQLException(e);
            return 0;
        }
    }

    /**
     * Retrieves the population of a specific country by name.
     *
     * @param con The database connection.
     * @param countryName The name of the country.
     * @return The population of the specified country.
     */
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
            // Handle SQL exception and return 0
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

    /**
     * Creates a Population object from the ResultSet.
     *
     * @param rset The ResultSet containing population information.
     * @param location The name of the location (continent, region, country).
     * @return The Population object created from the ResultSet.
     * @throws SQLException If a database access error occurs.
     */
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

    /**
     * Creates a Language object from the ResultSet.
     *
     * @param rset The ResultSet containing language information.
     * @return The Language object created from the ResultSet.
     * @throws SQLException If a database access error occurs.
     */
    private @NotNull Language createLanguageFromResultSet(@NotNull ResultSet rset) throws SQLException {
        Language language = new Language();
        language.setLanguage(rset.getString("countrylanguage.Language"));
        language.setTotalPopulation(rset.getLong("TotalPopulationwithlanguages"));
        language.setPercentageInWorld(rset.getDouble("Percentageofpopulationlanguages"));
//        language.setGetPercentageNotInWorld(rset.getDouble("PercentageNotInWorld"));

        return language;
    }

    /**
     * Displays population information by language.
     *
     * @param languageList The list of Language objects.
     * @param title The title for the display.
     */
    public void displayPopulationByLanguage(List<Language> languageList, String title) {
        if (languageList == null || title == null) {
            System.out.println("No languageLists or no title information provided.");
            return;
        }
        System.out.println();
        String titleAlignment = " %-20s %-20s %-30s %n";
        System.out.format(titleAlignment, "Language", "Total Population", "Percentage In World");
        String bodyAlignment = " %-20s %-20d %-30.2f %n";
        for (Language language : languageList) {
            if (language == null) {
                continue;
            }
            System.out.format(bodyAlignment, language.getLanguage(), language.getTotalPopulation(), language.getPercentageInWorld());
        }
        System.out.println();
    }

    /**
     * Displays population information for a given list and title.
     *
     * @param populationList The list of Population objects.
     * @param title The title for the display.
     */
    public void displayPopulationInfo(List<Population> populationList, String title) {
        // Check populationList is not null
        if (populationList == null || title == null) {
            System.out.println("No populations or no title information provided.");
            return;
        }
        String titleAlignment = " %-48s %-20s %-25s %-30s %-25s %-30s %n";
        System.out.format(titleAlignment, "Location Name", "Total Population", "Population In Location", "Population Not In Location", "Percentage In Location", "Percentage Not In Location");
        String bodyAlignment = " %-48s %-30d %-25d %-30s %-25.2f %-30.2f %n";
        for (Population population : populationList) {
            if (population == null) {
                continue;
            }
            System.out.format(bodyAlignment, population.getLocationName(), population.getTotalPopulation(), population.getPopulationInCities(), population.getPopulationNotInCities(), population.getPercentageInCities(), population.getPercentageNotInCities());
        }
        System.out.println();
    }

    /**
     * Displays additional information, such as total population, with the specified title.
     *
     * @param population The total population to be displayed.
     * @param title The title for the display.
     */
    public void displayAdditionalInfo(Long population, String title) {
        if (population == null || title == null) {
            System.out.println("No population data or title information provided");
            return;
        }
        System.out.println(title + " = " + population);
    }
}
