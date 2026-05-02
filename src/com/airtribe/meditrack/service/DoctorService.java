package com.airtribe.meditrack.service;

import com.airtribe.meditrack.constants.Specialization;
import com.airtribe.meditrack.entities.Doctor;
import com.airtribe.meditrack.entities.Patient;
import com.airtribe.meditrack.interfaces.Searchable;
import com.airtribe.meditrack.util.DataStore;

import java.util.List;

public class DoctorService implements Searchable{
    private DataStore<Doctor> doctorSOR;

    public DoctorService(){
        doctorSOR= new DataStore<>();
    }

    public void addDoctor(Doctor doctor){
        doctorSOR.addData(doctor.getPersonId(), doctor);
    }
    public List<Doctor> getAllDoctors(){
        return doctorSOR.getAllData();
    }

    public void removeDoctor(int id){
        doctorSOR.remove(id);
    }

    @Override
    public List<Doctor> searchByName(String name) {
        return doctorSOR.getAllData()
                .stream()
                .filter(p->p.getPersonName().equalsIgnoreCase(name))
                .toList();
    }

    @Override
    public List<Doctor> searchById(int id) {
        return doctorSOR.getAllData().stream().filter(p-> p.getPersonId()== id)
                .toList();
    }
    public List<Doctor> getDoctorsBySpecialization(Specialization specialization){
        return doctorSOR.getAllData().stream().
                filter(d->d.getSpecialization().
                        equals(specialization))
                .toList();
    }
}
