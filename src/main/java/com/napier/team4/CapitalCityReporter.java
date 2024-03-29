package com.napier.team4;

import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The CapitalCityReporter class is responsible for retrieving and displaying
 * information about capital cities sorted by population.
 */
public class CapitalCityReporter {

    /**
     * Retrieves a list of CapitalCity objects sorted by population.
     *
     * @param con The database connection.
     * @return A list of CapitalCity objects sorted by population.
     */
    public List<CapitalCity> sortCapitalCityByPopulation(@NotNull Connection con) {
        List<CapitalCity> capitalCities = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();

            // Create string for SQL statement to get capital cities sorted by population
            String strSelect = "SELECT city.Name as CityName, country.Name as CountryName, city.Population " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.ID = country.Capital " +
                    "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Iterate through the result set and create CapitalCity objects
            while (rset.next()) {
                CapitalCity capitalCity = createCapitalCityFromResultSet(rset);
                capitalCities.add(capitalCity);
            }

            // Close the ResultSet and Statement
            rset.close();
            stmt.close();

            return capitalCities;
        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }
    /**
     * Retrieves a list of CapitalCity objects representing all capital cities in a continent,
     * organized by largest population to smallest.
     *
     * @param con       The database connection.
     * @param continent The continent for which capital cities are to be retrieved.
     * @return A list of CapitalCity objects sorted by population in descending order.
     */
    public List<CapitalCity> sortCapitalCityByPopulationInContinent(@NotNull Connection con, String continent) {
        List<CapitalCity> capitalCities = new ArrayList<>();
        try {
            // Use a PreparedStatement to prevent SQL injection
            String strSelect = "SELECT city.Name as CityName, country.Name as CountryName, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.ID = country.Capital AND country.Continent = ? " +
                    "ORDER BY Population DESC";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set the parameter for the continent
            pstmt.setString(1, continent);

            // Execute SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Iterate through the result set and create CapitalCity objects
            while (rset.next()) {
                CapitalCity capitalCity = createCapitalCityFromResultSet(rset);
                capitalCities.add(capitalCity);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return capitalCities;
        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }
    /**
     * Retrieves a list of CapitalCity objects representing all capital cities in a region,
     * organized by largest population to smallest.
     *
     * @param con    The database connection.
     * @param region The region for which capital cities are to be retrieved.
     * @return A list of CapitalCity objects sorted by population in descending order.
     */
    public List<CapitalCity> sortCapitalCityByPopulationInRegion(@NotNull Connection con, String region) {
        List<CapitalCity> capitalCities = new ArrayList<>();
        try {
            // Use a PreparedStatement to prevent SQL injection
            String strSelect = "SELECT city.Name as CityName, country.Name as CountryName, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.ID = country.Capital AND country.Region = ? " +
                    "ORDER BY Population DESC";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set the parameter for the region
            pstmt.setString(1, region);

            // Execute SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Iterate through the result set and create CapitalCity objects
            while (rset.next()) {
                CapitalCity capitalCity = createCapitalCityFromResultSet(rset);
                capitalCities.add(capitalCity);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return capitalCities;
        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }
    /**
     * Retrieves the top N populated CapitalCity objects representing capital cities in the world,
     * organized by largest population to smallest.
     *
     * @param con The database connection.
     * @param topN   The number of top populated capital cities to retrieve.
     * @return A list of CapitalCity objects sorted by population in descending order, limited to the top N.
     */
    public List<CapitalCity> getTopNPopulatedCapitalCities(@NotNull Connection con, int topN) {
        List<CapitalCity> capitalCities = new ArrayList<>();
        try {
            // Use a PreparedStatement to prevent SQL injection
            String strSelect = "SELECT city.Name as CityName, country.Name as CountryName, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.ID = country.Capital " +
                    "ORDER BY Population DESC " +
                    "LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set the parameter for the limit (top N)
            pstmt.setInt(1, topN);

            // Execute SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Iterate through the result set and create CapitalCity objects
            while (rset.next()) {
                CapitalCity capitalCity = createCapitalCityFromResultSet(rset);
                capitalCities.add(capitalCity);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return capitalCities;
        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves the top N populated CapitalCity objects representing capital cities in a continent,
     * organized by largest population to smallest.
     *
     * @param con       The database connection.
     * @param continent The continent for which top populated capital cities are to be retrieved.
     * @param topN         The number of top populated capital cities to retrieve.
     * @return A list of CapitalCity objects sorted by population in descending order, limited to the top N.
     */
    public List<CapitalCity> getTopNPopulatedCapitalCitiesInContinent(@NotNull Connection con, String continent, int topN) {
        List<CapitalCity> capitalCities = new ArrayList<>();
        try {
            // Use a PreparedStatement to prevent SQL injection
            String strSelect = "SELECT city.Name as CityName, country.Name as CountryName, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.ID = country.Capital AND country.Continent = ? " +
                    "ORDER BY Population DESC " +
                    "LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set parameters for the continent and the limit (top N)
            pstmt.setString(1, continent);
            pstmt.setInt(2, topN);

            // Execute SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Iterate through the result set and create CapitalCity objects
            while (rset.next()) {
                CapitalCity capitalCity = createCapitalCityFromResultSet(rset);
                capitalCities.add(capitalCity);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return capitalCities;
        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves the top N populated CapitalCity objects representing capital cities in a region,
     * organized by largest population to smallest.
     *
     * @param con    The database connection.
     * @param region The region for which top populated capital cities are to be retrieved.
     * @param topN   The number of top populated capital cities to retrieve.
     * @return A list of CapitalCity objects sorted by population in descending order, limited to the top N.
     */
    public List<CapitalCity> getTopNPopulatedCapitalCitiesInRegion(@NotNull Connection con, String region, int topN) {
        List<CapitalCity> capitalCities = new ArrayList<>();
        try {
            // Use a PreparedStatement to prevent SQL injection
            String strSelect = "SELECT city.Name as CityName, country.Name as CountryName, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.ID = country.Capital AND country.Region = ? " +
                    "ORDER BY Population DESC " +
                    "LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set parameters for the region and the limit (top N)
            pstmt.setString(1, region);
            pstmt.setInt(2, topN);

            // Execute SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Iterate through the result set and create CapitalCity objects
            while (rset.next()) {
                CapitalCity capitalCity = createCapitalCityFromResultSet(rset);
                capitalCities.add(capitalCity);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return capitalCities;
        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }


    /**
     * Handles SQL exceptions by printing the error message and throwing a runtime exception.
     *
     * @param e The SQL exception to handle.
     */
    private void handleSQLException(@NotNull SQLException e) {
        System.out.println(e.getMessage());
        System.out.println("Failed to get capital city information");
        throw new RuntimeException(e);
    }

    /**
     * Creates a CapitalCity object from a ResultSet.
     *
     * @param rset The ResultSet containing the capital city information.
     * @return A CapitalCity object created from the ResultSet.
     * @throws SQLException If an SQL exception occurs.
     */
    private @NotNull CapitalCity createCapitalCityFromResultSet(@NotNull ResultSet rset) throws SQLException {
        String cityName = rset.getString("CityName");
        String countryName = rset.getString("CountryName");
        int population = rset.getInt("Population");

        return new CapitalCity(cityName, countryName, population);
    }

    /**
     * Displays information about capital cities in a formatted table.
     *
     * @param capitalCityList The list of CapitalCity objects to display.
     * @param title           The title for the table.
     */
    public void displayCapitalCityInfo(List<CapitalCity> capitalCityList, String title) {
        // Check capitalCityList and title is not null
        if (capitalCityList == null || title == null) {
            System.out.println("No capitals or no title information provided.");
            return;
        }
        System.out.println(title);

        String titleAlignment = " %-40s %-40s %-20s %n";
        System.out.format(titleAlignment, "Name", "Country Name", "Population");
        String bodyAlignment = " %-40s %-40s %-20d %n";
        for (CapitalCity capitalCity : capitalCityList) {
            if (capitalCity == null) {
                continue;
            }
            System.out.format(bodyAlignment, capitalCity.getName(), capitalCity.getCountry(), capitalCity.getPopulation());
        }
        System.out.println();
    }
}
