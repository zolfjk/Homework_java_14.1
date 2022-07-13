package ru.netology;

public class NotFoundCityFrom extends RuntimeException{
    public NotFoundCityFrom(String message) {
        super(message);
    }
}
