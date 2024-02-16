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
    // defining iteration count
    int iterationCount = 0;

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
            if (iterationCount > 5) break;
        }
    }

    @Test
    void testSortCountryByPopulationBasedOnRegion() {
        CountryReporter countryReporter = new CountryReporter();
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
            if (iterationCount > 5) break;
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
            if (iterationCount > 5) break;
        }
    }

    @Test
    void testSortCityByPopulationBasedOnRegion() {
        CityReporter cityReporter = new CityReporter();
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
            if (iterationCount > 5) break;
        }
    }

    @Test
    void testSortCityByPopulationBasedOnCountry() {
        CityReporter cityReporter = new CityReporter();
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
            if (iterationCount > 5) break;
        }
    }

    @Test
    void testSortCityByPopulationBasedOnDistrict() {
        CityReporter cityReporter = new CityReporter();
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
            if (iterationCount > 5) break;
        }
    }

    /*
     * capital city report testing methods
     */
    @Test
    void testSortCapitalCityByPopulation() {
        CapitalCityReporter capitalCityReporter = new CapitalCityReporter();
        // Retrieve a list of cities sorted by population on a district
        List<CapitalCity> cityList = capitalCityReporter.sortCapitalCityByPopulation(con);

        assertNotNull(cityList, "Capital City list should not be null");

        // verifying population data is sorted in descending order
        // holding maximum integer value for comparison
        int prevPopulation = Integer.MAX_VALUE;
        for (CapitalCity city : cityList) {
            // take current population at each iteration to compare with previous maximum value
            int currentPopulation = city.getPopulation();
            // comparing current and previous population
            assertTrue(currentPopulation <= prevPopulation, "population should be sorted in descending order");
            prevPopulation = currentPopulation;
        }
    }

    @Test
    void testSortCapitalCityByPopulationBasedOnContinent() {
        CapitalCityReporter capitalCityReporter = new CapitalCityReporter();
        // Retrieve a list of capital cities sorted by population on a continent
        List<CapitalCity> capitalCityList = capitalCityReporter.sortCapitalCityByPopulationInContinent(con, continentName);

        assertNotNull(capitalCityList, "Capital City list should not be null");

        // verifying population data is sorted in descending order
        // holding maximum integer value for comparison
        int prevPopulation = Integer.MAX_VALUE;
        for (CapitalCity cap_city : capitalCityList) {
            // take current population at each iteration to compare with previous maximum value
            int currentPopulation = cap_city.getPopulation();
            // comparing current and previous population
            assertTrue(currentPopulation <= prevPopulation, "population should be sorted in descending order");
            prevPopulation = currentPopulation;

            assertNotNull(cap_city.getName(), "City name should not be null");
            assertNotNull(cap_city.getCountry(), "Country name should not be null");

            iterationCount++;
            // only want to loop a list a bit
            if (iterationCount > 5) break;
        }
    }

    @Test
    void testSortCapitalCityByPopulationBasedOnRegion() {
        CapitalCityReporter capitalCityReporter = new CapitalCityReporter();
        // Retrieve a list of cities sorted by population on a district
        List<CapitalCity> capitalCityList = capitalCityReporter.sortCapitalCityByPopulationInRegion(con, regionName);

        assertNotNull(capitalCityList, "Capital City list should not be null");

        // verifying population data is sorted in descending order
        // holding maximum integer value for comparison
        int prevPopulation = Integer.MAX_VALUE;
        for (CapitalCity cap_city : capitalCityList) {
            // take current population at each iteration to compare with previous maximum value
            int currentPopulation = cap_city.getPopulation();
            // comparing current and previous population
            assertTrue(currentPopulation <= prevPopulation, "population should be sorted in descending order");
            prevPopulation = currentPopulation;

            assertNotNull(cap_city.getName(), "Capital City name should not be null");
            assertNotNull(cap_city.getCountry(), "Country name should not be null");

            iterationCount++;
            // only want to loop a list a bit
            if (iterationCount > 5) break;
        }
    }

    @Test
    void testGetTopNPopulatedCapitalCities() {
        // defining top N size
        int topN = 2;
        CapitalCityReporter capitalCityReporter = new CapitalCityReporter();

        // retrieves a list of top N populated capital cities in the world
        List<CapitalCity> capcityList = capitalCityReporter.getTopNPopulatedCapitalCities(con, topN);

        // returned capital city list should not be null
        assertNotNull(capcityList, "Capital City list should not be null");

        for (CapitalCity city : capcityList) {
            // each row's value should not be null
            assertNotNull(city.getName(), "Capital City name should not be null");
            assertNotNull(city.getCountry(), "Country name should not be null");
            // returned population should be greater than zero
            assertTrue(city.getPopulation() >= 0, "City population should have value");
        }
    }

    @Test
    void testGetTopNPopulatedCapitalCitiesInRegion() {
        // defining top N size
        int topN = 1;
        CapitalCityReporter capitalCityReporter = new CapitalCityReporter();

        // retrieves a list of top N populated capital cities in the specified region
        List<CapitalCity> capcityList = capitalCityReporter.getTopNPopulatedCapitalCitiesInRegion(con, regionName, topN);

        // returned capital city list should not be null
        assertNotNull(capcityList, "Capital City list should not be null");

        for (CapitalCity city : capcityList) {
            // each row's value should not be null
            assertNotNull(city.getName(), "City name should not be null");
            assertNotNull(city.getCountry(), "Country name should not be null");

            // returned population should be greater than zero
            assertTrue(city.getPopulation() >= 0, "Capital City population should have value");
        }
    }

    @Test
    void testGetTopNPopulatedCapitalCitiesInContinent() {
        // defining top N size
        int topN = 1;
        CapitalCityReporter capitalCityReporter = new CapitalCityReporter();

        // retrieves a list of top N populated cities in the specified continent
        List<CapitalCity> capcityList = capitalCityReporter.getTopNPopulatedCapitalCitiesInContinent(con, continentName, topN);

        // returned capital city list should not be null
        assertNotNull(capcityList, "Capital City list should not be null");

        for (CapitalCity city : capcityList) {
            // each row's value should not be null
            assertNotNull(city.getName(), "City name should not be null");
            assertNotNull(city.getCountry(), "Country name should not be null");

            // returned population should be greater than zero
            assertTrue(city.getPopulation() >= 0, "Capital City population should have value");
        }
    }

    /*
     * population report testing methods
     */
    @Test
    void testPopulationStaticForContinent() {
        PopulationReporter populationReporter = new PopulationReporter();

        // retrieves a list of population static for all continents
        List<Population> populationList = populationReporter.getPopulationStaticForContinent(con);

        // assuming the first row be the same as configuration.
        assertEquals("North America", populationList.get(0).getLocationName());
        assertEquals(482993000, populationList.get(0).getTotalPopulation());
        assertEquals(168250381, populationList.get(0).getPopulationInCities());
        assertEquals(314742619, populationList.get(0).getPopulationNotInCities());
        assertEquals(34.83, populationList.get(0).getPercentageInCities(), 0.01);
        assertEquals(65.17, populationList.get(0).getPercentageNotInCities(), 0.01);
    }

    @Test
    void testPopulationStaticForRegion() {
        PopulationReporter populationReporter = new PopulationReporter();

        // retrieves a list of population static for all regions
        List<Population> populationList = populationReporter.getPopulationStatisticsForRegion(con);

        // assuming the first row be the same as configuration.
        assertEquals("Caribbean", populationList.get(0).getLocationName());
        assertEquals(38140000, populationList.get(0).getTotalPopulation());
        assertEquals(11067550, populationList.get(0).getPopulationInCities());
        assertEquals(27072450, populationList.get(0).getPopulationNotInCities());
        assertEquals(29.02, populationList.get(0).getPercentageInCities(), 0.01);
        assertEquals(70.98, populationList.get(0).getPercentageNotInCities(), 0.01);
    }

    @Test
    void testPopulationStaticForCountry() {
        PopulationReporter populationReporter = new PopulationReporter();

        // retrieves a list of population static for all countries
        List<Population> populationList = populationReporter.getPopulationStatisticsForCountry(con);

        assertNotNull(populationList, "Population List for country should not be null");
        // assuming the first row be the same as configuration.
        assertEquals("Aruba", populationList.get(0).getLocationName());
        assertEquals(103000, populationList.get(0).getTotalPopulation());
        assertEquals(29034, populationList.get(0).getPopulationInCities());
        assertEquals(73966, populationList.get(0).getPopulationNotInCities());
        assertEquals(28.19, populationList.get(0).getPercentageInCities(), 0.01);
        assertEquals(71.81, populationList.get(0).getPercentageNotInCities(), 0.01);
    }

    @Test
    void testPopulationByLanguage() {
        PopulationReporter populationReporter = new PopulationReporter();

        // retrieves a list of population static for all countries
        List <Language> populationList = populationReporter.getPopulationByLanguage(con);

        // population list by language should not be null
        assertNotNull(populationList, "Population List by language should not be null");

        double prevPopulationPercentage = Double.MAX_VALUE;
        for (Language population : populationList) {
            double current_percentage = population.getPercentageInWorld();
            assertTrue(current_percentage <= prevPopulationPercentage, "population percentage should be sorted in descending order");
            prevPopulationPercentage = current_percentage;
            iterationCount++;
            // only want to loop a list a bit
            if (iterationCount > 5) break;

        }
    }

    @Test
    void testPopulationOfTheWorld() {
        PopulationReporter populationReporter = new PopulationReporter();

        // retrieves a value of the population of the world
        long population_world = populationReporter.getPopulationOfTheWorld(con);

        // population of the world should not be null
        assertNotNull(population_world, "Population of the world should not be null");
        assertEquals(6078749450L, population_world, "expected population of the world");
    }

    @Test
    void testPopulationOfTheContinent() {
        PopulationReporter populationReporter = new PopulationReporter();

        // retrieves a value of the population of the continent
        long population_continent = populationReporter.getPopulationOfContinent(con, continentName);

        // population of the continent should not be null
        assertNotNull(population_continent, "Population of the continent should not be null");
        assertEquals(3705025700L, population_continent, "expected population of the continent");
    }

    @Test
    void testPopulationOfTheRegion() {
        PopulationReporter populationReporter = new PopulationReporter();

        // retrieves a value of the population of the region
        long population_region = populationReporter.getPopulationOfRegion(con, regionName);

        // population of the region should not be null
        assertNotNull(population_region, "Population of the region should not be null");
        assertEquals(38140000L, population_region, "expected population of the region");
    }

    @Test
    void testPopulationOfTheCountry() {
        PopulationReporter populationReporter = new PopulationReporter();

        // retrieves a value of the population of the country
        long population_country = populationReporter.getPopulationOfCountryByName(con, countryName);

        // population of the country should not be null
        assertNotNull(population_country, "Population of the country should not be null");
        assertEquals(45611000L, population_country, "expected population of the country");
    }

    @Test
    void testPopulationOfTheDistrict() {
        PopulationReporter populationReporter = new PopulationReporter();

        // retrieves a value of the population of the district
        long population_district = populationReporter.getPopulationOfDistrict(con, districtName);

        // population of the district should not be null
        assertNotNull(population_district, "Population of the district should not be null");
        assertEquals(1780000L, population_district, "expected population of the district");
    }

    @Test
    void testPopulationOfTheCity() {
        PopulationReporter populationReporter = new PopulationReporter();

        // retrieves a value of the population of the city
        long population_city = populationReporter.getPopulationOfCity(con, "Taunggyi (Taunggye)");

        // population of the city should not be null
        assertNotNull(population_city, "Population of the city should not be null");
        assertEquals(131500L, population_city, "expected population of the city");
    }
}
