# USE CASE: 21. Produce a report of top N populated capital cities in a continent

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Capital City Reporter*, I want *to generate a report of the top N populated capital cities in a continent, where N is provided by the user* so that I *can set the size of the top chart for a specific continent population and observe it.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains capital cities, continents, and population data.

### Success End Condition
A report listing top N populated capital cities in a continent where N is provided by a Capital city reporter.

### Failed End Condition
No report is produced.

### Primary Actor
Capital City Reporter

### Trigger
A request for a report of a top N populated capital cities in a continent to the Capital City Reporter.

## MAIN SUCCESS SCENARIO
1. Organization request a report of top N populated capital cities in a continent.
2. Capital City Reporter specifies the number of chart size.
3. Capital City Reporter extracts top N populated capital cities in a continent.
4. Capital City Reporter provides the report to the organization.

## EXTENSIONS
1. **If the capital city, continent, population does not exist**:
   1. Capital City Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.5