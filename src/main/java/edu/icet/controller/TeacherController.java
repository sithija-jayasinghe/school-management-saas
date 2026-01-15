package edu.icet.controller;

import edu.icet.dto.TeacherDto;
import edu.icet.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/add")
    public void addTeacher(@RequestBody TeacherDto teacherDto) {
        teacherService.addTeacher(teacherDto);
    }

    @PutMapping("/update")
    public void updateTeacher(@RequestBody TeacherDto teacherDto) {
        teacherService.updateTeacher(teacherDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
    }

    @GetMapping("/get-by-id/{id}")
    public TeacherDto getTeacherById(@PathVariable Integer id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/get-all")
    public List<TeacherDto> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/get-all-by-name/{name}")
    public List<TeacherDto> getAllTeachersByName(@PathVariable String name) {
        return teacherService.searchTeacherByName(name);
    }
}
