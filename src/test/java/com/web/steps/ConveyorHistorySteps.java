
package com.web.steps;

import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.ConveyorHistoryPage;
import com.web.pages.ConveyorInspectPage;
import com.web.pages.ConveyorPage;
import com.web.pages.SitePage;

public class ConveyorHistorySteps {
    ConveyorHistoryPage conveyorHistoryPage=new ConveyorHistoryPage();
    ConveyorInspectPage conveyorInspectPage=new ConveyorInspectPage();
    ConveyorPage conveyorPage = new ConveyorPage();
    SitePage sitePage = new SitePage();


    @QAFTestStep(description = "User clicks on Conveyor inspect and on view arrow")
    public void userClicksOnConveyorInspectAndOnViewArrow() {
        conveyorPage.waitForPageLoad(5000);
        conveyorHistoryPage.clickOnConveyorInspect();
        conveyorPage.waitForPageLoad(5000);
        conveyorHistoryPage.clickOnViewArrow();

    }
    @QAFTestStep(description = "User clicks on Conveyor History")
    public void userClicksOnConveyorHistory(){
        SyncUtil.waitFor(5000);
        conveyorHistoryPage.clickOnConveyorHistory();
    }
    @QAFTestStep(description = "user clicks on conveyor view arrow")
    public void userClicksOnViewArrow(){
        conveyorPage.goToConveyorListScreen();
        conveyorHistoryPage.clickOnViewArrow();
    }

    @QAFTestStep(description = "Verify conveyor history screen for {ConveyorName}")
    public void userNavigatesToConveyorHistory(String conveyorName){
        conveyorPage.goToConveyorDetailScreen(conveyorName);
        conveyorHistoryPage.clickOnConveyorHistory();
        conveyorHistoryPage.verifyConveyorHistoryConveyor();
        conveyorHistoryPage.verifyHistoryCardCount();
    }

    @QAFTestStep(description = "user clicks on sites and on view arrow")
    public void userClicksOnSite(){
        sitePage.goToSiteListScreen();
        conveyorHistoryPage.clickOnViewArrow();
    }

    @QAFTestStep(description = "User is at conveyor history page")
    public void userIsAtConveyorHistoryPage() {
        conveyorHistoryPage.clickOnConveyorInspect();
        conveyorPage.waitForPageLoad(5000);
        conveyorPage.searchConveyor("Vulcan Materials - Granding");
        SyncUtil.waitFor(200);
        conveyorHistoryPage.clickOnViewArrow();
        conveyorHistoryPage.clickOnConveyorHistory();
    }

    @QAFTestStep(description = "User should see conveyor history page")
    public void userShouldSeeConveyorHistoryPage(){
        Validator.assertTrue(conveyorHistoryPage.getCurrentURL().endsWith("/conveyor-history"),"User is not in conveyor history page","User is at conveyor history page");
    }

    @QAFTestStep(description = "User Should be able to see add button")
    public void userShouldBeAbleToSeeAddButton(){
        conveyorHistoryPage.addButtonVisible();
    }

    @QAFTestStep(description = "User clicks on add button")
    public void userClicksOnAddButton(){
        conveyorHistoryPage.clickAddButton();
    }

    @QAFTestStep(description = "User should see dropdown with Options")
    public void userShouldSeeDropdownWithOptions(){
        conveyorHistoryPage.verifyAddDropdown();
    }

    @QAFTestStep(description = "User clicks on belt failure")
    public void userClicksOnBeltFailure(){
        conveyorHistoryPage.clickOnBeltFailure();
    }

    @QAFTestStep(description = "User should see belt failure message box")
    public void userShouldSeeBeltFailureMessageBox(){
        SyncUtil.waitFor(20000);
        Validator.assertTrue(conveyorHistoryPage.verifyBeltFailureMessageBox(),"All the contents are not present","All the contents are present");
    }

    @QAFTestStep(description = "Brand & Compounds tab should display as default tab")
    public void brandCompoundsTabShouldDisplayAsDefaultTab(){
        Validator.assertTrue(conveyorHistoryPage.tabBrandCompound.getAttribute("aria-selected").equals("true"),"Brand & Compounds tab is not selected","Brand & Compounds tab is selected");
    }

    @QAFTestStep(description = "Belt details tab should displayed")
    public void beltDetailsTabShouldSisplayed(){
        Validator.assertTrue(conveyorHistoryPage.tabBeltDetails.getAttribute("aria-selected").equals("true"),"Belt Details tab is not selected","Belt Details tab is selected");
    }

