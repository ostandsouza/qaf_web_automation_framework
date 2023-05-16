package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;

import java.util.concurrent.TimeUnit;

public class CoverWearPage extends BasePage{

    @FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
    public CustomElement home;

    @FindBy(locator = "xpath=(//li//span[text()='Cover wear'])[1]")
    public CustomElement coverWearList;

    @FindBy(locator="xpath=(//td[2])[1]")
    public CustomElement cwConveyorName;

    @FindBy(locator="xpath=(//td[3])[1]")
    public CustomElement cwSiteName;

    @FindBy(locator="xpath=(//td[4])[1]")
    public CustomElement cwInstalledDatee;

    @FindBy(locator="xpath=(//td[5])[1]")
    public CustomElement cwGrade;

    @FindBy(locator="xpath=(//td[6]/span)[1]")
    public CustomElement cwDurometer;

    @FindBy(locator="xpath=(//td[9]/button)[1]")
    public CustomElement cwDownload;

    @FindBy(locator="xpath=(//button[@icon='ctp-icon-Arrow-Right'])[1]")
    public CustomElement cwViewIcon;

    @FindBy(locator="xpath=//input[@placeholder='Search']")
    public CustomElement cwSearchInput;

    @FindBy(locator = "xpath=//span[text()='Save and Close']")
    public CustomElement cwSaveAndClose;

    @FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
    public CustomElement pagination;

    @FindBy(locator="xpath=(//td//p-tablecheckbox)[1]")
    public CustomElement cwCheckbox;

    @FindBy(locator="xpath=(//button[@icon='pi pi-chevron-down'])[2]")
    public CustomElement cwActions;

    @FindBy(locator="xpath=//li//span[text()='Edit']")
    public CustomElement cwEdit;

    @FindBy(locator="xpath=//span[text()='Delete']")
    public CustomElement cwDelete;

    @FindBy(locator = "xpath=//span[text()='Update']")
    public CustomElement cwUpdate;

    @FindBy(locator = "xpath=//span[text()='Yes']")
    public CustomElement yesConfirmation;

    @FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
    public CustomElement cwAddNew;

    @FindBy(locator="xpath=//label[text()='Site']/parent::div//div[@role='button']")
    public CustomElement cwSiteDropDown;

    @FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter p-inputtext')]")
    public CustomElement cwInput;

    @FindBy(locator="xpath=//label[text()='Conveyor']/parent::div//div[@role='button']")
    public CustomElement cwConveyorDropDown;

    @FindBy(locator="xpath=//label[text()='Position']/parent::div//div[@role='button']")
    public CustomElement cwPositionDropDown;

    public String ListItem = "//ul[@role='listbox']//li//span";

    @FindBy(locator="xpath=//label[text()='Temperature (°C)']/parent::div//input")
    public CustomElement cwTemperature;

    @FindBy(locator="xpath=//label[text()='Tons Conveyed (current)']/parent::div//input")
    public CustomElement cwTons;

    @FindBy(locator="xpath=//label[contains(text(),'of Data Points')]/parent::div//div[@role='button']")
    public CustomElement cwDataPoints;

    @FindBy(locator="xpath=(//table[@class='add-measurement-table']/button[@icon='ctp-icon-Delete'])[1]")
    public CustomElement cwDeleteMeasurement;

    @FindBy(locator="xpath=//table[@class='add-measurement-table']/button[@icon='ctp-icon-Add-circle']")
    public CustomElement cwAddMeasurement;

    @FindBy(locator="xpath=//button[contains(@class,'p-button-loading')]")
    public CustomElement cwSpecsLoader;
    @FindBy(locator="xpath=//span[text()='Save']")
    public CustomElement cwSave;

    @FindBy(locator="xpath=//span[text()='Cancel']")
    public CustomElement cwCancel;

    @FindBy(locator = "xpath=(//div[text()='Cover Wear']/..//div[contains(@class,'text-area')]/span)[1]")
    public CustomElement crCoverWearCard;

    @FindBy(locator="xpath=//button//span[text()='Edit']")
    public CustomElement cwEditSpec;

    @FindBy(locator="xpath=//label[text()='Belt Width (']/parent::div//input")
    public CustomElement cwBeltWidth;

    @FindBy(locator="xpath=//label[text()='Top Cover Thickness Nominal (']/parent::div//div[@role='button']")
    public CustomElement cwTopCoverThickness;

