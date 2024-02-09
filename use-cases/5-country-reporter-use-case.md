# USE CASE: 5. Produce a report of top N populated countries in the continent

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Country Reporter*, I want *to generate a report of the top N populated countries in a continent, where N is provided by the user* so that I *can quickly identify the most populated countries within a particular continent.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains population data.

### Success End Condition
A report listing top populated countries in the specific continent where the Country reporter can provide number of chart size.

### Failed End Condition
No report is produced.

### Primary Actor
Country Reporter

#### Trigger
Organization request the country reporter to export a report of top N populated countries in the continent.

## MAIN SUCCESS SCENARIO
1. Country reporter access the application.
2. System extracts the top N populated countries in the continent from the database.
3. System supplies the data to the Country Reporter.


## EXTENSIONS
1. **If the population is not available**:
    1. Country reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.3