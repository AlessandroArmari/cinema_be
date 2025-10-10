package com.iss.cinema_be.entity;

import com.iss.cinema_be.K.K;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE account SET is_active = FALSE, deleted_at = LOCALTIMESTAMP WHERE id = ?")
@SQLRestriction(K.IS_ACTIVE + " = TRUE")
public class Account extends AuditClass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = K.ACCOUNT + K.SEQ_GEN)
    @SequenceGenerator(name = K.ACCOUNT + K.SEQ_GEN)
    @Column(name = "account_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private LocalDate dob;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Booking> bookings;

}
