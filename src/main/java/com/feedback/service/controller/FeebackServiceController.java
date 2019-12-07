package com.feedback.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.service.impl.FeedBackService;
import com.feedback.service.model.FeedbackModel;
import com.feedback.service.model.Response;

@RestController
@CrossOrigin
public class FeebackServiceController {

	@Autowired
	private FeedBackService feedBackService;
	
	/*@GetMapping("/feedback")
	public ResponseEntity<Response> getAllFeedback(){
		return new ResponseEntity<>(
				
				Response.builder().response(null).status(HttpStatus.OK.toString()).build(),
				HttpStatus.OK);

	}
	*/
	@PostMapping("/feedback")
	public ResponseEntity<Response> addFeedback(@RequestBody FeedbackModel feedbackModel){
		feedBackService.addFeedback(feedbackModel);
		return new ResponseEntity<>(
				Response.builder().response("Success").status(HttpStatus.OK.toString()).build(),
				HttpStatus.OK);

	}
	
	@GetMapping("/feedback/{applicationId}")
	public ResponseEntity<Response> getFeedbackForApplication(@PathVariable Integer applicationId){
		List<FeedbackModel> response = feedBackService.getAllFeedbackForApplication(applicationId);
		return new ResponseEntity<>(
				Response.builder().response(response).status(HttpStatus.OK.toString()).build(),
				HttpStatus.OK);

	}
	
	@PostMapping("/configure")
	public ResponseEntity<Response> getAllConfiguration(@RequestBody FeedbackModel attributeModel){
		
		FeedbackModel response = feedBackService.addConfiguration(attributeModel);
		return new ResponseEntity<>(
				Response.builder().response(response).status(HttpStatus.OK.toString()).build(),
				HttpStatus.OK);

	}
	
	@GetMapping("/applicationparameter/{appID}")
	public ResponseEntity<Response> getAllApplications(@PathVariable("appID") Integer appID){
		
		FeedbackModel response = 	feedBackService.getConfigurationForApplication(appID);
		return new ResponseEntity<>(
				Response.builder().response(response).status(HttpStatus.OK.toString()).build(),
				HttpStatus.OK);

	}
}
