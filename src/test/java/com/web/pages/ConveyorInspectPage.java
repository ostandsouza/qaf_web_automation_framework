package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;

import java.util.concurrent.TimeUnit;

public class ConveyorInspectPage extends BasePage{

    @FindBy(locator = "xpath=(//app-card//div[text()='Conveyor Inspect'])[2]")
    public CustomElement conveyorInspect;

    @FindBy(locator="xpath=//span[contains(@class,'p-carousel-prev-icon pi pi-chevron-right')]")
    public CustomElement btRightCarousel;

    @FindBy(locator="xpath=//span[contains(@class,'p-carousel-prev-icon pi pi-chevron-left')]")
    public CustomElement btLeftCarousel;

    @FindBy(locator="xpath=//span[text()='Conveyor Status']")
    public CustomElement btConveyorStatus;

    @FindBy(locator="xpath=//span[text()='Trend Analysis']")
    public CustomElement btTrendAnalysis;

    @FindBy(locator="xpath=//span[text()='Maintenance Action']")
    public CustomElement btMaintenanceActon;

    @FindBy(locator="xpath=//span[text()='Upload Files']")
    public CustomElement btUploadFiles;

    @FindBy(locator="xpath=//span[text()='Edit']")
    public CustomElement btEdit;

    @FindBy(locator="xpath=//span[contains(@class,'pi-cog')]")
    public CustomElement btSettings;

    @FindBy(locator="xpath=//span[text()='Assign Object Detection Model']")
    public CustomElement assignModel;

    @FindBy(locator="xpath=//td[contains(@class,'p-datepicker-today')]")
    public CustomElement ciTodayDate;

    @FindBy(locator="xpath=//label[text()='Select date of flight']/parent::div//input")
    public CustomElement ciStartDateFlight;

    @FindBy(locator="xpath=//label[text()='Time of flight (hh,mm)']/parent::div//input")
    public CustomElement ciTimeFlight;

    @FindBy(locator="xpath=//div[contains(@class,'p-minute-picker')]/button[2]")
    public CustomElement ciTimeFlightDecrease;

    @FindBy(locator="xpath=//label[text()='Side']/parent::div//div[@role='button']")
    public CustomElement ciSide;

    public String ListItem = "//ul[@role='listbox']//li//span";

    public String ListColorMap = "//ul[@role='listbox']//li/div/div[2]";

    @FindBy(locator="xpath=//label[text()='Colormap']/parent::div//div[@role='button']")
    public CustomElement ciColourMap;

    @FindBy(locator="xpath=//input[@type='file']")
    public CustomElement fileUpload;

    @FindBy(locator="xpath=//span[text()='Cancel']")
    public CustomElement btCancel;

    @FindBy(locator="xpath=//span[text()='Upload']/..")
    public CustomElement btUpload;

    @FindBy(locator="xpath=//div[@class='p-progress-spinner']")
    public CustomElement btSpinner;

    @FindBy(locator="xpath=//div[text()='Data is based on Last Inspection From ']")
    public CustomElement btConveyorInspectStatus;

    @FindBy(locator="xpath=//h5[text()='Upload in progress']")
    public CustomElement uploadingProgress;

    @FindBy(locator="xpath=//label[text()='Model Name']/parent::div//div[@role='button']")
    public CustomElement modelName;

    @FindBy(locator="xpath=//span[text()='Save changes']")
    public CustomElement saveChanges;

    @FindBy(locator="xpath=//span[contains(@class,'pi-spinner')]")
    public CustomElement spinnerModel;

    @FindBy(locator="xpath=//span[contains(@class,'p-dialog-header-close-icon')]")
    public CustomElement modelClose;

    public void goToConveyorInspect(){
        if(conveyorInspect.isEnable())
            conveyorInspect.jsClick("Conveyor Inspect");
        else {
            btRightCarousel.jsClick("Carousel right");
            conveyorInspect.jsClick("Conveyor Inspect");
        }
        btConveyorStatus.isVisible("Conveyor inspect Header");
        waitForElementToInvisible(btConveyorInspectStatus,6000);
    }

    public void assignModel(String model){
        btSettings.click("Settings");
        assignModel.click("Assign Model");
        dropdownSelect(modelName, ListItem, model);
        saveChanges.click("Save");
        waitForElementToInvisible(spinnerModel,10000);
        modelClose.click("Close");
    }

    public void uploadDroneImgFiles(String side, String colorMap, String ir_Name, String rgb_Name){
        btUploadFiles.click("Upload Files");
        ciStartDateFlight.click("Flight Date");
        ciTodayDate.click("Current Date");
        ciTimeFlight.click("Time Flight");
        ciTimeFlightDecrease.click("Change Time");
        dropdownSelect(ciSide, ListItem, side);
        dropdownSelect(ciColourMap, ListColorMap, colorMap);
        String file_path = ClasspathResourceHelper.getPropertyFile(ir_Name, "test_files").getAbsolutePath();
        fileUpload.sendKeys(file_path, "img_upload IR");
        file_path = ClasspathResourceHelper.getPropertyFile(rgb_Name, "test_files").getAbsolutePath();
        fileUpload.sendKeys(file_path, "img_upload RGB");
        waitForElementToBeClickable(btUpload);
        btUpload.jsClick("Upload Files");
        waitForElementToInvisible(btSpinner,40000);
        waitForElementToInvisible(uploadingProgress,20000);
        waitForElementToDisplay(btSpinner);
        Validator.assertTrue(btUpload.isNotVisible(5),"Img upload failed","Image upload was successful");
    }


}
