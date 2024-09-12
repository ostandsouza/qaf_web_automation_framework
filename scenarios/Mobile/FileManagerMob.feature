@Regression1 @CTCP-2143
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_FileManager
Scenario:  Verify delete folder or file functionality via long press

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    And Navigate to file manager for the conveyor '${ConveyorName}'
    And Look for files/folders and long press on a file and very it is selected
    And Look for the popup displayed in footer and verify share move delete and cancel buttons are visible
    And Delete the file/folder '${FileName}' for the conveyor '${ConveyorName}' and verify it is deleted

@Regression2 @CTCP-2145
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_FileManager
Scenario:  Verify move folder or file functionality via long press

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    And Navigate to file manager for the conveyor '${ConveyorName}'
    And Look for files/folders and long press on a file and very it is selected
    And Look for the popup displayed in footer and verify share move delete and cancel buttons are visible
    And Click on move option and verify the popup with paste and cancel options are visible
    And Navigate to the file/folder where you want to paste the file/folder
    And Click on paste button and verify the selected file/folder is moved to the destination folder

