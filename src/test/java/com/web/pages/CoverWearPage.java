package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.PDFHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import groovyjarjarantlr4.v4.codegen.model.Sync;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static java.io.File.separator;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static org.testng.AssertJUnit.assertEquals;

public class CoverWearPage extends BasePage{

    @FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
    public CustomElement home;

    @FindBy(locator = "xpath=(//li//span[text()='Cover Wear'])[1]")
    public CustomElement coverWearList;

    @FindBy(locator="xpath=(//td[2])[1]")
    public CustomElement cwConveyorName;

    @FindBy(locator="xpath=(//td[3])[1]")
    public CustomElement cwSiteName;

    @FindBy(locator="xpath=(//td[4])[1]")
    public CustomElement cwInstalledDatee;

    @FindBy(locator="xpath=(//td[5])[1]")
    public CustomElement cwGrade;
    @FindBy(locator="xpath=(//td[6]/span)[1]")
    public CustomElement cwDurometer;

    @FindBy(locator="xpath=(//app-durometer/following-sibling::div/span)[1]")
    public CustomElement cwSpecsDurometer;
    @FindBy(locator="xpath=(//td[7]/span)[1]")
    public CustomElement cwRemainingLife;

    @FindBy(locator="xpath=//div[@class='durometer-container']/app-durometer/div/div[2]//span")
    public CustomElement cwSpecsRemainingLife;

    @FindBy(locator="xpath=(//td[8]/app-durometer/div/div[1]//span)[1]")
    public CustomElement cwRemainingCover;

    @FindBy(locator="xpath=//div[@class='durometer-container']/app-durometer/div/div[1]//span")
    public CustomElement cwSpecsRemainingCover;

    @FindBy(locator="xpath=(//td[9]/button)[1]")
    public CustomElement cwDownload;

    @FindBy(locator="xpath=(//button[@icon='ctp-icon-Arrow-Right'])[1]")
    public CustomElement cwViewIcon;

    @FindBy(locator="xpath=//input[@placeholder='Search']")
    public CustomElement cwSearchInput;

    @FindBy(locator = "xpath=//span[text()='Save and Close']")
    public CustomElement cwSaveAndClose;

    @FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
    public CustomElement pagination;

    @FindBy(locator="xpath=(//td//p-tablecheckbox)[1]")
    public CustomElement cwCheckbox;

    @FindBy(locator="xpath=//td//p-tablecheckbox")
    public CustomElement cwCheckboxes;

    @FindBy(locator="xpath=(//button/chevrondownicon)[2]")
//    @FindBy(locator="xpath=(//button/span[contains(@class,'pi-chevron-down')])[2]")
    public CustomElement cwActions;

    @FindBy(locator="xpath=//li//span[text()='Edit']")
    public CustomElement cwEdit;

    @FindBy(locator="xpath=//li//span[text()='Export PDF']")
    public CustomElement cwExport;

    @FindBy(locator="xpath=//span[text()='Delete']")
    public CustomElement cwDelete;

    @FindBy(locator = "xpath=//span[text()='Update']")
    public CustomElement cwUpdate;

    @FindBy(locator = "xpath=//span[text()='Yes']")
    public CustomElement yesConfirmation;

    @FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
    public CustomElement cwAddNew;

    @FindBy(locator="xpath=//label[text()='Site']/parent::div//div[@role='button']")
    public CustomElement cwSiteDropDown;

    @FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter p-inputtext')]")
    public CustomElement cwInput;

    @FindBy(locator="xpath=//label[text()='Conveyor']/parent::div//div[@role='button']")
    public CustomElement cwConveyorDropDown;

    @FindBy(locator="xpath=//label[text()='Site']/parent::div//input")
    public CustomElement cwSiteDropDownInput;

    @FindBy(locator="xpath=//label[text()='Conveyor']/parent::div//input")
    public CustomElement cwConveyorDropDownInput;

    @FindBy(locator="xpath=//label[text()='Position']/parent::div//div[@role='button']")
    public CustomElement cwPositionDropDown;

    public String ListItem = "//ul[@role='listbox']//li//span";

    @FindBy(locator="xpath=//label[text()='Temperature (°C)']/parent::div//input")
    public CustomElement cwTemperature;

    @FindBy(locator="xpath=//label[text()='Tons Conveyed (current)']/parent::div//input")
    public CustomElement cwTons;

    @FindBy(locator="xpath=//label[contains(text(),'of Data Points')]/parent::div//div[@role='button']")
    public CustomElement cwDataPoints;

    @FindBy(locator="xpath=(//table[@class='add-measurement-table']/button[@icon='ctp-icon-Delete'])[1]")
    public CustomElement cwDeleteMeasurement;

    @FindBy(locator="xpath=//table[@class='add-measurement-table']/button[@icon='ctp-icon-Add-circle']")
    public CustomElement cwAddMeasurement;

    @FindBy(locator="xpath=//button[contains(@class,'p-button-loading')]")
    public CustomElement cwSpecsLoader;
    @FindBy(locator="xpath=//span[text()='Save']")
    public CustomElement cwSave;

    @FindBy(locator="xpath=//span[text()='Cancel']")
    public CustomElement cwCancel;

    @FindBy(locator = "xpath=(//div[text()='Cover Wear']/..//div[contains(@class,'text-area')]/span)[1]")
    public CustomElement crCoverWearCard;

    @FindBy(locator="xpath=//button//span[text()='Edit']")
    public CustomElement cwEditSpec;

    @FindBy(locator="xpath=//label[text()='Belt Width (']/parent::div//input")
    public CustomElement cwBeltWidth;

    @FindBy(locator="xpath=//label[text()='Belt Length (']/parent::div//input")
    public CustomElement cwBeltLength;

    @FindBy(locator="xpath=(//label[text()='Top Cover Thickness Nominal (']/parent::div//input)[2]")
    public CustomElement cwTopCoverThicknessInput;

    @FindBy(locator="xpath=(//label[text()='Bottom Cover Thickness Nominal (']/parent::div//input)[2]")
    public CustomElement cwBottomCoverThicknessInput;

    @FindBy(locator="xpath=(//label[text()='Top Cover Compound']/parent::div//input)[1]/../following-sibling::span")
    public CustomElement cwTopCoverCompoundInput;

    @FindBy(locator="xpath=(//label[text()='Bottom Cover Compound']/parent::div//input)[1]/../following-sibling::span")
    public CustomElement cwBottomCoverCompoundInput;

    @FindBy(locator="xpath=//label[text()='Top Cover Thickness Nominal (']/parent::div//div[@role='button']")
    public CustomElement cwTopCoverThickness;

    @FindBy(locator="xpath=//label[text()='Bottom Cover Thickness Nominal (']/parent::div//div[@role='button']")
    public CustomElement cwBottomCoverThickness;

    @FindBy(locator="xpath=//label[text()='Durometer (New Belt)']/parent::div//input")
    public CustomElement cwSpecDurometer;

    @FindBy(locator="xpath=//label[text()='Top Cover Compound']/parent::div//div[@role='button']")
    public CustomElement cwTopCoverCompound;

    @FindBy(locator="xpath=//label[text()='Bottom Cover Compound']/parent::div//div[@role='button']")
    public CustomElement cwBottomCoverCompound;

    @FindBy(locator="xpath=//label[text()='Tons Conveyed']/parent::div//input")
    public CustomElement cwPositionTonsConveyed;

    @FindBy(locator="xpath=//label[text()='Shore A Durometer (New)']/parent::div//input")
    public CustomElement cwPositionDurometer;

    @FindBy(locator="xpath=(//label[text()='Top / Bottom']/..//p-radiobutton)[1]")
    public CustomElement cwPositionTopRadio;

    @FindBy(locator="xpath=(//label[text()='Top / Bottom']/..//p-radiobutton)[2]")
    public CustomElement cwPositionBottomRadio;

    @FindBy(locator="xpath=//td[contains(@class,'p-datepicker-today')]")
    public CustomElement cwTodayDate;

    @FindBy(locator="xpath=//label[text()='Installed Date']/parent::div//input")
    public CustomElement cwInstalledDate;

    @FindBy(locator="xpath=//span[text()='Add New Position']/../..//span[text()='Save']")
    public CustomElement cwPositionSave;
    @FindBy(locator="xpath=//label[text()='Segment']/parent::div//input")
    public CustomElement cwPositionSegment;

    @FindBy(locator="xpath=(//td[8]/span)[1]")
    public CustomElement cwTableDurometer;

    @FindBy(locator="xpath=(//td[2]/div/span)[1]")
    public CustomElement cwTableSegment;

    @FindBy(locator="xpath=(//td[11]/button[1]/span)[1]")
    public CustomElement cwTableDownload;

    @FindBy(locator="xpath=(//td[11]/button[2]/span)[1]")
    public CustomElement cwTableView;

    @FindBy(locator = "xpath=//td[contains(text(),'No')]")
    public CustomElement noList;

    @FindBy(locator="xpath=(//div[contains(@class,'p-panel-header')]/span)[1]")
    public CustomElement coverWearTitle;

    @FindBy(locator="xpath=//div[text()='Missing reading(s) values.']")
    public CustomElement errorMessage;

    @FindBy(locator="xpath=//p-dropdownitem")
    public List<CustomElement> allDropdownElements;

    @FindBy(locator="xpath=//tr/td[contains(@class,'datapoint') and not(contains(@class,'existing'))]/input")
    public List<CustomElement> dataPoints;

    @FindBy(locator="xpath=//tr/td[contains(@class,'durometer') and not(contains(@class,'existing'))]/input")
    public List<CustomElement> durometerMeasurement;

    @FindBy(locator="xpath=//tr/td[contains(@class,'datapoint') and contains(@class,'existing') and contains(@class,'ng-star')]")
    public List<CustomElement> previousDataPoints;

    @FindBy(locator="xpath=//span[text()='(Installed date)']/..")
    public CustomElement installationDateField;

    @FindBy(locator="xpath=//span[text()='(Prev. Measurement)']/..")
    public CustomElement prevMeasurementField;

    @FindBy(locator="xpath=(//table/button/span[contains(@class,'ctp-icon-Delete')])[2]")
    public CustomElement deleteMeasurement;

    @FindBy(locator="xpath=(//table/button/span[contains(@class,'ctp-icon-Add-circle')])[1]")
    public CustomElement addMeasurement;

    @FindBy(locator="xpath=//textarea[@formcontrolname='comment']")
    public CustomElement eleComments;

    @FindBy(locator="id=file-input")
    public CustomElement btnUpload;

    @FindBy(locator="xpath=//input[@formcontrolname='inspectorName']")
    public CustomElement inspectorField;

    @FindBy(locator="xpath=//input[@formcontrolname='temperature']")
    public CustomElement temperatureField;

    @FindBy(locator="xpath=//p-calendar[@formcontrolname='measurementDate']//input")
    public CustomElement inspectionDate;

    @FindBy(locator="xpath=//input[@formcontrolname='tonsConveyedPrevious']")
    public CustomElement tonsConveyedPreviously;

    @FindBy(locator="xpath=//input[@formcontrolname='tonsConveyedCurrent']")
    public CustomElement tonsConveyedCurrent;

