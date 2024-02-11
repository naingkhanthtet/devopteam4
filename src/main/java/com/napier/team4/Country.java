package com.napier.team4;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

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
