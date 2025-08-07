package com.we.microservizio_base.interfaceImpl;


public interface Iservice<T, REQ_DTO> {

    T findById(Long id);

    T create(REQ_DTO reqDTO);

    T updateById(Long id, REQ_DTO reqDTO);

    void deleteById(Long id);

    }
