package com.web.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;



public class FabricspliceAddPage extends BasePage{

	LoginPage lp =new LoginPage();
	
	
	@FindBy(locator = "xpath=//span[@class='p-button-icon ctp-icon-Add-circle']")
	public CustomElement btAdd;
	
	@FindBy(locator = "xpath=//th[@psortablecolumn='createdDate']")
	public CustomElement thcreatedate;
	
	@FindBy(locator = "xpath=//th[@psortablecolumn='status']")
	public CustomElement thApprovedStatus;
	
	
	@FindBy(locator = "xpath=//button[@icon='pi pi-download']")
	public CustomElement btDownload;

	@FindBy(locator = "xpath=//input[@name='date']")
	public CustomElement tbCreationDate;

	@FindBy(locator = "xpath=(//input[@name='drawing_num'])[1]")
	public CustomElement tbSpliceDesigndrawingNo;

	@FindBy(locator = "xpath=(//input[@name='drawing_num'])[2]")
	public CustomElement tbDesignerName;

	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='marketType']//div[2]")
	public CustomElement drChooseyourmarket;
	//WebElement drChooseyourmarketvalue = driver.findElement(By.xpath("//li[@class='p-dropdown-item p-ripple']"));
	
	@FindBy(locator = "xpath=//div[@ng-reflect-ng-class='p-dropdown-panel p-component']//input")
	public CustomElement tbinput;

	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='productionLocation']//div[2]")
	public CustomElement drProductionLocationofSpliceKit;
	
	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='customer']//div[2]")
	public CustomElement drCustomerName;

	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='conveyor']//div[2]")
	public CustomElement drConveyorName;

	@FindBy(locator = "xpath=//p-autocomplete[@ng-reflect-name='approverName']//button")
	public CustomElement drApproverName;

	public String drapproverlist = "xpath= //ul[contains(@class,'p-autocomplete-items')]//li//div//span";

	@FindBy(locator = "xpath=//input[@id='normal']")
	public CustomElement radioNormal;

	@FindBy(locator = "xpath=//input[@id='reverse']")
	public CustomElement radioreverse;

	@FindBy(locator = "xpath=(//span[@class='p-radiobutton-icon'])[5]")
	public CustomElement radioLeftarrow;

	@FindBy(locator = "xpath=(//span[@class='p-radiobutton-icon'])[6]")
	public CustomElement radioRightarrow;

	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='beltConstruction']//div[2]")
	public CustomElement drBeltConstruction;
	
	@FindBy(locator = "xpath=//input[@formcontrolname='beltWidth']")
	public CustomElement tbBeltwidth;

	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='beltFabric']//div[2]")
	public CustomElement drBeltTypeFabric;

	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='topCoverCompound']//div[2]")
	public CustomElement drTopcovercompound;
	
	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='bottomCoverCompound']//div[2]")
	public CustomElement drBottomcovercompound;

	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='topThickness']//div[2]")
	public CustomElement drTopcoverthickness;

	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='beltThickness']//div[2]")
	public CustomElement drBottomcoverthickness;

	@FindBy(locator = "xpath=//input[@type='number']")
	public CustomElement tboverallbeltthickness;
	
	@FindBy(locator = "xpath=//small[@class='p-inputgroup-error ng-star-inserted']")
	public CustomElement overallbeltthicknesserror;

	@FindBy(locator = "xpath=//span[@class='ng-tns-c82-76 p-dropdown-label p-inputtext ng-star-inserted']")
	public CustomElement drBaisangle;

	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='spliceType']//div[2]")
	public CustomElement drSplicetype;

	@FindBy(locator = "xpath=//p-dropdown[@ng-reflect-name='edge']//div[2]")
	public CustomElement drEdge;

	@FindBy(locator = "xpath=(//span[@class='p-radiobutton-icon'])[7]")
	public CustomElement radioRegularsplice;

	@FindBy(locator = "xpath=(//span[@class='p-radiobutton-icon'])[8]")
	public CustomElement radioReducedservicesplice;

	@FindBy(locator = "xpath=//span[text()='Clear']")
	public CustomElement btClear;
	
	@FindBy(locator = "xpath=//span[text()='No']")
	public CustomElement btclearNo;

	@FindBy(locator = "xpath=//button[@ng-reflect-label='Calculate']")
	public CustomElement btCalculate;

	@FindBy(locator = "xpath=//button[@label='Save as a Draft']")
	public CustomElement btSaveasadraft;

	@FindBy(locator = "xpath=//button[@ng-reflect-label='Generate PDF']")
	public CustomElement btGeneratePDF;
	
	@FindBy(locator = "xpath=(//tr[@class='p-selectable-row conti-active-tr ng-star-inserted'])[1]")
	public CustomElement Draftrow;
	
	@FindBy(locator = "xpath=(//button[@icon='pi pi-eye'])[1]")
	public CustomElement viewicon;

	@FindBy(locator = "xpath=//textarea[@ng-reflect-name='addNotes']")
	public CustomElement taAdditionalnotes;

	
	@FindBy(locator = "xpath=//span[text()='Design']")
	public CustomElement tabDesign;

	@FindBy(locator = "xpath=//span[text()='Splice Kit BOM']")
	public CustomElement tabSplicekitBOM;

	@FindBy(locator = "xpath=//span[text()='Comments Log']")
	public CustomElement tabCommentslog;

	@FindBy(locator = "xpath=//textarea[contains(@class,'p-inputtextarea p-inputtext')]")
	public CustomElement taDesignercomment;

	@FindBy(locator = "xpath=//button[@label='Send for review']")
	public CustomElement btsendforreview;

	@FindBy(locator = "xpath=(//div[@class='p-checkbox-box p-component'])[1]")
	public CustomElement checkbox;
	
	@FindBy(locator = "xpath=//button[@ng-reflect-icon='pi pi-chevron-down']")
	public CustomElement Actionsarrow;
	
	@FindBy(locator = "xpath=//span[text()='Edit']")
	public CustomElement lupdate;
	
	@FindBy(locator = "xpath=//*[@id=\"p-tabpanel-0\"]/div/div/app-fabric-step-result/div/form/div/div[2]/div/div[7]/div/textarea")
	public CustomElement tadesignAdditionalnotes;
	
	@FindBy(locator = "xpath=(//a[@class='p-menuitem-link ng-star-inserted'])[2]")
	public CustomElement lfabrickist;
	
	@FindBy(locator = "xpath=//button[@label='Reject']")
	public CustomElement btreject;
	
	@FindBy(locator = "xpath=//button[@label='Approve']")
	public CustomElement btapprove;
	
	@FindBy(locator = "xpath=/html/body/app-root/app-layout/div/app-top-menu/div/div/div[2]/ul/li[4]/a/div/span")
	public CustomElement profilemenu;
	
	@FindBy(locator = "xpath=/html/body/app-root/app-layout/div/app-top-menu/div/div/div[2]/ul/li[4]/ul/li[5]/a/h6")
	public CustomElement llogout;
	
	@FindBy(locator = "id=email")
	public CustomElement tbUserName;

	@FindBy(locator = "css=#password > div > input")
	public CustomElement tbPassword;

	@FindBy(locator = "xpath=//span[text()='Login']")
	public CustomElement btnLogIn;
	
	@FindBy(locator = "xpath=//span[text()='Splice Design']")
	public CustomElement menuspliceprint;

	 @FindBy(locator = "xpath=//span[text()='Fabric']")
	 public CustomElement Fabricsplicelink;
	 
	 @FindBy(locator = "xpath=//span[@class='ng-star-inserted']")
	  public CustomElement lcolumnsselections;
	  
	 @FindBy(locator = "xpath=(//input[@formcontrolname='beltWidth'])[2]")
	 public CustomElement tbwidth;
	  
	  public void clickfabricsplicegenerator() {
		    waitForPageLoad(5000);
		    menuspliceprint.click();
			Fabricsplicelink.click();
			}
	  
	  public void clickcolumnselection() {
		  lcolumnsselections.click();
	  }

	  public void Addbutton() {
	     btAdd.click();
	  }
	         
      
      public void customername() {
		  drCustomerName.click();
      }

      public void conveyorername() {
    	
		  drConveyorName.click();
      }
      
      public void Approvername() {
    			  drApproverName.click();
      }
      
      public void clickonclear() {
    	  btClear.click();
      }

      public void clickonclearNO() {
    	  btclearNo.click();
      }
      
      public void clickoncalculate() {
    	  waitForPageLoad(6000);
    	  btCalculate.click();
    	  waitForPageLoad(10000);
      }
      
      public void selectvalue(WebElement value) {
    	  Select s = new Select(value);
    	  s.selectByIndex(1);
      }
      
     public  void selectdropdownvalue(String dropdown, String dropdownvalues, String value) {
    	  
    	  WebElement dropdownWebElement = driver.findElement(By.xpath(dropdown));
    	  dropdownWebElement.click();
    	  
    	  List<WebElement> WebElementValues = driver.findElements(By.xpath(dropdownvalues));
    	  for (WebElement webElementvalue : WebElementValues) {
			if(webElementvalue.getText().equals(value))
			{
				webElementvalue.click();
				break;
			}
		}
      }
      
     
     public void errortext() {
   	  SyncUtil.waitFor(3000);
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].style.border='4px groove blue'", overallbeltthicknesserror);
     }
      public void inputdata() {
    	  waitForPageLoad(5000);
    	  dropdownSelectSearch(drChooseyourmarket, tbinput, "APAC");
    	  dropdownSelectSearch(drProductionLocationofSpliceKit, tbinput, "Moers");
    	  dropdownSelectSearch(drCustomerName, tbinput, "SiteAsia");
    	  dropdownSelectSearch(drConveyorName, tbinput, "rfb1");
    	  dropdownSelect(drApproverName, drapproverlist, "Test Approver 1.FS");
    	  dropdownSelectSearch(drBeltConstruction, tbinput, "ContiFlex");
    	  tbBeltwidth.type("1200");
    	  dropdownSelectSearch(drBeltTypeFabric, tbinput, "EP800/5");
    	  dropdownSelectSearch(drTopcovercompound, tbinput, "ARCTIC GOLD");
    	  dropdownSelectSearch(drBottomcovercompound, tbinput, "DEFENDER Y");
    	  dropdownSelectSearch(drTopcoverthickness, tbinput, "7");
    	  dropdownSelectSearch(drBottomcoverthickness, tbinput, "6");
    	  tboverallbeltthickness.type("10");
    	  tboverallbeltthickness.type("20");
    	  
    	   
      }
      
      public void inputdataD() {
    	  waitForPageLoad(5000);
    	  dropdownSelectSearch(drChooseyourmarket, tbinput, "APAC");
    	  dropdownSelectSearch(drProductionLocationofSpliceKit, tbinput, "Jorf");
    	  dropdownSelectSearch(drCustomerName, tbinput, "Mining Corp. China");
    	  dropdownSelectSearch(drConveyorName, tbinput, "do not delete");
    	  dropdownSelect(drApproverName, drapproverlist, "Test Approver 1.FS");
    	  dropdownSelectSearch(drBeltConstruction, tbinput, "ContiFlex");
    	  tbBeltwidth.type("1200");
    	  dropdownSelectSearch(drBeltTypeFabric, tbinput, "EP800/5");
    	  dropdownSelectSearch(drTopcovercompound, tbinput, "ARCTIC GOLD");
    	  dropdownSelectSearch(drBottomcovercompound, tbinput, "DEFENDER Y");
    	  dropdownSelectSearch(drTopcoverthickness, tbinput, "7");
    	  dropdownSelectSearch(drBottomcoverthickness, tbinput, "6");
    	  tboverallbeltthickness.type("10");
    	  tboverallbeltthickness.type("20");
    	  
    	   
      }
      
      public void clickongeneratePDF() {
    	  
           btGeneratePDF.click();
           waitForPageLoad(5000);
      }
      
      public void clickonsaveasadraft() {
    	  btSaveasadraft.click();
    	  SyncUtil.waitFor(5000);
      }
      
     
      public void clickonview() {
    	  viewicon.click();
    	  SyncUtil.waitFor(3000);
      }
      
      public void clickonsplicekitBOM() throws Throwable {
    	 waitForPageLoad(4000);
    
    	  tabSplicekitBOM.click();
    	  scrollPageDown();
      }
      public void clickoncommentslog() {
          waitForPageLoad(4000);
    	  tabCommentslog.click();
      }
      
      public void entercomments() {
    	  tabDesign.click();
    	  taDesignercomment.click();
    	  taDesignercomment.sendKeys("Please Review it.");
      }
      
      public void clickonsendforreview() {
    	  btsendforreview.click();
      }
      
      public void clickoncheckbox() {
    	
    	  checkbox.click();
    	  Actionsarrow.click();
      }
      
      public void clickonupdate() {
    	  lupdate.click();
      }
      
      public void enteradditionalnotes() throws Throwable {
    	  tabDesign.click();
    	  scrollPageDown();
    	  scrollPageDown();
    	  taAdditionalnotes.click();
    	  taAdditionalnotes.type("Added additional notes");
    	 
      }
      
      public void clickonfabriclist() {
    	  lfabrickist.click();
      }
      
      public void fieldsshouldbeeditable() throws Throwable {
    	  scrollPageDown();
    	  taAdditionalnotes.click();
    	  taAdditionalnotes.sendKeys("Approver Comments");
    	  scrollPageup();
      }
      
     
      public void clickonapprove() {
    	  btapprove.click();
      }
      public void logout() {
    	  profilemenu.click();
    	  llogout.click();
      }
}
