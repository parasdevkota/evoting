# evoting
A desktop application written in java which aims to replace the traditional paper based voting system. Evoting can be used on a scale of simple classroom elections to larger level elections however, the voters must come to the polling booth to cast their votes.
## Tools Used
The development will be done with Java, databases managed with Wampserver, and files are built using ant.
1. [Java Development Kit] (http://www.oracle.com/technetwork/java/javase/downloads/index.html) : For the development and running of the files
2. [Wampserver] (https://sourceforge.net/projects/wampserver/) : To manage the database of the system
3. [Apache Ant] (https://ant.apache.org/bindownload.cgi) : To build the binary files faster
### Predecessor Dependencies:
 1. Create JAVA_HOME system variable with path to jdk directory inside java installation as the value. usually C:\Program Files\Java\jdk1.8.0_144
 2. Set the path of bin folder of jdk directory. usually C:\Program Files\Java\jdk1.8.0_144\bin
 3. Create ANT_HOME system variable with path of ant directory as the value. 
 4. Set the path of bin folder of ant directory.
 5. Finally add %ANT_HOME%\bin on the path of System variables.
## Compilation and Execution
```
on the command prompt with the particular directory
ant compile jar run
or
ant

 

