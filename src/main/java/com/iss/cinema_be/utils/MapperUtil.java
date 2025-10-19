package com.iss.cinema_be.utils;

import com.iss.cinema_be.entity.Movie;
import com.iss.cinema_be.entity.ext.AuditClass;
import com.iss.cinema_be.utils.exception.ex_entity.BaseEx;
import com.iss.cinema_be.utils.exception.ExMessage;
import com.iss.cinema_be.utils.exception.ExResponse;
import com.iss.cinema_be.utils.exception.ex_entity.NotFoundEx;


import com.iss.cinema_be.utils.service_util.DirectorUtil;
import model_package.model.MovieReqDto;
import model_package.model.MovieResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = DirectorUtil.class, imports = ExMessage.class)
public interface MapperUtil {

    @Mapping(target = "director", source = "directorUuid", qualifiedByName = "findEntityOnDbOrThrow")
    Movie fromReqToEnt(MovieReqDto movieReqDto);

    GESTIRE NAZIONI IN ENTRATA

    @Mapping(target = "directorUuid", source = "director", qualifiedByName = "getUuid")
    MovieResDto fromEntToRes(Movie movie);


    ExResponse fromExToExResponse(NotFoundEx ex);

    ExResponse fromExToExResponse(BaseEx ex);


    @Named("getUuid")
    default String getUuid(AuditClass auditClass) {
        return auditClass.getUuid().toString();
    }


}
