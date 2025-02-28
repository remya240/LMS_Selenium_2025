
/************************************
Data driven testing is implemented by 
reading Test Data from Excel file and 
using Fillo library for excel reading.

 ************************************/

package com.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.constants.EnvironmentConstants;

public class ExcelReader {

	// 1.Fillo properties
	Fillo fillo = new Fillo();
	Connection connection = null;
	Recordset recordset = null;

	// 2.Excel Queries

	public static String LOGIN_POSITIVE_QUERY = "SELECT * FROM LOGIN WHERE TYPE='VALID'";
	public static String LOGIN_NEGATIVE_QUERY = "SELECT * FROM LOGIN WHERE TYPE='INVALID'";
	

	public static String PROGRAM_POSITIVE_QUERY = "SELECT * FROM PROGRAM WHERE TYPE='VALID'";
	public static String PROGRAM_NEGATIVE_QUERY = "SELECT * FROM  PROGRAM WHERE TYPE='INVALID'";

	public static String BATCH_POSITIVE_QUERY = "SELECT * FROM BATCH WHERE TYPE='VALID'";
	public static String BATCH_NEGATIVE_QUERY = "SELECT * FROM  BATCH WHERE TYPE='INVALID'";

	public static String CLASS_POSITIVE_QUERY = "SELECT * FROM CLASS WHERE TYPE='VALID'";
	public static String CLASS_NEGATIVE_QUERY = "SELECT * FROM  CLASS WHERE TYPE='INVALID'";
	
	

	
	public Map<String, List<String>> getData(String TestCase_Type, String Module) throws FileNotFoundException, IOException {
	    // Use a Map to store multiple values for each field (column)
	    Map<String, List<String>> testData = new LinkedHashMap<>();
	    try {
	        connection = fillo.getConnection(EnvironmentConstants.EXCEL_FILE_PATH);

	        // Determine which query to execute based on Module and TestCase_Type
	        switch (Module) {
	            case "Login":
	                if (TestCase_Type.equals("Positive")) {
	                    recordset = connection.executeQuery(LOGIN_POSITIVE_QUERY);
	                } else {
	                    recordset = connection.executeQuery(LOGIN_NEGATIVE_QUERY);
	                }
	                break;
	            case "Program":
	                if (TestCase_Type.equals("Positive")) {
	                    recordset = connection.executeQuery(PROGRAM_POSITIVE_QUERY);
	                } else {
	                    recordset = connection.executeQuery(PROGRAM_NEGATIVE_QUERY);
	                }
	                break;
	            case "Batch":
	                if (TestCase_Type.equals("Positive")) {
	                    recordset = connection.executeQuery(BATCH_POSITIVE_QUERY);
	                } else {
	                    recordset = connection.executeQuery(BATCH_NEGATIVE_QUERY);
	                }
	                break;
	            case "Class":
	                if (TestCase_Type.equals("Positive")) {
	                    recordset = connection.executeQuery(CLASS_POSITIVE_QUERY);
	                } else {
	                    recordset = connection.executeQuery(CLASS_NEGATIVE_QUERY);
	                }
	                break;
	        }

	        // Iterate over the rows of the recordset
	        while (recordset.next()) {
	            // Iterate over all fields (columns) for each row
	            for (String field : recordset.getFieldNames()) {
	                // Retrieve the field value
	                String fieldValue = recordset.getField(field);

	                // If the field (column) already exists in the Map, add the value to the List
	                if (!testData.containsKey(field)) {
	                    testData.put(field, new ArrayList<>());
	                }
	                testData.get(field).add(fieldValue);  // Add the value to the list for this column
	            }
	        }
	    } catch (FilloException exception) {
	        exception.printStackTrace();
	    } finally {
	        if (connection != null) {
	            connection.close();
	        }
	        if (recordset != null) {
	            recordset.close();
	        }
	    }

	    return testData;
	}

	
	
	@Test
	public void DataDrivenTesting() {

		Map<String, List<String>> testData;
		try {
			
			testData = getData("Positive", "Login");
			String Firstusername = testData.get("USER").get(0);
			String secondusername = testData.get("USER").get(1);
			
			String FirstPSWD = testData.get("PASSWORD").get(0);
			String secondpswd = testData.get("PASSWORD").get(1);
			
		
			System.out.println("First username testdata is " + Firstusername);
			System.out.println("Second username testdata is " + secondusername);
			
			System.out.println("First PSWD testdata is " + FirstPSWD);
			System.out.println("Second PSWD testdata is " + secondpswd);


		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
