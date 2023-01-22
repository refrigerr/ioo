package Test;

import Hospital.Department;
import Main.ApplicationInstance;
import Patients.Patient;
import Users.Doctor;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class TestEditPatientsMedicalRecord {

    Doctor doctor;

    @org.junit.Before
    public void initializeTest() {
        this.doctor = new Doctor("doktor", "nr1");
        ApplicationInstance.departments.add(new Department(5,"test"));
        for (int i = 0; i < 5; i++) {
            Patient patient = new Patient("Patient",String.valueOf(i+1),1,String.valueOf(i+1),"Wroclaw ul.test 1/2","AB",50,true);

            ApplicationInstance.registerNewPatient(patient);

        }
    }

    @org.junit.Test
    public void testEditPatientsMedicalRecord() {


        assertEquals("Dodano poczatkowy wpis", 1, ApplicationInstance.getPatientsMedicalRecord(ApplicationInstance.patients.get(1)).getRecords().size());


        String data = "2\n" +
                "1\n" +
                "y\n" +
                "title\n" +
                "description\n" +
                "n\n";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        ApplicationInstance.editPatientsMedicalRecord();

        assertEquals("dodano 2 wpis", 2, ApplicationInstance.getPatientsMedicalRecord(ApplicationInstance.patients.get(1)).getRecords().size());
    }

    @org.junit.Test
    public void testSearchPatientPatientEqual() {

        String data = "2\n" +
                "2\n";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Patient patient = this.doctor.searchPatient();

        assertEquals(patient, ApplicationInstance.getPatientByPesel("2"));
    }

    @org.junit.Test
    public void testSearchPatientUnEqual() {

        String data = "2\n" +
                "1\n";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Patient patient = this.doctor.searchPatient();

        assertNotEquals(patient, ApplicationInstance.getPatientByPesel("2"));
    }

    @org.junit.Test
    public void testGetPatientById() {
        Patient patient = ApplicationInstance.getPatientById(1);
        assertEquals(ApplicationInstance.patients.get(0).getId(), patient.getId());

        // wrong patient - id should be wrong
        patient = ApplicationInstance.getPatientById(2);
        assertNotEquals(patient.getId(), ApplicationInstance.patients.get(0).getId());

        // patient doesnt exist - should return null
        patient = ApplicationInstance.getPatientById(20);
        assertNull("searching patient that doesnt exist", patient);
    }

    @org.junit.Test
    public void testGetPatientByPesel() {

        Patient patient = ApplicationInstance.getPatientByPesel("1");

        assertEquals(ApplicationInstance.patients.get(0).getId(), patient.getId());

        // wrong patient - id should be wrong
        patient = ApplicationInstance.getPatientByPesel("2");
        assertNotEquals(patient.getId(), ApplicationInstance.patients.get(0).getId());

        // patient doesnt exist - should return null
        patient = ApplicationInstance.getPatientByPesel("10");
        assertNull("searching patient that doesnt exist", patient);
    }

    @org.junit.Test
    public void testGetPatientByFullName() {

        // correct patient - id's should match
        Patient patient = ApplicationInstance.getPatientByFullname("Patient", "1");

        assertEquals(ApplicationInstance.patients.get(0).getId(), patient.getId());

        // wrong patient - id should be wrong
        patient = ApplicationInstance.getPatientByFullname("Patient", "2");
        assertNotEquals(patient.getId(), ApplicationInstance.patients.get(0).getId());

        // patient doesnt exist - should return null
        patient = ApplicationInstance.getPatientByFullname("NoName", "1");
        assertNull("searching patient that doesnt exist", patient);
    }

    @org.junit.Test
    public void getPatientsMedicalRecordTest() {

    }
}
