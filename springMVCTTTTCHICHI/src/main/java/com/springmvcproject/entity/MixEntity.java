package com.springmvcproject.entity;

import javax.persistence.*;

@Entity
@Table(name="mix")
public class MixEntity extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mix_gen")
    @SequenceGenerator(name = "mix_gen", sequenceName = "mix_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roles_id")
    private RoleEntity roles;

    public UserEntity getUsers() {
        return users;
    }

    public void setUsers(UserEntity users) {
        this.users = users;
    }

    public RoleEntity getRoles() {
        return roles;
    }

    public void setRoles(RoleEntity roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

}
