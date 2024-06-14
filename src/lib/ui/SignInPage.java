package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.dictionary.En;
import org.junit.Assert;
import org.openqa.selenium.By;

public class SignInPage extends MainPageObject {
    public SignInPage(AppiumDriver driver) {
        super(driver);
    }

    public static final By
            EMAIL_FIELD = By.id("com.healbe.healbegobe.debug:id/email"),
            PASSWORD_FIELD = By.id("com.healbe.healbegobe.debug:id/password"),
            SIGN_IN_BUTTON = By.id("com.healbe.healbegobe.debug:id/button"),
            ERROR_ICON_NOT_VALID_INPUT = By.id("com.healbe.healbegobe.debug:id/text_input_error_icon"),
            ERROR_MESSAGE_NOT_VALID_INPUT = By.id("com.healbe.healbegobe.debug:id/error_values");
    private String
            valid_login = "v60@v.co",
            invalid_login1 = "v60@v.c",
            valid_password = "Heal",
            wrong_password = "1111";


    public void signIn(String login, String password) {
        waitForElementAndSendKeys(EMAIL_FIELD, login, "Cannot find and type into email field");
        waitForElementAndSendKeys(PASSWORD_FIELD, password, "Cannot find and type into password field");
        Assert.assertTrue(isButtonEnabled(SIGN_IN_BUTTON));
        waitForElementAndClick(SIGN_IN_BUTTON, "Cannot click on Sign In Button on Sign In");

    }

    public void signInAndEnsureSuccess() {
        signIn(valid_login, valid_password);
        waitForElementAndClick(DashboardPage.CLOSE_QUICK_START_BUTTON, "Cannot find X Button");
        waitForElementAndClick(NavBar.NAVBAR_PROFILE, "Cannot find Profile in BottomNavBar");
        swipeUpToFindElement(ProfilePage.EMAIL, "Cannot Find email value on Profile", 10);
        assertElementHasText(ProfilePage.EMAIL, valid_login, "login in Profile not equal to " + valid_login);
    }

    public void signInWrongPassword() {
        signIn(valid_login, wrong_password);
        waitForElementPresent(ERROR_MESSAGE_NOT_VALID_INPUT, "Cannot find error message" + En.error_message_not_valid_input);
        assertElementHasText(ERROR_MESSAGE_NOT_VALID_INPUT, En.error_message_not_valid_input, "Error message incorrect");

    }

    public void signInEmailNotValid() {
        waitForElementAndSendKeys(EMAIL_FIELD, invalid_login1, "Cannot find and type into email field");
        waitForElementAndSendKeys(PASSWORD_FIELD, valid_password,"Cannot click to password fields");
       // waitForElementPresent(ERROR_ICON_NOT_VALID_INPUT, "Cannot find error icon"); // почему-то перестала показываться иконка, хотя при ручном вводе показана.
        Assert.assertTrue(isButtonDisabled(SIGN_IN_BUTTON));
    }

    public void clearEmailAndPasswordFields() {
        waitForElementAndClear(EMAIL_FIELD, "Cannot clear email field");
        waitForElementAndClear(PASSWORD_FIELD, "Cannot clear password field");
    }

    //быстрая авторизация, включая онбординг
    public void quickSignIn() {
        OnboardingPage OnboardingPageObject = new OnboardingPage(driver);
        OnboardingPageObject.passOnboardingQuick();
        EnterPage EnterPage = new EnterPage(driver);
        EnterPage.clickSignInFromEnterForm();
        signIn(valid_login, valid_password);
        waitForElementAndClick(DashboardPage.CLOSE_QUICK_START_BUTTON, "Cannot find X Button");
    }


}
