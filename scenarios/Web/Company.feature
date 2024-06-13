Feature: Add Company flow for web

Background:
Launch the application through '/'

@Scenario1 @CTCP-566
@dataFile:resources/data/AddCompany.xls
@sheetName:Company
@key:Company_Master_User
Scenario: ZLook for the breadcrumb of the page

         Given User is at Login page
         When Login with '${UserName}' and '${Password}'
         And User navigates to Add Company page
         Then Verify the Company bread crumb
         And Click on Corporates Link to redirect to corporate list page
         And User navigates to Add Company page
         And Click on Home Link to redirect to home page

@Scenario2 @CTCP-568
@dataFile:resources/data/AddCompany.xls
@sheetName:Company
@key:Company_ImageUpload
Scenario: Verify closing of Image viewer panel

         And User navigates to Add Company page
         Then Verify the default image is displayed and on hover camera icon is displayed
         And  Verify that Image Viewer panel is displayed on clicking the camera icon
         When User clicks on Upload Image
         Then Verify that the user is able to upload the image '${imgName}' from the system
         And Verify that selected image is getting displayed in the image viewer panel
         When User clicks on cancel button
         Then Verify that the image viewer panel is closed and image is not uploaded

@Scenario3 @CTCP-574
@dataFile:resources/data/AddCompany.xls
@sheetName:Company
@key:Company_map
Scenario: Verify Address autoSuggest functionality should working as expected after maximizing the map.

         Then Verify user is on home page of the application
         And Verify add company Link should be visible in the left navigation bar
         And Verify user navigates to Add Company page on clicking the Add Company link in navigation bar
         And Verify that on clicking the maximize icon user is able to maximize the image
         When User writes a new location '${Address}' in the address field
         Then Verify the auto suggest is populated based on the address '${Address}' provided in the search box

@Scenario4 @CTCP-578
@dataFile:resources/data/AddCompany.xls
@sheetName:Company
@key:Company_Location
Scenario: Verify Add location when address not displayed in auto suggest.


         And User navigates to Add Company page
         And Verify image upload functionality with '${imageName}'
         And Select on Distributor corporate radio button and verify that distributor corporate is selected as default option
         When Enter a new company name '${CompanyName}' and address '${Address}' which is not in auto suggest
         When Click on the map where user wants to add address
         Then Verify user should be able to add  Street city zipcode state country cancel link and apply link
         And Add the address fields '${Street}' '${City}' '${ZipCode}' '${State}' '${Country}' '${CompanyName}' and verify the address is saved





