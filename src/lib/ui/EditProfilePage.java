package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;


public class EditProfilePage extends MainPageObject {
    public EditProfilePage(AppiumDriver driver) {
        super(driver);
    }

    private static final By
            EDIT_PROFILE_BUTTON = By.id("com.healbe.healbegobe.debug:id/edit"),
            SAVE_PROFILE_BUTTON = By.id("com.healbe.healbegobe.debug:id/saveButton"),
            FIRST_NAME_FIELD = By.id("com.healbe.healbegobe.debug:id/et_name"),
            LAST_NAME_FIELD = By.id("com.healbe.healbegobe.debug:id/et_lastName"),
            SEX_FIELD = By.id("com.healbe.healbegobe.debug:id/sex"),
            DATE_OF_BIRTH_FIELD = By.id("com.healbe.healbegobe.debug:id/birth_date"),
            HEIGHT_FIELD = By.xpath("(//android.widget.EditText[contains(@resource-id, 'single_units_input')])[1]"), // по id не получается очистить поле, поэтому использую xpath
            STEP_FIELD = By.xpath("(//android.widget.EditText[contains(@resource-id, 'single_units_input')])[2]"), // по id не получается очистить поле, поэтому использую xpath
            SLEEP_DURATION_FIELD = By.id("com.healbe.healbegobe.debug:id/sleep_duration"),
            GLASS_VOLUME_FIELD = By.id("com.healbe.healbegobe.debug:id/glass_volume"),
            COUNTRY_FIELD = By.id("com.healbe.healbegobe.debug:id/country"),
            CITY_FIELD = By.id("com.healbe.healbegobe.debug:id/et_city"),
            CALENDAR_TEXT_INPUT_MODE_BUTTON = By.id("com.healbe.healbegobe.debug:id/mtrl_picker_header_toggle"),
            CALENDAR_CONFIRM_DATA_BUTTON = By.id("com.healbe.healbegobe.debug:id/confirm_button"),
            CALENDAR_DATE_OF_BIRTH_FIELD = By.className("android.widget.EditText"); // по id не получается очистить поле, поэтому использую class

    protected String
            first_name = "Ali",
            last_name = "Baba",
            sex = "Male", //"Female"
            date_of_birth = "11/11/1980",
            output_date_of_birth = "11/11/80", //workaround пока не разберусь с форматом даты
            height = "180",
            step_length = "70",
            glass_volume = "50 ml",
            sleep_duration = "4 h 0 min",
            country = "Afghanistan",
            city = "Kabul";


//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("11/11/1980");
//        String date_of_birth = formatter.format(date);


