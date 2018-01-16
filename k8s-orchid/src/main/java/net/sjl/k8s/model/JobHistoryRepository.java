package net.sjl.k8s.model;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobHistoryRepository  extends PagingAndSortingRepository<JobHistory, String> {

}
