package com.iss.cinema_be.utils.exception;

public class ExMessage {

    public static String notFound(Long id, String entity) {
        return String.format("%s (id=%s) non trovata su db", entity, id);
    }
}
