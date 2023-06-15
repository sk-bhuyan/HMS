package com.hms.payload;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentDTO {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private String doctor;
    private String status;
}
