package com.we.microservizio_base.service;

import com.we.microservizio_base.configuration.BaseInterceptor;
import com.we.microservizio_base.interfaceImpl.ServiceImpl;
import com.we.microservizio_base.model.entity.BaseEntity;
import com.we.microservizio_base.repository.BaseRepository;
import com.we.microservizio_base.utils.MapperUtil;
import com.we.microservizio_base.utils.service_util.BaseUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import model_package.model.BaseReqDTO;
import model_package.model.BaseResDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseService implements ServiceImpl<BaseResDTO, BaseReqDTO> {

    private final BaseRepository baseRepository;
    private final BaseUtil baseUtil;
    private final MapperUtil mapperUtil;

    @Override
    public BaseResDTO findById(Long id) {
        return mapperUtil.fromEntToRes(baseUtil.findEntityOnDbOrThrow(id));
    }

    @Override
    @Transactional
    public BaseResDTO create(BaseReqDTO baseReqDTO) {
        BaseEntity baseEntity = baseRepository.save(mapperUtil.fromReqToEnt(baseReqDTO));
        return mapperUtil.fromEntToRes(baseEntity);
    }

    @Override
    @Transactional
    public BaseResDTO updateById(Long id, BaseReqDTO baseReqDTO) {
        BaseEntity baseEntity = baseUtil.findEntityOnDbOrThrow(id);
        baseEntity = mapperUtil.fromReqToEnt(baseReqDTO);
        baseEntity.setId(id);
        return mapperUtil.fromEntToRes(baseRepository.save(baseEntity));
    }

    @Override
    public void deleteById(Long id) {
        BaseEntity baseEntity = baseUtil.findEntityOnDbOrThrow(id);
        baseRepository.deleteById(baseEntity.getId());
    }


}
