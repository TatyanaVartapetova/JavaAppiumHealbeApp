package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class W_SearchPageObject extends MainPageObject{
    private static final String
    SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
    SEARCH_INPUT = "//*[contains(@text, 'Search Wikipedia')]",
    SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
    SEARCH_RESULT_ELEMENT =  "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title']",
    SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[contains(@text, '{SUBSTRING}')]",
    SEARCH_EMPTY_RESULT_ELEMENT = "//*[@text='No results']";
public W_SearchPageObject(AppiumDriver driver){
    super(driver); //таким образом мы берем драйвер из MainPageObject
}
/* TEMPLATE METHOD - такие методы называются методами темплэйтов(шаблонов)*/
private static String getResultSearchElement(String substring){ //этот метод не будет взаимодействовать с драйвером, он будет просто преобразовывать строки, поэтому мы можем не использовать здесь драйвер и сделать этот метод статичным.
return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
}
/* TEMPLATE METHOD */
public void initSearchInput(){
    this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element");
    this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
}
public void waitForCancelButtonToAppear(){
    this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "Cannot find search cancel button", 5);
}
public void waitForCancelButtonToDisappear(){
    this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "Cancel button still present", 5);
}
public void clickCancelSearch(){
    this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannot find and click search cancel button", 5);
}
public void typeSearchLine(String search_line){
this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
}
public void waitForSearchResult(String substring){
    String searchResultXpath = getResultSearchElement(substring);
    this.waitForElementPresent(By.xpath(searchResultXpath), "Cannot find search result with substring " + substring);
}
public void clickByArticleWithSubstring(String substring){
    String searchResultXpath = getResultSearchElement(substring);
    this.waitForElementAndClick(By.xpath(searchResultXpath), "Cannot find and click search result with substring " + substring, 10);
}

public int getAmountOfFoundArticles() {
    this.waitForElementPresent(By.xpath(SEARCH_RESULT_ELEMENT),
            "Cannot find anything by the request ",
            15);
    return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));

    }
    public void waitForEmptyResultsLabel(){
    this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT), "Cannot find empty result element", 15);
    }

    public void assertThereIsNoResultsOfSearch(){
    this.assertElementNotPresent(By.xpath(SEARCH_RESULT_ELEMENT), "we supposed not to find any results");
    }
}
