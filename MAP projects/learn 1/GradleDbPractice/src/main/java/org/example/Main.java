package org.example;

import org.example.domain.Student;
import org.example.repository.Repository;
import org.example.repository.db.RepositoryDbStudent;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/testDb";
        String username = "postgres";
                                                                                                                        String password = "CripiFace2";

        Repository<Long, Student> repoDb = new RepositoryDbStudent(url, username, password);
        repoDb.findAll().forEach(System.out::println);

    }
}