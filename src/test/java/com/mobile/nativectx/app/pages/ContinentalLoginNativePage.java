package com.mobile.nativectx.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.component.CustomMobileElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class ContinentalLoginNativePage extends NativeBasePage {

    private static ContinentalLoginNativePage obj;

    public static ContinentalLoginNativePage getInstance(){
        if(obj==null)
            obj = new ContinentalLoginNativePage();
        return obj;
    }

    @FindBy(locator = "continental.privacyPolicy.header")
    public CustomMobileElement privacyPolicyHeader;
    @FindBy(locator = "continental.privacyPolicy.details")
    public CustomMobileElement privacyPolicyDetails;
    @FindBy(locator = "continental.imprint.header")
    public CustomMobileElement imprintHeader;
    @FindBy(locator = "continental.imprint.details")
    public CustomMobileElement imprintDetails;
    @FindBy(locator = "continental.termsOfService.header")
    public CustomMobileElement termsOfServiceHeader;
    @FindBy(locator = "continental.termsOfService.details")
    public CustomMobileElement termsOfServiceDetails;
    @FindBy(locator = "continental.legalNotice.header")
    public CustomMobileElement legalNoticeHeader;


    public void verifyTermsAndConditionDetails()
    {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Validator.assertTrue(termsOfServiceDetails.isDisplayed()&&legalNoticeHeader.isDisplayed() &&imprintHeader.isDisplayed()&&termsOfServiceHeader.isDisplayed(),
                "User cannot view the terms and conditions page details","User can view the terms and conditions page details");


    }

}