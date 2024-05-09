package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.BasketPage;
import pages.MainPage;
import pages.MyAccountPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BasketPageTests extends TestBase {
    @Test
    void basketPage_UpCountProductToBasket_Success() {
        //arrange
        new MainPage().addSomeDrinksInBasket();
        new BasketPage().open();
        refresh();

        //act
        new BasketPage().countInput.click();
        new BasketPage().countInput.sendKeys(Keys.ARROW_UP);

        //assert
        new BasketPage().countInput.shouldHave(value("2"));
    }
    @Test
    void basketPage_DownCountProductToBasket_Success() {
        //arrange
        new MainPage().addSomeDrinksInBasket();
        new BasketPage().open();
        refresh();

        //act
        new BasketPage().countInput.click();
        new BasketPage().countInput.sendKeys(Keys.ARROW_DOWN);

        //assert
        new BasketPage().countInput.shouldHave(value("0"));
    }
    @Test
    public void basketPage_RefreshBasket_Success(){
        //arrange
        new MainPage().addSomeDrinksInBasket();
        new BasketPage().open();
        refresh();

        //act
        new BasketPage().countInput.sendKeys(Keys.ARROW_DOWN);
        new BasketPage().updateBasketButton.click();


        //assert
        new BasketPage().cardTotalPrice.shouldHave(text("300,00₽")).shouldBe(visible);
    }
    @Test
    public void basketPage_GoToPaymentPage_Success(){
        //arrange
        new MyAccountPage().authorization();
        new MainPage().addSomeDrinksInBasket();
        new BasketPage().open();
        refresh();

        //act
        new BasketPage().checkOutButton.click();

        //assert
        new BasketPage().currentTitleElement.shouldHave(text("Оформление Заказа")).shouldBe(visible);
    }
    @Test
    public void basketPage_ActivatePromoCode_Success(){
        //arrange
        String promoCode = "GIVEMEHALYAVA";
        new MainPage().addSomeDrinksInBasket();
        new BasketPage().open();
        refresh();

        //act
        new BasketPage().couponInput.setValue(promoCode);
        new BasketPage().submitCouponButton.click();

        //assert
        new BasketPage().totalOrderPrice.shouldHave(text("270,00₽"));
    }
}
