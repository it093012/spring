package com.feedback.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.feedback.service.entity.FeedbackApplication;

@Repository
public interface FeedbackApplicationRespository extends CrudRepository<FeedbackApplication, Integer>{

}
