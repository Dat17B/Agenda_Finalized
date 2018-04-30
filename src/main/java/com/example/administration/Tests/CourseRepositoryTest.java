package com.example.administration.Tests;

import com.example.administration.Interfaces.CourseInterface;
import com.example.administration.Models.CourseModel;
import com.example.administration.Repositories.CourseRepository;
import com.example.administration.Static.DAOConfig;

import java.time.LocalDate;
import java.util.Date;

public class CourseRepositoryTest
{
    private static CourseInterface repository;
    private static DAOConfig config;

    public static void main(String[] args)
    {
        config = new DAOConfig();
        repository = new CourseRepository(config.getDataSource());
        CourseModel course = new CourseModel(2, 5, "Delete Me again", new Date(2018-07-01));
        System.out.println("Start model: " + course);
        //System.out.println("Insert done: " + repository.insert(course));
        //System.out.println("Update done: " + repository.update(course));
        //System.out.println("Delete done: " + repository.delete(4));
        System.out.println("get() list of courses");
        System.out.println(repository.get());
        System.out.println("get(int) a course");
        System.out.println(repository.get(1));
    }
}
