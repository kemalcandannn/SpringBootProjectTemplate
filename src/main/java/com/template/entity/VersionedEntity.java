package com.template.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class VersionedEntity extends BaseEntity {
	@Version
	@Column(name = "version", columnDefinition="Bigint default 0", nullable = false)
	protected Long version;
}