    @FindBy(locator="xpath=//label[text()='No. of Data Points']/parent::div//div[@role='button']")
    public CustomElement noOfDataPointsDropdown;

    @FindBy(locator="xpath=//input[@formcontrolname='numberOfColumns']")
    public CustomElement noOfColumnsField;

    @FindBy(locator="xpath=//div[@class='p-progress-spinner']")
    public CustomElement progressLoader;

    @FindBy(locator="xpath=(//app-image-viewer/img)[1]")
    public CustomElement imageViewer;

    @FindBy(locator="xpath=(//span/button[contains(@icon,'pi-download')])[2]")
    public CustomElement downloadPosition;

    @FindBy(locator="xpath=(//span/p-button[contains(@icon,'pi-download')])[2]")
    public CustomElement downloadAll;

    @FindBy(locator="xpath=(//span[contains(@class,'pi-spinner')])[2]")
    public CustomElement downloadSpinner;

    @FindBy(locator="xpath=//div[@class=\"card-inner-wrapper\" and contains(div, \"Cover Wear\")]\n")
    public CustomElement coverWearCard;

    @FindBy(locator="xpath=//span[text()='Cover Wear Summary']")
    public CustomElement coverWearHeader;

    @FindBy(locator="xpath=//span[text()='Specification']")
    public CustomElement specificationHeader;

    @FindBy(locator="xpath=//button[contains(@class,'p-datepicker-prev')]")
    public CustomElement calendarPrev;

    @FindBy(locator="xpath=//button[contains(@class,'p-datepicker-next')]")
    public CustomElement calendarNext;

    @FindBy(locator="xpath=//button[contains(@class,'p-datepicker-month')]")
    public CustomElement calendarMonth;

    @FindBy(locator="xpath=//button[contains(@class,'p-datepicker-year')]")
    public CustomElement calendarYear;

    @FindBy(locator="xpath=//p-calendar[@formcontrolname='dateRangeFrom']//input")
    public CustomElement dateRangeFrom;

    @FindBy(locator="xpath=//p-calendar[@formcontrolname='dateRangeTo']//input")
    public CustomElement dateRangeTo;

    @FindBy(locator="xpath=//label[text()='Position']/parent::div//input")
    public CustomElement positionInput;
    @FindBy(locator="xpath=//label[text()='Position']/parent::div//div/chevrondownicon")
    public CustomElement positionDropdown;

    @FindBy(locator="xpath=//div[contains(@class,'p-multiselect-header')]//div[contains(@class,'p-checkbox-box')]")
    public CustomElement multiSelectAllCheckbox;

    @FindBy(locator="xpath=//button[contains(@class,'p-multiselect-close')]")
    public CustomElement multiSelectCloseBtn;

    @FindBy(locator="xpath=//label[text()='Include']/parent::div//div/chevrondownicon")
    public CustomElement includePositionTypes;

    @FindBy(locator="xpath=//span[text()='Apply']")
    public CustomElement applyBtn;

    @FindBy(locator="xpath=//span[text()='Cancel']")
    public CustomElement cancelBtn;

    @FindBy(locator="xpath=//span[contains(text(),'Cover Wear Report -')]")
    public CustomElement downloadPopup;

    @FindBy(locator="xpath=//div[contains(text(),'Position :')]")
    public CustomElement positionHeader;

    @FindBy(locator="xpath=//button[contains(@icon,'pi-download')]")
    public CustomElement downloadReport;

    @FindBy(locator="xpath=//span[text()='Line']")
    public CustomElement line;

    @FindBy(locator="xpath=//span[text()='3D Area']")
    public CustomElement Area3D;

    @FindBy(locator="xpath=//li//span[text()='Wear Trend']")
    public CustomElement wearTrend;

    @FindBy(locator="xpath=//span[text()='Wear Data']")
    public CustomElement wearData;

    @FindBy(locator="xpath=//span[text()='Wear Projections']")
    public CustomElement wearProjections;

    @FindBy(locator="xpath=//label[text()='Photos']/preceding-sibling::p-checkbox/div")
    public CustomElement photos;

    @FindBy(locator="xpath=//label[text()='Comments']/preceding-sibling::p-checkbox/div")
    public CustomElement comments;

    @FindBy(locator="xpath=//th[text()='Name of The Inspector']")
    public CustomElement inspectorCol;

    @FindBy(locator="xpath=//th[text()='Date of Measurements']")
    public CustomElement measurementDate;

    @FindBy(locator="xpath=//label[contains(text(),'Location')]")
    public CustomElement beltLocationCol;

    @FindBy(locator="xpath=//th/span[text()='Durometer']")
    public CustomElement durometerCol;

    @FindBy(locator="xpath=(//table[@class='main-table']/tr[3]/td[1])[1]")
    public CustomElement inspectorCell;

    @FindBy(locator="xpath=(//table[@class='main-table']/tr[3]/td[2])[1]")
    public CustomElement measurementDateCell;

    @FindBy(locator="xpath=//table[@class='main-table']/tr[3]/td[3]")
    public CustomElement durometerCell;

    @FindBy(locator="xpath=//table[@class='main-table']/tr[3]/td/button[@icon='ctp-icon-Attachments']")
    public CustomElement attachmentBtn;

    @FindBy(locator="xpath=//table[@class='main-table']/tr[3]/td/button[@icon='ctp-icon-Edit']")
    public CustomElement editBtn;

    @FindBy(locator="xpath=//table[@class='main-table']/tr[3]/td/button[@icon='ctp-icon-Delete']")
    public CustomElement deleteBtn;

    @FindBy(locator="xpath=//table[not(@class='main-table')]/tr[3]/td[contains(@class,'datapoint')]")
    public List<CustomElement> thicknessReading;

    @FindBy(locator="xpath=(//table[@class='add-measurement-table'])[2]")
    public CustomElement secondMeasurementTable;

    @FindBy(locator="xpath=(//table//button/span[contains(@class,'ctp-icon-Add-circle')])[1]")
    public CustomElement addCustomMeasurementBtn;

    @FindBy(locator="xpath=(//div[@role='dialog']//img)[1]")
    public CustomElement imgDialog;

    @FindBy(locator="xpath=//div[@role='dialog']/div/div/button")
    public CustomElement closeImgDialog;

    @FindBy(locator="xpath=(//div//button/span[contains(@class,'ctp-icon-Add-circle')]/..)[1]")
    public CustomElement addNewMeasurementBtn;

    @FindBy(locator="xpath=//label[text()='Site']/parent::div//input")
    public CustomElement cwSiteInput;

    @FindBy(locator="xpath=//label[text()='Conveyor']/parent::div//input")
    public CustomElement cwConveyorInput;

    @FindBy(locator="xpath=//label[text()='Position']/parent::div//input")
    public CustomElement cwPositionInput;

    @FindBy(locator="xpath=(//div[@role='dialog'])[1]")
    public CustomElement crDialog;

    @FindBy(locator="xpath=//span[contains(@id, \"p-panel-5_header\") and contains(text(), \"Sites\")]")
    public CustomElement siteHeader;

    @FindBy(locator="xpath=//div[@class='p-breadcrumb p-component']")
    public CustomElement coverWearBreadCrumb;

    @FindBy(locator="xpath=//span[@class='p-menuitem-text ng-star-inserted'][normalize-space()='Home']")
    public CustomElement homeLink;

    @FindBy(locator="xpath=//span[@class=\"p-input-icon-left\"]")
    public CustomElement searchBar;

    @FindBy(locator="xpath=//i[@class=\"ctp-icon-Search\"]")
    public CustomElement searchBarIcon;

    @FindBy(locator="xpath=//td[normalize-space()='No data found']")
    public CustomElement searchNotFound;

    @FindBy(locator="xpath=//th[@id='site-col']")
    public CustomElement siteColumn;

    @FindBy(locator="xpath=//p-columnfilter[@field='site']")
    public CustomElement siteFilter;

    @FindBy(locator="xpath=//p-columnfilterformelement//input")
    public CustomElement filterText;

    @FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
    public CustomElement paginationEntry;

    @FindBy(locator = "xpath=(//button[@icon='ctp-icon-Clear-Filters'])[2]")
    public CustomElement clearFilterBtn;

    @FindBy(locator = "//button[contains(@class, \"p-column-filter-menu-button-active\")]")
    public CustomElement appliedFilter;

    @FindBy(locator = "xpath=//div[@class='p-element p-multiselect-label-container']")
    public CustomElement columnNameBtn;

    @FindBy(locator = "xpath=//div[@class='ng-star-inserted'][normalize-space()='Conveyor']")
    public CustomElement conveyorColumnName;

    @FindBy(locator = "xpath=//div[@class='ng-star-inserted'][normalize-space()='Site']")
    public CustomElement siteColumnName;

    @FindBy(locator = "xpath=//div[normalize-space()='Corporate']")
    public CustomElement corporateColumnName;

    @FindBy(locator = "xpath=//div[@class='ng-star-inserted'][normalize-space()='Installed Date']")
    public CustomElement installedDateColumnName;

    @FindBy(locator = "xpath=//div[@class='ng-star-inserted'][normalize-space()='Cover Grade']")
    public CustomElement coverGradeColumnName;

    @FindBy(locator = "xpath=//div[@class='ng-star-inserted'][normalize-space()='Remaining Life by Time']")
    public CustomElement remainingLifeColumnName;

    @FindBy(locator = "xpath=//div[@class='ng-star-inserted'][normalize-space()='Last Recorded']")
    public CustomElement lastRecordedColumnName;

    @FindBy(locator = "xpath=//div[@class='ng-star-inserted'][normalize-space()='Lowest Reading']")
    public CustomElement lowestReadingColumnName;

    @FindBy(locator = "xpath=//div[@class='ng-star-inserted'][normalize-space()='Durometer Shore A']")
    public CustomElement durometerColumnName;

    @FindBy(locator = "xpath=//div[@class='ng-star-inserted'][normalize-space()='Remaining Cover %']")
    public CustomElement remainingCoverColumnName;

    @FindBy(locator = "xpath=//th[@psortablecolumn=\"corporateName\"]")
    public CustomElement corporateColumnHeader;

    @FindBy(locator = "//div[normalize-space()='Cover Grade']")
    public CustomElement coverGradeColumn;

    @FindBy(locator = "(//app-card//div[text()='Cover Wear']/following-sibling::div[contains(@class,'footer-count')]/div[1]/div[@class='conti-round'])[1]")
    public CustomElement greenCountValue;

    @FindBy(locator = "(//app-card//div[text()='Cover Wear']/following-sibling::div[contains(@class,'footer-count')]/div[2]/div[@class='conti-round'])[1]")
    public CustomElement yellowCountValue;

    @FindBy(locator = "(//app-card//div[text()='Cover Wear']/following-sibling::div[contains(@class,'footer-count')]/div[3]/div[@class='conti-round'])[1]")
    public CustomElement redCountValue;

    @FindBy(locator="xpath=//div[@class='p-breadcrumb p-component']")
    public CustomElement positionBreadcrumb;

    @FindBy(locator="xpath=//span[text()='CS Common Regression']")
    public CustomElement conveyorBreadCrumb;

