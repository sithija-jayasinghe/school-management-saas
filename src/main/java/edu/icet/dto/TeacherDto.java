package edu.icet.dto;

import edu.icet.util.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TeacherDto {
    private Integer id;
    private Integer schoolId;
    private String name;
    private Gender gender;
    private String phone;
    private String address;
    private String nic;
    private String department;
}
