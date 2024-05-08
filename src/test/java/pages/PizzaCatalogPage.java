package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import java.util.List;

public class PizzaCatalogPage extends BasePage {
    public PizzaCatalogPage() {
        super("product-category/menu/pizza/");
    }

    public SelenideElement orderBySelector = $(".orderby");
    public ElementsCollection pizzaNames = $$(".products.columns-4>li>div>a>h3");
    public SelenideElement sliderRange = $("div.ui-slider-range");
    public SelenideElement sliderThumbLeft = $(".price_slider_wrapper>div>span:nth-of-type(1)");
    public SelenideElement sliderThumbRight = $(".price_slider_wrapper>div>span:nth-of-type(2)");
    public SelenideElement filterSubmitButton = $(".price_slider_amount>button[type='submit']");
    public SelenideElement somePizzaToBasketButton = $("[aria-label*='Рай']");

    public void orderBy(String value){
        orderBySelector.selectOptionByValue(value);
    }
}
