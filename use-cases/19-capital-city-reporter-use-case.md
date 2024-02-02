# USE CASE: 19. Produce a report of all capital cities in a region by population. 

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Capital City Reporter*, I want *to generate a report of all capital cities in a specific region organized by population* so that I *can view specific region’s capital cities via population sort.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains capital cities, regions and population data.

### Success End Condition
A report listing capital cities in a region by the population.

### Failed End Condition
No report is produced.

### Primary Actor
Capital City Reporter

### Trigger
A request for a report of a capital cities in a region by population to the Capital City Reporter.

## MAIN SUCCESS SCENARIO
1. Organization request a report of capital cities in a region by population.
2. Capital City Reporter sort the population.
3. Capital City Reporter extracts the capital cities in a region.
4. Capital City Reporter provides the report to the organization.

## EXTENSIONS
1. **If the capital city, region, population does not exist**:
    1. Capital City Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.5