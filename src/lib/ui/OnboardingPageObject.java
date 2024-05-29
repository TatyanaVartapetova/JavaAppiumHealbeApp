package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class OnboardingPageObject extends MainPageObject{

    public OnboardingPageObject(AppiumDriver driver) {
        super(driver);
    }
    private static final String
    NAVIGATE_NEXT_BUTTON = "//android.widget.Button";
    public void navigationNext(){
        this.waitForElementAndClick(By.xpath(NAVIGATE_NEXT_BUTTON), "cannot find Navigate next button", 20);
    }

    public void passOnboarding(){
        navigationNext();
        navigationNext();
        this.waitForElementPresent(By.id("com.healbe.healbegobe.debug:id/sign_in"), "Cannot find Sign in Button on EnterForm ", 15);
    }
}
