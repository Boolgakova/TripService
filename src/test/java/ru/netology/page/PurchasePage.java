package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PurchasePage {
    private SelenideElement cardNumberField = $("input[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("input[placeholder='08']");
    private SelenideElement yearField = $("input[placeholder='22']");
    private SelenideElement ownerField = $x("//*[text()='Владелец']/following-sibling::span/input");
    private SelenideElement cvvField = $("input[placeholder='999']");
    private SelenideElement continueButton = $x("//*[text()='Продолжить']");
    private SelenideElement notification = $(".notification__content");

    public void sendForm(DataHelper.CardInfo info){
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvvField.setValue(info.getCvv());
        continueButton.click();
    }

    public void getSuccessNotification(){
        notification
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Операция одобрена Банком."));
    }

    public void getError(){
        notification
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Ошибка! Банк отказал в проведении операции."));
    }
}
