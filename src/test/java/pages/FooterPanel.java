package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FooterPanel {
    public SelenideElement footerSaleButton = $("#pages-2").$(withText("Акции"));
    public SelenideElement footerBonusProgramButton = $("#pages-2").$(withText("Бонусная программа"));
    public SelenideElement footerAllProductsButton = $("#pages-2").$(withText("Все товары"));
    public SelenideElement footerMainButton = $("#pages-2").$(withText("Главная"));
    public SelenideElement footerDeliveryAndPayButton = $("#pages-2").$(withText("Доставка и оплата"));
    public SelenideElement footerMyBasketButton = $("#pages-2").$(withText("Корзина"));
    public SelenideElement footerMyAccountButton = $("#pages-2").$(withText("Мой аккаунт"));
    public SelenideElement footerAboutUsButton = $("#pages-2").$(withText("О нас"));
    public SelenideElement footerPlacingAnOrderButton = $("#pages-2").$(withText("Оформление заказа"));
    public SelenideElement footerRegisterButton = $("#pages-2").$(withText("Регистрация"));
    public ElementsCollection footerLinks = $$(".cta-desc_simple>p>a");
}
