package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class EnterPage extends MainPageObject {
    public EnterPage(AppiumDriver driver) {
        super(driver);
    }

    private static final String
            ERROR_ICON_NOT_VALID_INPUT = "com.healbe.healbegobe.debug:id/text_input_error_icon",
            ERROR_MESSAGE_NOT_VALID_INPUT = "com.healbe.healbegobe.debug:id/error_values";

    public void signIn(String login, String password) {
        waitForElementAndClick(By.id(URI.EMAIL_FIELD), "Cannot find email field", 5);
        waitForElementAndSendKeys(By.id(URI.EMAIL_FIELD), login, "Cannot find and type into email field", 5);
        waitForElementAndSendKeys(By.id(URI.PASSWORD_FIELD), password, "Cannot find and type into password field", 5);
        waitForElementAndClick(By.id(URI.SIGN_IN_BUTTON_SIGN_IN_SCREEN), "Cannot click on Sign In Button on Sign In", 5);
        waitForElementNotPresent(By.id(URI.EMAIL_FIELD), "email field still present after click on Sign In button", 15);
        waitForElementAndClick(MobileBy.AccessibilityId("Close"), "Cannot find X Button", 5);
    }

    public void signInAndAssertSignInSuccessful(String login, String password) {
        signIn(login, password);
       // while (driver.findElements(MobileBy.AccessibilityId("Close")).size() == 1) { ...} - если в этот цикл обернуть, то будет работать независимо от того показан ли квикстарт
        waitForElementAndClick(MobileBy.AccessibilityId("Close"), "Cannot find X Button", 5);// работает только в англ локали, по остальным селекторам не находит. В ру "Закрыть". Придется видимо переписывать под каждую локаль
        waitForElementAndClick(By.id("com.healbe.healbegobe.debug:id/profile"), "Cannot find Profile in BottomNavBar", 5);
        swipeUpToFindElement(By.id(URI.EMAIL_VALUE_PROFILE_SCREEN), "Cannot Find email value on Profile", 20);
        assertElementHasText(By.id(URI.EMAIL_VALUE_PROFILE_SCREEN), login, "login in Profile not equal to " + login);
        waitForElementAndClick(By.id("com.healbe.healbegobe.debug:id/dashboard"), "Cannot find dashboard button in bottomNavBar", 5);
    }

    public  void signInWrongPassword(){
        signIn("v60@v.co", "1111");
        waitForElementPresent(By.id(ERROR_MESSAGE_NOT_VALID_INPUT), "Cannot find error message");
        assertElementHasText(By.id(ERROR_MESSAGE_NOT_VALID_INPUT),"неверный логин или пароль", "Error message incorrect" );//почему-то с большой буквы не работает, хотя по факту там большая
        assertElementPresent(By.id(URI.EMAIL_FIELD), "Email field not present after input wrong password");

    }
    public  void signInEmailNotValid(){
       // waitForElementAndClick(By.id(SIGN_IN_BUTTON_ENTER_FORM_SCREEN), "Cannot click on Sign In Button on Enter Form", 5);
        waitForElementAndClick(By.id(URI.EMAIL_FIELD), "Cannot find email field", 5);
        waitForElementAndSendKeys(By.id(URI.EMAIL_FIELD), "v60@v.", "Cannot find and type into email field", 5);
        waitForElementAndClick(By.id(URI.PASSWORD_FIELD), "Cannot click to password fields", 5);
        waitForElementPresent(By.id(ERROR_ICON_NOT_VALID_INPUT), "Cannot find error icon");
        //assertElementHasText(By.id(ERROR_MESSAGE_NOT_VALID_INPUT),"некорректный формат поля email", "Error message incorrect" );//почему-то не находит по id
        assertElementPresent(By.id(URI.EMAIL_FIELD), "Email field not present after input wrong password");
        assertButtonIsNotEnable(By.id(URI.SIGN_IN_BUTTON_SIGN_IN_SCREEN), "bla", 5);
        //  String enable_attribute_for_sign_in_button = this.waitForElementAndGetAttribute(By.id("com.healbe.healbegobe.debug:id/button"), "enabled", "Cannot find attribute Enable for Sign in Button", 5); // assert button not clickable element.isEnabled()

    }

    public void clearEmailAndPasswordFields(){
        waitForElementAndClear(By.id(URI.EMAIL_FIELD), "Cannot clear email field", 5);
        waitForElementAndClear(By.id(URI.PASSWORD_FIELD), "Cannot clear password field", 5);
    }
    public void signInFromEnterForm(){
        waitForElementAndClick(By.id(URI.SIGN_IN_BUTTON_ENTER_FORM_SCREEN), "Cannot click on Sign In Button on Enter Form", 5);
    }

    public void quickSignIn(String login, String password){
        OnboardingPage OnboardingPageObject = new OnboardingPage(driver);
        OnboardingPageObject.passOnboardingQuick();
        signInFromEnterForm();
        signIn(login, password);
    }
}
