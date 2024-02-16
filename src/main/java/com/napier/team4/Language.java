package com.napier.team4;

/**
 * Represents statistical information about a specific language, including its name, total population of speakers,
 * and the percentage of speakers in the world.
 */
public class Language {
    /**
     * The name of the language.
     */
    private String language;

    /**
     * The total population of speakers of the language.
     */
    private long totalPopulation;

    /**
     * The percentage of speakers of the language in comparison to the total world population.
     */
    private double percentageInWorld;

    /**
     * The percentage of the population not speaking the language.
     */
    private double getPercentageNotInWorld;

    /**
     * Default constructor for the Language class.
     * Initializes all fields to their default values.
     */
    public Language() {
    }

    /**
     * Constructor to initialize a Language object with provided parameters.
     * @param language The name of the language.
     * @param totalPopulation The total population of speakers of the language.
     * @param percentageInWorld The percentage of speakers of the language in the world.
     * @param getPercentageNotInWorld The percentage of the population not speaking the language.
     */
    public Language(String language, long totalPopulation, double percentageInWorld, double getPercentageNotInWorld) {
        this.language = language;
        this.totalPopulation = totalPopulation;
        this.percentageInWorld = percentageInWorld;
        this.getPercentageNotInWorld = getPercentageNotInWorld;
    }

    /**
     * Getter for the language name.
     * @return The name of the language.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Setter for the language name.
     * @param language The name of the language.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Getter for the total population of speakers of the language.
     * @return The total population of speakers of the language.
     */
    public long getTotalPopulation() {
        return totalPopulation;
    }

    /**
     * Setter for the total population of speakers of the language.
     * @param totalPopulation The total population of speakers of the language.
     */
    public void setTotalPopulation(long totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    /**
     * Getter for the percentage of speakers of the language in comparison to the total world population.
     * @return The percentage of speakers of the language in the world.
     */
    public double getPercentageInWorld() {
        return percentageInWorld;
    }

    /**
     * Setter for the percentage of speakers of the language in comparison to the total world population.
     * @param percentageInWorld The percentage of speakers of the language in the world.
     */
    public void setPercentageInWorld(double percentageInWorld) {
        this.percentageInWorld = percentageInWorld;
    }

    /**
     * Getter for the percentage of the population not speaking the language.
     * @return The percentage of the population not speaking the language.
     */
    public double getGetPercentageNotInWorld() {
        return getPercentageNotInWorld;
    }

    /**
     * Setter for the percentage of the population not speaking the language.
     * @param getPercentageNotInWorld The percentage of the population not speaking the language.
     */
    public void setGetPercentageNotInWorld(double getPercentageNotInWorld) {
        this.getPercentageNotInWorld = getPercentageNotInWorld;
    }

    /**
     * Returns a string representation of the Language object.
     * @return A string representation of the Language object.
     */
    @Override
    public String toString() {
        return "Language{" +
                "language='" + language + '\'' +
                ", totalPopulation=" + totalPopulation +
                ", percentageInWorld=" + percentageInWorld +
                ", getPercentageNotInWorld=" + getPercentageNotInWorld +
                '}';
    }
}
