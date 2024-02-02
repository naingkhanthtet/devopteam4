# USE CASE: 9. Produce a report of cities in the region by population

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *City Reporter*, I want *to generate a report of all cities in a specific region organized by population* so that I *can analyze the cities via population sort within a particular region.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains cities, regions and population data.

### Success End Condition
A report listing cities in the region by population.

### Failed End Condition
No report is produced.

### Primary Actor
City Reporter

### Trigger
A request for a report of a specific region's cities list by population is sent to the City Reporter.

## MAIN SUCCESS SCENARIO
1. Organization request a report of region's cities list.
2. City Reporter extracts all cities in the specific region.
3. City Reporter provides the report to the organization.

## EXTENSIONS
1. **If the city, region, population does not exist**:
    1. City Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.4