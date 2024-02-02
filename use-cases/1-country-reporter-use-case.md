# USE CASE: Produce a report of all countries from largest population to smallest

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
A request for a world country population report is sent to the Country reporter.

## MAIN SUCCESS SCENARIO
1. The Organization request world country population.
2. Country reporter access population data for all countries.
3. The system sorts countries by population from largest to smallest.
4. Country reporter provides report to the organization.

## EXTENSIONS
1. **If the database is inaccessible**:
    1. Country report informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.3