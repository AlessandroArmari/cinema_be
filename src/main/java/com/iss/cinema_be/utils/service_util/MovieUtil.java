package com.iss.cinema_be.utils.service_util;

import com.iss.cinema_be.K.K;
import com.iss.cinema_be.entity.Movie;
import com.iss.cinema_be.repository.MovieRepository;
import com.iss.cinema_be.utils.exception.ex_entity.NotFoundEx;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieUtil {

    private final MovieRepository movieRepository;

    public Movie findEntityOnDbOrThrow(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundEx(id, K.MOVIE));
    }

    public Movie findEntityOnDbOrThrow(String uuid) {
        return movieRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new NotFoundEx(uuid, K.MOVIE));
    }
}
