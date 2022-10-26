# Automation Job Scheduler
Utility program to optimally schedule the automation jobs 


# Prerequisites
- Required Java 11 (AWS Corretto 11 - OpenJDK) -
  download [here](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html "here")
- Maven (any latest version) - download [here](https://maven.apache.org/download.cgi "here")
- Install any java based IDE ; eclipse IDE => (https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers)

# How to run
- Checkout the code
- Do `mvn clean install`
- To run the application, open the `AutomationJobSchedulerSpringBootApp.java` file, and run it as **Java Application**.
- Navigate to localhost:8085/index.html in browser, and click on starting solving option
- through rest client (postman), make GET request with localhost:8085/timeTable and verify the solverStatus and score value, if the score reaches 0hard, then it denotes that solution is converged, in this case, we can click on "Stop solving button" in UI
- once the problem is solved, UI gets updated with job schedule.

<img width="884" alt="image" src="https://user-images.githubusercontent.com/95862290/198037161-f3abb1d3-01fc-41f7-b7dc-0bf3dd32df02.png">

