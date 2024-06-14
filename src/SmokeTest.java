import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;

public class SmokeTest extends CoreTestCase {

    @Test
    // проверяет онбординг полностью, в том числе соответствие строк (пока не закончен)
    public void testPassOnboardingFull() {
        OnboardingPage OnboardingPage = new OnboardingPage(driver);
        OnboardingPage.passOnboardingFull("ru");
    }

    @Test
    // проверяется успешная авторизация
    public void testSignInSuccessful() {
        OnboardingPage OnboardingPage = new OnboardingPage(driver);
        OnboardingPage.passOnboardingQuick();
        EnterPage EnterPage = new EnterPage(driver);
        EnterPage.clickSignInFromEnterForm();
        SignInPage SignInPage = new SignInPage(driver);
        SignInPage.signInAndEnsureSuccess();
    }

    @Test
    // проверяет, что авторизация невозможна при неправильном пароле и невалидном email (будут еще проверки)
    public void testSignInUnsuccessful() {
        OnboardingPage OnboardingPage = new OnboardingPage(driver);
        OnboardingPage.passOnboardingQuick();
        EnterPage EnterPage = new EnterPage(driver);
        EnterPage.clickSignInFromEnterForm();
        SignInPage SignInPage = new SignInPage(driver);
        SignInPage.signInWrongPassword();
        SignInPage.clearEmailAndPasswordFields();
        SignInPage.signInEmailNotValid();
    }

    @Test
    //обновляются все возможные значения (кроме веса) на экране Edit Profile, и проверяется, что значения сохранились на экране User Profile
    public void testEditProfileAndVerifyUpdates() {
        SignInPage SignInPage = new SignInPage(driver);
        SignInPage.quickSignIn();
        EditProfilePage EditProfilePage = new EditProfilePage(driver);
        EditProfilePage.editProfile();
        ProfilePage ProfilePage = new ProfilePage(driver);
        ProfilePage.assertProfileUpdate();
    }


    @Test
    // тест не готов, нужны синтетические данные
    public void testEnergy() {
        SignInPage SignInPage = new SignInPage(driver);
        SignInPage.quickSignIn();
        EnergyPage EnergyPage = new EnergyPage(driver);
        EnergyPage.openEnergyScreenWithData();
    }

    public void testSettings(){
        SignInPage SignInPage = new SignInPage(driver);
        SignInPage.quickSignIn();
        SettingsPage SettingsPage = new SettingsPage(driver);
        SettingsPage.editUnitsAndVerifySuccess();
    }
}