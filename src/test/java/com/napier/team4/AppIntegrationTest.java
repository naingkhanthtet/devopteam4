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

    // defining continent name
    String continentName = "Asia";
    // defining region name
    String regionName = "Caribbean";
    // defining country name
    String countryName = "Myanmar";
    // defining district name
    String districtName = "Kabol";

    @BeforeAll
    static void init() {
        sql = new MYSQLConnection();
        con = sql.connect("localhost:33062", 0);
    }

    @AfterAll
    static void cleanup() {
        sql.disconnect();
    }

    /*
     * Country report testing methods
     */
    @Test
    void testSortCountryByPopulation() {
        CountryReporter countryReporter = new CountryReporter();
        // Retrieve a list of countries sorted by population
        List<Country> countryList = countryReporter.sortCountryByPopulation(con);

        assertNotNull(countryList, "Country list should not be null");

        // verifying population data is sorted in descending order
        // holding maximum integer value for comparison
        int prevPopulation = Integer.MAX_VALUE;
        for (Country country : countryList) {
            // take current population at each iteration to compare with previous maximum value
            int currentPopulation = country.getPopulation();
            // comparing current and previous population
            assertTrue(currentPopulation <= prevPopulation, "population should be sorted in descending order");
            prevPopulation = currentPopulation;
        }
    }

    @Test
    void testSortCountryByPopulationBasedOnContinent() {
        CountryReporter countryReporter = new CountryReporter();
        // interation count
        int iterationCount = 0;
        // Retrieve a list of cities sorted by population on continent
        List<Country> countryList = countryReporter.sortCountryByPopulationBasedOnContinent(con, continentName);

        assertNotNull(countryList, "Country list should not be null");

        // verifying population data is sorted in descending order
        // holding maximum integer value for comparison
        int prevPopulation = Integer.MAX_VALUE;
        for (Country country : countryList) {
            // take current population at each iteration to compare with previous maximum value
            int currentPopulation = country.getPopulation();
            // comparing current and previous population
            assertTrue(currentPopulation <= prevPopulation, "population should be sorted in descending order");
            prevPopulation = currentPopulation;

            assertNotNull(country.getName(), "Country name should not be null");
            assertNotNull(country.getContinent(), "Continent name should not be null");
            assertNotNull(country.getRegion(), "Region name should not be null");
            assertEquals(country.getContinent(), continentName, "selected continent should be chosen");

            iterationCount++;
            // only want to loop a list a bit
            if (iterationCount > 3) break;
        }
    }

    @Test
    void testSortCountryByPopulationBasedOnRegion() {
        CountryReporter countryReporter = new CountryReporter();
        // interation count
        int iterationCount = 0;
        // Retrieve a list of cities sorted by population on continent
        List<Country> countryList = countryReporter.sortCountryByPopulationBasedOnRegion(con, regionName);

        assertNotNull(countryList, "Country list should not be null");

        // verifying population data is sorted in descending order
        // holding maximum integer value for comparison
        int prevPopulation = Integer.MAX_VALUE;
        for (Country country : countryList) {
            // take current population at each iteration to compare with previous maximum value
            int currentPopulation = country.getPopulation();
            // comparing current and previous population
            assertTrue(currentPopulation <= prevPopulation, "population should be sorted in descending order");
            prevPopulation = currentPopulation;

            assertNotNull(country.getName(), "Country name should not be null");
            assertNotNull(country.getContinent(), "Continent name should not be null");
            assertNotNull(country.getRegion(), "Region name should not be null");
            assertEquals(country.getRegion(), regionName, "selected region should be chosen");

            iterationCount++;
            // only want to loop a list a bit
            if (iterationCount > 3) break;
        }
    }

    @Test
    void testGetTopNPopulatedCountries() {
        // defining top N size
        int topN = 2;
        CountryReporter countryReporter = new CountryReporter();

        // retrieves a list of top N populated countries in the world
        List<Country> countryList = countryReporter.getTopNPopulatedCountries(con, topN);

        // returned country list should not be null
        assertNotNull(countryList, "Country list should not be null");

        for (Country country : countryList) {
            // each row's value should not be null
            assertNotNull(country.getName(), "Country name should not be null");
            assertNotNull(country.getContinent(), "Continent name should not be null");
            assertNotNull(country.getRegion(), "Region name should not be null");
        }
    }

    @Test
    void testGetTopNPopulatedCountriesInContinent() {
        // defining top N size
        int topN = 2;
        CountryReporter countryReporter = new CountryReporter();

        // retrieves a list of top N populated countries in the continent
        List<Country> countryList = countryReporter.getTopNPopulatedCountriesInContinent(con, continentName, topN);

        // returned country list should not be null
        assertNotNull(countryList, "Country list should not be null");

        for (Country country : countryList) {
            // each row's value should not be null
            assertNotNull(country.getName(), "Country name should not be null");
            assertNotNull(country.getContinent(), "Continent name should not be null");
            assertNotNull(country.getRegion(), "Region name should not be null");
            assertEquals(country.getContinent(), continentName, "selected continent should be provided");
        }
    }

    @Test
    void testGetTopNPopulatedCountriesInRegion() {
        // defining top N size
        int topN = 2;
        CountryReporter countryReporter = new CountryReporter();

        // retrieves a list of top N populated countries in the region
        List<Country> countryList = countryReporter.getTopNPopulatedCountriesInRegion(con, regionName, topN);

        // returned country list should not be null
        assertNotNull(countryList, "Country list should not be null");

        for (Country country : countryList) {
            // each row's value should not be null
            assertNotNull(country.getName(), "Country name should not be null");
            assertNotNull(country.getContinent(), "Continent name should not be null");
            assertNotNull(country.getRegion(), "Region name should not be null");
            assertEquals(country.getRegion(), regionName, "selected region should be provided");
        }
    }


    /*
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
