package lib.ui;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class ProfilePage extends MainPageObject{
    public ProfilePage(AppiumDriver driver) {
        super(driver);
    }
    public static final String
    EDIT_PROFILE_BUTTON = "com.healbe.healbegobe.debug:id/edit",
    SAVE_PROFILE_BUTTON = "com.healbe.healbegobe.debug:id/saveButton",
    FIRST_NAME_FIELD = "com.healbe.healbegobe.debug:id/et_name",
    LAST_NAME_FIELD = "com.healbe.healbegobe.debug:id/et_lastName",
    SEX_FIELD = "com.healbe.healbegobe.debug:id/sex",
    DATE_OF_BIRTH_FIELD = "com.healbe.healbegobe.debug:id/birth_date",
   //ADD_WEIGHT_BUTTON = "com.healbe.healbegobe.debug:id/add_weight_butt", //невозможно добавить вес с экрана Profile, так как открывающийся экран Weight не виден в инспекторе
    HEIGHT_FIELD = "com.healbe.healbegobe.debug:id/height_layout",
    STEP_FIELD = "com.healbe.healbegobe.debug:id/step_layout",
    SLEEP_DURATION_FIELD = "com.healbe.healbegobe.debug:id/sleep_duration",
    GLASS_VOLUME_FIELD = "com.healbe.healbegobe.debug:id/glass_volume",
    COUNTRY_FIELD = "com.healbe.healbegobe.debug:id/country",
    CITY_FIELD = "com.healbe.healbegobe.debug:id/et_city",
    CALENDAR_TEXT_INPUT_MODE_BUTTON = "com.healbe.healbegobe.debug:id/mtrl_picker_header_toggle",
    CALENDAR_CONFIRM_DATA_BUTTON = "com.healbe.healbegobe.debug:id/confirm_button",
    CALENDAR_DATE_OF_BIRTH_FIELD = "com.healbe.healbegobe.debug:id/mtrl_picker_text_input_date",
    CALENDAR_MONTH_GRID = "com.healbe.healbegobe.debug:id/month_grid",
    CALENDAR_NEXT_MONTH_BUTTON = "com.healbe.healbegobe.debug:id/month_navigation_next";

private String
    first_name = "Adonis",
    last_name = "Xhaferaj",
    sex =  "Male", //"Female"
    // date_of_birth = "01/01/1980",дата не вводится, решила выбирать в календаре
    // weight = "80", невозможно добавить вес с экрана Profile, так как открывающийся экран Weight не виден в инспекторе
    height = "180",
    step_length = "70",
    country = "Albania",
    city = "Tirana";


public void editProfile(){
    waitForElementAndClick(By.id(URI.NAVBAR_PROFILE), "Cannot find profile button in navBar");
    waitForElementAndClick(By.id(EDIT_PROFILE_BUTTON), "Cannot find edit profile button");
    waitForElementAndClear(By.id(FIRST_NAME_FIELD), "Cannot clear first name field");
    waitForElementAndSendKeys(By.id(FIRST_NAME_FIELD), first_name, "Cannot input first name");
    waitForElementAndClear(By.id(LAST_NAME_FIELD), "Cannot clear last name field");
    waitForElementAndSendKeys(By.id(LAST_NAME_FIELD), last_name, "Cannot input last name");
    waitForElementAndClick(By.id(SEX_FIELD), "Cannot find Sex field");
    pickSexFromDropDown(sex);
    waitForElementAndClick(By.id(DATE_OF_BIRTH_FIELD), "Cannot find date of birth field");
    waitForElementAndClick(By.id(CALENDAR_NEXT_MONTH_BUTTON), "Cannot find CALENDAR_NEXT_MONTH_BUTTON");
    tapToCenterOfElement(By.id(CALENDAR_MONTH_GRID), "Cannot choose date in calendar");
    waitForElementAndClick(By.id(CALENDAR_CONFIRM_DATA_BUTTON), "Cannot find calendar confirm button");
   // waitForElementAndClick(By.id(ADD_WEIGHT_BUTTON), "bla");
   // System.out.println(driver.getPageSource()); // этот метод выводит XML документа в консоль

}

    private void pickSexFromDropDown(String sex){ //workaround method, так как выпадающий список типа AutoCompleteTextView не видно в инспекторе
        WebElement element = waitForElementPresent(By.id(SEX_FIELD), "Cannot find Sex field");
        Dimension size = element.getSize(); // размеры элемента
    int margin_x = 0;
    int margin_y = 0;
        switch (sex) {
        case "Male":
            margin_y = size.getHeight();
            break;
        case "Female":
            margin_y = size.getHeight()*2;
            break;
        default:
            System.out.println("Invalid value. Please enter Female or Male.");
        }
        tapToPointWithMarginFromCenterOfElement(By.id(SEX_FIELD), margin_x, margin_y, "margin error");
    }


}
