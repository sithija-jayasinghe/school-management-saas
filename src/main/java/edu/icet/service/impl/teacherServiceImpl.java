package edu.icet.service.impl;

import edu.icet.dto.TeacherDto;
import edu.icet.entity.TeacherEntity;
import edu.icet.repository.TeacherRepository;
import edu.icet.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class teacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    @Autowired
    ModelMapper mapper;
    @Override
    public void addTeacher(TeacherDto teacherDto) {
        TeacherEntity teacherEntity = mapper.map(teacherDto,TeacherEntity.class);
        teacherRepository.save(teacherEntity);
    }

    @Override
    public void deleteTeacher(Integer id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void updateTeacher(TeacherDto teacherDto) {
        TeacherEntity teacherEntity = mapper.map(teacherDto,TeacherEntity.class);
        teacherRepository.save(teacherEntity);
    }

    @Override
    public List<TeacherDto> searchTeacherByName(String name) {

        List<TeacherEntity> teachers = teacherRepository.findByNameContainingIgnoreCase(name);
        List<TeacherDto> teacherDtoList = new ArrayList<>();

        teachers.forEach(teacherEntity -> {
            TeacherDto teacherDto = mapper.map(teacherEntity,TeacherDto.class);
            teacherDtoList.add(teacherDto);
        });

        return teacherDtoList;
    }


    @Override
    public List<TeacherDto> getAllTeachers() {
        List<TeacherEntity> all = teacherRepository.findAll();
        ArrayList<TeacherDto> teacherDtoList = new ArrayList<>();

        all.forEach(teacherEntity -> {
            TeacherDto teacherDto = mapper.map(teacherEntity,TeacherDto.class);
            teacherDtoList.add(teacherDto);
        });
        return teacherDtoList;
    }

    @Override
    public TeacherDto getTeacherById(Integer id) {
        TeacherEntity teacherEntity = teacherRepository.findById(id).get();
        return mapper.map(teacherEntity, TeacherDto.class);
    }
}
