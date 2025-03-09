package com.web.steps;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ConveyorSteps {

    ConveyorPage conveyorPage = new ConveyorPage();
    MonitoringDevicePage monitoringDevicePage = new MonitoringDevicePage();
    CorporatePage corporatePage = new CorporatePage();
    CoverWearPage coverWearPage=new CoverWearPage();
    SitePage sitePage = new SitePage();
    CordInspectPage cordInspectPage=new CordInspectPage();
    UsersPage userpage = new UsersPage();

    String[] monitoringDeviceColName = {"Name", "Device Type","Serial Number", "Site", "Conveyor", "Territory", "Carcass","Location", "Last Service Date", "Belt/Conveyor Saves"};


    @QAFTestStep(description = "Create a conveyor with {ConveyorNameGer} and {DistShopGerName} and {CustShopGerName}")
    public void createAConveyor(String conveyorName, String distShopName, String custSiteName) {
//        String conveyorId = conveyorPage.apiBase.getConveyorID(conveyorPage.apiBase.getConveyorsAPI(conveyorName));
//        conveyorPage.apiBase.deleteConveyorAPI(conveyorId);
        conveyorPage.createConveyor(conveyorName, distShopName, custSiteName);
    }

    @QAFTestStep(description = "Create a new conveyor with {ConveyorName1} and {DistShopAusName} and {CustSiteNZName}")
    public void createAnewConveyorWithRequiredFields(String conveyorName, String distShopName, String custSiteName) {
        String conveyorId = conveyorPage.apiBase.getConveyorID(conveyorPage.apiBase.getConveyorsAPI(conveyorName));
        conveyorPage.apiBase.deleteConveyorAPI(conveyorId);
        System.out.println("after delete apiBase");

        conveyorPage.createConveyorWithRequiredField(conveyorName, distShopName, custSiteName);
        conveyorPage.clickCreateBtn();
    }

    @QAFTestStep(description = "Enter the conveyor fields with {ConveyorName} and {DistShopName} and {CustSiteName}")
    public void enterTheConveyorFields(String conveyorName, String distShopName, String custSiteName) {
        conveyorPage.enterConveyorDetails(conveyorName, distShopName, custSiteName);
    }


    @QAFTestStep(description = "Create a duplicate conveyor with {ConveyorName1} and {DistShopAusName} and {CustSiteNZName}")
    public void createADuplicateConveyor(String conveyorName, String distShopName, String custSiteName) {
        conveyorPage.waitForPageLoad(20000);
//        SyncUtil.waitFor(20000);
        conveyorPage.createDuplicateConveyor(conveyorName, distShopName, custSiteName);
    }

    @QAFTestStep(description = "Verify conveyor technical data with {ConveyorName1}")
    public void verifyTechnicalData(String conveyorName) {
        conveyorPage.verifyTechnicalData(conveyorName);
    }

    @QAFTestStep(description = "Delete Conveyor from Conveyor list screen {ConveyorName1}")
    public void deleteConveyorFromConveyorListScreen(String conveyorName) {
        conveyorPage.deleteConveyor(conveyorName);
    }

    @QAFTestStep(description = "Verify Deleted Conveyor {ConveyorName1} from Conveyor list screen")
    public void verifyDeleteConveyor(String conveyorName) {
        conveyorPage.verifyDeleteConveyor(conveyorName);
    }

    @QAFTestStep(description = "Verify red pin on conveyor list with {ConveyorName2} and {ConveyorName5}")
    public void verifyRedPin(String conveyor2, String conveyor5) {
        conveyorPage.verifyDefaultPin(conveyor2);
        conveyorPage.verifyActivePin(conveyor5);
    }

    @QAFTestStep(description = "Export PDF and CSV data for {ConveyorName2} and {ConveyorName3} and {ConveyorName5} and {ConveyorName6}")
    public void verifyExportConveyor(String conveyor2, String conveyor3, String conveyor5, String conveyor6) {
        conveyorPage.goToConveyorListScreenAndWait();
        conveyorPage.exportPDFConveyor(conveyor5);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("conveyor.pdf"), "PDF report was not found", "PDF report was downloaded successfully");
        conveyorPage.verifyPDFContents(conveyor5);
        corporatePage.clickCorporates();
        conveyorPage.exportCSVConveyor(conveyor2);
        SyncUtil.waitFor(8000);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("download.csv"), "CSV report was not found", "CSV report was downloaded successfully");
        conveyorPage.verifyCSVContents(conveyor2);
    }


    @QAFTestStep(description = "Download bulk upload template for distributor {DistCorpName} and with sites {CustSiteName} and {CustSite2Name}")
    public void verifyTemplateDownload(String distCorpName, String custSiteName, String custSite2Name) {
        conveyorPage.checkDownloadTemplateForOneSite(distCorpName, custSiteName);
        SyncUtil.waitFor(20000);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("ConveyorTemplate-Metric.xlsx"), "Conveyor bulk upload template for single site was not found", "Conveyor bulk upload template for single site was downloaded successfully");
        MiscUtils.deleteDownloadedFiles("[\\D\\S]+.xlsx");
        conveyorPage.checkDownloadTemplateForMultipleSite(distCorpName, custSiteName, custSite2Name);
        SyncUtil.waitFor(20000);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("ConveyorTemplate-Metric.xlsx"), "Conveyor bulk upload template for multiple sites was not found", "Conveyor bulk upload template for single site was downloaded successfully");
        MiscUtils.deleteDownloadedFiles("[\\D\\S]+.xlsx");
    }

    @QAFTestStep(description = "Add two conveyor via bulk upload in site {CustSiteName} with file {FileName}")
    public void conveyorBulkUpload(String custSiteName, String fileName) {
//        Validator.assertTrue(conveyorPage.conveyorFileImport(fileName).contains("2"),"Not all conveyors were imported successfully","All conveyors imported successfully");
        Object[][] obj = MiscUtils.getExcelData(fileName, custSiteName);
        for (int i = obj.length; i > 0; i--) {
            String conveyorId = conveyorPage.apiBase.getConveyorID(conveyorPage.apiBase.getConveyorsAPI(((Map<String, String>) obj[i - 1][0]).get("Name")));
            conveyorPage.apiBase.deleteConveyorAPI(conveyorId);
        }
        conveyorPage.conveyorFileImport(fileName);
        conveyorPage.acknowledgeImport(obj.length - 1);
    }

    @QAFTestStep(description = "Validate conveyor {CustSiteName} should display in list with same data as filled in exel sheet {FileName}")
    public void verifyConveyorBulkUpload(String siteName, String fileName) {
        conveyorPage.verifyUploadedConveyor(siteName, fileName);
    }

    @QAFTestStep(description = "Edit Conveyor {0} from conveyor list screen to {1}")
    public void editConveyorFromConveyorListScreenTo(String ConveyorName, String ConveyorNameEdit) {
        conveyorPage.goToConveyorListScreenAndWait();
        conveyorPage.editConveyor(ConveyorName, ConveyorNameEdit);
        SyncUtil.waitFor(5000);
    }

    @QAFTestStep(description = "Verify Edited conveyor details with {EditCustCorpName} for Corporate {EditCustCorpName}")
    public void checkAConveyorC1GermanyAtMiningCorpGermany(String ConveyorNameGer2, String CustCorpName) {
        conveyorPage.checkConveyorGermany(ConveyorNameGer2, CustCorpName);
    }

    @QAFTestStep(description = "Navigate to Add Conveyor screen")
    public void verifyNavigationToAddConveyor() {
        conveyorPage.goToAddConveyor();
    }

    @QAFTestStep(description = "Navigate to Add Conveyor screen")
    public void verifyNavigationToListConveyor() {
        conveyorPage.goToConveyorListScreen();
    }

    @QAFTestStep(description = "Navigate to conveyor details screen for conveyor {conveyorName}")
    public void verifyConveyorDetailsNavigation(String conveyorName) {
        conveyorPage.goToConveyorDetailScreen(conveyorName);
    }

    @QAFTestStep(description = "Create a conveyor with {ConveyorName1} and {DistShopAusName} and {CustSiteNZName} with {ImageName}")
    public void createConveyorWithImage(String conveyorName, String distShop, String siteName, String imgName) {
        conveyorPage.createConveyorWithImg(conveyorName, distShop, siteName, imgName);
    }

    @QAFTestStep(description = "Verify all the tiles in conveyor detail screen")
    public void verifyConveyorTile() {
        conveyorPage.verifyTile();
    }

    @QAFTestStep(description = "Export CSV data for {ConveyorName2}")
    public void verifyCSVExport(String conveyor) {
        conveyorPage.exportCSVConveyor(conveyor);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("download.csv"), "CSV report was not found", "CSV report was downloaded successfully");
        conveyorPage.verifyCSVContents(conveyor);
    }

    @QAFTestStep(description = "Export PDF for {ConveyorName2}")
    public void verifyPDFExport(String conveyor) {
        conveyorPage.exportPDFConveyor(conveyor);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("conveyor.pdf"), "PDF report was not found", "PDF report was downloaded successfully");
        conveyorPage.verifyPDFContents(conveyor);
    }

    @QAFTestStep(description = "Navigate to Add Conveyor screen from list screen")
    public void verifyAddIconFunctionality() {
        conveyorPage.goToAddConveyorFromList();
    }

    @QAFTestStep(description = "verify all fields in conveyor tab")
    public void verifyConveyorTabFieldInAdd() {
        conveyorPage.verifyConveyor();
    }

    @QAFTestStep(description = "Verify the actions dropdown for conveyor with {ConveyorName2}")
    public void verifyActionDropdown(String conveyorName) {
        Validator.assertTrue(conveyorPage.verifyDropDown(conveyorName), "All Items are not present in conveyor dropdown", "Conveyor Dropdown was successfully verified");
    }

    @QAFTestStep(description = "Navigate to conveyor list screen")
    public void verifyConveyorListNav() {
        conveyorPage.goToConveyorListScreen();
    }


    @QAFTestStep(description = "Navigate to conveyor list screen and search for the created conveyor {ConveyorName1}")
    public void navigateToConveyorListScreenAndSearch(String conveyor) {
        conveyorPage.goToConveyorListScreenAndWait();
        conveyorPage.searchConveyor(conveyor);
        conveyorPage.navigateToAddConveyorPage();
    }

    @QAFTestStep(description = "verify user {Email} is able to add new layout for {Corporates} {BeltWidth} {Rating} {Length} with {Layout_Name}")
    public void verifyAddLayout(String email, String corporates, String beltWidth, String rating, String length, String layoutName) {
//        String userId = conveyorPage.apiBase.getUserProfileAPI(email);
//        String prefId = conveyorPage.apiBase.getPreferenceAPI(userId, layoutName);
//        conveyorPage.apiBase.deletePreferencesAPI(userId, prefId);
        conveyorPage.goToConveyorListScreen();
        conveyorPage.addLayout(corporates, beltWidth, rating, length, layoutName);
        Validator.assertTrue(conveyorPage.verifyFilters(), "All filters are not applied in table layout", "All filters were successfully verified");
    }

    @QAFTestStep(description = "verify user is able to delete layout for {Layout_Name}")
    public void verifyDeleteLayout(String layoutName) {
        conveyorPage.goToConveyorListScreen();
        conveyorPage.deleteLayout(layoutName);
        SyncUtil.waitFor(2000);
        Validator.assertFalse(conveyorPage.verifyFilters(), "All filters are applied in table layout", "All filters were successfully verified");
    }

    @QAFTestStep(description = "Verify user is able see saved preference")
    public void verifySavedPreference() {
        Validator.assertTrue(conveyorPage.verifyFilters(), "All saved filters are not available in layout", "All filters were successfully verified");
    }

    @QAFTestStep(description="Verify Conveyor horizontal navigation bar")
    public void verifyTheConveyorHorizontalNavBar(){
        conveyorPage.verifyConveyorHorizontalNavBar();
    }

    @QAFTestStep(description = "Verify the bread crumb of add conveyor page")
    public void verifyBreadCrumbOfConveyor() {
        conveyorPage.verifyConveyorBreadCrumb();
    }

    @QAFTestStep(description = "Verify that  GPS Coordinates Head and GPS Coordinates Tail with lat and long is visible")
    public void verifyHeadAndTailCoordinatesVisible() {
        conveyorPage.verifyGPSCoordinatesVisibility();
    }

    @QAFTestStep(description = "User selects a site {SiteName} from the dropdown and enter conveyorName {ConveyorName1}")
    public void selectSiteNameFromDropDown(String siteName,String conveyorName) {
        conveyorPage.enterConveyorName(conveyorName);
        conveyorPage.clickSiteDropDown();
        conveyorPage.selectSiteName(siteName);
    }

    @QAFTestStep(description = "Verify that map should display the location of site {SiteName}")
    public void verifyMapLocation(String siteName) {
        conveyorPage.verifyMapDisplaysSiteLocation(siteName);
    }

    @QAFTestStep(description = "Zoom in and out to reach conveyor location")
    public void clickOnZoomInAndOut() {
        conveyorPage.clickOnZoomIn();
        conveyorPage.clickOnZoomOut();
    }

    @QAFTestStep(description = "Click on map to set position of head and verify prefilled value for lat and long is displayed")
    public void clickOnMapAndVerifyPrefilledHeadValues() {
        conveyorPage.clickOnMap();
        conveyorPage.verifyPrefilledValuesDisplayed();
    }

    @QAFTestStep(description = "Click on location type and select head value from the dropdown")
    public void clickAndSelectLocationHead() {
        conveyorPage.clickOnLocationType();
        conveyorPage.selectLocationTypeHead();
    }

    @QAFTestStep(description = "Click on add marker button and verify GPS Coordinates Head is updated with lat long value")
    public void addMarkerClickAndVerifyHeadCoordinates() {
        conveyorPage.addMarkerBtnClick();
        conveyorPage.verifyUpdatedGPSHead();
    }

    @QAFTestStep(description = "Click on map to set position of tail and verify prefilled value for lat and long is displayed")
    public void clickOnMapAndVerifyPrefilledTailValues() {
        conveyorPage.clickOnMap();
        conveyorPage.verifyPrefilledValuesDisplayed();
    }

    @QAFTestStep(description = "Click on location type and select tail value from the dropdown")
    public void clickAndSelectLocationTail() {
        conveyorPage.clickOnLocationTwoType();
        conveyorPage.selectLocationTypeTail();
    }

    @QAFTestStep(description = "Click on add marker button and verify GPS Coordinates Tail is updated with lat long value")
    public void addMarkerClickAndVerifyTailCoordinates() {
        conveyorPage.addMarkerBtnClick();
        conveyorPage.verifyUpdatedGPSTail();
        conveyorPage.clickCreateBtn();

    }


    @QAFTestStep(description = "Verify that user should get an error message while creating duplicate conveyor")
    public void verifyDuplicateConveyorCreation() {
        conveyorPage.verifyErrorMessageIsDisplayed();
    }

    @QAFTestStep(description = "Click on remarks radio button and click on save and close")
    public void clickRemarksBtnAndClickSaveAndClose() {
        conveyorPage.remarksBtnClick();
        conveyorPage.clickCreateBtn();
        conveyorPage.verifyNavigationToConveyorSiteCard();

    }

    @QAFTestStep(description = "Verify that user should get conveyor site card")
    public void verifyConveyorSiteNavigation() {
        conveyorPage.verifyNavigationToConveyorSiteCard();
    }

    @QAFTestStep(description = "Click on remarks radio button and click on previous button")
    public void clickRemarksBtnAndClickPreviousBtn() {
        conveyorPage.remarksBtnClick();
        conveyorPage.previousBtnClick();
    }

    @QAFTestStep(description = "Verify user is navigated to transitions add page")
    public void verifyTransitionPageNavigation() {
        conveyorPage.verifyTransitionPage();
    }

    @QAFTestStep(description = "Add data value in header as imperial")
    public void AddTheDataAsImperial() {
        conveyorPage.addDataAsImperial();
    }

    @QAFTestStep(description = "Verify Conveyor Name {ConveyorName} is displayed as heading of the page")
    public void verifyConveyorHeadingDisplayed(String conveyorName) {
        conveyorPage.verifyConveyorHeading(conveyorName);
    }

    @QAFTestStep(description = "Verify the fields displayed under the conveyor name with prefilled values")
    public void verifyPrefilledValuesPresentUnderConveyor() {
        conveyorPage.verifyPrefilledConveyorValues();
    }

    @QAFTestStep(description = "Look for site Location {CustSiteName} in Conveyor trails map with site location should display")
    public void verifySiteLocationDisplayInConveyorTrail(String siteName) {
        conveyorPage.verifyMapDisplaysSiteLocation(siteName);
    }

    @QAFTestStep(description = "Verify that map is displayed in the Conveyor Trail")
    public void verifyMapIsVisibleInConveyorTrail() {
        conveyorPage.verifyMapIsVisible();
    }

    @QAFTestStep(description = "Verify Conveyor Head and Tail location position is displayed in the map")
    public void verifyHeadAndTailLocationDisplayInMap() {
        conveyorPage.verifyHeadLocationDisplayInMap();
        conveyorPage.verifyTailLocationDisplayInMap();
    }

    @QAFTestStep(description = "Click on pin location of conveyor in map and verify it displays label with conveyor name and cross button")
    public void pinLocationClickAndVerifyConveyorName() {
        conveyorPage.pinLocationClick();
        conveyorPage.verifyHeadConveyorName();
        conveyorPage.closeBtnClick();
        conveyorPage.verifyLabelIsClosed();
    }

    @QAFTestStep(description = "Verify user is able to open the popup")
    public void verifyLayoutPopupIsVisible() {
        conveyorPage.verifyLayoutPopupDisplay();

    }

    @QAFTestStep(description = "Mouse over the popup click and drag and verify user is able to drag and drop the popup")
    public void mouseOverAndVerifyDragAndDrop() {
        conveyorPage.verifyDragAndDrop();

    }

    @QAFTestStep(description = "Verify add button is enabled")
    public void verifyAddBtnIsEnabled() {
        conveyorPage.verifyAddBtnEnabled();

    }

    @QAFTestStep(description = "Verify user is able to see newly added layout")
    public void verifyNewlyAddedLayoutVisible() {
        Validator.assertTrue(conveyorPage.verifyFilters(), "User cannot see the newly added layout", "User can see the newly added layout");
    }

    @QAFTestStep(description = "Create a duplicate layout {Corporates} {BeltWidth} {Rating} {Length} with {Layout_Name}")
    public void createDuplicateLayout(String corporates,String beltWidth,String rating,String length,String layoutName) {
        conveyorPage.goToConveyorListScreen();
        conveyorPage.addDuplicateLayout(corporates, beltWidth, rating, length, layoutName);
    }

    @QAFTestStep(description = "Verify user should get an error message saying layout exists")
    public void verifyErrorMessageVisible() {
        conveyorPage.verifyDuplicateLayoutError();

    }

    @QAFTestStep(description = "Verify column selection filter is visible")
    public void verifyColumnNameFilter() {
        conveyorPage.verifyColumnNameFilterIsVisible();

    }

    @QAFTestStep(description = "Click on the column name filter and verify searchBar all columnNames with checkbox and cross button is visible")
    public void clickAndVerifyColumnFilterFields() {
        coverWearPage.columNamesClick();
        conveyorPage.verifyColumnNameFields();

    }

    @QAFTestStep(description = "Enter the columnName {ColumnName} in searchBar and verify all columnName with search text is displayed")
    public void searchAndVerifyColumnName(String columnName) {
        conveyorPage.searchColumnName(columnName);
        conveyorPage.verifySearchedColumnNames();

    }

    @QAFTestStep(description = "Select the checkbox of searched column and verify only selected column is displayed in the table and column filter text box")
    public void checkAndVerifySelectColumnNames() {
        conveyorPage.columnSelectionCheckboxClick();
        conveyorPage.verifySearchedColumnNames();
        conveyorPage.verifySearchedColumnNamesInTable();
    }

    @QAFTestStep(description = "Remove the entered text from the searchBar and verify all columns are displayed in the dropdown")
    public void clearSearchBarAndVerifyDropDown() {
        conveyorPage.clearSearchBar();
        conveyorPage.setImplicitWait(30000, TimeUnit.MILLISECONDS);
        conveyorPage.verifyColumnNamesArray();
    }

    @QAFTestStep(description = "Select the parent checkbox and verify all child column checkbox and all selected column is visible in the table")
    public void selectParentCheckboxAndVerify() {
        conveyorPage.columnSelectionCheckboxClick();
        conveyorPage.verifyCheckedColumnNames();
        conveyorPage.verifyAllColumnsVisibleInTable();

    }

    @QAFTestStep(description = "Click on cross button and verify column filter is closed")
    public void closeBtnClickAndVerifyColumnFilterClosed() {
        conveyorPage.closeColumnFilterBtnClick();
        conveyorPage.verifyColumnFilterClosed();

    }

    @QAFTestStep(description = "Hover on a column and verify filter icon is displayed")
    public void hoverAndVerifyFilterIsVisible() {
        coverWearPage.clearFilterClick();
        conveyorPage.hoverOverColumn();
        conveyorPage.verifyFilterIconVisible();

    }

    @QAFTestStep(description = "Hover over column name and verify filter icon is highlighted")
    public void hoverAndVerifyFilterIsHighlighted() {
        conveyorPage.hoverOverColumn();
        conveyorPage.verifyFilterIconHighlighted();

    }


    @QAFTestStep(description = "Click on the filter icon and verify all fields {filterType} are visible")
    public void clickOnFilterIconAndVerifyFields(String filterType) {
        conveyorPage.filterIconClick();
        conveyorPage.verifyFilterFields(filterType);
    }

    @QAFTestStep(description = "Select {filterType} from filter dropdown and verify it is selected")
    public void clickAndVerifyStartsWithFilter(String filterType) {
//        conveyorPage.StartsWithFilterClick();
//        conveyorPage.verifyFilterSelected();
        conveyorPage.verifyFilter(filterType);
    }

    @QAFTestStep(description = "Enter the text in the search text {searchText} box and verify user is able to enter")
    public void enterSearchTextAndVerify(String searchText) {
        conveyorPage.enterSearchText(searchText);
        conveyorPage.verifyTextEntered();
    }

    @QAFTestStep(description = "Click on apply button and verify all results with entered text and filter {filterType} is visible in list and filter popup is closed")
    public void applyAndVerifyFilterAppliedAndPopupClosure(String filterType) {
        conveyorPage.applyBtnClick();
        int noOfConveyors = Integer.parseInt(MiscUtils.regexExtractor(conveyorPage.paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        conveyorPage.verifyFilterApplied(noOfConveyors, filterType,null);
        conveyorPage.verifyFilterPopupClosed();
    }

    @QAFTestStep(description = "Click on clear button in popup and verify filter is removed")
    public void clearBtnClickAndVerifyFilterRemoved() {
        conveyorPage.filterIconClick();
        conveyorPage.clearFilterPopupButtonClick();
        conveyorPage.hoverOverColumn();
        conveyorPage.verifyFilterRemoved();

    }

    @QAFTestStep(description = "Search for the conveyor {ConveyorName} and select the checkbox to edit and verify user is able to select checkbox")
    public void searchAndSelectConveyor(String conveyor) {
        conveyorPage.searchConveyor(conveyor);
        conveyorPage.selectConveyor();
    }

    @QAFTestStep(description = "Click on Action button and select edit option and verify user is navigated to conveyor detail page")
    public void clickActionBtnAndSelectEditOption() {
        conveyorPage.actionBtnClick();
        conveyorPage.selectEditOption();
        conveyorPage.verifyConveyorDetailPageNavigation();
    }

    @QAFTestStep(description = "Update the fields of Conveyor-Lite page and verify user is able to update the fields")
    public void updateConveyorLiteFieldsAndVerify() {
        conveyorPage.updateConveyorLiteField();
    }

    @QAFTestStep(description = "Click on update button and verify all changes are saved and navigated to conveyor list page")
    public void clickUpdateBtnAndVerify() {
        conveyorPage.saveButtonClick();
        conveyorPage.verifyConveyorUpdation();
    }

    @QAFTestStep(description = "Look for the fields displayed under technical data and verify it is non editable")
    public void verifyFieldsUnderTechnicalData() {
        conveyorPage.verifyPrefilledFieldsInConveyorLite();
        conveyorPage.verifyPrefilledFieldsInInstalledBelt();
        conveyorPage.verifyPrefilledFieldsInMaterial();
        conveyorPage.verifyPrefilledFieldsInConveyor();

    }

    @QAFTestStep(description="Verify data value in header as metric")
    public void verifyTheDataInHeaderUnitAsMetric(){
        conveyorPage.verifyDataHeaderUnitAsMetric();
    }
    @QAFTestStep(description="Verify data value in header as imperial")
    public void verifyTheDataInHeaderUnitAsImperial(){
        conveyorPage.verifyDataHeaderUnitAsImperial();
    }

    @QAFTestStep(description="Edit Conveyor tons per hour value {TonsPerHour}")
    public void editConveyorTonsHourValue(String tonsPerHour){
        conveyorPage.editTonsPerHour(tonsPerHour);
    }
    @QAFTestStep(description="Verify data value unit as {MetricUnit} in Add Conveyor for TonsPerHour")
    public void verifyTheDataUnitInAddConveyorForTonsPerHour(String unit){
        conveyorPage.verifyDataUnitInAddConveyorForTonsPerHour(unit);
    }

    @QAFTestStep(description = "Close the warning popup")
    public void closeWarning() {
        SyncUtil.waitFor(2000);
        conveyorPage.closeDialog();
    }

    @QAFTestStep(description="Verify on click of conveyor nagivation bar nagivates to respective pages")
    public void verifyTheConveyorNavigationOnClick(){
        conveyorPage.verifyConveyorNavigationOnClick();
    }

    @QAFTestStep(description = "Verify that the image viewer panel is closed and image is not uploaded")
    public void verifyImageViewPanel () {
        conveyorPage.verifyImageViewPanelClosed();
    }


    @QAFTestStep(description="Create a conveyor with {ConveyorName} and {DistShopName} and {CustShopName} with mandatory field")
    public void createTheConveyorWithMan(String conveyorName, String distShopName, String custSiteName){
//        String conveyorId = conveyorPage.apiBase.getConveyorsAPI(conveyorName);
//        conveyorPage.apiBase.deleteConveyorAPI(conveyorId);
        conveyorPage.createConveyorWithMan(conveyorName, distShopName, custSiteName);
    }

    @QAFTestStep(description="Go to remarks and click on save as button")
    public void clickTheRemarkAndSave(){
        conveyorPage.clickRemarkAndSave();
    }

    @QAFTestStep(description="Verify data value in header as {Unit} in Add Conveyor")
    public void verifyTheDataInHeaderUnitInAddConveyor(String unit){
        conveyorPage.verifyDataHeaderUnitInAddConveyor(unit);
    }

    @QAFTestStep(description="Extract the main card count for {module}")
    public void extractTheMainCardCount(String module){
        conveyorPage.extractMainCardCount(module);
    }
    @QAFTestStep(description="Extract the card count in detail page for {Module}")
    public void extractTheConveyorCountInDetailPage(String module){
        conveyorPage.extractConveyorCardCountForDetailPage(module);
    }

    @QAFTestStep(description = "Verify the main card count after operation {Addition} for {Sites} with count {Value}")
    public void extractAddedMainCardCount(String operation, String moduleName, int value) {
        conveyorPage.verifyMainCardCountAfterAddition(operation, moduleName, value);
    }
    @QAFTestStep(description = "Verify the card count in detail screen after operation {Addition} for {Sites} with count {Value}")
    public void verifyTheCardCountInDetailPageAfterChange(String operation, String moduleName, int value) {
        conveyorPage.verifyCardCountInDetailPageAfterChange(operation, moduleName, value);
    }

    @QAFTestStep(description="Verify site and corporate fields are prefilled")
    public void verifyTheSiteAndConveyorPreFilled(){
        conveyorPage.verifySiteAndConveyorPreFilled();
    }

    @QAFTestStep(description="Edit Conveyor belt width value {BeltWidth}")
    public void editTheBeltWidth(String beltWidth){
        conveyorPage.editBeltWidth(beltWidth);
    }

    @QAFTestStep(description="Verify data value unit as {Unit} in Add Conveyor for beltwidth")
    public void verifyTheDataUnitInAddConveyorForBeltWidth(String unit){
        conveyorPage.verifyDataUnitInAddConveyorForBeltWidth(unit);
    }

    @QAFTestStep(description = "Click on layout picker")
    public void layoutBtnClick() {
        conveyorPage.clickOnLayoutPicker();

    }

    @QAFTestStep(description = "Click on text box and verify user is able to enter the layout name {layoutName}")
    public void clickTextBoxAndVerifySetLayoutName(String layoutName) {
        conveyorPage.addNewLayoutBtnClick();
        conveyorPage.verifySetLayoutName(layoutName);

    }

    @QAFTestStep(description = "Click on back button and verify user lands on table layout settings")
    public void clickBackBtnVerifyTableLayout() {
        conveyorPage.clickBackBtn();

    }

    @QAFTestStep(description = "Click on layout and verify safe set preference button")
    public void clickOnLayoutAndVerifyTheSafeSet() {
        conveyorPage.clickOnLayoutAndVerifySaveSetPreference();

    }
    @QAFTestStep(description = "Click on default layout")
    public void clickOnTheDefault() {
        conveyorPage.clickOnTheDefault();
    }

    @QAFTestStep(description = "Click on cross button in layout setting popUp")
    public void clickOnTheCloseLayoutSetting() {
        conveyorPage.clickOnCloseLayoutSetting();

    }
    @QAFTestStep(description="Edit Conveyor top cover thickness value {TopCoverThickness}")
    public void editTheConveyorTopCoverThickness(String topCoverThickness){
        conveyorPage.editConveyorTopCoverThickness(topCoverThickness);
    }
    @QAFTestStep(description="Add filter for header with {FilterName}")
    public void addTheColumnFilters(String filterName){
        conveyorPage.addColumnFilters(filterName);
    }
    @QAFTestStep(description="Verify header field {Header} is present in unit {Unit}")
    public void verifyTheHeaderFieldUnit(String field,String unit){
        conveyorPage.verifyHeaderDataFieldUnit(field,unit);
    }

    @QAFTestStep(description="Edit Conveyor bottom cover thickness value {BottomCoverThickness}")
    public void editTheConveyorBottomCoverThickness(String bottomCoverThickness){
        conveyorPage.editConveyorBottomCoverThickness(bottomCoverThickness);
    }

    @QAFTestStep(description="Edit Conveyor speed value {Speed}")
    public void editTheConveyorSpeed(String speed){
        conveyorPage.editConveyorSpeed(speed);
    }

    @QAFTestStep(description="Verify Conveyor list page header as Conveyor")
    public void verifyTheCoveyorListPageHeader(){  conveyorPage.verifyCoveyorListPageHeader();}

    @QAFTestStep(description="Verify Conveyor column name")
    public void verifyTheConveyorCoulmnName(){
        conveyorPage.verifyConveyorCoulmnName();
    }

    @QAFTestStep(description="Verify Conveyor column data {Name} {Site} {LastModified} {InstallBelt} {RemainingTime} {RemainingPer}")
    public void verifyTheConveyorColumnData(String name,String site,String lastModified,String installBelt,String remainingTime,String remainingPer){
        conveyorPage.verifyConveyorCoulmnData(name,site,lastModified,installBelt,remainingTime,remainingPer);
    }

    @QAFTestStep(description="Verify pagination backward arrow button")
    public void verifyThePaginationBackwardArrowButton(){
        conveyorPage.verifyPaginationBackwardArrowButton();
    }

    @QAFTestStep(description="Verify pagination format")
    public void verifyThePaginationFormat(){
        conveyorPage.verifyPaginationFormat();
    }


    @QAFTestStep(description="Navigate to Conveyor Bulk Upload")
    public void verifyConveyorBulkImportNavigation(){
        Validator.assertTrue(conveyorPage.goToBulkImport(),"Conveyor bulk import navigation failed","Conveyor bulk import navigation was successful");
    }

    @QAFTestStep(description="Verify the failure message after uploading wrong format file with name {file}")
    public void verifyFailureMsgFileUpload(String fileName){
        Validator.assertTrue(userpage.userWrongFileUpload(fileName),"Bulk import file upload failed","Bulk import file upload was successful");
    }

    @QAFTestStep(description="Verify conveyor analysis bar is displayed uploading file with name {file}")
    public void verifyTheAnalysisBar(String fileName){
        conveyorPage.conveyorFileImport(fileName);

    }

    @QAFTestStep(description="Verify import Report page data")
    public void verifyTheImportReportPageData(){
        conveyorPage.verifyImportReportPageData();
    }
    @QAFTestStep(description="Click on site dropdown and select sites with {Site1} {Site2}")
    public void selectSiteForConveyorBulkUpload(String site1,String site2){
        conveyorPage.selectSiteForUpload(site1,site2);
    }
    @QAFTestStep(description="Verify the excel data for {Site1} {Site2} with file {FileName}")
    public void verifyTheExcelDataForConveyor(String site1,String site2,String fileName){
        SyncUtil.waitFor(10000);
        conveyorPage.verifySheetNames(fileName,site1,site2);
        conveyorPage.verifyConveyorSheetData(fileName,site1);
        conveyorPage.verifyConveyorSheetData(fileName,site2);

    }

    @QAFTestStep(description="Navigate to Conveyor bulk import screen")
    public void verifyBulkImportNavigation(){
        Validator.assertTrue(conveyorPage.goToBulkImport(),"User is not in bulk import screen","Bulk import screen was successfully verified");
    }

    @QAFTestStep(description="Verify add conveyor permission")
    public void verifyAddConveyorPermission(){
        Validator.assertTrue(!conveyorPage.verifyAddConveyorPermission(),"Add conveyor is enabled","Add Conveyor should be disabled is successfully verified");
    }

    @QAFTestStep(description="Verify different sections from bulk import screen")
    public void verifySectionsFromBulkImport(){
        Validator.assertTrue(conveyorPage.verifySectionsFromBulkImport(),"All Section in bulk import are not available","All sections in conveyor bulk import are successfully verified");
    }

    @QAFTestStep(description="Verify download bulk upload template for distributor {DistCorpName} and with site {CustSiteName}")
    public void verifyDownloadTemplateForSingleSite(String distCorpName, String custSiteName){
        conveyorPage.checkDownloadTemplateForOneSite(distCorpName,custSiteName);
        SyncUtil.waitFor(20000);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("ConveyorTemplate-Metric.xlsx"),"Conveyor bulk upload template for single site was not found","Conveyor bulk upload template for single site was downloaded successfully");
        MiscUtils.deleteDownloadedFiles("[\\D\\S]+.xlsx");    }

    @QAFTestStep(description="Verify download bulk upload template for distributor {0} and with multisite {1} and with site {2}")
    public void verifyDownloadTemplateForMultipleSite(String distCorpName, String custSiteName, String custSite2Name) {
        conveyorPage.checkDownloadTemplateForMultipleSite(distCorpName, custSiteName, custSite2Name);
        SyncUtil.waitFor(20000);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("ConveyorTemplate-Metric.xlsx"), "Conveyor bulk upload template for multiple sites was not found", "Conveyor bulk upload template for single site was downloaded successfully");
        MiscUtils.deleteDownloadedFiles("[\\D\\S]+.xlsx");
    }

    @QAFTestStep(description="Verify bulk upload file format with file {FileName}")
    public void verifyBulkUploadFileFormat(String fileName) {
        conveyorPage.conveyorFileImportWithoutWait(fileName);
//        Validator.assertTrue(conveyorPage.conveyorFileImport(fileName).contains("2"),"Not all conveyors were imported successfully","All conveyors imported successfully");

    }

    @QAFTestStep(description="Verify acknowledge import screen for site {CustSiteName} with file {FileName}")
    public void verifyAcknowledgeImportScreen(String custSiteName, String fileName) {
        Object[][] obj = MiscUtils.getExcelData(fileName,custSiteName);
        conveyorPage.acknowledgeImport(obj.length-1);
    }

    @QAFTestStep(description="Verify bulk import report screen")
    public void verifyBulkImportReportScreen() {
        conveyorPage.verifyImportReport();
    }

    @QAFTestStep(description="Verify skip radio button functionality for site {CustSiteName} with file {FileName}")
    public void verifySkipRadioFunctionality(String custSiteName, String fileName) {
        Object[][] obj = MiscUtils.getExcelData(fileName,custSiteName);
        conveyorPage.verifySkipRadioBtn(obj.length-1);
    }

    @QAFTestStep(description="Verify update radio button functionality for site {CustSiteName} with file {FileName}")
    public void verifyUpdateRadioFunctionality(String custSiteName, String fileName) {
        Object[][] obj = MiscUtils.getExcelData(fileName,custSiteName);
        conveyorPage.verifyUpdateRadioBtn(obj.length-1);
    }

    @QAFTestStep(description="Verify copy radio button functionality for site {CustSiteName} with file {FileName}")
    public void verifyCopyRadioFunctionality(String custSiteName, String fileName) {
        Object[][] obj = MiscUtils.getExcelData(fileName,custSiteName);
        conveyorPage.verifyCopyRadioBtn(obj.length-1);
    }

    @QAFTestStep(description="Go Back to bulk import report")
    public void verifyBackNavigation() {
        conveyorPage.goBackToImportReport();
    }

    @QAFTestStep(description="Verify bulk import review messages")
    public void verifyReviewMessages() {
        conveyorPage.verifyMessages();
    }

    @QAFTestStep(description="Verify file analysis success message")
    public void verifyFileAnalysisMessages() {
        conveyorPage.verifyFileAnalyseMessages();
    }

    @QAFTestStep(description="Click on the import conveyor")
    public void clickOnImportConveyor() {
        conveyorPage.conveyorUpload();
    }

    @QAFTestStep(description="Verify Edit button is visible on details screen")
    public void verifyEditBtnDisplayed(){
        conveyorPage.editButtonVisiblityOnConveyorDetailsPage();
    }

    @QAFTestStep(description="Verify only view permission right for conveyors {ConveyorName}")
    public void verifyOnlyViewPermissionRightForConveyors(String ConveyorName) {
        Validator.assertTrue(conveyorPage.verifyViewPermissionRights(ConveyorName), "View Permission for conveyor is failing", "View permission for conveyor is verified successfully");
    }

    @QAFTestStep(description="Verify only view and edit permission right for conveyors {ConveyorName}")
    public void verifyOnlyViewAndEditPermissionRightForConveyors(String ConveyorName) {
        Validator.assertTrue(conveyorPage.verifyViewAndEditRights(ConveyorName), "Edit And view Permission for conveyor is failing", "Edit and view permission for conveyor is verified successfully");
    }

    @QAFTestStep(description="Verify only view and Delete permission right for conveyor {ConveyorName}")
    public void verifyViewAndDeletePermissionRightForConveyor(String ConveyorName) {
        Validator.assertTrue(conveyorPage.verifyViewAndDeleteRights(ConveyorName), "Delete and view Permission for conveyor is failing", "Delete and view permission for conveyor is verified successfully");
    }

    @QAFTestStep(description="Verify only view and add permission right for conveyor {ConveyorName}")
    public void verifyViewAndAddPermissionRightForConveyor(String ConveyorName) {
        Validator.assertTrue(conveyorPage.verifyViewAndAddRights(ConveyorName), "Add And view Permission for conveyor is failing", "Add and view permission for conveyor is verified successfully");
    }

    @QAFTestStep(description="Verify only view and download permission right for conveyor {ConveyorName}")
    public void verifyViewAndDownloadPermissionRightForConveyor(String ConveyorName) {
        Validator.assertTrue(conveyorPage.verifyViewAndDownloadRights(ConveyorName), "Download And view Permission for conveyor is failing", "Download and view permission for conveyor is verified successfully");
    }

    @QAFTestStep(description="wait for conveyors to load")
    public void conveyorLoad() {
        conveyorPage.goToConveyorListScreenAndWait();
    }

    @QAFTestStep(description="Verify conveyor detail screen card display")
    public void conveyorDetailsCardDisplay() {
        Validator.assertTrue(conveyorPage.verifyConveyorDetailCardsDisplayForBasics(), "After setting view rights for basics the card display showing other cards too", "After setting view right card display for basics, showing only 3 cards");
    }

    @QAFTestStep(description="User clicks on Conveyor History")
    public void navigateToConveyorHistory() {
        Validator.assertTrue(conveyorPage.navigateToConveyorHistoryFromDetails(),"User Conveyor history navigation failed", "User Conveyor history navigation was successful");
    }

    @QAFTestStep(description="User should not see dropdown with belt failure options for view rights")
    public void addConveyorHistoryViewRights() {
        Validator.assertTrue(conveyorPage.verifyaddConveyorHistoryViewRights(), "Add Conveyor history option enabled for view rights", "Add Conveyor history option disabled for view rights");
    }
    @QAFTestStep(description = "Verify that conveyor card is displayed in home page")
    public void verifyTheConveyorCardDisplay () {
        conveyorPage.verifyConveyorCardDisplay();
    }

    @QAFTestStep(description = "Click on the conveyor card and verify it navigates to conveyor list screen")
    public void verifyNavigationToConveyorListPage () {
        conveyorPage.clickConveyorCard();
        conveyorPage.verifyConveyorListPageNaviagtion();
    }

    @QAFTestStep(description = "Click on the conveyor card")
    public void clickTheConveyorCard () {
        conveyorPage.clickConveyorCard();
    }

    @QAFTestStep(description = "subscribe one conveyor {ConveyorName1} for the user")
    public void searchAndSubscribeConveyor (String conveyorName) {
//        SyncUtil.waitFor(20000);
        conveyorPage.searchConveyor(conveyorName);
        sitePage.subscribeSite(conveyorName);
    }

    @QAFTestStep(description = "Navigate to conveyorListPage and click on bellIcon")
    public void navigateToConveyorPageAndBellIconClick()
    {
        conveyorPage.goToConveyorListScreenAndWait();
        sitePage.bellIconClick();
    }
    @QAFTestStep(description = "Subscribe the conveyors {ConveyorName1} and {ConveyorName2}")
    public void searchAndSubscribeTwoConveyors(String ConveyorName1,String ConveyorName2) {
//        SyncUtil.waitFor(20000);
        conveyorPage.searchConveyor(ConveyorName1);
        sitePage.subscribeSite(ConveyorName1);
        conveyorPage.searchConveyor(ConveyorName2);
        sitePage.subscribeSite(ConveyorName2);
    }
    @QAFTestStep(description="Verify Conveyor History navigation bar fields")
    public void verifyTheConveyorHistoryHeaderFields(){
        conveyorPage.verifyConveyorHistoryHeaderFields();
    }

    @QAFTestStep(description = "Verify user is getting conveyor notification in last in first out format for {Value1} {Value2}")
    public void clickAndVerifyNotificationConveyorOrder(String value1,String value2)
    {
        sitePage.bellIconClick();
        conveyorPage.verifyNotificationConveyorOrder(value1,value2);
    }
    @QAFTestStep(description = "Verify user is getting inspection notification for {ConveyorName} with {CustSiteName} by {UserName}")
    public void verifyTheInspNotification(String conveyorName,String siteName,String userName)
    {
        sitePage.bellIconClick();
        conveyorPage.verifyInspNotification(conveyorName,siteName,userName);
    }
    @QAFTestStep(description = "Verify the pinned subscription list {Value}")
    public void verifyThePinSubList(String value)
    {
        conveyorPage.verifyPinnedSubList(value);
    }
    @QAFTestStep(description = "Verify the unPinned subscription list {Value}")
    public void verifyTheUnPinSubList(String value)
    {
        conveyorPage.verifyUnPinnedSubList(value);
    }
    @QAFTestStep(description = "Verify user can only see conveyor history of the particular subscribed conveyor {ConveyorName1} notification")
    public void verifyConveyorHistoryForParticularConveyor(String conveyorName){
        conveyorPage.verifyConveyorHistoryNav(conveyorName);
    }
    @QAFTestStep(description = "Verify Conveyor card details")
    public void verifyTheConveyorCardDetails() {
        conveyorPage.verifyConveyorCardDetails();
    }

    @QAFTestStep(description = "Click on the new link of the recent conveyor notification for {ConveyorName1} and verify it navigates conveyor history page")
    public void clickNewLinkAndVerifyNavigation(String conveyorName)
    {
        conveyorPage.newLinkClick();
        conveyorPage.verifyConveyorHistoryNav(conveyorName);
    }
    @QAFTestStep(description = "Navigate to conveyor list screen and wait to load data")
    public void verifyConveyorListNavAndWait() {
        conveyorPage.goToConveyorListScreenAndWait();
    }
    @QAFTestStep(description = "Verify the conveyor count with respect to pagination")
    public void validateTheConveyorCountWrtPagination()
    {
        conveyorPage.validateConveyorCountWrtPagination();
    }
    @QAFTestStep(description = "Click on add conveyor in menu")
    public void clickOnTheAddConveyorInMenu()
    {
        conveyorPage.clickOnAddConveyorInMenu();
    }
    @QAFTestStep(description = "Clear the search item")
    public void clearTheSearchItem()
    {
        conveyorPage.clearSearchItem();
    }
    @QAFTestStep(description = "Click on The Add Icon")
    public void clickTheOnAddIcon() {
        conveyorPage.clickOnAddIcon();
    }
    @QAFTestStep(description = "Enter the conveyor lite page fields with {BeltWidth} {MaterialName} {DriveWrapAngle} {SurchargeAngle} {IdlerOffsetType} {DriveDetails} {TakeUpDetails}")
    public void enterTheConveyorLitePageFields(String beltWidth,String materialName,String driveWrapAngle,String surchargeAngle,String idlerOffsetType,String driveDetails,String takeUpDetails) {
        conveyorPage.enterConveyorLitePageFields(beltWidth,materialName,driveWrapAngle,surchargeAngle,idlerOffsetType,driveDetails,takeUpDetails);
    }
    @QAFTestStep(description = "Enter the installed belt page fields with {BeltConfig} {BeltConst} {TopCompound} {CarCass} {Width} {Splice} {InstallDate}")
    public void enterTheInstalledBeltPageFields(String beltConfig,String beltConst,String topCompound,String carCass,String width,String splice,String installDate) {
        conveyorPage.enterInstalledBeltPageFields(beltConfig,beltConst,topCompound,carCass,width,splice,installDate);
    }
    @QAFTestStep(description = "Enter the material page fields with {BulkSize} {GranularSize} {Aggresivity} {LoadingFrequency} {FeedingConditions}")
    public void enterTheMaterialPageFields(String bulkSize,String granularSize,String aggresivity,String loadingFrequency,String feedingConditions) {
        conveyorPage.enterMaterialPageFields(bulkSize,granularSize,aggresivity,loadingFrequency,feedingConditions);
    }
    @QAFTestStep(description = "Enter the conveyor page fields with {ConveyingLength} {Ratio} {Stage} {TakeUpDetails} {BeltTurnOver}")
    public void enterTheConveyorPageFields(String conveyingLength,String ratio,String stage,String takeUpDetails,String beltTurnOver) {
        conveyorPage.enterConveyorPageFields(conveyingLength,ratio,stage,takeUpDetails,beltTurnOver);
    }
    @QAFTestStep(description = "Enter the wear life page fields with {ChuteAngle}")
    public void enterTheWearLifePageFields(String chuteAngle) {
        conveyorPage.enterWearLifePageFields(chuteAngle);
    }
    @QAFTestStep(description = "Enter the idlers page fields with {Angle} {IdlerOffset}")
    public void enterTheIdlersPageFields(String angle,String idlerOffset) {
        conveyorPage.enterIdlersPageFields(angle,idlerOffset);
    }
    @QAFTestStep(description = "Enter the pulleys page fields with {DrivePulley} {BrakeDevice} {HeadDiameter} {AngleWrap} {LaggingType}")
    public void enterThePulleysPageFields(String drivePulley,String brakeDevice,String headDiameter,String angleWrap,String laggingType) {
        conveyorPage.enterPulleysPageFields(drivePulley,brakeDevice,headDiameter,angleWrap,laggingType);
    }
    @QAFTestStep(description = "Enter the transitions page fields with {Length}")
    public void enterTheTransitionsPageFields(String length) {
        conveyorPage.enterTransitionsPageFields(length);
    }
    @QAFTestStep(description = "Enter the remarks page fields with {File} {Remark}")
    public void enterTheRemarksPageFields(String file,String remark) {
        conveyorPage.enterRemarksPageFields(file,remark);
    }
    @QAFTestStep(description = "Click multiSelect Checkbox and verify delete functionality")
    public void clickTheMultiSelectCheckBoxAndDelete() {
        conveyorPage.clickMultiSelectCheckBoxAndDelete();
    }
     @QAFTestStep(description = "Edit the technical tab data for the fields {ConveyorName} {BeltWidth} {BeltConfig} {DrivePulley} {File} {Remarks}")
     public void editTheEachTechDataForFields(String conveyorName,String beltWidth,String beltConfig,String drivePulley,String file,String remarks) {
        conveyorPage.editEachTechDataForFields(conveyorName,beltWidth,beltConfig,drivePulley,file,remarks);
    }
    @QAFTestStep(description = "Verify the technical tab data after edit for the fields {ConveyorName} {BeltWidth} {BeltConfig} {DrivePulley} {Remarks}")
     public void verifyTheEachTechDataAfterEditForFields(String conveyorName,String beltWidth,String beltConfig,String drivePulley,String remarks) {
        conveyorPage.verifyEachTechDataAfterEditForFields(conveyorName,beltWidth,beltConfig,drivePulley,remarks);
    }
    @QAFTestStep(description = "Verify the technical tab data are in imperial value for fields {BeltWidth} {TopCoverThickness} {BeltRating} {Length}")
     public void verifyTheTechnicalTabImperialValueForFields(String beltWidth,String topCoverThickness,String beltRating,String length) {
        conveyorPage.verifyTechnicalTabImperialValueForFields(beltWidth,topCoverThickness,beltRating,length);
    }
    @QAFTestStep(description = "Verify the technical tab data are in metric value for fields {BeltWidth} {TopCoverThickness}")
     public void verifyTheTechnicalTabMetricValueForFields(String beltWidth,String topCoverThickness) {
        conveyorPage.verifyTechnicalTabMetricValueForFields(beltWidth,topCoverThickness);
    }
    @QAFTestStep(description="Extract the status count for {Module} for {Status} in {StatusStored}")
    public void extractTheStatusCardCount(String module,String status,String storeVal){
        conveyorPage.extractStatusCardCount(module,status,storeVal);
    }
    @QAFTestStep(description = "Verify the status card count after operation {Addition} for {Sites} for {Status} with count {Value} in {StatusStored}")
    public void verifyTheStatusCardCountAfterChanges(String operation, String moduleName,String status, int value,String storeVal) {
        conveyorPage.verifyStatusCardCountAfterChanges(operation, moduleName,status, value,storeVal);
    }
    @QAFTestStep(description = "Verify user is getting belt scan notification for {ConveyorName} with {CustSiteName} by {UserName}")
    public void verifyTheBeltScanNotification(String conveyorName,String siteName,String userName)
    {
        sitePage.bellIconClick();
        conveyorPage.verifyBeltScanNotification(conveyorName,siteName,userName);
    }

    @QAFTestStep(description = "Verify the notification count in bellIcon after subscription and verify user is getting any notification")
    public void verifyNotificationCountAfterSubscriptionForConveyor()
    {

        sitePage.extractNotificationCountAfter();
        sitePage.verifyUserNotificationCountAfterUpdate();
    }

    @QAFTestStep(description = "Click on the new link of the recent Belt Scan notification and verify it navigates Add Belt Scan page")
    public void clickNewLinkAndVerifyBeltScanNavigation() {
        sitePage.bellIconClick();
        conveyorPage.newLinkClick();
        SyncUtil.waitFor(3000);
        Validator.assertTrue(cordInspectPage.getCurrentURL().contains("/secure/belt-scans/detail/"), "User is not navigated to  Belt Scan Detail page!",
                "User is  navigated to  Belt Scan Detail page!");
    }

    @QAFTestStep(description = "Verify user can see the updates done to the conveyor {ConveyorName} in the conveyor history under the subscribed site")
    public void verifyConveyorUpdateHistory(String conveyorName)
    {
        Validator.assertTrue(conveyorPage.getCurrentURL().contains("/conveyor-history"),"User is not navigated to conveyor history page","User is navigated to conveyor history page");
        conveyorPage.verifyConveyorHistoryForConveyor(conveyorName);
    }

    @QAFTestStep(description = "Click on each column header and verify filter icon fields")
    public void clickOnEachFilterIconAndVerifyFilterFields() {
        conveyorPage.columnNameFilterBtnClick(monitoringDeviceColName);
    }
    @QAFTestStep(description = "Extract the main card count in {Home} page for {ModuleName}")
    public void extractInitialMainCardCount(String moduleLevel,String moduleName) {
        conveyorPage.extractMainCardCount(moduleName,moduleLevel);
    }
    @QAFTestStep(description = "Verify the main card count after operation {Addition} for {Sites} with count {Value} at module level {ModuleLevel}")
    public void extractAddedMainCardCount(String operation,String moduleName,int value,String moduleLevel) {
        conveyorPage.verifyMainCardCountAfterAddition(operation,moduleName,value,moduleLevel);
    }
    @QAFTestStep(description = "Verify correct pagination and card count is displayed at {HomeLevel} page for {Sites}")
    public void verifyPaginationCountAndCardCountAtModuleLevel(String moduleLevel,String moduleName) {
        conveyorPage.extractMainCardCount(moduleName,moduleLevel);
        conveyorPage.verifyPaginationCountAndCardCount(moduleLevel);
    }


}
