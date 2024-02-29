package day_4_ce_4.ex_4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Patient {
    @Id
    private int patientld ;
private String patientName ;
private String doctorName ;
private String disease ;
private String medication;
public Patient(int patientld, String patientName, String doctorName, String disease, String medication) {
    this.patientld = patientld;
    this.patientName = patientName;
    this.doctorName = doctorName;
    this.disease = disease;
    this.medication = medication;
}
public Patient() {
}
public int getPatientld() {
    return patientld;
}
public void setPatientld(int patientld) {
    this.patientld = patientld;
}
public String getPatientName() {
    return patientName;
}
public void setPatientName(String patientName) {
    this.patientName = patientName;
}
public String getDoctorName() {
    return doctorName;
}
public void setDoctorName(String doctorName) {
    this.doctorName = doctorName;
}
public String getDisease() {
    return disease;
}
public void setDisease(String disease) {
    this.disease = disease;
}
public String getMedication() {
    return medication;
}
public void setMedication(String medication) {
    this.medication = medication;
}

}
