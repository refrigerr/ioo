package Main;

import Hospital.Department;
import Hospital.Room;
import Patients.MedicalRecord;
import Patients.Patient;
import Users.Doctor;
import Users.User;
import Interface.UI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ApplicationInstance {
    public static ArrayList<Patient> patients = new ArrayList<>();
    public static HashMap<Patient, MedicalRecord> medicalRecords = new HashMap<>();

    public static ArrayList<Department> departments = new ArrayList<>();

    public static void main(String[] args) {
        Room room = new Room(1);
        Patient patient = new Patient("cos","test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true);
        room.addPatient(patient);
        System.out.println(room.getBedByPatient(patient).getPatient().getName());
    }

    public static Patient getPatientById(int id){
        for (Patient p: patients){
            if(p.getId()==id){
                return p;
            }
        }
        return null;
    }

    public static Patient getPatientByPesel(String pesel){
        for(Patient p: patients){
            if(p.getPesel().equals(pesel)){
                return p;
            }
        }
        return null;
    }
    public static Patient getPatientByFullname(String name, String surname){
        for(Patient p: patients){
            if (p.getName().equals(name) && p.getSurname().equals(surname))
                return p;
        }

        return null;
    }

    public static boolean patientExists(Patient patient){
        for (Patient patient1: patients){
            if (patient1.equals(patient))
                return true;
        }
        return false;
    }

    public static MedicalRecord getPatientsMedicalRecord(Patient patient){
        return medicalRecords.get(patient);
    }

    public static void addMedicalRecord(Patient patient){
        medicalRecords.put(patient, new MedicalRecord());
    }

    public static void addPatient(Patient patient){
        patients.add(patient);
    }
    public static void putPatientInDepartment(Patient patient){
        Objects.requireNonNull(getDepartmentByID(patient.getDepartmentID())).addPatient(patient);
        Objects.requireNonNull(getDepartmentByID(patient.getDepartmentID())).getRoomByID(patient.getRoomID()).addPatient(patient);
    }
    public static void registerNewPatient(Patient patient){
        addPatient(patient);
        addMedicalRecord(patient);
        putPatientInDepartment(patient);
    }


    public static Department getDepartmentByID(int id){
        for (Department department: departments)
            if(department.getId()==id)
                return department;
        return null;
    }
    public static Department getDepartmentByName(String name){
        for (Department department: departments)
            if(department.getName().equals(name))
                return department;
        return null;
    }
    public static int getDepartmentsCount(){
        return departments.size();
    }
    public static void addDepartment(Department department){
        departments.add(department);
    }

    public static void editPatientsMedicalRecord(){
        Doctor doctor = new Doctor("Jan", "Kowalski");
        doctor.editPatientsMedicalRecord();
    }

    public static boolean departmentExists(Department department){
        for(Department dep: departments){
            if (dep.equals(department))
                return true;
        }
        return false;
    }
    public static Department getFirstFreeDepartment(){
        for (Department department: departments){
            if (department.checkBedAvailability())
                return department;
        }
        return null;
    }

    public static ArrayList<Patient> getPatients() {
        return patients;
    }
}