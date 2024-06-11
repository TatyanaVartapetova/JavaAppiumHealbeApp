import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class W_FirstTest extends CoreTestCase { //название класса, наследуем lib.ui.CoreTestCase с запуском и тд, а отсюда этот код удаляем
private MainPageObject MainPageObject;// вот эту всю часть с MainPageObject надо будет удалить после рефакторинга, она тут не нужна будет
protected void setUp() throws Exception{
    super.setUp();
    MainPageObject = new MainPageObject(driver);
}
    @Test
    public void testSearch() { //все тесты должны начинаться со слова test
        W_SearchPageObject SearchPageObject = new W_SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("programming language");
    }

    @Test
    public void testOnboardingNextButton(){
    W_NavigationUI NavigationUI = new W_NavigationUI(driver);
    NavigationUI.navigationNext();
    NavigationUI.navigationNext();
    MainPageObject.waitForElementPresent(By.id("com.healbe.healbegobe.debug:id/logo"), "Cannot find logo on Enter Form", 5);
    MainPageObject.waitForElementPresent(By.id("com.healbe.healbegobe.debug:id/buy_it"), "Cannot find 'Buy it' button on Enter Form", 5);
    MainPageObject.waitForElementPresent(By.id("com.healbe.healbegobe.debug:id/button"), "Cannot find Sign Up Button on Enter Form", 5);
    MainPageObject.waitForElementPresent(By.id("com.healbe.healbegobe.debug:id/sign_in"), "Cannot find Sign In Button on Enter Form", 5);
    MainPageObject.waitForElementAndClick(By.id("com.healbe.healbegobe.debug:id/sign_in"), "Cannot click on Sign In Button on Enter Form", 5);

    }

@Test
public void testSignIn(){
    W_NavigationUI NavigationUI = new W_NavigationUI(driver);
    NavigationUI.navigationNext();
    NavigationUI.navigationNext();
    MainPageObject.waitForElementAndClick(By.id("com.healbe.healbegobe.debug:id/sign_in"), "Cannot click on Sign In Button on Enter Form", 5);
    MainPageObject.waitForElementAndClick(By.id("com.healbe.healbegobe.debug:id/email"), "Cannot find email field", 5);
    MainPageObject.waitForElementAndSendKeys(By.id("com.healbe.healbegobe.debug:id/email"), "v602@v.co", "Cannot find and type into email field", 5);
    MainPageObject.waitForElementAndSendKeys(By.id("com.healbe.healbegobe.debug:id/password"), "Heal", "Cannot find and type into password field", 5);
   // MainPageObject.swipeUpHalfScreen(By.id("com.healbe.healbegobe.debug:id/button"),"Cannot find Sign In Button on Sign In", 50);
    MainPageObject.waitForElementAndClick(By.id("com.healbe.healbegobe.debug:id/button"), "Cannot click on Sign In Button on Sign In", 5);
    MainPageObject.waitForElementAndClick(By.id("com.healbe.healbegobe.debug:id/sex"), "Cannot find Sex field",  15);
    MainPageObject.showDimensionOfElement(By.id("com.healbe.healbegobe.debug:id/sex"), "cannot find demension of element");
  //  MainPageObject.tapToPointRelativeToElement(By.id("com.healbe.healbegobe.debug:id/sex"), 0, 340, "margin error");
    MainPageObject.assertElementHasText(By.id("com.healbe.healbegobe.debug:id/sex"), "female", "No Female on sex field");

    // MainPageObject.waitForElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc=\"Close\"]"), "Cannot find X button", 5);
  //  MainPageObject.waitForElementNotPresent(By.id("com.healbe.healbegobe.debug:id/scroll_view"), "Welcome screen still present", 5);

}

public void testSignUp(){
    W_NavigationUI NavigationUI = new W_NavigationUI(driver);
    NavigationUI.navigationNext();
    NavigationUI.navigationNext();
    MainPageObject.waitForElementAndClick(By.id("com.healbe.healbegobe.debug:id/button"), "Cannot click on Sign Up Button on Enter Form", 5);
 //   MainPageObject.waitForElementAndSendKeys(By.id("com.healbe.healbegobe.debug:id/email"), "v60@v.co", "Cannot find and type into email field", 5);
//    MainPageObject.waitForElementAndSendKeys(By.id("com.healbe.healbegobe.debug:id/password"), "Heal", "Cannot find and type into password field", 5);
 //   MainPageObject.swipeUpHalfScreen(By.id("com.healbe.healbegobe.debug:id/button"),"Cannot find Sign Up Button on Sign Up", 50);
 //   MainPageObject.waitForElementAndClick(By.id("com.healbe.healbegobe.debug:id/privacy_check"), "Cannot click on Privacy Check Button on Sign Up", 5);
  //  MainPageObject.waitForElementAndClick(By.id("com.healbe.healbegobe.debug:id/button"), "Cannot click on Sign Up Button on Sign Up", 5);
 //   MainPageObject.waitForElementPresent(By.id("com.healbe.healbegobe.debug:id/view_root"), "Cannot find error message 'user already exist'", 5);
    MainPageObject.waitForElementAndSendKeys(By.id("com.healbe.healbegobe.debug:id/email"), "v612@v.co", "Cannot find and type into email field", 5);
    MainPageObject.waitForElementAndSendKeys(By.id("com.healbe.healbegobe.debug:id/password"), "Heal", "Cannot find and type into password field", 5);
    MainPageObject.waitForElementAndClick(By.id("com.healbe.healbegobe.debug:id/privacy_check"), "Cannot click on Privacy Check Button on Sign Up", 5);
    MainPageObject.swipeUpHalfScreen(By.id("com.healbe.healbegobe.debug:id/button"),"Cannot find Sign Up Button on Sign Up", 15);
    MainPageObject.waitForElementAndClick(By.id("com.healbe.healbegobe.debug:id/button"), "Cannot click on Sign Up Button on Sign Up", 15);
    MainPageObject.waitForElementAndSendKeys(By.id("com.healbe.healbegobe.debug:id/first_name"), "Tatyana", "Cannot find and type into First Name field", 15);
    MainPageObject.waitForElementAndSendKeys(By.id("com.healbe.healbegobe.debug:id/second_name"), "Vart", "Cannot find and type into Last Name field", 15);
    MainPageObject.waitForElementAndClick(By.id("com.healbe.healbegobe.debug:id/sex"), "Cannot find Sex field",  15);
    MainPageObject.showDimensionOfElement(By.id("com.healbe.healbegobe.debug:id/sex"), "cannot find dimension of element");
  //  MainPageObject.waitForElementAndSendKeys(By.id("com.healbe.healbegobe.debug:id/sex"), "female ", "Cannot input value", 15);
  //  MainPageObject.tapToPointRelativeToElement(By.id("com.healbe.healbegobe.debug:id/sex"), 0, 30, "margin error");

    // driver.pressKeyCode(AndroidKeyCode.KEYCODE_PAGE_DOWN); не сработало
   // driver.pressKeyCode(AndroidKeyCode.ENTER);
    MainPageObject.assertElementHasText(By.id("com.healbe.healbegobe.debug:id/sex"), "Female", "No Female on sex field");
  //  MainPageObject.waitForElementPresent(By.id("com.healbe.healbegobe.debug:id/sex"), "Cannot find sex field after pick female", 15);


//    public void assertElementHasText(By by, String expected_text, String error_message) { //проверяет наличие ожидаемого текста у элемента
//        WebElement element = waitForElementPresent(by, error_message, 5);
//        String text_element = element.getText().toLowerCase(Locale.ROOT);
//        Assert.assertEquals(error_message, expected_text, text_element);
//    }

//    System.out.println(driver.getPageSource()); // этот метод выводит XML документа в консоль



}
    @Test
    public void testCancelSearch() {
        W_SearchPageObject SearchPageObject = new W_SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

    @Test
    public void testCompareArticleTitle() {
        W_SearchPageObject SearchPageObject = new W_SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("programming language");

        W_ArticlePageObject ArticlePageObject = new W_ArticlePageObject(driver);
        String article_title = ArticlePageObject.getArticleTitle();
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Object-oriented programming language')]"),
//                "Cannot find 'Object-oriented programming language' topic searching by java",
//                5
//        );
//        WebElement title_element = MainPageObject.waitForElementPresent(
//                By.xpath("//*[@text='Java (programming language)']"),
//                "Cannot find article title",
//                15
//        );
//        String article_title = title_element.getAttribute("text");
        assertEquals("We see unexpected article title", "Java (programming language)", article_title);
    }

    @Test // 1 задание 3го урока
    public void testCompareTextOfSearchInput() {
        MainPageObject.assertElementHasText(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "search wikipedia",
                "Text of search input is unexpected");

    }

    @Test // 2 задание 3го урока
    public void testFindFewTopicsAndCancelSearch() { //Ищет какое-то слово; Убеждается, что найдено несколько статей; Отменяет поиск; Убеждается, что результат поиска пропал
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find search input",
                15
        );
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Tree",
                "Cannot input value",
                20
        );
        WebElement listOfTopics = MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/search_results_list"),
                "Cannot find Results list",
                20);
        MainPageObject.assertFindFewTopics(listOfTopics, By.id("org.wikipedia:id/page_list_item_title"));

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find X button",
                20);

        MainPageObject.waitForElementNotPresent(
                By.id("org.wikipedia:id/search_results_list"),
                "Results list still present",
                15);
    }

    @Test // 3 задание 3 урока
    // Написать тест, который делает поиск по какому-то слову. Например, JAVA. Затем убеждается, что в каждом результате поиска есть это слово.
    public void testSearchAndEnsureAllResultsContainInput() {
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find search input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Cannot input value",
                5
        );

        WebElement listOfTopics = MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/search_results_list"),
                "Cannot find Results list",
                15);

        int amount_of_element_with_input = MainPageObject.countAmountOfElements(listOfTopics, By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][contains(@text, 'Java')]"));
        int amount_of_element = MainPageObject.countAmountOfElements(listOfTopics, By.id("org.wikipedia:id/page_list_item_title"));
        assertTrue("Not all result contains input", amount_of_element == amount_of_element_with_input);
        // это будет работать, но некрасиво и без приведения к lowerCase, позже разобраться как сделать правильно. Цикл с assertHasText?
        // assertElementHasText(By.id("org.wikipedia:id/page_list_item_title"), "tree", "Cannot find elements with expected text"); - уже с lowerCase
    }

    @Test //4 урок - 1
    public void testSwipeArticle() {
        W_SearchPageObject SearchPageObject = new W_SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Krot");
        SearchPageObject.clickByArticleWithSubstring("Surname");

        W_ArticlePageObject ArticlePageObject = new W_ArticlePageObject(driver);
      //  ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter();
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='Automation for Apps']"),
//                "Cannot find 'Automation for Apps",
//                5);

      //  MainPageObject.swipeUpToFindElement(By.xpath("//*[@text='View article in browser']"), "Cannot find element in footer", 20);

    }

    @Test //4 урок - 2 - сохранение и удаление статьи
    public void testSaveFirstArticleToMyList() {
        W_SearchPageObject SearchPageObject = new W_SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("programming language");
        W_ArticlePageObject ArticlePageObject = new W_ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        W_NavigationUI NavigationUI = new W_NavigationUI(driver);
        NavigationUI.navigationNext(); // тут было navigationUp
        NavigationUI.navigationNext(); // тут было navigationUp
        W_MyListsPageObject MyListsPageObject = new W_MyListsPageObject(driver);
        MyListsPageObject.clickToMyListsButton();
        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete(article_title);
    }

    @Test //4 урок - 3
    public void testAmountOfNotEmptySearch() {
        W_SearchPageObject SearchPageObject = new W_SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Gecko";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();
        assertTrue("Cannot find any results", amount_of_search_results > 0);
    }

    @Test //4 урок - 4 (assertion error)
    public void testAmountOfEmptyResults() {
        W_SearchPageObject SearchPageObject = new W_SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "jhfkjhk";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultsOfSearch();
    }

    @Test //4 урок - 5 (rotation)
    public void testChangeScreenOrientationOnSearchResults() {
        W_SearchPageObject SearchPageObject = new W_SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("programming language");
        W_ArticlePageObject ArticlePageObject = new W_ArticlePageObject(driver);
        String title_before_rotation = ArticlePageObject.getArticleTitle();
        this.rotateScreenLandscape();
        String title_after_rotation = ArticlePageObject.getArticleTitle();
        assertEquals("Article description has been changed after rotation", title_before_rotation, title_after_rotation);
        this.rotateScreenPortrait();
        String title_after_second_rotation = ArticlePageObject.getArticleTitle();
        assertEquals("Article description has been changed after rotation", title_before_rotation, title_after_second_rotation);

//                MainPageObject.waitForElementAndGetAttribute(
//                By.id("pcs-edit-section-title-description"),
//                "text",
//                "cannot find description of article",
//                15);
//        driver.rotate(ScreenOrientation.LANDSCAPE);
//        String description_after_rotation = MainPageObject.waitForElementAndGetAttribute(
//                By.id("pcs-edit-section-title-description"),
//                "text",
//                "cannot find description of article",
//                15);
//        Assert.assertEquals("Article description has been changed after rotation", description_before_rotation, description_after_rotation);
//        driver.rotate(ScreenOrientation.PORTRAIT);
//        String description_after_second_rotation = MainPageObject.waitForElementAndGetAttribute(
//                By.id("pcs-edit-section-title-description"),
//                "text",
//                "cannot find description of article",
//                15);
//        Assert.assertEquals("Article description has been changed after rotation", description_before_rotation, description_after_second_rotation);
    }