    @FindBy(locator="xpath=//div[@class='gauge-container']//app-durometer")
    public CustomElement imgGaugeMeter;

    @FindBy(locator="xpath=//td[8]//span[@class=\"durometer\"]")
    public CustomElement txtValDurometer;
    @FindBy(locator="xpath=//td[9]/span")
    public CustomElement txtValRemainingLife;

    @FindBy(locator="xpath=//td[10]//app-durometer//*//div//span\n")
    public CustomElement txtValRemainingCover;

    @FindBy(locator="xpath=//div[@class=\"gauge-container\"]//*//div//span")
    public CustomElement gaugeValRemainingCover;

    @FindBy(locator="xpath=//div[@class=\"gauge-container\"]//*//div[@class=\"bottom-label\"]//span")
    public CustomElement gaugeValRemainingLife;

    @FindBy(locator="xpath=//span[normalize-space()='45 Durometer']")
    public CustomElement gaugeValDurometer;

    @FindBy(locator="xpath=//div[@class=\"gauge-container\"]//div[@class=\"rating\"]")
    public CustomElement gaugePercentageRange;

    @FindBy(locator="xpath=//div[@role=\"tablist\"]//button[@icon=\"ctp-icon-Add-circle\"]")
    public CustomElement btAddMeasurement;

    @FindBy(locator="xpath=//div[@role=\"dialog\" and contains(@class,\"p-dialog\")]")
    public CustomElement measurementPopup;

    @FindBy(locator="xpath=//input[@formcontrolname=\"deviceType\"]")
    public CustomElement tbDeviceType;
    @FindBy(locator="xpath=//input[@formcontrolname=\"velocity\"]")
    public CustomElement tbVelocity;
    @FindBy(locator="xpath=//input[@formcontrolname=\"calibrationThickness\"]")
    public CustomElement tbCalibrationThickness;

    @FindBy(locator="xpath=//input[@formcontrolname=\"surfaceTemperature\"]")
    public CustomElement tbSurfaceTemperature;

    @FindBy(locator="xpath=//input[@formcontrolname='testPosition']")
    public CustomElement tbTestPosition;

    @FindBy(locator="//td[@id='durometer']//input")
    public CustomElement inpdurometerValue;

    @FindBy(locator="//button//span[text()=\"Save\"]")
    public CustomElement btnSave;

    @FindBy(locator="//app-wear-measurements//div[@role=\"region\"]//*//table[@class=\"main-table\"]//tr[4]//*//button[@icon=\"ctp-icon-Edit\"]")
    public CustomElement btnEdit;

    @FindBy(locator="//app-wear-measurements//div[@role=\"region\"]//*//table[@class=\"main-table\"]//tr[2]//*//button[@icon=\"ctp-icon-Attachments\"]")
    public CustomElement btnAttachmentLink;
    @FindBy(locator="//app-wear-measurements//div[@role=\"region\"]//*//table[@class=\"main-table\"]//tr[2]//*//button[@icon=\"ctp-icon-Edit\"]")
    public CustomElement btnEditLink;

    @FindBy(locator="(//app-wear-measurements//div[@role=\"region\"]//*//table[@class=\"main-table\"]//tr[4])[1]")
    public CustomElement trAddedMeasurement;

    @FindBy(locator="//table[@role=\"table\"]//tbody//tr//td[3]")
    public CustomElement tdInstalledDateTableValue;

    @FindBy(locator="//app-wear-measurements//div[@role=\"region\"]//*//table[@class=\"main-table\"]//tr[2]//td[2]")
    public CustomElement tdInstalledDateDetailValue;

    @FindBy(locator="//app-wear-measurements//div[@role=\"region\"]//*//table[@class=\"main-table\"]//tr[4]//*//button[@icon=\"ctp-icon-Delete\"]")
    public CustomElement btnDelete;

    @FindBy(locator="//button[contains(@class,\"p-dialog-header-close\")]")
    public CustomElement btnClose;

    @FindBy(locator="//p-confirmdialog[@header=\"Confirmation\"]")
    public CustomElement dialogConfirm;

    @FindBy(locator = "//button[contains(@class,\"p-confirm-dialog-accept\")]")
    public CustomElement dialogConfirmAccept;

    @FindBy(locator ="//app-wear-measurements//p-panel[@styleclass=\"wear-measurements-header\"]")
    public CustomElement wearMeasurementTable;

    @FindBy(locator = "(//app-wear-measurements//p-panel[@styleclass=\"wear-measurements-header\"]//*//table//td[2])[1]")
    public CustomElement wearMeasurementTableData;

    @FindBy(locator = "//app-wear-measurements//div[@role=\"region\"]//*//table[@class=\"main-table\"]//tr[3]//*//button[@icon=\"ctp-icon-Attachments\" and @disabled]")
    public CustomElement lnkAttachmentDisabled;

    @FindBy(locator = "//app-wear-measurements//div[@role=\"region\"]//*//table[@class=\"main-table\"]//tr[3]//*//button[@icon=\"ctp-icon-Attachments\"]")
    public CustomElement lnkAttachmentEnabled;

    @FindBy(locator = "//app-image-viewer[@cssclassname=\"wrapper-image\"]")
    public CustomElement uploadedImage;

    @FindBy(locator = "//app-measurement-attachments//button[@icon=\"ctp-icon-Add-circle\"]")
    public CustomElement btnAddMoreAttachments;

//    @FindBy(locator = "(//div[contains(@class,'image-list-container-outer')]//div[@class='image-list-container']//img[contains(@class,'thumbnail')])[2]")
//    public CustomElement corrosalImage;

    @FindBy(locator = "//div[@class='image-list-container']//img[2]")
    public CustomElement corrosalImage;

    @FindBy(locator = "//div[@class='view-image-container']//img")
    public CustomElement corrosalViewImage;

    @FindBy(locator = "//app-measurement-attachments//button[@icon='ctp-icon-Delete']")
    public CustomElement btnCorrosalDeleteImg;

    @FindBy(locator = "//button[@icon=\"pi pi-trash\"]")
    public CustomElement btnMeasurementImageDelete;

    @FindBy(locator = "//button[contains(@class,\"p-dialog-header-close\")]")
    public CustomElement btnDialogClose;










    public void goToCoverWearScreen(){
        if(!coverWearList.isVisible())
            home.click("Home");
        coverWearList.jsClick("Cover Wear List");
        coverWearHeader.isVisible("Cover Wear Header");
    }

