package com.common.component;

import com.common.component.CustomElement;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.util.ExpectedCondition;
import com.qmetry.qaf.automation.ui.util.QAFWebElementWait;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DropDownListWithoutSearch extends CustomElement {

    public String locOption = "xpath=//ul[@role='listbox']//li[normalize-space(.)='%s']";
    public String locAllOptions = "xpath=//ul[@role='listbox']//li";

    @FindBy(locator = "xpath=//ul[@role='listbox']")
    public CustomElement lstOptions;
    
    @FindBy(locator = "xpath=.//button")
    public CustomElement btnShowList;

    @FindBy(locator = "xpath=.//Input[@role='searchbox']")
    public CustomElement tbSearchText;
    
    public DropDownListWithoutSearch(String locator) {
        super(locator);
    }

    protected DropDownListWithoutSearch(QAFExtendedWebDriver driver) {
        super(driver);
    }

    public DropDownListWithoutSearch(QAFExtendedWebElement parent, String locator) {
        super(parent, locator);
    }

    public void waitForListItemsToLoad(long... timeout) {
		try {
			new QAFWebElementWait(lstOptions, timeout).ignoring(NoSuchElementException.class, RuntimeException.class).withMessage("Wait time out for list items to be present")
					.until(listItemsAreLoaded());
		} catch (Exception ignore) {
			ignore.printStackTrace();

		}
	}

	private static ExpectedCondition<QAFExtendedWebElement, Boolean> listItemsAreLoaded() {//		
		return element -> element.isPresent() && element.isDisplayed() && element.findElements(By.tagName("li")).size() > 0;
	}

	
    public void selectByVisibleText(String option, String objName) {
    	btnShowList.jsClick();    	
    	this.waitForListItemsToLoad(6000);    	        
        CustomElement eleOption = new CustomElement(String.format(locOption, option));
        if (eleOption.isPresent()) {
        	eleOption.jsClick(option);
        	
            if (tbSearchText.getAttribute("value").equalsIgnoreCase(option))
                Reporter.log("'" + option + " is selected in " + objName, MessageTypes.Info);
            else                
            	Reporter.log("'" + option + " is not selected in " + objName, MessageTypes.Fail);
            
        } else
            Reporter.log(option + " is not found in " + objName, MessageTypes.Fail);

        
    }

    public List<String> getAllOptions() {
    	btnShowList.jsClick();    	
    	this.waitForListItemsToLoad(8000);    	
        List<QAFWebElement> eleCurOptions = this.findElements(locAllOptions);
        List<String> allOptions = eleCurOptions.stream().map(ele -> ele.getText().trim()).collect(Collectors.toList());
        btnShowList.jsClick();
        return allOptions;

    }

    public void verifyOptionsInList(String[] options) {
        List<String> lstAllOptions = this.getAllOptions();
        List<String> lstNotFoundOptions = new ArrayList<>();
        for (String option : options) {
            if (!lstAllOptions.contains(option))
                lstNotFoundOptions.add(option);
        }
        if (lstNotFoundOptions.size() > 0)
            Reporter.log("Options " + lstAllOptions + " are not found in the list.", MessageTypes.Fail);
        else
            Reporter.log("All " + Arrays.toString(options) + " are found in the list.", MessageTypes.Pass);

    }

}
