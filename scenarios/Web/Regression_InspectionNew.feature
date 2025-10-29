#@dataProvider:CSV_DataProvider
#@dataProviderClass:com.common.utils.CSVDataProvider

Feature: Regression of P1 Inspection module

Background:
Launch the application through '/'

@Regression1 @customer
#@dataFile:resources/data/TestData.xls
#@sheetName:Regression
#@key:Inspection_CorpTemplateDefault
@csvDataFile:resources/data/Inspection.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:Inspection_CorpTemplateDefault
Scenario: zzzVerify inspection default template functionality for customer corporate

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}' and wait for pageload
    And   Navigation of corporate list screen
    And   Navigate to add corporate from list screen
    And   Navigation of corporate list screen
    And   Navigate to add corporate from list screen
    Then  Verify Default should be selected under inspection template
    And   Add customer corporate with '${CustCorpName}' and '${CustCorpAddress}' '${InsTemplate}'
    And   Navigate to edit corporate for '${CustCorpName}'
    And   Verify whether inspection template dropdown '${InsTemplate}' is disabled

@Regression2 @customer
#@dataFile:resources/data/TestData.xls
#@sheetName:Regression
#@key:Inspection_CorpTemplateVMC
@csvDataFile:resources/data/Inspection.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:Inspection_CorpTemplateVMC
Scenario: zyVerify inspection VMC template functionality for customer corporate

    And   Navigation of corporate list screen
    And   Navigate to add corporate from list screen
    Then  Verify Default should be selected under inspection template
    And   Add customer corporate with '${CustCorpName}' and '${CustCorpAddress}' '${InsTemplate}'
    And   Navigate to edit corporate for '${CustCorpName}'
    And   Verify whether inspection template dropdown '${InsTemplate}' is disabled

@Regression3 @card
#@dataFile:resources/data/TestData.xls
#@sheetName:Regression
#@key:Inspection_ListNav
@csvDataFile:resources/data/Inspection.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:Inspection_ListNav
Scenario: zxVerify inspection list page navigation

    When  Navigate to inspection list screen
    And   Navigate to site list page
    And   Navigate to inspection list from inspection card at home level
    Then  Navigate to inspection list from inspection card at corporate level '${DistCorpName}'
    Then  Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Navigate to distributor shop detail screen for '${DistCorpName}' with '${DistShop}'
    Then  Navigate to inspection list from inspection card at site/shop level '${DistShop}'
    When  Navigate to distributor shop detail screen for '${CustCorpName}' with '${CustSiteName}'
    Then  Navigate to inspection list from inspection card at site/shop level '${CustSiteName}'
    When  Navigate to conveyor details screen for conveyor '${ConveyorName}'
    Then  Navigate to inspection list from inspection card at site/shop level '${ConveyorName}'

@Regression4 @card
#@dataFile:resources/data/TestData.xls
#@sheetName:Regression
#@key:Inspection_CorpTemplateDefault
@csvDataFile:resources/data/Inspection.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:Inspection_CorpTemplateDefault
Scenario: Verify inspection card

    When  Navigate to inspection list screen
    Then  Verify tile count for total critical poor fault good and to be completed

@Regression5 @card
#@dataFile:resources/data/TestData.xls
#@sheetName:Regression
@csvDataFile:resources/data/Inspection.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:Inspection_CardSingleInspection
Scenario: zvVerify inspection card count functionality for add inspection at home level for single inspection

    When  Navigate to inspection list screen
    And   Extract the inspection card count
    And   Create a Customer site '${CustSiteName}' and '${CustSiteAddress}' and '${CustCorpName}' and '${DistShopName}' and '${FullName}' and '${TerritoryInd}'
    And   Create a conveyor with '${ConveyorName1}' and '${DistShopName}' and '${CustSiteName}'
    And   Create a conveyor with '${ConveyorName2}' and '${DistShopName}' and '${CustSiteName}'
    And   Create a conveyor with '${ConveyorName3}' and '${DistShopName}' and '${CustSiteName}'
    And   Create a conveyor with '${ConveyorName4}' and '${DistShopName}' and '${CustSiteName}'
    And   Add inspection Event for conveyor '${ConveyorName1}' with '${InspectionName1}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName1}' for '${InspectionName1}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'
    When  Navigate to inspection list screen
    And   Verify the incremental tile count changes for '${ChangeTotal}','${ChangeTobeComplated}','${NoChange}','${NoChange}','${ChangeFault}','${NoChange}'
    And   Add inspection Event for conveyor '${ConveyorName2}' with '${InspectionName2}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName2}' for '${InspectionName2}' with '${AssetName1}' '${AssetDetail1}' '${FailureMode1}' '${Condition1}' '${Status}'
    When  Navigate to inspection list screen
    And   Verify the incremental tile count changes for '${ChangeTotal}','${ChangeTobeComplated}','${NoChange}','${ChangePoor}','${NoChange}','${NoChange}'
    And   Add inspection Event for conveyor '${ConveyorName3}' with '${InspectionName3}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName3}' for '${InspectionName3}' with '${AssetName2}' '${AssetDetail2}' '${FailureMode2}' '${Condition2}' '${Status}'
    When  Navigate to inspection list screen
    And   Verify the incremental tile count changes for '${ChangeTotal}','${NoChange}','${ChangeGood}','${NoChange}','${NoChange}','${NoChange}'
    And   Add inspection Event for conveyor '${ConveyorName4}' with '${InspectionName4}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName4}' for '${InspectionName4}' with '${AssetName3}' '${AssetDetail3}' '${FailureMode3}' '${Condition3}' '${Status}'
    When  Navigate to inspection list screen
    And   Verify the incremental tile count changes for '${ChangeTotal}','${ChangeTobeComplated}','${NoChange}','${NoChange}','${NoChange}','${ChangeCritical}'

@Regression6 @card
#@dataFile:resources/data/TestData.xls
#@sheetName:Regression
@csvDataFile:resources/data/Inspection.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:Inspection_CardMultiInspection
Scenario: zuVerify inspection card count functionality for add inspection at home level for multi inspection

    When  Navigate to inspection list screen
    And   Extract the inspection card count
    And   Create a Customer site '${CustSiteName}' and '${CustSiteAddress}' and '${CustCorpName}' and '${DistShopName}' and '${FullName}' and '${TerritoryInd}'
    And   Create a conveyor with '${ConveyorName5}' and '${DistShopName}' and '${CustSiteName}'
    And   Add inspection Event for conveyor '${ConveyorName5}' with '${InspectionName5}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for VMC conveyor '${ConveyorName5}' for '${InspectionName5}' with '${AssetName}' '${AssetDetail}' '${Condition}' '${Status}' '${Observation}'
    And   Add inspection Item for VMC conveyor '${ConveyorName5}' for '${InspectionName5}' with '${AssetName1}' '${AssetDetail1}' '${Condition1}' '${Status}' '${Observation1}'
    And   Add inspection Item for VMC conveyor '${ConveyorName5}' for '${InspectionName5}' with '${AssetName2}' '${AssetDetail2}' '${Condition2}' '${Status}' '${Observation2}'
    And   Add inspection Item for VMC conveyor '${ConveyorName5}' for '${InspectionName5}' with '${AssetName3}' '${AssetDetail3}' '${Condition3}' '${Status}' '${Observation3}'
    When  Navigate to inspection list screen
    And   Verify the incremental tile count changes for '${ChangeTotal}','${ChangeTobeComplated}','${ChangeGood}','${ChangeFault}','${ChangeCritical}'

@Regression7 @card
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DeleteMultiInspection
Scenario: ztVerify inspection card count functionality for delete event at home level for multi inspection

    When  Navigate to inspection list screen
    And   Extract the inspection card count
    And   Delete inspection '${InspectionName5}' from inspection list
    And   Verify the incremental tile count changes for '${ChangeTotal}','${ChangeTobeComplated}','${ChangeGood}','${ChangeFault}','${ChangeCritical}'

@Regression8 @card
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_CorporateMultiInspection
Scenario: zsVerify inspection card count functionality at corporate level

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Extract the inspection card count
    And   Create a conveyor with '${ConveyorName6}' and '${DistShopName}' and '${CustSiteName}'
    And   Add inspection Event for conveyor '${ConveyorName6}' with '${InspectionName6}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for VMC conveyor '${ConveyorName6}' for '${InspectionName6}' with '${AssetName}' '${AssetDetail}' '${Condition}' '${Status}' '${Observation}'
    And   Add inspection Item for VMC conveyor '${ConveyorName6}' for '${InspectionName6}' with '${AssetName1}' '${AssetDetail1}' '${Condition1}' '${Status}' '${Observation1}'
    And   Add inspection Item for VMC conveyor '${ConveyorName6}' for '${InspectionName6}' with '${AssetName2}' '${AssetDetail2}' '${Condition2}' '${Status}' '${Observation2}'
    And   Add inspection Item for VMC conveyor '${ConveyorName6}' for '${InspectionName6}' with '${AssetName3}' '${AssetDetail3}' '${Condition3}' '${Status}' '${Observation3}'
    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Verify the incremental tile count changes for '${ChangeTotal}','${ChangeTobeComplated}','${ChangeGood}','${ChangeFault}','${ChangeCritical}'

@Regression9 @card
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_SiteMultiInspection
Scenario: zrVerify inspection card count functionality at site level

    When  Navigate to site details for site '${CustSiteName}'
    Then  Navigate to inspection list from inspection card at site/shop level '${CustSiteName}'
    And   Extract the inspection card count
    And   Create a conveyor with '${ConveyorName7}' and '${DistShopName}' and '${CustSiteName}'
    And   Add inspection Event for conveyor '${ConveyorName7}' with '${InspectionName7}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for VMC conveyor '${ConveyorName7}' for '${InspectionName7}' with '${AssetName}' '${AssetDetail}' '${Condition}' '${Status}' '${Observation}'
    And   Add inspection Item for VMC conveyor '${ConveyorName7}' for '${InspectionName7}' with '${AssetName1}' '${AssetDetail1}' '${Condition1}' '${Status}' '${Observation1}'
    And   Add inspection Item for VMC conveyor '${ConveyorName7}' for '${InspectionName7}' with '${AssetName2}' '${AssetDetail2}' '${Condition2}' '${Status}' '${Observation2}'
    And   Add inspection Item for VMC conveyor '${ConveyorName7}' for '${InspectionName7}' with '${AssetName3}' '${AssetDetail3}' '${Condition3}' '${Status}' '${Observation3}'
    And   Navigate to site details for site '${CustSiteName}'
    Then  Navigate to inspection list from inspection card at site/shop level '${CustSiteName}'
    And   Verify the incremental tile count changes for '${ChangeTotal}','${ChangeTobeComplated}','${ChangeGood}','${ChangeFault}','${ChangeCritical}'


