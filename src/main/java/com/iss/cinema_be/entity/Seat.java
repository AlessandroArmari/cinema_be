package com.iss.cinema_be.entity;

import com.iss.cinema_be.K.K;
import com.iss.cinema_be.entity.enum_pack.Row;
import com.iss.cinema_be.entity.ext.AuditClass;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE seat SET is_active = FALSE, deleted_at = LOCALTIMESTAMP WHERE id = ?")
@SQLRestriction(K.IS_ACTIVE + " = TRUE")
public class Seat extends AuditClass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = K.SEAT + K.SEQ_GEN)
    @SequenceGenerator(name = K.SEAT + K.SEQ_GEN)
    @Column(name = "seat_id")
    private Long id;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Row row;

    @Column(unique = true, nullable = false)
    private Integer seatNum;

    @OneToMany(mappedBy = "seat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false, referencedColumnName = "hall_id")
    private Hall hall;

}
