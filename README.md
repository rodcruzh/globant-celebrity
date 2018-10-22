# Globant Celebrity

Globant Technical Test written by **Rodrigo Cruz H**

----
## Requirements
* Java 1.8
* Maven 3.3.9 or later

----
## Compile
Import project as a Maven project on your IDE (Eclipse, Intellij IDEA). It compiles automatically 

----
## Build
Build on IDE
* Project builds automatically when saved
* It locates JAR artifact on `globant-celebrity/target` directory

Build from command line
* Go to project root `globant-celebrity`
* Run `mvn clean install`

----
## Run
Run on IDE
* Right click on `GlobantCelebrityApplication` and hit Run
* Open a web navigator and go to `http://localhost:8001/csv` to execute and example for CSV functionality to find a celeb. You can later edit `data.csv` file on `src/main/resources`
* On the navigator go to `http://localhost:8001/db` to execute the search for a celeb functionality from H2 database