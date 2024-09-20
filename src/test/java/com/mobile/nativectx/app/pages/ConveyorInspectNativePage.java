package com.mobile.nativectx.app.pages;

import com.mobile.nativectx.app.component.CustomMobileElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import org.openqa.selenium.By;

import java.time.Duration;

public class ConveyorInspectNativePage extends NativeBasePage {

    private static ConveyorInspectNativePage obj;

    public static ConveyorInspectNativePage getInstance(){
        if(obj==null)
            obj = new ConveyorInspectNativePage();
        return obj;
    }

//    DashboardPage dashboardPage = new DashboardPage();
//

    @FindBy(locator = "conveyor.details.conveyorInspect")
    protected CustomMobileElement conveyorInspectDetails;

    @FindBy(locator = "conveyorInspect.upload.imageSearch")
    protected CustomMobileElement conveyorInspectImgSearchBtn;

    @FindBy(locator = "conveyorInspect.upload.searchStringBox")
    protected CustomMobileElement conveyorInspectImgSearchBox;

    @FindBy(locator = "conveyorInspect.upload.backBtn")
    protected CustomMobileElement conveyorInspectBackBtn;


    public void clickOnConveyorInspectCard()
    {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        conveyorInspectDetails.click();
        switchContext("FLUTTER");
    }

    public void uploadConveyorInspectImage(String fileName, String filePath)
    {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        pushFile(fileName, filePath);
        switchContext("FLUTTER");
    }

    public void selectImageFromGallery(String fileName)
    {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        conveyorInspectImgSearchBtn.click();
//        conveyorInspectImgSearchBox.click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\""+fileName+"\"]")).click();
        switchContext("FLUTTER");
    }

    public void backButtonNavigation()
    {
        switchContext("NATIVE_APP").manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        conveyorInspectBackBtn.click();
        switchContext("FLUTTER");
    }
}
