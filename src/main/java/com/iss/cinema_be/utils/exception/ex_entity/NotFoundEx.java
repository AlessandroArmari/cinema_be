package com.iss.cinema_be.utils.exception.ex_entity;

import lombok.*;

@Getter
@Setter
public class NotFoundEx extends BaseEx {

    public Long id;
    public String uuid;
    public String entity;



    public NotFoundEx(Long id, String entity) {
        super();
        this.setStatusCode(400);
        this.id = id;
        this.entity = entity;
    }

    public NotFoundEx(String uuid, String entity) {
        super();
        this.setStatusCode(400);
        this.uuid = uuid;
        this.entity = entity;
    }
}
