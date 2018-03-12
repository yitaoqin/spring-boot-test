package com.example.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "userd")
public class UserEntity {

    @Id
    @Column(updatable = false,nullable = false)
    @Size(min=0,max=50)
    private String username;

    private String password;
    @Email
    private String email;
    private String activated;
    private String activationkey;
    private String resetpasswordkey;

    @ManyToMany
    @JoinTable(
            name = "authority_user",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "authority")
    )
    private Set<Authority> authoritySet;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivated() {
        return activated;
    }

    public void setActivated(String activated) {
        this.activated = activated;
    }

    public String getActivationkey() {
        return activationkey;
    }

    public void setActivationkey(String activationkey) {
        this.activationkey = activationkey;
    }

    public String getResetpasswordkey() {
        return resetpasswordkey;
    }

    public void setResetpasswordkey(String resetpasswordkey) {
        this.resetpasswordkey = resetpasswordkey;
    }

    public Set<Authority> getAuthoritySet() {
        return authoritySet;
    }

    public void setAuthoritySet(Set<Authority> authoritySet) {
        this.authoritySet = authoritySet;
    }
}
