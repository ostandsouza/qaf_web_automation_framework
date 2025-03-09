package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DashboardPage extends BasePage {



    @FindBy(locator = "xpath=//span[contains(text(),'We value your privacy!')]/..")
    public CustomElement popupHeader;

    @FindBy(locator = "xpath=//span[contains(text(),'Reject All')]")
    public CustomElement rejectBtn;

    @FindBy(locator = "xpath=//span[contains(text(),'Accept All')]")
    public CustomElement acceptBtn;


    public void handleCookiePopup()  {
        SyncUtil.waitFor(5000);
        waitForElementToDisplay(popupHeader);
        if(popupHeader.isVisible()){
            acceptBtn.click();
        }
        waitForElementToInvisible(acceptBtn,10000);
    }

}
