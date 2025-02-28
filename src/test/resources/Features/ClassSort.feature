Feature: Sort Class details

  Background: Admin is logged in to LMS Portal and on the Manage Class page
    Given The Browser is open
    When Log into LMS Portal as Admin
    And Admin clicks the "Class" Navigation bar in the Header
    Then Admin should land on the "Manage Class" page
    
    
  Scenario: Verify sorting of Batch name in Ascending order
    When Admin clicks on Arrow next to Batch Name of Class module page for sort
    Then Admin See the Batch Name is sorted Ascending order in Class module page for sort

 
  Scenario: Verify sorting of Batch name in Descending order
    When Admin clicks on Arrow next to Batch Name of Class module page for sort descend
    Then Admin See the Batch Name is sorted Descending order in Class module page 

 
  Scenario: Verify sorting of Class Topic in Ascending order
    When Admin clicks on Arrow next to Class Topic of Class module page for sort 
    Then Admin See the Class Topic is sorted Ascending order in Class module page 

  
  Scenario: Verify sorting of Class Topic in Descending order
    When Admin clicks on Arrow next to Class Topic of Class module page for sort descend
    Then Admin See the Class Topic is sorted Descending order in Class module page

  
  Scenario: Verify sorting of Class Description in Ascending order
    When Admin clicks on Arrow next to Class Description of Class module page for sort
    Then Admin See the Class Description is sorted Ascending order in Class module page

  
  Scenario: Verify sorting of Class Description in Descending order
    When Admin clicks on Arrow next to Class Description of Class module page for sor descend
    Then Admin See the Class Description is sorted Descending order in Class module page
    
