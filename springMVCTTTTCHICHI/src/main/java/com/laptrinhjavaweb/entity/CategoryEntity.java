package com.laptrinhjavaweb.entity;

import javax.persistence.*;
@Entity
@Table(name="category")

public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_gen")
    @SequenceGenerator(name = "category_gen", sequenceName = "category_seq", allocationSize = 1)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="code")
    private String code;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
