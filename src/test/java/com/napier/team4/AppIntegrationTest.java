package com.napier.team4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
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

    /**
     * city report testing methods
     */
    @Test
    void testGetTopNPopulatedCities() {
        // defining top N size
        int topN = 2;
        CityReporter cityReporter = new CityReporter();

        // retrieves a list of top N populated cities in the world
        List<City> cityList = cityReporter.getTopNPopulatedCities(con, topN);

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
            // specified country should be displayed
            assertEquals(city.getCountry(), countryName, "specified country name should have been output");
        }
    }

    @Test
    void testGetTopNPopulatedCitiesInDistrict() {
        // defining the district name
        String districtName = "Kabol";
        // defining top N size
        int topN = 1;
        CityReporter cityReporter = new CityReporter();

        // retrieves a list of top N populated cities in the specified district
        List<City> cityList = cityReporter.getTopNPopulatedCitiesInDistrict(con, districtName, topN);

        // returned city list should not be null
        assertNotNull(cityList, "City list should not be null");

        for (City city : cityList) {
            // each row's value should not be null
            assertNotNull(city.getName(), "City name should not be null");
            assertNotNull(city.getDistrict(), "District name should not be null");

            // returned population should be greater than zero
            assertTrue(city.getPopulation() >= 0, "City population should have value");
            // specified district should be displayed
            assertEquals(city.getDistrict(), districtName, "specified district name should have been output");
        }
    }

    @Test
    void testGetTopNPopulatedCitiesInRegion() {
        // defining the region name
        String regionName = "Caribbean";
        // defining top N size
        int topN = 1;
        CityReporter cityReporter = new CityReporter();

        // retrieves a list of top N populated cities in the specified region
        List<City> cityList = cityReporter.getTopNPopulatedCitiesInRegion(con, regionName, topN);

        // returned city list should not be null
        assertNotNull(cityList, "City list should not be null");

        for (City city : cityList) {
            // each row's value should not be null
            assertNotNull(city.getName(), "City name should not be null");
            assertNotNull(city.getDistrict(), "District name should not be null");
            assertNotNull(city.getCountry(), "Country name should not be null");

            // returned population should be greater than zero
            assertTrue(city.getPopulation() >= 0, "City population should have value");
        }
    }

    @Test
    void testGetTopNPopulatedCitiesInContinent() {
        // defining the asia name
        String continentName = "Asia";
        // defining top N size
        int topN = 1;
        CityReporter cityReporter = new CityReporter();

        // retrieves a list of top N populated cities in the specified continent
        List<City> cityList = cityReporter.getTopNPopulatedCitiesInContinent(con, continentName, topN);

        // returned city list should not be null
        assertNotNull(cityList, "City list should not be null");

        for (City city : cityList) {
            // each row's value should not be null
            assertNotNull(city.getName(), "City name should not be null");
            assertNotNull(city.getDistrict(), "District name should not be null");
            assertNotNull(city.getCountry(), "Country name should not be null");

            // returned population should be greater than zero
            assertTrue(city.getPopulation() >= 0, "City population should have value");
        }
    }

    @Test
    void testSortCityByPopulation() {
        CityReporter cityReporter = new CityReporter();
        // Retrieve a list of cities sorted by population
        List<City> cityList = cityReporter.sortCityByPopulation(con);

        assertNotNull(cityList, "City list should not be null");

        // verifying population data is sorted in descending order
        // holding maximum integer value for comparison
        int prevPopulation = Integer.MAX_VALUE;
        for (City city : cityList) {
            // take current population at each iteration to compare with previous maximum value
            int currentPopulation = city.getPopulation();
            // comparing current and previous population
            assertTrue(currentPopulation <= prevPopulation, "population should be sorted in descending order");
            prevPopulation = currentPopulation;
        }
    }

    @Test
    void testSortCityByPopulationBasedOnContinent() {
        CityReporter cityReporter = new CityReporter();
        // defining continent name
        String continentName = "Asia";
        // interation count
        int iterationCount = 0;
        // Retrieve a list of cities sorted by population on continent
        List<City> cityList = cityReporter.sortCityByPopulationBasedOnContinent(con, continentName);

        assertNotNull(cityList, "City list should not be null");

        // verifying population data is sorted in descending order
        // holding maximum integer value for comparison
        int prevPopulation = Integer.MAX_VALUE;
        for (City city : cityList) {
            // take current population at each iteration to compare with previous maximum value
            int currentPopulation = city.getPopulation();
            // comparing current and previous population
            assertTrue(currentPopulation <= prevPopulation, "population should be sorted in descending order");
            prevPopulation = currentPopulation;

            assertNotNull(city.getName(), "City name should not be null");
            assertNotNull(city.getDistrict(), "District name should not be null");
            assertNotNull(city.getCountry(), "Country name should not be null");

            iterationCount++;
            // only want to loop a list a bit
            if (iterationCount > 3) break;
        }
    }

    @Test
    void testSortCityByPopulationBasedOnRegion() {
        CityReporter cityReporter = new CityReporter();
        // defining region name
        String regionName = "Caribbean";
        // interation count
        int iterationCount = 0;
        // Retrieve a list of cities sorted by population on a region
        List<City> cityList = cityReporter.sortCityByPopulationBasedOnRegion(con, regionName);

        assertNotNull(cityList, "City list should not be null");

        // verifying population data is sorted in descending order
        // holding maximum integer value for comparison
        int prevPopulation = Integer.MAX_VALUE;
        for (City city : cityList) {
            // take current population at each iteration to compare with previous maximum value
            int currentPopulation = city.getPopulation();
            // comparing current and previous population
            assertTrue(currentPopulation <= prevPopulation, "population should be sorted in descending order");
            prevPopulation = currentPopulation;

            assertNotNull(city.getName(), "City name should not be null");
            assertNotNull(city.getDistrict(), "District name should not be null");
            assertNotNull(city.getCountry(), "Country name should not be null");

            iterationCount++;
            // only want to loop a list a bit
            if (iterationCount > 3) break;
        }
    }

    @Test
    void testSortCityByPopulationBasedOnCountry() {
        CityReporter cityReporter = new CityReporter();
        // defining country name
        String countryName = "Myanmar";
        // interation count
        int iterationCount = 0;
        // Retrieve a list of cities sorted by population on a country
        List<City> cityList = cityReporter.sortCityByPopulationInCountry(con, countryName);

        assertNotNull(cityList, "City list should not be null");

        // verifying population data is sorted in descending order
        // holding maximum integer value for comparison
        int prevPopulation = Integer.MAX_VALUE;
        for (City city : cityList) {
            // take current population at each iteration to compare with previous maximum value
            int currentPopulation = city.getPopulation();
            // comparing current and previous population
            assertTrue(currentPopulation <= prevPopulation, "population should be sorted in descending order");
            prevPopulation = currentPopulation;

            assertNotNull(city.getName(), "City name should not be null");
            assertNotNull(city.getDistrict(), "District name should not be null");
            assertNotNull(city.getCountry(), "Country name should not be null");
            // specified country should be displayed
            assertEquals(city.getCountry(), countryName, "specified country name should have been output");

            iterationCount++;
            // only want to loop a list a bit
            if (iterationCount > 3) break;
        }
    }

    @Test
    void testSortCityByPopulationBasedOnDistrict() {
        CityReporter cityReporter = new CityReporter();
        // defining district name
        String districtName = "Kabol";
        // interation count
        int iterationCount = 0;
        // Retrieve a list of cities sorted by population on a district
        List<City> cityList = cityReporter.sortCityByPopulationInDistrict(con, districtName);

        assertNotNull(cityList, "City list should not be null");

        // verifying population data is sorted in descending order
        // holding maximum integer value for comparison
        int prevPopulation = Integer.MAX_VALUE;
        for (City city : cityList) {
            // take current population at each iteration to compare with previous maximum value
            int currentPopulation = city.getPopulation();
            // comparing current and previous population
            assertTrue(currentPopulation <= prevPopulation, "population should be sorted in descending order");
            prevPopulation = currentPopulation;

            assertNotNull(city.getName(), "City name should not be null");
            assertNotNull(city.getDistrict(), "District name should not be null");
            assertNotNull(city.getCountry(), "Country name should not be null");
            // specified country should be displayed
            assertEquals(city.getDistrict(), districtName, "specified district name should have been output");

            iterationCount++;
            // only want to loop a list a bit
            if (iterationCount > 3) break;
        }
    }
}
