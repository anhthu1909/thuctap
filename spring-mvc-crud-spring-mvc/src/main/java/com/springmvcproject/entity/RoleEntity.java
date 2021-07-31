package com.springmvcproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_gen")
	@SequenceGenerator(name = "role_gen", sequenceName = "role_seq", allocationSize = 1)
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;
	
	@ManyToMany(mappedBy = "roles")
    private List<UserEntity> users = new ArrayList<>();

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

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
}
