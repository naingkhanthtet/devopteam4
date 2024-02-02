package com.napier.team4;

/**
 * Represents a country with various attributes such as code, name, continent, region,
 * population, and capital.
 */
public class Country {
    private String code;
    private String name;
    private String continent;
    private String region;
    private Integer population;
    private Integer capital;

    /**
     * Gets the country code.
     * @return The country code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the country code.
     * @param code The country code to set.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the name of the country.
     * @return The name of the country.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the country.
     * @param name The name of the country to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the continent where the country is located.
     * @return The continent of the country.
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Sets the continent where the country is located.
     * @param continent The continent to set.
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Gets the region where the country is located.
     * @return The region of the country.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the region where the country is located.
     * @param region The region to set.
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Gets the population of the country.
     * @return The population of the country.
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * Sets the population of the country.
     * @param population The population to set.
     */
    public void setPopulation(Integer population) {
        this.population = population;
    }

    /**
     * Gets the capital city of the country.
     * @return The capital city of the country.
     */
    public Integer getCapital() {
        return capital;
    }

    /**
     * Sets the capital city of the country.
     * @param capital The capital city to set.
     */
    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    /**
     * Returns a string representation of the country object.
     * @return A string representation of the country object.
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
