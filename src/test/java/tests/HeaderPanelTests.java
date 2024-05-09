package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;
import com.codeborne.selenide.Selenide;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class HeaderPanelTests extends TestBase{
    @Test
    public void mainPage_ClickOnMenuButton_MenuPageOpened(){
        //arrange
        new MainPage().open();

        //act
        new MainPage().headerPanel.menuButton.click();

        //assert
        new MainPage().headerPanel.menuButton.shouldBe(Condition.visible);
        new MainPage().titleElement.shouldHave(text("МЕНЮ"));
    }
    private static Stream<Arguments> mainPageSubMenuData(){
        return Stream.of(
                Arguments.arguments("//*[@id='menu-primary-menu']/li[2]/ul/li/a[text()='Пицца']","ПИЦЦА"),
                Arguments.arguments("//*[@id='menu-primary-menu']/li[2]/ul/li/a[text()='Десерты']", "ДЕСЕРТЫ"),
                Arguments.arguments("//*[@id='menu-primary-menu']/li[2]/ul/li/a[text()='Напитки']","НАПИТКИ")
        );
    }
    private static Stream<Arguments> mainPageHeaderMenuData(){
        return Stream.of(
                Arguments.arguments("//*[@id='menu-primary-menu']/li/a[text()='Доставка и оплата']","ДОСТАВКА И ОПЛАТА"),
                Arguments.arguments("//*[@id='menu-primary-menu']/li/a[text()='Акции']", "АКЦИИ"),
                Arguments.arguments("//*[@id='menu-primary-menu']/li/a[text()='О нас']","О НАС"),
                Arguments.arguments("//*[@id='menu-primary-menu']/li/a[text()='Корзина']","КОРЗИНА"),
                Arguments.arguments("//*[@id='menu-primary-menu']/li/a[text()='Мой аккаунт']", "МОЙ АККАУНТ"),
                Arguments.arguments("//*[@id='menu-primary-menu']/li/a[text()='Бонусная программа']","БОНУСНАЯ ПРОГРАММА")
        );
    }
    @ParameterizedTest
    @MethodSource("mainPageSubMenuData")
    public void mainPage_goToSubMenuElement_TitleIsDisplayed(String elementId, String expectedText){
        //arrange
        new MainPage().open();

        //act
        new MainPage().headerPanel.goToSubMenu(Selenide.$x(elementId));

        //assert
        new MainPage().titleElement.shouldHave(text(expectedText)).shouldBe(visible);
    }
    @ParameterizedTest
    @MethodSource("mainPageHeaderMenuData")
    public void mainPage_goToHeaderMenuElement_SubTitleIsDisplayed(String elementId, String expectedText){
        //arrange
        new MainPage().open();

        //act
        Selenide.$x(elementId).click();

        //assert
        new MainPage().subTitleElement.shouldHave(text(expectedText)).shouldBe(visible);
    }
}
