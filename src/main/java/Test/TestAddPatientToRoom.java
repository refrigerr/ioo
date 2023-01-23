package Test;

import Hospital.Bed;
import Hospital.Department;
import Hospital.Room;
import Patients.Patient;

import static org.junit.Assert.*;

public class TestAddPatientToRoom {



    @org.junit.Test
    public void testAddPatientToBed(){
        Bed bed = new Bed();
        bed.assignPatient(new Patient("test","test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true));
        assertNotNull("Pacjent lezy na lozku", bed.getPatient());
    }
    @org.junit.Test
    public void testAddPatientToRoom(){
        Room room = new Room(6);
        int count1 = room.CountFreeBeds();
        room.addPatient(new Patient("test","test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true));
        int count2 = room.CountFreeBeds();
        assertEquals("Pacent zostal dodany do pokoju", count1-1, count2);

    }
    @org.junit.Test
    public void testNoBedsAvailableInRoom(){
        Room room = new Room(6);
        //wypelnienie pokoju pacjentami
        for (int i=0;i<room.getBeds().size();i++){
            room.addPatient(new Patient("test","test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true));
        }
        int count1 = room.CountFreeBeds();
        //dodanie pacjenta ponad wielkosc pokoju
        room.addPatient(new Patient("test","test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true));
        int count2 = room.CountFreeBeds();
        assertEquals("Nie dodano pacjenta do pokoju", count1, count2);
    }


    @org.junit.Test
    public void testAddPatientToDepartment(){
        Department department = new Department(1,"test");
        int count1 = department.getPatients().size();
        department.addPatient(new Patient("test","test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true));
        int count2 = department.getPatients().size();
        assertEquals("Pacjent istnieje w departamencie", count1+1,count2);
    }

}
