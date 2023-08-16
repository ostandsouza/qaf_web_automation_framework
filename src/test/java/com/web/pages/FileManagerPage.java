package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

public class FileManagerPage extends BasePage{

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

    @FindBy(locator="xpath=//span[contains(@class,'ctp-icon-breadcrumb-home')]")
    public CustomElement homeIcon;

    @FindBy(locator="xpath=//input[@placeholder='Search']")
    public CustomElement btSearchInput;

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

    @FindBy(locator="xpath=//span[text()='Files Manager']")
    public CustomElement fileManagerHeader;

    @FindBy(locator="xpath=//div[text()='Folder created successfully!']")
    public CustomElement folderSuccessMessage;

    @FindBy(locator="xpath=//button[contains(@class,'p-button-loading')]")
    public CustomElement btSaveLoader;

    @FindBy(locator="xpath=//span[text()='File Uploading']")
    public CustomElement btFileUploadingDialog;

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

    @FindBy(locator="xpath=//button[contains(@class,'p-dialog-header-icon')]")
    public CustomElement closePopup;

    @FindBy(locator="xpath=//div[text()='Downloading']")
    public CustomElement downloadingMsg;

    @FindBy(locator="xpath=(//div[text()=' Files ']/..//li/div/p-skeleton)[1]")
    public CustomElement fileManagerLoader;


    public void goToFileManager(){
        if(fileManager.isEnable())
            fileManager.jsClick("File Manager");
        else {
            btRightCarousel.jsClick("Carousel right");
            fileManager.jsClick("File Manager");
        }
        fileManagerHeader.isVisible("File Manager Header");
        waitForElementToInvisible(fileManagerLoader,40000);
    }

    public void createFolder(String folderName){
        newFolder.click("New Folder");
        folderHeader.isVisible("Folder Dialog");
        folderInputName.type(folderName);
        save.click("Save");
        waitForElementToInvisible(btSaveLoader,30000);
        waitForElementToDisplay(folderSuccessMessage);
    }

    public void uploadFile(String folderName, String fileName){
        if(folderName.equalsIgnoreCase("root"))
            homeIcon.click("Root Icon");
        else {
            setImplicitWait(30000, TimeUnit.MILLISECONDS);
            waitForElementToInvisible(fileManagerLoader,40000);
            driver.findElement(By.xpath("//li/div[@aria-label='"+folderName+"']")).click();
            setImplicitWait(5000, TimeUnit.MILLISECONDS);
        }
        String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "test_files").getAbsolutePath();
        upload.sendKeys(file_path, "img_upload");
        SyncUtil.waitFor(5000);
        waitForElementToInvisible(btFileUploadingDialog, 45000);
    }

    public void verifyFolderAndFile(String folderName, String fileName){
        waitForElementToInvisible(fileManagerLoader,40000);
        Validator.assertTrue(driver.findElement(By.xpath("//li/div[@aria-label='"+folderName+"']")).isDisplayed(),"Folder created is not present","Folder was created successfully");
        driver.findElement(By.xpath("//li/div[@aria-label='"+folderName+"']")).click();
        Validator.assertTrue(verifyFilePresent(fileName),"File uploaded is not present","File was successfully uploaded");
    }

    public boolean verifyFilePresent(String fileName){
        btSearchInput.type(fileName,"File Name");
        return btCheckbox.isVisible("Search Result");
    }

    public void deleteFile(String folder, String fileName){
        waitForElementToInvisible(fileManagerLoader,40000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='"+folder+"']")));
        verifyFilePresent(fileName);
        waitForElementToBeClickable(btCheckbox);
        btCheckbox.check(fileName);
        btDelete.click("Delete");
        btDeleteDialog.isEnable("Delete Confirmation Dialog");
        btDeleteConfirm.click("Confirm Delete");
        waitForElementToInvisible(btDeleteDialog,45000);
    }

    public boolean verifyDeleteFile(String folder, String fileName){
        waitForElementToInvisible(fileManagerLoader,40000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='"+folder+"']")));
//        driver.findElement(By.xpath("//span[text()='"+folder+"']")).click();
        btSearchInput.type(fileName,"File Name");
        return noList.isVisible("No Search Result");
    }

    public boolean verifyDeleteFolder(String folder){
        boolean isPresent = false;
        try{
            driver.findElement("xpath=//span[text()='"+folder+"']").isDisplayed();
            isPresent = true;
        }
        catch(Exception e){
            isPresent = false;
        }
        return isPresent;
    }

    public void deleteFolder(String folderName){
        waitForElementToInvisible(fileManagerLoader,40000);
        driver.findElement(By.xpath("//li/div[@aria-label='"+folderName+"']")).click();
        driver.findElement(By.xpath("//span[text()='"+folderName+"']/../..//i[contains(@class,'pi-ellipsis-v')]")).click();
        btMoreDelete.click("Delete");
        btDeleteDialog.isEnable("Delete Confirmation Dialog");
        btDeleteConfirm.click("Confirm Delete");
        waitForElementToInvisible(btDeleteDialog,45000);
    }

    public void moveFileIntoFolder(String folderName,String fileName){
        homeIcon.click("Root Icon");
        verifyFilePresent(fileName);
        btCheckbox.click(fileName);
        btCut.click("Cut");
        waitForElementToInvisible(fileManagerLoader,40000);
        driver.findElement(By.xpath("//li/div[@aria-label='"+folderName+"']")).click();
        btPaste.click("Paste");
        btMoveDialog.isEnable("Move Confirmation Dialog");
        btMoveConfirm.click("Confirm Move");
        waitForElementToInvisible(btMoveDialog,45000);
    }

    public void openImage(String folderName,String fileName){
        waitForElementToInvisible(fileManagerLoader,40000);
        driver.findElement(By.xpath("//li/div[@aria-label='"+folderName+"']")).click();
        verifyFilePresent(fileName);
        driver.findElement(By.xpath("//a[text()='"+fileName+"']")).click();
        waitForElementToDisplay(imgPopup);
        imgPopup.isVisible("Image");
        closePopup.click();
    }

    public void openFile(String folderName,String fileName){
        waitForElementToInvisible(fileManagerLoader,40000);
        driver.findElement(By.xpath("//li/div[@aria-label='"+folderName+"']")).click();
        verifyFilePresent(fileName);
        driver.findElement(By.xpath("//a[text()='"+fileName+"']")).click();
        downloadingMsg.isEnable("Downloading Msg");
        SyncUtil.waitFor(5000);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles(fileName),"Downloaded file was not found","File was downloaded successfully");
    }
}
