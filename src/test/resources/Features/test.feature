Feature: test

  Background: Admin is logged in to LMS Portal
    Given The Browser is open
    When Log into LMS Portal as Admin
    
    #4
  Scenario: Verify other page's name displayed in menu bar
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the page names as in order "Home Program Batch Class "
#5
  Scenario: Verify sub menu displayed in program menu bar
    Given Admin is on program page
    When Admin clicks "Program" on the navigation bar
    Then Admin should see sub menu in menu bar as "Add New Program"
    
    
    #7
  Scenario: Verify view details of programs #in progress
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should able to see Program name, description, and status for each program
    
    #9
  Scenario: Verify the Search button
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see Search bar with text as "Search..."
    
    #10
  Scenario: Verify column header name of data table
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit/Delete
    
    Scenario: Verify footer message in manage program
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the footer as "In total there are z programs".
    