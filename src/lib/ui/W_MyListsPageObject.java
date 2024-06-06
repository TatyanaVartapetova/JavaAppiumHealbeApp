package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class W_MyListsPageObject extends MainPageObject{
    public static final String
    FOLDER_BY_NAME_TPL = "//*[@text='{FOLDER_NAME}']",
    MY_LISTS_BUTTON = "org.wikipedia:id/nav_tab_reading_lists",
    ARTICLE_BY_TITLE_TPL = "//*[@text='{ARTICLE_TITLE}']";
            private static String getFolderXpathByName(String name_of_folder){
                return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
            }
    private static String getArticleXpathByTitle(String article_title){
        return ARTICLE_BY_TITLE_TPL.replace("{ARTICLE_TITLE}", article_title);
    }
    public W_MyListsPageObject(AppiumDriver driver){
        super(driver);
    }
    public void clickToMyListsButton(){
        this.waitForElementAndClick(By.id(MY_LISTS_BUTTON), "cannot find my list icon", 15);
    }
    public void openFolderByName(String name_of_folder){
                String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                By.xpath(folder_name_xpath),
                "cannot find folder by name" + name_of_folder,
                15);
    }

    public void swipeByArticleToDelete(String article_title){
        String article_xpath = getArticleXpathByTitle(article_title);
        this.waitForArticleToAppearByTitle(article_title);
        this.swipeElementToLeft(By.xpath(article_xpath), "cannot find saved articles");
        this.waitForArticleToDisappearByTitle(article_title);

    }
    public void waitForArticleToAppearByTitle(String article_title){
        String article_xpath = getArticleXpathByTitle(article_title);
        this.waitForElementPresent(
                By.xpath(article_xpath),
                "Cannot find saved article by title " + article_title,
                15);
    }
    public void waitForArticleToDisappearByTitle(String article_title){
        String article_xpath = getArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(
                By.xpath(article_xpath),
                "saved articles still present with title" + article_title,
                15);
    }
}
