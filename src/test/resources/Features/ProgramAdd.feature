@ProgramAdd
Feature: Admin creates new Program
 
Background:  Admin enters Program to create new program
Given The Browser is open
When Log into LMS Portal as Admin
And admin clicks on "Program" in menubar
Then admin clicks on "Add New Program" submenu


@programDetails 
Scenario: Verify title of the pop up window
Then Admin should see window title as "Program Details"

Scenario: Verify mandatory fields with red asterisk mark
Then Admin should see red  asterisk mark  beside mandatory field "Name"

@Negative
Scenario: Verify empty form submission
When Admin clicks save button without entering mandatory  
Then Admin gets message <field> is required
|Program name is required.|
|Description is required.|
|Status is required.|

@Cancel
Scenario: Verify cancel button
When Admin clicks Cancel button
Then Admin can see Program Details form disappears 

@programName
Scenario: Verify enter program name
When Admin enters ProgramName in textbox 
Then Admin can see text entered
@progDesc
Scenario: Verify enter description
When Admin enters Description in textbox
Then Admin can see text entered  
@status
Scenario: Verify select Status 
When Admin selects status by clicking on radiobutton "(Active/InActive)"
Then Admin can see 'Active/Inactive' status selected

@validMandatory
Scenario: Verify Admin is able to save the program 
Given admin clicks on "Add New Program" submenu 
When Admin enter valid details for mandatory fields and Click on save button
Then Admin gets message 'Program Created Successfully'


Scenario: Verify added Program is created 
Given admin clicks on "Program" in menubar
When Admin searches with newly created "Program Name"
Then Records of the newly created  "Program Name" is displayed and match the data entered

@xbutton
Scenario: Verify close window with "X"  
When Admin Click on "X" button
Then Admin can see program details form disappear
