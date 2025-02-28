@HomePage
Feature: Home Page

  Background: Admin gives the correct LMS portal URL
    Given Admin is on login Page
    When Admin enters valid data in all field and  clicks login button

  @HP1
  Scenario: Verify LMS title
    Then Admin should see "LMS - Learning Management System" as title

  @HP2
  Scenario: Verify LMS title alignment
    Then LMS title should be on the top left corner of page

  @HP3
  Scenario: Validate navigation bar text
    Then Admin should see correct spelling in navigation bar text

  @HP4
  Scenario: Validate LMS title has correct spelling and space
    Then Admin should see correct spelling and space in LMS title

  @HP5
  Scenario: Validate alignment for navigation bar
    Then Admin should see the navigation bar text on the top right side

  @HP6
  Scenario: Validate navigation bar order - 1st Home
    Then Admin should see "Home" in the 1st place

  @HP7
  Scenario: Validate navigation bar order - 2nd Program
    Then Admin should see "Program" in the 2nd place

  @HP8
  Scenario: Validate navigation bar order - 3rd Batch
    Then Admin should see "Batch" in the 3rd place

  @HP9
  Scenario: Validate navigation bar order - 4th Class
    Then Admin should see "Class" in the 4th place

  @HP10
  Scenario: Validate navigation bar order - 5th Logout
    Then Admin should see "Logout" in the 5th place

  @HP11
  Scenario: Verify pie-chart presence
    Then Admin should see a pie chart

  @HP12
  Scenario: Verify user details
    Then Admin should see a welcome message with username and role

  @HP13
  Scenario: Verify bar chart
    Then Admin should see a bar chart for Active and Inactive users

  @HP14
  Scenario: Verify user count
    Then Admin should see user count

  @HP15
  Scenario: Verify staff count
    Then Admin should see staff count

  @HP16
  Scenario: Verify program count
    Then Admin should see program count

  @HP17
  Scenario: Verify batch count
    Then Admin should see batch count

  @HP18
  Scenario: Verify staff table pagination
    Then Admin should see staff table with pagination icons

  @HP19
  Scenario: Verify staff data page split
    Then Admin should see 5 staff data in a page

  @HP20
  Scenario: Verify previous page icon is disabled
    Then Admin should see the previous page icon disabled

  @HP21
  Scenario: Verify first page icon is disabled
    Then Admin should see the first page icon disabled
