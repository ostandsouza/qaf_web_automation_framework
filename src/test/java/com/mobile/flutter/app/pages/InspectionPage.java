package com.mobile.flutter.app.pages;

import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;

public class InspectionPage extends FlutterBasePage {

    private static InspectionPage obj;

    public static InspectionPage getInstance(){
        if(obj==null)
            obj = new InspectionPage();
        return obj;
    }

    @FindBy(locator = "inspection.name.field")
    public CustomFlutterElement inspectionNameField;

    @FindBy(locator = "inspection.site.field")
    public CustomFlutterElement siteField;

    @FindBy(locator = "inspection.conveyor.field")
    public CustomFlutterElement conveyorField;

    @FindBy(locator = "inspection.next.btn")
    public CustomFlutterElement nextBtn;

    @FindBy(locator = "inspection.save.btn")
    public CustomFlutterElement saveBtn;

    @FindBy(locator = "inspection.search.dropdown")
    public CustomFlutterElement searchArea;

    public boolean isInspectionPage() {
        return inspectionNameField.isPresent();
    }

    public boolean addInspection(String inspectionName, String conveyorName, String custSiteName) {
        inspectionNameField.sendKeys(inspectionName);
        SyncUtil.waitFor(2000);

        siteField.click("Customer dropdown");
        searchArea.sendKeys(custSiteName, "Customer");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();

        conveyorField.click("Conveyor dropdown");
        searchArea.sendKeys(conveyorName, "Conveyor");
        DashboardNativePage.getInstance().selectFirstSearchTerritorySiteScreen();

        nextBtn.click("next Btn");

        saveBtn.scrollIntoView("Save Btn");
        saveBtn.click();
        SyncUtil.waitFor(5000);
        return !saveBtn.isVisible();
    }
}
