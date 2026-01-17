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
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer schoolId;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phone;
    private String address;
    private String nic;
    private String department;
}
