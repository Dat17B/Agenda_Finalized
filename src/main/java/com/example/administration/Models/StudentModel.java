package com.example.administration.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

public class StudentModel
{
    private int studID;
    private String fName, lName, cpr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enrollmentDate;

    public StudentModel()
    {
    }

    public StudentModel(int studID, String fName, String lName, String cpr, Date enrollmentDate)
    {
        this.studID = studID;
        this.fName = fName;
        this.lName = lName;
        this.cpr = cpr;
        this.enrollmentDate = enrollmentDate;
        System.out.println("Model value: " + this.enrollmentDate);
    }

    public String getDateString()
    {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(this.enrollmentDate);
    }

    // Getters
    public int getStudID()
    {
        return studID;
    }
    public String getfName()
    {
        return fName;
    }
    public String getlName()
    {
        return lName;
    }
    public String getCpr()
    {
        return cpr;
    }
    public Date getEnrollmentDate()
    {
        return enrollmentDate;
    }

    // Setters
    public void setStudID(int studID)
    {
        this.studID = studID;
    }
    public void setfName(String fName)
    {
        this.fName = fName;
    }
    public void setlName(String lName)
    {
        this.lName = lName;
    }
    public void setCpr(String cpr)
    {
        this.cpr = cpr;
    }
    public void setEnrollmentDate(Date enrollmentDate)
    {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString()
    {
        return "StudentModel{" +
                "studID=" + studID +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", cpr='" + cpr + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                "}\n";
    }
}
