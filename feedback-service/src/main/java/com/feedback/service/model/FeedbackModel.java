package com.feedback.service.model;

import java.util.List;

import lombok.Data;

@Data
public class FeedbackModel {
	
	Integer applicationId;
	String applicationName;
	List<AttributeModel> attributes;
	

}