@Regression10 @card
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ConveyorMultiInspection
Scenario: zqVerify inspection card count functionality at conveyor level

    And   Create a conveyor with '${ConveyorName8}' and '${DistShopName}' and '${CustSiteName}'
    When  Navigate to conveyor details screen for conveyor '${ConveyorName8}'
    Then  Navigate to inspection list from inspection card at site/shop level '${ConveyorName8}'
    And   Extract the inspection card count
    And   Add inspection Event for conveyor '${ConveyorName8}' with '${InspectionName8}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName8}' for '${InspectionName8}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName8}' for '${InspectionName8}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition1}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName8}' for '${InspectionName8}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition2}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName8}' for '${InspectionName8}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition3}' '${Status}'
    And   Navigate to conveyor details screen for conveyor '${ConveyorName8}'
    Then  Navigate to inspection list from inspection card at site/shop level '${ConveyorName8}'
    And   Verify the incremental tile count changes for '${ChangeTotal}','${ChangeTobeComplated}','${ChangeGood}','${ChangePoor}','${ChangeFault}','${ChangeCritical}'

@Regression11 @card
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_EditInspectionCount
Scenario: zoVerify inspection card count functionality after editing status

    When  Navigate to inspection list screen
    And   Extract the inspection card count
    And   Edit inspection Item status for '${ConveyorName1}' to '${EditStatus}' from list view
    When  Navigate to inspection list screen
    And   Verify the incremental tile count changes for '${ChangeTotal}','${ChangeTobeComplated}','${ChangeGood}','${ChangePoor}','${ChangeFault}','${ChangeCritical}'

@Regression12 @card
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DeleteInspectionCount
Scenario: zpVerify inspection card count functionality after deleting inspection item

    When  Navigate to inspection list screen
    And   Extract the inspection card count
    And   Navigate to the inspection details screen for '${InspectionName1}'
    And   Delete inspection Item for '${AssertName1}'
    When  Navigate to inspection list screen
    And   Verify the incremental tile count changes for '${NoChange}','${ChangeTobeComplated}','${NoChange}','${NoChange}','${NoChange}','${ChangeCritical}'
    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Extract the inspection card count
    And   Navigate to the inspection details screen for '${InspectionName2}'
    And   Delete inspection Item for '${AssertName2}'
    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Verify the incremental tile count changes for '${NoChange}','${NoChange}','${ChangeGood}','${NoChange}','${NoChange}','${NoChange}'
    Then  Navigate to inspection list from inspection card at site/shop level '${CustSiteName}'
    And   Extract the inspection card count
    And   Navigate to the inspection details screen for '${InspectionName3}'
    And   Delete inspection Item for '${AssertName3}'
    Then  Navigate to inspection list from inspection card at site/shop level '${CustSiteName}'
    And   Verify the incremental tile count changes for '${NoChange}','${ChangeTobeComplated}','${NoChange}','${NoChange}','${ChangeFault}','${NoChange}'
    When  Navigate to conveyor details screen for conveyor '${ConveyorName4}'
    Then  Navigate to inspection list from inspection card at site/shop level '${ConveyorName4}'
    And   Extract the inspection card count
    And   Navigate to the inspection details screen for '${InspectionName4}'
    And   Delete inspection Item for '${AssertName4}'
    When  Navigate to conveyor details screen for conveyor '${ConveyorName4}'
    Then  Navigate to inspection list from inspection card at site/shop level '${ConveyorName4}'
    And   Verify the incremental tile count changes for '${NoChange}','${ChangeTobeComplated}','${NoChange}','${ChangePoor}','${NoChange}','${NoChange}'

@Regression13
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Navigation
Scenario: znVerify the breadcrumb for inspection list

    When  Navigate to inspection list screen and wait for data load
    Then  Verify the breadcrumb of the page
    And   Navigate to site list page
    And   Navigate to inspection list from inspection card at home level
    Then  Verify the breadcrumb of the page

@Regression14
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_NameColumn
Scenario: zmVerify the functionality of inspection name column

    When  Navigate to inspection list screen
    Then  Verify column filter with '${ColumnName}' and '${ColumnNumber}'
    And   Verify name filter functionality with '${InspectionName1}' and '${ColumnNumber}'

@Regression15
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DateColumn
Scenario: zlVerify the functionality of inspection date column

    When  Navigate to inspection list screen
    Then  Verify column filter with '${ColumnName}' and '${ColumnNumber}'
    And   Verify date filter functionality with '${InspectionDate}' and '${ColumnNumber}'


@Regression16
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_CorporateColumn
Scenario: zkVerify the functionality of corporate column

    When  Navigate to inspection list screen
    Then  Verify column filter with '${ColumnName}' and '${ColumnNumber}'
    And   Verify corporate filter functionality with '${Corporate}' and '${ColumnNumber}'

@Regression17
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_SiteColumn
Scenario: zjVerify the functionality of site column

    When  Navigate to inspection list screen
    Then  Verify column filter with '${ColumnName}' and '${ColumnNumber}'
    And   Verify site filter functionality with '${Site}' and '${ColumnNumber}'


@Regression18
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ConveyorColumn
Scenario: ziVerify the functionality of conveyor column

    When  Navigate to inspection list screen
    Then  Verify column filter with '${ColumnName}' and '${ColumnNumber}'
    And   Verify conveyor filter functionality with '${Conveyor}' and '${ColumnNumber}'

@Regression19
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_InspectorColumn
Scenario: zhVerify the functionality of inspector column

    When  Navigate to inspection list screen
    Then  Verify column filter with '${ColumnName}' and '${ColumnNumber}'
    And   Verify inspector filter functionality with '${Inspector}' and '${ColumnNumber}'

@Regression20
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_LastModifiedColumn
Scenario: zgVerify the functionality of last modified date column

    When  Navigate to inspection list screen
    Then  Verify column filter with '${ColumnName}' and '${ColumnNumber}'
    And   Verify last modified filter functionality with '${LastModified}' and '${ColumnNumber}'
    And   Add inspection Event for conveyor '${ConveyorName1}' with '${InspectionName1}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName1}' for '${InspectionName1}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName2}' for '${CustSiteName}' with '${AssetName1}' '${AssetDetail1}' '${FailureMode1}' '${Condition1}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName3}' for '${CustSiteName}' with '${AssetName2}' '${AssetDetail2}' '${FailureMode2}' '${Condition2}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName4}' for '${CustSiteName}' with '${AssetName3}' '${AssetDetail3}' '${FailureMode3}' '${Condition3}' '${Status}'
    And   Verify the last modified date for newly created inspection '${InspectionName1}'

@Regression21
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Condition
Scenario: zfVerify the functionality of condition column

    When  Navigate to inspection list screen
    Then  Verify the condition column filter '${Condition1}' '${ColumnNumber}'
    Then  Verify the condition column filter '${Condition2}' '${ColumnNumber}'
    Then  Verify the condition column filter '${Condition3}' '${ColumnNumber}'
    Then  Verify the condition column filter '${Condition4}' '${ColumnNumber}'

@Regression22
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Status
Scenario: zeVerify the functionality of status column

    When  Navigate to inspection list screen
    Then  Verify the status column filter '${Status1}'
    Then  Verify the status column filter '${Status2}'

@Regression23
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ReportDownload
Scenario: zdVerify the download functionality

    When  Navigate to inspection list screen
    Then  Download inspection '${InspectionName7}' from inspection list with '${CustSiteName}' '${ConveyorName7}'

@Regression24
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSingleInspection
Scenario: zzcVerify single conveyor inspection functionality

    When  Navigate to inspection list screen
    When  Navigate to add inspection screen
    Then  Verify Site '${CustSiteName}' selection from dropdown for default template
    And   Verify the inspection name functionality for site '${CustSiteName}'
    And   Enter inspection name as '${InspectionName}'
    And   Verify default date in inspection date field
    And   Verify auto-population of inspector name '${FullName}'
    And   Verify the inspection creation with success message
    And   Verify the inspection items columns
    And   Verify the add inspection item navigation
    And   Verify the close add inspection item popup
    And   Add inspection Item for conveyor '${ConveyorName}' for '${CustSiteName}' with '${AssetName1}' '${AssetDetail1}' '${FailureMode1}' '${Condition1}' '${Status}' '${observation}' '${recommendation}' '${address}' '${img}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${CustSiteName}' with '${AssetName2}' '${AssetDetail2}' '${FailureMode2}' '${Condition2}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${CustSiteName}' with '${AssetName3}' '${AssetDetail3}' '${FailureMode3}' '${Condition3}' '${Status}'
    And   Verify the sorting order for inspection items
    And   Verify whether the inspection event '${InspectionName}' is present in list view
    And   Verify the column condition functionality from list screen for column '${ColumnNumCondition}' and site '${InspectionName}'
    And   Verify the column status functionality from list screen '${Status}' for column '${ColumnNumStatus}' and site '${InspectionName}'
    And   Verify the column conveyor functionality from list screen for column '${ColumnNumConveyor}' and site '${InspectionName}' '${Count}'

@Regression25
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddMultiInspection
Scenario: zzbVerify multi conveyor inspection functionality

    When  Navigate to inspection list screen
    When  Extract the inspection card count
    When  Navigate to add inspection screen
    Then  Verify Site '${CustSiteName}' selection from dropdown for default template
    And   Verify the inspection name functionality for site '${CustSiteName}'
    And   Enter inspection name as '${InspectionName}'
    And   Verify default date in inspection date field
    And   Verify auto-population of inspector name '${FullName}'
    And   Verify the inspection creation with success message
    And   Add inspection Item for conveyor '${ConveyorName1}' for '${CustSiteName}' with '${AssetName1}' '${AssetDetail1}' '${FailureMode1}' '${Condition1}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName1}' for '${CustSiteName}' with '${AssetName2}' '${AssetDetail2}' '${FailureMode2}' '${Condition2}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName1}' for '${CustSiteName}' with '${AssetName3}' '${AssetDetail3}' '${FailureMode3}' '${Condition3}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName2}' for '${CustSiteName}' with '${AssetName4}' '${AssetDetail4}' '${FailureMode4}' '${Condition4}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName2}' for '${CustSiteName}' with '${AssetName5}' '${AssetDetail5}' '${FailureMode5}' '${Condition5}' '${Status}'
    And   Verify the sorting order for inspection items
    When  Navigate to inspection list screen
    And   Verify the incremental tile count changes for '${ChangeTotal}','${ChangeTobeComplated}','${ChangeGood}','${ChangePoor}','${ChangeFault}','${ChangeCritical}'
    And   Verify whether the inspection event '${InspectionName}' is present in list view
    And   Verify the column condition functionality from list screen for column '${ColumnNumCondition}' and site '${InspectionName}'
    And   Verify the column status functionality from list screen '${Status}' for column '${ColumnNumStatus}' and site '${InspectionName}'
    And   Verify the column conveyor functionality from list screen for column '${ColumnNumConveyor}' and site '${InspectionName}' '${Count}'

