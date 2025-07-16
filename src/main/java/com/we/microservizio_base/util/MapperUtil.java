package com.we.microservizio_base.util;

import com.we.microservizio_base.model.entity.BaseEntity;
import com.we.microservizio_base.util.exception.BaseEx;
import com.we.microservizio_base.util.exception.ExMessage;
import com.we.microservizio_base.util.exception.NotFoundEx;
import model_package.model.BaseReqDTO;
import model_package.model.BaseResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = ExMessage.class)
public interface MapperUtil {

    @Mapping(source = "data", target = "data", dateFormat = "yyyy-MM-dd")
    BaseEntity fromReqToEnt(BaseReqDTO baseReqDTO);

    @Mapping(source = "nome", target = "nomeRes")
    @Mapping(source = "cognome", target = "cognomeRes")
    @Mapping(source = "data", target = "dataRes")
    BaseResDTO fromEntToRes(BaseEntity baseEntity);

    //EXCEPTION
    @Mapping(target = "message", expression = "java(ExMessage.notFound(ex.getId(), ex.getEntity()))")
    ExResponse fromExToExResponse(NotFoundEx ex);


    ExResponse fromExToExResponse(BaseEx ex);


}
