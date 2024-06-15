package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class SettingsPage extends MainPageObject {
    public SettingsPage(AppiumDriver driver) {
        super(driver);
    }

    private static final By
            WEIGHT_UNITS = By.id("com.healbe.healbegobe.debug:id/weight_units"),
            HEIGHT_UNITS = By.id("com.healbe.healbegobe.debug:id/height_units"),
            DISTANCE_UNITS = By.id("com.healbe.healbegobe.debug:id/distance_units"),
            VOLUME_UNITS = By.id("com.healbe.healbegobe.debug:id/volume_units"),
            NOTIFICATION_SWITCH = By.id("com.healbe.healbegobe.debug:id/notifications_switch"),
            NOTIFICATION_PERIOD_ICON = By.id("com.healbe.healbegobe.debug:id/notification_period_icon"),
            NOTIFICATION_START_TIME = By.id("com.healbe.healbegobe.debug:id/start_layout"),
            NOTIFICATION_END_TIME = By.id("com.healbe.healbegobe.debug:id/end_layout"),
            FAST_SYNC_SWITCH = By.id("com.healbe.healbegobe.debug:id/fast_sync_switch"),
            CONNECT_GF_BUTTON = By.id("com.healbe.healbegobe.debug:id/google_fit_button"),
            SYNC_WEIGHT_DATA_SWITCH = By.id("com.healbe.healbegobe.debug:id/sync_profile_data_switch"),
            EXPORT_SENSOR_DATA_SWITCH = By.id("com.healbe.healbegobe.debug:id/export_sensors_data_switch");


    private String
            weight_units = "Pounds",
            height_units = "Inches",
            distance_units = "Miles",
            volume_units = "Ounces";

    public void editUnitsAndVerifySuccess() {
        // этот метод меняет все единицы измерения и проверяет, что они изменились на экране Settings
        // позже добавить проверку, что они изменились и на остальных экранах
        waitForElementAndClick(NavBar.NAVBAR_SETTINGS, "Cannot find Settings button on Navbar");
        waitForElementAndClick(WEIGHT_UNITS, "Cannot find weight units dropdown");
        pickSecondValueFromDropDown(WEIGHT_UNITS); //выберется Pounds
        assertElementHasText(WEIGHT_UNITS, weight_units, "Unexpected weight units");
        waitForElementAndClick(HEIGHT_UNITS, "Cannot find height units dropdown");
        pickSecondValueFromDropDown(HEIGHT_UNITS); //выберется Inches
        assertElementHasText(HEIGHT_UNITS, height_units, "Unexpected height units");
        waitForElementAndClick(DISTANCE_UNITS, "Cannot find weight units dropdown");
        pickSecondValueFromDropDown(DISTANCE_UNITS); //выберется Miles
        assertElementHasText(DISTANCE_UNITS, distance_units, "Unexpected weight units");
        waitForElementAndClick(VOLUME_UNITS, "Cannot find weight units dropdown");
        pickSecondValueFromDropDown(VOLUME_UNITS); //выберется Ounces
        assertElementHasText(VOLUME_UNITS, volume_units, "Unexpected weight units");
    }

    //метод поверхностно проверяет работоспособность остальных элементов на странице (кнопка GF, vibration, fast sync)
    public void checkOtherUIComponents() {
        //выключаем переключатель NOTIFICATION_SWITCH, если он включен, затем включаем, убеждаемся, что он включен.
        switchOffToggleIfNeeded(NOTIFICATION_SWITCH);
        waitForElementAndClick(NOTIFICATION_SWITCH, "Cannot find NOTIFICATION_SWITCH");
        Assert.assertTrue(isToggleSwitchOn(NOTIFICATION_SWITCH));
        // убеждаемся, что после включения NOTIFICATION_SWITCH появилась возможность выбрать период нотификаций
        swipeUpToFindElement(NOTIFICATION_PERIOD_ICON, "Cannot find NOTIFICATION_PERIOD_ICON by swiping up", 5);
        waitForElementAndClick(NOTIFICATION_PERIOD_ICON, "Cannot find NOTIFICATION_PERIOD_ICON");
        waitForElementPresent(NOTIFICATION_START_TIME, "Cannot find start time for notification");
        waitForElementPresent(NOTIFICATION_END_TIME, "Cannot find end time for notification");
        //выключаем переключатель FAST_SYNC_SWITCH, если он включен, затем включаем, убеждаемся, что он включен.
        swipeUpToFindElement(FAST_SYNC_SWITCH, "Cannot find FAST_SYNC_SWITCH", 5);
        switchOffToggleIfNeeded(FAST_SYNC_SWITCH);
        waitForElementAndClick(FAST_SYNC_SWITCH, "Cannot find FAST_SYNC_SWITCH");
        Assert.assertTrue(isToggleSwitchOn(FAST_SYNC_SWITCH));
        // нажимаем на кнопку Connect Google Fit, убеждаемся, что появляются переключатели
        swipeUpToFindElement(CONNECT_GF_BUTTON, "Cannot find Connect GF button by swiping up", 5);
        waitForElementAndClick(CONNECT_GF_BUTTON, "Cannot find GF button to click");
        swipeUpToFindElement(SYNC_WEIGHT_DATA_SWITCH, "Cannot find SYNC_WEIGHT_DATA_SWITCH by swiping up", 5);
        waitForElementPresent(SYNC_WEIGHT_DATA_SWITCH, "Cannot find SYNC_WEIGHT_DATA_SWITCH");
        swipeUpToFindElement(EXPORT_SENSOR_DATA_SWITCH, "Cannot find EXPORT_SENSOR_DATA_SWITCH by swiping up", 5);
        waitForElementPresent(EXPORT_SENSOR_DATA_SWITCH, "Cannot find EXPORT_SENSOR_DATA_SWITCH");

    }

    //метод, который выбирает второе значение сверху из выпадающего списка
    // workaround, так как выпадающий список типа AutoCompleteTextView не видно в инспекторе
    public void pickSecondValueFromDropDown(By by) {
        WebElement element = waitForElementPresent(by, "Cannot find WEIGHT_UNITS dropdown");
        Dimension size = element.getSize();
        int margin_x = 0;
        int margin_y = size.getHeight() * 2;
        tapToPointWithMarginFromCenterOfElement(by, margin_x, margin_y, "margin error");
    }

    // метод, который выключает переключатель, если он включен
    public void switchOffToggleIfNeeded(By locator) {
        WebElement toggleSwitch = driver.findElement(locator);

        String checkedValue = toggleSwitch.getAttribute("checked");

        if ("true".equals(checkedValue)) {
            toggleSwitch.click();

        } else {
        }

    }
}