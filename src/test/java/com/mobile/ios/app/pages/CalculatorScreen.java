package com.mobile.ios.app.pages;

import com.mobile.ios.app.comoponent.IOSMobileElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.util.Reporter;

public class CalculatorScreen extends MobileBasePage {

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub

    }

    @FindBy(locator = "name=5")
    public IOSMobileElement btn5;

    @FindBy(locator = "name=6")
    public IOSMobileElement btn6;

    @FindBy(locator = "name=add")
    public IOSMobileElement btnAdd;

    @FindBy(locator = "name=subtract")
    public IOSMobileElement btnSubtract;

    @FindBy(locator = "name=equals")
    public IOSMobileElement btnEquals;

    @FindBy(locator = "name=Result")
    public IOSMobileElement tbResult;


    public void enterNumber(String strNumber) {
        char[] arrNum = strNumber.toCharArray();
        for (char ch : arrNum) {
            switch (ch) {
                case '5':
                    btn5.click();
                    break;
                case '6':
                    btn6.click();
                    break;
                default:
                    throw new RuntimeException(ch + " is not added to repository");
            }
        }
        Reporter.log("Entered " + strNumber);
    }

    public void enterOperation(char operation) {
        switch (operation) {
            case '+':
                btnAdd.click();
                break;
            case '-':
                btnSubtract.click();
                break;
            default:
                throw new RuntimeException(operation + " is not added to repository");
        }
        Reporter.log("Selected '" + operation + "' operation.");
    }

}
