package Users;

import Patients.MedicalRecord;

public class Nurse extends User{

    public Nurse (String firstname, String lastname){
        super(firstname,lastname);
    }
    public void displayPatientsMedicalRecord(){
        MedicalRecord medicalRecord = searchMedicalRecord();
        medicalRecord.print();
    }

}
