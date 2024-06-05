package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class OnboardingPageObject extends MainPageObject{

    public OnboardingPageObject(AppiumDriver driver) {
        super(driver);
    }
    private static final String
    LOCALE = "en",
    NAVIGATE_NEXT_BUTTON = "//android.widget.Button",
    TITLE_ONBOARDING_1_TPL = "//android.widget.TextView[@text='{TITLE_ONBOARDING_1}']",
    DESCRIPTION_ONBOARDING_1_TPL = "//android.widget.TextView[@text='{DESCRIPTION_ONBOARDING_1}']",
    TITLE_ONBOARDING_2_TPL = "//android.widget.TextView[@text='{TITLE_ONBOARDING_2}']",
    DESCRIPTION_ONBOARDING_2_TPL = "//android.widget.TextView[@text='{DESCRIPTION_ONBOARDING_2}']";


    public static void defineLocaleOnboarding(String LOCALE){
        if (LOCALE =="en"){
            title_onboarding1 = en_title_onboarding1;
            title_onboarding2 = en_title_onboarding2;
            description_onboarding1 = en_description_onboarding1;
            description_onboarding2 = en_description_onboarding2;
        }
        else if (LOCALE =="ru"){
            title_onboarding1 = ru_title_onboarding1;
            title_onboarding2 = ru_title_onboarding2;
            description_onboarding1 = ru_description_onboarding1;
            description_onboarding2 = ru_description_onboarding2;
        }
        else {
            System.out.println("Unknown locale");
        }
    }

// private static String getArticleXpathByTitle(String article_title){
//        return ARTICLE_BY_TITLE_TPL.replace("{ARTICLE_TITLE}", article_title);
//    }

    // TITLE_ONBOARDING_1_TPL = "//android.widget.TextView[@text='{TITLE_ONBOARDING_1}']",
  private static String getTitleOnboarding1Xpath(String title_onboarding1){
        return TITLE_ONBOARDING_1_TPL.replace("{TITLE_ONBOARDING_1}", title_onboarding1);
   }
  private static String getTitleOnboarding2Xpath(String title_onboarding2){
        return TITLE_ONBOARDING_2_TPL.replace("{TITLE_ONBOARDING_2}", title_onboarding2);
    }
  private static String getDescriptionOnboarding1Xpath(String description_onboarding1){
        return DESCRIPTION_ONBOARDING_1_TPL.replace("{DESCRIPTION_ONBOARDING_1}", description_onboarding1);
    }
  private static String getDescriptionOnboarding2Xpath(String description_onboarding2){
        return DESCRIPTION_ONBOARDING_2_TPL.replace("{DESCRIPTION_ONBOARDING_2}", description_onboarding2);
    }

    public static String
    title_onboarding1= "title_onboarding1",
    title_onboarding2= "title_onboarding2",
    description_onboarding1= "description_onboarding1",
    description_onboarding2= "description_onboarding1",
    en_title_onboarding1 = "Tune into your body",
    en_description_onboarding1 = "Enhance nutrition and whole lifestyle\n" +
            "\n" +
            "Meet the only complete body Dashboard",
    en_title_onboarding2 = "Find a perfect balance",
    en_description_onboarding2 = "Direct insight into your personal lifestyle balance and habits",
    ru_title_onboarding1 = "Настройтесь на своё тело", //при копировании через нотпад можн увидеть нбсп и если их прописать то работает
    ru_description_onboarding1 = "Улучшайте питание и весь образ жизни, опираясь на точные данные",
    ru_title_onboarding2 = "Найдите идеальный баланс",
    ru_description_onboarding2 = "Обретите полное понимание того, как привычки влияют на вас";


    public void navigationNext(){
        this.waitForElementAndClick(By.xpath(NAVIGATE_NEXT_BUTTON), "cannot find Navigate next button", 20);
    }

    public void passOnboardingQuick(){ //дописать еще двойной тап
        navigationNext();
        navigationNext();
        this.waitForElementPresent(By.id("com.healbe.healbegobe.debug:id/sign_in"), "Cannot find Sign in Button on EnterForm ", 15);
    }

    public void passOnboardingFull(String LOCALE){
        this.defineLocaleOnboarding(LOCALE);
        String title_onboarding_1_xpath = getTitleOnboarding1Xpath(title_onboarding1);
        String title_onboarding_2_xpath = getTitleOnboarding1Xpath(title_onboarding2); // что тут происходит и почему тогда все работает???
        String description_onboarding_1_xpath = getTitleOnboarding1Xpath(description_onboarding1);
        String description_onboarding_2_xpath = getTitleOnboarding1Xpath(description_onboarding2);

        this.waitForElementPresent(By.xpath(title_onboarding_1_xpath), "cannot find title onboarding 1", 15);
        this.waitForElementPresent(By.xpath(description_onboarding_1_xpath), "cannot find description onboarding 1", 15);
        navigationNext();
        this.waitForElementPresent(By.xpath(title_onboarding_2_xpath), "cannot find title onboarding 2");
        this.waitForElementPresent(By.xpath(description_onboarding_2_xpath), "cannot find description onboarding 2");
        navigationNext();
        this.waitForElementPresent(By.id("com.healbe.healbegobe.debug:id/sign_in"), "Cannot find Sign in Button on EnterForm ", 15);
    }


}

