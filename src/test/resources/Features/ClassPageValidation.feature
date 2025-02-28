Feature: Class Page Validation and Add new class

  Background: Admin is logged in to LMS Portal
    Given The Browser is open
    When Log into LMS Portal as Admin
    And Admin clicks the "Class" Navigation bar in the Header
    Then Admin should land on the "Manage Class" page

  @ClassValidation1
  Scenario Outline: Validating the headers in the class page
    Then Admin should see the headers heading like "<headers>"

    Examples: 
      | headers                          |
      | LMS - Learning Management System |
      | Batch Name                       |
      | Class Topic                      |
      | Class Description                |
      | Status                           |
      | Class Date                       |
      | Staff Name                       |
      | Edit / Delete                    |

  @ClassValidation12
  Scenario: Validating the text and pagination icon in the classpage
    Then Admin should see the showing entries and enabled pagination controls under the data table

  @ClassValidation13
  Scenario: Validate the sort icon of all the field in datatable
    Then Admin should see the Sort icon of all the field in the datatable

  @ClassValidation14
  Scenario: Validating the Delete button under the Manage class
    Then Admin should see the Delete button under the Manage class page header

  @ClassValidation15
  Scenario: Validate the total no of classes in manage class page
    Then Admin should see Total no of classes in below of the data table
