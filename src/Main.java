import lib.CoreTestCase;
import lib.ui.EnterPageObject;
import lib.ui.OnboardingPageObject;
import org.junit.Test;

public class Main extends CoreTestCase {

    @Test
    public void testSignIn(){
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.passOnboardingQuick();
        EnterPageObject EnterPageObject = new EnterPageObject(driver);
        EnterPageObject.signInAndAssertSignInSuccessful("v60@v.co", "Heal");
    }
    @Test
    public void test(){
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.passOnboardingFull("ru");
    }

}