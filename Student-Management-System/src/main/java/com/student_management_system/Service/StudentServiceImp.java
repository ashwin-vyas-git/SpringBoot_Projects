package com.student_management_system.Service;

import com.student_management_system.Model.Student;
import com.student_management_system.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getById(int id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        studentRepo.deleteById(id);
    }
}
