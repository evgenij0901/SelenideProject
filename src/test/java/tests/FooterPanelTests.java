package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.BasePage;
import pages.MainPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class FooterPanelTests extends TestBase{
    private static Stream<Arguments> footerMenuData(){
        return Stream.of(
                Arguments.arguments("//*[@id='pages-2']/ul/li/a[text()='Акции']","АКЦИИ"),
                Arguments.arguments("//*[@id='pages-2']/ul/li/a[text()='Бонусная программа']", "БОНУСНАЯ ПРОГРАММА"),
                Arguments.arguments("//*[@id='pages-2']/ul/li/a[text()='Все товары']","ВСЕ ТОВАРЫ"),
                Arguments.arguments("//*[@id='pages-2']/ul/li/a[text()='Доставка и оплата']","ДОСТАВКА И ОПЛАТА"),
                Arguments.arguments("//*[@id='pages-2']/ul/li/a[text()='Корзина']", "КОРЗИНА"),
                Arguments.arguments("//*[@id='pages-2']/ul/li/a[text()='Мой аккаунт']","МОЙ АККАУНТ"),
                Arguments.arguments("//*[@id='pages-2']/ul/li/a[text()='О нас']","О НАС"),
                Arguments.arguments("//*[@id='pages-2']/ul/li/a[text()='Регистрация']","РЕГИСТРАЦИЯ")
        );
    }
    private static Stream<Arguments> footerLinkData(){
        return Stream.of(
                Arguments.arguments(1,"https://www.facebook.com/skillboxru"),
                Arguments.arguments(2,"https://vk.com/skillbox"),
                Arguments.arguments(3,"https://www.instagram.com/skillbox.ru/")
        );
    }
    @ParameterizedTest
    @MethodSource("footerMenuData")
    public void mainPage_GoToFooterMenuElement_SubTitleIsDisplayed(String elementId, String expectedText){
        //arrange
        new MainPage().open();

        //act
        Selenide.$x(elementId).click();

        //assert
        new BasePage().subTitleElement.shouldHave(text(expectedText)).shouldBe(visible);
    }
    @ParameterizedTest
    @MethodSource("footerLinkData")
    public void mainPage_ClickOnFooterLink_NewWindowOpened(int index, String expectedUrl){
        //arrange
        new MainPage().open();

        //act
        new MainPage().footerPanel.footerLinks.get(index).click();
        Selenide.switchTo().window(1);

        //assert
        Assertions.assertEquals(expectedUrl, WebDriverRunner.url(), "Некорректный адрес");
    }

}
