# DesignPatterns-StatePattern_JAVA

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
ant -buildfile src/build.xml run -Darg0=<InputFile> -Darg1=<OutputFile> -Darg2=<DebugValue>

-----------------------------------------------------------------------
## Data Structures:

Arraylist for storing results, OperationID. O(1) for add() O(N) for 
remove (We are adding data often but not removing often)

-----------------------------------------------------------------------
SecurityFactors.java is the context class. HighRisk.java , LowRisk.java
 , ModerateRisk.java are the state classes. Whenever the condition of 
 the state satisfies, state is changed.
 
-----------------------------------------------------------------------

References and Citations:

1) Declaring Enums:
https://stackoverflow.com/questions/33430459/having-trouble-initializing-enum-type/33430468#33430468

2) Check if Enum exists:
https://stackoverflow.com/questions/1167982/check-if-enum-exists-in-java

3) parseDouble syntax:
https://www.tutorialspoint.com/java/lang/double_parsedouble.htm

4) Reference for main structure of state classes and context class:
Head First Design Patterns
