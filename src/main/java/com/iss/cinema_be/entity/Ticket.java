package com.iss.cinema_be.entity;

import com.iss.cinema_be.K.K;
import com.iss.cinema_be.entity.ext.AuditClass;
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
@SQLDelete(sql = "UPDATE ticket SET is_active = FALSE, deleted_at = LOCALTIMESTAMP WHERE id = ?")
@SQLRestriction(K.IS_ACTIVE + " = TRUE")
public class Ticket extends AuditClass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = K.TICKET + K.SEQ_GEN)
    @SequenceGenerator(name = K.TICKET + K.SEQ_GEN)
    @Column(name = "ticket_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="booking_id", nullable = false, referencedColumnName = "booking_id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name="show_id", nullable = false, referencedColumnName = "show_id")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false, referencedColumnName = "seat_id")
    private Seat seat;

}
