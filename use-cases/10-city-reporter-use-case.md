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

### Trigger
A request for a report of a specific country's cities list by population is sent to the City Reporter.

## MAIN SUCCESS SCENARIO
1. Organization request a report of country's cities list.
2. City Reporter extracts all cities in the specific country.
3. City Reporter provides the report to the organization.

## EXTENSIONS
1. **If the city, country, population does not exist**:
    1. City Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.4