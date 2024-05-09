package tests;

import org.junit.jupiter.api.Test;
import pages.DeliveryPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class DeliveryPageTests extends TestBase{
    @Test
    public void deliveryPage_CheckDeliveryPriceOffer_Success(){
        //arrange
        new DeliveryPage().open();

        //act
        new DeliveryPage().switchToFrame(new DeliveryPage().iframe);

        //assert
        new DeliveryPage().minPriceDeliverySection.shouldHave(
                text("Минимальная сумма заказа 800 рублей.")).shouldBe(visible);
    }
}
