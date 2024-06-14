package lib;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class CoreTestCase extends TestCase { // это позволит нам использовать класс TestCase из junit, в котором есть удобные методы, например чтобы кейс упал (fail) или для ассертов
    protected AndroidDriver driver; // здесь мы объявляем переменную driver, которая используется ниже при включении андроид драйвера
//    @Before // маркер junit чтобы он понял откуда запускаться, почему-то в этом файле мы его убрали
    private static String AppiumURL= "http://127.0.0.1:4723/";
    @Override
    protected void setUp() throws Exception { // в этом методе устанавливаем все необходимые параметры для запуска аппиум драйвер и поднятия приложения на устройстве
        //предупреждаем с помощью throws, что метод может выбросить исключение Exception (?)
        // внутри метода устанавливаем капабилитиз необходимые аппиуму для работы
        super.setUp(); // указываем что мы используем метод setUp из TestCase
        DesiredCapabilities capabilities = new DesiredCapabilities(); // создаем объект класса DesiredCapabilities
        capabilities.setCapability("platformName", "Android"); //вызываем метод setCapability этого класса
        capabilities.setCapability("appium:deviceName", "and80");
        capabilities.setCapability("appium:platformVersion", "8.0");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:appPackage", "com.healbe.healbegobe.debug");
        capabilities.setCapability("appium:appActivity", "com.healbe.healbegobe.ui.splash.SplashActivity");
        capabilities.setCapability("appium:app", "C:/Users/Tatyana/Desktop/JavaAppiumHealbeApp/apks/healbe.apk");
        capabilities.setCapability("unicodeKeyboard", true); // это чтобы клавиатура не показывалась при тестах
        capabilities.setCapability("resetKeyboard", true);
      //  capabilities.setCapability("appium:noReset", "true"); // эта строка будет сохранять настройки после перезапуска МА (для теста чтобы в меню была кнопка сохранить статью
        driver = new AndroidDriver(new URL(AppiumURL), capabilities); // тут мы включаем андроид драйвер, в скобках пишем путь до сервера
        this.rotateScreenPortrait(); // чтобы быть уверенными что приложение в портретной ориентации
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); - другой вариант установки wait взятый из интернета
    }

   /* @Before // так как я использую строку "appium:noReset", "true" онбординг не нужно проходить каждый раз
   public void onboarding() {
        WebElement element_to_continue1 = driver.findElementByXPath("//*[contains(@text, 'Continue')]");
        element_to_continue1.click();
        WebElement element_to_continue2 = driver.findElementByXPath("//*[contains(@text, 'Continue')]");
        element_to_continue2.click();
        WebElement element_to_continue3 = driver.findElementByXPath("//*[contains(@text, 'Continue')]");
        element_to_continue3.click();
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Accept')]"),
                "Cannot find Accept",
                15
        );
    } */

    //@After - почему-то в этом файле мы его убрали
    @Override
    protected void tearDown() throws Exception { // аппиум драйвер выключается
        driver.quit();
        super.tearDown(); //тоже из класса TestCase junit'a
    }

    protected void rotateScreenPortrait(){
        driver.rotate(ScreenOrientation.PORTRAIT);
    }
    protected void rotateScreenLandscape(){
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }
    protected void backgroungApp(int seconds){
        driver.runAppInBackground(Duration.ofSeconds(seconds));
    }

}

//    protected void backgroundApp(int seconds)
//    {
//        -        driver.runAppInBackground(seconds);
//        +        driver.runAppInBackground(Duration.ofSeconds(seconds));
//    }