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
10. Handled chromedriver -v111 issue

# Proposed changes
1. Selenium library version updation - DONE
2. Focus on framework methods helps in faster development - PROGRESS
3. Driver dependency can be removed by bumping the lib version - QAF has open issue after selenium 4.3.0
4. Cleaning the code. PROGRESS
5. Before/After hooks - DONE
6. Convert Test Data Excel to json/yml 
7. Add API calling functionality - DONE
8. CDP integration - NOT POSSIBLE
9. Testcases continuous run Fix - PENDING
