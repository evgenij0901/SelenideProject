package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class FooterPanel {
    SelenideElement footerSaleButton = $("#pages-2").$(withText("Акции"));
    SelenideElement footerBonusProgramButton = $("#pages-2").$(withText("Бонусная программа"));
    SelenideElement footerAllProductsButton = $("#pages-2").$(withText("Все товары"));
    SelenideElement footerMainButton = $("#pages-2").$(withText("Главная"));
    SelenideElement footerDeliveryAndPayButton = $("#pages-2").$(withText("Доставка и оплата"));
    SelenideElement footerMyBasketButton = $("#pages-2").$(withText("Корзина"));
    SelenideElement footerMyAccountButton = $("#pages-2").$(withText("Мой аккаунт"));
    SelenideElement footerAboutUsButton = $("#pages-2").$(withText("О нас"));
    SelenideElement footerPlacingAnOrderButton = $("#pages-2").$(withText("Оформление заказа"));
    SelenideElement footerRegisterButton = $("#pages-2").$(withText("Регистрация"));
    SelenideElement faceBookLink = $(".cta-desc_simple>p:nth-of-type(3)>a");
    SelenideElement vkLink = $(".cta-desc_simple>p:nth-of-type(4)>a");
    SelenideElement instagramLink = $(".cta-desc_simple>p:nth-of-type(5)>a");
}
