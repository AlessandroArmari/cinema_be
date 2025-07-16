package com.we.microservizio_base.controller;

import api_package.api.BaseApi;
import com.we.microservizio_base.service.BaseService;
import lombok.RequiredArgsConstructor;
import model_package.model.BaseReqDTO;
import model_package.model.BaseResDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BaseController implements BaseApi {

    private final BaseService baseService;

    @Override
    public ResponseEntity<BaseResDTO> findById(Long id) {
        return ResponseEntity.ok(baseService.findById(id));
    }

    @Override
    public ResponseEntity<BaseResDTO> create(BaseReqDTO baseReqDTO) {
        return ResponseEntity.ok(baseService.create(baseReqDTO));
    }



}
