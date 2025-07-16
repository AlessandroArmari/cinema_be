package com.we.microservizio_base.util.exception;

public class ExMessage {

    public static String notFound(Long id, String entity) {
        return String.format("%s (id=%s) non trovata su db", entity, id);
    }
}
