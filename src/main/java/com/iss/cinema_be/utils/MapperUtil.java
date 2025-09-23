package com.iss.cinema_be.utils;

import com.iss.cinema_be.entity.Movie;
import com.iss.cinema_be.utils.exception.ex_entity.BaseEx;
import com.iss.cinema_be.utils.exception.ExMessage;
import com.iss.cinema_be.utils.exception.ExResponse;
import com.iss.cinema_be.utils.exception.ex_entity.NotFoundEx;


import model_package.model.MovieReqDto;
import model_package.model.MovieResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = ExMessage.class)
public interface MapperUtil {

    //@Mapping(source = "data", target = "data", dateFormat = "yyyy-MM-dd")
    Movie fromReqToEnt(MovieReqDto movieReqDto);

    /*
    @Mapping(source = "nome", target = "nomeRes")
    @Mapping(source = "cognome", target = "cognomeRes")
    @Mapping(source = "data", target = "dataRes")

     */
    MovieResDto fromEntToRes(Movie movie);

    //EXCEPTION
    //@Mapping(target = "message", expression = "java(ExMessage.notFound(ex.getId(), ex.getEntity()))")
    ExResponse fromExToExResponse(NotFoundEx ex);

    ExResponse fromExToExResponse(BaseEx ex);


}
