package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.MiscUtils;
import com.common.utils.PDFHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static java.io.File.separator;

public class FabricSplicePage extends BasePage {

    @FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
    public CustomElement btnAdd;

    @FindBy(locator = "xpath=(//div[text()='Splice Design']/../..//li//span[text()='Fabric'])[1]")
    public CustomElement fabric;
    @FindBy(locator = "xpath=//span[text()='Splice Design']")
    public CustomElement spliceDesign;
    @FindBy(locator = "xpath=//span[text()='Fabric Splice Generator']")
    public CustomElement fabricSpliceHeader;

    @FindBy(locator = "xpath=//input[@placeholder='Search']")
    public CustomElement btSearchinput;

    public String listItems = "//ul[@role='listbox']";

    @FindBy(locator = "xpath=//p-breadcrumb//nav[@data-pc-name=\"breadcrumb\"]")
    public CustomElement fabricSpliceBreadcrumb;

    @FindBy(locator = "xpath=//p-calendar[@formcontrolname='createdDate']//span//input")
    public CustomElement tbCreationDate;

    @FindBy(locator = "xpath=//input[@formcontrolname='designerName']")
    public CustomElement tbDesignerName;

    @FindBy(locator = "xpath=(//label[text()=\"Choose Your Market\"]/following-sibling::div//p-dropdown)[1]")
    public CustomElement drChooseMarketDropDown;

    @FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter')]")
    public CustomElement tbFabricSpliceSearchInput;

    @FindBy(locator = "xpath=(//label[text()=\"Production Location of Splice Kit\"]/following-sibling::div//p-dropdown)[1]")
    public CustomElement drProductionLocationKit;

    @FindBy(locator = "xpath=(//p-dropdown[@datakey='companyId']/div/div)[1]")
    public CustomElement drSiteDropdown;

    @FindBy(locator = "xpath=(//p-dropdown[@datakey='conveyorId']/div/div)[1]")
    public CustomElement drConveyorDropdown;

    @FindBy(locator = "xpath=//p-autocomplete[@field=\"name\"]//button")
    public CustomElement drApproverDropdown;

    @FindBy(locator = "xpath=//p-autocomplete[@field='name']//input")
    public CustomElement drApproverInput;

    @FindBy(locator = "xpath=(//label[text()=\"Belt Construction\"]/following-sibling::div//p-dropdown)[1]")
    public CustomElement drBeltConstructionDropdown;

    @FindBy(locator = "xpath=//p-radiobutton[@value=\"Normal\"]//div[contains(@class,\"p-highlight\")]")
    public CustomElement radioBtnNormalSelected;

    @FindBy(locator = "xpath=//p-radiobutton[@value=\"Right\"]//div[contains(@class,\"p-highlight\")]")
    public CustomElement radioBtnRightSelected;

    @FindBy(locator = "xpath=//p-radiobutton[@value=\"regular\"]//div[contains(@class,\"p-highlight\")]")
    public CustomElement radioBtnRegularSelected;


    @FindBy(locator = "xpath=//input[@formcontrolname='beltWidth']")
    public CustomElement tbBeltWidth;
    @FindBy(locator = "xpath=(//label[text()=\"Belt Type(Fabric)\"]/following-sibling::div//p-dropdown)[1]")
    public CustomElement drBeltType;

    @FindBy(locator = "xpath=(//label[text()=\"Top Cover Compound\"]/following-sibling::div//p-dropdown)[1]")
    public CustomElement drTopCoverCompound;
    @FindBy(locator = "xpath=(//label[text()=\"Bottom Cover Compound\"]/following-sibling::div//p-dropdown)[1]")
    public CustomElement drBottomCoverCompound;
    @FindBy(locator = "xpath=(//label[text()=\"Top Cover Thickness(mm)\"]/following-sibling::div//p-dropdown)[1]")
    public CustomElement drTopCoverThickness;
    @FindBy(locator = "xpath=(//label[text()=\"Bottom Cover Thickness(mm)\"]/following-sibling::div//p-dropdown)[1]")
    public CustomElement drBottomCoverThickness;

