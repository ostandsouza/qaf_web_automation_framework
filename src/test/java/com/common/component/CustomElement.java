package com.common.component;

import com.google.common.base.Function;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.util.ExpectedCondition;
import com.qmetry.qaf.automation.ui.util.QAFWebElementExpectedConditions;
import com.qmetry.qaf.automation.ui.util.QAFWebElementWait;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.StringMatcher;
import com.qmetry.qaf.automation.util.StringUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CustomElement extends QAFWebComponent {

    public CustomElement(String locator) {
        super(locator);
    }

    protected CustomElement(QAFExtendedWebDriver driver) {
        super(driver);
    }

    public CustomElement(QAFExtendedWebElement parent, String locator) {
        super(parent, locator);
    }

    /**
     * Replaces the existing text with new value
     *
     * @param value : To be typed in object
     */
    public void type(String value) {
        this.clear();
        this.sendKeys(value);

    }

    /**
     * @param value   : To be typed in object
     * @param objName : Name of object for reporting purpose
     */
    public void sendKeys(String value, String objName) {
        try {
            this.sendKeys(value);
            Reporter.log(value + " is typed in " + "'" + objName + "'", MessageTypes.Info);
        } catch (Exception e) {
            Reporter.log("Failed to type " + value + " in " + "'" + objName + "'" + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }

    }

    /**
     * Replaces the existing text with new value     *
     *
     * @param value   : To be typed in object
     * @param objName : Name of object for reporting purpose
     */
    public void type(String value, String objName) {
        try {
            this.type(value);
            Reporter.log(value + " is typed in " + "'" + objName + "'", MessageTypes.Info);
        } catch (Exception e) {
            Reporter.log("Failed to type " + value + " in " + "'" + objName + "'" + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs a click operation using JavaScriptExecutor
     *
     * @param objName Name of object for reporting purpose. It's optional
     */
    public void jsClick(String... objName) {
        try {
            JavascriptExecutor executor = this.getWrappedDriver();
            executor.executeScript("arguments[0].click();", this);
            if (objName.length > 0)
                Reporter.log("Clicked on " + objName, MessageTypes.Info);
        } catch (Exception e) {
            Reporter.log("Failed to click on " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Performs a click operation using Action class
     *
     * @param objName Name of object for reporting purpose. It's optional
     */
    public void actionClick(String... objName) {
        try {
            Actions act = new Actions(this.getWrappedDriver());
            act.moveToElement(this,0,150).click().build().perform();
            if (objName.length > 0)
                Reporter.log("Clicked on " + objName, MessageTypes.Info);
        } catch (Exception e) {
            Reporter.log("Failed to click on " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Perform left-click on the object
     *
     * @param objName Name of object for reporting purpose.
     */
    public void click(String objName) {
        try {
            this.click();
            Reporter.log("Clicked on " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to click on " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
    }

    /**
     * Get text from element
     *
     * @param objName Name of object for reporting purpose.
     */
    public String getText(String objName) {
        String text;
        try {
            text = this.getText();
            Reporter.log("Getting text from " + objName, MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to get text from " + objName + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }
        return text;
    }

    /**
     * Selects an object if it's not selected already.
     *
     * @param objName Name of object for reporting purpose.
     */
    public void check(String objName) {
        try {
            if (!this.isSelected()) {
                this.click();
                Reporter.log("'" + objName + "'" + " is selected", MessageTypes.Info);
            } else
                Reporter.log("'" + objName + "'" + " is already selected", MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to select " + "'" + objName + "'" + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }

    }

    /**
     * Unselects an object if it's selected already.
     *
     * @param objName Name of object for reporting purpose.
     */
    public void unCheck(String objName) {
        try {
            if (this.isSelected()) {
                this.click();
                Reporter.log("'" + objName + "'" + " is deselected", MessageTypes.Info);
            } else
                Reporter.log("'" + objName + "'" + " is already deselected", MessageTypes.Info);

        } catch (Exception e) {
            Reporter.log("Failed to deselected " + "'" + objName + "'" + " due to exception " + e.getMessage(), MessageTypes.Fail);
            throw e;
        }

    }

    /**
     * Checks if the element i enabled
     * @param objName Name of object for reporting purpose.
     * @return True if element is enabled otherwise False
     */
    public boolean isEnable(String... objName) {
        boolean result = false;
        try {
            if (this.isEnabled())
                result = true;

        } catch (Exception ignore) {
        }
        if (objName.length > 0)
            if (result)
                Reporter.log("'" + objName[0] + "'" + " is enabled", MessageTypes.Info);
            else
                Reporter.log("'" + objName[0] + "'" + " is not enabled", MessageTypes.Fail);
        return result;
    }

    /**
     * Checks visibility of the object
     *
     * @return True if object is visible otherwise False
     */
    public boolean isVisible() {
        boolean result = false;
        try {
            if (this.isDisplayed())
                result = true;

        } catch (Exception ignore) {
        }
        return result;
    }

    /**
     * Checks visibility of the object
     *
     * @param objName Name of object for reporting purpose.
     * @return True if object is visible otherwise False
     */
    public boolean isVisible(String... objName) {
        boolean result = this.isVisible();
        if (objName.length > 0)
            if (result)
                Reporter.log("'" + objName[0] + "'" + " is visible", MessageTypes.Info);
            else
                Reporter.log("'" + objName[0] + "'" + " is not visible", MessageTypes.Fail);
        return result;
    }

    /**
     * Checks visibility of the object of assigned period of time
     *
     * @param timeOut in milliseconds
     * @return True if object is visible otherwise False
     */
    public boolean isVisible(long timeOut) {
        boolean result = true;
        try {
            this.waitForVisible(timeOut);
        } catch (Exception ignore) {
            result = false;
        }
        return result;
    }

    /**
     * Checks visibility of the object of assigned period of time
     *
     * @param timeOut in milliseconds
     * @param objName Name of object for reporting purpose.
     * @return True if object is visible otherwise False
     */
    public boolean isVisible(long timeOut, String... objName) {
        boolean result = this.isVisible(timeOut);
        if (objName.length > 0)
            if (result)
                Reporter.log("'" + objName[0] + "'" + " is visible", MessageTypes.Info);
            else
                Reporter.log("'" + objName[0] + "'" + " is not visible", MessageTypes.Fail);

        return result;
    }

    /**
     * Checks invisibility of the object of assigned period of time
     *
     * @param timeOut in milliseconds
     * @return True if object is invisible otherwise False
     */
    public boolean isNotVisible(long timeOut) {
        boolean result = true;
        try {
            this.waitForNotVisible(timeOut);
        } catch (Exception ignore) {
            result = false;
        }
        return result;
    }

    /**
     * Waits and verifies if partial text is displayed in the object
     *
     * @param isRegEx True if text contains regular expression
     * @param text    Text to be verified
     * @param timeOut in milliseconds
     * @param objName Name of object for reporting purpose.
     * @return True if text is present otherwise False
     */
    public boolean verifyPartialText(boolean isRegEx, String text, long timeOut, String... objName) {
        boolean result = true;
        try {
            if (isRegEx) {
                this.waitForText(StringMatcher.like(text), timeOut);
                text = this.getText();
            } else
                this.waitForText(StringMatcher.contains(text), timeOut);

        } catch (Exception ignore) {
            result = false;
        }
        if (objName.length > 0)
            if (result)
                Reporter.log(text + " is displayed in " + objName[0], MessageTypes.Pass);
            else
                Reporter.log(text + " is not displayed in " + objName[0], MessageTypes.Fail);
        return result;
    }

    /**
     * Verifies if text is displayed in the object ignoring new line characters
     *
     * @param message text to be verified
     * @param objName Name of object for reporting purpose.
     */
    public void verifyTextIgnoringNewLineChar(String message, String objName) {
        String actMsgDetails = this.getText().replaceAll("\r\n", "").replaceAll("\n", "").trim();
        if (message.trim().equalsIgnoreCase(actMsgDetails))
            Reporter.log(message + " is verified in " + objName, MessageTypes.Pass);
        else
            Reporter.log(message + " is not verified in " + objName, MessageTypes.Fail);
    }

    /**
     * Wait until child objects appear inside the current object
     *
     * @param timeOut      in milliseconds
     * @param childLocator identifier for locating child object as per QAF
     * @return True if child object is found otherwise False.
     */
    public boolean waitForChildElementsToBePresent(long timeOut, String childLocator) {
        boolean result = false;
        try {
            result = new QAFWebElementWait(this, timeOut).withTimeout(timeOut, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class, RuntimeException.class)
                    .withMessage("Wait time out for any child element to be present")
                    .until((Function<QAFExtendedWebElement, Boolean>) parent -> parent.findElements(childLocator).size() > 0);
        } catch (Exception ignore) {
        }
        return result;
    }

    /**
     * Wait until element has part of text
     *
     * @param timeout      in milliseconds
     * @param text Part of text element need to wait for
     */
    public void waitForPartialText(String text, long... timeout) {
        (new QAFWebElementWait(this, timeout)).
                ignoring(new Class[]{NoSuchElementException.class, RuntimeException.class}).
                withMessage("Wait time out for " + this.getDescription() + " text " + text).
                until(new ExpectedCondition<QAFExtendedWebElement, Boolean>() {
                    public Boolean apply(QAFExtendedWebElement element) {
                        return StringUtil.contains(element.getText(), String.valueOf(text.trim()));
                }
        });
    }
}