    @QAFTestStep(description = "Age & Failure mode tab should displayed")
    public void ageFailureModeTabShouldDisplayed(){
        Validator.assertTrue(conveyorHistoryPage.tabAgeFailureMode.getAttribute("aria-selected").equals("true"),"Age & Failure mode tab is not selected","Age & Failure mode tab is selected");
    }

    @QAFTestStep(description = "User should be able to see all the content brand & compounds tab")
    public void userShouldBeAbleToSeeAllTheContentBrandCompoundsTab(){
        SyncUtil.waitFor(10000);
        Validator.assertTrue(conveyorHistoryPage.verifyBrandAndCompound(),"All the fields in Brand and Compound tab are not shown","All the fields in Brand and Compound tab are shown");
    }

    @QAFTestStep(description="User should be able to see the conveyor name")
    public void usershouldbeabletoseetheconveyorname(){
        Validator.assertTrue(conveyorHistoryPage.verifyConveyorTextBoxName(),"conveyor name is not visible","conveyor name is visible");
    }

    @QAFTestStep(description = "User should be able to see all content of belt details tab")
    public void userShouldBeAbleToSeeAllContentOfBeltDetailsTab(){
        Validator.assertTrue(conveyorHistoryPage.verifyBeltDetails(),"All the feilds in Belt Details tab are not shown","All the feilds in Belt Details tab are shown");
    }

    @QAFTestStep(description = "User should see close button")
    public void userShouldSeeCloseButton(){
        conveyorHistoryPage.verifyCloseButton();
    }

    @QAFTestStep(description = "Click on close button")
    public void clickOnCloseButton(){
        conveyorHistoryPage.clickClose();
    }
    @QAFTestStep(description = "Click on close button on component change")
    public void componentChangeCrossMark(){
        conveyorHistoryPage.clickCloseMark();
    }

    @QAFTestStep(description = "Click on close button on custom event")
    public void customEventCrossMark(){
        conveyorHistoryPage.clickCloseMarkCustomEvent();
    }

    @QAFTestStep(description = "Message box should get closed")
    public void messageBoxShouldGetClosed(){
        SyncUtil.waitFor(200);
        Validator.assertTrue(conveyorHistoryPage.verifyMessageBox(),"Message box is visible","Message box is Closed");

    }

    @QAFTestStep(description = "Link button should be visible")
    public void linkButtonShouldBeVisible(){
        conveyorHistoryPage.verifyLinkButton();
    }

    @QAFTestStep(description = "User click on link")
    public void userClickOnLink(){
        conveyorHistoryPage.clickOnLinkButton();
    }

    @QAFTestStep(description = "User should see technical data page")
    public void userShouldSeeTechnicalDataPage(){
        SyncUtil.waitFor(500);
        Validator.assertTrue(conveyorHistoryPage.getCurrentURL().endsWith("technical-data"),"Technical data page is not displayed","Technical data page is displayd");
    }

    @QAFTestStep(description = "Click on browser back button")
    public void clickOnBrowserBackButton(){
        conveyorHistoryPage.clickBack();
    }

    @QAFTestStep(description = "User clicks on Inspection event row")
    public void userClicksOnInspectionEventRow(){
        conveyorHistoryPage.selectInspectionEvent();
        conveyorHistoryPage.clickOnEvenRow();
    }

    @QAFTestStep(description = "User should not see edit button")
    public void userShouldNotSeeEditButton(){
        Validator.assertTrue(conveyorHistoryPage.editButtonNotVisible(),"Edit button is present","Edit button is not present");
    }

    @QAFTestStep(description = "User should see All the feilds")
    public void userShouldSeeAllTheFeilds(){
        Validator.assertTrue(conveyorHistoryPage.inspectionRowHistory(),"All the feilds are not shown","All the feilds are shown");
    }

    @QAFTestStep(description = "user select Author")
    public void userSelectAuthor(){
        conveyorHistoryPage.selectAuthor();
    }

    @QAFTestStep(description = "Based on author selection, records should display")
    public void basedOnAuthorSelectionRecordsShouldDisplay(){
        Validator.assertTrue(conveyorHistoryPage.authorName.getText().equalsIgnoreCase("Pramod Master"),"Records for the selected user is not shown","Records for the selected user is shown");
    }

    @QAFTestStep(description = "Refresh button is present")
    public void refreshButtonIsPresent(){
        Validator.assertTrue(conveyorHistoryPage.btnRefresh.isVisible("Refresh"),"Refresh button is not present","Refresh button is present");
    }

