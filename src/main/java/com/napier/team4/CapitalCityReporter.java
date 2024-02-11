package com.napier.team4;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CapitalCityReporter {
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

    private void handleSQLException(@NotNull SQLException e) {
        System.out.println(e.getMessage());
        System.out.println("Failed to get capital city information");
        throw new RuntimeException(e);
    }

    private @NotNull CapitalCity createCapitalCityFromResultSet(@NotNull ResultSet rset) throws SQLException {
        String cityName = rset.getString("CityName");
        String countryName = rset.getString("CountryName");
        int population = rset.getInt("Population");

        return new CapitalCity(cityName, countryName, population);
    }

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