    @FindBy(locator = "xpath=//input[@formcontrolname='overallBeltThickness']")
    public CustomElement tbOverallBeltThickness;

    @FindBy(locator = "xpath=(//label[text()=\"Bias Angle (Degrees)\"]/following-sibling::div//p-dropdown)[1]")
    public CustomElement drBiasAngleThickness;

    @FindBy(locator = "xpath=//p-dropdown[@formcontrolname='spliceType']//span")
    public CustomElement drSpliceType;
    @FindBy(locator = "xpath=//button//span[text()=\"Calculate\"]")
    public CustomElement btnCalculate;
    @FindBy(locator = "xpath=//button[@disabled]//span[text()=\"Calculate\"]")
    public CustomElement btnCalculateDisabled;

    @FindBy(locator = "xpath=//button//span[contains(@class,\"pi-spinner\")]")
    public CustomElement btnLoader;

    @FindBy(locator = "xpath=//i[contains(@class,\"pi-spinner\")]")
    public CustomElement loaderIcon;

    @FindBy(locator = "xpath=//div//p-panel[@header='Preview']")
    public CustomElement previewTab;
    @FindBy(locator = "xpath=//label[text()='No. Of Steps']/../following-sibling::div//input")
    public CustomElement noOfStepsVal;

    @FindBy(locator = "xpath=//label[text()='Width']/../following-sibling::div//input")
    public CustomElement beltWidthVal;
    @FindBy(locator = "xpath=//label[text()='Over Belt Thickness']/../following-sibling::div//input")
    public CustomElement overallBeltThicknessVal;

    @FindBy(locator = "xpath=//label[text()=\"Step Length\"]/../following-sibling::div//input")
    public CustomElement stepLengthVal;
    @FindBy(locator = "xpath=//label[text()=\"Splice Length\"]/../following-sibling::div//input")
    public CustomElement spliceLengthVal;
    @FindBy(locator = "xpath=//label[text()=\"Cover Strip Width(Top)\"]/../following-sibling::div//input")
    public CustomElement coverStripeWidthTop;

    @FindBy(locator = "xpath=//label[text()=\"Cover Strip Width(Bottom)\"]/../following-sibling::div//input")
    public CustomElement coverStripeWidthBottom;
    @FindBy(locator = "xpath=//label[contains(text(),\"Bias Length\")]/../following-sibling::div//input")
    public CustomElement biasLengthVal;

    @FindBy(locator = "xpath=//label[contains(text(),\"Coated Breaker Strip\")]/../following-sibling::div//input")
    public CustomElement coatedBreakerStripVal;
    @FindBy(locator = "xpath=//label[contains(text(),' Cure Temperature')]/../following-sibling::div//input")
    public CustomElement cureTempVal;

    @FindBy(locator = "xpath=//label[contains(text(),' Cure Pressure')]/../following-sibling::div//input")
    public CustomElement curePressureVal;
    @FindBy(locator = "xpath=//label[contains(text(),' Cure Time')]/../following-sibling::div//input")
    public CustomElement cureTimeVal;
    @FindBy(locator = "xpath=//label[contains(text(),'All dimension')]/../following-sibling::div//input")
    public CustomElement allDimensionVal;
    @FindBy(locator = "xpath=//div[contains(@class,\"arrow-right-direction\")]")
    public CustomElement arrowDirectionRight;
    @FindBy(locator = "xpath=//span//img[contains(@class,\"conti-step-image\")]")
    public CustomElement designPreview;
    @FindBy(locator = "xpath=//a[@role=\"tab\"]//span[text()=\"Splice Kit BOM\"]")
    public CustomElement spliceKitBomTab;
    @FindBy(locator = "xpath=//app-fabric-kit-bill//div//h4[text()=\"Bill Of Materials-Splice Kit\"]")
    public CustomElement spliceKitBomHeader;

    @FindBy(locator = "xpath=//a[@role=\"tab\"]//span[text()=\"Comments Log\"]")
    public CustomElement commentsLogTab;

    @FindBy(locator = "xpath=//div//h6[text()=\"Designer Comment\"]")
    public CustomElement commentsLogHeader;

