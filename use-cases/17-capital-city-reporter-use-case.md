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
Organization request the capital city reporter to export a report of all capital city in the world in the descending population order.

## MAIN SUCCESS SCENARIO
1. Capital city reporter access the application.
2. System extracts all capital cities in the world in the descending population order from the database.
3. System supplies the data to the Capital city Reporter.


## EXTENSIONS
1. **If the capital city, population does not exist**:
    1. Capital City Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.5