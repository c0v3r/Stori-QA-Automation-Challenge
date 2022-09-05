Environment details:
1 - Linux.
2 - 64 bits.
3 - Language: Java.
4- JDK: 1.8
5 - IDE: IntelliJ IDEA Community Edition.
6 - Create a folder with the name bin at the root of the project.
7 - Download and save the geckodriver and chromedriver binaries in the bin folder.
8 - Go to Configuration.properties file (src/test/resources/allure.properties) 
  and enter the name of the downloaded files (geckodriver and chromedriver, point 7).

Run tests with Chrome:
1 - mvn clean test -Dbrowser=CH allure:report

Run tests with FireFox:
1 - mvn clean test -Dbrowser=FF allure:report

Generate test report:
2 - mvn allure:serve