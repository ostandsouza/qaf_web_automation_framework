package com.mobile.flutter.app.pages;

import com.common.utils.ClasspathResourceHelper;
import com.common.utils.SyncUtil;
import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.ConveyorInspectNativePage;
import com.mobile.nativectx.app.pages.DashboardNativePage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import groovyjarjarantlr4.v4.codegen.model.Sync;

import java.util.Date;

public class ConveyorInspectPage extends FlutterBasePage {

    private static ConveyorInspectPage obj;

    public static ConveyorInspectPage getInstance(){
        if(obj==null)
            obj = new ConveyorInspectPage();
        return obj;
    }

    @FindBy(locator = "conveyorInspect.card.txt")
    public CustomFlutterElement conveyorInspectCard;

    @FindBy(locator = "conveyorInspect.card.count")
    public CustomFlutterElement conveyorInspectCardCount;

    @FindBy(locator = "conveyorInspect.dashboard.tab")
    public CustomFlutterElement ciDashboardTab;

    @FindBy(locator = "conveyorInspect.inspection.tab")
    public CustomFlutterElement ciInspectionTab;

    @FindBy(locator = "conveyorInspect.dashboard.conveyorStatus")
    public CustomFlutterElement ciConveyorStatus;

    @FindBy(locator = "conveyorInspect.conveyorStatus.lastUpdate")
    public CustomFlutterElement ciLastUpdate;

    @FindBy(locator = "conveyorInspect.conveyorStatus.critical")
    public CustomFlutterElement ciDashboardCritical;

    @FindBy(locator = "conveyorInspect.conveyorStatus.poor")
    public CustomFlutterElement ciDashboardPoor;

    @FindBy(locator = "conveyorInspect.conveyorStatus.fault")
    public CustomFlutterElement ciDashboardFault;

    @FindBy(locator = "conveyorInspect.conveyorStatus.good")
    public CustomFlutterElement ciDashboardGood;

    @FindBy(locator = "conveyorInspect.conveyorStatus.piechart")
    public CustomFlutterElement ciDashboardPieChart;

    @FindBy(locator = "conveyorInspect.conveyorStatus.criticalTemp")
    public CustomFlutterElement ciDashboardCriticalTemp;

    @FindBy(locator = "conveyorInspect.conveyorStatus.poorTemp")
    public CustomFlutterElement ciDashboardPoorTemp;

    @FindBy(locator = "conveyorInspect.conveyorStatus.faultTemp")
    public CustomFlutterElement ciDashboardFaultTemp;

    @FindBy(locator = "conveyorInspect.conveyorStatus.goodTemp")
    public CustomFlutterElement ciDashboardGoodTemp;

    @FindBy(locator = "conveyorInspect.dashboard.trendAnalysis")
    public CustomFlutterElement ciTrendAnalysis;

    @FindBy(locator = "conveyorInspect.trendAnalysis.critical")
    public CustomFlutterElement ciTrendAnalysisCritical;

    @FindBy(locator = "conveyorInspect.trendAnalysis.poor")
    public CustomFlutterElement ciTrendAnalysisPoor;

    @FindBy(locator = "conveyorInspect.trendAnalysis.fault")
    public CustomFlutterElement ciTrendAnalysisFault;

    @FindBy(locator = "conveyorInspect.trendAnalysis.good")
    public CustomFlutterElement ciTrendAnalysisGood;

    @FindBy(locator = "conveyorInspect.trendAnalysis.echart")
    public CustomFlutterElement ciTrendAnalysisChart;

    @FindBy(locator = "conveyorInspect.dashboard.maintenanceAction")
    public CustomFlutterElement ciMaintenanceAction;

    @FindBy(locator = "conveyorInspect.dashboard.upload")
    public CustomFlutterElement ciUploadFiles;

    @FindBy(locator = "conveyorInspect.uploadFile.uploadBtn")
    public CustomFlutterElement ciUploadFileBtn;

    @FindBy(locator = "conveyorInspect.uploadFile.site")
    public CustomFlutterElement ciUploadSite;

    @FindBy(locator = "conveyorInspect.uploadFile.conveyor")
    public CustomFlutterElement ciUploadConveyor;

