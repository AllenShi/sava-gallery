package net.sjl.k8s.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude={"edges"})
@Entity
public class JobDAGDefinition extends AbstractJobModel {
	
	@Column(name = "JOB_DAG_NAME", nullable = false)
	private String name;
	
	@Column(name = "JOB_DAG_DESC", nullable = true)
	private String description;
	
	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "jobDAGDefinition")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "jobDAGDefinition")
	private Set<JobDAGEdgeDefinition> edges;

}