@Regression26
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_EditInspectionDefault
Scenario: zzaVerify inspection item edit and delete functionality on edit mode

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}' and wait for pageload
    When  Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    Then  Verify the edit button functionality in inspection view mode for inspection '${InspectionName}'
    And   Verify the site dropdown is disabled on edit mode
    When  Edit Inspection event name to '${EditInspectionName}'
    When  Search inspection Item with conveyor '${ConveyorName}' '${AssetName}' '${Condition}'
    Then  Verify the conveyor and asset field are disabled on edit mode
    When  Edit inspection Item condition for conveyor '${ConveyorName}' and '${AssetName}' to '${EditCondition}'
    Then  Verify the sorting order for inspection items
    When  Navigate to inspection list screen
    And   Verify the column condition functionality from list screen for column '${ColumnNumberCondition}' and site '${EditInspectionName}'
    And   Verify the column status functionality from list screen '${Status}' for column '${ColumnNumberStatus}' and site '${EditInspectionName}'
    And   Verify the column conveyor functionality from list screen for column '${ColumnNumberConveyor}' and site '${EditInspectionName}' '${Count}'
    And   Verify name filter functionality with '${EditInspectionName}' and '${ColumnNumber}'

@Regression27.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DeleteInspectionDefault
Scenario: yzVerify uinspection item delete functionality

    When  Navigate to Inspection detail page of the Inspection event '${EditInspectionName}'
    Then  Verify the edit button functionality in inspection view mode for inspection '${EditInspectionName}'
    When  Search inspection Item with conveyor '${ConveyorName}' '${AssetName}' '${Condition}'
    When  Delete default inspection Item for '${ConveyorName}' and '${AssetName}'
    Then  Verify the sorting order for inspection items

@Regression28.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemClearFilter
Scenario: yyVerify uinspection item clear filter functionality

    When  Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    Then  Verify the edit button functionality in inspection view mode for inspection '${InspectionName}'
    Then  Verify column filter with '${Asset}' and '${ColumnNumber}'
    And   Verify asset filter functionality with '${Asset}' and '${ColumnNumber}'
    When  Clear filter for inspection items
    Then  Verify the clear filter functionality '${Asset}'

@Regression29.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemColumnSelection
Scenario: yxVerify uinspection item column selection functionality

    Then  Verify the edit button functionality in inspection view mode for inspection '${InspectionName}'
    And   Verify change column selection and disable '${ColumnName1}'
    When  Verify change column selection and disable '${ColumnName2}'

@Regression30.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemSearch
Scenario: ywVerify vinspection item search functionality

    Then  Verify the edit button functionality in inspection view mode for inspection '${InspectionName}'
    And   Verify the search functionality of the inspection item with '${Asset}'
    And   Verify the search functionality of the inspection item with '${Detail}'
    And   Verify the search functionality of the inspection item with '${FailureMode}'

@Regression31.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemPDF
Scenario: yvVerify multiple inspection items export functionality

    Then  Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    When  Select the inspection item with conveyor '${Asset1}'
    And   Select the inspection item with conveyor '${Asset2}'
    And   Verify the export functionality of the multiple inspection item for inspection '${InspectionName}'
    And   Verify the pdf content of inspection report for inspection '${InspectionName}' with conveyor '${Asset1}'
    And   Verify the pdf content of inspection report for inspection '${InspectionName}' with conveyor '${Asset2}'

@Regression32.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemDelete
Scenario: yuVerify multiple inspection items delete functionality

    And   Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    And   Select the inspection item with conveyor '${Asset1}'
    And   Select the inspection item with conveyor '${Asset2}'
    And   Delete inspection items record for inspection '${InspectionName}'
    Then  Verify the delete functionality of the inspection item for conveyor '${Asset1}'
    And   Verify the delete functionality of the inspection item for conveyor '${Asset1}'

@Regression33.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_GreenTick
Scenario: ytVerify the status green tick icon for completed event

    When  Navigate to add inspection screen
    And   Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName1}' '${AssetDetail1}' '${FailureMode1}' '${Condition1}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName2}' '${AssetDetail2}' '${FailureMode2}' '${Condition2}' '${Status1}'
    And   Navigate to inspection list screen
    Then  Verify the status when to be completed for '${InspectionName}' with '${StatusCount}'
    And   Verify the edit button functionality in list view for inspection '${InspectionName}'
    When  Edit inspection Item status for '${ConveyorName}' '${AssetName1}' to '${Status1}'
    And   Navigate to inspection list screen
    Then  Verify the status when completed for '${InspectionName}'

@Regression34.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Flags
Scenario: ysVerify the condition flags functionality

    When  Navigate to add inspection screen
    And   Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName1}' '${AssetDetail1}' '${FailureMode1}' '${Condition1}' '${Status1}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName2}' '${AssetDetail2}' '${FailureMode2}' '${Condition2}' '${Status}' '${observation}' '${recommendation}' '${address}' '${img}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName3}' '${AssetDetail3}' '${FailureMode3}' '${Condition3}' '${Status}'
    And   Navigate to inspection list screen
    Then  Verify the conditions flag column for inspection '${InspectionName}' with '${FlagCount}'
    And   Verify the edit button functionality in list view for inspection '${InspectionName}'
    When  Edit inspection Item status for '${ConveyorName}' '${AssetName1}' to '${Status}'
    When  Edit inspection Item status for '${ConveyorName}' '${AssetName2}' to '${Status1}'
    And   Navigate to inspection list screen
    Then  Verify the conditions flag column for inspection '${InspectionName}' with '${FlagCount}'

@Regression35.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Expand
Scenario: yrVerify the expand event functionality

    Then  Verify And validate the changes for '${InspectionName}' with '${ItemCount}'
    When  Navigate to inspection list screen
    And   Expand the inspection event to display inspection items for '${InspectionName}'
    And   Verify the column displayed for expanded list table
    And   Verify the all inspection items are present in expanded view
    And   Verify the location column for map popup in expanded view

@Regression36.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Navigation
Scenario: yqVerify the pagination functionality

    When  Navigate to inspection list screen
    And   Verify inspection event navigation to next pagination screen
    And   Verify inspection event the page limit functionality
    Then  Verify the inspection event pagination count


@Regression37.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ClearFilter
Scenario: ypVerify the clear filter functionality in event list

    When  Navigate to inspection list screen
    Then  Verify column filter with '${ColumnName}' and '${ColumnNumber}'
    And   Verify name filter functionality with '${InspectionName}' and '${ColumnNumber}'
    When  Clear filter for inspection items
    Then  Verify the clear filter functionality '${ColumnName}'

@Regression38.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ColumnSelection
Scenario: yoVerify inspection event column selection functionality

    When  Navigate to inspection list screen
    And   Verify change column selection and disable '${ColumnName1}'
    When  Verify change column selection and disable '${ColumnName2}'

@Regression39.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Search
Scenario: ynVerify inspection event search functionality

    When  Navigate to inspection list screen
    And   Verify the search functionality of the inspection event with '${InspectionName}'
    And   Verify the search functionality of the inspection event with '${CustSiteName}'
    And   Verify the search functionality of the inspection event with '${Inspector}'

@Regression40.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Navigation
Scenario: ymVerify inspection card count with pagination count

    When  Navigate to inspection list screen and wait for data load
    And   Extract the inspection card count
    And   Verify the total inspection event count with list
    Then  Verify if is able to switch from group view to list view
    And   Verify the filter functionality with status 'To be Completed'
    And   Verify the filter functionality with condition 'Good'
    And   Verify the filter functionality with condition 'Critical'
    And   Verify the filter functionality with condition 'Fault'
    And   Verify the filter functionality with condition 'Poor'

@Regression41.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DeleteItem
Scenario: ylVerify inspection item delete functionality from event and verifying in item list

    When  Navigate to inspection list screen
    And   Verify the edit button functionality in list view for inspection '${InspectionName}'
    When  Search inspection Item with conveyor '${ConveyorName}' '${AssetName}' '${Condition}'
    Then  Delete default inspection Item for '${ConveyorName}' and '${AssetName}'
    When  Navigate to inspection list screen
    And   Verify if is able to switch from group view to list view
    And   Search for inspection Item from list page for inspection '${InspectionName}'
    And   Verify asset filter functionality with '${AssetName}' and '${ColumnNumber}'
    And   Add filter functionality with condition '${Condition}'
    Then  Verify the delete functionality of the inspection item for conveyor '${ConveyorName}'

@Regression42.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemColumnSort
Scenario: yjVerify inspection item column functionality from item list

    When  Navigate to inspection list screen
    When  Verify if is able to switch from group view to list view
    And   Enable all columns from column selection
    Then  Verify all the column for inspection item list
    And   Verify column filter with 'Inspection Name' and '${ColumnNumber1}'
    When  Clear filter for inspection items
    Then  Verify the clear filter functionality 'Inspection Name'
    And   Verify column filter with 'Inspection Date' and '${ColumnNumber2}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Inspection Date'
    And   Verify column filter with 'Site' and '${ColumnNumber3}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Corporate'
    And   Verify column filter with 'Conveyor' and '${ColumnNumber5}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Site'
    And   Verify column filter with 'Corporate' and '${ColumnNumber4}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Conveyor'
    And   Verify column filter with 'Inspector' and '${ColumnNumber6}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Inspector'
    And   Verify column filter with 'Last Modified' and '${ColumnNumber7}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Last Modified'
    And   Verify column filter with 'Asset' and '${ColumnNumber8}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Asset'
    And   Verify column filter with 'Detail' and '${ColumnNumber9}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Detail'
    And   Verify column filter with 'Failure Mode' and '${ColumnNumber10}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Failure Mode'
    And   Add filter functionality with status '${Status}'
    When  Clear filter for inspection items
    And   Verify the condition column item filter with '${Condition}' '${ColumnNumber}'
    When  Clear filter for inspection items

@Regression43.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemActions
Scenario: wVerify inspection item action functionality from item list

    When  Navigate to inspection list screen
    When  Verify if is able to switch from group view to list view
    When  Search inspection Item from list view with conveyor '${InspectionName}' '${AssetName}' '${Condition}'
    Then  Verify edit inspection item from list '${AssetName}' to '${EditStatus}'
    When  Navigate to inspection list screen
    When  Verify if is able to switch from group view to list view
    When  Search inspection Item from list view with conveyor '${InspectionName}' '${AssetName}' '${Condition}'
    Then  Verify deleted inspection item from list '${ConveyorName}' for '${Asset}'
    When  Verify if is able to switch from list view to group view
    And   Expand the inspection event to display inspection items for '${InspectionName}'
    Then  Verify the all inspection items are present in expanded view

@Regression44.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Refresh
Scenario: vVerify inspection item refresh functionality from item list

    When  Navigate to inspection list screen and wait for data load
    When  Add inspection event from api with file '${FileName}' for conveyor '${CustSiteName}' for '${InspectionName}'
    Then  Verify the '${InspectionName}' is not visible in item list
    When  Refresh the item table contents
    Then  Verify the search functionality of the inspection event with '${InspectionName}'

