Feature: Regression of user statistics module

Background:
Launch the application through '/'

@Regression1
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserStatistics_User
Scenario: Verify ztotal users count on user statistics

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to user statistics page and capture users count
    And   Create a Market manager '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}'
    And   Add territory as '${Region}' for the user
    And   Add permission rights with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and create user
    And   Verify the user statistics user count

@Regression2
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserStatistics_Corp
Scenario: Verify ytotal corporates on user statistics

    And   Navigate to user statistics page and capture corporates count
    And   Create a Distributor Corporate with '${DistCorpName}' and '${DistCorpAddress}'
    And   Verify the user statistics corporates count

@Regression3
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserStatistics_Corp
Scenario: Verify xtotal shops on user statistics

    And   Navigate to user statistics page and capture shops count
    And   Create a Distributor shop with '${DistShopAusName}' and '${DistShopAusAddress}' and '${DistCorpName}' and '${FullName}' and '${TerritoryInd}'
    And   Verify the user statistics shops count

@Regression4
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserStatistics_Corp
Scenario: Verify vtotal sites on user statistics

    And   Navigate to user statistics page and capture sites count
    And   Create a Customer site '${CustSiteIndName}' and '${CustSiteIndAddress}' and '${CustCorpName}' and '${DistShopAusName}' and '${FullName}' and '${TerritoryInd}'
    And   Verify the user statistics sites count

@Regression5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserStatistics_Corp
Scenario: Verify utotal conveyors on user statistics

    And   Navigate to user statistics page and capture conveyors count
    When  Create a conveyor with '${ConveyorName1}' and '${DistShopAusName}' and '${CustSiteIndName}'
    And   Verify the user statistics conveyors count

@Regression6
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_UserStatistics
Scenario: Verify total cover wear on user statistics

    And   Navigate to user statistics page and capture cover wear count
    When  Add Cover Wear for conveyor '${ConveyorName}' and site '${CustSiteName}' with data '${FullName}' '${PositionName}' '${TopCoverThickness}' '${BottomCoverThickness}' '${Durometer}' '${TopCoverCompound}' '${BottomCoverCompound}'
    And   Add new measurement for '${Position}' with current date '${Thickness}' and '${NewDurometer}'
    Then  Verify Cover wear measurement for conveyor '${ConveyorName}'
    And   Verify the user statistics cover wear count

@Regression7
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_UserStatistics
Scenario: Verify total inspections on user statistics

    And   Navigate to user statistics page and capture inspection count
    When  Add inspection Event for conveyor '${EditInspectionName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'
    And   Verify the user statistics inspection count

@Regression8
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Inspect_UserStatistics
Scenario: Verify total conveyor inspect on user statistics

    And   Navigate to user statistics page and capture conveyor inspect count
    When  Assign Object detection model '${DetectionModel}' for Corporate '${CustCorpName}' with site '${CustSiteName}' and conveyor '${ConveyorName}'
    And   Upload drone files with '${Side}' '${colorMap}' '${irName}' '${rgbName}'
    And   Verify the user statistics conveyor inspect count

@Regression9
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_UserStatistics
Scenario: Verify total belt scans on user statistics

    And   Navigate to user statistics page and capture belt scan count
    Then  Navigate to Add Belt Scan Page and verify navigation
    When  Add Belt Scan general Info with '${DateOfScan}' '${ScanReason}' '${CustSiteAusName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    When  Submit the belt scan form
    Then  Verify the belt scan for '${ConveyorName}' is present in list screen
    And   Verify the user statistics belt scan count

@Regression10
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_UserStatistics
Scenario: Verify total monitoring device on user statistics

    And   Navigate to user statistics page and capture monitoring device count
    And   Navigate to Belt Monitoring List screen
    And   Navigate to Add monitoring device screen
    And   Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${InstallationDate}' and '${ConveyorName}'
    And   Click on save button and verify device '${DeviceName}' is created successfully
    And   Verify the user statistics monitoring device count

@Regression11
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Minuteman_Statistics
Scenario: Verify total minuteman on user statistics

    When  Navigate to user statistics page and capture minuteman count
    And   User is at add minuteman conveyor page
    When  User enters general info '${CalculationName1}' '${CustSiteName}' '${ConveyorName}' and click on select belt
    And   User enters select belt details and click on final report
    Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName1}' '${CustSiteName}' '${ConveyorName}'
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman calculation '${CalculationName1}' in list screen
    And   Verify the user statistics minuteman count