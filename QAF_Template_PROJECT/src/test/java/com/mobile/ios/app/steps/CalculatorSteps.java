package com.mobile.ios.app.steps;


import com.mobile.ios.app.pages.CalculatorScreen;
import com.qmetry.qaf.automation.step.QAFTestStep;

public class CalculatorSteps {
    CalculatorScreen screen = new CalculatorScreen();

    @QAFTestStep(description = "Enter number {number}")
    public void enterNumber(String number) {
        screen.enterNumber(number);
    }

    @QAFTestStep(description = "Enter operation {operation}")
    public void enterOperation(char operation) {
        screen.enterOperation(operation);
    }

    @QAFTestStep(description = "Calculate")
    public void calculate() {
        screen.btnEquals.click("'='");
    }

    @QAFTestStep(description = "verify {ans} in result")
    public void verifyResult(String result) {
        screen.tbResult.verifyText(result, "Result");
    }


}
