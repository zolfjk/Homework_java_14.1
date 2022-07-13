package ru.netology;

public class NotFoundId extends RuntimeException {

    public NotFoundId(String message) {
        super(message);
    }
}