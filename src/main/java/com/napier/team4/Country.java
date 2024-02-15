package com.napier.team4;

/**
 * Represents a country with its attributes such as code, name, continent, region, population, and capital.
 */
public class Country {
    private String code;
    private String name;
    private String continent;
    private String region;
    private Integer population;
    private String capital;

    /**
     * Constructs a new Country object with default values.
     */
    public Country() {
    }

    /**
     * Constructs a new Country object with the specified attributes.
     *
     * @param code       the country code
     * @param name       the name of the country
     * @param continent  the continent where the country is located
     * @param region     the region within the continent
     * @param population the population of the country
     * @param capital    the capital city code of the country
     */
    public Country(String code, String name, String continent, String region, Integer population, String capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }

    /**
     * Gets the country code.
     *
     * @return the country code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the country code.
     *
     * @param code the country code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the name of the country.
     *
     * @return the name of the country
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the country.
     *
     * @param name the name of the country to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the continent where the country is located.
     *
     * @return the continent of the country
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Sets the continent where the country is located.
     *
     * @param continent the continent to set
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Gets the region within the continent.
     *
     * @return the region of the country
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the region within the continent.
     *
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Gets the population of the country.
     *
     * @return the population of the country
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * Sets the population of the country.
     *
     * @param population the population to set
     */
    public void setPopulation(Integer population) {
        this.population = population;
    }

    /**
     * Gets the capital city code of the country.
     *
     * @return the capital city code
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Sets the capital city code of the country.
     *
     * @param capital the capital city code to set
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * Returns a string representation of the Country object.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", population=" + population +
                ", capital=" + capital +
                '}';
    }
}
