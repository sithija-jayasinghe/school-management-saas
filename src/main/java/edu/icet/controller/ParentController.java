package edu.icet.controller;

import edu.icet.dto.ParentDto;
import edu.icet.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parent")
@RequiredArgsConstructor
public class ParentController {
    final ParentService parentService;

    @PostMapping("/add")
    public void addParent(@RequestBody ParentDto parentDto) {parentService.addParent(parentDto);}

    @PutMapping("/update")
    public void updateParent(@RequestBody ParentDto parentDto) {parentService.updateParent(parentDto);}

    @DeleteMapping("/delete/{id}")
    public void deleteParent(@PathVariable Integer id) {parentService.deleteParent(id);}

    @GetMapping("/get-by-id/{id}")
    public ParentDto searchParentById(@PathVariable Integer id) {return parentService.searchParentById(id);}

    @GetMapping("/get-all-by-name/{name}")
    public List<ParentDto> getAllByName(@PathVariable String name) {return parentService.searchByName(name);}

    @GetMapping("/get-all")
    public List<ParentDto> getAllParents() {return parentService.getAll();}
}