package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import com.codeborne.selenide.Configuration;


import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {

    @BeforeEach
    public void setUp(){
        Configuration.browserSize = "2880x1864";
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}
