Feature: Regression of P1 File manager module

Background:
Launch the application through '/'

@Regression1
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: zzVerify Conveyor level with file manager navigation

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to file manager for conveyor '${CustCorp}' '${CustSiteName}' '${ConveyorName}'


@Regression2
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_DefaultFolder
Scenario: Verify Conveyor level the file manager default folders

    And   Navigate to file manager for conveyor '${ConveyorName}'
    Then  Verify default folder for conveyor level


@Regression3
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level with file manager folder creation

    And   Add Folder by the name '${FolderName}' under conveyor '${ConveyorName}'
    Then  Verify the folder created by the name '${FolderName}'


@Regression4
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level the file manager image upload


    And   Navigate to file manager for conveyor '${ConveyorName}'
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${ImgName}'


@Regression5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level the file manager video upload


    And   Navigate to file manager for conveyor '${ConveyorName}'
    When  Upload file '${videoFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${videoFile}'


@Regression6
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level the file manager document upload


    And   Navigate to file manager for conveyor '${ConveyorName}'
    When  Upload file '${pdfFile}' into the folder '${FolderName}'
    And   Verify folder '${FolderName}' and file '${pdfFile}'


@Regression7
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level for file manager rename functionality


    And   Navigate to file manager for conveyor '${ConveyorName}'
    And   Rename file with name '${ImgName}' to '${ImgNewName}' inside folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${ImgNewName}'


@Regression8
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level for file manager download folder functionality


    And   Navigate to file manager for conveyor '${ConveyorName}'
    Then  Verify Download folder by name '${FolderName}'

@Regression9
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level for file manager multiple files download functionality

    And   Navigate to file manager for conveyor '${ConveyorName}'
    Then  Verify the multi files download folder '${FolderName}'

@Regression10
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level for file manager files move functionality



    And   Navigate to file manager for conveyor '${ConveyorName}'
    And   Upload file '${ImgName}' into the folder "root"
    And   Move the file with '${ImgName}' inside folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${ImgName}'


@Regression11
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level for file manager count



    And   Navigate to file manager for conveyor '${ConveyorName}'
    Then  Verify count in the file manager tile


@Regression12
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level delete single file manager functionality


    And   Navigate to file manager for conveyor '${ConveyorName}'
    And   Delete file with name '${ImgName}' inside folder '${FolderName}'
    Then  Verify the deleted file '${ImgName}' inside folder '${FolderName}'

@Regression13
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level delete multi files file manager manager functionality


    And   Navigate to file manager for conveyor '${ConveyorName}'
    And   Delete multiple file inside folder '${FolderName}'
    Then  Verify the deleted file '${pdfFile}' inside folder '${FolderName}'
    Then  Verify the deleted file '${videoFile}' inside folder '${FolderName}'

@Regression14
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level an file manager memory functionality


    And   Navigate to file manager for conveyor '${ConveyorName}'
    Then  Verify folder '${FolderName}' memory details
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' memory details after file upload

@Regression15
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level an file manager file upload root level


    And   Navigate to file manager for conveyor '${ConveyorName}'
    When  Upload file '${pdfFile}' into the folder "root"
    Then  Verify folder "root" and file '${pdfFile}'


@Regression16
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level an file manager file delete root level


    And   Navigate to file manager for conveyor '${ConveyorName}'
    When  Delete file with name '${pdfFile}' inside folder "root"
    Then  Verify the deleted file '${pdfFile}' inside folder "root"

@Regression17
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level a file manager duplicate file check


    And   Navigate to file manager for conveyor '${ConveyorName}'
    When  Upload file '${ImgName}' into the folder "root"
    Then  Move the file with '${ImgName}' inside folder '${FolderName}'


@Regression18
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level a file manager view image

    And   Navigate to file manager for conveyor '${ConveyorName}'
    When  Open image with name '${ImgName}' inside folder '${FolderName}'


@Regression19
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify Conveyor level a file manager delete from top view

    And   Navigate to file manager for conveyor '${ConveyorName}'
    And   Delete file with name '${ImgName}' inside folder '${FolderName}'
    Then  Verify the deleted file '${ImgName}' inside folder '${FolderName}'


@Regression20
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify site level with file manager navigation

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to file manager for site '${CustSiteName}'


@Regression21
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_DefaultFolder
Scenario: ZVerify site level the file manager default folders


    And   Navigate to file manager for site '${CustSiteName}'
    Then  Verify default folder for site level


@Regression22
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify site level with file manager folder creation

    And   Add Folder by the name '${FolderName}' under site '${CustSiteName}'
    Then  Verify the folder created by the name '${FolderName}'


@Regression23
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify site level the file manager image upload

    And   Navigate to file manager for site '${CustSiteName}'
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${ImgName}'


@Regression24
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify site level the file manager video upload

    And   Navigate to file manager for site '${CustSiteName}'
    When  Upload file '${videoFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${videoFile}'


@Regression25
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify site level the file manager document upload


    And   Navigate to file manager for site '${CustSiteName}'
    When  Upload file '${pdfFile}' into the folder '${FolderName}'
    And   Verify folder '${FolderName}' and file '${pdfFile}'


@Regression26
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify site level for file manager rename functionality

    And   Navigate to file manager for site '${CustSiteName}'
    And   Rename file with name '${ImgName}' to '${ImgNewName}' inside folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${ImgNewName}'


@Regression27
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify site level for file manager download folder functionality


    And   Navigate to file manager for site '${CustSiteName}'
    Then  Verify Download folder by name '${FolderName}'

@Regression28
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify site level for file manager multiple files download functionality


    And   Navigate to file manager for site '${CustSiteName}'
    Then  Verify the multi files download folder '${FolderName}'

@Regression29
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify site level for file manager files move functionality




     And   Navigate to file manager for site '${CustSiteName}'
    And   Upload file '${ImgName}' into the folder "root"
    And   Move the file with '${ImgName}' inside folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${ImgName}'


@Regression30
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify site level for file manager count



    And   Navigate to file manager for site '${CustSiteName}'
    And   Navigate to file manager for site '${CustSiteName}'
    Then  Verify count in the file manager tile


@Regression31
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify site level delete single file manager functionality


    And   Navigate to file manager for site '${CustSiteName}'
    And   Delete file with name '${ImgName}' inside folder '${FolderName}'
    Then  Verify the deleted file '${ImgName}' inside folder '${FolderName}'

@Regression32
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify site level delete multi files file manager manager functionality


    And   Navigate to file manager for site '${CustSiteName}'
    And   Delete multiple file inside folder '${FolderName}'
    Then  Verify the deleted file '${pdfFile}' inside folder '${FolderName}'
    Then  Verify the deleted file '${videoFile}' inside folder '${FolderName}'

@Regression33
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:FileManager_Navigation
Scenario: Verify site level an file manager memory functionality

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to file manager for site '${CustSiteName}'
    Then  Verify folder '${FolderName}' memory details
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' memory details after file upload