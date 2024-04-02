package com.example.dlSpring.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, Set<Role> roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return name;
    }

    public String getRolesToString() {
        List<Role> list = getRoles().stream().toList();
        StringBuilder str = new StringBuilder(list.get(0).toString());
        if (list.size() == 2) {
            str.append(" ").append(list.get(1).toString());
        }
        return String.valueOf(str);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles;
    }
}
