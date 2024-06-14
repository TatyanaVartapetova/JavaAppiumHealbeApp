package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProfilePage extends EditProfilePage {

    public ProfilePage(AppiumDriver driver) {
        super(driver);
    }

    // локаторы
    public static final By
            USERNAME = By.id("com.healbe.healbegobe.debug:id/headerUsername"),
            SEX = By.id("com.healbe.healbegobe.debug:id/gender_value"),
            DATE_OF_BIRTH = By.id("com.healbe.healbegobe.debug:id/birth_date_value"),
            HEIGHT = By.id("com.healbe.healbegobe.debug:id/height_value"),
            STEP_LENGTH = By.id("com.healbe.healbegobe.debug:id/step_length_value"),
            SLEEP_DURATION = By.id("com.healbe.healbegobe.debug:id/sleep_duration_value"),
            GLASS_VOLUME = By.id("com.healbe.healbegobe.debug:id/glass_volume_value"),
            COUNTRY = By.id("com.healbe.healbegobe.debug:id/country_value"),
            CITY = By.id("com.healbe.healbegobe.debug:id/city_value"),
            EMAIL = By.id("com.healbe.healbegobe.debug:id/email_value");

    private String // ??? тут надо придумать, как использовать единицы измерения правильно относительно локали
            units_height_and_length = "cm";

    public void assertProfileUpdate() {
        assertElementHasText(USERNAME, first_name + " " + last_name, "Unexpected username");
        assertElementHasText(SEX, sex, "Unexpected sex");
        assertElementHasText(DATE_OF_BIRTH, output_date_of_birth, "Unexpected date of birth");
        assertElementHasText(HEIGHT, height + " " + units_height_and_length, "Unexpected height");
        assertElementHasText(STEP_LENGTH, step_length + " " + units_height_and_length, "Unexpected step length");
        assertElementHasText(SLEEP_DURATION, sleep_duration, "Unexpected sleep duration");
        assertElementHasText(GLASS_VOLUME, glass_volume, "Unexpected glass volume");
        swipeUpToFindElement(COUNTRY, "Cannot find Country by swiping up", 5);
        assertElementHasText(COUNTRY, country, "Unexpected country");
        swipeUpToFindElement(CITY, "Cannot find City by swiping up", 5);
        assertElementHasText(CITY, city, "Unexpected city");
    }

}
