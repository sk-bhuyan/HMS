package com.hms.controller;

import com.hms.payload.AppointmentDTO;
import com.hms.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/")
public class AppointmentController {

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService=appointmentService;
    }

    @PostMapping("/patients/{id}/appointments")
    public ResponseEntity<AppointmentDTO> addAppointmentToPatient(@PathVariable(value = "id")Long id,@RequestBody AppointmentDTO appointmentDTO){
        AppointmentDTO appointment = appointmentService.createAppointment(id, appointmentDTO);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }
}
