package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConveyorInspectPage extends BasePage{

    @FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
    public CustomElement home;

    @FindBy(locator = "xpath=(//li//span[text()='Conveyor Inspect'])[1]")
    public CustomElement conveyorInspectList;

    @FindBy(locator = "xpath=//div/span[text()='Inspections']")
    public CustomElement conveyorInspectHeader;
    @FindBy(locator = "xpath=(//app-card//div[text()='Conveyor Inspect'])[2]")
    public CustomElement conveyorInspect;

    @FindBy(locator = "xpath=(//app-card//div[text()='Conveyor Inspect'])[1]")
    public CustomElement conveyorInspect1;

    @FindBy(locator="xpath=//span[contains(@class,'p-carousel-prev-icon pi pi-chevron-right')]")
    public CustomElement btRightCarousel;

    @FindBy(locator="xpath=//span[contains(@class,'p-carousel-prev-icon pi pi-chevron-left')]")
    public CustomElement btLeftCarousel;

    @FindBy(locator="xpath=//span[text()='Conveyor Status']/..")
    public CustomElement btConveyorStatus;

    @FindBy(locator="xpath=//span[text()='Trend Analysis']/..")
    public CustomElement btTrendAnalysis;

    @FindBy(locator="xpath=//span[text()='Maintenance Action']/..")
    public CustomElement btMaintenanceActon;

    @FindBy(locator="xpath=//div[contains(text(),'Data is based on Last Inspection From')]")
    public CustomElement lastInspectionDate;

    @FindBy(locator="xpath=//span[text()='Upload Files']")
    public CustomElement btUploadFiles;

    @FindBy(locator="xpath=//span[text()='Edit']")
    public CustomElement btEdit;

    @FindBy(locator="xpath=//span[contains(@class,'pi-cog')]")
    public CustomElement btSettings;

    @FindBy(locator="xpath=//span[text()='Set Temperature Range']")
    public CustomElement tempRange;

    @FindBy(locator="xpath=//span[text()='Assign Object Detection Model']")
    public CustomElement assignModel;

    @FindBy(locator="xpath=//label[text()='Company site']/following-sibling::div[1]//input")
    public CustomElement companySiteDropdown;

    @FindBy(locator="xpath=//label[text()='Conveyor name']/following-sibling::div[1]//input")
    public CustomElement conveyorNameDropdown;

    @FindBy(locator="xpath=//p-radiobutton[@label='Video']/div[1]")
    public CustomElement videoRadioBtn;

    @FindBy(locator="xpath=//p-radiobutton[@label='Image']/div[1]")
    public CustomElement imgRadioBtn;

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

    @FindBy(locator="xpath=//span[text()='Save Changes']")
    public CustomElement saveTempChanges;

    @FindBy(locator="xpath=//span[contains(@class,'pi-spinner')]")
    public CustomElement spinnerModel;

    @FindBy(locator="xpath=//span[contains(@class,'pi-trash')]")
    public List<CustomElement> deleteImg;

    @FindBy(locator="xpath=//span[contains(@class,'pi-trash')]/../..")
    public List<CustomElement> uploadedFileName;

    @FindBy(locator="xpath=//button[contains(@class,'p-link')]/timesicon")
    public CustomElement modelClose;

    @FindBy(locator="xpath=//label[text()='Select company']/following-sibling::div//input")
    public CustomElement companyDropdown;

    @FindBy(locator="xpath=//label[text()='Select Site']/following-sibling::div//input")
    public CustomElement siteDropdown;

    @FindBy(locator="xpath=//label[text()='Select Conveyor']/following-sibling::div//input")
    public CustomElement conveyorDropdown;

    @FindBy(locator="xpath=//label[text()='Model Name']/parent::div//input")
    public CustomElement modelDropdown;

    @FindBy(locator="xpath=//div[text()='Critical']/../following-sibling::ngx-slider")
    public CustomElement criticalSlider;

    @FindBy(locator="xpath=//div[text()='Critical']/../following-sibling::ngx-slider/span[contains(@class,'ngx-slider-pointer-min')]")
    public CustomElement criticalMinPointer;

    @FindBy(locator="xpath=//div[text()='Critical']/../following-sibling::ngx-slider/span[contains(@class,'ngx-slider-pointer-max')]")
    public CustomElement criticalMaxPointer;

    @FindBy(locator="xpath=//div[text()='Poor']/../following-sibling::ngx-slider")
    public CustomElement poorSlider;

    @FindBy(locator="xpath=//div[text()='Poor']/../following-sibling::ngx-slider/span[contains(@class,'ngx-slider-pointer-min')]")
    public CustomElement poorMinPointer;

    @FindBy(locator="xpath=//div[text()='Poor']/../following-sibling::ngx-slider/span[contains(@class,'ngx-slider-pointer-max')]")
    public CustomElement poorMaxPointer;

    @FindBy(locator="xpath=//div[text()='Fault']/../following-sibling::ngx-slider")
    public CustomElement faultSlider;

    @FindBy(locator="xpath=//div[text()='Fault']/../following-sibling::ngx-slider/span[contains(@class,'ngx-slider-pointer-min')]")
    public CustomElement faultMinPointer;

    @FindBy(locator="xpath=//div[text()='Fault']/../following-sibling::ngx-slider/span[contains(@class,'ngx-slider-pointer-max')]")
    public CustomElement faultMaxPointer;

    @FindBy(locator="xpath=//div[text()='Good']/../following-sibling::ngx-slider")
    public CustomElement goodSlider;

    @FindBy(locator="xpath=//div[text()='Good']/../following-sibling::ngx-slider/span[contains(@class,'ngx-slider-pointer-min')]")
    public CustomElement goodMinPointer;

    @FindBy(locator="xpath=//div[text()='Good']/../following-sibling::ngx-slider/span[contains(@class,'ngx-slider-pointer-max')]")
    public CustomElement goodMaxPointer;

    @FindBy(locator="xpath=//div[text()='Success']")
    public CustomElement successToast;
    @FindBy(locator="xpath=//span[text()='Set Default']")
    public CustomElement setDefaultBtn;

    @FindBy(locator="xpath=//app-ci-finding-gauge//canvas")
    public List<CustomElement> gaugeMetrics;

    @FindBy(locator="xpath=//app-ci-finding-trend//canvas")
    public CustomElement trendMetrics;

    @FindBy(locator="xpath=//div[@class='action-list']/p-table")
    public CustomElement actionList;

    public void goToConveyorInspect(){
        waitForElementToBeClickable(conveyorInspect);
        if(conveyorInspect.isEnable())
            conveyorInspect.jsClick("Conveyor Inspect");
        else if(conveyorInspect1.isEnable())
            conveyorInspect1.jsClick("Conveyor Inspect");
        else {
            btRightCarousel.jsClick("Carousel right");
            conveyorInspect.jsClick("Conveyor Inspect");
        }
        btConveyorStatus.isVisible("Conveyor inspect Header");
        waitForElementToInvisible(btConveyorInspectStatus,6000);
    }

    public void goToConveyorInspectList(){
        if(!conveyorInspectList.isVisible())
            home.click("Home");
        conveyorInspectList.jsClick("Conveyor Inspect List");
        conveyorInspectHeader.isVisible("Conveyor Inspect Header");
    }

    public boolean verifyConveyorListHeaders(){
        return conveyorInspectHeader.isVisible("Conveyor Inspect Header");
    }

    public boolean goToUploadFiles(){
        btUploadFiles.click("Upload Files");
        return uploadBtnStatus();
    }

    public boolean uploadBtnStatus(){
        return btUpload.isEnabled();
    }

    public boolean imgDefaultSelection(){
        return imgRadioBtn.getAttribute("class").contains("p-radiobutton-checked");
    }

    public boolean imgSelection(){
        imgRadioBtn.click();
        return imgRadioBtn.getAttribute("class").contains("p-radiobutton-checked");
    }

    public boolean videoSelection(){
        videoRadioBtn.click();
        return videoRadioBtn.getAttribute("class").contains("p-radiobutton-checked");
    }

    public boolean companySiteContents(String name){
        return companySiteDropdown.getAttribute("value").equals(name) && !companySiteDropdown.isEnabled();
    }

    public boolean conveyorContents(String name){
        return conveyorNameDropdown.getAttribute("value").equals(name) && !conveyorNameDropdown.isEnabled();
    }

    public void flightDate(){
        ciStartDateFlight.click("Flight Date");
        ciTodayDate.click("Current Date");
    }

    public void flightTime(){
        ciTimeFlight.click("Time Flight");
        ciTimeFlightDecrease.click("Change Time");
    }

    public void sideDropdown(String side){
        dropdownSelect(ciSide, ListItem, side);
    }

    public void colorMapDropdown(String colorMap){
        dropdownSelect(ciColourMap, ListColorMap, colorMap);
    }

    public void imageUpload(String fileName){
        String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "test_files").getAbsolutePath();
        fileUpload.sendKeys(file_path, "img_upload");
    }

    public boolean deleteImg(String fileName){
        deleteImg.get(0).click("delete file");
        return deleteImg.isEmpty();
    }

    public boolean editFunctionalityConveyorLevel(){
        btEdit.click();
        return driver.getCurrentUrl().contains("conveyor/update");
    }

    public boolean editFunctionalitySiteLevel(){
        btEdit.click();
        return driver.getCurrentUrl().contains("companies/add");
    }

    public boolean invokeTemperatureRange(){
        btSettings.jsClick("Settings");
        tempRange.jsClick("Temperature Range");
        return saveTempChanges.isVisible("Save Changes");
    }

    public void setDefaultTemp(){
        setDefaultBtn.click("Set Default Temperature");
    }

    public void saveTempRange(){
        saveTempChanges.click("Save Temperature");
        SyncUtil.waitFor(1000);
        successToast.isVisible("success toast");
        modelClose.click("Close");
    }

    public void closeDialog(){
        modelClose.click("Close");
    }

    public void changeCriticalTemp(int min, int max){
        Dimension sliderSize = criticalSlider.getSize();
        int sliderWidth = sliderSize.getWidth();
        int xCoord = criticalSlider.getLocation().getX();
        int xMax = sliderWidth*(max/100);
        Actions builder = new Actions(driver);
        builder.moveToElement(criticalMaxPointer)
                .click()
                .dragAndDropBy
                        (criticalMaxPointer,xCoord + xMax, 0)
                .build()
                .perform();
        int xMin = sliderWidth*(min/100);
        builder.moveToElement(criticalMinPointer)
                .click()
                .dragAndDropBy
                        (criticalMinPointer,xCoord + xMin, 0)
                .build()
                .perform();
    }

    public void changePoorTemp(int min, int max){
        Dimension sliderSize = poorSlider.getSize();
        int sliderWidth = sliderSize.getWidth();
        int xCoord = poorSlider.getLocation().getX();
        int xMax = sliderWidth*(max/100);
        Actions builder = new Actions(driver);
        builder.moveToElement(poorMaxPointer)
                .click()
                .dragAndDropBy
                        (poorMaxPointer,xCoord + xMax, 0)
                .build()
                .perform();
        int xMin = sliderWidth*(min/100);
        builder.moveToElement(poorMinPointer)
                .click()
                .dragAndDropBy
                        (poorMinPointer,xCoord + xMin, 0)
                .build()
                .perform();
    }

    public void invokeObjectDetectionModel(){
        btSettings.jsClick("Settings");
        assignModel.jsClick("Assign Model");
        saveChanges.isVisible("save changes");
    }

    public boolean companyDropdownStatus(){
        return companyDropdown.isEnabled();
    }

    public boolean siteDropdownStatus(){
        return siteDropdown.isEnabled();
    }

    public boolean conveyorDropdownStatus(){
        return conveyorDropdown.isEnabled();
    }

    public boolean modelDropdownStatus(){
        return modelDropdown.isEnabled();
    }

    public boolean defaultTabSelection(){
        return btConveyorStatus.getAttribute("aria-selected").equalsIgnoreCase("true");
    }

    public boolean lastInspectionDate(String date){
        return lastInspectionDate.getText("Inspection Date").contains(date);
    }

    public boolean gaugeMetrics(){
        return gaugeMetrics.size() == 4;
    }

    public boolean goToTrendAnalysis(){
        btTrendAnalysis.click("Trend Analysis");
        SyncUtil.waitFor(5000);
        return trendMetrics.isVisible("Trend graph");
    }

    public boolean mouseOverGraphAnalysis(){
        return trendMetrics.isVisible("Trend graph");
    }

    public boolean goToMaintenanceAction(){
        btMaintenanceActon.click("Maintenance Action");
        SyncUtil.waitFor(5000);
        return actionList.isVisible("Action List");
    }

    public boolean maintenanceTable(){
        return actionList.isVisible("Action List");
    }

    public void modelSelection(String model){
        dropdownSelect(modelName, ListItem, model);
        saveChanges.jsClick("Save");
        waitForElementToInvisible(spinnerModel,10000);
        modelClose.click("Close");
    }

    public void assignModel(String model){
        btSettings.jsClick("Settings");
        assignModel.jsClick("Assign Model");
        dropdownSelect(modelName, ListItem, model);
        saveChanges.jsClick("Save");
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
        SyncUtil.waitFor(1000);
        waitForElementToInvisible(uploadingProgress,20000);
        waitForElementToInvisible(btSpinner,10000);
        SyncUtil.waitFor(2000);
        Validator.assertTrue(btUpload.isNotVisible(20000),"Img upload failed","Image upload was successful");
    }


}
