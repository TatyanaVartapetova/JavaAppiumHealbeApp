package lib.ui;

import io.appium.java_client.AppiumDriver;
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
            FAST_SYNC_SWITCH = By.id("com.healbe.healbegobe.debug:id/fast_sync_switch"),
            CONNECT_GF_BUTTON = By.id("com.healbe.healbegobe.debug:id/google_fit_button");

private String
    weight_units = "Pounds",
    height_units = "Inches",
    distance_units = "Miles",
    volume_units = "Ounces";
    public void editUnitsAndVerifySuccess(){
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
    //метод, который выбирает второе значение сверху из выпадающего списка
    // workaround, так как выпадающий список типа AutoCompleteTextView не видно в инспекторе
    public void pickSecondValueFromDropDown(By by) {
        WebElement element = waitForElementPresent(by, "Cannot find WEIGHT_UNITS dropdown");
        Dimension size = element.getSize();
        int margin_x = 0;
        int margin_y = size.getHeight() * 2;
        tapToPointWithMarginFromCenterOfElement(by, margin_x, margin_y, "margin error");
    }

//    private void pickSexFromDropDown(String sex) {
//        WebElement element = waitForElementPresent(SEX_FIELD, "Cannot find Sex field");
//        Dimension size = element.getSize(); // размеры элемента
//        int margin_x = 0;
//        int margin_y = 0;
//        switch (sex) {
//            case "Male":
//                margin_y = size.getHeight();
//                break;
//            case "Female":
//                margin_y = size.getHeight() * 2;
//                break;
//            default:
//                System.out.println("Invalid value. Please enter Female or Male.");
//        }
//        tapToPointWithMarginFromCenterOfElement(SEX_FIELD, margin_x, margin_y, "margin error");
//    }
}
