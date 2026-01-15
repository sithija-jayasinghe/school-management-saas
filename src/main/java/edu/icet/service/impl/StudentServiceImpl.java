package edu.icet.service.impl;

import edu.icet.dto.StudentDto;
import edu.icet.entity.StudentEntity;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    final StudentRepository repository;



    @Override
    public void addStudent(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setName(studentDto.getName());
        studentEntity.setAddress(studentDto.getAddress());
        studentEntity.setAge(studentDto.getAge());
        studentEntity.setClassRoom(studentDto.getClassRoom());
        studentEntity.setGender(studentDto.getGender());
        studentEntity.setSchoolId(studentDto.getSchoolId());
        studentEntity.setPhone(studentDto.getPhone());

        repository.save(studentEntity);

    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setId(studentDto.getId());
        studentEntity.setName(studentDto.getName());
        studentEntity.setAddress(studentDto.getAddress());
        studentEntity.setAge(studentDto.getAge());
        studentEntity.setClassRoom(studentDto.getClassRoom());
        studentEntity.setGender(studentDto.getGender());
        studentEntity.setSchoolId(studentDto.getSchoolId());
        studentEntity.setPhone(studentDto.getPhone());

        repository.save(studentEntity);
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public StudentDto searchStudentById(Integer id) {

        StudentDto studentDto = new StudentDto();
        StudentEntity studentEntity = repository.findById(id).get();

        studentDto.setId(studentEntity.getId());
        studentDto.setName(studentEntity.getName());
        studentDto.setAddress(studentEntity.getAddress());
        studentDto.setAge(studentEntity.getAge());
        studentDto.setClassRoom(studentEntity.getClassRoom());
        studentDto.setGender(studentEntity.getGender());
        studentDto.setSchoolId(studentEntity.getSchoolId());
        studentDto.setPhone(studentEntity.getPhone());

        return studentDto;



    }

    @Override
    public List<StudentDto> getAll() {
        List<StudentEntity> all = repository.findAll();
        ArrayList<StudentDto> studentDtoArrayList = new ArrayList<>();
        all.forEach(studentEntity -> {
            StudentDto studentDto = new StudentDto();
            studentDto.setId(studentEntity.getId());
            studentDto.setName(studentEntity.getName());
            studentDto.setAddress(studentEntity.getAddress());
            studentDto.setAge(studentEntity.getAge());
            studentDto.setClassRoom(studentEntity.getClassRoom());
            studentDto.setGender(studentEntity.getGender());
            studentDto.setSchoolId(studentEntity.getSchoolId());
            studentDto.setPhone(studentEntity.getPhone());

            studentDtoArrayList.add(studentDto);
        });
        return studentDtoArrayList;
    }

    @Override
    public List<StudentDto> searchByName(String name) {

        List<StudentEntity> students = repository.findByNameContainingIgnoreCase(name);

        List<StudentDto> studentDtoList = new ArrayList<>();

        students.forEach(studentEntity -> {
            StudentDto studentDto = new StudentDto();
            studentDto.setId(studentEntity.getId());
            studentDto.setName(studentEntity.getName());
            studentDto.setAddress(studentEntity.getAddress());
            studentDto.setAge(studentEntity.getAge());
            studentDto.setClassRoom(studentEntity.getClassRoom());
            studentDto.setGender(studentEntity.getGender());
            studentDto.setSchoolId(studentEntity.getSchoolId());
            studentDto.setPhone(studentEntity.getPhone());

            studentDtoList.add(studentDto);
        });

        return studentDtoList;
    }

}
