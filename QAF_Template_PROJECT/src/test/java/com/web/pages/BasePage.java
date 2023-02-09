package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.util.QAFWebDriverExpectedConditions;
import com.qmetry.qaf.automation.ui.util.QAFWebDriverWait;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.component.DropDownListWithoutSearch;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;


public class BasePage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	//QAFWebDriver driver;

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub
    }

    public String getCurrentURL() {
        return this.driver.getCurrentUrl();
    }

    public void verifyTitle(String title) {
        if (this.driver.getTitle().equalsIgnoreCase(title))
            Reporter.log(title + "is verified", MessageTypes.Pass);
        else
            Reporter.log(title + "is not verified", MessageTypes.Fail);
            }

    public void waitForPageLoad(long timeout) {
        try {
            String script = "var func=function(){var result=false;if(!!window.jQuery){if(jQuery.active==0){result=true;}}else{result=true;}return result;};return(document.readyState=='complete' && func());";
            new QAFWebDriverWait(timeout).ignoring(NoSuchElementException.class, RuntimeException.class).withMessage("Wait time out for Page load.")
                    .until(QAFWebDriverExpectedConditions.jsCondition(script));
        } catch (Exception ignore) {
            ignore.printStackTrace();

        }
    }
    
    public void verifyURL(String url) {
    	
		if (this.getCurrentURL().endsWith(url)) 
			Reporter.log(url + "is verified", MessageTypes.Pass);
        else
            Reporter.log(url + "is not verified", MessageTypes.Fail);
			
    }
    
    public static String randomestring() {
    	String generatedString1 = RandomStringUtils.randomAlphabetic(4);
    	return (generatedString1);
    			
    }
    
    public void scrollPageDown() throws Throwable {
    	Thread.sleep(5000);
    	((JavascriptExecutor)driver).executeScript("scroll(0,800)");
    }

    public void scrollPageup() throws Throwable {
    	Thread.sleep(5000);
    	((JavascriptExecutor)driver).executeScript("scroll(0,-500)");
    }
   
    public void dropdownselect(CustomElement dropDownButton, String dropDownItems, String itemText) {
    	
    	dropDownButton.click();
    	
    		List<QAFWebElement> Options = driver.findElements(dropDownItems);
	       //  waitForPageLoad(4000);
			for(WebElement ele:Options) {
				String value = ele.getAttribute("innerText");
				if(	value.equalsIgnoreCase(itemText)) {
					ele.click();
					Reporter.log(ele +" is selected", MessageTypes.Pass);
					break;
				}
			}
    }
		
    
    public void dropdownselectsearch(CustomElement dropDownButton, CustomElement Search, String itemstosearch) {
		dropDownButton.click();
		Search.type(itemstosearch);
		SyncUtil.waitFor(7000);
		driver.findElement("//span[text()='"+itemstosearch+"']").click();
		Reporter.log(itemstosearch +" is selected", MessageTypes.Pass );
	}
    
}
