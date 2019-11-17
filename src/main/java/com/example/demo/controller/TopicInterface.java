package com.example.demo.controller;

import com.example.demo.DTO.Topic;
import com.example.demo.exception.TopicException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@EnableSwagger2
public interface TopicInterface
{
    @RequestMapping( method= RequestMethod.GET, value="/getAllTopics" )
    List<Topic> getAllTopics();

    @RequestMapping( method= RequestMethod.GET, value="/getTopicById/{topicId}" )
    Topic getTopicById(@PathVariable("topicId") int topicId);

    @RequestMapping( method= RequestMethod.POST, value="/topics" )
    String addTopic( @RequestBody Topic topic ) throws TopicException;

    @RequestMapping( method= RequestMethod.PUT, value="/{topicId}" )
    String updateTopic( @RequestBody Topic topic, @PathVariable("topicId") int topicId ) throws TopicException;

    @RequestMapping( method= RequestMethod.DELETE, value="/{topicId}" )
    String deleteTopic( @PathVariable("topicId") int topicId );
}
