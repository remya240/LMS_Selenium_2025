Feature:Delete multiple batches with checkbox
Background: Admin is logged in to LMS Portal
Given The Browser is open
When Log into LMS Portal as Admin
Then Admin is on the Batch page
  Scenario: Validate single row delete with checkbox
    Given Admin is on batch page
    When Admin clicks on the delete icon under the Manage batch header
    Then The respective row in the table should be deleted

  Scenario: Validate multiple row delete with checkbox
    Given Admin is on batch page
    When Admin clicks on the delete icon under the Manage batch header
    Then The respective row in the table should be deleted
