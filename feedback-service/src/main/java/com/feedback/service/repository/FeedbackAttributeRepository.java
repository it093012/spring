package com.feedback.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.feedback.service.entity.FeedbackAttribute;

@Repository
public interface FeedbackAttributeRepository extends CrudRepository<FeedbackAttribute, Integer> {
	List<FeedbackAttribute> findByAppId(Integer id);

}
