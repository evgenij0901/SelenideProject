package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MyAccountPage;

import static com.codeborne.selenide.Condition.visible;

public class MyAccountTests extends TestBase{
    @Test
    public void myAccountPage_UploadFile_Success(){
        //arrange
        new MyAccountPage().open();
        new MyAccountPage().authorization();

        //act
        String filePath = "/Users/evgenijstolarov/Documents/JavaProjects/SelenideProject/src/test/resources";
        new MyAccountPage().accountInfoSection.click();
        new MyAccountPage().uploadFileInput.sendKeys(filePath);

        //assert
        new MyAccountPage().uploadPreview.shouldBe(visible);
    }
}
