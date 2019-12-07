package com.feedback.service.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="feedback_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_feedback_detail")
	Integer feedbackDeatailId;
	String attributeValue;
	//@OneToOne
	//@JoinColumn
	@Column(name="id_feedback_attribute")
	Integer attributeId;
	//@OneToMany
	//@JoinColumn
	@Column(name="id_feedback_app")
	Integer appId;
	@Convert(converter = LocalDateTimeConverter.class)
	LocalDateTime createdDate;
	
	public Feedback(String attributeValue,Integer attributeId,Integer appId,LocalDateTime createdDate){
		this.attributeValue = attributeValue;
		this.attributeId = attributeId;
		this.appId = appId;
		this.createdDate = createdDate;
	} 
	

}
