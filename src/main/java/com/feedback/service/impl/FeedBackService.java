package com.feedback.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.feedback.service.model.FeedbackModel;

@Service
public interface FeedBackService {
	
	void addFeedback(FeedbackModel feedbackModel);
	
	List<FeedbackModel> getAllFeedback(FeedbackModel feedbackModel);
		
	List<FeedbackModel> getAllFeedbackForApplication(Integer applicationId);
	
	FeedbackModel addConfiguration(FeedbackModel feedbackModel);
	
	FeedbackModel getConfigurationForApplication(Integer appId);
	

}
