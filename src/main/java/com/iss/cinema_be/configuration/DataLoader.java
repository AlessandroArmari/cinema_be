package com.iss.cinema_be.configuration;

import com.iss.cinema_be.entity.*;
import com.iss.cinema_be.entity.enum_pack.PaymentMethod;
import com.iss.cinema_be.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    private final NationRepository nationRepository;
    private final AccountRepository accountRepository;
    private final BookingRepository bookingRepository;

    @Transactional
    public void run(ApplicationArguments args) {

        this.createNations();

        Nation US = nationRepository.getReferenceById("US");
        Nation IT = nationRepository.getReferenceById("IT");
        Nation FR = nationRepository.getReferenceById("FR");


        Director tarantino = directorRepository.save(Director.builder().name("Quentin").surname("Tarantino").dob(LocalDate.of(1963,3,27)).nationalities(Set.of(US)).build());
        Director scorsese = directorRepository.save(Director.builder().name("Martin").surname("Scorsese").dob(LocalDate.of(1942,11,17)).nationalities(Set.of(US)).build());
        Director fellini = directorRepository.save(Director.builder().name("Federico").surname("Fellini").dob(LocalDate.of(1920,1,20)).nationalities(Set.of(IT)).build());

        Movie pulpFiction = movieRepository.save(Movie.builder().title("Pulp Fiction").runtime(154).releaseYear(1994).director(tarantino).nationalities(Set.of(US)).build());
        Movie killBill = movieRepository.save(Movie.builder().title("Kill Bill: Vol. 1").runtime(111).releaseYear(2003).director(tarantino).nationalities(Set.of(US)).build());
        Movie django = movieRepository.save(Movie.builder().title("Django Unchained").runtime(165).releaseYear(2012).director(tarantino).nationalities(Set.of(US)).build());

        Movie goodfellas = movieRepository.save(Movie.builder().title("Goodfellas").runtime(146).releaseYear(1990).director(scorsese).nationalities(Set.of(US)).build());
        Movie taxiDriver = movieRepository.save(Movie.builder().title("Taxi Driver").runtime(114).releaseYear(1976).director(scorsese).nationalities(Set.of(US)).build());
        Movie irishman = movieRepository.save(Movie.builder().title("The Irishman").runtime(209).releaseYear(2019).director(scorsese).nationalities(Set.of(US)).build());

        Movie laDolceVita = movieRepository.save(Movie.builder().title("La Dolce Vita").runtime(174).releaseYear(1960).director(fellini).nationalities(Set.of(IT, FR)).build());
        Movie ottoEMezzo = movieRepository.save(Movie.builder().title("8 e mezzo").runtime(138).releaseYear(1963).director(fellini).nationalities(Set.of(IT)).build());
        Movie amarcord = movieRepository.save(Movie.builder().title("Amarcord").runtime(123).releaseYear(1973).director(fellini).nationalities(Set.of(IT)).build());

        Account mario = accountRepository.save(Account.builder().name("Mario").surname("Rossi").dob(LocalDate.of(1985,5,12)).regDate(LocalDate.now().minusYears(2)).build());
        Account lucia = accountRepository.save(Account.builder().name("Lucia").surname("Bianchi").dob(LocalDate.of(1992,8,23)).regDate(LocalDate.now().minusMonths(6)).build());
        Account giovanni = accountRepository.save(Account.builder().name("Giovanni").surname("Verdi").dob(LocalDate.of(1978,11,3)).regDate(LocalDate.now().minusYears(1)).build());

        Booking bookingMario1 = bookingRepository.save(Booking.builder().paymentDeclined(true).paymentMethod(PaymentMethod.BANK_TRANSFER).amount(16.00).account(mario).build());
        Booking bookingMario2 = bookingRepository.save(Booking.builder().paymentDeclined(false).paymentMethod(PaymentMethod.BANK_TRANSFER).amount(6.00).account(mario).build());
        Booking bookingLucia = bookingRepository.save(Booking.builder().paymentDeclined(true).paymentMethod(PaymentMethod.PAYPAL).amount(8.5).account(lucia).build());
        Booking bookingGiovanni = bookingRepository.save(Booking.builder().paymentDeclined(true).paymentMethod(PaymentMethod.CASH).amount(25.5).account(giovanni).build());
    }

    private void createNations() {

        if (nationRepository.count() == 0) {
            nationRepository.saveAll(List.of(
                    Nation.builder().nationCode("AF").name("Afghanistan").build(),
                    Nation.builder().nationCode("AL").name("Albania").build(),
                    Nation.builder().nationCode("DZ").name("Algeria").build(),
                    Nation.builder().nationCode("AD").name("Andorra").build(),
                    Nation.builder().nationCode("AO").name("Angola").build(),
                    Nation.builder().nationCode("AR").name("Argentina").build(),
                    Nation.builder().nationCode("AM").name("Armenia").build(),
                    Nation.builder().nationCode("AU").name("Australia").build(),
                    Nation.builder().nationCode("AT").name("Austria").build(),
                    Nation.builder().nationCode("AZ").name("Azerbaijan").build(),
                    Nation.builder().nationCode("BE").name("Belgium").build(),
                    Nation.builder().nationCode("BR").name("Brazil").build(),
                    Nation.builder().nationCode("CA").name("Canada").build(),
                    Nation.builder().nationCode("CL").name("Chile").build(),
                    Nation.builder().nationCode("CN").name("China").build(),
                    Nation.builder().nationCode("CO").name("Colombia").build(),
                    Nation.builder().nationCode("HR").name("Croatia").build(),
                    Nation.builder().nationCode("CU").name("Cuba").build(),
                    Nation.builder().nationCode("CY").name("Cyprus").build(),
                    Nation.builder().nationCode("CZ").name("Czech Republic").build(),
                    Nation.builder().nationCode("DK").name("Denmark").build(),
                    Nation.builder().nationCode("EG").name("Egypt").build(),
                    Nation.builder().nationCode("EE").name("Estonia").build(),
                    Nation.builder().nationCode("FI").name("Finland").build(),
                    Nation.builder().nationCode("FR").name("France").build(),
                    Nation.builder().nationCode("DE").name("Germany").build(),
                    Nation.builder().nationCode("GR").name("Greece").build(),
                    Nation.builder().nationCode("HU").name("Hungary").build(),
                    Nation.builder().nationCode("IS").name("Iceland").build(),
                    Nation.builder().nationCode("IN").name("India").build(),
                    Nation.builder().nationCode("ID").name("Indonesia").build(),
                    Nation.builder().nationCode("IR").name("Iran").build(),
                    Nation.builder().nationCode("IE").name("Ireland").build(),
                    Nation.builder().nationCode("IL").name("Israel").build(),
                    Nation.builder().nationCode("IT").name("Italy").build(),
                    Nation.builder().nationCode("JP").name("Japan").build(),
                    Nation.builder().nationCode("JO").name("Jordan").build(),
                    Nation.builder().nationCode("KE").name("Kenya").build(),
                    Nation.builder().nationCode("KR").name("Korea, Republic of").build(),
                    Nation.builder().nationCode("KW").name("Kuwait").build(),
                    Nation.builder().nationCode("LV").name("Latvia").build(),
                    Nation.builder().nationCode("LB").name("Lebanon").build(),
                    Nation.builder().nationCode("LT").name("Lithuania").build(),
                    Nation.builder().nationCode("LU").name("Luxembourg").build(),
                    Nation.builder().nationCode("MY").name("Malaysia").build(),
                    Nation.builder().nationCode("MT").name("Malta").build(),
                    Nation.builder().nationCode("MX").name("Mexico").build(),
                    Nation.builder().nationCode("MD").name("Moldova").build(),
                    Nation.builder().nationCode("MC").name("Monaco").build(),
                    Nation.builder().nationCode("ME").name("Montenegro").build(),
                    Nation.builder().nationCode("MA").name("Morocco").build(),
                    Nation.builder().nationCode("NL").name("Netherlands").build(),
                    Nation.builder().nationCode("NZ").name("New Zealand").build(),
                    Nation.builder().nationCode("NG").name("Nigeria").build(),
                    Nation.builder().nationCode("NO").name("Norway").build(),
                    Nation.builder().nationCode("PK").name("Pakistan").build(),
                    Nation.builder().nationCode("PA").name("Panama").build(),
                    Nation.builder().nationCode("PE").name("Peru").build(),
                    Nation.builder().nationCode("PH").name("Philippines").build(),
                    Nation.builder().nationCode("PL").name("Poland").build(),
                    Nation.builder().nationCode("PT").name("Portugal").build(),
                    Nation.builder().nationCode("RO").name("Romania").build(),
                    Nation.builder().nationCode("RU").name("Russia").build(),
                    Nation.builder().nationCode("SA").name("Saudi Arabia").build(),
                    Nation.builder().nationCode("RS").name("Serbia").build(),
                    Nation.builder().nationCode("SG").name("Singapore").build(),
                    Nation.builder().nationCode("SK").name("Slovakia").build(),
                    Nation.builder().nationCode("SI").name("Slovenia").build(),
                    Nation.builder().nationCode("ZA").name("South Africa").build(),
                    Nation.builder().nationCode("ES").name("Spain").build(),
                    Nation.builder().nationCode("SE").name("Sweden").build(),
                    Nation.builder().nationCode("CH").name("Switzerland").build(),
                    Nation.builder().nationCode("TH").name("Thailand").build(),
                    Nation.builder().nationCode("TR").name("Turkey").build(),
                    Nation.builder().nationCode("UA").name("Ukraine").build(),
                    Nation.builder().nationCode("AE").name("United Arab Emirates").build(),
                    Nation.builder().nationCode("GB").name("United Kingdom").build(),
                    Nation.builder().nationCode("US").name("United States").build(),
                    Nation.builder().nationCode("UY").name("Uruguay").build(),
                    Nation.builder().nationCode("VE").name("Venezuela").build(),
                    Nation.builder().nationCode("VN").name("Vietnam").build(),
                    Nation.builder().nationCode("ZM").name("Zambia").build(),
                    Nation.builder().nationCode("ZW").name("Zimbabwe").build()
            ));
        }
    }
}

