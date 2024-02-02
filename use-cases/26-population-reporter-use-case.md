# USE CASE: 26. Produce a report of population of the world

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Population Reporter*, I want *to generate a report of the population of the world* so that I *can overview the global population.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains population data.

### Success End Condition
A report is available for Population reporter to provide the world population.

### Failed End Condition
No report is produced.

### Primary Actor
Population Reporter

### Trigger
A request for a world population.

## MAIN SUCCESS SCENARIO
1. Organization request a report of world population.
2. Population Reporter extracts population of the world.
3. Population Reporter provides the report to the organization.

## EXTENSIONS
1. **If the population does not exist**:
    Population Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.6