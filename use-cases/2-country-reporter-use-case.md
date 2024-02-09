# USE CASE: 2. Produce a report of Countries in a Continent from the largest population to the smallest

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Country Reporter*, I want *to generate a report of all the countries in a continent organized by largest population to smallest* so that I *can report all the countries in a continent via population sort.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains population data, the continent is specified.  

### Success End Condition
A report listing countries in the specific continent in descending population, is generated and ready for reporting.

### Failed End Condition
No report is produced.

### Primary Actor
Country Reporter

### Trigger
Organization request the country reporter to export a report of a continent's countries.

## MAIN SUCCESS SCENARIO
1. Country reporter access the application.
2. System extracts the population information for all countries in the specified continent from the database.
3. System supplies the data to the Country Reporter.

## EXTENSIONS
1. **If the continent is not found**:
    1. Country reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.3