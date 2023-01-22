package Hospital;

import Patients.Patient;

public class Bed {

    private Patient patient = null;


    public Bed(){

    }

    public Patient getPatient(){
        return patient;
    }

    public void freeBed(){
        this.patient = null;
    }
    public void assignPatient(Patient patient){
        this.patient = patient;
    }

    public void showPatientInfo(){
        if(patient!=null){
            System.out.println("Pacjent: "+patient.getName()+" "+patient.getSurname()+" "+patient.getPesel());
        }
    }

}
