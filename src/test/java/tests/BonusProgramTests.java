package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.BonusProgramPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BonusProgramTests extends TestBase{
    private static Stream<Arguments> bonusPage_fillForm_SuccessInfoIsDisplayed_testsData(){
        return Stream.of(
                Arguments.arguments("Евгений", "89345762083"),
                Arguments.arguments("Evgenij", "+79345762083")
        );
    }
    private static Stream<Arguments> bonusPage_SetEmptyInput_Data(){
        return Stream.of(
                Arguments.arguments("#bonus_username", "Поле \"Имя\" обязательно для заполнения"),
                Arguments.arguments("#bonus_phone", "Поле \"Телефон\" обязательно для заполнения")
        );
    }
    @ParameterizedTest
    @MethodSource("bonusPage_fillForm_SuccessInfoIsDisplayed_testsData")
    public void bonusPage_fillForm_SuccessInfoIsDisplayed(String name, String phoneNumber) {
        //arrange
        BonusProgramPage page = new BonusProgramPage();
        page.open();

        //act
        page.nameInput.sendKeys(name);
        page.phoneNumberInput.sendKeys(phoneNumber);
        page.submitButton.click();
        page.acceptAlert();

        //assert
        page.bonusInfo.shouldHave(text("Ваша карта оформлена!")).shouldBe(visible);
    }
    @Test
    public void bonusPage_SetCorrectData_AlertTextIsDisplayed(){
        //arrange
        new BonusProgramPage().open();

        //act
        new BonusProgramPage().nameInput.sendKeys("Имя");
        new BonusProgramPage().phoneNumberInput.sendKeys("+78110967744");
        new BonusProgramPage().submitButton.click();

        //assert
        Assertions.assertEquals("Заявка отправлена, дождитесь, пожалуйста, оформления карты!",
                new BonusProgramPage().acceptAlert());
    }
    @ParameterizedTest
    @MethodSource("bonusPage_SetEmptyInput_Data")
    public void bonusPage_SetEmptyInput_ValidationInfoIsDisplayed(String locator, String expectedText){
        //arrange
        new BonusProgramPage().open();

        //act
        new BonusProgramPage().nameInput.sendKeys("Имя");
        new BonusProgramPage().phoneNumberInput.sendKeys("89345762083");
        Selenide.$(locator).clear();
        new BonusProgramPage().submitButton.click();

        //assert
        new BonusProgramPage().bonusValidationInfo.shouldHave(text(expectedText)).shouldBe(visible);
    }
    @Test
    public void bonusPage_EnterIncorrectPhoneNumberInField_ValidationInfoIsDisplayed(){
        //arrange
        new BonusProgramPage().open();

        //act
        new BonusProgramPage().phoneNumberInput.sendKeys("333");
        new BonusProgramPage().nameInput.sendKeys("Евгений");
        new BonusProgramPage().submitButton.click();

        //assert
        new BonusProgramPage().bonusValidationInfo.shouldHave(text("Введен неверный формат телефона")).shouldBe(visible);
    }

}
