package com.example.administration.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CourseModel
{
    private int courseID, ETCS;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    public CourseModel()
    {
    }

    public CourseModel(int courseID, int ETCS, String title, Date startDate)
    {
        this.courseID = courseID;
        this.ETCS = ETCS;
        this.title = title;
        this.startDate = startDate;
    }

    // Getters and Setters
    public int getCourseID()
    {
        return courseID;
    }
    public void setCourseID(int courseID)
    {
        this.courseID = courseID;
    }
    public int getETCS()
    {
        return ETCS;
    }
    public void setETCS(int ETCS)
    {
        this.ETCS = ETCS;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public Date getStartDate()
    {
        return startDate;
    }
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }
    public void setStartDate(String date)
    {
        try {
            this.startDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException eP) {
            this.startDate = new Date(2001-01-01);
            eP.printStackTrace();
        }
    }

    // Date converter
    public String getDateString() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(this.startDate);
    }

    // To string
    @Override
    public String toString()
    {
        return "CourseModel{" +
                "courseID=" + courseID +
                ", ETCS=" + ETCS +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", startDateStr=" + getDateString() +
                "}\n";
    }
}
