package com.airtribe.meditrack.main;

import com.airtribe.meditrack.entities.*;
import com.airtribe.meditrack.constants.Specialization;
import com.airtribe.meditrack.service.*;
import com.airtribe.meditrack.util.IdGenerator;

import java.util.List;
import java.util.Scanner;

        public class Main {

            public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);

                PatientService patientService = new PatientService();
                DoctorService doctorService = new DoctorService();
                AppointmentService appointmentService = new AppointmentService();

                while (true) {
                    System.out.println("\n===== MediTrack Menu =====");
                    System.out.println("1. Add Patient");
                    System.out.println("2. Add Doctor");
                    System.out.println("3. View Patients");
                    System.out.println("4. View Doctors");
                    System.out.println("5. Create Appointment");
                    System.out.println("6. View Appointments");
                    System.out.println("7. Cancel Appointment");
                    System.out.println("8. Search Doctor by Specialization");
                    System.out.println("9. Generate Bill");
                    System.out.println("0. Exit");

                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {

                        case 1:
                            System.out.print("Enter name: ");
                            String pname = sc.nextLine();

                            System.out.print("Enter age: ");
                            int page = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter gender: ");
                            char pgender = sc.nextLine().charAt(0);

                            int pid = IdGenerator.getInstance().generateId();
                            //String personId, String personName, char gender, int age
                            Patient patient = new Patient(pid, pname, pgender, page);
                            patientService.addPatient(patient);

                            System.out.println("Patient added!");
                            break;

                        case 2:
                            System.out.print("Enter name: ");
                            String dname = sc.nextLine();

                            System.out.print("Enter age: ");
                            int dage = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter gender: ");
                            String dgender = sc.nextLine();

                            System.out.print("Enter fee: ");
                            double fee = sc.nextDouble();
                            sc.nextLine();

                            System.out.print("Enter experience: ");
                            float exp = sc.nextFloat();
                            sc.nextLine();

                            System.out.print("Enter specialization (CARDIOLOGIST, DERMATOLOGIST...): ");
                            Specialization spec = Specialization.valueOf(sc.nextLine().toUpperCase());

                            int did = IdGenerator.getInstance().generateId();

                            Doctor doctor = new Doctor(did, dname,spec, fee, exp);
                            doctorService.addDoctor(doctor);

                            System.out.println("Doctor added!");
                            break;

                        case 3:
                            patientService.getAllPatients()
                                    .forEach(Patient::display);
                            break;

                        case 4:
                            doctorService.getAllDoctors()
                                    .forEach(Doctor::display);
                            break;

                        case 5:
                            System.out.print("Enter patient ID: ");
                            int patId = sc.nextInt();

                            System.out.print("Enter doctor ID: ");
                            int docId = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter date (dd-MM-yyyy): ");
                            String date = sc.nextLine();

                            Appointment appt = appointmentService.createAppointment(
                                    patId,
                                    docId,
                                    date
                            );

                            System.out.println("Appointment created: " + appt.getAppointmentId());
                            break;

                        case 6:
                            appointmentService.getAllAppointment()
                                    .forEach(System.out::println);
                            break;

                        case 7:
                            System.out.print("Enter appointment ID: ");
                            int aid = sc.nextInt();

                            appointmentService.cancelAppointment(aid);

                            System.out.println("Appointment cancelled");
                            break;

                        case 8:
                            System.out.print("Enter specialization: ");
                            Specialization s = Specialization.valueOf(sc.nextLine().toUpperCase());

                            List<Doctor> doctors =
                                    doctorService.getDoctorsBySpecialization(s);

                            doctors.forEach(Doctor::display);
                            break;

                        case 9:
                            System.out.print("Enter patient ID: ");
                            int billPid = sc.nextInt();

                            List<Patient> p = patientService.searchById(billPid);

                            Bill bill = new Bill(
                                    IdGenerator.getInstance().generateId(),
                                    p.get(0),
                                    1000
                            );

                            double total = bill.calculateTotal();

                            BillSummary summary =
                                    new BillSummary(bill.getBillId(), total);

                            System.out.println(summary);
                            break;

                        case 0:
                            System.out.println("Exiting...");
                            return;

                        default:
                            System.out.println("Invalid choice");
                    }
                }
            }
        }

