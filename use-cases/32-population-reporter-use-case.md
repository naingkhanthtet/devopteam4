# USE CASE: 32. Produce a report of world Population percentage within the language speakers in the descending order of population.

## CHARACTERISTIC INFORMATION

### Goal in Context
As a *Population Reporter*, I want *to generate a report of the number of people who speak the following languages from greatest number to smallest, including the percentage of the world population* so that I *can access the overall world population percentage of specific language speakers from high to low.*

### Scope
World Population Reporting System

### Level
Primary task.

### Preconditions
The World Database contains Language, Percentage data.

### Success End Condition
A report is available for Population reporter to provide the world population percentage of language speakers in the descending order of population.

### Failed End Condition
No report is produced.

### Primary Actor
Population Reporter

### Trigger
Organization request the Population reporter to export a report of world Population percentage within the language speakers in the descending order of population.

## MAIN SUCCESS SCENARIO
1. Population reporter access the application.
2. System extracts world Population percentage within the language speakers in the descending order of population. from the database.
3. System supplies the data to the Population Reporter.

## EXTENSIONS
1. **If the language, percentage does not exist**:
    Population Reporter informs the organization about the unavailability of world database.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE**: Release 0.1.0.6