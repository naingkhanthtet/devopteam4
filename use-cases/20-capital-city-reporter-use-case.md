# USE CASE: 20. Produce a report of top N populated capital cities in the world

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Capital City Reporter*, I want *to generate a report of the top N populated capital cities in the world, where N is provided by the user* so that I *can set the size of the top chart for the world population and observe it.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains capital cities, and population data.

### Success End Condition
A report listing top N populated capital cities in the world where N is provided by a Capital city reporter.

### Failed End Condition
No report is produced.

### Primary Actor
Capital City Reporter

### Trigger
Organization request the capital city reporter to export a report of top N populated capital cities in the world.

## MAIN SUCCESS SCENARIO
1. Capital City reporter access the application.
2. System extracts top N populated capital cities in the world from the database.
3. System supplies the data to the Capital City Reporter.

## EXTENSIONS
1. **If the capital city, population does not exist**:
   1. Capital City Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.5