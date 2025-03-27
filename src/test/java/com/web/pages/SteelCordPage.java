package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.MiscUtils;
import com.common.utils.PDFHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import groovyjarjarantlr4.v4.codegen.model.Sync;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.By;
import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static java.io.File.separator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class SteelCordPage extends BasePage {

	InspectionPage inspectionPage=new InspectionPage();
	@FindBy(locator = "xpath=//span[text()='Splice Design']")
	public CustomElement lsSpliceDesign;
	@FindBy(locator = "xpath=//span[text()='Steel Cord']")
	public CustomElement lsSteelCord;
	@FindBy(locator = "xpath=//h4[text()='Steel Cord Splice Generator']")
	public CustomElement txtSteelCordListHeader;
	@FindBy(locator = "xpath=//h4[text()='STEEL CORD SPLICE GENERATOR']")
	public CustomElement txtSteelCordAddHeader;

	@FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
	public CustomElement btAdd;

	@FindBy(locator = "xpath=//p-calendar//input")
	public CustomElement tbCreationDate;
	@FindBy(locator = "xpath=//input[@name='designerName']")
	public CustomElement tbdesignerName;
	@FindBy(locator = "xpath=//div[@class='profile-info']//h6")
	public CustomElement tbProfileName;
	@FindBy(locator = "xpath=(//label[text()='Choose Your Market']/../div//span)[1]")
	public CustomElement drchoosetyourmarket;

//	@FindBy(locator = "xpath=(//label[text()=\"Choose Your Market\"]/following-sibling::div//p-dropdown)[1]")
//	public CustomElement drChooseMarketDropDown;

	@FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter p-inputtext')]")
	public CustomElement tbInput;

	@FindBy(locator = "xpath= (//label[text()='Production Location of Splice Kit']/../div//span)[1]")
	public CustomElement drProductionLocationOfSplicekit;

	@FindBy(locator = "xpath= //label[text()='Customer Name']/../div//span")
	public CustomElement drCustomerName;

	@FindBy(locator = "xpath= (//label[text()='Conveyor Name']/../div//span)[2]")
	public CustomElement drConveyorName;
	
	@FindBy(locator = "xpath= //label[text()='Approver Name']/../div//button")
	public CustomElement drApproverName;

	@FindBy(locator = "xpath=//p-autocomplete[@field='name']//button")
	public CustomElement drApproverDropdown;
	@FindBy(locator = "xpath=//p-autocomplete[@field='name']//input")
	public CustomElement drApproverInput;
	
	public String drapproverlist = "xpath= //ul[contains(@class,'p-autocomplete-items')]//li//div//span";
	
	@FindBy(locator = "xpath=  //label[text()='Belt Rating']/../div//span")
	public CustomElement drBeltrating;

	@FindBy(locator = "xpath=//input[@formcontrolname='beltWidth']")
	public CustomElement tbBeltWidth;
	
	@FindBy(locator = "xpath=//label[text()='Top Cover Compound']/../div//span")
	public CustomElement drTopCoverCompound;
	
	@FindBy(locator = "xpath=//label[text()='Bottom Cover Compound']/../div//span")
	public CustomElement drBottomCoverCompound;

	@FindBy(locator = "xpath=//label[text()='Top Cover Thickness']/../div//span")
	public CustomElement drTopCoverThickness;
	
	@FindBy(locator = "xpath=//label[text()='Bottom Cover Thickness']/../div//span")
	public CustomElement drBottomCoverThickness;
	
	@FindBy(locator = "xpath=//input[@formcontrolname='overallThickness']")
	public CustomElement tbOverallThickness;
	
	@FindBy(locator = "xpath=//input[@formcontrolname='cordDiameter']")
	public CustomElement tbCordDiameter;
	
	@FindBy(locator = "xpath=//input[@formcontrolname='cordPitch']")
	public CustomElement tbCordPitch;
	
	@FindBy(locator = "xpath=//input[@formcontrolname='numberOfCord']")
	public CustomElement tbNumberOfCords;
	
	@FindBy(locator = "xpath=//label[contains(text(),'Bias Angle')]/../div//span")
	public CustomElement drBiasAngle;
	@FindBy(locator = "xpath=//label[contains(text(),'Bias Angle')]/../div//li[contains(@aria-label,'22')]")
	public CustomElement drBiasAngle22Deg;
	
	@FindBy(locator = "xpath=(//p-radiobutton[@formcontrolname='spliceCategory']//div[2])[1]")
	public CustomElement radioRegularSplice;
	
	@FindBy(locator = "xpath=(//p-radiobutton[@formcontrolname='spliceCategory']//div[2])[2]")
	public CustomElement radioHighPerformaceSplice;
	@FindBy(locator = "xpath=(//p-radiobutton[@formcontrolname='spliceCategory']//div[2])[3]")
	public CustomElement radioReduceServiceSplice;
	
	@FindBy(locator = "xpath=(//p-checkbox[@name='reducedServiceReason'])[1]")
	public CustomElement checkBoxReason;
	
	@FindBy(locator = "xpath=//span[text()='Save']")
	public CustomElement btSave;
	@FindBy(locator = "xpath=//button//span[text()='Calculate']")
	public CustomElement btnCalculate;
	@FindBy(locator = "xpath=//div//p-panel//span[text()='Preview']")
	public CustomElement previewTab;

	@FindBy(locator = "xpath=(//p-image//span//img)[1]")
	public CustomElement previewTabImg;
	@FindBy(locator = "xpath=(//label[text()='No. Of Steps']/../following-sibling::div//input)[1]")
	public CustomElement noOfStepsVal;
	@FindBy(locator = "xpath=(//label[text()='Width']/../following-sibling::div//input)[1]")
	public CustomElement beltWidthVal;
	@FindBy(locator = "xpath=(//label[text()='Overall Belt Thickness']/../following-sibling::div//input)[1]")
	public CustomElement overallBeltThicknessVal;
	@FindBy(locator = "xpath=(//p-panel///label[text()='Splice Pattern']/../following-sibling::div//input)[1]")
	public CustomElement splicePatternVal;
	@FindBy(locator = "xpath=(//p-panel///label[text()='Splice Type']/../following-sibling::div//input)[1]")
	public CustomElement spliceTypeVal;
	@FindBy(locator = "xpath=//label[text()='Number Of Repeats:']/../..//label[text()='A']/../following-sibling::div//input")
	public CustomElement numberOfRepeatsAVal;
	@FindBy(locator = "xpath=//label[text()='Number Of Repeats:']/../..//label[text()='B']/../following-sibling::div//input")
	public CustomElement numberOfRepeatsBVal;
	@FindBy(locator = "xpath=//label[contains(text(),'Cover Cut')]/../following-sibling::div//input")
	public CustomElement coverCutVal;
	@FindBy(locator = "xpath=//p-panel//label[contains(text(),'Cord Butt Gap')]/../following-sibling::div//input")
	public CustomElement cordButtGapVal;
	@FindBy(locator = "xpath=//p-panel//label[contains(text(),'Transition Length')]/../following-sibling::div//input")
	public CustomElement transitionLengthVal;
	@FindBy(locator = "xpath=//label[contains(text(),'Bias Length')]/../following-sibling::div//input")
	public CustomElement biasLengthVal;
	@FindBy(locator = "xpath=//p-panel//label[contains(text(),'Bias Angle')]/../following-sibling::div//input")
	public CustomElement biasAngleVal;
	@FindBy(locator = "xpath=//label[text()='Step Length']/../following-sibling::div//input")
	public CustomElement stepLengthVal;
	@FindBy(locator = "xpath=//label[text()='Splice Length']/../following-sibling::div//input")
	public CustomElement spliceLengthVal;
	@FindBy(locator = "xpath=//label[text()='Overall Splice Length']/../following-sibling::div//input")
	public CustomElement overallSpliceLengthVal;
	@FindBy(locator = "xpath=//td[contains(text(),'Cord Diameter')]/../td[2]")
	public CustomElement cordDiameterBeltVal;
	@FindBy(locator = "xpath=//td[contains(text(),'Cord Diameter')]/../td[3]")
	public CustomElement cordDiameterSpliceVal;
	@FindBy(locator = "xpath=//td[contains(text(),'No of Cords')]/../td[2]")
	public CustomElement noOfCordsBeltVal;
	@FindBy(locator = "xpath=//td[contains(text(),'No of Cords')]/../td[3]")
	public CustomElement noOfCordsSpliceVal;
	@FindBy(locator = "xpath=//td[contains(text(),'Cord Spacing')]/../td[2]")
	public CustomElement cordSpacingBeltVal;
	@FindBy(locator = "xpath=//td[contains(text(),'Cord Spacing')]/../td[3]")
	public CustomElement cordSpacingSpliceVal;
	@FindBy(locator = "xpath=//td[contains(text(),'Cord Pitch')]/../td[2]")
	public CustomElement cordPitchBeltVal;
	@FindBy(locator = "xpath=//td[contains(text(),'Cord Pitch')]/../td[3]")
	public CustomElement cordPitchSpliceVal;
	@FindBy(locator = "xpath=//input[@formcontrolname='allDimension']")
	public CustomElement allDimensionVal;
	@FindBy(locator = "xpath=//label//b[text()='Additional Notes:']")
	public CustomElement additionalNotesLabel;
	@FindBy(locator = "xpath=//input[@formcontrolname='temprature']")
	public CustomElement temperatureVal;
	@FindBy(locator = "xpath=//input[@formcontrolname='pressure']")
	public CustomElement pressureVal;
	@FindBy(locator = "xpath=//input[@formcontrolname='vulcTime']")
	public CustomElement vulcanizationTimeVal;
	@FindBy(locator = "xpath=//li//span[text()='Vulcanization Chart']")
	public CustomElement tbVulcanizationChartHeader;
	@FindBy(locator = "xpath=//li//span[text()='Comments Log']")
	public CustomElement tbCommentsLogHeader;
	@FindBy(locator = "xpath=//div[text()='Vulcanization Parameters']")
	public CustomElement vulcanizationParamHeader;
	@FindBy(locator = "xpath=//p-tabpanel//span[text()='Vulcanization Chart']")
	public CustomElement vulcanizationChartHeader;
	@FindBy(locator = "xpath=//span[text()='Vulcanization Chart']/..//img")
	public CustomElement vulcanizationChartImg;
	@FindBy(locator = "xpath=//span[text()='Cross-Sectional View of Splice']")
	public CustomElement crossSectionalViewHeader;
	@FindBy(locator = "xpath=//span[text()='Cross-Sectional View of Splice']/..//img")
	public CustomElement crossSectionalViewImg;
	@FindBy(locator = "xpath=//h6[text()='Designer Comment']")
	public CustomElement designerCommentHeader;
	@FindBy(locator = "xpath=//h6[text()='Designer Comment']/../../following-sibling::textarea")
	public CustomElement txtDesignerComment;
	@FindBy(locator = "xpath=//span[text()='Send for review']")
	public CustomElement btSendForReview;

	@FindBy(locator = "xpath=//div//h6[text()='Designer Comment']")
	public CustomElement commentsLogHeader;
	@FindBy(locator = "xpath=//div//h6[contains(text(),'Approver comment')]")
	public CustomElement approverCommentHeader;
	@FindBy(locator = "xpath=(//div//textarea)[2]")
	public CustomElement tbComments;
	@FindBy(locator = "xpath=//button//span[text()='Send for review']")
	public CustomElement btnReview;
	@FindBy(locator = "xpath=(//td//p-tablecheckbox)[1]")
	public CustomElement crCheckbox;
	@FindBy(locator = "xpath=//td//p-tag//span[text()=' In Review']")
	public CustomElement statusInReview;
	@FindBy(locator = "xpath=//td//p-tag//span[text()=' Approved']")
	public CustomElement statusApproved;
	@FindBy(locator = "xpath=//label[text()='Splice Design Drawing No.']/../div//input")
	public CustomElement tbSpliceDesignDrawingNo;
	@FindBy(locator = "xpath=//button//span[contains(text(),'Draft')]")
	public CustomElement btnSaveDraftButtonSteelCord;
	@FindBy(locator = "xpath=//button//span[contains(@class,'pi-spinner')]")
	public CustomElement btnLoader;
	@FindBy(locator = "xpath=//a[@role='tab']//span[text()='Comments Log']")
	public CustomElement commentsLogTab;
	@FindBy(locator = "xpath=//td//p-tag//span[text()=' Draft']")
	public CustomElement statusDraft;

	@FindBy(locator="xpath=//input[@placeholder='Search']")
	public CustomElement btSearchinput;
	@FindBy(locator="xpath=//input[@name='drawing_num']")
	public CustomElement spliceDrawingNumberVal;

	@FindBy(locator = "xpath=(//button/chevrondownicon)[2]")
	public CustomElement btActions;

	@FindBy(locator = "xpath=//li//span[text()='Edit']/..")
	public CustomElement btEdit;
	@FindBy(locator = "xpath=//app-breadcrumb//ol")
	public CustomElement steelCordBreadcrumb;

	@FindBy(locator="xpath=(//button[@icon='ctp-icon-Arrow-Right'])[1]")
	public CustomElement btviewicon;

	@FindBy(locator = "xpath=//button//span[text()='Approve']")
	public CustomElement btnApprove;
	@FindBy(locator = "xpath=//span[text()='Delete']")
	public CustomElement btDelete;
	@FindBy(locator="xpath=//div[contains(@class,'p-confirm-dialog')]")
	public CustomElement deleteDialogbox;

	@FindBy(locator="xpath=//div[contains(@class,'p-confirm-dialog')]//checkicon[contains(@class,'p-icon-wrapper')]")
	public CustomElement confirmBtn;

	@FindBy(locator = "xpath=//td[contains(text(),'No')]")
	public CustomElement noList;

	@FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
	public CustomElement pagination;

	@FindBy(locator = "xpath=//span[text()='Belt Info']")
	public CustomElement lsBeltInfo;

	@FindBy(locator = "xpath=//span[text()='Textile']")
	public CustomElement lsTextile;

	@FindBy(locator = "xpath=//span[text()='Conveying Solutions Technical Data Sheet']")
	public CustomElement txtBeltInfoTextileBreadCrumb;

	@FindBy(locator = "xpath=//span[text()='Steel']")
	public CustomElement lsSteel;

	@FindBy(locator = "xpath=//span[text()='Steelcord Belt Specification']")
	public CustomElement txtBeltInfoSteelBreadCrumb;


	public void navigateSteelCordListPage() {
		lsSpliceDesign.click();
		lsSteelCord.click();
		waitForPageLoad(5000);
		waitForElementVisible(txtSteelCordListHeader,5000,500);
		Validator.assertTrue(txtSteelCordListHeader.isVisible(),"Page is not redirected to SteelCord-list page","Redirected to SteelCord-list page");
		Validator.assertTrue(driver.getCurrentUrl().contains("secure/steel-cord/list"),"URL missMatch","URL validation passed");
	}
	public void navigateAddSteelCordPage() {
		btAdd.click();
		waitForPageLoad(5000);
		waitForElementVisible(txtSteelCordAddHeader,5000,500);
		Validator.assertTrue(txtSteelCordAddHeader.isVisible(),"Page is not redirected to SteelCord-Add page","Redirected to SteelCord-Add page");
		Validator.assertTrue(driver.getCurrentUrl().contains("secure/steel-cord/add"),"URL missMatch","URL validation passed");
	}

	public void createAndCalculateSteelCordSplice(String market,String spliceKit,String customerName,String conveyorName,String approverName,String beltRating,String beltWidth,String topCoverCompound,String bottomCoverCompound,String topCoverThickness,String bottomCoverThickness,String overAllBeltThickness,String cordDiameter,String cordPitch,String numberOfCords) {
	//	tbdesignerName.type(Designername);
		waitForPageLoad(10000);
		SyncUtil.waitFor(5000);
		dropdownSearchSelect(drchoosetyourmarket, tbInput, market);
		dropdownSearchSelect(drProductionLocationOfSplicekit, tbInput, spliceKit);
		dropdownSearchSelect(drCustomerName, tbInput, customerName);
		dropdownSearchSelect(drConveyorName, tbInput, conveyorName);
		dropdownSearchSelect(drBeltrating, tbInput, beltRating);
		tbBeltWidth.type(beltWidth);
		dropdownSelectSearchContains(drTopCoverCompound, tbInput, topCoverCompound);
		dropdownSearchSelect(drBottomCoverCompound, tbInput, bottomCoverCompound);
		Validator.assertTrue(tbdesignerName.getAttribute("value").contains(tbProfileName.getText()),"DesignerName Mismatch","DesignerName matches");
		dropdownSearchSelect(drTopCoverThickness, tbInput, topCoverThickness);
		dropdownSearchSelect(drBottomCoverThickness, tbInput, bottomCoverThickness);
		tbOverallThickness.type(overAllBeltThickness);
		tbCordDiameter.type(cordDiameter);
		tbCordPitch.type(cordPitch);
		tbNumberOfCords.type(numberOfCords);
		drBiasAngle.click();
		drBiasAngle22Deg.click();
		radioRegularSplice.jsClick();
		drApproverName.jsClick("Approver List");
		drApproverInput.type(approverName);
		SyncUtil.waitFor(5000);
		waitForElementVisible(driver.findElement(By.xpath("//ul[@aria-label='Option List']//li//span[text()='"+approverName+"']")),10000,500);
		driver.findElement(By.xpath("//ul[@aria-label='Option List']//li//span[text()='"+approverName+"']")).click();
		scrollPageDown();
		setImplicitWait(3000, TimeUnit.MILLISECONDS);
		waitForPageLoad(3000);

	}

	public void calculateBtnClick() {
		setImplicitWait(4000,TimeUnit.MILLISECONDS);
		waitForElementToBeClickable(btnCalculate);
		btnCalculate.jsClick("Calculate");
		}

	public void verifyPreviewTab() {
		waitForPageLoad(4000);
		scrollPageDown();
		Validator.assertTrue(previewTab.isVisible(10000,"Preview"),"The preview tab is not displayed after calculation","The preview tab is displayed after calculation");
	}

	public void verifyPreviewDesignHeaderForSteelCord(String beltWidth,String beltRating, String topCoverThickness, String bottomCoverThickness, String topCoverCompoundName) {
		SyncUtil.waitFor(40000);
		System.out.println(driver.findElement(By.xpath("(//div//h4[contains(normalize-space(), '" + beltWidth + " " + beltRating + " " + topCoverThickness + " + " + bottomCoverThickness + " " + topCoverCompoundName + " (2-B Stage (N-11)/6)')])[1]")));
		Validator.assertTrue(driver.findElement(By.xpath("(//div//h4[contains(normalize-space(), '" + beltWidth + " " + beltRating + " " + topCoverThickness + " + " + bottomCoverThickness + " " + topCoverCompoundName + " (2-B Stage (N-11)/6)')])[1]")).isDisplayed(),"The preview tab for design has in-correct header","The preview tab for design has correct header");
	}
	public void verifyPreviewDesignDimensionForSteelCord(String noOfSteps,String beltWidth,String overallThickness,String splicePattern,String spliceType,String numberOfRepeatsA,String numberOfRepeatsB,String coverCut, String cordButtGap, String transitionLength, String biasLength, String biasAngle,String stepLength,String spliceLength,String overallSpliceLength) {
		SyncUtil.waitFor(5000);
		getBundle().setProperty("spliceDrawingNumber",spliceDrawingNumberVal.getAttribute("value"));
		scrollPageDown();
		scrollPageDown();
		Validator.assertTrue(previewTabImg.isVisible(10000,"Preview"),"The preview tab Img is not displayed after calculation","The preview tab Img is displayed after calculation");
		noOfStepsVal.isVisible(10000, "No Of Steps");
//		Validator.assertTrue(noOfStepsVal.getAttribute("value").equalsIgnoreCase(noOfSteps), "The No Of Steps value is in-correct", "The No Of Steps value is correct");
		Validator.assertTrue(beltWidthVal.getAttribute("value").equalsIgnoreCase(beltWidth), "The Belt width value is in-correct", "The Belt width value is correct");
		Validator.assertTrue(overallBeltThicknessVal.getAttribute("value").equalsIgnoreCase(overallThickness), "The Belt Thickness value is in-correct", "The Belt Thickness value is correct");
//		Validator.assertTrue(splicePatternVal.getAttribute("value").equalsIgnoreCase(splicePattern), "The Splice Pattern value is in-correct", "The Splice Pattern value is correct");
//		Validator.assertTrue(spliceTypeVal.getAttribute("value").equalsIgnoreCase(spliceType), "The step Splice Type value is in-correct", "The Splice Type value is correct");
		Validator.assertTrue(numberOfRepeatsAVal.getAttribute("value").equalsIgnoreCase(numberOfRepeatsA), "The Number Of Repeats A value is in-correct", "The Number Of Repeats A value is correct");
		Validator.assertTrue(numberOfRepeatsBVal.getAttribute("value").equalsIgnoreCase(numberOfRepeatsB), "The Number Of Repeats B value is in-correct", "The Number Of Repeats B value is correct");
		Validator.assertTrue(coverCutVal.getAttribute("value").equalsIgnoreCase(coverCut), "The No Of Steps value is in-correct", "The No Of Steps value is correct");
		Validator.assertTrue(cordButtGapVal.getAttribute("value").equalsIgnoreCase(cordButtGap), "The Belt width value is in-correct", "The Belt width value is correct");
		Validator.assertTrue(transitionLengthVal.getAttribute("value").equalsIgnoreCase(transitionLength), "The OverAll Thickness value is in-correct", "The OverAll Thickness value is correct");
		Validator.assertTrue(biasLengthVal.getAttribute("value").equalsIgnoreCase(biasLength), "The bias Length value is in-correct", "The bias Length value is correct");
		Validator.assertTrue(biasAngleVal.getAttribute("value").equalsIgnoreCase(biasAngle), "The bias Angle value is in-correct", "The bias Angle value is correct");
		Validator.assertTrue(stepLengthVal.getAttribute("value").equalsIgnoreCase(stepLength), "The step Length value is in-correct", "The step Length value is correct");
		Validator.assertTrue(spliceLengthVal.getAttribute("value").equalsIgnoreCase(spliceLength), "The splice Length value is in-correct", "The splice Length value is correct");
		System.out.println(overallSpliceLengthVal.getAttribute("value")+"value"+overallSpliceLength);
		Validator.assertTrue(overallSpliceLengthVal.getAttribute("value").equalsIgnoreCase(overallSpliceLength), "The OverAll splice Length value is in-correct", "The OverAll splice Length value is correct");
	}
	public void verifyPreviewDesignTableAndNoteForSteelCord(String cordDiameterBelt,String cordDiameterSplice,String noOfCordsBelt,String noOfCordsSplice,String cordSpacingBelt,String cordSpacingSplice,String cordPitchBelt,String cordPitchSplice,String allDimension) {
		Validator.assertTrue(cordDiameterBeltVal.getText().equalsIgnoreCase(cordDiameterBelt), "The Cord Diameter Belt value is in-correct", "The Cord Diameter Bel value is correct");
		Validator.assertTrue(cordDiameterSpliceVal.getText().equalsIgnoreCase(cordDiameterSplice), "The Cord Diameter Splice value is in-correct", "The Cord Diameter Splice value is correct");
		Validator.assertTrue(noOfCordsBeltVal.getText().equalsIgnoreCase(noOfCordsBelt), "The No Of Cords Belt value is in-correct", "The No Of Cords Belt value is correct");
		Validator.assertTrue(noOfCordsSpliceVal.getText().equalsIgnoreCase(noOfCordsSplice), "The No Of Cords Splice value is in-correct", "The No Of Cords Splice value is correct");
		Validator.assertTrue(cordSpacingBeltVal.getText().equalsIgnoreCase(cordSpacingBelt), "The Cord Spacing Belt is in-correct", "The Cord Spacing Belt value is correct");
		Validator.assertTrue(cordSpacingSpliceVal.getText().equalsIgnoreCase(cordSpacingSplice), "The Cord Spacing Splice value is in-correct", "The Cord Spacing Splice value is correct");
		Validator.assertTrue(cordPitchBeltVal.getText().equalsIgnoreCase(cordPitchBelt), "The Cord Pitch Belt value is in-correct", "The Cord Pitch Belt value is correct");
		Validator.assertTrue(cordPitchSpliceVal.getText().equalsIgnoreCase(cordPitchSplice), "The Cord Pitch Splice value is in-correct", "The Cord Pitch Splice value is correct");
		Validator.assertTrue(allDimensionVal.getAttribute("value").equalsIgnoreCase(allDimension), "The All Dimension value is in-correct", "The All Dimension value is correct");
		Validator.assertTrue(additionalNotesLabel.isDisplayed(), "The Additional Notes is not visible", "The Additional Notes is visible");
	}
	public void verifyPreviewVulcanizationForSteelCord(String temperature,String pressure,String valcanizationTime) {
		Validator.assertTrue(tbVulcanizationChartHeader.isDisplayed(),"Vulcanization Chart Tab is not visible","Vulcanization Chart Tab is visible");
		tbVulcanizationChartHeader.click();
		waitForPageLoad(5000);
		SyncUtil.waitFor(5000);
		waitForElementVisible(vulcanizationChartImg,10000,1000);
		Validator.assertTrue(vulcanizationChartHeader.isDisplayed(),"Vulcanization Chart Header is not visible","Vulcanization Chart Header is visible");
		Validator.assertTrue(vulcanizationChartImg.isDisplayed(),"Vulcanization Chart Image is not visible","Vulcanization Chart Image is visible");
		Validator.assertTrue(crossSectionalViewHeader.isDisplayed(),"Vulcanization Chart Header is not visible","Vulcanization Chart Header is visible");
		Validator.assertTrue(crossSectionalViewImg.isDisplayed(),"Vulcanization Chart Image is not visible","Vulcanization Chart Image is visible");
		Validator.assertTrue(vulcanizationParamHeader.isDisplayed(),"Vulcanization Param Header is not visible","Vulcanization Param Header is visible");
		Validator.assertTrue(temperatureVal.getAttribute("value").equalsIgnoreCase(temperature), "The Temperature value is in-correct", "The Temperature value is correct");
		Validator.assertTrue(pressureVal.getAttribute("value").equalsIgnoreCase(pressure), "The Pressure value is in-correct", "The Pressure value is correct");
		System.out.println(vulcanizationTimeVal.getAttribute("value")+valcanizationTime);
		Validator.assertTrue(vulcanizationTimeVal.getAttribute("value").equalsIgnoreCase(valcanizationTime), "The Valcanization Time value is in-correct", "The Valcanization Time value is correct");
	}
	public void verifyPreviewCommentLogForSteelCord() {
		Validator.assertTrue(tbCommentsLogHeader.isDisplayed(),"Vulcanization Chart Tab is not visible","Vulcanization Chart Tab is visible");
		tbCommentsLogHeader.click();
		waitForPageLoad(2000);
		Validator.assertTrue(designerCommentHeader.isDisplayed(),"Designer Comment Chart Header is not visible","Designer Comment Chart Header is visible");
		Validator.assertTrue(txtDesignerComment.isDisplayed(),"Comment Box is not visible","Comment Box is visible");
		Validator.assertTrue(btSendForReview.isDisplayed(),"Send For Review Button is not visible","Send For Review Button is visible");
	}

	public void saveDraftBtnClick() {
		btnSaveDraftButtonSteelCord.isVisible(10000, "save as draft");
		btnSaveDraftButtonSteelCord.click("Save As Draft");
		waitForPageLoad(4000);
//		waitForElementInvisible(btnLoader, 10000, 500);
	}

	public void commentLogClick() {
		commentsLogTab.isVisible(20000, "Comments Log");
		commentsLogTab.click();
		Validator.assertTrue(commentsLogHeader.isVisible(10000, "Comments Log Tab"), "User is not navigated to Comments Log Tab", "User is  navigated to Comments Log Tab");
	}
	public void approverCommentLogTabClick() {
		commentsLogTab.isVisible(20000, "Comments Log");
		commentsLogTab.click();
		Validator.assertTrue(approverCommentHeader.isVisible(10000, "Comments Log Tab"), "User is not navigated to Comments Log Tab", "User is  navigated to Comments Log Tab");
	}
	public void goToSteelCordScreenAndWait() {
		navigateSteelCordListPage();
		scrollPageDown();
		String val = "";
		for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(300); stop > System.nanoTime(); ) {
			if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
				break;
			}
			val = pagination.getText();
			SyncUtil.waitFor(20000);
		}
	}

	public void editRecord() {
		crCheckbox.check("Select Corporate");
		btActions.jsClick("Actions");
		waitForElementVisible(btEdit, 10000, 500);
		btEdit.jsClick("Edit");
	}

	public void verifyEditPageNavigationSteelCord() {
		waitForPageLoad(10000);
		SyncUtil.waitFor(6000);
		System.out.println(steelCordBreadcrumb.getText()+"steelCordBreadcrumb.getText()");
		waitForElementVisible(steelCordBreadcrumb,10000,1000);
		Validator.assertTrue(steelCordBreadcrumb.getText().contains("Tools\nSteel Cord Splice Generator\nEdit"), "User is not navigated to edit splice page", "User is  navigated to edit splice page");
	}

	public void clickAndVerifyCommentsLog(String comments) {
		commentLogClick();
		tbComments.isVisible(10000, "Comments tab");
		tbComments.type(comments);
	}
	public void clickAndVerifyApproverCommentsLog(String comments) {
		approverCommentLogTabClick();
		tbComments.isVisible(10000, "Comments tab");
		tbComments.type(comments);
	}
	public void btnReviewClick() {
		btnReview.isVisible(10000, "Review");
		btnReview.click("Review");
		waitForPageLoad(10000);
	}

	public void clickViewIcon(){
		waitForElementToDisplay(crCheckbox);
		waitForElementToDisplay(btviewicon);
		btviewicon.jsClick("View Details");
		waitForPageLoad(20000);
	}
	public void btnApproveClick() {
		btnApprove.isVisible(10000, "Review");
		btnApprove.click("Approve");
		waitForPageLoad(10000);
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
	public void verifyDownloadPDFSpliceDesign(String siteName,String conveyorName) {
		inspectionPage.downloadPDF();
		String reqFile=getBundle().getProperty("spliceDrawingNumber").toString()+"_Rev0.pdf";
		String designId=getBundle().getProperty("spliceDrawingNumber").toString();
		Validator.assertTrue(MiscUtils.checkDownloadedFiles(reqFile), "PDF report was not found", "PDF report was downloaded successfully");
		verifyPDFContentsSpliceDesign(reqFile,designId, siteName, conveyorName);
		MiscUtils.deleteDownloadedFiles(reqFile);
	}

	public void navigateBeltInfoSteelListPage() {
		lsBeltInfo.click();
		lsSteel.click();
		waitForPageLoad(5000);
		waitForElementVisible(txtBeltInfoSteelBreadCrumb,5000,500);
		Validator.assertTrue(txtBeltInfoSteelBreadCrumb.isVisible(),"Page is not redirected to Belt Info Steel page","Redirected to  Belt Info Steel page");
		Validator.assertTrue(driver.getCurrentUrl().contains("secure/form/belt-info-steel"),"URL missMatch","URL validation passed");
	}
	public void navigateBeltInfoTextileListPage() {
		lsBeltInfo.click();
		lsTextile.click();
		waitForPageLoad(5000);
		waitForElementVisible(txtBeltInfoTextileBreadCrumb,5000,500);
		Validator.assertTrue(txtBeltInfoTextileBreadCrumb.isVisible(),"Page is not redirected to Belt Info Textile page","Redirected to  Belt Info Textile page");
		Validator.assertTrue(driver.getCurrentUrl().contains("secure/form/belt-info-textile"),"URL missMatch","URL validation passed");
	}
}