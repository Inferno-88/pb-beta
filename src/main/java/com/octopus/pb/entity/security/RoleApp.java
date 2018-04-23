package com.octopus.pb.entity.security;

import com.octopus.pb.entity.Player;
import com.octopus.pb.enums.RoleType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"userAppSet"})
@Entity
@Table(name = "roles")
public class RoleApp implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String authority;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_roles_to_users")),
            inverseJoinColumns = @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "user_roles_to_roles")),
            uniqueConstraints = @UniqueConstraint(name = "user_roles_unique", columnNames = {"user_id", "role_id"})
    )
    private final Set<UserApp> userAppSet = new HashSet<>();

    public RoleApp (RoleType roleType) {
        this.authority = roleType.toString();
    }

}
