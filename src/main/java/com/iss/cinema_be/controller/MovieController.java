package com.iss.cinema_be.controller;

import api_package.api.MovieApi;
import com.iss.cinema_be.interfaceImpl.Iservice;
import lombok.RequiredArgsConstructor;
import model_package.model.MovieReqDto;
import model_package.model.MovieResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController implements MovieApi {

    private final Iservice<MovieResDto, MovieReqDto> iService;

    @Override
    public ResponseEntity<MovieResDto> findById(Long id) {
        return ResponseEntity.ok(iService.findById(id));
    }

    @Override
    public ResponseEntity<List<MovieResDto>> findAll() {
        return ResponseEntity.ok(iService.findAll());
    }

    @Override
    public ResponseEntity<MovieResDto> createMovie(MovieReqDto movieReqDto) {
        return ResponseEntity.ok(iService.create(movieReqDto));
    }

    @Override
    public ResponseEntity<MovieResDto> updateById(Long id, MovieReqDto movieReqDto) {
        return ResponseEntity.ok(iService.updateById(id, movieReqDto));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        iService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
