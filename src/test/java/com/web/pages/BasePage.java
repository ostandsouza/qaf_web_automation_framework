package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.APIBase;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.util.QAFWebDriverExpectedConditions;
import com.qmetry.qaf.automation.ui.util.QAFWebDriverWait;
import com.qmetry.qaf.automation.util.Reporter;
//import com.web.component.DropDownListWithoutSearch;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BasePage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	//QAFWebDriver driver;
    QAFWebDriverWait webDriverWait = new QAFWebDriverWait(driver, 90000);
    long implicitWait = Long.parseLong("2");

    public APIBase apiBase = new APIBase();

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
        try{
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            logger.error("exception occured");
        }
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
        try{
            setImplicitWait(2000, TimeUnit.MILLISECONDS);
            QAFWebDriverWait wdWait = new QAFWebDriverWait(driver, timeOutInSeconds);
            wdWait.until(invisibilityOfWebElementLocated(element));
            setImplicitWait(5000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            logger.error("exception occured");
        }
    }

    /**
     * @param element
     */
    public void waitForElementToBeClickable(WebElement element) {
        try{
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logger.error("exception occured: "+e);
        }
    }

    /**
     * @param locator
     */
    public void waitForPresenceOfElement(By locator) {
        try{
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            logger.error("exception occurred: "+e);
        }
    }

    /**
     * @param locator
     */
    public void waitForElementToBeClickable(By locator) {
        try{
            webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            logger.error("exception occured: "+e);
        }
    }

    /**
     * @param locator
     */
    public void waitForPresenceOfElements(By locator) {
        try{
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            logger.error("exception occurred: "+e);
        }
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
//        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }

    /**
     * @param timeout
     * @param unit
     */
    public void setImplicitWait(long timeout, TimeUnit unit) {
        unit = unit == null ? TimeUnit.SECONDS : unit;
        driver.manage().timeouts().implicitlyWait(unit.toMillis(timeout), TimeUnit.MILLISECONDS);
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(timeout));
    }

    public void waitForElementVisible(WebElement elem, int timeOutInSeconds, int pollingEveryInMiliSec) {
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
                    System.out.println("invisible");
                }
                return notDisplayed;
            }
        };
    }

    public boolean isLocatorVisible(final By element) {
        boolean notDisplayed = false;
        try {
            notDisplayed = !driver.findElement(element).isDisplayed();
        } catch (Exception e) {
            System.out.println("invisible");
        }
        return notDisplayed;
    }

    /**
     * @param timeOutInMiliSec
     */
    public void hardWait(int timeOutInMiliSec) {
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
    
    public void scrollPageDown(){
        SyncUtil.waitFor(1000);
    	((JavascriptExecutor)driver).executeScript("scroll(0,800)");
        SyncUtil.waitFor(1000);
    }

    public void scrollPageup(){
        SyncUtil.waitFor(1000);
    	((JavascriptExecutor)driver).executeScript("scroll(0,-500)");
        SyncUtil.waitFor(1000);
    }
   
    public void dropdownSelect(CustomElement dropDownButton, String dropDownItems, String itemText) {
    	
    	dropDownButton.click();
        setImplicitWait(15000,TimeUnit.MILLISECONDS);
        SyncUtil.waitFor(300);
        waitForPresenceOfElements(By.xpath(dropDownItems));
        List<WebElement> Options = driver.findElements(By.xpath(dropDownItems));
        for(WebElement ele:Options) {
            waitForElementToBeClickable(ele);
            String value = ele.getAttribute("innerText");
            if(	value.equalsIgnoreCase(itemText)) {
                ele.click();
                Reporter.log(ele +" is selected", MessageTypes.Pass);
                break;
            }
        }
        setImplicitWait(5000,TimeUnit.MILLISECONDS);
    }

    public void scrollToElemet(WebElement element) {
        executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
    }

    public void scrollIntoView(WebElement element) {
        executeScript("arguments[0].scrollIntoView()", element);
    }

    public Object executeScript(String script, Object... args) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script, args);
    }

    public void dropdownSelectSearch(CustomElement dropDownButton, CustomElement Search, String itemstosearch) {
        waitForElementVisible(dropDownButton,10000,500);
        waitForElementToBeClickable(dropDownButton);
        setImplicitWait(20000,TimeUnit.MILLISECONDS);
        dropDownButton.jsClick("dropdown");
        waitForElementToBeClickable(dropDownButton);
        SyncUtil.waitFor(100);
        Search.type(itemstosearch);
        setImplicitWait(60000,TimeUnit.MILLISECONDS);
        waitForPresenceOfElement(By.xpath("//span[text()='"+itemstosearch+"']"));
        driver.findElement("//span[text()='"+itemstosearch+"']").click();
//        waitForPresenceOfElement(By.xpath("//li/span[1]"));
//        driver.findElement("//li/span[1]").click();
        setImplicitWait(1000,TimeUnit.MILLISECONDS);
        Reporter.log(itemstosearch +" is selected", MessageTypes.Pass );
    }

    public void dropdownSelectSearchContains(CustomElement dropDownButton, CustomElement Search, String itemstosearch) {
        waitForElementVisible(dropDownButton,10000,500);
        waitForElementToBeClickable(dropDownButton);
        setImplicitWait(20000,TimeUnit.MILLISECONDS);
        dropDownButton.jsClick("dropdown");
        waitForElementToBeClickable(dropDownButton);
        SyncUtil.waitFor(100);
        Search.type(itemstosearch);
        setImplicitWait(60000,TimeUnit.MILLISECONDS);
//        waitForPresenceOfElement(By.xpath("//span[contains(text(),'"+itemstosearch+"')]"));
//        driver.findElement("//span[contains(text(),'"+itemstosearch+"')]").click();
        waitForPresenceOfElement(By.xpath("//li/span[1]"));
        driver.findElement("//li/span[1]").click();
        setImplicitWait(1000,TimeUnit.MILLISECONDS);
        Reporter.log(itemstosearch +" is selected", MessageTypes.Pass );
    }

    public void dropdownSearch(CustomElement dropDownButton, CustomElement Search, String itemstosearch) {
        dropDownButton.click();
        waitForElementToBeClickable(dropDownButton);
        SyncUtil.waitFor(100);
        Search.type(itemstosearch);
        setImplicitWait(70000,TimeUnit.MILLISECONDS);
        SyncUtil.waitFor(5000);
        setImplicitWait(150000,TimeUnit.MILLISECONDS);
        waitForPresenceOfElement(By.xpath("//span[text()='"+itemstosearch+"']"));
        driver.findElement("//span[text()='"+itemstosearch+"']").click();
        setImplicitWait(1000,TimeUnit.MILLISECONDS);
        Reporter.log(itemstosearch +" is selected", MessageTypes.Pass );
    }

    public void browserRefresh() {
        driver.navigate().refresh();
        SyncUtil.waitFor(2000);
    }

    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void cropImage(WebElement element) {
        Actions crop = new Actions(driver);
        crop.dragAndDropBy(element, -50,-100).perform();
    }

    public void clickAtPosition(WebElement imageElement, int xCoordinate, int yCoordinate) {
        Actions actions = new Actions(driver);
        actions.moveToElement(imageElement, xCoordinate, yCoordinate).click().build().perform();
    }

    public void browserBack() {
        driver.navigate().back();
    }

    public void dragAndDrop(WebElement fromElement, WebElement toElement) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(fromElement)
                .moveToElement(toElement)
                .release()
                .build()
                .perform(); // Perform the action chain
    }

    public void dropdownSearchSelect(CustomElement dropDownButton, CustomElement Search, String itemstosearch) {
        dropDownButton.jsClick();
        SyncUtil.waitFor(100);
        Search.type(itemstosearch);
        setImplicitWait(70000,TimeUnit.MILLISECONDS);
        SyncUtil.waitFor(5000);
        setImplicitWait(150000,TimeUnit.MILLISECONDS);
        waitForPresenceOfElement(By.xpath("//span[text()='"+itemstosearch+"']"));
        driver.findElement("//span[text()='"+itemstosearch+"']").click();
        setImplicitWait(1000,TimeUnit.MILLISECONDS);
        Reporter.log(itemstosearch +" is selected", MessageTypes.Pass );
    }

}
