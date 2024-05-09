package pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class BonusProgramPage extends BasePage{
    public BonusProgramPage() {
        super("bonus/");
    }

    public SelenideElement nameInput = $("#bonus_username");
    public SelenideElement phoneNumberInput = $("#bonus_phone");
    public SelenideElement submitButton = $(withText("Оформить карту"));
    public SelenideElement bonusInfo = $(".content-page>#bonus_main>h3");
    public SelenideElement bonusValidationInfo = $("#bonus_main>#bonus_content");
    public ElementsCollection loaderLocators = $$(".loaderPoint");

    public String acceptAlert(){
        return confirm();
    }

    public void waitForLoaderEnds(){
        loaderLocators.shouldHave(size(4));
    }
}
