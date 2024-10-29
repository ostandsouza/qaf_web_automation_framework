package com.mobile.nativectx.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.nativectx.app.component.CustomMobileElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class CoverWearNativePage extends NativeBasePage {

    private static CoverWearNativePage obj;

    public static CoverWearNativePage getInstance(){
        if(obj==null)
            obj = new CoverWearNativePage();
        return obj;
    }
    @FindBy(locator = "coverWear.installation.editBtn")
    protected CustomMobileElement installationEditBtn;

    @FindBy(locator = "coverWear.measurement.deleteBtn")
    protected CustomMobileElement deleteMeasurementBtn;


    @FindBy(locator = "coverWear.addPosition.specErrorMsg")
    protected CustomMobileElement posSpecErrorMsg;
    @FindBy(locator = "coverWear.addPosition.existingPositionErrorMsg")
    protected CustomMobileElement exisitingPosErrorMsg;


    public boolean verifyEditButtonIsVisible()
    {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean flag=installationEditBtn.isPresent();
        switchContext("FLUTTER");
        return flag;
    }
    public void editBtnClick()
    {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        installationEditBtn.click();
        switchContext("FLUTTER");
    }
    public boolean verifyDeleteBtnIsVisible()
    {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean flag=deleteMeasurementBtn.isPresent();
        switchContext("FLUTTER");
        return flag;
    }
    public void verifyAddNewPositionSpecErrorMsg() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Validator.assertTrue(posSpecErrorMsg.isPresent(),"Add New Position Button is not visbile","Add New Position Button is visbile");
        switchContext("FLUTTER");
    }
    public void verifyExistingPositionErrorMsg() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Validator.assertTrue(exisitingPosErrorMsg.isPresent(),"Existing Position Error is not visbile","Existing Position Erroris visbile");
        switchContext("FLUTTER");
    }

    public void deleteBtnClick()
    {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        deleteMeasurementBtn.click();
        switchContext("FLUTTER");

    }


}