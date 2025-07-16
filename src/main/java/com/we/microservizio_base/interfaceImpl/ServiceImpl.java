package com.we.microservizio_base.interfaceImpl;


public interface ServiceImpl<T, REQ_DTO> {

    public T findById(Long id);

    public T create(REQ_DTO reqDTO);

    public T updateById(Long id, REQ_DTO reqDTO);


    }
