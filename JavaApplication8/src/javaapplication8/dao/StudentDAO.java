package javaapplication8.dao;

import javaapplication8.context.DBContext;
import javaapplication8.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements StudentService{
    Connection conn;

    public StudentDAO() throws Exception {
        this.conn = new DBContext().getConnection();
    }

    PreparedStatement ps = null;
    ResultSet rs = null;
    public ResultSet getQuery(String query) throws Exception {
        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();
        return rs;
    }

    @Override
    public List<Student> getAll() throws Exception {
        ResultSet rs = getQuery("select * from students");
        List<Student> list = new ArrayList<>();
        while(rs.next()){
            list.add(new Student(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getFloat(4)));
        }
        return list;
    }

    @Override
    public Student Add(Student input) throws Exception {
        String query = "insert into students (id , name,idClass , gpa) values (?,?,?,?)";
        ps = conn.prepareStatement(query);
        ps.setString(1 , input.getId());
        ps.setString(2 , input.getName());
        ps.setString(3 , input.getClasss());
        ps.setFloat(4 , input.getGpa());
        ps.executeUpdate();
        return null;
    }

    @Override
    public Student Update(String id , Student input) {
        String query = "update students set name = (?) , idClass = (?) , gpa = (?) where id = (?)";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1 , input.getName());
            ps.setString(2 , input.getClasss());
            ps.setFloat(3 , input.getGpa());
            ps.setString(4 , id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Student GetByID(String id) throws Exception {
        String query = "select * from students where id = (?)";
        ps = conn.prepareStatement(query);
        ps.setString(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            return new Student(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getFloat(4));
        }
        return null;
    }
    @Override
    public void Delete(String id) {
        String query = "delete from students where id = (?)";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1 , id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void DeleteAll() {
        String query = "delete from students";
        try {
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
