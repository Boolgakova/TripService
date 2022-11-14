package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.*;

public class PurchaseTest {

    @BeforeEach
    void tearDown() {
        cleanDatabase();
    }

    @Test
    void shouldSuccessPurchase() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTour();
        var cardInfo = DataHelper.getAcceptedUser();
        purchasePage.sendForm(cardInfo);
        purchasePage.getSuccessNotification();
    }

    @Test
    void shouldDecline() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTour();
        var cardInfo = DataHelper.getDeclinedUser();
        purchasePage.sendForm(cardInfo);
        purchasePage.getError();
    }

    @Test
    void shouldDeclineWrongCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTour();
        var cardInfo = DataHelper.getUserWithWrongCardNumber();
        purchasePage.sendForm(cardInfo);
        purchasePage.getError();
    }

    @Test
    void shouldNotSendFormWithWrongMonth() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTour();
        var cardInfo = DataHelper.getUserWithWrongMonth();
        purchasePage.sendForm(cardInfo);
        purchasePage.getNotificationWrongValidityPeriod();
    }

    @Test
    void shouldNotSendFormWithWrongYear() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTour();
        var cardInfo = DataHelper.getUserWithWrongYear();
        purchasePage.sendForm(cardInfo);
        purchasePage.getNotificationWrongValidityPeriodInPast();
    }

    @Test
    void shouldNotSendFormWithWrongYearInFuture() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTour();
        var cardInfo = DataHelper.getUserWithWrongYearInFuture();
        purchasePage.sendForm(cardInfo);
        purchasePage.getNotificationWrongValidityPeriod();
    }

    @Test
    void shouldNotSendFormWithWrongName() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTour();
        var cardInfo = DataHelper.getUserWithCyrillicName();
        purchasePage.sendForm(cardInfo);
        purchasePage.getNotificationWrongName();
    }

    @Test
    void shouldSuccessPurchaseAndSaveToBase() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTour();
        var cardInfo = DataHelper.getAcceptedUser();
        purchasePage.sendForm(cardInfo);
        String expected = getOrderID();
        String actual = getTransactionID();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSuccessPurchaseAndSaveToBaseApprovedStatus() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var purchasePage = startPage.getTour();
        var cardInfo = DataHelper.getAcceptedUser();
        purchasePage.sendForm(cardInfo);

        String expected = "APPROVED";
        String actual = getStatus();

        Assertions.assertEquals(expected, actual);
    }
}
