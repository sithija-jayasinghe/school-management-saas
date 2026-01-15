package edu.icet.service.impl;

import edu.icet.dto.TeacherDto;
import edu.icet.entity.TeacherEntity;
import edu.icet.repository.TeacherRepository;
import edu.icet.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class teacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public void addTeacher(TeacherDto teacherDto) {
        TeacherEntity teacherEntity = new TeacherEntity();

        teacherEntity.setName(teacherDto.getName());
        teacherEntity.setSchoolId(teacherDto.getSchoolId());
        teacherEntity.setGender(teacherDto.getGender());
        teacherEntity.setPhone(teacherDto.getPhone());
        teacherEntity.setAddress(teacherDto.getAddress());
        teacherEntity.setNic(teacherDto.getNic());
        teacherEntity.setDepartment(teacherDto.getDepartment());

        teacherRepository.save(teacherEntity);
    }

    @Override
    public void deleteTeacher(Integer id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void updateTeacher(TeacherDto teacherDto) {
        TeacherEntity teacherEntity = new TeacherEntity();

        teacherEntity.setId(teacherDto.getId());
        teacherEntity.setName(teacherDto.getName());
        teacherEntity.setSchoolId(teacherDto.getSchoolId());
        teacherEntity.setGender(teacherDto.getGender());
        teacherEntity.setPhone(teacherDto.getPhone());
        teacherEntity.setAddress(teacherDto.getAddress());
        teacherEntity.setNic(teacherDto.getNic());
        teacherEntity.setDepartment(teacherDto.getDepartment());

        teacherRepository.save(teacherEntity);
    }

    @Override
    public List<TeacherDto> searchTeacherByName(String name) {

        List<TeacherEntity> teachers = teacherRepository.findByNameContainingIgnoreCase(name);

        List<TeacherDto> teacherDtoList = new ArrayList<>();

        teachers.forEach(teacherEntity -> {
            TeacherDto teacherDto = new TeacherDto();
            teacherDto.setId(teacherEntity.getId());
            teacherDto.setName(teacherEntity.getName());
            teacherDto.setSchoolId(teacherEntity.getSchoolId());
            teacherDto.setGender(teacherEntity.getGender());
            teacherDto.setPhone(teacherEntity.getPhone());
            teacherDto.setAddress(teacherEntity.getAddress());
            teacherDto.setNic(teacherEntity.getNic());
            teacherDto.setDepartment(teacherEntity.getDepartment());
            teacherDtoList.add(teacherDto);
        });

        return teacherDtoList;
    }


    @Override
    public List<TeacherDto> getAllTeachers() {
        List<TeacherEntity> all = teacherRepository.findAll();
        ArrayList<TeacherDto> teacherDtoList = new ArrayList<>();
        all.forEach(teacherEntity -> {
            TeacherDto teacherDto = new TeacherDto();
            teacherDto.setId(teacherEntity.getId());
            teacherDto.setName(teacherEntity.getName());
            teacherDto.setSchoolId(teacherEntity.getSchoolId());
            teacherDto.setGender(teacherEntity.getGender());
            teacherDto.setPhone(teacherEntity.getPhone());
            teacherDto.setAddress(teacherEntity.getAddress());
            teacherDto.setNic(teacherEntity.getNic());
            teacherDto.setDepartment(teacherEntity.getDepartment());
            teacherDtoList.add(teacherDto);
        });
        return teacherDtoList;
    }

    @Override
    public TeacherDto getTeacherById(Integer id) {
        TeacherDto teacherDto = new TeacherDto();
        TeacherEntity teacherEntity = teacherRepository.findById(id).get();

        teacherDto.setId(teacherEntity.getId());
        teacherDto.setName(teacherEntity.getName());
        teacherDto.setSchoolId(teacherEntity.getSchoolId());
        teacherDto.setGender(teacherEntity.getGender());
        teacherDto.setPhone(teacherEntity.getPhone());
        teacherDto.setAddress(teacherEntity.getAddress());
        teacherDto.setNic(teacherEntity.getNic());
        teacherDto.setDepartment(teacherEntity.getDepartment());

        return teacherDto;
    }
}
