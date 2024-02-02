# USE CASE: 3. Produce a report of Countries in a Region from the largest population to the smallest

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Country Reporter*, I want *to generate a report of all the countries in a region organized by largest population to smallest* so that I *can report all the countries in a region via population sort.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains population data, the region is specified.  

### Success End Condition
A report listing countries in the specific region in descending population, is generated and ready for reporting.

### Failed End Condition
No report is produced.

### Primary Actor
Country Reporter

### Trigger
A request for a region's countries report is sent to the Country reporter.

## MAIN SUCCESS SCENARIO
1. Organization request a region's country in descending order of population.
2. Country reporter specifies the region.
3. The system extracts population information for all countries in the specified region.
4. Country reporter provides the report to the organization.

## EXTENSIONS
1. **If the region is not found**:
    1. Country reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.3