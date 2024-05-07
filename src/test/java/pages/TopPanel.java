package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TopPanel {
    public SelenideElement searchField = $(".search-field");
    public SelenideElement searchSubmitButton = $(".searchform > .searchsubmit");
    public SelenideElement basketIcon = $(".view-cart > a");

    public void search (String text){
        searchField.setValue(text);
        searchSubmitButton.click();
    }
}
