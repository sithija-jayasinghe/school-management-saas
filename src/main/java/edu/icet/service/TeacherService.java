package edu.icet.service;

import edu.icet.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    void addTeacher(TeacherDto teacherDto);
    void deleteTeacher(Integer id);
    void updateTeacher(TeacherDto teacherDto);
    List<TeacherDto> searchTeacherByName(String name);
    List<TeacherDto> getAllTeachers();
    TeacherDto getTeacherById(Integer id);
}
