package com.template.entity.system;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.template.entity.VersionedEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "system", name = "role_process")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class RoleProcess extends VersionedEntity {
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="role_id", nullable = false)
	private Role roleId;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="process_id", nullable = false)
	private Process processId;
}