    @FindBy(locator="xpath=//label[text()='Bottom Cover Thickness Nominal (']/parent::div//div[@role='button']")
    public CustomElement cwBottomCoverThickness;

    @FindBy(locator="xpath=//label[text()='Durometer (New Belt)']/parent::div//input")
    public CustomElement cwSpecDurometer;

    @FindBy(locator="xpath=//label[text()='Top Cover Compound']/parent::div//div[@role='button']")
    public CustomElement cwTopCoverCompound;

    @FindBy(locator="xpath=//label[text()='Bottom Cover Compound']/parent::div//div[@role='button']")
    public CustomElement cwBottomCoverCompound;

    @FindBy(locator="xpath=//label[text()='Tons Conveyed']/parent::div//input")
    public CustomElement cwPositionTonsConveyed;

    @FindBy(locator="xpath=//label[text()='Shore A Durometer (New)']/parent::div//input")
    public CustomElement cwPositionDurometer;

    @FindBy(locator="xpath=(//label[text()='Top / Bottom']/..//p-radiobutton)[1]")
    public CustomElement cwPositionTopRadio;

    @FindBy(locator="xpath=(//label[text()='Top / Bottom']/..//p-radiobutton)[2]")
    public CustomElement cwPositionBottomRadio;

    @FindBy(locator="xpath=//td[contains(@class,'p-datepicker-today')]")
    public CustomElement cwTodayDate;

    @FindBy(locator="xpath=//label[text()='Installed Date']/parent::div//input")
    public CustomElement cwInstalledDate;

    @FindBy(locator="xpath=//span[text()='Add New Position']/../..//span[text()='Save']")
    public CustomElement cwPositionSave;
    @FindBy(locator="xpath=//label[text()='Segment']/parent::div//input")
    public CustomElement cwPositionSegment;

    @FindBy(locator="xpath=(//td[8]/span)[1]")
    public CustomElement cwTableDurometer;

    @FindBy(locator="xpath=(//td[2]/div/span)[1]")
    public CustomElement cwTableSegment;

    @FindBy(locator = "xpath=//td[contains(text(),'No')]")
    public CustomElement noList;

    @FindBy(locator="xpath=(//div[contains(@class,'p-panel-header')]/span)[1]")
    public CustomElement coverWearTitle;

    public void goToCoverWearScreen(){
        if(!coverWearList.isVisible())
            home.click("Home");
        coverWearList.jsClick("Cover Wear List");
        cwSearchInput.isVisible("Cover Wear Page");
    }

