package com.mobile.flutter.app.steps;

import com.mobile.flutter.app.pages.ConveyorPage;
import com.mobile.flutter.app.pages.DashboardPage;
import com.mobile.flutter.app.pages.FileManagerPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

public class FileManagerSteps {

    @QAFTestStep(description = "Verify the contents in FileManager card")
    public void verifyTheFileManagerContents() {
        FileManagerPage.getInstance().verifyFileManagerContents();
    }

    @QAFTestStep(description = "Click on FileManager card in the conveyor page")
    public void clickOnTheFileManagerCardInConveyorPage() {
        DashboardPage.getInstance().fileManagerTileClick();
    }

    @QAFTestStep(description = "Verify navigation to FileManager Page {ConveyorName}")
    public void verifyTheNavToFileManagerPage(String conveyor) {
        FileManagerPage.getInstance().verifyTheNavToFileManagerPage(conveyor);
    }

    @QAFTestStep(description = "Verify type displayed FileManager Page for folder view")
    public void verifyTheTypeDisplayedForFileManager() {
        FileManagerPage.getInstance().verifyTypeDisplayedForFileManager();
    }

    @QAFTestStep(description = "Verify default folders present in FileManager Page")
    public void verifyTheFileManagerDefFolders() {
        FileManagerPage.getInstance().verifyFileManagerDefFolders();
    }

    @QAFTestStep(description = "Navigate to sub folder and verify breadcrumb in File Manager Page")
    public void navigateAndVerifyTheBreadCrumbInFileManager() {
        FileManagerPage.getInstance().navigateAndVerifyBreadCrumbInFileManager();
    }

    @QAFTestStep(description = "Look for files/folders and long press on a file and very it is selected")
    public void clickOnFileOrFolder() {
        Validator.assertTrue(ConveyorPage.getInstance().verifyFilesPresent("conti-img"), "File is not present", "File is present");
        ConveyorPage.getInstance().longPressOnFile();
    }

    @QAFTestStep(description = "Look for the popup displayed in footer and verify share move delete and cancel buttons are visible")
    public void verifyTheActionPopup() {
        Validator.assertTrue(ConveyorPage.getInstance().verifyActionPopup(), "Action popup is not visible", "Action popup is visible");
        ConveyorPage.getInstance().verifyActionPopupButtons();
    }

    @QAFTestStep(description = "Click and Verify Cancel button for file manager")
    public void verifyTheCancelInFileManager() {
        ConveyorPage.getInstance().clickCancelBtnInFileManger();
        Validator.assertTrue(ConveyorPage.getInstance().verifyCancelBtnFuncInFileManager(), "Cancel button is visible", "Cancel button is not visible");
    }

    @QAFTestStep(description = "Verify grid and list view in FileManager Page")
    public void verifyTheGridListViewInFm() {
        FileManagerPage.getInstance().verifyGridListViewInFileManager();
    }
}