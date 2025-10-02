package com.iss.cinema_be.configuration;

import com.iss.cinema_be.entity.Director;
import com.iss.cinema_be.entity.Movie;
import com.iss.cinema_be.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final MovieRepository movieRepository;

    public void run(ApplicationArguments args) {


        Director tarantino = Director.builder().name("Quentin").surname("Tarantino").dob(LocalDate.of(1963, 03, 27)).build();
        Director scorsese = Director.builder().name("Martin").surname("Scorsese").dob(LocalDate.of(1942, 11, 17)).build();
        Director fellini = Director.builder().name("Federico").surname("Fellini").dob(LocalDate.of(1920, 1, 20)).build();


        // Film di Tarantino
        movieRepository.save(Movie.builder().title("Pulp Fiction").runtime(154).releaseYear(1994).build());
        movieRepository.save(Movie.builder().title("Kill Bill: Vol. 1").runtime(111).releaseYear(2003).build());
        movieRepository.save(Movie.builder().title("Django Unchained").runtime(165).releaseYear(2012).build());

// Film di Scorsese
        movieRepository.save(Movie.builder().title("Goodfellas").runtime(146).releaseYear(1990).build());
        movieRepository.save(Movie.builder().title("Taxi Driver").runtime(114).releaseYear(1976).build());
        movieRepository.save(Movie.builder().title("The Irishman").runtime(209).releaseYear(2019).build());

// Film di Fellini
        movieRepository.save(Movie.builder().title("La Dolce Vita").runtime(174).releaseYear(1960).build());
        movieRepository.save(Movie.builder().title("8 e mezzo").runtime(138).releaseYear(1963).build());
        movieRepository.save(Movie.builder().title("Amarcord").runtime(123).releaseYear(1973).build());

    }
}