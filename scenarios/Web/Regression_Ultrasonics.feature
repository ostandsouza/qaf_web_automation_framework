Feature: Regression of P1 Ultrasonics module

Background:
Launch the application through '/'

@Regression1
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Navigation
Scenario: Verify with the cover wear navigation

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to cover wear listing screen and wait

@Regression17
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_NoTechnical
Scenario: Verify with position specification of cover wear when technical data is not present

    Then  Verify whether the specifications is populated when no technical data is present for '${ConveyorName}' '${CustSiteName}'

@Regression8
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Specs
Scenario: Verify with add measure with no previous measurement

    When  Navigate to cover wear listing screen
    Then  Verify mandatory parameter for add measurement '${ConveyorName}'
    When  Select site from dropdown with '${CustSiteName}'
    Then  Look for conveyor dropdown with '${ConveyorName}'
    Then  Verify add position navigation for '${Position}' and '${Count}'
    And   Add measurement data '${BeltLength}' '${BeltWidth}' '${TopCoverThickness}' '${BottomCoverThickness}' '${Durometer}' '${TopCoverCompound}' '${BottomCoverCompound}'

@Regression9
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_AddMeasurement
Scenario: Verify with add measure having previous measurement

    When  Navigate to cover wear listing screen
    And   Go to add measurement window
    And   Select site from dropdown with '${CustSiteName}'
    Then  Look for conveyor dropdown with '${ConveyorName}'
    Then  Verify Inspector name is prefilled with '${InspectorName}'
    Then  Verify dropdown behaviour with '${Standard}' and '${Every}' and '${Custom}'
    When  Data point is select as '${Standard}'
    Then  Verify existing position for '${Position}' and '${Count}'
    When  Enter Temperature '${Temperature}' and verify
    When  Select Inspection date as '${InspectionDate}'
    Then  Verify the previous tons conveyor '${TonsConveyedPreviously}'
    When  Enter the current tons conveyor '${TonsConveyed}' and verify
    Then  Verify measurement table for '${InstallationDate}' '${PreviousMeasurementDate}' '${PreviousThickness}'
    When  Add new measurement for current date with '${Thickness}' and '${Durometer}'
    Then  Verify Add and remove new measurement readings
    Then  Verify file upload functionality with '${ImageName}'
    Then  Verify comments sections with '${Comment}'
    Then  Verify save functionality for new measurement

@Regression2
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Specs
Scenario: Verify the logic of the displaying durometer shoreA

    When  Navigate to cover wear listing screen
    Then  Verify Cover wear measurement for conveyor '${ConveyorName}'
    Then  Verify durometer shoreA score for '${ConveyorName}'

@Regression3
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Specs
Scenario: Verify the logic of displaying remaining life by time

    When  Navigate to cover wear listing screen
    Then  Verify Cover wear measurement for conveyor '${ConveyorName}'
    Then  Verify remaining life by time for '${ConveyorName}'

@Regression4
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Specs
Scenario: Verify the logic of displaying remaining cover percentage

    When  Navigate to cover wear listing screen
    Then  Verify Cover wear measurement for conveyor '${ConveyorName}'
    Then  Verify remaining cover percentage for '${ConveyorName}'

@Regression5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Specs
Scenario: Verify the download button functionality

    When  Navigate to cover wear listing screen
    Then  Verify the download functionality in list screen for '${FullName}'

@Regression6
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Edit
Scenario: Verify the edit button functionality

    When  Navigate to cover wear listing screen
    Then  Verify after select cover wear record '${ConveyorName}' action button is enabled
    And   Verify the contents of action dropdown for cover wear
    And   Navigate to edit cover wear and verify navigation
    When  Edit durometer specification to '${Durometer}'
    Then  Verify the changes '${Durometer}' for cover wear '${ConveyorName}'

@Regression10
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Specs
Scenario: Verify position navigation of cover wear listing via conveyor details screen

    Then  Navigate to conveyor cover wear screen for '${ConveyorName}'

@Regression11
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Specs
Scenario: Verify position logic of displaying durometer shoreA

    When  Navigate to conveyor cover wear screen for '${ConveyorName}'
    Then  Verify durometer shoreA score for '${ConveyorName}' in specification screen

