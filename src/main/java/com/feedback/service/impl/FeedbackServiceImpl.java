package com.feedback.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.service.entity.Feedback;
import com.feedback.service.entity.FeedbackApplication;
import com.feedback.service.entity.FeedbackAttribute;
import com.feedback.service.model.AttributeModel;
import com.feedback.service.model.FeedbackModel;
import com.feedback.service.repository.*;

@Service
public class FeedbackServiceImpl implements FeedBackService {

	@Autowired
	FeedbackAttributeRepository feedbackAttributeRepo;

	@Autowired
	FeedbackApplicationRespository feedbackAppRepo;

	@Autowired
	FeedbackRepository feedbackRepo;

	@Override
	public void addFeedback(FeedbackModel feedbackModel) {

		List<AttributeModel> attributes = feedbackModel.getAttributes();
		List<Feedback> feedbackList = new ArrayList<>();
		for (AttributeModel model : attributes) {
			Feedback feedback = new Feedback(model.getAttributeValue(), model.getAttributeId(),
					feedbackModel.getApplicationId(), LocalDateTime.now());
			feedbackList.add(feedback);
		}
		feedbackRepo.saveAll(feedbackList);
	}

	@Override
	public FeedbackModel addConfiguration(FeedbackModel feedbackModel) {

		FeedbackApplication app = new FeedbackApplication();
		List<FeedbackAttribute> attributes = new ArrayList<>();
		app.setApplicationName(feedbackModel.getApplicationName());
		app = feedbackAppRepo.save(app);
		if (app != null) {
			if (feedbackModel.getAttributes() != null) {
				for (int i = 0; i < feedbackModel.getAttributes().size(); i++) {
					AttributeModel model = feedbackModel.getAttributes().get(i);
					FeedbackAttribute attribute = new FeedbackAttribute();
					attribute.setAppId(app.getAppId());
					// attributes.setAttributeDescription(model.get);
					attribute.setAttributeName(model.getAttributeName());
					attribute.setAttributeName(model.getAttributeName());
					attribute.setAttributeType(model.getAttributeType());
					attributes.add(attribute);
				}
			}

			if (attributes.size() > 0) {
				feedbackAttributeRepo.saveAll(attributes);
			}
			feedbackModel.setApplicationId(app.getAppId());
		}
		return feedbackModel;
	}

	@Override
	public List<FeedbackModel> getAllFeedback(FeedbackModel feedbackModel) {
		return null;
	}

	public List<FeedbackModel> getAllFeedbackForApplication(Integer applicationId) {
		List<FeedbackModel> feedbackModelList = new ArrayList<>();
		List<Feedback> feedbackList = feedbackRepo.findByAppId(applicationId);
		for (Feedback feedBack : feedbackList) {
			FeedbackModel feedbackModel = new FeedbackModel();
			feedbackModel.setApplicationName(feedbackAppRepo.findById(applicationId).get().getApplicationName());
			List<AttributeModel> attributes = new ArrayList<>();
			AttributeModel attrModel = new AttributeModel();
			FeedbackAttribute attribute = feedbackAttributeRepo.findById(feedBack.getAttributeId()).get();
			attrModel.setAttributeName(attribute.getAttributeName());
			attrModel.setAttributeType(attribute.getAttributeType());
			attrModel.setAttributeValue(feedBack.getAttributeValue());
			attributes.add(attrModel);
			feedbackModel.setAttributes(attributes);
			feedbackModelList.add(feedbackModel);
		}
		return feedbackModelList;
	}

	@Override
	public FeedbackModel getConfigurationForApplication(Integer appId) {
		List<FeedbackAttribute> attributes = feedbackAttributeRepo.findByAppId(appId);
		List<AttributeModel> attributeModelList = new ArrayList<>();
		FeedbackModel feedbackModel = new FeedbackModel();
		for (FeedbackAttribute attribute : attributes) {
			AttributeModel model = new AttributeModel();
			model.setAttributeName(attribute.getAttributeName());
			model.setAttributeType(attribute.getAttributeType());
			model.setAttributeId(attribute.getAttributeId());
			attributeModelList.add(model);
		}
		feedbackModel.setApplicationId(appId);
		feedbackModel.setApplicationName(feedbackAppRepo.findById(appId).get().getApplicationName());
		feedbackModel.setAttributes(attributeModelList);
		return feedbackModel;
	}
}
