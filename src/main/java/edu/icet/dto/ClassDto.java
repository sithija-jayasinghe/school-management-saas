package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClassDto {
    private Integer id;
    private Integer schoolId;
    private String grade;
    private String section;
    private String academicYear;
    private Integer teacherId;
}
