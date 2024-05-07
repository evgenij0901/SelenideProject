package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class HeaderPanel {
    public SelenideElement mainButton = $("#menu-primary-menu").$(withText("Главная"));
    public SelenideElement menuButton = $("#menu-primary-menu").$(withText("Меню"));
    public SelenideElement menuPizzaButton = $("#menu-primary-menu").$(withText("Пицца"));
    public SelenideElement menuDessertButton = $("#menu-primary-menu").$(withText("Десерты"));
    public SelenideElement menuDrinksButton = $("#menu-primary-menu").$(withText("Напитки"));
    public SelenideElement deliverAndPayButton = $("#menu-primary-menu").$(withText("Доставка и оплата"));
    public SelenideElement saleButton = $("#menu-primary-menu").$(withText("Акции"));
    public SelenideElement aboutUsButton = $("#menu-primary-menu").$(withText("О нас"));
    public SelenideElement myBasketButton = $("#menu-primary-menu").$(withText("Корзина"));
    public SelenideElement myAccountButton = $("#menu-primary-menu").$(withText("Мой аккаунт"));
    public SelenideElement placingAnOrderButton = $("#menu-primary-menu").$(withText("Оформление заказа"));
    public SelenideElement bonusProgramButton = $("#menu-primary-menu").$(withText("Бонусная программа"));

    public void goToSubMenu(SelenideElement element) {
        menuButton.hover();
        element.shouldBe(visible).click();
    }

}
