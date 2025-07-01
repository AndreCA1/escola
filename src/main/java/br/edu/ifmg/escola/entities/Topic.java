package br.edu.ifmg.escola.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "tb_topic")
public class Topic {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String title;
    private String body;
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToMany
    @JoinTable(
            name = "tb_topic_likes",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> likes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @OneToOne
    @JoinColumn(name = "reply_id")
    private Reply answer;

    @OneToMany(mappedBy = "topic")
    private Set<Reply> replies = new HashSet<>();
}
