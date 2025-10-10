package com.iss.cinema_be.entity;

import com.iss.cinema_be.K.K;
import com.iss.cinema_be.entity.ext.AuditClass;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE movie SET is_active = FALSE, deleted_at = LOCALTIMESTAMP WHERE id = ?")
@SQLRestriction(K.IS_ACTIVE + " = TRUE")
public class Movie extends AuditClass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = K.MOVIE + K.SEQ_GEN)
    @SequenceGenerator(name = K.MOVIE + K.SEQ_GEN)
    @Column(name = "movie_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private Integer runtime;

    @Column(nullable = false)
    private Integer releaseYear;

    @ManyToMany
    @JoinTable(
            name = "movie_nation",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "nation_code"))
    private Set<Nation> nationalities;

    @ManyToOne
    @JoinColumn(name="director_id", nullable = false, referencedColumnName = "director_id")
    private Director director;

}
