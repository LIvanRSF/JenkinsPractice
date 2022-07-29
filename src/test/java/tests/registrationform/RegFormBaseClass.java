package tests.registrationform;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.registrationform.attachments.Attach;
import tests.registrationform.pages.RegistrationFormPage;

public class RegFormBaseClass {
    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    RegistrationFormPage formPage = new RegistrationFormPage();
    RegFormTestData testData;

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;

        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "100");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        String remoteWebDriverUrl = System.getProperty("remoteDriverUrl", "selenoid.autotests.cloud/wd/hub");

        Configuration.remote =
            String.format("https://%s:%s@%s", config.login(), config.password(), remoteWebDriverUrl);
        System.out.println("Конфигурация теста установлена");
    }

    @BeforeEach
    public void beforEach() {
        testData = new RegFormTestData();
        formPage.openPage();
        System.out.println("Тестовые данные сгенерированы. Веб-страница открыта");
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
