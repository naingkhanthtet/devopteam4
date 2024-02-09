# USE CASE: 1. Produce a report of all countries from largest population to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Country Reporter*, I want *to generate a report of all the countries in the world organized by largest population to smallest* so that I *can report all the countries in the world via population sort.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
World Database contains world country population data.  

### Success End Condition
A report listing all countries in the world, sorted by population, is generated and ready for reporting.

### Failed End Condition
No report is produced.

### Primary Actor
Country Reporter

### Trigger
Organization request the country reporter to export a report of world country population.

## MAIN SUCCESS SCENARIO
1. Country reporter access the application.
2. System extracts the data from world database.
3. System supplies the data to the Country Reporter.

## EXTENSIONS
1. **If the database is inaccessible**:
    1. Country report informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.3