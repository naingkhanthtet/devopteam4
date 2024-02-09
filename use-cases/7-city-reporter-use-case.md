# USE CASE: 7. Produce a report of cities in the world in descending population

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *City Reporter*, I want *to generate a list of all cities in the world organized by the largest population to the smallest* so that I *can explore global cities via population sort.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains cities and population data.

### Success End Condition
A report listing cities in the world in descending population.

### Failed End Condition
No report is produced.

### Primary Actor
City Reporter

#### Trigger
Organization request the city reporter to export a report of cities in the world.

## MAIN SUCCESS SCENARIO
1. City reporter access the application.
2. System extracts the city in the world descending population from the database.
3. System supplies the data to the City Reporter.

## EXTENSIONS
1. **If the city does not exist**:
    1. City Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.3