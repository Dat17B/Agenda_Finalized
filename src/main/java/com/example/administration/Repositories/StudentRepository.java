package com.example.administration.Repositories;

import com.example.administration.Interfaces.StudentInterface;
import com.example.administration.Models.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements StudentInterface
{
    @Autowired
    private JdbcTemplate jdbc;

    public StudentRepository(DataSource dataSource)
    {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean insert(StudentModel entity)
    {
        System.out.println(entity);
        int insert = jdbc.update("INSERT INTO students(fName, lName, cpr, enrollmentDate) " +
                "values('" + entity.getfName() + "', '" + entity.getlName() +
                "', '" + entity.getCpr() + "', '" + entity.getDateString() + "')");
        System.out.println(insert);
        if (insert != 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(StudentModel entity)
    {
        int update = jdbc.update("Update students " +
                "SET fName= '" + entity.getfName() + "', lName= '" + entity.getlName() + "'" +
                ", cpr='" + entity.getCpr() + "', enrollmentDate='" + entity.getDateString() + "' " +
                "where studID = " + entity.getStudID());
        System.out.println(update);
        if (update != 0)
            return true;
        return false;
    }

    @Override
    public boolean delete(int id)
    {
        int delete = jdbc.update("DELETE FROM students where studID=" + id);
        if (delete != 0)
            return true;
        return false;
    }

    @Override
    public List<StudentModel> get()
    {
        List<StudentModel> students = new ArrayList<>();
        SqlRowSet rowSet = jdbc.queryForRowSet("SELECT * From students");

        while (rowSet.next())
            students.add(new StudentModel(rowSet.getInt("studID"), rowSet.getString("fName"), rowSet.getString("lName"), rowSet.getString("cpr"), rowSet.getDate("enrollmentDate")));

        return students;
    }

    @Override
    public StudentModel get(int id)
    {
        SqlRowSet rowSet = jdbc.queryForRowSet("SELECT * From students where studID=" + id);
        rowSet.next();

        return new StudentModel(rowSet.getInt("studID"), rowSet.getString("fName"), rowSet.getString("lName"), rowSet.getString("cpr"), rowSet.getDate("enrollmentDate"));
    }
}
