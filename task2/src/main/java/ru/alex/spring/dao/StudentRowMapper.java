package ru.alex.spring.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.alex.spring.models.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        Student student = new Student();

        student.setName(rs.getString("name"));
        student.setSurname(rs.getString("surname"));
        student.setMiddleName(rs.getString("middleName"));
        student.setDate(rs.getString("date"));
        student.setGr(rs.getInt("gr"));
        student.setId(rs.getInt("id"));

        return student;
    }
}