    @FindBy(locator = "xpath=(//div//textarea)[2]")
    public CustomElement tbComments;
    @FindBy(locator = "xpath=//button//span[text()='Send for review']")
    public CustomElement btnReview;
    @FindBy(locator = "xpath=(//td//p-tablecheckbox)[1]")
    public CustomElement crCheckbox;
    @FindBy(locator = "xpath=//td//p-tag//span[text()=\" In Review\"]")
    public CustomElement statusInReview;

    @FindBy(locator = "xpath=//td//p-tag//span[text()=\" To Review\"]")
    public CustomElement statusToReview;
    @FindBy(locator = "xpath=//td//p-tag//span[text()=\" Approved\"]")
    public CustomElement statusApproved;

    @FindBy(locator = "xpath=//td//p-tag//span[text()=\" Draft\"]")
    public CustomElement statusDraft;
    @FindBy(locator = "xpath=//label[text()='Splice Design Drawing No.']/../div//input")
    public CustomElement tbSpliceDesignDrawingNo;
    @FindBy(locator = "xpath=//button//span[text()=\"Save as a Draft\"]")
    public CustomElement btnSaveDraftButton;

    @FindBy(locator = "xpath=(//button/chevrondownicon)[2]")
    public CustomElement btActions;
    @FindBy(locator = "xpath=//button[@disabled]/chevrondownicon")
    public CustomElement btActionsDisabled;

    @FindBy(locator = "xpath=//li//span[text()='Edit']")
    public CustomElement btEdit;
    @FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
    public CustomElement pagination;


    @FindBy(locator = "xpath=//button//span[text()='Save as Draft']")
    public CustomElement btnSaveDraftButtonSteelCord;

    @FindBy(locator = "xpath=//input[@name='drawing_num']")
    public CustomElement spliceDrawingNumberVal;

    @FindBy(locator = "xpath=//app-breadcrumb//ol")
    public CustomElement steelCordBreadcrumb;
    @FindBy(locator = "xpath=(//button[@icon='ctp-icon-Arrow-Right'])[1]")
    public CustomElement btviewicon;
    @FindBy(locator = "xpath=//button//span[text()='Approve']")
    public CustomElement btnApprove;
    @FindBy(locator = "xpath=//span[text()='Delete']")
    public CustomElement btDelete;
    @FindBy(locator = "xpath=//div[contains(@class,'p-confirm-dialog')]")
    public CustomElement deleteDialogbox;
    @FindBy(locator = "xpath=//div[contains(@class,'p-confirm-dialog')]//checkicon[contains(@class,'p-icon-wrapper')]")
    public CustomElement confirmBtn;
    @FindBy(locator = "xpath=//td[contains(text(),'No')]")
    public CustomElement noList;
    @FindBy(locator = "xpath=//div//h6[contains(text(),'Approver comment')]")
    public CustomElement approverCommentHeader;


    InspectionPage inspectionPage = new InspectionPage();

    public void gotoFabricScreen() {
        if (!fabric.isVisible())
            spliceDesign.click("Splice Design");
        SyncUtil.waitFor(1000);
        fabric.click("Minuteman");
        waitForElementToDisplay(fabricSpliceHeader);
        btSearchinput.isVisible("Minuteman Page");
    }

