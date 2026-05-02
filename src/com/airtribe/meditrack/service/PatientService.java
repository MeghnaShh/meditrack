package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entities.Doctor;
import com.airtribe.meditrack.entities.Patient;
import com.airtribe.meditrack.interfaces.Searchable;
import com.airtribe.meditrack.util.DataStore;

import java.util.List;

public class PatientService implements Searchable {

    private DataStore<Patient> patientSOR;

    public PatientService(){
        patientSOR= new DataStore<>();
    }

    public void addPatient(Patient patient){
        patientSOR.addData(patient.getPersonId(), patient);
    }

    public void removePatient(int id){
        patientSOR.remove(id);
    }
    public List<Patient> getAllPatients(){
        return patientSOR.getAllData();
    }
    @Override
    public List<Patient> searchByName(String name) {
        return patientSOR.getAllData()
                .stream()
                .filter(p->p.getPersonName().equalsIgnoreCase(name))
                .toList();
    }

    @Override
    public List<Patient> searchById(int id) {
        return patientSOR.getAllData().stream().filter(p-> p.getPersonId()== id)
                .toList();
    }


    public List<Patient> searchByAge(int age) {
        return patientSOR.getAllData().stream().filter(p-> p.getAge()== age)
                .toList();
    }
}
