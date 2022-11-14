package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataHelper {

    private DataHelper(){
    }

    private static Faker faker = new Faker(new Locale("en"));
    private static Faker faker2 = new Faker(new Locale("ru"));

    @Value
    public static class CardInfo{
        String cardNumber;
        String month;
        String year;
        String owner;
        String cvv;
    }

    private static String getValidMonth(){
        List<String> months = new ArrayList<>();
        months.add("01");
        months.add("02");
        months.add("03");
        months.add("04");
        months.add("05");
        months.add("06");
        months.add("07");
        months.add("08");
        months.add("09");
        months.add("10");
        months.add("11");
        months.add("12");

        Random random = new Random();
        String month = months.get(random.nextInt(months.size()));
        return month;
    }

    private static String getInvalidMonth(){
        return String.valueOf(faker.random().nextInt(13,99));
    }

    private static String getValidYear(){
        return String.valueOf(faker.random().nextInt(23,27));
    }

    private static String getInvalidYear(){
        return String.valueOf(faker.random().nextInt(11,21));
    }

    private static String getInvalidYearInFuture(){
        return String.valueOf(faker.random().nextInt(29,55));
    }

    private static String getValidName(){
        return faker.name().name();
    }

    private static String getInvalidName(){
        return faker2.name().name();
    }

    private static String getCVV(){
        return faker.number().digits(3);
    }

    public static CardInfo getAcceptedUser(){
        return new CardInfo("1111 2222 3333 4444",getValidMonth(),getValidYear(),getValidName(),getCVV());
    }

    public static CardInfo getDeclinedUser(){
        return new CardInfo("5555 6666 7777 8888",getValidMonth(),getValidYear(),getValidName(),getCVV());
    }

    public static CardInfo getUserWithWrongCardNumber(){
        return new CardInfo("1111 2222 3333 4445",getValidMonth(),getValidYear(),getValidName(),getCVV());
    }

    public static CardInfo getUserWithWrongMonth(){
        return new CardInfo("1111 2222 3333 4444",getInvalidMonth(),getValidYear(),getValidName(),getCVV());
    }

    public static CardInfo getUserWithWrongYear(){
        return new CardInfo("1111 2222 3333 4444",getValidMonth(),getInvalidYear(),getValidName(),getCVV());
    }

    public static CardInfo getUserWithWrongYearInFuture(){
        return new CardInfo("1111 2222 3333 4444",getValidMonth(),getInvalidYearInFuture(),getValidName(),getCVV());
    }
    public static CardInfo getUserWithCyrillicName(){
        return new CardInfo("1111 2222 3333 4444",getValidMonth(),getValidYear(),getInvalidName(),getCVV());
    }
}
