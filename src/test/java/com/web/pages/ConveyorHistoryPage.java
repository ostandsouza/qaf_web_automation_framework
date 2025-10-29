package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConveyorHistoryPage extends BasePage{


    @FindBy(locator = "xpath=//div[contains(text(),'By Author')]")
    public CustomElement byAuthorDropdown;

    @FindBy(locator = "xpath=//div[contains(text(),'By Event')]")
    public CustomElement byEventDropdown;

    @FindBy(locator = "xpath=//div[contains(text(),'By Conveyor')]")
    public CustomElement byConveyorDropdown;

    @FindBy(locator = "xpath=(//p-datepicker[contains(@placeholder,'MM/DD/YYYY')])[1]")
    public CustomElement fromCalendar;

    @FindBy(locator = "xpath=(//p-datepicker[contains(@placeholder,'MM/DD/YYYY')])[2]")
    public CustomElement toCalendar;

    @FindBy(locator = "xpath=//span[@class='p-button-icon pi pi-refresh']")
    public CustomElement btnRefresh;

    @FindBy(locator = "xpath=//span[@class='p-button-icon ctp-icon-Clear-Filters']")
    public CustomElement clearFilter;

    @FindBy(locator = "xpath=//span[@class='p-button-icon ctp-icon-sort-icon-down']")
    public CustomElement btnSort;

    @FindBy(locator = "xpath=//button[@class='p-element p-button-rounded p-button-outlined p-button p-component p-button-icon-only' and @icon='ctp-icon-Add-circle']")
    public CustomElement btnAdd;

    @FindBy(locator = "xpath=//div[contains(@class,'p-panel-icons-end')]")
    public CustomElement collapseButton;

    @FindBy(locator = "xpath=//ul[@role='menu']")
    public CustomElement menuDropdown;

    @FindBy(locator = "xpath=//span[text()='Belt Failure']")
    public CustomElement beltFailure;

    @FindBy(locator = "xpath=//span[text()='Component Change']")
    public CustomElement componentChange;

    @FindBy(locator = "xpath=//span[text()='Custom Event']")
    public CustomElement customEvent;

    @FindBy(locator = "xpath=//span[contains(text(),'Brand & Compound')]/..")
    public CustomElement tabBrandCompound;

    @FindBy(locator = "xpath=//span[contains(text(),'Belt Details')]/..")
    public CustomElement tabBeltDetails;

    @FindBy(locator = "xpath=//span[contains(text(),'Age & Failure mode')]/..")
    public CustomElement tabAgeFailureMode;

    @FindBy(locator = "xpath=(//p-select[@formcontrolname='tension'])")
    public CustomElement TensionDropdown;

    @FindBy(locator = "xpath=//div[contains(@class,'p-panel-header')]/h4")
    public CustomElement conveyorName;

    @FindBy(locator = "xpath=//button[contains(@class,'p-dialog-header')]/timesicon")
    public CustomElement btnCross;


    @FindBy(locator = "xpath=//button[contains(@class,'p-dialog-header')]/timesicon")
    public CustomElement componentChangeCrossMark;

    @FindBy(locator = "xpath=//button[contains(@class,'p-dialog-header')]/timesicon")
    public CustomElement customEventCrossMark;

    @FindBy(locator = "xpath=//button[@type='button']/span[text()='Next']")
    public CustomElement btnNext;

    @FindBy(locator = "xpath=//button[contains(text(),'Save')]")
    public CustomElement btnSave;

    @FindBy(locator = "xpath=//button[contains(text(),'Cancel')]")
    public CustomElement btnCancel;

    @FindBy(locator = "xpath=(//input[@class='p-inputtext p-component p-element p-filled ng-star-inserted'])")
    public CustomElement selectConveyor;

    @FindBy(locator = "xpath=(//input[@formcontrolname='beltManufactured'])")
    public CustomElement tbBeltManufactured;

    @FindBy(locator = "xpath=//input[@formcontrolname='family']")
    public CustomElement tbFamily;

    @FindBy(locator = "xpath=//input[@formcontrolname='topCoverCompounds']")
    public CustomElement tbTopCoverCompound;

    @FindBy(locator = "xpath=//span[text()='Yes']/..")
    public CustomElement btnYes;

    @FindBy(locator = "xpath=//span[text()='No']/..")
    public CustomElement btnNo;

    @FindBy(locator = "xpath=//p-select[@formcontrolname='fabricType']")
    public CustomElement   selectFabricType;

    @FindBy(locator = "xpath=//p-select[@formcontrolname='otherSpecials']")
    public CustomElement selectOtherSpecials;

    @FindBy(locator = "xpath=//p-select[@formcontrolname='tensionUnit']")
    public CustomElement selectTensionUnit;

    @FindBy(locator = "xpath=//input[@formcontrolname='width']")
    public CustomElement tbWidth;

    @FindBy(locator = "xpath=//input[@formcontrolname='pulleyCover']")
    public CustomElement tbPulleyCover;

    @FindBy(locator = "xpath=//p-select[@formcontrolname='pulleyCover']")
    public CustomElement selectPulleyCover;

    @FindBy(locator = "xpath=//p-select[@formcontrolname='plies']")
    public CustomElement selectPlies;

    @FindBy(locator = "xpath=//input[@formcontrolname='topCover']")
    public CustomElement tbTopCover;

    @FindBy(locator = "xpath=//p-select[@formcontrolname='topCover']")
    public CustomElement selectTopCover;


    @FindBy(locator = "xpath=//p-datepicker[@formcontrolname='dateInstalled']")
    public CustomElement calendarDateInstalled;

    @FindBy(locator = "xpath=//p-datepicker[@formcontrolname='dateFailed']")
    public CustomElement calendarDateFailed;

    @FindBy(locator = "xpath=//input[@formcontrolname='yearsOnSystem']")
    public CustomElement tbYearOfSystem;

    @FindBy(locator = "xpath=//p-multiselect[@formcontrolname='failureMode']")
    public CustomElement selectFailureMode;

    @FindBy(locator = "xpath=(//button[@type='button']//timesicon)[2]")
    public CustomElement failureModePopupCrossButton;

    @FindBy(locator = "xpath=//textarea[@formcontrolname='comments']")
    public CustomElement tbComments;

    @FindBy(locator = "xpath=//button[contains(text(),'Select Files')]")
    public CustomElement uploadFile;

    @FindBy(locator = "xpath=//div[@role='dialog']")
    public CustomElement messageBox;

    @FindBy(locator = "xpath=(//div[contains(@class,'p-d-flex p-ai-center')])[2]/span[2]")
    public CustomElement authorName;

    @FindBy(locator = "xpath=//span[@class='p-button-icon ctp-icon-link']")
    public CustomElement btnLink;

    @FindBy(locator = "xpath=//span[text()='Edit']")
    public CustomElement btnEdit;

    @FindBy(locator = "xpath=(//div[@class='p-d-flex p-ai-center'])[1]")
    public CustomElement eventRow;

    @FindBy(locator = "xpath=(//i[@class='ctp-icon-Arrow-Right'])[1]")
    public CustomElement eventArrow;

    @FindBy(locator = "xpath=//input[contains(@class,'p-multiselect-filter p-inputtext')]")
    public CustomElement searchInput;

    @FindBy(locator = "xpath=//div[@class='p-checkbox-box p-highlight']")
    public CustomElement failureModeCheckBox;

    @FindBy(locator = "xpath=//button[@type='button']//timesicon")
    public CustomElement clickCrossMarkBeltFailure;


   // @FindBy(locator = "xpath=//div/span[@class='p-checkbox-icon']")
    public CustomElement selectSearch;

    @FindBy(locator = "xpath=//div/div[contains(@class,'p-d-flex p-ai-center p-p-custom')]/div[contains(@class,'time p-d-flex p-jc-center p-ai-center')]")
    public CustomElement inspectionCreatedDate;

    @FindBy(locator = "xpath=//div/div[contains(@class,'p-d-flex p-ai-center p-p-custom')]/span[2]")
    public CustomElement inspectorName;

    @FindBy(locator = "xpath=//div/div[contains(@class,'p-d-flex p-ai-center p-p-custom')]/span[3]")
    public CustomElement inspectConveyorName;

    @FindBy(locator = "xpath=//div[@class='p-card-title ng-star-inserted' and contains(text(),'TOTAL')]/..")
    public CustomElement crTotal;

    @FindBy(locator = "xpath=//div[@class='p-card-title ng-star-inserted' and contains(text(),'CRITICAL')]/..")
    public CustomElement crCritical;

    @FindBy(locator = "xpath=//div[@class='p-card-title ng-star-inserted' and contains(text(),'POOR')]/..")
    public CustomElement crPoor;

    @FindBy(locator = "xpath=//div[@class='p-card-title ng-star-inserted' and contains(text(),'FAULT')]/..")
    public CustomElement crFault;

    @FindBy(locator = "xpath=//div[@class='p-card-title ng-star-inserted' and contains(text(),'GOOD')]/..")
    public CustomElement crGood;

    @FindBy(locator = "xpath=//div[contains(@class,'p-d-flex to-be-completed p-jc-between ')]")
    public CustomElement crTobeCompleted;

    @FindBy(locator = "xpath=//div[contains(@class,'to-be-completed summary')]")
    public CustomElement crSummary;

    @FindBy(locator = "xpath=//div[contains(@class,'p-virtualscroller-list')]")
    public CustomElement eventList;

    @FindBy(locator = "xpath=//div/table/thead/tr/th[1]")
    public CustomElement tblField;

    @FindBy(locator = "xpath=//div/table/thead/tr/th[2]")
    public CustomElement tblPrevious;

    @FindBy(locator = "xpath=//div/table/thead/tr/th[3]")
    public CustomElement tblEdited;


    @FindBy(locator = "xpath=(//h6[contains(@class,'conveyor-name')])[1]")
    public CustomElement conveyorNameInEventList;

    @FindBy(locator = "xpath=(//div[contains(@class,'time p-d-flex p-jc-center p-ai-center')])[1]")
    public CustomElement inspectionDate;

    @FindBy(locator="xpath=//input[@type='file']")
    public CustomElement fileUpload;

    @FindBy(locator="xpath=//td[contains(@class,'p-datepicker-today')]")
    public CustomElement ciTodayDate;

    @FindBy(locator = "xpath=//div[@role='alert']/div/div[contains(@class,'p-toast-summary')]")
    public CustomElement toastMessage;

    @FindBy(locator = "xpath=//span[@class='p-button-icon p-button-loading-icon pi pi-spinner pi-spin']")
    public CustomElement spinner;

    @FindBy(locator = "xpath=//button[@class='p-element p-splitbutton-menubutton p-button-icon-only p-button p-component']")
    public CustomElement actionDropdown;

    @FindBy(locator = "xpath=//span[text()='Delete']")
    public CustomElement btnDelete;

    @FindBy(locator = "xpath=//p-select[@formcontrolname='componentType']")
    public CustomElement selectComponentType;

    @FindBy(locator = "xpath=//input[@formcontrolname='refNumberUseedPart']")
    public CustomElement tbNumberUsedPart;

    @FindBy(locator = "xpath=//input[@formcontrolname='refNumberNewPart']")
    public CustomElement tbNumberNewPart;

    @FindBy(locator = "xpath=//input[@formcontrolname='title']")
    public CustomElement tbTitle;

    @FindBy(locator = "xpath=//div/span[contains(@class,'p-confirm-dialog-message')]")
    public CustomElement confirmationMessage;

    @FindBy(locator = "xpath=(//i[@class='ctp-icon-clock']/following-sibling::span)[1]")
    public CustomElement dateOnEventlist;

    @FindBy(locator = "xpath=//ul[@role='listbox']")
    public CustomElement listByEvent;

    @FindBy(locator = "xpath=(//div[1]/div/div/div[2]/div/div/h6)[2]")
    public CustomElement eventNameEventList;

    @FindBy(locator = "xpath=//div[text()=' Cover Wear URL: ']")
    public CustomElement coverWearURL;

    @FindBy(locator = "xpath=//table/thead/tr/th[1]")
    public CustomElement measuredAndDatesInstalled;

    @FindBy(locator = "xpath=//table/thead/tr/th[5]")
    public CustomElement location599;

    @FindBy(locator = "xpath=(//label[text()='Conveyor']/following::input)[1]")
    public CustomElement conveyorTextBox;

    @FindBy(locator="xpath=(//p-button[@icon='ctp-icon-Arrow-Right']/button)[1]")
    public CustomElement crviewicon;

    @FindBy(locator = "xpath=(//div[text()='Conveyor History']/..//div[contains(@class,'text-area')]/span)[1]")
    public CustomElement crConveyorHistory;

    @FindBy(locator="xpath=(//app-card//div[text()='Conveyor History']/..//span)[1]")
    public CustomElement btConveyorHistoryCardNo;

    @FindBy(locator = "xpath=//*[text()='Conveyor Inspect']")
    public CustomElement conveyorInspect;


    String textInput="//ul[@role='listbox']//li//span[not(@aria-hidden)]";
    String textInput1="//ul[@role='listbox']//li";

    String initialDate;
    String finalDate;

    String dateFormat="dd MMM yyyy";

    public void addButtonVisible(){
        Validator.assertTrue(btnAdd.isVisible(),"Add button is not visible","Add button is visible");
    }

    public void clickAddButton(){
//        waitForPageLoad(5000);
  //      SyncUtil.waitFor(500);
        if(!(conveyorNameInEventList.isVisible()))
            SyncUtil.waitFor(2000);
//        waitForElementToDisplay(conveyorNameInEventList);
        btnAdd.click("Add Button");
        SyncUtil.waitFor(2000);
    }

    public void verifyAddDropdown(){
        Validator.assertTrue(menuDropdown.getText().equals("Belt Failure\n" + "Component Change\n" + "Custom Event"),"All the feilds in dropdown is not shown","All the feilds in deopdown is shown");
    }

    public void clickOnBeltFailure(){
        beltFailure.click("Belt Failure");
    }

    public boolean verifyBeltFailureMessageBox(){
        return tabBrandCompound.isVisible("Brand and Compounds")&&tabBeltDetails.isVisible("Belt Details")
                &&tabAgeFailureMode.isVisible("Age and Failure mode")&&btnNext.isVisible("Next")
                &&btnCross.isVisible("Close")&&btnSave.isVisible("Save")&&btnCancel.isVisible("Cancel");
    }

    public boolean verifyBrandAndCompound(){
        return selectConveyor.isVisible("Conveyor")&&tbBeltManufactured.isVisible("Belt Manufactured")
                &&tbFamily.isVisible("Family")&&tbTopCoverCompound.isVisible("Top Cover Compound");
    }

    public  boolean verifyconveyortextbox(){
    return selectConveyor.isVisible("conveyor");
    }

    public boolean verifyBeltDetails(){
        return selectFabricType.isVisible("Fabric Type")&&selectOtherSpecials.isVisible("Other Specials")
                &&selectTensionUnit.isVisible("Tension Unit")&&tbWidth.isVisible("Width")&&selectPlies.isVisible("Plies")
                &&tbPulleyCover.isVisible("Pulley Cover")&&tbTopCover.isVisible("Top Cover");
    }

    public boolean verifyAgeAndFailureMode(){
        return calendarDateInstalled.isVisible("Date Installed")&&calendarDateFailed.isVisible("Date Failed")
                &&tbYearOfSystem.isVisible("Year on System")&&selectFailureMode.isVisible("Failure Mode")
                &&tbComments.isVisible("Comments")&&uploadFile.isVisible("Upload Files");
    }

    public boolean verifyCloseButton(){
        return btnCross.isVisible("Close Button");
    }

    public void clickClose(){
        btnCross.click("Close");
    }
    public void clickCloseMark(){
        componentChangeCrossMark.click("componentChangeCrossMark");
    }
    public void clickCloseMarkCustomEvent(){
        customEventCrossMark.click("customEventCrossMark");
    }



    public boolean verifyMessageBox(){
        try {
            waitForElementVisible(messageBox,500,100);
            return false;
        }catch (Exception e){
            return true;
        }

    }

    public void setSelectConveyor(String Conveyor){
        dropdownSelect(selectConveyor,textInput,Conveyor);
    }

    public void setTbBeltManufactured(String BeltManufactured){
        tbBeltManufactured.type(BeltManufactured,"Belt Manufactured");
    }

    public void setTbFamily(String Family){
        tbFamily.type(Family, "Family");
    }

    public void setTbTopCoverCompound(String TopCoverCompound){
       tbTopCover.type(TopCoverCompound,"Top Cover Compound");
    }
    public void setTbTopCoverCompounds(String TopCoverCompound){
        tbTopCoverCompound.type(TopCoverCompound,"Top Cover Compound");
    }
    public void setSelectTopCover(String TopCover){
        dropdownSelect(selectTopCover,textInput,TopCover);
    }
    public void setSelectPulleyCover(String PulleyCover) {
        dropdownSelect(selectPulleyCover, textInput, PulleyCover);
    }


    public void setSelectFabricType(String FabricType){
        dropdownSelect(selectFabricType,textInput,FabricType);
    }

    public void setSelectOtherSpecials(String OtherSpecials){
        dropdownSelect(selectOtherSpecials,textInput,OtherSpecials);
    }

    public void setSelectTensionUnit(String TensionUnit){
        dropdownSelect(selectTensionUnit,textInput,TensionUnit);
    }

    public void setSelectPlies(String Plies){
        SyncUtil.waitFor(2000);
        dropdownSelect(selectPlies,textInput1,Plies);
    }

    public void setTbWidth(String width){
        SyncUtil.waitFor(2000);
        tbWidth.sendKeys(width,"Width");
    }

    public void setTbTopCover(String TopCover){

        SyncUtil.waitFor(2000);
        tbTopCover.sendKeys(TopCover,"Top cover");
    }

    public void setTbPulleyCover(String pullyCover){
        SyncUtil.waitFor(2000);
        tbPulleyCover.sendKeys(pullyCover,"Pulley Cover");
    }

    public void setTbYearOfSystem(String YearOnSystem){
        tbYearOfSystem.type(YearOnSystem,"Year on system");
    }

    public void setSelectFailureMode(String failureMode){
        dropdownSearchClick(selectFailureMode,searchInput,failureMode);
    }
    public void setSelectFailureModeDropDown(String failureMode){
        dropdownSearchClick(selectFailureMode,searchInput,failureMode);
    }


    public void closePopupButtonForFailureMode(){
        failureModePopupCrossButton.click();
    }
//    public void checkBoxClickForFailureMode() {
//        failureModeCheckBox.click();
  //  }

    private void dropdownSearchClick(CustomElement selectFailureMode, CustomElement searchInput, String failureMode) {
        waitForPageLoad(40000);
        dropdownSelectSearch(selectFailureMode,searchInput,failureMode);
    }

    public void setTbComments(String Comments){
        tbComments.type(Comments,"Comments");
    }

    public boolean verifyLinkButton(){
//        waitForElementVisible(btnLink,10000,500);
        waitForPageLoad(5000);
        return btnLink.isVisible("Link");
    }

    public void clickOnLinkButton(){
        btnLink.click("Link Button");
    }

    public void clickBack(){
        getTestBase().getDriver().navigate().back();
        Reporter.log("Clicked on browser back button", MessageTypes.Pass);
    }

    public boolean editButtonNotVisible(){
        try {
            waitForElementVisible(btnEdit,500,100);
            return false;
        }catch (Exception e){
            return true;
        }

    }

    public void selectInspectionEvent(){
        waitForElementVisible(byEventDropdown,5000,100);
        dropdownSearchClick(byEventDropdown,searchInput,"Inspection");
    }

    public void clickOnEvenRow(){
        waitForElementVisible(eventRow,5000,100);
        eventRow.click("Event Row");
    }

    public boolean inspectionRowHistory(){
        return inspectionCreatedDate.isVisible("Inspection created date")&&inspectorName.isVisible("Inspector Name")
                &&inspectConveyorName.isVisible("Conveyor Name")&&crTotal.isVisible("Total")
                &&crCritical.isVisible("Critial")&&crPoor.isVisible("Poor")&&crFault.isVisible("Fault")
                &&crGood.isVisible("Good")&&crTobeCompleted.isVisible("To be completed")&&crSummary.isVisible("Summury");
    }

    public void selectAuthor(){
        SyncUtil.waitFor(10000);
        waitForElementVisible(byAuthorDropdown,5000,100);
        dropdownSelectSearch(byAuthorDropdown,searchInput,"Vivek Kumar");
    }

    public void selectEvent(){
        SyncUtil.waitFor(10000);
        dropdownSearchClick(byEventDropdown,searchInput,"Belt Failure");
    }

    public void clickOnRefresh(){
        btnRefresh.click("Refresh");
    }

    public boolean verifyConveyorHistoryConveyor(){
        waitForPageLoad(20000);
        return conveyorName.isVisible("Conveyor Name")
                &&eventArrow.isVisible("Arrow")&&byAuthorDropdown.isVisible("By Author")
                &&byEventDropdown.isVisible("By Event")&&fromCalendar.isVisible("Calendar From")
                &&toCalendar.isVisible("To Calendar")&&btnRefresh.isVisible("Refresh")
                &&btnAdd.isVisible("Add (+)")&&collapseButton.isVisible("Expand and collapse");
    }
    public boolean verifyConveyorTextBoxName(){
        waitForElementToDisplay(conveyorTextBox);
        return conveyorTextBox.isVisible("conveyor textbox");
    }

    public boolean verifyConveyorHistorySites(){
        waitForElementToDisplay(eventList);
        return eventList.isVisible("Event List")&&eventArrow.isVisible("Arrow")&&byAuthorDropdown.isVisible("By Author")
                &&byEventDropdown.isVisible("By Event")&&byConveyorDropdown.isVisible("By Conveyor")
                &&fromCalendar.isVisible("Calendar From")&&toCalendar.isVisible("To Calendar")
                &&btnRefresh.isVisible("Refresh")&&btnAdd.isVisible("Add (+)")&&collapseButton.isVisible("Expand and collapse");
    }

    public void uploadFile(String ImageName) {
        String file_path = ClasspathResourceHelper.getPropertyFile("conveyor.image1.png", "test_files").getAbsolutePath();
        fileUpload.sendKeys(file_path, "conveyor.image1.png");
        SyncUtil.waitFor(10000);
    }

    public void setSelectTension(String Tension){
        SyncUtil.waitFor(2000);
        dropdownSelect(TensionDropdown,textInput,Tension);
    }

    public void clickNext(){
        btnNext.click("Next");
    }


    public void setCalendarDateInstalled(){
        calendarDateInstalled.click("Date Installed");
        ciTodayDate.click("Current date");
    }

    public void setCalendarDateFailed(){
        calendarDateFailed.click("Date Failed");
        ciTodayDate.click("Current date");
    }

    public void clickCancel(){
        SyncUtil.waitFor(20000);
        btnCancel.click("Cancel");
        SyncUtil.waitFor(20000);
        btnYes.click("Yes");
    }

    public void clickSave(){
        btnSave.click("Save");
    }

    public void clickOnAction(){
        actionDropdown.click("Action");
    }

    public void verifyActionDropdown(){
        if(btnEdit.isVisible("Edit"))
            Reporter.log("Edit option is present",MessageTypes.Pass);
        if(btnDelete.isVisible("Delete"))
            Reporter.log("Delete option is present",MessageTypes.Pass);
    }

    public void clickOnDelete(){
        btnDelete.click("Delete");
    }

    public void clickOnEdit(){
        btnEdit.click("Edit");
    }

    public boolean verifyDeleteConfirmPopup(){
        return btnYes.isVisible("Yes")&&btnNo.isVisible("No")&&btnCross.isVisible("Close");
    }

    public void verifyEditFunctionality(){
        tbBeltManufactured.clear();
        tbBeltManufactured.type("Test");
        SyncUtil.waitFor(500);
        if(tbBeltManufactured.getAttribute("value").equals("Test"))
            Reporter.log("User is able to edit the text feilds",MessageTypes.Pass);
        else
            Reporter.log("User is not able to edit the text feild",MessageTypes.Fail);
    }

    public void clickOnFromCalendar(){
        fromCalendar.click("From calendar");
        ciTodayDate.click("Current date");
    }

    public void clickOnToCalendar(){
        toCalendar.click("To calendar");
        ciTodayDate.click("Current date");
    }

    public boolean verifyComponentChange(){
        return selectConveyor.isVisible("Conveyor")&&selectComponentType.isVisible("Component Type")
                &&tbNumberNewPart.isVisible("Ref. Number New Part") &&tbNumberUsedPart.isVisible("Ref number used part")
                &&tbComments.isVisible("Comments")&&uploadFile.isVisible("File upload")&&btnSave.isVisible("Save")
                &&btnCancel.isVisible("Cancel")&&btnCross.isVisible("Close");
    }
    public boolean verifyComponentChangeConveyor(){
        return selectConveyor.isVisible("Conveyor")&&selectComponentType.isVisible("Component Type")
                &&tbNumberNewPart.isVisible("Ref. Number New Part") &&tbNumberUsedPart.isVisible("Ref number used part")
                &&tbComments.isVisible("Comments")&&uploadFile.isVisible("File upload")&&btnSave.isVisible("Save")
                &&btnCancel.isVisible("Cancel")&&componentChangeCrossMark.isVisible("Close");
    }

    public boolean verifyCustomEvent(){
        return selectConveyor.isVisible("Conveyor")&&tbTitle.isVisible("Title")&&tbComments.isVisible("Comment")
                &&uploadFile.isVisible("File upload")&&btnSave.isVisible("Save")&&btnCancel.isVisible("Cancel")
                &&customEventCrossMark.isVisible("Close");
    }

    public void setTbTitle(String Title){
        tbTitle.type(Title,"Title");
    }

    public void setSelectComponentType(String ComponetType){
        dropdownSelect(selectComponentType,textInput,ComponetType);
    }

    public void setTbNumberUsedPart(String NumberUsedPart){
        tbNumberUsedPart.type(NumberUsedPart,"Number Used Part");
    }

    public void setTbNumberNewPart(String NumberNewPart){
        tbNumberNewPart.type(NumberNewPart,"Number New Part");
    }

    public void clickOnComponentChange(){
        waitForPageLoad(5000);
        if(!(conveyorNameInEventList.isVisible()))
            SyncUtil.waitFor(10000);
        btnAdd.click("Add");
        componentChange.click("Component Change");
    }

    public void clickOnCustomEvent(){
        waitForPageLoad(2000);
        if(!(conveyorNameInEventList.isVisible()))
            SyncUtil.waitFor(10000);
        btnAdd.click("Add");
        customEvent.click("Custom Event");
    }

    public boolean verifyToastMessage(){
       waitForElementToDisplay(toastMessage);
       SyncUtil.waitFor(60000);
        return toastMessage.getText().equalsIgnoreCase("Event Created");
    }

    public void clickOnClearFilter(){
        clearFilter.click("Clear Filter");
    }

    public void setInitialDate(){
        SyncUtil.waitFor(1000);
        initialDate=dateOnEventlist.getText();
    }

    public void setFinalDate(){
        SyncUtil.waitFor(1000);
        finalDate=dateOnEventlist.getText();
    }

    public void clickOnSort(){
        btnSort.click("Sort");
    }



    public void ascending(){
        SyncUtil.waitFor(1000);
        initialDate=dateOnEventlist.getText();
        clickOnSort();
        SyncUtil.waitFor(1000);
        finalDate=dateOnEventlist.getText();
        DateFormat sdf=new SimpleDateFormat(dateFormat);
        try {
            Date date1 =sdf.parse(initialDate);
            Date date2 =sdf.parse(finalDate);
            if(date2.before(date1)||date2.equals(date1)) {
                Reporter.log("Records are in ascending order",MessageTypes.Pass);
            }else {
                Reporter.log("Not in ascending order",MessageTypes.Fail);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void descending(){
        SyncUtil.waitFor(1000);
        initialDate=dateOnEventlist.getText();
        clickOnSort();
        SyncUtil.waitFor(1000);
        finalDate=dateOnEventlist.getText();
        DateFormat sdf=new SimpleDateFormat(dateFormat);
        try {
            Date date1 = sdf.parse(initialDate);
            Date date2 = sdf.parse(finalDate);
            if(date1.before(date2)||date1.equals(date2)) {
                Reporter.log("Records are in descending order",MessageTypes.Pass);
            }else {
                Reporter.log("Not in descending order",MessageTypes.Fail);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void lookForByEvent(){
        Validator.assertTrue(byEventDropdown.isVisible("By Event"),"By event Dropdown is not present","By Event dropdown is present");
    }

    public void clickOnByEvent(){
        byEventDropdown.click("By Event");
        SyncUtil.waitFor(200);
        Validator.assertTrue(listByEvent.getText().equalsIgnoreCase("Inspection\n"+"Conveyor\n"+"Cover Wear\n"+"Belt Failure\n"+"Component Change\n"+"Custom Event"),"All the events are not listed","all the events are listed");

    }

    public void selectOneEventFromDropDown(){
        byEventDropdown.click();
        SyncUtil.waitFor(2000);
        selectConveyorEvent();
    }

    public void selectCoverWearEvent(){
        dropdownSearchClickEvent(byEventDropdown,searchInput,"Cover Wear");
    }

    private void dropdownSearchClickEvent(CustomElement byEventDropdown, CustomElement searchInput, String cover_wear) {
        dropdownSelectSearch(byEventDropdown,searchInput,"cover_wear");
    }

    public void selectConveyorEvent(){
        dropdownSearchClickEvent(byEventDropdown,searchInput,"Conveyor");
    }

    public void verifySelectedEvent(){
        Validator.assertTrue(eventNameEventList.getText().contains("Conveyor"),"Based on event selection records are not shown","Base on event selection records are shown");
    }

    public boolean verifyConveyorEdited(){
        return inspectionCreatedDate.isVisible("Creation date")&&inspectorName.isVisible("Name")&&
                inspectConveyorName.isVisible("Conveyor Name")&&tblField.isVisible("Field")&&tblPrevious.isVisible("Previous")
                &&tblEdited.isVisible("Edited");
    }

    public boolean verifyCoverWear(){
        return inspectionCreatedDate.isVisible("Creation Date")&&inspectorName.isVisible("Name")&&inspectConveyorName.isVisible("Conveyor Name")
                &&coverWearURL.isVisible("Cover wear URL")&&measuredAndDatesInstalled.isVisible("Measured (mm) & Dates Installed")
                &&location599.isVisible(" Location (mm) across belt width");
    }

    public void clickCrossMarkBeltFailure() {
        clickCrossMarkBeltFailure.click("cross mark");    }

    public void clickOnConveyorInspect() {
        //   home.click("Home");
        SyncUtil.waitFor(2000);
        conveyorInspect.jsClick();
    }


    // public void clickOnViewArrow() {
    // clickOnViewArrow(ViewArrow);

    public void clickOnViewArrow() {
        SyncUtil.waitFor(4000);
        crviewicon.click();
    }

    public void clickOnConveyorHistory(){
        crConveyorHistory.isEnable("Conveyor History");
        crConveyorHistory.jsClick();
    }

    public void verifyHistoryCardCount(){
        Validator.assertTrue(btConveyorHistoryCardNo.getText("History Card").trim().equalsIgnoreCase("1"),"History card count shown in corporate details screen is incorrect","Successfully verified History card count shown in corporate details screen");
    }
}

