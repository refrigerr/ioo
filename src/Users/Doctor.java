package Users;

import Patients.MedicalRecord;
import Patients.Record;

import java.util.Scanner;

public class Doctor extends Nurse{

    public Doctor (String name, String lastName){
        super(name,lastName);
    }

    public void editPatientsMedicalRecord(){
        MedicalRecord medicalRecord = searchMedicalRecord();
        if(medicalRecord==null)
            return;
        medicalRecord.print();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Czy chcesz dodac wpis? [Y/N]");
        String choice = scanner.nextLine();
        while (choice.equals("y")||choice.equals("Y")){
            Record record = createRecord();
            medicalRecord.addRecord(record);
            System.out.println("Czy chcesz dodac kolejny wpis? [Y/N]");
            choice = scanner.nextLine();
        }
        medicalRecord.print();
    }
    public Record createRecord(){
        Scanner scanner = new Scanner(System.in);
        String title, description;
        System.out.print("Podaj tytul: ");
        title = scanner.nextLine();
        System.out.print("Podaj Wpis: ");
        description = scanner.nextLine();
        return new Record(title,name + " " + lastName, description);
    }
}
