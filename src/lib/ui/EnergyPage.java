package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class EnergyPage extends MainPageObject{
    public EnergyPage(AppiumDriver driver) {
        super(driver);
    }

    public void openEnergyScreenWithData(){ // это временный вариант пока нет профиля с данными от Антона
        waitForElementAndClick(DashboardPage.ENERGY_BALANCE_CELL_DASHBOARD, "bla", 5);
        waitForElementAndClick(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View"), "bla1",5);
        waitForElementAndClick(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View"), "bla2",5);
        //swipeLeft(); // не работают свайпы на эмуляторе (руками совсем, авто - плохо)
        waitForElementPresent(By.xpath("//android.widget.TextView[@text=\"Balance\"]"), "Cannot find Energy balance cell", 40);
        assertElementHasText(By.xpath("//android.widget.TextView[@text=\"-376\"]"), "-376", "Cannot find value of balance"); //понятно, что этот xpath супер тупо, но другого нет
        swipeUpToFindElement(By.xpath("(//android.widget.TextView[@text=\"Intake\"])[2]"), "Cannot find Intake cell", 10);
        assertElementHasText(By.xpath("//android.widget.TextView[@text=\"+1,043 kcal\"]"), "+1,043 kcal", "Cannot find value of intake");
        swipeUpToFindElement(By.xpath("//android.widget.TextView[@text=\"Burned\"]"), "Cannot find Burned cell", 10);
        assertElementHasText(By.xpath("//android.widget.TextView[@text=\"-1,419 kcal\"]"), "-1,419 kcal", "Cannot find value of burned");

    }


}
