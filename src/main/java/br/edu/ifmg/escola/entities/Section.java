package br.edu.ifmg.escola.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "tb_section")
public class Section {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    //Pré-requisitos da sessao
    @ManyToOne
    @JoinColumn(name = "prerequisite_id")
    private Section prerequisite;

    @OneToMany(mappedBy = "section")
    private Set<Lesson> lessons = new HashSet<Lesson>();
}
