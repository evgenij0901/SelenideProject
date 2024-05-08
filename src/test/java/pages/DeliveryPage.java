package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class DeliveryPage extends BasePage{
    public DeliveryPage() {
        super("delivery/");
    }

    public SelenideElement minPriceDeliverySection = $("body>ul>li:nth-child(2)");
    public SelenideElement iframe = $("iframe");

    public void switchToFrame(SelenideElement frameElement){
        switchTo().frame(frameElement);
    }

    public void switchToMainPage(){
        switchTo().defaultContent();
    }
}
