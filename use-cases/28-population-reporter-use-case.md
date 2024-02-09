# USE CASE: 28. Produce a report of population of a region

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Population Reporter*, I want *to generate a report of the population of a region* so that I *can overview the population of a specific region.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains region, population data.

### Success End Condition
A report is available for Population reporter to provide a region population.

### Failed End Condition
No report is produced.

### Primary Actor
Population Reporter

### Trigger
Organization request the Population reporter to export a report of population of the region.

## MAIN SUCCESS SCENARIO
1. Population reporter access the application.
2. System extracts population of the region from the database.
3. System supplies the data to the Population Reporter.

## EXTENSIONS
1. **If the region, population does not exist**:
    Population Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.6