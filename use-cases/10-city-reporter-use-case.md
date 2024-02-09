# USE CASE: 10. Produce a report of cities in the country by population

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *City Reporter*, I want *to generate a report of all cities in a specific country organized by population* so that I *can analyze the cities via population sort within a particular country.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains cities, countries and population data.

### Success End Condition
A report listing cities in the country by population.

### Failed End Condition
No report is produced.

### Primary Actor
City Reporter

#### Trigger
Organization request the city reporter to export a report of cities in the country.

## MAIN SUCCESS SCENARIO
1. City reporter access the application.
2. System extracts the city in the country in descending population from the database.
3. System supplies the data to the City Reporter.

## EXTENSIONS
1. **If the city, country, population does not exist**:
    1. City Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.4