package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage{
    public MainPage() {
        super();
    }

    public SelenideElement leftSliderButton = $(".slick-prev");
    public SelenideElement rightSliderButton = $(".slick-next");
    public SelenideElement pepperoniPizzaCard = $x("//*[@data-slick-index=4]");
    public SelenideElement cappuccinoCard = $("#accesspress_store_product-7 ul [data-slick-index=0]");
    public SelenideElement cappuccinoInBasketButton = $("[aria-label*=\"Капуччино\"]");
    public SelenideElement cinnamonBunCard = $("#accesspress_store_product-6 [data-slick-index=0]");

    public void addSomeDrinksInBasket(){
        open();
        actions().moveToElement(cappuccinoCard).perform();
        cappuccinoInBasketButton.click();
    }
}
