package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.MainPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.actions;

public class MainPageTests extends TestBase{
    @Test
    public void mainPage_SwitchLeftPizzaSlider_Success(){
        //arrange
        new MainPage().open();

        //act
        actions().moveToElement(new MainPage().leftSliderButton).perform();
        new MainPage().leftSliderButton.click();

        //assert
        new MainPage().pizzaCards.get(4).shouldBe(visible);
    }

    @Test
    public void mainPage_SwitchRightPizzaSlider_Success(){
        //arrange
        new MainPage().open();

        //act
        actions().moveToElement(new MainPage().leftSliderButton).perform();
        new MainPage().leftSliderButton.click();

        //assert
        new MainPage().pizzaCards.get(4).shouldBe(visible);
    }

    @Test
    public void mainPage_NavigatePointerOnSomeDrinkImage_InBasketButtonIsDisplayed(){
        //arrange
        new MainPage().open();

        //act
        actions().moveToElement(new MainPage().drinkCards.get(1)).perform();

        //assert
        new MainPage().inBasketDrinkButtons.get(1).shouldBe(visible);
    }

    @Test
    public void mainPage_ClickOnDessertCard_CardOpened(){
        //arrange
        new MainPage().open();

        //act
        actions().click(new MainPage().desertsCards.get(0)).perform();

        //assert
        new MainPage().cardCurrentTitle.shouldHave(text("Десерт «Булочка С Корицей»")).shouldBe(visible);
    }

    @Test
    public void mainPage_ScrollToEndPage_UpArrowElementIsDisplayed(){
        //arrange
        new MainPage().open();

        //act
        for(int i = 0; i < 200; i++){
            new MainPage().page.sendKeys(Keys.ARROW_DOWN);
        }

        //assert
        new MainPage().upArrowElement.shouldHave(attribute("style", "right: 20px;"));
    }

}
