import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FirstTests {
    @Test
    void amazon_SearchHarryPotter_Success() throws InterruptedException {
        //arrange
        open("https://www.amazon.com/");
        Thread.sleep(500);

        //act


        //assert
    }
}
