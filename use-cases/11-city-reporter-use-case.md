# USE CASE: 11. Produce a report of cities in the district by population

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *City Reporter*, I want *to generate a report of all cities in a specific district organized by population* so that I *can analyze the cities via population sort within a particular district.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains cities, districts and population data.

### Success End Condition
A report listing cities in the district by population.

### Failed End Condition
No report is produced.

### Primary Actor
City Reporter

#### Trigger
Organization request the city reporter to export a report of cities in the district.

## MAIN SUCCESS SCENARIO
1. City reporter access the application.
2. System extracts the city in the district in descending population from the database.
3. System supplies the data to the City Reporter.

## EXTENSIONS
1. **If the city, district, population does not exist**:
    1. City Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.4