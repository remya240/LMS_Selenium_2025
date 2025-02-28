Feature: Add new class popup window

  Background: Admin is logged in to LMS Portal and on the Manage Class page
    Given The Browser is open
    When Log into LMS Portal as Admin
    And Admin clicks the "Class" Navigation bar in the Header
    Then clicks add new class under the class menu bar

  @ClassAddNew1
  Scenario: Validate Class Details Popup window
    Then Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window

  @ClassAddNew2
  Scenario: Validate input fields and their text boxes in Class details form
    Then Admin should see few input fields and their respective text boxes in the class details window

  @ClassAddNew3
  Scenario: Validate Cancel/Close(X) icon on class Details form
    When Admin clicks Cancel Icon on class Details form
    Then Class Details popup window should be closed without saving

  @ClassAddNew4
  Scenario Outline: Check if class is created when only mandatory fields are entered with valid data
    When Admin enters mandatory fields "<BatchName>" "<ClassTopic>" "<ClassDescription>" "<month>" "<date1>" "<date2>" "<StaffName>" "<Status>" "<SuccessMsg>" in the form and clicks on save button
    Then Admin gets message Class added Successfully

    Examples: 
      | BatchName |  | ClassTopic |  | ClassDescription |  | month    |  | date1 |  | date2 |  | StaffName     |  | Status   |  | SuccessMsg   |
      | SMPO33    |  | Java       |  | Core Java        |  | February |  |    25 |  |    12 |  | Sarnaya       |  | Active   |  | Successful   |
      | SMPO2     |  | @@         |  | *&()#$UCV        |  | December |  |    25 |  |    19 |  | Geetha Thakur |  | Inactive |  | Unsuccessful |

  @ClassAddNew5
  Scenario Outline: Check no classes value added when selecting class dates

    When Admin selects class "<month>" "<date1>" "<date2>" in date picker
    Then Admin should see no of class value is added automatically
     Examples: 
    |month||date1||date2 |
    |December||25||13|
    
    
    @ClassAddNew6
  Scenario Outline: Verify class creation with only optional fields entered
   
    When Admin skips adding values in mandatory fields and enters only the optional fields "<comments>" "<notes>" "<recording>"
    Then Admin should see error message below the test field and the field will be highlighed in red color "<batchNameReqText>" "<classTopicReqText>" "<classDateReqText>" "<staffNameReqText>" "<noOfClassesReqText>"

    Examples: 
      | comments   | notes         | recording     | batchNameReqText         | classTopicReqText        | classDateReqText        | staffNameReqText        | noOfClassesReqText          |
      | Excellent  | Python notes  | Zoom link     | Batch Name is required.  | Class Topic is required. | Class Date is required. | Staff Name is required. | No. of Classes is required. |
      | Helpful    | React notes   | Meet link     | Batch Name is required.  | Class Topic is required. | Class Date is required. | Staff Name is required. | No. of Classes is required. |
      | Informative| JS guide      | Teams link    | Batch Name is required.  | Class Topic is required. | Class Date is required. | Staff Name is required. | No. of Classes is required. |
  
    @ClassAddNew7
  Scenario Outline: Empty form submission
 
    When Admin clicks on save button without entering data
    Then Admin should see error message below the test field and the field will be highlighed in red color "<BatchName>" "<ClassTopic>" "<ClassDate>" "<StaffName>" "<NoOfClasses>"

    Examples: 
      | BatchName                     | ClassTopic                      | ClassDate                       | StaffName                       | NoOfClasses    |
      | Batch Name is required. | Class Topic is required. | Class Date is required. | Staff Name is required. | No. of Classes is required. |
