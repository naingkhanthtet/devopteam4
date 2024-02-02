# USE CASE: 25. Produce a report of population for each country including people living in cities and not

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Population Reporter*, I want *to view the population statistics for each country, including people, people living in cities, and people not living in cities* so that I *can access the population of each country who are in cities and who are not.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains cities, countries and population data.

### Success End Condition
A report of population for a country including people living in cities and not.

### Failed End Condition
No report is produced.

### Primary Actor
Population Reporter

### Trigger
A request for a population report of each country including citizens and non-citizens to the Population Reporter.

## MAIN SUCCESS SCENARIO
1. Organization request a report of population of each country including citizens and non-citizens.
2. Population Reporter extracts population for each country with all types of citizens.
3. Population Reporter provides the report to the organization.

## EXTENSIONS
1. **If the city, country, population does not exist**:
    Population Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.6