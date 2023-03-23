package com.mobile.android.app.pages;

import com.mobile.android.app.comoponent.AndroidMobileElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.util.Reporter;

public class CalculatorScreen extends MobileBasePage {

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub

    }

    @FindBy(locator = "id=com.google.android.calculator:id/digit_5")
    public AndroidMobileElement btn5;

    @FindBy(locator = "id=com.google.android.calculator:id/digit_6")
    public AndroidMobileElement btn6;

    @FindBy(locator = "id=com.google.android.calculator:id/op_add")
    public AndroidMobileElement btnAdd;

    @FindBy(locator = "id=com.google.android.calculator:id/op_sub")
    public AndroidMobileElement btnSubtract;

    @FindBy(locator = "id=com.google.android.calculator:id/eq")
    public AndroidMobileElement btnEquals;

    @FindBy(locator = "id=com.google.android.calculator:id/result_final")
    public AndroidMobileElement tbResult;


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
