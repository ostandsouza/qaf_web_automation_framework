package com.mobile.flutter.app.pages;

import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import org.testng.Assert;

public class CoverWearPage extends FlutterBasePage {

    private static CoverWearPage obj;

    public static CoverWearPage getInstance(){
        if(obj==null)
            obj = new CoverWearPage();
        return obj;
    }

    @FindBy(locator = "coverWear.coverWear.txt")
    public CustomFlutterElement coverWear;

    @FindBy(locator = "coverWear.search.field")
    public CustomFlutterElement searchField;

    @FindBy(locator = "coverWear.beltWidth.field")
    public CustomFlutterElement beltWidth;

    @FindBy(locator = "coverWear.beltLength.field")
    public CustomFlutterElement beltLength;

    @FindBy(locator = "coverWear.search.filter")
    public CustomFlutterElement search;

    @FindBy(locator = "coverWear.search.results")
    public CustomFlutterElement result;

    @FindBy(locator = "coverWear.topCoverThickness.field")
    public CustomFlutterElement topCoverThickness;

    @FindBy(locator = "coverWear.bottomCoverThickness.field")
    public CustomFlutterElement bottomCoverThickness;

    @FindBy(locator = "coverWear.durometer.field")
    public CustomFlutterElement durometer;

    @FindBy(locator = "coverWear.topCoverCompound.field")
    public CustomFlutterElement topCoverCompound;

    @FindBy(locator = "coverWear.bottomCoverCompound.field")
    public CustomFlutterElement bottomCoverCompound;

    @FindBy(locator = "coverWear.datePicker.field")
    public CustomFlutterElement dateOfInstallation;

    @FindBy(locator = "coverWear.success.msg")
    public CustomFlutterElement successMsgSpecs;

    @FindBy(locator = "dashboard.save.btn")
    public CustomFlutterElement saveBtn;

    public void goToCoverWearViaConveyor(String conveyor) {
        ConveyorPage.getInstance().conveyorDetailsNav(conveyor);
        DashboardNativePage.getInstance().goToCoverWear();
    }

    public boolean fillCoverWearSpecs(){
        beltWidth.sendKeys("8");
        System.out.println(beltLength.getElementProperties());
        beltLength.sendKeys("5");
        topCoverThickness.scrollIntoView("Top cover");
        topCoverThickness.click();
        search.sendKeys("1");
        DashboardNativePage.getInstance().selectFirstSearch();
        bottomCoverThickness.scrollIntoView("Bottom cover");
        bottomCoverThickness.click();
        search.sendKeys("3");
        DashboardNativePage.getInstance().selectFirstSearch();
        durometer.scrollIntoView("Durometer");
        durometer.sendKeys("50");
        topCoverCompound.scrollIntoView("Top compound");
        topCoverCompound.click();
        search.sendKeys("ALUMINA HOT");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();
        bottomCoverCompound.scrollIntoView("Bottom compound");
        bottomCoverCompound.click();
        search.sendKeys("ALUMINA HOT");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();
        dateOfInstallation.click();
        DashboardNativePage.getInstance().selectCalenderDate();
        saveBtn.click();
        return successMsgSpecs.isVisible("Specs Message");
    }

}
