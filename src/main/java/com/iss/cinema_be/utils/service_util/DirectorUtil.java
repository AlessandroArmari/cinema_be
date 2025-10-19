package com.iss.cinema_be.utils.service_util;

import com.iss.cinema_be.K.K;
import com.iss.cinema_be.entity.Director;
import com.iss.cinema_be.entity.Movie;
import com.iss.cinema_be.interfaces.Iutil;
import com.iss.cinema_be.repository.DirectorRepository;
import com.iss.cinema_be.utils.exception.ex_entity.NotFoundEx;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DirectorUtil implements Iutil<Director> {

    private final DirectorRepository directorRepository;

    @Override
    public Director findEntityOnDbOrThrow(Long id) {
        return directorRepository.findById(id)
                .orElseThrow(() -> new NotFoundEx(id, K.DIRECTOR));
    }

    @Override
    @Named("findEntityOnDbOrThrow")
    public Director findEntityOnDbOrThrow(String uuid) {

        return directorRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new NotFoundEx(uuid, K.DIRECTOR));
    }
}
