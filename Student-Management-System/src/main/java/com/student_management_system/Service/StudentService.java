package com.student_management_system.Service;

import com.student_management_system.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student>getAllStudents();
    public Student saveStudent(Student student);
    public Student getById(int id);
    public void deleteById(int id);
}
