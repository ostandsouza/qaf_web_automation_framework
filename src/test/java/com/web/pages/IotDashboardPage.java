package com.web.pages;


import com.common.component.CustomElement;
import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;

import java.util.concurrent.TimeUnit;

public class IotDashboardPage extends BasePage {

	@FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
	public CustomElement paginationEntry;
	@FindBy(locator = "xpath=(//li//span[text()='IoT Dashboards'])[1]")
	public CustomElement iotDashboard;

	@FindBy(locator = "xpath=//input[@placeholder='Search']")
	public CustomElement btSearchinput;

	@FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
	public CustomElement home;

	@FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
	public CustomElement pagination;
	@FindBy(locator = "xpath=(//app-card//div[text()='IoT Dashboards'])[1]/../div/div/div/span")
	public CustomElement iotDashboardCardCount;

	public void gotoIotDashboardScreen(){
		if(!iotDashboard.isVisible())
			home.click("Home");
		iotDashboard.click("Iot Dashboard");
		btSearchinput.isVisible("Io Dashboard Page");
	}
	public void gotoIotDashboardScreenWait(){
		gotoIotDashboardScreen();
		scrollPageDown();
		String val="";
		for (long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(200); stop>System.nanoTime();) {
			if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
				break;
			}
			val = pagination.getText();
			SyncUtil.waitFor(8000);
		}
	}

	public void validateIotDashboardCountWrtPagination(){
		int deviceCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
		Validator.assertTrue(apiBase.getIotDashboardCount().get("count").equals(deviceCount),"Iot Dashboard Pagination Count does not match","Iot Dashboard Pagination Count matches");
		Validator.assertTrue(Integer.toString(deviceCount).equals(iotDashboardCardCount.getText()),"Iot Dashboard Card Count does not match","Iot Dashboard Card Count matches");

	}

}