@Test // 4 урок - 6 (background) - тест падает, потому что там баг. 
public void testCheckSearchArticleOnBackground(){

    W_SearchPageObject SearchPageObject = new W_SearchPageObject(driver);
    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.waitForSearchResult("programming language");
    this.backgroungApp(2);
    SearchPageObject.waitForSearchResult("programming language");


//    MainPageObject.waitForElementPresent(
//            By.xpath("//*[contains(@text, 'Java (programming language)')]"),
//            "Cannot find 'Java (programming language)' topic after returning from background",
//            15
//    );
}

    @Test //дз1- сохранение 2х и удаление 1 статьи
    public void testSaveTwoArticlesToMyList() {
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find Search input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Cannot input value",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Java (programming language)')]"),
                "Cannot find 'Java (programming language)' topic searching by java",
                15
        );
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find article title",
                15
        );
        MainPageObject.waitForElementAndClick(By.id("org.wikipedia:id/page_toolbar_button_show_overflow_menu"), "Cannot find button more options", 15);
        //waitForElementAndClick(By.id("org.wikipedia:id/customize_toolbar"), "Cannot find customize toolbar", 15);
        MainPageObject.waitForElementAndClick(By.id("org.wikipedia:id/page_save"), "Save not found", 15);
        MainPageObject.waitForElementAndClick(By.id("org.wikipedia:id/snackbar_action"), "Add to list button not found", 30);
        String name_of_folder = "Programming";
        MainPageObject.waitForElementAndSendKeys(By.id("org.wikipedia:id/text_input"), name_of_folder, "Cannot input value", 15);
        MainPageObject.waitForElementAndClick(By.xpath("//*[@text='OK']"), "Cannot find Ok button", 15);

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/page_toolbar_button_search"),
                "Cannot find Search input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Appium",
                "Cannot input value",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']"),
                "Cannot find 'Appium' topic searching by appium",
                15
        );
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Automation for Apps']"),
                "Cannot find article title",
                15
        );
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/page_toolbar_button_show_overflow_menu"),
                "Cannot find button more options",
                15);
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Save not found",
                15);
        MainPageObject.waitForElementAndClick(By.id("org.wikipedia:id/snackbar_action"), "Add to list button not found", 15);
        MainPageObject.waitForElementAndClick(By.xpath("//*[@text='Programming']"), "Programming folder not found", 15);
        MainPageObject.waitForElementAndClick(By.id("org.wikipedia:id/snackbar_action"),"Cannot find snackBar button", 150);
        MainPageObject.waitForElementAndClick(By.xpath("//*[@text='" + name_of_folder + "']"), "cannot find created folder", 15);
        MainPageObject.swipeElementToLeft(By.xpath("//*[@text='Java (programming language)']"), "cannot find saved articles");
        MainPageObject.waitForElementNotPresent(By.xpath("//*[@text='Java (programming language)']"), "saved articles still present", 15);
        MainPageObject.waitForElementAndClick(By.xpath("//*[@text='Automation for Apps']"), "cannot find Appium article in Programming folder", 20);
        WebElement title_element = MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Appium']"),
                "Cannot find article title",
                15
        );
        String article_title = title_element.getAttribute("text");
        assertEquals("We see unexpected article title", "Appium", article_title);

    }


}

// WebElement - это класс, описывающий webElement (видимо его можно указывать вместо типа переменной) - для элемента который мы будем искать (даже не класс, а интерфейс вероятно)
// element - название объекта класса WebElement (указывать понятно - напр element_to_init_search, хотя дальше походу рефакторинг)
// .driver - вызываем аппиум драйвер
// .findElement и т.д. это методы драйвера аппиума
// для xpath пишем сначала // что означает любую вложенность, затем * что означает любой элемент, далее в [] contains - позволяет искать по частичному совпадению, далее в () пишем @text, 'текст по кот мы хотим искать'
//конкатенация: выбираем сначала общий элемент, затем уточняе. Пример "//*[@resource-id='...']//*[@text='...'] - перед элементом всегда ставится add(@)
// //*-значит переход на более низкий уровень. Если мы уточняем элемент в первых квадратных скобках, то между ними ничего не ставить.


