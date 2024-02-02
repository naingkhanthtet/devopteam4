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
A request for a continent's countries report is sent to the Country reporter.

## MAIN SUCCESS SCENARIO
1. Organization request a continent's countries in descending order of population.
2. Country reporter specifies the continent.
3. The system extracts population information for all countries in the specified continent.
4. Country reporter provides the report to the organization.

## EXTENSIONS
1. **If the continent is not found**:
    1. Country reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.3