@Regression45.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_PDFMultiInspection
Scenario: zVerify download pdf functionality

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}' and wait for pageload
    When  Navigate to add inspection screen
    Then  Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName1}' '${AssetDetail1}' '${FailureMode1}' '${Condition1}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName2}' '${AssetDetail2}' '${FailureMode2}' '${Condition2}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName3}' '${AssetDetail3}' '${FailureMode3}' '${Condition3}' '${Status}' '${observation}' '${recommendation}' '${address}' '${img}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName4}' '${AssetDetail4}' '${FailureMode4}' '${Condition4}' '${Status1}'
    And   Add inspection Item for conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName5}' '${AssetDetail5}' '${FailureMode5}' '${Condition5}' '${Status}' '${observation}' '${recommendation}' '${address}' '${img}'
    And   Add inspection Item for conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName6}' '${AssetDetail6}' '${FailureMode6}' '${Condition6}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName7}' '${AssetDetail7}' '${FailureMode7}' '${Condition7}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName8}' '${AssetDetail8}' '${FailureMode8}' '${Condition8}' '${Status1}'
    Then  Download inspection '${InspectionName}' from inspection list with '${CustSiteName}' '${ConveyorName}'
    And   Verify data displayed in report header and footer for '${FullName}' '${CustSiteName}' '${InspectionName}'
    And   Verify data displayed in inspection table for '${InspectionName}'


@Regression46.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_PDFMultiInspection
Scenario: yVerify unit conversion in pdf

    When  Navigate to inspection list screen
    And   Download inspection '${InspectionName}' from inspection list with '${CustSiteName}' '${ConveyorName}'
    Then  Verify the inspection pdf report for metric for '${InspectionName}'
    When  Switch the unit conversion to 'imperial'
    And   Download inspection '${InspectionName}' from inspection list with '${CustSiteName}' '${ConveyorName}'
    Then  Verify the inspection pdf report for imperial for '${InspectionName}'

@Regression47.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_PDFMultiInspection
Scenario: xVerify item report pdf download

    When  Navigate to inspection list screen
    And   Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    When  Select the inspection item with conveyor '${AssetName2}'
    And   Select the inspection item with conveyor '${AssetName8}'
    Then  Verify the export functionality of the multiple inspection item for inspection '${InspectionName}'
    And   Verify data displayed in report header and footer for '${FullName}' '${CustSiteName}' '${InspectionName}'
    And   Verify the pdf content of inspection report for inspection '${InspectionName}' with conveyor '${AssetName2}'
    And   Verify the pdf content of inspection report for inspection '${InspectionName}' with conveyor '${AssetName8}'

@Regression48.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DefaultSequence
Scenario: wVerify asset sequence for default template

    When  Navigate to add inspection screen
    Then  Verify Site '${CustSiteName}' selection from dropdown for default template
    When  Verify the add inspection item navigation
    And   Verify the asset sequencing logic for default template
    And   Verify the close add inspection item popup
    When  Verify the add inspection item navigation
    And   Verify the details field for selected asset '${ConveyorName}' '${AssetName1}'
    When  Verify the add inspection item navigation
    Then  Verify the failure mode for selected asset '${ConveyorName}' '${AssetName1}'
    When  Verify the add inspection item navigation
    And   Verify the details field for selected asset '${ConveyorName}' '${AssetName2}'
    When  Verify the add inspection item navigation
    Then  Verify the failure mode for selected asset '${ConveyorName}' '${AssetName2}'
    When  Verify the add inspection item navigation
    And   Verify the details field for selected asset '${ConveyorName}' '${AssetName3}'
    When  Verify the add inspection item navigation
    Then  Verify the failure mode for selected asset '${ConveyorName}' '${AssetName3}'

@Regression49.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_InspectionImage
Scenario: vVerify image zoom functionality

    When  Navigate to add inspection screen
    Then  Verify Site '${CustSiteName}' selection from dropdown for default template
    And   Fill inspection Item mandatory parameter for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'
    And   Fill inspection Item optional parameter for conveyor '${ConveyorName}' for '${InspectionName}' with '${observation}' '${recommendation}' '${address}' '${img}'
    Then  Verify the image zoom in capabilities
    Then  Verify the image zoom out capabilities
    And   Verify the close add inspection item popup

@Regression50.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_SiteLogo
Scenario: uVerify usite logo functionality in pdf

    When  Navigate to add inspection screen
    Then  Navigate to edit site screen for '${CustSiteName}'
    And   Add '${CorpImageName}' image to Corporate and save changes
    And   Download inspection '${InspectionName}' from inspection list with '${CustSiteName}' '${ConveyorName}'
    Then  Verify the site logo functionality in pdf report for '${InspectionName}'

@Regression51
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_InspectionLogo
Scenario: tVerify site and inspection item logo functionality in pdf

    When  Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    And   Select the inspection item with conveyor '${AssetName}'
    Then  Verify the export functionality of the single inspection item for inspection '${InspectionName}'
    And   Verify the site and item logo functionality in pdf report for '${InspectionName}'

@Regression52.5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_EventDelete
Scenario: sVerify action button functionality for event list screen

    When  Navigate to inspection list screen
    And   Select the inspection event '${InspectionName1}'
    And   Select the inspection event '${InspectionName2}'
    Then  Verify the action dropdown for multi event selection
    And   Verify delete button for multi inspection events
    And   Verify inspection '${InspectionName1}' is deleted from inspection list
    And   Verify inspection '${InspectionName2}' is deleted from inspection list
    When  Select the inspection event '${InspectionName3}'
    Then  Verify the action dropdown for single event selection

@Regression53 @vmc
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_NameColumnVMC
Scenario: Verify the functionality of inspection name column

    When  Navigate to inspection list screen
    Then  Verify column filter with '${ColumnName}' and '${ColumnNumber}'
    And   Verify name filter functionality with '${InspectionName1}' and '${ColumnNumber}'


@Regression54 @vmc
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_CorporateColumnVMC
Scenario: Verify the functionality of corporate column

    When  Navigate to inspection list screen
    Then  Verify column filter with '${ColumnName}' and '${ColumnNumber}'
    And   Verify corporate filter functionality with '${Corporate}' and '${ColumnNumber}'

@Regression55 @vmc
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_SiteColumnVMC
Scenario: Verify the functionality of site column

    When  Navigate to inspection list screen
    Then  Verify column filter with '${ColumnName}' and '${ColumnNumber}'
    And   Verify site filter functionality with '${Site}' and '${ColumnNumber}'


@Regression56 @vmc
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ConveyorColumnVMC
Scenario: Verify the functionality of conveyor column

    When  Navigate to inspection list screen
    Then  Verify column filter with '${ColumnName}' and '${ColumnNumber}'
    And   Verify conveyor filter functionality with '${Conveyor}' and '${ColumnNumber}'


@Regression57 @vmc
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ReportDownloadVMC
Scenario: Verify the download functionality

    When  Navigate to inspection list screen
    Then  Download inspection '${InspectionName7}' from inspection list with '${CustSiteName}' '${ConveyorName7}'

@Regression58 @vmc
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSingleInspectionVMC
Scenario: zVerify single conveyor inspection functionality for VMC template

    When  Navigate to add inspection screen
    Then  Verify Site '${CustSiteName}' selection from dropdown for VMC template
    And   Verify the inspection name functionality for site '${CustSiteName}'
    And   Enter inspection name as '${InspectionName}'
    And   Verify default date in inspection date field
    And   Verify auto-population of inspector name '${FullName}'
    And   Verify the inspection creation with success message
    And   Verify the inspection items columns for VMC
    And   Verify the add inspection item navigation
    And   Verify the close add inspection item popup
    And   Add inspection Item for VMC conveyor '${ConveyorName}' for '${CustSiteName}' with '${AssetName}' '${AssetDetail}' '${Condition}' '${Status}' '${Observation}' '${recommendation}' '${address}' '${img}'
    And   Add inspection Item for VMC conveyor '${ConveyorName}' for '${CustSiteName}' with '${AssetName1}' '${AssetDetail1}' '${Condition1}' '${Status}' '${Observation1}'
    And   Add inspection Item for VMC conveyor '${ConveyorName}' for '${CustSiteName}' with '${AssetName2}' '${AssetDetail2}' '${Condition2}' '${Status}' '${Observation2}'
    And   Verify the sorting order for inspection items for VMC
    And   Verify whether the inspection event '${InspectionName}' is present in list view
    And   Verify the column condition functionality from list screen for column '${ColumnNumberCondition}' and site '${InspectionName}'
    And   Verify the column status functionality from list screen '${Status}' for column '${ColumnNumberStatus}' and site '${InspectionName}'
    And   Verify the column conveyor functionality from list screen for column '${ColumnNumberConveyor}' and site '${InspectionName}' '${Count}'

@Regression59 @vmc
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddMultiInspectionVMC
Scenario: yVerify multi conveyor inspection functionality for VMC template

    When  Extract the inspection card count
    When  Navigate to add inspection screen
    Then  Verify Site '${CustSiteName}' selection from dropdown for VMC template
    And   Verify the inspection name functionality for site '${CustSiteName}'
    And   Enter inspection name as '${InspectionName}'
    And   Verify default date in inspection date field
    And   Verify auto-population of inspector name '${FullName}'
    And   Verify the inspection creation with success message
    And   Add inspection Item for VMC conveyor '${ConveyorName1}' for '${CustSiteName}' with '${AssetName}' '${AssetDetail}' '${Condition}' '${Status}' '${Observation}'
    And   Add inspection Item for VMC conveyor '${ConveyorName1}' for '${CustSiteName}' with '${AssetName1}' '${AssetDetail1}' '${Condition1}' '${Status}' '${Observation1}'
    And   Add inspection Item for VMC conveyor '${ConveyorName1}' for '${CustSiteName}' with '${AssetName2}' '${AssetDetail2}' '${Condition2}' '${Status}' '${Observation2}'
    And   Add inspection Item for VMC conveyor '${ConveyorName2}' for '${CustSiteName}' with '${AssetName3}' '${AssetDetail3}' '${Condition3}' '${Status}' '${Observation3}'
    And   Add inspection Item for VMC conveyor '${ConveyorName2}' for '${CustSiteName}' with '${AssetName4}' '${AssetDetail4}' '${Condition4}' '${Status}' '${Observation4}'
    And   Verify the sorting order for inspection items for VMC
    When  Navigate to inspection list screen
    And   Verify the incremental tile count changes for '${ChangeTotal}','${ChangeTobeComplated}','${ChangeGood}','${ChangeFault}','${ChangeCritical}'
    And   Verify whether the inspection event '${InspectionName}' is present in list view
    And   Verify the column condition functionality from list screen for column '${ColumnNumberCondition}' and site '${InspectionName}'
    And   Verify the column status functionality from list screen '${Status}' for column '${ColumnNumberStatus}' and site '${InspectionName}'
    And   Verify the column conveyor functionality from list screen for column '${ColumnNumberConveyor}' and site '${InspectionName}' '${Count}'


