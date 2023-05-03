package com.web.steps;

import com.common.utils.MiscUtils;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.FileManagerPage;
import com.web.pages.SitePage;
import io.restassured.response.Response;

public class FileManagerSteps {

    FileManagerPage fileManagerPage = new FileManagerPage();
    SitePage sitePage = new SitePage();

    @QAFTestStep(description="Add Folder by the name {FolderName} under site {siteName}")
    public void createNewFolder(String folderName, String siteName){
        String companyId = fileManagerPage.apiBase.getCompanyAPI(siteName);
        Response fileRes= fileManagerPage.apiBase.getFilesListAPI("site",companyId);
        fileManagerPage.apiBase.getRootFileID(fileRes).forEach(x -> fileManagerPage.apiBase.deleteFilesAPI(x));
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

    @QAFTestStep(description="Verify folder {FolderName} and file {ImgName}")
    public void verifyFileUpload(String folderName, String imgName){
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
}
