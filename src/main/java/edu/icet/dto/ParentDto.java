package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ParentDto {
    private Integer id;
    private Integer schoolId;
    private String name;
    private String address;
    private String phone;
    private String nic;
    private String relation;
}
