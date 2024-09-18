package com.mobile.flutter.app.pages;


import com.mobile.flutter.app.component.CustomFlutterElement;
import com.mobile.nativectx.app.pages.FileManagerNativePage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;

import static javax.swing.UIManager.getColor;

public class FileManagerPage extends FlutterBasePage {

    private static FileManagerPage obj;

    public static FileManagerPage getInstance(){
        if(obj==null)
            obj = new FileManagerPage();
        return obj;
    }

    @FindBy(locator = "fileManager.document.icon")
    public CustomFlutterElement documentIcon;
    @FindBy(locator = "fileManager.folder.icon")
    public CustomFlutterElement folderIcon;
    @FindBy(locator = "fileManager.image.icon")
    public CustomFlutterElement imageIcon;
    @FindBy(locator = "fileManager.video.icon")
    public CustomFlutterElement videoIcon;
    @FindBy(locator = "conveyor.details.fileManager")
    public CustomFlutterElement conveyorFileManagerDetails;
    @FindBy(locator = "conveyor.fileManager.tileCount")
    public CustomFlutterElement fileManagerTileCount;
    @FindBy(locator = "conveyor.fileManager.storageAmt")
    public CustomFlutterElement fileManagerStorageAmt;
    @FindBy(locator = "fileManager.header.text")
    public CustomFlutterElement fileManagerHeader;
    @FindBy(locator = "fileManager.folder.monitoringDevice")
    public CustomFlutterElement monitoringDeviceFolder;
    @FindBy(locator = "fileManager.folder.video")
    public CustomFlutterElement videoFolder;
    @FindBy(locator = "fileManager.folder.ultrasonicReport")
    public CustomFlutterElement ultrasonicReportFolder;
    @FindBy(locator = "fileManager.folder.technicalDataReport")
    public CustomFlutterElement technicalDataReportFolder;
    @FindBy(locator = "fileManager.folder.spliceDesign")
    public CustomFlutterElement spliceDesignFolder;
    @FindBy(locator = "fileManager.folder.minuteManReport")
    public CustomFlutterElement minuteManReportFolder;
    @FindBy(locator = "fileManager.folder.photo")
    public CustomFlutterElement photoFolder;
    @FindBy(locator = "fileManager.folder.inspectionReport")
    public CustomFlutterElement inspectionReportFolder;
    @FindBy(locator = "fileManager.grid.icon")
    public CustomFlutterElement fileManagerGridIcon;
    @FindBy(locator = "fileManager.list.icon")
    public CustomFlutterElement fileManagerListIcon;

    @FindBy(locator = "flutter-rawmap={\"finderType\":\"Descendant\",\"matching\":\"{\\\"finderType\\\":\\\"ByType\\\",\\\"type\\\": \\\"CircleAvatar\\\"}\",\"of\": \"{\\\"finderType\\\":\\\"ByValueKey\\\",\\\"keyValueType\\\": \\\"String\\\",\\\"keyValueString\\\": \\\"Folders\\\"}\"}")
    public CustomFlutterElement folderIconBg;

    public boolean isFileManagerPage() {
        Validator.assertTrue(folderIcon.isDisplayed(),"Folder Icon is not present","Folder Icon is present");
//        System.out.println(folderIconBg.getRenderObject()+"getRender");
//        System.out.println(folderIconBg.getElementColor()+"getColor");
        Validator.assertTrue(documentIcon.isDisplayed(),"Document Icon not present","Document Icon is present");
        return documentIcon.isPresent();
    }
    public void verifyFileManagerContents() {
        Validator.assertTrue(conveyorFileManagerDetails.isDisplayed(),"File Manager Tile is not present","File Manager Tile is present");
        Validator.assertTrue(fileManagerTileCount.isDisplayed(),"File Manager Tile Count is not present","File Manager Tile Count is present");
        Validator.assertTrue(fileManagerStorageAmt.isDisplayed(),"File Manager Storage Amount  is not present","File Manager Storage Amount is present");
    }

    public void verifyTheNavToFileManagerPage(String conveyor) {

        Validator.assertTrue(isFileManagerPage(),"File Manager Page is not present","File Manager Page is present");
        Validator.assertTrue(fileManagerHeader.getText().contains(conveyor+" - File Manager"),"File Manager Header is invalid","File Manager Header is valid");
    }
    public void verifyTypeDisplayedForFileManager() {
        Validator.assertTrue(folderIcon.isDisplayed(),"Folder Icon is not present","Folder Icon is present");
        Validator.assertTrue(documentIcon.isDisplayed(),"Document Icon not present","Document Icon is present");
        Validator.assertTrue(imageIcon.isDisplayed(),"Image Icon is not present","Image Icon is present");
        Validator.assertTrue(videoIcon.isDisplayed(),"Video Icon not present","Video Icon is present");
    }
    public void verifyFileManagerDefFolders() {
        Validator.assertTrue(monitoringDeviceFolder.isDisplayed(),"Monitoring Device Folder is not present","Monitoring Device Folder is present");
        Validator.assertTrue(videoFolder.isDisplayed(),"Video Folder not present","Video Folder is present");
        Validator.assertTrue(ultrasonicReportFolder.isDisplayed(),"Ultrasonic Report Folder is not present","Ultrasonic Report Folderis present");
        Validator.assertTrue(technicalDataReportFolder.isDisplayed(),"Technical Data Report Folder not present","Technical Data Report Folder is present");
        Validator.assertTrue(spliceDesignFolder.isDisplayed(),"Splice Design Folder is not present","Splice Design Folder is present");
        Validator.assertTrue(minuteManReportFolder.isDisplayed(),"MinuteMan Report Folder not present","MinuteMan Report Folder is present");
        Validator.assertTrue(photoFolder.isDisplayed(),"Photo Folder is not present","Photo Folder is present");
        Validator.assertTrue(inspectionReportFolder.isDisplayed(),"Inspection Report Folder not present","Inspection Report Folder is present");
    }
    public void navigateAndVerifyBreadCrumbInFileManager() {
        Validator.assertTrue(photoFolder.isDisplayed(), "Photo Folder is not present", "Photo Folder is present");
        photoFolder.click();
        FileManagerNativePage.getInstance().validateBreadCrumbInFileManager();
    }

    public boolean verifyGridListViewInFileManager()
    {
        Validator.assertTrue(fileManagerGridIcon.isDisplayed(), "Grid Icon is not present", "Grid Icon is present");
        Validator.assertTrue(fileManagerListIcon.isDisplayed(), "List Icon is not present", "List Icon is present");
        return fileManagerListIcon.isVisible();
    }
}