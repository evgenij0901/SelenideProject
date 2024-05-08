package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class OrderPage extends BasePage {
    public OrderPage() {
        super("checkout/");
    }

    public SelenideElement firstNameInput = $("#billing_first_name");
    public SelenideElement lastNameInput = $("#billing_last_name");
    public SelenideElement countrySelector = $("#select2-billing_country-container");
    public SelenideElement addressInput = $("#billing_address_1");
    public SelenideElement cityInput = $("#billing_city");
    public SelenideElement stateInput = $("#billing_state");
    public SelenideElement postCodeInput = $("#billing_postcode");
    public SelenideElement phoneNumberInput = $("#billing_phone");
    public SelenideElement emailInput = $("#billing_email");
    public SelenideElement orderCommentsInput = $("#order_comments");
    public SelenideElement submitOrderButton = $("#place_order");
    public SelenideElement infoElement = $(".woocommerce-notice--success");
    public SelenideElement errorInfo = $(".woocommerce-error > li");
    public SelenideElement payToTakeButton = $("#payment_method_cod");
    public SelenideElement paymentMethodInfo = $(".woocommerce-order-overview__payment-method");
    public SelenideElement agreeTermsCheckbox = $("#terms");
    public SelenideElement blockElement = $(".blockUI.blockOverlay");
    public SelenideElement orderDateSelector = $("#order_date");

    public void clearInputs(){
        firstNameInput.clear();
        lastNameInput.clear();
        addressInput.clear();
        cityInput.clear();
        stateInput.clear();
        postCodeInput.clear();
        phoneNumberInput.clear();
        emailInput.clear();
    }

    public void fillAllRequiredInput(){
        clearInputs();
        firstNameInput.setValue("Евгений");
        lastNameInput.setValue("Столяров");
        addressInput.setValue("Монетная 20");
        cityInput.setValue("Санкт-Петербург");
        stateInput.setValue("Ленинградская");
        postCodeInput.setValue("210000");
        phoneNumberInput.setValue("+79345764555");
        emailInput.setValue("test@mail.ru");
        orderCommentsInput.setValue("побыстрее");
    }

    public String getOrderDate(){
        return executeJavaScript("return document.querySelectorAll('#order_date')[0].value").toString();
    }

    public void setOrderDate(String date){
        executeJavaScript("document.querySelectorAll('#order_date')[0].value = arguments[0]", date);
    }
}

