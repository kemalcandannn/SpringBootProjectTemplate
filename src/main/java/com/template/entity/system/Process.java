package com.template.entity.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.template.entity.VersionedEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "system", name = "process")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Process extends VersionedEntity {
	@Column(name = "name" , length = 100, nullable = false)
	private String name;
	
	@Column(name = "table_name" , length = 50, nullable = false, unique = true)
	@NotEmpty(message = "Table Name cannot be empty or null.")
	private String tableName;
	
	@Column(name = "explanation", length = 250)
	private String explanation;
	
	@Column(name = "show_in_tree" , nullable = false)
	private Boolean showInTree;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_process_id")
	private Process parentProcessId;
}
