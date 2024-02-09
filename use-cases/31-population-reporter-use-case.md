# USE CASE: 31. Produce a report of population of a city

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Population Reporter*, I want *to generate a report of the population of a city* so that I *can overview the population of a specific city.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains city, population data.

### Success End Condition
A report is available for Population reporter to provide a city population.

### Failed End Condition
No report is produced.

### Primary Actor
Population Reporter

### Trigger
Organization request the Population reporter to export a report of population of the city.

## MAIN SUCCESS SCENARIO
1. Population reporter access the application.
2. System extracts population of the city from the database.
3. System supplies the data to the Population Reporter.

## EXTENSIONS
1. **If the city, population does not exist**:
    Population Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.6