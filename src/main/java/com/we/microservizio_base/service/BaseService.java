package com.we.microservizio_base.service;

import com.we.microservizio_base.K.K;
import com.we.microservizio_base.interfaceImpl.ServiceImpl;
import com.we.microservizio_base.model.entity.BaseEntity;
import com.we.microservizio_base.repository.BaseRepository;
import com.we.microservizio_base.util.MapperUtil;
import com.we.microservizio_base.util.exception.NotFoundEx;
import lombok.RequiredArgsConstructor;
import model_package.model.BaseReqDTO;
import model_package.model.BaseResDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseService implements ServiceImpl<BaseResDTO, BaseReqDTO> {

    private final BaseRepository baseRepository;
    private final MapperUtil mapperUtil;

    @Override
    public BaseResDTO findById(Long id) {
        return mapperUtil.fromEntToRes(this.findEntityOnDbOrThrow(id));
    }

    @Override
    public BaseResDTO create(BaseReqDTO baseReqDTO) {
        BaseEntity baseEntity = baseRepository.save(mapperUtil.fromReqToEnt(baseReqDTO));
        return mapperUtil.fromEntToRes(baseEntity);
    }

    @Override
    public BaseResDTO updateById(Long id, BaseReqDTO baseReqDTO) {
        BaseEntity baseEntity = this.findEntityOnDbOrThrow(id);
        baseEntity = mapperUtil.fromReqToEnt(baseReqDTO);
        baseEntity.setId(id);
        return mapperUtil.fromEntToRes(baseRepository.save(baseEntity));
    }

    @Override
    public void deleteById(Long id) {
        BaseEntity baseEntity = this.findEntityOnDbOrThrow(id);
        baseRepository.deleteById(baseEntity.getId());
    }

    private BaseEntity findEntityOnDbOrThrow(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new NotFoundEx(id, K.BASE_ENTITY));
    }
}
