Feature: Regression of P1 Heavy Equipment module

Background:
Launch the application through '/'

@Regression1 @CTCP-3727
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_Add
Scenario: ZVerify add button functionality

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And Navigate to the Heavy Equipment list page
    And Navigate to the Heavy Equipment add page
    And Create a heavy equipment with '${HeavyEquipmentName}' '${Category}' '${Model}' '${Year}' '${SerialNumber}' '${DistShopName}' '${ImageName}'
    And Search for the heavy equipment '${HeavyEquipmentName}'
    And Navigate to the Heavy Equipment add page
    And Create a heavy equipment with '${HeavyEquipmentName}' '${Category}' '${Model}' '${Year}' '${SerialNumber}' '${DistShopName}' '${ImageName}' and click on cancel

@Regression2 @CTCP-3713
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_DistCount
Scenario: Verify visibility of heavy equipment tile on distributor corporate page


    Then Navigate to Corporate details screen for corporate '${DistCorpName}'
    And Click on the Heavy Equipment card and verify navigation to Heavy Equipment list page
    And Verify the count of records linked to the Distributor Shops in the Heavy Equipment Listing page

@Regression3 @CTCP-3714
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_DistCount
Scenario: Verify visibility of heavy equipment tile on distributor shop page


    Then Navigate to Corporate details screen for corporate '${DistCorpName}'
    And Verify navigation to '${DistShopName}' detail screen
    And Click on the Heavy Equipment card and verify navigation to Heavy Equipment list page
    And Verify the count of records linked to the Distributor Shops in the Heavy Equipment Listing page

@Regression4 @CTCP-3715
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_CustCorp
Scenario: Verify visibility of heavy equipment tile on customer corporate page


    Then Navigate to Corporate details screen for corporate '${CustCorpName}'
    And Verify Heavy Equipment card is not visible in customer corporate page

@Regression5 @CTCP-3716
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_CustCorp
Scenario: Verify visibility of heavy equipment tile on customer site page


    Then Navigate to Corporate details screen for corporate '${CustCorpName}'
    And Verify navigation to '${CustSiteName}' detail screen
    And Verify Heavy Equipment card is not visible in customer corporate page

@Regression6 @CTCP-3730
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_Add
Scenario: Verify edit equipment functionality


    Then Navigate to the Heavy Equipment list page
    And Search for the heavy equipment '${HeavyEquipmentName}'
    And Navigate to edit heavy equipment page
    And Edit the Heavy Equipment '${EditHeavyEquipmentName}' '${Category}'
    And Click on add Icon and upload the file '${ImageName}'
    And Click on add Icon and upload the file '${PdfFile}'
    And Click on save button and verify the Heavy Equipment '${EditHeavyEquipmentName}' is edited

@Regression7 @CTCP-3717
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_Permission
Scenario: Verify the access of heavy equipment tile as per the permission

    When Navigate to user list page and wait
    Then Search for the user '${UserNameMarket}'
    And Navigate to edit user page
    And Edit the Internal Tools permission '${EditAdd}' '${EditEdit}' '${EditDelete}' '${EditView}' '${EditDownload}' and save
    And Logout from the current user
    And Login with '${UserEmailNameMarket}' and '${PasswordMarket}'
    And Navigate to the Heavy Equipment list page
    And Navigate to the Heavy Equipment add page
    And Navigate to the Heavy Equipment list page
    And Search for the heavy equipment '${EditHeavyEquipmentName}'
    And Click on view more icon
    And Navigate to the Heavy Equipment list page
    And Search for the heavy equipment '${EditHeavyEquipmentName}'
    And Verify user does not have edit download delete rights

@Regression8 @CTCP-3731
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_Add
Scenario: ZVerify preview functionality of uploaded file in view mode

Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then Navigate to the Heavy Equipment list page
    And Search for the heavy equipment '${EditHeavyEquipmentName}'
    And Click on view more icon
    And Verify and view the image uploaded '${ImageName}'

@Regression9 @CTCP-3732
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_Add
Scenario: ZVerify delete functionality of uploaded file

    Then Navigate to the Heavy Equipment list page
    And Search for the heavy equipment '${EditHeavyEquipmentName}'
    And Click on view more icon
    And Verify search and delete document '${ImageName}' functionality
    And Verify search and delete document '${PdfFile}' functionality


@Regression10 @CTCP-3729
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_Add
Scenario: Verify delete equipment functionality

Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And Navigate to the Heavy Equipment list page
    And Navigate to heavy equipment page and wait
    And Verify search and delete '${EditHeavyEquipmentName}' functionality

@Regression11 @CTCP-3722
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_ColumnSearch
Scenario: ZVerify the search functionality of the list table

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then Navigate to the Heavy Equipment list page
    And Navigate to heavy equipment page and wait
    And Search for the heavy equipment '${Name}'
    And Search for the heavy equipment '${Model}'
    And Search for the heavy equipment '${Year}'
    And Verify only the records with searched year '${Year}' appears in the table
    And Search for the heavy equipment '${SerialNumber}'

@Regression12 @CTCP-3718
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_ColumnSearch
Scenario: YVerify the data displayed in the heavy equipment listing page

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then Navigate to the Heavy Equipment list page
    And Verify the header and all the column names in heavy equipment page

@Regression13 @CTCP-3719
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_ColumnSearch
Scenario: XVerify the sorting functionality for each column

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then Navigate to the Heavy Equipment list page
    And Navigate to heavy equipment page and wait
    And Click on column header and verify sorting functionality for heavy equipment list page

@Regression14 @CTCP-3720 @CTCP-3724
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_ColumnSearch
Scenario: WVerify the filter functionality for each column

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then Navigate to the Heavy Equipment list page
    And Navigate to heavy equipment page and wait
    And Click on each column header of heavyEquipment list and verify filter icon fields

@Regression15 @CTCP-3721
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_ColumnSearch
Scenario: VVerify more column functionality

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then Navigate to the Heavy Equipment list page
    And Navigate to heavy equipment page and wait
    And Search for the heavy equipment '${Name}'
    And Click on view more icon
    And Click on Heavy equipment link in breadcrumb
    And And Search for the heavy equipment '${Name}'
    And Click on the  scanner icon in list and verify fields '${Name}'
    And Click on the download button and verify QR is downloaded with the proper name '${Name}'

@Regression16 @CTCP-3723
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_ColumnSearch
Scenario: UVerify column selection functionality

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then Navigate to the Heavy Equipment list page
    And Navigate to heavy equipment page and wait
    And Verify column selection filter is visible
    And Click on the column name filter and verify searchBar all columnNames with checkbox and cross button is visible
    And Verify user is able to see the column names selected by default
    And Select only two columns and verify the selected columns are visible in the table

@Regression17 @CTCP-3726
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_ColumnSearch
Scenario: TVerify pagination functionality

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then Navigate to the Heavy Equipment list page
    And Navigate to heavy equipment page and wait
    Then Verify the heavy equipment count with respect to pagination
    And Click on pagination dropdown and verify records
    And Click on the page number and verify it navigates to respective page













