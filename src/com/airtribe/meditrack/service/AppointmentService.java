package com.airtribe.meditrack.service;

import com.airtribe.meditrack.constants.AppointmentStatus;
import com.airtribe.meditrack.entities.Appointment;
import com.airtribe.meditrack.entities.Doctor;
import com.airtribe.meditrack.entities.Patient;
import com.airtribe.meditrack.exception.AppointmentNotFoundException;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.DateUtil;
import com.airtribe.meditrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.List;

public class AppointmentService {

    private DataStore<Appointment> appointmentSOR;

    public AppointmentService(){
        appointmentSOR= new DataStore<>();
    }

    public Appointment createAppointment(int patientId, int doctorId, String dateStr) {

        int id = IdGenerator.getInstance().generateId();
        LocalDate date = DateUtil.parse(dateStr);
        Appointment appointment = new Appointment(
                id,
                patientId,
                doctorId,
                date,
                AppointmentStatus.CONFIRMED
        );
        appointmentSOR.addData(id, appointment);
        return appointment;
    }
    public Appointment getAppointment(int id) {

        Appointment appointment = appointmentSOR.getData(id);

        if (appointment == null) {
            throw new AppointmentNotFoundException(
                    "Appointment not found with id: " + id
            );
        }

        return appointment;
    }

    public List<Appointment> getAllAppointment(){
        return appointmentSOR.getAllData();
    }

    public void cancelAppointment(int appointmentId){
        getAppointment(appointmentId).cancelAppointment();
    }
}
