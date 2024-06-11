import lib.CoreTestCase;
import lib.ui.EnergyPage;
import lib.ui.EnterPage;
import lib.ui.OnboardingPage;
import lib.ui.ProfilePage;
import org.junit.Test;

public class Main extends CoreTestCase {

    @Test
    public void testPassOnboardingFull() {
        OnboardingPage OnboardingPage = new OnboardingPage(driver);
        OnboardingPage.passOnboardingFull("ru");
    }
    @Test
    public void testSignInSuccessful() {
        OnboardingPage OnboardingPage = new OnboardingPage(driver);
        OnboardingPage.passOnboardingQuick();
        EnterPage EnterPage = new EnterPage(driver);
        EnterPage.signInFromEnterForm();
        EnterPage.signInAndAssertSignInSuccessful("v60@v.co", "Heal");
    }
    @Test
    public void testSignInUnsuccessful() {
        OnboardingPage OnboardingPage = new OnboardingPage(driver);
        OnboardingPage.passOnboardingQuick();
        EnterPage EnterPage = new EnterPage(driver);
        EnterPage.signInFromEnterForm();
        EnterPage.signInWrongPassword();
        EnterPage.clearEmailAndPasswordFields();
        EnterPage.signInEmailNotValid();
    }

    @Test
    public void testEnergy(){
        EnterPage EnterPage = new EnterPage(driver);
        EnterPage.quickSignIn("v60@v.co", "Heal");
        EnergyPage EnergyPage = new EnergyPage(driver);
        EnergyPage.openEnergyScreenWithData();
    }
@Test
    public void testProfile(){
    ProfilePage ProfilePage = new ProfilePage(driver);
    ProfilePage.editProfile();
}
}