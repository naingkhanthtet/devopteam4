# USE CASE: 27. Produce a report of population of a continent

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Population Reporter*, I want *to generate a report of the population of a continent* so that I *can overview the population of a specific continent.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains continent, population data.

### Success End Condition
A report is available for Population reporter to provide a continent population.

### Failed End Condition
No report is produced.

### Primary Actor
Population Reporter

### Trigger
A request for a continent population.

## MAIN SUCCESS SCENARIO
1. Organization request a report of a continent population.
2. Population Reporter extracts population of a continent.
3. Population Reporter provides the report to the organization.

## EXTENSIONS
1. **If the continent, population does not exist**:
    Population Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.6