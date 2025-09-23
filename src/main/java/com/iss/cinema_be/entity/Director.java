package com.iss.cinema_be.entity;

import com.iss.cinema_be.K.K;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE director SET is_active = FALSE, deleted_at = LOCALTIMESTAMP WHERE id = ?")
@SQLRestriction(K.IS_ACTIVE + " = TRUE")
public class Director extends AuditClass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = K.MOVIE + K.SEQ_GEN)
    @SequenceGenerator(name = K.DIRECTOR + K.SEQ_GEN)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private LocalDate dob;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Movie> movies;
}
