package com.mobile.nativectx.app.pages;

import com.mobile.nativectx.app.component.CustomMobileElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Validator;

import java.time.Duration;

public class FileManagerNativePage extends NativeBasePage {

    private static FileManagerNativePage obj;

    public static FileManagerNativePage getInstance(){
        if(obj==null)
            obj = new FileManagerNativePage();
        return obj;
    }
    @FindBy(locator = "fileManager.folder.breadCrumb")
    public CustomMobileElement photosBreadCrumb;
    public void validateBreadCrumbInFileManager() {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Validator.assertTrue(photosBreadCrumb.getText().contains("Photos"),"Photos BreadCrumb is not visible","Photos BreadCrumb is visible");
        switchContext("FLUTTER");
    }
}