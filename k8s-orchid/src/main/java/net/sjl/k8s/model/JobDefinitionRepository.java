package net.sjl.k8s.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDefinitionRepository extends PagingAndSortingRepository<JobDefinition, String> {

}
