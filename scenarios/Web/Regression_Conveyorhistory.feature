Feature: Regression for Conveyor History feature

  Background:
  Launch the application through '/'

@Regression1 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Navigate to conveyor history
  Then Verify Home page is displayed
  When User clicks on Conveyor inspect
 Then User clicks on Conveyor inspect arrow
 And User clicks on Conveyor History
Then User should see conveyor history page

@Regression2 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Verify conveyor history page [Conveyor Level]
  When user clicks on conveyor view arrow
  And User clicks on Conveyor History
  Then User should see conveyor history page Conveyor level


@Regression3 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify conveyor history page [Site Level]
  When user clicks on sites and on view arrow
  And User clicks on Conveyor History
  Then User should see conveyor history page Site level

  @Regression4 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Company_Navigation
  Scenario: Verify Add button functionality
    And user clicks on conveyor view arrow
    And  User clicks on Conveyor History
    And User Should be able to see add button
    When User clicks on add button
    Then User should see dropdown with Options

  @Regression5 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Company_Navigation
  Scenario: Verify Belt failure functionality
    And User clicks on conveyor view arrow
    And  User clicks on Conveyor History
    Then User Should be able to see add button
    And User clicks on add button
    When User clicks on belt failure
    Then User should see belt failure message box

  @Regression6 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Company_Navigation
  Scenario: Verify brand & component tab
    And User clicks on conveyor view arrow
    And  User clicks on Conveyor History
    And User clicks on add button
    When User clicks on belt failure
    Then Brand & Compounds tab should display as default tab
    And User should be able to see all the content brand & compounds tab
     And User should be able to see the conveyor name
    And User should be able to enter the data into Belt Manufactured '${BeltManufactured}' text input field
    And User should be able to enter the data into Family '${Family}' text input field
    And User should be able to enter the data into Top Cover Compound '${TopCoverCompound}' text input field

  @Regression7 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Company_Navigation
  Scenario: Verify belt details tab
    And User clicks on conveyor view arrow
    And  User clicks on Conveyor History
    And User clicks on add button
    When User clicks on belt failure
    And Click on belt details tab
    Then Belt details tab should displayed
    And User should be able to see all content of belt details tab
    And User should be able to click on Fabric Type Dropdown '${FabricTypeDropdown}' and select the value
    And User should be able to click on Other Specials Dropdown '${OtherSpecialsDropdown}' and select the value
    And User should be able to click on Tension Unit Dropdown '${tensionUnitDropdown}' and select the value
    And User should be able to click on the Tension Dropdown '${Tension}' select the value
   And User should be able to click on Piles Dropdown '${PliesDropdown}' and select the value
   And User should be able to enter the data into Width '${Width}' text input field
    And User should be able to enter the data into Top Cover '${TopCover}' text input field
   And User should be able to select the data into Pulley Cover '${PulleyCover}' text input field


  @Regression8 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Company_Navigation
  Scenario: Verify Age & Failure mode tab
    And User clicks on conveyor view arrow
    And  User clicks on Conveyor History
    And User clicks on add button
    When User clicks on belt failure
    And Click on Age & Failure mode tab
    Then Age & Failure mode tab should displayed
    And User should be able to see all content of Age & Failure mode tab
    And User should be able to select the InstalledDate from calendar
    And User should be able to select the FailedDate from calendar
    And User should be able to click on Years On System '${YearsOnSystem}' text input field
    And User should be able to click on failure mode dropdown '${FailureModeDropdown}' and select the value
    And User should be able to enter the data into '${Comments}' text input field
   And Drag and drop any '${FileOrDocument}' from system to application

  @Regression9 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Company_Navigation
  Scenario: Verify cancel button
    And User clicks on conveyor view arrow
    And  User clicks on Conveyor History
    And User clicks on add button
    When User clicks on belt failure
    Then Brand & Compounds tab should display as default tab
    And User should be able to see all the content brand & compounds tab
    And User should be able to see the conveyor name
    And User should be able to enter the data into Belt Manufactured '${BeltManufactured}' text input field
    And User should be able to enter the data into Family '${Family}' text input field
    And User should be able to enter the data into Top Cover Compound '${TopCoverCompound}' text input field
   And Click on cancel button
    Then Message box should get closed


  @Regression10 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Company_Navigation
  Scenario: Verify Save button
    And User clicks on conveyor view arrow
    And  User clicks on Conveyor History
    And User clicks on add button
    When User clicks on belt failure
    And User should be able to see the conveyor name
    And User should be able to enter the data into Belt Manufactured '${BeltManufactured}' text input field
    And User should be able to enter the data into Family '${Family}' text input field
    And User should be able to enter the data into Top Cover Compound '${TopCoverCompound}' text input field
    And Click on Save button
    Then Success message should display

  @Regression12 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:ConveyorHistory_ComponentChange
  Scenario: Verify Component change functionality
    And User clicks on conveyor view arrow
    And  User clicks on Conveyor History
    When Click on add button and click on component change
    Then User Should see all the fields in the Component change message box on Conveyor History
    And User should be able to see the conveyor name
    And User should be able to click on component type dropdown '${ComponentType}' and select the value
    And User should be able to enter the data into Ref number used part '${NumberUsedPart}' text input field
    And User should be able to enter the data into Ref number new part '${NumberNewPart}' text input field
    And User should be able to enter the data into '${Comments}' text input field
    And Drag and drop any '${FileOrDocument}' from system to application
    When Click on cancel button
    Then Message box should get closed
     When Click on add button and click on component change
    And Click on close button on component change
    Then Message box should get closed
    When Click on add button and click on component change
    And Enter all details component change '${ComponentType}' and '${NumberUsedPart}' and '${NumberNewPart}' and '${Comments}' and '${FileOrDocument}'
    And Click on Save button
    Then Entered componet change details should be saved


  @Regression13 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:ConveyorHistory_CustomEvent
  Scenario: Verify custom event functionality
    And User clicks on conveyor view arrow
    And  User clicks on Conveyor History
    When Click on add button and click on custom event change
    Then User Should see all the fields in the Custom event functionality
    And User should be able to see the conveyor name
    And User should be able to enter the data into title '${title}' text input field
    And User should be able to enter the data into '${Comments}' text input field
    And Drag and drop any '${FileOrDocument}' from system to application
    When Click on cancel button
    Then Message box should get closed
    When Click on add button and click on custom event change
    And Click on close button on custom event
    Then Message box should get closed
    When Click on add button and click on custom event change
    And Enter all details custom event '${title}' and '${Comments}' and '${FileOrDocument}'
    And Click on Save button
    Then Entered Custom event details should be saved

  @Regression14 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Company_Navigation
  Scenario: Verify Actions dropdown functionality
    When user clicks on conveyor view arrow
    And User clicks on Conveyor History
    And clicks on action button
    Then Dropdown should loads with Edit and delete option

  @Regression15 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Company_Navigation
  Scenario: Verify Edit button functionality
    When user clicks on conveyor view arrow
    And User clicks on Conveyor History
    And Click on actions and click on edit button
    Then Verify edit functionality

  @Regression16 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Company_Navigation
  Scenario: Verify Delete button functionality
    When user clicks on conveyor view arrow
    And User clicks on Conveyor History
    When User clicks on any one of the event
    And Click on actions and click on delete button
    Then Verify delete button functionality

  @Regression17 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Company_Navigation
  Scenario: Verify By Author dropdown in table header
    When user clicks on conveyor view arrow
    And User clicks on Conveyor History
    When user select Author
    Then Based on author selection, records should display

  @Regression18 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Company_Navigation
  Scenario: Verify By Event dropdown in table header
    When user clicks on conveyor view arrow
    And User clicks on Conveyor History
    Then Look for By Event dropdown in table header
   Then Click on By Event dropdown
    And Click on any one event
    Then Based on event selection, records should display

  @Regression19 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Company_Navigation
  Scenario: Verify from calendar date picker
    When user clicks on conveyor view arrow
    And User clicks on Conveyor History
    When Look for from calendar date picker
    Then Click on from calendar and select any one date

  @Regression20 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Company_Navigation
  Scenario: Verify To calendar date picker
    When user clicks on conveyor view arrow
    And User clicks on Conveyor History
    When Look for to calendar date picker
    Then Click on to calendar and select any one date

  @Regression21 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Company_Navigation
  Scenario: Verify assending/desending order
    When user clicks on conveyor view arrow
    And User clicks on Conveyor History
    Then Look for ascending/descending order button
    When Click on Sort button and Records should display in ascending order
    Then Again click sort on button Records should display in descending order

  @Regression22 @Regression
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Company_Navigation
  Scenario: Verify refresh button functionality
    Given Login with '${UserName}' and '${Password}'
    When user clicks on conveyor view arrow
    And User clicks on Conveyor History
    And user select Author
    Then Refresh button is present
    When User clicks on Refresh button
    Then Page should be refreshed