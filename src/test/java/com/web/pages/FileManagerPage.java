package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class FileManagerPage extends BasePage {

    @FindBy(locator = "xpath=(//app-card//div[text()='File Manager'])[1]")
    public CustomElement fileManager;

    @FindBy(locator = "xpath=(//app-card//div[text()='File Manager']/..//span)[1]")
    public CustomElement fileManagerCount;

    @FindBy(locator="xpath=//span[text()='New Folder']")
    public CustomElement newFolder;

    @FindBy(locator="id=file-upload")
    public CustomElement upload;

    @FindBy(locator="xpath=//span[text()='Folder Name']")
    public CustomElement folderHeader;

    @FindBy(locator="xpath=//span[text()='Folder Name']/..//button")
    public CustomElement closeButton;

    @FindBy(locator="xpath=//span[text()='Folder Name']/../..//input")
    public CustomElement folderInputName;

    @FindBy(locator="xpath=//span[text()='Save']")
    public CustomElement save;

    @FindBy(locator="xpath=//span[text()='Cancel']")
    public CustomElement cancel;

    @FindBy(locator="xpath=//span[text()='Refresh']")
    public CustomElement refresh;

    @FindBy(locator="xpath=(//homeicon)[2]/following-sibling::span")
    public CustomElement homeIcon;

    @FindBy(locator="xpath=//input[@placeholder='Search']")
    public CustomElement btSearchInput;

    @FindBy(locator="xpath=(//th//p-tableheadercheckbox)[1]")
    public CustomElement btCheckboxHeader;

    @FindBy(locator="xpath=(//td//p-tablecheckbox)[1]")
    public CustomElement btCheckbox;

    @FindBy(locator="xpath=//span[text()='Delete']")
    public CustomElement btDelete;

    @FindBy(locator="xpath=//span[text()='Delete Folder/File']")
    public CustomElement btDeleteDialog;

    @FindBy(locator="xpath=//span[text()='Delete Folder/File']/../..//span[text()='Delete']")
    public CustomElement btDeleteConfirm;

    @FindBy(locator="xpath=//span[text()='Delete Folder/File']/../..//span[text()='Cancel']")
    public CustomElement btDeleteCancel;

    @FindBy(locator="xpath=//span[text()='Download']")
    public CustomElement btDownload;

    @FindBy(locator="xpath=//span[text()='Cut']")
    public CustomElement btCut;

    @FindBy(locator="xpath=//span[text()='Rename']")
    public CustomElement btRename;

    @FindBy(locator="xpath=//span[text()='Paste']")
    public CustomElement btPaste;

    @FindBy(locator="xpath=//td//i[contains(@class,'pi-ellipsis-v')]")
    public CustomElement btFileMore;

    @FindBy(locator="xpath=(//i[contains(@class,'pi-ellipsis-v')])[1]")
    public CustomElement btFolderMore;

    @FindBy(locator="xpath=//span[text()='Download' and contains(@class,'p-menuitem-text')]")
    public CustomElement btMoreDownload;

    @FindBy(locator="xpath=//span[text()='Rename' and contains(@class,'p-menuitem-text')]")
    public CustomElement btMoreRename;

    @FindBy(locator="xpath=//span[text()='Delete' and contains(@class,'p-menuitem-text')]")
    public CustomElement btMoreDelete;

    @FindBy(locator="xpath=//span[contains(@class,'p-carousel-prev-icon pi pi-chevron-right')]")
    public CustomElement btRightCarousel;

    @FindBy(locator="xpath=//span[contains(@class,'p-carousel-prev-icon pi pi-chevron-left')]")
    public CustomElement btLeftCarousel;

    @FindBy(locator="xpath=//span[text()='File Manager']")
    public CustomElement fileManagerHeader;

    @FindBy(locator="xpath=//div[text()='Folder created successfully!']")
    public CustomElement folderSuccessMessage;

    @FindBy(locator="xpath=//button[contains(@class,'p-button-loading')]")
    public CustomElement btSaveLoader;

    @FindBy(locator="xpath=//span[text()='File Uploading']")
    public CustomElement btFileUploadingDialog;

    @FindBy(locator="xpath=//span[text()='File Uploading']/following-sibling::div/button")
    public CustomElement btFileUploadingCloseBtn;

    @FindBy(locator="xpath=//p-progressspinner/div")
    public CustomElement btFileUploadingProgress;

    @FindBy(locator = "xpath=//td[contains(text(),'No')]")
    public CustomElement noList;

    @FindBy(locator="xpath=//span[text()='Move Folder']")
    public CustomElement btMoveDialog;

    @FindBy(locator="xpath=//span[text()='Move Folder']/../..//span[text()='Move']")
    public CustomElement btMoveConfirm;

    @FindBy(locator="xpath=//span[text()='Move Folder']/../..//span[text()='Cancel']")
    public CustomElement btMoveCancel;

    @FindBy(locator="xpath=//img[contains(@class,'wrapper-image-item')]")
    public CustomElement imgPopup;

    @FindBy(locator="xpath=//pdf-viewer/div[1]")
    public CustomElement pdfPopup;

    @FindBy(locator="xpath=//div[text()='File is still in scanning status. Please try again after some time.']")
    public CustomElement pdfScanning;

    @FindBy(locator="xpath=//button[contains(@class,'p-dialog-header-icon')]")
    public CustomElement closePopup;

    @FindBy(locator="xpath=//div[text()='Downloading']")
    public CustomElement downloadingMsg;

    @FindBy(locator="xpath=(//div[text()=' Files ']/..//li/div/p-skeleton)[1]")
    public CustomElement fileManagerLoader;

    @FindBy(locator="xpath=//div[text()=' Videos ']")
    public CustomElement videoFolder;

    @FindBy(locator="xpath=//div[text()=' Ultrasonic reports ']")
    public CustomElement ultrasonicFolder;

    @FindBy(locator = "xpath=//div[text()=' Monitoring Devices ']")
    public CustomElement monitoringDevice;

    @FindBy(locator = "xpath=//div[text()=' Technical Data reports ']")
    public CustomElement technicalFolder;

    @FindBy(locator="xpath=//div[text()=' Splice designs ']")
    public CustomElement spliceFolder;

    @FindBy(locator="xpath=//div[text()=' Photos ']")
    public CustomElement photosFolder;

    @FindBy(locator="xpath=//div[text()=' MinuteMan reports ']")
    public CustomElement minutemanFolder;

    @FindBy(locator="xpath=//div[text()=' Inspection reports ']")
    public CustomElement inspectionFolder;

    @FindBy(locator="xpath=//input[@placeholder='Please enter new name']")
    public CustomElement renameInput;

    @FindBy(locator="xpath=//button[not(@icon)]/span[text()='Rename']")
    public CustomElement renameConfirm;

    @FindBy(locator="xpath=//span[text()='Rename Folder/File']")
    public CustomElement btRenameDialog;
    @FindBy(locator = "xpath=//p-breadcrumb//nav[@data-pc-name=\"breadcrumb\"]")
    public CustomElement inspectionsBreadcrumb;

    @FindBy(locator = "xpath=//tr//td//i[@class=\"ctp-icon-Visibility_On\"]")
    public CustomElement documentViewIcon;
    @FindBy(locator = "xpath=//p-toast//div[contains(text(),\"Cannot do operations on generated folder\")]")
    public CustomElement defaultFileErrorMessage;

    @FindBy(locator = "xpath=//p[text()=\"File already exists\"]")
    public CustomElement duplicateFileErrorMessage;

    public void goToFileManager() {
        if (fileManager.isEnable())
            fileManager.jsClick("File Manager");
        else {
            btRightCarousel.jsClick("Carousel right");
            fileManager.jsClick("File Manager");
        }
        fileManagerHeader.isVisible("File Manager Header");
        waitForElementToInvisible(fileManagerLoader,40000);
    }

    public void createFolder(String folderName) {
        newFolder.jsClick("New Folder");
        folderHeader.isVisible("Folder Dialog");
        folderInputName.type(folderName);
        save.jsClick("Save");
        waitForElementToInvisible(btSaveLoader,30000);
        waitForElementToDisplay(folderSuccessMessage);
    }

    public void uploadFile(String folderName, String fileName){
        if(folderName.equalsIgnoreCase("root"))
            homeIcon.click("Root Icon");
        else {
            setImplicitWait(30000, TimeUnit.MILLISECONDS);
            waitForElementToInvisible(fileManagerLoader,40000);
            SyncUtil.waitFor(2000);
            driver.findElement(By.xpath("//li[@aria-label='"+folderName+"']")).click();
            setImplicitWait(5000, TimeUnit.MILLISECONDS);
            SyncUtil.waitFor(1000);
            driver.findElement(By.xpath("//li[@aria-label='"+folderName+"']/div")).click();
        }
        String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "test_files").getAbsolutePath();
        upload.sendKeys(file_path, "img_upload");
        SyncUtil.waitFor(5000);
//        if(duplicateFileErrorMessage.isVisible(10000,"error"))
//            Reporter.log("User cannot upload Duplicate files");
        waitForElementToInvisible(btFileUploadingProgress, 45000);
        SyncUtil.waitFor(1000);
        waitForElementToBeClickable(btFileUploadingCloseBtn);
        btFileUploadingCloseBtn.click("Upload Close Btn");
    }

    public void verifyFolderAndFile(String folderName, String fileName){
        if(folderName.equalsIgnoreCase("root"))
            homeIcon.click("Root Icon");
        else {
            waitForElementToInvisible(fileManagerLoader, 40000);
            Validator.assertTrue(driver.findElement(By.xpath("//li[@aria-label='" + folderName + "']")).isDisplayed(), "Folder created is not present", "Folder was created successfully");
        }
        driver.findElement(By.xpath("//li[@aria-label='"+folderName+"']")).click();
        Validator.assertTrue(verifyFilePresent(fileName), "File uploaded is not present", "File was successfully uploaded");
    }

    public boolean verifyFilePresent(String fileName){
        btSearchInput.type(fileName,"File Name");
        return btCheckbox.isVisible("Search Result");
    }

    public void deleteFile(String folder, String fileName) {
        if (folder.equalsIgnoreCase("root"))
            homeIcon.click("Root Icon");
        else {
            waitForElementToInvisible(fileManagerLoader, 40000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(),'" + folder + "')]")));

        }
        verifyFilePresent(fileName);
        waitForElementToBeClickable(btCheckbox);
        btCheckbox.check(fileName);
        btDelete.click("Delete");
        btDeleteDialog.isEnable("Delete Confirmation Dialog");
        btDeleteConfirm.click("Confirm Delete");
        waitForElementToInvisible(btDeleteDialog,45000);
    }

    public boolean verifyDeleteFile(String folder, String fileName){
        if(folder.equalsIgnoreCase("root"))
            homeIcon.click("Root Icon");
        else {
            waitForElementToInvisible(fileManagerLoader, 40000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(),'" + folder + "')]")));
        }
