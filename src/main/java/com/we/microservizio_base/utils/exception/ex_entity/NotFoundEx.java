package com.we.microservizio_base.utils.exception.ex_entity;

import lombok.*;

@Getter
@Setter
public class NotFoundEx extends BaseEx {

    public Long id;
    public String entity;



    public NotFoundEx(Long id, String entity) {
        super();
        this.setStatusCode(400);
        this.id = id;
        this.entity = entity;
    }
}
