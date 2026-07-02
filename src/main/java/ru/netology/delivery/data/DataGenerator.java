package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
         return LocalDate.now()
                        .plusDays(shift)
                        .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты

    }

    public static String generateCity(Faker faker) {
        String[] city = {"Москва", "Санкт-Петербург", "Краснодар", "Якутия"};
        Random random = new Random();
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random
        return city[random.nextInt(city.length)];
    }

    public static String generateName() {
        Faker faker = new Faker(new Locale("ru"));
      return faker.name().lastName() + " " + faker.name().firstName();
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker
        
    }

    public static String generatePhone() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.phoneNumber().phoneNumber();
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать Faker

    }

    public static class Registration {
        private static Faker faker;

        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            Faker faker = new Faker(new Locale("ru"));
            String city = generateCity(faker);
            String name = faker.name().fullName();
            String phone = faker.phoneNumber().phoneNumber();
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(faker),
            // generateName(faker), generatePhone(faker)
            return new UserInfo(city, name, phone);
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}