@Regression60 @vmc
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_tailPulleySeq
Scenario: ybVerify the asset display sequence for VMC

    When  Navigate to add inspection screen
    Then  Verify Site '${CustSiteName}' selection from dropdown for VMC template
    And   Verify the inspection name functionality for site '${CustSiteName}'
    And   Verify default date in inspection date field
    And   Verify auto-population of inspector name '${FullName}'
    And   Verify the add inspection item navigation
    And   Verify the asset display sequence for VMC

@Regression61 @vmc
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_tailPulleySeq
Scenario: yaVerify the asset tail pulley details sequence for VMC

    When  Navigate to add inspection screen
    Then  Verify Site '${CustSiteName}' selection from dropdown for VMC template
    And   Verify the inspection name functionality for site '${CustSiteName}'
    And   Verify default date in inspection date field
    And   Verify auto-population of inspector name '${FullName}'
    And   Verify the add inspection item navigation
    And   Verify the asset tail pulley detail sequence
    And   Verify condition for asset '${AssetName}' with '${AssetDetail1}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail2}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail3}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail4}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup

@Regression62 @vmc
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_beltDetailSeq
Scenario: xVerify the asset belt details sequence for VMC

    When  Navigate to add inspection screen
    Then  Verify Site '${CustSiteName}' selection from dropdown for VMC template
    And   Verify the inspection name functionality for site '${CustSiteName}'
    And   Verify default date in inspection date field
    And   Verify auto-population of inspector name '${FullName}'
    And   Verify the add inspection item navigation
    And   Verify the asset belt detail sequence
    And   Verify condition for asset '${AssetName}' with '${AssetDetail1}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail2}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail3}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail4}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail5}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup

@Regression63 @vmc
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_otherPulleySeq
Scenario: vVerify the asset other pulley details sequence for VMC

    When  Navigate to add inspection screen
    Then  Verify Site '${CustSiteName}' selection from dropdown for VMC template
    And   Verify the inspection name functionality for site '${CustSiteName}'
    And   Verify default date in inspection date field
    And   Verify auto-population of inspector name '${FullName}'
    And   Verify the add inspection item navigation
    And   Verify the asset other pulley detail sequence
    And   Verify condition for asset '${AssetName}' with '${AssetDetail1}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail2}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail3}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail4}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup

@Regression64 @vmc
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_BeltAlignmentSeq
Scenario: uVerify the asset belt alignment details sequence for VMC

    When  Navigate to add inspection screen
    Then  Verify Site '${CustSiteName}' selection from dropdown for VMC template
    And   Verify the inspection name functionality for site '${CustSiteName}'
    And   Verify default date in inspection date field
    And   Verify auto-population of inspector name '${FullName}'
    And   Verify the add inspection item navigation
    And   Verify the asset belt alignment detail sequence
    And   Verify condition for asset '${AssetName}' with '${AssetDetail1}' and conveyor '${ConveyorName}' for VMC belt
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail2}' and conveyor '${ConveyorName}' for VMC belt
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail3}' and conveyor '${ConveyorName}' for VMC belt
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail4}' and conveyor '${ConveyorName}' for VMC belt overall
    And   Verify the close add inspection item popup

@Regression65 @vmc
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_IdlersDetailsSeq
Scenario: uVerify the asset idlers details sequence for VMC

    When  Navigate to add inspection screen
    Then  Verify Site '${CustSiteName}' selection from dropdown for VMC template
    And   Verify the inspection name functionality for site '${CustSiteName}'
    And   Verify default date in inspection date field
    And   Verify auto-population of inspector name '${FullName}'
    And   Verify the add inspection item navigation
    And   Verify the asset idlers detail sequence
    And   Verify condition for asset '${AssetName}' with '${AssetDetail1}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation

@Regression66 @vmc
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_drivePulleySeq
Scenario: tVerify the asset drive pulley details sequence for VMC

    When  Navigate to add inspection screen
    Then  Verify Site '${CustSiteName}' selection from dropdown for VMC template
    And   Verify the inspection name functionality for site '${CustSiteName}'
    And   Verify default date in inspection date field
    And   Verify auto-population of inspector name '${FullName}'
    And   Verify the add inspection item navigation
    And   Verify the asset driver pulley detail sequence
    And   Verify condition for asset '${AssetName}' with '${AssetDetail1}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail2}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail3}' and conveyor '${ConveyorName}' for VMC
    And   Verify the close add inspection item popup

@Regression67 @vmc
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_drivePulleySeq
Scenario: sVerify the observation mandatory scenario

    When  Navigate to add inspection screen
    Then  Verify Site '${CustSiteName}' selection from dropdown for VMC template
    And   Verify the inspection name functionality for site '${CustSiteName}'
    And   Verify default date in inspection date field
    And   Verify auto-population of inspector name '${FullName}'
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail1}' and conveyor '${ConveyorName}' for VMC
    And   Verify for the condition 'Critical' observation field is mandatory
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail1}' and conveyor '${ConveyorName}' for VMC
    And   Verify for the condition 'Fault' observation field is mandatory

@Regression68 @vmc
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_drivePulleySeq
Scenario: rVerify the observation optional scenario

    When  Navigate to add inspection screen
    Then  Verify Site '${CustSiteName}' selection from dropdown for VMC template
    And   Verify the inspection name functionality for site '${CustSiteName}'
    And   Verify default date in inspection date field
    And   Verify auto-population of inspector name '${FullName}'
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail1}' and conveyor '${ConveyorName}' for VMC
    And   Verify for the condition 'Good' observation field is optional

@Regression69
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_EditInspectionVMC
Scenario: xVerify inspection item edit and delete functionality on edit mode

    When  Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    Then  Verify the edit button functionality in inspection view mode for inspection '${InspectionName}'
    And   Verify the site dropdown is disabled on edit mode
    When  Edit Inspection event name to '${EditInspectionName}'
    When  Search inspection Item with conveyor '${ConveyorName}' '${AssetName}' '${Condition}'
    Then  Verify the conveyor and asset field are disabled on edit mode
    When  Edit inspection Item condition for conveyor '${ConveyorName}' and '${AssetName}' to '${EditCondition}'
    Then  Verify the sorting order for inspection items for VMC
    When  Navigate to inspection list screen
    And   Verify the column condition functionality from list screen for column '${ColumnNumberCondition}' and site '${EditInspectionName}'
    And   Verify the column status functionality from list screen '${Status}' for column '${ColumnNumberStatus}' and site '${EditInspectionName}'
    And   Verify the column conveyor functionality from list screen for column '${ColumnNumberConveyor}' and site '${EditInspectionName}' '${Count}'
    And   Verify name filter functionality with '${EditInspectionName}' and '${ColumnNumber}'

@Regression70
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DeleteInspectionVMC
Scenario: zzpVerify inspection item delete functionality

    When  Navigate to Inspection detail page of the Inspection event '${EditInspectionName}'
    Then  Verify the edit button functionality in inspection view mode for inspection '${EditInspectionName}'
    When  Search inspection Item with conveyor '${ConveyorName}' '${AssetName}' '${Condition}'
    When  Delete default inspection Item for '${ConveyorName}' and '${AssetName}'
    Then  Verify the sorting order for inspection items for VMC

@Regression71
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemClearFilterVMC
Scenario: zzVerify uinspection item clear filter functionality

    When  Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    Then  Verify the edit button functionality in inspection view mode for inspection '${InspectionName}'
    Then  Verify column filter with '${Asset}' and '${ColumnNumber}'
    And   Verify asset filter functionality with '${Asset}' and '${ColumnNumber}'
    When  Clear filter for inspection items
    Then  Verify the clear filter functionality '${Asset}'

@Regression72
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemColumnSelectionVMC
Scenario: zxVerify uinspection item column selection functionality

    Then  Verify the edit button functionality in inspection view mode for inspection '${InspectionName}'
    And   Verify change column selection and disable '${ColumnName1}'
    When  Verify change column selection and disable '${ColumnName2}'

@Regression73
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemSearchVMC
Scenario: zwVerify vinspection item search functionality

    Then  Verify the edit button functionality in inspection view mode for inspection '${InspectionName}'
    And   Verify the search functionality of the inspection item with '${Asset}'
    And   Verify the search functionality of the inspection item with '${Detail}'

@Regression74
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemPdfVMC
Scenario: zvVerify multiple inspection items export functionality

    Then  Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    When  Select the inspection item with conveyor '${Asset1}'
    And   Select the inspection item with conveyor '${Asset2}'
    And   Verify the export functionality of the multiple inspection item for inspection '${InspectionName}'
    And   Verify the pdf content of inspection report for inspection '${InspectionName}' with conveyor '${Asset1}'
    And   Verify the pdf content of inspection report for inspection '${InspectionName}' with conveyor '${Asset2}'

@Regression75
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemDeleteVMC
Scenario: zuVerify multiple inspection items delete functionality

    And   Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    And   Select the inspection item with conveyor '${Asset1}'
    And   Select the inspection item with conveyor '${Asset2}'
    And   Delete inspection items record for inspection '${InspectionName}'
    Then  Verify the delete functionality of the inspection item for conveyor '${Asset1}'
    And   Verify the delete functionality of the inspection item for conveyor '${Asset1}'

@Regression76
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_GreenTickVMC
Scenario: ztVerify the status green tick icon for completed event

    When  Navigate to add inspection screen
    And   Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for VMC conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${Condition}' '${Status}' '${Observation}'
    And   Add inspection Item for VMC conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName1}' '${AssetDetail1}' '${Condition1}' '${Status1}' '${Observation}'
    And   Navigate to inspection list screen
    Then  Verify the status when to be completed for '${InspectionName}' with '${StatusCount}'
    And   Verify the edit button functionality in list view for inspection '${InspectionName}'
    When  Edit inspection Item status for '${ConveyorName}' '${AssetName}' to '${Status1}'
    And   Navigate to inspection list screen
    Then  Verify the status when completed for '${InspectionName}'

@Regression77
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_FlagsVMC
Scenario: zsVerify the condition flags functionality

    When  Navigate to add inspection screen
    And   Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for VMC conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${Condition}' '${Status1}' '${Observation}'
    And   Add inspection Item for VMC conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName1}' '${AssetDetail1}' '${Condition1}' '${Status}' '${Observation}' '${recommendation}' '${address}' '${img}'
    And   Add inspection Item for VMC conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName2}' '${AssetDetail2}' '${Condition2}' '${Status}' '${Observation}'
    And   Navigate to inspection list screen
    Then  Verify the conditions flag column for inspection '${InspectionName}' with '${FlagCount}'
    And   Verify the edit button functionality in list view for inspection '${InspectionName}'
    When  Edit inspection Item status for '${ConveyorName}' '${AssetName}' to '${Status}'
    When  Edit inspection Item status for '${ConveyorName}' '${AssetName2}' to '${Status1}'
    And   Navigate to inspection list screen
    Then  Verify the conditions flag column for inspection '${InspectionName}' with '${FlagCount}'

