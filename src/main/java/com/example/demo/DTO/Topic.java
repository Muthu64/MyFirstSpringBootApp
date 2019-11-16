package com.example.demo.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "topic" )
public class Topic
{

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "topic_id" )
    private int id;

    @Column( name = "topic_name" )
    private String name;

    @Column( name = "topic_desc" )
    private String desc;

    public Topic()
    {

    }

    public Topic( int id, String name, String desc )
    {
        super();
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDesc()
    {
        return desc;
    }


}
