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
            String strSelect =
                    "SELECT city.Name as CityName, country.Name as CountryName, city.District, city.Population "
                            + "FROM city JOIN country ON city.CountryCode = country.Code "
                            + "ORDER BY Population DESC";

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
     * Handles SQLException by printing an error message and throwing a RuntimeException.
     *
     * @param e The SQLException to be handled.
     */
    private void handleSQLException(SQLException e) {
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
    private City createCityFromResultSet(ResultSet rset) throws SQLException {
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
        for (City city : cityList) {
            System.out.println(city);
        }
    }
}
