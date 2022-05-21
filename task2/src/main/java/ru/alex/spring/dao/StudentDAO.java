package ru.alex.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alex.spring.models.Student;

import java.util.List;

@Component
public class StudentDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> index(){
        return jdbcTemplate.query(
                "SELECT * from student", new StudentRowMapper());
    }

    public Student show(int id){
        return jdbcTemplate.query(
                "SELECT * from student where id=?",
                        new Object[]{id}, new StudentRowMapper())
                        .stream().findAny().orElse(null);
    }

    public void save(Student student){
        jdbcTemplate.update(
                "INSERT INTO student values (?,?,?,?,?,?)",
                student.getName(),student.getSurname(), student.getMiddleName(),
                student.getDate(), student.getGr(), student.getId());
    }

    public void update(int id, Student updateStudent){
        jdbcTemplate.update("UPDATE student set name=?, surname=?, middlename=?, " +
                        "date=?, gr=? where id=?",
                updateStudent.getName(), updateStudent.getSurname(), updateStudent.getMiddleName(),
                updateStudent.getDate(), updateStudent.getGr(),  id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE from student where id=?", id);
    }
}
