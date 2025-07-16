package com.we.microservizio_base.service;

import com.we.microservizio_base.model.entity.BaseEntity;
import com.we.microservizio_base.repository.BaseRepository;
import com.we.microservizio_base.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import model_package.model.BaseReqDTO;
import model_package.model.BaseResDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseService {

    private final BaseRepository baseRepository;
    private final MapperUtil mapperUtil;

    public BaseResDTO findById(Long id) {
        return null;
    }

    public BaseResDTO create(BaseReqDTO baseReqDTO) {
        BaseEntity baseEntity = baseRepository.save(mapperUtil.fromReqToEnt(baseReqDTO));
        return mapperUtil.fromEntToRes(baseEntity);
    }
}
