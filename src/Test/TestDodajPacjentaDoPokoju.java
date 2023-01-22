package Test;

import Hospital.Room;
import Patients.Patient;

public class TestDodajPacjentaDoPokoju {
    int iluDodac;
    int wielkoscPokoju;


    public int dodajPacjentaDoPokoju(){
        Room room = new Room(wielkoscPokoju);
        for(int i=0;i<iluDodac;i++){
            room.addPatient(new Patient("test2","test2",1,"testpesel","Wroclaw ul.test 1/2","AB",50,true));
        }
        return room.CountFreeBeds();
    }

    public void setIluDodac(int iluDodac) {
        this.iluDodac = iluDodac;
    }
    public void setWielkoscPokoju(int wielkoscPokoju) {
        this.wielkoscPokoju = wielkoscPokoju;
    }
}
