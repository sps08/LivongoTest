# POC - Test Automation Framework


Pre requisite:
1. Java environment
2. Maven should be installed


Points:
1. testng is used for test case execution
2. extent report is used to generate reports.
3. properties files is used to store environment related  config.
4. Page factory design pattern is used to capture web page elements.
5. Singleton design pattern is used to create webdriver object.


steps: 

1. git clone https://github.com/sps08/LivongoTest.git
2. mvn clean test -DsuiteXmlFile=testng.xml


Framework will generate the Extent report with Screenshots.
