package edu.icet.entity;

import edu.icet.util.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer schoolId;
    private Integer classId;
    private String name;
    private String address;
    private String phone;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
