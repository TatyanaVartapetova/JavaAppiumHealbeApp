package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;


public class MainPageObject {
    protected AppiumDriver driver; // инициализируем драйвер
    public MainPageObject(AppiumDriver driver){
        this.driver = driver;
    }

    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) { // пишем название класса (а не тип данных как обычно, почему?)
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds); // WebDriverWait это один из селениумских методов, он принимает драйвер и время в секундах
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }


    public WebElement waitForElementPresent(By by, String error_message) { // перегрузка метода с ожиданием по умолчанию в 5 сек
        return waitForElementPresent(by, error_message, 5);
    }

    public WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) { // метод в котором сначала дожидается какого-то элемента, используя метод waitFoeElementPresent, а затем по нему кликают
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds); // сохраняем в переменную элемент результат выполнения функции?()
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) { // метод в котором сначала дожидается какого-то элемента, а затем вводят какое-то значение
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by)); // тут либо invisible, тогда true, либо нет
    }

    public WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    public void assertElementHasText(By by, String expected_text, String error_message) { //проверяет наличие ожидаемого текста у элемента
        WebElement element = waitForElementPresent(by, error_message, 5);
        String text_element = element.getText().toLowerCase(Locale.ROOT);
        Assert.assertEquals(error_message, expected_text, text_element);
    }

    public void assertFindFewTopics(WebElement listOfTopics, By by) {
        int size = listOfTopics.findElements(by).size();
        Assert.assertTrue("Cannot find few topics", size > 1);
    }

    public int countAmountOfElements(WebElement listOfTopics, By by) {
        int amount = listOfTopics.findElements(by).size();
        return amount;
    }

//    public void swipeUp(int timeOfSwipe){
//        TouchAction action = new TouchAction(driver);
//        Dimension size= driver.manage().window().getSize();
//        int x = size.width / 2;
//        int start_y = (int) (size.height * 0.8);
//        int end_y = (int) (size.height * 0.2);
//        action
//                .press(PointOption.point(x, start_y))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
//                .moveTo(PointOption.point(x, end_y))
//                .release()
//                .perform();
//
//
//    }

    public void swipeUp(Duration duration){
      //  WebElement element = waitForElementPresent(by, error_message, 10);

       // Point location = element.getLocation();
       // Dimension size = element.getSize();
//        int middle_x = size.getWidth()/2;
//        int start_y = (int) (size.getHeight() * 0.8);
//        int end_y = (int) (size.getHeight() * 0.2);
        Dimension size= driver.manage().window().getSize();
       int middle_x = size.width / 2;
       int start_y = (int) (size.height * 0.8);
       int end_y = (int) (size.height * 0.2);
        this.swipe(new Point(middle_x, start_y), new Point(middle_x, end_y), Duration.ofMillis(550));

//        TouchAction action = new TouchAction(driver);
//        Dimension size= driver.manage().window().getSize();
//        int x = size.width / 2;
//        int start_y = (int) (size.height * 0.8);
//        int end_y = (int) (size.height * 0.2);
//        action
//                .press(PointOption.point(x, start_y))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
//                .moveTo(PointOption.point(x, end_y))
//                .release()
//                .perform();


    }
    public void swipeUpQuick(){
        swipeUp(Duration.ofMillis(200));
    }

    public void swipeUpToFindElement(By by, String error_message, int max_swipes){
        int already_swiped =0;
        while (driver.findElements(by).size()==0){
            if (already_swiped>max_swipes){
                waitForElementPresent(by, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }
    }

//    public void swipeElementToLeft(By by, String error_message){
//        WebElement element=waitForElementPresent(by, error_message, 10);
//        int left_x = element.getLocation().getX(); // get x  - самая левая точка
//        int right_x = left_x + element.getSize().getWidth(); // прибавляем ширину элемента
//        int upper_y = element.getLocation().getY();
//        int lower_y = upper_y + element.getSize().getHeight();
//        int medium_y = (upper_y+lower_y)/2;
//        TouchAction action = new TouchAction(driver);
//        action
//                .press(PointOption.point(right_x, medium_y))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(150)))
//                .moveTo(PointOption.point(left_x, medium_y))
//                .release()
//                .perform();
//
//    }

    public void swipeElementToLeft(By by, String error_message) {

        WebElement element = waitForElementPresent(by, error_message, 10);

        Point location = element.getLocation();
        Dimension size = element.getSize();

        int left_x = location.getX();
        int right_x = left_x + size.getWidth();
        int upper_y = location.getY();
        int lower_y = upper_y + size.getHeight();
        int middle_y = upper_y + (size.getHeight() / 2);

        int start_x = right_x - 20;
        int end_x = left_x + 20;
        int start_y = middle_y;
        int end_y = middle_y;

        this.swipe(
                new Point(start_x, start_y),
                new Point(end_x, end_y),
                Duration.ofMillis(550)
        );
    }

    protected void swipe(Point start, Point end, Duration duration) {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger"); // потом можно создать 2 палец, напр для зума 2 пальцами, поэтому надо его называть
        Sequence swipe = new Sequence(finger, 1); //последовательность действий

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y)); // ZERO - быстро нажали
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        this.driver.perform(Arrays.asList(swipe));
    }


    public int getAmountOfElements(By by){
        List elements = driver.findElements(by);
        return elements.size();
    }


    public void assertElementNotPresent(By by, String error_message){
        int amount_of_elements = getAmountOfElements(by); // вычисляем количество элементов по переданному xpath
        if(amount_of_elements>0){
            String default_message = "An element '" + by.toString() + "'supposed to be not present"; // значение элемента by может быть не строка, поэтому преобразуем его в строку через метод toString()
            throw new AssertionError(default_message + " " + error_message);
        }


    }