    //Этот метод меняет все возможные значения на экране Edit profile (кроме веса), и убеждается, что они изменились на экране Edit profile
    public void editProfile() {
        // переходим в редактирование профиля пользователя
        waitForElementAndClick(NavBar.NAVBAR_PROFILE, "Cannot find profile button in navBar");
        waitForElementAndClick(EDIT_PROFILE_BUTTON, "Cannot find edit profile button");
        //Имя: редактируем, убеждаемся, что введенное значение верное
        waitForElementClearAndSendKeys(FIRST_NAME_FIELD, first_name, "Cannot input first name");
        assertElementHasText(FIRST_NAME_FIELD, first_name, "First name is unexpected");
        //Фамилия: редактируем, убеждаемся, что введенное значение верное
        waitForElementClearAndSendKeys(LAST_NAME_FIELD, last_name, "Cannot input last name");
        assertElementHasText(LAST_NAME_FIELD, last_name, "Last name is unexpected");
        //Пол: выбираем в выпадающем списке, убеждаемся, что выбрано верное значение
        waitForElementAndClick(SEX_FIELD, "Cannot find Sex field");
        pickSexFromDropDown(sex);
        assertElementHasText(SEX_FIELD, sex, "Sex is unexpected");
        //Дата рождения: редактируем, сохраняем, убеждаемся, что значение верное
        waitForElementAndClick(DATE_OF_BIRTH_FIELD, "Cannot find date of birth field");
        waitForElementAndClick(CALENDAR_TEXT_INPUT_MODE_BUTTON, "Cannot find CALENDAR_TEXT_INPUT_MODE_BUTTON");
        waitForElementClearAndSendKeys(CALENDAR_DATE_OF_BIRTH_FIELD, date_of_birth, "Cannot input date of birth");
        waitForElementAndClick(CALENDAR_CONFIRM_DATA_BUTTON, "Cannot find Confirm button");
        assertElementHasText(DATE_OF_BIRTH_FIELD, output_date_of_birth, "Unexpected date od birth");
        //Рост: редактируем, убеждаемся, что введенное значение верное
        waitForElementClearAndSendKeys(HEIGHT_FIELD, height, "Cannot input height");
        assertElementHasText(HEIGHT_FIELD, height, "Unexpected height");
        //Длина шага: свайп, пока не найдем элемент, редактируем, убеждаемся, что введенное значение верное
        swipeUpToFindElement(STEP_FIELD, "Cannot find step field by swiping", 5);
        waitForElementClearAndSendKeys(STEP_FIELD, step_length, "");
        assertElementHasText(STEP_FIELD, step_length, "");
        //Длительность сна: свайп, пока не найдем элемент; выбираем из выпадающего списка верхнее значение (4 часа), убеждаемся что значение верное
        swipeUpToFindElement(SLEEP_DURATION_FIELD, "Cannot find sleep duration field by swiping", 10);
        waitForElementAndClick(SLEEP_DURATION_FIELD, "Cannot find sleep duration field");
        pickUpperValueFromDropDown();
        assertElementHasText(SLEEP_DURATION_FIELD, sleep_duration, "Text of search input is unexpected");
        //Объем стакана: свайп, пока не найдем элемент; выбираем из выпадающего списка верхнее значение (50мл), убеждаемся что значение верное
        swipeUpToFindElement(GLASS_VOLUME_FIELD, "Cannot find glass volume field by swiping", 5);
        waitForElementAndClick(GLASS_VOLUME_FIELD, "Cannot find glass volume field");
        pickUpperValueFromDropDown();//при таких координатах выберется 50ml
        assertElementHasText(GLASS_VOLUME_FIELD, glass_volume, "Text of search input is unexpected");
        //Страна:  свайп, пока не найдем элемент; выбираем из выпадающего списка верхнее значение (Афганистан), убеждаемся что значение верное
        swipeUpToFindElement(COUNTRY_FIELD, "Cannot find country field by swiping", 5);
        waitForElementAndClick(COUNTRY_FIELD, "Cannot find country field");
        pickUpperValueFromDropDown();//при таких координатах выберется Afghanistan
        assertElementHasText(COUNTRY_FIELD, country, "Text of search input is unexpected");
        //Город:  свайп, пока не найдем элемент; редактируем, убеждаемся, что введенное значение верное
        swipeUpToFindElement(CITY_FIELD, "Cannot find city field by swiping", 5);
        waitForElementClearAndSendKeys(CITY_FIELD, city, "Cannot input value to city field");
        assertElementHasText(CITY_FIELD, city, "Text of search input is unexpected");
        waitForElementAndClick(SAVE_PROFILE_BUTTON, "Cannot find save profile button");
    }

    //метод, который выбирает пол из выпадающего списка
    // workaround, так как выпадающий список типа AutoCompleteTextView не видно в инспекторе
    private void pickSexFromDropDown(String sex) {
        WebElement element = waitForElementPresent(SEX_FIELD, "Cannot find Sex field");
        Dimension size = element.getSize(); // размеры элемента
        int margin_x = 0;
        int margin_y = 0;
        switch (sex) {
            case "Male":
                margin_y = size.getHeight();
                break;
            case "Female":
                margin_y = size.getHeight() * 2;
                break;
            default:
                System.out.println("Invalid value. Please enter Female or Male.");
        }
        tapToPointWithMarginFromCenterOfElement(SEX_FIELD, margin_x, margin_y, "margin error");
    }

    //метод, который выбирает верхнее значение из выпадающего списка
    // workaround, так как выпадающий список типа AutoCompleteTextView не видно в инспекторе
    public void pickUpperValueFromDropDown() {
        Dimension size = driver.manage().window().getSize();
        int x = (int) (size.width * 0.5);
        int y = (int) (size.height * 0.1);
        tapToPoint(x, y);
    }
}
