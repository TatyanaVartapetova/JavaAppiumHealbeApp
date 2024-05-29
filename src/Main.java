import lib.CoreTestCase;
import lib.ui.EnterPageObject;
import lib.ui.OnboardingPageObject;
import org.junit.Test;

public class Main extends CoreTestCase {

    @Test
    public void testSignIn(){
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.passOnboarding();
        EnterPageObject EnterPageObject = new EnterPageObject(driver);
        EnterPageObject.signInAndAssertSignInSuccessful("v60@v.co", "Heal");
    }
}