    @FindBy(locator = "conveyorInspect.uploadFile.date")
    public CustomFlutterElement ciUploadDate;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"Text\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"ContiplusDatePicker\\\"}\"}")
    public CustomFlutterElement ciUploadDateText;

    @FindBy(locator = "conveyorInspect.uploadFile.time")
    public CustomFlutterElement ciUploadTime;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"Text\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"ContiplusTimePicker\\\"}\"}")
    public CustomFlutterElement ciUploadTimeText;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"Text\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"Side\\\"}\"}")
    public CustomFlutterElement ciUploadSide;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"Text\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"colorMap\\\"}\"}")
    public CustomFlutterElement ciUploadColorMap;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"SvgPicture\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"Side\\\"}\"}")
    public CustomFlutterElement ciUploadSideIcon;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"SvgPicture\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"colorMap\\\"}\"}")
    public CustomFlutterElement ciUploadColorMapicon;

    @FindBy(locator = "conveyorInspect.uploadFile.colorHot")
    public CustomFlutterElement ciColorHot;

    @FindBy(locator = "conveyorInspect.uploadFile.upload")
    public CustomFlutterElement ciUploadBtn;

    @FindBy(locator = "conveyorInspect.uploadFile.cancel")
    public CustomFlutterElement ciUploadCancel;

    @FindBy(locator = "conveyorInspect.uploadFile.close")
    public CustomFlutterElement ciUploadClose;

    @FindBy(locator = "conveyorInspect.siteLevel.InspectionTab")
    public CustomFlutterElement ciSiteInspectionTab;

    @FindBy(locator = "conveyorInspect.InspectionTab.header")
    public CustomFlutterElement ciSiteInspectionHeader;

    @FindBy(locator = "conveyorInspect.InspectionTab.kmTab")
    public CustomFlutterElement ciSiteKmTab;

    @FindBy(locator = "conveyorInspect.InspectionTab.100mTab")
    public CustomFlutterElement ciSite100KmTab;

    @FindBy(locator = "conveyorInspect.InspectionTab.10mTab")
    public CustomFlutterElement ciSite10mTab;

    @FindBy(locator = "conveyorInspect.InspectionTab.critical")
    public CustomFlutterElement ciSiteInspectionCritical;

    @FindBy(locator = "conveyorInspect.InspectionTab.poor")
    public CustomFlutterElement ciSiteInspectionPoor;

    @FindBy(locator = "conveyorInspect.InspectionTab.fault")
    public CustomFlutterElement ciSiteInspectionFault;

    @FindBy(locator = "conveyorInspect.InspectionTab.good")
    public CustomFlutterElement ciSiteInspectionGood;

    @FindBy(locator = "conveyorInspect.InspectionTab.map")
    public CustomFlutterElement ciSiteInspectionMap;

    @FindBy(locator = "conveyorInspect.list.firstRow")
    public CustomFlutterElement ciConveyorInspectList;

    @FindBy(locator = "conveyorInspect.maintenance.finding")
    public CustomFlutterElement ciMaintenanceFinding;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"inspect_name\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"conveyorInspect_0\\\"}\"}")
    public CustomFlutterElement ciSiteName;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"conveyor name\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"conveyor_0\\\"}\"}")
    public CustomFlutterElement ciConveyorName;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"findingbg\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"findings_0\\\"}\"}")
    public CustomFlutterElement ciFindingsColor;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"expand\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"findings_0\\\"}\"}")
    public CustomFlutterElement ciFindingsExpand;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"idler temp\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"findings_0\\\"}\"}")
    public CustomFlutterElement ciFindingsIdlerTemp;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"env temp\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"findings_0\\\"}\"}")
    public CustomFlutterElement ciFindingsEnvTemp;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByText\\\",\\\"text\\\": \\\"Got that fixed\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"findings_0\\\"}\"}")
    public CustomFlutterElement ciFindingsGotFixed;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"rgb\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"findings_0\\\"}\"}")
    public CustomFlutterElement ciFindingsRgb;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"ir\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"findings_0\\\"}\"}")
    public CustomFlutterElement ciFindingsIr;

    @FindBy(locator = "conveyorInspect.maintenance.loader")
    public CustomFlutterElement ciMaintenanceLoader;

    @FindBy(locator = "conveyor.search.dropdown")
    public CustomFlutterElement searchDropdown;

    @FindBy(locator = "conveyorInspect.uploadFile.cancelImageUpload")
    public CustomFlutterElement cancelImageUpload;

    @FindBy(locator = "conveyorInspect.uploadFile.proceedUpload")
    public CustomFlutterElement proceedUpload;

    @FindBy(locator = "conveyorInspect.uploadFile.imageStatus")
    public CustomFlutterElement imageStatus;

    @FindBy(locator = "conveyorInspect.uploadFile.imgFailed")
    public CustomFlutterElement imgFailed;

    @FindBy(locator = "conveyorInspect.uploadFile.uploadFailed")
    public CustomFlutterElement uploadFailed;

    public boolean goToConveyorInspectFromConveyorDetails() {
        ConveyorInspectNativePage.getInstance().clickOnConveyorInspectCard();
        return ciSiteInspectionTab.isVisible() && ciDashboardTab.isVisible();
    }

    public boolean navigateToConveyorInspect() {
        conveyorInspectCard.click();
        return ciConveyorInspectList.isVisible();
    }

    public String getFirstSearchResultSite() {
        return ciSiteName.getText();
    }

    public boolean navigateToConveyorInspectDetails() {
        ciSiteName.click();
        return ciInspectionTab.isVisible() && ciDashboardTab.isVisible();
    }

    public boolean goToInspectionConveyorInspect() {
        ciInspectionTab.click();
        return ciConveyorName.isVisible();
    }

    public String getFirstSearchResultConveyor() {
        return ciConveyorName.getText();
    }

    public boolean goToConveyorLevelFromSite() {
        ciConveyorName.click();
        return ciSiteInspectionTab.isVisible() && ciDashboardTab.isVisible();
    }

    public boolean verifyCompanySiteDashboard() {
        return ciLastUpdate.isVisible() && ciConveyorStatus.isVisible() && ciDashboardPieChart.isVisible() && ciDashboardCritical.isVisible() && ciDashboardGoodTemp.isVisible() && ciUploadFiles.isVisible();
    }

    public boolean verifyLastUpdateStatus(String date) {
        System.out.println(date);
        return ciLastUpdate.isVisible() && ciLastUpdate.getText().contains(date);
    }

    public boolean verifyGraphFromDashboard(int critical,int poor,int fault,int good) {
        System.out.println(critical+".0 %");
        System.out.println(poor+".0 %");
        System.out.println(fault+".0 %");
        System.out.println(good+".0 %");
        return ciDashboardPieChart.isVisible() && ciDashboardCritical.getText().equalsIgnoreCase(critical+".0 %")&& ciDashboardPoor.getText().equalsIgnoreCase(poor+".0 %")&& ciDashboardFault.getText().equalsIgnoreCase(fault+".0 %")&& ciDashboardGood.getText().equalsIgnoreCase(good+".0 %");
    }

    public boolean verifyTemperatureFromDashboard(int critical,int poor,int fault,int good) {
        System.out.println(critical);
        System.out.println(poor);
        System.out.println(fault);
        System.out.println(good);
        return ciDashboardCriticalTemp.getText().contains(critical+"")&& ciDashboardPoorTemp.getText().contains(poor+"")&& ciDashboardFaultTemp.getText().contains(fault+"")&& ciDashboardGoodTemp.getText().contains(good+"");
    }


    public boolean verifyTrendAnalysis(){
        DashboardNativePage.getInstance().swipePage();
        return ciTrendAnalysisChart.isVisible() && ciTrendAnalysisCritical.isVisible() && ciTrendAnalysisPoor.isVisible() && ciTrendAnalysisFault.isVisible() && ciTrendAnalysisGood.isVisible();
    }

    public boolean verifyMaintenanceAction(){
        SyncUtil.waitFor(1500);
        DashboardNativePage.getInstance().swipePage();
        SyncUtil.waitFor(1500);
        DashboardNativePage.getInstance().swipePage();
        SyncUtil.waitFor(2000);
        ciMaintenanceLoader.waitForTheElementToBeInvisible(15);
        SyncUtil.waitFor(6000);
        return ciMaintenanceAction.isVisible() && ciMaintenanceFinding.isVisible();
    }

    public boolean verifyMaintenanceExpandFunctionality(){
        ciFindingsExpand.click();
        System.out.println(ciFindingsIdlerTemp.getText());
        System.out.println(ciFindingsEnvTemp.getText());
        System.out.println(ciFindingsRgb.isVisible());
        System.out.println(ciFindingsIr.isVisible());
        System.out.println(ciFindingsColor.getRenderObject());
        return ciFindingsGotFixed.isVisible();
    }

    public boolean verifyMaxTemp(){
        ciFindingsExpand.click();
        System.out.println(ciFindingsIdlerTemp.getText());
        System.out.println(ciFindingsEnvTemp.getText());
        return ciFindingsIdlerTemp.isVisible() && ciFindingsEnvTemp.isVisible();
    }

    public boolean verifyGotThatFixed(){
        ciFindingsExpand.click();
        return ciFindingsGotFixed.isVisible();
    }

    public boolean verifyIfrImages(){
        ciFindingsExpand.click();
        return ciFindingsRgb.isVisible() && ciFindingsIr.isVisible();
    }

    public boolean verifyUploadBtnNavigation(){
        ciUploadFiles.click();
        return ciUploadSite.isVisible() && ciUploadConveyor.isVisible();
    }

    public void siteSelection(String custSiteName){
        ciUploadSite.click();
        searchDropdown.sendKeys(custSiteName, "Customer");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();
    }

    public boolean verifySiteSelection(String custSiteName){
        return ciUploadSite.getText().equalsIgnoreCase(custSiteName);
    }

    public void conveyorSelection(String conveyorName){
        ciUploadConveyor.click();
        searchDropdown.sendKeys(conveyorName, "Conveyor");
        DashboardNativePage.getInstance().selectFirstSearchSiteScreen();
    }

    public boolean verifyConveyorSelection(String conveyorName){
        System.out.println(ciUploadConveyor.getText());
        return ciUploadConveyor.getText().equalsIgnoreCase(conveyorName);
    }

    public String verifyFlightDate(){
        ciUploadDate.click();
        DashboardNativePage.getInstance().cancelCalenderDate();
        System.out.println(ciUploadDateText.getText());
        ciUploadDate.click();
        DashboardNativePage.getInstance().selectCalenderDate();
        System.out.println(ciUploadDateText.getText());
        return ciUploadDateText.getText();
    }

    public String verifyFlightTime(){
        ciUploadTime.click();
        DashboardNativePage.getInstance().cancelCalenderDate();
        System.out.println(ciUploadTimeText.getText());
        ciUploadTime.click();
        DashboardNativePage.getInstance().selectCalenderDate();
        System.out.println(ciUploadTimeText.getText());
        return ciUploadTimeText.getText();
    }

    public String verifySideSelection(){
        ciUploadSideIcon.click();
        searchDropdown.sendKeys("LHS", "side");
        DashboardNativePage.getInstance().selectFirstSearchTerritorySiteScreen();
        return ciUploadSide.getText();
    }

    public String verifyColorSelection(){
        ciUploadColorMapicon.click();
        ciColorHot.click();
        return ciUploadColorMap.getText();
    }

    public boolean verifyCancelFunctionality(){
        ciUploadCancel.click();
        return !ciUploadConveyor.isVisible();
    }

    public boolean openUploadImage(String fileName){
        String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "test_files").getAbsolutePath();
        ConveyorInspectNativePage.getInstance().uploadConveyorInspectImage(fileName,file_path);
        ciUploadFileBtn.click();
        ConveyorInspectNativePage.getInstance().selectImageFromGallery(fileName);
        proceedUpload.click();
        boolean flag = imgFailed.isVisible();
        if(proceedUpload.isVisible())
            ConveyorInspectNativePage.getInstance().backButtonNavigation();
        return flag;
    }

    public String verifyUploadImage(){
        return imageStatus.getText();
    }

    public boolean verifyUploadSubmitSuccess(){
        ciUploadBtn.click();
        SyncUtil.waitFor(25000);
        return !uploadFailed.isVisible() && !ciUploadBtn.isVisible();
    }

    public boolean verifyUploadSubmitError(){
        ciUploadBtn.click();
        return uploadFailed.isVisible();
    }
}
