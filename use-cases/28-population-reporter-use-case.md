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
A request for a region population.

## MAIN SUCCESS SCENARIO
1. Organization request a report of a region population.
2. Population Reporter extracts population of a region.
3. Population Reporter provides the report to the organization.

## EXTENSIONS
1. **If the region, population does not exist**:
    Population Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.6