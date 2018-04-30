package com.example.administration.Repositories;

import com.example.administration.Interfaces.CourseInterface;
import com.example.administration.Models.CourseModel;
import com.example.administration.Static.DAOConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository implements CourseInterface
{
    @Autowired
    private JdbcTemplate template;
    private DAOConfig config = new DAOConfig();

    // For mapping Spring
    public CourseRepository() {
        this.template = new JdbcTemplate(config.getDataSource());
    }
    // Testing constructor
    public CourseRepository(JdbcTemplate template) { this.template = template; }
    public CourseRepository(DataSource dataSource) { this.template = new JdbcTemplate(dataSource); }

    @Override
    public boolean insert(CourseModel entity)
    {
        String sql = "insert into courses values(?, ?, ?, ?)";
        Boolean result = false;
        try
        {
            template.execute(sql + "", new PreparedStatementCallback<Boolean>()
            {
                @Nullable
                @Override
                public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException
                {
                    preparedStatement.setInt(1, entity.getCourseID());
                    preparedStatement.setString(2, entity.getTitle());
                    preparedStatement.setInt(3, entity.getETCS());
                    preparedStatement.setString(4, entity.getDateString());

                    return !preparedStatement.execute();
                }
            });

            result = true;
        } catch(DataIntegrityViolationException eDIV) {
            eDIV.printStackTrace();
        } finally {
            return result;
        }
    }

    @Override
    public boolean update(CourseModel entity)
    {
        // Setup
        String query = "update Courses Set Title=?, ETCS=?, StartDate=? where courseID=?";
        Object[] params = {entity.getTitle(), entity.getETCS(), entity.getStartDate(), entity.getCourseID()};
        int[] types = {Types.VARCHAR, Types.INTEGER, Types.DATE, Types.INTEGER};
        // Execute
        int rows = template.update(query, params, types);
        // Test
        if (rows > 0)
        {
            System.out.println("Rows updated = " + rows);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id)
    {
        int rows = template.update("Delete from Courses where courseID=" + id);
        if (rows > 0) {
            System.out.println("Rows Deleted = " + rows);
            return true;
        }
        return false;
    }

    @Override
    public List<CourseModel> get()
    {
        List<CourseModel> list = new ArrayList<>();
        String query = "Select * from Courses";
        SqlRowSet result = template.queryForRowSet(query);
        while (result.next())
            list.add(new CourseModel(result.getInt(1), result.getInt(3), result.getString(2), result.getDate(4)));
        return list;
    }

    @Override
    public CourseModel get(int id)
    {
        String query = "Select * from Courses where courseID=" + id;
        SqlRowSet result = template.queryForRowSet(query);
        result.next();
        return new CourseModel(result.getInt(1), result.getInt(3), result.getString(2), result.getDate(4));
    }
}
