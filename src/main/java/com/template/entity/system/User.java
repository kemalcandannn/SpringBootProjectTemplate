package com.template.entity.system;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.template.entity.VersionedEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import util.enums.ActiveEnum;

@Entity
@Table(schema = "system", name = "user")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class User extends VersionedEntity {
	@Column(name = "username" , length = 50, nullable = false)
	private String username;

	@Column(name = "password" , length = 100, nullable = false)
	private String password;
	
	@Column(name = "name" , length = 100, nullable = false)
	private String name;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "active", nullable = false)
	private ActiveEnum active;
	
	@Column(name = "admin", nullable = false)
	private Boolean admin;
}
