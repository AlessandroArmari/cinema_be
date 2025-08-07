package com.we.microservizio_base.interfaceImpl;

import org.springframework.stereotype.Repository;

@Repository
public interface Iservice<RES_DTO, REQ_DTO> {

    RES_DTO findById(Long id);

    RES_DTO create(REQ_DTO reqDTO);

    RES_DTO updateById(Long id, REQ_DTO reqDTO);

    void deleteById(Long id);

    }
