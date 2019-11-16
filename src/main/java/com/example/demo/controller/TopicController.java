package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.Topic;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.exception.TopicException;
import com.example.demo.exception.TopicExceptionBuilder;
import com.example.demo.service.TopicService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/topic")
@EnableSwagger2
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	private void validateRequest(Topic topic) throws TopicException
	{
		TopicExceptionBuilder topicExceptionBuilder =  new TopicExceptionBuilder().newBuilder( ErrorCodes.REQUEST_IS_NOT_VALID );
		if(topic.getDesc() == null )
		{
		   topicExceptionBuilder.add(ErrorCodes.ContextKeys.TOPIC_DESCRIPTION_MUST_NOT_BE_NULL);
		   topicExceptionBuilder.setErrorFound(true);
		}
		
		if(topic.getName() == null)
		{
			topicExceptionBuilder.add(ErrorCodes.ContextKeys.TOPIC_NAME_MUST_NOT_BE_NULL);
			topicExceptionBuilder.setErrorFound(true);
		}
		
		topicExceptionBuilder.buildAndthrowIfErrorFound();
	}
	
	@RequestMapping( method= RequestMethod.GET, value="/getAllTopics" )
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics();
	}
	
	
	@RequestMapping( method= RequestMethod.GET, value="/getTopicById/{topicId}" )
	public Topic getTopicById(@PathVariable("topicId") int topicId)
	{
		return topicService.getTopicById(topicId);
	}
	
	@RequestMapping( method= RequestMethod.POST, value="/topics" )
	public String addTopic( @RequestBody Topic topic ) throws TopicException
	{
		validateRequest(topic);
		return topicService.addTopic(topic);
	}

	@RequestMapping( method= RequestMethod.PUT, value="/{topicId}" )
	public String updateTopic( @RequestBody Topic topic, @PathVariable("topicId") int topicId ) throws TopicException
	{
		 validateRequest(topic);
		 return topicService.updateTopic(topic, topicId);
	}

	
	@RequestMapping( method= RequestMethod.DELETE, value="/{topicId}" )
	public String deleteTopic( @PathVariable("topicId") int topicId )
	{
		return topicService.deleteTopic(topicId);
	}

	
	
}
