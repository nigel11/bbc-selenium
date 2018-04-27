# BBC add comment tests

### Driver.java
The Chrome driver has been setup in class Driver.java

### Hooks.java
Adds a setup and teardown for each test

### PicoContainer
Tests have been written with PicoContainer library:
- Manage States within Step Definition files
- Pass driver between step definition files

Each step definition file:
- has a constructor passing in BaseUtil
- has a local variable BaseUtil, to be used in each step definition
- variables from the State class, and methods from the BaseUtil class are passed in using 'base'.
  For example, base.driver, or base.waitFor().

### BaseUtil.java
Custom Selenium methods have been setup in BaseUtil.java
- waitFor():          Finds elements on a page
- insertText():       Inserts characters into a field
- scrollTo():         Scrolls to required element using javascript
- createUniqueText(): Creates unique text based upon current date-time to the millisecond

### State.java
Variables passed between step definitions

### RunCukesTest.java
Test Runner for project

### maven command line
Run from workspace with command 'mvn clean test'
