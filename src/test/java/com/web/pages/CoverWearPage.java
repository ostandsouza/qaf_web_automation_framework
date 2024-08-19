package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.PDFHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import groovyjarjarantlr4.v4.codegen.model.Sync;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.common.utils.MiscUtils.convertDateFormat;
import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static java.io.File.separator;
import static java.lang.Math.abs;

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

    @FindBy(locator = "xpath=//span[@class='p-button-icon ctp-icon-Add-circle']")
    public CustomElement btAdd;

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

    @FindBy(locator="xpath=(//app-card//div[text()='Cover Wear'])[2]")
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

    @FindBy(locator="xpath=//h4[text()='Positions']")
    public CustomElement positionHeading;

    @FindBy(locator="xpath=//span[text()='Wear Trend']")
    public CustomElement wearTrendHeading;

    @FindBy(locator="xpath=//span[@class='p-button-icon pi pi-download']")
    public CustomElement measurementDownload;

    @FindBy(locator="xpath=(//span[@class='p-button-icon ctp-icon-Edit'])[2]")
    public CustomElement editMeasurement;

    @FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[1]")
    public CustomElement cwAddNewMeasurement;

    @FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Delete'])[1]")
    public CustomElement measurementDelete;

    @FindBy(locator="xpath=//th[@id='name-col']")
    public CustomElement hdConveyor;

    @FindBy(locator="xpath=//th[@id='site-col']")
    public CustomElement hdSite;

    @FindBy(locator="xpath=//th[@psortablecolumn='installedDate']")
    public CustomElement hdInstalledDate;

    @FindBy(locator="xpath=//th[@id='install-col']")
    public CustomElement hdCoverGrade;

    @FindBy(locator="xpath=//th[@id='process-col']")
    public CustomElement hdDurometer;

    @FindBy(locator="xpath=//th[@id='belt-col']")
    public CustomElement hdRemainingLife;

    @FindBy(locator="xpath=//th[@id='inspec-col']")
    public CustomElement hdRemainingCover;

    @FindBy(locator="xpath=//th[@id='more-col']")
    public CustomElement hdMore;

    @FindBy(locator="xpath=//div[@aria-label='dropdown trigger']")
    public CustomElement btPgDropDown;

    @FindBy(locator="xpath=(//li[@role='option'])[1]")
    public CustomElement ddlPaginationFirstValue;

    @FindBy(locator="xpath=(//li[@role='option'])[2]")
    public CustomElement ddlPaginationSecondValue;

    @FindBy(locator="xpath=(//li[@role='option'])[3]")
    public CustomElement ddlPaginationThirdValue;

    @FindBy(locator="xpath=//anglerighticon")
    public CustomElement btPgNext;

    @FindBy(locator="xpath=//button[@class='p-ripple p-element p-paginator-page p-paginator-element p-link ng-star-inserted p-highlight']")
    public CustomElement btPgHighlightedValue;

    @FindBy(locator="//div[@role='dialog']")
    public CustomElement dialogBox;

    @FindBy(locator="//input[@formcontrolname='tonsConveyedCurrent']/../label")
    public CustomElement tbTonsConveyedCurrentlabel;

    @FindBy(locator="//input[@formcontrolname='temperature']/../label")
    public CustomElement tbTemperaturelabel;

    @FindBy(locator="//td[@id='durometer']//input")
    public CustomElement inpdurometerValue;

    @FindBy(locator="xpath=//input[@formcontrolname='deviceType']")
    public CustomElement deviceInstrumentField;

    @FindBy(locator="xpath=//input[@formcontrolname='velocity']")
    public CustomElement velocityField;

    @FindBy(locator="xpath=//input[@formcontrolname='calibrationThickness']")
    public CustomElement calibrationThicknessField;

    @FindBy(locator="xpath=//input[@formcontrolname='surfaceTemperature']")
    public CustomElement surfaceTemperatureField;

    @FindBy(locator="xpath=//input[@formcontrolname='testPosition']")
    public CustomElement testPositionField;

    @FindBy(locator="xpath=//input[@formcontrolname='conveyor']")
    public CustomElement conveyorField;

    @FindBy(locator="xpath=//input[@formcontrolname='customer']")
    public CustomElement siteField;

    @FindBy(locator="xpath=//li[@class='topbar-item scale']")
    public CustomElement unitIcon;

    @FindBy(locator="xpath=//h6[text()='Metric']/../..//div[@class='p-radiobutton p-component p-radiobutton-checked']")
    public CustomElement cbMetricUnit;

    @FindBy(locator="xpath=//h6[text()='Imperial']/../..//div[@class='p-radiobutton p-component p-radiobutton-checked']")
    public CustomElement cbImperialUnit;

    @FindBy(locator="xpath=//h6[text()='Metric']")
    public CustomElement btMetricUnit;

    @FindBy(locator="xpath=//h6[text()='Imperial']")
    public CustomElement btImperialUnit;

    @FindBy(locator="xpath=//input[@formcontrolname='beltWidth']/../../label")
    public CustomElement beltWidthFieldLabel;

    @FindBy(locator="xpath=//input[@formcontrolname='beltWidth']")
    public CustomElement beltWidthField;

    @FindBy(locator="xpath=//div[@class='gauge-container']//app-durometer")
    public CustomElement imgGuazeMeter;

    @FindBy(locator="xpath=//div[@class='center-label']//span")
    public CustomElement getCwRemainingCoverPercent;

    @FindBy(locator="xpath=//span[text()='Wear Rate Statistics & Projections']")
    public CustomElement hdWearRateStatTable;

    @FindBy(locator="xpath=//th[@id='site-col']//p[2]")
    public CustomElement thYearsUnit;

    @FindBy(locator="xpath=(//p[text()='Estimate Total Life']/../p[2])[2]")
    public CustomElement thEstTotalLifeUnit;

    @FindBy(locator="xpath=//p[text()='Est. Total Cost per Year']/../p[2]")
    public CustomElement thEstTotalCostPerLifeUnit;

    @FindBy(locator="xpath=//th[@id='name-col']")
    public CustomElement thTonsConveyed;
    @FindBy(locator="xpath=//th[@id='site-col']")
    public CustomElement thYears;

    @FindBy(locator="xpath=//p[text()='Wear rate']")
    public CustomElement thWearRate;
    @FindBy(locator="xpath=//p[text()='Projected Future Tons']")
    public CustomElement thProjectedFutureTons;
    @FindBy(locator="xpath=//p[text()='Projected Future Life']")
    public CustomElement thProjectedFutureLife;
    @FindBy(locator="xpath=(//p[text()='Estimate Total Life'])[1]")
    public CustomElement thEstTotalLifeTons;

    @FindBy(locator="xpath=(//p[text()='Estimate Total Life'])[2]")
    public CustomElement thEstTotalLifeYears;

    @FindBy(locator="xpath=//p[text()='Est. Total Cost per Ton']")
    public CustomElement thEstTotalCostPerTonLife;

    @FindBy(locator="xpath=//p[text()='Est. Total Cost per Year']")
    public CustomElement thEstTotalCostPerYearLife;

    @FindBy(locator="xpath=//div[@class='col']")
    public CustomElement hdPositionName;
    @FindBy(locator="xpath=//div[@class='col-12 subtitle']")
    public CustomElement hdSpecificationValue;

    @FindBy(locator="xpath=//div[@class='col-6 date']")
    public CustomElement hdDateOfInstallation;

    @FindBy(locator="xpath=//div[@class='col-6 durometer']")
    public CustomElement hdNewDurometerValue;

    @FindBy(locator="xpath=//span[text()='CV Common Regression']")
    public CustomElement hdCoverWearBreadCrumb;

    @FindBy(locator="xpath=//span[text()='Installed Belt']")
    public CustomElement hdInstalledBelt;

    @FindBy(locator="xpath=//label[text()='Installation Date']/..//p-calendar//input")
    public CustomElement  ddInstallationDateValue;

    @FindBy(locator="xpath=(//label[text()='Belt Construction']/../app-master-data-picker//div//input)[2]")
    public CustomElement  ddBeltConstructionValue;

    @FindBy(locator="xpath=(//label[text()='Width']/..//div//input)[2]")
    public CustomElement  ddBeltWidthValue;

    @FindBy(locator="xpath=(//label[text()='Top Cover Compound']/../app-master-data-picker//div//input)[2]")
    public CustomElement  ddTopCoverCompoundValue;

    @FindBy(locator="xpath=(//label[text()='Bottom Cover Compound']/../app-master-data-picker//div//input)[2]")
    public CustomElement  ddBottomCoverCompoundValue;

    @FindBy(locator="xpath=(//label[text()='Top Cover Thickness']/..//div//input)[2]")
    public CustomElement  ddTopCoverThicknessValue;

    @FindBy(locator="xpath=(//label[text()='Bottom Cover Thickness']/..//div//input)[2]")
    public CustomElement  ddBottomCoverThicknessValue;

    @FindBy(locator="xpath=//span[text()='Wear Profile']")
    public CustomElement hdWearProfile;

    @FindBy(locator="xpath=//h4[text()='Positions']")
    public CustomElement hdPositionTable;

    @FindBy(locator="xpath=//th[@id='name-col']")
    public CustomElement hdPosition;

    @FindBy(locator="xpath=//th[@psortablecolumn='tonsConveyed']")
    public CustomElement hdTonsConveyed;

    @FindBy(locator="xpath=//th[@psortablecolumn='ageToDate']")
    public CustomElement hdAgeToDate;

    @FindBy(locator="xpath=//th[@psortablecolumn='lastRecorded']")
    public CustomElement hdLastRecorded;

    @FindBy(locator="xpath=//th[@psortablecolumn='lowestReading']")
    public CustomElement hdLowestReading;

    @FindBy(locator="xpath=//p-dialog//input[@formcontrolname='customer']")
    public CustomElement tbCustomer;

    @FindBy(locator="xpath=//p-dialog//input[@formcontrolname='conveyor']")
    public CustomElement tbConveyor;

    @FindBy(locator="xpath=//p-dialog//input[@formcontrolname='width']")
    public CustomElement tbWidth;

    @FindBy(locator="xpath=//p-dialog//input[@formcontrolname='segment']")
    public CustomElement tbSegment;
    @FindBy(locator="xpath=//p-dialog//input[@formcontrolname='tonsConveyed']")
    public CustomElement tbTonsConveyed;

    @FindBy(locator="xpath=//p-dialog//input[@formcontrolname='durometer']")
    public CustomElement tbDurometer;

    @FindBy(locator="xpath=//input[@value='top']")
    public CustomElement tbTop;

    @FindBy(locator="xpath=//input[@value='top']//../../div[2]")
    public CustomElement rbtTop;

    @FindBy(locator = "xpath=//p-dialog//span[text()='Save']")
    public CustomElement btSave;

    @FindBy(locator = "xpath=(//td[2]//span)[2]")
    public CustomElement txtPosition;

    @FindBy(locator="xpath=//div[@class='durometer-container']")
    public CustomElement btGuazeMeter;

    @FindBy(locator="xpath=//input[@formcontrolname='customer']/../../label")
    public CustomElement txtSite;

    @FindBy(locator="xpath=//input[@formcontrolname='conveyor']/../../label")
    public CustomElement txtConveyor;

    @FindBy(locator="xpath=//input[@formcontrolname='beltWidth']/../../label")
    public CustomElement txtBeltWidth;

    @FindBy(locator="xpath=//app-master-data-picker[@parentmasterformcontrolname='topCoverThicknessNominal']//../label")
    public CustomElement txtTopCoverThicknessNominal;

    @FindBy(locator="xpath=//app-master-data-picker[@parentmasterformcontrolname='bottomCoverThicknessNominal']//../label")
    public CustomElement txtBottomCoverThicknessNominal;
    @FindBy(locator="xpath=//input[@formcontrolname='beltLength']/../../label")
    public CustomElement txtBeltLength;

    @FindBy(locator="xpath=//app-master-data-picker[@parentmasterformcontrolname='topCoverThicknessActual']//../label")
    public CustomElement txtTopCoverThicknessActual;

    @FindBy(locator="xpath=//app-master-data-picker[@parentmasterformcontrolname='bottomCoverThicknessActual']//../label")
    public CustomElement txtBottomCoverThicknessActual;

    @FindBy(locator="xpath=//p-dropdown[@formcontrolname='numberOfDatapoints']/../label")
    public CustomElement txtNoOfDatapoints;

    @FindBy(locator="xpath=//input[@formcontrolname='durometer']/../../label")
    public CustomElement txtDurometer;

    @FindBy(locator="xpath=//input[@formcontrolname='priceOfBelt']/../../label")
    public CustomElement txtPriceOfBelt;

    @FindBy(locator="xpath=//input[@formcontrolname='numberOfColumns']/../../label")
    public CustomElement txtNoOfColumns;

    @FindBy(locator="xpath=//app-master-data-picker[@parentmasterformcontrolname='topCoverCompound']//../label")
    public CustomElement txtTopCoverCompound;

    @FindBy(locator="xpath=//app-master-data-picker[@parentmasterformcontrolname='bottomCoverCompound']//../label")
    public CustomElement txtBottomCoverCompound;

    @FindBy(locator="xpath=//app-master-data-picker[@parentmasterformcontrolname='topCoverCriticalThickness']//../label")
    public CustomElement txtTopCoverCriticalThickness;

    @FindBy(locator="xpath=//app-master-data-picker[@parentmasterformcontrolname='topCoverPoorThickness']//../label")
    public CustomElement txtTopCoverPoorThickness;

    @FindBy(locator="xpath=//app-master-data-picker[@parentmasterformcontrolname='bottomCoverCriticalThickness']//../label")
    public CustomElement txtBottomCoverCriticalThickness;

    @FindBy(locator="xpath=//app-master-data-picker[@parentmasterformcontrolname='bottomCoverPoorThickness']//../label")
    public CustomElement txtBottomCoverPoorThickness;

   @FindBy(locator="xpath=//label[text()='Include']")
    public CustomElement hdInclude;

    @FindBy(locator="xpath=//label[text()='Position']")
    public CustomElement hdPositionExportPop;

    @FindBy(locator="xpath=//button[@icon='pi pi-download']")
    public CustomElement btReportDownload;

    @FindBy(locator="xpath=//input[@placeholder='Search']")
    public CustomElement btSearchinput;

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
        SyncUtil.waitFor(2000);
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
        SyncUtil.waitFor(2000);
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

    public void goToThePositionDetailScreen(String positionName) {
        searchPosition(positionName);
        waitForElementToDisplay(cwViewIcon);
        cwViewIcon.click("Position Detail");
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
        Validator.assertTrue(Options.size() == Integer.parseInt(count),"Position dropdown is showing incorrect positions","Position dropdown verified successfully");
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
        waitForElementVisible(cwSave,5000,1000);
        waitForElementToBeClickable(cwSave);
        cwSave.click("Save");
        waitForElementToInvisible(cwSpecsLoader,40000);
        Validator.assertTrue(!(tonsConveyedCurrent.isVisible()),"Add Measurement window was not closed after save","Add measurement window was closed successfully");
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
        val = Integer.parseInt(calendarYear.getText("Calendar year")) - Integer.parseInt(year);
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
        attachmentBtn.click("Attachment Btn");
        return imgDialog.isVisible("Image dialog");
    }

    public boolean closeAttachment() {
        closeImgDialog.click("Attachment Close Btn");
        return !imgDialog.isNotVisible(1000);
    }

    public boolean editMeasurement() {
        scrollPageup();
        editBtn.click("Edit Measurement");
        return cwConveyorInput.isVisible("Conveyor Inout");
    }

    public boolean editFunctionality(String thickness, String durometer) {
        durometerMeasurement.stream().forEach(x -> x.sendKeys(durometer));
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

    public boolean verifyViewRights(String ConveyorName) {
        searchCoverWear(ConveyorName);
        waitForElementToDisplay(cwCheckbox);
        cwCheckbox.check("CoverWear Checkbox");
        cwActions.click("Actions");
        return cwAddNew.isNotVisible(1000) && cwEdit.isNotVisible(1000) && cwDelete.isNotVisible(1000);
    }
    public boolean verifyViewAndAddRights(String ConveyorName) {
        searchCoverWear(ConveyorName);
        waitForElementToDisplay(cwCheckbox);
        cwCheckbox.check("CoverWear Checkbox");
        cwActions.click("Actions");
        return cwAddNew.isVisible(1000) && cwEdit.isNotVisible(1000) && cwDelete.isNotVisible(1000);
    }

    public boolean verifyViewAndEditRights(String ConveyorName) {
        searchCoverWear(ConveyorName);
        waitForElementToDisplay(cwCheckbox);
        cwCheckbox.check("CoverWear Checkbox");
        cwActions.click("Actions");
        return cwAddNew.isNotVisible(1000) && cwEdit.isVisible(1000) && cwDelete.isNotVisible(1000);
    }

    public boolean verifyViewAndDeleteRights(String ConveyorName) {
        searchCoverWear(ConveyorName);
        waitForElementToDisplay(cwCheckbox);
        cwCheckbox.check("CoverWear Checkbox");
        cwActions.click("Actions");
        return cwAddNew.isNotVisible(1000) && cwEdit.isNotVisible(1000) && cwDelete.isVisible(1000);

    }
    public boolean verifyViewAndDownloadRights(String ConveyorName) {
        searchCoverWear(ConveyorName);
        waitForElementToDisplay(cwCheckbox);
        cwCheckbox.check("CoverWear Checkbox");
        cwActions.click("Actions");
        cwAddNew.isNotVisible(1000);
        cwEdit.isVisible(1000);
        cwDelete.isNotVisible(1000);
        return cwAddNew.isNotVisible(1000) && cwEdit.isNotVisible(1000) && cwDelete.isNotVisible(1000);
    }

    public boolean verifyViewRightsForSpecification(String ConveyorName) {
        cwViewIcon.click("CoverWear");
        SyncUtil.waitFor(8000);
        waitForElementToDisplay(positionHeading);
        waitForElementToDisplay(cwCheckbox);
        cwEditSpec.isNotVisible(1000);
        cwAddNew.isNotVisible(1000);
        cwCheckbox.check("CoverWear Checkbox");
        cwActions.click("Actions");
        return cwDelete.isNotVisible(1000) && cwEdit.isNotVisible(1000) && cwExport.isNotVisible(1000);
    }

    public boolean verifyViewAddRightsForSpecification(String ConveyorName) {
        cwViewIcon.click("CoverWear");
        SyncUtil.waitFor(10000);
        waitForElementToDisplay(positionHeading);
        waitForElementToDisplay(cwCheckbox);
        cwEditSpec.isNotVisible(1000);
        cwAddNew.isVisible(1000);
        cwCheckbox.check("CoverWear Checkbox");
        cwActions.click("Actions");
        return cwDelete.isNotVisible(1000) && cwEdit.isNotVisible(1000) && cwExport.isNotVisible(1000);
    }

    public boolean verifyViewEditRightsForSpecification(String ConveyorName) {
        cwViewIcon.click("CoverWear");
        SyncUtil.waitFor(10000);
        waitForElementToDisplay(positionHeading);
        waitForElementToDisplay(cwCheckbox);
        cwEditSpec.isVisible(1000);
        cwAddNew.isNotVisible(1000);
        cwCheckbox.check("CoverWear Checkbox");
        cwActions.click("Actions");
        return cwDelete.isNotVisible(1000) && cwEdit.isVisible(1000) && cwExport.isNotVisible(1000);
    }

    public boolean verifyViewDeleteRightsForSpecification(String ConveyorName) {
        cwViewIcon.click("CoverWear");
        SyncUtil.waitFor(10000);
        waitForElementToDisplay(positionHeading);
        waitForElementToDisplay(cwCheckbox);
        cwEditSpec.isNotVisible(1000);
        cwAddNew.isNotVisible(1000);
        cwCheckbox.check("CoverWear Checkbox");
        cwActions.click("Actions");
        return cwDelete.isNotVisible(1000) && cwEdit.isNotVisible(1000) && cwExport.isVisible(1000);
    }
    public boolean verifyViewDownloadRightsForSpecification(String ConveyorName) {
        cwViewIcon.click("CoverWear");
        SyncUtil.waitFor(10000);
        waitForElementToDisplay(positionHeading);
        waitForElementToDisplay(cwCheckbox);
        cwEditSpec.isNotVisible(1000);
        cwAddNew.isNotVisible(1000);
        cwCheckbox.check("CoverWear Checkbox");
        cwActions.click("Actions");
        return cwDelete.isNotVisible(1000) && cwEdit.isNotVisible(1000) && cwExport.isVisible(1000);
    }
    public boolean verifyViewRightsForMeasurement(String ConveyorName) {
        cwViewIcon.click("CoverWear");
        waitForElementToDisplay(wearTrendHeading);
        return cwAddNewMeasurement.isNotVisible(1000) && editMeasurement.isNotVisible(1000) && measurementDownload.isNotVisible(1000) && measurementDelete.isNotVisible(1000);

    }
    public boolean verifyViewAddRightsForMeasurement(String ConveyorName) {
        cwViewIcon.click("CoverWear");
        waitForElementToDisplay(wearTrendHeading);
        return cwAddNewMeasurement.isVisible(1000) && editMeasurement.isNotVisible(1000) && measurementDownload.isNotVisible(1000) && measurementDelete.isNotVisible(1000);
    }

    public boolean verifyViewEditRightsForMeasurement(String ConveyorName) {
        cwViewIcon.click("CoverWear");
        waitForElementToDisplay(wearTrendHeading);
        return cwAddNewMeasurement.isNotVisible(1000) && editMeasurement.isVisible(1000) && measurementDownload.isNotVisible(1000) && measurementDelete.isNotVisible(1000);
    }

    public boolean verifyViewDeleteRightsForMeasurement(String ConveyorName) {
        cwViewIcon.click("CoverWear");
        waitForElementToDisplay(wearTrendHeading);
        return cwAddNewMeasurement.isNotVisible(1000) && editMeasurement.isNotVisible(1000) && measurementDownload.isNotVisible(1000) && measurementDelete.isVisible(1000);
    }

    public boolean verifyViewDownloadRightsForMeasurement(String ConveyorName) {
        cwViewIcon.click("CoverWear");
        waitForElementToDisplay(measurementDownload);
        return cwAddNewMeasurement.isNotVisible(1000) && editMeasurement.isNotVisible(1000) && measurementDownload.isVisible(1000) && measurementDelete.isNotVisible(1000);
    }

    public void extractCoverGradeValue(){
        String cwValue= cwGrade.getText();
        getBundle().setProperty("coverWearValue", cwValue);
    }

    public String calculateCoverGradeValue(String topCoverValue, String bottomCoverValue) {
        if (topCoverValue.equals(bottomCoverValue)) {
            return topCoverValue;
        } else {
            return topCoverValue + "/" + bottomCoverValue;
        }
    }
    public void verifyCoverGradeValue(){
    waitForPageLoad(10000);
    waitForElementVisible(cwTopCoverCompoundInput,20000,1000);
    waitForElementVisible(cwBottomCoverCompoundInput,20000,1000);
    String topCoverValue= cwTopCoverCompoundInput.getText();
    String bottomCoverValue=cwBottomCoverCompoundInput.getText();
    String extCoverWearValue= calculateCoverGradeValue(topCoverValue,bottomCoverValue);
    String expectedValue = getBundle().getProperty("coverWearValue").toString();
    Assert.assertEquals(expectedValue, extCoverWearValue, "CoverWear value matched");
    }

    public void verifyCoverWearHeader(){
        waitForElementVisible(coverWearHeader,5000,1000);
        Validator.assertTrue(coverWearHeader.getText().contains("Cover Wear Summary"),"Cover Wear Summary is not visible","Cover Wear Summary is visible");
    }

    public void verifyCoverWearCoulmnName(){
        waitForElementVisible(hdConveyor,5000,1000);
        Validator.assertTrue(hdConveyor.getText().contains("Conveyor"),"Conveyor is not visible","Conveyor is visible");
        Validator.assertTrue(hdSite.getText().contains("Site"),"Site is not visible","Site is visible");
        Validator.assertTrue(hdInstalledDate.getText().contains("Installed Date"),"Installed Date is not visible","Installed Date is visible");
        Validator.assertTrue(hdCoverGrade.getText().contains("Cover Grade"),"Cover Grade is not visible","Cover Grade is visible");
        Validator.assertTrue(hdDurometer.getText().contains("Durometer Shore A"),"Durometer Shore A is not visible","Durometer Shore A is visible");
        Validator.assertTrue(hdRemainingLife.getText().contains("Remaining Life by Time"),"Remaining Life by Time is not visible","Remaining Life by Time is visible");
        Validator.assertTrue(hdRemainingCover.getText().contains("Remaining Cover %"),"Remaining Cover % is not visible","Remaining Cover % is visible");
        Validator.assertTrue(hdMore.getText().contains("More"),"More is not visible","More is visible");
    }

    public void verifyPaginationDropDown(){
        waitForPageLoad(10000);
        waitForElementVisible(cwConveyorName,10000,1000);
        waitForElementVisible(btPgDropDown,10000,1000);
        waitForElementToBeClickable(btPgDropDown);
        btPgDropDown.click();
        waitForElementVisible(ddlPaginationFirstValue,5000,1000);
        Validator.assertTrue(ddlPaginationFirstValue.getText().contains("10"),"Pagination value 10 is not displayed","Pagination value 10 is displayed");
        Validator.assertTrue(ddlPaginationSecondValue.getText().contains("25"),"Pagination value 25 is not displayed","Pagination value 25 is displayed");
        Validator.assertTrue(ddlPaginationThirdValue.getText().contains("50"),"Pagination value 50 is not displayed","Pagination value 50 is displayed");
    }

    public void verifyPaginationForwardArrowButton(){
        waitForElementVisible(btPgNext,5000,1000);
        waitForElementToBeClickable(btPgNext);
        btPgNext.jsClick();
        Validator.assertTrue(btPgHighlightedValue.getText().contains("2"),"Pagination is not present at 2","Pagination is present at 2");
    }

    public void clickAdd(){
        waitForElementVisible(cwAddNew,5000,1000);
        waitForElementToBeClickable(cwAddNew);
        cwAddNew.click();
        waitForElementVisible(dialogBox,5000,1000);
        Validator.assertTrue(dialogBox.isDisplayed(),"Dialogbox is not displayed","Dialogbox is displayed");
    }

    public void verifyNonMandatoryFields(){
        waitForPageLoad(4000);
        waitForElementVisible(tbTonsConveyedCurrentlabel,5000,1000);
        Validator.assertFalse(tbTonsConveyedCurrentlabel.getText().contains("*"),"TonsConveyedCurrent Mandatory field","TonsConveyedCurrent Not Mandatory field");
        waitForElementVisible(tbTemperaturelabel,5000,1000);
        Validator.assertFalse(tbTemperaturelabel.getText().contains("*"),"Temperature Mandatory field","Temperature Not Mandatory field");
    }

    public void addMeasurmentPopUpFields(String CustSiteName,String ConveyorName,String Position){
        waitForPageLoad(5000);
        dropdownSelectSearch(cwSiteDropDown, cwInput, CustSiteName);
        waitForPageLoad(10000);
        dropdownSelectSearch(cwConveyorDropDown, cwInput, ConveyorName);
        waitForElementVisible(cwPositionDropDown,5000,500);
        dropdownSelect(cwPositionDropDown, ListItem, Position); }

    public void typeReadingValues(String value){
        for(int i=1;i<8;i++)
        {
            WebElement reading=  driver.findElement(By.xpath("(//td[@id='datapointmeasurement']//input)["+i+"]"));
            reading.clear();
            reading.sendKeys(value);
        }
    }
    public void addMeasurementReadingsValue(String durometerValue,String value){
        waitForPageLoad(5000);
        waitForElementVisible(inpdurometerValue,10000,1000);
        inpdurometerValue.type(durometerValue);
        waitForElementVisible(inpdurometerValue,3000,1000);
        typeReadingValues(value);
    }
    public void addTempAndTonsValueAsZero(String zero){
        waitForElementVisible(tonsConveyedCurrent,20000,1000);
        tonsConveyedCurrent.type(zero);
        temperatureField.type(zero);
    }

    public void addDeviceInformation(String device ,String velocity,String thickness,String surfaceTemp,String testPos){
        waitForElementVisible(deviceInstrumentField,5000,1000);
        deviceInstrumentField.type(device);
        velocityField.type(velocity);
        calibrationThicknessField.type(thickness);
        surfaceTemperatureField.type(surfaceTemp);
        testPositionField.type(testPos);
    }

    public void verifyUserSavedMeasurementDetails(String CustSiteName ,String ConveyorName){
        waitForPageLoad(5000);
        waitForElementToBeClickable(cwEditSpec);
        cwEditSpec.click();
        waitForElementVisible(conveyorField,5000,1000);
        waitForElementVisible(siteField,5000,1000);
        SyncUtil.waitFor(2000);
        Validator.assertTrue(siteField.getAttribute("value").contains(CustSiteName),"Site value misMatch","Site value matched");
        Validator.assertTrue(conveyorField.getAttribute("value").contains(ConveyorName),"Conveyor value misMatch","Conveyor value matched");
    }

    public void verifyDataHeaderUnitAsMetric(){
        waitForPageLoad(5000);
        waitForElementVisible(unitIcon,5000,1000);
        waitForElementToBeClickable(unitIcon);
        unitIcon.click();
        waitForElementVisible(cbMetricUnit,5000,1000);
        Validator.assertTrue(cbMetricUnit.isDisplayed(),"Metric unit is not selected","Metric unit is selected");
//        unitIcon.click();
    }
        public void verifyDataHeaderUnitAsImperial(){
        waitForPageLoad(5000);
        waitForElementVisible(unitIcon,5000,1000);
        waitForElementToBeClickable(unitIcon);
        SyncUtil.waitFor(5000);
        unitIcon.click();
        SyncUtil.waitFor(10000);
        waitForElementVisible(cbImperialUnit,5000,1000);
        Validator.assertTrue(cbImperialUnit.isDisplayed(),"Imperial unit is not selected","Imperial unit is selected");
    }


    public void verifyDataInMetric(String metricValue){
        waitForElementVisible(beltWidthFieldLabel,5000,1000);
        SyncUtil.waitFor(3000);
        Validator.assertTrue(beltWidthFieldLabel.getText().contains("mm"),"Metric unit is not selected","Metric unit is selected");
        waitForElementVisible(beltWidthFieldLabel,5000,1000);
        SyncUtil.waitFor(3000);
        Validator.assertTrue(beltWidthField.getAttribute("value").contains(metricValue),"Metric value is not matching","Metric value is matching");
    }

    public void verifyDataInImperial(String imperialValue){
        waitForElementVisible(beltWidthFieldLabel,5000,1000);
        SyncUtil.waitFor(5000);
        Validator.assertTrue(beltWidthFieldLabel.getText().contains("in"),"Imperial unit is not selected","Imperial unit is selected");
        waitForElementVisible(beltWidthField,5000,1000);
        SyncUtil.waitFor(3000);
        Validator.assertTrue(beltWidthField.getAttribute("value").contains(imperialValue),"Imperial value is not matching","Imperial value is matching");
    }

    public void addDataAsMetric(){
        waitForPageLoad(5000);
        waitForElementVisible(unitIcon,5000,1000);
        waitForElementToBeClickable(unitIcon);
        unitIcon.click();
        waitForElementVisible(btMetricUnit,5000,1000);
        waitForElementToBeClickable(btMetricUnit);
        btMetricUnit.click();
    }

    public void addDataAsImperial(){
        waitForPageLoad(5000);
        waitForElementVisible(unitIcon,15000,1000);
        waitForElementToBeClickable(unitIcon);
        unitIcon.click();
        waitForElementVisible(btImperialUnit,15000,1000);
        waitForElementToBeClickable(btImperialUnit);
        btImperialUnit.click();
    }

    public void addNewMeasurementWithWidth(String conveyorName, String siteName, String position, String beltWidth) {
        cwAddNew.click("Add New Measurement");
        waitForElementToDisplay(cwSiteDropDown);
        waitForPageLoad(5000);
        dropdownSelectSearch(cwSiteDropDown, cwInput, siteName);
        waitForPageLoad(5000);
        dropdownSelectSearch(cwConveyorDropDown, cwInput, conveyorName);
        dropdownSelect(cwPositionDropDown, ListItem, position);
        waitForPageLoad(5000);
        SyncUtil.waitFor(5000);
        waitForElementToBeClickable(cwEditSpec);
        cwEditSpec.click("Edit");
        waitForElementVisible(cwBeltWidth,10000,1000);
        waitForElementToBeClickable(cwBeltWidth);
        SyncUtil.waitFor(5000);
        cwBeltWidth.clear();
        cwBeltWidth.sendKeys(beltWidth);
        cwSave.click();
        waitForElementToInvisible(cwSpecsLoader,15000);
    }

    public void clickAddMeasurment(){
        waitForElementVisible(btAdd,5000,1000);
        waitForElementToBeClickable(btAdd);
        waitForPageLoad(5000);
        btAdd.jsClick();
        waitForElementVisible(dialogBox,20000,1000);
        Validator.assertTrue(dialogBox.isDisplayed(),"Dialogbox is not displayed","Dialogbox is displayed");
    }

    public void verifyGuazeImageInSpec(){
        waitForPageLoad(5000);
        waitForElementVisible(imgGuazeMeter,10000,1000);
        Validator.assertTrue(imgGuazeMeter.isDisplayed(),"Guaze meter is not displayed","Guaze meter is displayed");
        }

    public void verifyGuazeEmptyData(){
        waitForElementVisible(getCwRemainingCoverPercent,10000,1000);
        Validator.assertTrue(getCwRemainingCoverPercent.getText().equals("--"),"Guaze data is not empty","Guaze data meter is empty");
    }

    public void verifyWearRateStatTable(){
        waitForElementVisible(hdWearRateStatTable,10000,1000);
        Validator.assertTrue(hdWearRateStatTable.isDisplayed(),"Wear Rate Statistics & Projections Table is not displayed","Wear Rate Statistics & Projections Table is displayed");
    }

    public void verifyWearRateTableValueAreYear(){
        waitForElementVisible(thYearsUnit,10000,1000);
        Validator.assertTrue(thYearsUnit.getText().contains("Year"),"Year Value is not in Year","Year Value is in Year");
        Validator.assertTrue(thEstTotalLifeUnit.getText().contains("Year"),"Estimate Total Life Value is not in Year","Estimate Total Life Value is in Year");
        Validator.assertTrue(thEstTotalCostPerLifeUnit.getText().contains("Year"),"Total Cost per Year Value is not in Year","Total Cost per Year Value is in Year");
    }
    public void verifyWearRateStatAndProjectionFields(){
      waitForElementVisible(thTonsConveyed,10000,1000);
      Validator.assertTrue(thTonsConveyed.isDisplayed(),"Tons Conveyed is not displayed","Tons Conveyed is displayed");
      Validator.assertTrue(thYears.isDisplayed(),"Year is not displayed","Year is displayed");
      Validator.assertTrue(thWearRate.isDisplayed(),"Wear rate is not displayed","Wear rate is displayed");
      Validator.assertTrue(thProjectedFutureTons.isDisplayed(),"Projected Future Tons is not displayed","Projected Future Tons is displayed");
      Validator.assertTrue(thProjectedFutureLife.isDisplayed(),"Projected Future Life is not displayed","Projected Future Life is displayed");
      Validator.assertTrue(thEstTotalLifeTons.isDisplayed(),"Estimate Total Life Tons is not displayed","Estimate Total Life Tons is displayed");
      Validator.assertTrue(thEstTotalLifeYears.isDisplayed(),"Estimate Total Life Years is not displayed","Estimate Total Life Years is displayed");
      Validator.assertTrue(thEstTotalCostPerTonLife.isDisplayed(),"Est. Total Cost per Ton is not displayed","Est. Total Cost per Ton is displayed");
      Validator.assertTrue(thEstTotalCostPerYearLife.isDisplayed(),"Est. Total Cost per Year is not displayed","Est. Total Cost per Year is displayed");
    }

    public void verifyPositionHeader(String positionName){
        waitForPageLoad(3000);
        waitForElementVisible(hdPositionName,10000,1000);
        Validator.assertTrue(hdPositionName.getText().contains(positionName),"Position Name doesn't match","Position Name matches");
    }

    public void verifySpecificationFormat(String beltConstruction, String beltWidth, String topCoverCompound, String bottomCoverCompound, String topCoverThickness, String bottomCoverThickness){
        waitForElementVisible(hdSpecificationValue,10000,1000);
        Validator.assertTrue(hdSpecificationValue.getText().contains("Specification: "+beltConstruction+" "+beltWidth+" - "+topCoverThickness+" / "+bottomCoverThickness+" "+topCoverCompound+"/"+bottomCoverCompound),"Specification Value doesn't match","Specification Value matches");
    }

    public void verifyDateOfInsFormat(String date){
        waitForElementVisible(hdDateOfInstallation,10000,1000);
        Validator.assertTrue(hdDateOfInstallation.getText().contains("Date of Installation: "+date),"Date of installation doesn't match","Date of installation matches");
    }

    public void verifyNewDurometerFormat(String durometer){
        waitForElementVisible(hdNewDurometerValue,10000,1000);
        Validator.assertTrue(hdNewDurometerValue.getText().contains("Durometer (New Belt): "+durometer),"Durometer Value doesn't match","Durometer Value matches");
    }

    public void verifyDateAndSpecificationValue(String date,String beltConstruction, String beltWidth, String topCoverCompound, String bottomCoverCompound, String topCoverThickness, String bottomCoverThickness){
        waitForElementVisible(hdCoverWearBreadCrumb,10000,1000);
        hdCoverWearBreadCrumb.jsClick();
        waitForPageLoad(5000);
        waitForElementVisible(hdInstalledBelt,5000,1000);
        waitForElementToBeClickable(hdInstalledBelt);
        hdInstalledBelt.click();
        waitForElementVisible(ddBeltConstructionValue,5000,1000);
        Validator.assertTrue(convertDateFormat(ddInstallationDateValue.getAttribute("value")).equalsIgnoreCase(date),"Date Value doesn't match","Date Value matches");
        Validator.assertTrue(ddBeltConstructionValue.getAttribute("value").equalsIgnoreCase(beltConstruction),"Belt Construction Value doesn't match","Belt Construction Value matches");
        Validator.assertTrue(ddBeltWidthValue.getAttribute("value").equalsIgnoreCase(beltWidth),"Date Value doesn't match","Date Value matches");
        Validator.assertTrue(ddTopCoverThicknessValue.getAttribute("value").equalsIgnoreCase(topCoverThickness),"Top Cover Thickness Value doesn't match","Top Cover Thickness Value matches");
        Validator.assertTrue(ddBottomCoverThicknessValue.getAttribute("value").equalsIgnoreCase(bottomCoverThickness),"Bottom Cover Thickness Value doesn't match","Bottom Cover Thickness Value matches");
        Validator.assertTrue(ddTopCoverCompoundValue.getAttribute("value").equalsIgnoreCase(topCoverCompound),"Top Cover Compound Value doesn't match","Top Cover Compound Value matches");
        Validator.assertTrue(ddBottomCoverCompoundValue.getAttribute("value").equalsIgnoreCase(bottomCoverCompound),"Bottom Cover Compound Value doesn't match","Bottom Cover Compound Value matches");
    }

    public void verifyProfileGraphIsDisplayed(){
        waitForElementVisible(hdWearProfile,10000,1000);
        Validator.assertTrue(hdWearProfile.getText().contains("Wear Profile"),"Wear Profile Graph is not displayed","Wear Profile Graph is displayed");
    }

    public void verifyCoverWearPositionTableHeader(){
        waitForElementVisible(hdPositionTable,5000,1000);
        Validator.assertTrue(hdPositionTable.getText().equalsIgnoreCase("Positions"),"Positions is not visible","Positions is visible");
    }

    public void verifyCoverWearPositionTableCoulmnName(){
        waitForElementVisible(hdConveyor,5000,1000);
        Validator.assertTrue(hdPosition.getText().contains("Position"),"Position is not visible","Position is visible");
        Validator.assertTrue(hdInstalledDate.getText().contains("Installed Date"),"Installed Date is not visible","Installed Date is visible");
        Validator.assertTrue(hdTonsConveyed.getText().contains("Tons Conveyed"),"Tons Conveyed is not visible","Tons Conveyed is visible");
        Validator.assertTrue(hdAgeToDate.getText().contains("Age to date"),"Age to date is not visible","Age to date is visible");
        Validator.assertTrue(hdLastRecorded.getText().contains("Last Recorded"),"Last Recorded is not visible","Last Recorded is visible");
        Validator.assertTrue(hdLowestReading.getText().contains("Lowest Reading"),"Lowest Reading is not visible","Lowest Reading is visible");
        Validator.assertTrue(hdDurometer.getText().contains("Durometer Shore A"),"Durometer Shore A is not visible","Durometer Shore A is visible");
        Validator.assertTrue(hdRemainingLife.getText().contains("Remaining Life by Time"),"Remaining Life by Time is not visible","Remaining Life by Time is visible");
        Validator.assertTrue(hdRemainingCover.getText().contains("Remaining Cover %"),"Remaining Cover % is not visible","Remaining Cover % is visible");
        Validator.assertTrue(hdMore.getText().contains("More"),"More is not visible","More is visible");
    }

    public void verifyAddNewPositionPopUp(){
        waitForElementVisible(crDialog,5000,1000);
        waitForPageLoad(5000);
        SyncUtil.waitFor(10000);
        Validator.assertTrue(hdPositionTable.getText().equalsIgnoreCase("Positions"),"Positions is not visible","Positions is visible");
        waitForPageLoad(5000);
    }
    public void verifyCustomerField(String site){
        waitForPageLoad(5000);
        SyncUtil.waitFor(20000);
        waitForElementVisible(tbCustomer,5000,1000);
        Validator.assertTrue(tbCustomer.getAttribute("value").equalsIgnoreCase(site),"Customer value doesnt match","Customer value match");
         }

    public void verifyConveyorField(String conveyor){
        waitForElementVisible(tbConveyor,5000,1000);
        Validator.assertTrue(tbConveyor.getAttribute("value").equalsIgnoreCase(conveyor),"Conveyor value doesnt match","Conveyor value match");
    }
    public void verifyWidthField(String width){
        Validator.assertTrue(tbWidth.getAttribute("value").equalsIgnoreCase(width),"Width value doesnt match","Width value match");
    }
    public void addSegmentField(String segment){
        waitForElementToBeClickable(tbSegment);
        tbSegment.type(segment);
        }
    public void addTonsConveyedField(String zero){
        waitForElementToBeClickable(tbTonsConveyed);
        tbTonsConveyed.type(zero);
    }
    public void addDurometerField(String durometer){
        waitForElementToBeClickable(tbDurometer);
        tbDurometer.type(durometer);
     }
     public void addTopBottomValue(){
        waitForElementToBeClickable(rbtTop);
         rbtTop.click();
        Validator.assertTrue(tbTop.getAttribute("aria-checked").equalsIgnoreCase("true"),"Top is not selected","Top is selected");
     }

    public void clickOnSave(){
        waitForElementToBeClickable(btSave);
        btSave.jsClick();
    }
    public void verifySegmentCreation(String positionName) {
        waitForPageLoad(5000);
        searchPosition(positionName);
        waitForElementVisible(txtPosition,10000,1000);
        Validator.assertTrue(txtPosition.getText().equalsIgnoreCase(positionName), "Position is not created", "Position is created");
    }
    public void verifySpecificationHeader() {
        waitForPageLoad(5000);
        waitForElementVisible(specificationHeader,10000,1000);
        Validator.assertTrue(specificationHeader.getText().equalsIgnoreCase("Specification"), "Specification header is not visible", "Specification header is visible");
    }
    public void verifySpecificationTableFields() {
        waitForPageLoad(5000);
        Validator.assertTrue(btGuazeMeter.isDisplayed(),"Guaze meter is not displayed","Guaze meter is displayed");
        Validator.assertTrue(txtSite.isDisplayed(),"Site is not displayed","Site is displayed");
        Validator.assertTrue(txtConveyor.isDisplayed(),"Conveyor is not displayed","Conveyor is displayed");
        Validator.assertTrue(txtBeltWidth.isDisplayed(),"BeltWidth is not displayed","BeltWidth is displayed");
        Validator.assertTrue(txtTopCoverThicknessNominal.isDisplayed(),"TopCoverThicknessNominal is not displayed","TopCoverThicknessNominal is displayed");
        Validator.assertTrue(txtBottomCoverThicknessNominal.isDisplayed(),"BottomCoverThicknessNominal is not displayed","BottomCoverThicknessNominal is displayed");
        Validator.assertTrue(txtBeltLength.isDisplayed(),"BeltLength is not displayed","BeltLength is displayed");
        Validator.assertTrue(txtTopCoverThicknessActual.isDisplayed(),"TopCoverThicknessActual is not displayed","TopCoverThicknessActual is displayed");
        Validator.assertTrue(txtBottomCoverThicknessActual.isDisplayed(),"BottomCoverThicknessActual is not displayed","BottomCoverThicknessActual is displayed");
        Validator.assertTrue(txtNoOfDatapoints.isDisplayed(),"Number Of Datapoints is not displayed","Number Of Datapoints is displayed");
        Validator.assertTrue(txtDurometer.isDisplayed(),"Durometer is not displayed","Durometer is displayed");
        Validator.assertTrue(txtPriceOfBelt.isDisplayed(),"PriceOfBelt is not displayed","PriceOfBelt is displayed");
        Validator.assertTrue(txtNoOfColumns.isDisplayed(),"Number Of Columns is not displayed","Number Of Columns is displayed");
        Validator.assertTrue(txtTopCoverCompound.isDisplayed(),"TopCoverCompound is not displayed","TopCoverCompound is displayed");
        Validator.assertTrue(txtBottomCoverCompound.isDisplayed(),"BottomCoverCompound is not displayed","SBottomCoverCompound is displayed");
        Validator.assertTrue(txtTopCoverCriticalThickness.isDisplayed(),"TopCoverCriticalThickness is not displayed","TopCoverCriticalThickness is displayed");
        Validator.assertTrue(txtTopCoverPoorThickness.isDisplayed(),"TopCoverPoorThicknessis not displayed","TopCoverPoorThickness is displayed");
        Validator.assertTrue(txtBottomCoverCriticalThickness.isDisplayed(),"BottomCoverCriticalThickness is not displayed","BottomCoverCriticalThickness is displayed");
        Validator.assertTrue(txtBottomCoverPoorThickness.isDisplayed(),"BottomCoverPoorThickness is not displayed","BottomCoverPoorThickness is displayed");
        Validator.assertTrue(cwEditSpec.isDisplayed(),"Edit button is not displayed","Edit button is displayed");
        Validator.assertTrue(cwSave.isDisplayed(),"Save button meter is not displayed","Save button is displayed");
        Validator.assertTrue(cwCancel.isDisplayed(),"Cancel button meter is not displayed","Cancel button is displayed");
    }

    public void clickOnExportPDF() {
        waitForElementVisible(cwExport,5000,1000);
        cwExport.click();
    }

    public void verifyExportPopUp() {
        waitForElementVisible(crDialog,10000,1000);
        Validator.assertTrue(downloadPopup.isDisplayed(),"Pop Up is not visible","Pop Up is visble");
        Validator.assertTrue(dateRangeFrom.isDisplayed(),"Date Range From is not visible","Date Range From is visible");
        Validator.assertTrue(hdPositionExportPop.isDisplayed(),"Position is not visible","Position is visible");
        Validator.assertTrue(hdInclude.isDisplayed(),"Include is not visible","Include is visible");
        includePositionTypes.click();
        Validator.assertTrue(includeDropdownContent(),"Include Contents is not visible","Include Contents is visible");
        multiSelectCloseBtn.click();
        verifyCommentAndPhotos();
        Validator.assertTrue(applyBtn.isDisplayed(),"Apply Button is not visible","Apply Button is visible");
        Validator.assertTrue(cancelBtn.isDisplayed(),"Cancel Button is not visible","Cancel Button is visible");
    }

    public void clickReportDownloadButton() {
       waitForPageLoad(5000);
       waitForElementVisible(cwCheckbox,5000,1000);
       waitForElementToBeClickable(btReportDownload);
       btReportDownload.click();
       waitForElementVisible(crDialog,5000,1000);
       Validator.assertTrue(crDialog.isVisible(),"Dialog is not visible","Dialog is visible");
    }
    public void extractCoverWearData() {
       waitForPageLoad(5000);
        getBundle().setProperty("cwConveyorValue", cwConveyorName.getText());
        getBundle().setProperty("cwSiteValue", cwSiteName.getText());
        getBundle().setProperty("cwInstallDateValue", cwInstalledDatee.getText());
        getBundle().setProperty("cwCoverGradeValue", cwGrade.getText());
        getBundle().setProperty("cwDurometerValue", cwDurometer.getText());
        getBundle().setProperty("cwRemainingTimeValue", cwRemainingLife.getText());
        getBundle().setProperty("cwRemainingPerValue", cwRemainingCover.getText());
    }

    public void verifyCoverWearPDFContents(String conveyorName, String siteName) {
        PDDocument doc = PDFHelper.getPDFData(System.getProperty("user.dir") + separator + "target" + separator + "downloads" + separator + conveyorName + "_" + siteName + ".pdf");
        try {
            String val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
            Validator.assertTrue(val.contains(getBundle().getProperty("cwConveyorValue").toString()), "Conveyor in PDF Report does not match", "Conveyor in PDF Report match");
            Validator.assertTrue(val.contains(getBundle().getProperty("cwSiteValue").toString()), "Site in PDF Report does not match", "Site in PDF Report match");
            Validator.assertTrue(val.contains(getBundle().getProperty("cwDurometerValue").toString()), "Durometer in PDF Report does not match", "Durometer in PDF Report match");
      } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
