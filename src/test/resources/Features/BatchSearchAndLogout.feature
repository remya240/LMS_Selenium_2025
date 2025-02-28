Feature:Search Textbox validation and Loggout of the application from the batch page

  Background: Admin is logged in to LMS Portal
    Given The Browser is open
    When Log into LMS Portal as Admin

  Scenario: validate search box functionality
    Given Admin is on batch page
    When Admin enters the batch name in the search text box
    Then Admin should see the filtered batches in the data table

  Scenario: Validate logout option in the header is visible and enabled from the batch page
    Given Admin is on batch page
    When Admin clicks on the logout button
    Then Admin should see the Login screen Page
