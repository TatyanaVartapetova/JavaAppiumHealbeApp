package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class OnboardingPageObject extends MainPageObject {

    public OnboardingPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String

            NAVIGATE_NEXT_BUTTON = "//android.widget.Button",
            SIGN_IN_BUTTON_ENTER_FORM_SCREEN = "com.healbe.healbegobe.debug:id/sign_in", // я эту кнопку использую и в EnterPageObject, может как-то отдельно вынести или сделать ее паблик?
            ONBOARDING_TITLE_AND_TEXT_TPL = "//android.widget.TextView[@text='{ONBOARDING_TITLE_AND_TEXT}']";

    private String
            onboarding_page1_title = "",
            onboarding_page2_title = "",
            onboarding_page1_text = "",
            onboarding_page2_text = "",
            en_onboarding_page1_title = "Tune into your body",
            en_onboarding_page1_text = "Enhance nutrition and whole lifestyle\n" +
                    "\n" +
                    "Meet the only complete body Dashboard",
            en_onboarding_page2_title = "Find a perfect balance",
            en_onboarding_page2_text = "Direct insight into your personal lifestyle balance and habits",
            ru_onboarding_page1_title = "Настройтесь на своё тело", //при копировании через нотпад можн увидеть   и если их прописать, то работает
            ru_onboarding_page1_text = "Улучшайте питание и весь образ жизни, опираясь на точные данные",
            ru_onboarding_page2_title = "Найдите идеальный баланс",
            ru_onboarding_page2_text = "Обретите полное понимание того, как привычки влияют на вас";


    public void defineLocaleOnboarding(String locale) {
        if (locale == "en") {
            onboarding_page1_title = en_onboarding_page1_text;
            onboarding_page2_title = en_onboarding_page2_title;
            onboarding_page1_text = en_onboarding_page1_text;
            onboarding_page2_text = en_onboarding_page2_text;
        } else if (locale == "ru") {
            onboarding_page1_title = ru_onboarding_page1_title;
            onboarding_page2_title = ru_onboarding_page2_title;
            onboarding_page1_text = ru_onboarding_page1_text;
            onboarding_page2_text = ru_onboarding_page2_text;
        } else {
            System.out.println("Unknown locale");
        }
    }

    private static String getOnboardingPage1TitleXpath(String title_onboarding1) {
        return ONBOARDING_TITLE_AND_TEXT_TPL.replace("{ONBOARDING_TITLE_AND_TEXT}", title_onboarding1);
    }

    private static String getOnboardingPage2TitleXpath(String title_onboarding2) {
        return ONBOARDING_TITLE_AND_TEXT_TPL.replace("{ONBOARDING_TITLE_AND_TEXT}", title_onboarding2);
    }

    private static String getOnboardingPage1TextXpath(String description_onboarding1) {
        return ONBOARDING_TITLE_AND_TEXT_TPL.replace("{ONBOARDING_TITLE_AND_TEXT}", description_onboarding1);
    }

    private static String getOnboardingPage2TextXpath(String description_onboarding2) {
        return ONBOARDING_TITLE_AND_TEXT_TPL.replace("{ONBOARDING_TITLE_AND_TEXT}", description_onboarding2);
    }


    public void navigationNext() {
        waitForElementAndClick(By.xpath(NAVIGATE_NEXT_BUTTON), "cannot find Navigate next button", 15);
    }

    public void passOnboardingQuick() {
        // doubleTapToCenterOfElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View"), "Cannot find center of element gif  onboarding"); - почему-то если вначале ускорить процесс, то он не кликает по второй кнопке NEXT, оэтому убрала этот метод
        navigationNext();
        navigationNext();
        waitForElementPresent(By.id(SIGN_IN_BUTTON_ENTER_FORM_SCREEN), "Cannot find Sign in Button on EnterForm ", 15);
    }

    public void passOnboardingFull(String locale) {
        defineLocaleOnboarding(locale);
        waitForElementPresent(By.xpath(getOnboardingPage1TitleXpath(onboarding_page1_title)), "cannot find title onboarding 1", 15);
        waitForElementPresent(By.xpath(getOnboardingPage1TextXpath(onboarding_page1_text)), "cannot find description onboarding 1", 15);
        navigationNext();
        waitForElementPresent(By.xpath(getOnboardingPage2TitleXpath(onboarding_page2_title)), "cannot find title onboarding 2");
        waitForElementPresent(By.xpath(getOnboardingPage2TextXpath(onboarding_page2_text)), "cannot find description onboarding 2");
        navigationNext();
        waitForElementPresent(By.id(SIGN_IN_BUTTON_ENTER_FORM_SCREEN), "Cannot find Sign in Button on EnterForm ", 15);
    }


}

