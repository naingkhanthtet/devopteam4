# USE CASE: 24. Produce a report of population for each region including people living in cities and not

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Population Reporter*, I want *to view the population statistics for each region, including people, people living in cities, and people not living in cities* so that I *can access the population of each region who are in cities and who are not.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains cities, regions and population data.

### Success End Condition
A report of population for a region including people living in cities and not.

### Failed End Condition
No report is produced.

### Primary Actor
Population Reporter

### Trigger
Organization request the Population reporter to export a report of population for each region including people living in cities and not.

## MAIN SUCCESS SCENARIO
1. Population reporter access the application.
2. System extracts population for each region including people living in cities and not from the database.
3. System supplies the data to the Population Reporter.

## EXTENSIONS
1. **If the city, region, population does not exist**:
    Population Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.5