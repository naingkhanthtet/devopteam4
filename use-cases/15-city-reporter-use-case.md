# USE CASE: 15. Produce a report of top N populated cities in a country 

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *City Reporter*, I want *to generate a report of the top N populated cities in a country, where N is provided by the user* so that I *can set the size of the top chart for cities in a specific country and observe it.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains cities, countries and population data.

### Success End Condition
A report listing top N populated cities in a country where N is provided by a city reporter.

### Failed End Condition
No report is produced.

### Primary Actor
City Reporter

### Trigger
A request for a report of a top N populated cities in a country to the City Reporter.

## MAIN SUCCESS SCENARIO
1. Organization request a report of top N populated cities in a country.
2. City Reporter specifies the number of chart size.
3. City Reporter extracts top N populated cities in a country.
4. City Reporter provides the report to the organization.

## EXTENSIONS
1. **If the city, country, population does not exist**:
    1. City Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.4