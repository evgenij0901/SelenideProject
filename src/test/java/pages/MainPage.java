package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.SetValueOptions.withDate;
import static com.codeborne.selenide.SetValueOptions.withText;

public class MainPage extends BasePage{
    public MainPage() {
        super();
    }

    public SelenideElement leftSliderButton = $(".slick-prev");
    public SelenideElement rightSliderButton = $(".slick-next");
    public ElementsCollection pizzaCards = $$("#accesspress_store_product-5 .slick-track>li");
    public ElementsCollection desertsCards = $$("#accesspress_store_product-6 .slick-track>li");
    public SelenideElement pepperoniPizzaCard = $x("//*[@data-slick-index=4]");
    public ElementsCollection drinkCards = $$("#accesspress_store_product-7 .slick-track>li");
    public ElementsCollection inBasketDrinkButtons = $$x("//*[@id='accesspress_store_product-7']//*[text()='В корзину']");
    public SelenideElement cappuccinoInBasketButton = $("[aria-label*=\"Капуччино\"]");
    public SelenideElement cinnamonBunCard = $("#accesspress_store_product-6 [data-slick-index=0]");

    public void addSomeDrinksInBasket(){
        open();
        actions().moveToElement(drinkCards.get(1)).perform();
        inBasketDrinkButtons.get(1).click();
    }
}
