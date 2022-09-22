package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.StartPage;

import static com.codeborne.selenide.Selenide.open;

public class PurchaseTest {

    @Test
    void shouldSuccessPurchase(){
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTour();
        var cardInfo = DataHelper.getAcceptedUser();
        purchasePage.sendForm(cardInfo);
        purchasePage.getSuccessNotification();
    }
}
