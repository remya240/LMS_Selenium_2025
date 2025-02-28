@tag
Feature: ProgramSorting

Background: Admin is logged in to LMS Portal
    Given The Browser is open
    When Log into LMS Portal as Admin
    And Click Program option in menubar
    
  #17
  #sorting
  Scenario: Verify sorting of  Program name in Ascending order
    When Admin clicks on Arrow next to programName
    Then Admin See the Program Name is sorted in "Ascending order"
#18
  Scenario: Verify sorting of  Program Description in  Ascending order
    When Admin clicks on Arrow next to ProgramDescription
    Then Admin See the program Description is sorted in "Ascending order"
#19
  Scenario: Verify sorting of   Program status in Ascending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to Program status
    Then Use See the  Program Status is sorted in "Ascending order"