    public void goToFabricListScreenAndWait() {
        gotoFabricScreen();
        scrollPageDown();
        String val = "";
        for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(380); stop > System.nanoTime(); ) {
            if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
                break;
            }
            val = pagination.getText();
            SyncUtil.waitFor(10000);
        }
    }

    public void gotoAddFabricSpliceScreen() {
        gotoFabricScreen();
        btnAdd.click("Add");
        Validator.assertTrue(fabricSpliceBreadcrumb.getText().contains("Tools\nFabric Splice Generator"), "User is not navigated to add splice page", "User is  navigated to add splice page");
    }

    public void addFabricSpliceDesign(String designerName, String market, String spliceKit, String customerName, String conveyorName, String approverName, String beltConstruction) {
        waitForPageLoad(10000);
//        SyncUtil.waitFor(5000);
        Validator.assertTrue(tbDesignerName.getAttribute("value").equalsIgnoreCase(designerName), "The designer name is not auto-populated and is not same as current user name", "The designer name is auto-populated and is same as current user name");
        waitForElementVisible(drChooseMarketDropDown, 10000, 500);
        dropdownSearch(drChooseMarketDropDown, tbFabricSpliceSearchInput, market);
        dropdownSearch(drProductionLocationKit, tbFabricSpliceSearchInput, spliceKit);
        dropdownSelectSearch(drSiteDropdown, tbFabricSpliceSearchInput, customerName);
        dropdownSelectSearch(drConveyorDropdown, tbFabricSpliceSearchInput, conveyorName);
        setImplicitWait(20000, TimeUnit.MILLISECONDS);
//        drApproverDropdown.jsClick("Approver List");
        drApproverInput.type(approverName);
//        SyncUtil.waitFor(5000);
//        waitForElementVisible(driver.findElement(By.xpath("//ul[@aria-label='Option List']//li//span[text()='"+approverName+"']")),10000,500);
//        driver.findElement(By.xpath("//ul[@aria-label='Option List']//li//span[text()='"+approverName+"']")).click();
//        scrollPageDown();
        SyncUtil.waitFor(500);
        dropdownSelect(drApproverDropdown,listItems,approverName);
//        waitForElementVisible(driver.findElement(By.xpath("//ul[@aria-label='Option List']//li//span[text()='"+approverName+"']")),5000,500);
//        scrollIntoView(driver.findElement(By.xpath("//ul[@aria-label='Option List']//li//span[text()='" + approverName + "']")));
//        driver.findElement(By.xpath("//ul[@aria-label='Option List']//li//span[text()='" + approverName + "']")).click();
        dropdownSearch(drBeltConstructionDropdown, tbFabricSpliceSearchInput, beltConstruction);
        Validator.assertTrue(radioBtnNormalSelected.isVisible(), "'Normal' is not selected by default for Direction of Skive Cut", "'Normal' is selected by default for Direction of Skive Cut");
        Validator.assertTrue(radioBtnRightSelected.isVisible(), "'Right' is not selected by default for Direction of Travel", "'Right' is selected by default for Direction of Travel");
        waitForElementVisible(tbCreationDate, 10000, 500);
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String formattedCurrentDate = currentDate.format(formatter);
        Validator.assertTrue(formattedCurrentDate.equals(tbCreationDate.getAttribute("value")), "The creation date is not equal to current date", "The creation date is  equal to current date");
    }

    public void addFabricSpliceDesignDetails(String beltWidth, String beltType, String topCoverCompound, String bottomCoverCompound, String topCoverThickness, String bottomCoverThickness, String overallThickess, String biasAngle) {
        tbBeltWidth.isVisible(10000, "Belt Width");
        tbBeltWidth.type(beltWidth);
        dropdownSelectSearchContains(drBeltType, tbFabricSpliceSearchInput, beltType);
        dropdownSearch(drTopCoverCompound, tbFabricSpliceSearchInput, topCoverCompound);
        dropdownSearch(drTopCoverThickness, tbFabricSpliceSearchInput, topCoverThickness);
        dropdownSearch(drBottomCoverCompound, tbFabricSpliceSearchInput, bottomCoverCompound);
        tbOverallBeltThickness.type(overallThickess);
        drBiasAngleThickness.click();
        waitForElementVisible(driver.findElement(By.xpath("//p-dropdownitem//li[contains(@aria-label,'" + biasAngle + "')]")), 10000, 500);
        driver.findElement(By.xpath("//p-dropdownitem//li[contains(@aria-label,'" + biasAngle + "')]")).click();
        dropdownSearch(drBottomCoverThickness, tbFabricSpliceSearchInput, bottomCoverThickness);


    }

    public void selectAndVerifySpliceType(String spliceType) {
        drSpliceType.isVisible(10000, "Splice Type");
        drSpliceType.click();
        waitForElementVisible(driver.findElement(By.xpath("//p-dropdownitem//li[contains(@aria-label,'" + spliceType + "')]")), 10000, 500);
        driver.findElement(By.xpath("//p-dropdownitem//li[contains(@aria-label,'" + spliceType + "')]")).click();
        Validator.assertTrue(radioBtnRegularSelected.isVisible(), "The Regular Splice is not selected by default", "The Regular Splice is selected by default");
//        Validator.assertTrue(btnCalculate.isEnabled(), "The calculate button is not enabled", "The calculate button is enabled");
//        SyncUtil.waitFor(40000);
    }

    public void calculateBtnClick() {
        setImplicitWait(4000, TimeUnit.MILLISECONDS);
        btnCalculate.isVisible("Calculate");
        waitForElementToBeClickable(btnCalculate);
        btnCalculate.click("Calculate");
        SyncUtil.waitFor(5000);
        btnCalculateDisabled.isVisible(15000, "calculate Button Disabled");
    }

    public void verifyFabricSplicePreviewTab() {
        scrollPageDown();
        Validator.assertTrue(previewTab.isVisible(10000, "Preview"), "The preview tab is not displayed after calculation", "The preview tab is displayed after calculation");
    }

    public void verifyFabricPreviewDesignDescription(String noOfSteps, String beltWidth, String overallThickness, String stepLength, String spliceLength, String coverStripTop, String coverStripBottom, String biasLength, String coatedBreakerStrip, String beltType, String topCoverThickness, String bottomCoverThickness, String topCoverCompoundName) {

        tbSpliceDesignDrawingNo.isVisible(10000, "splice drawing number");
        String designName = tbSpliceDesignDrawingNo.getAttribute("value");
        System.out.println(designName + "The design name before getbundle");
        getBundle().setProperty("spliceDrawingNumber", designName);
        System.out.println("Splice drawing number" + getBundle().getProperty("spliceDrawingNumber").toString());
        Validator.assertTrue(
//                driver.findElement(By.xpath("//div//h4[contains(text(), '" + beltWidth + " " + beltType + " " + topCoverThickness + "+" + bottomCoverThickness + " " + topCoverCompoundName + "  - FABRIC BELT STEP SPLICE')]")).isDisplayed(),
                driver.findElement(By.xpath("//div//h4[contains(text(), '" + beltType + " " + topCoverThickness + "+" + bottomCoverThickness + " " + topCoverCompoundName + "  - FABRIC BELT STEP SPLICE')]")).isDisplayed(),
                "The preview tab for design has in-correct header",
                "The preview tab for design has correct header"
        );
        scrollPageDown();
        SyncUtil.waitFor(5000);
//        Validator.assertTrue(arrowDirectionRight.isVisible(10000, "Arrow Right"), "The Direction of arrow is not same as the input direction to travel provided", "The Direction of arrow is same as the input direction to travel provided");
        Validator.assertTrue(designPreview.isVisible(10000, "Design"), "The preview design is not displayed", "The preview design is displayed");
        noOfStepsVal.isVisible(10000, "No Of Steps");
        Validator.assertTrue(noOfStepsVal.getAttribute("value").equalsIgnoreCase(noOfSteps), "The No Of Steps value is in-correct", "The No Of Steps value is correct");
        Validator.assertTrue(beltWidthVal.getAttribute("value").equalsIgnoreCase(beltWidth), "The Belt width value is in-correct", "The Belt width value is correct");
        Validator.assertTrue(overallBeltThicknessVal.getAttribute("value").equalsIgnoreCase(overallThickness), "The Belt Thickness value is in-correct", "The Belt Thickness value is correct");
        System.out.println(stepLengthVal.getAttribute("value"));
        System.out.println(stepLength);
        Validator.assertTrue(stepLengthVal.getAttribute("value").equalsIgnoreCase(stepLength), "The step Length value is in-correct", "The step Length value is correct");
        Validator.assertTrue(spliceLengthVal.getAttribute("value").equalsIgnoreCase(spliceLength), "The splice Length value is in-correct", "The splice Length value is correct");
        Validator.assertTrue(coverStripeWidthTop.getAttribute("value").equalsIgnoreCase(coverStripTop), "The cover Stripe Width(Top) value is in-correct", "The cover Stripe Width(Top) value is correct");
        Validator.assertTrue(coverStripeWidthBottom.getAttribute("value").equalsIgnoreCase(coverStripBottom), "The cover Stripe Width (Bottom) value is in-correct", "The cover Stripe Width (Bottom) value is correct");
        Validator.assertTrue(biasLengthVal.getAttribute("value").equalsIgnoreCase(biasLength), "The bias Length value is in-correct", "The bias Length value is correct");
        Validator.assertTrue(coatedBreakerStripVal.getAttribute("value").equalsIgnoreCase(coatedBreakerStrip), "The coated Breaker Strip value is in-correct", "The coated Breaker Strip value is correct");

    }

    public void verifyPreviewNotesValues(String cureTemp, String curePressure, String cureTime, String dimensionUnit) {
        cureTempVal.isVisible(10000, "Cure Temperature");
        Validator.assertTrue(cureTempVal.getAttribute("value").contains(cureTemp), "The cureTemperature value is in-correct", "The cureTemperature value is correct");
        System.out.println(curePressureVal.getAttribute("value") + "the value is" + curePressure);
        Validator.assertTrue(curePressureVal.getAttribute("value").contains(curePressure), "The cure Pressure value is in-correct", "The cure Pressure value is correct");
        Validator.assertTrue(cureTimeVal.getAttribute("value").equalsIgnoreCase(cureTime), "The cure Time value is in-correct", "The cure Time value is correct");
        Validator.assertTrue(allDimensionVal.getAttribute("value").equalsIgnoreCase(dimensionUnit), "The dimension Unit value is in-correct", "The dimension Unit value is correct");

    }

    public void clickAndVerifySpliceKitBOM() {
        spliceKitBomTab.isVisible(10000, "Splice Kit BOM");
        spliceKitBomTab.click();
        Validator.assertTrue(spliceKitBomHeader.isVisible(10000, "Splice Kit BOM"), "User is not navigated to Splice Kit BOM Tab", "User is  navigated to Splice Kit BOM Tab");

    }

    public void commentLogClick() {
        commentsLogTab.isVisible(10000, "Comments Log");
        commentsLogTab.click();
        Validator.assertTrue(commentsLogHeader.isVisible(10000, "Splice Kit BOM"), "User is not navigated to Comments Log Tab", "User is  navigated to Comments Log Tab");
    }

    public void saveDraftBtnClick() {
        btnSaveDraftButton.isVisible(10000, "save as draft");
        btnSaveDraftButton.click("Save As Draft");
        SyncUtil.waitFor(12000);
//        waitForElementInvisible(btnLoader,15000,500);
    }

    public void clickAndVerifyCommentsLog(String comments) {
        commentLogClick();
        tbComments.isVisible(10000, "Comments tab");
        tbComments.type(comments);
    }

    public void btnReviewClick() {
        btnReview.isVisible(10000, "Review");
        btnReview.click("Review");
    }

    public boolean searchForTheRecord(String designName) {
        waitForPageLoad(10000);
        btSearchinput.isVisible(10000, "search input");
        btSearchinput.type(designName, "Record Search");
        waitForElementVisible(crCheckbox, 20000, 1000);
        waitForElementToDisplay(crCheckbox);
        return crCheckbox.isVisible("Record Found");
    }

    public void verifyDesignStatus(String status) {
        String spliceDrawingNumber = getBundle().getProperty("spliceDrawingNumber").toString();
        System.out.println("Splice drawing number" + spliceDrawingNumber);
        searchForTheRecord(spliceDrawingNumber);
        if (status.equalsIgnoreCase("In Review"))
            Validator.assertTrue(statusInReview.isVisible(10000, "In Review"), "The design is not in review status after sending for review", "The design is in review status after sending for review");
        else if (status.equalsIgnoreCase("Approved"))
            Validator.assertTrue(statusApproved.isVisible(10000, "Approved"), "The design is not approved status", "The design is in approved status");
        else if (status.equalsIgnoreCase("Draft"))
            Validator.assertTrue(statusDraft.isVisible(10000, "Draft"), "The design is not in Draft status", "The design is in Draft status");
        else if(status.equalsIgnoreCase("To Review"))
            Validator.assertTrue(statusToReview.isVisible(10000,"To Review"),"The design is not in 'To Review' status","The design is  in 'To Review' status");

    }

    public void editRecord() {
        crCheckbox.isVisible(10000, "record");
//        waitForElementVisible(crCheckbox,10000,500);
        crCheckbox.check("Select Corporate");
        btActions.jsClick("Actions");
        waitForElementToDisplay(btEdit);
        waitForElementVisible(btEdit, 10000, 500);
        btEdit.isVisible(10000, "Edit");
        waitForElementToBeClickable(btEdit);
        btEdit.click("Edit");
    }
    public boolean verifyActionBtnPermissions()
    {
        SyncUtil.waitFor(10000);
        crCheckbox.isVisible(10000, "record");
        crCheckbox.check("Select Corporate");
        waitForElementVisible(btActions,10000,500);
        return btActionsDisabled.isVisible(10000,"Action button disabled");
    }

    public void verifyEditPageNavigation() {
        waitForPageLoad(10000);
        SyncUtil.waitFor(5000);
        Validator.assertTrue(fabricSpliceBreadcrumb.getText().contains("Tools\nFabric Splice Generator\nEdit"), "User is not navigated to edit splice page", "User is  navigated to edit splice page");
    }

    public void clickViewBtn() {
        waitForElementToDisplay(crCheckbox);
        waitForElementToDisplay(btviewicon);
        btviewicon.click("View Details");
        waitForPageLoad(20000);
    }

    public void btnApproveClick() {
        btnApprove.isVisible(10000, "Review");
        btnApprove.click("Approve");
        waitForPageLoad(10000);
    }

    public void approverCommentLogTabClick() {
        commentsLogTab.isVisible(20000, "Comments Log");
        commentsLogTab.click();
        Validator.assertTrue(approverCommentHeader.isVisible(10000, "Comments Log Tab"), "User is not navigated to Comments Log Tab", "User is  navigated to Comments Log Tab");
    }

    public void clickAndVerifyApproverCommentsLog(String comments) {
        approverCommentLogTabClick();
        tbComments.isVisible(10000, "Comments tab");
        tbComments.type(comments);
    }

    public void verifyPDFContentsSpliceDesign(String reqFile, String designId, String siteName, String conveyorName) {
        PDDocument doc = PDFHelper.getPDFData(System.getProperty("user.dir")+separator+"target"+separator+"downloads"+separator+reqFile);
        try {
            String val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
            System.out.println(val);
            Validator.assertTrue(val.contains(designId), "PDF Report was generated for the wrong Design Id", "PDF Report was generated for the right Design Id");
            Validator.assertTrue(val.contains(siteName), "PDF Report was generated for the wrong customer Site", "PDF Report was generated for the right customer Site");
            Validator.assertTrue(val.contains(conveyorName), "PDF Report was generated for the wrong conveyor", "PDF Report was generated for the right conveyor");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyDownloadPDFSpliceDesign(String siteName, String conveyorName) {
        inspectionPage.downloadPDF();
        String reqFile = getBundle().getProperty("spliceDrawingNumber").toString() + "_Rev0.pdf";
        String designId = getBundle().getProperty("spliceDrawingNumber").toString();
        Validator.assertTrue(MiscUtils.checkDownloadedFiles(reqFile), "PDF report was not found", "PDF report was downloaded successfully");
        verifyPDFContentsSpliceDesign(reqFile, designId, siteName, conveyorName);
        MiscUtils.deleteDownloadedFiles(reqFile);
    }

    public void verifyDeleteFunForSpliceDesign() {
        crCheckbox.check("Select Item");
        btActions.jsClick("Actions");
        waitForElementVisible(btDelete, 10000, 500);
        waitForElementToBeClickable(btDelete);
        btDelete.click();
        waitForElementVisible(deleteDialogbox, 5000, 500);
        waitForElementVisible(confirmBtn, 5000, 500);
        waitForElementToBeClickable(confirmBtn);
        confirmBtn.click();
        waitForElementToDisplay(noList);
        noList.isVisible("No Item Found");
    }


}