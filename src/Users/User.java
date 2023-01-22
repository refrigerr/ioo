package Users;

import Hospital.Department;
import Interface.UI;
import Main.ApplicationInstance;
import Patients.MedicalRecord;
import Patients.Patient;
import Patients.Record;
//import jdk.jfr.StackTrace;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class User {

    String name, lastName;
    int id, privilage;
    char[] password;

    public User (String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }


    public void dischargePatient(){
        Patient patient = searchPatient();
        Objects.requireNonNull(ApplicationInstance.getDepartmentByID(patient.getDepartmentID())).getRoomByID(patient.getRoomID()).getBedByPatient(patient).freeBed();
        MedicalRecord medicalRecord = ApplicationInstance.getPatientsMedicalRecord(patient);
        medicalRecord.addRecord(new Record("Wypis","System","Pacjent zostal wypisany ze szpitala"));
    }
    public Patient searchPatient(){
        Scanner scanner = new Scanner(System.in);
        Patient patient = null;
        int id;
        String pesel, imie, nazwisko;
        int choice2;
        boolean search = true;
        while (search){
            printMenu();
            System.out.println("Wybierz opcję");
            choice2 = Integer.parseInt(scanner.nextLine());
            switch(choice2){

                case 1: // by id
                    System.out.print("Podaj id: ");
                    id = Integer.parseInt(scanner.nextLine());
                    patient = ApplicationInstance.getPatientById(id);
                    break;

                case 2: // by pesel
                    System.out.print("Podaj pesel delikwenta:  ");
                    pesel = scanner.nextLine();
                    patient = ApplicationInstance.getPatientByPesel(pesel);
                    break;

                case 3: // by full name
                    System.out.print("Podaj imie delikwenta:  ");
                    imie = scanner.nextLine();
                    System.out.print("Podaj nazwisko delikwenta:  ");
                    nazwisko = scanner.nextLine();
                    patient = ApplicationInstance.getPatientByFullname(imie, nazwisko);
                    break;

                default:
                    System.out.println("Wybierz opcje ponownie");

            }

            if(patient!=null)
                return patient;
            String choice;
            System.out.println("Nie znaleziono pacjenta");
            System.out.println("Czy jeszcze raz szukac? [Y/N]");
            choice = scanner.nextLine();
            search = choice.equalsIgnoreCase("y");

        }
        return null;
    }
    public MedicalRecord searchMedicalRecord(){
        Patient patient = searchPatient();
        if(patient==null)
            return null;
        return ApplicationInstance.getPatientsMedicalRecord(patient);
    }

    public void printMenu(){
        System.out.println("=== MENU ===");
        System.out.println("= Wybierz opcje wyszukiwania pacjenta =");
        System.out.println("1. Podanie Id");
        System.out.println("2. Podanie numeru PESEL");
        System.out.println("3. Podanie imienia i nazwiska");
    }
    public void assignPatientToDepartment(){

    }
    public void registerPatient(){
        String firstname,lastname,pesel, address, bloodType;
        int age, departmentID;
        boolean sex;
        firstname = UI.GetUserResponse("Imie: ");
        lastname = UI.GetUserResponse("Nazwisko: ");
        age = Integer.parseInt(UI.GetUserResponse("Wiek: "));
        String tempSex = UI.GetUserResponse("Plec [M/K]: ").toLowerCase();
        sex = !tempSex.equals("m");
        pesel = UI.GetUserResponse("Pesel: ");
        address = UI.GetUserResponse("Adres zamieszkania: ");
        bloodType = UI.GetUserResponse("Grupa krwi: ");
        departmentID = Integer.parseInt(UI.GetUserResponse("ID departamentu: "));
        ApplicationInstance.registerNewPatient(new Patient(firstname,lastname,departmentID,pesel,address,bloodType,age,sex));
    }
    public Department searchDepartment(){
        Department department = null;
        do {
            String choice = UI.GetUserResponse("Szukaj oddzial po [id/nazwa]: ");
            switch (choice.toLowerCase()){
                case "id":
                    int id = Integer.parseInt(UI.GetUserResponse("Podaj id: "));
                    department = ApplicationInstance.getDepartmentByID(id);
                    break;
                case "nazwa":
                    String name = UI.GetUserResponse("Podaj nazwe: ");
                    department = ApplicationInstance.getDepartmentByName(name);
                    break;
                default:
                    System.out.println("Wybrano nieprawidlowa opcje");
                    break;
            }
            if(department==null){
                String choice2 = UI.GetUserResponse("Czy chcesz szukac jeszcze raz [Y/N]: ").toLowerCase();
                if(!choice2.equals("y"))
                    return null;
            }
        }while (true);
    }
    public String getName(){
        return name;
    }
    public int cos(int a, int b){
        return a+b;
    }


}