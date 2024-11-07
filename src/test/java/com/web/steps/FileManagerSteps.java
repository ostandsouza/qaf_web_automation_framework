package com.web.steps;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.ConveyorPage;
import com.web.pages.FileManagerPage;
import com.web.pages.SitePage;
import io.restassured.response.Response;

public class FileManagerSteps {

    FileManagerPage fileManagerPage = new FileManagerPage();
    SitePage sitePage = new SitePage();

    ConveyorPage conveyorPage = new ConveyorPage();

    @QAFTestStep(description="Add Folder by the name {FolderName} under site {siteName}")
    public void createNewFolder(String folderName, String siteName){
//        String companyId = fileManagerPage.apiBase.getCompanyID(fileManagerPage.apiBase.getCompanyAPI(siteName));
//        Response fileRes= fileManagerPage.apiBase.getFilesListAPI("site",companyId);
//        fileManagerPage.apiBase.getRootFileID(fileRes).forEach(x -> fileManagerPage.apiBase.deleteFilesAPI(x));
        sitePage.goToSiteDetails(siteName);
        fileManagerPage.goToFileManager();
        fileManagerPage.createFolder(folderName);
    }

    @QAFTestStep(description="Upload file {ImgName} into the folder {FolderName}")
    public void uploadImg(String imgName, String folderName){
//        sitePage.goToSiteDetails(custSIteName);
        fileManagerPage.goToFileManager();
        fileManagerPage.uploadFile(folderName,imgName);
    }

    @QAFTestStep(description="Verify folder {0} and file {1}")
    public void verifyFolderAndFile(String folderName,String imgName){
        fileManagerPage.verifyFolderAndFile(folderName,imgName);
    }

    @QAFTestStep(description="Move the file with {pdfFile} inside folder {FolderName}")
    public void moveFileToFolder(String fileName, String folder){
        fileManagerPage.moveFileIntoFolder(folder,fileName);
    }

    @QAFTestStep(description="Open image with name {ImgName} inside folder {FolderName}")
    public void openImage(String fileName, String folder){
        fileManagerPage.openImage(folder,fileName);
    }

    @QAFTestStep(description="Open pdf with name {ImgName} inside folder {FolderName}")
    public void openPdf(String fileName, String folder){
        fileManagerPage.openPdf(folder,fileName);
    }

    @QAFTestStep(description="Open file with name {videoFile} inside folder {FolderName}")
    public void openFile(String fileName, String folder){
        fileManagerPage.openFile(folder,fileName);
    }

    @QAFTestStep(description="Delete file with name {ImgName} inside folder {FolderName}")
    public void deleteFile(String fileName, String folder){
        fileManagerPage.goToFileManager();
        fileManagerPage.deleteFile(folder,fileName);
    }

    @QAFTestStep(description="Verify the deleted file {ImgName} {pdfFile} {videoFile} inside folder {FolderName}")
    public void verifyDeleteFile(String imageName, String pdfName, String videoName, String folderName){
        fileManagerPage.verifyDeleteFile(folderName,imageName);
        fileManagerPage.verifyDeleteFile(folderName,pdfName);
        fileManagerPage.verifyDeleteFile(folderName,videoName);
    }

    @QAFTestStep(description="Delete the folder {FolderName}")
    public void deleteFolder(String folder){
        fileManagerPage.deleteFolder(folder);
    }

    @QAFTestStep(description="Verify the deleted folder {FolderName}")
    public void verifyDeleteFolder(String folder){
        fileManagerPage.verifyDeleteFolder(folder);
    }

    @QAFTestStep(description="Navigate to site details for site {siteName}")
    public void navigateToSiteDetails(String siteName){
        sitePage.goToSiteDetails(siteName);
    }

