package com.example.demo.service;

import com.example.demo.DTO.Topic;
import com.example.demo.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService
{

    @Autowired
    private TopicRepository topicRepository;

    public static List<Topic> topicList = new ArrayList<Topic>();


    public List<Topic> getAllTopics()
    {
        List<Topic> topicList = new ArrayList<>();

        topicRepository.findAll().forEach( topicList::add );
        //topicRepository.deleteRowsByTopicName("saran");
        return topicList;
    }


    public Topic getTopicById( int topicId )
    {
        return topicRepository.findById( topicId ).get();
    }

    public String addTopic( Topic topic )
    {
        topicRepository.save( topic );
        return "Topic added successfully";

    }

    public String updateTopic( Topic topic, int topicId )
    {
        String resultMessage = null;
        /*
         * Topic topicFromList = TopicService.topicList.stream().filter( topics ->
         * topics.getId() == topicId ).findFirst().get(); int index =
         * TopicService.topicList.indexOf(topicFromList);
         * TopicService.topicList.set(index, topic);
         */

        boolean isPresent = topicRepository.existsById( topicId );
        if (isPresent) {
            topicRepository.save( topic );
            resultMessage = "Topic updated successfully";
        } else {
            resultMessage = "Nothing to update";
        }
        return resultMessage;
    }

    public String deleteTopic( int topicId )
    {
        String resultMessage = null;
        Topic topicDTO = topicRepository.findById( topicId ).orElse( null );

        if (topicDTO != null) {
            topicRepository.delete( topicDTO );
            resultMessage = "Topic deleted successfully";
        } else {
            resultMessage = "Nothing to delete";
        }

        return resultMessage;
    }

}
