package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class EnterPageObject extends MainPageObject{
    public EnterPageObject(AppiumDriver driver){
        super(driver);
    }

    public void signIn(String login, String password) {
        this.waitForElementAndClick(By.id("com.healbe.healbegobe.debug:id/sign_in"), "Cannot click on Sign In Button on Enter Form", 5);
        this.waitForElementAndClick(By.id("com.healbe.healbegobe.debug:id/email"), "Cannot find email field", 5);
        this.waitForElementAndSendKeys(By.id("com.healbe.healbegobe.debug:id/email"), login, "Cannot find and type into email field", 5);
        this.waitForElementAndSendKeys(By.id("com.healbe.healbegobe.debug:id/password"), password, "Cannot find and type into password field", 5);
        this.waitForElementAndClick(By.id("com.healbe.healbegobe.debug:id/button"), "Cannot click on Sign In Button on Sign In", 5);
        this.waitForElementNotPresent(By.id("com.healbe.healbegobe.debug:id/email"), "email field still present after click on Sign In button", 15);
    }
     public void signInAndAssertSignInSuccessful(String login, String password) {
        this.signIn(login, password);
         while (driver.findElements(By.xpath("//android.widget.ImageButton[@content-desc=\"Close\"]")).size()==1){
             this.waitForElementAndClick(MobileBy.AccessibilityId("Close"), "Cannot find X Button", 5);
        }

         this.waitForElementAndClick(MobileBy.AccessibilityId("Profile"), "Cannot find Profile in BottomNavBar", 5);
         this.swipeUpToFindElement(By.id("com.healbe.healbegobe.debug:id/email_value"), "Cannot Find email value on Profile", 20);
         this.assertElementHasText(By.id("com.healbe.healbegobe.debug:id/email_value"), login, "login in Profile not equal to " + login);
     }


}
