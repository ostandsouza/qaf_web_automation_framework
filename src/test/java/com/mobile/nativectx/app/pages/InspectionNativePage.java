package com.mobile.nativectx.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.nativectx.app.component.CustomMobileElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class InspectionNativePage extends NativeBasePage {

    private static InspectionNativePage obj;

    public static InspectionNativePage getInstance(){
        if(obj==null)
            obj = new InspectionNativePage();
        return obj;
    }

    @FindBy(locator = "inspection.addressPermision.okButton")
    protected CustomMobileElement inspAddressPermissionOkBtn;

    @FindBy(locator = "inspection.inspNext.btn")
    protected CustomMobileElement inspNextBtn;
    @FindBy(locator = "inspection.inspPrev.btn")
    protected CustomMobileElement inspPrevBtn;
    @FindBy(locator = "inspection.calender.selectDate")
    protected CustomMobileElement inspCalenderPopUp;
    @FindBy(locator = "inspection.calender.okButton")
    protected CustomMobileElement inspCalenderOkBtn;
    @FindBy(locator = "inspection.calender.cancelButton")
    protected CustomMobileElement inspCalenderCancelBtn;
    @FindBy(locator = "inspection.inspLocation.map")
    protected CustomMobileElement inspLocationMap;
    @FindBy(locator = "inspection.signOff.summaryField")
    protected CustomMobileElement summaryField;
    @FindBy(locator = "inspection.saveAsDraft.popUp")
    protected CustomMobileElement saveAsDraftPopUp;



    public void validateInspectionLocationPermissionPopUp() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Validator.assertTrue(inspAddressPermissionOkBtn.isDisplayed(),"Permission Pop up is not Visible","Permission Pop up is Visible");
        inspAddressPermissionOkBtn.click();
        switchContext("FLUTTER");
    }
    public void validateInspLocationMap() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        SyncUtil.waitFor(10000);
        System.out.println(inspLocationMap.isDisplayed());
        Validator.assertTrue(inspLocationMap.isDisplayed(),"Map Location is not Visible","Map Location is Visible");
        switchContext("FLUTTER");
    }

    public void validateInspectionCalenderPopUp() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Validator.assertTrue(inspCalenderPopUp.isDisplayed(),"Calender Pop up is not Visible","Calender Pop up is Visible");
        Validator.assertTrue(inspCalenderOkBtn.isDisplayed(),"Calender Pop up ok button is not Visible","Calender Pop up ok button is Visible");
        Validator.assertTrue(inspCalenderCancelBtn.isDisplayed(),"Calender Pop up cancel button is not Visible","Calender Pop up cancel button is Visible");
        inspCalenderOkBtn.click();
        switchContext("FLUTTER");
    }

    public void clickInspectionCustomDistNextBtn() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        SyncUtil.waitFor(5000);
        waitUntilElementIsVisible(inspNextBtn);
        Validator.assertTrue(inspNextBtn.isVisible(),"Custom Distributor Logo Next Button is not Visible","Custom Distributor Logo Next Button is Visible");
        inspNextBtn.click();
        switchContext("FLUTTER");
    }
    public void clickInspectionInfoBeltNextBtn() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Validator.assertTrue(inspNextBtn.isDisplayed(),"Inspection Info Next Button is not Visible","Inspection Info Next Button is Visible");
        Validator.assertTrue(inspPrevBtn.isDisplayed(),"Inspection Info Previous Button is not Visible","Inspection Info Previous Button is Visible");
        inspNextBtn.click();
        switchContext("FLUTTER");
    }

    public void verifyInspectionSummaryField(String summary) {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Validator.assertTrue(summaryField.isVisible(),"Summary Field is not visible","Summary Field is visible");
//        summaryField.sendKeys(summary);
        switchContext("FLUTTER");
    }
    public void verifySaveAsDraftPopUp() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Validator.assertTrue(saveAsDraftPopUp.isVisible(),"Save as Draft Pop Up is not visible","Save as Draft Pop Up is visible");
        switchContext("FLUTTER");
    }

}