@Regression12
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Specs
Scenario: Verify position logic of displaying remaining life by time

    When  Navigate to conveyor cover wear screen for '${ConveyorName}'
    Then  Verify remaining life by time for '${ConveyorName}' in specification screen

@Regression13
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Specs
Scenario: Verify position logic of displaying remaining cover percentage

    When  Navigate to conveyor cover wear screen for '${ConveyorName}'
    Then  Verify remaining cover percentage for '${ConveyorName}' in specification screen

@Regression14
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Download
Scenario: Verify position download button functionality

    When  Navigate to conveyor cover wear screen for '${ConveyorName}'
    Then  Download position report for date range '${FromDate}' to '${ToDate}'
    Then  Verify the download functionality with '${ConveyorName}' and '${CustSiteName}' for '${FullName}'

@Regression15
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_EditPosition
Scenario: Verify position edit button functionality

    When  Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
    Then  Verify after selecting cover wear position '${Position}' action button is enabled
    And   Verify the contents of action dropdown for position
    And   Navigate to edit cover wear position and verify navigation
    When  Edit durometer position to '${Durometer}'
    Then  Verify the changes '${Durometer}' for cover wear position '${Position}'


@Regression16
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_DeletePosition
Scenario: Verify position delete button functionality

    When  Navigate to conveyor cover wear screen for '${ConveyorName}'
    When  Delete Cover wear position for conveyor '${ConveyorName}' with data '${SegmentName}'
    Then  Verify Delete Cover wear position for conveyor '${ConveyorName}' and segment '${SegmentName}'

@Regression18
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Technical
Scenario: Verify position specification of cover wear when technical data is present

    When  Navigate to conveyor cover wear screen for '${ConveyorName}'
    Then  Verify whether the specifications is populated when technical data is present for '${ConveyorName}' '${CustSiteName}' with '${BeltLength}' '${BeltWidth}' '${TopCoverThickness}' '${BottomCoverThickness}' '${TopCoverCompound}' '${BottomCoverCompound}'

@Regression19
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_PositionNav
Scenario: Verify navigation of position detail screen

    When  Navigate to conveyor cover wear screen for '${ConveyorName}'
    Then  Navigate to position details screen for '${Position}'

@Regression20
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_PositionDownload
Scenario: Verify download functionality under specification

    When  Navigate to conveyor cover wear screen for '${ConveyorName}'
    When  Navigate to position details screen for '${Position}'
    Then  Verify the download functionality with '${ConveyorName}' and '${CustSiteName}' for '${FullName}' from '${FromDate}' to '${ToDate}'

@Regression21
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_WearTable
Scenario: Verify a wear measurement table

    When  Navigate to conveyor cover wear screen for '${ConveyorName}'
    When  Navigate to position details screen for '${Position}'
    Then  Verify wear measurement table column headers
    Then  Verify the data for last measurement '${Inspector}' '${MeasurementDate}' '${Thickness}' '${Durometer}'

@Regression22
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_WearTable
Scenario: Verify an attach image operation for existing measurement

    When  Navigate to conveyor cover wear screen for '${ConveyorName}'
    When  Navigate to position details screen for '${Position}'
    Then  Verify attached image functionality

@Regression23
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_EditWearTable
Scenario: Verify an edit option operation for individual measurement

    When  Navigate to conveyor cover wear screen for '${ConveyorName}'
    When  Navigate to position details screen for '${Position}'
    Then  Edit the measurement with durometer '${NewDurometer}' and thickness '${NewThickness}'
    Then  Verify the data for last measurement '${Inspector}' '${MeasurementDate}' '${NewThickness}' '${NewDurometer}'

@Regression24
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_WearTable
Scenario: Verify a delete option operation for individual measurement

    When  Navigate to conveyor cover wear screen for '${ConveyorName}'
    When  Navigate to position details screen for '${Position}'
    Then  Delete the last measurement from wear table
    Then  Verify the deleted last measurement from the table

