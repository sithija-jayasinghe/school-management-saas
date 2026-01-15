package edu.icet.service;

import edu.icet.dto.StudentDto;

import java.util.List;

public interface StudentService {
    void addStudent(StudentDto studentDto);

    void updateStudent(StudentDto studentDto);

    void deleteStudent(Integer id);

    StudentDto searchStudentById(Integer id);

    List<StudentDto> getAll();

    List<StudentDto> searchByName(String name);
}
