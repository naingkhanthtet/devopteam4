package com.napier.team4;

/**
 * The CapitalCity class represents information about a capital city,
 * including its name, country, and population.
 */
public class CapitalCity {
    private String name;
    private String country;
    private Integer population;

    /**
     * Default constructor for the CapitalCity class.
     */
    public CapitalCity() {
    }

    /**
     * Parameterized constructor for the CapitalCity class.
     *
     * @param name       The name of the capital city.
     * @param country    The country to which the capital city belongs.
     * @param population The population of the capital city.
     */
    public CapitalCity(String name, String country, Integer population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    /**
     * Get the name of the capital city.
     *
     * @return The name of the capital city.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the capital city.
     *
     * @param name The new name of the capital city.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the country to which the capital city belongs.
     *
     * @return The country of the capital city.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set the country to which the capital city belongs.
     *
     * @param country The new country of the capital city.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get the population of the capital city.
     *
     * @return The population of the capital city.
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * Set the population of the capital city.
     *
     * @param population The new population of the capital city.
     */
    public void setPopulation(Integer population) {
        this.population = population;
    }

    /**
     * Returns a string representation of the CapitalCity object.
     *
     * @return A string containing the name, country, and population of the capital city.
     */
    @Override
    public String toString() {
        return "CapitalCity{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", population=" + population +
                '}';
    }
}