    @QAFTestStep(description="Navigate to file manager for conveyor {0} {1} {2}")
    public void navigateToFileManagerForConveyor(String custCorp, String custSite, String conveyorName){
        String companyId = fileManagerPage.apiBase.getCompanyID(fileManagerPage.apiBase.getCompanyAPI(custCorp));
        String siteCompanyId = fileManagerPage.apiBase.getCompanyID(fileManagerPage.apiBase.getCompanyAPI(custSite));
        String conveyorId = fileManagerPage.apiBase.getConveyorsAPI(conveyorName);
//        fileManagerPage.apiBase.deleteConveyorAPI(conveyorId);
//        SyncUtil.waitFor(3000);
//        fileManagerPage.apiBase.createConveyorAPI("conveyor1", companyId, siteCompanyId, conveyorName);
//        fileManagerPage.browserRefresh();
        conveyorPage.goToConveyorDetailScreen(conveyorName);
        fileManagerPage.goToFileManager();
    }

    @QAFTestStep(description="Navigate to file manager for site {SiteName}")
    public void navigateToFileManagerViaSite(String siteName){
        sitePage.goToSiteDetails(siteName);
        fileManagerPage.goToFileManager();
    }

    @QAFTestStep(description="Navigate to file manager for conveyor {ConveyorName}")
    public void navigateToFileManagerViaConveyor(String conveyorName){
        conveyorPage.goToConveyorDetailScreen(conveyorName);
        fileManagerPage.goToFileManager();
    }

    @QAFTestStep(description="Verify default folder for conveyor level")
    public void verifyDefaultFolders(){
        fileManagerPage.verifyDefaultFolders();
    }

    @QAFTestStep(description="Add Folder by the name {FolderName} under conveyor {conveyorName}")
    public void createNewFolderConveyor(String folderName, String conveyorName){
//        String conveyorID = fileManagerPage.apiBase.getConveyorsAPI(conveyorName);
//        Response fileRes= fileManagerPage.apiBase.getFilesListAPI("conveyor",conveyorID);
//        fileManagerPage.apiBase.getRootFileID(fileRes).forEach(x -> fileManagerPage.apiBase.deleteFilesAPI(x));
        conveyorPage.goToConveyorDetailScreen(conveyorName);
        fileManagerPage.goToFileManager();
        fileManagerPage.createFolder(folderName);
    }

    @QAFTestStep(description="Verify the folder created by the name {FolderName}")
    public void verifyTheFolderCreatedByTheName(String folderName){
        fileManagerPage.verifyFolder(folderName);
    }

    @QAFTestStep(description="Rename file with name {ImgName} to {ImgNewName} inside folder {FolderName}")
    public void renameFile(String fileName, String newFileName, String folderName){
        fileManagerPage.renameFile(folderName, fileName, newFileName);
    }

    @QAFTestStep(description="Verify Download folder by name {FolderName}")
    public void downloadFolder(String folderName){
        fileManagerPage.downloadFolder(folderName);
    }

    @QAFTestStep(description="Verify the multi files download folder {FolderName}")
    public void downloadFiles(String folderName){
        fileManagerPage.downloadFile(folderName);
    }

    @QAFTestStep(description="Verify count in the file manager tile")
    public void verifyFileManagerTile(){
        fileManagerPage.verifyCount();
    }

    @QAFTestStep(description="Delete multiple file inside folder {FolderName}")
    public void deleteMultipleFiles(String folder){
        fileManagerPage.deleteAllFile(folder);
    }

    @QAFTestStep(description="Verify folder {FolderName} memory details")
    public void verifyFolderMemory(String folder){
        Validator.assertTrue(fileManagerPage.getFolderMemory(folder).equalsIgnoreCase("0 Bytes"), "Memory size is incorrect for empty folder", "Memory size for empty folder verified successfully");
    }

    @QAFTestStep(description="Verify folder {FolderName} memory details after file upload")
    public void verifyFolderMemoryAfterUpload(String folder){
        Validator.assertTrue(!fileManagerPage.getFolderMemory(folder).equalsIgnoreCase("0 Bytes"), "Memory size is incorrect for folder", "Memory size for folder verified successfully");
    }

    @QAFTestStep(description="Verify the deleted file {0} inside folder {1}")
    public void verifyTheDeletedFileInsideFolder(String imageName, String folderName){
        fileManagerPage.verifyDeleteFile(folderName, imageName);
    }

    @QAFTestStep(description="Verify default folder for site level")
    public void verifyDefaultFoldersSite(){

    }
}