    public void goToCoverWearScreenAndWait() {
        goToCoverWearScreen();
        scrollPageDown();
        String val="";
        for (long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(120); stop>System.nanoTime();) {
            if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
                break;
            }
            val = pagination.getText();
            SyncUtil.waitFor(5000);
        }
        scrollPageup();
    }

    public void editMeasurement(String conveyorName) {
        searchCoverWear(conveyorName);
        cwCheckbox.check("Measurement Checkbox");
        cwActions.click("Actions");
        waitForElementVisible(cwEdit, 10000,500);
        cwEdit.click("Edit");
        coverWearTitle.isVisible("Cover Wear Title");
    }

    public void addNewMeasurement(String conveyorName, String siteName, String position, String topCoverThickness, String bottomCoverThickness, String positionDurometer, String topCoverCompound, String bottomCoverCompound) {
        cwAddNew.click("Add New Measurement");
        waitForElementToDisplay(cwSiteDropDown);
        dropdownSelectSearch(cwSiteDropDown, cwInput, siteName);
        dropdownSelectSearch(cwConveyorDropDown, cwInput, conveyorName);
        dropdownSelect(cwPositionDropDown, ListItem, position);
        SyncUtil.waitFor(10000);
        editSpecifications(topCoverThickness,bottomCoverThickness,topCoverCompound,bottomCoverCompound,positionDurometer);
        waitForElementToDisplay(cwCheckbox);
        cwCheckbox.isVisible("Position");
    }

    public void editSpecifications(String topCoverThickness, String bottomCoverThickness, String topCoverCompound, String bottomCoverCompound, String positionDurometer){
        cwEditSpec.click("Edit");
        SyncUtil.waitFor(5000);
        cwBeltWidth.sendKeys("600");
        cwBeltLength.sendKeys("400");
        dropdownSelectSearch(cwTopCoverThickness, cwInput, topCoverThickness);
        dropdownSelectSearch(cwBottomCoverThickness, cwInput, bottomCoverThickness);
        cwSpecDurometer.sendKeys(positionDurometer, "Durometer");
        dropdownSelectSearch(cwTopCoverCompound, cwInput, topCoverCompound);
        dropdownSelectSearch(cwBottomCoverCompound, cwInput, bottomCoverCompound);
        cwSave.click("Save Specs");
        waitForElementToInvisible(cwSpecsLoader,15000);
    }

    public void addPosition(String segment, boolean top, String tons, String durameter){
        cwSpecsLoader.waitForNotVisible(10000);
        cwAddNew.click("Edit");
        cwPositionSegment.sendKeys(segment, "Segment");
        cwPositionTonsConveyed.sendKeys(tons, "Tons Conveyed");
        cwPositionDurometer.sendKeys(durameter, "Durameter");
        if(top)
            cwPositionTopRadio.click("Top Radio");
        else cwPositionBottomRadio.check("Bottom Radio");
        cwInstalledDate.click("Date Picker");
        cwTodayDate.click("Current Date");
        cwPositionSave.click("Save Position");
        cwPositionSave.waitForNotVisible(7000);
        SyncUtil.waitFor(3000);
    }

    public void editPosition(String segment, String editSegment){
        waitForElementToDisplay(cwCheckbox);
        searchPosition(segment);
        cwCheckbox.check("Position Checkbox");
        cwActions.click("Actions");
        waitForElementVisible(cwEdit, 10000,500);
        cwEdit.click("Edit");
        cwPositionSegment.type(editSegment);
        cwPositionSave.click("Save");
        cwPositionSave.waitForNotVisible(7000);
        SyncUtil.waitFor(7000);
    }

    public void verifyPosition(String segment, String durameter){
        searchPosition(segment);
        Validator.assertTrue(cwTableSegment.getText().contains(segment),"Segment showing incorrect","Segment is updated correctly");
        System.out.println("Logger: ="+cwTableDurometer.getText().trim());
        System.out.println("Logger: ="+durameter);
        Validator.assertTrue(cwTableDurometer.getText().trim().equalsIgnoreCase(durameter),"Durometer showing incorrect","Durometer is updated correctly");
    }

    public boolean searchPosition(String segmentName){
        cwSearchInput.type(segmentName, "Position Search");
        waitForElementToDisplay(cwCheckbox);
        return cwCheckbox.isVisible("Position Found");
    }

    public void deletePosition(String segmentName) {
        searchPosition(segmentName);
        cwCheckbox.check("Position Checkbox");
        cwActions.click("Actions");
        waitForElementVisible(cwDelete, 10000,500);
        cwDelete.click("Delete");
        yesConfirmation.click("Confirm");
        SyncUtil.waitFor(2000);
    }

    public void goToPositionDetailScreen(String conveyorName) {
        searchPosition(conveyorName);
        waitForElementToDisplay(cwViewIcon);
        cwViewIcon.click("Position Detail");
        crCoverWearCard.isEnable("Cover Wear Data");
    }

    public void verifyDeletePosition(String segmentName) {
        cwSearchInput.type(segmentName, "Position Search");
        Validator.assertTrue(noList.isVisible(),"Delete position was still found in cover wear list screen","Position deleted successfully");
    }

    public boolean searchCoverWear(String conveyorName){
        goToCoverWearScreenAndWait();
        cwSearchInput.type(conveyorName, "Cover Wear Search");
        waitForElementToDisplay(cwCheckbox);
        return cwCheckbox.isVisible("Cover Wear Found");
    }

    public void deleteCoverWear(String conveyorName) {
        searchCoverWear(conveyorName);
        cwCheckbox.check("Cover Wear Checkbox");
        cwActions.click("Actions");
        waitForElementVisible(cwDelete, 10000,500);
        cwDelete.click("Delete");
        yesConfirmation.click("Confirm");
        SyncUtil.waitFor(2000);
    }

    public void goToCoverWearDetailScreen(String conveyorName) {
        searchCoverWear(conveyorName);
        waitForElementToDisplay(cwViewIcon);
        cwViewIcon.click("Cover Wear Detail");
        coverWearTitle.isEnable("Cover Wear Data");
    }

    public void verifyCoverWearDelete(String conveyorName) {
        goToCoverWearScreenAndWait();
        cwSearchInput.type(conveyorName, "Cover Wear Search");
        Validator.assertTrue(noList.isVisible(),"Delete Cover Wear was still found in cover wear list screen","Cover Wear deleted successfully");
    }

    public void goToAddMeasurement() {
        cwAddNew.click("Add New Measurement");
        waitForElementToDisplay(cwSiteDropDown);
        cwSiteDropDown.isVisible("Site Dropdown");
    }

    public void verifyErrorMessage() {
        cwSave.click("Save Measurement");
        errorMessage.isEnable("No Position Message");
    }

    public void selectSiteDropdown(String siteName) {
        dropdownSelectSearch(cwSiteDropDown, cwInput, siteName);
    }

    public void verifyConveyorDropdown(String conveyorName) {
        cwConveyorDropDown.click();
        SyncUtil.waitFor(2000);
        waitForElementToBeClickable(cwConveyorDropDown);
        setImplicitWait(70000,TimeUnit.MILLISECONDS);
        waitForPresenceOfElement(By.xpath("//span[text()='"+conveyorName+"']"));
        allDropdownElements.stream().map(x->x.getText()).forEach(System.out::println);
//        Validator.assertTrue(allDropdownElements.size() == 2,"Conveyor dropdown is showing incorrect list of conveyors for selected site","Assigned conveyors to site is shown in dropdown");
        cwInput.type(conveyorName);
        driver.findElement("//span[text()='"+conveyorName+"']").click();
        setImplicitWait(1000,TimeUnit.MILLISECONDS);
        Reporter.log(conveyorName +" is selected", MessageTypes.Pass );
    }

    public void addPositionNavigation(String position, String count) {
        cwPositionDropDown.click();
        setImplicitWait(15000,TimeUnit.MILLISECONDS);
        SyncUtil.waitFor(300);
        waitForPresenceOfElements(By.xpath(ListItem));
        List<WebElement> Options = driver.findElements(By.xpath(ListItem));
        System.out.println("actual positions ="+Options.size());
        System.out.println("expected positions ="+count);
        Validator.assertTrue(Options.size() == parseInt(count),"Position dropdown is showing incorrect positions","Position dropdown verified successfully");
        for(WebElement ele:Options) {
            waitForElementToBeClickable(ele);
            String value = ele.getAttribute("innerText");
            if(	value.equalsIgnoreCase(position)) {
                ele.click();
                Reporter.log(ele +" is selected", MessageTypes.Pass);
                break;
            }
        }
        setImplicitWait(5000,TimeUnit.MILLISECONDS);
        SyncUtil.waitFor(5000);
    }

    public void verifySpecificationScreen(){
        cwEditSpec.isVisible("Specification page");
    }

    public void addSpecification(String beltLength, String beltWidth, String topCoverThickness, String bottomCoverThickness, String positionDurometer, String topCoverCompound, String bottomCoverCompound) {
        editSpecifications(topCoverThickness,bottomCoverThickness,topCoverCompound,bottomCoverCompound,positionDurometer);
        waitForElementToDisplay(cwCheckbox);
        cwCheckbox.isVisible("Position");
    }

    public void verifyInspectorField(String inspector) {
        Validator.assertTrue(inspectorField.getAttribute("value").equalsIgnoreCase(inspector),"Incorrect inspector name is prefilled","Inspector name is validated successfully");
    }

    public void verifyTemperatureField(String temp) {
        temperatureField.sendKeys(temp);
        Validator.assertTrue(temperatureField.getAttribute("value").equalsIgnoreCase(temp),"Entered temperature value is not shown","Temperature is validated successfully");
    }

    public void enterMeasurementDate() {
        inspectionDate.click("Inspection Date");
        cwTodayDate.click("Current Date");
    }

    public void verifyPreviousTonsConveyed(String value) {
        System.out.println(tonsConveyedPreviously.getAttribute("value"));
        System.out.println(value);
        Validator.assertTrue(tonsConveyedPreviously.getAttribute("value").equalsIgnoreCase(value),"Previous tons conveyed is incorrectly prefilled","Previous tons conveyed is validated successfully");
    }

    public void verifyTonsConveyed(String val) {
        tonsConveyedCurrent.sendKeys(val);
        Validator.assertTrue(tonsConveyedCurrent.getAttribute("value").equalsIgnoreCase(val),"Entered tons conveyed is not shown","Tons conveyed is validated successfully");
    }

    public void verifyDataPointDropdownBehaviour(String standard, String every, String custom){
        noOfDataPointsDropdown.click();
        setImplicitWait(15000,TimeUnit.MILLISECONDS);
        SyncUtil.waitFor(1500);
        waitForPresenceOfElements(By.xpath(ListItem));
        List<WebElement> Options = driver.findElements(By.xpath(ListItem));
        List<String> strArr = Options.stream().map(x->x.getText()).collect(Collectors.toList());
        for(String value:strArr) {
            if(	value.equalsIgnoreCase(standard)) {
                driver.findElement("//span[text()='"+value+"']").click();
                Validator.assertTrue(!noOfColumnsField.isEnable(),"Columns field should be disabled if standard data point is selected","Columns field was disabled as expected");
                Reporter.log(value +" is selected and column field is disabled", MessageTypes.Pass);
            }
            else if(value.equalsIgnoreCase(every)){
                driver.findElement("//span[text()='"+value+"']").click();
                Validator.assertTrue(!noOfColumnsField.isEnable(),"Columns field should be disabled if every 50mm data point is selected","Columns field was disabled as expected");
                Reporter.log(value +" is selected and column field is disabled", MessageTypes.Pass);
            }
            else if(value.equalsIgnoreCase(custom)){
                driver.findElement("//span[text()='"+value+"']").click();
                Validator.assertTrue(noOfColumnsField.isEnable(),"Columns field should be enabled if custom data point is selected","Columns field was enabled as expected");
                Reporter.log(value +" is selected and column field is enabled", MessageTypes.Pass);
            }
            else{
                Reporter.log("Data point dropdown values got changed", MessageTypes.Fail);
            }
            SyncUtil.waitFor(1000);
            noOfDataPointsDropdown.click();
        }
        noOfDataPointsDropdown.click();
        setImplicitWait(5000,TimeUnit.MILLISECONDS);
    }

    public void fileUploadMeasurement(String fileName) {
        String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "test_files").getAbsolutePath();
        btnUpload.sendKeys(file_path, "img_upload");
    }

    public void verifyImageUpload(){
        waitForElementToInvisible(progressLoader,20000);
        Validator.assertFalse(imageViewer.getAttribute("src").equalsIgnoreCase("/assets/img/upload_default.png"), "New Image was not uploaded", "New Img was successfully added");
    }

    public void addAndVerifyComments(String comments) {
        eleComments.sendKeys(comments);
        Validator.assertTrue(eleComments.getAttribute("value").equalsIgnoreCase(comments),"Entered comments value is not shown","Comments is validated successfully");
    }

    public void verifySaveFunctionality(){
        cwSave.click("Save");
        waitForElementToInvisible(cwSpecsLoader,40000);
        Validator.assertTrue(!tonsConveyedCurrent.isVisible(),"Add Measurement window was not closed after save","Add measurement window was closed successfully");
    }

    public void verifyPreviousMeasurementTable(String installationDate, String previousMeasurementDate, String previousThickness){
        Validator.assertTrue(installationDateField.getText().trim().contains(installationDate),"Installation Date displayed in measurement table is incorrect","Installation Date was verified successfully");
//        Validator.assertTrue(prevMeasurementField.getText().trim().contains(previousMeasurementDate),"Previous measurement date displayed is incorrect","Previous measurement date was verified successfully");
//        Validator.assertTrue(previousDataPoints.get(0).getText().trim().equalsIgnoreCase(previousThickness),"Previous thickness displayed in table is incorrect","Previous thickness was verified successfully");
    }

    public void verifyAdditionOfNewMeasurement(String thickness, String durometer){
        durometerMeasurement.stream().forEach(x -> x.sendKeys(durometer));
        dataPoints.stream().forEach(x -> x.sendKeys(thickness));
    }

    public void verifyAddNewReading(){
        addMeasurement.click("Add New Reading");
        Validator.assertTrue(durometerMeasurement.size() == 2,"New Reading was not added to the measurement table","New Reading was successfully added");
    }

    public void verifyRemoveNewReading(){
        deleteMeasurement.click("Remove New Reading");
        yesConfirmation.click("Confirmation yes");
        Validator.assertTrue(durometerMeasurement.size() == 1,"New Reading was not deleted from the measurement table","New Reading was successfully deleted");
    }

    public void verifyShoreA(long val) {
        if(cwDurometer.isEnabled())
            Validator.assertTrue(cwDurometer.getText("Durometer").equalsIgnoreCase(String.valueOf(val)),"Incorrect Durometer is not shown in cover listing screen","Durometer was validated successfully");
        else
            Validator.assertTrue(cwSpecsDurometer.getText("Specification Durometer").equalsIgnoreCase(String.valueOf(val)),"Incorrect Durometer is not shown in cover wear screen","Durometer was validated successfully");
    }

    public void verifyShoreASpecs(long val) {
        System.out.println("abcd: ="+cwSpecsDurometer.getText());
        System.out.println("abcd: = "+val);
        Validator.assertTrue(cwSpecsDurometer.getText("Specification Durometer").contains(String.valueOf(val)),"Incorrect Durometer is not shown in cover wear screen","Durometer was validated successfully");
    }

    public void verifyRemainingLife(double val) {
        System.out.println("abcd: ="+cwRemainingLife.getText());
        System.out.println("abcd: = "+val);
        if(cwRemainingLife.isEnabled())
            Validator.assertTrue(cwRemainingLife.getText("Remaining Life").contains(String.valueOf(val == 0D ? "-": val)),"Incorrect Remaining life is not shown in cover listing screen","Remaining life was validated successfully");
        else
            Validator.assertTrue(cwSpecsRemainingLife.getText("Specification Remaining Life").contains(String.valueOf(val == 0D ? "NA": val)),"Incorrect Remaining life is not shown in cover wear screen","Remaining life was validated successfully");
    }

    public void verifyRemainingLifeSpecs(double val) {
        System.out.println("abcd: ="+cwSpecsRemainingLife.getText());
        System.out.println("abcd: = "+val);
        Validator.assertTrue(cwSpecsRemainingLife.getText("Specification Remaining Life").contains(String.valueOf(val == 0D ? "NA": val)),"Incorrect Remaining life is not shown in cover wear screen","Remaining life was validated successfully");
    }

    public void verifyRemainingCover(double val) {
        System.out.println("abcd: ="+cwRemainingCover.getText());
        System.out.println("abcd: = "+new DecimalFormat("#").format(val));
        if(cwRemainingCover.isEnabled())
            Validator.assertTrue(cwRemainingCover.getText("Remaining Cover").contains(String.valueOf(val == 0D ? "--": new DecimalFormat("#").format(val))),"Incorrect Remaining cover is not shown in cover listing screen","Remaining cover was validated successfully");
        else
            Validator.assertTrue(cwSpecsRemainingCover.getText("Specification Remaining Cover").contains(String.valueOf(val == 0D ? "--": new DecimalFormat("#").format(val))),"Incorrect Remaining cover is not shown in cover Wear screen","Remaining cover was validated successfully");
    }

    public void verifyRemainingCoverSpecs(double val) {
        System.out.println("abcd: ="+cwSpecsRemainingCover.getText());
        System.out.println("abcd: = "+new DecimalFormat("#").format(val));
        Validator.assertTrue(cwSpecsRemainingCover.getText("Specification Remaining Cover").contains(String.valueOf(val == 0D ? "--": new DecimalFormat("#").format(val))),"Incorrect Remaining cover is not shown in cover Wear screen","Remaining cover was validated successfully");
    }

    public void verifyDownloadFunctionality() {
        downloadAll.click("Download cover wear summary report");
        waitForElementToInvisible(downloadSpinner, 30000);
    }

    public void verifyPDFContents(String conveyorName, String siteName, String fullName) {
        PDDocument doc =  PDFHelper.getPDFData(System.getProperty("user.dir")+separator+"target"+separator+"downloads"+separator+conveyorName+"_"+siteName+".pdf");
        try {
            String val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
            System.out.println(fullName);
            Validator.assertTrue(val.contains(fullName),"PDF Report was generated for wrong user","PDF Report was generated for the right user");
            Validator.assertTrue(val.contains(conveyorName),"PDF Report has incorrect conveyor name","PDF Report conveyor verified successfully");
            Validator.assertTrue(val.contains(siteName),"PDF Report has incorrect site name","PDF Report site name verified successfully");
            Validator.assertTrue(val.contains("1 top"),"PDF Report was not generated top position","PDF Report generated successfully for top position");
            Validator.assertTrue(val.contains("1 bottom"),"PDF Report was not generated bottom position","PDF Report generated successfully for bottom position");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void verifyPDFTopPosition(String conveyorName, String siteName) {
        PDDocument doc =  PDFHelper.getPDFData(System.getProperty("user.dir")+separator+"target"+separator+"downloads"+separator+conveyorName+"_"+siteName+".pdf");
        try {
            String val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
            Validator.assertTrue(val.contains("1 top"),"PDF Report was not generated top position","PDF Report generated successfully for top position");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void verifyPDFBottomPosition(String conveyorName, String siteName) {
        PDDocument doc =  PDFHelper.getPDFData(System.getProperty("user.dir")+separator+"target"+separator+"downloads"+separator+conveyorName+"_"+siteName+".pdf");
        try {
            String val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
            Validator.assertTrue(val.contains("1 bottom"),"PDF Report was not generated bottom position","PDF Report generated successfully for bottom position");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void verifyPDFContents(String header, String fullName) {
        PDDocument doc =  PDFHelper.getPDFData(System.getProperty("user.dir")+separator+"target"+separator+"downloads"+separator+"Cover_wear_summary_report"+".pdf");
        try {
            String val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
            Validator.assertTrue(val.contains(header),"PDF Report has incorrect header","PDF Report header verified successfully");
            System.out.println("fullName; "+fullName);
            System.out.println("fullName; "+val);
            System.out.println("fullName; "+val.contains(fullName));
            Validator.assertTrue(val.contains(fullName),"PDF Report was generated for wrong user","PDF Report was generated for the right user");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void selectCoverWearRecord() {
        cwCheckbox.check("Checkbox");
    }

    public boolean verifyActionBtnState() {
        return cwActions.isEnable();
    }

    public boolean verifyActionDropDown(){
        cwActions.click("Actions");
        return cwEdit.isVisible("Edit Cover Wear") && cwDelete.isVisible("Delete Cover Wear");
    }

    public boolean verifyActionDropDownForPosition(){
        cwActions.click("Actions");
        return cwEdit.isVisible("Edit Cover Wear") && cwDelete.isVisible("Delete Cover Wear") && cwExport.isVisible("Export PDF");
    }
    public boolean editCoverWearNavigation(){
        cwEdit.jsClick("Edit");
        waitForElementToDisplay(cwEditSpec);
        return cwEditSpec.isVisible("Specification");
    }

    public boolean editCoverWearPosNavigation(){
        cwEdit.jsClick("Edit");
        waitForElementToDisplay(cwPositionSave);
        return cwPositionSave.isVisible("Position Dialog");
    }

    public void editSpecifications(String positionDurometer){
        cwEditSpec.click("Edit");
        SyncUtil.waitFor(5000);
        cwSpecDurometer.clear();
        cwSpecDurometer.sendKeys(positionDurometer, "Durometer");
        cwSave.click("Save Specs");
        waitForElementToInvisible(cwSpecsLoader,15000);
    }

    public void verifyPositionDurometerAfterEdit(String positionDurometer){
        System.out.println("abcd: = "+positionDurometer);
        System.out.println("abcd: = "+cwTableDurometer.getText().trim());
        Validator.assertTrue(!cwTableDurometer.getText().trim().equalsIgnoreCase(positionDurometer), "Durometer is not supposed to update after edit","After editing durometer was updated in position list");
    }
    public void verifyDurometerAfterEdit(String positionDurometer){
        System.out.println("abcd: = "+positionDurometer);
        System.out.println("abcd: = "+cwSpecDurometer.getAttribute("value"));
        Validator.assertTrue(cwSpecDurometer.getAttribute("value").equalsIgnoreCase(positionDurometer), "Durometer is not updated after edit","After editing durometer was verified successfully");
    }

    public void verifyCoverWearViaConveyor(){
        scrollPageup();
        coverWearCard.click("Cover Wear");
        specificationHeader.isVisible("Specification Header");
    }

    public void verifyPositionNav(String position){
        searchPosition(position);
        cwTableView.click("View Icon");
        positionHeader.isVisible("Position Header");
    }
    public void positionDetailsClick()
    {
        cwTableView.click("View Icon");
        positionHeader.isVisible("Position Header");
        waitForPageLoad(10000);

    }

    public void selectGivenDate(String date) {
        String day = null;
        String month = null;
        String year = null;
        DateTimeFormatter format = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("yyyy-MM-dd").toFormatter(Locale.ENGLISH);
        LocalDate formatDate = LocalDate.parse(date, format);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
            SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
            SimpleDateFormat dateFormat = new SimpleDateFormat("d", Locale.ENGLISH);
            Date dateformat = simpleDateFormat.parse(formatDate.toString());
            day = dateFormat.format(dateformat);
            month = monthFormat.format(dateformat);
            year = yearFormat.format(dateformat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int val;
        SyncUtil.waitFor(1000);
        calendarMonth.click("Calendar Month");
        val = parseInt(calendarYear.getText("Calendar year")) - parseInt(year);
        if (val > 0)
            for (int i = 0; i < abs(val); i++)
               calendarPrev.click("Calendar Decrement");
        else if (val < 0)
            for (int i = 0; i < abs(val); i++)
                calendarNext.click("Calendar Increment");
            SyncUtil.waitFor(500);
            waitForElementToBeClickable(By.xpath("//span[contains(text(),\"" + month + "\")]"));
            driver.findElement(By.xpath("//span[contains(text(),\"" + month + "\")]")).click();
            waitForElementToBeClickable(By.xpath("(//td[contains(@class,'ng-star-inserted')]//span[text()=\"" + day + "\" ])[1]"));
            driver.findElement(By.xpath("(//td[contains(@class,'ng-star-inserted')]//span[text()=\"" + day + "\" ])[1]")).click();
//            waitForElementToBeClickable(By.xpath("(//span[text()=\"" + day + "\" and not(contains(@class,'p-disabled'))])[1]"));
//            driver.findElement(By.xpath("(//span[text()=\"" + day + "\" and not(contains(@class,'p-disabled'))])[1]")).click();
    }

    public void downloadPopup(){
        downloadPosition.click("Download cover wear position report");
        downloadPopup.isVisible("DownloadPopup");
    }

    public void openDownloadPositionReportPopup(){
        scrollPageup();
        downloadReport.click("Download cover wear position report");
        downloadPopup.isVisible("DownloadPopup");
    }

    public void verifyCloseDownloadWindow(){
        openDownloadPositionReportPopup();
        verifyCloseBtn();
    }

    public void dateRange(String fromDate, String toDate){
        dateRangeFrom.click("From Date Input");
        selectGivenDate(fromDate);
        dateRangeTo.click("To Date Input");
        selectGivenDate(toDate);
    }

    public void positionDropdownSelection(String position){
        Validator.assertTrue(positionInput.getAttribute("value").equalsIgnoreCase(position),"Incorrect position was selected in download report","Position dropdown for download report was verified successfully");
    }

    public boolean includeDropdownContent(){
        return line.isVisible("Line Option") && Area3D.isVisible("3D Area Option") && wearTrend.isVisible("Wear Trend Option") && wearData.isVisible("Wear Data Option") && wearProjections.isVisible("Wear Projections Option");
    }

    public void verifyCommentAndPhotos(){
        Validator.assertTrue(photos.getAttribute("class").contains("p-checkbox-checked") && comments.getAttribute("class").contains("p-checkbox-checked"),"Photos and comments are not selected in download position report window","Photos and comments are selected in download position report window");
    }

    public void verifySaveBtn(){
        applyBtn.click("Apply");
        waitForElementToInvisible(cwSpecsLoader, 15000);
    }

    public void verifyCloseBtn(){
        cancelBtn.click("Cancel");
        SyncUtil.waitFor(1000);
        Validator.assertTrue(!downloadPopup.isVisible(),"Download report popup was not close on click of cancel","Download popup was closed successfully after clicking cancel");
    }

    public void verifyPositionDropdownContents(){
        positionDropdown.click("Position Dropdown");
        if(multiSelectAllCheckbox.getAttribute("aria-checked").equalsIgnoreCase("false"))
            multiSelectAllCheckbox.click("Select All Position");
        multiSelectCloseBtn.click("Close Dropdown");
    }

    public void verifyIncludeDropdownContents(){
        includePositionTypes.click("Include Dropdown");
        includeDropdownContent();
        if(multiSelectAllCheckbox.getAttribute("aria-checked").equalsIgnoreCase("false"))
            multiSelectAllCheckbox.click("Select All Types");
        multiSelectCloseBtn.click("Close Dropdown");
    }

    public void downloadPositionReport(String fromDate, String toDate){
        dateRange(fromDate, toDate);
        verifyPositionDropdownContents();
        verifyIncludeDropdownContents();
        verifyCommentAndPhotos();
        verifySaveBtn();
    }

    public boolean verifyCoverWearSpecs(String conveyor, String custSite){
        SyncUtil.waitFor(5000);
        cwEditSpec.click("Edit");
        System.out.println("abcd: = "+cwSiteDropDownInput.getAttribute("value"));
        System.out.println("abcd: = "+cwConveyorDropDownInput.getAttribute("value"));
        System.out.println("abcd: = "+cwBeltWidth.getAttribute("value"));
        System.out.println("abcd: = "+cwBeltLength.getAttribute("value"));
        System.out.println("abcd: = "+cwTopCoverThicknessInput.getAttribute("value"));
        System.out.println("abcd: = "+cwBottomCoverThicknessInput.getAttribute("value"));
        System.out.println("abcd: = "+cwBottomCoverCompoundInput.getText());
        return cwSiteDropDownInput.getAttribute("value").equalsIgnoreCase(custSite) && cwConveyorDropDownInput.getAttribute("value").equalsIgnoreCase(conveyor) && cwBeltWidth.getAttribute("value").equalsIgnoreCase("") &&
                cwBeltLength.getAttribute("value").equalsIgnoreCase("") && cwTopCoverThicknessInput.getAttribute("value").equalsIgnoreCase("") &&
                cwBottomCoverThicknessInput.getAttribute("value").equalsIgnoreCase("") && StringUtils.isEmpty(cwTopCoverCompoundInput.getText()) && StringUtils.isEmpty(cwBottomCoverCompoundInput.getText());
    }

    public boolean verifyCoverWearSpecs(String conveyor, String custSite, String beltLength, String beltWidth, String topCoverThickness, String bottomCoverThickness, String topCoverCompound, String bottomCoverCompound){
        SyncUtil.waitFor(5000);
        cwEditSpec.click("Edit");
        System.out.println("abcd: = "+cwSiteDropDownInput.getAttribute("value"));
        System.out.println("abcd: = "+cwConveyorDropDownInput.getAttribute("value"));
        System.out.println("abcd: = "+cwBeltWidth.getAttribute("value"));
        System.out.println("abcd: = "+beltLength);
        System.out.println("abcd: = "+cwBeltLength.getAttribute("value"));
        System.out.println("abcd: = "+cwTopCoverThicknessInput.getAttribute("value"));
        System.out.println("abcd: = "+cwBottomCoverThicknessInput.getAttribute("value"));
        System.out.println("abcd: = "+cwBottomCoverCompoundInput.getText());
        return cwSiteDropDownInput.getAttribute("value").equalsIgnoreCase(custSite) && cwConveyorDropDownInput.getAttribute("value").equalsIgnoreCase(conveyor) && cwBeltWidth.getAttribute("value").equalsIgnoreCase(beltWidth) &&
                cwBeltLength.getAttribute("value").equalsIgnoreCase(beltLength) && cwTopCoverThicknessInput.getAttribute("value").equalsIgnoreCase(topCoverThickness) &&
                cwBottomCoverThicknessInput.getAttribute("value").equalsIgnoreCase(bottomCoverThickness) && cwTopCoverCompoundInput.getText().equalsIgnoreCase(topCoverCompound) && cwBottomCoverCompoundInput.getText().equalsIgnoreCase(bottomCoverCompound);
    }


    public void editPositionDurometer(String positionDurometer){
        cwPositionDurometer.clear();
        cwPositionDurometer.sendKeys(positionDurometer, "Durometer");
        cwPositionSave.click("Save Specs");
        waitForElementToInvisible(cwSpecsLoader,15000);
    }

    public void selectDataPoint(String dataPoint) {
        SyncUtil.waitFor(1000);
        dropdownSelect(noOfDataPointsDropdown, ListItem, dataPoint);
    }

    public void enterInspectionDate(String date) {
        inspectionDate.click("Inspection Date");
        selectGivenDate(date);
    }

    public boolean openMeasurement() {
        scrollPageup();
        addNewMeasurementBtn.click("Measurement Btn");
        return cwPositionInput.isVisible("Position");
    }

    public boolean verifyConveyor(String conveyor) {
        return cwConveyorInput.getAttribute("value").equalsIgnoreCase(conveyor);
    }

    public boolean verifySite(String site) {
        return cwSiteInput.getAttribute("value").equalsIgnoreCase(site);
    }

    public boolean verifyPosition(String position) {
        return cwPositionInput.getAttribute("value").equalsIgnoreCase(position);
    }

    public boolean verifyWearTableHeader() {
        return inspectorCol.isVisible("Name of the Inspector") && measurementDate.isVisible("Date of measurement") && beltLocationCol.isVisible("Location") && durometerCol.isVisible("Durometer");
    }

    public boolean verifyWearMeasurementData(String inspectorName, String measurementDate, String thickness, String durometer) {
        return inspectorCell.getAttribute("value").equalsIgnoreCase(inspectorName) && measurementDateCell.getAttribute("value").equalsIgnoreCase(measurementDate) && thicknessReading.get(0).getAttribute("value").equalsIgnoreCase(thickness) && durometerCell.getAttribute("value").equalsIgnoreCase(durometer);
    }

    public boolean verifyAttachmentBtn() {
        scrollPageup();
        System.out.println(attachmentBtn.isEnable());
        return attachmentBtn.isEnable();
    }

    public boolean verifyAttachmentFunctionality() {
        attachmentBtn.jsClick("Attachment Btn");
        return imgDialog.isVisible("Image dialog");
    }

    public boolean closeAttachment() {
        closeImgDialog.click("Attachment Close Btn");
        return !imgDialog.isNotVisible(1000);
    }

    public boolean editMeasurement() {
        scrollPageup();
        editBtn.jsClick("Edit Measurement");
        return cwConveyorInput.isVisible("Conveyor Inout");
    }

    public boolean editFunctionality(String thickness, String durometer) {
        durometerMeasurement.stream().forEach(x->x.clear());
        durometerMeasurement.stream().forEach(x -> x.sendKeys(durometer));
        dataPoints.stream().forEach(x->x.clear());
        dataPoints.stream().forEach(x -> x.sendKeys(thickness));
        cwSave.click("Save");
        return !cwConveyorInput.isNotVisible(1000);
    }

    public boolean deleteMeasurement() {
        deleteBtn.click("Delete Btn");
        yesConfirmation.click("Confirmation yes");
        return yesConfirmation.isNotVisible(1000);
    }

    public void verifyDeleteMeasurement(){
        Validator.assertTrue(durometerMeasurement.size() == 1,"New Reading was not deleted from the measurement table","New Reading was successfully deleted");
    }

    public void verifyDataPointMeasurement(int count){
        Validator.assertTrue(dataPoints.size() == count,"New Reading was not deleted from the measurement table","New Reading was successfully deleted");
    }

    public void verifySingleConveyorReport(String fromDate, String toDate){
        cwDownload.click("Download");
        crDialog.isVisible("Cover Wear Report dialog");
        downloadPositionReport(fromDate, toDate);
    }

    public void verifyPDFSingleConveyor(){
    }

    public void verifyPDFAllConveyor(){
    }

    public void verifyDataPoints(){
    }

    public void enterDataPoints(String count){
        noOfColumnsField.clear();
        noOfColumnsField.sendKeys(count);
    }

    public void verifyHomePage()
    {
        waitForPageLoad(15000);
//        waitForElementVisible(siteHeader,10000,500);
//        Validator.assertTrue(siteHeader.isVisible(),"User is not in home page of the application","User is in home page of the application");
        Validator.assertTrue(driver.getCurrentUrl().contains("secure/dashboard/sites"),"User is not in home page of the application","User is in home page of the application");

    }
    public void clickCoverWearCard()
    {
//        SyncUtil.waitFor(10000);
        waitForPageLoad(10000);
        waitForElementVisible(coverWearCard,5000,500);
        waitForElementToBeClickable(coverWearCard);
        coverWearCard.jsClick();

    }
    public void verifyCoverWearNavigation()
    {
//        SyncUtil.waitFor(10000);
        waitForPageLoad(10000);
        waitForElementVisible(coverWearHeader,5000,500);
        Validator.assertTrue(coverWearHeader.isVisible(),"user is not navigated to coverWear list page","user is  navigated to coverWear list page");
        Validator.assertTrue(driver.getCurrentUrl().contains("secure/dashboard/cover-wear"),"URL mismatch","URL matches");

    }
    public void verifyCoverWearBreadCrumb()
    {
        waitForElementVisible(coverWearHeader,5000,500);
        Validator.assertTrue(coverWearBreadCrumb.isDisplayed(), "Breadcrumb element is not displayed","Breadcrumb text is displayed");
        Assert.assertEquals(coverWearBreadCrumb.getText(), "Home\nCover Wear", "Breadcrumb text does not match expected");

    }

    public void homeLinkClick()
    {
        waitForElementVisible(homeLink,5000,500);
        homeLink.click();

    }

    public void verifySearchBar()
    {
        waitForPageLoad(10000);
        waitForElementVisible(searchBar,5000,500);
        Validator.assertTrue(searchBar.isVisible(),"The searchBar is not visible","The searchBar is visible");
        Validator.assertTrue(cwSearchInput.isVisible(),"The search placeholder is not present","The search placeholder is  present");
        Validator.assertTrue(searchBarIcon.isVisible(),"The searchBar icon is not present","The searchBar icon is  present");

    }

    public void searchForItem(String searchItem)
    {
        cwSearchInput.type(searchItem, "Cover Wear Search");
    }

    public void verifySearchItem() {
        try {
            waitForPageLoad(10000);
            SyncUtil.waitFor(25000);
            waitForElementVisible(cwCheckboxes,20000,500);
            waitForElementToDisplay(cwCheckboxes);

            if (cwCheckboxes.isDisplayed()) {
                Validator.assertTrue(cwCheckboxes.isVisible(), "No items found", "Search items found");
            }
        } catch (TimeoutException e) {
            Validator.assertTrue(searchNotFound.isVisible(), "No data found text is not visible", "No data found text is visible");
        }
    }

    public void applyColumnFilterClick()
    {
        waitForElementVisible(siteColumn,5000,500);
        hoverOverElement(siteColumn);
        waitForElementVisible(siteFilter,5000,500);
        siteFilter.click();
        waitForElementVisible(filterText,5000,500);
        filterText.type("w");
        waitForElementVisible(applyBtn,5000,500);
        applyBtn.click();
        System.out.println("inside if click ****************");


    }

    public void verifyColumnFilterClick(int noOfCoverWears)
    {
        waitForElementVisible(siteColumn,5000,500);
        hoverOverElement(siteColumn);
        waitForElementVisible(appliedFilter,10000,500);
        for (int i = 1; i <= noOfCoverWears; i++)
        {
            String tdText = driver.findElement(By.xpath("//table//tr["+ i +"]/td[3]")).getText(); // Get the text of the td element

            if (tdText.startsWith("W")) // Check if the text starts with 'w'
            {
                // If the filter is applied, assert it for this row
                Validator.assertTrue(true, "Filter is not applied for row ","filter is applied");
            } else {
                // If the filter is not applied, assert it for this row
                System.out.println("No filter applied for row " + i);
                // Add your assertion code here
            }
        }
    }

    public void clearFilterClick()
    {
        waitForElementVisible(clearFilterBtn,10000,500);
        clearFilterBtn.click();
    }

    public void verifyFilterIsRemoved()
    {
        waitForElementVisible(siteColumn,5000,500);
        hoverOverElement(siteColumn);
        Validator.assertTrue(appliedFilter.isNotVisible(10000),"filter is not removed","filter is removed");
    }

    public void columNamesClick()
    {
        waitForElementVisible(columnNameBtn,5000,500);
        columnNameBtn.click();
    }

    public void verifyColumnNames()
    {
        waitForElementVisible(conveyorColumnName,5000,500);
        Validator.assertTrue(conveyorColumnName.isVisible(),"conveyor column name is not visible","conveyor column name is visible");
        Validator.assertTrue(siteColumnName.isVisible(),"site column name is not visible","site column name is visible");
        Validator.assertTrue(corporateColumnName.isVisible(),"corporate column name is not visible","corporate column name is visible");
        Validator.assertTrue(installedDateColumnName.isVisible(),"installedDate column name is not visible","installedDate column name is visible");
        Validator.assertTrue(coverGradeColumnName.isVisible(),"coverWear column name is not visible","coverWear column name is visible");
        Validator.assertTrue(remainingLifeColumnName.isVisible(),"Remaining life by Time  column name is not visible","Remaining life by Time column name is visible");
        Validator.assertTrue(lastRecordedColumnName.isVisible(),"Last recorded column name is not visible","Last recorded column name is visible");
        Validator.assertTrue(lowestReadingColumnName.isVisible(),"Lowest Reading column name is not visible","Lowest Reading column name is visible");
        Validator.assertTrue(durometerColumnName.isVisible(),"Durometer Shore column name is not visible","Durometer Shore column name is visible");
        Validator.assertTrue(remainingCoverColumnName.isVisible(),"Remaining Cover % column name is not visible","Remaining Cover % column name is visible");










    }

    public void verifyColumnIsVisible()
    {
        waitForElementVisible(corporateColumnHeader,10000,500);
        Validator.assertTrue(corporateColumnHeader.isVisible(),"selected column is not displayed","selected column is displayed");

    }

    public void selectColumnName()
    {
        waitForElementVisible(corporateColumnName,5000,500);
        corporateColumnName.click();

    }
    public void clickOnColumn()
    {
        waitForElementVisible(coverGradeColumn,5000,500);
        coverGradeColumn.click();

    }

    private List<String> getColumnData(int columnNumber) {
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
        List<String> columnData = new ArrayList<>();
        for (WebElement row : rows) {
            WebElement cell = row.findElement(By.xpath("./td[" + columnNumber + "]"));
            columnData.add(cell.getText().trim());
        }
        return columnData;
    }

    public void verifyIncreasingOrderSorting()
    {
        int columnNumber = 5; // Example: retrieve data from the 5th column
        List<String> columnDataAfterSortingIncreasing = getColumnData(columnNumber);
        List<String> expectedSortedDataIncreasing = new ArrayList<>(columnDataAfterSortingIncreasing);
        expectedSortedDataIncreasing.sort(null);
        Validator.assertTrue(columnDataAfterSortingIncreasing.equals(expectedSortedDataIncreasing), "Sorting in increasing order is not applied correctly","sorting is applied in increasing order");

    }

    public void verifyDecreasingOrderSorting()
    {
        int columnNumber = 5; // Example: retrieve data from the 5th column
        List<String> columnDataAfterSortingDecreasing = getColumnData(columnNumber);
        List<String> expectedSortedDataDecreasing = new ArrayList<>(columnDataAfterSortingDecreasing);
        expectedSortedDataDecreasing.sort(Collections.reverseOrder());
        // Compare the values of the column data after sorting with the expected sorted data (decreasing order)
        Validator.assertTrue(columnDataAfterSortingDecreasing.equals(expectedSortedDataDecreasing), "Sorting in decreasing order is not applied correctly","sorting is applied in decreasing order");

    }
    int redCount = 0;
    int yellowCount = 0;
    int greenCount = 0;
    public void getCountFromDurometer()
    {


        for(int i=1;i<=8;i++)
        {
            SyncUtil.waitFor(10000);
//            waitForPageLoad(10000);
            String durometerXpath = "//table//tr[" + i + "]/td[6]//span"; // Replace this with the actual XPath for durometer value
            String lifecycleXpath = "//table//tr[" + i + "]/td[8]//span"; // Replace this with the actual XPath for lifecycle value
            waitForElementVisible(driver.findElement(By.xpath(durometerXpath)),5000,500);
            waitForElementVisible(driver.findElement(By.xpath(lifecycleXpath)),5000,500);


            WebElement durometerElement = driver.findElement(By.xpath(durometerXpath));
            WebElement lifecycleElement = driver.findElement(By.xpath(lifecycleXpath));

            // Extract numeric values from elements
            int durometerValue = extractNumericValue(durometerElement.getText());

            int lifecycleValue = extractNumericValue(lifecycleElement.getText());

            String color = getHighestPriorityColor(durometerValue, lifecycleValue);

            switch (color) {
                case "red":
                    redCount++;
                    break;
                case "yellow":
                    yellowCount++;
                    break;
                case "green":
                    greenCount++;
                    break;
            }
//
        }
        System.out.println("Red count: " + redCount);
        System.out.println("green count: " + greenCount);
        System.out.println("yellow count: " + yellowCount);


    }
    public void verifyYellowCount()
    {
        waitForPageLoad(10000);
//        SyncUtil.waitFor(10000);
        getCountFromDurometer();
        WebElement element = driver.findElement(By.xpath("(//app-card//div[text()='Cover Wear']/following-sibling::div[contains(@class,'footer-count')]/div[2]/div[@class='conti-round'])[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String tileValue = (String) js.executeScript("return arguments[0].textContent;", element);
        System.out.println("TextYellow: " + tileValue);
        Assert.assertEquals(yellowCount,parseInt(tileValue),"The yellowCount does not match");

    }
    public void verifyRedCount()
    {
        waitForPageLoad(10000);
        getCountFromDurometer();
        WebElement element = driver.findElement(By.xpath("(//app-card//div[text()='Cover Wear']/following-sibling::div[contains(@class,'footer-count')]/div[3]/div[@class='conti-round'])[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String tileValue = (String) js.executeScript("return arguments[0].textContent;", element);
        System.out.println("TextRed: " + tileValue);
        Assert.assertEquals(redCount,parseInt(tileValue),"The redCount does not match");

    }

    public void verifyGreenCount()
    {
        waitForPageLoad(10000);
        getCountFromDurometer();
        WebElement element = driver.findElement(By.xpath("(//app-card//div[text()='Cover Wear']/following-sibling::div[contains(@class,'footer-count')]/div[1]/div[@class='conti-round'])[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String tileValue = (String) js.executeScript("return arguments[0].textContent;", element);
        System.out.println("TextGreen: " + tileValue);
        Assert.assertEquals(greenCount,parseInt(tileValue),"The redCount does not match");

    }


    private String getHighestPriorityColor(double durometer, double lifecycle) {
        String durometerStatus;
        if (durometer < 45 || durometer >= 83) {
            durometerStatus = "red";
        } else if (durometer >= 45 && durometer < 55) {
            durometerStatus = "yellow";
        } else if (durometer >= 55 && durometer <= 73) {
            durometerStatus = "green";
        } else if (durometer > 73 && durometer < 83) {
            durometerStatus = "yellow";
        } else {
            durometerStatus = "unknown";
        }

        String lifecycleStatus;
        if (lifecycle < 10) {
            lifecycleStatus = "red";
        } else if (lifecycle <= 20) {
            lifecycleStatus = "yellow";
        } else if (lifecycle > 30) {
            lifecycleStatus = "green";
        } else {
            lifecycleStatus = "unknown";
        }

        // Compare the statuses based on priority
        if ((durometerStatus.equals("red") && lifecycleStatus.equals("red")) ||
                (durometerStatus.equals("red") && lifecycleStatus.equals("yellow")) ||
                (durometerStatus.equals("yellow") && lifecycleStatus.equals("red"))||
            (durometerStatus.equals("red") && lifecycleStatus.equals("green"))||
        (durometerStatus.equals("green") && lifecycleStatus.equals("red")))

        {
            return "red";
        } else if ((durometerStatus.equals("yellow") && lifecycleStatus.equals("yellow")) ||
                (durometerStatus.equals("green") && lifecycleStatus.equals("yellow")) ||
                (durometerStatus.equals("yellow") && lifecycleStatus.equals("green"))) {
            return "yellow";
        } else if((durometerStatus.equals("green") && lifecycleStatus.equals("green"))) {
            return "green";
        }
        return "yellow";

    }

    private static int extractNumericValue(String text) {
        String numericText = text.replaceAll("\\D", ""); // This removes all non-digit characters
        return parseInt(numericText);

    }
    public void verifyPositionBreadCrumb(String position,String conveyor,String site,String corporate)
    {
        waitForElementVisible(positionBreadcrumb,10000,500);
        Validator.assertTrue(positionBreadcrumb.isDisplayed(), "Breadcrumb element is not displayed","Breadcrumb text is displayed");
        Assert.assertEquals(positionBreadcrumb.getText(), "Home\nCorporates\n"+corporate+"\n"+site+"\n"+conveyor+"\n"+position, "Breadcrumb text does not match expected");


    }

    public void conveyorNameClick()
    {
        waitForElementVisible(conveyorBreadCrumb,5000,500);
        conveyorBreadCrumb.jsClick("Conveyor name");

    }

    public void verifyGaugeImageInSpec(){
        waitForPageLoad(5000);
        waitForElementVisible(imgGaugeMeter,10000,1000);
        Validator.assertTrue(imgGaugeMeter.isDisplayed(),"Guaze meter is not displayed","Guaze meter is displayed");
    }



    public void extractPositionData()
    {
        waitForElementVisible(txtValDurometer,5000,500);
         String duro_meterValue=txtValDurometer.getText();
         getBundle().setProperty("durometerTxtValue",duro_meterValue);
        System.out.println(duro_meterValue+"durometer value variable");
        System.out.println(txtValDurometer.getText()+"durometer value");

        waitForElementVisible(txtValRemainingLife,5000,500);
        String remainingLifeValue=  txtValRemainingLife.getText();
        getBundle().setProperty("remainingLifeTxtValue",remainingLifeValue);
        System.out.println(remainingLifeValue+"txtValRemainingLife value variable");
        System.out.println(txtValRemainingLife.getText()+"txtValRemainingLife value");

        waitForElementVisible(txtValRemainingCover,5000,500);
         String remainingCoverValue=txtValRemainingCover.getText();
         getBundle().setProperty("remainingCoverTxtValue",remainingCoverValue);
        System.out.println(remainingCoverValue+"txtValRemainingCover value variable");
        System.out.println(txtValRemainingCover.getText()+"txtValRemainingCover value");

    }
    public void verifyDataInGaugeMeter()
    {
        waitForPageLoad(10000);
        waitForElementVisible(gaugeValRemainingCover,10000,500);
        Validator.assertTrue(gaugeValRemainingCover.isVisible(),"The remaining cover % value is not displayed in gauge image","The remaining cover % value is  displayed in gauge image");
        Validator.assertTrue(gaugeValRemainingLife.isVisible(),"The remaining life value is not displayed in gauge image","The remaining life value is  displayed in gauge image");
        Validator.assertTrue(gaugeValDurometer.isVisible(),"The duro meter value is not displayed in gauge image","The duro meter value is  displayed in gauge image");
        Validator.assertTrue(gaugePercentageRange.isVisible(),"The duro meter range value is not displayed in gauge image","The duro meter range value is displayed in gauge image");
    }

    public void verifyGaugeDataAndTableData()
    {
        String actualDurometerText = gaugeValDurometer.getText().toString();
        String actualNumericDurometerValue = actualDurometerText.split("\\s+")[0];
        Assert.assertEquals(getBundle().getProperty("durometerTxtValue"),actualNumericDurometerValue,"the duro meter values are not same");
        Assert.assertEquals(getBundle().getProperty("remainingCoverTxtValue"),gaugeValRemainingCover.getText(),"the remaining cover  values are not same");
        Assert.assertEquals(getBundle().getProperty("remainingLifeTxtValue"),gaugeValRemainingLife.getText(),"the remaining life values are not same");

    }

    public void btnAddMeasurementClick()
    {
        waitForElementVisible(btAddMeasurement,10000,500);
        btAddMeasurement.jsClick();

    }

    public void verifyAddMeasurementPopupVisible()
    {
        waitForElementVisible(measurementPopup,10000,500);
        Validator.assertTrue(measurementPopup.isVisible(),"the add measurement popup is not visible","the add measurement popup is visible");

    }

    public void verifyAddDetailsFields()
    {
        waitForElementVisible(tbDeviceType,10000,500);
        Validator.assertTrue(tbDeviceType.isVisible(),"The deviceType field is not visible","The deviceType field is  visible");
        Validator.assertTrue(tbVelocity.isVisible(),"The velocity field is not visible","The velocity field is  visible");
        Validator.assertTrue(tbCalibrationThickness.isVisible(),"The CalibrationThickness field is not visible","The CalibrationThickness field is  visible");
        Validator.assertTrue(tbSurfaceTemperature.isVisible(),"The SurfaceTemperature field is not visible","The SurfaceTemperature field is  visible");
        Validator.assertTrue(tbTestPosition.isVisible(),"The TestPosition field is not visible","The TestPosition field is  visible");

    }
    public void addDeviceMeasurementValues(String instrument,String velocity,String calibrationThickness,String surfaceTemperature,String testPosition)
    {
        waitForElementVisible(tbDeviceType,10000,500);
        tbDeviceType.type(instrument,"device type");
        tbVelocity.type(velocity,"velocity");
        tbCalibrationThickness.type(calibrationThickness,"calibrationThickness");
        tbSurfaceTemperature.type(surfaceTemperature,"surfaceTemperature");
        tbTestPosition.type(testPosition,"testPosition");

    }
    public void typeReadingValues(String value){
        for(int i=1;i<8;i++)
        {
            WebElement reading=  driver.findElement(By.xpath("(//td[@id='datapointmeasurement']//input)["+i+"]"));
//            reading.clear();
            reading.sendKeys(value);
        }
    }
    public void addMeasurementReadingsValue(String durometerValue,String value){
        waitForPageLoad(5000);
        waitForElementVisible(inpdurometerValue,10000,1000);
        inpdurometerValue.type(durometerValue);
        typeReadingValues(value);
    }

    public void btnSaveClick()
    {
        SyncUtil.waitFor(5000);
        waitForElementVisible(btnSave,10000,500);
        btnSave.jsClick();
        waitForPageLoad(10000);

    }
    public void btnEditClick()
    {
        waitForPageLoad(10000);
        SyncUtil.waitFor(5000);
//        waitForElementVisible(trAddedMeasurement,10000,500);
        waitForElementVisible(btnEdit,10000,500);
        waitForElementToBeClickable(btnEdit);
        btnEdit.jsClick();
    }

    public void verifyUserEnteredData(String surfaceTemperature,String position)
    {
        waitForPageLoad(10000);
        SyncUtil.waitFor(10000);
        waitForElementVisible(tbSurfaceTemperature,10000,500);
        System.out.println(tbSurfaceTemperature.getAttribute("value")+"TESTPOSITIONVALUE");
        //SHOWING EMPTY
        Assert.assertEquals(surfaceTemperature,tbSurfaceTemperature.getAttribute("value"),"the user entered data is not present");

    }

    public void extractDateValue() {
        waitForElementVisible(tdInstalledDateTableValue, 10000, 500);
        String installedDate = tdInstalledDateTableValue.getText();

        // Parse the date from the original format "24 Apr 2024"
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd MMM yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("MMM, dd, yyyy");
        try {
            Date date = inputFormat.parse(installedDate);
            String formattedDate = outputFormat.format(date);

            // Store the formatted date in properties or wherever needed
            getBundle().setProperty("installedDateTb", formattedDate);
            System.out.println(getBundle().getProperty("installedDateTb")+"value of installed date");
        } catch (ParseException e) {
            // Handle parsing exception
            e.printStackTrace();
        }
    }

    public void verifyInstalledDates()
    {
        waitForPageLoad(10000);
        waitForElementVisible(tdInstalledDateDetailValue,10000,500);
        String actualText = tdInstalledDateDetailValue.getText();
        String actualDate = actualText.replace("(Installed date)", "").trim(); // Remove prefix and trim whitespace
        Assert.assertEquals(getBundle().getProperty("installedDateTb"), actualDate, "The installed dates don't match");

    }

    public void  verifyAttachmentLinkVisible()
    {
        waitForElementVisible(btnAttachmentLink,10000,500);
        Validator.assertTrue(btnAttachmentLink.isVisible(),"The attachment link is not visible for installed data","The attachment link is visible for installed data");

    }

    public void  verifyEditLinkVisible()
    {
        waitForElementVisible(btnEditLink,10000,500);
        Validator.assertTrue(btnEditLink.isVisible(),"The edit link is not visible for installed data","The edit link is visible for installed data");

    }

    public void btnCloseClick()
    {
        waitForElementVisible(btnClose,1000,500);
        waitForElementToBeClickable(btnClose);
        btnClose.jsClick();
        waitForPageLoad(10000);
    }

    public void btnDeleteClick()
    {
        waitForElementVisible(btnDelete,10000,500);
        waitForElementToBeClickable(btnDelete);
        btnDelete.jsClick();
        waitForElementVisible(dialogConfirm,10000,500);
        Validator.assertTrue(dialogConfirm.isVisible(),"The dialog to delete measurement is not visible","The dialog to delete measurement is visible");
        waitForElementVisible(dialogConfirmAccept,10000,500);
        dialogConfirmAccept.jsClick();
        Validator.assertTrue(btnEdit.verifyNotPresent(),"The measurement is not deleted","The measurement is deleted");
    }

    public void editBtnClick()
    {
        waitForElementVisible(btnEditLink,10000,500);
        btnEditLink.jsClick();

    }

    public void verifyMeasurementTableData()
    {
        waitForPageLoad(10000);
        waitForElementVisible(wearMeasurementTable,10000,500);
        Validator.assertTrue(wearMeasurementTable.isVisible(),"The wear measurement table is not visible","The wear measurement table is  visible");
        SyncUtil.waitFor(5000);
        waitForElementVisible(tdInstalledDateDetailValue,10000,500);
        Validator.assertTrue(tdInstalledDateDetailValue.isVisible(),"The wear measurement table data is visible","The wear measurement table data is  visible");
    }
    public void verifyAttachmentHighlight()
    {
        waitForElementVisible(lnkAttachmentDisabled,10000,500);
        Validator.assertTrue(lnkAttachmentDisabled.isVisible(),"The background is not highlighted","The background is highlighted");

    }

    public void verifyUploadedImage()
    {
        waitForPageLoad(20000);
        SyncUtil.waitFor(10000);
        Validator.assertTrue(lnkAttachmentDisabled.verifyNotPresent(),"The image upload is not successfull","The image upload is successfull");
    }

    public void verifyAttachBackgroundRemoved()
    {
        waitForPageLoad(20000);
        SyncUtil.waitFor(5000);
        Validator.assertTrue(lnkAttachmentDisabled.verifyNotPresent(),"The image upload is not successfull","The image upload is successfull");
    }

    public void addMoreAttachmentsClick()
    {
        waitForElementVisible(btnAddMoreAttachments,10000,500);
        btnAddMoreAttachments.jsClick("add more attachments");
        waitForPageLoad(10000);

    }

    public void verifyAttachmentImageUploaded()
    {
        waitForElementToInvisible(progressLoader,20000);
        waitForElementVisible(corrosalImage,20000,1000);
        Validator.assertTrue(corrosalImage.isVisible(),"Additional images is not displayed","Additional images is displayed");

    }

    public void clickImageInCorrosal()
    {
        waitForElementVisible(corrosalImage,20000,1000);
        corrosalImage.click();
    }

    public void verifyCorrosalImageMaximazed()
    {
        waitForElementVisible(corrosalImage,20000,1000);
        waitForElementVisible(corrosalViewImage,20000,1000);
        corrosalImage.click();
        Validator.assertTrue(corrosalImage.getAttribute("src").equalsIgnoreCase(corrosalViewImage.getAttribute("src")),"Image is not maximized","Image is maximized");
    }

    public void clickOnDeleteAndVerify()
    {
        waitForElementVisible(btnCorrosalDeleteImg,20000,1000);
        waitForElementToBeClickable(btnCorrosalDeleteImg);
        btnCorrosalDeleteImg.click();
        waitForElementVisible(dialogConfirmAccept,10000,500);
        dialogConfirmAccept.jsClick();
        waitForElementToInvisible(progressLoader,20000);
        System.out.println(corrosalImage.verifyNotPresent()+"aaaa");
        Validator.assertTrue(corrosalImage.verifyNotPresent(),"Images is not deleted","Images is deleted");
        waitForElementVisible(btnDialogClose,10000,500);
        btnDialogClose.jsClick();
        waitForPageLoad(10000);

    }

    public void deleteMeasurementImage()
    {
        waitForElementVisible(btnMeasurementImageDelete,10000,500);
        btnMeasurementImageDelete.jsClick();
        SyncUtil.waitFor(10000);
        btnSaveClick();
        waitForPageLoad(20000);
        verifyAttachmentHighlight();
    }




}
