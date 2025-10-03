package com.iss.cinema_be.service;

import com.iss.cinema_be.entity.Movie;
import com.iss.cinema_be.interfaceImpl.Iservice;
import com.iss.cinema_be.repository.MovieRepository;
import com.iss.cinema_be.utils.MapperUtil;
import com.iss.cinema_be.utils.service_util.MovieUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import model_package.model.MovieReqDto;
import model_package.model.MovieResDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements Iservice<MovieResDto, MovieReqDto> {

    private final MovieRepository baseRepository;
    private final MovieUtil baseUtil;
    private final MapperUtil mapperUtil;

    @Override
    public MovieResDto findById(Long id) {
        return mapperUtil.fromEntToRes(baseUtil.findEntityOnDbOrThrow(id));
    }

    @Override
    public List<MovieResDto> findAll() {
        return List.of();
    }

    @Override
    @Transactional
    public MovieResDto create(MovieReqDto movieReqDto) {
        Movie movie = baseRepository.save(mapperUtil.fromReqToEnt(movieReqDto));
        return mapperUtil.fromEntToRes(movie);
    }

    @Override
    @Transactional
    public MovieResDto updateById(Long id, MovieReqDto baseReqDTO) {
        baseUtil.findEntityOnDbOrThrow(id);
        Movie movie = mapperUtil.fromReqToEnt(baseReqDTO);
        movie.setId(id);
        return mapperUtil.fromEntToRes(baseRepository.save(movie));
    }

    @Override
    public void deleteById(Long id) {
        Movie movie = baseUtil.findEntityOnDbOrThrow(id);
        baseRepository.deleteById(movie.getId());
    }


}
