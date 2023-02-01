package Testfit;

import Hospital.Bed;
import Hospital.Department;
import Hospital.Room;
import Patients.Patient;

import static Main.ApplicationInstance.departments;
import static Main.ApplicationInstance.getFirstFreeDepartment;
import static org.junit.Assert.assertTrue;

public class TestGetBeds {
    int department;
    int rooms_inDepartment;
    //int beds_inRoom;
    // po 6 lozek na pokoj

    String departmentName;
    String departmentName1;

    String name;



    public boolean testCheckBedAvability(){
        Department department = new Department(rooms_inDepartment,departmentName);
        return department.checkBedAvailability();
    }

/*    public int testCountBeds(){
        //Department department = new Department(rooms_inDepartment,departmentName);
        Room room = new Room(beds_inRoom);
        return room.CountFreeBeds();
    }*/

    public String findBedInHospital(){
        Department department = new Department(rooms_inDepartment, departmentName);
        Department department1 = new Department(rooms_inDepartment, departmentName1);
        departments.add(department);
        departments.add(department1);
        return getFirstFreeDepartment().getName();
    }

    public Bed testGetBedByPatient(){
        Patient patient = new Patient("Michal", "Michalski", 2, "012345678", "Krotka 4, Lututow", "AB rh+", 34, true);
        Room room = new Room(rooms_inDepartment);
        for(Bed bed: room.getBeds()){
            if(bed.getPatient()==null){
                bed.assignPatient(patient);
                break;
            }
        }
        Bed bed = room.getBedByPatient(patient);
        return bed;
    }

/*    public int assignDepartmentId(){
        Patient patient = new Patient("Michal", "Michalski", 2, "012345678", "Krotka 4, Lututow", "AB rh+", 34, true);
        patient.assignDepartmentId(department);
    }*/

    public boolean patientExists(){
        Department department = new Department(rooms_inDepartment, departmentName);
        Patient patient = new Patient(name, "Michalski", 2, "012345678", "Krotka 4, Lututow", "AB rh+", 34, true);
        department.addPatient(patient);
        return department.patientExists(patient);
    }

    public boolean patientNotExists(){
        Department department = new Department(rooms_inDepartment, departmentName);
        Patient patient = new Patient(name, "Michalski", 2, "012345678", "Krotka 4, Lututow", "AB rh+", 34, true);
        return department.patientExists(patient);
    }

    public int removeExistingPatient(){
        Patient patient = new Patient(name, "Michalski", 2, "012345678", "Krotka 4, Lututow", "AB rh+", 34, true);
        Room room = new Room(1);
        room.addPatient(patient);
        room.removePatient(patient);
        return room.CountFreeBeds();
    }

    public void setDepartment(int department){this.department = department;}
    public void setRooms_inDepartment(int rooms_inDepartment){this.rooms_inDepartment = rooms_inDepartment;}

    public void setDepartmentName(String departmentName){this.departmentName = departmentName;}

    public void setName(String name){this.name = name;}
}
