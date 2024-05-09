package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.PizzaCatalogPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.actions;

public class PizzaCatalogTests extends TestBase{

    private static Stream<Arguments> orderParamData(){
        return Stream.of(
                Arguments.arguments("menu_order","Пицца «4 в 1»"),
                Arguments.arguments("popularity", "Пицца «Как у бабушки»"),
                Arguments.arguments("date","Пицца «4 в 1»"),
                Arguments.arguments("price","Пицца «4 в 1»"),
                Arguments.arguments("price-desc","Пицца «Рай»")
        );
    }

    @ParameterizedTest
    @MethodSource("orderParamData")
    public void pizzaPage_SortedByPriceAsc_Success(String value, String expectedText){
        //arrange
        new PizzaCatalogPage().open();

        //act
        new PizzaCatalogPage().orderBy(value);

        //assert
        new PizzaCatalogPage().pizzaNames.get(0).shouldHave(text(expectedText)).shouldBe(visible);
    }
    @Test
    public void pizzaPage_FilterByPrice_Success(){
        //arrange
        new PizzaCatalogPage().open();

        //act
        int sliderWidth = new PizzaCatalogPage().sliderRange.getSize().getWidth();
        actions()
            .dragAndDropBy(new PizzaCatalogPage().sliderThumbLeft, sliderWidth / 2, 0)
            .build()
            .perform();
        new PizzaCatalogPage().filterSubmitButton.click();

        //assert
        new PizzaCatalogPage().pizzaNames.get(0).shouldHave(text("Пицца «Как у бабушки»")).shouldBe(visible);
    }
    @Test
    public void pizzaPage_AddPizzaToBasket_Success(){
        //arrange
        new PizzaCatalogPage().open();

        //act
        new PizzaCatalogPage().somePizzaToBasketButton.click();

        //assert
        new PizzaCatalogPage().topPanel.basketIcon.shouldHave(text("[ 515,00₽ ]")).shouldBe(visible);
    }
}