//    public void assertElementPresent(By by, String error_message){
//        boolean quick_start = ; // вычисляем количество элементов по переданному xpath
//        if(quick_start==0){
//            String default_message = "An element '" + by.toString() + "'supposed to be not present"; // значение элемента by может быть не строка, поэтому преобразуем его в строку через метод toString()
//            throw new AssertionError(default_message + " " + error_message);
//        }

    public String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeoutInSeconds){
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }
    public void waitForEnterFormToAppear(){
        String logo_enter_form_id = "com.healbe.healbegobe.debug:id/logo";
        this.waitForElementPresent(
                By.id(logo_enter_form_id),
                "Cannot find logo on Enter Form ",
                15);
    }

    public void swipeUpHalfScreen(By by, String error_message, int max_swipes){
        //  WebElement element = waitForElementPresent(by, error_message, 10);

        // Point location = element.getLocation();
        // Dimension size = element.getSize();
//        int middle_x = size.getWidth()/2;
//        int start_y = (int) (size.getHeight() * 0.8);
//        int end_y = (int) (size.getHeight() * 0.2);
        Dimension size= driver.manage().window().getSize();
        int middle_x = size.width / 2;
        int start_y = (int) (size.height * 0.5);
        int end_y = (int) (size.height * 0.2);
        this.swipe(new Point(middle_x, start_y), new Point(middle_x, end_y), Duration.ofMillis(550));
    }

    public void tapToCenterOfElement(By by, String error_message) {

        WebElement element = waitForElementPresent(by, error_message, 10);

        Point location = element.getLocation(); // расположение элемента на странице - это точка левый верхний угол
        Dimension size = element.getSize(); // размеры элемента


        int middle_x = location.getX() + size.getWidth()/2;
        int middle_y = location.getY() + size.getHeight()/2;
        //int tap_y = middle_y + 20;


        this.tapToPoint(middle_x, middle_y);
    }

    public void tapToPoint(int x, int y) {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(200)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        this.driver.perform(Collections.singletonList(tap));
    }

    public void tapToPointRelativeToElement(By by, int margin_x, int margin_y, String error_message){
        WebElement element = waitForElementPresent(by, error_message, 10);

        Point location = element.getLocation(); // расположение элемента на странице - это точка левый верхний угол
        Dimension size = element.getSize(); // размеры элемента

        int middle_x = location.getX() + size.getWidth()/2;
        int middle_y = location.getY() + size.getHeight()/2;

        int tap_x = middle_x + margin_x;
        int tap_y = middle_y +margin_y;
        this.tapToPoint(tap_x, tap_y);

    }

    public void showDimensionOfElement(By by, String error_message){
        WebElement element = waitForElementPresent(by, error_message, 10);

        //Point location = element.getLocation(); // расположение элемента на странице - это точка левый верхний угол
        Dimension size = element.getSize(); // размеры элемента
        System.out.println(size);
    }

  //  public WebElement waitForTitleElement(){
   //     return this.waitForElementPresent(By.xpath(TITLE), "Cannot find article title on page ", 15);
  //  }
    public String getTextOfElement(By by){
        WebElement text_element = waitForElementPresent(by, "Cannot find text of Element", 5);
        return text_element.getAttribute("text");
    }

}


