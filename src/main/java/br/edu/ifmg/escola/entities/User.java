package br.edu.ifmg.escola.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String name;

    @NonNull
    @Column(unique = true)
    private String email;
    @NonNull
    private String password;

    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name = "userRole",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
        )
    private Set<Role> roles = new HashSet<>();
}
