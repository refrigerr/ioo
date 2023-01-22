package Users;

import Interface.UI;
import Patients.Patient;

public class Receptionist extends User{

    public Receptionist(String firstname, String lastname){
        super(firstname,lastname);
    }
    public void checkBedAvailability(){

    }
    public void editPatientsInfo(){
        Patient patient = searchPatient();
        if (patient==null)
            return;
        patient.showInfo();
        System.out.println("Jesli nie chcesz edytowac pola, zostaw je puste");
        String firstname,lastname,pesel, address, bloodType, stringAge, stringSex;
        firstname = UI.GetUserResponse("Imie: ");
        if (!firstname.isEmpty())
            patient.setName(firstname);
        lastname = UI.GetUserResponse("Nazwisko: ");
        if (!lastname.isEmpty())
            patient.setSurname(firstname);
        stringAge = UI.GetUserResponse("Wiek: ");
        if (!stringAge.isEmpty())
            patient.setAge(Integer.parseInt(stringAge));
        stringSex = UI.GetUserResponse("Plec [M/K]: ");
        if (!stringSex.isEmpty())
            patient.setSex(!stringSex.equals("M") && !stringSex.equals("m"));
        pesel = UI.GetUserResponse("Pesel: ");
        if (!pesel.isEmpty())
            patient.setPesel(pesel);
        address = UI.GetUserResponse("Adres zamieszkania: ");
        if (!address.isEmpty())
            patient.setAddress(address);
        bloodType = UI.GetUserResponse("Grupa krwi: ");
        if (!bloodType.isEmpty())
            patient.setBloodType(bloodType);
    }
}
