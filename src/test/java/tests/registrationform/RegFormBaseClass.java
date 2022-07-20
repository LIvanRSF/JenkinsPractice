package tests.registrationform;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tests.registrationform.pages.RegistrationFormPage;

public class RegFormBaseClass {
    RegistrationFormPage formPage = new RegistrationFormPage();
    RegFormTestData testData;

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        System.out.println("Конфигурация теста установлена");
    }

    @BeforeEach
    public void beforEach() {
        testData = new RegFormTestData();
        formPage.openPage();
        System.out.println("Тестовые данные сгенерированы. Веб-страница открыта");
    }
}
