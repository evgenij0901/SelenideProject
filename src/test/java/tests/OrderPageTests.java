package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;
import pages.MyAccountPage;
import pages.OrderPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderPageTests extends TestBase{
    @BeforeAll
    public void setup(){
        new MyAccountPage().open();
        new MyAccountPage().authorization();
    }
    private static Stream<Arguments> paymentMethodData(){
        return Stream.of(
                Arguments.arguments("payment_method_cod", "Оплата при доставке"),
                Arguments.arguments("payment_method_bacs", "Прямой банковский перевод")
        );
    }
    private static Stream<Arguments> emptyRequiredInputData(){
        return Stream.of(
                Arguments.arguments("billing_first_name", "Имя для выставления счета обязательное поле"),
                Arguments.arguments("billing_last_name", "Фамилия для выставления счета обязательное поле"),
                Arguments.arguments("billing_address_1", "Адрес для выставления счета обязательное поле"),
                Arguments.arguments("billing_city", "Город / Населенный пункт для выставления счета обязательное поле"),
                Arguments.arguments("billing_state", "Область для выставления счета обязательное поле"),
                Arguments.arguments("billing_postcode", "Почтовый индекс для выставления счета обязательное поле"),
                Arguments.arguments("billing_phone", "Телефон для выставления счета обязательное поле"),
                Arguments.arguments("billing_email", "Адрес почты для выставления счета обязательное поле")
        );
    }
    @ParameterizedTest
    @MethodSource("paymentMethodData")
    public void orderPage_CorrectOrderingWithDifferentPaymentMethod_Success(String locator, String expectedText){
        //arrange
        new MainPage().addSomeDrinksInBasket();
        new OrderPage().open();

        //act
        new OrderPage().fillAllRequiredInput();
        Selenide.$(locator).click();
        new OrderPage().agreeTermsCheckbox.click();
        new OrderPage().submitOrderButton.click();

        //assert
        new OrderPage().paymentMethodInfo.shouldHave(text(expectedText)).shouldBe(visible);
    }
    @ParameterizedTest
    @MethodSource("emptyRequiredInputData")
    public void orderPage_EmptyRequiredInput_ErrorTextIsDisplayed(String locator, String expectedText){
        //arrange
        new MainPage().addSomeDrinksInBasket();
        new OrderPage().open();

        //act
        new OrderPage().fillAllRequiredInput();
        new OrderPage().agreeTermsCheckbox.click();
        Selenide.$(locator).clear();
        new OrderPage().submitOrderButton.click();

        //assert
        new OrderPage().errorInfo.shouldHave(text(expectedText)).shouldBe(visible);
    }
    @Test
    public void orderPage_NotAcceptTerm_ErrorTextIsDisplayed(){
        //arrange
        new MainPage().addSomeDrinksInBasket();
        new OrderPage().open();

        //act
        new OrderPage().fillAllRequiredInput();
        new OrderPage().submitOrderButton.click();

        //assert
        new OrderPage().errorInfo.shouldHave(text("Please read and accept the terms and conditions to proceed with your order."))
                .shouldBe(visible);
    }
    @Test
    public void orderPage_SetOrderDate_Success(){
        //arrange
        new MainPage().addSomeDrinksInBasket();
        new OrderPage().open();

        //act
        new OrderPage().setOrderDate("2024-04-06");

        //assert
        Assertions.assertEquals("2024-04-06", new OrderPage().getOrderDate(), "errorTextElementMessage");
    }
}
