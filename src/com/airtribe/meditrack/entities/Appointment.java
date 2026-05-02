package com.airtribe.meditrack.entities;

import com.airtribe.meditrack.constants.AppointmentStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Appointment {

    private int appointmentId;
    private int patientId;
    private int doctorId;
    private LocalDate appointmentDate;
    private AppointmentStatus appointmentStatus;

    public Appointment(int appointmentId, int patientId, int doctorId,
                       LocalDate appointmentDate, AppointmentStatus appointmentStatus) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentStatus = appointmentStatus;
        display(appointmentStatus);
    }

    public void cancelAppointment() {
        this.appointmentStatus = AppointmentStatus.CANCELLED;
        display(appointmentStatus);
    }
    public void confirmAppointment() {
        this.appointmentStatus = AppointmentStatus.CONFIRMED;
        display(appointmentStatus);
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void display(AppointmentStatus appointmentStatus){
        System.out.println("Doctor: "+this.doctorId +
                "and Patient: "+ this.patientId
                +"\nAppointment has been "+appointmentStatus);
    }
}
