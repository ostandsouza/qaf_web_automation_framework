# Automation Framework

Maven directory structure:
 
The 'config' directory contains testng.xml file, and is a place holder for configuration files.

The 'resources' directory contains all required resources including properties files and data files, and is a place holder for other resources.

The 'src' directory contains all java files and is a place holder for other java files.

The 'test-results' directory contains result files.

The 'scenarios' directory is the default place holder for all the scenario files. 


To change/modify dependencies check pom.xml
To run the project, from command prompt go to project home and run mvn. Open dashboard.htm to view results.

# Automation Fixes:
1. com.web.component directory is missing
2. removed "AddressComponent" elements from page classes
3. chromedriver for mac is copied into drivers
4. updated the application.properties to run on chrome
5. Added implicit and explicit wait methods in Base class
6. Removed hard waits and added dynamic waits
7. Update the locators at several places
8. Test Data not present for several steps
9. Feature file and steps file are updated to be in sync.

# Proposed changes
1. Selenium library version updation
2. Focus on framework methods helps in faster development
3. Driver dependency can be removed by bumping the lib version
4. Cleaning the code.
