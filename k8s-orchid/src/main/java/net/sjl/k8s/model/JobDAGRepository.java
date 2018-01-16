package net.sjl.k8s.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDAGRepository extends PagingAndSortingRepository<JobDAG, String> {

}
