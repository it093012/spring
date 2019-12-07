package com.feedback.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity(name="feedback_app")
@Getter
@Setter
public class FeedbackApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_feedback_app")
	Integer appId;
	String applicationName;
	//@OneToMany(fetch= FetchType.LAZY)
	//@Column(name="id_feedback_attribute")
	//Integer attributeId;
}
