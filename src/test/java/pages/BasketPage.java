package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasketPage extends BasePage{
    public BasketPage() {
        super("cart/");
    }

    public SelenideElement countInput = $("[type='number']");
    public SelenideElement updateBasketButton = $("[name='update_cart']");
    public SelenideElement cardTotalPrice = $(".product-subtotal>span>bdi");
    public SelenideElement blockElement = $(".blockUI.blockOverlay");
    public SelenideElement checkOutButton = $("[class*=\"checkout-button\"]");
    public SelenideElement couponInput = $("[name='coupon_code']");
    public SelenideElement submitCouponButton = $("[name='apply_coupon']");
    public SelenideElement totalOrderPrice = $("[data-title='Сумма']>strong>span>bdi");
}
