package br.edu.ifmg.escola.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Inheritance(strategy = InheritanceType.JOINED)//Uma tabela para cada com as chaves estrangeiras(precisa buscar nas outras) gasta mais tempo e msnos espaço
//SingleTable - um tabelao quando tem poucos campos diferentes. Gasta menos tempo e mais espaço
//TablePerClass - Não cria tablea para a classe pai. Dps cria uma tabela para cada classe filho
@Table(name = "tb_lesson")
public abstract class Lesson {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String title;
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToMany
    @JoinTable(name = "tb_lessonsDone",
            joinColumns = @JoinColumn(name = "lesson_id"),
            //Chave composta do Enrollment
            inverseJoinColumns = {
                @JoinColumn(name = "user_id"),
                @JoinColumn(name = "offer_id")
            })
    private Set<Enrollment> enrollmentsDone = new HashSet<Enrollment>();
}