    @QAFTestStep(description = "User clicks on Refresh button")
    public void userClicksOnRefreshButton(){
        conveyorHistoryPage.clickOnRefresh();
    }
    @QAFTestStep(description = "Page should be refreshed")
    public void pageShouldBeRefreshed(){
        Validator.assertTrue(conveyorHistoryPage.byAuthorDropdown.getText().equals("By Author"),"Page is not refreshed","Page got refreshed");
    }

    @QAFTestStep(description = "Clear filter button is present")
    public void clearFilterButtonIsPresent(){
        Validator.assertTrue(conveyorHistoryPage.clearFilter.isVisible("Clear Filter"),"Clear filter button is not presnt","Clear filter button is present");
    }

    @QAFTestStep(description = "User clicks on clear filter")
    public void userClickOnClearFilter(){
        conveyorHistoryPage.clickOnClearFilter();
    }

    @QAFTestStep(description = "All the filter should get cleared")
    public void allTheFilterShouldGetCleared(){
        Validator.assertTrue(conveyorHistoryPage.byAuthorDropdown.getText().equals("By Author"),"Applied filter is not cleared","Applied filter got cleared");
    }


    @QAFTestStep(description = "User should see conveyor history page Conveyor level")
    public void userShouldSeeConveyorHistoryPageConveyor(){
        Validator.assertTrue(conveyorHistoryPage.verifyConveyorHistoryConveyor(),"All the feilds are not shown","All the feilds are shown");
    }

    @QAFTestStep(description = "User should see conveyor history page Site level")
    public void userShouldSeeConveyorHistoryPageSites(){
        Validator.assertTrue(conveyorHistoryPage.verifyConveyorHistorySites(),"All the feilds are not shown","All the feilds are shown");
    }

    @QAFTestStep(description = "User should be able to click on {ConveyorDropdown} and select the value")
    public void UserSelectsConveyor(String ConveyorDropdown){
        conveyorHistoryPage.setSelectConveyor(ConveyorDropdown);
    }

    @QAFTestStep(description = "User should be able to enter the data into Belt Manufactured {BeltManufactured} text input field")
    public void UserEntersBeltManufacturedData(String BeltManufactured){
        conveyorHistoryPage.setTbBeltManufactured(BeltManufactured);
    }

    @QAFTestStep(description = "User should be able to enter the data into Family {Family} text input field")
    public void UserEntersFamilyData(String Family){
        conveyorHistoryPage.setTbFamily(Family);
    }

    @QAFTestStep(description = "User should be able to enter the data into Top Cover Compound {TopCoverCompound} text input field")
    public void UserEntersTopCoverCompound(String TopCoverCompound){
        conveyorHistoryPage.setTbTopCoverCompounds(TopCoverCompound);

    }
    @QAFTestStep(description = "Click on belt details tab")
    public void clickOnBeltDetailsTab(){
        conveyorHistoryPage.clickNext();
    }

    @QAFTestStep(description = "User should be able to click on Fabric Type Dropdown {FabricTypeDropdown} and select the value")
    public void userSelectsFabricType(String FabricTypeDropdown){
        conveyorHistoryPage.setSelectFabricType(FabricTypeDropdown);
    }

    @QAFTestStep(description = "User should be able to click on Other Specials Dropdown {OtherSpecialsDropdown} and select the value")
    public void userSelectsOtherSpecials(String OtherSpecialsDropdown){
        conveyorHistoryPage.setSelectOtherSpecials(OtherSpecialsDropdown);
    }

    @QAFTestStep(description = "User should be able to click on Tension Unit Dropdown {tensionUnitDropdown} and select the value")
    public void userSelectsTensionUnit(String tensionUnitDropdown){
        conveyorHistoryPage.setSelectTensionUnit(tensionUnitDropdown);
    }

    @QAFTestStep(description = "User should be able to click on Piles Dropdown {pliesdropdown} and select the value")
    public void userSelectPiles(String PliesDropdown){
        conveyorHistoryPage.setSelectPlies(String.valueOf(PliesDropdown.charAt(0)));
    }

    @QAFTestStep(description = "User should be able to enter the data into Width {Width} text input field")
    public void userEntersWidth(String Width){conveyorHistoryPage.setTbWidth(Width);}

    @QAFTestStep(description = "User should be able to enter the data into Top Cover {TopCover} text input field")
    public void userEntersTopCover(String TopCover){
        conveyorHistoryPage.setSelectTopCover(TopCover);
    }

