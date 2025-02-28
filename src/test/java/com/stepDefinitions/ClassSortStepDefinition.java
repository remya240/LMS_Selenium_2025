package com.stepDefinitions;

import java.util.List;

import org.junit.Assert;

import com.driverManager.DriverFactory;
import com.pages.ClassSortPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClassSortStepDefinition {

    ClassSortPage csp = new ClassSortPage(DriverFactory.getDriver());

    @When("Admin clicks on Arrow next to Batch Name of Class module page for sort")
    public void admin_clicks_on_Arrow_next_to_Batch_Name_of_Class_module_page_for_sort() {
    	csp.clickBatchNameSortAsc();
        
    }

    @Then("Admin See the Batch Name is sorted Ascending order in Class module page for sort")
    public void admin_See_the_Batch_Name_is_sorted_Ascending_order_in_Class_module_page_for_sort() {
    	List<String> originalList = csp.getOriginalList("BatchName");
    	List<String> sortedList = csp.getSortedList(originalList);
    	System.out.println("sorted name list" + sortedList.toString() );
    	Assert.assertTrue(originalList.equals(sortedList));

    }

    @When("Admin clicks on Arrow next to Batch Name of Class module page for sort descend")
    public void admin_clicks_on_Arrow_next_to_Batch_Name_of_Class_module_page_for_sort_descend() {
    	csp.clickBatchNameSortDesc();
        
    }

    @Then("Admin See the Batch Name is sorted Descending order in Class module page")
    public void admin_See_the_Batch_Name_is_sorted_Descending_order_in_Class_module_page() {
    	List<String> originalList = csp.getOriginalList("BatchName");
    	List<String> sortedList = csp.getSortedListDescending(originalList);
    	System.out.println("Descending sorted name list " + sortedList.toString() );
    	Assert.assertTrue(originalList.equals(sortedList));
        
    }

    }