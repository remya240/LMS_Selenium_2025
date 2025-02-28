#Feature: Manage Class Functionality
#
  #Background: 
    #Given Admin gives the correct LMS portal URL
    #Given Admin is on login Page
    #When Admin enters valid data in all fields and clicks the login button
    #Given Admin is on the home page
    #When Admin clicks the Class Navigation bar in the Header
    #Then Admin should land on the Manage Class page
#
  #@DeleteMultipleClass1
  #Scenario: Validate Common Delete button enabled after clicking on any checkbox
    #When Admin clicks any checkbox in the data table
    #Then Admin should see the common delete option enabled under the header Manage Class
#
  #@DeleteMultipleClass2
  #Scenario Outline: Validate single class deletion by selecting a checkbox
    #When Admin clicks the checkbox for the class named "<ClassTopic>"
    #When Admin clicks the common delete button
    #Given Admin is on Confirm Deletion alert
    #When Admin clicks <YES> button on the alert
    #Then Admin should land on Manage Class page and can see the class "<ClassTopic>" is deleted from the data table
#
  #Examples:
    #| ClassTopic |
    #| drsacv      |
    #
    #@DeleteMultipleClass3
#Scenario Outline: Validate single class deletion cancellation by selecting a checkbox
  #When Admin clicks the checkbox for the class named "<ClassTopic>"
  #And Admin clicks the common delete button
  #Then Admin is on Confirm Deletion alert
  #When Admin clicks "No" button on the alert
  #Then Admin should land on Manage Class page and can see the selected class is not deleted from the data table
    #Examples:
    #| ClassTopic |
    #| testingselenium      |
   #
   #
  #@DeleteMultipleClass4  
  #Scenario Outline: Validate multiple class deletion by selecting multiple checkboxes
  #When Admin selects the checkboxes for the classes "<ClassNames>"
  #When Admin clicks the common delete button
  #Given Admin is on Confirm Deletion alert
  #When Admin clicks <YES> button on the alert
  #Then Admin should land on Manage Class page and can see the selected classes are deleted from the data table
#
  #Examples:
    #| ClassNames       |
    #|  testingselenium , testingselenium1  | 
    #
  #
  #@DeleteMultipleClass5
  #Scenario Outline: Validate multiple class deletion cancellation by selecting multiple checkboxes
   #When Admin selects the checkboxes for the classes "<ClassNames>"
   #And Admin clicks the common delete button
    #Given Admin is on Confirm Deletion alert
    #When Admin clicks "No" button on the alert
    #Then Admin should land on Manage Class page and can see the selected classes are not deleted from the data table  
    #Examples:
    #| ClassNames       |
    #|  Testing_Team10_1 , Testing_Team10_2 | 
