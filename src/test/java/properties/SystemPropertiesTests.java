package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

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
    @Tag("hello")
    void someTest2() {
        System.out.println("Hello " + System.getProperty("anyText"));
    }
}
