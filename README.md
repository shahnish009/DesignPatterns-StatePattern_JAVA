
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD -Darg3=FOURTH -Darg4=FIFTH

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

Implemented methods registerObserver(...), removeObserver(...), 
notifyAll(...), update(...) from respective interfaces SubjectI and 
ObjectI. 
deleteCourse(...) in TreeBuilder.java class calls the notifyAll(...) 
method after each line of delete file is processed (i.e. each time the
courses are updated.
backup_Node_1 and backup_Node_2 are created as clones of node_orig and
are registered as observers from Driver.java class.
clone(...) method is implemented in Node.java class which is called
from Driver.java class.

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

1) Iterating over arraylist to check if course is already present:
https://stackoverflow.com/questions/8284936/java-see-if-arraylist-contains-string?rq=1

2) Get all keys from HashMap:
https://stackoverflow.com/questions/10462819/get-keys-from-hashmap-in-java

3) Motivation to use LinkedHashMap over HashMap and it's implementation:
https://stackoverflow.com/questions/10710193/how-to-preserve-insertion-order-in-hashmap
http://docs.oracle.com/javase/6/docs/api/java/util/LinkedHashMap.html

4) Binary Search Tree implementation references:
http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
http://www.sanfoundry.com/java-program-implement-binary-search-tree/

5) Convert ArrayList to String:
https://www.dotnetperls.com/convert-arraylist-string-java

6) Motivation to select Scanner over BufferedReader:
https://stackoverflow.com/questions/2231369/scanner-vs-bufferedreader

7) Motivation to use PrintWriter over BufferedWriter
https://stackoverflow.com/questions/1747040/difference-between-java-io-printwriter-and-java-io-bufferedwriter