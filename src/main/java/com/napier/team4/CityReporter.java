package com.napier.team4;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The CityReporter class provides functionality for retrieving and displaying city information.
 */
public class CityReporter {

    /**
     * Retrieves a list of cities sorted by population from the database.
     *
     * @param con The database connection.
     * @return A list of City objects sorted by population, or null if an error occurs.
     */
    public List<City> sortCityByPopulation(@NotNull Connection con) {
        List<City> cityList = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();

            // Create string for SQL statement to get cities sorted by population
            String strSelect = "SELECT city.Name as CityName, country.Name as CountryName, city.District, city.Population " + "FROM city JOIN country ON city.CountryCode = country.Code " + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Iterate through the result set and create City objects
            while (rset.next()) {
                City city = createCityFromResultSet(rset);
                cityList.add(city);
            }

            // Close the ResultSet and Statement
            rset.close();
            stmt.close();

            return cityList;
        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves a list of cities sorted by population based on the specified continent.
     *
     * @param con       The database connection.
     * @param continent The continent name for filtering cities.
     * @return A list of City objects sorted by population, or null if an exception occurs.
     */
    public List<City> sortCityByPopulationBasedOnContinent(@NotNull Connection con, String continent) {
        List<City> cityList = new ArrayList<>();
        try {
            // Create a prepared statement with parameters to prevent SQL injection
            String strSelect = "SELECT city.Name as CityName, country.Name as CountryName, city.District, city.Population " + "FROM city JOIN country ON city.CountryCode = country.Code " + "WHERE country.Continent = ? " + "ORDER BY Population DESC";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set the continent parameter
            pstmt.setString(1, continent);

            // Execute SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Iterate through the result set and create City objects
            while (rset.next()) {
                City city = createCityFromResultSet(rset);
                cityList.add(city);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return cityList;

        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }


    /**
     * Retrieves a list of cities sorted by population based on the specified region.
     *
     * @param con    The database connection.
     * @param region The region name for filtering cities.
     * @return A list of City objects sorted by population, or null if an exception occurs.
     */
    public List<City> sortCityByPopulationBasedOnRegion(@NotNull Connection con, String region) {
        List<City> cityList = new ArrayList<>();
        try {
            // Create a prepared statement with parameters to prevent SQL injection
            String strSelect = "SELECT city.Name as CityName, country.Name as CountryName, city.District, city.Population " + "FROM city JOIN country ON city.CountryCode = country.Code " + "WHERE country.Region = ? " + "ORDER BY Population DESC";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set the region parameter
            pstmt.setString(1, region);

            // Execute SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Iterate through the result set and create City objects
            while (rset.next()) {
                City city = createCityFromResultSet(rset);
                cityList.add(city);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return cityList;

        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves a list of cities in a specific country sorted by population.
     *
     * @param con         The database connection.
     * @param countryName The country name for filtering cities.
     * @return A list of City objects sorted by population, or null if an exception occurs.
     */
    public List<City> sortCityByPopulationInCountry(@NotNull Connection con, String countryName) {
        List<City> cityList = new ArrayList<>();
        try {
            // Create a prepared statement with parameters to prevent SQL injection
            String strSelect = "SELECT city.Name as CityName, country.Name as CountryName, city.District, city.Population " + "FROM city JOIN country ON city.CountryCode = country.Code " + "WHERE country.Name = ? " + "ORDER BY Population DESC";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set the country code parameter
            pstmt.setString(1, countryName);

            // Execute SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Iterate through the result set and create City objects
            while (rset.next()) {
                City city = createCityFromResultSet(rset);
                cityList.add(city);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return cityList;

        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves a list of cities in a specific district sorted by population.
     *
     * @param con      The database connection.
     * @param district The district name for filtering cities.
     * @return A list of City objects sorted by population, or null if an exception occurs.
     */
    public List<City> sortCityByPopulationInDistrict(@NotNull Connection con, String district) {
        List<City> cityList = new ArrayList<>();
        try {
            // Create a prepared statement with parameters to prevent SQL injection
            String strSelect = "SELECT city.Name as CityName, country.Name as CountryName, city.District, city.Population " + "FROM city JOIN country ON city.CountryCode = country.Code " + "WHERE city.District = ? " + "ORDER BY Population DESC";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set the district parameter
            pstmt.setString(1, district);

            // Execute SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Iterate through the result set and create City objects
            while (rset.next()) {
                City city = createCityFromResultSet(rset);
                cityList.add(city);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return cityList;

        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves the top N populated cities in the world.
     *
     * @param con  The database connection.
     * @param topN The number of cities to retrieve (top N populated).
     * @return A list of City objects representing the top N populated cities, or null if an exception occurs.
     */
    public List<City> getTopNPopulatedCities(@NotNull Connection con, int topN) {
        List<City> cityList = new ArrayList<>();
        try {
            // Create a prepared statement with parameters to prevent SQL injection
            String strSelect = "SELECT city.Name as CityName, country.Name as CountryName, city.District, city.Population " + "FROM city JOIN country ON city.CountryCode = country.Code " + "ORDER BY Population DESC LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set the top N parameter
            pstmt.setInt(1, topN);

            // Execute SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Iterate through the result set and create City objects
            while (rset.next()) {
                City city = createCityFromResultSet(rset);
                cityList.add(city);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return cityList;

        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves the top N populated cities in a specific continent.
     *
     * @param con       The database connection.
     * @param continent The continent name for filtering cities.
     * @param topN      The number of cities to retrieve (top N populated).
     * @return A list of City objects representing the top N populated cities in the specified continent, or null if an exception occurs.
     */
    public List<City> getTopNPopulatedCitiesInContinent(@NotNull Connection con, String continent, int topN) {
        List<City> cityList = new ArrayList<>();
        try {
            // Create a prepared statement with parameters to prevent SQL injection
            String strSelect = "SELECT city.Name as CityName, country.Name as CountryName, city.District, city.Population " + "FROM city JOIN country ON city.CountryCode = country.Code " + "WHERE country.Continent = ? " + "ORDER BY Population DESC LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set the continent parameter
            pstmt.setString(1, continent);
            // Set the top N parameter
            pstmt.setInt(2, topN);

            // Execute SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Iterate through the result set and create City objects
            while (rset.next()) {
                City city = createCityFromResultSet(rset);
                cityList.add(city);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return cityList;

        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves the top N populated cities in a specific region.
     *
     * @param con    The database connection.
     * @param region The region name for filtering cities.
     * @param topN   The number of cities to retrieve (top N populated).
     * @return A list of City objects representing the top N populated cities in the specified region, or null if an exception occurs.
     */
    public List<City> getTopNPopulatedCitiesInRegion(@NotNull Connection con, String region, int topN) {
        List<City> cityList = new ArrayList<>();
        try {
            // Create a prepared statement with parameters to prevent SQL injection
            String strSelect = "SELECT city.Name as CityName, country.Name as CountryName, city.District, city.Population " + "FROM city JOIN country ON city.CountryCode = country.Code " + "WHERE country.Region = ? " + "ORDER BY Population DESC LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set the region parameter
            pstmt.setString(1, region);
            // Set the top N parameter
            pstmt.setInt(2, topN);

            // Execute SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Iterate through the result set and create City objects
            while (rset.next()) {
                City city = createCityFromResultSet(rset);
                cityList.add(city);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return cityList;

        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves the top N populated cities in a specific country.
     *
     * @param con         The database connection.
     * @param countryName The country name for filtering cities.
     * @param topN        The number of cities to retrieve (top N populated).
     * @return A list of City objects representing the top N populated cities in the specified country, or null if an exception occurs.
     */
    public List<City> getTopNPopulatedCitiesInCountry(@NotNull Connection con, String countryName, int topN) {
        List<City> cityList = new ArrayList<>();
        try {
            // Create a prepared statement with parameters to prevent SQL injection
            String strSelect = "SELECT city.Name as CityName, country.Name as CountryName, city.District, city.Population " + "FROM city JOIN country ON city.CountryCode = country.Code " + "WHERE country.Name = ? " + "ORDER BY Population DESC LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set the country code parameter
            pstmt.setString(1, countryName);
            // Set the top N parameter
            pstmt.setInt(2, topN);

            // Execute SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Iterate through the result set and create City objects
            while (rset.next()) {
                City city = createCityFromResultSet(rset);
                cityList.add(city);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return cityList;

        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves the top N populated cities in a specific district.
     *
     * @param con      The database connection.
     * @param district The district name for filtering cities.
     * @param topN     The number of cities to retrieve (top N populated).
     * @return A list of City objects representing the top N populated cities in the specified district, or null if an exception occurs.
     */
    public List<City> getTopNPopulatedCitiesInDistrict(@NotNull Connection con, String district, int topN) {
        List<City> cityList = new ArrayList<>();
        try {
            // Create a prepared statement with parameters to prevent SQL injection
            String strSelect = "SELECT city.Name as CityName, country.Name as CountryName, city.District, city.Population " + "FROM city JOIN country ON city.CountryCode = country.Code " + "WHERE city.District = ? " + "ORDER BY Population DESC LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            // Set the district parameter
            pstmt.setString(1, district);
            // Set the top N parameter
            pstmt.setInt(2, topN);

            // Execute SQL statement
            ResultSet rset = pstmt.executeQuery();
            // Iterate through the result set and create City objects
            while (rset.next()) {
                City city = createCityFromResultSet(rset);
                cityList.add(city);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return cityList;

        } catch (SQLException e) {
            handleSQLException(e);
            return null;
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
     * Creates a City object from the ResultSet obtained from the database.
     *
     * @param rset The ResultSet containing city information.
     * @return A City object created from the ResultSet.
     * @throws SQLException If an error occurs while retrieving data from the ResultSet.
     */
    private @NotNull City createCityFromResultSet(@NotNull ResultSet rset) throws SQLException {
        City city = new City();
        city.setName(rset.getString("CityName"));
        city.setCountry(rset.getString("CountryName"));
        city.setDistrict(rset.getString("District"));
        city.setPopulation(rset.getInt("Population"));
        return city;
    }

    /**
     * Displays city information in the console.
     *
     * @param cityList The list of City objects to be displayed.
     * @param title    The title to be displayed before the list of cities.
     */
    public void displayCityInfo(@NotNull List<City> cityList, String title) {
        System.out.println(title);

        String titleAlignment = " %-40s %-40s %-40s %-20s %n";
        System.out.format(titleAlignment, "Name", "Country", "District", "Population");
        String bodyAlignment = " %-40s %-40s %-40s %-20d %n";
        for (City city : cityList) {
            System.out.format(bodyAlignment, city.getName(), city.getCountry(), city.getDistrict(), city.getPopulation());
        }
        System.out.println();
    }
}