    public void goToCoverWearScreenAndWait() {
        goToCoverWearScreen();
        scrollPageDown();
        String val="";
        for (long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(120); stop>System.nanoTime();) {
            if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
                break;
            }
            val = pagination.getText();
            SyncUtil.waitFor(5000);
        }
    }

    public void editMeasurement(String conveyorName) {
        searchCoverWear(conveyorName);
        cwCheckbox.check("Measurement Checkbox");
        cwActions.click("Actions");
        waitForElementVisible(cwEdit, 10000,500);
        cwEdit.click("Edit");
        coverWearTitle.isVisible("Cover Wear Title");
    }

    public void addNewMeasurement(String conveyorName, String siteName, String position, String topCoverThickness, String bottomCoverThickness, String positionDurometer, String topCoverCompound, String bottomCoverCompound) {
        cwAddNew.click("Add New Measurement");
        waitForElementToDisplay(cwSiteDropDown);
        dropdownSelectSearch(cwSiteDropDown, cwInput, siteName);
        dropdownSelectSearch(cwConveyorDropDown, cwInput, conveyorName);
        dropdownSelect(cwPositionDropDown, ListItem, position);
        SyncUtil.waitFor(10000);
        editSpecifications(topCoverThickness,bottomCoverThickness,topCoverCompound,bottomCoverCompound,positionDurometer);
        waitForElementToDisplay(cwCheckbox);
        cwCheckbox.isVisible("Position");
    }

    public void editSpecifications(String topCoverThickness, String bottomCoverThickness, String topCoverCompound, String bottomCoverCompound, String positionDurometer){
        cwEditSpec.click("Edit");
        dropdownSelectSearch(cwTopCoverThickness, cwInput, topCoverThickness);
        dropdownSelectSearch(cwBottomCoverThickness, cwInput, bottomCoverThickness);
        cwSpecDurometer.sendKeys(positionDurometer, "Durometer");
        dropdownSelectSearch(cwTopCoverCompound, cwInput, topCoverCompound);
        dropdownSelectSearch(cwBottomCoverCompound, cwInput, bottomCoverCompound);
        cwSave.click("Save Specs");
    }

    public void addPosition(String segment, boolean top, String tons, String durameter){
        cwSpecsLoader.waitForNotVisible(10000);
        cwAddNew.click("Edit");
        cwPositionSegment.sendKeys(segment, "Segment");
        cwPositionTonsConveyed.sendKeys(tons, "Tons Conveyed");
        cwPositionDurometer.sendKeys(durameter, "Durameter");
        if(top)
            cwPositionTopRadio.click("Top Radio");
        else cwPositionBottomRadio.check("Bottom Radio");
        cwInstalledDate.click("Date Picker");
        cwTodayDate.click("Current Date");
        cwPositionSave.click("Save Position");
        cwPositionSave.waitForNotVisible(7000);
        SyncUtil.waitFor(3000);
    }

    public void editPosition(String segment, String editSegment){
        waitForElementToDisplay(cwCheckbox);
        searchPosition(segment);
        cwCheckbox.check("Position Checkbox");
        cwActions.click("Actions");
        waitForElementVisible(cwEdit, 10000,500);
        cwEdit.click("Edit");
        cwPositionSegment.type(editSegment);
        cwPositionSave.click("Save");
        cwPositionSave.waitForNotVisible(7000);
        SyncUtil.waitFor(5000);
    }

    public void verifyPosition(String segment, String durameter){
        searchPosition(segment);
        Validator.assertTrue(cwTableSegment.getText().contains(segment),"Segment showing incorrect","Segment is updated correctly");
        System.out.println("Logger: ="+cwTableDurometer.getText().trim());
        System.out.println("Logger: ="+durameter);
        Validator.assertTrue(cwTableDurometer.getText().trim().equalsIgnoreCase(durameter),"Durometer showing incorrect","Durometer is updated correctly");
    }

    public boolean searchPosition(String segmentName){
        cwSearchInput.type(segmentName, "Position Search");
        waitForElementToDisplay(cwCheckbox);
        return cwCheckbox.isVisible("Position Found");
    }

    public void deletePosition(String segmentName) {
        searchPosition(segmentName);
        cwCheckbox.check("Position Checkbox");
        cwActions.click("Actions");
        waitForElementVisible(cwDelete, 10000,500);
        cwDelete.click("Delete");
        yesConfirmation.click("Confirm");
    }

    public void goToPositionDetailScreen(String conveyorName) {
        searchPosition(conveyorName);
        waitForElementToDisplay(cwViewIcon);
        cwViewIcon.click("Position Detail");
        crCoverWearCard.isEnable("Cover Wear Data");
    }

    public void verifyDeletePosition(String segmentName) {
        cwSearchInput.type(segmentName, "Position Search");
        Validator.assertTrue(noList.isVisible(),"Delete position was still found in cover wear list screen","Position deleted successfully");
    }

    public boolean searchCoverWear(String conveyorName){
        goToCoverWearScreenAndWait();
        cwSearchInput.type(conveyorName, "Cover Wear Search");
        waitForElementToDisplay(cwCheckbox);
        return cwCheckbox.isVisible("Cover Wear Found");
    }

    public void deleteCoverWear(String conveyorName) {
        searchCoverWear(conveyorName);
        cwCheckbox.check("Cover Wear Checkbox");
        cwActions.click("Actions");
        waitForElementVisible(cwDelete, 10000,500);
        cwDelete.click("Delete");
        yesConfirmation.click("Confirm");
    }

    public void goToCoverWearDetailScreen(String conveyorName) {
        searchCoverWear(conveyorName);
        waitForElementToDisplay(cwViewIcon);
        cwViewIcon.click("Cover Wear Detail");
        coverWearTitle.isEnable("Cover Wear Data");
    }

    public void verifyCoverWearDelete(String conveyorName) {
        goToCoverWearScreenAndWait();
        cwSearchInput.type(conveyorName, "Cover Wear Search");
        Validator.assertTrue(noList.isVisible(),"Delete Cover Wear was still found in cover wear list screen","Cover Wear deleted successfully");
    }
}
