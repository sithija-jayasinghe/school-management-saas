package edu.icet.service.impl;

import edu.icet.dto.ParentDto;
import edu.icet.entity.ParentEntity;
import edu.icet.repository.ParentRepository;
import edu.icet.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;
    @Autowired
    ModelMapper mapper;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addParent(ParentDto parentDto) {
        ParentEntity parentEntity = mapper.map(parentDto, ParentEntity.class);
        parentEntity.setId(null);
        parentRepository.save(parentEntity);
    }

    @Override
    public void updateParent(ParentDto parentDto) {
        ParentEntity parent = parentRepository.findById(parentDto.getId()).get();
        mapper.map(parentDto, parent);
        parentRepository.save(parent);
    }

    @Override
    public void deleteParent(Integer id) {
        parentRepository.deleteById(id);
    }

    @Override
    public ParentDto searchParentById(Integer id) {
        return mapper.map(parentRepository.findById(id).get(), ParentDto.class);
    }

    @Override
    public List<ParentDto> getAll() {
        List<ParentEntity> all = parentRepository.findAll();
        return all.stream()
                .map(parentEntity -> modelMapper.map(parentEntity, ParentDto.class))
                .toList();
    }

    @Override
    public List<ParentDto> searchByName(String name) {
        List<ParentEntity> parents = parentRepository.findByNameContainingIgnoreCase(name);
        return parents.stream()
                .map(parentEntity -> modelMapper.map(parentEntity, ParentDto.class))
                .toList();
    }
}
