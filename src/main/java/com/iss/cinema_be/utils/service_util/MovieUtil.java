package com.iss.cinema_be.utils.service_util;

import com.iss.cinema_be.K.K;
import com.iss.cinema_be.entity.Movie;
import com.iss.cinema_be.repository.MovieRepository;
import com.iss.cinema_be.utils.exception.ex_entity.NotFoundEx;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieUtil {

    private final MovieRepository baseRepository;

    public Movie findEntityOnDbOrThrow(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new NotFoundEx(id, K.MOVIE));
    }
}
