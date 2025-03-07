# coding-rules-and-regulations-for-java
Explaining and demonstrating Java programming rules and regulations from the [SEI CERT Oracle Coding Standard for java](https://wiki.sei.cmu.edu/confluence/display/java/SEI+CERT+Oracle+Coding+Standard+for+Java).

## Description
Each group member was tasked with researching several rules and recommendations. We provide an example of each rule and recommendation we researched in it's own Java file.

Additionally, we combined several of these rules and recommendations in to one large program.

## Rules
The list of rules and recommendations we researched is as follows:

**Rules**
- Rule 00. Input Validation and Data Sanitization (IDS)
  - IDS01-J. Normalize strings before validating them
  - IDS03-J. Do not log unsanitized user input
- Rule 02. Expressions (EXP)
  - EXP00-J. Do not ignore values returned by methods
  - EXP02-J. Do not use the Object.equals() method to compare two arrays
- Rule 05. Object Orientation (OBJ)
  - OBJ01-J. Limit accessibility of fields
  - OBJ07-J. Sensitive classes must not let themselves be copied
  - OBJ09-J. Compare classes and not class names
  - OBJ13-J. Ensure that references to mutable objects are not exposed
- Rule 06. Methods (MET)
  - MET00-J. Validate method arguments
  - MET01-J. Never use assertions to validate method arguments
- Rule 07. Exceptional Behavior (ERR)
  - ERR02-J. Prevent exceptions while logging data
  - ERR08-J. Do not catch NullPointerException or any of its ancestors
- Rule 13. Input Output (FIO)
  - FIO02-J. Detect and handle file related errors
  - FIO14-J. Perform proper cleanup at program termination

**Recommendations**
- Rec. 05. Object Orientation (OBJ)
  - OBJ54-J. Do not attempt to help the garbage collector by setting local reference variables to null
  - OBJ55-J. Remove short-lived objects from long-lived container objects
- Rec. 06. Methods (MET)
  - MET54-J. Always provide feedback about the resulting value of a method
  - MET55-J. Return an empty array or collection instead of a null value for methods that return an array or collection
- Rec. 07. Exceptional Behavior (ERR)
  - ERR50-J. Use exceptions only for exceptional conditions
