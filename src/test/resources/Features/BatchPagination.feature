Feature: Pagination

  Background: Admin is logged in to LMS Portal
    Given The Browser is open
    When Log into LMS Portal as Admin

  Scenario: Validate next page link
    Given Admin is on batch page
    When Admin clicks next page link on the data table
    Then Admin should see the Next enabled link

  Scenario: validate last page link
    Given Admin is on batch page
    When Admin clicks last page link on the data table
    Then Admin should see the last page link with next page link disabled on the table

  Scenario: validate the previous page link
    Given Admin is on batch page
    When Admin clicks previous page link on the data table
    Then Admin should see the previous page on the table

  Scenario: validate the first page link
    Given Admin is on batch page
    When Admin clicks first page link on the data table
    Then Admin should see the very first page on the data table
