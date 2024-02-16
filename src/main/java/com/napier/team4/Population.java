package com.napier.team4;

/**
 * Represents population data for a continent, region, or country.
 */
public class Population {

    /**
     * The name of the continent/region/country.
     */
    private String locationName;

    /**
     * The total population.
     */
    private long totalPopulation;

    /**
     * The population living in cities.
     */
    private long populationInCities;

    /**
     * The population not living in cities.
     */
    private long populationNotInCities;

    /**
     * The percentage of the population living in cities.
     */
    private double percentageInCities;

    /**
     * The percentage of the population not living in cities.
     */
    private double percentageNotInCities;

    /**
     * Constructs a new Population object with default values.
     */
    public Population() {
    }

    /**
     * Constructs a new Population object with the specified attributes.
     *
     * @param locationName         the name of the continent/region/country
     * @param totalPopulation      the total population
     * @param populationInCities   the population living in cities
     * @param populationNotInCities the population not living in cities
     */
    public Population(String locationName, long totalPopulation, long populationInCities, long populationNotInCities, double percentageInCities, double percentageNotInCities) {
        this.locationName = locationName;
        this.totalPopulation = totalPopulation;
        this.populationInCities = populationInCities;
        this.populationNotInCities = populationNotInCities;
        this.percentageInCities = 0; // Initialize with default value
        this.percentageNotInCities = 0; // Initialize with default value
    }

    // Getters and setters for percentage values

    public double getPercentageInCities() {
        return percentageInCities;
    }

    public void setPercentageInCities(double percentageInCities) {
        this.percentageInCities = percentageInCities;
    }

    public double getPercentageNotInCities() {
        return percentageNotInCities;
    }

    public void setPercentageNotInCities(double percentageNotInCities) {
        this.percentageNotInCities = percentageNotInCities;
    }

    /**
     * Gets the name of the continent/region/country.
     *
     * @return the location name
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * Sets the name of the continent/region/country.
     *
     * @param locationName the location name to set
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * Gets the total population.
     *
     * @return the total population
     */
    public long getTotalPopulation() {
        return totalPopulation;
    }

    /**
     * Sets the total population.
     *
     * @param totalPopulation the total population to set
     */
    public void setTotalPopulation(long totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    /**
     * Gets the population living in cities.
     *
     * @return the population in cities
     */
    public long getPopulationInCities() {
        return populationInCities;
    }

    /**
     * Sets the population living in cities.
     *
     * @param populationInCities the population in cities to set
     */
    public void setPopulationInCities(long populationInCities) {
        this.populationInCities = populationInCities;
    }

    /**
     * Gets the population not living in cities.
     *
     * @return the population not in cities
     */
    public long getPopulationNotInCities() {
        return populationNotInCities;
    }

    /**
     * Sets the population not living in cities.
     *
     * @param populationNotInCities the population not in cities to set
     */
    public void setPopulationNotInCities(long populationNotInCities) {
        this.populationNotInCities = populationNotInCities;
    }

    /**
     * Returns a string representation of the Population object.
     *
     * @return a string representation of the Population object
     */
    @Override
    public String toString() {
        return "Population{" +
                "locationName='" + locationName + '\'' +
                ", totalPopulation=" + totalPopulation +
                ", populationInCities=" + populationInCities +
                ", populationNotInCities=" + populationNotInCities +
                ", percentageInCities=" + percentageInCities +
                ", percentageNotInCities=" + percentageNotInCities +
                '}';
    }
}