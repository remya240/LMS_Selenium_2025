Feature: Add new class popup window

  Background: Admin is logged in to LMS Portal
    Given The Browser is open
    When Log into LMS Portal as Admin
    And Admin clicks the "Class" Navigation bar in the Header
    Then Admin clicks on the edit icon

  @Edit1
  Scenario: Validate row level edit icon
    Then A new pop up with class details appears

  @Edit2
  Scenario: Check disabled  batch name
    Then Admin should see batch name field is disabled

  @Edit3
  Scenario: Check disabled class topic
    Then Admin should see class topic field is disabled

  @Edit4
  Scenario Outline: Check if the fields are updated with valid data
    When Update the fields with valid data "editClassDescription" and click save
    Then Admin gets message "Successful" and see the updated values in data table

    Examples: 
      | editClassDescription |
      | Java                 |
      
  @Edit5
  Scenario Outline: Check if the optional fields are updated with valid data
    When Update the optional fields with valid values "<comments>" "<notes>" "<recording>" and click save
    Then Admin gets message "Successful" and see the updated values in data table
    
    Examples: 
      | comments  | notes        | recording    |
      | Excellent | python notes | youtube link |
      
  @Edit6
  Scenario: Validate Cancel button on Edit popup
    When Admin clicks Cancel button on edit popup
    Then Admin can see the class details popup disappears and can see nothing changed for particular Class
    
