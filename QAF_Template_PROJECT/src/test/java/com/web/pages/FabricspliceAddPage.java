package com.web.pages;


import java.util.List;
import java.util.concurrent.TimeUnit;
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

	@FindBy(locator = "xpath=(//div[@class='p-fluid'])[6]")
	public CustomElement drChooseyourmarket;
	//WebElement drChooseyourmarketvalue = driver.findElement(By.xpath("//li[@class='p-dropdown-item p-ripple']"));
	
	@FindBy(locator = "xpath=//p-dropdownitem[@ng-reflect-label='APAC']")
	public CustomElement drChooseyourmarketAPAC;

	@FindBy(locator = "xpath=////span[text()='APAC']")
	public CustomElement selectvalueAPAC;
	
	@FindBy(locator = "xpath=(//div[@class='p-fluid'])[9]")
	public CustomElement drProductionLocationofSpliceKit;
	
	@FindBy(locator = "xpath=/html/body/app-root/app-layout/div/div[2]/div/app-fabric-add/div[2]/form/div[2]/div[4]/div[1]/div/app-master-data-picker/div/div/div/p-dropdown/div/div[3]/div[2]/ul/p-dropdownitem[4]/li")
	public CustomElement drProductionLocationofSpliceKitvalue;

	@FindBy(locator = "xpath=(//span[text()='Select'])[1]")
	public CustomElement drCustomerName;
	
	@FindBy(locator = "xpath=((//ul[@ng-reflect-ng-class='[object Object]'])[2]//li[1])[2]")
	public CustomElement drCustomerNamevalue;

	@FindBy(locator = "xpath=(//div[@ng-reflect-ng-class='[object Object]'])[16]")
	public CustomElement drConveyorName;
	
	@FindBy(locator = "xpath=(//li[@ng-reflect-ng-class='[object Object]'])[7]")
	public CustomElement drConveyorNamevalue;

	@FindBy(locator = "xpath=//span[@class='p-button-icon pi pi-chevron-down']")
	public CustomElement drApproverName;
	
	@FindBy(locator = "xpath=(//div[@class='ng-star-inserted'])[1]")
	public CustomElement drApproverNamevalue;

	@FindBy(locator = "xpath=//input[@id='normal']")
	public CustomElement radioNormal;

	@FindBy(locator = "xpath=//input[@id='reverse']")
	public CustomElement radioreverse;

	@FindBy(locator = "xpath=(//span[@class='p-radiobutton-icon'])[5]")
	public CustomElement radioLeftarrow;

	@FindBy(locator = "xpath=(//span[@class='p-radiobutton-icon'])[6]")
	public CustomElement radioRightarrow;

	@FindBy(locator = "xpath=(//div[@class='p-fluid'])[13]")
	public CustomElement drBeltConstruction;
	
	@FindBy(locator = "xpath=(//li[@class='p-dropdown-item p-ripple'])[1]")
	public CustomElement drBeltConstructionvalue;

	@FindBy(locator = "xpath=//input[@formcontrolname='beltWidth']")
	public CustomElement tbBeltwidth;

	@FindBy(locator = "xpath=(//div[@class='p-fluid'])[18]")
	public CustomElement drBeltTypeFabric;
	
	@FindBy(locator = "xpath=((//ul[@ng-reflect-ng-class='[object Object]'])[2]//li)[1]")
	public CustomElement drBeltTypeFabricvalue;

	@FindBy(locator = "xpath=(//div[@class='p-fluid'])[20]")
	public CustomElement drTopcovercompound;
	
	@FindBy(locator = "xpath=((//ul[@ng-reflect-ng-class='[object Object]'])[2]//li)[1]") 
	public CustomElement drTopcovercompoundvalue;

	@FindBy(locator = "xpath=(//div[@class='p-fluid'])[23]")
	public CustomElement drBottomcovercompound;
	
	@FindBy(locator = "xpath=(//p-dropdownitem[@ng-reflect-option='[object Object]'])[1]")
	public CustomElement drBottomcovercompoundvalue;

	@FindBy(locator = "xpath=(//div[@class='p-fluid'])[26]")
	public CustomElement drTopcoverthickness;
	
	@FindBy(locator = "xpath=(//li[@ng-reflect-ng-class='[object Object]'])[7]")
	public CustomElement drTopcoverthicknessvalue;

	@FindBy(locator = "xpath=(//div[@class='p-fluid'])[16]")
	public CustomElement drBottomcoverthickness;
	
	@FindBy(locator = "xpath=(//li[@ng-reflect-ng-class='[object Object]'])[7]")
	public CustomElement drBottomcoverthicknessvalue;

	@FindBy(locator = "xpath=//input[@type='number']")
	public CustomElement tboverallbeltthickness;
	
	@FindBy(locator = "xpath=//small[@class='p-inputgroup-error ng-star-inserted']")
	public CustomElement overallbeltthicknesserror;

	@FindBy(locator = "xpath=//span[@class='ng-tns-c82-76 p-dropdown-label p-inputtext ng-star-inserted']")
	public CustomElement drBaisangle;

	@FindBy(locator = "xpath=(//div[@class='p-fluid'])[25]")
	public CustomElement drSplicetype;

	@FindBy(locator = "xpath=//span[@class='ng-tns-c82-92 p-dropdown-label p-inputtext p-placeholder ng-star-inserted']")
	public CustomElement drEdge;

	@FindBy(locator = "xpath=(//span[@class='p-radiobutton-icon'])[7]")
	public CustomElement radioRegularsplice;

	@FindBy(locator = "xpath=(//span[@class='p-radiobutton-icon'])[8]")
	public CustomElement radioReducedservicesplice;

	@FindBy(locator = "xpath=//button[@class='p-mr-2 p-mb-2 p-button-secondary p-button p-component']")
	public CustomElement btClear;
	
	@FindBy(locator = "xpath=(//button[@type='button'])[3]")
	public CustomElement btclearNo;

	@FindBy(locator = "xpath=//button[@type='submit']")
	public CustomElement btCalculate;

	@FindBy(locator = "xpath=//button[@label='Save as a Draft']")
	public CustomElement btSaveasadraft;

	@FindBy(locator = "xpath=//p-button[@ng-reflect-label='Generate PDF']")
	public CustomElement btGeneratePDF;
	
	@FindBy(locator = "xpath=(//tr[@class='p-selectable-row conti-active-tr ng-star-inserted'])[1]")
	public CustomElement Draftrow;
	
	@FindBy(locator = "xpath=(//button[@icon='pi pi-eye'])[1]")
	public CustomElement viewicon;

	@FindBy(locator = "xpath=//*[@id=\"p-tabpanel-6\"]/div/div/app-fabric-step-result/div/form/div/div[2]/div/div[7]/div/textarea")
	public CustomElement taAdditionalnotes;
	
	@FindBy(locator = "xpath=//html/body/app-root/app-layout/div/div[2]/div/app-fabric-add/div[4]/div/p-panel/div/div[2]/div/p-tabview/div/div/p-tabpanel[1]/div/div/div/app-fabric-step-result/div/form/div/div[2]/div/div[7]/div/textarea")
	public CustomElement tadesignadditionalnotes;
	
	@FindBy(locator = "xpath=(//a[@class='p-tabview-nav-link p-ripple'])[1]")
	public CustomElement tabDesign;

	@FindBy(locator = "xpath=(//a[@class='p-tabview-nav-link p-ripple'])[2]")
	public CustomElement tabSplicekitBOM;

	@FindBy(locator = "xpath=(//a[@class='p-tabview-nav-link p-ripple'])[3]")
	public CustomElement tabCommentslog;

	@FindBy(locator = "xpath=/html/body/app-root/app-layout/div/div[2]/div/app-fabric-add/div[4]/div/p-panel/div/div[2]/div/p-tabview/div/div/p-tabpanel[3]/div/textarea")
	public CustomElement taDesignercomment;

	@FindBy(locator = "xpath=//button[@label='Send for review']")
	public CustomElement btsendforreview;

	@FindBy(locator = "xpath=(//div[@ng-reflect-ng-class='[object Object]'])[25]")
	public CustomElement checkbox;
	
	@FindBy(locator = "xpath=//span[@class='p-button-icon pi pi-chevron-down']")
	public CustomElement Actionsarrow;
	
	@FindBy(locator = "xpath=(//a[@class='p-menuitem-link ng-star-inserted'])[3]")
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
	
	@FindBy(locator = "xpath=//span[text()='Splice Print']")
	public CustomElement menuspliceprint;

	 @FindBy(locator = "xpath=//span[text()='Fabric Splice Generator']")
	 public CustomElement Fabricsplicelink;
	 
	 @FindBy(locator = "xpath=//span[@class='ng-star-inserted']")
	  public CustomElement lcolumnsselections;
	  
	 @FindBy(locator = "xpath=(//input[@formcontrolname='beltWidth'])[2]")
	 public CustomElement tbwidth;
	  
	  public void clickfabricsplicegenerator() {
		    SyncUtil.waitFor(5000);
		    menuspliceprint.click();
			Fabricsplicelink.click();
			}
	  
	  public void clickcolumnselection() {
		  lcolumnsselections.click();
	  }

	  public void Addbutton() {
		  SyncUtil.waitFor(3000);
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].style.border='4px groove blue'", btAdd);
		  btAdd.click();
	  }
	  
	  public void creationdate() {
		  SyncUtil.waitFor(3000);
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].style.border='4px groove blue'", thcreatedate);
	  }

	  public void Status() {
		  SyncUtil.waitFor(3000);
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].style.border='4px groove blue'", thApprovedStatus);
	  }

	  public void downloadicon() {
		  SyncUtil.waitFor(3000);
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].style.border='4px groove blue'", btDownload);
	  }
	  
	  
	  public void AutoDesignername() {
		  SyncUtil.waitFor(3000);
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].style.border='4px groove blue'", tbDesignerName);
	  }

      public void SpliceDesignDrawingNo() {
    	  SyncUtil.waitFor(3000);
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].style.border='4px groove blue'", tbSpliceDesigndrawingNo);
      }
      
      public void calculatebuttondisable() {
    	  SyncUtil.waitFor(3000);
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].style.border='4px groove blue'", btCalculate);
      }
      
      public void customername() {
    	  SyncUtil.waitFor(3000);
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].style.border='4px groove blue'", drCustomerName);
		  drCustomerName.click();
      }

      public void conveyorername() {
    	  SyncUtil.waitFor(3000);
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].style.border='4px groove blue'", drConveyorName);
		  drConveyorName.click();
      }
      
      public void Approvername() {
    	  SyncUtil.waitFor(3000);
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].style.border='4px groove blue'", drApproverName);
		  drApproverName.click();
      }
      
      public void clickonclear() {
    	  btClear.click();
      }

      public void clickonclearNO() {
    	  btclearNo.click();
      }
      
      public void clickoncalculate() {
    	  btCalculate.click();
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
    	  SyncUtil.waitFor(4000);
    	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	  drChooseyourmarket.click();
    	  //selectvalueAPAC.click();
    	 drChooseyourmarketAPAC.click();
    	 //selectdropdownvalue("(//div[@class='p-fluid'])[6]", "//p-dropdownitem[@class='ng-tns-c82-106 ng-star-inserted']","APAC");
    	 drProductionLocationofSpliceKit.click();
    	 drProductionLocationofSpliceKitvalue.click();
    	 drCustomerName.click();
    	 drCustomerNamevalue.click();
    	 SyncUtil.waitFor(2000);
    	 drConveyorName.click();
    	 drConveyorNamevalue.click();
    	 drApproverName.click();
    	 drApproverNamevalue.click();
    	 drBeltConstruction.click();
    	 drBeltConstructionvalue.click();
    	 tbBeltwidth.sendKeys("1200");
    	 drBeltTypeFabric.click();
    	 drBeltTypeFabricvalue.click();
    	 SyncUtil.waitFor(2000);
    	 drTopcovercompound.click();
    	 drTopcovercompoundvalue.click();
    	 drBottomcovercompound.click();
    	 drBottomcovercompoundvalue.click();
    	 drTopcoverthickness.click();
    	 drTopcoverthicknessvalue.click();
    	 drBottomcoverthickness.click();
    	 drBottomcoverthicknessvalue.click();
    	 tboverallbeltthickness.sendKeys("1");
    	 SyncUtil.waitFor(3000);
    	 tboverallbeltthickness.clear();
    	 tboverallbeltthickness.sendKeys("3");
    	 
    
      }
      
      public void Splicedrawingnovisible() {
    	  SyncUtil.waitFor(3000);
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].style.border='4px groove red'", tbSpliceDesigndrawingNo);
      }
      
      public void clickongeneratePDF() {
    	  SyncUtil.waitFor(3000);
    	  JavascriptExecutor js1 = (JavascriptExecutor)driver;
    	  js1.executeScript("window.scrollBy(0,500)", "");
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].style.border='4px groove red'", btGeneratePDF);
    	 // btGeneratePDF.click();
      }
      
      public void clickonsaveasadraft() {
    	  btSaveasadraft.click();
    	  SyncUtil.waitFor(5000);
      }
      
      public void DrafteSplicerow() {
    	  SyncUtil.waitFor(3000);
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].style.border='4px groove blue'", Draftrow);
      }
      public void clickonview() {
    	  viewicon.click();
    	  SyncUtil.waitFor(3000);
      }
      
      public void clickonsplicekitBOM() {
    	  SyncUtil.waitFor(3000);
    	  JavascriptExecutor js1 = (JavascriptExecutor)driver;
    	  js1.executeScript("window.scrollBy(0,500)", "");
    	  tabSplicekitBOM.click();
      }
      public void clickoncommentslog() {
    	  SyncUtil.waitFor(2000);
    	  tabCommentslog.click();
      }
      
      public void entercomments() {
    	  taDesignercomment.click();
    	  taDesignercomment.sendKeys("Please Review it.");
      }
      
      public void clickonsendforreview() {
    	  btsendforreview.click();
      }
      
      public void clickoncheckbox() {
    	  SyncUtil.waitFor(3000);
    	  checkbox.click();
    	  Actionsarrow.click();
      }
      
      public void clickonupdate() {
    	  lupdate.click();
      }
      
      public void enteradditionalnotes() {
    	  
    	  tabDesign.click();
    	  JavascriptExecutor js1 = (JavascriptExecutor)driver;
    	  js1.executeScript("window.scrollBy(0,1500)", "");
    	  taAdditionalnotes.click();
    	  taAdditionalnotes.sendKeys("Added additional notes");
    	 
      }
      
      public void clickonfabriclist() {
    	  lfabrickist.click();
      }
      
      public void fieldsshouldbeeditable() {
    	  JavascriptExecutor js1 = (JavascriptExecutor)driver;
    	  js1.executeScript("window.scrollBy(0,1700)", "");
    	  tadesignadditionalnotes.click();
    	  tadesignadditionalnotes.sendKeys("Approver Comments");
    	  
      }
      
      public void rejectapprove() {
    	  SyncUtil.waitFor(3000);
    	  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].style.border='4px groove red'", btreject);
		  JavascriptExecutor js2 = (JavascriptExecutor)driver;
		  js2.executeScript("arguments[0].style.border='4px groove red'", btapprove);
      }
      
      public void clickonapprove() {
    	  btapprove.click();
      }
      public void logout() {
    	  profilemenu.click();
    	  llogout.click();
      }
}
