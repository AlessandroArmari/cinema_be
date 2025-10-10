package com.iss.cinema_be.entity;

import com.iss.cinema_be.K.K;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE booking SET is_active = FALSE, deleted_at = LOCALTIMESTAMP WHERE id = ?")
@SQLRestriction(K.IS_ACTIVE + " = TRUE")
public class Booking extends AuditClass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = K.BOOKING + K.SEQ_GEN)
    @SequenceGenerator(name = K.BOOKING + K.SEQ_GEN)
    @Column(name = "booking_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false, referencedColumnName = "account_id")
    private Account account;

}
