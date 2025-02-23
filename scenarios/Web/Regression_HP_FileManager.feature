
  @Regression11
  @dataFile:resources/data/FileManagerRegressionHP.json
  Scenario: Verify user navigate to file manager from site level, verify the bread crumb, verify default folder displayed for all conveyors,  Create folder, add files inside the folder (upload image, pdf, video, csv, word, excel), validate the count is incremented based on total files uploaded.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    Then  Navigate to file manager for site '${Market_FM_SiteName}'
    And Verify the breadcrumb of the page for file manager at '${CustCorp}' '${Market_FM_SiteName}' '${Market_FM_ConveyorName1}' level
    And Verify default folder for site level
    When  Add Folder by the name '${FolderName}' under site '${Market_FM_SiteName}'
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${ImgName}'
    When  Upload file '${pdfFile}' into the folder "root"
    And   Move the file with '${pdfFile}' inside folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${pdfFile}'
    When  Upload file '${videoFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${videoFile}'
    When  Upload file '${csvFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${csvFile}'
    When  Upload file '${wordFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${wordFile}'
    When  Upload file '${excelFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${excelFile}'
    And Verify count in the file manager tile

  @Regression12
  @dataFile:resources/data/FileManagerRegressionHP.json
  Scenario: Verify user navigate to file manager from conveyor level, verify the bread crumb, verify default folder displayed for all conveyors,  Create folder, add files inside the folder (upload image, pdf, video, csv, word, excel), validate the count is incremented based on total files uploaded.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    Then  Navigate to file manager for conveyor '${CustCorp}' '${Market_FM_SiteName}' '${Market_FM_ConveyorName}'
    And Verify the breadcrumb of the page for file manager at '${CustCorp}' '${Market_FM_SiteName}' '${Market_FM_ConveyorName}' level
    And Verify default folder for conveyor level
    When  Add Folder by the name '${FolderName}' under conveyor '${Market_FM_ConveyorName}'
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${ImgName}'
    When  Upload file '${pdfFile}' into the folder "root"
    And   Move the file with '${pdfFile}' inside folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${pdfFile}'
    When  Upload file '${videoFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${videoFile}'
    When  Upload file '${csvFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${csvFile}'
    When  Upload file '${wordFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${wordFile}'
    When  Upload file '${excelFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${excelFile}'
    And Verify count in the file manager tile


  @Regression13
  @dataFile:resources/data/FileManagerRegressionHP.json
  Scenario:  Verify file manager card count is not updated when multiple folders created and validate the count of file manager in site and conveyor level.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And   Navigate to file manager for conveyor '${Market_FMD_ConveyorName}'
    And Extract the main card count in '${ConveyorLevel}' page for '${FileManager}'
    When  Add Folder by the name '${FolderName}' under conveyor '${Market_FMD_ConveyorName}'
    When  Add Folder by the name '${FolderName1}' under conveyor '${Market_FMD_ConveyorName}'
    And Verify the main card count after operation '${Edit}' for '${FileManager}' with count '${multipleValue}' at module level '${ConveyorLevel}'
    Then  Navigate to file manager for conveyor '${CustCorp}' '${Market_FM_SiteName}' '${Market_FM_ConveyorName}'
    And Verify count in the file manager tile
    And Click on site name '${Market_FM_SiteName}' in breadcrumb anf verify it navigates to site page
    And Verify count in the file manager tile


  @Regression14
  @dataFile:resources/data/FileManagerRegressionHP.json
  Scenario:  Verify the user should be able to move the folder from one folder to another folder, move files from one folder to another folder,validate folder and files are moved, rename the folder & files and validate files are renamed and delete multiple file and folders from conveyor level and count should be updated accordingly.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And   Navigate to file manager for conveyor '${Market_FM_ConveyorName2}'
    When  Add Folder by the name '${FolderName1}' under conveyor '${Market_FM_ConveyorName2}'
    When  Add Folder by the name '${FolderName2}' under conveyor '${Market_FM_ConveyorName2}'
    And   Upload file '${ImgName}' into the folder '${FolderName2}'
    Then  Verify folder '${FolderName2}' and file '${ImgName}'
    When  Upload file '${pdfFile}' into the folder "root"
    And   Move the file with '${pdfFile}' inside folder '${FolderName2}'
    Then  Verify folder '${FolderName2}' and file '${pdfFile}'
    When  Add Folder by the name '${FolderNameNested}' inside the folder '${FolderName1}'
    And Click on the folder '${FolderName1}'
    And   Move the file with '${FolderNameNested}' inside folder '${FolderName2}'
    Then  Verify folder '${FolderName2}' and file '${FolderNameNested}'
    And   Rename file with name '${FolderNameNested}' to '${FolderNameNestedNew}' inside folder '${FolderName2}'
    Then  Verify folder '${FolderName2}' and file '${FolderNameNestedNew}'
    And   Rename file with name '${pdfFile}' to '${pdfFileNew}' inside folder '${FolderName2}'
    Then  Verify folder '${FolderName2}' and file '${pdfFileNew}'
    And Extract the main card count in '${ConveyorLevel}' page for '${FileManager}'
    And   Delete multiple file inside folder '${FolderName2}'
    Then  Verify the deleted file '${pdfFileNew}' inside folder '${FolderName2}'
    Then  Verify the deleted file '${FolderNameNestedNew}' inside folder '${FolderName2}'
    And Verify the main card count after operation '${Deletion}' for '${FileManager}' with count '${multipleValue}' at module level '${ConveyorLevel}'


  @Regression15
  @dataFile:resources/data/FileManagerRegressionHP.json
  Scenario:  Verify user should be able to preview and download the uploaded files,multiple downloads should be allowed, duplicate files should not be uploaded,default folders should not be deleted, from site and conveyor level.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And   Navigate to file manager for conveyor '${Market_FM_ConveyorName}'
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    When  Open image with name '${ImgName}' inside folder '${FolderName}'
    And Open file with name '${videoFile}' inside folder '${FolderName}'
    And Open file with name '${wordFile}' inside folder '${FolderName}'
    And Open file with name '${excelFile}' inside folder '${FolderName}'
    And Open file with name '${csvFile}' inside folder '${FolderName}'
    Then  Verify the multi files download folder '${FolderName}'
    When  Delete the folder '${defaultFolder}' and verify default folders cannot be deleted

    Then  Navigate to file manager for site '${Market_FM_SiteName}'
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    When  Open image with name '${ImgName}' inside folder '${FolderName}'
    And Open file with name '${videoFile}' inside folder '${FolderName}'
    And Open file with name '${wordFile}' inside folder '${FolderName}'
    And Open file with name '${excelFile}' inside folder '${FolderName}'
    And Open file with name '${csvFile}' inside folder '${FolderName}'
    Then  Verify the multi files download folder '${FolderName}'
    When  Delete the folder '${defaultFolder}' and verify default folders cannot be deleted











