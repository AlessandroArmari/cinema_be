package com.iss.cinema_be.utils;

import com.iss.cinema_be.entity.Movie;
import com.iss.cinema_be.interfaces.Iutil;
import com.iss.cinema_be.utils.exception.ex_entity.BaseEx;
import com.iss.cinema_be.utils.exception.ExMessage;
import com.iss.cinema_be.utils.exception.ExResponse;
import com.iss.cinema_be.utils.exception.ex_entity.NotFoundEx;


import com.iss.cinema_be.utils.service_util.DirectorUtil;
import model_package.model.MovieReqDto;
import model_package.model.MovieResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = DirectorUtil.class, imports = ExMessage.class)
public interface MapperUtil {

    @Mapping(target = "director", source = "directorUuid", qualifiedByName = "findEntityOnDbOrThrow")
    Movie fromReqToEnt(MovieReqDto movieReqDto);

    @Mapping(target = "director", source = "directorUuid", qualifiedByName = "findEntityOnDbOrThrow")
    MovieResDto fromEntToRes(Movie movie);

    //EXCEPTION
    //@Mapping(target = "message", expression = "java(ExMessage.notFound(ex.getId(), ex.getEntity()))")
    ExResponse fromExToExResponse(NotFoundEx ex);

    ExResponse fromExToExResponse(BaseEx ex);


}
