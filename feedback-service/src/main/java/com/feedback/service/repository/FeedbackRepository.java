package com.feedback.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.feedback.service.entity.Feedback;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Integer>{

	List<Feedback> findByAppId(Integer appId); 
}
