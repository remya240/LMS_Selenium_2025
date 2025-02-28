Feature: Login

  #1
  Scenario: Validate login with valid data in all field #completed
    When Admin enter valid data in all field and clicks login button
    Then Admin should land on home page

  #2
  Scenario: Verify Admin is able to land on login page #completed
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should land on the login page

  #3
  Scenario: Verify Admin is able to land on home page with invalid URL#completed
    Given The browser is open
    When Admin gives the invalid LMS portal URL
    Then Admin should receive application error

  #4
  Scenario: Verify for broken link#completed
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then HTTP response >= 400 then the link is broken

  #5
  Scenario: Verify the text spelling in the page #completed
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see correct spellings in all fields

  #6
  Scenario: Verify application name# use google ocr for image text
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see  LMS - Learning Management System

  #7
  Scenario: Verify company name# use google ocr for image text
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see company name below the app name

  #8
  Scenario: Validate sign in content#completed
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see "Please login to LMS application"

  #9
  Scenario: Verify text field is present#complteed
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see two text field

  #10
  Scenario: Verify text on the first field#completed
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should "User" in the first text field

  #11
  Scenario: Verify dropdown is present#completed
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see one dropdown

  #12
  Scenario: Verify asterisk next to USER text#completed
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see asterisk mark symbol next to text for mandatory fields

  #13
  Scenario: Verify text on the second field #complted
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should "Password" in the second text field

  #14
  Scenario: Verify asterisk mark symbol next to password text#complted
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see asterisk mark symbol next to password text

  #15
  Scenario: Verify placeholder in dropdown to select role
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see "Select the role" placeholder in dropdown

  #16
  Scenario: Verify dropdown option to select role
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see "Admin , Staff, Student" options in dropdown

  #17
  Scenario: Verify the alignment input field for the login
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see input field on the centre of the page

  #18
  Scenario: verify Login button is present
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see login button

  #19
  Scenario: Verify input descriptive text in user field
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see "user" in gray color

  #20
  Scenario: Verify input descriptive text in password field
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should see "password" in gray color

  #21
  Scenario: Validate login with invalid data
    Given Admin is on login Page
    When Admin enter invalid data and clicks login button
    Then Error message "Invalid username and password Please try again"

  #22
  Scenario: Validate login credentials with null user name
    Given Admin is on login Page
    When Admin enter value only in password and clicks login button
    Then Error message "Please enter your user name"

  #23
  Scenario: Validate login credentials with null password
    Given Admin is on login Page
    When Admin enter value only in user name and clicks login button
    Then Error message "Please enter your password"

  #24
  Scenario: verify login button action through keyboard
    Given Admin is on login Page
    When Admin enter valid credentials  and clicks login button through keyboard
    Then Admin should land on home page

  #25
  Scenario: verify login button action through mouse
    Given Admin is on login Page
    When Admin enter valid credentials  and clicks login button through mouse
    Then Admin should land on home page
