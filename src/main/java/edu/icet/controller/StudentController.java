package edu.icet.controller;

import edu.icet.dto.StudentDto;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    final StudentService studentService;

    @PostMapping("/add")
    public void addStudent(@RequestBody StudentDto student){
        studentService.addStudent(student);
    }

    @PutMapping("/update")
    public void updateStudent(@RequestBody StudentDto studentDto){
        studentService.updateStudent(studentDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/get-by-id/{id}")
    public StudentDto searchStudentById(@PathVariable Integer id){
       return studentService.searchStudentById(id);
    }

    @GetMapping("/get-all")
    public List<StudentDto> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/get-all-by-name/{name}")
    public List<StudentDto> getAllByName(@PathVariable String name){
       return studentService.searchByName(name);
    }
}
