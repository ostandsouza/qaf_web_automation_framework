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
//import com.web.component.DropDownListWithoutSearch;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	//QAFWebDriver driver;
    QAFWebDriverWait webDriverWait = new QAFWebDriverWait(driver, 90000);
    long implicitWait = Long.parseLong("2");

    public BasePage(){
        setImplicitWait(1, TimeUnit.SECONDS);
    }

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub
    }

    /**
     * @param element
     */
    public void waitForElementToDisplay(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     *
     * @param elements
     */
    public void waitForElementsToDisplay(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    /**
     * @param element
     */
    public void waitForElementToInvisible(WebElement element) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * @param element
     * @param timeOutInSeconds
     */
    public void waitForElementToInvisible(WebElement element, int timeOutInSeconds) {
        QAFWebDriverWait wdWait = new QAFWebDriverWait(driver, timeOutInSeconds);
        wdWait.until(invisibilityOfWebElementLocated(element));
    }

    /**
     * @param element
     */
    public void waitForElementToBeClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * @param locator
     */
    public void waitForPresenceOfElement(By locator) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * @param timeOutInSeconds
     * @param pollingEveryInMiliSec
     * @return
     */
    private QAFWebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
        QAFWebDriverWait wait = new QAFWebDriverWait(driver, timeOutInSeconds);
//        Duration pollingDuration = Duration.of(pollingEveryInMiliSec, ChronoUnit.MILLIS);
        wait.pollingEvery(pollingEveryInMiliSec,TimeUnit.MILLISECONDS);
        wait.ignoring(java.util.NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }

    /**
     * @param timeout
     * @param unit
     */
    public void setImplicitWait(long timeout, TimeUnit unit) {
        Reporter.log("timeout[{}]");
        unit = unit == null ? TimeUnit.SECONDS : unit;
        driver.manage().timeouts().implicitlyWait(unit.toMillis(timeout), TimeUnit.MILLISECONDS);

    }

    public void waitForElementVisible(WebElement elem, int timeOutInSeconds, int pollingEveryInMiliSec) {
        Reporter.log("locator[{}]");
        setImplicitWait(1, TimeUnit.SECONDS);
        QAFWebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
        wait.until(ExpectedConditions.visibilityOf(elem));
        setImplicitWait(implicitWait, TimeUnit.SECONDS);
    }

    public void waitForElementInvisible(WebElement elem, int timeOutInSeconds, int pollingEveryInMiliSec) {
        setImplicitWait(1, TimeUnit.SECONDS);
        QAFWebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
        wait.until(ExpectedConditions.invisibilityOf(elem));
        setImplicitWait(implicitWait, TimeUnit.SECONDS);
    }

    private static ExpectedCondition<Boolean> invisibilityOfWebElementLocated(final WebElement element) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                boolean notDisplayed = true;
                try {
                    notDisplayed = !element.isDisplayed();
                } catch (Exception e) {
                    Reporter.log("invisible");
                }
                return notDisplayed;
            }
        };
    }

    /**
     * @param timeOutInMiliSec
     */
    public void hardWait(int timeOutInMiliSec) {
        Reporter.log("timeOutInMiliSec[{}]");
        try {
            Thread.sleep(timeOutInMiliSec);
        } catch (InterruptedException e) {
            Reporter.log("InterruptedException occured. Error[{}]", MessageTypes.valueOf(e.getMessage()));
        }
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

    public void scrollToElemet(WebElement element) {
        Reporter.log("element[{}]");
        executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
    }

    public void scrollIntoView(WebElement element) {
        Reporter.log("element[{}]");
        executeScript("arguments[0].scrollIntoView()", element);
    }

    public Object executeScript(String script, Object... args) {
        Reporter.log("script[{}]");
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script, args);
    }
    
    public void dropdownselectsearch(CustomElement dropDownButton, CustomElement Search, String itemstosearch) {
		dropDownButton.click();
		Search.type(itemstosearch);
		SyncUtil.waitFor(7000);
		driver.findElement("//span[text()='"+itemstosearch+"']").click();
		Reporter.log(itemstosearch +" is selected", MessageTypes.Pass );
	}
    
}