    @QAFTestStep(description = "User should be able to enter the data into Pulley Cover {PulleyCover} text input field")
    public void userEntersPulleyCover(String PulleyCover){
        conveyorHistoryPage.setTbPulleyCover(PulleyCover);
    }

    @QAFTestStep(description = "User should be able to select the data into Pulley Cover {PulleyCover} text input field")
    public void userSelectsPulleyCover(String PulleyCover){
        System.out.println("mypulley"+PulleyCover);
        conveyorHistoryPage.setSelectPulleyCover(PulleyCover);
    }


    @QAFTestStep(description = "User should be able to click on the Tension Dropdown {Tension} select the value")
    public void userSelectsTension(String Tension){
        conveyorHistoryPage.setSelectTension(Tension);
    }

    @QAFTestStep(description = "Click on Age & Failure mode tab")
    public void clickOnAgeFailureModeTab(){
        SyncUtil.waitFor(5000);
        conveyorHistoryPage.clickNext();
        SyncUtil.waitFor(5000);
        conveyorHistoryPage.clickNext();
    }

    @QAFTestStep(description = "User should be able to see all content of Age & Failure mode tab")
    public void userShouldBeAbleToSeeCllContentOfAgeFailureModeTab(){
        Validator.assertTrue(conveyorHistoryPage.verifyAgeAndFailureMode(),"All the feilds in Age and Failure Mode are not present","All the feilds in Age and Failure Mode are present");
    }

    @QAFTestStep(description = "User should be able to select the InstalledDate from calendar")
    public void selectInstalledDate(){
        conveyorHistoryPage.setCalendarDateInstalled();
    }

    @QAFTestStep(description = "User should be able to select the FailedDate from calendar")
    public void selectFailedDate(){
        conveyorHistoryPage.setCalendarDateFailed();
    }

    @QAFTestStep(description = "User should be able to click on Years On System {YearsOnSystem} text input field")
    public void userEntersYearOnSystem(String YearOnSystem){
        conveyorHistoryPage.setTbYearOfSystem(YearOnSystem);
    }

    @QAFTestStep(description = "User should be able to click on failure mode dropdown {FailureModeDropdown} and select the value")
    public void userSelectsFailureMode(String FailureModeDropdown){
        conveyorHistoryPage.setSelectFailureMode(FailureModeDropdown);
        conveyorHistoryPage.closePopupButtonForFailureMode();
     //   conveyorHistoryPage.failureModeCheckBox();
    }


    @QAFTestStep(description = "User should be able to enter the data into {Comments} text input field")
    public void userEntersComment(String Comments){
        conveyorHistoryPage.setTbComments(Comments);
    }

    @QAFTestStep(description = "Drag and drop any {FileOrDocument} from system to application")
    public void userDropsFile(String FileOrDocument){
        conveyorHistoryPage.uploadFile(FileOrDocument);
    }

    @QAFTestStep(description = "Enter the required data into all fields {ConveyorDropdown} and {BeltManufactured} and {Family} and {TopCoverCompound}")
    public void userEntersRequiredFeild(String ConveyorDropdown,String BeltManufactured,String Family,String TopCoverCompound){
        conveyorHistoryPage.setSelectConveyor(ConveyorDropdown);
        conveyorHistoryPage.setTbBeltManufactured(BeltManufactured);
        conveyorHistoryPage.setTbFamily(Family);
        conveyorHistoryPage.setTbTopCoverCompound(TopCoverCompound);
    }

    @QAFTestStep(description = "Click on cancel button")
    public void userClicksOnCancel(){
        conveyorHistoryPage.clickCancel();
    }

    @QAFTestStep(description = "Click on Save button")
    public void userClicksOnSave(){
        conveyorHistoryPage.clickSave();
    }

    @QAFTestStep(description = "User clicks on any one of the event")
    public void userClicksOnAnyEvent(){
        conveyorHistoryPage.selectEvent();
        conveyorHistoryPage.clickOnEvenRow();
      //  conveyorHistoryPage.setSelectFailureModeDropDown();
      //  conveyorHistoryPage.clickCrossMarkBeltFailure();
    }

    @QAFTestStep(description = "clicks on action button")
    public void userClickOnAction(){
        conveyorHistoryPage.clickOnAction();
    }

    @QAFTestStep(description = "Dropdown should loads with Edit and delete option")
    public void userShouldSeeDropdown(){
        conveyorHistoryPage.verifyActionDropdown();
    }

