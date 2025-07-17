package com.we.microservizio_base.utils.service_util;

import com.we.microservizio_base.K.K;
import com.we.microservizio_base.model.entity.BaseEntity;
import com.we.microservizio_base.repository.BaseRepository;
import com.we.microservizio_base.utils.exception.ex_entity.NotFoundEx;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseUtil {

    private final BaseRepository baseRepository;

    public BaseEntity findEntityOnDbOrThrow(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new NotFoundEx(id, K.BASE_ENTITY));
    }
}
