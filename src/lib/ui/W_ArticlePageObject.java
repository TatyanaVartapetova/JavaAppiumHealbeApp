package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class W_ArticlePageObject extends MainPageObject {
    private static final String
    TITLE = "//*[@text='Java (programming language)']",
            //"//*[@text='Automation for Apps']", в примере тут айди и он одинаковый для всех статей, поэтому у меня такая фигня

    FOOTER_ELEMENT = "//*[@text='View article in browser']",
    OPTIONS_BUTTON = "org.wikipedia:id/page_toolbar_button_show_overflow_menu",
    SAVE_BUTTON = "org.wikipedia:id/page_save",
    MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
    MY_LIST_OK_BUTTON = "//*[@text='OK']",
    OPTIONS_ADD_TO_MY_LIST_BUTTON = "org.wikipedia:id/snackbar_action";

    public W_ArticlePageObject(AppiumDriver driver){
        super(driver);
    }
    public WebElement waitForTitleElement(){
    return this.waitForElementPresent(By.xpath(TITLE), "Cannot find article title on page ", 15);
    }
    public String getArticleTitle(){
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }
    public void swipeToFooter(){
        this.swipeUpToFindElement(By.xpath(FOOTER_ELEMENT), "Cannot find the end of article", 20);
    }

    public void addArticleToMyList(String name_of_folder){

        this.waitForElementAndClick(By.id(OPTIONS_BUTTON), "Cannot find button more options", 15);
        //waitForElementAndClick(By.id("org.wikipedia:id/customize_toolbar"), "Cannot find customize toolbar", 15);
        this.waitForElementAndClick(By.id(SAVE_BUTTON), "Save not found", 15);
        this.waitForElementAndClick(By.id(OPTIONS_ADD_TO_MY_LIST_BUTTON), "Add to list button not found", 15);

        this.waitForElementAndSendKeys(By.id(MY_LIST_NAME_INPUT), name_of_folder, "Cannot input value", 15);
        this.waitForElementAndClick(By.xpath(MY_LIST_OK_BUTTON), "Cannot find Ok button", 15);
    }


}
