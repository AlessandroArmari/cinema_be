package com.we.microservizio_base.controller;

import api_package.api.BaseApi;
import com.we.microservizio_base.interfaceImpl.Iservice;
import lombok.RequiredArgsConstructor;
import model_package.model.BaseReqDTO;
import model_package.model.BaseResDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BaseController implements BaseApi {

    private final Iservice<BaseResDTO, BaseReqDTO> iService;

    @Override
    public ResponseEntity<BaseResDTO> findById(Long id) {
        return ResponseEntity.ok(iService.findById(id));
    }

    @Override
    public ResponseEntity<BaseResDTO> create(BaseReqDTO baseReqDTO) {
        return ResponseEntity.ok(iService.create(baseReqDTO));
    }

    @Override
    public ResponseEntity<BaseResDTO> updateById(Long id, BaseReqDTO baseReqDTO) {
        return ResponseEntity.ok(iService.updateById(id, baseReqDTO));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        iService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
