package com.we.microservizio_base.controller;

import api_package.api.BaseApi;
import com.we.microservizio_base.service.BaseService;
import lombok.RequiredArgsConstructor;
import model_package.model.BaseDTO;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class BaseController implements BaseApi {

    private final BaseService baseService;

    @Override
    public ResponseEntity<BaseDTO> findById(Long id) {
        return ResponseEntity.ok(baseService.findById(id));
    }

    @Override
    public ResponseEntity<BaseDTO> create(BaseDTO baseDTO) {
        return ResponseEntity.ok(baseService.create(baseDTO));
    }



}
