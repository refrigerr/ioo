package Interface;

import Hospital.Bed;
import Hospital.Department;
import Hospital.Room;
import Main.ApplicationInstance;
import Patients.Patient;
import Users.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

import static Main.ApplicationInstance.departments;
import static Main.ApplicationInstance.patients;

public class UI {

    public static String GetUserResponse(String command){
        Scanner scanner = new Scanner(System.in);
        System.out.println(command);
        return scanner.nextLine();
    }

    public static boolean ChechInput(String input, int format){
        boolean is_ok = false;
        if(input == null){
            return false;
        }
        switch(format){
            case 1: // imie lub nazwisko
                try {
                    double d = Double.parseDouble(input);
                } catch (NumberFormatException nfe) {
                    is_ok = true;
                }
                break;

            case 2: // id czegos, numer opcji
                is_ok = true;
                try {
                    int d = Integer.parseInt(input);
                } catch (NumberFormatException nfe) {
                    is_ok = false;
                }
                break;

            case 3: // pesel
                is_ok = true;
                for(int i=0; i<input.length(); i++){
                    try {
                        int d = Integer.parseInt(String.valueOf(input.charAt(i)));
                    } catch (NumberFormatException nfe) {
                        is_ok = false;
                    }
                    if(!is_ok){
                        return false;
                    }
                }
                break;
        }
        return is_ok;
    }

    public static void GetErroInputMessage(boolean is_ok){
        if(!is_ok){
            System.out.println("Wpisano bledne dane");
        }
    }
    public static void StartMenu(){
        String response;
        int num_response;
        final String start = "============== SYSTEM ZARZADZANIA SZPITALEM ============== \n === STRONA GLOWNA ===";
        System.out.println(start);

        final String role_choice = " 1. Wybor uprawnien \n 2. Wyjdz";
        response = GetUserResponse(role_choice);
        if(Integer.parseInt(response)!= 1)
            return;
        int choice = RoleChoice();
        switch(choice){
            case 1: // lekarz
                DoctorsMenu();
                break;

            case 2: // pielegniarka
                NurseMenu();
                break;

            case 3: // Pracownik izby przyjec
                ReceptionistMenu();
                break;
        }

    }

    public static int RoleChoice(){
        String roles = "== WYBOR UPRAWNIEN == \n 1. Lekarz \n 2. Pielegniarka \n 3. Pracownik izby przyjec";
        return Integer.parseInt(GetUserResponse(roles));
    }

    public static void DoctorsMenu(){
        final String choice = "== MENU LEKARZA== \n 1. Wypisz pacjenta \n 2. Wypisz recepte \n 3. Wypisz skierowanie \n 4. Edytuj dokumentacje medyczna pacjenta";
        int response = Integer.parseInt(GetUserResponse(choice));
        switch(response){
            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                ApplicationInstance.editPatientsMedicalRecord();
                break;
        }

    }

    public static void showDepartmentInfo(){
        int departmentID = Integer.parseInt(GetUserResponse("Wpisz numer oddzialu: \n"));
        Department department = ApplicationInstance.getDepartmentByID(departmentID);
        if (department!= null)
            department.showDepartmentInfo();
    }


    public static void NurseMenu(){
        final String choice = "== MENU PIELEGNIARKI== \n 1. Wyszukaj informacje o oddziale \n 2. Dodaj pacjenta";
        int response = 0;
        do{
            response = Integer.parseInt(GetUserResponse(choice));
            switch(response){
                case 1:
                    showDepartmentInfo();
                    break;

                case 2:

                    break;
            }
        }while(response!=0);


    }

    public static void ReceptionistMenu(){
        final String choice = "== MENU PRACOWNIKA IZBY PRZYJEC  == \n 1. Wyszukaj informacje o oddziale \n 2. Pokaz pokoje ";
        int response = Integer.parseInt(GetUserResponse(choice));
        switch(response){
            case 1:
                showDepartmentInfo();
                break;

            case 2:

                break;
        }
    }
}
