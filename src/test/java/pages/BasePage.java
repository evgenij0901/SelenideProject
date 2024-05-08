package pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    public HeaderPanel headerPanel;
    public FooterPanel footerPanel;
    public TopPanel topPanel;
    private String url = "http://pizzeria.skillbox.cc/";
    private String subUrl;

    public SelenideElement page = $("html");
    public SelenideElement titleElement = $(".entry-title.ak-container");
    public SelenideElement subTitleElement = $(".post-title");
    public SelenideElement currentTitleElement = $("span.current");
    public SelenideElement cardCurrentTitle = $(".woocommerce-breadcrumb.accesspress-breadcrumb > span");
    public SelenideElement upArrowElement = $("#ak-top");
    public SelenideElement loginButton = $(".account");

    public BasePage(String subUrl) {
        headerPanel = new HeaderPanel();
        footerPanel = new FooterPanel();
        topPanel = new TopPanel();
        this.subUrl = subUrl;
    }
    public BasePage(){
        this("");
    }

    public void open(){
        Selenide.open(getPageUrl());
    }

    public String getPageUrl(){
        return url + subUrl;
    }
}
