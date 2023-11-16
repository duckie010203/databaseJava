package javaapplication8.dao;

import javaapplication8.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    List<Student> getAll() throws Exception;
    Student Add(Student input) throws Exception;
    Student Update(String id , Student input);
    Student GetByID(String id) throws Exception;
    void Delete(String id);
    void DeleteAll();
}
