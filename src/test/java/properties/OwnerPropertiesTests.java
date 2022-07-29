package properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class OwnerPropertiesTests {
    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    @Test
    @Tag("Test5")
    void someTest1() {
        String browserName = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "101");
        String browserSize = System.getProperty("browserSize", "1920x1080");

        System.out.println(browserName);
        System.out.println(version);
        System.out.println(browserSize);
    }

    @Test
    @Tag("owner")
    void ownerTest1() {
        String login = config.login();
        String password = config.password();

        System.out.printf("I logged as %s with password %s", login, password);
        System.out.println("");
    }

    @Test
    @Tag("hello")
    void someTest2() {
        System.out.println("Hello " + System.getProperty("anyText"));
    }
}
