package edu.icet.service.impl;

import edu.icet.dto.StudentDto;
import edu.icet.entity.StudentEntity;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    final StudentRepository repository;

    @Autowired
    ModelMapper mapper;
    @Override
    public void addStudent(StudentDto studentDto) {
        StudentEntity studentEntity = mapper.map(studentDto, StudentEntity.class);
        repository.save(studentEntity);
    }

    @Override
    public void updateStudent(StudentDto studentDto) {

        StudentEntity student = repository.findById(studentDto.getId()).get();

        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        student.setGender(studentDto.getGender());
        student.setAddress(studentDto.getAddress());
        student.setClassRoom(studentDto.getClassRoom());
        student.setPhone(studentDto.getPhone());
        student.setSchoolId(studentDto.getSchoolId());

        repository.save(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public StudentDto searchStudentById(Integer id) {

        StudentEntity studentEntity = repository.findById(id).get();
        StudentDto studentDto = mapper.map(studentEntity, StudentDto.class);
        return studentDto;
    }

    @Override
    public List<StudentDto> getAll() {
        List<StudentEntity> all = repository.findAll();
        ArrayList<StudentDto> studentDtoArrayList = new ArrayList<>();

        all.forEach(studentEntity -> {
            StudentDto studentDto = mapper.map(studentEntity, StudentDto.class);
            studentDtoArrayList.add(studentDto);
        });
        return studentDtoArrayList;
    }

    @Override
    public List<StudentDto> searchByName(String name) {
        List<StudentEntity> students = repository.findByNameContainingIgnoreCase(name);
        List<StudentDto> studentDtoList = new ArrayList<>();

        students.forEach(studentEntity -> {
            StudentDto studentDto = mapper.map(studentEntity, StudentDto.class);
            studentDtoList.add(studentDto);
        });

        return studentDtoList;
    }

}
