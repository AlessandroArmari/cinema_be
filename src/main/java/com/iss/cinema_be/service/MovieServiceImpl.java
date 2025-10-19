package com.iss.cinema_be.service;

import com.iss.cinema_be.entity.Movie;
import com.iss.cinema_be.interfaces.Iservice;
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

    private final MovieRepository movieRepository;
    private final MovieUtil movieUtil;
    private final MapperUtil mapperUtil;

    @Override
    public MovieResDto findByUuid(String uuid) {
        return mapperUtil.fromEntToRes(movieUtil.findEntityOnDbOrThrow(uuid));
    }

    @Override
    public MovieResDto findById(Long id) {
        return mapperUtil.fromEntToRes(movieUtil.findEntityOnDbOrThrow(id));
    }

    @Override
    public List<MovieResDto> findAll() {
        return List.of();
    }

    @Override
    @Transactional
    public MovieResDto create(MovieReqDto movieReqDto) {
        Movie movie = mapperUtil.fromReqToEnt(movieReqDto);
        movie = movieRepository.save(movie);
        MovieResDto movieResDto = mapperUtil.fromEntToRes(movie);
        return movieResDto;
    }

    @Override
    @Transactional
    public MovieResDto updateById(Long id, MovieReqDto baseReqDTO) {
        movieUtil.findEntityOnDbOrThrow(id);
        Movie movie = mapperUtil.fromReqToEnt(baseReqDTO);
        movie.setId(id);
        return mapperUtil.fromEntToRes(movieRepository.save(movie));
    }

    @Override
    public void deleteById(Long id) {
        Movie movie = movieUtil.findEntityOnDbOrThrow(id);
        movieRepository.deleteById(movie.getId());
    }


}
