package edu.icet.service;

import edu.icet.dto.ParentDto;

import java.util.List;

public interface ParentService {
    void addParent(ParentDto parentDto);
    void updateParent(ParentDto parentDto);
    void deleteParent(Integer id);
    ParentDto searchParentById(Integer id);
    List<ParentDto> getAll();
    List<ParentDto> searchByName(String name);
}