@Regression78
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ExpandVMC
Scenario: zrVerify the expand event functionality

    Then  Verify And validate the changes for '${InspectionName}' with '${ItemCount}'
    When  Navigate to inspection list screen
    And   Expand the inspection event to display inspection items for '${InspectionName}'
    And   Verify the column displayed for expanded list table
    And   Verify the all inspection items are present in expanded view for VMC
    And   Verify the location column for map popup in expanded view

@Regression79
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Navigation
Scenario: zqVerify the pagination functionality

    When  Navigate to inspection list screen
    And   Verify inspection event navigation to next pagination screen
    And   Verify inspection event the page limit functionality
    Then  Verify the inspection event pagination count


@Regression80
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ClearFilterVMC
Scenario: zpVerify the clear filter functionality in event list

    When  Navigate to inspection list screen
    Then  Verify column filter with '${ColumnName}' and '${ColumnNumber}'
    And   Verify name filter functionality with '${InspectionName}' and '${ColumnNumber}'
    When  Clear filter for inspection items
    Then  Verify the clear filter functionality '${ColumnName}'

@Regression81
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ColumnSelectionVMC
Scenario: zoVerify inspection event column selection functionality

    When  Navigate to inspection list screen
    And   Verify change column selection and disable '${ColumnName1}'
    When  Verify change column selection and disable '${ColumnName2}'

@Regression82
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Search_VMC
Scenario: znVerify inspection event search functionality

    When  Navigate to inspection list screen
    And   Verify the search functionality of the inspection event with '${InspectionName}'
    And   Verify the search functionality of the inspection event with '${CustSiteName}'
    And   Verify the search functionality of the inspection event with '${Inspector}'

@Regression83
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Navigation
Scenario: zmVerify inspection card count with pagination count

    When  Navigate to inspection list screen and wait for data load
    And   Extract the inspection card count
    And   Verify the total inspection event count with list
    Then  Verify if is able to switch from group view to list view
    And   Verify the filter functionality with status 'To be Completed'
    And   Verify the filter functionality with condition 'Good'
    And   Verify the filter functionality with condition 'Critical'
    And   Verify the filter functionality with condition 'Fault'
    And   Verify the filter functionality with condition 'Poor'

@Regression84
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DeleteItem_VMC
Scenario: zlVerify inspection item delete functionality from event and verifying in item list

    When  Navigate to inspection list screen
    And   Verify the edit button functionality in list view for inspection '${InspectionName}'
    When  Search inspection Item with conveyor '${ConveyorName}' '${AssetName}' '${Condition}'
    Then  Delete default inspection Item for '${ConveyorName}' and '${AssetName}'
    When  Navigate to inspection list screen
    And   Verify if is able to switch from group view to list view
    And   Search for inspection Item from list page for inspection '${InspectionName}'
    And   Verify asset filter functionality with '${AssetName}' and '${ColumnNumber}'
    And   Add filter functionality with condition '${Condition}'
    Then  Verify the delete functionality of the inspection item for conveyor '${ConveyorName}'

@Regression85
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemColumnSortVMC
Scenario: zkVerify inspection item column functionality from item list

    When  Navigate to inspection list screen
    When  Verify if is able to switch from group view to list view
    And   Enable all columns from column selection
    Then  Verify all the column for inspection item list
    And   Verify column filter with 'Inspection Name' and '${ColumnNumber1}'
    When  Clear filter for inspection items
    Then  Verify the clear filter functionality 'Inspection Name'
    And   Verify column filter with 'Inspection Date' and '${ColumnNumber2}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Inspection Date'
    And   Verify column filter with 'Site' and '${ColumnNumber3}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Corporate'
    And   Verify column filter with 'Conveyor' and '${ColumnNumber5}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Site'
    And   Verify column filter with 'Corporate' and '${ColumnNumber4}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Conveyor'
    And   Verify column filter with 'Inspector' and '${ColumnNumber6}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Inspector'
    And   Verify column filter with 'Last Modified' and '${ColumnNumber7}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Last Modified'
    And   Verify column filter with 'Asset' and '${ColumnNumber8}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Asset'
    And   Verify column filter with 'Detail' and '${ColumnNumber9}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Detail'
    And   Verify column filter with 'Failure Mode' and '${ColumnNumber10}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Failure Mode'
    And   Add filter functionality with status '${Status}'
    When  Clear filter for inspection items
    And   Verify the condition column item filter with '${Condition}' '${ColumnNumber}'
    When  Clear filter for inspection items

@Regression86
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemActionsVMC
Scenario: zjVerify inspection item action functionality from item list

    When  Navigate to inspection list screen
    When  Verify if is able to switch from group view to list view
    When  Search inspection Item from list view with conveyor '${InspectionName}' '${AssetName}' '${Condition}'
    Then  Verify edit inspection item from list '${AssetName}' to '${EditStatus}'
    When  Navigate to inspection list screen
    When  Verify if is able to switch from group view to list view
    When  Search inspection Item from list view with conveyor '${InspectionName}' '${AssetName}' '${Condition}'
    Then  Verify deleted inspection item from list '${ConveyorName}' for '${Asset}'
    When  Verify if is able to switch from list view to group view
    And   Expand the inspection event to display inspection items for '${InspectionName}'
    Then  Verify the all inspection items are present in expanded view for VMC

@Regression88
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_PDFMultiInspectionVMC
Scenario: ziVerify download pdf functionality

    When  Navigate to add inspection screen
    Then  Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for VMC conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName1}' '${AssetDetail1}' '${Condition1}' '${Status}' '${Observation1}'
    And   Add inspection Item for VMC conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName2}' '${AssetDetail2}' '${Condition2}' '${Status}' '${Observation2}'
    And   Add inspection Item for VMC conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName3}' '${AssetDetail3}' '${Condition3}' '${Status}' '${Observation3}' '${recommendation}' '${address}' '${img}'
    And   Add inspection Item for VMC conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName4}' '${AssetDetail4}' '${Condition4}' '${Status1}' '${Observation4}'
    And   Add inspection Item for VMC conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName5}' '${AssetDetail5}' '${Condition5}' '${Status}' '${Observation5}' '${recommendation}' '${address}' '${img}'
    And   Add inspection Item for VMC conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName6}' '${AssetDetail6}' '${Condition6}' '${Status}' '${Observation6}'
    And   Add inspection Item for VMC conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName7}' '${AssetDetail7}' '${Condition7}' '${Status}' '${Observation7}'
    And   Add inspection Item for VMC conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName8}' '${AssetDetail8}' '${Condition8}' '${Status1}' '${Observation8}'
    Then  Download inspection '${InspectionName}' from inspection list with '${CustSiteName}' '${ConveyorName}'
    And   Verify data displayed in report header and footer for '${FullName}' '${CustSiteName}' '${InspectionName}'
    And   Verify data displayed in inspection table for '${InspectionName}' for VMC


@Regression89
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_PDFMultiInspectionVMC
Scenario: zhVerify unit conversion in pdf

    When  Navigate to inspection list screen
    And   Download inspection '${InspectionName}' from inspection list with '${CustSiteName}' '${ConveyorName}'
    Then  Verify the inspection pdf report for metric for '${InspectionName}'
    When  Switch the unit conversion to 'imperial'
    And   Download inspection '${InspectionName}' from inspection list with '${CustSiteName}' '${ConveyorName}'
    Then  Verify the inspection pdf report for imperial for '${InspectionName}'

@Regression90
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_PDFMultiInspectionVMC
Scenario: zgVerify item report pdf download

    When  Navigate to inspection list screen
    And   Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    When  Select the inspection item with conveyor '${AssetName2}'
    And   Select the inspection item with conveyor '${AssetName8}'
    Then  Verify the export functionality of the multiple inspection item for inspection '${InspectionName}'
    And   Verify data displayed in report header and footer for '${FullName}' '${CustSiteName}' '${InspectionName}'
    And   Verify the pdf content of inspection report for inspection '${InspectionName}' with conveyor '${AssetName2}'
    And   Verify the pdf content of inspection report for inspection '${InspectionName}' with conveyor '${AssetName8}'

@Regression91
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DuplicateItemsVMC
Scenario: zfVerify duplicate inspection item in VMC

    Then  Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for VMC conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${Condition}' '${Status}' '${Observation}'
    When  Verify the add inspection item navigation
    And   Verify the duplicate inspection item for VMC '${ConveyorName}' with '${AssetName}' '${AssetDetail}'

@Regression92
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_InspectionImageVMC
Scenario: zeVerify image zoom functionality

    When  Navigate to add inspection screen
    Then  Verify Site '${CustSiteName}' selection from dropdown for VMC template
    And   Fill inspection Item mandatory parameter for VMC conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${Condition}' '${Status}' '${Observation}'
    And   Fill inspection Item optional parameter for VMC conveyor '${ConveyorName}' for '${InspectionName}' with '${recommendation}' '${address}' '${img}'
    Then  Verify the image zoom in capabilities
    Then  Verify the image zoom out capabilities
    And   Verify the close add inspection item popup

@Regression93
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_SiteLogoVMC
Scenario: zdVerify usite logo functionality in pdf

    When  Navigate to add inspection screen
    Then  Navigate to edit site screen for '${CustSiteName}'
    And   Add '${CorpImageName}' image to Corporate and save changes
    And   Download inspection '${InspectionName}' from inspection list with '${CustSiteName}' '${ConveyorName}'
    Then  Verify the site logo functionality in pdf report for '${InspectionName}'

@Regression94
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_InspectionLogoVMC
Scenario: zcVerify site and inspection item logo functionality in pdf

    When  Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    And   Select the inspection item with conveyor '${AssetName}'
    Then  Verify the export functionality of the single inspection item for inspection '${InspectionName}'
    And   Verify the site and item logo functionality in pdf report for '${InspectionName}'

@Regression95
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_EventDeleteVMC
Scenario: zbVerify action button functionality for event list screen

    When  Navigate to inspection list screen
    And   Select the inspection event '${InspectionName1}'
    And   Select the inspection event '${InspectionName2}'
    Then  Verify the action dropdown for multi event selection
    And   Verify delete button for multi inspection events
    And   Verify inspection '${InspectionName1}' is deleted from inspection list
    And   Verify inspection '${InspectionName2}' is deleted from inspection list
    When  Select the inspection event '${InspectionName3}'
    Then  Verify the action dropdown for single event selection

