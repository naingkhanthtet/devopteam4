# USE CASE: 17. Produce a report of all capital cities in the world in the descending population order 

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Capital City Reporter*, I want *to view a list of all capital cities in the world organized by the largest population to the smallest* so that I *can view global capital cities with the greatest population at the top.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains capital cities and population data.

### Success End Condition
A report listing capital cities in the world by the descending order of population.

### Failed End Condition
No report is produced.

### Primary Actor
Capital City Reporter

### Trigger
A request for a report of a capital cities in the world by descending population to the Capital City Reporter.

## MAIN SUCCESS SCENARIO
1. Organization request a report of capital cities in the world by descending population.
2. Capital City Reporter sort the population in the descending order.
3. Capital City Reporter extracts the capital cities in the world.
4. Capital City Reporter provides the report to the organization.

## EXTENSIONS
1. **If the capital city, population does not exist**:
    1. Capital City Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.5