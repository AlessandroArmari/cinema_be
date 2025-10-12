package com.iss.cinema_be.interfaceImpl;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Iservice<RES_DTO, REQ_DTO> {

    RES_DTO findByUuid(String uuid);

    RES_DTO findById(Long id);

    List<RES_DTO> findAll();

    RES_DTO create(REQ_DTO reqDTO);

    RES_DTO updateById(Long id, REQ_DTO reqDTO);

    void deleteById(Long id);

}
