# coding-rules-and-regulations-for-java
Explaining and demonstrating Java programming rules and regulations from the [SEI CERT Oracle Coding Standard for java](https://wiki.sei.cmu.edu/confluence/display/java/SEI+CERT+Oracle+Coding+Standard+for+Java).

## Description
Each group member was tasked with researching several rules and recommendations. We provide an example of each rule and recommendation we researched in it's own Java file.

Additionally, we combined several of these rules and recommendations into one large program.

## Rules
The list of rules and recommendations we researched is as follows:

**Rules**
- Rule 00. Input Validation and Data Sanitization (IDS)
  - IDS01-J. Normalize strings before validating them
  - IDS03-J. Do not log unsanitized user input
  - IDS07-J. Sanitize untrusted data passed to the Runtime.exec() method
  - IDS11-J. Perform any string modifications before validation
- Rule 02. Expressions (EXP)
  - EXP00-J. Do not ignore values returned by methods
  - EXP02-J. Do not use the Object.equals() method to compare two arrays
- Rule 05. Object Orientation (OBJ)
  - OBJ01-J. Limit accessibility of fields
  - OBJ04-J. Provide mutable classes with copy functionality to safely allow passing instances to untrusted code
  - OBJ05-J. Do not return references to private mutable class members
  - OBJ07-J. Sensitive classes must not let themselves be copied
  - OBJ08-J. Do not expose private members of an outer class from within a nested class
  - OBJ09-J. Compare classes and not class names
  - OBJ10-J. Do not use public static nonfinal fields
  - OBJ13-J. Ensure that references to mutable objects are not exposed
- Rule 06. Methods (MET)
  - MET00-J. Validate method arguments
  - MET01-J. Never use assertions to validate method arguments
  - MET06-J. Do not invoke overridable methods in clone()
- Rule 07. Exceptional Behavior (ERR)
  - ERR02-J. Prevent exceptions while logging data
  - ERR08-J. Do not catch NullPointerException or any of its ancestors
- Rule 13. Input Output (FIO)
  - FIO02-J. Detect and handle file related errors
  - FIO14-J. Perform proper cleanup at program termination

**Recommendations**
- Rec. 01. Declarations and Initialization (DCL)
  - DCL50-J. Use visually distinct identifiers
- Rec. 05. Object Orientation (OBJ)
  - OBJ50-J. Never confuse the immutability of a reference with that of the referenced object
  - OBJ51-J. Minimize the accessibility of classes and their members
  - OBJ54-J. Do not attempt to help the garbage collector by setting local reference variables to null
  - OBJ55-J. Remove short-lived objects from long-lived container objects
  - OBJ56-J. Provide sensitive mutable classes with unmodifiable wrappers
- Rec. 06. Methods (MET)
  - MET54-J. Always provide feedback about the resulting value of a method
  - MET55-J. Return an empty array or collection instead of a null value for methods that return an array or collection
  - MET56-J. Do not use Object.equals() to compare cryptographic keys
- Rec. 07. Exceptional Behavior (ERR)
  - ERR50-J. Use exceptions only for exceptional conditions
  - ERR51-J. Prefer user-defined exceptions over more general exception types
  - ERR53-J. Try to gracefully recover from system errors
