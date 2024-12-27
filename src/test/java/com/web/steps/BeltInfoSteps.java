package com.web.steps;

import com.common.utils.MiscUtils;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.BeltInfoPage;

public class BeltInfoSteps {
    BeltInfoPage beltInfoPage=new BeltInfoPage();

    @QAFTestStep(description = "Navigate to the Belt Info Textile sheet")
    public void navigateToTheBeltInfoTextileSheet() {
        beltInfoPage.navigateBeltInfoTextilePage();
    }

    @QAFTestStep(description = "Navigate to the Belt Info Steel list page")
    public void navigateToTheBeltInfoSteelGenListPage() {
        beltInfoPage.navigateBeltInfoSteelListPage();
    }
    @QAFTestStep(description = "Enter the Belt Form data {Market} {STDReqByCustomer} {BeltConstruction} {CarcassConstruction} {TopCoverCompound} {TopCoverGauge} {BottomCoverCompound} {BottomCoverGauge} {BeltWidth} {BreakerItems} {BreakerItems} {Overallbeltthickness} {Comment}")
    public void addBeltInfoFormData(String market,String customer,String beltConstruction,String carcassConstruction,String topCoverCompound,String topCoverGauge,String bottomCoverCompound,String bottomCoverGauge,String beltWidth,String breakerItem,String overallThickndess,String comment) {
        beltInfoPage.addBeltInfoForm(market,customer,beltConstruction,carcassConstruction,topCoverCompound,topCoverGauge,bottomCoverCompound,bottomCoverGauge,beltWidth,breakerItem,overallThickndess,comment);
    }
    @QAFTestStep(description = "Navigate to preferences tab and verify data")
    public void verifyPreferencesTabData() {
        beltInfoPage.verifyPreferencesTab();
    }
    @QAFTestStep(description = "Export PDF and verify the PDF is downloaded")
    public void verifyExportPDFFunctionality() {
        beltInfoPage.generatePDF();
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("SF_REPORT"), "PDF report was not found", "PDF report was downloaded successfully");

    }
}
