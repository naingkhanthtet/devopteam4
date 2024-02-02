package com.napier.team4;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods for reporting country information based on population, continent, and region.
 */
public class CountryReporter {

    /**
     * Retrieves a list of countries sorted by population in descending order.
     *
     * @param con The database connection.
     * @return A list of countries sorted by population.
     */
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
                Country country = createCountryFromResultSet(rset);
                countryList.add(country);
            }

            // Close the ResultSet and Statement
            rset.close();
            stmt.close();

            return countryList;
        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves a list of countries sorted by population in descending order within a specific region.
     *
     * @param con    The database connection.
     * @param region The region to filter countries.
     * @return A list of countries sorted by population in the specified region.
     */
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
                Country country = createCountryFromResultSet(rset);
                countryList.add(country);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return countryList;

        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves a list of countries sorted by population in descending order within a specific continent.
     *
     * @param con      The database connection.
     * @param continent The continent to filter countries.
     * @return A list of countries sorted by population in the specified continent.
     */
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
                Country country = createCountryFromResultSet(rset);
                countryList.add(country);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return countryList;

        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves the top N populated countries from the database.
     *
     * @param con The database connection.
     * @param n   The number of top populated countries to retrieve.
     * @return A list of top N populated countries.
     */
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
                Country country = createCountryFromResultSet(rset);
                countryList.add(country);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return countryList;

        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves the top N populated countries from a specific continent.
     *
     * @param con       The database connection.
     * @param continent The continent to filter countries.
     * @param n         The number of top populated countries to retrieve.
     * @return A list of top N populated countries in the specified continent.
     */
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
                Country country = createCountryFromResultSet(rset);
                countryList.add(country);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return countryList;

        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Retrieves the top N populated countries from a specific region.
     *
     * @param con    The database connection.
     * @param region The region to filter countries.
     * @param n      The number of top populated countries to retrieve.
     * @return A list of top N populated countries in the specified region.
     */
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
                Country country = createCountryFromResultSet(rset);
                countryList.add(country);
            }

            // Close the ResultSet and Statement
            rset.close();
            pstmt.close();

            return countryList;

        } catch (SQLException e) {
            handleSQLException(e);
            return null;
        }
    }

    /**
     * Creates a Country object from the given ResultSet containing country information.
     *
     * @param rset The ResultSet containing country information.
     * @return A Country object populated with data from the ResultSet.
     * @throws SQLException If a database access error occurs or the column index is out of range.
     */
    private @NotNull Country createCountryFromResultSet(@NotNull ResultSet rset) throws SQLException {
        Country country = new Country();
        country.setCode(rset.getString("Code"));
        country.setName(rset.getString("Name"));
        country.setContinent(rset.getString("Continent"));
        country.setRegion(rset.getString("Region"));
        country.setPopulation(rset.getInt("Population"));
        country.setCapital(rset.getInt("Capital"));
        return country;
    }

    /**
     * Handles a SQLException by printing the error message, indicating a failure to retrieve country information,
     * and throwing a RuntimeException with the original exception.
     *
     * @param e The SQLException to handle.
     * @throws RuntimeException Always throws a RuntimeException with the original SQLException.
     */
    private void handleSQLException(@NotNull SQLException e) {
        System.out.println(e.getMessage());
        System.out.println("Failed to get country information");
        throw new RuntimeException(e);
    }

    /**
     * Displays country information in a tabular format.
     *
     * @param countryList The list of countries to display.
     * @param title       The title to display before the table.
     */
    public void displayCountryInfo(@NotNull List<Country> countryList, String title) {
        System.out.println(title);
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow("Code", "Name", "Continent", "Region", "Population", "Capital");
        asciiTable.addRule();
        for (Country country : countryList) {
            asciiTable.addRow(
                    country.getCode(),
                    country.getName(),
                    country.getContinent(),
                    country.getRegion(),
                    country.getPopulation(),
                    country.getCapital()
            );
            asciiTable.addRule();
        }
        asciiTable.setTextAlignment(TextAlignment.CENTER);
        String render = asciiTable.render();
        System.out.println(render);
        System.out.println();
    }
}
