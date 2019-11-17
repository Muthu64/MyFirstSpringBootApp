package com.example.demo.controller;

import com.example.demo.DTO.Topic;
import com.example.demo.exception.ErrorCodes;
import com.example.demo.exception.TopicException;
import com.example.demo.exception.TopicExceptionBuilder;
import com.example.demo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController implements TopicInterface
{

    @Autowired
    private TopicService topicService;

    private void validateRequest( Topic topic ) throws TopicException
    {
        TopicExceptionBuilder topicExceptionBuilder = new TopicExceptionBuilder().newBuilder( ErrorCodes.REQUEST_IS_NOT_VALID );
        if (topic.getDesc() == null) {
            topicExceptionBuilder.add( ErrorCodes.ContextKeys.TOPIC_DESCRIPTION_MUST_NOT_BE_NULL );
            topicExceptionBuilder.setErrorFound( true );
        }

        if (topic.getName() == null) {
            topicExceptionBuilder.add( ErrorCodes.ContextKeys.TOPIC_NAME_MUST_NOT_BE_NULL );
            topicExceptionBuilder.setErrorFound( true );
        }

        topicExceptionBuilder.buildAndthrowIfErrorFound();
    }

    @Override
    public List<Topic> getAllTopics()
    {
        return topicService.getAllTopics();
    }

    @Override
    public Topic getTopicById( int topicId )
    {
        return topicService.getTopicById( topicId );
    }

    @Override
    public String addTopic( Topic topic ) throws TopicException
    {
        validateRequest( topic );
        return topicService.addTopic( topic );
    }

    @Override
    public String updateTopic( Topic topic, int topicId ) throws TopicException
    {
        validateRequest( topic );
        return topicService.updateTopic( topic, topicId );
    }

    @Override
    public String deleteTopic( int topicId )
    {
        return topicService.deleteTopic( topicId );
    }


}
