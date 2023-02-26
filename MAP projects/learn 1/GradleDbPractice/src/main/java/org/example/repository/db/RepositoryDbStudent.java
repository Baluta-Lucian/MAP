package org.example.repository.db;

import org.example.domain.Student;
import org.example.repository.Repository;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class RepositoryDbStudent implements Repository<Long, Student> {

    private String url;

    private String username;

    private String password;

    public RepositoryDbStudent(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public Optional<Student> findOne(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Iterable<Student> findAll() {
        Set<Student> students = new HashSet<>();

        try(Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * from students");
            ResultSet resultSet = statement.executeQuery()){

            while(resultSet.next()){
                Long id = resultSet.getLong("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                Student student = new Student(firstName, lastName);
                student.setID(id);
                students.add(student);
            }
            return students;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return students;

    }

    @Override
    public Optional<Student> delete(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<Student> update(Student entity) {
        return Optional.empty();
    }
}
