package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassSortPage {
	
  public WebDriver cspdriver;
    private WebDriverWait wait;
    private Actions action;
    

    public ClassSortPage(WebDriver driver) {
        cspdriver = driver;
        PageFactory.initElements(driver, this);
        this.action = new Actions(driver);
    
    }

    // Sorting icons
    @FindBy(xpath = "//thead//tr//th[2]//i")
    private WebElement batchNameSortIcon;

    @FindBy(xpath = "//thead//tr//th[3]//i")
    private WebElement classTopicSortIcon;

    @FindBy(xpath = "//thead//tr//th[4]//i")
    private WebElement classDescriptionSortIcon;

    @FindBy(xpath = "//thead//tr//th[5]//i")
    private WebElement classStatusSortIcon;

    @FindBy(xpath = "//thead//tr//th[6]//i")
    private WebElement classDateSortIcon;

    @FindBy(xpath = "//thead//tr//th[7]//i")
    private WebElement staffNameSortIcon;

    // Column Data Lists
    @FindBy(xpath = "//tbody//td[2]")
    private List<WebElement> batchNameList;

    @FindBy(xpath = "//tbody//td[3]")
    private List<WebElement> classTopicList;

    @FindBy(xpath = "//tbody//td[4]")
    private List<WebElement> classDescriptionList;

    @FindBy(xpath = "//tbody//td[5]")
    private List<WebElement> classStatusList;

    @FindBy(xpath = "//tbody//td[6]")
    private List<WebElement> classDateList;

    @FindBy(xpath = "//tbody//td[7]")
    private List<WebElement> staffNameList;

    public void clickBatchNameSortAsc() {
    	action.click(batchNameSortIcon).perform();
		action.click(batchNameSortIcon).perform();
    }

    public void clickBatchNameSortDesc() {
    	action.click(batchNameSortIcon).perform();
		action.click(batchNameSortIcon).perform();
		action.click(batchNameSortIcon).perform();
		
    }

    public void clickClassTopicSortAsc() {
    	action.click(classTopicSortIcon).perform();
		action.click(classTopicSortIcon).perform();

;
    }

    public void clickClassTopicSortDesc() {
    	action.click(classTopicSortIcon).perform();
		action.click(classTopicSortIcon).perform();
		action.click(classTopicSortIcon).perform();
	


;
    }

    public void clickclassDescriptionSort() {
		action.click(classDescriptionSortIcon).perform();
		action.click(classDescriptionSortIcon).perform();

	}

	public void clickclassDescriptionSortDes() {
		action.click(classDescriptionSortIcon).perform();
		action.click(classDescriptionSortIcon).perform();
		action.click(classDescriptionSortIcon).perform();
	}


//    public void clickClassStatusSortAsc() {
//        clickSortIcon(classStatusSortIcon, 2);
//    }
//
//    public void clickClassStatusSortDesc() {
//        clickSortIcon(classStatusSortIcon, 3);
//    }
//
//    public void clickClassDateSortAsc() {
//        clickSortIcon(classDateSortIcon, 2);
//    }
//
//    public void clickClassDateSortDesc() {
//        clickSortIcon(classDateSortIcon, 3);
//    }
//
//    public void clickStaffNameSortAsc() {
//        clickSortIcon(staffNameSortIcon, 2);
//    }
//
//    public void clickStaffNameSortDesc() {
//        clickSortIcon(staffNameSortIcon, 3);
//    }
	//get and return original list	
		public List<String> getOriginalList(String type) {
			List<String> originalList = null;

			if (type.equals("BatchName")) {
				originalList = printWebElements(batchNameList);

			} else if (type.equals("ClassTopic")) {
				originalList = printWebElements(classTopicList);

			} else {
				originalList = printWebElements(classDescriptionList);
			}
			return originalList;
		}
			public List<String> getSortedList(List<String> originalList) {
				System.out.println("Original List Before sorting is" + originalList);
				List<String> sortedList = new ArrayList<>(originalList);
				Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
				System.out.println("Sorted List After sorting is" + sortedList);
				return sortedList;
			}

			public List<String> getSortedListDescending(List<String> originalList) {

				System.out.println("Original List Before sorting is" + originalList);
				List<String> sortedList = new ArrayList<>(originalList);
//		        Collections.sort(sortedList, (s1, s2) -> s2.compareToIgnoreCase(s1));
//		        Collections.sort(sortedList, Collections.reverseOrder());
				Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER.reversed());
				System.out.println("Sorted List After sorting is" + sortedList);
				return sortedList;
			}

		// covert web element to java string list	
			public List<String> printWebElements(List<WebElement> options) {
				List<String> texts = new ArrayList<String>();
				int i = 0;
				for (WebElement option : options) {
					texts.add(i, option.getText());
					i++;
				}
				System.out.println("The number of items in the list are: " + texts.size());
				return texts;
			}

			public boolean validateHeader(WebElement element, String header) {
				String headerText = "";
				if (element.isDisplayed()) {
					headerText = element.getText();
					if (headerText.equals(header)) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}


			public boolean isSortingbuttonDisplayed(List<WebElement> elements) {
				boolean flag = true;
				if (elements.size() > 1) {
					for (int i = 1; i < elements.size(); i++) {
						WebElement element = elements.get(i);
						if (!element.isDisplayed()) {
							flag = false;
							break;
						}
					}
				} else {
					flag = false;
				}
				return flag;
			}
}