@Regression96
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_InspectionDashboardVMC
Scenario: zzyVerify inspection dashboard screen for VMC

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}' and wait for pageload
    And   Add customer corporate with '${CustCorpName}' and '${CustCorpAddress}' '${InsTemplate}'
    And   Create a Customer site '${CustSiteName}' and '${CustSiteAddress}' and '${CustCorpName}' and '${DistShopName}' and '${FullName}' and '${TerritoryInd}'
    And   Create a conveyor with '${ConveyorName1}' and '${DistShopName}' and '${CustSiteName}'
    And   Create a conveyor with '${ConveyorName2}' and '${DistShopName}' and '${CustSiteName}'
    And   Create a conveyor with '${ConveyorName3}' and '${DistShopName}' and '${CustSiteName}'
    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    And   Extract the inspection dashboard count for VMC
    Then  Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for VMC conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${Condition}' '${Status}' '${Observation}'
    And   Add inspection Item for VMC conveyor '${ConveyorName2}' for '${InspectionName}' with '${AssetName1}' '${AssetDetail1}' '${Condition}' '${Status}' '${Observation}'
    And   Add inspection Item for VMC conveyor '${ConveyorName3}' for '${InspectionName}' with '${AssetName2}' '${AssetDetail2}' '${Condition1}' '${Status}' '${Observation}'
    And   Add inspection Item for VMC conveyor '${ConveyorName3}' for '${InspectionName}' with '${AssetName3}' '${AssetDetail3}' '${Condition}' '${Status1}' '${Observation}'
    And   Add inspection Item for VMC conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName4}' '${AssetDetail4}' '${Condition}' '${Status}' '${Observation}'
    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    And   Verify the dashboard tile count changes for '${ChangeTotal}','${ChangeGood}','${ChangeFault}','${ChangeCritical}'

@Regression97
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_InspectionDashboardVMC
Scenario: zxVerify elements displayed on inspection dashboard screen for VMC

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    And   Verify the header of the inspection dashboard screen
    And   Verify the options available in inspection dashboard screen
    And   Verify the action dropdown for inspection dashboard
    And   Verify the event cards in dashboard screen for VMC
    And   Verify the item list table in dashboard screen for VMC

@Regression98
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_InspectionDashboardDefault
Scenario: zwVerify inspection dashboard screen for default

    And   Add customer corporate with '${CustCorpName}' and '${CustCorpAddress}' '${InsTemplate}'
    And   Create a Customer site '${CustSiteName}' and '${CustSiteAddress}' and '${CustCorpName}' and '${DistShopName}' and '${FullName}' and '${TerritoryInd}'
    And   Create a conveyor with '${ConveyorName1}' and '${DistShopName}' and '${CustSiteName}'
    And   Create a conveyor with '${ConveyorName2}' and '${DistShopName}' and '${CustSiteName}'
    And   Create a conveyor with '${ConveyorName3}' and '${DistShopName}' and '${CustSiteName}'
    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    And   Extract the inspection dashboard count
    Then  Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName1}' '${AssetDetail1}' '${FailureMode1}' '${Condition1}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName2}' for '${InspectionName}' with '${AssetName2}' '${AssetDetail2}' '${FailureMode2}' '${Condition1}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName3}' for '${InspectionName}' with '${AssetName3}' '${AssetDetail3}' '${FailureMode3}' '${Condition1}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName3}' for '${InspectionName}' with '${AssetName4}' '${AssetDetail4}' '${FailureMode4}' '${Condition2}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName5}' '${AssetDetail5}' '${FailureMode5}' '${Condition1}' '${Status}'
    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    And   Verify the dashboard tile count changes for '${ChangeTotal}','${ChangeGood}','${ChangePoor}','${ChangeFault}','${ChangeCritical}'

@Regression99
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_InspectionDashboardDefault
Scenario: zvVerify elements displayed on inspection dashboard screen for default

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    And   Verify the header of the inspection dashboard screen
    And   Verify the options available in inspection dashboard screen
    And   Verify the action dropdown for inspection dashboard
    And   Verify the event cards in dashboard screen
    And   Verify the item list table in dashboard screen

@Regression100
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DashboardPDFForVMC
Scenario: zuVerify inspection dashboard export functionality for VMC

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    And   Verify the export functionality of the inspection dashboard
    And   Verify the pdf content of inspection report for coporate '${CustCorpName}' with conveyor '${FullName}'

@Regression101
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DashboardPDFForDefault
Scenario: zsVerify inspection dashboard export functionality for Default

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    And   Verify the export functionality of the inspection dashboard
    And   Verify the pdf content of inspection report for coporate '${CustCorpName}' with conveyor '${FullName}'

@Regression102
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DashboardPDFForDefault
Scenario: zrVerify select site functionality from inspection dashboard

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    And   Verify the site selection functionality for '${CustSiteName}'


@Regression103
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DashboardPDFForDefault
Scenario: zqVerify select from field functionality from inspection dashboard

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    And   Verify the from field date functionality for '${CustSiteName}'


@Regression104
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DashboardPDFForDefault
Scenario: zpVerify select to field functionality from inspection dashboard

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    And   Verify the to field date functionality for '${CustSiteName}'

@Regression105
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DashboardPDFForDefault
Scenario: zoVerify export pdf when date range is selected

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    And   Verify the site selection functionality for '${CustSiteName}'
    And   Verify the from field date functionality for '${CustSiteName}'
    And   Verify the to field date functionality for '${CustSiteName}'
    And   Verify the export functionality of the inspection dashboard
    And   Verify the pdf content of inspection report for coporate '${CustCorpName}' with conveyor '${FullName}'


@Regression106
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DashboardPDFForDefault
Scenario: znVerify sorting applied for event table column

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    Then  Verify all the column for inspection dashboard event table list
    And   Verify column filter with 'Asset' and '${ColumnNumber1}'
    When  Clear filter for inspection items
    Then  Verify the clear filter functionality 'Asset'
    And   Verify column filter with 'Failure Mode' and '${ColumnNumber2}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Failure Mode'
    And   Verify column filter with 'Inspection Item %' and '${ColumnNumber3}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Inspection Item %'
    And   Verify column filter with 'Inspection Item Σ' and '${ColumnNumber4}'
    When  Clear filter for inspection items
    Then  Verify the clear filter functionality 'Inspection Item Σ'

@Regression107
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DashboardPDFForDefault
Scenario: zmVerify filter applied for event table column

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    Then  Verify all the column for inspection dashboard event table list
    And   Verify column filter with 'Asset' and '${ColumnNumber1}'
    When  Clear filter for inspection items
    When  Verify the clear filter functionality 'Asset'

@Regression108
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DashboardPDFForDefault
Scenario: zlVerify search applied for event table column

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    Then  Verify the search functionality of the dashboard event with '${AssetName}'
    And   Verify the pagination count


@Regression109
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DashboardPDFForVMC
Scenario: zjVerify select site functionality from inspection dashboard for VMC

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    And   Verify the site selection functionality for '${CustSiteName}'


@Regression110
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DashboardPDFForVMC
Scenario: ziVerify select from field functionality from inspection dashboard for VMC

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    And   Verify the from field date functionality for '${CustSiteName}'


@Regression111
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DashboardPDFForVMC
Scenario: Verify select to field functionality from inspection dashboard for VMC

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    And   Verify the to field date functionality for '${CustSiteName}'

@Regression112
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DashboardPDFForVMC
Scenario: Verify export pdf when date range is selected for VMC

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    And   Verify the site selection functionality for '${CustSiteName}'
    And   Verify the from field date functionality for '${CustSiteName}'
    And   Verify the to field date functionality for '${CustSiteName}'
    And   Verify the export functionality of the inspection dashboard
    And   Verify the pdf content of inspection report for coporate '${CustCorpName}' with conveyor '${FullName}'


@Regression113
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DashboardPDFForVMC
Scenario: Verify sorting applied for event table column for VMC

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    Then  Verify all the column for inspection dashboard event table list for VMC
    And   Verify column filter with 'Asset' and '${ColumnNumber1}'
    When  Clear filter for inspection items
    Then  Verify the clear filter functionality 'Asset'
    And   Verify column filter with 'Inspection Item %' and '${ColumnNumber2}'
    When  Clear filter for inspection items
    And   Verify the clear filter functionality 'Inspection Item %'
    And   Verify column filter with 'Inspection Item Σ' and '${ColumnNumber3}'
    When  Clear filter for inspection items
    Then  Verify the clear filter functionality 'Inspection Item Σ'

@Regression114
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DashboardPDFForVMC
Scenario: Verify filter applied for event table column for VMC

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    Then  Verify all the column for inspection dashboard event table list for VMC
    And   Verify column filter with 'Asset' and '${ColumnNumber1}'
    When  Clear filter for inspection items
    When  Verify the clear filter functionality 'Asset'

@Regression115
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DashboardPDFForVMC
Scenario: Verify search applied for event table column for VMC

    And   Navigate to inspection list from inspection card at corporate level '${CustCorpName}'
    And   Click on inspection dashboard symbol and verify user is able to click on dashboard
    Then  Verify the search functionality of the dashboard event with '${AssetName}'
    And   Verify the pagination count

@Regression116 @tc
@csvDataFile:resources/data/Inspection.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:Ins_001
Scenario: BVerify inspection total conveyance template functionality for customer corporate

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}' and wait for pageload
    And   Navigation of corporate list screen
    And   Navigate to add corporate from list screen
    And   Navigation of corporate list screen
    And   Navigate to add corporate from list screen
    Then  Verify Default should be selected under inspection template
    And   Add customer corporate with '${CustCorpName}' and '${CustCorpAddress}' '${InsTemplate}'
    And   Navigate to edit corporate for '${CustCorpName}'
    And   Verify whether inspection template dropdown '${InsTemplate}' is disabled

@Regression117
@csvDataFile:resources/data/Inspection.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:Ins_002
Scenario: AVerify total conveyance inspection functionality

    When  Navigate to inspection list screen
    And   Create a Customer site '${CustSiteName}' and '${CustSiteAddress}' and '${CustCorpName}' and '${DistShopName}' and '${FullName}' and '${TerritoryInd}'
    And   Navigate to Conveyor Bulk Upload
    And   Add two conveyor via bulk upload in site '${CustSiteName}' with file '${FileUpload}'
    When  Navigate to add inspection screen
    Then  Verify the breadcrumb of the add page
    And   Verify Site '${CustSiteName}' selection from dropdown for TC template
    And   Verify Conveyor '${ConveyorName}' selection from dropdown for TC template
    And   Verify the inspection name functionality for site '${CustSiteName}'
    And   Enter inspection name as '${InspectionName}'
    And   Verify default date in inspection date field
    And   Verify auto-population of inspector name '${FullName}'
    And   Verify weather inspection template dropdown '${InsTemplate}' is disabled in add screen
    And   Verify the productivity field with '${Productivity}'
    And   Verify the uptime field with '${Uptime}'
    And   Verify profile image upload is disabled from add screen
    And   Verify the inspection creation with success message
