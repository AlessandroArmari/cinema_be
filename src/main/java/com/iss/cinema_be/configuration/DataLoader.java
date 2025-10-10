package com.iss.cinema_be.configuration;

import com.iss.cinema_be.entity.Director;
import com.iss.cinema_be.entity.Movie;
import com.iss.cinema_be.repository.DirectorRepository;
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
    private final DirectorRepository directorRepository;

    public void run(ApplicationArguments args) {

        /*

        Director tarantino = directorRepository.save(Director.builder().name("Quentin").surname("Tarantino").dob(LocalDate.of(1963, 3, 27)).build());
        Director scorsese = directorRepository.save(Director.builder().name("Martin").surname("Scorsese").dob(LocalDate.of(1942, 11, 17)).build());
        Director fellini = directorRepository.save(Director.builder().name("Federico").surname("Fellini").dob(LocalDate.of(1920, 1, 20)).build());

        // Tarantino's
        movieRepository.save(Movie.builder().title("Pulp Fiction").runtime(154).releaseYear(1994).director(tarantino).build());
        movieRepository.save(Movie.builder().title("Kill Bill: Vol. 1").runtime(111).releaseYear(2003).director(tarantino).build());
        movieRepository.save(Movie.builder().title("Django Unchained").runtime(165).releaseYear(2012).director(tarantino).build());

        // Scorsese's
        movieRepository.save(Movie.builder().title("Goodfellas").runtime(146).releaseYear(1990).director(scorsese).build());
        movieRepository.save(Movie.builder().title("Taxi Driver").runtime(114).releaseYear(1976).director(scorsese).build());
        movieRepository.save(Movie.builder().title("The Irishman").runtime(209).releaseYear(2019).director(scorsese).build());

        // Fellini's
        movieRepository.save(Movie.builder().title("La Dolce Vita").runtime(174).releaseYear(1960).director(fellini).build());
        movieRepository.save(Movie.builder().title("8 e mezzo").runtime(138).releaseYear(1963).director(fellini).build());
        movieRepository.save(Movie.builder().title("Amarcord").runtime(123).releaseYear(1973).director(fellini).build());

         */

    }
}