
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=<InputFile> -Darg1=<OutputFile> -Darg2=<DebugValue>

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 10/03/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

LinkedHashMap for processing input file. O(1) for get() and containsKey()

Arraylist for storing results, courses, observers. O(1) for add() 
O(N) for remove (We are adding data often but not removing often)

Reference: http://infotechgems.blogspot.com/2011/11/java-collections-performance-time.html
-----------------------------------------------------------------------

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

1) Declaring Enums:
https://stackoverflow.com/questions/33430459/having-trouble-initializing-enum-type/33430468#33430468

2) Check if Enum exists:
https://stackoverflow.com/questions/1167982/check-if-enum-exists-in-java

3) Motivation to select Scanner over BufferedReader:
https://stackoverflow.com/questions/2231369/scanner-vs-bufferedreader

4) Motivation to use PrintWriter over BufferedWriter
https://stackoverflow.com/questions/1747040/difference-between-java-io-printwriter-and-java-io-bufferedwriter

5) parseDouble syntax:
https://www.tutorialspoint.com/java/lang/double_parsedouble.htm