#    And   Verify the conveying length value from conveyor card with '${ConveyingLength}' for '${ConveyorName}'
    And   Verify the productivity value from productivity card with '${Productivity}' and change '${ProductivityChange}' with indicator as '${ProductivityIndicator}'
    And   Verify the uptime value from uptime card with '${Uptime}' and change '${UpTimeChange}' with indicator as '${UpTimeIndicator}'
    And   Verify the system health value from system health card with '${SystemHealth}' and change '${SystemhealthChange}' with indicator as '${SystemHealthIndicator}'
    And   Verify the inspection items columns for VMC
    And   Verify the add inspection item navigation
    And   Verify the close add inspection item popup
    And   Add inspection Item for TC conveyor '${ConveyorName}' for '${CustSiteName}' with '${AssetName1}' '${AssetDetail1}' '${Condition1}' '${Status}' '${observation}' '${recommendation}' '${address}' '${img}'
    And   Add inspection Item for TC conveyor '${ConveyorName}' for '${CustSiteName}' with '${AssetName2}' '${AssetDetail2}' '${Condition2}' '${Status}'
    And   Verify the sorting order for inspection items for TC
    And   Verify whether the inspection event '${InspectionName}' is present in list view

@Regression118 @tc
@csvDataFile:resources/data/Inspection.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:Ins_001
Scenario: zzzVerify the conveyor graph on the inspection details page

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    And   Verify heather the conveyor graph is present
    And   Verify the header for the conveyor graph
    And   Verify all the traffic lights are visisble
    And   Verify the pipe shape dropdown contents
    And   Verify the pipe shape fields
    And   Verify the belt condition fields
    And   Verify the summary field is present

@Regression119 @tc
@csvDataFile:resources/data/Inspection.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:Ins_001
Scenario: zzzVerify the sections in inspection item popup for total conveyance

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    And   Verify the add inspection item navigation
    And   Verify the asset section in items popup for TC

@Regression120 @tc
@csvDataFile:resources/data/Inspection.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:Ins_001
Scenario: zzzVerify the asset tail display sequence for total conveyance

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    And   Verify the add inspection item navigation
    And   Verify the asset tail display sequence for TC
    And   Verify condition for asset '${AssetName}' with '${AssetDetail1}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail2}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail3}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail4}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail5}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup

@Regression121 @tc
@csvDataFile:resources/data/Inspection.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:Ins_001
Scenario: zzzVerify the asset center display sequence for total conveyance

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    And   Verify the add inspection item navigation
    And   Verify the asset center display sequence for TC
    And   Verify condition for asset '${AssetName}' with '${AssetDetail1}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail2}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail3}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail4}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail5}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup

@Regression122 @tc
@csvDataFile:resources/data/Inspection.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:Ins_001
Scenario: zzzVerify the asset head display sequence for total conveyance

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    And   Verify the add inspection item navigation
    And   Verify the asset head display sequence for TC
    And   Verify condition for asset '${AssetName}' with '${AssetDetail1}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail2}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail3}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail4}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail5}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup

@Regression123 @tc
@csvDataFile:resources/data/Inspection.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:Ins_001
Scenario: zzzVerify the asset belt display sequence for total conveyance

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    And   Verify the add inspection item navigation
    And   Verify the asset belt display sequence for TC
    And   Verify condition for asset '${AssetName}' with '${AssetDetail1}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail2}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail3}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail4}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail5}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup

@Regression124 @tc
@csvDataFile:resources/data/Inspection.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:Ins_001
Scenario: zzzVerify the asset belt display sequence for total conveyance

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    And   Verify the add inspection item navigation
    And   Verify the asset belt display sequence for TC
    And   Verify condition for asset '${AssetName}' with '${AssetDetail1}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail2}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail3}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail4}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup
    And   Verify the add inspection item navigation
    And   Verify condition for asset '${AssetName}' with '${AssetDetail5}' and conveyor '${ConveyorName}' for TC
    And   Verify the close add inspection item popup

@Regression261
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_EditInspectionDefault
Scenario: zaVerify inspection item edit and delete functionality on edit mode

    When  Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    Then  Verify the edit button functionality in inspection view mode for inspection '${InspectionName}'
    And   Verify the site dropdown is disabled on edit mode
    When  Edit Inspection event name to '${EditInspectionName}'
    When  Search inspection Item with conveyor '${ConveyorName}' '${AssetName}' '${Condition}'
    Then  Verify the conveyor and asset field are disabled on edit mode
    When  Edit inspection Item condition for conveyor '${ConveyorName}' and '${AssetName}' to '${EditCondition}'
    Then  Verify the sorting order for inspection items
    When  Navigate to inspection list screen
    And   Verify the column condition functionality from list screen for column '${ColumnNumberCondition}' and site '${EditInspectionName}'
    And   Verify the column status functionality from list screen '${Status}' for column '${ColumnNumberStatus}' and site '${EditInspectionName}'
    And   Verify the column conveyor functionality from list screen for column '${ColumnNumberConveyor}' and site '${EditInspectionName}' '${Count}'
    And   Verify name filter functionality with '${EditInspectionName}' and '${ColumnNumber}'

@Regression27
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_DeleteInspectionDefault
Scenario: yzVerify uinspection item delete functionality

    When  Navigate to Inspection detail page of the Inspection event '${EditInspectionName}'
    Then  Verify the edit button functionality in inspection view mode for inspection '${EditInspectionName}'
    When  Search inspection Item with conveyor '${ConveyorName}' '${AssetName}' '${Condition}'
    When  Delete default inspection Item for '${ConveyorName}' and '${AssetName}'
    Then  Verify the sorting order for inspection items

@Regression28
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemClearFilter
Scenario: yyVerify uinspection item clear filter functionality

    When  Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    Then  Verify the edit button functionality in inspection view mode for inspection '${InspectionName}'
    Then  Verify column filter with '${Asset}' and '${ColumnNumber}'
    And   Verify asset filter functionality with '${Asset}' and '${ColumnNumber}'
    When  Clear filter for inspection items
    Then  Verify the clear filter functionality '${Asset}'

@Regression29
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemColumnSelection
Scenario: yxVerify uinspection item column selection functionality

    Then  Verify the edit button functionality in inspection view mode for inspection '${InspectionName}'
    And   Verify change column selection and disable '${ColumnName1}'
    When  Verify change column selection and disable '${ColumnName2}'

@Regression30
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemSearch
Scenario: ywVerify vinspection item search functionality

    Then  Verify the edit button functionality in inspection view mode for inspection '${InspectionName}'
    And   Verify the search functionality of the inspection item with '${Asset}'
    And   Verify the search functionality of the inspection item with '${Detail}'
    And   Verify the search functionality of the inspection item with '${FailureMode}'

@Regression31
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ItemPDF
Scenario: yvVerify multiple inspection items export functionality

    Then  Navigate to Inspection detail page of the Inspection event '${InspectionName}'
    When  Select the inspection item with conveyor '${Asset1}'
    And   Select the inspection item with conveyor '${Asset2}'
    And   Verify the export functionality of the multiple inspection item for inspection '${InspectionName}'
    And   Verify the pdf content of inspection report for inspection '${InspectionName}' with conveyor '${Asset1}'
    And   Verify the pdf content of inspection report for inspection '${InspectionName}' with conveyor '${Asset2}'

@Regression33
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_GreenTick
Scenario: ytVerify the status green tick icon for completed event

    When  Navigate to add inspection screen
    And   Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName1}' '${AssetDetail1}' '${FailureMode1}' '${Condition1}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName2}' '${AssetDetail2}' '${FailureMode2}' '${Condition2}' '${Status1}'
    And   Navigate to inspection list screen
    Then  Verify the status when to be completed for '${InspectionName}' with '${StatusCount}'
    And   Verify the edit button functionality in list view for inspection '${InspectionName}'
    When  Edit inspection Item status for '${ConveyorName}' '${AssetName1}' to '${Status1}'
    And   Navigate to inspection list screen
    Then  Verify the status when completed for '${InspectionName}'

@Regression34
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Flags
Scenario: ysVerify the condition flags functionality

    When  Navigate to add inspection screen
    And   Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName1}' '${AssetDetail1}' '${FailureMode1}' '${Condition1}' '${Status1}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName2}' '${AssetDetail2}' '${FailureMode2}' '${Condition2}' '${Status}' '${observation}' '${recommendation}' '${address}' '${img}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName3}' '${AssetDetail3}' '${FailureMode3}' '${Condition3}' '${Status}'
    And   Navigate to inspection list screen
    Then  Verify the conditions flag column for inspection '${InspectionName}' with '${FlagCount}'
    And   Verify the edit button functionality in list view for inspection '${InspectionName}'
    When  Edit inspection Item status for '${ConveyorName}' '${AssetName1}' to '${Status}'
    When  Edit inspection Item status for '${ConveyorName}' '${AssetName2}' to '${Status1}'
    And   Navigate to inspection list screen
    Then  Verify the conditions flag column for inspection '${InspectionName}' with '${FlagCount}'

@Regression35
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Expand
Scenario: yrVerify the expand event functionality

    Then  Verify And validate the changes for '${InspectionName}' with '${ItemCount}'
    When  Navigate to inspection list screen
    And   Expand the inspection event to display inspection items for '${InspectionName}'
    And   Verify the column displayed for expanded list table
    And   Verify the all inspection items are present in expanded view
    And   Verify the location column for map popup in expanded view

@Regression45
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_PDFMultiInspection
Scenario: zVerify download pdf functionality

    When  Navigate to add inspection screen
    Then  Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName1}' '${AssetDetail1}' '${FailureMode1}' '${Condition1}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName2}' '${AssetDetail2}' '${FailureMode2}' '${Condition2}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName3}' '${AssetDetail3}' '${FailureMode3}' '${Condition3}' '${Status}' '${observation}' '${recommendation}' '${address}' '${img}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName4}' '${AssetDetail4}' '${FailureMode4}' '${Condition4}' '${Status1}'
    And   Add inspection Item for conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName5}' '${AssetDetail5}' '${FailureMode5}' '${Condition5}' '${Status}' '${observation}' '${recommendation}' '${address}' '${img}'
    And   Add inspection Item for conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName6}' '${AssetDetail6}' '${FailureMode6}' '${Condition6}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName7}' '${AssetDetail7}' '${FailureMode7}' '${Condition7}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName8}' '${AssetDetail8}' '${FailureMode8}' '${Condition8}' '${Status1}'
    Then  Download inspection '${InspectionName}' from inspection list with '${CustSiteName}' '${ConveyorName}'
    And   Verify data displayed in report header and footer for '${FullName}' '${CustSiteName}' '${InspectionName}'
    And   Verify data displayed in inspection table for '${InspectionName}'
