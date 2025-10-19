package com.iss.cinema_be.interfaces;


import org.mapstruct.Named;
import org.springframework.stereotype.Repository;

@Repository
public interface Iutil<T> {


    T findEntityOnDbOrThrow(Long id);

    T findEntityOnDbOrThrow(String uuid);
}
