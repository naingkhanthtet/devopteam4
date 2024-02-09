# USE CASE: 26. Produce a report of population of the world

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Population Reporter*, I want *to generate a report of the population of the world* so that I *can overview the global population.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains population data.

### Success End Condition
A report is available for Population reporter to provide the world population.

### Failed End Condition
No report is produced.

### Primary Actor
Population Reporter

### Trigger
Organization request the Population reporter to export a report of population of the world.

## MAIN SUCCESS SCENARIO
1. Population reporter access the application.
2. System extracts population of the world from the database.
3. System supplies the data to the Population Reporter.

## EXTENSIONS
1. **If the population does not exist**:
    Population Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.6