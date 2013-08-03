PRE REQUIRE:
0. Install Maven latest version.
1. Install Java 7 latest version.
1. Copy q1/numbers.txt to /temp/q1/numbers.txt
2. Copy q2/numbers.txt to /temp/q2/numbers.txt

OBJECTIVE:
This code does not tuning high performance but code is clear & readable.

INSTALLATION CHECK:
$ java -version
java version "1.7.0_25"
Java(TM) SE Runtime Environment (build 1.7.0_25-b15)
Java HotSpot(TM) 64-Bit Server VM (build 23.25-b01, mixed mode)

$ mvn -version
Apache Maven 3.0.3 (r1075438; 2011-03-01 00:31:09+0700)
Maven home: /usr/share/maven
Java version: 1.7.0_25, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.7.0_25.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.8.4", arch: "x86_64", family: "mac"


EXECUTION:
$ mvn test
.
.
.
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running TestSuite
12:51:45.757 [main] DEBUG com.thjug.battle.Q1 - Q1: [1, 10, 91, 97, 100, 242, 1489, 3567, 3574, 3721, 4259, 4425, 7727, 8700, 8889, 9102]
12:51:45.762 [main] INFO  com.thjug.battle.Q1 - run in 141 ms
12:51:46.180 [main] INFO  com.thjug.battle.Q2 - run in 413 ms
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.154 sec

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 4.038s
[INFO] Finished at: Sat Aug 03 12:51:46 ICT 2013
[INFO] Final Memory: 8M/141M
[INFO] ------------------------------------------------------------------------


** Execution Time capture only execution time, does not include initial jvm time.