package com.mobile.nativectx.app.pages;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.mobile.flutter.app.pages.CorporatePage;
import com.mobile.nativectx.app.component.CustomMobileElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class CorporateNativePage extends NativeBasePage {

    private static CorporateNativePage obj;

    public static CorporateNativePage getInstance(){
        if(obj==null)
            obj = new CorporateNativePage();
        return obj;
    }

    @FindBy(locator = "dashboard.search.icon")
    protected CustomMobileElement corporateListSiteCount;

    @FindBy(locator ="//android.view.View[contains(@content-desc,'Customer Site') or contains(@content-desc,'Distributor Shop') ]")
    public List<WebElement> corporateListCorpData;

    @FindBy(locator = "company.filter.distributor")
    protected CustomMobileElement corporateFilterDistributor;

    @FindBy(locator = "company.filter.customer")
    protected CustomMobileElement corporateFilterCustomer;

    @FindBy(locator = "company.filter.market")
    protected CustomMobileElement corporateFilterMarket;

    @FindBy(locator = "company.filter.corporateType")
    protected CustomMobileElement corporateFilterCorpType;
    @FindBy(locator = "company.filter.corporatecheckbox")
    protected CustomMobileElement corporateFilterCheckbox;

    @FindBy(locator = "company.filter.icon")
    protected CustomMobileElement corporateFilterIcon;

    @FindBy(locator = "company.filter.close")
    protected CustomMobileElement corporateFilterClose;
    @FindBy(locator = "company.filter.cancel")
    protected CustomMobileElement corporateFilterCancel;

    @FindBy(locator = "company.filter.save")
    protected CustomMobileElement corporateFilterSave;

    @FindBy(locator = "company.filter.ascending")
    protected CustomMobileElement corporateFilterAscending;

    @FindBy(locator = "company.filter.descending")
    protected CustomMobileElement corporateFilterDescending;

    @FindBy(locator = "navSite.manager.dropdown")
    public CustomMobileElement territoryManagerDropdown;
    @FindBy(locator = "navSite.company.name")
    public CustomMobileElement corporateDetailsName;
    @FindBy(locator = "navSite.address.field")
    public CustomMobileElement addressBar;
    @FindBy(locator = "navSite.company.type")
    public CustomMobileElement companyType;

    public void verifyDataInCorpListScreen() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(corporateListCorpData.size()+"corporateListCorpData.size()");
        Validator.assertTrue(corporateListCorpData.size()==0,"Corporate List data is Invalid","Corporate List data is valid");
        switchContext("FLUTTER");
    }
    public void extractCountInCorpList() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getBundle().setProperty("CorpListSiteCount",corporateListSiteCount.getText());
        switchContext("FLUTTER");
    }

    public void verifyFilterFieldsInCorpList() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Validator.assertTrue(corporateFilterDistributor.isDisplayed(),"Distributor Corporate is not displayed","Distributor Corporate is displayed");
        Validator.assertTrue(corporateFilterCustomer.isDisplayed(),"Customer Corporate is not displayed","Customer Corporate is displayed");
        Validator.assertTrue(corporateFilterMarket.isDisplayed(),"Market is not displayed","Market is displayed");
        Validator.assertTrue(corporateFilterCorpType.isDisplayed(),"Corporate Name is not displayed","Corporate Name is displayed");
        corporateFilterCorpType.click();
        Validator.assertTrue(corporateFilterCheckbox.isDisplayed(),"Checkbox is not displayed","Checkbox is displayed");
        Validator.assertTrue(corporateFilterIcon.isDisplayed(),"Filter Disable button is not displayed","Filter disable button is displayed");
        Validator.assertTrue(corporateFilterClose.isDisplayed(),"Close button is not displayed","Close button is displayed");
        Validator.assertTrue(corporateFilterCancel.isDisplayed(),"Cancel button is not displayed","Cancel button is displayed");
        Validator.assertTrue(corporateFilterSave.isDisplayed(),"Save button is not displayed","Save button is displayed");
        switchContext("FLUTTER");
    }
    public void verifyClearFilterIsEnabled() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Validator.assertTrue(corporateFilterIcon.getAttribute("enabled").equalsIgnoreCase("true"),"Filter is not applied","Filter is applied");
        switchContext("FLUTTER");
    }
    public void applyClearFilter() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        corporateFilterIcon.click();
        switchContext("FLUTTER");
    }

    public void verifyClearFilterIsDisabled() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Validator.assertTrue(corporateFilterIcon.getAttribute("enabled").equalsIgnoreCase("false"),"Filter is not applied","Filter is applied");
        switchContext("FLUTTER");
    }
    public void verifyClearFilter() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Validator.assertTrue(corporateFilterAscending.getAttribute("checked").equalsIgnoreCase("false"),"Filter is not applied","Filter is applied");
        Validator.assertTrue(corporateFilterDescending.getAttribute("checked").equalsIgnoreCase("false"),"Filter is not applied","Filter is applied");
        Validator.assertTrue(corporateFilterDistributor.getAttribute("checked").equalsIgnoreCase("false"),"Filter is not applied","Filter is applied");
        Validator.assertTrue(corporateFilterCustomer.getAttribute("checked").equalsIgnoreCase("false"),"Filter is not applied","Filter is applied");
        switchContext("FLUTTER");
    }


    public void verifySiteDetailsDisabled() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(territoryManagerDropdown.getAttribute("enabled")+corporateDetailsName.getAttribute("enabled")+companyType.getAttribute("enabled")+addressBar.getAttribute("enabled"));
        Validator.assertTrue(territoryManagerDropdown.getAttribute("enabled").equalsIgnoreCase("false"),"Territory Manager Field is not disabled","Territory Manager Field is disabled");
        Validator.assertTrue(corporateDetailsName.getAttribute("enabled").equalsIgnoreCase("false"),"Company Name Field is not disabled","Company Name Field is disabled");
        Validator.assertTrue(companyType.getAttribute("enabled").equalsIgnoreCase("false"),"Company Type Field is not disabled","Company Type Field is disabled");
        Validator.assertTrue(addressBar.getAttribute("enabled").equalsIgnoreCase("false"),"Address Field is not disabled","Address Field is not disabled");
        switchContext("FLUTTER");
    }

    public void verifySiteDetailsEnabled() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Validator.assertTrue(territoryManagerDropdown.getAttribute("enabled").equalsIgnoreCase("true"),"Territory Manager Field is not disabled","Territory Manager Field is disabled");
        Validator.assertTrue(corporateDetailsName.getAttribute("enabled").equalsIgnoreCase("true"),"Company Name Field is not disabled","Company Name Field is disabled");
        Validator.assertTrue(addressBar.getAttribute("enabled").equalsIgnoreCase("true"),"Address Field is not disabled","Address Field is not disabled");
        switchContext("FLUTTER");
    }




}