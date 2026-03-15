package com.example.studentcrud.service;

import com.example.studentcrud.entity.Student;
import com.example.studentcrud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student addStudent(Student student) {
        return repo.save(student);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

    public Student updateStudent(Long id, Student s) {
        Student student = repo.findById(id).orElseThrow();
        student.setName(s.getName());
        student.setEmail(s.getEmail());
        student.setCourse(s.getCourse());
        return repo.save(student);
    }
}
