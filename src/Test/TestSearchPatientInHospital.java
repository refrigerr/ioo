package Test;

import Patients.Patient;
import org.junit.Test;

import static Main.ApplicationInstance.*;
import static org.junit.Assert.assertTrue;
public class TestSearchPatientInHospital {

    @Test
    public void testAddPatientToHospital(){
        Patient test_patient = new Patient("test","test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true);
        patients.add(test_patient);
        assertTrue("Pacjent znaleziony w szpitalu", patientExists(test_patient));
    }

    @Test
    public void testSearchPatientByPesel(){
        Patient test_patient = new Patient("test","test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true);
        patients.add(test_patient);
        Patient patient = getPatientByPesel("12345678900");
        assertTrue("Pacjent znaleziony w szpitalu", patientExists(patient));
    }

    @Test
    public void testSearchPatientById(){
        Patient test_patient = new Patient("test","test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true);
        patients.add(test_patient);
        Patient patient = getPatientById(1);
        assertTrue("Pacjent znaleziony w szpitalu", patientExists(patient));
    }

    @Test
    public void testSearchPatientByFullName(){
        Patient test_patient = new Patient("test","test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true);
        patients.add(test_patient);
        Patient patient = getPatientByFullname("Imie", "Nazwisko");
        assertTrue("Pacjent znaleziony w szpitalu", patientExists(patient));
    }




}
