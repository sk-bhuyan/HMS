package com.hms.payload;

import lombok.Data;

import java.util.List;

@Data
public class PatientDTO {
    private Long id;
    private String name;
    private int age;
    private String gender;
    private String contactInformation;
}
