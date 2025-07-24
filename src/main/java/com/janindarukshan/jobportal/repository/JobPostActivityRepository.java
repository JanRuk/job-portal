package com.janindarukshan.jobportal.repository;

import com.janindarukshan.jobportal.entity.JobPostActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostActivityRepository  extends JpaRepository<JobPostActivity, Integer> {

}
