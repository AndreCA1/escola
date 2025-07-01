package br.edu.ifmg.escola.entities;

import br.edu.ifmg.escola.costants.DeliverStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "tb_deliver")
public class Deliver {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String uri;
    private Instant moment;

    @Enumerated(EnumType.STRING)
    private DeliverStatus status;
    private String feedback;
    private Integer correctCount;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;


    //Enrollment é chave composta
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "offer_id"),
            @JoinColumn(name = "user_id")
    })
    private Enrollment enrollment;
}
