package com.we.microservizio_base.util.exception;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
public class NotFoundEx extends BaseEx {

    public Long id;
    public String entity;


    public NotFoundEx(Long id, String entity, String message) {
        super(message);
        this.id = id;
        this.entity = entity;
    }
}