    @QAFTestStep(description = "Click on actions and click on delete button")
    public void userCLicksOnDelete(){
        conveyorHistoryPage.clickOnAction();
        conveyorHistoryPage.clickOnDelete();
    }

    @QAFTestStep(description = "Verify delete button functionality")
    public void verifyingDeleteButtonFunctionality(){
        Validator.assertTrue(conveyorHistoryPage.verifyDeleteConfirmPopup(),"All the feilds are not shown","ALl the feilds are shown with message : "+conveyorHistoryPage.confirmationMessage.getText());
    }

    @QAFTestStep(description = "Click on actions and click on edit button")
    public void userClickOnEdit(){
        conveyorHistoryPage.clickOnAction();
        conveyorHistoryPage.clickOnEdit();
    }

    @QAFTestStep(description = "Verify edit functionality")
    public void verifyEditButtonFunctionality(){
        conveyorHistoryPage.verifyEditFunctionality();
    }

    @QAFTestStep(description = "Look for from calendar date picker")
    public void lookForFromCalendar() {
        Validator.assertTrue(conveyorHistoryPage.fromCalendar.isVisible("From calendar"), "From calendar is not Present", "From calendar is Present");
    }

    @QAFTestStep(description = "Click on from calendar and select any one date")
    public void clickOnFromCalendar(){
        conveyorHistoryPage.clickOnFromCalendar();
    }

    @QAFTestStep(description = "Look for to calendar date picker")
    public void lookForToCalendar(){
        Validator.assertTrue(conveyorHistoryPage.toCalendar.isVisible("To calendar"), "To calendar is not Present", "To calendar is Present");
    }

    @QAFTestStep(description = "Click on to calendar and select any one date")
    public void clickOnToCalendar(){
        conveyorHistoryPage.clickOnToCalendar();
    }

    @QAFTestStep(description = "Click on add button and click on component change")
    public void userClickOnComponentChange(){
        conveyorHistoryPage.clickOnComponentChange();
    }

    @QAFTestStep(description = "User Should see all the fields in the Component change message box")
    public void verifyComponetChangeMessageBox(){
        Validator.assertTrue(conveyorHistoryPage.verifyComponentChange(),"All the feilds of component change are not shown","ALl the feilds of component change are shown");
    }
    @QAFTestStep(description = "User Should see all the fields in the Component change message box on Conveyor History")
    public void verifyComponetChangeMessageBoxConveyorHistory(){
        Validator.assertTrue(conveyorHistoryPage.verifyComponentChangeConveyor(),"All the feilds of component change are not shown","ALl the feilds of component change are shown");
    }


    @QAFTestStep(description = "User should be able to click on component type dropdown {ComponentType} and select the value")
    public void userSelectComponentType(String ComponentType){
        conveyorHistoryPage.setSelectComponentType(ComponentType);
    }

    @QAFTestStep(description = "User should be able to enter the data into Ref number used part {NumberUsedPart} text input field")
    public void userEntersNumberUsedPart(String NumberUsedPart){
        conveyorHistoryPage.setTbNumberUsedPart(NumberUsedPart);
    }

    @QAFTestStep(description = "User should be able to enter the data into Ref number new part {NumberNewPart} text input field")
    public void userEntersNumberNewPart(String NumberNewPart){
        conveyorHistoryPage.setTbNumberNewPart(NumberNewPart);
    }

    @QAFTestStep(description = "Enter all details component change {ComponentType} and {NumberUsedPart} and {NumberNewPart} and {Comments} and {FileOrDocument}")
    public void userEntersAllComponetChangeDetails(String ComponentType,String NumberUsedPart,String NumberNewPart,String Comments,String FileOrDocument){
      //  conveyorHistoryPage.setSelectConveyor(ConveyorDropdown);
        conveyorHistoryPage.setSelectComponentType(ComponentType);
        conveyorHistoryPage.setTbNumberUsedPart(NumberUsedPart);
        conveyorHistoryPage.setTbNumberNewPart(NumberNewPart);
        conveyorHistoryPage.setTbComments(Comments);
    }

    @QAFTestStep(description = "Click on add button and click on custom event change")
    public void userClickOnCustomEvent(){
        conveyorHistoryPage.clickOnCustomEvent();
    }

    @QAFTestStep(description = "User Should see all the fields in the Custom event functionality")
    public void verifyCustomEventMessageBox(){
        Validator.assertTrue(conveyorHistoryPage.verifyCustomEvent(),"All the feilds in custom event are not shown","All the feilds in custom event are showm");
    }

