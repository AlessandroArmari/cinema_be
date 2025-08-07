package com.we.microservizio_base.controller;

import api_package.api.BaseApi;
import com.we.microservizio_base.service.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import model_package.model.BaseReqDTO;
import model_package.model.BaseResDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BaseController implements BaseApi {

    private final BaseServiceImpl baseServiceImpl;

    @Override
    public ResponseEntity<BaseResDTO> findById(Long id) {
        return ResponseEntity.ok(baseServiceImpl.findById(id));
    }

    @Override
    public ResponseEntity<BaseResDTO> create(BaseReqDTO baseReqDTO) {
        return ResponseEntity.ok(baseServiceImpl.create(baseReqDTO));
    }

    @Override
    public ResponseEntity<BaseResDTO> updateById(Long id, BaseReqDTO baseReqDTO) {
        return ResponseEntity.ok(baseServiceImpl.updateById(id, baseReqDTO));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        baseServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
