package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class DashboardPage extends MainPageObject{
    public DashboardPage(AppiumDriver driver) {
        super(driver);
    }

    public final static By
            CLOSE_QUICK_START_BUTTON = MobileBy.AccessibilityId("Close"), //только англ
            ENERGY_BALANCE_CELL_DASHBOARD = By.xpath("//android.widget.TextView[@text=\"Energy balance\"]");//только англ

}