    @QAFTestStep(description = "User should be able to enter the data into title {title} text input field")
    public void userEntersTitle(String title){
        conveyorHistoryPage.setTbTitle(title);
    }

    @QAFTestStep(description = "Enter all details custom event {title} and {Comments} and {FileOrDocument}")
    public void userEntersAllCustomEventDetails(String title,String Comments,String FileOrDocument){
       // conveyorHistoryPage.setSelectConveyor(ConveyorDropdown);
        conveyorHistoryPage.setTbTitle(title);
        conveyorHistoryPage.setTbComments(Comments);
    }

    @QAFTestStep(description = "Entered componet change details should be saved")
    public void componetChangeSaved(){
        Validator.assertTrue(conveyorHistoryPage.verifyToastMessage(),"Enetred conponet change details Not saved","Entered component change details saved");
    }

    @QAFTestStep(description = "Entered Custom event details should be saved")
    public void customEventSaved(){
        Validator.assertTrue(conveyorHistoryPage.verifyToastMessage(),"Enetred custom event details Not saved","Entered custom event details saved");
    }

    @QAFTestStep(description = "Success message should display")
    public void beltfailureSuccessMessage(){
        Validator.assertTrue(conveyorHistoryPage.verifyToastMessage(),"Success Message is not displayed","Success message is displayed");

    }

    @QAFTestStep(description = "Look for ascending/descending order button")
    public void lookForSortButton(){
        Validator.assertTrue(conveyorHistoryPage.btnSort.isVisible("Sort"),"Sort button is not present","Sort button is present");
    }

//    @QAFTestStep(description = "Click on Sort button")
//    public void clickOnSortButton(){
//        conveyorHistoryPage.setInitialDate();
//        conveyorHistoryPage.clickOnSort();
//        conveyorHistoryPage.setFinalDate();
//    }
//
//    @QAFTestStep(description = "Again click sort on button")
//    public void againClickOnSortButton(){
//        clickOnSortButton();
//    }

    @QAFTestStep(description = "Click on Sort button and Records should display in ascending order")
    public void recordsShouldDisplayInAscendingOrder(){
        conveyorHistoryPage.ascending();
    }

    @QAFTestStep(description = "Again click sort on button Records should display in descending order")
    public void recordsShouldDisplayInDescedingOrder(){
        conveyorHistoryPage.descending();
    }

    @QAFTestStep(description = "Look for By Event dropdown in table header")
    public void lookForEventDropDown(){
        conveyorHistoryPage.lookForByEvent();
    }

    @QAFTestStep(description = "Click on By Event dropdown")
    public void clickOnByEventdropdown(){
        conveyorHistoryPage.clickOnByEvent();
    }

    @QAFTestStep(description = "Click on any one event")
    public void clickOnAnyEvent(){
        conveyorHistoryPage.selectOneEventFromDropDown();
    }
    @QAFTestStep(description = "Based on event selection, records should display")
    public void verifySelectedEvent(){
        conveyorHistoryPage.verifySelectedEvent();
    }

    @QAFTestStep(description = "Click on save button without entering the data")
    public void clickOnSaveWithoutEnteringData(){
        conveyorHistoryPage.clickSave();
    }

    @QAFTestStep(description = "Undefined text should not display on fields")
    public void undefinedTextShouldNotDisplayOneFields(){
        SyncUtil.waitFor(5000);
        Validator.assertTrue(conveyorHistoryPage.tbBeltManufactured.getText().equals(""),"Undefined text is shown","Undefined text is not shown");
    }

    @QAFTestStep(description = "Click on conveyor edition")
    public void clickOnConveyorEdition(){
        conveyorHistoryPage.selectConveyorEvent();
        conveyorHistoryPage.clickOnEvenRow();
    }

    @QAFTestStep(description = "Verify conveyor edition")
    public void verifyConveyorEdition(){
        Validator.assertTrue(conveyorHistoryPage.verifyConveyorEdited(),"All the fields are not shown","All the fields are shown");
    }

    @QAFTestStep(description = "Click on cover wear row")
    public void clickOnCoverWear(){
        conveyorHistoryPage.selectCoverWearEvent();
        conveyorHistoryPage.clickOnEvenRow();
    }

    @QAFTestStep(description = "Verify cover wear details")
    public void verifyCoverWear(){
        Validator.assertTrue(conveyorHistoryPage.verifyCoverWear(),"All the fields are not shown","All the fields are shown");
    }


}

