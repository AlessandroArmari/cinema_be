package com.iss.cinema_be.controller;

import api_package.api.MovieApi;
import com.iss.cinema_be.interfaceImpl.Iservice;
import lombok.RequiredArgsConstructor;
import model_package.model.MovieReqDto;
import model_package.model.MovieResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieController implements MovieApi {

    private final Iservice<MovieResDto, MovieReqDto> iService;

    @Override
    public ResponseEntity<MovieResDto> findById(Long id) {
        return ResponseEntity.ok(iService.findById(id));
    }

    @Override
    public ResponseEntity<MovieResDto> createMovie(MovieReqDto MovieReqDto) {
        return ResponseEntity.ok(iService.create(MovieReqDto));
    }

    @Override
    public ResponseEntity<MovieResDto> updateById(Long id, MovieReqDto MovieReqDto) {
        return ResponseEntity.ok(iService.updateById(id, MovieReqDto));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        iService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
