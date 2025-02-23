package com.web.pages;


import com.common.component.CustomElement;
import com.common.utils.MiscUtils;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;
import com.common.utils.SyncUtil;

import java.util.concurrent.TimeUnit;

public class HeavyEquipmentPage extends BasePage {

	@FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
	public CustomElement paginationEntry;
	@FindBy(locator = "xpath=(//li//span[text()='Heavy Equipment'])[1]")
	public CustomElement heavyEquipment;
	@FindBy(locator = "xpath=//input[@placeholder='Search']")
	public CustomElement btSearchinput;
	@FindBy(locator = "xpath=//p-panel//span[text()='Heavy Equipment']")
	public CustomElement txtheavyEquipmentListHeader;

	@FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
	public CustomElement home;

	@FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
	public CustomElement pagination;
	@FindBy(locator = "xpath=(//app-card//div[text()='Heavy Equipment'])[1]/../div/div/div/span")
	public CustomElement heavyEquipmentCardCount;
	public void navigateHeavyEquipmentListPage() {
		if (!heavyEquipment.isVisible())
			home.click("Home");
		heavyEquipment.click("Heavy Equipment List");
		btSearchinput.isVisible("Site Page");
		waitForElementVisible(txtheavyEquipmentListHeader, 5000, 500);
		Validator.assertTrue(txtheavyEquipmentListHeader.isVisible(), "Page is not redirected to SteelCord-list page", "Redirected to SteelCord-list page");
		Validator.assertTrue(driver.getCurrentUrl().contains("/secure/dashboard/heavy-equipment"), "URL missMatch", "URL validation passed");
	}

	public void goToHeavyEquipmentPageAndWait() {
		scrollPageDown();
		String val = "";
		for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(300); stop > System.nanoTime(); ) {
			if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
				break;
			}
			val = pagination.getText();
			SyncUtil.waitFor(15000);
		}
	}
	public void validateHeavyEquipmentCountWrtPagination(){
		int deviceCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
		Validator.assertTrue(apiBase.getHeavyEquipmentCount().get("count").equals(deviceCount),"Heavy Equipment Pagination Count does not match","Heavy Equipment Pagination Count matches");
		Validator.assertTrue(Integer.toString(deviceCount).equals(heavyEquipmentCardCount.getText()),"Heavy Equipment Card Count does not match","Heavy Equipment Card Count matches");
	}

}
