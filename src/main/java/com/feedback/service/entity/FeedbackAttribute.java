package com.feedback.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FeedbackAttribute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_feedback_attribute")
	Integer attributeId;
	String attributeName;
	String attributeType;
	String attributeDescription;
	@Column(name="id_feedback_app")
	Integer appId;
}