//        driver.findElement(By.xpath("//span[text()='"+folder+"']")).click();
        btSearchInput.type(fileName,"File Name");
        return noList.isVisible("No Search Result");
    }

    public boolean verifyDeleteFolder(String folder){
        boolean isPresent = false;
        try{
            driver.findElement("xpath=///*['contains(text(),'"+folder+"')]").isDisplayed();
            isPresent = true;
        }
        catch(Exception e){
            isPresent = false;
        }
        return isPresent;
    }

    public void deleteFolder(String folderName){
        waitForElementToInvisible(fileManagerLoader,40000);
        driver.findElement(By.xpath("//li[@aria-label='"+folderName+"']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'"+folderName+"')]/../../..//i[contains(@class,'pi-ellipsis-v')]")).click();
        btMoreDelete.click("Delete");
        btDeleteDialog.isEnable("Delete Confirmation Dialog");
        btDeleteConfirm.click("Confirm Delete");
        waitForElementToInvisible(btDeleteDialog,45000);
    }

    public void moveFileIntoFolder(String folderName, String fileName) {
        homeIcon.isVisible(10000,"Home Icon");
        homeIcon.jsClick("Root Icon");
        verifyFilePresent(fileName);
        btCheckbox.click(fileName);
        btCut.click("Cut");
        waitForElementToInvisible(fileManagerLoader,40000);
        driver.findElement(By.xpath("//li[@aria-label='"+folderName+"']")).click();
        driver.findElement(By.xpath("//li[@aria-label='"+folderName+"']")).click();
        btPaste.click("Paste");
        btMoveDialog.isVisible(10000,"MoveDialog");
        btMoveDialog.isEnable("Move Confirmation Dialog");
        btMoveConfirm.isVisible(10000,"Move");
        SyncUtil.waitFor(3000);
        btMoveConfirm.click("Confirm Move");
        waitForElementToInvisible(btMoveDialog,45000);
    }

    public void openImage(String folderName,String fileName){
        waitForElementToInvisible(fileManagerLoader,40000);
        driver.findElement(By.xpath("//li[@aria-label='"+folderName+"']")).click();
        verifyFilePresent(fileName);
        driver.findElement(By.xpath("//a[text()='"+fileName+"']")).click();
        waitForElementToDisplay(imgPopup);
        imgPopup.isVisible("Image");
        closePopup.click();
    }

    public void openPdf(String folderName,String fileName){
        waitForElementToInvisible(fileManagerLoader,40000);
        driver.findElement(By.xpath("//li[@aria-label='"+folderName+"']")).click();
        verifyFilePresent(fileName);
        driver.findElement(By.xpath("//a[text()='"+fileName+"']")).click();
        waitForElementToDisplay(pdfPopup);
        pdfPopup.isVisible("pdf");
        if(closePopup.isVisible())
            closePopup.click();
    }

    public void openFile(String folderName, String fileName) {
        waitForElementToInvisible(fileManagerLoader, 40000);
        driver.findElement(By.xpath("//li[@aria-label='" + folderName + "']")).click();
        verifyFilePresent(fileName);
        SyncUtil.waitFor(1000);
        driver.findElement(By.xpath("//a[text()='" + fileName + "']")).click();
        downloadingMsg.isEnable("Downloading Msg");
        SyncUtil.waitFor(5000);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles(fileName), "Downloaded file was not found", "File was downloaded successfully");
    }

    public boolean verifyDefaultFolders() {
        return videoFolder.isVisible("video folder") && ultrasonicFolder.isVisible("ultrasonic folder") && technicalFolder.isVisible("technical folder") && spliceFolder.isVisible("splice folder") &&
                photosFolder.isVisible("photos folder") && minutemanFolder.isVisible("minuteman folder") && inspectionFolder.isVisible("inspection folder") && monitoringDevice.isVisible("monitoring device folder");
    }

    public boolean verifyFolder(String folderName) {
        waitForElementToInvisible(fileManagerLoader, 40000);
        return driver.findElement(By.xpath("//li[@aria-label='" + folderName + "']")).isDisplayed();
    }

    public void renameFile(String folder, String fileName, String newFileName) {
        waitForElementToInvisible(fileManagerLoader, 40000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(),'" + folder + "')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(),'" + folder + "')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(),'" + folder + "')]")));

        verifyFilePresent(fileName);
        waitForElementToBeClickable(btCheckbox);
        btCheckbox.check(fileName);
        btRename.click("Rename");
        renameInput.clear();
        renameInput.sendKeys(newFileName);
        renameConfirm.click("Confirm rename");
        waitForElementToInvisible(btRenameDialog,45000);
    }

    public void downloadFolder(String folderName) {
        waitForElementToInvisible(fileManagerLoader, 40000);
        driver.findElement(By.xpath("//li[@aria-label='" + folderName + "']//i[contains(@class,'pi-ellipsis-v')]")).click();
        btMoreDownload.click("download folder");
        SyncUtil.waitFor(5000);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles(folderName+".zip"),"Downloaded file was not found","File was downloaded successfully");
    }

    public void downloadFile(String folderName) {
        waitForElementToInvisible(fileManagerLoader, 60000);
        driver.findElement(By.xpath("//li[@aria-label='" + folderName + "']")).click();
        driver.findElement(By.xpath("//li[@aria-label='" + folderName + "']")).click();
        driver.findElement(By.xpath("//li[@aria-label='" + folderName + "']")).click();
        waitForElementToBeClickable(btCheckboxHeader);
        btCheckboxHeader.check("all files");
        btDownload.click("Download");
        SyncUtil.waitFor(20000);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles(folderName + ".zip"), "Downloaded file was not found", "File was downloaded successfully");
    }

    public void verifyCount() {
        waitForElementToInvisible(fileManagerLoader, 40000);
        SyncUtil.waitFor(5000);
        System.out.println("count = " + fileManagerCount.getText());
        Validator.assertTrue(fileManagerCount.getText().equalsIgnoreCase("3") || fileManagerCount.getText().equalsIgnoreCase("6"), "File manager count doesnt match", "File manager count verified successfully");
    }
    public void verifyTileCount(String count) {
        waitForElementToInvisible(fileManagerLoader, 40000);
        SyncUtil.waitFor(5000);
        System.out.println("count = " + fileManagerCount.getText());
        Validator.assertTrue(fileManagerCount.getText().equalsIgnoreCase(count) || fileManagerCount.getText().equalsIgnoreCase("6"), "File manager count doesnt match", "File manager count verified successfully");
    }

    public void deleteAllFile(String folderName) {
        SyncUtil.waitFor(1000);
        waitForElementToInvisible(fileManagerLoader, 40000);
        driver.findElement(By.xpath("//li[@aria-label='" + folderName + "']")).click();
        driver.findElement(By.xpath("//li[@aria-label='" + folderName + "']")).click();

        waitForElementToBeClickable(btCheckboxHeader);
        btCheckboxHeader.check("all files");
        btDelete.click("Delete");
        btDeleteDialog.isEnable("Delete Confirmation Dialog");
        btDeleteConfirm.click("Confirm Delete");
        waitForElementToInvisible(btDeleteDialog,45000);
    }

    public String getFolderMemory(String folderName){
        waitForElementToInvisible(fileManagerLoader,40000);
        String memory = driver.findElement(By.xpath("//li[@aria-label='"+folderName+"']//span[@class='file-details']")).getText();
        System.out.println(MiscUtils.regexExtractor(memory, "(|[^|]*)$").trim());
        return MiscUtils.regexExtractor(memory, "(|[^|]*)$").trim();
    }
    public void openImageDocument(String fileName){
        SyncUtil.waitFor(1000);
        documentViewIcon.isVisible(10000,"View Icon");
        documentViewIcon.click();
        SyncUtil.waitFor(1000);
        waitForElementToDisplay(imgPopup);
        imgPopup.isVisible("Image");
        closePopup.click();
    }
    public void openPdfDocument(String fileName)
    {
        SyncUtil.waitFor(1000);
        documentViewIcon.isVisible(10000,"View Icon");
        documentViewIcon.click();
        SyncUtil.waitFor(1000);
        if(!pdfScanning.isVisible()) {
            waitForElementToDisplay(pdfPopup);
            pdfPopup.isVisible("pdf");
            closePopup.click();
        }
    }
    public void verifyFileManagerBreadCrumb(String corpName,String moduleRecordName,String conveyorName)
    {
        waitForElementVisible(inspectionsBreadcrumb, 10000, 500);
        Validator.assertTrue(inspectionsBreadcrumb.isDisplayed(), "Breadcrumb element is not displayed", "Breadcrumb text is displayed");
        if(!conveyorName.isEmpty())
            assertEquals(inspectionsBreadcrumb.getText(), "Home\nCorporates\n"+corpName+"\n"+moduleRecordName+"\n"+conveyorName+"\nFile Manager", "Breadcrumb text does not match expected");
        else
            assertEquals(inspectionsBreadcrumb.getText(), "Home\nCorporates\n"+corpName+"\n"+moduleRecordName, "Breadcrumb text does not match expected");
    }
    public void verifyFileManagerBreadCrumbDistUser(String corpName,String distShop,String moduleRecordName,String conveyorName)
    {
        waitForElementVisible(inspectionsBreadcrumb, 10000, 500);
        Validator.assertTrue(inspectionsBreadcrumb.isDisplayed(), "Breadcrumb element is not displayed", "Breadcrumb text is displayed");
        if(!conveyorName.isEmpty())
            assertEquals(inspectionsBreadcrumb.getText(), "Home\nCorporates\n" + corpName + "\n" + distShop + "\n" + moduleRecordName + "\n" + conveyorName + "\nFile Manager", "Breadcrumb text does not match expected");

        else
            assertEquals(inspectionsBreadcrumb.getText(), "Home\nCorporates\n"+corpName+"\n"+ distShop + "\n"+moduleRecordName, "Breadcrumb text does not match expected");
    }
    public void folderNameClick(String folderName) {
        SyncUtil.waitFor(5000);
        if (folderName.equalsIgnoreCase("root"))
            homeIcon.click("Root Icon");
        else {
            setImplicitWait(30000, TimeUnit.MILLISECONDS);
            waitForElementToInvisible(fileManagerLoader, 40000);
            scrollIntoView(driver.findElement(By.xpath("//li[@aria-label='" + folderName + "']")));
            driver.findElement(By.xpath("//li[@aria-label='" + folderName + "']")).click();
            setImplicitWait(5000, TimeUnit.MILLISECONDS);
            driver.findElement(By.xpath("//li[@aria-label='" + folderName + "']")).click();

        }
    }
    public void verifyDefaultFolderDeletion()
    {
        defaultFileErrorMessage.isVisible(10000,"Error message");
        Validator.assertTrue(defaultFileErrorMessage.isVisible(),"The default files are getting deleted","The default folders are not getting deleted");
    }
    public void verifyDuplicateFileUpload()
    {
        duplicateFileErrorMessage.isVisible(10000,"Error message");
        Validator.assertTrue(duplicateFileErrorMessage.isVisible(10000,"error"),"Able to upload duplicate files!","User cannot upload duplicate files!");
        closePopup.click();
    }
}
