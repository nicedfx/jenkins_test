import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.AttachmentsHelper.*;

public class TestBase {

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.browserVersion= config.browserVersion();
        Configuration.browser = config.browser();
        Configuration.startMaximized = config.startMaximized();

        if (config.isRemote() == true) {
            Configuration.remote = config.selenoidUrl();
        }
    }

    @AfterEach
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
//        attachAsText("Browser console logs", getConsoleLogs());
//        getConsoleLogs(); There is an issue with fireFox console logs!
        attachVideo();
        closeWebDriver();
    }
}
