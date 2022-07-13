package ru.netology;

public class NotFoundCityIn extends RuntimeException {
    public NotFoundCityIn(String message) {
        super(message);
    }
}
