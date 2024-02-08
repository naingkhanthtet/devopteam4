package com.napier.team4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {
    static MYSQLConnection sql;
    static Connection con;

    @BeforeAll
    static void init() {
        sql = new MYSQLConnection();
        con = sql.connect("localhost:33062", 0);
    }

    @AfterAll
    static void cleanup() {
        sql.disconnect();
    }

    @Test
    void testGetTopNPopulatedCitiesInCountry() {
        // defining country name
        String countryName = "Myanmar";
        // defining top N size
        int topN = 2;
        CityReporter cityReporter = new CityReporter();

        // retrieves a list of top N populated cities in the specified country
        List<City> cityList = cityReporter.getTopNPopulatedCitiesInCountry(con, countryName, topN);

        // returned city list should not be null
        assertNotNull(cityList, "City list should not be null");

        for (City city : cityList) {
            // each row's value should not be null
            assertNotNull(city.getName(), "City name should not be null");
            assertNotNull(city.getCountry(), "Country name should not be null");
            assertNotNull(city.getDistrict(), "City district should not be null");

            // returned population should be greater than zero
            assertTrue(city.getPopulation() >= 0, "City population should have value");
        }
    }
}
