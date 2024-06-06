import lib.CoreTestCase;
import lib.ui.EnergyPageObject;
import lib.ui.EnterPageObject;
import lib.ui.OnboardingPageObject;
import org.junit.Test;

public class Main extends CoreTestCase {

    @Test
    public void testPassOnboardingFull() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.passOnboardingFull("ru");
    }
    @Test
    public void testSignInSuccessful() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.passOnboardingQuick();
        EnterPageObject EnterPageObject = new EnterPageObject(driver);
        EnterPageObject.signInFromEnterForm();
        EnterPageObject.signInAndAssertSignInSuccessful("v60@v.co", "Heal");
    }
    @Test
    public void testSignInUnsuccessful() {
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.passOnboardingQuick();
        EnterPageObject EnterPageObject = new EnterPageObject(driver);
        EnterPageObject.signInFromEnterForm();
        EnterPageObject.signInWrongPassword();
        EnterPageObject.clearEmailAndPasswordFields();
        EnterPageObject.signInEmailNotValid();
    }

    @Test
    public void testEnergy(){
        OnboardingPageObject OnboardingPageObject = new OnboardingPageObject(driver);
        OnboardingPageObject.passOnboardingQuick();
        EnterPageObject EnterPageObject = new EnterPageObject(driver);
        EnterPageObject.signInFromEnterForm();
        EnterPageObject.signIn("v60@v.co", "Heal");
        EnergyPageObject EnergyPageObject = new EnergyPageObject(driver);
        EnergyPageObject.openEnergyScreenWithData();
    }
}