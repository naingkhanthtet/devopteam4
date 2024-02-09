package com.napier.team4;

/**
 * The City class represents information about a city, including its name, country, district, and population.
 */
public class City {
    private String name;
    private String country;
    private String district;
    private int population;

    /**
     * Default constructor for the City class.
     * Initializes the City with default values:
     * - name: null
     * - country: null
     * - district: null
     * - population: 0
     */
    public City() {
        this.name = null;
        this.country = null;
        this.district = null;
        this.population = 0;
    }

    /**
     * Parameterized constructor for the City class.
     *
     * @param name       The name of the city.
     * @param country    The country where the city is located.
     * @param district   The district or region within the country.
     * @param population The population of the city.
     */
    public City(String name, String country, String district, int population) {
        this.name = name;
        this.country = country;
        this.district = district;
        this.population = population;
    }

    /**
     * Get the name of the city.
     *
     * @return The name of the city.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the city.
     *
     * @param name The name to set for the city.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the country where the city is located.
     *
     * @return The country of the city.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set the country where the city is located.
     *
     * @param country The country to set for the city.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get the district or region where the city is situated.
     *
     * @return The district of the city.
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Set the district or region where the city is situated.
     *
     * @param district The district to set for the city.
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Get the population of the city.
     *
     * @return The population of the city.
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Set the population of the city.
     *
     * @param population The population to set for the city.
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Returns a string representation of the City object.
     *
     * @return A string representation of the City object.
     */
    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}
