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
@SQLDelete(sql = "UPDATE show SET is_active = FALSE, deleted_at = LOCALTIMESTAMP WHERE id = ?")
@SQLRestriction(K.IS_ACTIVE + " = TRUE")
public class Show extends AuditClass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = K.SHOW + K.SEQ_GEN)
    @SequenceGenerator(name = K.SHOW + K.SEQ_GEN)
    @Column(name = "show_id")
    private Long id;

    @OneToMany(mappedBy = "show", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ticket> tickets;



}
