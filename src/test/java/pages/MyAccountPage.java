package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MyAccountPage extends BasePage {
    public MyAccountPage() {
        super("my-account/");
    }

    public SelenideElement userNameInput = $("#username");
    public SelenideElement passwordInput = $("#password");
    public SelenideElement submitButton = $("[name='login']");
    public SelenideElement accountInfoSection = $(withText("Данные аккаунта"));
    public SelenideElement uploadFileInput = $("#uploadFile");
    public SelenideElement uploadPreview = $("#uploadPreview");

    public void authorization(){
        open();
        userNameInput.setValue("test_user1968");
        passwordInput.setValue("dLk2TcEhUf9wxBe");
        submitButton.click();
    }
}

