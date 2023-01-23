package Testfit;

import Hospital.Bed;
import Hospital.Department;
import Hospital.Room;
import Main.ApplicationInstance;
import Patients.Patient;
import Users.Doctor;

public class TestAddPatientToRoom {

    int bedsInRoom;
    int patientsInRoom;
    int patientsToAdd;
    String imie;
    Department department = new Department(10,"cos");

    public String testAddPatientToBed(){
        Bed bed = new Bed();
        bed.assignPatient(new Patient(imie,"test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true));
        return bed.getPatient().getName();
    }

    public int testCountFreeBedsInRoom(){
        Room room = new Room(bedsInRoom);
        for (int i =0;i<patientsInRoom;i++){
            room.addPatient(new Patient("test","test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true));
        }
        return room.CountFreeBeds();
    }

    public Bed testAddPatientToFullRoom(){
        Room room = new Room(1);
        room.addPatient(new Patient("test2","test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true));
        Patient patient = new Patient(imie,"test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true);
        room.addPatient(patient);
        return room.getBedByPatient(patient);
    }

    public String testAddPatientToRoom(){
        Room room = new Room(1);
        Patient patient = new Patient(imie,"test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true);
        room.addPatient(patient);
        return room.getBedByPatient(patient).getPatient().getName();
    }

    public int testAddPatientToDepartment(){
        for(int i=0;i<patientsToAdd;i++)
            department.addPatient( new Patient(imie,"test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true));
        return department.getPatients().size();

    }

    public void setPatientsToAdd(int patientsToAdd) {
        this.patientsToAdd = patientsToAdd;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setBedsInRoom(int bedsInRoom) {
        this.bedsInRoom = bedsInRoom;
    }

    public void setPatientsInRoom(int patientsInRoom) {
        this.patientsInRoom = patientsInRoom;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }
}
