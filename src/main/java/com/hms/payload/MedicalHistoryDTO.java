package com.hms.payload;

import lombok.Data;

import java.util.Date;

@Data
public class MedicalHistoryDTO {
    private Long id;
    private String details;
    private Date date;
}
