Feature: Class Delete

  Background: Admin is logged in to LMS Portal
    Given The Browser is open
    When Log into LMS Portal as Admin
    And Admin clicks the "Class" Navigation bar in the Header
    Then Admin clicks on Delete option for particular class

  @ClassDelete1
  Scenario: Validate row level delete icon
    Then Admin should see an alert open with heading "Confirm" along with "<YES>" and "<NO>" buttons for deletion

  @ClassDelete2
  Scenario: Click Yes on deletion window
    When Admin clicks the "YES" option
    Then Admin gets a message "Successful" alert

  @ClassDelete3
  Scenario: Click No on deletion window
    When Admin clicks the "NO" option
    Then Admin can see the deletion alert disappears without deleting

  @ClassDelete4
  Scenario: Validate Close(X) icon on Confirm Deletion alert
    Given Admin is on Confirm Deletion alert
    When Admin clicks on the close button
    Then Admin can see the deletion alert disappears without any changes