@Regression25
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_AddMeasurementStandard
Scenario: Verify an add new measurement functionality from position details screen using standard

    When  Navigate to conveyor cover wear screen for '${ConveyorName}'
    When  Navigate to position details screen for '${Position}'
    When  Open add new measurement window from position details screen
    Then  Verify the selected customer site is '${CustSiteName}'
    Then  Verify selected conveyor is '${ConveyorName}'
    Then  Verify selected position is '${Position}'
    Then  Verify Inspector name is prefilled with '${InspectorName}'
    Then  Verify dropdown behaviour with '${Standard}' and '${Every}' and '${Custom}'
    When  Data point is select as '${Standard}'
    When  Enter Temperature '${Temperature}' and verify
    When  Select Inspection date as '${InspectionDate}'
    Then  Verify the previous tons conveyor '${TonsConveyedPreviously}'
    When  Enter the current tons conveyor '${TonsConveyed}' and verify
    Then  Verify measurement table for '${InstallationDate}' '${PreviousMeasurementDate}' '${PreviousThickness}'
    When  Add new measurement for current date with '${Thickness}' and '${Durometer}'
    Then  Verify Add and remove new measurement readings
    Then  Verify file upload functionality with '${ImageName}'
    Then  Verify comments sections with '${Comment}'
    Then  Verify save functionality for new measurement


@Regression26
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_AddMeasurementEvery
Scenario: Verify an add new measurement functionality from position details screen using 50mm

    When  Navigate to conveyor cover wear screen for '${ConveyorName}'
    When  Navigate to position details screen for '${Position}'
    When  Open add new measurement window from position details screen
    When  Data point is select as '${Every}'
    When  Enter Temperature '${Temperature}' and verify
    When  Select Inspection date as '${InspectionDate}'
    Then  Verify the previous tons conveyor '${TonsConveyedPreviously}'
    When  Enter the current tons conveyor '${TonsConveyed}' and verify
    Then  Verify measurement table datapoint count as '${Count}'
    When  Add new measurement for current date with '${Thickness}' and '${Durometer}'
    Then  Verify Add and remove new measurement readings
    Then  Verify file upload functionality with '${ImageName}'
    Then  Verify comments sections with '${Comment}'
    Then  Verify save functionality for new measurement

@Regression27
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_AddMeasurementCustom
Scenario: Verify an add new measurement functionality from position details screen using custom

    When  Navigate to conveyor cover wear screen for '${ConveyorName}'
    When  Navigate to position details screen for '${Position}'
    When  Open add new measurement window from position details screen
    When  Data point is select as '${Custom}'
    When  Enter data point count as '${Count}'
    When  Enter Temperature '${Temperature}' and verify
    When  Select Inspection date as '${InspectionDate}'
    Then  Verify the previous tons conveyor '${TonsConveyedPreviously}'
    When  Enter the current tons conveyor '${TonsConveyed}' and verify
    Then  Verify measurement table datapoint count as '${Count}'
    When  Add new measurement for current date with '${Thickness}' and '${Durometer}'
    Then  Verify Add and remove new measurement readings
    Then  Verify file upload functionality with '${ImageName}'
    Then  Verify comments sections with '${Comment}'
    Then  Verify save functionality for new measurement

@Regression28
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_PositionDownload
Scenario: Verify a summary report download functionality for single conveyor

    When  Navigate to cover wear listing screen
    Then  Verify Cover wear measurement for conveyor '${ConveyorName}'
    Then  Download report for date range '${FromDate}' to '${ToDate}'
    Then  Verify the download functionality with '${ConveyorName}' and '${CustSiteName}' for '${FullName}'
    Then  Verify the PDF report for single conveyor

@Regression29
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_PositionDownload
Scenario: Verify a download button functionality for all conveyors

     When  Navigate to cover wear listing screen
     Then  Verify the download functionality in list screen for '${FullName}'
     Then  Verify the PDF report for all conveyors

@Regression7
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Specs
Scenario: Verify a delete button functionality

    When  Navigate to cover wear listing screen
    When  Delete Cover wear measurement for conveyor '${ConveyorName}'
    Then  Verify Delete Cover wear measurement for conveyor '${ConveyorName}'