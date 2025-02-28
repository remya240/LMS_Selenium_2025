@EditProgram
Feature: Admin Edit Program in Manage Program

  Background: Admin enters Program to create new program
    Given The Browser is open
    When Log into LMS Portal as Admin
    And admin clicks on "Program" in menubar

  @programEdit1
  Scenario: Verify Edit option
    When Admin clicks on Edit option for particular program
    Then Admin lands on Program details form

  @programEdit
  Scenario: Verify title of the pop up window
    When Admin clicks on Edit option for particular program
    Then Admin should see window title as "Program Details"

  @programEdit
  Scenario: Verify mandatory fields with red asterisk mark
    When Admin clicks on Edit option for particular program
    Then Admin should see red asterisk mark beside mandatory field "Name"

  @programEdit
  Scenario: Verify edit Program Name
    Given Admin clicks on Edit option for particular program
    When Admin edits the program name and click on save button
    Then Updated program name is seen by the Admin

  @programEdit
  Scenario: Verify edit Description
    Given Admin clicks on Edit option for particular program
    When Admin edits the description text and click on save button
    Then Admin can see the description is updated
    
@verifyEditStatus
  Scenario: Verify edit Status
    Given Admin clicks on Edit option for particular program
    When Admin can change the status of the program and click on save button
    Then Status updated can be viewed by the Admin
@save
  Scenario: Verify Admin is able to click Save
    Given Admin clicks on Edit option for particular program
    When Admin click on save button
    Then Admin can see the updated program details

  Scenario: Verify cancel button
    When Admin clicks Cancel button
    Then Admin can see Program Details form disappears
    
@EditedProgram
  Scenario: Verify edited Program details
  
    When Admin searches with newly updated "Program Name"
    Then Admin verifies that the details are correctly updated.

  Scenario: Verify close the window with "X"
    Given Admin clicks on Edit option for particular program
    When Admin Click on "X" button
    Then Admin can see program details form disappear
#
  #@Deleteprogram
  #Scenario: Verify delete feature
    #When Admin clicks on delete button for a program
    #Then Admin will get confirm deletion popup
#
     #Scenario: Verify Admin is able to click 'Yes'
    #GivenAdmin is on Program Confirm Deletion Page after selecting a program to delete
    #When Admin clicks on "Yes" button
    #Then Admin can see 'Successful Program Deleted' message
#
  #Scenario: Verify Admin is able to deleted program
    #Given Admin is on Program page
    #When Admin Searches for "Deleted Program name"
    #Then There should be zero results.
#
  #Scenario: Verify Admin is able to click 'No'
    #Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    #When Admin clicks on "No" button
    #Then Admin can see Confirmation form disappears
#
  #Scenario: Verify Admin is able to close the window with "X" 
    #Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    #When Admin Click on "X" button
    #Then Admin can see Confirm Deletion form disappear
#
  #Scenario: Verify Admin is able to select multiple programs
    #Given Admin is on Program page
    #When Admin selects more than one program by clicking on the checkbox
    #Then Programs get selected
#
  #Scenario: Verify Admin is able to delete Multiple programs
    #Given Admin is on Program page
    #When Admin clicks on the delete button on the left top of the program page
    #Then Admin lands on Confirmation form
#
   #Scenario: Verify Admin is able to deleted program
    #Given Admin is on Program page
    #When Admin Searches for "Deleted Program names"
    #Then There should be zero results.
#
  #Scenario: Verify Admin is able to click 'No'
    #Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    #When Admin clicks on "No" button
    #Then Admin can see Programs are still selected and not deleted
#
  #Scenario: Verify Admin is able to close the window with "X" 
    #Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    #When Admin Click on "X" button
    #Then Admin can see Confirm Deletion form disappear

    