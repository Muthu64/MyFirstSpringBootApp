package com.example.demo.repository;


import com.example.demo.DTO.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer>
{

//	@Query("DELETE FROM TABLENAME WHERE TOPIC_NAME=:name")
//	public int deleteRowsByTopicName(String name);
//	
}
