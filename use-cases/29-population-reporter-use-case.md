# USE CASE: 29. Produce a report of population of a country

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Population Reporter*, I want *to generate a report of the population of a country* so that I *can overview the population of a specific country.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains country, population data.

### Success End Condition
A report is available for Population reporter to provide a country population.

### Failed End Condition
No report is produced.

### Primary Actor
Population Reporter

### Trigger
A request for a country population.

## MAIN SUCCESS SCENARIO
1. Organization request a report of a country population.
2. Population Reporter extracts population of a country.
3. Population Reporter provides the report to the organization.

## EXTENSIONS
1. **If the country, population does not exist**:
    Population Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.6